package com.ss.android.lark.keyboard.widget;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m {
    public static void a(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        r1.rightMargin = r3;
        r1.leftMargin = 0;
        r2.requestLayout();
        return;
    }
}
