package com.zpj.imx6dual_led_sata;

import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
//import com.zpj.hardlibrary.*;
import android.os.ILedzpjService;
import android.os.ServiceManager;

public class LEDSATA_Activity extends AppCompatActivity {

    private ILedzpjService iLedzpjService = null;
    private CheckBox ledsata = null;


    public void onCheckboxClicked(View view){
        boolean checked = ((CheckBox) view).isChecked();
//        iLedzpjService hardControl = new iLedzpjService();

        switch (view.getId()) {
            case R.id.LEDSATA:
                if (checked) {
                    Toast.makeText(getApplicationContext(), "LED-SATA 选中", Toast.LENGTH_SHORT).show();
                    try {
                        iLedzpjService.ledCtrl(0, 1);
//                        HardControl.ledCtrl(0, 1);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "LED-SATA 取消", Toast.LENGTH_SHORT).show();
                    try {
                        iLedzpjService.ledCtrl(0, 0);
//                        HardControl.ledCtrl(0, 0);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ledsata_layout);

        ledsata = (CheckBox) findViewById(R.id.LEDSATA);
        iLedzpjService = ILedzpjService.Stub.asInterface(ServiceManager.getService("ledzpj"));

    }
}
