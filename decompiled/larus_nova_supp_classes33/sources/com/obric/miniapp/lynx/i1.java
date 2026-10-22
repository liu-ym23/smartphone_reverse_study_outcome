package com.obric.miniapp.lynx;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class i1 {
    public static final void a(View r3) {
        r3.forceLayout();
        r3.requestLayout();
        if ((r3 instanceof ViewGroup) == false) goto L11;
        ViewGroup r4 = (ViewGroup) r3;
        int r0 = r4.getChildCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L15;
        View r2 = r4.getChildAt(r1);
        if (r2 == null) goto L10;
        a(r2);
    L10:
        r1 = r1 + 1;
        goto L5
    L15:
        return;
    }
}
