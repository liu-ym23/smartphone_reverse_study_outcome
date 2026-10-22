package com.bytedance.bdlocation.permission.request;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(23)
public class PermissionFragment extends Fragment {
    Permissions.Callback mCallback;

    public PermissionFragment() {
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle r8) {
        super.onCreate(r8);
        requestPermissions(getArguments().getStringArray("permissions"), 1);
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int r8, String[] r10, int[] r11) {
        super.onRequestPermissionsResult(r8, r10, r11);
        Permissions.Callback r12 = this.mCallback;
        if (r12 == null) goto L5;
        r12.onRequestPermissionResult(r10, r11);
    L5:
        getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
    }
}
