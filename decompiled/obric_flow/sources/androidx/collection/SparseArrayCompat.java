package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class SparseArrayCompat<E> implements Cloneable {
    private static final Object DELETED = null;
    private boolean mGarbage;
    private int[] mKeys;
    private int mSize;
    private Object[] mValues;

    static {
        DELETED = new Object();
    }

    public SparseArrayCompat() {
        this(10);
    }

    private void gc() {
        int r5 = this.mSize;
        int[] r10 = this.mKeys;
        Object[] r11 = this.mValues;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r5) goto L10;
        Object r14 = r11[r12];
        if (r14 == DELETED) goto L9;
        if (r12 == r13) goto L8;
        r10[r13] = r10[r12];
        r11[r13] = r14;
        r11[r12] = null;
    L8:
        r13 = r13 + 1;
    L9:
        r12 = r12 + 1;
        goto L3
    L10:
        this.mGarbage = false;
        this.mSize = r13;
    }

    public void append(int r10, E r11) {
        int r5 = this.mSize;
        if (r5 == 0) goto L9;
        if (r10 > this.mKeys[r5 - 1]) goto L9;
        put(r10, r11);
        return;
    L9:
        if (this.mGarbage == true) goto L11;
    L13:
        int r12 = this.mSize;
        if (r12 < this.mKeys.length) goto L16;
        int r13 = ContainerHelpers.idealIntArraySize(r12 + 1);
        int[] r14 = new int[r13];
        Object[] r15 = new Object[r13];
        int[] r16 = this.mKeys;
        System.arraycopy(r16, 0, r14, 0, r16.length);
        Object[] r17 = this.mValues;
        System.arraycopy(r17, 0, r15, 0, r17.length);
        this.mKeys = r14;
        this.mValues = r15;
    L16:
        this.mKeys[r12] = r10;
        this.mValues[r12] = r11;
        this.mSize = r12 + 1;
        return;
    L11:
        if (r5 < this.mKeys.length) goto L13;
        gc();
        goto L13
    }

    public void clear() {
        int r5 = this.mSize;
        Object[] r10 = this.mValues;
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L5;
        r10[r11] = null;
        r11 = r11 + 1;
        goto L3
    L5:
        this.mSize = 0;
        this.mGarbage = false;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m3clone() throws CloneNotSupportedException {
        return clone();
    }

    public boolean containsKey(int r5) {
        if (indexOfKey(r5) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean containsValue(E r5) {
        if (indexOfValue(r5) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Deprecated
    public void delete(int r5) {
        remove(r5);
    }

    @Nullable
    public E get(int r5) {
        return get(r5, null);
    }

    public int indexOfKey(int r5) {
        if (this.mGarbage == false) goto L6;
        gc();
    L6:
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, r5);
    }

    public int indexOfValue(E r5) {
        if (this.mGarbage == false) goto L5;
        gc();
    L5:
        int r10 = 0;
    L7:
        if (r10 >= this.mSize) goto L12;
        if (this.mValues[r10] == r5) goto L10;
        r10 = r10 + 1;
        goto L7
    L10:
        return r10;
    L12:
        return -1;
    }

    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int keyAt(int r5) {
        if (this.mGarbage == false) goto L6;
        gc();
    L6:
        return this.mKeys[r5];
    }

    public void put(int r10, E r11) {
        int r5 = ContainerHelpers.binarySearch(this.mKeys, this.mSize, r10);
        if (r5 < 0) goto L5;
        this.mValues[r5] = r11;
        return;
    L5:
        int r12 = ~r5;
        int r13 = this.mSize;
        if (r12 >= r13) goto L12;
        Object[] r14 = this.mValues;
        if (r14[r12] != DELETED) goto L12;
        this.mKeys[r12] = r10;
        r14[r12] = r11;
        return;
    L12:
        if (this.mGarbage == true) goto L14;
    L16:
        int r15 = this.mSize;
        if (r15 < this.mKeys.length) goto L19;
        int r16 = ContainerHelpers.idealIntArraySize(r15 + 1);
        int[] r17 = new int[r16];
        Object[] r18 = new Object[r16];
        int[] r19 = this.mKeys;
        System.arraycopy(r19, 0, r17, 0, r19.length);
        Object[] r20 = this.mValues;
        System.arraycopy(r20, 0, r18, 0, r20.length);
        this.mKeys = r17;
        this.mValues = r18;
    L19:
        int r21 = this.mSize;
        if ((r21 - r12) == 0) goto L22;
        int[] r22 = this.mKeys;
        int r23 = r12 + 1;
        System.arraycopy(r22, r12, r22, r23, r21 - r12);
        Object[] r24 = this.mValues;
        System.arraycopy(r24, r12, r24, r23, this.mSize - r12);
    L22:
        this.mKeys[r12] = r10;
        this.mValues[r12] = r11;
        this.mSize++;
        return;
    L14:
        if (r13 < this.mKeys.length) goto L16;
        gc();
        r12 = ~ContainerHelpers.binarySearch(this.mKeys, this.mSize, r10);
        goto L16
    }

    public void putAll(@NonNull SparseArrayCompat<? extends E> r5) {
        int r10 = r5.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        put(r5.keyAt(r11), r5.valueAt(r11));
        r11 = r11 + 1;
        goto L3
    }

    @Nullable
    public E putIfAbsent(int r5, E r10) {
        E r11 = get(r5);
        if (r11 != null) goto L5;
        put(r5, r10);
    L5:
        return r11;
    }

    public void remove(int r5) {
        int r10 = ContainerHelpers.binarySearch(this.mKeys, this.mSize, r5);
        if (r10 < 0) goto L8;
        Object[] r11 = this.mValues;
        Object r12 = r11[r10];
        Object r13 = DELETED;
        if (r12 == r13) goto L9;
        r11[r10] = r13;
        this.mGarbage = true;
        return;
    L9:
        return;
    }

    public void removeAt(int r5) {
        Object[] r10 = this.mValues;
        Object r11 = r10[r5];
        Object r12 = DELETED;
        if (r11 == r12) goto L6;
        r10[r5] = r12;
        this.mGarbage = true;
        return;
    }

    public void removeAtRange(int r5, int r10) {
        int r11 = Math.min(this.mSize, r10 + r5);
    L3:
        if (r5 >= r11) goto L5;
        removeAt(r5);
        r5 = r5 + 1;
        goto L3
    }

    @Nullable
    public E replace(int r5, E r10) {
        int r11 = indexOfKey(r5);
        if (r11 < 0) goto L6;
        Object[] r12 = this.mValues;
        E r13 = (E) r12[r11];
        r12[r11] = r10;
        return r13;
    L6:
        return null;
    }

    public void setValueAt(int r5, E r10) {
        if (this.mGarbage == false) goto L5;
        gc();
    L5:
        this.mValues[r5] = r10;
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
        StringBuilder r5 = new StringBuilder(this.mSize * 28);
        r5.append('{');
        int r10 = 0;
    L8:
        if (r10 >= this.mSize) goto L16;
        if (r10 <= 0) goto L11;
        r5.append(", ");
    L11:
        r5.append(keyAt(r10));
        r5.append('=');
        E r11 = valueAt(r10);
        if (r11 == this) goto L14;
        r5.append(r11);
    L15:
        r10 = r10 + 1;
        goto L8
    L14:
        r5.append("(this Map)");
        goto L15
    L16:
        r5.append('}');
        return r5.toString();
    }

    public E valueAt(int r5) {
        if (this.mGarbage == false) goto L6;
        gc();
    L6:
        return (E) this.mValues[r5];
    }

    public SparseArrayCompat(int r5) {
        this.mGarbage = false;
        if (r5 != 0) goto L5;
        this.mKeys = ContainerHelpers.EMPTY_INTS;
        this.mValues = ContainerHelpers.EMPTY_OBJECTS;
        return;
    L5:
        int r10 = ContainerHelpers.idealIntArraySize(r5);
        this.mKeys = new int[r10];
        this.mValues = new Object[r10];
    }

    public SparseArrayCompat<E> clone() {
        SparseArrayCompat<E> r5 = (SparseArrayCompat) super.clone();     // Catch: CloneNotSupportedException -> L4
        r5.mKeys = (int[]) this.mKeys.clone();     // Catch: CloneNotSupportedException -> L4
        r5.mValues = (Object[]) this.mValues.clone();     // Catch: CloneNotSupportedException -> L4
        return r5;
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public E get(int r5, E r10) {
        int r11 = ContainerHelpers.binarySearch(this.mKeys, this.mSize, r5);
        if (r11 < 0) goto L8;
        E r12 = (E) this.mValues[r11];
        if (r12 == DELETED) goto L8;
        return r12;
    L8:
        return r10;
    }

    public boolean replace(int r5, E r10, E r11) {
        int r12 = indexOfKey(r5);
        if (r12 < 0) goto L11;
        Object r13 = this.mValues[r12];
        if (r13 == r10) goto L9;
        if (r10 != null) goto L8;
        return false;
    L8:
        if (r10.equals(r13) == true) goto L9;
        return false;
    L9:
        this.mValues[r12] = r11;
        return true;
    L11:
        return false;
    }

    public boolean remove(int r5, Object r10) {
        int r11 = indexOfKey(r5);
        if (r11 < 0) goto L11;
        E r12 = valueAt(r11);
        if (r10 == r12) goto L9;
        if (r10 != null) goto L8;
        return false;
    L8:
        if (r10.equals(r12) == true) goto L9;
        return false;
    L9:
        removeAt(r11);
        return true;
    L11:
        return false;
    }
}
