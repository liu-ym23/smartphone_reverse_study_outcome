package com.ttnet.org.chromium.net.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import java.nio.ByteBuffer;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class CronetUrlRequest$OnReadCompletedRunnable implements Runnable {
    ByteBuffer mByteBuffer;
    final /* synthetic */ CronetUrlRequest this$0;

    @Override // java.lang.Runnable
    public void run() {
        com_ttnet_org_chromium_net_impl_CronetUrlRequest$OnReadCompletedRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_ttnet_org_chromium_net_impl_CronetUrlRequest$OnReadCompletedRunnable__run$___twin___() {
        this.this$0.checkCallingThread();
        ByteBuffer r0 = this.mByteBuffer;
        this.mByteBuffer = null;
        Object r1 = CronetUrlRequest.access$000(this.this$0);     // Catch: Exception -> L16
        monitor-enter(r1);     // Catch: Exception -> L16
    L13:
        th = move-exception;
        throw th;     // Catch: Exception -> L16
    L6:
        if (CronetUrlRequest.access$100(this.this$0) == false) goto L9;
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L9:
        CronetUrlRequest.access$202(this.this$0, true);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        VersionSafeCallbacks$UrlRequestCallback r2 = CronetUrlRequest.access$400(this.this$0);     // Catch: Exception -> L16
        CronetUrlRequest r3 = this.this$0;     // Catch: Exception -> L16
        r2.onReadCompleted(r3, CronetUrlRequest.access$300(r3), r0);     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        CronetUrlRequest.access$500(this.this$0, e);
    }

    private CronetUrlRequest$OnReadCompletedRunnable(CronetUrlRequest r1) {
        this.this$0 = r1;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest$OnReadCompletedRunnable_com_larus_apm_impl_protector_RunnableLancet_run(CronetUrlRequest$OnReadCompletedRunnable r1) {
        r1.com_ttnet_org_chromium_net_impl_CronetUrlRequest$OnReadCompletedRunnable__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public /* synthetic */ CronetUrlRequest$OnReadCompletedRunnable(CronetUrlRequest r1, CronetUrlRequest.1 r2) {
        this(r1);
    }
}
