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

    public CircularIntArray(int r10) {
        if (r10 < 1) goto L14;
        if (r10 > 1073741824) goto L12;
        if (Integer.bitCount(r10) == 1) goto L9;
        r10 = Integer.highestOneBit(r10 - 1) << 1;
    L9:
        this.mCapacityBitmask = r10 - 1;
        this.mElements = new int[r10];
        return;
    L12:
        throw new IllegalArgumentException("capacity must be <= 2^30");
    L14:
        throw new IllegalArgumentException("capacity must be >= 1");
    }

    private void doubleCapacity() {
        int[] r10 = this.mElements;
        int r11 = r10.length;
        int r12 = this.mHead;
        int r13 = r11 - r12;
        int r14 = r11 << 1;
        if (r14 < 0) goto L7;
        int[] r15 = new int[r14];
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

    public void addFirst(int r10) {
        int r11 = (this.mHead - 1) & this.mCapacityBitmask;
        this.mHead = r11;
        this.mElements[r11] = r10;
        if (r11 != this.mTail) goto L6;
        doubleCapacity();
        return;
    }

    public void addLast(int r10) {
        int[] r11 = this.mElements;
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
        this.mTail = this.mHead;
    }

    public int get(int r10) {
        if (r10 < 0) goto L8;
        if (r10 >= size()) goto L8;
        int[] r11 = this.mElements;
        int r12 = this.mHead + r10;
        return r11[this.mCapacityBitmask & r12];
    L8:
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getFirst() {
        int r10 = this.mHead;
        if (r10 == this.mTail) goto L7;
        return this.mElements[r10];
    L7:
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getLast() {
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

    public int popFirst() {
        int r10 = this.mHead;
        if (r10 == this.mTail) goto L7;
        int r11 = this.mElements[r10];
        this.mHead = (r10 + 1) & this.mCapacityBitmask;
        return r11;
    L7:
        throw new ArrayIndexOutOfBoundsException();
    }

    public int popLast() {
        int r10 = this.mHead;
        int r11 = this.mTail;
        if (r10 == r11) goto L7;
        int r12 = this.mCapacityBitmask & (r11 - 1);
        int r13 = this.mElements[r12];
        this.mTail = r12;
        return r13;
    L7:
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromEnd(int r10) {
        if (r10 > 0) goto L5;
        return;
    L5:
        if (r10 > size()) goto L9;
        int r11 = this.mTail - r10;
        this.mTail = this.mCapacityBitmask & r11;
        return;
    L9:
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromStart(int r10) {
        if (r10 > 0) goto L5;
        return;
    L5:
        if (r10 > size()) goto L9;
        int r11 = this.mHead + r10;
        this.mHead = this.mCapacityBitmask & r11;
        return;
    L9:
        throw new ArrayIndexOutOfBoundsException();
    }

    public int size() {
        int r10 = this.mTail - this.mHead;
        return this.mCapacityBitmask & r10;
    }
}
