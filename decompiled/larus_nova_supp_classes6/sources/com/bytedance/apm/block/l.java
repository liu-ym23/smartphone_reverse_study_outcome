package com.bytedance.apm.block;

import b27.j;
import com.larus.apm.impl.protector.RunnableProtector;
import ss3.e;
import zs3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class l implements Runnable {
    public final /* synthetic */ c a;
    public final /* synthetic */ k b;

    public final void a() {
        c r0 = this.a;
        if ((r0.h - r0.g) > this.b.e) goto L5;
    L7:
        this.a.getClass();
        c r1 = this.a;
        if (r1.q == null) goto L12;
        if (r1.l == true) goto L12;
    L15:
        c r2 = this.a;
        long r3 = r2.h - r2.g;
        k r4 = this.b;
        if (r3 > r4.e) goto L18;
    L22:
        boolean r5 = false;
    L33:
        String r6 = j.a(this.a.b);     // Catch: Exception -> L32
        k r7 = this.b;     // Catch: Exception -> L32
        c r8 = this.a;     // Catch: Exception -> L32
        k.a(r7, r8.d, r8, r6);     // Catch: Exception -> L32
        if (this.a.j == true) goto L26;
    L30:
        k.c(this.b, this.a, r6);     // Catch: Exception -> L32
        return;
    L26:
        if (this.b.b == false) goto L30;
        k r9 = this.b;     // Catch: Exception -> L32
        if (r9.f == false) goto L30;
        k.b(r9, this.a, r6, r5);     // Catch: Exception -> L32
    L35:
        return;
    L18:
        if (r2.j == true) goto L22;
        if (r4.f == false) goto L22;
        r2.v = k.d(r4);
        c r10 = this.a;
        e.b().getClass();
        r10.u = e.a();
        r5 = true;
        this.a.j = true;
    L12:
        if (this.b.c == false) goto L14;
        return;
    L14:
        this.a.q = "Invalid Stack\n";
        goto L15
    L5:
        if (c.b("serious_block_monitor") == false) goto L7;
        c r11 = this.b.k;
        com.bytedance.monitor.collector.c r12 = com.bytedance.monitor.collector.c.e();
        c r13 = this.a;
        r11.w = r12.c(r13.g, r13.h);
        goto L7
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

    public l(k r1, c r2) {
        this.b = r1;
        this.a = r2;
    }
}
