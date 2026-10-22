package com.ttnet.org.chromium.net.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class CronetUrlRequest$2 implements Runnable {
    final /* synthetic */ CronetUrlRequest this$0;
    final /* synthetic */ VersionSafeCallbacks$UrlRequestStatusListener val$listener;

    @Override // java.lang.Runnable
    public void run() {
        com_ttnet_org_chromium_net_impl_CronetUrlRequest$2_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_ttnet_org_chromium_net_impl_CronetUrlRequest$2__run$___twin___() {
        this.val$listener.onStatus(-1);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest$2_com_larus_apm_impl_protector_RunnableLancet_run(CronetUrlRequest$2 r1) {
        r1.com_ttnet_org_chromium_net_impl_CronetUrlRequest$2__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public CronetUrlRequest$2(CronetUrlRequest r1, VersionSafeCallbacks$UrlRequestStatusListener r2) {
        this.this$0 = r1;
        this.val$listener = r2;
    }
}
