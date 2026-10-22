package a0;

import android.graphics.Color;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<double[]> f2a = null;

    static {
        f2a = new ThreadLocal();
    }

    public static int a(double r17, double r19, double r21) {
        double r8 = (((-0.4986d) * r21) + (((-1.5372d) * r19) + (3.2406d * r17))) / 100.0d;
        double r10 = ((0.0415d * r21) + ((1.8758d * r19) + ((-0.9689d) * r17))) / 100.0d;
        double r11 = ((1.057d * r21) + (((-0.204d) * r19) + (0.0557d * r17))) / 100.0d;
        if (r8 <= 0.0031308d) goto L5;
        double r12 = (Math.pow(r8, 0.4166666666666667d) * 1.055d) - 0.055d;
    L7:
        if (r10 <= 0.0031308d) goto L9;
        double r13 = (Math.pow(r10, 0.4166666666666667d) * 1.055d) - 0.055d;
    L11:
        if (r11 <= 0.0031308d) goto L13;
        double r14 = (Math.pow(r11, 0.4166666666666667d) * 1.055d) - 0.055d;
    L14:
        int r15 = (int) Math.round(r12 * 255.0d);
        int r16 = 0;
        if (r15 >= 0) goto L17;
        int r18 = 0;
    L18:
        int r20 = (int) Math.round(r13 * 255.0d);
        if (r20 >= 0) goto L21;
        int r22 = 0;
    L22:
        int r23 = (int) Math.round(r14 * 255.0d);
        if (r23 < 0) goto L27;
        r16 = Math.min(r23, 255);
    L27:
        return Color.rgb(r18, r22, r16);
    L21:
        r22 = Math.min(r20, 255);
        goto L22
    L17:
        r18 = Math.min(r15, 255);
        goto L18
    L13:
        r14 = r11 * 12.92d;
        goto L14
    L9:
        r13 = r10 * 12.92d;
        goto L11
    L5:
        r12 = r8 * 12.92d;
        goto L7
    }

    public static int b(float r8, int r10, int r11) {
        float r12 = 1.0f - r8;
        return Color.argb((int) ((Color.alpha(r11) * r8) + (Color.alpha(r10) * r12)), (int) ((Color.red(r11) * r8) + (Color.red(r10) * r12)), (int) ((Color.green(r11) * r8) + (Color.green(r10) * r12)), (int) ((Color.blue(r11) * r8) + (Color.blue(r10) * r12)));
    }

    public static int c(int r8, int r10) {
        int r11 = Color.alpha(r10);
        int r12 = Color.alpha(r8);
        int r13 = 255 - r12;
        int r14 = 255 - (((255 - r11) * r13) / 255);
        int r15 = Color.red(r8);
        int r16 = Color.red(r10);
        int r17 = 0;
        if (r14 != 0) goto L5;
        int r18 = 0;
    L6:
        int r19 = Color.green(r8);
        int r20 = Color.green(r10);
        if (r14 != 0) goto L9;
        int r21 = 0;
    L10:
        int r22 = Color.blue(r8);
        int r23 = Color.blue(r10);
        if (r14 == 0) goto L15;
        r17 = (((r23 * r11) * r13) + ((r22 * 255) * r12)) / (r14 * 255);
    L15:
        return Color.argb(r14, r18, r21, r17);
    L9:
        r21 = (((r20 * r11) * r13) + ((r19 * 255) * r12)) / (r14 * 255);
        goto L10
    L5:
        r18 = (((r16 * r11) * r13) + ((r15 * 255) * r12)) / (r14 * 255);
        goto L6
    }

    public static int d(int r8, int r10) {
        if (r10 < 0) goto L8;
        if (r10 > 255) goto L8;
        return (r8 & 16777215) | (r10 << 24);
    L8:
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
