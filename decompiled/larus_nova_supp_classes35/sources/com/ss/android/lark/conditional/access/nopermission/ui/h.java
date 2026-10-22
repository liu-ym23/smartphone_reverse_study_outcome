package com.ss.android.lark.conditional.access.nopermission.ui;

import androidx.lifecycle.Observer;
import com.ss.android.lark.conditional.access.network.model.response.GetDeviceInfoData;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ DeviceOwnerNoPermissionFragment a;

    public h(DeviceOwnerNoPermissionFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        GetDeviceInfoData r6 = (GetDeviceInfoData) r5;
        if (r6 != null) goto L5;
        DeviceOwnerNoPermissionFragment.Y90(this.a);
        ScsLogger.d("SecurityPolicy_DeviceOwnerNoPermissionFragment", "show error toast by deviceInfoLiveData");
        return;
    L5:
        DeviceOwnerNoPermissionFragment r1 = this.a;
        int r2 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_DeviceOwnerNoPermissionFragment", "exist: " + r6.getExist() + "DeviceApplyStatus: " + r6.getApplyStatus());
        if (r6.getExist() == false) goto L8;
        int r7 = DeviceOwnerNoPermissionFragment.k;
        r1.T90().getDeviceApplySwitchData();
        return;
    L8:
        r1.T90().bindDevice();
    }
}
