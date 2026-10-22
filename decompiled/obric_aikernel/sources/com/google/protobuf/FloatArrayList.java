package com.google.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
final class FloatArrayList extends AbstractProtobufList<Float> implements Internal.FloatList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final float[] EMPTY_ARRAY = null;
    private static final FloatArrayList EMPTY_LIST = null;
    private float[] array;
    private int size;

    static {
        float[] r10 = new float[0];
        EMPTY_ARRAY = r10;
        EMPTY_LIST = new FloatArrayList(r10, 0, false);
    }

    FloatArrayList() {
        this(EMPTY_ARRAY, 0, true);
    }

    private FloatArrayList(float[] r10, int r11, boolean r12) {
        super(r12);
        this.array = r10;
        this.size = r11;
    }

    private void addFloat(int r10, float r11) {
        ensureIsMutable();
        if (r10 < 0) goto L13;
        int r12 = this.size;
        if (r10 > r12) goto L13;
        float[] r13 = this.array;
        if (r12 >= r13.length) goto L9;
        System.arraycopy(r13, r10, r13, r10 + 1, r12 - r10);
    L10:
        this.array[r10] = r11;
        this.size++;
        ((AbstractList) this).modCount++;
        return;
    L9:
        float[] r14 = new float[growSize(r13.length)];
        System.arraycopy(this.array, 0, r14, 0, r10);
        System.arraycopy(this.array, r10, r14, r10 + 1, this.size - r10);
        this.array = r14;
    L13:
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(r10));
    }

    public static FloatArrayList emptyList() {
        return EMPTY_LIST;
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

    public void add(int r10, Float r11) {
        addFloat(r10, r11.floatValue());
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ void add(int r10, Object r11) {
        add(r10, (Float) r11);
    }

    public boolean add(Float r10) {
        addFloat(r10.floatValue());
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object r10) {
        return add((Float) r10);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Float> r10) {
        ensureIsMutable();
        Internal.checkNotNull(r10);
        if ((r10 instanceof FloatArrayList) == false) goto L5;
        FloatArrayList r11 = (FloatArrayList) r10;
        int r12 = r11.size;
        if (r12 != 0) goto L9;
        return false;
    L9:
        int r13 = this.size;
        if ((Integer.MAX_VALUE - r13) < r12) goto L17;
        int r14 = r13 + r12;
        float[] r15 = this.array;
        if (r14 <= r15.length) goto L14;
        this.array = Arrays.copyOf(r15, r14);
    L14:
        System.arraycopy(r11.array, 0, this.array, this.size, r11.size);
        this.size = r14;
        ((AbstractList) this).modCount++;
        return true;
    L17:
        throw new OutOfMemoryError();
    L5:
        return super.addAll(r10);
    }

    @Override // com.google.protobuf.Internal.FloatList
    public void addFloat(float r10) {
        ensureIsMutable();
        int r11 = this.size;
        float[] r12 = this.array;
        if (r11 != r12.length) goto L5;
        float[] r13 = new float[growSize(r12.length)];
        System.arraycopy(this.array, 0, r13, 0, this.size);
        this.array = r13;
    L5:
        float[] r14 = this.array;
        int r15 = this.size;
        this.size = r15 + 1;
        r14[r15] = r10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r10) {
        if (indexOf(r10) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    void ensureCapacity(int r10) {
        float[] r11 = this.array;
        if (r10 > r11.length) goto L6;
        return;
    L6:
        if (r11.length != 0) goto L9;
        this.array = new float[Math.max(r10, 10)];
        return;
    L9:
        int r12 = r11.length;
    L10:
        if (r12 >= r10) goto L12;
        r12 = growSize(r12);
        goto L10
    L12:
        this.array = Arrays.copyOf(this.array, r12);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof FloatArrayList) == false) goto L8;
        FloatArrayList r11 = (FloatArrayList) r10;
        if (this.size == r11.size) goto L12;
        return false;
    L12:
        float[] r12 = r11.array;
        int r13 = 0;
    L14:
        if (r13 >= this.size) goto L19;
        if (Float.floatToIntBits(this.array[r13]) != Float.floatToIntBits(r12[r13])) goto L17;
        r13 = r13 + 1;
        goto L14
    L17:
        return false;
    L19:
        return true;
    L8:
        return super.equals(r10);
    }

    @Override // java.util.AbstractList, java.util.List
    public Float get(int r10) {
        return Float.valueOf(getFloat(r10));
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r10) {
        return get(r10);
    }

    @Override // com.google.protobuf.Internal.FloatList
    public float getFloat(int r10) {
        ensureIndexInRange(r10);
        return this.array[r10];
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int r10 = 1;
        int r11 = 0;
    L4:
        if (r11 >= this.size) goto L6;
        r10 = (r10 * 31) + Float.floatToIntBits(this.array[r11]);
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r10) {
        if ((r10 instanceof Float) == true) goto L5;
        return -1;
    L5:
        float r11 = ((Float) r10).floatValue();
        int r12 = size();
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L11;
        if (this.array[r13] == r11) goto L9;
        r13 = r13 + 1;
        goto L6
    L9:
        return r13;
    L11:
        return -1;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public Internal.ProtobufList<Float> mutableCopyWithCapacity(int r10) {
        if (r10 < this.size) goto L10;
        if (r10 != 0) goto L6;
        float[] r11 = EMPTY_ARRAY;
    L8:
        return new FloatArrayList(r11, this.size, true);
    L6:
        r11 = Arrays.copyOf(this.array, r10);
        goto L8
    L10:
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Internal.ProtobufList<Float> mutableCopyWithCapacity2(int r10) {
        return mutableCopyWithCapacity(r10);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Float remove(int r10) {
        ensureIsMutable();
        ensureIndexInRange(r10);
        float[] r11 = this.array;
        float r12 = r11[r10];
        int r13 = this.size;
        if (r10 >= (r13 - 1)) goto L5;
        System.arraycopy(r11, r10 + 1, r11, r10, (r13 - r10) - 1);
    L5:
        this.size--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(r12);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int r10) {
        return remove(r10);
    }

    @Override // java.util.AbstractList
    protected void removeRange(int r10, int r11) {
        ensureIsMutable();
        if (r11 < r10) goto L7;
        float[] r12 = this.array;
        System.arraycopy(r12, r11, r12, r10, this.size - r11);
        this.size -= r11 - r10;
        ((AbstractList) this).modCount++;
        return;
    L7:
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public Float set(int r10, Float r11) {
        return Float.valueOf(setFloat(r10, r11.floatValue()));
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int r10, Object r11) {
        return set(r10, (Float) r11);
    }

    @Override // com.google.protobuf.Internal.FloatList
    public float setFloat(int r10, float r11) {
        ensureIsMutable();
        ensureIndexInRange(r10);
        float[] r12 = this.array;
        float r13 = r12[r10];
        r12[r10] = r11;
        return r13;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }
}
