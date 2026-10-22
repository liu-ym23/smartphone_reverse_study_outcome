package com.obric.oui.titlebar.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes2.dex */
class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private int tempLeftRightOffset;
    private int tempTopBottomOffset;
    private a viewOffsetHelper;

    public ViewOffsetBehavior() {
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }

    public ViewOffsetBehavior(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }

    public int getLeftAndRightOffset() {
        a r10 = this.viewOffsetHelper;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.b();
    }

    public int getTopAndBottomOffset() {
        a r10 = this.viewOffsetHelper;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.c();
    }

    public boolean isHorizontalOffsetEnabled() {
        a r10 = this.viewOffsetHelper;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.d() == false) goto L7;
        return true;
    }

    public boolean isVerticalOffsetEnabled() {
        a r10 = this.viewOffsetHelper;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.e() == false) goto L7;
        return true;
    }

    protected void layoutChild(@NonNull CoordinatorLayout r10, @NonNull V r11, int r12) {
        r10.onLayoutChild(r11, r12);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull V r11, int r12) {
        layoutChild(r10, r11, r12);
        if (this.viewOffsetHelper != null) goto L5;
        this.viewOffsetHelper = new a(r11);
    L5:
        this.viewOffsetHelper.f();
        this.viewOffsetHelper.a();
        int r13 = this.tempTopBottomOffset;
        if (r13 == 0) goto L8;
        this.viewOffsetHelper.i(r13);
        this.tempTopBottomOffset = 0;
    L8:
        int r14 = this.tempLeftRightOffset;
        if (r14 == 0) goto L13;
        this.viewOffsetHelper.h(r14);
        this.tempLeftRightOffset = 0;
        return true;
    L13:
        return true;
    }

    public void setHorizontalOffsetEnabled(boolean r10) {
        a r11 = this.viewOffsetHelper;
        if (r11 == null) goto L6;
        r11.g(r10);
        return;
    }

    public boolean setLeftAndRightOffset(int r10) {
        a r11 = this.viewOffsetHelper;
        if (r11 != null) goto L5;
        this.tempLeftRightOffset = r10;
        return false;
    L5:
        return r11.h(r10);
    }

    public boolean setTopAndBottomOffset(int r10) {
        a r11 = this.viewOffsetHelper;
        if (r11 != null) goto L5;
        this.tempTopBottomOffset = r10;
        return false;
    L5:
        return r11.i(r10);
    }

    public void setVerticalOffsetEnabled(boolean r10) {
        a r11 = this.viewOffsetHelper;
        if (r11 == null) goto L6;
        r11.j(r10);
        return;
    }
}
