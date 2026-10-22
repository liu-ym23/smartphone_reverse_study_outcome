package com.obric.cae.userAware.ui;

import android.content.ComponentName;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.obric.cae.R;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OCTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public class DataCollectionHomeActivity extends androidx.fragment.app.m implements PermissionsCheckFragment.OnAllReadyListener {
    public DataCollectionHomeActivity() {
    }

    public static /* synthetic */ void d(DataCollectionHomeActivity r8, View r10) {
        r8.lambda$onCreate$0(r10);
    }

    private /* synthetic */ void lambda$onCreate$0(View r8) {
        finish();
    }

    private void replaceFragment(Fragment r8, boolean r10) {
        FragmentManager r11 = getSupportFragmentManager();
        r11.getClass();
        androidx.fragment.app.a r12 = new androidx.fragment.app.a(r11);
        r12.e(R.id.fragment_container, r8, null, 2);
        if (r10 == true) goto L5;
    L9:
        r12.d(true);
        return;
    L5:
        if (r12.f2074h == false) goto L8;
        r12.f2073g = true;
        r12.f2075i = null;
        goto L9
    L8:
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    @Override // com.obric.cae.userAware.ui.PermissionsCheckFragment.OnAllReadyListener
    public void onAllReady() {
        replaceFragment(new DataCollectionEntryFragment(), true);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override // androidx.fragment.app.m, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle r8) {
        super.onCreate(r8);
        setContentView(R.layout.activity_data_collection_home);
        getPackageManager().setComponentEnabledSetting(new ComponentName(this, UserAwareLauncherActivity.class), 1, 1);     // Catch: IllegalArgumentException -> L5
    L6:
        OCTitleBar r10 = (OCTitleBar) findViewById(R.id.debug_home_title);
        if (r10 == null) goto L11;
        OButton r11 = r10.getMLeftActionBack();
        if (r11 == null) goto L11;
        r11.setOnClickListener(new com.google.android.material.search.a(this, 5));
    L11:
        if (r8 != null) goto L16;
        replaceFragment(new PermissionsCheckFragment(), false);
        return;
    L16:
        return;
    L5:
        Log.e("DataCollectionHome", "Enable UserAwareLauncherActivity failed");
        goto L6
    }
}
