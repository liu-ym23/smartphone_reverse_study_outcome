package com.bytedance.bdinstall;

import com.larus.apm.impl.protector.RunnableProtector;
import i84.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class p0$g implements Runnable {
    public final /* synthetic */ p0 a;

    public final void a() {
        i0 r0 = this.a.b;
        if (r0 == null) goto L10;
        t.a("dispatcher#activeManually");
        long r1 = System.currentTimeMillis();
        if ((r1 - r0.i) >= 900000) goto L7;
        return;
    L7:
        if (j.a(r0.a.getContext()) == false) goto L14;
        r0.i = r1;
        r0.b(new c(r0.a, r0.e));
        return;
    L14:
        return;
    L10:
        t.e(new RuntimeException("active failed"));
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

    public p0$g(p0 r1) {
        this.a = r1;
    }
}
