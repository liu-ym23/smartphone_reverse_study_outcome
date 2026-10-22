package androidx.collection;

/* JADX INFO: loaded from: classes.dex */
class ContainerHelpers {
    static final int[] EMPTY_INTS = null;
    static final long[] EMPTY_LONGS = null;
    static final Object[] EMPTY_OBJECTS = null;

    static {
        EMPTY_INTS = new int[0];
        EMPTY_LONGS = new long[0];
        EMPTY_OBJECTS = new Object[0];
    }

    private ContainerHelpers() {
    }

    static int binarySearch(int[] r10, int r11, int r12) {
        int r13 = r11 - 1;
        int r14 = 0;
    L3:
        if (r14 > r13) goto L11;
        int r15 = (r14 + r13) >>> 1;
        int r16 = r10[r15];
        if (r16 < r12) goto L6;
        if (r16 <= r12) goto L9;
        r13 = r15 - 1;
        goto L3
    L9:
        return r15;
    L6:
        r14 = r15 + 1;
        goto L3
    L11:
        return ~r14;
    }

    static int binarySearch(long[] r10, int r11, long r12) {
        int r13 = r11 - 1;
        int r14 = 0;
    L3:
        if (r14 > r13) goto L11;
        int r15 = (r14 + r13) >>> 1;
        long r16 = r10[r15];
        if (r16 < r12) goto L6;
        if (r16 <= r12) goto L9;
        r13 = r15 - 1;
        goto L3
    L9:
        return r15;
    L6:
        r14 = r15 + 1;
        goto L3
    L11:
        return ~r14;
    }

    public static boolean equal(Object r10, Object r11) {
        if (r10 == r11) goto L8;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.equals(r11) == false) goto L7;
    L8:
        return true;
    }

    public static int idealByteArraySize(int r10) {
        int r11 = 4;
    L4:
        if (r11 >= 32) goto L9;
        int r12 = (1 << r11) - 12;
        if (r10 <= r12) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return r12;
    L9:
        return r10;
    }

    public static int idealIntArraySize(int r10) {
        return idealByteArraySize(r10 * 4) / 4;
    }

    public static int idealLongArraySize(int r10) {
        return idealByteArraySize(r10 * 8) / 8;
    }
}
