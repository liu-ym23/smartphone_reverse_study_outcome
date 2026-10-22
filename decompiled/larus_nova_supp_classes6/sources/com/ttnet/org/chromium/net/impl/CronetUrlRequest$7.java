package com.ttnet.org.chromium.net.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class CronetUrlRequest$7 implements Runnable {
    final /* synthetic */ CronetUrlRequest this$0;
    final /* synthetic */ VersionSafeCallbacks$UrlRequestStatusListener val$listener;
    final /* synthetic */ int val$loadState;

    @Override // java.lang.Runnable
    public void run() {
        com_ttnet_org_chromium_net_impl_CronetUrlRequest$7_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_ttnet_org_chromium_net_impl_CronetUrlRequest$7__run$___twin___() {
        this.val$listener.onStatus(UrlRequestBase.convertLoadState(this.val$loadState));
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest$7_com_larus_apm_impl_protector_RunnableLancet_run(CronetUrlRequest$7 r1) {
        r1.com_ttnet_org_chromium_net_impl_CronetUrlRequest$7__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public CronetUrlRequest$7(CronetUrlRequest r1, VersionSafeCallbacks$UrlRequestStatusListener r2, int r3) {
        this.this$0 = r1;
        this.val$listener = r2;
        this.val$loadState = r3;
    }
}
