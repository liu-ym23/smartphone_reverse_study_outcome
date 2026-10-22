package com.suite.lark.platform.component.widget_floatwindow.cardbag;

import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {

    @FunctionalInterface
    public interface a {
    }

    public static void a(FrameLayout r5) {
        if (r5 == null) goto L11;
        int r0 = 0;
    L6:
        if (r0 >= r5.getChildCount()) goto L15;
        View r1 = r5.getChildAt(r0);
        jpc.a r2 = (jpc.a) r1.getTag();
        if (r2 != null) goto L10;
        r2 = new jpc.a();
    L10:
        int r3 = r1.getPaddingLeft();
        int r4 = r1.getPaddingTop();
        r1.getPaddingRight();
        r1.getPaddingBottom();
        r2.c = r4;
        r2.b = r3;
        r0 = r0 + 1;
        goto L6
    L15:
        return;
    }
}
