package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
class b extends c {
    b() {
    }

    @Override // com.google.android.material.tabs.c
    void d(TabLayout r10, View r11, View r12, float r13, @NonNull Drawable r14) {
        if (r13 < 0.5f) goto L6;
        r11 = r12;
    L6:
        RectF r15 = c.a(r10, r11);
        if (r13 >= 0.5f) goto L9;
        float r16 = r5.a.b(1.0f, 0.0f, 0.0f, 0.5f, r13);
    L10:
        r14.setBounds((int) r15.left, r14.getBounds().top, (int) r15.right, r14.getBounds().bottom);
        r14.setAlpha((int) (r16 * 255.0f));
        return;
    L9:
        r16 = r5.a.b(0.0f, 1.0f, 0.5f, 1.0f, r13);
        goto L10
    }
}
