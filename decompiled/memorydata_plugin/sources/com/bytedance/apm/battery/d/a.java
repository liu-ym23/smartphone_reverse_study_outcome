package com.bytedance.apm.battery.d;

import android.os.SystemClock;
import com.bytedance.apm.battery.d.a.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T extends com.bytedance.apm.battery.d.a.b> extends c<T> {
    private static final Object e = null;
    private volatile int f;
    private volatile long g;
    private long h;
    private int i;

    static {
        e = new Object();
    }

    a(String r1) {
        super(r1);
        this.f = 0;
    }

    private void a(long r11, boolean r13, String r14) {
        com.bytedance.apm.c.a r9 = new com.bytedance.apm.c.a(r13, System.currentTimeMillis(), getType(), this.c, r11, r14);
        com.bytedance.apm.battery.c.a.a().a(r9);
    }

    static /* synthetic */ void a(a r0, long r1, boolean r3, String r4) {
        r0.a(r1, r3, r4);
    }

    private void d(boolean r7) {
        Object r0 = e;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f > 0) goto L7;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.g <= 0) goto L12;
        long r1 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L14
        if (r7 == false) goto L11;
        a(r1 - this.g, this.f1162b, com.bytedance.apm.battery.a.a().h());     // Catch: Throwable -> L14
    L11:
        this.g = r1;     // Catch: Throwable -> L14
        goto L12
    }

    abstract void a(double r1, double r3);

    @Override // com.bytedance.apm.battery.d.c
    public void a(long r9, long r11, boolean r13) {
        this.i = 0;
        this.h = 0;
        d(r13);
        super.a(r9, r11, r13);
        long r10 = System.currentTimeMillis();
        a(((this.h / (r10 - this.f1161a)) * 60000.0d) * 10.0d, ((((double) this.i) / (r10 - this.f1161a)) * 60000.0d) * 10.0d);
    }

    public abstract void a(T r1, long r2);

    @Override // com.bytedance.apm.battery.d.c
    public void a(T r6, long r7, long r9) {
        this.i++;
        long r0 = r6.d;
        if (r0 < r7) goto L6;
        r7 = r0;
    L6:
        long r1 = r6.e;
        if (r1 > 0) goto L9;
    L12:
        a(r6, r9 - r6.d);
        long r10 = r9 - r7;
        if (r10 <= 0) goto L16;
        this.h += r10;
        return;
    L16:
        return;
    L9:
        if (r9 < r1) goto L12;
        r9 = r1;
        goto L12
    }

    @Override // com.bytedance.apm.battery.d.c, com.bytedance.apm.battery.d.l
    public void a(boolean r1) {
        d(r1);
        super.a(r1);
    }

    @Override // com.bytedance.apm.battery.d.l
    public void a(boolean r1, boolean r2) {
        d(r2);
        this.c = r1;
    }

    void b() {
        Object r0 = e;
        monitor-enter(r0);
        com.bytedance.apm.e.a.b("APM-Battery", "addHolderCount:" + this.f + " type:" + getType());     // Catch: Throwable -> L9
        this.f++;     // Catch: Throwable -> L9
        if (this.f != 1) goto L7;
        this.g = SystemClock.elapsedRealtime();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.battery.d.c, com.bytedance.apm.battery.d.l
    public void b(boolean r1) {
        d(r1);
        super.b(r1);
    }

    void c() {
        Object r0 = e;
        monitor-enter(r0);
        com.bytedance.apm.e.a.b("APM-Battery", "reduceHolderCount:" + this.f + " type:" + getType());     // Catch: Throwable -> L13
        if (this.f != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L8:
        this.f--;     // Catch: Throwable -> L13
        if (this.f != 0) goto L11;
        final boolean r1 = this.f1162b;     // Catch: Throwable -> L13
        final long r2 = SystemClock.elapsedRealtime() - this.g;     // Catch: Throwable -> L13
        com.bytedance.apm.l.b.a().a(new AnonymousClass1(this, r2, r1));     // Catch: Throwable -> L13
        this.g = -1;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
