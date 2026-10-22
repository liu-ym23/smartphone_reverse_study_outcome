package com.bytedance.ttnet.cronet;

import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class AbsCronetDependAdapter$9 extends ThreadPlus {
    final /* synthetic */ AbsCronetDependAdapter this$0;
    final /* synthetic */ double val$downstreamLossRate;
    final /* synthetic */ double val$downstreamLossRateVariance;
    final /* synthetic */ int val$protocol;
    final /* synthetic */ double val$upstreamLossRate;
    final /* synthetic */ double val$upstreamLossRateVariance;

    public void run() {
        com_bytedance_ttnet_cronet_AbsCronetDependAdapter$9_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_bytedance_ttnet_cronet_AbsCronetDependAdapter$9__run$___twin___() {
        this.this$0.onPacketLossComputed(this.val$protocol, this.val$upstreamLossRate, this.val$upstreamLossRateVariance, this.val$downstreamLossRate, this.val$downstreamLossRateVariance);
        this.this$0.onNQEPacketLossComputed(this.val$protocol, this.val$upstreamLossRate, this.val$upstreamLossRateVariance, this.val$downstreamLossRate, this.val$downstreamLossRateVariance);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_ttnet_cronet_AbsCronetDependAdapter$9_com_larus_apm_impl_protector_RunnableLancet_run(AbsCronetDependAdapter$9 r1) {
        r1.com_bytedance_ttnet_cronet_AbsCronetDependAdapter$9__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public AbsCronetDependAdapter$9(AbsCronetDependAdapter r1, int r2, double r3, double r5, double r7, double r9) {
        this.this$0 = r1;
        this.val$protocol = r2;
        this.val$upstreamLossRate = r3;
        this.val$upstreamLossRateVariance = r5;
        this.val$downstreamLossRate = r7;
        this.val$downstreamLossRateVariance = r9;
    }
}
