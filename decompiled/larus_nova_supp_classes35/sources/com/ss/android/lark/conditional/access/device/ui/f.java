package com.ss.android.lark.conditional.access.device.ui;

import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.ss.android.lark.conditional.access.network.model.response.GetDeviceApplySwitchData;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ UserScopeDeviceDeclareFragment a;

    public f(UserScopeDeviceDeclareFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        GetDeviceApplySwitchData r11 = (GetDeviceApplySwitchData) r10;
        if (r11 == null) goto L6;
        UserScopeDeviceDeclareFragment r0 = this.a;
        int r1 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_UserScopeDeviceDeclareFragment", "getDeviceApplySwitchData onSuccess, switch : " + r11.getSwitch());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), null, null, new UserScopeDeviceDeclareFragment$initData$2$1$1(r11, r0, null), 3, null);
        return;
    }
}
