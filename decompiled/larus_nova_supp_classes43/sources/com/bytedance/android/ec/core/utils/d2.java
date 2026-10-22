package com.bytedance.android.ec.core.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d2 {
    public static final void a(View r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$setBottomMargin");
        ViewGroup.LayoutParams r0 = r10.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        if (r1 == null) goto L9;
        r1.bottomMargin = r11;
        Unit r12 = Unit.INSTANCE;
        r10.setLayoutParams(r1);
        return;
    }

    public static final void b(View r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$setGravity");
        ViewGroup.LayoutParams r0 = r10.getLayoutParams();
        if ((r0 instanceof FrameLayout.LayoutParams) == true) goto L5;
        r0 = null;
    L5:
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        if (r1 == null) goto L9;
        r1.gravity = r11;
        Unit r12 = Unit.INSTANCE;
        r10.setLayoutParams(r1);
        return;
    }

    public static final void c(View r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$setLeftMargin");
        ViewGroup.LayoutParams r0 = r10.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        if (r1 == null) goto L9;
        r1.leftMargin = r11;
        Unit r12 = Unit.INSTANCE;
        r10.setLayoutParams(r1);
        return;
    }

    public static final void e(View r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$setRightMargin");
        ViewGroup.LayoutParams r0 = r10.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        if (r1 == null) goto L9;
        r1.rightMargin = r11;
        Unit r12 = Unit.INSTANCE;
        r10.setLayoutParams(r1);
        return;
    }

    public static final void f(View r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$setTopMargin");
        ViewGroup.LayoutParams r0 = r10.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        if (r1 == null) goto L9;
        r1.topMargin = r11;
        Unit r12 = Unit.INSTANCE;
        r10.setLayoutParams(r1);
        return;
    }

    public static final void d(View r10, int r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "$this$setMargins");
        ViewGroup.LayoutParams r0 = r10.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        if (r1 == null) goto L9;
        r1.setMargins(r11, r12, r13, r14);
        Unit r15 = Unit.INSTANCE;
        r10.setLayoutParams(r1);
        return;
    }
}
