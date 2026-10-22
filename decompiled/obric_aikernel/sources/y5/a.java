package y5;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static float a(float r10, float r11, float r12, float r13) {
        return (float) Math.hypot(r12 - r10, r13 - r11);
    }

    public static float b(float r10, float r11, float r12, float r13, float r14, float r15) {
        return e(a(r10, r11, r12, r13), a(r10, r11, r14, r13), a(r10, r11, r14, r15), a(r10, r11, r12, r15));
    }

    public static boolean c(float r10, float r11, float r12) {
        if ((r10 + r12) < r11) goto L5;
        return true;
    L5:
        return false;
    }

    public static float d(float r10, float r11, float r12) {
        return ((1.0f - r12) * r10) + (r12 * r11);
    }

    private static float e(float r10, float r11, float r12, float r13) {
        if (r10 <= r11) goto L10;
        if (r10 <= r12) goto L10;
        if (r10 <= r13) goto L10;
        return r10;
    L10:
        if (r11 <= r12) goto L15;
        if (r11 <= r13) goto L15;
        return r11;
    L15:
        if (r12 <= r13) goto L18;
        return r12;
    L18:
        return r13;
    }
}
