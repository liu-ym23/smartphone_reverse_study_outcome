package wg;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.k1;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final void a(View r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$detachParent");
        ViewParent r0 = r10.getParent();
        if ((r0 instanceof ViewGroup) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L9;
        r1.removeView(r10);
        return;
    }

    public static final float b(View r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$getVisibleAreaRatioInScreen");
        if (r10.getHeight() != 0) goto L5;
    L12:
        return 0.0f;
    L5:
        if (r10.getWidth() == 0) goto L12;
        int[] r0 = c(r10);
        int[] r11 = new int[2];
        Context r12 = k1.c();
        if (r12 == null) goto L10;
        Resources r13 = r12.getResources();
        DisplayMetrics r14 = WindowDisplayMetricsOverride.apply(r13, r13.getDisplayMetrics());
        r11 = new int[]{r14.widthPixels, r14.heightPixels};
    L10:
        int r15 = r0[0];
        int r1 = r0[1];
        int r16 = r11[0];
        int r17 = r11[1];
        int r18 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r15, 0), r16);
        return RangesKt.coerceAtMost(RangesKt.coerceAtLeast((((RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r1 + r10.getHeight(), 0), r17) - RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r1, 0), r17)) * 1.0f) * (RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r15 + r10.getWidth(), 0), r16) - r18)) / RangesKt.coerceAtLeast(r10.getHeight() * r10.getWidth(), 1), 0.0f), 1.0f);
    }

    public static final int[] c(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$locationInScreen");
        int[] r0 = new int[2];
        r1.getLocationOnScreen(r0);
        return r0;
    }

    public static final void d(View r1, int r10) {
        Intrinsics.checkNotNullParameter(r1, "$this$setHeight");
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        if (r0 == null) goto L5;
        r0.height = r10;
    L5:
        r1.setLayoutParams(r0);
    }

    public static final void g(TextView r1, int r10) {
        Intrinsics.checkNotNullParameter(r1, "$this$setTextSizeDp");
        r1.setTextSize(1, r10);
    }

    public static final void h(View r1, boolean r10) {
        Intrinsics.checkNotNullParameter(r1, "$this$setVisible");
        if (r10 == false) goto L5;
        int r11 = 0;
    L6:
        r1.setVisibility(r11);
        return;
    L5:
        r11 = 8;
        goto L6
    }

    public static final void i(View r1, int r10) {
        Intrinsics.checkNotNullParameter(r1, "$this$setWidth");
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        if (r0 == null) goto L5;
        r0.width = r10;
    L5:
        r1.setLayoutParams(r0);
    }

    public static /* synthetic */ void f(View r10, int r11, int r12, int r13, int r14) {
        e(r10, r11, r12, r13, r14, false);
    }

    public static final void e(View r1, int r10, int r11, int r12, int r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r1, "$this$setMargins");
        if ((r1.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        if (r0 == null) goto L11;
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r0;
        r15.setMargins(r10, r11, r12, r13);
        if (r14 == false) goto L9;
        r15.setMarginEnd(r12);
        r15.setMarginStart(r10);
    L9:
        r1.setLayoutParams(r15);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
}
