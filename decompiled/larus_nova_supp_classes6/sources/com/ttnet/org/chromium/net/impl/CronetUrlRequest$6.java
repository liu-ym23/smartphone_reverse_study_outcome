package com.ttnet.org.chromium.net.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ttnet.org.chromium.base.Log;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class CronetUrlRequest$6 implements Runnable {
    final /* synthetic */ CronetUrlRequest this$0;

    @Override // java.lang.Runnable
    public void run() {
        com_ttnet_org_chromium_net_impl_CronetUrlRequest$6_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_ttnet_org_chromium_net_impl_CronetUrlRequest$6__run$___twin___() {
        VersionSafeCallbacks.UrlRequestCallback r0 = CronetUrlRequest.access$400(this.this$0);     // Catch: Exception -> L4
        CronetUrlRequest r1 = this.this$0;     // Catch: Exception -> L4
        r0.onCanceled(r1, CronetUrlRequest.access$300(r1));     // Catch: Exception -> L4
        CronetUrlRequest.access$1200(this.this$0);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in onCanceled method", new Object[]{e});
    }

    public CronetUrlRequest$6(CronetUrlRequest r1) {
        this.this$0 = r1;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest$6_com_larus_apm_impl_protector_RunnableLancet_run(CronetUrlRequest$6 r1) {
        r1.com_ttnet_org_chromium_net_impl_CronetUrlRequest$6__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
