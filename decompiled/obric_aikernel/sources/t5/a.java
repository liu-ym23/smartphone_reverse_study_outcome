package t5;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.resources.b;

/* JADX INFO: loaded from: classes.dex */
public class a {
    @ColorInt
    public static int a(@ColorInt int r10, @IntRange(from = 0, to = 255) int r11) {
        return ColorUtils.setAlphaComponent(r10, (Color.alpha(r10) * r11) / 255);
    }

    @ColorInt
    public static int b(@NonNull Context r10, @AttrRes int r11, @ColorInt int r12) {
        TypedValue r13 = b.a(r10, r11);
        if (r13 != null) goto L5;
        return r12;
    L5:
        return r13.data;
    }

    @ColorInt
    public static int c(Context r10, @AttrRes int r11, String r12) {
        return b.d(r10, r11, r12);
    }

    @ColorInt
    public static int d(@NonNull View r10, @AttrRes int r11) {
        return b.e(r10, r11);
    }

    @ColorInt
    public static int e(@NonNull View r10, @AttrRes int r11, @ColorInt int r12) {
        return b(r10.getContext(), r11, r12);
    }

    public static boolean f(@ColorInt int r10) {
        if (r10 != 0) goto L4;
    L6:
        return false;
    L4:
        if (ColorUtils.calculateLuminance(r10) <= 0.5d) goto L6;
        return true;
    }

    @ColorInt
    public static int g(@ColorInt int r10, @ColorInt int r11) {
        return ColorUtils.compositeColors(r11, r10);
    }

    @ColorInt
    public static int h(@ColorInt int r10, @ColorInt int r11, @FloatRange(from = 0.0d, to = 1.0d) float r12) {
        return g(r10, ColorUtils.setAlphaComponent(r11, Math.round(Color.alpha(r11) * r12)));
    }

    @ColorInt
    public static int i(@NonNull View r10, @AttrRes int r11, @AttrRes int r12, @FloatRange(from = 0.0d, to = 1.0d) float r13) {
        return h(d(r10, r11), d(r10, r12), r13);
    }
}
