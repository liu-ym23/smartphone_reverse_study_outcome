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
import b6.a;
import com.google.android.material.resources.c;
import com.google.android.material.shape.MaterialShapeDrawable;
import q5.b;
import q5.d;
import q5.k;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
public class MaterialDivider extends View {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f3233k = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final MaterialShapeDrawable f3234c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3235g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @ColorInt
    private int f3236h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f3237i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f3238j;

    static {
        f3233k = k.Widget_MaterialComponents_MaterialDivider;
    }

    public MaterialDivider(@NonNull Context r10) {
        this(r10, null);
    }

    public MaterialDivider(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, b.materialDividerStyle);
    }

    public MaterialDivider(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        int r13 = f3233k;
        super(a.c(r10, r11, r12, r13), r11, r12);
        Context r14 = getContext();
        this.f3234c = new MaterialShapeDrawable();
        TypedArray r15 = com.google.android.material.internal.k.h(r14, r11, l.MaterialDivider, r12, r13, new int[0]);
        this.f3235g = r15.getDimensionPixelSize(l.MaterialDivider_dividerThickness, getResources().getDimensionPixelSize(d.material_divider_thickness));
        this.f3237i = r15.getDimensionPixelOffset(l.MaterialDivider_dividerInsetStart, 0);
        this.f3238j = r15.getDimensionPixelOffset(l.MaterialDivider_dividerInsetEnd, 0);
        setDividerColor(c.a(r14, r15, l.MaterialDivider_dividerColor).getDefaultColor());
        r15.recycle();
    }

    public int getDividerColor() {
        return this.f3236h;
    }

    @Px
    public int getDividerInsetEnd() {
        return this.f3238j;
    }

    @Px
    public int getDividerInsetStart() {
        return this.f3237i;
    }

    public int getDividerThickness() {
        return this.f3235g;
    }

    @Override // android.view.View
    protected void onDraw(@NonNull Canvas r10) {
        super.onDraw(r10);
        boolean r11 = true;
        if (ViewCompat.getLayoutDirection(this) == 1) goto L6;
        r11 = false;
    L6:
        if (r11 == false) goto L8;
        int r12 = this.f3238j;
    L9:
        if (r11 == false) goto L11;
        int r13 = getWidth();
        int r14 = this.f3237i;
    L12:
        this.f3234c.setBounds(r12, 0, r13 - r14, getBottom() - getTop());
        this.f3234c.draw(r10);
        return;
    L11:
        r13 = getWidth();
        r14 = this.f3238j;
        goto L12
    L8:
        r12 = this.f3237i;
        goto L9
    }

    @Override // android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        int r12 = View.MeasureSpec.getMode(r11);
        int r13 = getMeasuredHeight();
        if (r12 == Integer.MIN_VALUE) goto L5;
        if (r12 == 0) goto L5;
        return;
    L5:
        int r14 = this.f3235g;
        if (r14 <= 0) goto L9;
        if (r13 == r14) goto L9;
        r13 = r14;
    L9:
        setMeasuredDimension(getMeasuredWidth(), r13);
    }

    public void setDividerColor(@ColorInt int r10) {
        if (this.f3236h == r10) goto L6;
        this.f3236h = r10;
        this.f3234c.setFillColor(ColorStateList.valueOf(r10));
        invalidate();
        return;
    }

    public void setDividerColorResource(@ColorRes int r10) {
        setDividerColor(ContextCompat.getColor(getContext(), r10));
    }

    public void setDividerInsetEnd(@Px int r10) {
        this.f3238j = r10;
    }

    public void setDividerInsetEndResource(@DimenRes int r10) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(r10));
    }

    public void setDividerInsetStart(@Px int r10) {
        this.f3237i = r10;
    }

    public void setDividerInsetStartResource(@DimenRes int r10) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(r10));
    }

    public void setDividerThickness(@Px int r10) {
        if (this.f3235g == r10) goto L6;
        this.f3235g = r10;
        requestLayout();
        return;
    }

    public void setDividerThicknessResource(@DimenRes int r10) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(r10));
    }
}
