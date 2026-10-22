package ija;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
        new a(0.4f, 0.0f, 0.2f, 1.0f);
    }

    public static final float a(float r4) {
        float r0 = Float.intBitsToFloat(((int) ((((long) Float.floatToRawIntBits(r4)) & 8589934591L) / ((long) 3))) + 709952852);
        float r1 = r0 - ((r0 - (r4 / (r0 * r0))) * 0.33333334f);
        return r1 - ((r1 - (r4 / (r1 * r1))) * 0.33333334f);
    }

    public static final int b(float r2, float[] r3, int r4) {
        if (r2 >= 0.0f) goto L8;
        if (r2 < (-8.34465E-7f)) goto L12;
        r2 = 0.0f;
    L13:
        r3[r4] = r2;
        return !Float.isNaN(r2) ? 1 : 0;
    L12:
        r2 = Float.NaN;
        goto L13
    L8:
        if (r2 <= 1.0f) goto L13;
        if (r2 > 1.0000008f) goto L12;
        r2 = 1.0f;
        goto L13
    }
}
