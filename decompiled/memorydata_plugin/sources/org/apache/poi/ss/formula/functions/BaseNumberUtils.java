package org.apache.poi.ss.formula.functions;

/* JADX INFO: loaded from: classes7.dex */
public class BaseNumberUtils {
    public static double convertToDecimal(String r17, int r18, int r19) {
        if (r17 != null) goto L5;
    L46:
        return 0.0d;
    L5:
        if (r17.length() == 0) goto L46;
        long r4 = r17.length();
        long r6 = r19;
        if (r4 > r6) goto L45;
        long r5 = 0;
        char[] r7 = r17.toCharArray();
        int r8 = r7.length;
        double r15 = 0.0d;
        int r2 = 0;
        boolean r3 = true;
    L10:
        if (r2 >= r8) goto L35;
        char r11 = r7[r2];
        if ('0' > r11) goto L17;
        if (r11 > '9') goto L17;
        long r12 = ((long) r11) - 48;
    L29:
        if (r12 >= r18) goto L34;
        if (r3 == false) goto L32;
        r5 = r12;
        r3 = false;
    L32:
        r15 = (r15 * ((double) r18)) + r12;
        r2 = r2 + 1;
        goto L10
    L34:
        throw new IllegalArgumentException("character not allowed");
    L17:
        if ('A' > r11) goto L23;
        if (r11 > 'Z') goto L23;
        int r13 = r11 - 'A';
    L21:
        r12 = ((long) r13) + 10;
    L23:
        if ('a' <= r11) goto L25;
    L27:
        r12 = r18;
        goto L29
    L25:
        if (r11 > 'z') goto L27;
        r13 = r11 - 'a';
        goto L21
    L35:
        if (r3 == true) goto L40;
        if (r4 != r6) goto L40;
        if (r5 < (r18 / 2)) goto L40;
        boolean r9 = true;
    L41:
        if (r9 == true) goto L43;
        return r15;
    L43:
        return getTwoComplement(r18, r19, r15) * (-1.0d);
    L40:
        r9 = false;
        goto L41
    L45:
        throw new IllegalArgumentException();
    }

    private static double getTwoComplement(double r0, double r2, double r4) {
        return Math.pow(r0, r2) - r4;
    }
}
