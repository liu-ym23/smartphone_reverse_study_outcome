package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes2.dex */
class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private int tempLeftRightOffset;
    private int tempTopBottomOffset;
    private ViewOffsetHelper viewOffsetHelper;

    public ViewOffsetBehavior() {
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }

    public int getLeftAndRightOffset() {
        ViewOffsetHelper r5 = this.viewOffsetHelper;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.getLeftAndRightOffset();
    }

    public int getTopAndBottomOffset() {
        ViewOffsetHelper r5 = this.viewOffsetHelper;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.getTopAndBottomOffset();
    }

    public boolean isHorizontalOffsetEnabled() {
        ViewOffsetHelper r5 = this.viewOffsetHelper;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.isHorizontalOffsetEnabled() == false) goto L7;
        return true;
    }

    public boolean isVerticalOffsetEnabled() {
        ViewOffsetHelper r5 = this.viewOffsetHelper;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.isVerticalOffsetEnabled() == false) goto L7;
        return true;
    }

    public void layoutChild(@NonNull CoordinatorLayout r5, @NonNull V r10, int r11) {
        r5.onLayoutChild(r10, r11);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout r5, @NonNull V r10, int r11) {
        layoutChild(r5, r10, r11);
        if (this.viewOffsetHelper != null) goto L5;
        this.viewOffsetHelper = new ViewOffsetHelper(r10);
    L5:
        this.viewOffsetHelper.onViewLayout();
        this.viewOffsetHelper.applyOffsets();
        int r12 = this.tempTopBottomOffset;
        if (r12 == 0) goto L8;
        this.viewOffsetHelper.setTopAndBottomOffset(r12);
        this.tempTopBottomOffset = 0;
    L8:
        int r13 = this.tempLeftRightOffset;
        if (r13 == 0) goto L13;
        this.viewOffsetHelper.setLeftAndRightOffset(r13);
        this.tempLeftRightOffset = 0;
        return true;
    L13:
        return true;
    }

    public void setHorizontalOffsetEnabled(boolean r5) {
        ViewOffsetHelper r10 = this.viewOffsetHelper;
        if (r10 == null) goto L6;
        r10.setHorizontalOffsetEnabled(r5);
        return;
    }

    public boolean setLeftAndRightOffset(int r5) {
        ViewOffsetHelper r10 = this.viewOffsetHelper;
        if (r10 != null) goto L5;
        this.tempLeftRightOffset = r5;
        return false;
    L5:
        return r10.setLeftAndRightOffset(r5);
    }

    public boolean setTopAndBottomOffset(int r5) {
        ViewOffsetHelper r10 = this.viewOffsetHelper;
        if (r10 != null) goto L5;
        this.tempTopBottomOffset = r5;
        return false;
    L5:
        return r10.setTopAndBottomOffset(r5);
    }

    public void setVerticalOffsetEnabled(boolean r5) {
        ViewOffsetHelper r10 = this.viewOffsetHelper;
        if (r10 == null) goto L6;
        r10.setVerticalOffsetEnabled(r5);
        return;
    }

    public ViewOffsetBehavior(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }
}
