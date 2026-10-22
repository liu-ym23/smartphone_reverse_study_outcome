package com.ss.android.lark.conditional.access.device.ui;

import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.ss.android.lark.conditional.access.network.model.response.ApplyDeviceData;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.storage.LarkKVStorage;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g<T> implements Observer {
    public final /* synthetic */ UserScopeDeviceDeclareFragment a;

    public g(UserScopeDeviceDeclareFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r13) {
        ApplyDeviceData r14 = (ApplyDeviceData) r13;
        if (r14 == null) goto L16;
        UserScopeDeviceDeclareFragment r0 = this.a;
        int r1 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_UserScopeDeviceDeclareFragment", "applyDeviceOwner onSuccess, applyStatus: " + r14.getApplyStatus() + ", owner: " + r14.getOwnership());
        Ref.BooleanRef r2 = new Ref.BooleanRef();
        Integer r3 = r0.j;
        int r4 = r14.getApplyStatus();
        if (r3 != null) goto L8;
    L9:
        r2.element = true;
        r0.j = Integer.valueOf(r14.getApplyStatus());
        int r5 = r14.getApplyStatus();
        com.ss.android.lark.storage.kv.storage.a r6 = r0.i;
        if (r6 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("kvStorage");
        r6 = null;
    L13:
        com.ss.android.lark.storage.a r7 = com.ss.android.lark.security.compliance.infra.storage.d.a;
        Intrinsics.checkNotNullParameter(r6, "user");
        LarkKVStorage.d(LarkKVStorage.a, r6, com.ss.android.lark.security.compliance.infra.storage.d.a, "common").putInt("scs_sp_conditional_access_apply_status", r5);
    L14:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), null, null, new UserScopeDeviceDeclareFragment$initData$3$1$1(r0, r14, r2, null), 3, null);
        return;
    L8:
        if (r3.intValue() == r4) goto L14;
    }
}
