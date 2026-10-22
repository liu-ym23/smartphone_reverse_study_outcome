package com.lynx.xelement.scroll.coordinator.childitem;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import q8a.a;
import q8a.c;
import q8a.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@LynxBehavior(isCreateAsync = true, tagName = {"scroll-coordinator-slot-drag"})
@LynxGeneratorName(packageName = "com.lynx.xelement.scroll.coordinator.childitem")
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\u0007"}, d2 = {"Lcom/lynx/xelement/scroll/coordinator/childitem/LynxUIScrollCoordinatorSlotDrag;", "Lcom/lynx/tasm/behavior/ui/scroll/AbsLynxUIScroll;", "Lcom/lynx/xelement/scroll/coordinator/childitem/ScrollCoordinatorNestedScrollView;", NameKeys.UnloadStrategy_No_Strategy, "value", NameKeys.UnloadStrategy_No_Strategy, "setEnableDrag", "ScrollCoordinator_release"}, k = 1, mv = {1, 6, 0})
public class LynxUIScrollCoordinatorSlotDrag extends AbsLynxUIScroll<ScrollCoordinatorNestedScrollView> {
    public static final /* synthetic */ int c = 0;
    public Object a;
    public WeakReference<Object> b;

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void N(boolean r1) {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void O(boolean r1) {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final Rect getBoundRectForOverflow() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void scrollToIndex(int r1) {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setLowerThreshole(int r1) {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollBarEnable(boolean r1) {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollLeft(int r1) {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollTap(boolean r1) {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollTop(int r1) {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setUpperThreshole(int r1) {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getScrollX() {
        return ((ScrollCoordinatorNestedScrollView) this.mView).getScrollX();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getScrollY() {
        return ((ScrollCoordinatorNestedScrollView) this.mView).getScrollY();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void measure() {
        int r1 = 0;
        if (((ScrollCoordinatorNestedScrollView) this.mView).getOrientation() != 0) goto L5;
        boolean r0 = true;
    L6:
        int r2 = getWidth();
        int r3 = getHeight();
        int r4 = getChildCount();
    L7:
        if (r1 >= r4) goto L13;
        LynxBaseUI r5 = getChildAt(r1);
        if (r0 == false) goto L11;
        r2 = Math.max(r2, r5.getWidth() + r5.getLeft());
    L12:
        r1 = r1 + 1;
        goto L7
    L11:
        r3 = Math.max(r3, r5.getHeight() + r5.getTop());
        goto L12
    L13:
        ScrollCoordinatorNestedScrollView r6 = (ScrollCoordinatorNestedScrollView) this.mView;
        r6.h = r3;
        r6.g = r2;
        c r7 = r6.a;
        if (r7 == null) goto L16;
        r7.requestLayout();
    L16:
        super.measure();
        return;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.ui.k
    public final void invalidate() {
        super.invalidate();
        LinearLayout r0 = ((ScrollCoordinatorNestedScrollView) this.mView).getLinearLayout();
        if (r0 == null) goto L6;
        r0.invalidate();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        int r0 = this.mPaddingLeft + this.mBorderLeftWidth;
        int r1 = this.mPaddingRight + this.mBorderRightWidth;
        int r2 = this.mPaddingTop + this.mBorderTopWidth;
        int r3 = this.mPaddingBottom + this.mBorderBottomWidth;
        ((ScrollCoordinatorNestedScrollView) this.mView).setPadding(r0, r2, r1, r3);
    }

    public final void P(Object r2) {
        this.a = r2;
        WeakReference<Object> r0 = this.b;
        if (r0 == null) goto L8;
        Object r1 = r0.get();
        if (r1 == null) goto L9;
        f.a(r1, r2);
        return;
    L9:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new ScrollCoordinatorNestedScrollView(r2);
    }

    @LynxProp(defaultBoolean = true, name = "enable-drag")
    public final void setEnableDrag(boolean r1) {
        setEnableScroll(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setEnableScroll(final boolean r3) {
        ((ScrollCoordinatorNestedScrollView) getView()).setOnTouchListener(new a(r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setOverflow(Integer r3) {
        super.setOverflow(r3);
        if (r3 != null) goto L6;
    L7:
        boolean r4 = true;
    L9:
        boolean r5 = !r4;
        ((ScrollCoordinatorNestedScrollView) this.mView).setClipChildren(r5);
        ((ScrollCoordinatorNestedScrollView) this.mView).getLinearLayout().setClipChildren(r5);
        ((ScrollCoordinatorNestedScrollView) this.mView).getHScrollView().setClipChildren(r5);
        return;
    L6:
        if (r3.intValue() != 1) goto L7;
        r4 = false;
        goto L9
    }

    public LynxUIScrollCoordinatorSlotDrag(LynxContext r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r1, int r2) {
        super.insertChild(r1, r2);
        if ((r1 instanceof LynxUI) == false) goto L8;
        ((LynxUI) r1).setParent(this);
        if (f.b(r1) == false) goto L9;
        P(r1);
        return;
    L9:
        return;
    }
}
