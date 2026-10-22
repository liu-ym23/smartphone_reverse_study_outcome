package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class w implements r0.e {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final r9.c f1568v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f1569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.lynx.tasm.base.f f1570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f1571c;
    public final r0.d d;
    public final r9.c e;
    public final s f;
    public final c0.b g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c0.b f1572h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c0.b f1573i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicInteger f1574j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public x f1575k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f1576l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f1577m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public d0 f1578n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public DataSource f1579o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f1580p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public GlideException f1581q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1582r;
    public y s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public k f1583t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile boolean f1584u;

    static {
        f1568v = new r9.c(2);
    }

    public w(c0.b r5, c0.b r10, c0.b r11, c0.b r12, s r13, s r14, r0.d r15) {
        r9.c r16 = f1568v;
        this.f1569a = new v(new ArrayList(2), 0);
        this.f1570b = new com.lynx.tasm.base.f();
        this.f1574j = new AtomicInteger();
        this.g = r5;
        this.f1572h = r10;
        this.f1573i = r12;
        this.f = r13;
        this.f1571c = r14;
        this.d = r15;
        this.e = r16;
    }

    public final synchronized void a(com.bumptech.glide.request.d r5, ai.y r10) {
        monitor-enter(this);
        this.f1570b.b();     // Catch: Throwable -> L6
        v r11 = this.f1569a;     // Catch: Throwable -> L6
        r11.getClass();     // Catch: Throwable -> L6
        ((ArrayList) r11.f1567b).add(new u(r5, r10));     // Catch: Throwable -> L6
        if (this.f1580p == false) goto L9;
        e(1);     // Catch: Throwable -> L6
        r10.execute(new t(this, r5, 1));     // Catch: Throwable -> L6
    L12:
        monitor-exit(this);
        return;
    L9:
        if (this.f1582r == false) goto L11;
        e(1);     // Catch: Throwable -> L6
        r10.execute(new t(this, r5, 0));     // Catch: Throwable -> L6
        goto L12
    L11:
        io.reactivex.internal.observers.h.f("Cannot add callbacks to a cancelled EngineJob", !this.f1584u);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // r0.e
    public final com.lynx.tasm.base.f b() {
        return this.f1570b;
    }

    public final void c() {
        if (f() == false) goto L5;
        return;
    L5:
        this.f1584u = true;
        k r5 = this.f1583t;
        r5.D = true;
        f r10 = r5.B;
        if (r10 == null) goto L8;
        r10.cancel();
    L8:
        s r11 = this.f;
        x r12 = this.f1575k;
        monitor-enter(r11);
        jg.k r13 = r11.f1558a;     // Catch: Throwable -> L15
        r13.getClass();     // Catch: Throwable -> L15
        HashMap r14 = (HashMap) r13.f18339b;     // Catch: Throwable -> L15
        if (equals(r14.get(r12)) == false) goto L13;
        r14.remove(r12);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r11);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public final void d() {
        monitor-enter(this);
        this.f1570b.b();     // Catch: Throwable -> L10
        io.reactivex.internal.observers.h.f("Not yet complete!", f());     // Catch: Throwable -> L10
        int r5 = this.f1574j.decrementAndGet();     // Catch: Throwable -> L10
        if (r5 < 0) goto L6;
        boolean r10 = true;
    L7:
        io.reactivex.internal.observers.h.f("Can't decrement below 0", r10);     // Catch: Throwable -> L10
        if (r5 != 0) goto L12;
        y r11 = this.s;     // Catch: Throwable -> L10
        g();     // Catch: Throwable -> L10
    L13:
        monitor-exit(this);     // Catch: Throwable -> L10
        if (r11 == null) goto L21;
        r11.d();
        return;
    L21:
        return;
    L12:
        r11 = null;
        goto L13
    L6:
        r10 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized void e(int r5) {
        monitor-enter(this);
        io.reactivex.internal.observers.h.f("Not yet complete!", f());     // Catch: Throwable -> L9
        if (this.f1574j.getAndAdd(r5) != 0) goto L11;
        y r10 = this.s;     // Catch: Throwable -> L9
        if (r10 == null) goto L11;
        r10.b();     // Catch: Throwable -> L9
    L11:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final boolean f() {
        if (this.f1582r == false) goto L5;
    L10:
        return true;
    L5:
        if (this.f1580p == true) goto L10;
        if (this.f1584u == true) goto L10;
        return false;
    }

    public final synchronized void g() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.f1575k == null) goto L21;
        ((ArrayList) this.f1569a.f1567b).clear();     // Catch: Throwable -> L15
        this.f1575k = null;     // Catch: Throwable -> L15
        this.s = null;     // Catch: Throwable -> L15
        this.f1578n = null;     // Catch: Throwable -> L15
        this.f1582r = false;     // Catch: Throwable -> L15
        this.f1584u = false;     // Catch: Throwable -> L15
        this.f1580p = false;     // Catch: Throwable -> L15
        k r5 = this.f1583t;     // Catch: Throwable -> L15
        j r10 = r5.g;     // Catch: Throwable -> L15
        monitor-enter(r10);     // Catch: Throwable -> L15
        r10.f1517a = true;     // Catch: Throwable -> L17
        boolean r11 = r10.b();     // Catch: Throwable -> L17
        monitor-exit(r10);     // Catch: Throwable -> L15
        if (r11 == false) goto L12;
        r5.k();     // Catch: Throwable -> L15
    L12:
        this.f1583t = null;     // Catch: Throwable -> L15
        this.f1581q = null;     // Catch: Throwable -> L15
        this.f1579o = null;     // Catch: Throwable -> L15
        this.d.release(this);     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L21:
        throw new IllegalArgumentException();     // Catch: Throwable -> L15
    }

    public final synchronized void h(com.bumptech.glide.request.d r5) {
        monitor-enter(this);
        this.f1570b.b();     // Catch: Throwable -> L10
        v r10 = this.f1569a;     // Catch: Throwable -> L10
        r10.getClass();     // Catch: Throwable -> L10
        u r11 = new u(r5, q0.e.f21452b);     // Catch: Throwable -> L10
        ((ArrayList) r10.f1567b).remove(r11);     // Catch: Throwable -> L10
        if (((ArrayList) this.f1569a.f1567b).isEmpty() == false) goto L15;
        c();     // Catch: Throwable -> L10
        if (this.f1580p == true) goto L13;
        if (this.f1582r == false) goto L15;
    L13:
        if (this.f1574j.get() != 0) goto L15;
        g();     // Catch: Throwable -> L10
    L15:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
