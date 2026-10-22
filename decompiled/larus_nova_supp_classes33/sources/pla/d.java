package pla;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d {
    public static final float h(float r2, float r3) {
        if (r2 != 0.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return 0.0f;
    L9:
        return r2 * r3;
    L5:
        r1 = false;
        goto L6
    }

    public static DisplayMetrics a(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    @Deprecated(message = "use dp2px(dpValue: Int, context: Context) instead")
    public static final int g(int r1) {
        return (int) ((r1 * a(Resources.getSystem()).density) + 0.5f);
    }

    public static final int i(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        DisplayMetrics r2 = a(r1.getResources());
        if (r2 != null) goto L6;
        return 0;
    L6:
        return r2.heightPixels;
    }

    public static final int j(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        DisplayMetrics r2 = a(r1.getResources());
        if (r2 != null) goto L6;
        return 0;
    L6:
        return r2.widthPixels;
    }

    public static final int b(Context r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0;
    L9:
        return MathKt.roundToInt(r3 * a(r2.getResources()).density);
    L5:
        r0 = false;
        goto L6
    }

    public static final int c(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != 0) goto L6;
        return 0;
    L6:
        return b(r1, r2);
    }

    public static final float d(Context r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r4 != 0.0f) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        return 0.0f;
    L9:
        return TypedValue.applyDimension(1, r4, a(r3.getResources()));
    L5:
        r2 = false;
        goto L6
    }

    public static final float e(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != 0) goto L6;
        return 0.0f;
    L6:
        return d(r1, r2);
    }

    public static final float f(float r1, Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return r1 * a(r2.getResources()).density;
    }

    public static final int k(Context r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return MathKt.roundToInt(r2 / a(r1.getResources()).density);
    }

    public static final int l(View r4, double r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r5 != 0.0d) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0;
    L9:
        return m(r4, (float) r5);
    L5:
        r0 = false;
        goto L6
    }

    public static final int m(View r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0;
    L9:
        return MathKt.roundToInt(r3 * a(r2.getResources()).density);
    L5:
        r0 = false;
        goto L6
    }

    public static final int n(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != 0) goto L6;
        return 0;
    L6:
        return m(r1, r2);
    }

    public static final float o(View r3, double r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r4 != 0.0d) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0.0f;
    L9:
        return p(r3, (float) r4);
    L5:
        r0 = false;
        goto L6
    }

    public static final float p(View r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r4 != 0.0f) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        return 0.0f;
    L9:
        return TypedValue.applyDimension(1, r4, a(r3.getResources()));
    L5:
        r2 = false;
        goto L6
    }

    public static final float q(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != 0) goto L6;
        return 0.0f;
    L6:
        return p(r1, r2);
    }

    public static final float r(View r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != 0.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return 0.0f;
    L9:
        return TypedValue.applyDimension(2, r3, a(r2.getResources()));
    L5:
        r1 = false;
        goto L6
    }
}
