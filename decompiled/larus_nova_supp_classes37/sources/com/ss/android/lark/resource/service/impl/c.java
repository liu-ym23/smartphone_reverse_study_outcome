package com.ss.android.lark.resource.service.impl;

import com.bytedance.lark.pb.media.v1.PushResourceResponse;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ PushResourceResponse.Status b;
    public final /* synthetic */ ResourcePush c;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r0 = ((CopyOnWriteArrayList) this.c.a).iterator();     // Catch: Throwable -> L11
    L4:
        if (r0.hasNext() == false) goto L22;
        qpc.c r1 = (qpc.c) r0.next();     // Catch: Throwable -> L11
        String r2 = this.a;     // Catch: Throwable -> L11
        if (this.b != PushResourceResponse.Status.SUCCESS) goto L8;
        boolean r3 = true;
    L9:
        r1.onPushDownloadStatus(r2, r3);     // Catch: Throwable -> L11
        goto L4
    L8:
        r3 = false;
        goto L9
    L22:
        return;
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L15;
        return;
    L15:
        throw th;
    }

    public c(ResourcePush r1, String r2, PushResourceResponse.Status r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
