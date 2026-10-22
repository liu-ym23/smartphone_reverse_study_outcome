package com.bytedance.ttnet.cronet;

import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class AbsCronetDependAdapter$19 extends ThreadPlus {
    final /* synthetic */ AbsCronetDependAdapter this$0;
    final /* synthetic */ List val$dropReasons;
    final /* synthetic */ boolean val$isBlocked;

    public void run() {
        com_bytedance_ttnet_cronet_AbsCronetDependAdapter$19_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_bytedance_ttnet_cronet_AbsCronetDependAdapter$19__run$___twin___() {
        CronetDropReasonAccess.inst().onDropReasonChanged(this.val$isBlocked, this.val$dropReasons);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_ttnet_cronet_AbsCronetDependAdapter$19_com_larus_apm_impl_protector_RunnableLancet_run(AbsCronetDependAdapter$19 r1) {
        r1.com_bytedance_ttnet_cronet_AbsCronetDependAdapter$19__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public AbsCronetDependAdapter$19(AbsCronetDependAdapter r1, boolean r2, List r3) {
        this.this$0 = r1;
        this.val$isBlocked = r2;
        this.val$dropReasons = r3;
    }
}
