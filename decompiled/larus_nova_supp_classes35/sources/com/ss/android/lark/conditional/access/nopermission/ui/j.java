package com.ss.android.lark.conditional.access.nopermission.ui;

import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.ss.android.lark.conditional.access.network.model.response.GetDeviceApplySwitchData;
import com.ss.android.lark.conditional.access.network.model.response.GetDeviceInfoData;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j<T> implements Observer {
    public final /* synthetic */ DeviceOwnerNoPermissionFragment a;

    public j(DeviceOwnerNoPermissionFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r9) {
        GetDeviceApplySwitchData r10 = (GetDeviceApplySwitchData) r9;
        if (r10 != null) goto L5;
        DeviceOwnerNoPermissionFragment.Y90(this.a);
        ScsLogger.d("SecurityPolicy_DeviceOwnerNoPermissionFragment", "show error toast by deviceApplySwitchLiveData");
        return;
    L5:
        int r1 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_DeviceOwnerNoPermissionFragment", "switch : " + r10.getSwitch());
        if (r10.getSwitch() == false) goto L10;
        GetDeviceInfoData r11 = (GetDeviceInfoData) this.a.T90().getDeviceInfoLiveData().getValue();
        if (r11 == null) goto L13;
        DeviceOwnerNoPermissionFragment r2 = this.a;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r2), null, null, new DeviceOwnerNoPermissionFragment$initData$3$1$1(r11, r2, null), 3, null);
        return;
    L13:
        return;
    L10:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new DeviceOwnerNoPermissionFragment$initData$3$2(this.a, null), 3, null);
    }
}
