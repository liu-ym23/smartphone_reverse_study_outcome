package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes2.dex */
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
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_Toolbar;
        LOGO_SCALE_TYPE_ARRAY = new ImageView.ScaleType[]{ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    }

    public MaterialToolbar(@NonNull Context r5) {
        this(r5, null);
    }

    private Pair<Integer, Integer> calculateTitleBoundLimits(@Nullable TextView r10, @Nullable TextView r11) {
        int r5 = getMeasuredWidth();
        int r12 = r5 / 2;
        int r13 = getPaddingLeft();
        int r14 = r5 - getPaddingRight();
        int r15 = 0;
    L4:
        if (r15 >= getChildCount()) goto L21;
        View r16 = getChildAt(r15);
        if (r16.getVisibility() == 8) goto L19;
        if (r16 == r10) goto L19;
        if (r16 == r11) goto L19;
        if (r16.getRight() >= r12) goto L15;
        if (r16.getRight() <= r13) goto L15;
        r13 = r16.getRight();
    L15:
        if (r16.getLeft() <= r12) goto L19;
        if (r16.getLeft() >= r14) goto L19;
        r14 = r16.getLeft();
    L19:
        r15 = r15 + 1;
        goto L4
    L21:
        return new Pair(Integer.valueOf(r13), Integer.valueOf(r14));
    }

    private void initBackground(Context r5) {
        Drawable r10 = getBackground();
        if (r10 != null) goto L5;
        ColorStateList r11 = ColorStateList.valueOf(0);
    L6:
        if (r11 == null) goto L9;
        MaterialShapeDrawable r12 = new MaterialShapeDrawable();
        r12.setFillColor(r11);
        r12.initializeElevationOverlay(r5);
        r12.setElevation(ViewCompat.getElevation(this));
        ViewCompat.setBackground(this, r12);
        return;
    L9:
        return;
    L5:
        r11 = DrawableUtils.getColorStateListOrNull(r10);
        goto L6
    }

    private void layoutTitleCenteredHorizontally(View r5, Pair<Integer, Integer> r10) {
        int r11 = getMeasuredWidth();
        int r12 = r5.getMeasuredWidth();
        int r13 = (r11 / 2) - (r12 / 2);
        int r14 = r12 + r13;
        int r15 = Math.max(Math.max(((Integer) r10.first).intValue() - r13, 0), Math.max(r14 - ((Integer) r10.second).intValue(), 0));
        if (r15 <= 0) goto L5;
        r13 = r13 + r15;
        r14 = r14 - r15;
        r5.measure(View.MeasureSpec.makeMeasureSpec(r14 - r13, BasicMeasure.EXACTLY), r5.getMeasuredHeightAndState());
    L5:
        r5.layout(r13, r5.getTop(), r14, r5.getBottom());
    }

    private void maybeCenterTitleViews() {
        if (this.titleCentered == false) goto L5;
    L7:
        TextView r5 = ToolbarUtils.getTitleTextView(this);
        TextView r10 = ToolbarUtils.getSubtitleTextView(this);
        if (r5 != null) goto L11;
        if (r10 != null) goto L11;
        return;
    L11:
        Pair<Integer, Integer> r11 = calculateTitleBoundLimits(r5, r10);
        if (this.titleCentered == false) goto L16;
        if (r5 == null) goto L16;
        layoutTitleCenteredHorizontally(r5, r11);
    L16:
        if (this.subtitleCentered == false) goto L20;
        if (r10 == null) goto L21;
        layoutTitleCenteredHorizontally(r10, r11);
        return;
    L21:
        return;
    L20:
        return;
    L5:
        if (this.subtitleCentered == true) goto L7;
    }

    @Nullable
    private Drawable maybeTintNavigationIcon(@Nullable Drawable r5) {
        if (r5 != null) goto L4;
        return r5;
    L4:
        if (this.navigationIconTint == null) goto L8;
        Drawable r10 = DrawableCompat.wrap(r5.mutate());
        DrawableCompat.setTint(r10, this.navigationIconTint.intValue());
        return r10;
    L8:
        return r5;
    }

    private void updateLogoImageView() {
        ImageView r5 = ToolbarUtils.getLogoImageView(this);
        if (r5 == null) goto L11;
        Boolean r10 = this.logoAdjustViewBounds;
        if (r10 == null) goto L7;
        r5.setAdjustViewBounds(r10.booleanValue());
    L7:
        ImageView.ScaleType r11 = this.logoScaleType;
        if (r11 == null) goto L12;
        r5.setScaleType(r11);
        return;
    L12:
        return;
    }

    public void clearNavigationIconTint() {
        this.navigationIconTint = null;
        Drawable r5 = getNavigationIcon();
        if (r5 == null) goto L6;
        DrawableCompat.setTintList(DrawableCompat.wrap(r5.mutate()), null);
        setNavigationIcon(r5);
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

    @Override // androidx.appcompat.widget.Toolbar
    public void inflateMenu(int r5) {
        Menu r10 = getMenu();
        boolean r11 = r10 instanceof MenuBuilder;
        if (r11 == false) goto L5;
        ((MenuBuilder) r10).stopDispatchingItemsChanged();
    L5:
        super.inflateMenu(r5);
        if (r11 == false) goto L9;
        ((MenuBuilder) r10).startDispatchingItemsChanged();
        return;
    }

    public boolean isLogoAdjustViewBounds() {
        Boolean r5 = this.logoAdjustViewBounds;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.booleanValue() == false) goto L7;
        return true;
    }

    public boolean isSubtitleCentered() {
        return this.subtitleCentered;
    }

    public boolean isTitleCentered() {
        return this.titleCentered;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        maybeCenterTitleViews();
        updateLogoImageView();
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float r5) {
        super.setElevation(r5);
        MaterialShapeUtils.setElevation(this, r5);
    }

    public void setLogoAdjustViewBounds(boolean r5) {
        Boolean r10 = this.logoAdjustViewBounds;
        if (r10 != null) goto L5;
    L6:
        this.logoAdjustViewBounds = Boolean.valueOf(r5);
        requestLayout();
        return;
    L5:
        if (r10.booleanValue() != r5) goto L6;
    }

    public void setLogoScaleType(@NonNull ImageView.ScaleType r5) {
        if (this.logoScaleType == r5) goto L6;
        this.logoScaleType = r5;
        requestLayout();
        return;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable r5) {
        super.setNavigationIcon(maybeTintNavigationIcon(r5));
    }

    public void setNavigationIconTint(@ColorInt int r5) {
        this.navigationIconTint = Integer.valueOf(r5);
        Drawable r10 = getNavigationIcon();
        if (r10 == null) goto L6;
        setNavigationIcon(r10);
        return;
    }

    public void setSubtitleCentered(boolean r5) {
        if (this.subtitleCentered == r5) goto L6;
        this.subtitleCentered = r5;
        requestLayout();
        return;
    }

    public void setTitleCentered(boolean r5) {
        if (this.titleCentered == r5) goto L6;
        this.titleCentered = r5;
        requestLayout();
        return;
    }

    public MaterialToolbar(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.toolbarStyle);
    }

    public MaterialToolbar(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        int r5 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r5), r11, r12);
        Context r13 = getContext();
        TypedArray r14 = ThemeEnforcement.obtainStyledAttributes(r13, r11, R.styleable.MaterialToolbar, r12, r5, new int[0]);
        if (r14.hasValue(R.styleable.MaterialToolbar_navigationIconTint) == false) goto L5;
        setNavigationIconTint(r14.getColor(R.styleable.MaterialToolbar_navigationIconTint, -1));
    L5:
        this.titleCentered = r14.getBoolean(R.styleable.MaterialToolbar_titleCentered, false);
        this.subtitleCentered = r14.getBoolean(R.styleable.MaterialToolbar_subtitleCentered, false);
        int r15 = r14.getInt(R.styleable.MaterialToolbar_logoScaleType, -1);
        if (r15 < 0) goto L11;
        ImageView.ScaleType[] r16 = LOGO_SCALE_TYPE_ARRAY;
        if (r15 >= r16.length) goto L11;
        this.logoScaleType = r16[r15];
    L11:
        if (r14.hasValue(R.styleable.MaterialToolbar_logoAdjustViewBounds) == false) goto L13;
        this.logoAdjustViewBounds = Boolean.valueOf(r14.getBoolean(R.styleable.MaterialToolbar_logoAdjustViewBounds, false));
    L13:
        r14.recycle();
        initBackground(r13);
    }
}
