package com.bytedance.ttnet.cronet;

import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class AbsCronetDependAdapter$14 extends ThreadPlus {
    final /* synthetic */ AbsCronetDependAdapter this$0;
    final /* synthetic */ int val$effectiveHrttMs;
    final /* synthetic */ int val$effectiveRxThroughputKbps;
    final /* synthetic */ int val$effectiveTrttMs;

    public void run() {
        com_bytedance_ttnet_cronet_AbsCronetDependAdapter$14_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_bytedance_ttnet_cronet_AbsCronetDependAdapter$14__run$___twin___() {
        this.this$0.onNetworkQualityRttAndThroughputNotified(this.val$effectiveHrttMs, this.val$effectiveTrttMs, this.val$effectiveRxThroughputKbps);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_ttnet_cronet_AbsCronetDependAdapter$14_com_larus_apm_impl_protector_RunnableLancet_run(AbsCronetDependAdapter$14 r1) {
        r1.com_bytedance_ttnet_cronet_AbsCronetDependAdapter$14__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public AbsCronetDependAdapter$14(AbsCronetDependAdapter r1, int r2, int r3, int r4) {
        this.this$0 = r1;
        this.val$effectiveHrttMs = r2;
        this.val$effectiveTrttMs = r3;
        this.val$effectiveRxThroughputKbps = r4;
    }
}
