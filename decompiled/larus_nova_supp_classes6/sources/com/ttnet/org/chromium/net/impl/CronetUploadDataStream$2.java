package com.ttnet.org.chromium.net.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class CronetUploadDataStream$2 implements Runnable {
    final /* synthetic */ CronetUploadDataStream this$0;

    @Override // java.lang.Runnable
    public void run() {
        com_ttnet_org_chromium_net_impl_CronetUploadDataStream$2_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_ttnet_org_chromium_net_impl_CronetUploadDataStream$2__run$___twin___() {
        Object r0 = CronetUploadDataStream.access$000(this.this$0);
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (CronetUploadDataStream.access$100(this.this$0) != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L8:
        CronetUploadDataStream.access$200(this.this$0, 3);     // Catch: Throwable -> L15
        CronetUploadDataStream.access$402(this.this$0, 1);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        CronetUploadDataStream.access$500(this.this$0);     // Catch: Exception -> L12
        CronetUploadDataStream.access$600(this.this$0).rewind(this.this$0);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        CronetUploadDataStream.access$700(this.this$0, e);
    }

    public CronetUploadDataStream$2(CronetUploadDataStream r1) {
        this.this$0 = r1;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_ttnet_org_chromium_net_impl_CronetUploadDataStream$2_com_larus_apm_impl_protector_RunnableLancet_run(CronetUploadDataStream$2 r1) {
        r1.com_ttnet_org_chromium_net_impl_CronetUploadDataStream$2__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
