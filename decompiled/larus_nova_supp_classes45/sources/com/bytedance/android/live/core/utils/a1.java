package com.bytedance.android.live.core.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a1 {
    public static final int d(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$layoutHeight");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.height;
    }

    public static final int e(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$layoutMarginBottom");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r2 = null;
    L5:
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        if (r3 != null) goto L10;
        return 0;
    L10:
        return r3.bottomMargin;
    }

    public static final int f(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$layoutMarginLeft");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r2 = null;
    L5:
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        if (r3 != null) goto L10;
        return 0;
    L10:
        return r3.leftMargin;
    }

    public static final int g(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$layoutMarginRight");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r2 = null;
    L5:
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        if (r3 != null) goto L10;
        return 0;
    L10:
        return r3.rightMargin;
    }

    public static final int h(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$layoutMarginTop");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r2 = null;
    L5:
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        if (r3 != null) goto L10;
        return 0;
    L10:
        return r3.topMargin;
    }

    public static final int i(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$layoutWidth");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.width;
    }

    public static final void j(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$layoutGravity");
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if ((r0 instanceof FrameLayout.LayoutParams) == false) goto L6;
        ((FrameLayout.LayoutParams) r0).gravity = r3;
        r2.setLayoutParams(r0);
        return;
    }

    public static final void k(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$layoutHeight");
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        if (r0 == null) goto L6;
        r0.height = r2;
        r1.setLayoutParams(r0);
        return;
    }

    public static final void l(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$layoutMarginBottom");
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r0).bottomMargin = r3;
        r2.setLayoutParams(r0);
        return;
    }

    public static final void m(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$layoutMarginLeft");
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r0).leftMargin = r3;
        r2.setLayoutParams(r0);
        return;
    }

    public static final void n(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$layoutMarginRight");
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r0).rightMargin = r3;
        r2.setLayoutParams(r0);
        return;
    }

    public static final void o(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$layoutMarginTop");
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r0).topMargin = r3;
        r2.setLayoutParams(r0);
        return;
    }

    public static final void p(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$layoutWidth");
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        if (r0 == null) goto L6;
        r0.width = r2;
        r1.setLayoutParams(r0);
        return;
    }

    public static void a(FrameLayout r8, View r9, Integer r11, Integer r12, Integer r13, int r14) {
        if ((r14 & 8) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 16) == 0) goto L8;
        Integer r4 = null;
    L10:
        if ((r14 & 128) == 0) goto L12;
        Integer r7 = null;
    L13:
        Intrinsics.checkNotNullParameter(r8, "$this$addView");
        Intrinsics.checkNotNullParameter(r9, "view");
        r8.addView(r9, b(r9.getLayoutParams(), null, null, r11, r4, null, null, r7));
        return;
    L12:
        r7 = r13;
        goto L13
    L8:
        r4 = r12;
        goto L10
    }

    public static final FrameLayout.LayoutParams b(ViewGroup.LayoutParams r2, Integer r3, Integer r4, Integer r5, Integer r6, Integer r7, Integer r8, Integer r9) {
        if ((r2 instanceof FrameLayout.LayoutParams) == false) goto L10;
        if (r2 == null) goto L8;
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams) r2);
        r0.gravity = ((FrameLayout.LayoutParams) r2).gravity;
    L16:
        if (r3 == null) goto L18;
        r0.width = r3.intValue();
    L18:
        if (r4 == null) goto L20;
        r0.height = r4.intValue();
    L20:
        if (r9 == null) goto L22;
        r0.gravity = r9.intValue();
    L22:
        if (r5 == null) goto L24;
        r0.leftMargin = r5.intValue();
    L24:
        if (r6 == null) goto L26;
        r0.topMargin = r6.intValue();
    L26:
        if (r7 == null) goto L28;
        r0.rightMargin = r7.intValue();
    L28:
        if (r8 == null) goto L30;
        r0.bottomMargin = r8.intValue();
    L30:
        return r0;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L10:
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        r0 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams) r2);
        goto L16
    L13:
        if ((r2 instanceof ViewGroup.LayoutParams) == false) goto L15;
        r0 = new FrameLayout.LayoutParams(r2);
        goto L16
    L15:
        r0 = new FrameLayout.LayoutParams(0, 0, 0);
        goto L16
    }

    public static /* synthetic */ FrameLayout.LayoutParams c(ViewGroup.LayoutParams r2, Integer r3, Integer r4, Integer r5, Integer r6, Integer r7, Integer r8, int r9) {
        if ((r9 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r9 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r9 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r9 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r9 & 16) == 0) goto L18;
        r7 = null;
    L18:
        if ((r9 & 32) == 0) goto L21;
        r8 = null;
    L21:
        return b(r2, r3, r4, r5, r6, r7, r8, null);
    }
}
