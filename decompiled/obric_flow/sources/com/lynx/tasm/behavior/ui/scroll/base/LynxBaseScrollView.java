package com.lynx.tasm.behavior.ui.scroll.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import com.lynx.tasm.behavior.ui.a;
import com.lynx.tasm.behavior.ui.b;
import com.lynx.tasm.behavior.ui.scroll.LynxUIScrollViewInternal;

/* JADX INFO: loaded from: classes2.dex */
public class LynxBaseScrollView extends LynxBaseScrollViewNested implements a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b f10659p;

    public LynxBaseScrollView(Context r5) {
        super(r5);
        setNestedScrollingEnabled(true);
        setOnTouchListener(new gs.a(this));
    }

    @Override // com.lynx.tasm.behavior.ui.a
    public final void bindDrawChildHook(b r5) {
        this.f10659p = r5;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r5) {
        b r10 = this.f10659p;
        if (r10 == null) goto L5;
        r10.beforeDispatchDraw(r5);
    L5:
        super.dispatchDraw(r5);
        b r11 = this.f10659p;
        if (r11 == null) goto L9;
        r11.afterDispatchDraw(r5);
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r5, View r10, long r11) {
        b r12 = this.f10659p;
        if (r12 == null) goto L5;
        Rect r13 = r12.beforeDrawChild(r5, r10, r11);
    L6:
        if (r13 == null) goto L8;
        r5.save();
        r5.clipRect(r13);
        boolean r14 = super.drawChild(r5, r10, r11);
        r5.restore();
    L9:
        b r15 = this.f10659p;
        if (r15 == null) goto L12;
        r15.afterDrawChild(r5, r10, r11);
    L12:
        return r14;
    L8:
        r14 = super.drawChild(r5, r10, r11);
        goto L9
    L5:
        r13 = null;
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        if (getRootView().isLayoutRequested() == true) goto L8;
        b r14 = this.f10659p;
        if (r14 == null) goto L9;
        r14.performLayoutChildrenUI();
        return;
    L9:
        return;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r5, int r10) {
        setMeasuredDimension(View.MeasureSpec.getSize(r5), View.MeasureSpec.getSize(r10));
        if (getRootView().isLayoutRequested() == true) goto L8;
        b r11 = this.f10659p;
        if (r11 == null) goto L9;
        r11.performMeasureChildrenUI();
        return;
    L9:
        return;
    }

    @Override // android.view.View
    public final void onScrollChanged(int r5, int r10, int r11, int r12) {
        super.onScrollChanged(r5, r10, r11, r12);
        ((LynxUIScrollViewInternal) this.f17353i).j();
    }

    public void setBackwardNestedScrollMode(int r5) {
        this.f10663o = r5;
    }

    public void setFooter(View r5) {
    }

    public void setForwardNestedScrollMode(int r5) {
        this.f10662n = r5;
    }

    public void setHeader(View r5) {
    }

    public void setLayoutFromEnd(boolean r5) {
    }

    public void setVertical(boolean r5) {
        this.f17351c = r5;
    }
}
