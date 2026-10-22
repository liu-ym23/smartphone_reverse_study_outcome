package com.bytedance.android.live.revenue.common;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.common.utility.UIUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ViewUtilsKt {
    public static final Sequence<View> a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$children");
        return SequencesKt.sequence(new ViewUtilsKt$children$1(r2, null));
    }

    public static final void e(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$setVisibilityGone");
        UIUtils.setViewVisibility(r1, 8);
    }

    public static final void f(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$setVisibilityVisible");
        UIUtils.setViewVisibility(r1, 0);
    }

    public static final void b(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$layoutMarginBottom");
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r0).bottomMargin = r3;
        r2.setLayoutParams(r0);
        return;
    }

    public static final void c(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$layoutMarginLeft");
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r0).leftMargin = r3;
        r2.setLayoutParams(r0);
        return;
    }

    public static final void d(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$layoutWidth");
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        if (r0 == null) goto L6;
        r0.width = r2;
        r1.setLayoutParams(r0);
        return;
    }

    public static final void g(View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$visibleOrGone");
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }
}
