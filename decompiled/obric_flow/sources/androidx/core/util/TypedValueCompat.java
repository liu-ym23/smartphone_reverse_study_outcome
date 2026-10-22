package androidx.core.util;

import ai.j0;
import android.annotation.SuppressLint;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class TypedValueCompat {
    private static final float INCHES_PER_MM = 0.03937008f;
    private static final float INCHES_PER_PT = 0.013888889f;

    @RequiresApi(34)
    public static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        public static float deriveDimension(int r5, float r10, DisplayMetrics r11) {
            return TypedValue.deriveDimension(r5, r10, r11);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ComplexDimensionUnit {
    }

    private TypedValueCompat() {
    }

    public static float deriveDimension(int r5, float r10, @NonNull DisplayMetrics r11) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        if (r5 != 0) goto L8;
        return r10;
    L8:
        if (r5 != 1) goto L10;
        float r12 = r11.density;
        if (r12 != 0.0f) goto L43;
        return 0.0f;
    L43:
        return r10 / r12;
    L10:
        if (r5 != 2) goto L12;
        float r13 = r11.scaledDensity;
        if (r13 != 0.0f) goto L38;
        return 0.0f;
    L38:
        return r10 / r13;
    L12:
        if (r5 != 3) goto L14;
        float r14 = r11.xdpi;
        if (r14 != 0.0f) goto L33;
        return 0.0f;
    L33:
        float r15 = r10 / r14;
        float r16 = INCHES_PER_PT;
    L22:
        return r15 / r16;
    L14:
        if (r5 != 4) goto L16;
        float r17 = r11.xdpi;
        if (r17 != 0.0f) goto L29;
        return 0.0f;
    L29:
        return r10 / r17;
    L16:
        if (r5 != 5) goto L24;
        float r18 = r11.xdpi;
        if (r18 != 0.0f) goto L20;
        return 0.0f;
    L20:
        r15 = r10 / r18;
        r16 = INCHES_PER_MM;
        goto L22
    L24:
        throw new IllegalArgumentException(j0.g(r5, "Invalid unitToConvertTo "));
    L5:
        return Api34Impl.deriveDimension(r5, r10, r11);
    }

    public static float dpToPx(float r5, @NonNull DisplayMetrics r10) {
        return TypedValue.applyDimension(1, r5, r10);
    }

    @SuppressLint({"WrongConstant"})
    public static int getUnitFromComplexDimension(int r5) {
        return r5 & 15;
    }

    public static float pxToDp(float r5, @NonNull DisplayMetrics r10) {
        return deriveDimension(1, r5, r10);
    }

    public static float pxToSp(float r5, @NonNull DisplayMetrics r10) {
        return deriveDimension(2, r5, r10);
    }

    public static float spToPx(float r5, @NonNull DisplayMetrics r10) {
        return TypedValue.applyDimension(2, r5, r10);
    }
}
