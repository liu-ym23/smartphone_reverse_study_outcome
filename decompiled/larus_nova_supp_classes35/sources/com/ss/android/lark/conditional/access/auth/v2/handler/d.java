package com.ss.android.lark.conditional.access.auth.v2.handler;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements Runnable {
    public final /* synthetic */ e a;

    public d(e r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e r0 = this.a;     // Catch: Throwable -> L4
        r0.b.invoke(r0.d);     // Catch: Throwable -> L4
        e r1 = this.a;     // Catch: Throwable -> L4
        r1.getClass();     // Catch: Throwable -> L4
        r1.c = System.currentTimeMillis();     // Catch: Throwable -> L4
        r1.d.clear();     // Catch: Throwable -> L4
        r1.e = false;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
