package com.obric.assistant.omnidetailpage.blockview;

import android.util.Size;
import kotlin.NoWhenBranchMatchedException;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class n0 {
    public static final Size a(ifa.c r4, int r5, int r6) {
        boolean r0 = r4 instanceof ifa.c.a;
        if (r0 == false) goto L6;
        Integer r1 = ((ifa.c.a) r4).e;
    L8:
        int r2 = 0;
        if (r1 == null) goto L11;
        int r3 = r1.intValue();
    L12:
        if (r0 == false) goto L15;
        Integer r7 = ((ifa.c.a) r4).f;
    L17:
        if (r7 == null) goto L19;
        r2 = r7.intValue();
    L19:
        boolean r8 = r4 instanceof ifa.c.b;
        int r9 = RangesKt.coerceAtLeast(r5, 1);
        if (r6 <= 1) goto L22;
        int r10 = RangesKt.coerceAtMost(MathKt.roundToInt(r9 * 0.8f), i5.a0());
    L23:
        if (r3 <= 0) goto L43;
        if (r2 <= 0) goto L43;
        float r11 = r2 / r3;
        if (r11 <= 1.7777778f) goto L29;
        r11 = 1.7777778f;
    L29:
        if (r8 == false) goto L31;
        float r12 = 0.42857143f;
    L33:
        if (r11 >= r12) goto L35;
        r11 = r12;
    L35:
        int r13 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r5, 1), i5.a0());
        if (r11 <= 1.0f) goto L40;
        int r14 = (int) (r13 / r11);
        if (r14 >= r10) goto L40;
        r10 = r14;
    L48:
        return new Size(RangesKt.coerceAtLeast(r10, 1), RangesKt.coerceAtLeast(r13, 1));
    L40:
        r13 = (int) (r10 * r11);
        goto L48
    L31:
        r12 = 0.5625f;
    L43:
        return new Size(RangesKt.coerceAtLeast(r10, 1), RangesKt.coerceAtLeast(r10, 1));
    L22:
        r10 = RangesKt.coerceAtMost(r9, i5.a0());
        goto L23
    L15:
        if ((r4 instanceof ifa.c.b) == false) goto L45;
        r7 = ((ifa.c.b) r4).j;
        goto L17
    L45:
        throw new NoWhenBranchMatchedException();
    L11:
        r3 = 0;
        goto L12
    L6:
        if ((r4 instanceof ifa.c.b) == false) goto L47;
        r1 = ((ifa.c.b) r4).i;
        goto L8
    L47:
        throw new NoWhenBranchMatchedException();
    }
}
