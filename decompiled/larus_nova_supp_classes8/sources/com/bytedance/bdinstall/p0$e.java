package com.bytedance.bdinstall;

import b84.m;
import com.larus.apm.impl.protector.RunnableProtector;
import g84.a;
import g84.e;
import i84.n;
import k74.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class p0$e implements Runnable {
    public final /* synthetic */ u a;
    public final /* synthetic */ p0 b;

    public final void a() {
        this.b.b.c(this.a, false);
        b84.q r0 = this.b.c;
        r0.getClass();
        a r1 = (a) e.a(a.class, String.valueOf(((m) r0).f.a));
        if (r1 == null) goto L5;
        r1.clearAll();
    L5:
        n.a(((m) r0).e, ((m) r0).f);
        n r2 = i84.o.a;
        i84.o.a = new n();
        b84.q r3 = this.b.c;
        r3.g();
        c r4 = ((m) r3).n;
        if (r4 == null) goto L8;
        r4.a(new l74.a(((m) r3).i));
    L8:
        r3.j();
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

    public p0$e(p0 r1, u r2) {
        this.b = r1;
        this.a = r2;
    }
}
