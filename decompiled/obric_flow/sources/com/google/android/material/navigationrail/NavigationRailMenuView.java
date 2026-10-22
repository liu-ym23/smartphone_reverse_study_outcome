package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationRailMenuView extends NavigationBarMenuView {

    @Px
    private int itemMinimumHeight;
    private final FrameLayout.LayoutParams layoutParams;

    public NavigationRailMenuView(@NonNull Context r5) {
        super(r5);
        this.itemMinimumHeight = -1;
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(-1, -2);
        this.layoutParams = r10;
        r10.gravity = 49;
        setLayoutParams(r10);
        setItemActiveIndicatorResizeable(true);
    }

    private int makeSharedHeightSpec(int r5, int r10, int r11) {
        int r12 = r10 / Math.max(1, r11);
        int r13 = this.itemMinimumHeight;
        if (r13 != (-1)) goto L7;
        r13 = View.MeasureSpec.getSize(r5);
    L7:
        return View.MeasureSpec.makeMeasureSpec(Math.min(r13, r12), 0);
    }

    private int measureChildHeight(View r5, int r10, int r11) {
        if (r5.getVisibility() == 8) goto L6;
        r5.measure(r10, r11);
        return r5.getMeasuredHeight();
    L6:
        return 0;
    }

    private int measureSharedChildHeights(int r5, int r10, int r11, View r12) {
        int r13 = 0;
        if (r12 != null) goto L5;
        int r14 = makeSharedHeightSpec(r5, r10, r11);
    L6:
        int r15 = getChildCount();
        int r16 = 0;
    L7:
        if (r13 >= r15) goto L12;
        View r17 = getChildAt(r13);
        if (r17 == r12) goto L11;
        r16 = r16 + measureChildHeight(r17, r5, r14);
    L11:
        r13 = r13 + 1;
        goto L7
    L12:
        return r16;
    L5:
        r14 = View.MeasureSpec.makeMeasureSpec(r12.getMeasuredHeight(), 0);
        goto L6
    }

    private int measureShiftingChildHeights(int r5, int r10, int r11) {
        View r12 = getChildAt(getSelectedItemPosition());
        if (r12 == null) goto L5;
        int r13 = measureChildHeight(r12, r5, makeSharedHeightSpec(r5, r10, r11));
        r10 = r10 - r13;
        r11 = r11 - 1;
    L7:
        return r13 + measureSharedChildHeights(r5, r10, r11, r12);
    L5:
        r13 = 0;
        goto L7
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    @NonNull
    public NavigationBarItemView createNavigationBarItemView(@NonNull Context r5) {
        return new NavigationRailItemView(r5);
    }

    @Px
    public int getItemMinimumHeight() {
        return this.itemMinimumHeight;
    }

    public int getMenuGravity() {
        return this.layoutParams.gravity;
    }

    public boolean isTopGravity() {
        if ((this.layoutParams.gravity & 112) != 48) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        int r14 = getChildCount();
        int r15 = r12 - r10;
        int r16 = 0;
        int r17 = 0;
    L3:
        if (r16 >= r14) goto L8;
        View r18 = getChildAt(r16);
        if (r18.getVisibility() == 8) goto L7;
        int r19 = r18.getMeasuredHeight() + r17;
        r18.layout(0, r17, r15, r19);
        r17 = r19;
    L7:
        r16 = r16 + 1;
        goto L3
    }

    @Override // android.view.View
    public void onMeasure(int r5, int r10) {
        int r11 = View.MeasureSpec.getSize(r10);
        int r12 = getMenu().getVisibleItems().size();
        if (r12 > 1) goto L5;
    L7:
        int r13 = measureSharedChildHeights(r5, r11, r12, null);
    L8:
        setMeasuredDimension(View.MeasureSpec.getSize(r5), View.resolveSizeAndState(r13, r10, 0));
        return;
    L5:
        if (isShifting(getLabelVisibilityMode(), r12) == false) goto L7;
        r13 = measureShiftingChildHeights(r5, r11, r12);
        goto L8
    }

    public void setItemMinimumHeight(@Px int r5) {
        if (this.itemMinimumHeight == r5) goto L6;
        this.itemMinimumHeight = r5;
        requestLayout();
        return;
    }

    public void setMenuGravity(int r5) {
        FrameLayout.LayoutParams r10 = this.layoutParams;
        if (r10.gravity == r5) goto L6;
        r10.gravity = r5;
        setLayoutParams(r10);
        return;
    }
}
