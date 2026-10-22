package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private int tempLeftRightOffset;
    private int tempTopBottomOffset;
    private a viewOffsetHelper;

    public ViewOffsetBehavior() {
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }

    public ViewOffsetBehavior(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }

    public int getLeftAndRightOffset() {
        a r0 = this.viewOffsetHelper;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.d();
    }

    public int getTopAndBottomOffset() {
        a r0 = this.viewOffsetHelper;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.c();
    }

    public boolean isHorizontalOffsetEnabled() {
        a r0 = this.viewOffsetHelper;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.g() == false) goto L7;
        return true;
    }

    public boolean isVerticalOffsetEnabled() {
        a r0 = this.viewOffsetHelper;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.f() == false) goto L7;
        return true;
    }

    public void layoutChild(CoordinatorLayout r1, V r2, int r3) {
        r1.onLayoutChild(r2, r3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout r1, V r2, int r3) {
        layoutChild(r1, r2, r3);
        if (this.viewOffsetHelper != null) goto L5;
        this.viewOffsetHelper = new a(r2);
    L5:
        this.viewOffsetHelper.a();
        this.viewOffsetHelper.b();
        int r4 = this.tempTopBottomOffset;
        if (r4 == 0) goto L8;
        this.viewOffsetHelper.a(r4);
        this.tempTopBottomOffset = 0;
    L8:
        int r5 = this.tempLeftRightOffset;
        if (r5 == 0) goto L13;
        this.viewOffsetHelper.b(r5);
        this.tempLeftRightOffset = 0;
        return true;
    L13:
        return true;
    }

    public void setHorizontalOffsetEnabled(boolean r1) {
        a r0 = this.viewOffsetHelper;
        if (r0 == null) goto L6;
        r0.b(r1);
        return;
    }

    public boolean setLeftAndRightOffset(int r2) {
        a r0 = this.viewOffsetHelper;
        if (r0 != null) goto L5;
        this.tempLeftRightOffset = r2;
        return false;
    L5:
        return r0.b(r2);
    }

    public boolean setTopAndBottomOffset(int r2) {
        a r0 = this.viewOffsetHelper;
        if (r0 != null) goto L5;
        this.tempTopBottomOffset = r2;
        return false;
    L5:
        return r0.a(r2);
    }

    public void setVerticalOffsetEnabled(boolean r1) {
        a r0 = this.viewOffsetHelper;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }
}
