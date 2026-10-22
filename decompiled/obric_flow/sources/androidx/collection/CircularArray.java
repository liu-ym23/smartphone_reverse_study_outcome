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

    private void doubleCapacity() {
        E[] r5 = this.mElements;
        int r10 = r5.length;
        int r11 = this.mHead;
        int r12 = r10 - r11;
        int r13 = r10 << 1;
        if (r13 < 0) goto L7;
        E[] r14 = (E[]) new Object[r13];
        System.arraycopy(r5, r11, r14, 0, r12);
        System.arraycopy(this.mElements, 0, r14, r12, this.mHead);
        this.mElements = r14;
        this.mHead = 0;
        this.mTail = r10;
        this.mCapacityBitmask = r13 - 1;
        return;
    L7:
        throw new RuntimeException("Max array capacity exceeded");
    }

    public void addFirst(E r5) {
        int r10 = (this.mHead - 1) & this.mCapacityBitmask;
        this.mHead = r10;
        this.mElements[r10] = r5;
        if (r10 != this.mTail) goto L6;
        doubleCapacity();
        return;
    }

    public void addLast(E r5) {
        E[] r10 = this.mElements;
        int r11 = this.mTail;
        r10[r11] = r5;
        int r12 = this.mCapacityBitmask;
        int r13 = r12 & (r11 + 1);
        this.mTail = r13;
        if (r13 != this.mHead) goto L6;
        doubleCapacity();
        return;
    }

    public void clear() {
        removeFromStart(size());
    }

    public E get(int r5) {
        if (r5 < 0) goto L8;
        if (r5 >= size()) goto L8;
        E[] r10 = this.mElements;
        int r11 = this.mHead + r5;
        return r10[this.mCapacityBitmask & r11];
    L8:
        throw new ArrayIndexOutOfBoundsException();
    }

    public E getFirst() {
        int r5 = this.mHead;
        if (r5 == this.mTail) goto L7;
        return this.mElements[r5];
    L7:
        throw new ArrayIndexOutOfBoundsException();
    }

    public E getLast() {
        int r5 = this.mHead;
        int r10 = this.mTail;
        if (r5 == r10) goto L7;
        return this.mElements[this.mCapacityBitmask & (r10 - 1)];
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
        int r5 = this.mHead;
        if (r5 == this.mTail) goto L7;
        E[] r10 = this.mElements;
        E r11 = r10[r5];
        r10[r5] = null;
        this.mHead = (r5 + 1) & this.mCapacityBitmask;
        return r11;
    L7:
        throw new ArrayIndexOutOfBoundsException();
    }

    public E popLast() {
        int r5 = this.mHead;
        int r10 = this.mTail;
        if (r5 == r10) goto L7;
        int r11 = this.mCapacityBitmask & (r10 - 1);
        E[] r12 = this.mElements;
        E r13 = r12[r11];
        r12[r11] = null;
        this.mTail = r11;
        return r13;
    L7:
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromEnd(int r5) {
        if (r5 > 0) goto L5;
        return;
    L5:
        if (r5 > size()) goto L23;
        int r10 = this.mTail;
        if (r5 >= r10) goto L9;
        int r11 = r10 - r5;
    L10:
        int r12 = r11;
    L11:
        int r13 = this.mTail;
        if (r12 >= r13) goto L14;
        this.mElements[r12] = null;
        r12 = r12 + 1;
        goto L11
    L14:
        int r14 = r13 - r11;
        int r15 = r5 - r14;
        this.mTail = r13 - r14;
        if (r15 <= 0) goto L26;
        int r16 = this.mElements.length;
        this.mTail = r16;
        int r17 = r16 - r15;
        int r18 = r17;
    L18:
        if (r18 >= this.mTail) goto L20;
        this.mElements[r18] = null;
        r18 = r18 + 1;
        goto L18
    L20:
        this.mTail = r17;
        return;
    L26:
        return;
    L9:
        r11 = 0;
        goto L10
    L23:
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromStart(int r5) {
        if (r5 > 0) goto L5;
        return;
    L5:
        if (r5 > size()) goto L20;
        int r10 = this.mElements.length;
        int r11 = this.mHead;
        if (r5 >= (r10 - r11)) goto L10;
        r10 = r11 + r5;
    L10:
        if (r11 >= r10) goto L12;
        this.mElements[r11] = null;
        r11 = r11 + 1;
        goto L10
    L12:
        int r12 = this.mHead;
        int r13 = r10 - r12;
        int r14 = r5 - r13;
        int r15 = r12 + r13;
        this.mHead = this.mCapacityBitmask & r15;
        if (r14 <= 0) goto L24;
        int r16 = 0;
    L15:
        if (r16 >= r14) goto L17;
        this.mElements[r16] = null;
        r16 = r16 + 1;
        goto L15
    L17:
        this.mHead = r14;
        return;
    L24:
        return;
    L20:
        throw new ArrayIndexOutOfBoundsException();
    }

    public int size() {
        int r5 = this.mTail - this.mHead;
        return this.mCapacityBitmask & r5;
    }

    public CircularArray(int r5) {
        if (r5 < 1) goto L14;
        if (r5 > 1073741824) goto L12;
        if (Integer.bitCount(r5) == 1) goto L9;
        r5 = Integer.highestOneBit(r5 - 1) << 1;
    L9:
        this.mCapacityBitmask = r5 - 1;
        this.mElements = (E[]) new Object[r5];
        return;
    L12:
        throw new IllegalArgumentException("capacity must be <= 2^30");
    L14:
        throw new IllegalArgumentException("capacity must be >= 1");
    }
}
