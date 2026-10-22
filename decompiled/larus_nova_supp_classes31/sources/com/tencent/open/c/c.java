package com.tencent.open.c;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class c extends FrameLayout {
    public c(Context r1) {
        super(r1);
    }

    private void a(WindowInsets r5) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return;
    L5:
        if (r5 != null) goto L7;
        return;
    L7:
        DisplayCutout r6 = r5.getDisplayCutout();
        if (r6 != null) goto L10;
        return;
    L10:
        List<Rect> r0 = r6.getBoundingRects();
        if (r0 != null) goto L13;
        return;
    L13:
        if (r0.isEmpty() == true) goto L18;
        setPadding(Math.max(r6.getSafeInsetLeft(), 0), Math.max(r6.getSafeInsetTop(), 0), Math.max(r6.getSafeInsetRight(), 0), Math.max(r6.getSafeInsetBottom(), 0));
        return;
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets r1) {
        a(r1);
        return super.onApplyWindowInsets(r1);
    }
}
