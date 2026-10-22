package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
abstract class a<E> extends bk<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4655b;

    public a(int r2) {
        this(r2, 0);
    }

    public a(int r1, int r2) {
        com.google.common.base.n.b(r2, r1);
        this.f4654a = r1;
        this.f4655b = r2;
    }

    public abstract E a(int r1);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        if (this.f4655b >= this.f4654a) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        if (this.f4655b <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext() == false) goto L7;
        int r0 = this.f4655b;
        this.f4655b = r0 + 1;
        return a(r0);
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f4655b;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious() == false) goto L7;
        int r0 = this.f4655b - 1;
        this.f4655b = r0;
        return a(r0);
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f4655b - 1;
    }
}
