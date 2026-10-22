package com.obric.miniapp.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.caverock.androidsvg.SVG;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f1 {
    public static final o0 a(SVG r12, Context r13) {
        Resources r0 = r13.getResources();
        DisplayMetrics r1 = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics());
        Float r2 = Float.valueOf(r1.density);
        if (r2.floatValue() <= 0.0f) goto L5;
        boolean r3 = true;
    L6:
        Float r6 = null;
        if (r3 == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L12;
        float r4 = r2.floatValue();
    L13:
        SVG.d0 r5 = r12.a;
        if (r5 == null) goto L81;
        SVG.b r7 = ((SVG.p0) r5).p;
        if (r7 != null) goto L18;
        RectF r8 = null;
    L20:
        if (r12.a == null) goto L79;
        Float r9 = Float.valueOf(r12.a(r12.b).c);
        float r10 = r9.floatValue();
        if (Float.isInfinite(r10) == false) goto L24;
    L26:
        boolean r11 = false;
    L27:
        if (r11 == true) goto L29;
    L31:
        boolean r14 = false;
    L32:
        if (r14 == true) goto L35;
        r9 = null;
    L35:
        if (r9 != null) goto L41;
        if (r8 == null) goto L39;
        r9 = Float.valueOf(r8.width());
    L40:
        if (r9 != null) goto L41;
        float r15 = 24.0f;
    L44:
        if (r12.a == null) goto L77;
        Float r16 = Float.valueOf(r12.a(r12.b).d);
        float r17 = r16.floatValue();
        if (Float.isInfinite(r17) == false) goto L48;
    L50:
        boolean r18 = false;
    L51:
        if (r18 == true) goto L53;
    L55:
        boolean r19 = false;
    L56:
        if (r19 == true) goto L59;
        r16 = null;
    L59:
        if (r16 == null) goto L61;
        float r20 = r16.floatValue();
    L66:
        int r21 = (int) Math.ceil(r15 * r4);
        float r22 = 24;
        Resources r23 = Resources.getSystem();
        int r24 = RangesKt.coerceAtLeast(r21, MathKt.roundToInt(TypedValue.applyDimension(1, r22, WindowDisplayMetricsOverride.apply(r23, r23.getDisplayMetrics()))));
        int r25 = (int) Math.ceil(r20 * r4);
        Resources r26 = Resources.getSystem();
        int r27 = RangesKt.coerceAtLeast(r25, MathKt.roundToInt(TypedValue.applyDimension(1, r22, WindowDisplayMetricsOverride.apply(r26, r26.getDisplayMetrics()))));
        int r28 = r24 * 3;
        int r29 = r27 * 3;
        float r30 = r28;
        SVG.d0 r31 = r12.a;
        if (r31 == null) goto L75;
        r31.s = new SVG.o(r30);
        float r32 = r29;
        SVG.d0 r33 = r12.a;
        if (r33 == null) goto L73;
        r33.t = new SVG.o(r32);
        Bitmap r34 = Bitmap.createBitmap(r28, r29, Bitmap.Config.ARGB_8888);
        r34.setDensity(r1.densityDpi * 3);
        r12.e(new Canvas(r34));
        o0 r110 = new o0(r13.getResources(), r34, r24, r27);
        r110.setAntiAlias(true);
        r110.setFilterBitmap(true);
        r110.setBounds(0, 0, r24, r27);
        return r110;
    L73:
        throw new IllegalArgumentException("SVG document is empty");
    L75:
        throw new IllegalArgumentException("SVG document is empty");
    L61:
        if (r8 == null) goto L63;
        r6 = Float.valueOf(r8.height());
    L63:
        if (r6 == null) goto L65;
        r20 = r6.floatValue();
        goto L66
    L65:
        r20 = r15;
        goto L66
    L53:
        if (r17 <= 0.0f) goto L55;
        r19 = true;
        goto L56
    L48:
        if (Float.isNaN(r17) == true) goto L50;
        r18 = true;
        goto L51
    L77:
        throw new IllegalArgumentException("SVG document is empty");
    L39:
        r9 = null;
    L41:
        r15 = r9.floatValue();
        goto L44
    L29:
        if (r10 <= 0.0f) goto L31;
        r14 = true;
        goto L32
    L24:
        if (Float.isNaN(r10) == true) goto L26;
        r11 = true;
        goto L27
    L79:
        throw new IllegalArgumentException("SVG document is empty");
    L18:
        float r35 = r7.a;
        float r111 = r7.b;
        r8 = new RectF(r35, r111, r7.c + r35, r7.d + r111);
        goto L20
    L81:
        throw new IllegalArgumentException("SVG document is empty");
    L12:
        r4 = 1.0f;
        goto L13
    L5:
        r3 = false;
        goto L6
    }
}
