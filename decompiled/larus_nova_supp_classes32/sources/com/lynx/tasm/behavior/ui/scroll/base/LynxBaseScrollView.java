package com.lynx.tasm.behavior.ui.scroll.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.lynx.tasm.behavior.ui.IDrawChildHook;
import com.lynx.tasm.behavior.ui.scroll.LynxUIScrollViewInternal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxBaseScrollView extends LynxBaseScrollViewNested implements IDrawChildHook.IDrawChildHookBinding {
    public IDrawChildHook q;

    public class a implements View.OnTouchListener {
        public final /* synthetic */ LynxBaseScrollView a;

        public a(LynxBaseScrollView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            return !this.a.f;
        }
    }

    public void setFooter(View r1) {
    }

    public void setHeader(View r1) {
    }

    public void setLayoutFromEnd(boolean r1) {
    }

    public LynxBaseScrollView(Context r2) {
        this(r2, null);
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook.IDrawChildHookBinding
    public final void bindDrawChildHook(IDrawChildHook r1) {
        this.q = r1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r2) {
        IDrawChildHook r0 = this.q;
        if (r0 == null) goto L5;
        r0.beforeDispatchDraw(r2);
    L5:
        super.dispatchDraw(r2);
        IDrawChildHook r1 = this.q;
        if (r1 == null) goto L9;
        r1.afterDispatchDraw(r2);
        return;
    }

    public void setBackwardNestedScrollMode(int r1) {
        this.p = r1;
    }

    public void setForwardNestedScrollMode(int r1) {
        this.o = r1;
    }

    public void setVertical(boolean r1) {
        this.c = r1;
    }

    public LynxBaseScrollView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        setMeasuredDimension(View.MeasureSpec.getSize(r1), View.MeasureSpec.getSize(r2));
        if (getRootView().isLayoutRequested() == true) goto L8;
        IDrawChildHook r3 = this.q;
        if (r3 == null) goto L9;
        r3.performMeasureChildrenUI();
        return;
    L9:
        return;
    }

    public LynxBaseScrollView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        setNestedScrollingEnabled(true);
        setOnTouchListener(new a(this));
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r3, View r4, long r5) {
        IDrawChildHook r0 = this.q;
        if (r0 == null) goto L5;
        Rect r1 = r0.beforeDrawChild(r3, r4, r5);
    L6:
        if (r1 == null) goto L8;
        r3.save();
        r3.clipRect(r1);
        boolean r2 = super.drawChild(r3, r4, r5);
        r3.restore();
    L9:
        IDrawChildHook r6 = this.q;
        if (r6 == null) goto L12;
        r6.afterDrawChild(r3, r4, r5);
    L12:
        return r2;
    L8:
        r2 = super.drawChild(r3, r4, r5);
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.view.View
    public final void onScrollChanged(int r1, int r2, int r3, int r4) {
        super.onScrollChanged(r1, r2, r3, r4);
        ((LynxUIScrollViewInternal) this.i).O();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        if (getRootView().isLayoutRequested() == true) goto L8;
        IDrawChildHook r6 = this.q;
        if (r6 == null) goto L9;
        r6.performLayoutChildrenUI();
        return;
    L9:
        return;
    }
}
