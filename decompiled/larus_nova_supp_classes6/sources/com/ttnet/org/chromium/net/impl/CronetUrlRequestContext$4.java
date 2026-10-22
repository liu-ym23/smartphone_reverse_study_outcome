package com.ttnet.org.chromium.net.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class CronetUrlRequestContext$4 implements Runnable {
    final /* synthetic */ CronetUrlRequestContext this$0;
    final /* synthetic */ VersionSafeCallbacks$NetworkQualityThroughputListenerWrapper val$listener;
    final /* synthetic */ int val$source;
    final /* synthetic */ int val$throughputKbps;
    final /* synthetic */ long val$whenMs;

    @Override // java.lang.Runnable
    public void run() {
        com_ttnet_org_chromium_net_impl_CronetUrlRequestContext$4_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext$4__run$___twin___() {
        this.val$listener.onThroughputObservation(this.val$throughputKbps, this.val$whenMs, this.val$source);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext$4_com_larus_apm_impl_protector_RunnableLancet_run(CronetUrlRequestContext$4 r1) {
        r1.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext$4__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public CronetUrlRequestContext$4(CronetUrlRequestContext r1, VersionSafeCallbacks$NetworkQualityThroughputListenerWrapper r2, int r3, long r4, int r6) {
        this.this$0 = r1;
        this.val$listener = r2;
        this.val$throughputKbps = r3;
        this.val$whenMs = r4;
        this.val$source = r6;
    }
}
