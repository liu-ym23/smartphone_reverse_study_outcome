package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class LongSparseArray<E> implements Cloneable {
    private static final Object DELETED = null;
    private boolean mGarbage;
    private long[] mKeys;
    private int mSize;
    private Object[] mValues;

    static {
        DELETED = new Object();
    }

    public LongSparseArray() {
        this(10);
    }

    public LongSparseArray(int r10) {
        this.mGarbage = false;
        if (r10 != 0) goto L5;
        this.mKeys = ContainerHelpers.EMPTY_LONGS;
        this.mValues = ContainerHelpers.EMPTY_OBJECTS;
        return;
    L5:
        int r11 = ContainerHelpers.idealLongArraySize(r10);
        this.mKeys = new long[r11];
        this.mValues = new Object[r11];
    }

    private void gc() {
        int r10 = this.mSize;
        long[] r11 = this.mKeys;
        Object[] r12 = this.mValues;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r10) goto L10;
        Object r15 = r12[r13];
        if (r15 == DELETED) goto L9;
        if (r13 == r14) goto L8;
        r11[r14] = r11[r13];
        r12[r14] = r15;
        r12[r13] = null;
    L8:
        r14 = r14 + 1;
    L9:
        r13 = r13 + 1;
        goto L3
    L10:
        this.mGarbage = false;
        this.mSize = r14;
    }

    public void append(long r10, E r11) {
        int r12 = this.mSize;
        if (r12 == 0) goto L9;
        if (r10 > this.mKeys[r12 - 1]) goto L9;
        put(r10, r11);
        return;
    L9:
        if (this.mGarbage == true) goto L11;
    L13:
        int r13 = this.mSize;
        if (r13 < this.mKeys.length) goto L16;
        int r14 = ContainerHelpers.idealLongArraySize(r13 + 1);
        long[] r15 = new long[r14];
        Object[] r16 = new Object[r14];
        long[] r17 = this.mKeys;
        System.arraycopy(r17, 0, r15, 0, r17.length);
        Object[] r18 = this.mValues;
        System.arraycopy(r18, 0, r16, 0, r18.length);
        this.mKeys = r15;
        this.mValues = r16;
    L16:
        this.mKeys[r13] = r10;
        this.mValues[r13] = r11;
        this.mSize = r13 + 1;
        return;
    L11:
        if (r12 < this.mKeys.length) goto L13;
        gc();
        goto L13
    }

    public void clear() {
        int r10 = this.mSize;
        Object[] r11 = this.mValues;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        r11[r12] = null;
        r12 = r12 + 1;
        goto L3
    L5:
        this.mSize = 0;
        this.mGarbage = false;
    }

    public LongSparseArray<E> clone() {
        LongSparseArray<E> r10 = (LongSparseArray) super.clone();     // Catch: CloneNotSupportedException -> L4
        r10.mKeys = (long[]) this.mKeys.clone();     // Catch: CloneNotSupportedException -> L4
        r10.mValues = (Object[]) this.mValues.clone();     // Catch: CloneNotSupportedException -> L4
        return r10;
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1clone() {
        return clone();
    }

    public boolean containsKey(long r10) {
        if (indexOfKey(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean containsValue(E r10) {
        if (indexOfValue(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Deprecated
    public void delete(long r10) {
        remove(r10);
    }

    @Nullable
    public E get(long r10) {
        return get(r10, null);
    }

    public E get(long r10, E r11) {
        int r12 = ContainerHelpers.binarySearch(this.mKeys, this.mSize, r10);
        if (r12 < 0) goto L9;
        Object[] r13 = this.mValues;
        if (r13[r12] == DELETED) goto L9;
        return (E) r13[r12];
    L9:
        return r11;
    }

    public int indexOfKey(long r10) {
        if (this.mGarbage == false) goto L6;
        gc();
    L6:
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, r10);
    }

    public int indexOfValue(E r10) {
        if (this.mGarbage == false) goto L5;
        gc();
    L5:
        int r11 = 0;
    L7:
        if (r11 >= this.mSize) goto L12;
        if (this.mValues[r11] == r10) goto L10;
        r11 = r11 + 1;
        goto L7
    L10:
        return r11;
    L12:
        return -1;
    }

    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public long keyAt(int r10) {
        if (this.mGarbage == false) goto L6;
        gc();
    L6:
        return this.mKeys[r10];
    }

    public void put(long r10, E r11) {
        int r12 = ContainerHelpers.binarySearch(this.mKeys, this.mSize, r10);
        if (r12 < 0) goto L5;
        this.mValues[r12] = r11;
        return;
    L5:
        int r13 = ~r12;
        int r14 = this.mSize;
        if (r13 >= r14) goto L12;
        Object[] r15 = this.mValues;
        if (r15[r13] != DELETED) goto L12;
        this.mKeys[r13] = r10;
        r15[r13] = r11;
        return;
    L12:
        if (this.mGarbage == true) goto L14;
    L16:
        int r16 = this.mSize;
        if (r16 < this.mKeys.length) goto L19;
        int r17 = ContainerHelpers.idealLongArraySize(r16 + 1);
        long[] r18 = new long[r17];
        Object[] r19 = new Object[r17];
        long[] r20 = this.mKeys;
        System.arraycopy(r20, 0, r18, 0, r20.length);
        Object[] r21 = this.mValues;
        System.arraycopy(r21, 0, r19, 0, r21.length);
        this.mKeys = r18;
        this.mValues = r19;
    L19:
        int r22 = this.mSize;
        if ((r22 - r13) == 0) goto L22;
        long[] r23 = this.mKeys;
        int r24 = r13 + 1;
        System.arraycopy(r23, r13, r23, r24, r22 - r13);
        Object[] r25 = this.mValues;
        System.arraycopy(r25, r13, r25, r24, this.mSize - r13);
    L22:
        this.mKeys[r13] = r10;
        this.mValues[r13] = r11;
        this.mSize++;
        return;
    L14:
        if (r14 < this.mKeys.length) goto L16;
        gc();
        r13 = ~ContainerHelpers.binarySearch(this.mKeys, this.mSize, r10);
        goto L16
    }

    public void putAll(@NonNull LongSparseArray<? extends E> r10) {
        int r11 = r10.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        put(r10.keyAt(r12), r10.valueAt(r12));
        r12 = r12 + 1;
        goto L3
    }

    @Nullable
    public E putIfAbsent(long r10, E r11) {
        E r12 = get(r10);
        if (r12 != null) goto L5;
        put(r10, r11);
    L5:
        return r12;
    }

    public void remove(long r10) {
        int r11 = ContainerHelpers.binarySearch(this.mKeys, this.mSize, r10);
        if (r11 < 0) goto L8;
        Object[] r12 = this.mValues;
        Object r13 = r12[r11];
        Object r14 = DELETED;
        if (r13 == r14) goto L9;
        r12[r11] = r14;
        this.mGarbage = true;
        return;
    L9:
        return;
    }

    public boolean remove(long r10, Object r11) {
        int r12 = indexOfKey(r10);
        if (r12 < 0) goto L11;
        E r13 = valueAt(r12);
        if (r11 == r13) goto L9;
        if (r11 != null) goto L8;
        return false;
    L8:
        if (r11.equals(r13) == true) goto L9;
        return false;
    L9:
        removeAt(r12);
        return true;
    L11:
        return false;
    }

    public void removeAt(int r10) {
        Object[] r11 = this.mValues;
        Object r12 = r11[r10];
        Object r13 = DELETED;
        if (r12 == r13) goto L6;
        r11[r10] = r13;
        this.mGarbage = true;
        return;
    }

    @Nullable
    public E replace(long r10, E r11) {
        int r12 = indexOfKey(r10);
        if (r12 < 0) goto L6;
        Object[] r13 = this.mValues;
        E r14 = (E) r13[r12];
        r13[r12] = r11;
        return r14;
    L6:
        return null;
    }

    public boolean replace(long r10, E r11, E r12) {
        int r13 = indexOfKey(r10);
        if (r13 < 0) goto L11;
        Object r14 = this.mValues[r13];
        if (r14 == r11) goto L9;
        if (r11 != null) goto L8;
        return false;
    L8:
        if (r11.equals(r14) == true) goto L9;
        return false;
    L9:
        this.mValues[r13] = r12;
        return true;
    L11:
        return false;
    }

    public void setValueAt(int r10, E r11) {
        if (this.mGarbage == false) goto L5;
        gc();
    L5:
        this.mValues[r10] = r11;
    }

    public int size() {
        if (this.mGarbage == false) goto L6;
        gc();
    L6:
        return this.mSize;
    }

    public String toString() {
        if (size() > 0) goto L6;
        return "{}";
    L6:
        StringBuilder r10 = new StringBuilder(this.mSize * 28);
        r10.append('{');
        int r11 = 0;
    L8:
        if (r11 >= this.mSize) goto L16;
        if (r11 <= 0) goto L11;
        r10.append(", ");
    L11:
        r10.append(keyAt(r11));
        r10.append('=');
        E r12 = valueAt(r11);
        if (r12 == this) goto L14;
        r10.append(r12);
    L15:
        r11 = r11 + 1;
        goto L8
    L14:
        r10.append("(this Map)");
        goto L15
    L16:
        r10.append('}');
        return r10.toString();
    }

    public E valueAt(int r10) {
        if (this.mGarbage == false) goto L6;
        gc();
    L6:
        return (E) this.mValues[r10];
    }
}
