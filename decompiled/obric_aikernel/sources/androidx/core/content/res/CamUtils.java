package androidx.core.content.res;

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

    static int intFromLStar(float r15) {
        if (r15 >= 1.0f) goto L7;
        return ViewCompat.MEASURED_STATE_MASK;
    L7:
        if (r15 <= 99.0f) goto L10;
        return -1;
    L10:
        float r10 = (r15 + 16.0f) / 116.0f;
        if (r15 <= 8.0f) goto L13;
        boolean r11 = true;
    L14:
        if (r11 == false) goto L16;
        float r16 = (r10 * r10) * r10;
    L17:
        float r12 = (r10 * r10) * r10;
        if (r12 <= 0.008856452f) goto L20;
        boolean r13 = true;
    L21:
        if (r13 == false) goto L23;
        float r14 = r12;
    L24:
        if (r13 == true) goto L27;
        r12 = ((r10 * 116.0f) - 16.0f) / 903.2963f;
    L27:
        float[] r17 = WHITE_POINT_D65;
        return ColorUtils.XYZToColor(r14 * r17[0], r16 * r17[1], r12 * r17[2]);
    L23:
        r14 = ((r10 * 116.0f) - 16.0f) / 903.2963f;
        goto L24
    L20:
        r13 = false;
        goto L21
    L16:
        r16 = r15 / 903.2963f;
        goto L17
    L13:
        r11 = false;
        goto L14
    }

    static float lStarFromInt(int r10) {
        return lStarFromY(yFromInt(r10));
    }

    static float lStarFromY(float r10) {
        float r11 = r10 / 100.0f;
        if (r11 > 0.008856452f) goto L7;
        return r11 * 903.2963f;
    L7:
        return (((float) Math.cbrt(r11)) * 116.0f) - 16.0f;
    }

    static float lerp(float r10, float r11, float r12) {
        return r10 + ((r11 - r10) * r12);
    }

    static float linearized(int r10) {
        float r11 = r10 / 255.0f;
        if (r11 > 0.04045f) goto L7;
        float r12 = r11 / 12.92f;
    L6:
        return r12 * 100.0f;
    L7:
        r12 = (float) Math.pow((r11 + 0.055f) / 1.055f, 2.4000000953674316d);
        goto L6
    }

    @NonNull
    static float[] xyzFromInt(int r10) {
        float r11 = linearized(Color.red(r10));
        float r12 = linearized(Color.green(r10));
        float r13 = linearized(Color.blue(r10));
        float[][] r14 = SRGB_TO_XYZ;
        return new float[]{((r14[0][0] * r11) + (r14[0][1] * r12)) + (r14[0][2] * r13), ((r14[1][0] * r11) + (r14[1][1] * r12)) + (r14[1][2] * r13), ((r11 * r14[2][0]) + (r12 * r14[2][1])) + (r13 * r14[2][2])};
    }

    static float yFromInt(int r10) {
        float r11 = linearized(Color.red(r10));
        float r12 = linearized(Color.green(r10));
        float r13 = linearized(Color.blue(r10));
        float[][] r14 = SRGB_TO_XYZ;
        return ((r11 * r14[1][0]) + (r12 * r14[1][1])) + (r13 * r14[1][2]);
    }

    static float yFromLStar(float r10) {
        if (r10 <= 8.0f) goto L7;
        float r11 = (float) Math.pow((((double) r10) + 16.0d) / 116.0d, 3.0d);
    L6:
        return r11 * 100.0f;
    L7:
        r11 = r10 / 903.2963f;
        goto L6
    }
}
