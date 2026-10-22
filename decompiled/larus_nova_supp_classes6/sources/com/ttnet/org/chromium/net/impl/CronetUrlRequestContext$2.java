package com.ttnet.org.chromium.net.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class CronetUrlRequestContext$2 implements Runnable {
    final /* synthetic */ CronetUrlRequestContext this$0;
    final /* synthetic */ URLDispatch val$dispatchRef;

    @Override // java.lang.Runnable
    public void run() {
        com_ttnet_org_chromium_net_impl_CronetUrlRequestContext$2_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext$2__run$___twin___() {
        this.val$dispatchRef.done();
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext$2_com_larus_apm_impl_protector_RunnableLancet_run(CronetUrlRequestContext$2 r1) {
        r1.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext$2__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public CronetUrlRequestContext$2(CronetUrlRequestContext r1, URLDispatch r2) {
        this.this$0 = r1;
        this.val$dispatchRef = r2;
    }
}
