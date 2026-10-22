package androidx.core.util;

import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class TypedValueCompat {
    private static final float INCHES_PER_MM = 0.03937008f;
    private static final float INCHES_PER_PT = 0.013888889f;

    private static class Api34Impl {
        private Api34Impl() {
        }

        public static float deriveDimension(int r0, float r1, DisplayMetrics r2) {
            return TypedValue.deriveDimension(r0, r1, r2);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ComplexDimensionUnit {
    }

    private TypedValueCompat() {
    }

    public static float deriveDimension(int r2, float r3, DisplayMetrics r4) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        if (r2 != 0) goto L8;
        return r3;
    L8:
        if (r2 == 1) goto L38;
        if (r2 == 2) goto L34;
        if (r2 == 3) goto L30;
        if (r2 == 4) goto L26;
        if (r2 != 5) goto L24;
        if (r4.xdpi != 0.0f) goto L20;
        return 0.0f;
    L20:
        r3 = r3 / r4.xdpi;
        float r5 = INCHES_PER_MM;
    L22:
        return r3 / r5;
    L24:
        throw new IllegalArgumentException("Invalid unitToConvertTo " + r2);
    L26:
        if (r4.xdpi != 0.0f) goto L28;
        return 0.0f;
    L28:
        r5 = r4.xdpi;
        goto L22
    L30:
        if (r4.xdpi != 0.0f) goto L32;
        return 0.0f;
    L32:
        r3 = r3 / r4.xdpi;
        r5 = INCHES_PER_PT;
        goto L22
    L34:
        if (r4.scaledDensity != 0.0f) goto L36;
        return 0.0f;
    L36:
        r5 = r4.scaledDensity;
        goto L22
    L38:
        if (r4.density != 0.0f) goto L40;
        return 0.0f;
    L40:
        r5 = r4.density;
        goto L22
    L5:
        return Api34Impl.deriveDimension(r2, r3, r4);
    }

    public static float dpToPx(float r1, DisplayMetrics r2) {
        return TypedValue.applyDimension(1, r1, r2);
    }

    public static int getUnitFromComplexDimension(int r0) {
        return (r0 >> 0) & 15;
    }

    public static float pxToDp(float r1, DisplayMetrics r2) {
        return deriveDimension(1, r1, r2);
    }

    public static float pxToSp(float r1, DisplayMetrics r2) {
        return deriveDimension(2, r1, r2);
    }

    public static float spToPx(float r1, DisplayMetrics r2) {
        return TypedValue.applyDimension(2, r1, r2);
    }
}
