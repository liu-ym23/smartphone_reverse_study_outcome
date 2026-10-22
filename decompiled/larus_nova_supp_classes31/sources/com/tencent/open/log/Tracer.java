package com.tencent.open.log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public abstract class Tracer {
    private volatile int a;
    private volatile boolean b;
    private g c;

    public abstract void doTrace(int r1, Thread r2, long r3, String r5, String r6, Throwable r7);

    public Tracer() {
        this(c.a, true, g.a);
    }

    public boolean d() {
        return this.b;
    }

    public g e() {
        return this.c;
    }

    public void a(int r1) {
        this.a = r1;
    }

    public void a(g r1) {
        this.c = r1;
    }

    public void a(boolean r1) {
        this.b = r1;
    }

    public Tracer(int r2, boolean r3, g r4) {
        this.a = c.a;
        this.b = true;
        this.c = g.a;
        a(r2);
        a(r3);
        a(r4);
    }

    public void a(int r2, Thread r3, long r4, String r6, String r7, Throwable r8) {
        if (d() == true) goto L5;
        return;
    L5:
        if (d.a.a(this.a, r2) == false) goto L9;
        doTrace(r2, r3, r4, r6, r7, r8);
        return;
    }
}
