package com.bytedance.ttnet.cronet;

import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class AbsCronetDependAdapter$6 extends ThreadPlus {
    final /* synthetic */ AbsCronetDependAdapter this$0;
    final /* synthetic */ String val$key;
    final /* synthetic */ int val$status;

    public void run() {
        com_bytedance_ttnet_cronet_AbsCronetDependAdapter$6_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_bytedance_ttnet_cronet_AbsCronetDependAdapter$6__run$___twin___() {
        this.this$0.onCronetMappingRequestStatus(this.val$key, this.val$status);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_ttnet_cronet_AbsCronetDependAdapter$6_com_larus_apm_impl_protector_RunnableLancet_run(AbsCronetDependAdapter$6 r1) {
        r1.com_bytedance_ttnet_cronet_AbsCronetDependAdapter$6__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public AbsCronetDependAdapter$6(AbsCronetDependAdapter r1, String r2, int r3) {
        this.this$0 = r1;
        this.val$key = r2;
        this.val$status = r3;
    }
}
