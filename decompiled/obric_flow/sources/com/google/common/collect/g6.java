package com.google.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g6 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MapMakerInternalMap.Segment f8994c;
    public AtomicReferenceArray d;
    public h6 e;
    public a7 f;
    public a7 g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ MapMakerInternalMap f8995h;

    public g6(MapMakerInternalMap r5) {
        this.f8995h = r5;
        this.f8992a = r5.segments.length - 1;
        this.f8993b = -1;
        a();
    }

    public final void a() {
        this.f = null;
        if (d() == false) goto L6;
        return;
    L6:
        if (e() == false) goto L8;
        return;
    L8:
        int r5 = this.f8992a;
        if (r5 < 0) goto L14;
        MapMakerInternalMap.Segment[] r10 = this.f8995h.segments;
        this.f8992a = r5 - 1;
        MapMakerInternalMap.Segment r11 = r10[r5];
        this.f8994c = r11;
        if (r11.count == 0) goto L8;
        AtomicReferenceArray<E> r12 = this.f8994c.table;
        this.d = r12;
        this.f8993b = r12.length() - 1;
        if (e() == false) goto L8;
        return;
    }

    public final boolean b(h6 r5) {
        MapMakerInternalMap r10 = this.f8995h;
        Object r11 = r5.getKey();     // Catch: Throwable -> L8
        Object r12 = r10.getLiveValue(r5);     // Catch: Throwable -> L8
        if (r12 == null) goto L10;
        this.f = new a7(r10, r11, r12);     // Catch: Throwable -> L8
        this.f8994c.postReadCleanup();
        return true;
    L10:
        this.f8994c.postReadCleanup();
        return false;
    L8:
        th = move-exception;
        this.f8994c.postReadCleanup();
        throw th;
    }

    public final a7 c() {
        a7 r5 = this.f;
        if (r5 == null) goto L7;
        this.g = r5;
        a();
        return this.g;
    L7:
        throw new NoSuchElementException();
    }

    public final boolean d() {
        h6 r5 = this.e;
        if (r5 == null) goto L11;
    L4:
        this.e = r5.getNext();
        h6 r10 = this.e;
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

    public final boolean e() {
    L2:
        int r5 = this.f8993b;
        if (r5 < 0) goto L12;
        AtomicReferenceArray r10 = this.d;
        this.f8993b = r5 - 1;
        h6 r11 = (h6) r10.get(r5);
        this.e = r11;
        if (r11 == null) goto L2;
        if (b(r11) == true) goto L10;
        if (d() == false) goto L2;
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
        return c();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.g == null) goto L5;
        boolean r5 = true;
    L6:
        p7.t(r5);
        Object r10 = this.g.f8893a;
        this.f8995h.remove(r10);
        this.g = null;
        return;
    L5:
        r5 = false;
        goto L6
    }
}
