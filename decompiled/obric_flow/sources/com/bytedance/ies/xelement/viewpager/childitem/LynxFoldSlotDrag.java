package com.bytedance.ies.xelement.viewpager.childitem;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;
import bf.h;
import com.bytedance.ies.xelement.viewpager.LynxTabBarView;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll;
import fn.a;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ye.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/childitem/LynxFoldSlotDrag;", "Lcom/lynx/tasm/behavior/ui/scroll/AbsLynxUIScroll;", "Lcom/bytedance/ies/xelement/viewpager/childitem/AndroidNestedScrollView;", "", "value", "", "setEnableDrag", "(Z)V", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxFoldSlotDrag extends AbsLynxUIScroll<AndroidNestedScrollView> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f6541c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LynxTabBarView f6542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference f6543b;

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void c(boolean r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new AndroidNestedScrollView(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final Rect getBoundRectForOverflow() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getScrollX() {
        return ((AndroidNestedScrollView) this.mView).getScrollX();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getScrollY() {
        return ((AndroidNestedScrollView) this.mView).getScrollY();
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void i(boolean r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r5, int r10) {
        super.insertChild(r5, r10);
        if ((r5 instanceof LynxUI) == false) goto L17;
        LynxUI r11 = (LynxUI) r5;
        r11.setParent(this);
        if ((r11 instanceof LynxTabBarView) == false) goto L18;
        LynxTabBarView r12 = (LynxTabBarView) r5;
        this.f6542a = r12;
        WeakReference r13 = this.f6543b;
        if (r13 == null) goto L11;
        h r14 = (h) r13.get();
        if (r14 == null) goto L11;
        r14.setTabLayout(r12);
    L11:
        WeakReference r15 = this.f6543b;
        if (r15 == null) goto L19;
        h r16 = (h) r15.get();
        if (r16 == null) goto L20;
        r16.setTabBarElementAdded(false);
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.ui.a0
    public final void invalidate() {
        super.invalidate();
        LinearLayout r5 = ((AndroidNestedScrollView) this.mView).getLinearLayout();
        if (r5 == null) goto L6;
        r5.invalidate();
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
        int r13 = getChildCount();
    L7:
        if (r5 >= r13) goto L13;
        LynxBaseUI r14 = getChildAt(r5);
        if (r10 == false) goto L11;
        r11 = Math.max(r11, r14.getLeft() + r14.getWidth());
    L12:
        r5 = r5 + 1;
        goto L7
    L11:
        r12 = Math.max(r12, r14.getTop() + r14.getHeight());
        goto L12
    L13:
        AndroidNestedScrollView r15 = (AndroidNestedScrollView) this.mView;
        r15.f6528h = r12;
        r15.g = r11;
        a r16 = r15.f6525a;
        if (r16 == null) goto L16;
        r16.requestLayout();
    L16:
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
        ((AndroidNestedScrollView) this.mView).f6525a.setPadding(r5, r11, r10, r12);
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void scrollToIndex(int r5) {
    }

    @c0(defaultBoolean = true, name = "enable-drag")
    public final void setEnableDrag(boolean r5) {
        setEnableScroll(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setEnableScroll(final boolean r5) {
        ((AndroidNestedScrollView) getView()).setOnTouchListener(new d(r5));
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setLowerThreshole(int r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setOverflow(Integer r5) {
        super.setOverflow(r5);
        Object r10 = r5;
        if (r5 != null) goto L5;
        r10 = Boolean.FALSE;
    L5:
        boolean r11 = Intrinsics.areEqual(r10, 1);
        ((AndroidNestedScrollView) this.mView).setClipChildren(r11);
        ((AndroidNestedScrollView) this.mView).getLinearLayout().setClipChildren(r11);
        ((AndroidNestedScrollView) this.mView).getHScrollView().setClipChildren(r11);
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollBarEnable(boolean r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollLeft(int r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollTap(boolean r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollTop(int r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setUpperThreshole(int r5) {
    }
}
