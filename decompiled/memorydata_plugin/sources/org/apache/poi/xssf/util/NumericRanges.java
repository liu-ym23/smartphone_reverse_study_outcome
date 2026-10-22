package org.apache.poi.xssf.util;

/* JADX INFO: loaded from: classes7.dex */
public class NumericRanges {
    public static long[] getOverlappingRange(long[] r6, long[] r7) {
        int r0 = getOverlappingType(r6, r7);
        if (r0 == 0) goto L14;
        if (r0 == 1) goto L12;
        if (r0 != 2) goto L7;
        return r7;
    L7:
        if (r0 != 3) goto L9;
        return r6;
    L9:
        return new long[]{-1, -1};
    L12:
        return new long[]{r6[0], r7[1]};
    L14:
        return new long[]{r7[0], r6[1]};
    }

    public static int getOverlappingType(long[] r9, long[] r10) {
        long r1 = r9[0];
        long r4 = r9[1];
        long r6 = r10[0];
        long r11 = r10[1];
        if (r1 < r6) goto L12;
        if (r4 > r11) goto L9;
        return 3;
    L9:
        if (r1 > r11) goto L18;
        return 1;
    L18:
        return -1;
    L12:
        if (r4 < r11) goto L16;
        return 2;
    L16:
        if (r4 < r6) goto L20;
        return 0;
    L20:
        return -1;
    }
}
