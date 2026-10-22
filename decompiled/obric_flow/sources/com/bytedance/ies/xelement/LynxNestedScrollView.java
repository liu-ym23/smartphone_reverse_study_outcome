package com.bytedance.ies.xelement;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll;
import fn.a;
import java.util.Map;
import oe.b;
import oe.e;
import on.f;

/* JADX INFO: loaded from: classes2.dex */
public class LynxNestedScrollView extends AbsLynxUIScroll<AndroidNestedScrollView> implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6362c;
    public boolean d;

    @Override // oe.b
    public final void a(int r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void b(LynxBaseUI r5, boolean r10, String r11, String r12) {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void c(boolean r5) {
        if (r5 == true) goto L5;
        ((AndroidNestedScrollView) this.mView).setOrientation(1);
        return;
    L5:
        ((AndroidNestedScrollView) this.mView).setOrientation(0);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        AndroidNestedScrollView r10 = new AndroidNestedScrollView(r5);
        r10.setOnScrollListener(new e(this));
        return r10;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void drawChild(LynxFlattenUI r5, Canvas r10) {
        r5.draw(r10);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final Rect getBoundRectForOverflow() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getScrollX() {
        return ((AndroidNestedScrollView) this.mView).getHScrollView().getScrollX();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getScrollY() {
        return ((AndroidNestedScrollView) this.mView).getScrollY();
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void i(boolean r5) {
        if (r5 == false) goto L5;
        ((AndroidNestedScrollView) this.mView).setOrientation(1);
        return;
    L5:
        ((AndroidNestedScrollView) this.mView).setOrientation(0);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.ui.a0
    public final void invalidate() {
        ((AndroidNestedScrollView) this.mView).getLinearLayout().invalidate();
    }

    public final void j(String r10, int r11, int r12, int r13, int r14) {
        f r15 = new f(getSign(), r10);
        r15.d(r11, r12, ((AndroidNestedScrollView) this.mView).getContentHeight(), ((AndroidNestedScrollView) this.mView).getContentWidth(), r13 - r11, r14 - r12);
        if (getLynxContext() == null) goto L6;
        getLynxContext().g.b(r15);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void measure() {
        int r5 = 0;
        if (((AndroidNestedScrollView) this.mView).getOrientation() != 0) goto L5;
        boolean r10 = true;
    L6:
        int r11 = getWidth();
        int r12 = getHeight();
    L8:
        if (r5 >= getChildCount()) goto L14;
        LynxBaseUI r13 = getChildAt(r5);
        if (r10 == false) goto L12;
        r11 = Math.max(r11, r13.getLeft() + r13.getWidth());
    L13:
        r5 = r5 + 1;
        goto L8
    L12:
        r12 = Math.max(r12, r13.getTop() + r13.getHeight());
        goto L13
    L14:
        AndroidNestedScrollView r14 = (AndroidNestedScrollView) this.mView;
        r14.f6337h = r12;
        r14.g = r11;
        a r15 = r14.f6334a;
        if (r15 == null) goto L17;
        r15.requestLayout();
    L17:
        super.measure();
        return;
    L5:
        r10 = false;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        int r5 = this.mPaddingLeft + this.mBorderLeftWidth;
        int r10 = this.mPaddingRight + this.mBorderRightWidth;
        int r11 = this.mPaddingTop + this.mBorderTopWidth;
        int r12 = this.mPaddingBottom + this.mBorderBottomWidth;
        ((AndroidNestedScrollView) this.mView).f6334a.setPadding(r5, r11, r10, r12);
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void scrollToIndex(int r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map r5) {
        super.setEvents(r5);
        if (r5 == null) goto L24;
        this.f6360a = false;
        this.f6361b = false;
        this.f6362c = false;
        if (r5.containsKey("scrolltolower") == false) goto L9;
        this.f6361b = true;
    L9:
        if (r5.containsKey("scrolltoupper") == false) goto L12;
        this.f6360a = true;
    L12:
        if (r5.containsKey("scroll") == false) goto L15;
        this.f6362c = true;
    L15:
        if (this.f6361b == false) goto L17;
    L22:
        ((AndroidNestedScrollView) this.mView).setOnScrollListener(this);
        return;
    L17:
        if (this.f6360a == true) goto L22;
        if (this.f6362c == true) goto L22;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setLowerThreshole(int r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollBarEnable(boolean r5) {
        ((AndroidNestedScrollView) this.mView).setScrollBarEnable(r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        LynxLog.b(4, "UIScrollView", e.getMessage());
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollLeft(int r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollTap(boolean r5) {
        this.d = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollTop(int r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setUpperThreshole(int r5) {
    }

    @Override // oe.b
    public final void a(int r10, int r11, int r12, int r13) {
        if (this.f6362c == false) goto L6;
        j("scroll", r10, r11, r12, r13);
    L6:
        if (r10 != r12) goto L21;
        if (r10 != 0) goto L21;
        if (r11 == 0) goto L10;
        View r5 = ((AndroidNestedScrollView) this.mView).getChildAt(0);
        if (r5 == null) goto L42;
        int r14 = r5.getMeasuredHeight();
        int r15 = ((AndroidNestedScrollView) this.mView).getScrollY();
        if (r14 == (((AndroidNestedScrollView) this.mView).getMeasuredHeight() + r15)) goto L18;
        return;
    L18:
        if (this.f6361b == false) goto L44;
        j("scrolltolower", r10, r11, r12, r13);
        return;
    L44:
        return;
    L42:
        return;
    L10:
        if (this.f6360a == false) goto L41;
        j("scrolltoupper", r10, r11, r12, r13);
        return;
    L41:
        return;
    L21:
        if (r11 != r13) goto L45;
        if (r11 != 0) goto L46;
        if (r10 == 0) goto L38;
        if (r10 <= 0) goto L28;
        if (r12 == 0) goto L38;
    L28:
        if (((AndroidNestedScrollView) this.mView).getHScrollView() == null) goto L47;
        View r16 = ((AndroidNestedScrollView) this.mView).getHScrollView().getChildAt(0);
        if (r16 != null) goto L32;
        return;
    L32:
        if (r10 == (r16.getMeasuredWidth() - ((AndroidNestedScrollView) this.mView).getMeasuredWidth())) goto L34;
        return;
    L34:
        if (this.f6361b == false) goto L50;
        j("scrolltolower", r10, r11, r12, r13);
        return;
    L50:
        return;
    L47:
        return;
    L38:
        if (this.f6360a == false) goto L51;
        j("scrolltoupper", r10, r11, r12, r13);
        return;
    L51:
        return;
    L46:
        return;
    }
}
