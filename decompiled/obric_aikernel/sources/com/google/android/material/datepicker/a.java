package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;

/* JADX INFO: loaded from: classes.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final Rect f3195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ColorStateList f3196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ColorStateList f3197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ColorStateList f3198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f3199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final l f3200f;

    private a(ColorStateList r10, ColorStateList r11, ColorStateList r12, int r13, l r14, @NonNull Rect r15) {
        Preconditions.checkArgumentNonnegative(r15.left);
        Preconditions.checkArgumentNonnegative(r15.top);
        Preconditions.checkArgumentNonnegative(r15.right);
        Preconditions.checkArgumentNonnegative(r15.bottom);
        this.f3195a = r15;
        this.f3196b = r11;
        this.f3197c = r10;
        this.f3198d = r12;
        this.f3199e = r13;
        this.f3200f = r14;
    }

    @NonNull
    static a a(@NonNull Context r12, @StyleRes int r13) {
        if (r13 == 0) goto L5;
        boolean r10 = true;
    L6:
        Preconditions.checkArgument(r10, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray r14 = r12.obtainStyledAttributes(r13, q5.l.MaterialCalendarItem);
        Rect r11 = new Rect(r14.getDimensionPixelOffset(q5.l.MaterialCalendarItem_android_insetLeft, 0), r14.getDimensionPixelOffset(q5.l.MaterialCalendarItem_android_insetTop, 0), r14.getDimensionPixelOffset(q5.l.MaterialCalendarItem_android_insetRight, 0), r14.getDimensionPixelOffset(q5.l.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList r15 = com.google.android.material.resources.c.a(r12, r14, q5.l.MaterialCalendarItem_itemFillColor);
        ColorStateList r16 = com.google.android.material.resources.c.a(r12, r14, q5.l.MaterialCalendarItem_itemTextColor);
        ColorStateList r17 = com.google.android.material.resources.c.a(r12, r14, q5.l.MaterialCalendarItem_itemStrokeColor);
        int r18 = r14.getDimensionPixelSize(q5.l.MaterialCalendarItem_itemStrokeWidth, 0);
        l r19 = l.b(r12, r14.getResourceId(q5.l.MaterialCalendarItem_itemShapeAppearance, 0), r14.getResourceId(q5.l.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).m();
        r14.recycle();
        return new a(r15, r16, r17, r18, r19, r11);
    L5:
        r10 = false;
        goto L6
    }

    int b() {
        return this.f3195a.bottom;
    }

    int c() {
        return this.f3195a.top;
    }

    void d(@NonNull TextView r11) {
        MaterialShapeDrawable r10 = new MaterialShapeDrawable();
        MaterialShapeDrawable r12 = new MaterialShapeDrawable();
        r10.setShapeAppearanceModel(this.f3200f);
        r12.setShapeAppearanceModel(this.f3200f);
        r10.setFillColor(this.f3197c);
        r10.setStroke(this.f3199e, this.f3198d);
        r11.setTextColor(this.f3196b);
        if (Build.VERSION.SDK_INT < 21) goto L5;
        Drawable r13 = new RippleDrawable(this.f3196b.withAlpha(30), r10, r12);
    L6:
        Rect r14 = this.f3195a;
        ViewCompat.setBackground(r11, new InsetDrawable(r13, r14.left, r14.top, r14.right, r14.bottom));
        return;
    L5:
        r13 = r10;
        goto L6
    }
}
