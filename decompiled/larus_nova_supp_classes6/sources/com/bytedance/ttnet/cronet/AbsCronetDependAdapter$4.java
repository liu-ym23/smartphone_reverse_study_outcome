package com.bytedance.ttnet.cronet;

import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.ttnet.httpdns.TTDnsOuterService;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class AbsCronetDependAdapter$4 extends ThreadPlus {
    final /* synthetic */ AbsCronetDependAdapter this$0;
    final /* synthetic */ int val$cache_source;
    final /* synthetic */ String val$detailed_info;
    final /* synthetic */ String val$host;
    final /* synthetic */ List val$ips;
    final /* synthetic */ int val$ret;
    final /* synthetic */ int val$source;
    final /* synthetic */ String val$uuid;

    public void run() {
        com_bytedance_ttnet_cronet_AbsCronetDependAdapter$4_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_bytedance_ttnet_cronet_AbsCronetDependAdapter$4__run$___twin___() {
        TTDnsOuterService.getInstance().HandleHttpdnsResult(this.val$uuid, this.val$host, this.val$ret, this.val$source, this.val$cache_source, this.val$ips, this.val$detailed_info);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_ttnet_cronet_AbsCronetDependAdapter$4_com_larus_apm_impl_protector_RunnableLancet_run(AbsCronetDependAdapter$4 r1) {
        r1.com_bytedance_ttnet_cronet_AbsCronetDependAdapter$4__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public AbsCronetDependAdapter$4(AbsCronetDependAdapter r1, String r2, String r3, int r4, int r5, int r6, List r7, String r8) {
        this.this$0 = r1;
        this.val$uuid = r2;
        this.val$host = r3;
        this.val$ret = r4;
        this.val$source = r5;
        this.val$cache_source = r6;
        this.val$ips = r7;
        this.val$detailed_info = r8;
    }
}
