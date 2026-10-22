package com.google.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class IntArrayList extends AbstractProtobufList<Integer> implements Internal.IntList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final int[] EMPTY_ARRAY = null;
    private static final IntArrayList EMPTY_LIST = null;
    private int[] array;
    private int size;

    static {
        int[] r8 = new int[0];
        EMPTY_ARRAY = r8;
        EMPTY_LIST = new IntArrayList(r8, 0, false);
    }

    public IntArrayList() {
        this(EMPTY_ARRAY, 0, true);
    }

    public static IntArrayList emptyList() {
        return EMPTY_LIST;
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

    public void add(int r8, Integer r10) {
        addInt(r8, r10.intValue());
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Integer> r8) {
        ensureIsMutable();
        Internal.checkNotNull(r8);
        if ((r8 instanceof IntArrayList) == false) goto L5;
        IntArrayList r10 = (IntArrayList) r8;
        int r11 = r10.size;
        if (r11 != 0) goto L9;
        return false;
    L9:
        int r12 = this.size;
        if ((Integer.MAX_VALUE - r12) < r11) goto L17;
        int r13 = r12 + r11;
        int[] r14 = this.array;
        if (r13 <= r14.length) goto L14;
        this.array = Arrays.copyOf(r14, r13);
    L14:
        System.arraycopy(r10.array, 0, this.array, this.size, r10.size);
        this.size = r13;
        ((AbstractList) this).modCount++;
        return true;
    L17:
        throw new OutOfMemoryError();
    L5:
        return super.addAll(r8);
    }

    @Override // com.google.protobuf.Internal.IntList
    public void addInt(int r8) {
        ensureIsMutable();
        int r10 = this.size;
        int[] r11 = this.array;
        if (r10 != r11.length) goto L5;
        int[] r12 = new int[growSize(r11.length)];
        System.arraycopy(this.array, 0, r12, 0, this.size);
        this.array = r12;
    L5:
        int[] r13 = this.array;
        int r14 = this.size;
        this.size = r14 + 1;
        r13[r14] = r8;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r8) {
        if (indexOf(r8) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public void ensureCapacity(int r8) {
        int[] r10 = this.array;
        if (r8 > r10.length) goto L6;
        return;
    L6:
        if (r10.length != 0) goto L9;
        this.array = new int[Math.max(r8, 10)];
        return;
    L9:
        int r11 = r10.length;
    L10:
        if (r11 >= r8) goto L12;
        r11 = growSize(r11);
        goto L10
    L12:
        this.array = Arrays.copyOf(this.array, r11);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof IntArrayList) == false) goto L8;
        IntArrayList r10 = (IntArrayList) r8;
        if (this.size == r10.size) goto L12;
        return false;
    L12:
        int[] r11 = r10.array;
        int r12 = 0;
    L14:
        if (r12 >= this.size) goto L19;
        if (this.array[r12] != r11[r12]) goto L17;
        r12 = r12 + 1;
        goto L14
    L17:
        return false;
    L19:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // java.util.AbstractList, java.util.List
    public Integer get(int r8) {
        return Integer.valueOf(getInt(r8));
    }

    @Override // com.google.protobuf.Internal.IntList
    public int getInt(int r8) {
        ensureIndexInRange(r8);
        return this.array[r8];
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int r8 = 1;
        int r10 = 0;
    L4:
        if (r10 >= this.size) goto L6;
        r8 = (r8 * 31) + this.array[r10];
        r10 = r10 + 1;
        goto L4
    L6:
        return r8;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r8) {
        if ((r8 instanceof Integer) == true) goto L5;
        return -1;
    L5:
        int r10 = ((Integer) r8).intValue();
        int r11 = size();
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L11;
        if (this.array[r12] == r10) goto L9;
        r12 = r12 + 1;
        goto L6
    L9:
        return r12;
    L11:
        return -1;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public Internal.ProtobufList<Integer> mutableCopyWithCapacity(int r8) {
        if (r8 < this.size) goto L10;
        if (r8 != 0) goto L6;
        int[] r10 = EMPTY_ARRAY;
    L8:
        return new IntArrayList(r10, this.size, true);
    L6:
        r10 = Arrays.copyOf(this.array, r8);
        goto L8
    L10:
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Integer remove(int r8) {
        ensureIsMutable();
        ensureIndexInRange(r8);
        int[] r10 = this.array;
        int r11 = r10[r8];
        int r12 = this.size;
        if (r8 >= (r12 - 1)) goto L5;
        System.arraycopy(r10, r8 + 1, r10, r8, (r12 - r8) - 1);
    L5:
        this.size--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(r11);
    }

    @Override // java.util.AbstractList
    public void removeRange(int r8, int r10) {
        ensureIsMutable();
        if (r10 < r8) goto L7;
        int[] r11 = this.array;
        System.arraycopy(r11, r10, r11, r8, this.size - r10);
        this.size -= r10 - r8;
        ((AbstractList) this).modCount++;
        return;
    L7:
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public Integer set(int r8, Integer r10) {
        return Integer.valueOf(setInt(r8, r10.intValue()));
    }

    @Override // com.google.protobuf.Internal.IntList
    public int setInt(int r8, int r10) {
        ensureIsMutable();
        ensureIndexInRange(r8);
        int[] r11 = this.array;
        int r12 = r11[r8];
        r11[r8] = r10;
        return r12;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    public IntArrayList(IntArrayList r8, boolean r10) {
        int r11 = r8.size;
        if (r11 != 0) goto L5;
        int[] r12 = EMPTY_ARRAY;
    L6:
        this(r12, r8.size, r10);
        return;
    L5:
        r12 = Arrays.copyOf(r8.array, r11);
        goto L6
    }

    private void addInt(int r8, int r10) {
        ensureIsMutable();
        if (r8 < 0) goto L13;
        int r11 = this.size;
        if (r8 > r11) goto L13;
        int[] r12 = this.array;
        if (r11 >= r12.length) goto L9;
        System.arraycopy(r12, r8, r12, r8 + 1, r11 - r8);
    L10:
        this.array[r8] = r10;
        this.size++;
        ((AbstractList) this).modCount++;
        return;
    L9:
        int[] r13 = new int[growSize(r12.length)];
        System.arraycopy(this.array, 0, r13, 0, r8);
        System.arraycopy(this.array, r8, r13, r8 + 1, this.size - r8);
        this.array = r13;
    L13:
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(r8));
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ void add(int r8, Object r10) {
        add(r8, (Integer) r10);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r8) {
        return get(r8);
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Internal.ProtobufList<Integer> mutableCopyWithCapacity2(int r8) {
        return mutableCopyWithCapacity(r8);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int r8) {
        return remove(r8);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int r8, Object r10) {
        return set(r8, (Integer) r10);
    }

    private IntArrayList(int[] r8, int r10, boolean r11) {
        super(r11);
        this.array = r8;
        this.size = r10;
    }

    public boolean add(Integer r8) {
        addInt(r8.intValue());
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object r8) {
        return add((Integer) r8);
    }
}
