package com.google.common.cache;

import com.google.common.util.concurrent.b1;
import java.lang.ref.ReferenceQueue;

/* JADX INFO: loaded from: classes2.dex */
public class y implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile g0 f8777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b1 f8778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.common.base.d0 f8779c;

    public y(g0 r5) {
        this.f8778b = new b1();
        this.f8779c = new com.google.common.base.d0();
        if (r5 != null) goto L5;
        r5 = q0.f8743w;
    L5:
        this.f8777a = r5;
    }

    @Override // com.google.common.cache.g0
    public final v0 a() {
        return null;
    }

    @Override // com.google.common.cache.g0
    public final void b(Object r5) {
        if (r5 == null) goto L4;
        this.f8778b.l(r5);
        return;
    L4:
        this.f8777a = q0.f8743w;
    }

    @Override // com.google.common.cache.g0
    public final int c() {
        return this.f8777a.c();
    }

    @Override // com.google.common.cache.g0
    public boolean d() {
        return !(this instanceof t);
    }

    @Override // com.google.common.cache.g0
    public final g0 e(ReferenceQueue r5, Object r10, v0 r11) {
        return this;
    }

    @Override // com.google.common.cache.g0
    public final Object f() {
        return com.google.common.util.concurrent.p0.h(this.f8778b);
    }

    public final com.google.common.util.concurrent.w0 g(Object r5, h r10) {
        this.f8779c.a();     // Catch: Throwable -> L7
        Object r11 = this.f8777a.get();     // Catch: Throwable -> L7
        if (r11 != null) goto L13;
        Object r12 = r10.load(r5);     // Catch: Throwable -> L7
        if (this.f8778b.l(r12) == true) goto L28;
        if (r12 != null) goto L12;
        return com.google.common.util.concurrent.u0.f9438b;
    L12:
        return new com.google.common.util.concurrent.u0(r12);
    L28:
        return this.f8778b;
    L13:
        com.google.common.util.concurrent.w0 r13 = r10.reload(r5, r11);     // Catch: Throwable -> L7
        if (r13 != null) goto L18;
        return com.google.common.util.concurrent.u0.f9438b;
    L18:
        return com.google.common.util.concurrent.p0.k(r13, new x(this), com.google.common.util.concurrent.p0.d());
    L7:
        th = move-exception;
        if (this.f8778b.k(th) == false) goto L22;
        com.google.common.util.concurrent.o r14 = this.f8778b;
    L24:
        if ((th instanceof InterruptedException) == false) goto L26;
        Thread.currentThread().interrupt();
    L26:
        return r14;
    L22:
        r14 = new com.google.common.util.concurrent.t0();
        r14.k(th);
        goto L24
    }

    @Override // com.google.common.cache.g0
    public final Object get() {
        return this.f8777a.get();
    }

    @Override // com.google.common.cache.g0
    public final boolean isActive() {
        return this.f8777a.isActive();
    }
}
