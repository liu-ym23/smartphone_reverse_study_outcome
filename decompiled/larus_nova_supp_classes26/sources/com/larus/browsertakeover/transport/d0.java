package com.larus.browsertakeover.transport;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d0 {
    public int a;
    public long b;
    public int c;
    public long d;

    public final synchronized e0 a() {
        monitor-enter(this);
        e0 r7 = new e0(this.a, this.b, this.c, this.d);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r7;
    L6:
        th = move-exception;
        throw th;
    }

    public d0() {
    }

    public final synchronized e0 b(int r12) {
        monitor-enter(this);
        if (r12 > 0) goto L18;
    L15:
        monitor-exit(this);
        return null;
    L18:
        int r0 = this.a;     // Catch: Throwable -> L12
        if (r0 >= 512) goto L15;
        long r1 = r12;
        long r3 = this.b;     // Catch: Throwable -> L12
        if (r1 > (8388608 - r3)) goto L15;
        int r2 = r0 + 1;     // Catch: Throwable -> L12
        this.a = r2;     // Catch: Throwable -> L12
        this.b = r3 + r1;     // Catch: Throwable -> L12
        this.c = Math.max(this.c, r2);     // Catch: Throwable -> L12
        long r9 = Math.max(this.d, this.b);     // Catch: Throwable -> L12
        this.d = r9;     // Catch: Throwable -> L12
        e0 r13 = new e0(this.a, this.b, this.c, r9);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r13;
    L12:
        th = move-exception;
        throw th;
    }
}
