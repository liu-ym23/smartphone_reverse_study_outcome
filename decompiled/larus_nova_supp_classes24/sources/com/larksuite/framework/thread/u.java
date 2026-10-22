package com.larksuite.framework.thread;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class u implements Runnable {
    public final /* synthetic */ v a;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.e.incrementAndGet();     // Catch: Throwable -> L6
        v r0 = this.a;     // Catch: Throwable -> L6
        v.a r1 = r0.d;     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        r1.a(r0.e);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public u(v r1) {
        this.a = r1;
    }
}
