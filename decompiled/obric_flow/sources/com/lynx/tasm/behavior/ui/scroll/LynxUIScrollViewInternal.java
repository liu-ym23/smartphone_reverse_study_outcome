package com.lynx.tasm.behavior.ui.scroll;

import android.content.Context;
import android.view.View;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollView;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import gn.g;
import hn.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import on.b;

/* JADX INFO: loaded from: classes2.dex */
public class LynxUIScrollViewInternal extends UISimpleView<LynxBaseScrollView> implements h {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f10611i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f10612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f10613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f10614c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f10615h;

    /* JADX WARN: Multi-variable type inference failed */
    public static int[] i(LynxBaseUI r5, LynxUIScrollViewInternal r10, boolean r11) {
        int[] r12 = {0, 0};
        if (r5 == null) goto L8;
        if (r11 == false) goto L7;
        r12[0] = (((LynxBaseScrollView) r10.getView()).getScrollRange()[1] - r5.getLeft()) - r5.getWidth();
        r12[1] = r5.getTop();
        return r12;
    L7:
        r12[0] = r5.getLeft();
        r12[1] = r5.getTop();
    L8:
        return r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(String r10, LynxBaseUI r11, boolean r12) {
        int[] r5 = {0, 0};
        if ("center".equals(r10) == false) goto L6;
        r5[1] = r5[1] - ((((LynxBaseScrollView) getView()).getHeight() - r11.getHeight()) / 2);
        r5[0] = r5[0] - ((((LynxBaseScrollView) getView()).getWidth() - r11.getWidth()) / 2);
    L8:
        if (r11 == this) goto L13;
        r5[1] = r11.getTop() + r5[1];
        r5[0] = r11.getLeft() + r5[0];
        r11 = r11.getParentBaseUI();
    L11:
        if ((r11 instanceof LynxFlattenUI) == false) goto L8;
        r11 = (LynxBaseUI) r11.getParent();
        goto L11
    L13:
        if (r12 == false) goto L16;
        ((LynxBaseScrollView) this.mView).b(r5);
        return;
    L16:
        LynxBaseScrollView r13 = (LynxBaseScrollView) this.mView;
        if (r13.f17351c == false) goto L20;
        int r14 = r5[1];
        int[] r15 = r13.getScrollRangeVertically();
        r13.scrollTo(r13.getScrollX(), Math.min(Math.max(r14, r15[0]), r15[1]));
        return;
    L20:
        int r16 = r5[0];
        int[] r17 = r13.getScrollRangeHorizontally();
        r13.scrollTo(Math.min(Math.max(r16, r17[0]), r17[1]), r13.getScrollY());
        return;
    L6:
        if ("end".equals(r10) == false) goto L8;
        r5[1] = r5[1] - (((LynxBaseScrollView) getView()).getHeight() - r11.getHeight());
        r5[0] = r5[0] - (((LynxBaseScrollView) getView()).getWidth() - r11.getWidth());
        goto L8
    }

    public final void c(String r10, HashMap r11) {
        HashMap r5 = new HashMap();
        LynxBaseScrollView r12 = (LynxBaseScrollView) this.mView;
        r5.put("scrollLeft", Integer.valueOf(r12.getScrollOffsetHorizontally()));
        r5.put("scrollTop", Integer.valueOf(r12.getScrollOffsetVertically()));
        boolean r13 = true;
        r5.put("scrollHeight", Integer.valueOf(r12.getScrollRangeVertically()[1]));
        r5.put("scrollWidth", Integer.valueOf(r12.getScrollRangeHorizontally()[1]));
        if (r12.f17352h == 1) goto L6;
        r13 = false;
    L6:
        r5.put("isDragging", Boolean.valueOf(r13));
        r5.put("scrollState", Integer.valueOf(r12.f17352h));
        if (r11 == null) goto L9;
        r5.putAll(r11);
    L9:
        this.mContext.g.b(new b(getSign(), r10, r5));
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        LynxBaseScrollView r10 = new LynxBaseScrollView(r5);
        r10.setScrollDelegate(this);
        return r10;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        ((LynxBaseScrollView) this.mView).setScrollDelegate(null);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getScrollX() {
        return ((LynxBaseScrollView) this.mView).getScrollX();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getScrollY() {
        return ((LynxBaseScrollView) this.mView).getScrollY();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isScrollContainer() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isScrollable() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j() {
        if (this.f10612a == 0) goto L7;
        long r10 = System.currentTimeMillis();
        if ((r10 - this.f10613b) < this.f10612a) goto L8;
        int[] r5 = ((LynxBaseScrollView) this.mView).getScrollOffset();
        HashMap r11 = new HashMap();
        r11.put("deltaX", Integer.valueOf(r5[0] - this.f10614c[0]));
        r11.put("deltaY", Integer.valueOf(r5[1] - this.f10614c[1]));
        c("scroll", r11);
        this.f10614c = r5;
        this.f10613b = r10;
    L8:
        k();
        int[] r12 = ((LynxBaseScrollView) getView()).getScrollOffset();
        int r13 = 0;
        boolean r14 = false;
    L10:
        if (r13 >= this.mChildren.size()) goto L15;
        if (this.mChildren.get(r13).checkStickyOnParentScroll(r12[0], r12[1]) == false) goto L14;
        r14 = true;
    L14:
        r13 = r13 + 1;
        goto L10
    L15:
        if (r14 == false) goto L21;
        invalidate();
        return;
    L21:
        return;
    L7:
        int[] r15 = ((LynxBaseScrollView) this.mView).getScrollOffset();
        HashMap r16 = new HashMap();
        r16.put("deltaX", Integer.valueOf(r15[0] - this.f10614c[0]));
        r16.put("deltaY", Integer.valueOf(r15[1] - this.f10614c[1]));
        c("scroll", r16);
        this.f10614c = r15;
        goto L8
    }

    public final void k() {
        LynxBaseScrollView r5 = (LynxBaseScrollView) this.mView;
        if (r5.f17351c == false) goto L5;
        int r10 = r5.getScrollOffsetVertically();
    L7:
        if (r5.f17351c == false) goto L9;
        int[] r11 = r5.getScrollRangeVertically();
    L10:
        boolean r12 = false;
        if (r10 > (r11[0] + this.d)) goto L13;
        boolean r13 = true;
    L15:
        if (r10 < (r11[1] - this.e)) goto L18;
        r12 = true;
    L18:
        if (r13 == true) goto L20;
    L22:
        if (r12 == true) goto L24;
    L26:
        this.f = r13;
        this.g = r12;
        return;
    L24:
        if (this.g == true) goto L26;
        c("scrolltolower", null);
        goto L26
    L20:
        if (this.f == true) goto L22;
        c("scrolltoupper", null);
        goto L22
    L13:
        r13 = false;
        goto L15
    L9:
        r11 = r5.getScrollRangeHorizontally();
        goto L10
    L5:
        r10 = r5.getScrollOffsetHorizontally();
        goto L7
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void measure() {
        int r5 = 0;
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r5 >= getChildCount()) goto L6;
        LynxBaseUI r12 = getChildAt(r5);
        r11 = Math.max(r11, (r12.getMarginBottom() + (r12.getTop() + r12.getHeight())) + this.mPaddingBottom);
        r10 = Math.max(r10, (r12.getMarginRight() + (r12.getLeft() + r12.getWidth())) + this.mPaddingRight);
        r5 = r5 + 1;
        goto L4
    L6:
        ((LynxBaseScrollView) this.mView).setScrollContentSize(new int[]{r10, r11});
        if (this.mFirstRender == false) goto L13;
        Iterator r13 = this.f10615h.iterator();
    L10:
        if (r13.hasNext() == false) goto L12;
        ((g) r13.next()).a(this);
        goto L10
    L12:
        this.f10615h = null;
        this.mFirstRender = false;
    L13:
        k();
        super.measure();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        LynxBaseScrollView r5 = (LynxBaseScrollView) this.mView;
        r5.d = getWidth();
        LynxBaseScrollView r10 = (LynxBaseScrollView) this.mView;
        r10.e = getHeight();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReady() {
        onAnimationNodeReady();
        afterAnimationNodeReady();
    }
}
