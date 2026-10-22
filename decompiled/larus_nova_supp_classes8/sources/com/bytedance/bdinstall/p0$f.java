package com.bytedance.bdinstall;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class p0$f implements Runnable {
    public final /* synthetic */ u a;
    public final /* synthetic */ p0 b;

    public final void a() {
        if (this.b.e.get() == false) goto L5;
        this.b.b.d(this.a, false, true);
        return;
    L5:
        t.a("not start yet,start it " + this.a);
        this.b.b.c(this.a, true);
        p0.o(this.b, true);
        this.b.q();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public p0$f(p0 r1, u r2) {
        this.b = r1;
        this.a = r2;
    }
}
