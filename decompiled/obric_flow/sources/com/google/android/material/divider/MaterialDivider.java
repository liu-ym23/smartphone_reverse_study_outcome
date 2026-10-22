package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialDivider extends View {
    private static final int DEF_STYLE_RES = 0;

    @ColorInt
    private int color;

    @NonNull
    private final MaterialShapeDrawable dividerDrawable;
    private int insetEnd;
    private int insetStart;
    private int thickness;

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_MaterialDivider;
    }

    public MaterialDivider(@NonNull Context r5) {
        this(r5, null);
    }

    public int getDividerColor() {
        return this.color;
    }

    @Px
    public int getDividerInsetEnd() {
        return this.insetEnd;
    }

    @Px
    public int getDividerInsetStart() {
        return this.insetStart;
    }

    public int getDividerThickness() {
        return this.thickness;
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas r10) {
        super.onDraw(r10);
        boolean r5 = true;
        if (ViewCompat.getLayoutDirection(this) == 1) goto L6;
        r5 = false;
    L6:
        if (r5 == false) goto L8;
        int r11 = this.insetEnd;
    L9:
        if (r5 == false) goto L12;
        int r12 = getWidth();
        int r13 = this.insetStart;
    L13:
        this.dividerDrawable.setBounds(r11, 0, r12 - r13, getBottom() - getTop());
        this.dividerDrawable.draw(r10);
        return;
    L12:
        r12 = getWidth();
        r13 = this.insetEnd;
        goto L13
    L8:
        r11 = this.insetStart;
        goto L9
    }

    @Override // android.view.View
    public void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
        int r11 = View.MeasureSpec.getMode(r10);
        int r12 = getMeasuredHeight();
        if (r11 == Integer.MIN_VALUE) goto L5;
        if (r11 == 0) goto L5;
        return;
    L5:
        int r13 = this.thickness;
        if (r13 <= 0) goto L9;
        if (r12 == r13) goto L9;
        r12 = r13;
    L9:
        setMeasuredDimension(getMeasuredWidth(), r12);
    }

    public void setDividerColor(@ColorInt int r5) {
        if (this.color == r5) goto L6;
        this.color = r5;
        this.dividerDrawable.setFillColor(ColorStateList.valueOf(r5));
        invalidate();
        return;
    }

    public void setDividerColorResource(@ColorRes int r5) {
        setDividerColor(ContextCompat.getColor(getContext(), r5));
    }

    public void setDividerInsetEnd(@Px int r5) {
        this.insetEnd = r5;
    }

    public void setDividerInsetEndResource(@DimenRes int r5) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(r5));
    }

    public void setDividerInsetStart(@Px int r5) {
        this.insetStart = r5;
    }

    public void setDividerInsetStartResource(@DimenRes int r5) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(r5));
    }

    public void setDividerThickness(@Px int r5) {
        if (this.thickness == r5) goto L6;
        this.thickness = r5;
        requestLayout();
        return;
    }

    public void setDividerThicknessResource(@DimenRes int r5) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(r5));
    }

    public MaterialDivider(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.materialDividerStyle);
    }

    public MaterialDivider(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        int r5 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r5), r11, r12);
        Context r13 = getContext();
        this.dividerDrawable = new MaterialShapeDrawable();
        TypedArray r14 = ThemeEnforcement.obtainStyledAttributes(r13, r11, R.styleable.MaterialDivider, r12, r5, new int[0]);
        this.thickness = r14.getDimensionPixelSize(R.styleable.MaterialDivider_dividerThickness, getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
        this.insetStart = r14.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetStart, 0);
        this.insetEnd = r14.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetEnd, 0);
        setDividerColor(MaterialResources.getColorStateList(r13, r14, R.styleable.MaterialDivider_dividerColor).getDefaultColor());
        r14.recycle();
    }
}
