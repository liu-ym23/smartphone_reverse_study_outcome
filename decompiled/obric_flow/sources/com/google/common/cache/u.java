package com.google.common.cache;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LocalCache$Segment f8767c;
    public AtomicReferenceArray d;
    public v0 e;
    public p0 f;
    public p0 g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ q0 f8768h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f8769i;

    public u(q0 r5, int r10) {
        this.f8769i = r10;
        this.f8768h = r5;
        this.f8765a = r5.f8747c.length - 1;
        this.f8766b = -1;
        a();
    }

    public final void a() {
        this.f = null;
        if (e() == false) goto L6;
        return;
    L6:
        if (f() == false) goto L8;
        return;
    L8:
        int r5 = this.f8765a;
        if (r5 < 0) goto L14;
        LocalCache$Segment[] r10 = this.f8768h.f8747c;
        this.f8765a = r5 - 1;
        LocalCache$Segment r11 = r10[r5];
        this.f8767c = r11;
        if (r11.count == 0) goto L8;
        AtomicReferenceArray<v0> r12 = this.f8767c.table;
        this.d = r12;
        this.f8766b = r12.length() - 1;
        if (f() == false) goto L8;
        return;
    }

    public final boolean b(v0 r10) {
        q0 r5 = this.f8768h;
        long r11 = r5.f8755o.a();     // Catch: Throwable -> L17
        Object r12 = r10.getKey();     // Catch: Throwable -> L17
        r5.getClass();     // Catch: Throwable -> L17
        Object r13 = null;
        if (r10.getKey() == null) goto L13;
        Object r14 = r10.getValueReference().get();     // Catch: Throwable -> L17
        if (r14 == null) goto L13;
        if (r5.f(r10, r11) == true) goto L13;
        r13 = r14;
    L13:
        if (r13 == null) goto L19;
        this.f = new p0(r5, r12, r13);     // Catch: Throwable -> L17
        this.f8767c.postReadCleanup();
        return true;
    L19:
        this.f8767c.postReadCleanup();
        return false;
    L17:
        th = move-exception;
        this.f8767c.postReadCleanup();
        throw th;
    }

    public final Object c() {
        return d();
    }

    public final p0 d() {
        p0 r5 = this.f;
        if (r5 == null) goto L7;
        this.g = r5;
        a();
        return this.g;
    L7:
        throw new NoSuchElementException();
    }

    public final boolean e() {
        v0 r5 = this.e;
        if (r5 == null) goto L11;
    L4:
        this.e = r5.getNext();
        v0 r10 = this.e;
        if (r10 == null) goto L15;
        if (b(r10) == true) goto L8;
        r5 = this.e;
        goto L4
    L8:
        return true;
    L15:
        return false;
    L11:
        return false;
    }

    public final boolean f() {
    L2:
        int r5 = this.f8766b;
        if (r5 < 0) goto L12;
        AtomicReferenceArray r10 = this.d;
        this.f8766b = r5 - 1;
        v0 r11 = (v0) r10.get(r5);
        this.e = r11;
        if (r11 == null) goto L2;
        if (b(r11) == true) goto L10;
        if (e() == false) goto L2;
        return true;
    L10:
        return true;
    L12:
        return false;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public Object next() {
        switch(this.f8769i) {
            case 1: goto L9;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return c();
    L7:
        return d().f8737b;
    L9:
        return d().f8736a;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.g == null) goto L5;
        boolean r5 = true;
    L6:
        com.google.common.base.b0.t(r5);
        Object r10 = this.g.f8736a;
        this.f8768h.remove(r10);
        this.g = null;
        return;
    L5:
        r5 = false;
        goto L6
    }
}
