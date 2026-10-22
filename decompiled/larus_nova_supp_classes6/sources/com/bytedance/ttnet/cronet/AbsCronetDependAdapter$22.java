package com.bytedance.ttnet.cronet;

import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.config.MultiProcStackOptConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class AbsCronetDependAdapter$22 extends ThreadPlus {
    final /* synthetic */ AbsCronetDependAdapter this$0;
    final /* synthetic */ boolean val$fallbackFixEnabled;
    final /* synthetic */ int val$fallbackFixIntervalSeconds;
    final /* synthetic */ boolean val$stackOptEnabled;

    public void run() {
        com_bytedance_ttnet_cronet_AbsCronetDependAdapter$22_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_bytedance_ttnet_cronet_AbsCronetDependAdapter$22__run$___twin___() {
        MultiProcStackOptConfig.inst(TTNetInit.getTTNetDepend().getContext()).onTncRequestSucceeded(this.val$stackOptEnabled, this.val$fallbackFixEnabled, this.val$fallbackFixIntervalSeconds);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_ttnet_cronet_AbsCronetDependAdapter$22_com_larus_apm_impl_protector_RunnableLancet_run(AbsCronetDependAdapter$22 r1) {
        r1.com_bytedance_ttnet_cronet_AbsCronetDependAdapter$22__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public AbsCronetDependAdapter$22(AbsCronetDependAdapter r1, boolean r2, boolean r3, int r4) {
        this.this$0 = r1;
        this.val$stackOptEnabled = r2;
        this.val$fallbackFixEnabled = r3;
        this.val$fallbackFixIntervalSeconds = r4;
    }
}
