package com.google.android.material.math;

/* JADX INFO: loaded from: classes2.dex */
public final class MathUtils {
    public static final float DEFAULT_EPSILON = 1.0E-4f;

    private MathUtils() {
    }

    public static float dist(float r5, float r10, float r11, float r12) {
        return (float) Math.hypot(r11 - r5, r12 - r10);
    }

    public static float distanceToFurthestCorner(float r5, float r10, float r11, float r12, float r13, float r14) {
        return max(dist(r5, r10, r11, r12), dist(r5, r10, r13, r12), dist(r5, r10, r13, r14), dist(r5, r10, r11, r14));
    }

    public static float floorMod(float r5, int r10) {
        float r11 = r10;
        int r12 = (int) (r5 / r11);
        if ((Math.signum(r5) * r11) >= 0.0f) goto L8;
        if ((r12 * r10) == r5) goto L8;
        r12 = r12 - 1;
    L8:
        return r5 - (r12 * r10);
    }

    public static boolean geq(float r5, float r10, float r11) {
        if ((r5 + r11) < r10) goto L5;
        return true;
    L5:
        return false;
    }

    public static float lerp(float r5, float r10, float r11) {
        float r12 = (1.0f - r11) * r5;
        return (r11 * r10) + r12;
    }

    private static float max(float r5, float r10, float r11, float r12) {
        if (r5 <= r10) goto L10;
        if (r5 <= r11) goto L10;
        if (r5 <= r12) goto L10;
        return r5;
    L10:
        if (r10 <= r11) goto L15;
        if (r10 <= r12) goto L15;
        return r10;
    L15:
        if (r11 <= r12) goto L18;
        return r11;
    L18:
        return r12;
    }

    public static int floorMod(int r5, int r10) {
        int r11 = r5 / r10;
        if ((r5 ^ r10) >= 0) goto L8;
        if ((r11 * r10) == r5) goto L8;
        r11 = r11 - 1;
    L8:
        return r5 - (r11 * r10);
    }
}
