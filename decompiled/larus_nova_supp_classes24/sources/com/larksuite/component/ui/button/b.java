package com.larksuite.component.ui.button;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public static Drawable a(int r1, int r2, int r3, int r4) {
        GradientDrawable r0 = new GradientDrawable();
        r0.setCornerRadius(r2);
        r0.setColor(r1);
        if (r4 <= 0) goto L5;
        r0.setStroke(r4, r3);
    L5:
        return r0;
    }
}
