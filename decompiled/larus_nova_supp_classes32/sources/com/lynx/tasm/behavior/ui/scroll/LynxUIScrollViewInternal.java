package com.lynx.tasm.behavior.ui.scroll;

import android.content.Context;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollView;
import com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewScrolling;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.utils.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxUIScrollViewInternal extends UISimpleView<LynxBaseScrollView> implements LynxBaseScrollViewScrolling.a {
    public static final /* synthetic */ int i = 0;
    public long a;
    public long b;
    public int[] c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public ArrayList<a> h;

    public interface a {
        void a(LynxUIScrollViewInternal r1);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isScrollContainer() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final boolean isScrollable() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void measure() {
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r1 >= getChildCount()) goto L6;
        LynxBaseUI r4 = getChildAt(r1);
        r3 = Math.max(r3, ((r4.getHeight() + r4.getTop()) + r4.getMarginBottom()) + this.mPaddingBottom);
        r2 = Math.max(r2, ((r4.getWidth() + r4.getLeft()) + r4.getMarginRight()) + this.mPaddingRight);
        r1 = r1 + 1;
        goto L4
    L6:
        ((LynxBaseScrollView) this.mView).setScrollContentSize(new int[]{r2, r3});
        if (this.mFirstRender == false) goto L13;
        Iterator<a> r5 = this.h.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        r5.next().a(this);
        goto L10
    L12:
        this.h = null;
        this.mFirstRender = false;
    L13:
        Q();
        super.measure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void O() {
        if (this.a == 0) goto L7;
        long r0 = System.currentTimeMillis();
        if ((r0 - this.b) < this.a) goto L8;
        int[] r4 = ((LynxBaseScrollView) this.mView).getScrollOffset();
        HashMap<String, Object> r5 = new HashMap();
        r5.put("deltaX", Float.valueOf(i.c(r4[0] - this.c[0])));
        r5.put("deltaY", Float.valueOf(i.c(r4[1] - this.c[1])));
        P("scroll", r5);
        this.c = r4;
        this.b = r0;
    L8:
        Q();
        int[] r1 = ((LynxBaseScrollView) getView()).getScrollOffset();
        int r2 = 0;
        boolean r6 = false;
    L10:
        if (r2 >= this.mChildren.size()) goto L15;
        if (((LynxBaseUI) ListProtector.get(this.mChildren, r2)).checkStickyOnParentScroll(r1[0], r1[1]) == false) goto L14;
        r6 = true;
    L14:
        r2 = r2 + 1;
        goto L10
    L15:
        if (r6 == false) goto L21;
        invalidate();
        return;
    L21:
        return;
    L7:
        int[] r3 = ((LynxBaseScrollView) this.mView).getScrollOffset();
        HashMap<String, Object> r7 = new HashMap();
        r7.put("deltaX", Float.valueOf(i.c(r3[0] - this.c[0])));
        r7.put("deltaY", Float.valueOf(i.c(r3[1] - this.c[1])));
        P("scroll", r7);
        this.c = r3;
        goto L8
    }

    public final void Q() {
        LynxBaseScrollView r0 = (LynxBaseScrollView) this.mView;
        if (r0.c == false) goto L5;
        int r1 = r0.getScrollOffsetVertically();
    L7:
        if (r0.c == false) goto L9;
        int[] r2 = r0.getScrollRangeVertically();
    L10:
        boolean r3 = false;
        if (r1 > (r2[0] + this.d)) goto L13;
        boolean r4 = true;
    L15:
        if (r1 < (r2[1] - this.e)) goto L18;
        r3 = true;
    L18:
        if (r4 == true) goto L20;
    L22:
        if (r3 == true) goto L24;
    L26:
        this.f = r4;
        this.g = r3;
        return;
    L24:
        if (this.g == true) goto L26;
        P("scrolltolower", null);
        goto L26
    L20:
        if (this.f == true) goto L22;
        P("scrolltoupper", null);
        goto L22
    L13:
        r4 = false;
        goto L15
    L9:
        r2 = r0.getScrollRangeHorizontally();
        goto L10
    L5:
        r1 = r0.getScrollOffsetHorizontally();
        goto L7
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getScrollX() {
        return ((LynxBaseScrollView) this.mView).getScrollX();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getScrollY() {
        return ((LynxBaseScrollView) this.mView).getScrollY();
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        ((LynxBaseScrollView) this.mView).setScrollDelegate(null);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        LynxBaseScrollView r0 = (LynxBaseScrollView) this.mView;
        r0.d = getWidth();
        LynxBaseScrollView r1 = (LynxBaseScrollView) this.mView;
        r1.e = getHeight();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReady() {
        super.onNodeReady();
    }

    public LynxUIScrollViewInternal(LynxContext r3) {
        super(r3);
        this.a = 0;
        this.b = 0;
        this.c = new int[]{0, 0};
        this.d = 0;
        this.e = 0;
        this.f = false;
        this.g = false;
        this.h = new ArrayList();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r2) {
        LynxBaseScrollView r0 = new LynxBaseScrollView(r2);
        r0.setScrollDelegate(this);
        return r0;
    }

    public final void P(String r6, HashMap<String, Object> r7) {
        HashMap r0 = new HashMap();
        LynxBaseScrollView r1 = (LynxBaseScrollView) this.mView;
        r0.put("scrollLeft", Float.valueOf(i.c(r1.getScrollOffsetHorizontally())));
        r0.put("scrollTop", Float.valueOf(i.c(r1.getScrollOffsetVertically())));
        boolean r3 = true;
        r0.put("scrollHeight", Float.valueOf(i.c(r1.getScrollRangeVertically()[1])));
        r0.put("scrollWidth", Float.valueOf(i.c(r1.getScrollRangeHorizontally()[1])));
        if (r1.h == 1) goto L6;
        r3 = false;
    L6:
        r0.put("isDragging", Boolean.valueOf(r3));
        r0.put("scrollState", Integer.valueOf(r1.h));
        if (r7 == null) goto L9;
        r0.putAll(r7);
    L9:
        this.mContext.getEventEmitter().sendCustomEvent(new com.lynx.tasm.event.a(getSign(), r6, r0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int[] M(LynxBaseUI r3, LynxUIScrollViewInternal r4, boolean r5) {
        int[] r0 = {0, 0};
        if (r4 == null) goto L9;
        if (r3 == null) goto L9;
        if (r5 == false) goto L8;
        r0[0] = (((LynxBaseScrollView) r4.getView()).getScrollRange()[1] - r3.getLeft()) - r3.getWidth();
        r0[1] = r3.getTop();
        goto L9
    L8:
        r0[0] = r3.getLeft();
        r0[1] = r3.getTop();
    L9:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void N(LynxBaseUI r7, boolean r8, String r9) {
        int[] r1 = {0, 0};
        if ("center".equals(r9) == false) goto L6;
        r1[1] = r1[1] - ((((LynxBaseScrollView) getView()).getHeight() - r7.getHeight()) / 2);
        r1[0] = r1[0] - ((((LynxBaseScrollView) getView()).getWidth() - r7.getWidth()) / 2);
    L8:
        if (r7 == this) goto L13;
        r1[1] = r1[1] + r7.getTop();
        r1[0] = r1[0] + r7.getLeft();
        r7 = r7.getParentBaseUI();
    L11:
        if ((r7 instanceof LynxFlattenUI) == false) goto L8;
        r7 = (LynxBaseUI) r7.getParent();
        goto L11
    L13:
        if (r8 == false) goto L15;
        ((LynxBaseScrollView) this.mView).e(r1);
        return;
    L15:
        ((LynxBaseScrollView) this.mView).f(r1);
        return;
    L6:
        if ("end".equals(r9) == false) goto L8;
        r1[1] = r1[1] - (((LynxBaseScrollView) getView()).getHeight() - r7.getHeight());
        r1[0] = r1[0] - (((LynxBaseScrollView) getView()).getWidth() - r7.getWidth());
        goto L8
    }
}
