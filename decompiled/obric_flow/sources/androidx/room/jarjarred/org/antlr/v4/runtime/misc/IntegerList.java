package androidx.room.jarjarred.org.antlr.v4.runtime.misc;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class IntegerList {
    private static int[] EMPTY_DATA = null;
    private static final int INITIAL_SIZE = 4;
    private static final int MAX_ARRAY_SIZE = 2147483639;
    private int[] _data;
    private int _size;

    static {
        EMPTY_DATA = new int[0];
    }

    public IntegerList() {
        this._data = EMPTY_DATA;
    }

    private int charArraySize() {
        int r5 = 0;
        int r10 = 0;
    L4:
        if (r5 >= this._size) goto L6;
        r10 = r10 + Character.charCount(this._data[r5]);
        r5 = r5 + 1;
        goto L4
    L6:
        return r10;
    }

    private void ensureCapacity(int r5) {
        if (r5 < 0) goto L17;
        if (r5 > MAX_ARRAY_SIZE) goto L17;
        int[] r10 = this._data;
        if (r10.length != 0) goto L8;
        int r11 = 4;
    L9:
        if (r11 >= r5) goto L14;
        r11 = r11 * 2;
        if (r11 < 0) goto L13;
        if (r11 <= MAX_ARRAY_SIZE) goto L9;
    L13:
        r11 = MAX_ARRAY_SIZE;
        goto L9
    L14:
        this._data = Arrays.copyOf(this._data, r11);
        return;
    L8:
        r11 = r10.length;
    L17:
        throw new OutOfMemoryError();
    }

    public final void add(int r5) {
        int r10 = this._data.length;
        int r11 = this._size;
        if (r10 != r11) goto L5;
        ensureCapacity(r11 + 1);
    L5:
        int[] r12 = this._data;
        int r13 = this._size;
        r12[r13] = r5;
        this._size = r13 + 1;
    }

    public final void addAll(int[] r5) {
        ensureCapacity(this._size + r5.length);
        System.arraycopy(r5, 0, this._data, this._size, r5.length);
        this._size += r5.length;
    }

    public final int binarySearch(int r5) {
        return Arrays.binarySearch(this._data, 0, this._size, r5);
    }

    public final void clear() {
        Arrays.fill(this._data, 0, this._size, 0);
        this._size = 0;
    }

    public final boolean contains(int r5) {
        int r10 = 0;
    L4:
        if (r10 >= this._size) goto L10;
        if (this._data[r10] == r5) goto L7;
        r10 = r10 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof IntegerList) == true) goto L8;
        return false;
    L8:
        IntegerList r11 = (IntegerList) r10;
        if (this._size == r11._size) goto L11;
        return false;
    L11:
        int r5 = 0;
    L13:
        if (r5 >= this._size) goto L18;
        if (this._data[r5] != r11._data[r5]) goto L16;
        r5 = r5 + 1;
        goto L13
    L16:
        return false;
    L18:
        return true;
    }

    public final int get(int r5) {
        if (r5 < 0) goto L8;
        if (r5 >= this._size) goto L8;
        return this._data[r5];
    L8:
        throw new IndexOutOfBoundsException();
    }

    public int hashCode() {
        int r5 = 1;
        int r10 = 0;
    L4:
        if (r10 >= this._size) goto L6;
        r5 = (r5 * 31) + this._data[r10];
        r10 = r10 + 1;
        goto L4
    L6:
        return r5;
    }

    public final boolean isEmpty() {
        if (this._size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final int removeAt(int r5) {
        int r10 = get(r5);
        int[] r11 = this._data;
        System.arraycopy(r11, r5 + 1, r11, r5, (this._size - r5) - 1);
        int[] r12 = this._data;
        int r13 = this._size;
        r12[r13 - 1] = 0;
        this._size = r13 - 1;
        return r10;
    }

    public final void removeRange(int r5, int r10) {
        if (r5 < 0) goto L13;
        if (r10 < 0) goto L13;
        int r11 = this._size;
        if (r5 > r11) goto L13;
        if (r10 > r11) goto L13;
        if (r5 > r10) goto L11;
        int[] r12 = this._data;
        System.arraycopy(r12, r10, r12, r5, r11 - r10);
        int[] r13 = this._data;
        int r14 = this._size;
        int r15 = r10 - r5;
        Arrays.fill(r13, r14 - r15, r14, 0);
        this._size -= r15;
        return;
    L11:
        throw new IllegalArgumentException();
    L13:
        throw new IndexOutOfBoundsException();
    }

    public final int set(int r5, int r10) {
        if (r5 < 0) goto L8;
        if (r5 >= this._size) goto L8;
        int[] r11 = this._data;
        int r12 = r11[r5];
        r11[r5] = r10;
        return r12;
    L8:
        throw new IndexOutOfBoundsException();
    }

    public final int size() {
        return this._size;
    }

    public final void sort() {
        Arrays.sort(this._data, 0, this._size);
    }

    public final int[] toArray() {
        int r5 = this._size;
        if (r5 != 0) goto L7;
        return EMPTY_DATA;
    L7:
        return Arrays.copyOf(this._data, r5);
    }

    public final char[] toCharArray() {
        char[] r5 = new char[this._size];
        int r10 = 0;
        boolean r11 = false;
        int r12 = 0;
    L4:
        if (r10 >= this._size) goto L11;
        int r13 = this._data[r10];
        if (r11 == true) goto L10;
        if (Character.isSupplementaryCodePoint(r13) == false) goto L10;
        r5 = Arrays.copyOf(r5, charArraySize());
        r11 = true;
    L10:
        r12 = r12 + Character.toChars(r13, r5, r12);
        r10 = r10 + 1;
        goto L4
    L11:
        return r5;
    }

    public String toString() {
        return Arrays.toString(toArray());
    }

    public final void trimToSize() {
        int[] r5 = this._data;
        int r10 = r5.length;
        int r11 = this._size;
        if (r10 != r11) goto L5;
        return;
    L5:
        this._data = Arrays.copyOf(r5, r11);
    }

    public final int binarySearch(int r5, int r10, int r11) {
        if (r5 < 0) goto L13;
        if (r10 < 0) goto L13;
        int r12 = this._size;
        if (r5 > r12) goto L13;
        if (r10 > r12) goto L13;
        if (r5 > r10) goto L11;
        return Arrays.binarySearch(this._data, r5, r10, r11);
    L11:
        throw new IllegalArgumentException();
    L13:
        throw new IndexOutOfBoundsException();
    }

    public IntegerList(int r5) {
        if (r5 < 0) goto L9;
        if (r5 != 0) goto L6;
        this._data = EMPTY_DATA;
        return;
    L6:
        this._data = new int[r5];
        return;
    L9:
        throw new IllegalArgumentException();
    }

    public final void addAll(IntegerList r10) {
        ensureCapacity(this._size + r10._size);
        System.arraycopy(r10._data, 0, this._data, this._size, r10._size);
        this._size += r10._size;
    }

    public IntegerList(IntegerList r5) {
        this._data = (int[]) r5._data.clone();
        this._size = r5._size;
    }

    public final void addAll(Collection<Integer> r10) {
        int r5 = this._size;
        ensureCapacity(r10.size() + r5);
        Iterator<Integer> r11 = r10.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        int r13 = r11.next().intValue();
        this._data[this._size + r12] = r13;
        r12 = r12 + 1;
        goto L4
    L6:
        int r14 = this._size;
        this._size = r10.size() + r14;
    }

    public IntegerList(Collection<Integer> r5) {
        this(r5.size());
        Iterator<Integer> r10 = r5.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        add(r10.next().intValue());
        goto L4
    }
}
