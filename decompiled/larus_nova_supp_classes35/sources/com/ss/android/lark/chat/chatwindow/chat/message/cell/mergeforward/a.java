package com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final int a(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
    L6:
        if (r3 != null) goto L10;
        return 0;
    L10:
        return r3.bottomMargin;
    L5:
        r3 = null;
        goto L6
    }

    public static final boolean b(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof AutoWrapLayout.LayoutParams) == false) goto L5;
        AutoWrapLayout.LayoutParams r3 = (AutoWrapLayout.LayoutParams) r2;
    L6:
        if (r3 != null) goto L10;
        return false;
    L10:
        return r3.b;
    L5:
        r3 = null;
        goto L6
    }

    public static final int c(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
    L6:
        if (r3 != null) goto L10;
        return 0;
    L10:
        return r3.leftMargin;
    L5:
        r3 = null;
        goto L6
    }

    public static final int d(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
    L6:
        if (r3 != null) goto L10;
        return 0;
    L10:
        return r3.rightMargin;
    L5:
        r3 = null;
        goto L6
    }

    public static final int e(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
    L6:
        if (r3 != null) goto L10;
        return 0;
    L10:
        return r3.topMargin;
    L5:
        r3 = null;
        goto L6
    }
}
