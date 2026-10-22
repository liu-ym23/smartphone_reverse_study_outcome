package org.apache.poi.hssf.util;

/* JADX INFO: loaded from: classes7.dex */
public final class RKUtil {
    public static double decodeNumber(int r4) {
        long r0 = ((long) r4) >> 2;
        if ((r4 & 2) != 2) goto L5;
        double r1 = r0;
    L7:
        if ((r4 & 1) == 1) goto L9;
        return r1;
    L9:
        return r1 / 100.0d;
    L5:
        r1 = Double.longBitsToDouble(r0 << 34);
        goto L7
    }
}
