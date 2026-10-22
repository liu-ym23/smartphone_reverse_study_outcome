package com.google.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {
    private static final Object[] EMPTY_ARRAY = null;
    private static final ProtobufArrayList<Object> EMPTY_LIST = null;
    private E[] array;
    private int size;

    static {
        Object[] r10 = new Object[0];
        EMPTY_ARRAY = r10;
        EMPTY_LIST = new ProtobufArrayList(r10, 0, false);
    }

    ProtobufArrayList() {
        this(EMPTY_ARRAY, 0, true);
    }

    private ProtobufArrayList(E[] r10, int r11, boolean r12) {
        super(r12);
        this.array = r10;
        this.size = r11;
    }

    private static <E> E[] createArray(int r10) {
        return (E[]) new Object[r10];
    }

    public static <E> ProtobufArrayList<E> emptyList() {
        return (ProtobufArrayList<E>) EMPTY_LIST;
    }

    private void ensureIndexInRange(int r10) {
        if (r10 < 0) goto L7;
        if (r10 >= this.size) goto L7;
        return;
    L7:
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(r10));
    }

    private static int growSize(int r10) {
        return Math.max(((r10 * 3) / 2) + 1, 10);
    }

    private String makeOutOfBoundsExceptionMessage(int r10) {
        return "Index:" + r10 + ", Size:" + this.size;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int r10, E r11) {
        ensureIsMutable();
        if (r10 < 0) goto L13;
        int r12 = this.size;
        if (r10 > r12) goto L13;
        E[] r13 = this.array;
        if (r12 >= r13.length) goto L9;
        System.arraycopy(r13, r10, r13, r10 + 1, r12 - r10);
    L10:
        this.array[r10] = r11;
        this.size++;
        ((AbstractList) this).modCount++;
        return;
    L9:
        E[] r14 = (E[]) createArray(growSize(r13.length));
        System.arraycopy(this.array, 0, r14, 0, r10);
        System.arraycopy(this.array, r10, r14, r10 + 1, this.size - r10);
        this.array = r14;
    L13:
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(r10));
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r10) {
        ensureIsMutable();
        int r11 = this.size;
        E[] r12 = this.array;
        if (r11 != r12.length) goto L5;
        this.array = (E[]) Arrays.copyOf(this.array, growSize(r12.length));
    L5:
        E[] r13 = this.array;
        int r14 = this.size;
        this.size = r14 + 1;
        r13[r14] = r10;
        ((AbstractList) this).modCount++;
        return true;
    }

    void ensureCapacity(int r10) {
        E[] r11 = this.array;
        if (r10 > r11.length) goto L6;
        return;
    L6:
        if (r11.length != 0) goto L9;
        this.array = (E[]) new Object[Math.max(r10, 10)];
        return;
    L9:
        int r12 = r11.length;
    L10:
        if (r12 >= r10) goto L12;
        r12 = growSize(r12);
        goto L10
    L12:
        this.array = (E[]) Arrays.copyOf(this.array, r12);
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r10) {
        ensureIndexInRange(r10);
        return this.array[r10];
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public /* bridge */ /* synthetic */ Internal.ProtobufList mutableCopyWithCapacity(int r10) {
        return mutableCopyWithCapacity(r10);
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public ProtobufArrayList<E> mutableCopyWithCapacity(int r10) {
        if (r10 < this.size) goto L10;
        if (r10 != 0) goto L6;
        Object[] r11 = EMPTY_ARRAY;
    L8:
        return new ProtobufArrayList(r11, this.size, true);
    L6:
        r11 = Arrays.copyOf(this.array, r10);
        goto L8
    L10:
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E remove(int r10) {
        ensureIsMutable();
        ensureIndexInRange(r10);
        E[] r11 = this.array;
        E r12 = r11[r10];
        int r13 = this.size;
        if (r10 >= (r13 - 1)) goto L5;
        System.arraycopy(r11, r10 + 1, r11, r10, (r13 - r10) - 1);
    L5:
        this.size--;
        ((AbstractList) this).modCount++;
        return r12;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E set(int r10, E r11) {
        ensureIsMutable();
        ensureIndexInRange(r10);
        E[] r12 = this.array;
        E r13 = r12[r10];
        r12[r10] = r11;
        ((AbstractList) this).modCount++;
        return r13;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }
}
