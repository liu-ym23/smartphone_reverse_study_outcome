package com.obric.cae.smartBluetooth.deviceIdentification.bdim;

import android.os.Bundle;
import android.os.SystemProperties;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.e;
import androidx.room.m;
import com.obric.cae.R;
import com.obric.cae.smartBluetooth.deviceIdentification.BluetoothDeviceInfoExt;
import s1.x;

/* JADX INFO: loaded from: classes.dex */
public class BdimPredictionResultActivity extends e {
    private TextView tvBatchTestResult;

    public BdimPredictionResultActivity() {
    }

    public static /* synthetic */ void d(BdimPredictionResultActivity r8, String r10, Button r11) {
        r8.lambda$onCreate$0(r10, r11);
    }

    public static /* synthetic */ void e(BdimPredictionResultActivity r8, Button r10, View r11) {
        r8.lambda$onCreate$2(r10, r11);
    }

    public static /* synthetic */ void f(BdimPredictionResultActivity r8, Button r10) {
        r8.lambda$onCreate$1(r10);
    }

    private /* synthetic */ void lambda$onCreate$0(String r8, Button r10) {
        this.tvBatchTestResult.setText(r8);
        r10.setEnabled(true);
    }

    private /* synthetic */ void lambda$onCreate$1(Button r8) {
        runOnUiThread(new m(this, BdimAutoTestMode.runBatchTest(this, BluetoothDeviceInfoExt.getInstance(this).getBdimModel()), r8, 3));
    }

    private /* synthetic */ void lambda$onCreate$2(Button r8, View r10) {
        this.tvBatchTestResult.setText("Test running, please wait...");
        r8.setEnabled(false);
        new Thread(new x(5, this, r8)).start();
    }

    @Override // androidx.fragment.app.m, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle r25) {
        super.onCreate(r25);
        setContentView(R.layout.activity_bdim_debug);
        setTitle("BDIM Prediction Result");
        LinearLayout r8 = (LinearLayout) findViewById(R.id.ll_batch_test_container);
        ScrollView r10 = (ScrollView) findViewById(R.id.ll_single_result_container);
        Button r11 = (Button) findViewById(R.id.btn_start_batch_test);
        this.tvBatchTestResult = (TextView) findViewById(R.id.tv_batch_test_result);
        if (SystemProperties.getInt(BluetoothDeviceIdentificationModel.BDIM_TEST_MODE, 0) != 2) goto L5;
        r8.setVisibility(0);
        r10.setVisibility(8);
        r11.setOnClickListener(new com.obric.cae.location.zpp.ui.b(this, r11, 1));
        return;
    L5:
        r8.setVisibility(8);
        r10.setVisibility(0);
        String r12 = getIntent().getStringExtra(BdimCategoryConstants.INTENT_KEY_MAC_PREFIX);
        String r13 = getIntent().getStringExtra(BdimCategoryConstants.INTENT_KEY_NAME_KEYWORD);
        String r14 = getIntent().getStringExtra(BdimCategoryConstants.INTENT_KEY_CATEGORY_KEYWORD);
        String r15 = getIntent().getStringExtra(BdimCategoryConstants.INTENT_KEY_SERVICE_INFO);
        String r16 = getIntent().getStringExtra(BdimCategoryConstants.INTENT_KEY_METHOD);
        String r17 = getIntent().getStringExtra(BdimCategoryConstants.INTENT_KEY_IO);
        String r18 = getIntent().getStringExtra(BdimCategoryConstants.INTENT_KEY_COD);
        String r19 = getIntent().getStringExtra(BdimCategoryConstants.INTENT_KEY_MANUF);
        String r110 = getIntent().getStringExtra(BdimCategoryConstants.INTENT_KEY_PREDICTED_CLASS);
        float r111 = getIntent().getFloatExtra("confidence", 0.0f);
        int r20 = getIntent().getIntExtra(BdimCategoryConstants.INTENT_KEY_FINAL_TYPE, 0);
        String r112 = getIntent().getStringExtra(BdimCategoryConstants.INTENT_KEY_ACTUAL_COD_TYPE);
        TextView r113 = (TextView) findViewById(R.id.tv_mac_prefix);
        TextView r114 = (TextView) findViewById(R.id.tv_name_keyword);
        TextView r115 = (TextView) findViewById(R.id.tv_category_keyword);
        TextView r116 = (TextView) findViewById(R.id.tv_service_info);
        TextView r21 = (TextView) findViewById(R.id.tv_method);
        TextView r117 = (TextView) findViewById(R.id.tv_io);
        TextView r118 = (TextView) findViewById(R.id.tv_cod);
        TextView r22 = (TextView) findViewById(R.id.tv_manuf);
        TextView r23 = (TextView) findViewById(R.id.tv_predicted_class);
        TextView r24 = (TextView) findViewById(R.id.tv_confidence);
        TextView r26 = (TextView) findViewById(R.id.tv_final_type);
        TextView r27 = (TextView) findViewById(R.id.tv_actual_cod_type);
        r113.setText("MAC Prefix: " + r12);
        r114.setText("Name Keyword: " + r13);
        r115.setText("Category Keyword: " + r14);
        r116.setText("Service Info: " + r15);
        r21.setText("Method: " + r16);
        r117.setText("IO: " + r17);
        r118.setText("CoD: " + r18);
        r22.setText("Manufacturer: " + r19);
        r23.setText("Predicted Class: " + r110);
        r24.setText("Confidence: " + String.format("%.2f", new Object[]{Float.valueOf(r111)}));
        r26.setText("Final Type: " + r20 + " (" + BluetoothDeviceIdentificationModel.mapIntTypeToString(r20) + ")");
        if (r27 == null) goto L10;
        r27.setText("Actual CoD Type: " + r112);
        return;
    }
}
