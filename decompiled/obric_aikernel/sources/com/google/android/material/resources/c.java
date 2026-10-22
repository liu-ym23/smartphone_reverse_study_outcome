package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TintTypedArray;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class c {
    @Nullable
    public static ColorStateList a(@NonNull Context r10, @NonNull TypedArray r11, @StyleableRes int r12) {
        if (r11.hasValue(r12) == false) goto L10;
        int r13 = r11.getResourceId(r12, 0);
        if (r13 == 0) goto L10;
        ColorStateList r14 = AppCompatResources.getColorStateList(r10, r13);
        if (r14 == null) goto L10;
        return r14;
    L10:
        if (Build.VERSION.SDK_INT > 15) goto L16;
        int r15 = r11.getColor(r12, -1);
        if (r15 == (-1)) goto L16;
        return ColorStateList.valueOf(r15);
    L16:
        return r11.getColorStateList(r12);
    }

    @Nullable
    public static ColorStateList b(@NonNull Context r10, @NonNull TintTypedArray r11, @StyleableRes int r12) {
        if (r11.hasValue(r12) == false) goto L10;
        int r13 = r11.getResourceId(r12, 0);
        if (r13 == 0) goto L10;
        ColorStateList r14 = AppCompatResources.getColorStateList(r10, r13);
        if (r14 == null) goto L10;
        return r14;
    L10:
        if (Build.VERSION.SDK_INT > 15) goto L16;
        int r15 = r11.getColor(r12, -1);
        if (r15 == (-1)) goto L16;
        return ColorStateList.valueOf(r15);
    L16:
        return r11.getColorStateList(r12);
    }

    private static int c(TypedValue r10) {
        if (Build.VERSION.SDK_INT < 22) goto L7;
        return r10.getComplexUnit();
    L7:
        return (r10.data >> 0) & 15;
    }

    public static int d(@NonNull Context r10, @NonNull TypedArray r11, @StyleableRes int r12, int r13) {
        TypedValue r14 = new TypedValue();
        if (r11.getValue(r12, r14) == false) goto L10;
        if (r14.type != 2) goto L10;
        TypedArray r15 = r10.getTheme().obtainStyledAttributes(new int[]{r14.data});
        int r16 = r15.getDimensionPixelSize(0, r13);
        r15.recycle();
        return r16;
    L10:
        return r11.getDimensionPixelSize(r12, r13);
    }

    @Nullable
    public static Drawable e(@NonNull Context r10, @NonNull TypedArray r11, @StyleableRes int r12) {
        if (r11.hasValue(r12) == false) goto L10;
        int r13 = r11.getResourceId(r12, 0);
        if (r13 == 0) goto L10;
        Drawable r14 = AppCompatResources.getDrawable(r10, r13);
        if (r14 == null) goto L10;
        return r14;
    L10:
        return r11.getDrawable(r12);
    }

    @StyleableRes
    static int f(@NonNull TypedArray r10, @StyleableRes int r11, @StyleableRes int r12) {
        if (r10.hasValue(r11) == false) goto L5;
        return r11;
    L5:
        return r12;
    }

    @Nullable
    public static TextAppearance g(@NonNull Context r10, @NonNull TypedArray r11, @StyleableRes int r12) {
        if (r11.hasValue(r12) == false) goto L8;
        int r13 = r11.getResourceId(r12, 0);
        if (r13 != 0) goto L7;
        return null;
    L7:
        return new TextAppearance(r10, r13);
    L8:
        return null;
    }

    public static int h(@NonNull Context r10, @StyleRes int r11, int r12) {
        if (r11 != 0) goto L4;
        return r12;
    L4:
        TypedArray r13 = r10.obtainStyledAttributes(r11, l.TextAppearance);
        TypedValue r14 = new TypedValue();
        boolean r15 = r13.getValue(l.TextAppearance_android_textSize, r14);
        r13.recycle();
        if (r15 == true) goto L8;
        return r12;
    L8:
        if (c(r14) != 2) goto L12;
        return Math.round(TypedValue.complexToFloat(r14.data) * r10.getResources().getDisplayMetrics().density);
    L12:
        return TypedValue.complexToDimensionPixelSize(r14.data, r10.getResources().getDisplayMetrics());
    }

    public static boolean i(@NonNull Context r10) {
        if (r10.getResources().getConfiguration().fontScale < 1.3f) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean j(@NonNull Context r10) {
        if (r10.getResources().getConfiguration().fontScale < 2.0f) goto L5;
        return true;
    L5:
        return false;
    }
}
