package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ColorUtils {
    static final double[][] SRGB_TO_XYZ = null;
    static final double[] WHITE_POINT_D65 = null;
    static final double[][] XYZ_TO_SRGB = null;

    static {
        SRGB_TO_XYZ = new double[][]{new double[]{0.41233895d, 0.35762064d, 0.18051042d}, new double[]{0.2126d, 0.7152d, 0.0722d}, new double[]{0.01932141d, 0.11916382d, 0.95034478d}};
        XYZ_TO_SRGB = new double[][]{new double[]{3.2413774792388685d, -1.5376652402851851d, -0.49885366846268053d}, new double[]{-0.9691452513005321d, 1.8758853451067872d, 0.04156585616912061d}, new double[]{0.05562093689691305d, -0.20395524564742123d, 1.0571799111220335d}};
        WHITE_POINT_D65 = new double[]{95.047d, 100.0d, 108.883d};
    }

    private ColorUtils() {
    }

    public static int alphaFromArgb(int r5) {
        return (r5 >> 24) & 255;
    }

    public static int argbFromLab(double r10, double r11, double r13) {
        double[] r5 = WHITE_POINT_D65;
        double r12 = (r10 + 16.0d) / 116.0d;
        double r14 = r12 - (r13 / 200.0d);
        double r15 = labInvf((r11 / 500.0d) + r12);
        double r16 = labInvf(r12);
        double r17 = labInvf(r14);
        return argbFromXyz(r15 * r5[0], r16 * r5[1], r17 * r5[2]);
    }

    public static int argbFromLinrgb(double[] r5) {
        return argbFromRgb(delinearized(r5[0]), delinearized(r5[1]), delinearized(r5[2]));
    }

    public static int argbFromLstar(double r5) {
        int r10 = delinearized(yFromLstar(r5));
        return argbFromRgb(r10, r10, r10);
    }

    public static int argbFromRgb(int r5, int r10, int r11) {
        return ((((r5 & 255) << 16) | ViewCompat.MEASURED_STATE_MASK) | ((r10 & 255) << 8)) | (r11 & 255);
    }

    public static int argbFromXyz(double r12, double r14, double r16) {
        double[][] r5 = XYZ_TO_SRGB;
        double[] r10 = r5[0];
        double r11 = r10[0] * r12;
        double r13 = (r10[1] * r14) + r11;
        double r15 = (r10[2] * r16) + r13;
        double[] r17 = r5[1];
        double r18 = r17[0] * r12;
        double r19 = (r17[1] * r14) + r18;
        double r20 = (r17[2] * r16) + r19;
        double[] r21 = r5[2];
        double r22 = r21[0] * r12;
        double r23 = (r21[1] * r14) + r22;
        double r24 = (r21[2] * r16) + r23;
        return argbFromRgb(delinearized(r15), delinearized(r20), delinearized(r24));
    }

    public static int blueFromArgb(int r5) {
        return r5 & 255;
    }

    public static int delinearized(double r5) {
        double r10 = r5 / 100.0d;
        if (r10 > 0.0031308d) goto L5;
        double r11 = r10 * 12.92d;
    L7:
        return MathUtils.clampInt(0, 255, (int) Math.round(r11 * 255.0d));
    L5:
        r11 = (Math.pow(r10, 0.4166666666666667d) * 1.055d) - 0.055d;
        goto L7
    }

    public static int greenFromArgb(int r5) {
        return (r5 >> 8) & 255;
    }

    public static boolean isOpaque(int r5) {
        if (alphaFromArgb(r5) < 255) goto L5;
        return true;
    L5:
        return false;
    }

    public static double labF(double r5) {
        if (r5 <= 0.008856451679035631d) goto L7;
        return Math.pow(r5, 0.3333333333333333d);
    L7:
        return ((r5 * 903.2962962962963d) + 16.0d) / 116.0d;
    }

    public static double[] labFromArgb(int r18) {
        double r5 = linearized(redFromArgb(r18));
        double r10 = linearized(greenFromArgb(r18));
        double r11 = linearized(blueFromArgb(r18));
        double[][] r12 = SRGB_TO_XYZ;
        double[] r13 = r12[0];
        double r14 = (r13[2] * r11) + ((r13[1] * r10) + (r13[0] * r5));
        double[] r15 = r12[1];
        double r16 = (r15[2] * r11) + ((r15[1] * r10) + (r15[0] * r5));
        double[] r17 = r12[2];
        double r19 = (r17[2] * r11) + ((r17[1] * r10) + (r17[0] * r5));
        double[] r20 = WHITE_POINT_D65;
        double r110 = r14 / r20[0];
        double r111 = r16 / r20[1];
        double r21 = r19 / r20[2];
        double r22 = labF(r110);
        double r23 = labF(r111);
        return new double[]{(116.0d * r23) - 16.0d, (r22 - r23) * 500.0d, (r23 - labF(r21)) * 200.0d};
    }

    public static double labInvf(double r5) {
        double r10 = (r5 * r5) * r5;
        if (r10 <= 0.008856451679035631d) goto L6;
        return r10;
    L6:
        return ((r5 * 116.0d) - 16.0d) / 903.2962962962963d;
    }

    public static double linearized(int r10) {
        double r5 = ((double) r10) / 255.0d;
        if (r5 > 0.040449936d) goto L7;
        double r11 = r5 / 12.92d;
    L6:
        return r11 * 100.0d;
    L7:
        r11 = Math.pow((r5 + 0.055d) / 1.055d, 2.4d);
        goto L6
    }

    public static double lstarFromArgb(int r5) {
        return (labF(xyzFromArgb(r5)[1] / 100.0d) * 116.0d) - 16.0d;
    }

    public static double lstarFromY(double r5) {
        return (labF(r5 / 100.0d) * 116.0d) - 16.0d;
    }

    public static int redFromArgb(int r5) {
        return (r5 >> 16) & 255;
    }

    public static double[] whitePointD65() {
        return WHITE_POINT_D65;
    }

    public static double[] xyzFromArgb(int r10) {
        return MathUtils.matrixMultiply(new double[]{linearized(redFromArgb(r10)), linearized(greenFromArgb(r10)), linearized(blueFromArgb(r10))}, SRGB_TO_XYZ);
    }

    public static double yFromLstar(double r5) {
        return labInvf((r5 + 16.0d) / 116.0d) * 100.0d;
    }
}
