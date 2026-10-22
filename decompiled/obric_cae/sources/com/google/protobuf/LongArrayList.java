package com.google.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class LongArrayList extends AbstractProtobufList<Long> implements Internal.LongList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final long[] EMPTY_ARRAY = null;
    private static final LongArrayList EMPTY_LIST = null;
    private long[] array;
    private int size;

    static {
        long[] r8 = new long[0];
        EMPTY_ARRAY = r8;
        EMPTY_LIST = new LongArrayList(r8, 0, false);
    }

    public LongArrayList() {
        this(EMPTY_ARRAY, 0, true);
    }

    private void addLong(int r8, long r10) {
        ensureIsMutable();
        if (r8 < 0) goto L13;
        int r11 = this.size;
        if (r8 > r11) goto L13;
        long[] r12 = this.array;
        if (r11 >= r12.length) goto L9;
        System.arraycopy(r12, r8, r12, r8 + 1, r11 - r8);
    L10:
        this.array[r8] = r10;
        this.size++;
        ((AbstractList) this).modCount++;
        return;
    L9:
        long[] r13 = new long[growSize(r12.length)];
        System.arraycopy(this.array, 0, r13, 0, r8);
        System.arraycopy(this.array, r8, r13, r8 + 1, this.size - r8);
        this.array = r13;
    L13:
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(r8));
    }

    public static LongArrayList emptyList() {
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

    public void add(int r8, Long r10) {
        addLong(r8, r10.longValue());
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Long> r8) {
        ensureIsMutable();
        Internal.checkNotNull(r8);
        if ((r8 instanceof LongArrayList) == false) goto L5;
        LongArrayList r10 = (LongArrayList) r8;
        int r11 = r10.size;
        if (r11 != 0) goto L9;
        return false;
    L9:
        int r12 = this.size;
        if ((Integer.MAX_VALUE - r12) < r11) goto L17;
        int r13 = r12 + r11;
        long[] r14 = this.array;
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

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r8) {
        if (indexOf(r8) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public void ensureCapacity(int r8) {
        long[] r10 = this.array;
        if (r8 > r10.length) goto L6;
        return;
    L6:
        if (r10.length != 0) goto L9;
        this.array = new long[Math.max(r8, 10)];
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
    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof LongArrayList) == false) goto L8;
        LongArrayList r11 = (LongArrayList) r10;
        if (this.size == r11.size) goto L12;
        return false;
    L12:
        long[] r12 = r11.array;
        int r8 = 0;
    L14:
        if (r8 >= this.size) goto L19;
        if (this.array[r8] != r12[r8]) goto L17;
        r8 = r8 + 1;
        goto L14
    L17:
        return false;
    L19:
        return true;
    L8:
        return super.equals(r10);
    }

    @Override // java.util.AbstractList, java.util.List
    public Long get(int r8) {
        return Long.valueOf(getLong(r8));
    }

    @Override // com.google.protobuf.Internal.LongList
    public long getLong(int r8) {
        ensureIndexInRange(r8);
        return this.array[r8];
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int r8 = 1;
        int r10 = 0;
    L4:
        if (r10 >= this.size) goto L6;
        r8 = (r8 * 31) + Internal.hashLong(this.array[r10]);
        r10 = r10 + 1;
        goto L4
    L6:
        return r8;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r8) {
        if ((r8 instanceof Long) == true) goto L5;
        return -1;
    L5:
        long r10 = ((Long) r8).longValue();
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
    public Internal.ProtobufList<Long> mutableCopyWithCapacity(int r8) {
        if (r8 < this.size) goto L10;
        if (r8 != 0) goto L6;
        long[] r10 = EMPTY_ARRAY;
    L8:
        return new LongArrayList(r10, this.size, true);
    L6:
        r10 = Arrays.copyOf(this.array, r8);
        goto L8
    L10:
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Long remove(int r8) {
        ensureIsMutable();
        ensureIndexInRange(r8);
        long[] r10 = this.array;
        long r11 = r10[r8];
        int r12 = this.size;
        if (r8 >= (r12 - 1)) goto L5;
        System.arraycopy(r10, r8 + 1, r10, r8, (r12 - r8) - 1);
    L5:
        this.size--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(r11);
    }

    @Override // java.util.AbstractList
    public void removeRange(int r8, int r10) {
        ensureIsMutable();
        if (r10 < r8) goto L7;
        long[] r11 = this.array;
        System.arraycopy(r11, r10, r11, r8, this.size - r10);
        this.size -= r10 - r8;
        ((AbstractList) this).modCount++;
        return;
    L7:
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public Long set(int r8, Long r10) {
        return Long.valueOf(setLong(r8, r10.longValue()));
    }

    @Override // com.google.protobuf.Internal.LongList
    public long setLong(int r8, long r10) {
        ensureIsMutable();
        ensureIndexInRange(r8);
        long[] r11 = this.array;
        long r12 = r11[r8];
        r11[r8] = r10;
        return r12;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    public LongArrayList(LongArrayList r8, boolean r10) {
        int r11 = r8.size;
        if (r11 != 0) goto L5;
        long[] r12 = EMPTY_ARRAY;
    L6:
        this(r12, r8.size, r10);
        return;
    L5:
        r12 = Arrays.copyOf(r8.array, r11);
        goto L6
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ void add(int r8, Object r10) {
        add(r8, (Long) r10);
    }

    @Override // com.google.protobuf.Internal.LongList
    public void addLong(long r8) {
        ensureIsMutable();
        int r10 = this.size;
        long[] r11 = this.array;
        if (r10 != r11.length) goto L5;
        long[] r12 = new long[growSize(r11.length)];
        System.arraycopy(this.array, 0, r12, 0, this.size);
        this.array = r12;
    L5:
        long[] r13 = this.array;
        int r14 = this.size;
        this.size = r14 + 1;
        r13[r14] = r8;
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r8) {
        return get(r8);
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Internal.ProtobufList<Long> mutableCopyWithCapacity2(int r8) {
        return mutableCopyWithCapacity(r8);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int r8) {
        return remove(r8);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int r8, Object r10) {
        return set(r8, (Long) r10);
    }

    private LongArrayList(long[] r8, int r10, boolean r11) {
        super(r11);
        this.array = r8;
        this.size = r10;
    }

    public boolean add(Long r8) {
        addLong(r8.longValue());
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object r8) {
        return add((Long) r8);
    }
}
