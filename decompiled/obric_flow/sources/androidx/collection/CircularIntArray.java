package androidx.collection;

/* JADX INFO: loaded from: classes.dex */
public final class CircularIntArray {
    private int mCapacityBitmask;
    private int[] mElements;
    private int mHead;
    private int mTail;

    public CircularIntArray() {
        this(8);
    }

    private void doubleCapacity() {
        int[] r5 = this.mElements;
        int r10 = r5.length;
        int r11 = this.mHead;
        int r12 = r10 - r11;
        int r13 = r10 << 1;
        if (r13 < 0) goto L7;
        int[] r14 = new int[r13];
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

    public void addFirst(int r5) {
        int r10 = (this.mHead - 1) & this.mCapacityBitmask;
        this.mHead = r10;
        this.mElements[r10] = r5;
        if (r10 != this.mTail) goto L6;
        doubleCapacity();
        return;
    }

    public void addLast(int r5) {
        int[] r10 = this.mElements;
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
        this.mTail = this.mHead;
    }

    public int get(int r5) {
        if (r5 < 0) goto L8;
        if (r5 >= size()) goto L8;
        int[] r10 = this.mElements;
        int r11 = this.mHead + r5;
        return r10[this.mCapacityBitmask & r11];
    L8:
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getFirst() {
        int r5 = this.mHead;
        if (r5 == this.mTail) goto L7;
        return this.mElements[r5];
    L7:
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getLast() {
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

    public int popFirst() {
        int r5 = this.mHead;
        if (r5 == this.mTail) goto L7;
        int r10 = this.mElements[r5];
        this.mHead = (r5 + 1) & this.mCapacityBitmask;
        return r10;
    L7:
        throw new ArrayIndexOutOfBoundsException();
    }

    public int popLast() {
        int r5 = this.mHead;
        int r10 = this.mTail;
        if (r5 == r10) goto L7;
        int r11 = this.mCapacityBitmask & (r10 - 1);
        int r12 = this.mElements[r11];
        this.mTail = r11;
        return r12;
    L7:
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromEnd(int r5) {
        if (r5 > 0) goto L5;
        return;
    L5:
        if (r5 > size()) goto L9;
        int r10 = this.mTail - r5;
        this.mTail = this.mCapacityBitmask & r10;
        return;
    L9:
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromStart(int r5) {
        if (r5 > 0) goto L5;
        return;
    L5:
        if (r5 > size()) goto L9;
        int r10 = this.mHead + r5;
        this.mHead = this.mCapacityBitmask & r10;
        return;
    L9:
        throw new ArrayIndexOutOfBoundsException();
    }

    public int size() {
        int r5 = this.mTail - this.mHead;
        return this.mCapacityBitmask & r5;
    }

    public CircularIntArray(int r5) {
        if (r5 < 1) goto L14;
        if (r5 > 1073741824) goto L12;
        if (Integer.bitCount(r5) == 1) goto L9;
        r5 = Integer.highestOneBit(r5 - 1) << 1;
    L9:
        this.mCapacityBitmask = r5 - 1;
        this.mElements = new int[r5];
        return;
    L12:
        throw new IllegalArgumentException("capacity must be <= 2^30");
    L14:
        throw new IllegalArgumentException("capacity must be >= 1");
    }
}
