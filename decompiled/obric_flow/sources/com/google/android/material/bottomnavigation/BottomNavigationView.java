package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;

/* JADX INFO: loaded from: classes2.dex */
public class BottomNavigationView extends NavigationBarView {
    private static final int MAX_ITEM_COUNT = 5;

    @Deprecated
    public interface OnNavigationItemReselectedListener extends NavigationBarView.OnItemReselectedListener {
    }

    @Deprecated
    public interface OnNavigationItemSelectedListener extends NavigationBarView.OnItemSelectedListener {
    }

    public BottomNavigationView(@NonNull Context r5) {
        this(r5, null);
    }

    private void addCompatibilityTopDivider(@NonNull Context r5) {
        View r10 = new View(r5);
        r10.setBackgroundColor(ContextCompat.getColor(r5, R.color.design_bottom_navigation_shadow_color));
        r10.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_shadow_height)));
        addView(r10);
    }

    private void applyWindowInsets() {
        ViewUtils.doOnApplyWindowInsets(this, new AnonymousClass1(this));
    }

    private int makeMinHeightSpec(int r5) {
        int r10 = getSuggestedMinimumHeight();
        if (View.MeasureSpec.getMode(r5) == 1073741824) goto L7;
        if (r10 <= 0) goto L7;
        int r11 = getPaddingTop();
        int r12 = (getPaddingBottom() + r11) + r10;
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(r5), r12), BasicMeasure.EXACTLY);
    L7:
        return r5;
    }

    private boolean shouldDrawCompatibilityTopDivider() {
        return false;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavigationBarMenuView createNavigationBarMenuView(@NonNull Context r5) {
        return new BottomNavigationMenuView(r5);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 5;
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return ((BottomNavigationMenuView) getMenuView()).isItemHorizontalTranslationEnabled();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r5, int r10) {
        super.onMeasure(r5, makeMinHeightSpec(r10));
    }

    public void setItemHorizontalTranslationEnabled(boolean r5) {
        BottomNavigationMenuView r10 = (BottomNavigationMenuView) getMenuView();
        if (r10.isItemHorizontalTranslationEnabled() == r5) goto L6;
        r10.setItemHorizontalTranslationEnabled(r5);
        getPresenter().updateMenuView(false);
        return;
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(@Nullable OnNavigationItemReselectedListener r5) {
        setOnItemReselectedListener(r5);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener r5) {
        setOnItemSelectedListener(r5);
    }

    public BottomNavigationView(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.bottomNavigationStyle);
    }

    public BottomNavigationView(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        this(r5, r10, r11, R.style.Widget_Design_BottomNavigationView);
    }

    public BottomNavigationView(@NonNull Context r10, @Nullable AttributeSet r11, int r12, int r13) {
        super(r10, r11, r12, r13);
        Context r14 = getContext();
        TintTypedArray r15 = ThemeEnforcement.obtainTintedStyledAttributes(r14, r11, R.styleable.BottomNavigationView, r12, r13, new int[0]);
        setItemHorizontalTranslationEnabled(r15.getBoolean(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        if (r15.hasValue(R.styleable.BottomNavigationView_android_minHeight) == false) goto L6;
        setMinimumHeight(r15.getDimensionPixelSize(R.styleable.BottomNavigationView_android_minHeight, 0));
    L6:
        if (r15.getBoolean(R.styleable.BottomNavigationView_compatShadowEnabled, true) == true) goto L8;
    L10:
        r15.recycle();
        applyWindowInsets();
        return;
    L8:
        if (shouldDrawCompatibilityTopDivider() == false) goto L10;
        addCompatibilityTopDivider(r14);
        goto L10
    }
}
