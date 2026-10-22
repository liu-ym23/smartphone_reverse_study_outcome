package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class d {
    static void a(@NonNull TextInputLayout r10, @NonNull CheckableImageButton r11, ColorStateList r12, PorterDuff.Mode r13) {
        Drawable r14 = r11.getDrawable();
        if (r14 == null) goto L13;
        r14 = DrawableCompat.wrap(r14).mutate();
        if (r12 != null) goto L7;
    L9:
        DrawableCompat.setTintList(r14, r12);
    L10:
        if (r13 == null) goto L13;
        DrawableCompat.setTintMode(r14, r13);
        goto L13
    L7:
        if (r12.isStateful() == false) goto L9;
        DrawableCompat.setTintList(r14, ColorStateList.valueOf(r12.getColorForState(b(r10, r11), r12.getDefaultColor())));
    L13:
        if (r11.getDrawable() == r14) goto L16;
        r11.setImageDrawable(r14);
        return;
    }

    private static int[] b(@NonNull TextInputLayout r10, @NonNull CheckableImageButton r11) {
        int[] r12 = r10.getDrawableState();
        int[] r13 = r11.getDrawableState();
        int r14 = r12.length;
        int[] r15 = Arrays.copyOf(r12, r12.length + r13.length);
        System.arraycopy(r13, 0, r15, r14, r13.length);
        return r15;
    }

    static void c(@NonNull TextInputLayout r10, @NonNull CheckableImageButton r11, ColorStateList r12) {
        Drawable r13 = r11.getDrawable();
        if (r11.getDrawable() == null) goto L10;
        if (r12 != null) goto L6;
        return;
    L6:
        if (r12.isStateful() == false) goto L12;
        int r14 = r12.getColorForState(b(r10, r11), r12.getDefaultColor());
        Drawable r15 = DrawableCompat.wrap(r13).mutate();
        DrawableCompat.setTintList(r15, ColorStateList.valueOf(r14));
        r11.setImageDrawable(r15);
        return;
    L12:
        return;
    }

    private static void d(@NonNull CheckableImageButton r10, @Nullable View.OnLongClickListener r11) {
        boolean r12 = ViewCompat.hasOnClickListeners(r10);
        boolean r13 = false;
        int r14 = 1;
        if (r11 == null) goto L5;
        boolean r15 = true;
    L6:
        if (r12 == true) goto L8;
        if (r15 == true) goto L8;
    L9:
        r10.setFocusable(r13);
        r10.setClickable(r12);
        r10.setPressable(r12);
        r10.setLongClickable(r15);
        if (r13 == true) goto L13;
        r14 = 2;
    L13:
        ViewCompat.setImportantForAccessibility(r10, r14);
        return;
    L8:
        r13 = true;
        goto L9
    L5:
        r15 = false;
        goto L6
    }

    static void e(@NonNull CheckableImageButton r10, @Nullable View.OnClickListener r11, @Nullable View.OnLongClickListener r12) {
        r10.setOnClickListener(r11);
        d(r10, r12);
    }

    static void f(@NonNull CheckableImageButton r10, @Nullable View.OnLongClickListener r11) {
        r10.setOnLongClickListener(r11);
        d(r10, r11);
    }
}
