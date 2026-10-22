package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialResources {
    private static final float FONT_SCALE_1_3 = 1.3f;
    private static final float FONT_SCALE_2_0 = 2.0f;

    private MaterialResources() {
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Context r5, @NonNull TypedArray r10, @StyleableRes int r11) {
        if (r10.hasValue(r11) == false) goto L10;
        int r12 = r10.getResourceId(r11, 0);
        if (r12 == 0) goto L10;
        ColorStateList r13 = AppCompatResources.getColorStateList(r5, r12);
        if (r13 == null) goto L10;
        return r13;
    L10:
        return r10.getColorStateList(r11);
    }

    private static int getComplexUnit(TypedValue r5) {
        return r5.getComplexUnit();
    }

    public static int getDimensionPixelSize(@NonNull Context r5, @NonNull TypedArray r10, @StyleableRes int r11, int r12) {
        TypedValue r13 = new TypedValue();
        if (r10.getValue(r11, r13) == false) goto L10;
        if (r13.type != 2) goto L10;
        TypedArray r14 = r5.getTheme().obtainStyledAttributes(new int[]{r13.data});
        int r15 = r14.getDimensionPixelSize(0, r12);
        r14.recycle();
        return r15;
    L10:
        return r10.getDimensionPixelSize(r11, r12);
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Context r5, @NonNull TypedArray r10, @StyleableRes int r11) {
        if (r10.hasValue(r11) == false) goto L10;
        int r12 = r10.getResourceId(r11, 0);
        if (r12 == 0) goto L10;
        Drawable r13 = AppCompatResources.getDrawable(r5, r12);
        if (r13 == null) goto L10;
        return r13;
    L10:
        return r10.getDrawable(r11);
    }

    public static float getFontScale(@NonNull Context r5) {
        return r5.getResources().getConfiguration().fontScale;
    }

    @StyleableRes
    public static int getIndexWithValue(@NonNull TypedArray r5, @StyleableRes int r10, @StyleableRes int r11) {
        if (r5.hasValue(r10) == false) goto L5;
        return r10;
    L5:
        return r11;
    }

    @Nullable
    public static TextAppearance getTextAppearance(@NonNull Context r5, @NonNull TypedArray r10, @StyleableRes int r11) {
        if (r10.hasValue(r11) == false) goto L8;
        int r12 = r10.getResourceId(r11, 0);
        if (r12 != 0) goto L7;
        return null;
    L7:
        return new TextAppearance(r5, r12);
    L8:
        return null;
    }

    public static int getUnscaledTextSize(@NonNull Context r5, @StyleRes int r10, int r11) {
        if (r10 != 0) goto L4;
        return r11;
    L4:
        TypedArray r12 = r5.obtainStyledAttributes(r10, R.styleable.TextAppearance);
        TypedValue r13 = new TypedValue();
        boolean r14 = r12.getValue(R.styleable.TextAppearance_android_textSize, r13);
        r12.recycle();
        if (r14 == true) goto L8;
        return r11;
    L8:
        if (getComplexUnit(r13) != 2) goto L12;
        return Math.round(TypedValue.complexToFloat(r13.data) * r5.getResources().getDisplayMetrics().density);
    L12:
        return TypedValue.complexToDimensionPixelSize(r13.data, r5.getResources().getDisplayMetrics());
    }

    public static boolean isFontScaleAtLeast1_3(@NonNull Context r5) {
        if (r5.getResources().getConfiguration().fontScale < FONT_SCALE_1_3) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isFontScaleAtLeast2_0(@NonNull Context r5) {
        if (r5.getResources().getConfiguration().fontScale < FONT_SCALE_2_0) goto L5;
        return true;
    L5:
        return false;
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Context r5, @NonNull TintTypedArray r10, @StyleableRes int r11) {
        if (r10.hasValue(r11) == false) goto L10;
        int r12 = r10.getResourceId(r11, 0);
        if (r12 == 0) goto L10;
        ColorStateList r13 = AppCompatResources.getColorStateList(r5, r12);
        if (r13 == null) goto L10;
        return r13;
    L10:
        return r10.getColorStateList(r11);
    }
}
