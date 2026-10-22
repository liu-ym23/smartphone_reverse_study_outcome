package androidx.core.graphics;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal<double[]> TEMP_ARRAY = null;
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047d;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0d;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883d;

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static Color compositeColors(Color r10, Color r11) {
            if (Objects.equals(r10.getModel(), r11.getModel()) == false) goto L17;
            if (Objects.equals(r11.getColorSpace(), r10.getColorSpace()) == true) goto L8;
            r10 = r10.convert(r11.getColorSpace());
        L8:
            float[] r12 = r10.getComponents();
            float[] r13 = r11.getComponents();
            float r14 = r10.alpha();
            float r15 = r11.alpha() * (1.0f - r14);
            int r16 = r11.getComponentCount() - 1;
            r13[r16] = r14 + r15;
            if (r13[r16] <= 0.0f) goto L11;
            r14 = r14 / r13[r16];
            r15 = r15 / r13[r16];
        L11:
            int r17 = 0;
        L12:
            if (r17 >= r16) goto L15;
            r13[r17] = (r12[r17] * r14) + (r13[r17] * r15);
            r17 = r17 + 1;
            goto L12
        L15:
            return Color.valueOf(r13, r11.getColorSpace());
        L17:
            throw new IllegalArgumentException("Color models must match (" + r10.getModel() + " vs. " + r11.getModel() + ")");
        }
    }

    static {
        TEMP_ARRAY = new ThreadLocal();
    }

    private ColorUtils() {
    }

    @ColorInt
    public static int HSLToColor(@NonNull float[] r10) {
        float r11 = r10[0];
        float r12 = r10[1];
        float r13 = r10[2];
        float r14 = (1.0f - Math.abs((r13 * 2.0f) - 1.0f)) * r12;
        float r15 = r13 - (0.5f * r14);
        float r16 = (1.0f - Math.abs(((r11 / 60.0f) % 2.0f) - 1.0f)) * r14;
        switch((((int) r11) / 60)) {
            case 0: goto L12;
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            case 4: goto L6;
            case 5: goto L5;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        int r17 = 0;
        int r18 = 0;
        int r19 = 0;
    L15:
        return Color.rgb(constrain(r18, 0, 255), constrain(r19, 0, 255), constrain(r17, 0, 255));
    L5:
        r18 = Math.round((r14 + r15) * 255.0f);
        r19 = Math.round(r15 * 255.0f);
    L10:
        r17 = Math.round((r16 + r15) * 255.0f);
        goto L15
    L6:
        r18 = Math.round((r16 + r15) * 255.0f);
        r19 = Math.round(r15 * 255.0f);
    L8:
        r17 = Math.round((r14 + r15) * 255.0f);
        goto L15
    L7:
        r18 = Math.round(r15 * 255.0f);
        r19 = Math.round((r16 + r15) * 255.0f);
        goto L8
    L9:
        r18 = Math.round(r15 * 255.0f);
        r19 = Math.round((r14 + r15) * 255.0f);
        goto L10
    L11:
        r18 = Math.round((r16 + r15) * 255.0f);
        r19 = Math.round((r14 + r15) * 255.0f);
    L13:
        r17 = Math.round(r15 * 255.0f);
        goto L15
    L12:
        r18 = Math.round((r14 + r15) * 255.0f);
        r19 = Math.round((r16 + r15) * 255.0f);
        goto L13
    }

    @ColorInt
    public static int LABToColor(@FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) double r10, @FloatRange(from = -128.0d, to = 127.0d) double r11, @FloatRange(from = -128.0d, to = 127.0d) double r12) {
        double[] r13 = getTempDouble3Array();
        LABToXYZ(r10, r11, r12, r13);
        return XYZToColor(r13[0], r13[1], r13[2]);
    }

    public static void LABToXYZ(@FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) double r19, @FloatRange(from = -128.0d, to = 127.0d) double r21, @FloatRange(from = -128.0d, to = 127.0d) double r23, @NonNull double[] r25) {
        double r10 = (r19 + 16.0d) / 116.0d;
        double r11 = (r21 / 500.0d) + r10;
        double r12 = r10 - (r23 / 200.0d);
        double r13 = Math.pow(r11, 3.0d);
        if (r13 > XYZ_EPSILON) goto L7;
        r13 = ((r11 * 116.0d) - 16.0d) / XYZ_KAPPA;
    L7:
        if (r19 <= 7.9996247999999985d) goto L9;
        double r14 = Math.pow(r10, 3.0d);
    L10:
        double r15 = Math.pow(r12, 3.0d);
        if (r15 > XYZ_EPSILON) goto L14;
        r15 = ((r12 * 116.0d) - 16.0d) / XYZ_KAPPA;
    L14:
        r25[0] = r13 * XYZ_WHITE_REFERENCE_X;
        r25[1] = r14 * XYZ_WHITE_REFERENCE_Y;
        r25[2] = r15 * XYZ_WHITE_REFERENCE_Z;
        return;
    L9:
        r14 = r19 / XYZ_KAPPA;
        goto L10
    }

    public static void RGBToHSL(@IntRange(from = 0, to = 255) int r10, @IntRange(from = 0, to = 255) int r11, @IntRange(from = 0, to = 255) int r12, @NonNull float[] r13) {
        float r14 = r10 / 255.0f;
        float r15 = r11 / 255.0f;
        float r16 = r12 / 255.0f;
        float r17 = Math.max(r14, Math.max(r15, r16));
        float r18 = Math.min(r14, Math.min(r15, r16));
        float r19 = r17 - r18;
        float r20 = (r17 + r18) / 2.0f;
        if (r17 != r18) goto L6;
        float r21 = 0.0f;
        float r22 = 0.0f;
    L13:
        float r23 = (r21 * 60.0f) % 360.0f;
        if (r23 >= 0.0f) goto L16;
        r23 = r23 + 360.0f;
    L16:
        r13[0] = constrain(r23, 0.0f, 360.0f);
        r13[1] = constrain(r22, 0.0f, 1.0f);
        r13[2] = constrain(r20, 0.0f, 1.0f);
        return;
    L6:
        if (r17 != r14) goto L9;
        r21 = ((r15 - r16) / r19) % 6.0f;
    L12:
        r22 = r19 / (1.0f - Math.abs((2.0f * r20) - 1.0f));
        goto L13
    L9:
        if (r17 != r15) goto L11;
        r21 = ((r16 - r14) / r19) + 2.0f;
        goto L12
    L11:
        r21 = 4.0f + ((r14 - r15) / r19);
        goto L12
    }

    public static void RGBToLAB(@IntRange(from = 0, to = 255) int r10, @IntRange(from = 0, to = 255) int r11, @IntRange(from = 0, to = 255) int r12, @NonNull double[] r13) {
        RGBToXYZ(r10, r11, r12, r13);
        XYZToLAB(r13[0], r13[1], r13[2], r13);
    }

    public static void RGBToXYZ(@IntRange(from = 0, to = 255) int r16, @IntRange(from = 0, to = 255) int r17, @IntRange(from = 0, to = 255) int r18, @NonNull double[] r19) {
        if (r19.length != 3) goto L19;
        double r10 = ((double) r16) / 255.0d;
        if (r10 >= 0.04045d) goto L7;
        double r11 = r10 / 12.92d;
    L8:
        double r12 = ((double) r17) / 255.0d;
        if (r12 >= 0.04045d) goto L11;
        double r13 = r12 / 12.92d;
    L12:
        double r14 = ((double) r18) / 255.0d;
        if (r14 >= 0.04045d) goto L15;
        double r15 = r14 / 12.92d;
    L16:
        r19[0] = (((0.4124d * r11) + (0.3576d * r13)) + (0.1805d * r15)) * XYZ_WHITE_REFERENCE_Y;
        r19[1] = (((0.2126d * r11) + (0.7152d * r13)) + (0.0722d * r15)) * XYZ_WHITE_REFERENCE_Y;
        r19[2] = (((r11 * 0.0193d) + (r13 * 0.1192d)) + (r15 * 0.9505d)) * XYZ_WHITE_REFERENCE_Y;
        return;
    L15:
        r15 = Math.pow((r14 + 0.055d) / 1.055d, 2.4d);
        goto L16
    L11:
        r13 = Math.pow((r12 + 0.055d) / 1.055d, 2.4d);
        goto L12
    L7:
        r11 = Math.pow((r10 + 0.055d) / 1.055d, 2.4d);
        goto L8
    L19:
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    @ColorInt
    public static int XYZToColor(@FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_X) double r17, @FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) double r19, @FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Z) double r21) {
        double r10 = (((3.2406d * r17) + ((-1.5372d) * r19)) + ((-0.4986d) * r21)) / XYZ_WHITE_REFERENCE_Y;
        double r11 = ((((-0.9689d) * r17) + (1.8758d * r19)) + (0.0415d * r21)) / XYZ_WHITE_REFERENCE_Y;
        double r12 = (((0.0557d * r17) + ((-0.204d) * r19)) + (1.057d * r21)) / XYZ_WHITE_REFERENCE_Y;
        if (r10 <= 0.0031308d) goto L5;
        double r13 = (Math.pow(r10, 0.4166666666666667d) * 1.055d) - 0.055d;
    L7:
        if (r11 <= 0.0031308d) goto L9;
        double r14 = (Math.pow(r11, 0.4166666666666667d) * 1.055d) - 0.055d;
    L11:
        if (r12 <= 0.0031308d) goto L13;
        double r15 = (Math.pow(r12, 0.4166666666666667d) * 1.055d) - 0.055d;
    L15:
        return Color.rgb(constrain((int) Math.round(r13 * 255.0d), 0, 255), constrain((int) Math.round(r14 * 255.0d), 0, 255), constrain((int) Math.round(r15 * 255.0d), 0, 255));
    L13:
        r15 = r12 * 12.92d;
        goto L15
    L9:
        r14 = r11 * 12.92d;
        goto L11
    L5:
        r13 = r10 * 12.92d;
        goto L7
    }

    public static void XYZToLAB(@FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_X) double r10, @FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) double r11, @FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Z) double r12, @NonNull double[] r13) {
        if (r13.length != 3) goto L7;
        double r14 = pivotXyzComponent(r10 / XYZ_WHITE_REFERENCE_X);
        double r15 = pivotXyzComponent(r11 / XYZ_WHITE_REFERENCE_Y);
        double r16 = pivotXyzComponent(r12 / XYZ_WHITE_REFERENCE_Z);
        r13[0] = Math.max(0.0d, (116.0d * r15) - 16.0d);
        r13[1] = (r14 - r15) * 500.0d;
        r13[2] = (r15 - r16) * 200.0d;
        return;
    L7:
        throw new IllegalArgumentException("outLab must have a length of 3.");
    }

    @ColorInt
    public static int blendARGB(@ColorInt int r10, @ColorInt int r11, @FloatRange(from = 0.0d, to = 1.0d) float r12) {
        float r13 = 1.0f - r12;
        return Color.argb((int) ((Color.alpha(r10) * r13) + (Color.alpha(r11) * r12)), (int) ((Color.red(r10) * r13) + (Color.red(r11) * r12)), (int) ((Color.green(r10) * r13) + (Color.green(r11) * r12)), (int) ((Color.blue(r10) * r13) + (Color.blue(r11) * r12)));
    }

    public static void blendHSL(@NonNull float[] r10, @NonNull float[] r11, @FloatRange(from = 0.0d, to = 1.0d) float r12, @NonNull float[] r13) {
        if (r13.length != 3) goto L7;
        float r14 = 1.0f - r12;
        r13[0] = circularInterpolate(r10[0], r11[0], r12);
        r13[1] = (r10[1] * r14) + (r11[1] * r12);
        r13[2] = (r10[2] * r14) + (r11[2] * r12);
        return;
    L7:
        throw new IllegalArgumentException("result must have a length of 3.");
    }

    public static void blendLAB(@NonNull double[] r10, @NonNull double[] r11, @FloatRange(from = 0.0d, to = 1.0d) double r12, @NonNull double[] r13) {
        if (r13.length != 3) goto L7;
        double r14 = 1.0d - r12;
        r13[0] = (r10[0] * r14) + (r11[0] * r12);
        r13[1] = (r10[1] * r14) + (r11[1] * r12);
        r13[2] = (r10[2] * r14) + (r11[2] * r12);
        return;
    L7:
        throw new IllegalArgumentException("outResult must have a length of 3.");
    }

    public static double calculateContrast(@ColorInt int r10, @ColorInt int r11) {
        if (Color.alpha(r11) != 255) goto L10;
        if (Color.alpha(r10) >= 255) goto L7;
        r10 = compositeColors(r10, r11);
    L7:
        double r12 = calculateLuminance(r10) + 0.05d;
        double r13 = calculateLuminance(r11) + 0.05d;
        return Math.max(r12, r13) / Math.min(r12, r13);
    L10:
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(r11));
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public static double calculateLuminance(@ColorInt int r10) {
        double[] r11 = getTempDouble3Array();
        colorToXYZ(r10, r11);
        return r11[1] / XYZ_WHITE_REFERENCE_Y;
    }

    public static int calculateMinimumAlpha(@ColorInt int r10, @ColorInt int r11, float r12) {
        int r13 = 255;
        if (Color.alpha(r11) != 255) goto L20;
        double r14 = r12;
        if (calculateContrast(setAlphaComponent(r10, 255), r11) >= r14) goto L8;
        return -1;
    L8:
        int r15 = 0;
        int r16 = 0;
    L10:
        if (r15 > 10) goto L18;
        if ((r13 - r16) <= 1) goto L18;
        int r17 = (r16 + r13) / 2;
        if (calculateContrast(setAlphaComponent(r10, r17), r11) >= r14) goto L16;
        r16 = r17;
    L17:
        r15 = r15 + 1;
        goto L10
    L16:
        r13 = r17;
    L18:
        return r13;
    L20:
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(r11));
    }

    @VisibleForTesting
    static float circularInterpolate(float r10, float r11, float r12) {
        if (Math.abs(r11 - r10) <= 180.0f) goto L9;
        if (r11 <= r10) goto L7;
        r10 = r10 + 360.0f;
        goto L9
    L7:
        r11 = r11 + 360.0f;
    L9:
        return (r10 + ((r11 - r10) * r12)) % 360.0f;
    }

    public static void colorToHSL(@ColorInt int r10, @NonNull float[] r11) {
        RGBToHSL(Color.red(r10), Color.green(r10), Color.blue(r10), r11);
    }

    public static void colorToLAB(@ColorInt int r10, @NonNull double[] r11) {
        RGBToLAB(Color.red(r10), Color.green(r10), Color.blue(r10), r11);
    }

    public static void colorToXYZ(@ColorInt int r10, @NonNull double[] r11) {
        RGBToXYZ(Color.red(r10), Color.green(r10), Color.blue(r10), r11);
    }

    private static int compositeAlpha(int r10, int r11) {
        return 255 - (((255 - r11) * (255 - r10)) / 255);
    }

    public static int compositeColors(@ColorInt int r10, @ColorInt int r11) {
        int r12 = Color.alpha(r11);
        int r13 = Color.alpha(r10);
        int r14 = compositeAlpha(r13, r12);
        return Color.argb(r14, compositeComponent(Color.red(r10), r13, Color.red(r11), r12, r14), compositeComponent(Color.green(r10), r13, Color.green(r11), r12, r14), compositeComponent(Color.blue(r10), r13, Color.blue(r11), r12, r14));
    }

    @NonNull
    @RequiresApi(26)
    public static Color compositeColors(@NonNull Color r10, @NonNull Color r11) {
        return Api26Impl.compositeColors(r10, r11);
    }

    private static int compositeComponent(int r10, int r11, int r12, int r13, int r14) {
        if (r14 != 0) goto L6;
        return 0;
    L6:
        return (((r10 * 255) * r11) + ((r12 * r13) * (255 - r11))) / (r14 * 255);
    }

    private static float constrain(float r10, float r11, float r12) {
        if (r10 >= r11) goto L6;
        return r11;
    L6:
        return Math.min(r10, r12);
    }

    private static int constrain(int r10, int r11, int r12) {
        if (r10 >= r11) goto L5;
        return r11;
    L5:
        return Math.min(r10, r12);
    }

    public static double distanceEuclidean(@NonNull double[] r10, @NonNull double[] r11) {
        return Math.sqrt((Math.pow(r10[0] - r11[0], 2.0d) + Math.pow(r10[1] - r11[1], 2.0d)) + Math.pow(r10[2] - r11[2], 2.0d));
    }

    private static double[] getTempDouble3Array() {
        ThreadLocal<double[]> r10 = TEMP_ARRAY;
        double[] r11 = r10.get();
        if (r11 != null) goto L6;
        double[] r12 = new double[3];
        r10.set(r12);
        return r12;
    L6:
        return r11;
    }

    private static double pivotXyzComponent(double r10) {
        if (r10 <= XYZ_EPSILON) goto L6;
        return Math.pow(r10, 0.3333333333333333d);
    L6:
        return ((r10 * XYZ_KAPPA) + 16.0d) / 116.0d;
    }

    @ColorInt
    public static int setAlphaComponent(@ColorInt int r10, @IntRange(from = 0, to = 255) int r11) {
        if (r11 < 0) goto L8;
        if (r11 > 255) goto L8;
        return (r10 & ViewCompat.MEASURED_SIZE_MASK) | (r11 << 24);
    L8:
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
