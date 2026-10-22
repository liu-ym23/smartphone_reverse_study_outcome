package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
class a extends c {
    a() {
    }

    private static float e(@FloatRange(from = 0.0d, to = 1.0d) float r10) {
        return (float) (1.0d - Math.cos((((double) r10) * 3.141592653589793d) / 2.0d));
    }

    private static float f(@FloatRange(from = 0.0d, to = 1.0d) float r10) {
        return (float) Math.sin((((double) r10) * 3.141592653589793d) / 2.0d);
    }

    @Override // com.google.android.material.tabs.c
    void d(TabLayout r10, View r11, View r12, float r13, @NonNull Drawable r14) {
        RectF r15 = c.a(r10, r11);
        RectF r16 = c.a(r10, r12);
        if (r15.left >= r16.left) goto L5;
        boolean r17 = true;
    L6:
        if (r17 == false) goto L8;
        float r18 = e(r13);
        float r19 = f(r13);
    L9:
        r14.setBounds(r5.a.c((int) r15.left, (int) r16.left, r18), r14.getBounds().top, r5.a.c((int) r15.right, (int) r16.right, r19), r14.getBounds().bottom);
        return;
    L8:
        r18 = f(r13);
        r19 = e(r13);
        goto L9
    L5:
        r17 = false;
        goto L6
    }
}
