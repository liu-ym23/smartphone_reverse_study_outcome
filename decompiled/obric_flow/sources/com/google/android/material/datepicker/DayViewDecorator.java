package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DayViewDecorator implements Parcelable {
    public DayViewDecorator() {
    }

    @Nullable
    public ColorStateList getBackgroundColor(@NonNull Context r5, int r10, int r11, int r12, boolean r13, boolean r14) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableBottom(@NonNull Context r5, int r10, int r11, int r12, boolean r13, boolean r14) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableLeft(@NonNull Context r5, int r10, int r11, int r12, boolean r13, boolean r14) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableRight(@NonNull Context r5, int r10, int r11, int r12, boolean r13, boolean r14) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableTop(@NonNull Context r5, int r10, int r11, int r12, boolean r13, boolean r14) {
        return null;
    }

    @Nullable
    public CharSequence getContentDescription(@NonNull Context r5, int r10, int r11, int r12, boolean r13, boolean r14, @Nullable CharSequence r15) {
        return r15;
    }

    @Nullable
    public ColorStateList getTextColor(@NonNull Context r5, int r10, int r11, int r12, boolean r13, boolean r14) {
        return null;
    }

    public void initialize(@NonNull Context r5) {
    }
}
