package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f9406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f9407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f9408c;
    public final AtomicReferenceFieldUpdater d;
    public final AtomicReferenceFieldUpdater e;

    public d(AtomicReferenceFieldUpdater r5, AtomicReferenceFieldUpdater r10, AtomicReferenceFieldUpdater r11, AtomicReferenceFieldUpdater r12, AtomicReferenceFieldUpdater r13) {
        this.f9406a = r5;
        this.f9407b = r10;
        this.f9408c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // com.google.common.util.concurrent.p0
    public final boolean a(o r5, c r10, c r11) {
    L2:
        AtomicReferenceFieldUpdater r12 = this.d;
        if (r12.compareAndSet(r5, r10, r11) == true) goto L4;
        if (r12.get(r5) == r10) goto L2;
        return false;
    L4:
        return true;
    }

    @Override // com.google.common.util.concurrent.p0
    public final boolean b(o r5, Object r10, Object r11) {
    L2:
        AtomicReferenceFieldUpdater r12 = this.e;
        if (r12.compareAndSet(r5, r10, r11) == true) goto L4;
        if (r12.get(r5) == r10) goto L2;
        return false;
    L4:
        return true;
    }

    @Override // com.google.common.util.concurrent.p0
    public final boolean c(o r5, n r10, n r11) {
    L2:
        AtomicReferenceFieldUpdater r12 = this.f9408c;
        if (r12.compareAndSet(r5, r10, r11) == true) goto L4;
        if (r12.get(r5) == r10) goto L2;
        return false;
    L4:
        return true;
    }

    @Override // com.google.common.util.concurrent.p0
    public final c e(o r5) {
        c r10 = c.d;
        return (c) this.d.getAndSet(r5, r10);
    }

    @Override // com.google.common.util.concurrent.p0
    public final n f(o r5) {
        n r10 = n.f9421c;
        return (n) this.f9408c.getAndSet(r5, r10);
    }

    @Override // com.google.common.util.concurrent.p0
    public final void i(n r5, n r10) {
        this.f9407b.lazySet(r5, r10);
    }

    @Override // com.google.common.util.concurrent.p0
    public final void j(n r5, Thread r10) {
        this.f9406a.lazySet(r5, r10);
    }
}
