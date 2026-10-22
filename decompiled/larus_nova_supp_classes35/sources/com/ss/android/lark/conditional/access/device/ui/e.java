package com.ss.android.lark.conditional.access.device.ui;

import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.ss.android.lark.conditional.access.network.model.response.GetDeviceInfoData;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ UserScopeDeviceDeclareFragment a;

    public e(UserScopeDeviceDeclareFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r8) {
        GetDeviceInfoData r9 = (GetDeviceInfoData) r8;
        if (r9 == null) goto L6;
        UserScopeDeviceDeclareFragment r0 = this.a;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), null, null, new UserScopeDeviceDeclareFragment$initData$1$1$1(r9, r0, null), 3, null);
        return;
    }
}
