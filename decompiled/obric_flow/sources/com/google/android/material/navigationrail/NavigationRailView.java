package com.google.android.material.navigationrail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.resources.MaterialResources;

/* JADX INFO: loaded from: classes2.dex */
public class NavigationRailView extends NavigationBarView {
    private static final int DEFAULT_HEADER_GRAVITY = 49;
    static final int DEFAULT_MENU_GRAVITY = 49;
    static final int MAX_ITEM_COUNT = 7;
    static final int NO_ITEM_MINIMUM_HEIGHT = -1;

    @Nullable
    private View headerView;

    @Nullable
    private Boolean paddingBottomSystemWindowInsets;

    @Nullable
    private Boolean paddingStartSystemWindowInsets;

    @Nullable
    private Boolean paddingTopSystemWindowInsets;
    private final int topMargin;

    public NavigationRailView(@NonNull Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ Boolean access$000(NavigationRailView r5) {
        return r5.paddingTopSystemWindowInsets;
    }

    public static /* synthetic */ boolean access$100(NavigationRailView r5, Boolean r10) {
        return r5.shouldApplyWindowInsetPadding(r10);
    }

    public static /* synthetic */ Boolean access$200(NavigationRailView r5) {
        return r5.paddingBottomSystemWindowInsets;
    }

    public static /* synthetic */ Boolean access$300(NavigationRailView r5) {
        return r5.paddingStartSystemWindowInsets;
    }

    private void applyWindowInsets() {
        ViewUtils.doOnApplyWindowInsets(this, new AnonymousClass1(this));
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    private boolean isHeaderViewVisible() {
        View r5 = this.headerView;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.getVisibility() == 8) goto L7;
        return true;
    }

    private int makeMinWidthSpec(int r5) {
        int r10 = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(r5) == 1073741824) goto L7;
        if (r10 <= 0) goto L7;
        int r11 = getPaddingLeft();
        int r12 = (getPaddingRight() + r11) + r10;
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(r5), r12), BasicMeasure.EXACTLY);
    L7:
        return r5;
    }

    private boolean shouldApplyWindowInsetPadding(Boolean r5) {
        if (r5 == null) goto L5;
        return r5.booleanValue();
    L5:
        return ViewCompat.getFitsSystemWindows(this);
    }

    public void addHeaderView(@LayoutRes int r5) {
        addHeaderView(LayoutInflater.from(getContext()).inflate(r5, this, false));
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public /* bridge */ /* synthetic */ NavigationBarMenuView createNavigationBarMenuView(@NonNull Context r5) {
        return createNavigationBarMenuView(r5);
    }

    @Nullable
    public View getHeaderView() {
        return this.headerView;
    }

    public int getItemMinimumHeight() {
        return ((NavigationRailMenuView) getMenuView()).getItemMinimumHeight();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        NavigationRailMenuView r14 = getNavigationRailMenuView();
        int r15 = 0;
        if (isHeaderViewVisible() == false) goto L8;
        int r16 = this.headerView.getBottom() + this.topMargin;
        int r17 = r14.getTop();
        if (r17 >= r16) goto L10;
        r15 = r16 - r17;
    L10:
        if (r15 <= 0) goto L13;
        r14.layout(r14.getLeft(), r14.getTop() + r15, r14.getRight(), r14.getBottom() + r15);
        return;
    L13:
        return;
    L8:
        if (r14.isTopGravity() == false) goto L10;
        r15 = this.topMargin;
        goto L10
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r5, int r10) {
        int r11 = makeMinWidthSpec(r5);
        super.onMeasure(r11, r10);
        if (isHeaderViewVisible() == false) goto L6;
        int r12 = View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.headerView.getMeasuredHeight()) - this.topMargin, Integer.MIN_VALUE);
        measureChild(getNavigationRailMenuView(), r11, r12);
        return;
    }

    public void removeHeaderView() {
        View r5 = this.headerView;
        if (r5 == null) goto L6;
        removeView(r5);
        this.headerView = null;
        return;
    }

    public void setItemMinimumHeight(@Px int r5) {
        ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(r5);
    }

    public void setMenuGravity(int r5) {
        getNavigationRailMenuView().setMenuGravity(r5);
    }

    public NavigationRailView(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.navigationRailStyle);
    }

    public void addHeaderView(@NonNull View r5) {
        removeHeaderView();
        this.headerView = r5;
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(-2, -2);
        r10.gravity = 49;
        r10.topMargin = this.topMargin;
        addView(r5, 0, r10);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavigationRailMenuView createNavigationBarMenuView(@NonNull Context r5) {
        return new NavigationRailMenuView(r5);
    }

    public NavigationRailView(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        this(r5, r10, r11, R.style.Widget_MaterialComponents_NavigationRailView);
    }

    public NavigationRailView(@NonNull Context r10, @Nullable AttributeSet r11, int r12, int r13) {
        super(r10, r11, r12, r13);
        this.paddingTopSystemWindowInsets = null;
        this.paddingBottomSystemWindowInsets = null;
        this.paddingStartSystemWindowInsets = null;
        this.topMargin = getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_rail_margin);
        Context r14 = getContext();
        TintTypedArray r15 = ThemeEnforcement.obtainTintedStyledAttributes(r14, r11, R.styleable.NavigationRailView, r12, r13, new int[0]);
        int r16 = r15.getResourceId(R.styleable.NavigationRailView_headerLayout, 0);
        if (r16 == 0) goto L5;
        addHeaderView(r16);
    L5:
        setMenuGravity(r15.getInt(R.styleable.NavigationRailView_menuGravity, 49));
        if (r15.hasValue(R.styleable.NavigationRailView_itemMinHeight) == false) goto L9;
        setItemMinimumHeight(r15.getDimensionPixelSize(R.styleable.NavigationRailView_itemMinHeight, -1));
    L9:
        if (r15.hasValue(R.styleable.NavigationRailView_paddingTopSystemWindowInsets) == false) goto L12;
        this.paddingTopSystemWindowInsets = Boolean.valueOf(r15.getBoolean(R.styleable.NavigationRailView_paddingTopSystemWindowInsets, false));
    L12:
        if (r15.hasValue(R.styleable.NavigationRailView_paddingBottomSystemWindowInsets) == false) goto L15;
        this.paddingBottomSystemWindowInsets = Boolean.valueOf(r15.getBoolean(R.styleable.NavigationRailView_paddingBottomSystemWindowInsets, false));
    L15:
        if (r15.hasValue(R.styleable.NavigationRailView_paddingStartSystemWindowInsets) == false) goto L17;
        this.paddingStartSystemWindowInsets = Boolean.valueOf(r15.getBoolean(R.styleable.NavigationRailView_paddingStartSystemWindowInsets, false));
    L17:
        int r17 = getResources().getDimensionPixelOffset(R.dimen.m3_navigation_rail_item_padding_top_with_large_font);
        int r18 = getResources().getDimensionPixelOffset(R.dimen.m3_navigation_rail_item_padding_bottom_with_large_font);
        float r19 = AnimationUtils.lerp(0.0f, 1.0f, 0.3f, 1.0f, MaterialResources.getFontScale(r14) - 1.0f);
        float r110 = AnimationUtils.lerp(getItemPaddingTop(), r17, r19);
        float r20 = AnimationUtils.lerp(getItemPaddingBottom(), r18, r19);
        setItemPaddingTop(Math.round(r110));
        setItemPaddingBottom(Math.round(r20));
        r15.recycle();
        applyWindowInsets();
    }
}
