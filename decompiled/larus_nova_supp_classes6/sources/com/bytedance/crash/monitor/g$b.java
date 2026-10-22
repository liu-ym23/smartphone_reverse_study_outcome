package com.bytedance.crash.monitor;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class g$b implements Runnable {
    public final /* synthetic */ g a;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.s();     // Catch: Throwable -> L10
        g.d r0 = this.a.r;     // Catch: Throwable -> L10
        monitor-enter(r0);     // Catch: Throwable -> L10
        r0.notifyAll();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    L13:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L18;
        throw th;
    }

    public g$b(g r1) {
        this.a = r1;
    }
}
