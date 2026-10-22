package com.ttnet.org.chromium.net.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class CronetUrlRequestContext$5 implements Runnable {
    final /* synthetic */ CronetUrlRequestContext this$0;
    final /* synthetic */ VersionSafeCallbacks.RequestFinishedInfoListener val$listener;
    final /* synthetic */ RequestFinishedInfo val$requestInfo;

    @Override // java.lang.Runnable
    public void run() {
        com_ttnet_org_chromium_net_impl_CronetUrlRequestContext$5_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext$5__run$___twin___() {
        this.val$listener.onRequestFinished(this.val$requestInfo);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext$5_com_larus_apm_impl_protector_RunnableLancet_run(CronetUrlRequestContext$5 r1) {
        r1.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext$5__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public CronetUrlRequestContext$5(CronetUrlRequestContext r1, VersionSafeCallbacks.RequestFinishedInfoListener r2, RequestFinishedInfo r3) {
        this.this$0 = r1;
        this.val$listener = r2;
        this.val$requestInfo = r3;
    }
}
