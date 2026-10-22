package com.bytedance.android.livesdk.chatroom.vs_base.util;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k {
    public static final void a(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$layoutGravity");
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if ((r0 instanceof FrameLayout.LayoutParams) == false) goto L6;
        ((FrameLayout.LayoutParams) r0).gravity = r3;
        r2.setLayoutParams(r0);
        return;
    }

    public static final void b(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$layoutHeight");
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        if (r0 == null) goto L6;
        r0.height = r2;
        r1.setLayoutParams(r0);
        return;
    }

    public static final void c(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$layoutMarginBottom");
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r0).bottomMargin = r3;
        r2.setLayoutParams(r0);
        return;
    }

    public static final void d(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$layoutMarginLeft");
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r0).leftMargin = r3;
        r2.setLayoutParams(r0);
        return;
    }

    public static final void e(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$layoutMarginRight");
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r0).rightMargin = r3;
        r2.setLayoutParams(r0);
        return;
    }

    public static final void f(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$layoutWidth");
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        if (r0 == null) goto L6;
        r0.width = r2;
        r1.setLayoutParams(r0);
        return;
    }
}
