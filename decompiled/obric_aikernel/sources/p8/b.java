package p8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    static {
        new a(0.4f, 0.0f, 0.2f, 1.0f);
    }

    public static final /* synthetic */ int a(float r10, float[] r11, int r12) {
        return f(r10, r11, r12);
    }

    public static final q8.a b(float r10, float r11, float r12, float r13, float[] r14, int r15) {
        Intrinsics.checkNotNullParameter(r14, "roots");
        float r16 = (r11 - r10) * 3.0f;
        float r17 = (r12 - r11) * 3.0f;
        float r18 = (r13 - r12) * 3.0f;
        int r19 = d(r16, r17, r18, r14, r15);
        float r20 = (r17 - r16) * 2.0f;
        float r21 = (r18 - r17) * 2.0f;
        float r22 = (-r20) / (r21 - r20);
        int r23 = r19 + a(r22, r14, r15 + r19);
        float r110 = Math.min(r10, r13);
        float r24 = Math.max(r10, r13);
        int r25 = 0;
    L3:
        if (r25 >= r23) goto L6;
        float r26 = c(r10, r11, r12, r13, r14[r25]);
        r110 = Math.min(r110, r26);
        r24 = Math.max(r24, r26);
        r25 = r25 + 1;
        goto L3
    L6:
        return new q8.a(r110, r24);
    }

    private static final float c(float r10, float r11, float r12, float r13, float r14) {
        float r15 = (r13 + ((r11 - r12) * 3.0f)) - r10;
        float r16 = ((r12 - (2.0f * r11)) + r10) * 3.0f;
        float r17 = ((r15 * r14) + r16) * r14;
        return ((r17 + ((r11 - r10) * 3.0f)) * r14) + r10;
    }

    private static final int d(float r17, float r18, float r19, float[] r20, int r21) {
        double r10 = r17;
        double r11 = r18;
        double r12 = r19;
        double r13 = r11 * 2.0d;
        double r14 = (r10 - r13) + r12;
        if (r14 == 0.0d) goto L13;
        double r15 = -Math.sqrt((r11 * r11) - (r12 * r10));
        double r16 = (-r10) + r11;
        int r22 = f((float) ((-(r15 + r16)) / r14), r20, r21) + 0;
        int r110 = r22 + f((float) ((r15 - r16) / r14), r20, r21 + r22);
        if (r110 <= 1) goto L16;
        float r23 = r20[r21];
        int r24 = r21 + 1;
        float r25 = r20[r24];
        if (r23 <= r25) goto L10;
        r20[r21] = r25;
        r20[r24] = r23;
        return r110;
    L10:
        if (r23 == r25) goto L19;
        return r110;
    L19:
        return r110 - 1;
    L16:
        return r110;
    L13:
        if (r11 != r12) goto L15;
        return 0;
    L15:
        return 0 + f((float) ((r13 - r12) / (r13 - (r12 * 2.0d))), r20, r21);
    }

    public static final void e(String r10) {
        Intrinsics.checkNotNullParameter(r10, "message");
        throw new IllegalArgumentException(r10);
    }

    private static final int f(float r10, float[] r11, int r12) {
        if (r10 >= 0.0f) goto L9;
        if (r10 < (-8.34465E-7f)) goto L7;
        r10 = 0.0f;
    L13:
        r11[r12] = r10;
        return !Float.isNaN(r10) ? 1 : 0;
    L7:
        r10 = Float.NaN;
        goto L13
    L9:
        if (r10 <= 1.0f) goto L13;
        if (r10 > 1.0000008f) goto L7;
        r10 = 1.0f;
        goto L13
    }
}
