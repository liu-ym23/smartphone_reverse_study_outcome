package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h {
    public static void a(View r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "action");
        r3.setOnClickListener(new f(500, r4));
    }

    public static void b(View r2, Integer r3, Integer r4, int r5) {
        ViewGroup.MarginLayoutParams r1 = null;
        if ((r5 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r4 = null;
    L8:
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ViewGroup.LayoutParams r6 = r2.getLayoutParams();
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        r1 = (ViewGroup.MarginLayoutParams) r6;
    L11:
        if (r1 == null) goto L28;
        boolean r7 = true;
        if (r3 == null) goto L18;
        int r8 = r3.intValue();
        if (r1.getMarginStart() == r8) goto L18;
        r1.setMarginStart(r8);
        boolean r9 = true;
    L19:
        if (r4 == null) goto L23;
        int r10 = r4.intValue();
        if (r1.topMargin == r10) goto L23;
        r1.topMargin = r10;
    L24:
        if (r7 == false) goto L27;
        r2.setLayoutParams(r1);
        return;
    L27:
        return;
    L23:
        r7 = r9;
    L18:
        r9 = false;
        goto L19
    }
}
