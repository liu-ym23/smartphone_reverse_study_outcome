package com.obric.cae.location.zpp.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Process;
import android.os.UserHandle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.android.material.datepicker.q;
import com.obric.cae.R;
import com.obric.cae.cloud.CloudServiceConstants;
import com.obric.cae.location.zpp.StarZppManager;
import com.obric.cae.utils.CaeUtil;

/* JADX INFO: loaded from: classes.dex */
public class StarZppModelActivity extends Activity {
    public StarZppModelActivity() {
    }

    public static /* synthetic */ void a(StarZppModelActivity r8, TextView r10, View r11) {
        r8.lambda$initViews$2(r10, r11);
    }

    public static /* synthetic */ void b(StarZppModelActivity r8, View r10) {
        r8.lambda$initViews$4(r10);
    }

    public static /* synthetic */ void c(StarZppModelActivity r8, TextView r10, View r11) {
        r8.lambda$initViews$3(r10, r11);
    }

    public static /* synthetic */ void d(StarZppModelActivity r8, TextView r10, View r11) {
        r8.lambda$initViews$1(r10, r11);
    }

    public static /* synthetic */ void e(StarZppModelActivity r8, View r10) {
        r8.lambda$initViews$0(r10);
    }

    @SuppressLint({"MissingPermission"})
    private void getLastKnownLocation(String r8, String r10, TextView r11) {
        r11.append(CaeUtil.getCurrentTimeFormatted() + " " + r10 + ": " + ((LocationManager) getSystemService(LocationMonitorConst.LOCATION)).getLastKnownLocation(r8) + "\n");
    }

    @SuppressLint({"SetTextI18n"})
    private void initViews() {
        Button r8 = (Button) findViewById(R.id.load_model_btn);
        Button r10 = (Button) findViewById(R.id.get_location_btn);
        Button r11 = (Button) findViewById(R.id.get_glp_last_location_btn);
        Button r12 = (Button) findViewById(R.id.get_nlp_last_location_btn);
        Button r13 = (Button) findViewById(R.id.go_to_zpp_ui_btn);
        final TextView r14 = (TextView) findViewById(R.id.zpp_location_text);
        int r15 = 0;
        r8.setOnClickListener(new a(this, r15));
        r10.setOnClickListener(new b(this, r14, r15));
        r11.setOnClickListener(new c(this, r14));
        r12.setOnClickListener(new d(this, r14));
        r13.setOnClickListener(new q(this, 3));
    }

    private /* synthetic */ void lambda$initViews$0(View r8) {
        int r10 = UserHandle.getUserId(Process.myUid());
        StarZppManager.getInstance(this, r10).deinitAiKernelZppModel();
        StarZppManager.getInstance(this, r10).initAiKernelZppModel();
        Toast.makeText(this, getString(R.string.user_aware_zpp_model_load), 0).show();
    }

    private /* synthetic */ void lambda$initViews$1(TextView r8, View r10) {
        r8.append(CaeUtil.getCurrentTimeFormatted() + " Zpp " + StarZppManager.getInstance(this, UserHandle.getUserId(Process.myUid())).getZppLocation() + "\n");
    }

    private /* synthetic */ void lambda$initViews$2(TextView r8, View r10) {
        getLastKnownLocation(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS, "GLP Last Location", r8);
    }

    private /* synthetic */ void lambda$initViews$3(TextView r8, View r10) {
        getLastKnownLocation("network", "NLP Last Location", r8);
    }

    private /* synthetic */ void lambda$initViews$4(View r8) {
        startActivity(new Intent(this, StarZppUiActivity.class));
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r8) {
        super.onCreate(r8);
        setContentView(R.layout.activity_star_zpp_model);
        initViews();
    }
}
