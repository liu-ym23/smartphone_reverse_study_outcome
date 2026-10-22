package com.bytedance.bdlocation.permission.request;

import android.app.Fragment;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class PermissionFragment extends Fragment {
    Permissions.Callback mCallback;

    public PermissionFragment() {
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        ZeusTransformUtils.requestPermissions(this, getArguments().getStringArray("permissions"), 1, "com.obric.memorydata.plugin");
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int r1, String[] r2, int[] r3) {
        super.onRequestPermissionsResult(r1, r2, r3);
        Permissions.Callback r4 = this.mCallback;
        if (r4 == null) goto L5;
        r4.onRequestPermissionResult(r2, r3);
    L5:
        getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
    }
}
