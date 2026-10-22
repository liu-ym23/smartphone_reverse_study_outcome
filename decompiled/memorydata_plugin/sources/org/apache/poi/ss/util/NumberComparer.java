package org.apache.poi.ss.util;

import com.ttnet.org.chromium.net.NetError;
import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
public final class NumberComparer {
    public static int compare(double r7, double r9) {
        long r0 = Double.doubleToLongBits(r7);
        long r10 = Double.doubleToLongBits(r9);
        int r2 = IEEEDouble.getBiasedExponent(r0);
        int r3 = IEEEDouble.getBiasedExponent(r10);
        if (r2 == 2047) goto L43;
        if (r3 == 2047) goto L41;
        if (r0 >= 0) goto L8;
        boolean r4 = true;
    L10:
        if (r10 >= 0) goto L12;
        boolean r8 = true;
    L13:
        if (r4 == r8) goto L17;
        if (r4 == false) goto L44;
        return -1;
    L44:
        return 1;
    L17:
        int r11 = r2 - r3;
        int r12 = Math.abs(r11);
        if (r12 <= 1) goto L22;
        if (r4 == true) goto L21;
        return r11;
    L21:
        return -r11;
    L22:
        if (r12 != 1) goto L25;
    L27:
        if (r2 != 0) goto L33;
        if (r3 != 0) goto L32;
        return compareSubnormalNumbers(r0 & 4503599627370495L, 4503599627370495L & r10, r4);
    L32:
        return -compareAcrossSubnormalThreshold(r10, r0, r4);
    L33:
        if (r3 == 0) goto L35;
        int r13 = ExpandedDouble.fromRawBitsAndExponent(r0, r2 + NetError.ERR_BT_FRAME_CODEC_ERROR).normaliseBaseTen().roundUnits().compareNormalised(ExpandedDouble.fromRawBitsAndExponent(r10, r3 + NetError.ERR_BT_FRAME_CODEC_ERROR).normaliseBaseTen().roundUnits());
        if (r4 == true) goto L39;
        return r13;
    L39:
        return -r13;
    L35:
        return compareAcrossSubnormalThreshold(r0, r10, r4);
    L25:
        if (r0 != r10) goto L27;
        return 0;
    L12:
        r8 = false;
        goto L13
    L8:
        r4 = false;
        goto L10
    L41:
        throw new IllegalArgumentException("Special double values are not allowed: " + toHex(r7));
    L43:
        throw new IllegalArgumentException("Special double values are not allowed: " + toHex(r7));
    }

    private static int compareAcrossSubnormalThreshold(long r5, long r7, boolean r9) {
        long r8 = r7 & 4503599627370495L;
        if (r8 != 0) goto L8;
        if (r9 == false) goto L7;
        return -1;
    L7:
        return 1;
    L8:
        long r6 = r5 & 4503599627370495L;
        if (r6 <= 7) goto L11;
    L19:
        if (r9 == false) goto L22;
        return -1;
    L22:
        return 1;
    L11:
        if (r8 < 4503599627370490L) goto L19;
        if (r6 != 7) goto L16;
        if (r8 != 4503599627370490L) goto L16;
        return 0;
    L16:
        if (r9 == true) goto L18;
        return -1;
    L18:
        return 1;
    }

    private static int compareSubnormalNumbers(long r0, long r2, boolean r4) {
        if (r4 == false) goto L6;
        return Long.compare(r2, r0);
    L6:
        return Long.compare(r0, r2);
    }

    private static String toHex(double r2) {
        return "0x" + Long.toHexString(Double.doubleToLongBits(r2)).toUpperCase(Locale.ROOT);
    }
}
