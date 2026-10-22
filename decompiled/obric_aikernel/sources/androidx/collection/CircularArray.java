package androidx.collection;

/* JADX INFO: loaded from: classes.dex */
public final class CircularArray<E> {
    private int mCapacityBitmask;
    private E[] mElements;
    private int mHead;
    private int mTail;

    public CircularArray() {
        this(8);
    }

    public CircularArray(int r10) {
        if (r10 < 1) goto L14;
        if (r10 > 1073741824) goto L12;
        if (Integer.bitCount(r10) == 1) goto L9;
        r10 = Integer.highestOneBit(r10 - 1) << 1;
    L9:
        this.mCapacityBitmask = r10 - 1;
        this.mElements = (E[]) new Object[r10];
        return;
    L12:
        throw new IllegalArgumentException("capacity must be <= 2^30");
    L14:
        throw new IllegalArgumentException("capacity must be >= 1");
    }

    private void doubleCapacity() {
        E[] r10 = this.mElements;
        int r11 = r10.length;
        int r12 = this.mHead;
        int r13 = r11 - r12;
        int r14 = r11 << 1;
        if (r14 < 0) goto L7;
        E[] r15 = (E[]) new Object[r14];
        System.arraycopy(r10, r12, r15, 0, r13);
        System.arraycopy(this.mElements, 0, r15, r13, this.mHead);
        this.mElements = r15;
        this.mHead = 0;
        this.mTail = r11;
        this.mCapacityBitmask = r14 - 1;
        return;
    L7:
        throw new RuntimeException("Max array capacity exceeded");
    }

    public void addFirst(E r10) {
        int r11 = (this.mHead - 1) & this.mCapacityBitmask;
        this.mHead = r11;
        this.mElements[r11] = r10;
        if (r11 != this.mTail) goto L6;
        doubleCapacity();
        return;
    }

    public void addLast(E r10) {
        E[] r11 = this.mElements;
        int r12 = this.mTail;
        r11[r12] = r10;
        int r13 = this.mCapacityBitmask;
        int r14 = r13 & (r12 + 1);
        this.mTail = r14;
        if (r14 != this.mHead) goto L6;
        doubleCapacity();
        return;
    }

    public void clear() {
        removeFromStart(size());
    }

    public E get(int r10) {
        if (r10 < 0) goto L8;
        if (r10 >= size()) goto L8;
        E[] r11 = this.mElements;
        int r12 = this.mHead + r10;
        return r11[this.mCapacityBitmask & r12];
    L8:
        throw new ArrayIndexOutOfBoundsException();
    }

    public E getFirst() {
        int r10 = this.mHead;
        if (r10 == this.mTail) goto L7;
        return this.mElements[r10];
    L7:
        throw new ArrayIndexOutOfBoundsException();
    }

    public E getLast() {
        int r10 = this.mHead;
        int r11 = this.mTail;
        if (r10 == r11) goto L7;
        return this.mElements[this.mCapacityBitmask & (r11 - 1)];
    L7:
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        if (this.mHead != this.mTail) goto L5;
        return true;
    L5:
        return false;
    }

    public E popFirst() {
        int r10 = this.mHead;
        if (r10 == this.mTail) goto L7;
        E[] r11 = this.mElements;
        E r12 = r11[r10];
        r11[r10] = null;
        this.mHead = (r10 + 1) & this.mCapacityBitmask;
        return r12;
    L7:
        throw new ArrayIndexOutOfBoundsException();
    }

    public E popLast() {
        int r10 = this.mHead;
        int r11 = this.mTail;
        if (r10 == r11) goto L7;
        int r12 = this.mCapacityBitmask & (r11 - 1);
        E[] r13 = this.mElements;
        E r14 = r13[r12];
        r13[r12] = null;
        this.mTail = r12;
        return r14;
    L7:
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromEnd(int r10) {
        if (r10 > 0) goto L5;
        return;
    L5:
        if (r10 > size()) goto L22;
        int r11 = 0;
        int r12 = this.mTail;
        if (r10 >= r12) goto L9;
        r11 = r12 - r10;
    L9:
        int r13 = r11;
    L10:
        int r14 = this.mTail;
        if (r13 >= r14) goto L13;
        this.mElements[r13] = null;
        r13 = r13 + 1;
        goto L10
    L13:
        int r15 = r14 - r11;
        int r16 = r10 - r15;
        this.mTail = r14 - r15;
        if (r16 <= 0) goto L25;
        int r17 = this.mElements.length;
        this.mTail = r17;
        int r18 = r17 - r16;
        int r19 = r18;
    L17:
        if (r19 >= this.mTail) goto L19;
        this.mElements[r19] = null;
        r19 = r19 + 1;
        goto L17
    L19:
        this.mTail = r18;
        return;
    L25:
        return;
    L22:
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromStart(int r10) {
        if (r10 > 0) goto L5;
        return;
    L5:
        if (r10 > size()) goto L20;
        int r11 = this.mElements.length;
        int r12 = this.mHead;
        if (r10 >= (r11 - r12)) goto L10;
        r11 = r12 + r10;
    L10:
        if (r12 >= r11) goto L12;
        this.mElements[r12] = null;
        r12 = r12 + 1;
        goto L10
    L12:
        int r13 = this.mHead;
        int r14 = r11 - r13;
        int r15 = r10 - r14;
        int r16 = r13 + r14;
        this.mHead = this.mCapacityBitmask & r16;
        if (r15 <= 0) goto L24;
        int r17 = 0;
    L15:
        if (r17 >= r15) goto L17;
        this.mElements[r17] = null;
        r17 = r17 + 1;
        goto L15
    L17:
        this.mHead = r15;
        return;
    L24:
        return;
    L20:
        throw new ArrayIndexOutOfBoundsException();
    }

    public int size() {
        int r10 = this.mTail - this.mHead;
        return this.mCapacityBitmask & r10;
    }
}
