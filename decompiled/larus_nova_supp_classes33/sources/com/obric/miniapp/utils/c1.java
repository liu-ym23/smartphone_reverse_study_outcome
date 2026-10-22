package com.obric.miniapp.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c1 {
    public static final b1 a(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return new b1(r1, r2);
    }

    public static final View b(View r5, float r6, float r7) {
        int[] r0 = new int[2];
        r5.getLocationOnScreen(r0);
        int r1 = r0[0];
        int r2 = r0[1];
        int r3 = r5.getWidth() + r1;
        int r4 = r5.getHeight() + r2;
        if (r6 >= r1) goto L5;
        return null;
    L5:
        if (r6 <= r3) goto L7;
        return null;
    L7:
        if (r7 >= r2) goto L9;
        return null;
    L9:
        if (r7 <= r4) goto L12;
        return null;
    L12:
        if ((r5 instanceof ViewGroup) == false) goto L20;
        ViewGroup r8 = (ViewGroup) r5;
        int r9 = r8.getChildCount() - 1;
    L15:
        if ((-1) >= r9) goto L20;
        View r10 = r8.getChildAt(r9);
        Intrinsics.checkNotNull(r10);
        View r11 = b(r10, r6, r7);
        if (r11 != null) goto L18;
        r9 = r9 - 1;
        goto L15
    L18:
        return r11;
    L20:
        return r5;
    }
}
