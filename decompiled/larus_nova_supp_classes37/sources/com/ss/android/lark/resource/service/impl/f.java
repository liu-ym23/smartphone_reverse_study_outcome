package com.ss.android.lark.resource.service.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;
    public final /* synthetic */ ResourcePush e;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r0 = ((CopyOnWriteArrayList) this.e.c).iterator();     // Catch: Throwable -> L7
    L4:
        if (r0.hasNext() == false) goto L16;
        ((qpc.b) r0.next()).onPushDownloadProgress(this.a, this.b, this.c, this.d);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public f(ResourcePush r1, String r2, int r3, long r4, long r6) {
        this.e = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
    }
}
