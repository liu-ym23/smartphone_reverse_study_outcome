package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes2.dex */
public class MathUtils {
    public static final float EPSILON = 0.001f;

    private MathUtils() {
    }

    public static boolean areFloatsEqual(float r10, float r11) {
        if (Math.abs(r10 - r11) >= 0.001f) goto L5;
        return true;
    L5:
        return false;
    }

    public static float clamp(float r10, float r11, float r12) {
        if (r11 <= r12) goto L5;
        float r13 = r12;
    L6:
        if (r11 > r12) goto L10;
        r11 = r12;
    L10:
        if (r10 >= r13) goto L13;
        return r13;
    L13:
        if (r10 > r11) goto L15;
        return r10;
    L15:
        return r11;
    L5:
        r13 = r11;
        goto L6
    }

    public static int clamp(int r10, int r11, int r12) {
        if (r11 <= r12) goto L4;
        int r13 = r12;
    L5:
        if (r11 > r12) goto L8;
        r11 = r12;
    L8:
        if (r10 < r13) goto L13;
        if (r10 > r11) goto L12;
        return r10;
    L12:
        return r11;
    L13:
        return r13;
    L4:
        r13 = r11;
        goto L5
    }

    public static long clamp(long r10, long r11, long r12) {
        if (r11 <= r12) goto L5;
        long r13 = r12;
    L6:
        if (r11 > r12) goto L10;
        r11 = r12;
    L10:
        if (r10 >= r13) goto L13;
        return r13;
    L13:
        if (r10 > r11) goto L15;
        return r10;
    L15:
        return r11;
    L5:
        r13 = r11;
        goto L6
    }

    public static int compareLongs(long r10, long r11) {
        if (r10 >= r11) goto L5;
        return -1;
    L5:
        if (r10 != r11) goto L7;
        return 0;
    L7:
        return 1;
    }

    public static float distance(float r10, float r11, float r12, float r13) {
        float r14 = r12 - r10;
        float r15 = r13 - r11;
        return (float) Math.sqrt((r14 * r14) + (r15 * r15));
    }

    public static float flipSignIf(float r10, boolean r11) {
        if (r11 == true) goto L4;
        return r10;
    L4:
        return -r10;
    }

    public static int flipSignIf(int r10, boolean r11) {
        if (r11 == true) goto L4;
        return r10;
    L4:
        return -r10;
    }

    public static float interpolate(float r10, float r11, float r12) {
        return r10 + ((r11 - r10) * r12);
    }

    public static float map(float r10, float r11, float r12, float r13, float r14) {
        return r13 + ((r14 - r13) * ((r10 - r11) / (r12 - r11)));
    }

    public static int positiveModulo(int r10, int r11) {
        int r12 = r10 % r11;
        if (r12 < 0) goto L6;
        return r12;
    L6:
        return r12 + r11;
    }

    public static double roundTwoDecimalPlaces(double r10) {
        return Math.round(r10 * 100.0d) / 100.0d;
    }

    public static float scaleToFitTargetSize(int[] r10, int r11, int r12) {
        if (r10.length < 2) goto L11;
        if (r10[0] <= 0) goto L11;
        if (r10[1] <= 0) goto L11;
        float r13 = Math.max(r11 / r10[0], r12 / r10[1]);
        r10[0] = (int) (r10[0] * r13);
        r10[1] = (int) (r10[1] * r13);
        return r13;
    L11:
        throw new IllegalArgumentException("Expected dimensions to have length >= 2 && dimensions[0] > 0 && dimensions[1] > 0");
    }

    public static float smoothstep(float r10) {
        return (r10 * r10) * (3.0f - (r10 * 2.0f));
    }
}
