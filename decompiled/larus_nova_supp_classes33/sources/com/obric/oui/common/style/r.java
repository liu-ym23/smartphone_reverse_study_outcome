package com.obric.oui.common.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import com.obric.common.oea.foundation.graphics.smoothcorner.SmoothCornerHelper;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class r {
    public static final SmoothCornerHelper a = null;
    public static final SmoothCornerHelper b = null;
    public static final SmoothCornerHelper c = null;
    public static final SmoothCornerHelper d = null;
    public static final boolean e = false;
    public static final boolean f = false;

    static {
        a = new SmoothCornerHelper();
        SmoothCornerHelper r0 = new SmoothCornerHelper();
        r0.b(SmoothCornerHelper.Companion.CurveType.BASIC);
        b = r0;
        SmoothCornerHelper r1 = new SmoothCornerHelper();
        r1.b(SmoothCornerHelper.Companion.CurveType.SKETCH);
        c = r1;
        SmoothCornerHelper r2 = new SmoothCornerHelper();
        r2.b(SmoothCornerHelper.Companion.CurveType.QUADRATIC_CAPSULE);
        d = r2;
        e = !TextUtils.equals("HUAWEI", Build.BRAND);
        f = true;
    }

    public static Path a(RectF r7, float r8) {
        Intrinsics.checkNotNullParameter(r7, "rect");
        float r6 = c(r8, r7);
        SmoothCornerHelper r9 = b(r6, Math.min(r7.width(), r7.height()));
        Rect r1 = new Rect();
        r7.roundOut(r1);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r1, "rect");
        return r9.a.a(r1.left, r1.top, r1.right, r1.bottom, r6);
    }

    public static SmoothCornerHelper b(float r2, float r3) {
        if (f == true) goto L5;
        SmoothCornerHelper r0 = a;
        if (r0.a.c(r2, r3) == true) goto L14;
        SmoothCornerHelper r1 = c;
        if (r1.a.c(r2, r3) == false) goto L13;
        return r1;
    L13:
        return d;
    L14:
        return r0;
    L5:
        return b;
    }

    public static float c(float r2, RectF r3) {
        if (r3.isEmpty() == false) goto L7;
        wma.b.b("SmoothCornerH", "decideValidCornerRadius: rectF is empty");
        return 0.0f;
    L7:
        return RangesKt.coerceAtLeast(Math.min(r2, Math.min(r3.width(), r3.height()) / 2.0f), 0.0f);
    }

    @JvmStatic
    public static final void e(Canvas r10, RectF r11, float r12, Paint r13) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        Intrinsics.checkNotNullParameter(r11, "rectF");
        Intrinsics.checkNotNullParameter(r13, "paint");
        float r9 = c(r12, r11);
        SmoothCornerHelper r2 = b(r9, Math.min(r11.width(), r11.height()));
        r2.getClass();
        Intrinsics.checkNotNullParameter(r10, "canvas");
        Intrinsics.checkNotNullParameter(r11, "rect");
        Intrinsics.checkNotNullParameter(r13, "paint");
        if (r11.isEmpty() == false) goto L5;
        mja.a.C0063a r14 = mja.a.a;
        mja.a.b("SmoothCornerHelper", "empty rect: " + r11);
        return;
    L5:
        r2.a(r10, r13, r11.left, r11.top, r11.right, r11.bottom, r9);
    }

    @JvmStatic
    public static final void d(Canvas r9, float r10, float r11, float r12, float r13, float r14, Paint r15) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        Intrinsics.checkNotNullParameter(r15, "paint");
        float r0 = r12 - r10;
        float r4 = r13 - r11;
        float r8 = RangesKt.coerceAtLeast(Math.min(r14, Math.min(Math.abs(r0), Math.abs(r4)) / 2.0f), 0.0f);
        b(r8, Math.min(Math.abs(r0), Math.abs(r4))).a(r9, r15, r10, r11, r12, r13, r8);
    }
}
