package androidx.core.graphics;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.motion.widget.a;
import androidx.core.content.res.CamColor;
import androidx.core.view.ViewCompat;
import com.google.android.material.color.utilities.Contrast;
import java.util.Objects;
import kotlin.jvm.internal.DoubleCompanionObject;

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
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static Color compositeColors(Color r10, Color r11) {
            if (Objects.equals(r10.getModel(), r11.getModel()) == false) goto L17;
            if (Objects.equals(r11.getColorSpace(), r10.getColorSpace()) == true) goto L8;
            r10 = r10.convert(r11.getColorSpace());
        L8:
            float[] r5 = r10.getComponents();
            float[] r12 = r11.getComponents();
            float r13 = r10.alpha();
            float r14 = (1.0f - r13) * r11.alpha();
            int r15 = r11.getComponentCount() - 1;
            float r16 = r13 + r14;
            r12[r15] = r16;
            if (r16 <= 0.0f) goto L11;
            r13 = r13 / r16;
            r14 = r14 / r16;
        L11:
            int r17 = 0;
        L12:
            if (r17 >= r15) goto L15;
            r12[r17] = (r12[r17] * r14) + (r5[r17] * r13);
            r17 = r17 + 1;
            goto L12
        L15:
            return Color.valueOf(r12, r11.getColorSpace());
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
        float r5 = r10[0];
        float r11 = r10[1];
        float r12 = r10[2];
        float r13 = (1.0f - Math.abs((r12 * 2.0f) - 1.0f)) * r11;
        float r14 = r12 - (0.5f * r13);
        float r15 = (1.0f - Math.abs(((r5 / 60.0f) % 2.0f) - 1.0f)) * r13;
        switch((((int) r5) / 60)) {
            case 0: goto L10;
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L6;
            case 5: goto L5;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
    L12:
        return Color.rgb(constrain(r17, 0, 255), constrain(r18, 0, 255), constrain(r16, 0, 255));
    L5:
        r17 = Math.round((r13 + r14) * 255.0f);
        r18 = Math.round(r14 * 255.0f);
        r16 = Math.round((r15 + r14) * 255.0f);
        goto L12
    L6:
        r17 = Math.round((r15 + r14) * 255.0f);
        r18 = Math.round(r14 * 255.0f);
        r16 = Math.round((r13 + r14) * 255.0f);
        goto L12
    L7:
        r17 = Math.round(r14 * 255.0f);
        r18 = Math.round((r15 + r14) * 255.0f);
        r16 = Math.round((r13 + r14) * 255.0f);
        goto L12
    L8:
        r17 = Math.round(r14 * 255.0f);
        r18 = Math.round((r13 + r14) * 255.0f);
        r16 = Math.round((r15 + r14) * 255.0f);
        goto L12
    L9:
        r17 = Math.round((r15 + r14) * 255.0f);
        r18 = Math.round((r13 + r14) * 255.0f);
        r16 = Math.round(r14 * 255.0f);
        goto L12
    L10:
        r17 = Math.round((r13 + r14) * 255.0f);
        r18 = Math.round((r15 + r14) * 255.0f);
        r16 = Math.round(r14 * 255.0f);
        goto L12
    }

    @ColorInt
    public static int LABToColor(@FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) double r10, @FloatRange(from = -128.0d, to = 127.0d) double r11, @FloatRange(from = -128.0d, to = 127.0d) double r12) {
        double[] r13 = getTempDouble3Array();
        LABToXYZ(r10, r11, r12, r13);
        return XYZToColor(r13[0], r13[1], r13[2]);
    }

    public static void LABToXYZ(@FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) double r19, @FloatRange(from = -128.0d, to = 127.0d) double r21, @FloatRange(from = -128.0d, to = 127.0d) double r23, @NonNull double[] r25) {
        double r5 = (r19 + 16.0d) / 116.0d;
        double r10 = (r21 / 500.0d) + r5;
        double r11 = r5 - (r23 / 200.0d);
        double r12 = Math.pow(r10, 3.0d);
        if (r12 > XYZ_EPSILON) goto L7;
        r12 = ((r10 * 116.0d) - 16.0d) / XYZ_KAPPA;
    L7:
        if (r19 <= 7.9996247999999985d) goto L9;
        double r13 = Math.pow(r5, 3.0d);
    L10:
        double r14 = Math.pow(r11, 3.0d);
        if (r14 > XYZ_EPSILON) goto L14;
        r14 = ((r11 * 116.0d) - 16.0d) / XYZ_KAPPA;
    L14:
        r25[0] = r12 * XYZ_WHITE_REFERENCE_X;
        r25[1] = r13 * XYZ_WHITE_REFERENCE_Y;
        r25[2] = r14 * XYZ_WHITE_REFERENCE_Z;
        return;
    L9:
        r13 = r19 / XYZ_KAPPA;
        goto L10
    }

    @ColorInt
    public static int M3HCTToColor(@FloatRange(from = 0.0d, to = 360.0d, toInclusive = false) float r5, @FloatRange(from = 0.0d, to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false) float r10, @FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) float r11) {
        return CamColor.toColor(r5, r10, r11);
    }

    public static void RGBToHSL(@IntRange(from = 0, to = 255) int r10, @IntRange(from = 0, to = 255) int r11, @IntRange(from = 0, to = 255) int r12, @NonNull float[] r13) {
        float r14 = r10 / 255.0f;
        float r15 = r11 / 255.0f;
        float r16 = r12 / 255.0f;
        float r5 = Math.max(r14, Math.max(r15, r16));
        float r17 = Math.min(r14, Math.min(r15, r16));
        float r18 = r5 - r17;
        float r19 = (r5 + r17) / 2.0f;
        if (r5 != r17) goto L6;
        float r20 = 0.0f;
        float r21 = 0.0f;
    L13:
        float r22 = (r20 * 60.0f) % 360.0f;
        if (r22 >= 0.0f) goto L16;
        r22 = r22 + 360.0f;
    L16:
        r13[0] = constrain(r22, 0.0f, 360.0f);
        r13[1] = constrain(r21, 0.0f, 1.0f);
        r13[2] = constrain(r19, 0.0f, 1.0f);
        return;
    L6:
        if (r5 != r14) goto L9;
        r20 = ((r15 - r16) / r18) % 6.0f;
    L12:
        r21 = r18 / (1.0f - Math.abs((2.0f * r19) - 1.0f));
        goto L13
    L9:
        if (r5 != r15) goto L11;
        r20 = a.a(r16, r14, r18, 2.0f);
        goto L12
    L11:
        r20 = a.a(r14, r15, r18, 4.0f);
        goto L12
    }

    public static void RGBToLAB(@IntRange(from = 0, to = 255) int r10, @IntRange(from = 0, to = 255) int r11, @IntRange(from = 0, to = 255) int r12, @NonNull double[] r13) {
        RGBToXYZ(r10, r11, r12, r13);
        XYZToLAB(r13[0], r13[1], r13[2], r13);
    }

    public static void RGBToXYZ(@IntRange(from = 0, to = 255) int r16, @IntRange(from = 0, to = 255) int r17, @IntRange(from = 0, to = 255) int r18, @NonNull double[] r19) {
        if (r19.length != 3) goto L21;
        double r5 = ((double) r16) / 255.0d;
        if (r5 >= 0.04045d) goto L8;
        double r10 = r5 / 12.92d;
    L9:
        double r11 = ((double) r17) / 255.0d;
        if (r11 >= 0.04045d) goto L13;
        double r12 = r11 / 12.92d;
    L14:
        double r13 = ((double) r18) / 255.0d;
        if (r13 >= 0.04045d) goto L17;
        double r14 = r13 / 12.92d;
    L18:
        double r15 = 0.3576d * r12;
        double r20 = r15 + (0.4124d * r10);
        r19[0] = ((0.1805d * r14) + r20) * XYZ_WHITE_REFERENCE_Y;
        double r110 = 0.7152d * r12;
        double r111 = r110 + (0.2126d * r10);
        r19[1] = ((0.0722d * r14) + r111) * XYZ_WHITE_REFERENCE_Y;
        double r21 = r12 * 0.1192d;
        double r112 = r14 * 0.9505d;
        r19[2] = (r112 + (r21 + (r10 * 0.0193d))) * XYZ_WHITE_REFERENCE_Y;
        return;
    L17:
        r14 = Math.pow((r13 + 0.055d) / 1.055d, 2.4d);
        goto L18
    L13:
        r12 = Math.pow((r11 + 0.055d) / 1.055d, 2.4d);
        goto L14
    L8:
        r10 = Math.pow((r5 + 0.055d) / 1.055d, 2.4d);
        goto L9
    L21:
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    @ColorInt
    public static int XYZToColor(@FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_X) double r17, @FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) double r19, @FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Z) double r21) {
        double r5 = (-1.5372d) * r19;
        double r10 = r5 + (3.2406d * r17);
        double r11 = (((-0.4986d) * r21) + r10) / XYZ_WHITE_REFERENCE_Y;
        double r12 = 1.8758d * r19;
        double r13 = r12 + ((-0.9689d) * r17);
        double r14 = ((0.0415d * r21) + r13) / XYZ_WHITE_REFERENCE_Y;
        double r15 = (-0.204d) * r19;
        double r16 = r15 + (0.0557d * r17);
        double r18 = ((1.057d * r21) + r16) / XYZ_WHITE_REFERENCE_Y;
        if (r11 <= 0.0031308d) goto L5;
        double r20 = (Math.pow(r11, 0.4166666666666667d) * 1.055d) - 0.055d;
    L7:
        if (r14 <= 0.0031308d) goto L9;
        double r22 = (Math.pow(r14, 0.4166666666666667d) * 1.055d) - 0.055d;
    L11:
        if (r18 <= 0.0031308d) goto L13;
        double r23 = (Math.pow(r18, 0.4166666666666667d) * 1.055d) - 0.055d;
    L15:
        return Color.rgb(constrain((int) Math.round(r20 * 255.0d), 0, 255), constrain((int) Math.round(r22 * 255.0d), 0, 255), constrain((int) Math.round(r23 * 255.0d), 0, 255));
    L13:
        r23 = r18 * 12.92d;
        goto L15
    L9:
        r22 = r14 * 12.92d;
        goto L11
    L5:
        r20 = r11 * 12.92d;
        goto L7
    }

    public static void XYZToLAB(@FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_X) double r5, @FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) double r10, @FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Z) double r11, @NonNull double[] r12) {
        if (r12.length != 3) goto L7;
        double r13 = pivotXyzComponent(r5 / XYZ_WHITE_REFERENCE_X);
        double r14 = pivotXyzComponent(r10 / XYZ_WHITE_REFERENCE_Y);
        double r15 = pivotXyzComponent(r11 / XYZ_WHITE_REFERENCE_Z);
        r12[0] = Math.max(0.0d, (116.0d * r14) - 16.0d);
        r12[1] = (r13 - r14) * 500.0d;
        r12[2] = (r14 - r15) * 200.0d;
        return;
    L7:
        throw new IllegalArgumentException("outLab must have a length of 3.");
    }

    @ColorInt
    public static int blendARGB(@ColorInt int r5, @ColorInt int r10, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r11) {
        float r12 = 1.0f - r11;
        return Color.argb((int) ((Color.alpha(r10) * r11) + (Color.alpha(r5) * r12)), (int) ((Color.red(r10) * r11) + (Color.red(r5) * r12)), (int) ((Color.green(r10) * r11) + (Color.green(r5) * r12)), (int) ((Color.blue(r10) * r11) + (Color.blue(r5) * r12)));
    }

    public static void blendHSL(@NonNull float[] r5, @NonNull float[] r10, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r11, @NonNull float[] r12) {
        if (r12.length != 3) goto L7;
        float r13 = 1.0f - r11;
        r12[0] = circularInterpolate(r5[0], r10[0], r11);
        float r14 = r5[1] * r13;
        r12[1] = (r10[1] * r11) + r14;
        float r15 = r5[2] * r13;
        r12[2] = (r10[2] * r11) + r15;
        return;
    L7:
        throw new IllegalArgumentException("result must have a length of 3.");
    }

    public static void blendLAB(@NonNull double[] r10, @NonNull double[] r11, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) double r12, @NonNull double[] r13) {
        if (r13.length != 3) goto L7;
        double r5 = 1.0d - r12;
        double r14 = r10[0] * r5;
        r13[0] = (r11[0] * r12) + r14;
        double r15 = r10[1] * r5;
        r13[1] = (r11[1] * r12) + r15;
        double r16 = r10[2] * r5;
        r13[2] = (r11[2] * r12) + r16;
        return;
    L7:
        throw new IllegalArgumentException("outResult must have a length of 3.");
    }

    public static double calculateContrast(@ColorInt int r5, @ColorInt int r10) {
        if (Color.alpha(r10) != 255) goto L10;
        if (Color.alpha(r5) >= 255) goto L7;
        r5 = compositeColors(r5, r10);
    L7:
        double r11 = calculateLuminance(r5) + 0.05d;
        double r12 = calculateLuminance(r10) + 0.05d;
        return Math.max(r11, r12) / Math.min(r11, r12);
    L10:
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(r10));
    }

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    public static double calculateLuminance(@ColorInt int r5) {
        double[] r10 = getTempDouble3Array();
        colorToXYZ(r5, r10);
        return r10[1] / XYZ_WHITE_REFERENCE_Y;
    }

    public static int calculateMinimumAlpha(@ColorInt int r10, @ColorInt int r11, float r12) {
        int r5 = 255;
        if (Color.alpha(r11) != 255) goto L20;
        double r13 = r12;
        if (calculateContrast(setAlphaComponent(r10, 255), r11) >= r13) goto L8;
        return -1;
    L8:
        int r14 = 0;
        int r15 = 0;
    L10:
        if (r14 > 10) goto L18;
        if ((r5 - r15) <= 1) goto L18;
        int r16 = (r15 + r5) / 2;
        if (calculateContrast(setAlphaComponent(r10, r16), r11) >= r13) goto L16;
        r15 = r16;
    L17:
        r14 = r14 + 1;
        goto L10
    L16:
        r5 = r16;
    L18:
        return r5;
    L20:
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(r11));
    }

    @VisibleForTesting
    public static float circularInterpolate(float r5, float r10, float r11) {
        if (Math.abs(r10 - r5) <= 180.0f) goto L9;
        if (r10 <= r5) goto L7;
        r5 = r5 + 360.0f;
        goto L9
    L7:
        r10 = r10 + 360.0f;
    L9:
        return (((r10 - r5) * r11) + r5) % 360.0f;
    }

    public static void colorToHSL(@ColorInt int r5, @NonNull float[] r10) {
        RGBToHSL(Color.red(r5), Color.green(r5), Color.blue(r5), r10);
    }

    public static void colorToLAB(@ColorInt int r5, @NonNull double[] r10) {
        RGBToLAB(Color.red(r5), Color.green(r5), Color.blue(r5), r10);
    }

    public static void colorToM3HCT(@ColorInt int r5, @NonNull @Size(3) float[] r10) {
        CamColor.getM3HCTfromColor(r5, r10);
    }

    public static void colorToXYZ(@ColorInt int r5, @NonNull double[] r10) {
        RGBToXYZ(Color.red(r5), Color.green(r5), Color.blue(r5), r10);
    }

    private static int compositeAlpha(int r5, int r10) {
        int r11 = 255 - r5;
        return 255 - ((r11 * (255 - r10)) / 255);
    }

    public static int compositeColors(@ColorInt int r10, @ColorInt int r11) {
        int r5 = Color.alpha(r11);
        int r12 = Color.alpha(r10);
        int r13 = compositeAlpha(r12, r5);
        return Color.argb(r13, compositeComponent(Color.red(r10), r12, Color.red(r11), r5, r13), compositeComponent(Color.green(r10), r12, Color.green(r11), r5, r13), compositeComponent(Color.blue(r10), r12, Color.blue(r11), r5, r13));
    }

    private static int compositeComponent(int r5, int r10, int r11, int r12, int r13) {
        if (r13 != 0) goto L5;
        return 0;
    L5:
        int r14 = (r5 * 255) * r10;
        int r15 = 255 - r10;
        return ((r15 * (r11 * r12)) + r14) / (r13 * 255);
    }

    private static float constrain(float r5, float r10, float r11) {
        if (r5 >= r10) goto L6;
        return r10;
    L6:
        return Math.min(r5, r11);
    }

    public static double distanceEuclidean(@NonNull double[] r10, @NonNull double[] r11) {
        double r5 = Math.pow(r10[0] - r11[0], 2.0d);
        double r12 = Math.pow(r10[1] - r11[1], 2.0d) + r5;
        return Math.sqrt(Math.pow(r10[2] - r11[2], 2.0d) + r12);
    }

    private static double[] getTempDouble3Array() {
        ThreadLocal<double[]> r5 = TEMP_ARRAY;
        double[] r10 = r5.get();
        if (r10 != null) goto L6;
        double[] r11 = new double[3];
        r5.set(r11);
        return r11;
    L6:
        return r10;
    }

    private static double pivotXyzComponent(double r5) {
        if (r5 <= XYZ_EPSILON) goto L6;
        return Math.pow(r5, 0.3333333333333333d);
    L6:
        return ((r5 * XYZ_KAPPA) + 16.0d) / 116.0d;
    }

    @ColorInt
    public static int setAlphaComponent(@ColorInt int r5, @IntRange(from = 0, to = 255) int r10) {
        if (r10 < 0) goto L8;
        if (r10 > 255) goto L8;
        return (r5 & ViewCompat.MEASURED_SIZE_MASK) | (r10 << 24);
    L8:
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    private static int constrain(int r5, int r10, int r11) {
        if (r5 >= r10) goto L5;
        return r10;
    L5:
        return Math.min(r5, r11);
    }

    @NonNull
    @RequiresApi(26)
    public static Color compositeColors(@NonNull Color r5, @NonNull Color r10) {
        return Api26Impl.compositeColors(r5, r10);
    }
}
