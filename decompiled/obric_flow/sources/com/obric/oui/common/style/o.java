package com.obric.oui.common.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import com.lynx.serval.svg.SVGRenderEngine;
import com.obric.common.oea.foundation.graphics.smoothcorner.SmoothCornerHelper$Companion$CurveType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pp.b f12520a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final pp.b f12521b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final pp.b f12522c = null;
    public static final pp.b d = null;
    public static final boolean e = false;
    public static final boolean f = false;

    static {
        f12520a = new pp.b();
        pp.b r5 = new pp.b();
        r5.b(SmoothCornerHelper$Companion$CurveType.BASIC);
        f12521b = r5;
        pp.b r10 = new pp.b();
        r10.b(SmoothCornerHelper$Companion$CurveType.SKETCH);
        f12522c = r10;
        pp.b r11 = new pp.b();
        r11.b(SmoothCornerHelper$Companion$CurveType.QUADRATIC_CAPSULE);
        d = r11;
        e = !TextUtils.equals("HUAWEI", Build.BRAND);
        f = true;
    }

    public static Path a(RectF r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, SVGRenderEngine.RECT);
        float r12 = c(r10, r11);
        pp.b r13 = b(r12, Math.min(r10.width(), r10.height()));
        Rect r5 = new Rect();
        r10.roundOut(r5);
        r13.getClass();
        Intrinsics.checkNotNullParameter(r5, SVGRenderEngine.RECT);
        return r13.f21387a.l(r5.left, r5.top, r5.right, r5.bottom, r12);
    }

    public static pp.b b(float r5, float r10) {
        if (f == true) goto L5;
        pp.b r11 = f12520a;
        if (r11.f21387a.n(r5, r10) == true) goto L14;
        pp.b r12 = f12522c;
        if (r12.f21387a.n(r5, r10) == false) goto L13;
        return r12;
    L13:
        return d;
    L14:
        return r11;
    L5:
        return f12521b;
    }

    public static float c(RectF r5, float r10) {
        if (r5.isEmpty() == false) goto L7;
        ps.a.c("SmoothCornerH", "decideValidCornerRadius: rectF is empty");
        return 0.0f;
    L7:
        return RangesKt.coerceAtLeast(Math.min(r10, Math.min(r5.width(), r5.height()) / 2.0f), 0.0f);
    }

    public static final void d(float r10, float r11, float r12, float r13, float r14, Canvas r15, Paint r16) {
        Intrinsics.checkNotNullParameter(r15, "canvas");
        Intrinsics.checkNotNullParameter(r16, "paint");
        float r5 = r12 - r10;
        float r17 = r13 - r11;
        float r18 = RangesKt.coerceAtLeast(Math.min(r14, Math.min(Math.abs(r5), Math.abs(r17)) / 2.0f), 0.0f);
        b(r18, Math.min(Math.abs(r5), Math.abs(r17))).a(r10, r11, r12, r13, r18, r15, r16);
    }

    public static final void e(Canvas r10, RectF r11, float r12, Paint r13) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        Intrinsics.checkNotNullParameter(r11, "rectF");
        Intrinsics.checkNotNullParameter(r13, "paint");
        float r14 = c(r11, r12);
        pp.b r5 = b(r14, Math.min(r11.width(), r11.height()));
        r5.getClass();
        Intrinsics.checkNotNullParameter(r10, "canvas");
        Intrinsics.checkNotNullParameter(r11, SVGRenderEngine.RECT);
        Intrinsics.checkNotNullParameter(r13, "paint");
        if (r11.isEmpty() == false) goto L5;
        rp.b.a("empty rect: " + r11);
        return;
    L5:
        r5.a(r11.left, r11.top, r11.right, r11.bottom, r14, r10, r13);
    }
}
