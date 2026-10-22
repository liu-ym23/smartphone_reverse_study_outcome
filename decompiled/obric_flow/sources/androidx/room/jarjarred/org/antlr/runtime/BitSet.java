package androidx.room.jarjarred.org.antlr.runtime;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BitSet implements Cloneable {
    protected static final int BITS = 64;
    protected static final int LOG_BITS = 6;
    protected static final int MOD_MASK = 63;
    protected long[] bits;

    public BitSet() {
        this(64);
    }

    private static final long bitMask(int r5) {
        return 1 << (r5 & 63);
    }

    private final int numWordsToHold(int r5) {
        return (r5 >> 6) + 1;
    }

    public static BitSet of(int r5) {
        BitSet r10 = new BitSet(r5 + 1);
        r10.add(r5);
        return r10;
    }

    private void setSize(int r5) {
        long[] r10 = new long[r5];
        int r11 = Math.min(r5, this.bits.length);
        System.arraycopy(this.bits, 0, r10, 0, r11);
        this.bits = r10;
    }

    private static final int wordNumber(int r5) {
        return r5 >> 6;
    }

    public void add(int r10) {
        int r5 = wordNumber(r10);
        if (r5 < this.bits.length) goto L5;
        growToInclude(r10);
    L5:
        long[] r11 = this.bits;
        r11[r5] = r11[r5] | bitMask(r10);
    }

    public Object clone() {
        BitSet r5 = (BitSet) super.clone();     // Catch: CloneNotSupportedException -> L4
        long[] r10 = new long[this.bits.length];     // Catch: CloneNotSupportedException -> L4
        r5.bits = r10;     // Catch: CloneNotSupportedException -> L4
        long[] r11 = this.bits;     // Catch: CloneNotSupportedException -> L4
        System.arraycopy(r11, 0, r10, 0, r11.length);     // Catch: CloneNotSupportedException -> L4
        return r5;
    L5:
        throw new InternalError();
    }

    public boolean equals(Object r10) {
        if (r10 != null) goto L5;
    L32:
        return false;
    L5:
        if ((r10 instanceof BitSet) == false) goto L32;
        BitSet r11 = (BitSet) r10;
        int r5 = Math.min(this.bits.length, r11.bits.length);
        int r12 = 0;
    L8:
        if (r12 >= r5) goto L14;
        if (this.bits[r12] != r11.bits[r12]) goto L11;
        r12 = r12 + 1;
        goto L8
    L11:
        return false;
    L14:
        if (this.bits.length <= r5) goto L23;
        int r13 = r5 + 1;
    L16:
        long[] r14 = this.bits;
        if (r13 >= r14.length) goto L31;
        if (r14[r13] != 0) goto L20;
        r13 = r13 + 1;
        goto L16
    L20:
        return false;
    L31:
        return true;
    L23:
        if (r11.bits.length <= r5) goto L31;
        int r15 = r5 + 1;
    L25:
        long[] r16 = r11.bits;
        if (r15 >= r16.length) goto L31;
        if (r16[r15] != 0) goto L29;
        r15 = r15 + 1;
        goto L25
    L29:
        return false;
    }

    public void growToInclude(int r5) {
        long[] r10 = new long[Math.max(this.bits.length << 1, numWordsToHold(r5))];
        long[] r11 = this.bits;
        System.arraycopy(r11, 0, r10, 0, r11.length);
        this.bits = r10;
    }

    public boolean isNil() {
        int r5 = this.bits.length - 1;
    L3:
        if (r5 < 0) goto L9;
        if (this.bits[r5] != 0) goto L6;
        r5 = r5 - 1;
        goto L3
    L6:
        return false;
    L9:
        return true;
    }

    public int lengthInLongWords() {
        return this.bits.length;
    }

    public boolean member(int r5) {
        if (r5 >= 0) goto L5;
        return false;
    L5:
        int r10 = wordNumber(r5);
        long[] r11 = this.bits;
        if (r10 < r11.length) goto L8;
        return false;
    L8:
        long r12 = r11[r10];
        if ((bitMask(r5) & r12) == 0) goto L12;
        return true;
    L12:
        return false;
    }

    public int numBits() {
        return this.bits.length << 6;
    }

    public BitSet or(BitSet r5) {
        if (r5 != null) goto L4;
        return this;
    L4:
        BitSet r10 = (BitSet) clone();
        r10.orInPlace(r5);
        return r10;
    }

    public void orInPlace(BitSet r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        long[] r5 = r10.bits;
        if (r5.length <= this.bits.length) goto L7;
        setSize(r5.length);
    L7:
        int r11 = Math.min(this.bits.length, r10.bits.length) - 1;
    L8:
        if (r11 < 0) goto L10;
        long[] r12 = this.bits;
        r12[r11] = r12[r11] | r10.bits[r11];
        r11 = r11 - 1;
        goto L8
    }

    public void remove(int r10) {
        int r5 = wordNumber(r10);
        long[] r11 = this.bits;
        if (r5 >= r11.length) goto L6;
        r11[r5] = r11[r5] & (~bitMask(r10));
        return;
    }

    public int size() {
        int r5 = this.bits.length - 1;
        int r10 = 0;
    L3:
        if (r5 < 0) goto L13;
        long r11 = this.bits[r5];
        if (r11 == 0) goto L12;
        int r12 = 63;
    L7:
        if (r12 < 0) goto L12;
        if (((1 << r12) & r11) == 0) goto L11;
        r10 = r10 + 1;
    L11:
        r12 = r12 - 1;
    L12:
        r5 = r5 - 1;
        goto L3
    L13:
        return r10;
    }

    public int[] toArray() {
        int[] r5 = new int[size()];
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r10 >= (this.bits.length << 6)) goto L9;
        if (member(r10) == false) goto L8;
        r5[r11] = r10;
        r11 = r11 + 1;
    L8:
        r10 = r10 + 1;
        goto L4
    L9:
        return r5;
    }

    public long[] toPackedArray() {
        return this.bits;
    }

    public String toString() {
        return toString(null);
    }

    public BitSet(long[] r5) {
        this.bits = r5;
    }

    public String toString(String[] r5) {
        StringBuilder r10 = new StringBuilder("{");
        int r11 = 0;
        boolean r12 = false;
    L4:
        if (r11 >= (this.bits.length << 6)) goto L15;
        if (member(r11) == false) goto L14;
        if (r11 <= 0) goto L10;
        if (r12 == false) goto L10;
        r10.append(",");
    L10:
        if (r5 == null) goto L12;
        r10.append(r5[r11]);
    L13:
        r12 = true;
        goto L14
    L12:
        r10.append(r11);
    L14:
        r11 = r11 + 1;
        goto L4
    L15:
        r10.append('}');
        return r10.toString();
    }

    public static BitSet of(int r5, int r10) {
        BitSet r11 = new BitSet(Math.max(r5, r10) + 1);
        r11.add(r5);
        r11.add(r10);
        return r11;
    }

    public BitSet(List<Integer> r5) {
        this();
        int r10 = 0;
    L4:
        if (r10 >= r5.size()) goto L6;
        add(r5.get(r10).intValue());
        r10 = r10 + 1;
        goto L4
    }

    public static BitSet of(int r5, int r10, int r11) {
        BitSet r12 = new BitSet();
        r12.add(r5);
        r12.add(r10);
        r12.add(r11);
        return r12;
    }

    public BitSet(int r5) {
        this.bits = new long[((r5 - 1) >> 6) + 1];
    }

    public static BitSet of(int r5, int r10, int r11, int r12) {
        BitSet r13 = new BitSet();
        r13.add(r5);
        r13.add(r10);
        r13.add(r11);
        r13.add(r12);
        return r13;
    }
}
