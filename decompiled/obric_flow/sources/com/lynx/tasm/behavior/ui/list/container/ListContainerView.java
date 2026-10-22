package com.lynx.tasm.behavior.ui.list.container;

import ai.j0;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.behavior.ui.a;
import com.lynx.tasm.behavior.ui.b;
import com.lynx.tasm.i;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ListContainerView extends NestedScrollContainerView implements a {
    public fn.a A;
    public Boolean B;
    public Boolean C;
    public boolean D;
    public b E;
    public boolean F;
    public int G;
    public int H;
    public boolean I;
    public int J;
    public int K;
    public boolean L;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public UIListContainer f10546z;

    @Override // android.view.ViewGroup
    public final void addView(View r5) {
        fn.a r10 = this.A;
        if (r10 == null) goto L9;
        if (r10 != r5) goto L7;
        super.addView(r10);
        return;
    L7:
        r10.addView(r5);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.a
    public final void bindDrawChildHook(b r5) {
        this.E = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.list.container.NestedScrollContainerView, android.view.View
    public final boolean canScrollHorizontally(int r5) {
        if (this.L == false) goto L7;
        if (this.F == true) goto L7;
        return true;
    L7:
        if (super.canScrollHorizontally(r5) == true) goto L12;
        return false;
    L12:
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.list.container.NestedScrollContainerView, android.view.View
    public final boolean canScrollVertically(int r5) {
        if (this.L == false) goto L7;
        if (this.F == false) goto L7;
        return true;
    L7:
        if (super.canScrollVertically(r5) == true) goto L12;
        return false;
    L12:
        return true;
    }

    @Override // android.view.View
    public final void computeScroll() {
        super.computeScroll();
        UIListContainer r5 = this.f10546z;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isEnableNewGesture() == false) goto L13;
        sn.a r10 = this.f10546z.getGestureArenaManager();
        if (r10 == null) goto L12;
        r10.a();
        return;
    L12:
        return;
    }

    public final void d(int r5, int r10) {
        if (this.G == r5) goto L5;
    L6:
        this.H = r10;
        this.G = r5;
        fn.a r11 = this.A;
        if (r11 == null) goto L11;
        r11.requestLayout();
        return;
    L11:
        return;
    L5:
        if (this.H != r10) goto L6;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        UIListContainer r10 = this.f10546z;
        if (r10 != null) goto L7;
        return super.dispatchTouchEvent(r5);
    L7:
        if (r10.isEnableNewGesture() == false) goto L19;
        if (Boolean.FALSE.equals(this.B) == false) goto L12;
        return true;
    L12:
        if (r5.getActionMasked() != 2) goto L19;
        if (this.B == null) goto L19;
        if (this.D == true) goto L19;
        r5.setAction(0);
        this.D = true;
    L19:
        return super.dispatchTouchEvent(r5);
    }

    public LinearLayout getLinearLayout() {
        return this.A;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        LynxLog.b(4, "ListContainerView", "onDetachedFromWindow: " + this + ", ui = " + this.f10546z);
        super.onDetachedFromWindow();
    }

    @Override // com.lynx.tasm.behavior.ui.list.container.NestedScrollContainerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        UIListContainer r10 = this.f10546z;
        if (r10 != null) goto L7;
        return super.onInterceptTouchEvent(r5);
    L7:
        if (r10.isEnableNewGesture() == false) goto L12;
        if (this.f10546z.getIncludeNativeGesture() == true) goto L12;
        return false;
    L12:
        if (this.f10546z.isEnableNewGesture() == false) goto L21;
        Boolean r11 = this.B;
        if (r11 == null) goto L21;
        if (r11.booleanValue() == true) goto L21;
        if (r5.getActionMasked() == 0) goto L21;
        return false;
    L21:
        if (this.f10546z.isEnableNewGesture() == false) goto L29;
        Boolean r12 = this.C;
        if (r12 == null) goto L29;
        if (r12.booleanValue() == false) goto L29;
        return this.C.booleanValue();
    L29:
        return super.onInterceptTouchEvent(r5);
    }

    @Override // android.view.View
    public final void onScrollChanged(int r10, int r11, int r12, int r13) {
        super.onScrollChanged(r10, r11, r12, r13);
        StringBuilder r14 = j0.v("onScrollChanged: ", r13, r11, " -> ", ", ");
        r14.append(r12);
        r14.append(" -> ");
        r14.append(r10);
        LynxLog.b(2, "ListContainerView", r14.toString());
        if (this.I == true) goto L30;
        UIListContainer r15 = this.f10546z;
        if (r15 != null) goto L7;
        return;
    L7:
        if (r15.getLynxContext() == null) goto L32;
        i r16 = this.f10546z.getLynxContext().f10141i;
        if (r16 != null) goto L12;
        LynxLog.b(4, "ListContainerView", "onScrollChanged: listNodeInfoFetcher is nullptr");
        return;
    L12:
        this.K = r11;
        if (this.f10546z.isRtl() == false) goto L15;
        int r5 = (int) Math.max((this.G - r10) - this.f10546z.getWidth(), 0.0f);
    L16:
        this.J = r5;
        int r17 = this.f10546z.getSign();
        float r18 = this.J;
        float r19 = r11;
        float r20 = r10;
        LynxTemplateRender r21 = (LynxTemplateRender) r16.f10879a;
        if (r21 == null) goto L19;
        r21.f(r17, r18, r19, r20, r19);
    L19:
        this.f10546z.y();
        this.f10546z.x();
        Iterator r22 = this.f10562t.iterator();
        if (r22.hasNext() == true) goto L22;
        return;
    L22:
        if (r22.next() != null) goto L29;
        if (this.f10546z.isRtl() == false) goto L27;
        Math.max((this.G - r12) - this.f10546z.getWidth(), 0.0f);
    L27:
        throw null;
    L29:
        throw new ClassCastException();
    L15:
        r5 = r10;
        goto L16
    L32:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.list.container.NestedScrollContainerView, android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        UIListContainer r10 = this.f10546z;
        if (r10 != null) goto L7;
        return super.onTouchEvent(r5);
    L7:
        if (r10.isEnableNewGesture() == false) goto L12;
        if (this.f10546z.getIncludeNativeGesture() == true) goto L12;
        return false;
    L12:
        if (this.f10546z.isEnableNewGesture() == false) goto L21;
        Boolean r11 = this.B;
        if (r11 == null) goto L21;
        if (r11.booleanValue() == true) goto L21;
        if (r5.getActionMasked() == 0) goto L21;
        return false;
    L21:
        if (this.f10546z.isEnableNewGesture() == false) goto L40;
        if (this.C == null) goto L40;
        if (r5.getAction() != 0) goto L28;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L40
    L28:
        if (r5.getAction() != 2) goto L35;
        getParent().requestDisallowInterceptTouchEvent(this.C.booleanValue());
        boolean r12 = this.C.booleanValue();
        if (this.C.booleanValue() == false) goto L32;
        return r12;
    L32:
        return super.onTouchEvent(r5);
    L35:
        if (r5.getAction() != 1) goto L37;
    L38:
        this.C = null;
        goto L40
    L37:
        if (r5.getAction() == 3) goto L38;
    L40:
        return super.onTouchEvent(r5);
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        fn.a r5 = this.A;
        if (r5 == null) goto L6;
        r5.removeAllViews();
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View r5) {
        fn.a r10 = this.A;
        if (r10 == null) goto L9;
        if (r10 != r5) goto L7;
        super.removeView(r10);
        return;
    L7:
        r10.removeView(r5);
        return;
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int r5) {
        fn.a r10 = this.A;
        if (r10 == null) goto L6;
        r10.removeViewAt(r5);
        return;
    }

    public void setForceCanScroll(boolean r5) {
        this.L = r5;
    }

    public void setOrientation(int r5) {
        int r10 = 0;
        if (r5 != 1) goto L5;
        boolean r11 = true;
    L6:
        this.F = r11;
        setIsVertical(r11);
        fn.a r12 = this.A;
        if (r12 == null) goto L12;
        if (r5 != 1) goto L10;
        r10 = 1;
    L10:
        r12.setOrientation(r10);
        return;
    L12:
        return;
    L5:
        r11 = false;
        goto L6
    }

    @Override // android.view.ViewGroup
    public final void addView(View r5, int r10) {
        fn.a r11 = this.A;
        if (r11 == null) goto L9;
        if (r11 != r5) goto L7;
        super.addView(r11, r10);
        return;
    L7:
        r11.addView(r5, r10);
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View r5, ViewGroup.LayoutParams r10) {
        fn.a r11 = this.A;
        if (r11 == null) goto L9;
        if (r11 != r5) goto L7;
        super.addView(r11, r10);
        return;
    L7:
        r11.addView(r5, r10);
        return;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r5, int r10, int r11) {
        fn.a r12 = this.A;
        if (r12 == null) goto L9;
        if (r12 != r5) goto L7;
        super.addView(r12, r10, r11);
        return;
    L7:
        r12.addView(r5, r10, r11);
        return;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r5, int r10, ViewGroup.LayoutParams r11) {
        fn.a r12 = this.A;
        if (r12 == null) goto L9;
        if (r12 != r5) goto L7;
        super.addView(r12, r10, r11);
        return;
    L7:
        r12.addView(r5, r10, r11);
        return;
    }
}
