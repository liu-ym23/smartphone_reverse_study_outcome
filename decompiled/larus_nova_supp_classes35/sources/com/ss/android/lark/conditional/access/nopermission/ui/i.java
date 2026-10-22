package com.ss.android.lark.conditional.access.nopermission.ui;

import androidx.lifecycle.Observer;
import com.ss.android.lark.conditional.access.network.model.response.BindDeviceData;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ DeviceOwnerNoPermissionFragment a;

    public i(DeviceOwnerNoPermissionFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        BindDeviceData r6 = (BindDeviceData) r5;
        if (r6 != null) goto L5;
        DeviceOwnerNoPermissionFragment.Y90(this.a);
        ScsLogger.d("SecurityPolicy_DeviceOwnerNoPermissionFragment", "show error toast by bindDeviceLiveData");
        return;
    L5:
        DeviceOwnerNoPermissionFragment r1 = this.a;
        int r2 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_DeviceOwnerNoPermissionFragment", "success:" + r6.getSuccess());
        if (r6.getSuccess() == false) goto L8;
        r1.W90("bind_device");
        return;
    L8:
        int r7 = DeviceOwnerNoPermissionFragment.k;
        r1.T90().getDeviceApplySwitchData();
    }
}
