package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class NavigationRailMenuView extends NavigationBarMenuView {
    private int itemMinimumHeight;
    private final FrameLayout.LayoutParams layoutParams;

    public NavigationRailMenuView(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        this.itemMinimumHeight = -1;
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, -2);
        this.layoutParams = r0;
        r0.gravity = 49;
        setLayoutParams(r0);
        setItemActiveIndicatorResizeable(true);
    }

    private int makeSharedHeightSpec(int r2, int r3, int r4) {
        int r5 = r3 / Math.max(1, r4);
        int r1 = this.itemMinimumHeight;
        if (r1 != (-1)) goto L7;
        r1 = View.MeasureSpec.getSize(r2);
    L7:
        return View.MeasureSpec.makeMeasureSpec(Math.min(r1, r5), 0);
    }

    private int measureChildHeight(View r2, int r3, int r4) {
        if (r2.getVisibility() == 8) goto L6;
        r2.measure(r3, r4);
        return r2.getMeasuredHeight();
    L6:
        return 0;
    }

    private int measureSharedChildHeights(int r4, int r5, int r6, View r7) {
        makeSharedHeightSpec(r4, r5, r6);
        int r0 = 0;
        if (r7 != null) goto L5;
        int r8 = makeSharedHeightSpec(r4, r5, r6);
    L6:
        int r9 = getChildCount();
        int r1 = 0;
    L7:
        if (r0 >= r9) goto L12;
        View r2 = getChildAt(r0);
        if (r2 == r7) goto L11;
        r1 = r1 + measureChildHeight(r2, r4, r8);
    L11:
        r0 = r0 + 1;
        goto L7
    L12:
        return r1;
    L5:
        r8 = View.MeasureSpec.makeMeasureSpec(r7.getMeasuredHeight(), 0);
        goto L6
    }

    private int measureShiftingChildHeights(int r3, int r4, int r5) {
        View r0 = getChildAt(getSelectedItemPosition());
        if (r0 == null) goto L5;
        int r1 = measureChildHeight(r0, r3, makeSharedHeightSpec(r3, r4, r5));
        r4 = r4 - r1;
        r5 = r5 - 1;
    L7:
        return r1 + measureSharedChildHeights(r3, r4, r5, r0);
    L5:
        r1 = 0;
        goto L7
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    public NavigationBarItemView createNavigationBarItemView(Context r2) {
        return new NavigationRailItemView((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

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
    public void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        int r9 = getChildCount();
        int r10 = r7 - r5;
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r9) goto L8;
        View r0 = getChildAt(r11);
        if (r0.getVisibility() == 8) goto L7;
        int r1 = r0.getMeasuredHeight() + r12;
        r0.layout(0, r12, r10, r1);
        r12 = r1;
    L7:
        r11 = r11 + 1;
        goto L3
    }

    @Override // android.view.View
    public void onMeasure(int r4, int r5) {
        int r0 = View.MeasureSpec.getSize(r5);
        int r1 = getMenu().getVisibleItems().size();
        if (r1 > 1) goto L5;
    L7:
        int r2 = measureSharedChildHeights(r4, r0, r1, null);
    L8:
        setMeasuredDimension(View.resolveSizeAndState(View.MeasureSpec.getSize(r4), r4, 0), View.resolveSizeAndState(r2, r5, 0));
        return;
    L5:
        if (isShifting(getLabelVisibilityMode(), r1) == false) goto L7;
        r2 = measureShiftingChildHeights(r4, r0, r1);
        goto L8
    }

    public void setItemMinimumHeight(int r2) {
        if (this.itemMinimumHeight == r2) goto L6;
        this.itemMinimumHeight = r2;
        requestLayout();
        return;
    }

    void setMenuGravity(int r2) {
        if (this.layoutParams.gravity == r2) goto L6;
        this.layoutParams.gravity = r2;
        setLayoutParams(this.layoutParams);
        return;
    }
}
