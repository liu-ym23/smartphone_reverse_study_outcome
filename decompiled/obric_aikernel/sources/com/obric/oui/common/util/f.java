package com.obric.oui.common.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static final float a(float r10) {
        Resources r11 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r11, "Resources.getSystem()");
        return r10 * r11.getDisplayMetrics().density;
    }

    public static final int b(int r10) {
        Resources r11 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r11, "Resources.getSystem()");
        return (int) ((r10 * r11.getDisplayMetrics().density) + 0.5f);
    }

    public static final int c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$color");
        return Color.parseColor(r10);
    }

    public static final int d(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$getScreenHeight");
        Resources r11 = r10.getResources();
        Intrinsics.checkNotNullExpressionValue(r11, "resources");
        DisplayMetrics r12 = r11.getDisplayMetrics();
        if (r12 != null) goto L7;
        return 0;
    L7:
        return r12.heightPixels;
    }

    public static final int e(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$getScreenWidth");
        Resources r11 = r10.getResources();
        Intrinsics.checkNotNullExpressionValue(r11, "resources");
        DisplayMetrics r12 = r11.getDisplayMetrics();
        if (r12 != null) goto L7;
        return 0;
    L7:
        return r12.widthPixels;
    }

    public static final int f(Context r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$px2dp");
        Resources r12 = r10.getResources();
        Intrinsics.checkNotNullExpressionValue(r12, "resources");
        return MathKt.roundToInt(r11 / r12.getDisplayMetrics().density);
    }
}
