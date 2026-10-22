package com.google.crypto.tink.shaded.protobuf;

import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
final class bh<E> extends c<E> implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final bh<Object> f4978a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private E[] f4979b;
    private int c;

    static {
        f4978a = new bh(new Object[0], 0, false);
    }

    bh() {
        this(new Object[10], 0, true);
    }

    private bh(E[] r1, int r2, boolean r3) {
        super(r3);
        this.f4979b = r1;
        this.c = r2;
    }

    private static <E> E[] b(int r0) {
        return (E[]) new Object[r0];
    }

    private void c(int r2) {
        if (r2 < 0) goto L7;
        if (r2 >= this.c) goto L7;
        return;
    L7:
        throw new IndexOutOfBoundsException(d(r2));
    }

    public static <E> bh<E> d() {
        return (bh<E>) f4978a;
    }

    private String d(int r3) {
        return "Index:" + r3 + ", Size:" + this.c;
    }

    public bh<E> a(int r3) {
        if (r3 < this.c) goto L7;
        return new bh(Arrays.copyOf(this.f4979b, r3), this.c, true);
    L7:
        throw new IllegalArgumentException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.List
    public void add(int r5, E r6) {
        c();
        if (r5 < 0) goto L13;
        int r0 = this.c;
        if (r5 > r0) goto L13;
        E[] r1 = this.f4979b;
        if (r0 >= r1.length) goto L9;
        System.arraycopy(r1, r5, r1, r5 + 1, r0 - r5);
    L10:
        this.f4979b[r5] = r6;
        this.c++;
        this.modCount++;
        return;
    L9:
        E[] r2 = (E[]) b(((r0 * 3) / 2) + 1);
        System.arraycopy(this.f4979b, 0, r2, 0, r5);
        System.arraycopy(this.f4979b, r5, r2, r5 + 1, this.c - r5);
        this.f4979b = r2;
    L13:
        throw new IndexOutOfBoundsException(d(r5));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r5) {
        c();
        int r0 = this.c;
        E[] r1 = this.f4979b;
        if (r0 != r1.length) goto L5;
        this.f4979b = (E[]) Arrays.copyOf(r1, ((r0 * 3) / 2) + 1);
    L5:
        E[] r2 = this.f4979b;
        int r3 = this.c;
        this.c = r3 + 1;
        r2[r3] = r5;
        this.modCount++;
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ab.i, com.google.crypto.tink.shaded.protobuf.ab.g
    public /* synthetic */ ab.i e(int r1) {
        return a(r1);
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r1) {
        c(r1);
        return this.f4979b[r1];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.List
    public E remove(int r5) {
        c();
        c(r5);
        E[] r0 = this.f4979b;
        E r1 = r0[r5];
        int r2 = this.c;
        if (r5 >= (r2 - 1)) goto L5;
        System.arraycopy(r0, r5 + 1, r0, r5, (r2 - r5) - 1);
    L5:
        this.c--;
        this.modCount++;
        return r1;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.List
    public E set(int r3, E r4) {
        c();
        c(r3);
        E[] r0 = this.f4979b;
        E r1 = r0[r3];
        r0[r3] = r4;
        this.modCount++;
        return r1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.c;
    }
}
