package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationRailMenuView extends NavigationBarMenuView {

    @Px
    private int itemMinimumHeight;
    private final FrameLayout.LayoutParams layoutParams;

    public NavigationRailMenuView(@NonNull Context r10) {
        super(r10);
        this.itemMinimumHeight = -1;
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-1, -2);
        this.layoutParams = r11;
        r11.gravity = 49;
        setLayoutParams(r11);
        setItemActiveIndicatorResizeable(true);
    }

    private int makeSharedHeightSpec(int r10, int r11, int r12) {
        int r13 = r11 / Math.max(1, r12);
        int r14 = this.itemMinimumHeight;
        if (r14 != (-1)) goto L7;
        r14 = View.MeasureSpec.getSize(r10);
    L7:
        return View.MeasureSpec.makeMeasureSpec(Math.min(r14, r13), 0);
    }

    private int measureChildHeight(View r10, int r11, int r12) {
        if (r10.getVisibility() == 8) goto L6;
        r10.measure(r11, r12);
        return r10.getMeasuredHeight();
    L6:
        return 0;
    }

    private int measureSharedChildHeights(int r10, int r11, int r12, View r13) {
        makeSharedHeightSpec(r10, r11, r12);
        int r14 = 0;
        if (r13 != null) goto L5;
        int r15 = makeSharedHeightSpec(r10, r11, r12);
    L6:
        int r16 = getChildCount();
        int r17 = 0;
    L7:
        if (r14 >= r16) goto L12;
        View r18 = getChildAt(r14);
        if (r18 == r13) goto L11;
        r17 = r17 + measureChildHeight(r18, r10, r15);
    L11:
        r14 = r14 + 1;
        goto L7
    L12:
        return r17;
    L5:
        r15 = View.MeasureSpec.makeMeasureSpec(r13.getMeasuredHeight(), 0);
        goto L6
    }

    private int measureShiftingChildHeights(int r10, int r11, int r12) {
        View r13 = getChildAt(getSelectedItemPosition());
        if (r13 == null) goto L5;
        int r14 = measureChildHeight(r13, r10, makeSharedHeightSpec(r10, r11, r12));
        r11 = r11 - r14;
        r12 = r12 - 1;
    L7:
        return r14 + measureSharedChildHeights(r10, r11, r12, r13);
    L5:
        r14 = 0;
        goto L7
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    @NonNull
    protected NavigationBarItemView createNavigationBarItemView(@NonNull Context r10) {
        return new NavigationRailItemView(r10);
    }

    @Px
    public int getItemMinimumHeight() {
        return this.itemMinimumHeight;
    }

    int getMenuGravity() {
        return this.layoutParams.gravity;
    }

    boolean isTopGravity() {
        if ((this.layoutParams.gravity & 112) != 48) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = getChildCount();
        int r16 = r13 - r11;
        int r17 = 0;
        int r18 = 0;
    L3:
        if (r17 >= r15) goto L8;
        View r19 = getChildAt(r17);
        if (r19.getVisibility() == 8) goto L7;
        int r20 = r19.getMeasuredHeight() + r18;
        r19.layout(0, r18, r16, r20);
        r18 = r20;
    L7:
        r17 = r17 + 1;
        goto L3
    }

    @Override // android.view.View
    protected void onMeasure(int r10, int r11) {
        int r12 = View.MeasureSpec.getSize(r11);
        int r13 = getMenu().getVisibleItems().size();
        if (r13 > 1) goto L5;
    L7:
        int r14 = measureSharedChildHeights(r10, r12, r13, null);
    L8:
        setMeasuredDimension(View.resolveSizeAndState(View.MeasureSpec.getSize(r10), r10, 0), View.resolveSizeAndState(r14, r11, 0));
        return;
    L5:
        if (isShifting(getLabelVisibilityMode(), r13) == false) goto L7;
        r14 = measureShiftingChildHeights(r10, r12, r13);
        goto L8
    }

    public void setItemMinimumHeight(@Px int r10) {
        if (this.itemMinimumHeight == r10) goto L6;
        this.itemMinimumHeight = r10;
        requestLayout();
        return;
    }

    void setMenuGravity(int r10) {
        FrameLayout.LayoutParams r11 = this.layoutParams;
        if (r11.gravity == r10) goto L6;
        r11.gravity = r10;
        setLayoutParams(r11);
        return;
    }
}
