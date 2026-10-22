package com.google.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {
    private static final Object[] EMPTY_ARRAY = null;
    private static final ProtobufArrayList<Object> EMPTY_LIST = null;
    private E[] array;
    private int size;

    static {
        Object[] r8 = new Object[0];
        EMPTY_ARRAY = r8;
        EMPTY_LIST = new ProtobufArrayList(r8, 0, false);
    }

    public ProtobufArrayList() {
        this(EMPTY_ARRAY, 0, true);
    }

    private static <E> E[] createArray(int r8) {
        return (E[]) new Object[r8];
    }

    public static <E> ProtobufArrayList<E> emptyList() {
        return (ProtobufArrayList<E>) EMPTY_LIST;
    }

    private void ensureIndexInRange(int r8) {
        if (r8 < 0) goto L7;
        if (r8 >= this.size) goto L7;
        return;
    L7:
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(r8));
    }

    private static int growSize(int r8) {
        return Math.max(((r8 * 3) / 2) + 1, 10);
    }

    private String makeOutOfBoundsExceptionMessage(int r8) {
        StringBuilder r10 = defpackage.b.f("Index:", r8, ", Size:");
        r10.append(this.size);
        return r10.toString();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int r8, E r10) {
        ensureIsMutable();
        if (r8 < 0) goto L13;
        int r11 = this.size;
        if (r8 > r11) goto L13;
        E[] r12 = this.array;
        if (r11 >= r12.length) goto L9;
        System.arraycopy(r12, r8, r12, r8 + 1, r11 - r8);
    L10:
        this.array[r8] = r10;
        this.size++;
        ((AbstractList) this).modCount++;
        return;
    L9:
        E[] r13 = (E[]) createArray(growSize(r12.length));
        System.arraycopy(this.array, 0, r13, 0, r8);
        System.arraycopy(this.array, r8, r13, r8 + 1, this.size - r8);
        this.array = r13;
    L13:
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(r8));
    }

    public void ensureCapacity(int r8) {
        E[] r10 = this.array;
        if (r8 > r10.length) goto L6;
        return;
    L6:
        if (r10.length != 0) goto L9;
        this.array = (E[]) new Object[Math.max(r8, 10)];
        return;
    L9:
        int r11 = r10.length;
    L10:
        if (r11 >= r8) goto L12;
        r11 = growSize(r11);
        goto L10
    L12:
        this.array = (E[]) Arrays.copyOf(this.array, r11);
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r8) {
        ensureIndexInRange(r8);
        return this.array[r8];
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public /* bridge */ /* synthetic */ Internal.ProtobufList mutableCopyWithCapacity(int r8) {
        return mutableCopyWithCapacity(r8);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E remove(int r8) {
        ensureIsMutable();
        ensureIndexInRange(r8);
        E[] r10 = this.array;
        E r11 = r10[r8];
        int r12 = this.size;
        if (r8 >= (r12 - 1)) goto L5;
        System.arraycopy(r10, r8 + 1, r10, r8, (r12 - r8) - 1);
    L5:
        this.size--;
        ((AbstractList) this).modCount++;
        return r11;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E set(int r8, E r10) {
        ensureIsMutable();
        ensureIndexInRange(r8);
        E[] r11 = this.array;
        E r12 = r11[r8];
        r11[r8] = r10;
        ((AbstractList) this).modCount++;
        return r12;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    private ProtobufArrayList(E[] r8, int r10, boolean r11) {
        super(r11);
        this.array = r8;
        this.size = r10;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r8) {
        ensureIsMutable();
        int r10 = this.size;
        E[] r11 = this.array;
        if (r10 != r11.length) goto L5;
        this.array = (E[]) Arrays.copyOf(this.array, growSize(r11.length));
    L5:
        E[] r12 = this.array;
        int r13 = this.size;
        this.size = r13 + 1;
        r12[r13] = r8;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public ProtobufArrayList<E> mutableCopyWithCapacity(int r8) {
        if (r8 < this.size) goto L10;
        if (r8 != 0) goto L6;
        Object[] r10 = EMPTY_ARRAY;
    L8:
        return new ProtobufArrayList(r10, this.size, true);
    L6:
        r10 = Arrays.copyOf(this.array, r8);
        goto L8
    L10:
        throw new IllegalArgumentException();
    }
}
