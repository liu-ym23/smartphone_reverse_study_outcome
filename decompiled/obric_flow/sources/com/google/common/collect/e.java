package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e extends ha {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8950b;

    public e(int r5, int r10) {
        com.google.common.base.b0.o(r10, r5);
        this.f8949a = r5;
        this.f8950b = r10;
    }

    public abstract Object a(int r5);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        if (this.f8950b >= this.f8949a) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        if (this.f8950b <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (hasNext() == false) goto L7;
        int r5 = this.f8950b;
        this.f8950b = r5 + 1;
        return a(r5);
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f8950b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (hasPrevious() == false) goto L7;
        int r5 = this.f8950b - 1;
        this.f8950b = r5;
        return a(r5);
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f8950b - 1;
    }
}
