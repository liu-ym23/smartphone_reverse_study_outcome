package com.bytedance.bdlocation.utils;

import android.aimedia.a;
import com.obric.cae.smartNetwork.netAccel.AccelMetric;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class RandomStringUtil {
    private static final Random RANDOM = null;

    static {
        RANDOM = new Random();
    }

    private RandomStringUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static int nextInt(int r8, int r10) {
        if (r10 < r8) goto L11;
        if (r8 < 0) goto L9;
        if (r8 != r10) goto L7;
        return r8;
    L7:
        return RANDOM.nextInt(r10 - r8) + r8;
    L9:
        throw new IllegalArgumentException("Both range values must be non-negative.");
    L11:
        throw new IllegalArgumentException("Start value must be smaller or equal to end value.");
    }

    public static String random(int r8) {
        return random(r8, false, false);
    }

    public static String randomAlphabetic(int r8) {
        return random(r8, true, false);
    }

    public static String randomAlphanumeric(int r8) {
        return random(r8, true, true);
    }

    public static String randomAscii(int r8) {
        return random(r8, 32, QesdkUtils.LIMITS.INT_8_UPPER, false, false);
    }

    public static String randomGraph(int r8) {
        return random(r8, 33, 126, false, false);
    }

    public static String randomNumeric(int r8) {
        return random(r8, false, true);
    }

    public static String randomPrint(int r8) {
        return random(r8, 32, 126, false, false);
    }

    public static String random(int r8, int r10, int r11, boolean r12, boolean r13) {
        return random(r8, r10, r11, r12, r13, null, RANDOM);
    }

    public static String randomAlphabetic(int r8, int r10) {
        return randomAlphabetic(nextInt(r8, r10));
    }

    public static String randomAlphanumeric(int r8, int r10) {
        return randomAlphanumeric(nextInt(r8, r10));
    }

    public static String randomAscii(int r8, int r10) {
        return randomAscii(nextInt(r8, r10));
    }

    public static String randomGraph(int r8, int r10) {
        return randomGraph(nextInt(r8, r10));
    }

    public static String randomNumeric(int r8, int r10) {
        return randomNumeric(nextInt(r8, r10));
    }

    public static String randomPrint(int r8, int r10) {
        return randomPrint(nextInt(r8, r10));
    }

    public static String random(int r8, int r10, int r11, boolean r12, boolean r13, char... r14) {
        return random(r8, r10, r11, r12, r13, r14, RANDOM);
    }

    public static String random(int r8, int r10, int r11, boolean r12, boolean r13, char[] r14, Random r15) {
        if (r8 != 0) goto L5;
        return "";
    L5:
        if (r8 < 0) goto L68;
        if (r14 == null) goto L13;
        if (r14.length != 0) goto L13;
        throw new IllegalArgumentException("The chars array must not be empty");
    L13:
        if (r10 != 0) goto L21;
        if (r11 != 0) goto L21;
        if (r14 == null) goto L17;
        r11 = r14.length;
    L22:
        if (r14 != null) goto L32;
        if (r13 == true) goto L25;
    L26:
        if (r12 == false) goto L32;
        if (r11 > 65) goto L32;
    L31:
        throw new IllegalArgumentException(a.c("Parameter end (", r11, ") must be greater then (48) for generating digits or greater then (65) for generating letters."));
    L25:
        if (r11 <= 48) goto L31;
    L32:
        StringBuilder r16 = new StringBuilder(r8);
        int r17 = r11 - r10;
    L33:
        int r18 = r8 - 1;
        if (r8 == 0) goto L64;
        int r19 = r15.nextInt(r17) + r10;
        if (r14 != null) goto L44;
        int r20 = Character.getType(r19);
        if (r20 == 0) goto L49;
        if (r20 == 18) goto L49;
        int r21 = r19;
        if (r20 == 19) goto L49;
    L45:
        int r22 = Character.charCount(r21);
        if (r18 != 0) goto L50;
        if (r22 > 1) goto L49;
    L50:
        if (r12 == true) goto L52;
    L53:
        if (r13 == true) goto L55;
    L56:
        if (r12 == true) goto L62;
        if (r13 == true) goto L62;
    L58:
        r16.appendCodePoint(r21);
        if (r22 != 2) goto L61;
        r18 = r18 - 1;
    L61:
        r8 = r18;
    L62:
        r18 = r18 + 1;
        goto L61
    L55:
        if (Character.isDigit(r21) == true) goto L58;
    L52:
        if (Character.isLetter(r21) == true) goto L58;
    L49:
        r8 = r18 + 1;
        goto L33
    L44:
        r21 = r14[r19];
        goto L45
    L64:
        return r16.toString();
    L17:
        if (r12 == true) goto L20;
        if (r13 == true) goto L20;
        r11 = 1114111;
    L20:
        r11 = AccelMetric.CAE_MULTI_NET_ACCEL_EVENT_FEATURE_ID;
        r10 = 32;
    L21:
        if (r11 > r10) goto L22;
        throw new IllegalArgumentException("Parameter end (" + r11 + ") must be greater than start (" + r10 + ")");
    L68:
        throw new IllegalArgumentException(a.c("Requested random string length ", r8, " is less than 0."));
    }

    public static String random(int r8, String r10) {
        if (r10 != null) goto L6;
        return random(r8, 0, 0, false, false, null, RANDOM);
    L6:
        return random(r8, r10.toCharArray());
    }

    public static String random(int r8, boolean r10, boolean r11) {
        return random(r8, 0, 0, r10, r11);
    }

    public static String random(int r8, char... r10) {
        if (r10 != null) goto L7;
        int r11 = 0;
        boolean r12 = false;
        boolean r13 = false;
        char[] r14 = null;
        Random r15 = RANDOM;
    L6:
        return random(r8, 0, r11, r12, r13, r14, r15);
    L7:
        r11 = r10.length;
        r12 = false;
        r13 = false;
        r15 = RANDOM;
        r14 = r10;
        goto L6
    }
}
