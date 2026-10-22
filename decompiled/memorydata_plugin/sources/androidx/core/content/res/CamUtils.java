package androidx.core.content.res;

import android.graphics.Color;
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
        float r1 = (r15 + 16.0f) / 116.0f;
        if (r15 <= 8.0f) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L16;
        float r16 = (r1 * r1) * r1;
    L17:
        float r6 = (r1 * r1) * r1;
        if (r6 <= 0.008856452f) goto L20;
        boolean r4 = true;
    L21:
        if (r4 == false) goto L23;
        float r8 = r6;
    L24:
        if (r4 == true) goto L27;
        r6 = ((r1 * 116.0f) - 16.0f) / 903.2963f;
    L27:
        float[] r0 = WHITE_POINT_D65;
        return ColorUtils.XYZToColor(r8 * r0[0], r16 * r0[1], r6 * r0[2]);
    L23:
        r8 = ((r1 * 116.0f) - 16.0f) / 903.2963f;
        goto L24
    L20:
        r4 = false;
        goto L21
    L16:
        r16 = r15 / 903.2963f;
        goto L17
    L13:
        r5 = false;
        goto L14
    }

    static float lStarFromInt(int r0) {
        return lStarFromY(yFromInt(r0));
    }

    static float lStarFromY(float r2) {
        float r3 = r2 / 100.0f;
        if (r3 > 0.008856452f) goto L7;
        return r3 * 903.2963f;
    L7:
        return (((float) Math.cbrt(r3)) * 116.0f) - 16.0f;
    }

    static float lerp(float r0, float r1, float r2) {
        return r0 + ((r1 - r0) * r2);
    }

    static float linearized(int r6) {
        float r7 = r6 / 255.0f;
        if (r7 > 0.04045f) goto L7;
        float r8 = r7 / 12.92f;
    L6:
        return r8 * 100.0f;
    L7:
        r8 = (float) Math.pow((r7 + 0.055f) / 1.055f, 2.4000000953674316d);
        goto L6
    }

    static void xyzFromInt(int r8, float[] r9) {
        float r0 = linearized(Color.red(r8));
        float r1 = linearized(Color.green(r8));
        float r10 = linearized(Color.blue(r8));
        float[][] r2 = SRGB_TO_XYZ;
        r9[0] = ((r2[0][0] * r0) + (r2[0][1] * r1)) + (r2[0][2] * r10);
        r9[1] = ((r2[1][0] * r0) + (r2[1][1] * r1)) + (r2[1][2] * r10);
        r9[2] = ((r0 * r2[2][0]) + (r1 * r2[2][1])) + (r10 * r2[2][2]);
    }

    static float yFromInt(int r6) {
        float r0 = linearized(Color.red(r6));
        float r1 = linearized(Color.green(r6));
        float r7 = linearized(Color.blue(r6));
        float[][] r2 = SRGB_TO_XYZ;
        return ((r0 * r2[1][0]) + (r1 * r2[1][1])) + (r7 * r2[1][2]);
    }

    static float yFromLStar(float r6) {
        if (r6 <= 8.0f) goto L7;
        float r7 = (float) Math.pow((((double) r6) + 16.0d) / 116.0d, 3.0d);
    L6:
        return r7 * 100.0f;
    L7:
        r7 = r6 / 903.2963f;
        goto L6
    }
}
