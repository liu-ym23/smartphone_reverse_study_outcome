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

    public static int binarySearch(int[] r5, int r10, int r11) {
        int r12 = r10 - 1;
        int r13 = 0;
    L3:
        if (r13 > r12) goto L11;
        int r14 = (r13 + r12) >>> 1;
        int r15 = r5[r14];
        if (r15 < r11) goto L6;
        if (r15 <= r11) goto L9;
        r12 = r14 - 1;
        goto L3
    L9:
        return r14;
    L6:
        r13 = r14 + 1;
        goto L3
    L11:
        return ~r13;
    }

    public static boolean equal(Object r5, Object r10) {
        if (r5 == r10) goto L8;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.equals(r10) == false) goto L7;
    L8:
        return true;
    }

    public static int idealByteArraySize(int r5) {
        int r10 = 4;
    L4:
        if (r10 >= 32) goto L9;
        int r11 = (1 << r10) - 12;
        if (r5 <= r11) goto L7;
        r10 = r10 + 1;
        goto L4
    L7:
        return r11;
    L9:
        return r5;
    }

    public static int idealIntArraySize(int r5) {
        return idealByteArraySize(r5 * 4) / 4;
    }

    public static int idealLongArraySize(int r5) {
        return idealByteArraySize(r5 * 8) / 8;
    }

    public static int binarySearch(long[] r5, int r10, long r11) {
        int r12 = r10 - 1;
        int r13 = 0;
    L3:
        if (r13 > r12) goto L11;
        int r14 = (r13 + r12) >>> 1;
        long r15 = r5[r14];
        if (r15 < r11) goto L6;
        if (r15 <= r11) goto L9;
        r12 = r14 - 1;
        goto L3
    L9:
        return r14;
    L6:
        r13 = r14 + 1;
        goto L3
    L11:
        return ~r13;
    }
}
