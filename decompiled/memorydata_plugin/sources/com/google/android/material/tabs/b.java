package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
class b extends c {
    b() {
    }

    @Override // com.google.android.material.tabs.c
    void a(TabLayout r2, View r3, View r4, float r5, Drawable r6) {
        if (r5 < 0.5f) goto L6;
        r3 = r4;
    L6:
        RectF r7 = a(r2, r3);
        if (r5 >= 0.5f) goto L9;
        float r1 = com.google.android.material.a.a.a(1.0f, 0.0f, 0.0f, 0.5f, r5);
    L10:
        r6.setBounds((int) r7.left, r6.getBounds().top, (int) r7.right, r6.getBounds().bottom);
        r6.setAlpha((int) (r1 * 255.0f));
        return;
    L9:
        r1 = com.google.android.material.a.a.a(0.0f, 1.0f, 0.5f, 1.0f, r5);
        goto L10
    }
}
