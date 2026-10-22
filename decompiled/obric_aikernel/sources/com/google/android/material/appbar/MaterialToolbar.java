package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.h;
import q5.k;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {
    private static final int DEF_STYLE_RES = 0;
    private static final ImageView.ScaleType[] LOGO_SCALE_TYPE_ARRAY = null;

    @Nullable
    private Boolean logoAdjustViewBounds;

    @Nullable
    private ImageView.ScaleType logoScaleType;

    @Nullable
    private Integer navigationIconTint;
    private boolean subtitleCentered;
    private boolean titleCentered;

    static {
        DEF_STYLE_RES = k.Widget_MaterialComponents_Toolbar;
        LOGO_SCALE_TYPE_ARRAY = new ImageView.ScaleType[]{ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    }

    public MaterialToolbar(@NonNull Context r10) {
        this(r10, null);
    }

    public MaterialToolbar(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, q5.b.toolbarStyle);
    }

    public MaterialToolbar(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        int r13 = DEF_STYLE_RES;
        super(b6.a.c(r10, r11, r12, r13), r11, r12);
        Context r14 = getContext();
        TypedArray r15 = com.google.android.material.internal.k.h(r14, r11, l.MaterialToolbar, r12, r13, new int[0]);
        int r16 = l.MaterialToolbar_navigationIconTint;
        if (r15.hasValue(r16) == false) goto L5;
        setNavigationIconTint(r15.getColor(r16, -1));
    L5:
        this.titleCentered = r15.getBoolean(l.MaterialToolbar_titleCentered, false);
        this.subtitleCentered = r15.getBoolean(l.MaterialToolbar_subtitleCentered, false);
        int r17 = r15.getInt(l.MaterialToolbar_logoScaleType, -1);
        if (r17 < 0) goto L10;
        ImageView.ScaleType[] r18 = LOGO_SCALE_TYPE_ARRAY;
        if (r17 >= r18.length) goto L10;
        this.logoScaleType = r18[r17];
    L10:
        int r19 = l.MaterialToolbar_logoAdjustViewBounds;
        if (r15.hasValue(r19) == false) goto L13;
        this.logoAdjustViewBounds = Boolean.valueOf(r15.getBoolean(r19, false));
    L13:
        r15.recycle();
        initBackground(r14);
    }

    private Pair<Integer, Integer> calculateTitleBoundLimits(@Nullable TextView r10, @Nullable TextView r11) {
        int r12 = getMeasuredWidth();
        int r13 = r12 / 2;
        int r14 = getPaddingLeft();
        int r15 = r12 - getPaddingRight();
        int r16 = 0;
    L4:
        if (r16 >= getChildCount()) goto L21;
        View r17 = getChildAt(r16);
        if (r17.getVisibility() == 8) goto L19;
        if (r17 == r10) goto L19;
        if (r17 == r11) goto L19;
        if (r17.getRight() >= r13) goto L15;
        if (r17.getRight() <= r14) goto L15;
        r14 = r17.getRight();
    L15:
        if (r17.getLeft() <= r13) goto L19;
        if (r17.getLeft() >= r15) goto L19;
        r15 = r17.getLeft();
    L19:
        r16 = r16 + 1;
        goto L4
    L21:
        return new Pair(Integer.valueOf(r14), Integer.valueOf(r15));
    }

    private void initBackground(Context r10) {
        Drawable r11 = getBackground();
        if (r11 != null) goto L5;
    L7:
        MaterialShapeDrawable r12 = new MaterialShapeDrawable();
        if (r11 == null) goto L10;
        int r13 = ((ColorDrawable) r11).getColor();
    L11:
        r12.setFillColor(ColorStateList.valueOf(r13));
        r12.initializeElevationOverlay(r10);
        r12.setElevation(ViewCompat.getElevation(this));
        ViewCompat.setBackground(this, r12);
        return;
    L10:
        r13 = 0;
        goto L11
    L5:
        if ((r11 instanceof ColorDrawable) == true) goto L7;
    }

    private void layoutTitleCenteredHorizontally(View r10, Pair<Integer, Integer> r11) {
        int r12 = getMeasuredWidth();
        int r13 = r10.getMeasuredWidth();
        int r14 = (r12 / 2) - (r13 / 2);
        int r15 = r13 + r14;
        int r16 = Math.max(Math.max(((Integer) r11.first).intValue() - r14, 0), Math.max(r15 - ((Integer) r11.second).intValue(), 0));
        if (r16 <= 0) goto L5;
        r14 = r14 + r16;
        r15 = r15 - r16;
        r10.measure(View.MeasureSpec.makeMeasureSpec(r15 - r14, 1073741824), r10.getMeasuredHeightAndState());
    L5:
        r10.layout(r14, r10.getTop(), r15, r10.getBottom());
    }

    private void maybeCenterTitleViews() {
        if (this.titleCentered == false) goto L5;
    L7:
        TextView r10 = com.google.android.material.internal.l.e(this);
        TextView r11 = com.google.android.material.internal.l.c(this);
        if (r10 != null) goto L11;
        if (r11 != null) goto L11;
        return;
    L11:
        Pair<Integer, Integer> r12 = calculateTitleBoundLimits(r10, r11);
        if (this.titleCentered == false) goto L16;
        if (r10 == null) goto L16;
        layoutTitleCenteredHorizontally(r10, r12);
    L16:
        if (this.subtitleCentered == false) goto L20;
        if (r11 == null) goto L21;
        layoutTitleCenteredHorizontally(r11, r12);
        return;
    L21:
        return;
    L20:
        return;
    L5:
        if (this.subtitleCentered == true) goto L7;
    }

    @Nullable
    private Drawable maybeTintNavigationIcon(@Nullable Drawable r10) {
        if (r10 != null) goto L4;
        return r10;
    L4:
        if (this.navigationIconTint == null) goto L8;
        Drawable r11 = DrawableCompat.wrap(r10.mutate());
        DrawableCompat.setTint(r11, this.navigationIconTint.intValue());
        return r11;
    L8:
        return r10;
    }

    private void updateLogoImageView() {
        ImageView r10 = com.google.android.material.internal.l.b(this);
        if (r10 == null) goto L11;
        Boolean r11 = this.logoAdjustViewBounds;
        if (r11 == null) goto L7;
        r10.setAdjustViewBounds(r11.booleanValue());
    L7:
        ImageView.ScaleType r12 = this.logoScaleType;
        if (r12 == null) goto L12;
        r10.setScaleType(r12);
        return;
    L12:
        return;
    }

    @Nullable
    public ImageView.ScaleType getLogoScaleType() {
        return this.logoScaleType;
    }

    @Nullable
    @ColorInt
    public Integer getNavigationIconTint() {
        return this.navigationIconTint;
    }

    public boolean isLogoAdjustViewBounds() {
        Boolean r10 = this.logoAdjustViewBounds;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.booleanValue() == false) goto L7;
        return true;
    }

    public boolean isSubtitleCentered() {
        return this.subtitleCentered;
    }

    public boolean isTitleCentered() {
        return this.titleCentered;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        maybeCenterTitleViews();
        updateLogoImageView();
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float r10) {
        super.setElevation(r10);
        h.d(this, r10);
    }

    public void setLogoAdjustViewBounds(boolean r10) {
        Boolean r11 = this.logoAdjustViewBounds;
        if (r11 != null) goto L5;
    L6:
        this.logoAdjustViewBounds = Boolean.valueOf(r10);
        requestLayout();
        return;
    L5:
        if (r11.booleanValue() != r10) goto L6;
    }

    public void setLogoScaleType(@NonNull ImageView.ScaleType r10) {
        if (this.logoScaleType == r10) goto L6;
        this.logoScaleType = r10;
        requestLayout();
        return;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable r10) {
        super.setNavigationIcon(maybeTintNavigationIcon(r10));
    }

    public void setNavigationIconTint(@ColorInt int r10) {
        this.navigationIconTint = Integer.valueOf(r10);
        Drawable r11 = getNavigationIcon();
        if (r11 == null) goto L6;
        setNavigationIcon(r11);
        return;
    }

    public void setSubtitleCentered(boolean r10) {
        if (this.subtitleCentered == r10) goto L6;
        this.subtitleCentered = r10;
        requestLayout();
        return;
    }

    public void setTitleCentered(boolean r10) {
        if (this.titleCentered == r10) goto L6;
        this.titleCentered = r10;
        requestLayout();
        return;
    }
}
