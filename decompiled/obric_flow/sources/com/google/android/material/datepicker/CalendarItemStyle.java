package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: loaded from: classes2.dex */
final class CalendarItemStyle {
    private final ColorStateList backgroundColor;

    @NonNull
    private final Rect insets;
    private final ShapeAppearanceModel itemShape;
    private final ColorStateList strokeColor;
    private final int strokeWidth;
    private final ColorStateList textColor;

    private CalendarItemStyle(ColorStateList r5, ColorStateList r10, ColorStateList r11, int r12, ShapeAppearanceModel r13, @NonNull Rect r14) {
        Preconditions.checkArgumentNonnegative(r14.left);
        Preconditions.checkArgumentNonnegative(r14.top);
        Preconditions.checkArgumentNonnegative(r14.right);
        Preconditions.checkArgumentNonnegative(r14.bottom);
        this.insets = r14;
        this.textColor = r10;
        this.backgroundColor = r5;
        this.strokeColor = r11;
        this.strokeWidth = r12;
        this.itemShape = r13;
    }

    @NonNull
    public static CalendarItemStyle create(@NonNull Context r12, @StyleRes int r13) {
        if (r13 == 0) goto L5;
        boolean r5 = true;
    L6:
        Preconditions.checkArgument(r5, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray r14 = r12.obtainStyledAttributes(r13, R.styleable.MaterialCalendarItem);
        Rect r11 = new Rect(r14.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetLeft, 0), r14.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetTop, 0), r14.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetRight, 0), r14.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList r10 = MaterialResources.getColorStateList(r12, r14, R.styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList r15 = MaterialResources.getColorStateList(r12, r14, R.styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList r16 = MaterialResources.getColorStateList(r12, r14, R.styleable.MaterialCalendarItem_itemStrokeColor);
        int r17 = r14.getDimensionPixelSize(R.styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        ShapeAppearanceModel r18 = ShapeAppearanceModel.builder(r12, r14.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearance, 0), r14.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).build();
        r14.recycle();
        return new CalendarItemStyle(r10, r15, r16, r17, r18, r11);
    L5:
        r5 = false;
        goto L6
    }

    public int getBottomInset() {
        return this.insets.bottom;
    }

    public int getLeftInset() {
        return this.insets.left;
    }

    public int getRightInset() {
        return this.insets.right;
    }

    public int getTopInset() {
        return this.insets.top;
    }

    public void styleItem(@NonNull TextView r5) {
        styleItem(r5, null, null);
    }

    public void styleItem(@NonNull TextView r10, @Nullable ColorStateList r11, @Nullable ColorStateList r12) {
        MaterialShapeDrawable r5 = new MaterialShapeDrawable();
        MaterialShapeDrawable r13 = new MaterialShapeDrawable();
        r5.setShapeAppearanceModel(this.itemShape);
        r13.setShapeAppearanceModel(this.itemShape);
        if (r11 != null) goto L6;
        r11 = this.backgroundColor;
    L6:
        r5.setFillColor(r11);
        r5.setStroke(this.strokeWidth, this.strokeColor);
        if (r12 != null) goto L10;
        r12 = this.textColor;
    L10:
        r10.setTextColor(r12);
        RippleDrawable r14 = new RippleDrawable(this.textColor.withAlpha(30), r5, r13);
        Rect r15 = this.insets;
        ViewCompat.setBackground(r10, new InsetDrawable(r14, r15.left, r15.top, r15.right, r15.bottom));
    }
}
