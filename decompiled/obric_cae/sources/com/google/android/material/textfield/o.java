package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.google.android.material.internal.CheckableImageButton;
import j0.h0;
import j0.w;
import java.util.Arrays;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class o {
    public static void a(TextInputLayout r8, CheckableImageButton r10, ColorStateList r11, PorterDuff.Mode r12) {
        Drawable r13 = r10.getDrawable();
        if (r13 == null) goto L13;
        r13 = r13.mutate();
        if (r11 != null) goto L7;
    L9:
        b0.a.b.h(r13, r11);
    L10:
        if (r12 == null) goto L13;
        b0.a.b.i(r13, r12);
        goto L13
    L7:
        if (r11.isStateful() == false) goto L9;
        int[] r14 = r8.getDrawableState();
        int[] r15 = r10.getDrawableState();
        int r16 = r14.length;
        int[] r17 = Arrays.copyOf(r14, r14.length + r15.length);
        System.arraycopy(r15, 0, r17, r16, r15.length);
        b0.a.b.h(r13, ColorStateList.valueOf(r11.getColorForState(r17, r11.getDefaultColor())));
    L13:
        if (r10.getDrawable() == r13) goto L16;
        r10.setImageDrawable(r13);
        return;
    }

    public static ImageView.ScaleType b(int r8) {
        if (r8 == 0) goto L26;
        if (r8 == 1) goto L24;
        if (r8 == 2) goto L22;
        if (r8 == 3) goto L20;
        if (r8 == 5) goto L18;
        if (r8 == 6) goto L16;
        return ImageView.ScaleType.CENTER;
    L16:
        return ImageView.ScaleType.CENTER_INSIDE;
    L18:
        return ImageView.ScaleType.CENTER_CROP;
    L20:
        return ImageView.ScaleType.FIT_END;
    L22:
        return ImageView.ScaleType.FIT_CENTER;
    L24:
        return ImageView.ScaleType.FIT_START;
    L26:
        return ImageView.ScaleType.FIT_XY;
    }

    public static void c(TextInputLayout r8, CheckableImageButton r10, ColorStateList r11) {
        Drawable r12 = r10.getDrawable();
        if (r10.getDrawable() == null) goto L10;
        if (r11 != null) goto L6;
        return;
    L6:
        if (r11.isStateful() == false) goto L12;
        int[] r13 = r8.getDrawableState();
        int[] r14 = r10.getDrawableState();
        int r15 = r13.length;
        int[] r16 = Arrays.copyOf(r13, r13.length + r14.length);
        System.arraycopy(r14, 0, r16, r15, r14.length);
        int r17 = r11.getColorForState(r16, r11.getDefaultColor());
        Drawable r18 = r12.mutate();
        b0.a.b.h(r18, ColorStateList.valueOf(r17));
        r10.setImageDrawable(r18);
        return;
    L12:
        return;
    }

    public static void d(CheckableImageButton r8, View.OnLongClickListener r10) {
        WeakHashMap<View, h0> r11 = w.f8437a;
        boolean r12 = w.c.a(r8);
        boolean r13 = false;
        int r14 = 1;
        if (r10 == null) goto L5;
        boolean r15 = true;
    L6:
        if (r12 == true) goto L8;
        if (r15 == true) goto L8;
    L9:
        r8.setFocusable(r13);
        r8.setClickable(r12);
        r8.setPressable(r12);
        r8.setLongClickable(r15);
        if (r13 == true) goto L13;
        r14 = 2;
    L13:
        w.d.s(r8, r14);
        return;
    L8:
        r13 = true;
        goto L9
    L5:
        r15 = false;
        goto L6
    }
}
