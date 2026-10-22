package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.internal.ViewUtils;

/* JADX INFO: loaded from: classes.dex */
class c {
    c() {
    }

    static RectF a(TabLayout r10, @Nullable View r11) {
        if (r11 != null) goto L6;
        return new RectF();
    L6:
        if (r10.y() == true) goto L12;
        if ((r11 instanceof TabLayout.g) == false) goto L12;
        return b((TabLayout.g) r11, 24);
    L12:
        return new RectF(r11.getLeft(), r11.getTop(), r11.getRight(), r11.getBottom());
    }

    static RectF b(@NonNull TabLayout.g r10, @Dimension(unit = 0) int r11) {
        int r12 = r10.getContentWidth();
        int r13 = r10.getContentHeight();
        int r14 = (int) ViewUtils.c(r10.getContext(), r11);
        if (r12 >= r14) goto L5;
        r12 = r14;
    L5:
        int r15 = (r10.getLeft() + r10.getRight()) / 2;
        int r16 = (r10.getTop() + r10.getBottom()) / 2;
        int r17 = r12 / 2;
        return new RectF(r15 - r17, r16 - (r13 / 2), r17 + r15, r16 + (r15 / 2));
    }

    void c(TabLayout r10, View r11, @NonNull Drawable r12) {
        RectF r13 = a(r10, r11);
        r12.setBounds((int) r13.left, r12.getBounds().top, (int) r13.right, r12.getBounds().bottom);
    }

    void d(TabLayout r10, View r11, View r12, @FloatRange(from = 0.0d, to = 1.0d) float r13, @NonNull Drawable r14) {
        RectF r15 = a(r10, r11);
        RectF r16 = a(r10, r12);
        r14.setBounds(r5.a.c((int) r15.left, (int) r16.left, r13), r14.getBounds().top, r5.a.c((int) r15.right, (int) r16.right, r13), r14.getBounds().bottom);
    }
}
