package androidx.core.content.res;

import ai.j0;
import android.graphics.Color;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
final class CamUtils {
    static final float[][] CAM16RGB_TO_XYZ = null;
    static final float[][] SRGB_TO_XYZ = null;
    static final float[] WHITE_POINT_D65 = null;
    static final float[][] XYZ_TO_CAM16RGB = null;

    static {
        XYZ_TO_CAM16RGB = new float[][]{new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
        CAM16RGB_TO_XYZ = new float[][]{new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};
        WHITE_POINT_D65 = new float[]{95.047f, 100.0f, 108.883f};
        SRGB_TO_XYZ = new float[][]{new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};
    }

    private CamUtils() {
    }

    public static int intFromLStar(float r15) {
        if (r15 >= 1.0f) goto L7;
        return ViewCompat.MEASURED_STATE_MASK;
    L7:
        if (r15 <= 99.0f) goto L10;
        return -1;
    L10:
        float r5 = (r15 + 16.0f) / 116.0f;
        if (r15 <= 8.0f) goto L13;
        float r16 = (r5 * r5) * r5;
    L14:
        float r10 = (r5 * r5) * r5;
        if (r10 <= 0.008856452f) goto L17;
        boolean r11 = true;
    L18:
        if (r11 == false) goto L20;
        float r12 = r10;
    L21:
        if (r11 == true) goto L24;
        r10 = ((r5 * 116.0f) - 16.0f) / 903.2963f;
    L24:
        float[] r13 = WHITE_POINT_D65;
        return ColorUtils.XYZToColor(r12 * r13[0], r16 * r13[1], r10 * r13[2]);
    L20:
        r12 = ((r5 * 116.0f) - 16.0f) / 903.2963f;
        goto L21
    L17:
        r11 = false;
        goto L18
    L13:
        r16 = r15 / 903.2963f;
        goto L14
    }

    public static float lStarFromInt(int r5) {
        return lStarFromY(yFromInt(r5));
    }

    public static float lStarFromY(float r5) {
        float r10 = r5 / 100.0f;
        if (r10 > 0.008856452f) goto L7;
        return r10 * 903.2963f;
    L7:
        return (((float) Math.cbrt(r10)) * 116.0f) - 16.0f;
    }

    public static float lerp(float r5, float r10, float r11) {
        return j0.b(r10, r5, r11, r5);
    }

    public static float linearized(int r10) {
        float r11 = r10 / 255.0f;
        if (r11 > 0.04045f) goto L7;
        float r12 = r11 / 12.92f;
    L6:
        return r12 * 100.0f;
    L7:
        r12 = (float) Math.pow((r11 + 0.055f) / 1.055f, 2.4000000953674316d);
        goto L6
    }

    public static void xyzFromInt(int r10, @NonNull float[] r11) {
        float r5 = linearized(Color.red(r10));
        float r12 = linearized(Color.green(r10));
        float r13 = linearized(Color.blue(r10));
        float[][] r14 = SRGB_TO_XYZ;
        float[] r15 = r14[0];
        float r16 = r15[0] * r5;
        float r17 = (r15[1] * r12) + r16;
        r11[0] = (r15[2] * r13) + r17;
        float[] r18 = r14[1];
        float r19 = r18[0] * r5;
        float r20 = (r18[1] * r12) + r19;
        r11[1] = (r18[2] * r13) + r20;
        float[] r21 = r14[2];
        float r22 = r5 * r21[0];
        float r23 = (r12 * r21[1]) + r22;
        r11[2] = (r13 * r21[2]) + r23;
    }

    public static float yFromInt(int r5) {
        float r10 = linearized(Color.red(r5));
        float r11 = linearized(Color.green(r5));
        float r12 = linearized(Color.blue(r5));
        float[] r13 = SRGB_TO_XYZ[1];
        float r14 = r10 * r13[0];
        float r15 = (r11 * r13[1]) + r14;
        return (r12 * r13[2]) + r15;
    }

    public static float yFromLStar(float r10) {
        if (r10 <= 8.0f) goto L7;
        float r11 = (float) Math.pow((((double) r10) + 16.0d) / 116.0d, 3.0d);
    L6:
        return r11 * 100.0f;
    L7:
        r11 = r10 / 903.2963f;
        goto L6
    }
}
