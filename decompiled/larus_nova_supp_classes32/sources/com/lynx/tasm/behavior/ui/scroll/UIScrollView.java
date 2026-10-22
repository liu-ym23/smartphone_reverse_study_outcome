package com.lynx.tasm.behavior.ui.scroll;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.core.math.MathUtils;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.list.container.UIListContainer;
import com.lynx.tasm.behavior.ui.utils.h;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.tasm.utils.i;
import com.lynx.tasm.utils.n;
import com.obric.aivoice.core.data.NameKeys;
import g7a.g;
import g7a.j;
import g7a.k;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import m7a.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIScrollView extends AbsLynxUIScroll<AndroidScrollView> implements g7a.c {
    public static final /* synthetic */ int L = 0;
    public boolean A;
    public boolean B;
    public boolean C;
    public int D;
    public Callback E;
    public String F;
    public int G;
    public String H;
    public final HashMap<String, Integer> I;
    public int J;
    public Boolean K;
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public ArrayList<Integer> n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public UIBounceView w;
    public UIBounceView x;
    public boolean y;
    public CustomUIScrollViewAccessibilityDelegate z;

    public class CustomUIScrollViewAccessibilityDelegate extends AccessibilityDelegateCompat {
        public final /* synthetic */ UIScrollView a;

        public CustomUIScrollViewAccessibilityDelegate(UIScrollView r1) {
            this.a = r1;
        }

        public final void onInitializeAccessibilityEvent(View r3, AccessibilityEvent r4) {
            super.onInitializeAccessibilityEvent(r3, r4);
            int r5 = this.a.u0();
            if (this.a.A == false) goto L6;
            if (r5 <= 0) goto L6;
            boolean r0 = true;
        L7:
            r4.setScrollable(r0);
            r4.setScrollX(((AndroidScrollView) UIScrollView.c0(this.a)).getRealScrollX());
            r4.setScrollY(((AndroidScrollView) UIScrollView.d0(this.a)).getRealScrollY());
            UIScrollView r1 = this.a;
            if (r1.a == false) goto L10;
            r4.setMaxScrollX(((AndroidScrollView) UIScrollView.e0(r1)).getRealScrollX());
            r4.setMaxScrollY(r5);
            return;
        L10:
            r4.setMaxScrollX(r5);
            r4.setMaxScrollY(((AndroidScrollView) UIScrollView.f0(this.a)).getRealScrollY());
            return;
        L6:
            r0 = false;
            goto L7
        }

        public final void onInitializeAccessibilityNodeInfo(View r3, AccessibilityNodeInfoCompat r4) {
            super.onInitializeAccessibilityNodeInfo(r3, r4);
            int r5 = this.a.u0();
            if (this.a.A == false) goto L6;
            if (r5 <= 0) goto L6;
            boolean r0 = true;
        L7:
            r4.setScrollable(r0);
            if (r0 == false) goto L24;
            UIScrollView r1 = this.a;
            if (r1.a == false) goto L18;
            if (((AndroidScrollView) UIScrollView.g0(r1)).getRealScrollY() <= 0) goto L15;
            r4.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            return;
        L15:
            if (((AndroidScrollView) UIScrollView.h0(this.a)).getRealScrollY() >= r5) goto L26;
            r4.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            return;
        L26:
            return;
        L18:
            if (((AndroidScrollView) UIScrollView.i0(r1)).getRealScrollX() <= 0) goto L21;
            r4.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            return;
        L21:
            if (((AndroidScrollView) UIScrollView.j0(this.a)).getRealScrollX() >= r5) goto L29;
            r4.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            return;
        L29:
            return;
        L24:
            return;
        L6:
            r0 = false;
            goto L7
        }

        public final boolean performAccessibilityAction(View r6, int r7, Bundle r8) {
            UIScrollView r9 = this.a;
            int r10 = UIScrollView.L;
            int r11 = r9.v0();
            int r12 = this.a.u0();
            UIScrollView r0 = this.a;
            if (r0.A == false) goto L6;
            if (r12 <= 0) goto L6;
            boolean r1 = true;
        L7:
            if (r1 == true) goto L9;
            return false;
        L9:
            int r2 = ((AndroidScrollView) UIScrollView.k0(r0)).getRealScrollX();
            int r3 = ((AndroidScrollView) UIScrollView.l0(this.a)).getRealScrollY();
            if (r7 == 4096) goto L24;
            if (r7 == 8192) goto L15;
            return false;
        L15:
            if (this.a.a == false) goto L19;
            int r13 = Math.max(r3 - (r11 / 2), 0);
            if (r13 == r3) goto L22;
            ((AndroidScrollView) UIScrollView.o0(this.a)).i(0, r13, true);
        L22:
            return true;
        L19:
            int r14 = Math.max(r2 - (r11 / 2), 0);
            if (r14 == r2) goto L22;
            ((AndroidScrollView) UIScrollView.p0(this.a)).i(r14, 0, true);
            goto L22
        L24:
            if (this.a.a == false) goto L28;
            int r15 = Math.min((r11 / 2) + r3, r12);
            if (r15 == r3) goto L31;
            ((AndroidScrollView) UIScrollView.m0(this.a)).i(0, r15, true);
        L31:
            return true;
        L28:
            int r16 = Math.min((r11 / 2) + r2, r12);
            if (r16 == r2) goto L31;
            ((AndroidScrollView) UIScrollView.n0(this.a)).i(r16, 0, true);
        L6:
            r1 = false;
            goto L7
        }
    }

    public class a implements g {
        public final /* synthetic */ AndroidScrollView a;

        @Override // g7a.g
        public final int getScrollX() {
            AndroidScrollView r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.getRealScrollX();
        }

        @Override // g7a.g
        public final int getScrollY() {
            AndroidScrollView r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.getRealScrollY();
        }

        public a(AndroidScrollView r1) {
            this.a = r1;
        }

        @Override // g7a.g
        public final void scrollTo(int r3, int r4) {
            AndroidScrollView r0 = this.a;
            if (r0 == null) goto L6;
            r0.i(r3, r4, false);
            return;
        }
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        this.E = null;
        T r1 = this.mView;
        if (r1 == 0) goto L8;
        ArrayList<AndroidScrollView.b> r2 = ((AndroidScrollView) r1).y;
        if (r2 == null) goto L7;
        r2.clear();
    L7:
        ((AndroidScrollView) this.mView).setScrollSnapHelper(null);
    L8:
        super.destroy();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isAccessibilityHostUI() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isScrollContainer() {
        return true;
    }

    @Override // g7a.c
    public final void t() {
        this.l = true;
        y0();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final int getScrollContainerDirection() {
        if (((AndroidScrollView) this.mView).u == false) goto L5;
        return -1;
    L5:
        return 1;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getScrollX() {
        return ((AndroidScrollView) this.mView).getHScrollView().getScrollX();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getScrollY() {
        return ((AndroidScrollView) this.mView).getScrollY();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.ui.k
    public final void invalidate() {
        ((AndroidScrollView) this.mView).getLinearLayout().invalidate();
        ((AndroidScrollView) this.mView).invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g7a.c
    public final void l() {
        if (this.l == true) goto L5;
        return;
    L5:
        if (this.n != null) goto L7;
        return;
    L7:
        if (this.mContext != null) goto L10;
        return;
    L10:
        if (this.a == false) goto L12;
        int r0 = ((AndroidScrollView) this.mView).getRealScrollY();
    L14:
        if (this.a == false) goto L16;
        int r1 = getHeight();
    L18:
        if (this.a == false) goto L20;
        int r2 = ((AndroidScrollView) getView()).getContentHeight();
    L21:
        int r3 = 0;
        int r4 = Math.max(r2 - r1, 0);
    L23:
        if (r3 >= this.n.size()) goto L34;
        LynxBaseUI r5 = this.mContext.findLynxUIBySign(((Integer) ListProtector.get(this.n, r3)).intValue());
        if (r5 == null) goto L27;
        r5.calculateStickyTranslateWithOffset(r0, this.a, r1, r4);
    L27:
        r3 = r3 + 1;
        goto L23
    L34:
        return;
    L20:
        r2 = ((AndroidScrollView) getView()).getContentWidth();
        goto L21
    L16:
        r1 = getWidth();
        goto L18
    L12:
        r0 = ((AndroidScrollView) this.mView).getRealScrollX();
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void layout() {
        ((AndroidScrollView) this.mView).c(getOverflow(), this.C);
        boolean r0 = this.y;
        if (r0 == true) goto L5;
    L18:
        if (r0 == true) goto L20;
    L33:
        super.layout();
        int r1 = this.p;
        if (r1 <= 0) goto L46;
        if (this.a == false) goto L41;
        if ((r1 + getHeight()) > ((AndroidScrollView) getView()).getContentHeight()) goto L41;
        int r2 = ((AndroidScrollView) getView()).getRealScrollX();
        ((AndroidScrollView) getView()).i(r2, this.p, false);
        this.p = 0;
    L41:
        if (this.a == true) goto L46;
        if ((this.p + getWidth()) > ((AndroidScrollView) getView()).getContentWidth()) goto L46;
        int r3 = ((AndroidScrollView) getView()).getRealScrollY();
        ((AndroidScrollView) getView()).i(this.p, r3, false);
        this.p = 0;
    L46:
        if (this.m == false) goto L53;
        this.m = false;
        LynxContext r4 = this.mContext;
        if (r4 != null) goto L50;
        return;
    L50:
        if (r4.getEnableNewSticky() == false) goto L55;
        l();
        return;
    L55:
        return;
    L53:
        return;
    L20:
        if (this.a == false) goto L33;
        UIBounceView r5 = this.x;
        if (r5 == null) goto L24;
        int r6 = r5.getHeight();
    L25:
        AndroidScrollView r7 = (AndroidScrollView) this.mView;
        int r8 = u0();
        g7a.b r9 = r7.i;
        if (r9 == null) goto L33;
        if (r8 == r9.e) goto L30;
    L31:
        r7.requestLayout();
    L32:
        g7a.b r10 = r7.i;
        r10.e = r8;
        r10.f = r6;
        goto L33
    L30:
        if (r6 == r9.f) goto L32;
    L24:
        r6 = 0;
        goto L25
    L5:
        if (this.a == true) goto L18;
        UIBounceView r11 = this.x;
        if (r11 == null) goto L9;
        int r12 = r11.getWidth();
    L10:
        AndroidScrollView.CustomHorizontalScrollView r13 = ((AndroidScrollView) this.mView).getHScrollView();
        int r14 = u0();
        g7a.b r15 = r13.r;
        if (r15 == null) goto L33;
        if (r14 == r15.e) goto L15;
    L16:
        r13.requestLayout();
    L17:
        g7a.b r16 = r13.r;
        r16.e = r14;
        r16.f = r12;
        goto L33
    L15:
        if (r12 == r15.f) goto L17;
    L9:
        r12 = 0;
        goto L10
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void measure() {
        int r1 = 0;
        if (((AndroidScrollView) this.mView).getOrientation() != 0) goto L5;
        boolean r0 = true;
    L6:
        int r3 = getWidth();
        int r4 = getHeight();
    L8:
        if (r1 >= getChildCount()) goto L15;
        LynxBaseUI r5 = getChildAt(r1);
        if (r0 == false) goto L12;
        r3 = Math.max(r3, ((r5.getWidth() + r5.getLeft()) + r5.getMarginRight()) + this.mPaddingRight);
    L13:
        r1 = r1 + 1;
        goto L8
    L12:
        r4 = Math.max(r4, ((r5.getHeight() + r5.getTop()) + r5.getMarginBottom()) + this.mPaddingBottom);
        goto L13
    L15:
        if (((AndroidScrollView) this.mView).getContentWidth() == r3) goto L17;
    L18:
        float r2 = r3;
        float r6 = r4;
        if (this.k == false) goto L23;
        m7a.a r7 = new m7a.a(getSign(), "contentsizechanged");
        r7.a("scrollWidth", Float.valueOf(i.c(r2)));
        r7.a("scrollHeight", Float.valueOf(i.c(r6)));
        if (getLynxContext() == null) goto L23;
        getLynxContext().getEventEmitter().sendCustomEvent(r7);
    L23:
        AndroidScrollView r8 = (AndroidScrollView) this.mView;
        r8.x = r4;
        r8.w = r3;
        g7a.a r9 = r8.p;
        if (r9 == null) goto L26;
        r9.requestLayout();
    L26:
        AndroidScrollView r10 = (AndroidScrollView) this.mView;
        r10.h(r10.getScrollX(), ((AndroidScrollView) this.mView).getScrollY());
        this.m = true;
    L27:
        super.measure();
        return;
    L17:
        if (((AndroidScrollView) this.mView).getContentHeight() == r4) goto L27;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final void onInvalidate() {
        if (this.mView != 0) goto L5;
        return;
    L5:
        if (isEnableNewGesture() == false) goto L9;
        ViewCompat.postInvalidateOnAnimation(this.mView);
        return;
    }

    public final int u0() {
        if (this.a == false) goto L5;
        int r0 = ((AndroidScrollView) this.mView).getContentHeight();
    L7:
        return r0 - v0();
    L5:
        r0 = ((AndroidScrollView) this.mView).getContentWidth();
        goto L7
    }

    public final int v0() {
        if (this.a == false) goto L5;
        int r0 = getHeight() - ((AndroidScrollView) this.mView).getPaddingBottom();
        int r1 = ((AndroidScrollView) this.mView).getPaddingTop();
    L7:
        return r0 - r1;
    L5:
        r0 = getWidth() - ((AndroidScrollView) this.mView).getPaddingLeft();
        r1 = ((AndroidScrollView) this.mView).getPaddingRight();
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void w0() {
        if (this.q <= 0) goto L24;
        if (this.mFirstRender == true) goto L11;
        if (t0() == null) goto L11;
        if (t0().initialPropsFlushed("initialScrollOffset", s0()) == true) goto L24;
    L11:
        if (t0() == null) goto L14;
        t0().setInitialPropsHasFlushed("initialScrollOffset", s0());
    L14:
        if (this.a == false) goto L19;
        if ((this.q + getHeight()) > ((AndroidScrollView) getView()).getContentHeight()) goto L19;
        int r0 = ((AndroidScrollView) getView()).getRealScrollX();
        ((AndroidScrollView) getView()).i(r0, this.q, false);
        C0(0);
    L19:
        if (this.a == true) goto L24;
        if ((this.q + getWidth()) > ((AndroidScrollView) getView()).getContentWidth()) goto L24;
        int r1 = ((AndroidScrollView) getView()).getRealScrollY();
        ((AndroidScrollView) getView()).i(this.q, r1, false);
        C0(0);
    L24:
        if (this.v != (-1)) goto L26;
        return;
    L26:
        if (this.mFirstRender == true) goto L32;
        if (t0() == null) goto L32;
        if (t0().initialPropsFlushed("initialScrollIndex", s0()) == false) goto L32;
    L35:
        this.v = -1;
        return;
    L32:
        if (t0() == null) goto L34;
        t0().setInitialPropsHasFlushed("initialScrollIndex", s0());
    L34:
        ((AndroidScrollView) this.mView).setScrollToIndex(this.v);
        goto L35
    }

    public final void x0() {
        if (this.a == false) goto L5;
        ((AndroidScrollView) this.mView).setOrientation(1);
        return;
    L5:
        ((AndroidScrollView) this.mView).setOrientation(0);
    }

    public final void z0() {
        if (this.y == true) goto L41;
        UIBounceView r0 = this.w;
        if (r0 == null) goto L42;
        int r6 = -1;
        if (this.a == false) goto L25;
        if (r0.a == 3) goto L11;
    L13:
        UIBounceView r1 = this.w;
        if (r1.a == 2) goto L16;
    L18:
        if (r6 <= 0) goto L43;
        T r2 = this.mView;
        if (r2 == 0) goto L23;
        ((AndroidScrollView) r2).fling((int) 0.0d);
    L23:
        ((AndroidScrollView) this.mView).i(0, r6, true);
        return;
    L43:
        return;
    L16:
        if (r1.getHeight() <= getScrollY()) goto L18;
        r6 = this.w.getHeight();
        goto L18
    L11:
        if (r0.getTop() >= (getScrollY() + getHeight())) goto L13;
        r6 = this.w.getTop() - getHeight();
        goto L18
    L25:
        if (r0.a == 0) goto L27;
    L29:
        UIBounceView r3 = this.w;
        if (r3.a == 1) goto L32;
    L34:
        if (r6 <= 0) goto L45;
        T r4 = this.mView;
        if (r4 == 0) goto L39;
        ((AndroidScrollView) r4).getHScrollView().fling((int) 0.0d);
    L39:
        ((AndroidScrollView) this.mView).i(r6, 0, true);
        return;
    L45:
        return;
    L32:
        if (r3.getWidth() <= getScrollX()) goto L34;
        r6 = this.w.getWidth();
        goto L34
    L27:
        if (r0.getLeft() >= (getScrollX() + getWidth())) goto L29;
        r6 = this.w.getLeft() - getWidth();
        goto L34
    L42:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final View getAccessibilityHostView() {
        return getRealParentView();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final Rect getBoundRectForOverflow() {
        return super.getClipBounds();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final Map<Integer, t7a.a> getGestureHandlers() {
        return super.getGestureHandlers();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final int getMemberScrollX() {
        return getScrollX();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final int getMemberScrollY() {
        return getScrollY();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final View getRealParentView() {
        AndroidScrollView r0 = (AndroidScrollView) getView();
        if (this.a == true) goto L7;
        if (r0 != null) goto L6;
        return r0;
    L6:
        return r0.getHScrollView();
    L7:
        return r0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        int r0 = this.mPaddingLeft + this.mBorderLeftWidth;
        int r1 = this.mPaddingRight + this.mBorderRightWidth;
        int r2 = this.mPaddingTop + this.mBorderTopWidth;
        int r3 = this.mPaddingBottom + this.mBorderBottomWidth;
        ((AndroidScrollView) this.mView).setPadding(r0, r2, r1, r3);
        this.m = true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReady() {
        super.onNodeReady();
        int r0 = this.D;
        if (r0 <= 0) goto L6;
        ((AndroidScrollView) this.mView).setFadingEdgeLength(r0);
        ((AndroidScrollView) this.mView).setHorizontalFadingEdgeEnabled(!this.a);
        ((AndroidScrollView) this.mView).setVerticalFadingEdgeEnabled(this.a);
    L6:
        if (this.B == true) goto L8;
    L25:
        this.mFirstRender = false;
        if (this.m == false) goto L37;
        this.m = false;
        LynxContext r1 = this.mContext;
        if (r1 != null) goto L30;
        return;
    L30:
        if (r1.getEnableNewSticky() == false) goto L39;
        l();
        return;
    L39:
        return;
    L37:
        return;
    L8:
        if (this.a == true) goto L17;
        AndroidScrollView.CustomHorizontalScrollView r2 = ((AndroidScrollView) this.mView).getHScrollView();
        r2.getClass();
        ViewConfiguration r5 = ViewConfiguration.get(r2.getContext());     // Catch: IllegalAccessException -> L15 NoSuchFieldException -> L16
        Field r3 = HorizontalScrollView.class.getDeclaredField("mTouchSlop");     // Catch: IllegalAccessException -> L15 NoSuchFieldException -> L16
        if (r5 == null) goto L25;
        if (r3 == null) goto L25;
        int r6 = r5.getScaledPagingTouchSlop();     // Catch: IllegalAccessException -> L15 NoSuchFieldException -> L16
        r3.setAccessible(true);     // Catch: IllegalAccessException -> L15 NoSuchFieldException -> L16
        r3.set(r2, Integer.valueOf(r6));     // Catch: IllegalAccessException -> L15 NoSuchFieldException -> L16
        r2.f = r6;     // Catch: IllegalAccessException -> L15 NoSuchFieldException -> L16
    L15:
        LLog.e("LynxNestedHorizontalScrollView", "Failed to get mTouchSlop field of HorizontalScrollView!");
    L16:
        LLog.e("LynxNestedHorizontalScrollView", "Failed to get mTouchSlop field of HorizontalScrollView!");
        goto L25
    L17:
        AndroidScrollView r4 = (AndroidScrollView) this.mView;
        r4.getClass();
        ViewConfiguration r7 = ViewConfiguration.get(r4.getContext());     // Catch: IllegalAccessException -> L23 NoSuchFieldException -> L24
        Field r8 = ScrollView.class.getDeclaredField("mTouchSlop");     // Catch: IllegalAccessException -> L23 NoSuchFieldException -> L24
        if (r7 == null) goto L25;
        if (r8 == null) goto L25;
        int r9 = r7.getScaledPagingTouchSlop();     // Catch: IllegalAccessException -> L23 NoSuchFieldException -> L24
        r8.setAccessible(true);     // Catch: IllegalAccessException -> L23 NoSuchFieldException -> L24
        r8.set(r4, Integer.valueOf(r9));     // Catch: IllegalAccessException -> L23 NoSuchFieldException -> L24
    L23:
        LLog.e("LynxNestedScrollView", "Failed to get mTouchSlop field of NestedScrollView!");
    L24:
        LLog.e("LynxNestedScrollView", "Failed to get mTouchSlop field of NestedScrollView!");
        goto L25
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReload() {
        super.onNodeReload();
        if (this.mLynxDirection != 2) goto L5;
        ((AndroidScrollView) getView()).i(u0(), 0, false);
        return;
    L5:
        ((AndroidScrollView) getView()).i(0, 0, false);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onPropsUpdated() {
        super.onPropsUpdated();
        if (this.mView == 0) goto L14;
        if (this.J != getOverflow()) goto L12;
        Boolean r0 = this.K;
        if (r0 == null) goto L12;
        if (r0.booleanValue() == this.C) goto L14;
    L12:
        this.J = getOverflow();
        this.K = Boolean.valueOf(this.C);
        ((AndroidScrollView) this.mView).c(getOverflow(), this.C);
    L14:
        if (this.a == false) goto L16;
        ((AndroidScrollView) this.mView).setEnableNewBounce(this.y);
    L17:
        com.lynx.tasm.behavior.ui.accessibility.d r1 = this.mContext.getLynxAccessibilityWrapper();
        if (r1 != null) goto L20;
        return;
    L20:
        if (r1.e() == true) goto L24;
        if (r1.f() == true) goto L24;
        return;
    L24:
        if (this.z != null) goto L27;
        this.z = new CustomUIScrollViewAccessibilityDelegate(this);
    L27:
        if (this.a == false) goto L29;
        ViewCompat.setAccessibilityDelegate(this.mView, this.z);
        ViewCompat.setAccessibilityDelegate(((AndroidScrollView) this.mView).getHScrollView(), null);
    L31:
        if (r1.f() == false) goto L43;
        T r2 = this.mView;
        int r3 = 1;
        if (this.a == false) goto L35;
        int r4 = 1;
    L36:
        ViewCompat.setImportantForAccessibility(r2, r4);
        AndroidScrollView.CustomHorizontalScrollView r5 = ((AndroidScrollView) this.mView).getHScrollView();
        if (this.a == false) goto L39;
        r3 = 2;
    L39:
        ViewCompat.setImportantForAccessibility(r5, r3);
        ViewCompat.setImportantForAccessibility(((AndroidScrollView) this.mView).getLinearLayout(), 2);
        return;
    L35:
        r4 = 2;
        goto L36
    L43:
        return;
    L29:
        ViewCompat.setAccessibilityDelegate(this.mView, null);
        ViewCompat.setAccessibilityDelegate(((AndroidScrollView) this.mView).getHScrollView(), this.z);
        goto L31
    L16:
        ((AndroidScrollView) this.mView).getHScrollView().setEnableNewBounce(this.y);
        goto L17
    }

    public final String s0() {
        return constructListStateCacheKey(getTagName(), this.H, getIdSelector());
    }

    public final LynxBaseUI t0() {
        LynxBaseUI r0 = getLynxContext().getLynxUIOwner().findLynxUIBySign(this.G);
        if ((r0 instanceof UIList) == false) goto L5;
        return r0;
    L5:
        if ((r0 instanceof UIListContainer) == true) goto L10;
        return null;
    L10:
        return r0;
    }

    public final void y0() {
        int r0 = getScrollX();
        int r1 = getScrollY();
        int r2 = 0;
    L4:
        if (r2 >= this.mChildren.size()) goto L6;
        ((LynxBaseUI) ListProtector.get(this.mChildren, r2)).checkStickyOnParentScroll(r0, r1);
        r2 = r2 + 1;
        goto L4
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isAccessibilityDirectionVertical() {
        return this.a;
    }

    public static /* synthetic */ View Q(UIScrollView r0) {
        return r0.mView;
    }

    public static /* synthetic */ View R(UIScrollView r0) {
        return r0.mView;
    }

    public static /* synthetic */ View S(UIScrollView r0) {
        return r0.mView;
    }

    public static /* synthetic */ View T(UIScrollView r0) {
        return r0.mView;
    }

    public static /* synthetic */ View U(UIScrollView r0) {
        return r0.mView;
    }

    public static /* synthetic */ List V(UIScrollView r0) {
        return r0.mChildren;
    }

    public static /* synthetic */ List W(UIScrollView r0) {
        return r0.mChildren;
    }

    public static void X(UIScrollView r1) {
        LynxContext r0 = r1.mContext;
        if (r0 != null) goto L5;
    L7:
        r1.y0();
        return;
    L5:
        if (r0.getEnableNewSticky() == false) goto L7;
        r1.l();
    }

    public static /* synthetic */ View Y(UIScrollView r0) {
        return r0.mView;
    }

    public static /* synthetic */ View Z(UIScrollView r0) {
        return r0.mView;
    }

    public static /* synthetic */ View a0(UIScrollView r0) {
        return r0.mView;
    }

    public static /* synthetic */ LynxContext b0(UIScrollView r0) {
        return r0.mContext;
    }

    public static /* synthetic */ View c0(UIScrollView r0) {
        return r0.mView;
    }

    public static /* synthetic */ View d0(UIScrollView r0) {
        return r0.mView;
    }

    public static /* synthetic */ View e0(UIScrollView r0) {
        return r0.mView;
    }

    public static /* synthetic */ View f0(UIScrollView r0) {
        return r0.mView;
    }

    public static /* synthetic */ View g0(UIScrollView r0) {
        return r0.mView;
    }

    public static /* synthetic */ View h0(UIScrollView r0) {
        return r0.mView;
    }

    public static /* synthetic */ View i0(UIScrollView r0) {
        return r0.mView;
    }

    public static /* synthetic */ View j0(UIScrollView r0) {
        return r0.mView;
    }

    public static /* synthetic */ View k0(UIScrollView r0) {
        return r0.mView;
    }

    public static /* synthetic */ View l0(UIScrollView r0) {
        return r0.mView;
    }

    public static /* synthetic */ View m0(UIScrollView r0) {
        return r0.mView;
    }

    public static /* synthetic */ View n0(UIScrollView r0) {
        return r0.mView;
    }

    public static /* synthetic */ View o0(UIScrollView r0) {
        return r0.mView;
    }

    public static /* synthetic */ View p0(UIScrollView r0) {
        return r0.mView;
    }

    public final void C0(int r5) {
        if (r5 != 0) goto L6;
        this.q = 0;
        return;
    L6:
        if (t0() != null) goto L8;
        this.q = r5;
        return;
    L8:
        if (t0().initialPropsFlushed("initialScrollOffset", s0()) == false) goto L10;
        r5 = 0;
    L10:
        this.q = r5;
    }

    public final void D0(int r5) {
        if (r5 != (-1)) goto L6;
        this.v = -1;
        return;
    L6:
        if (t0() != null) goto L8;
        this.v = r5;
        return;
    L8:
        if (t0().initialPropsFlushed("initialScrollIndex", s0()) == false) goto L10;
        r5 = -1;
    L10:
        this.v = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void N(boolean r3) {
        if (this.m == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        this.m = r0;
        this.a = !r3;
        x0();
        return;
    L5:
        if (this.a == r3) goto L8;
        r0 = false;
        goto L9
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void O(boolean r2) {
        if (this.m == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        this.m = r0;
        this.a = r2;
        x0();
        return;
    L5:
        if (this.a != r2) goto L8;
        r0 = false;
        goto L9
    }

    @LynxUIMethod
    public void autoScroll(ReadableMap r10) {
        AndroidScrollView r0 = (AndroidScrollView) this.mView;
        r0.getClass();
        double r4 = r10.getDouble("rate", 0.0d);
        if (r10.getBoolean("start", true) == false) goto L10;
        int r11 = (int) i.a(r4 / 60.0d);
        if (r4 != 0.0d) goto L8;
        LLog.e("LynxUIScrollView", "the rate of speed  is not right, current value is 0");
        return;
    L8:
        if (r0.G == true) goto L13;
        r0.G = true;
        r0.I = r11;
        r0.post(new AndroidScrollView.d(r0));
        return;
    L13:
        return;
    L10:
        r0.G = false;
        r0.I = 0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void consumeGesture(boolean r3) {
        AndroidScrollView r0 = (AndroidScrollView) this.mView;
        r0.m = Boolean.valueOf(r3);
        if (r3 == false) goto L6;
        r0.l = false;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r2) {
        AndroidScrollView r0 = new AndroidScrollView(r2, this);
        r0.setOnScrollListener(new c(this, r0));
        return r0;
    }

    @LynxUIMethod
    public void getScrollInfo(Callback r5) {
        int r0 = getMemberScrollX();
        int r1 = getMemberScrollY();
        JavaOnlyMap r2 = new JavaOnlyMap();
        r2.putInt("scrollX", h.h(this.mContext, r0));
        r2.putInt("scrollY", h.h(this.mContext, r1));
        r2.putInt("scrollRange", h.h(this.mContext, u0()));
        r5.invoke(new Object[]{0, r2});
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void interceptGesture(boolean r2) {
        AndroidScrollView r0 = (AndroidScrollView) this.mView;
        r0.n = Boolean.valueOf(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final boolean isAtBorder(boolean r4) {
        if (isEnableNewGesture() == false) goto L21;
        T r0 = this.mView;
        if (r0 == 0) goto L21;
        if (r4 == false) goto L16;
        if (((AndroidScrollView) r0).u == false) goto L14;
        return !q0(2);
    L14:
        return !q0(0);
    L16:
        if (((AndroidScrollView) r0).u == false) goto L20;
        return !q0(3);
    L20:
        return !q0(1);
    L21:
        return false;
    }

    public final boolean q0(int r6) {
        T r0 = this.mView;
        if (r0 != 0) goto L6;
        return false;
    L6:
        if (r6 == 0) goto L21;
        if (r6 == 1) goto L19;
        if (r6 == 2) goto L17;
        if (r6 == 3) goto L15;
        return false;
    L15:
        return ((AndroidScrollView) r0).getHScrollView().canScrollHorizontally(1);
    L17:
        return ((AndroidScrollView) r0).getHScrollView().canScrollHorizontally(-1);
    L19:
        return ((AndroidScrollView) r0).canScrollVertically(1);
    L21:
        return ((AndroidScrollView) r0).canScrollVertically(-1);
    }

    @Override // g7a.c
    public final void r(int r3) {
        if (this.n != null) goto L6;
        this.n = new ArrayList();
    L6:
        if (this.n.contains(Integer.valueOf(r3)) == true) goto L8;
        this.n.add(Integer.valueOf(r3));
    L8:
        this.l = !this.n.isEmpty();
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void scrollToIndex(int r2) {
        A0(r2, false);
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setBlockDescendantFocusability(boolean r2) {
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ((AndroidScrollView) r0).setBlockDescendantFocusability(r2);
        return;
    }

    @LynxProp(defaultBoolean = false, name = "enable-nested-scroll")
    public void setEnableNestedScroll(boolean r2) {
        T r0 = this.mView;
        if (r0 != 0) goto L5;
        return;
    L5:
        ((AndroidScrollView) r0).setNestedScrollingEnabled(r2);
        if (((AndroidScrollView) this.mView).getHScrollView() == null) goto L9;
        ((AndroidScrollView) this.mView).getHScrollView().setNestedScrollingEnabled(r2);
        return;
    }

    @LynxProp(defaultBoolean = false, name = "android-enable-new-bounce")
    public void setEnableNewBounce(boolean r1) {
        this.y = r1;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setEnableNewNested(boolean r2) {
        T r0 = this.mView;
        if (r0 != 0) goto L5;
        return;
    L5:
        ((AndroidScrollView) r0).setEnableNewNested(r2);
        if (((AndroidScrollView) this.mView).getHScrollView() == null) goto L9;
        ((AndroidScrollView) this.mView).getHScrollView().setEnableNewNested(r2);
        return;
    }

    @LynxProp(defaultBoolean = true, name = "android-enable-overflow-hidden-padding-visible")
    public void setEnableOverflowHiddenPaddingVisible(boolean r1) {
        this.C = r1;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setEnableScroll(boolean r2) {
        T r0 = this.mView;
        if (r0 == 0) goto L5;
        ((AndroidScrollView) r0).setEnableScroll(r2);
    L5:
        this.A = r2;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map<String, EventsListener> r3) {
        super.setEvents(r3);
        if (r3 != null) goto L5;
        return;
    L5:
        this.b = false;
        this.d = false;
        this.g = false;
        this.i = false;
        if (r3.containsKey("scrolltolower") == false) goto L9;
        this.d = true;
    L9:
        if (r3.containsKey("scrolltoloweredge") == false) goto L12;
        this.e = true;
    L12:
        if (r3.containsKey("scrolltoupper") == false) goto L15;
        this.b = true;
    L15:
        if (r3.containsKey("scrolltoupperedge") == false) goto L18;
        this.c = true;
    L18:
        if (r3.containsKey("scrolltonormalstate") == false) goto L21;
        this.f = true;
    L21:
        if (r3.containsKey("scroll") == false) goto L24;
        this.g = true;
    L24:
        if (r3.containsKey("scrollstart") == false) goto L27;
        this.h = true;
    L27:
        if (r3.containsKey("scrollend") == false) goto L30;
        this.i = true;
    L30:
        if (r3.containsKey("contentsizechanged") == false) goto L33;
        this.k = true;
        return;
    }

    @LynxProp(name = "fading-edge-length")
    public void setFadingEdgeLength(String r3) {
        int r4 = (int) n.d(r3, 0.0f, 0.0f, this.mContext.getScreenMetrics());
        this.D = r4;
        if (r4 > 0) goto L8;
        T r5 = this.mView;
        if (r5 == 0) goto L9;
        ((AndroidScrollView) r5).setHorizontalFadingEdgeEnabled(false);
        ((AndroidScrollView) this.mView).setVerticalFadingEdgeEnabled(false);
        return;
    L9:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setForbidFlingFocusChange(boolean r2) {
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ((AndroidScrollView) r0).setForbidFlingFocusChange(r2);
        return;
    }

    @LynxProp(defaultBoolean = false, name = "force-can-scroll")
    public void setForceCanScroll(boolean r2) {
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ((AndroidScrollView) r0).setForceCanScroll(r2);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setGestureDetectors(Map<Integer, s7a.a> r1) {
        super.setGestureDetectors(r1);
    }

    @LynxProp(name = "initial-scroll-offset")
    public void setInitialScrollOffset(Integer r5) {
        if (r5 != null) goto L5;
        this.I.remove("initialScrollOffset");
        return;
    L5:
        this.I.put("initialScrollOffset", Integer.valueOf((int) i.b(r5.intValue(), 0.0f)));
        if (this.a == false) goto L8;
        F0(r5.intValue(), true, true);
        return;
    L8:
        E0(r5.intValue(), true, true);
    }

    @LynxProp(name = "initial-scroll-to-index")
    public void setInitialScrollToIndex(Integer r3) {
        if (r3 != null) goto L5;
        this.I.remove("initialScrollIndex");
        return;
    L5:
        this.I.put("initialScrollIndex", r3);
        A0(r3.intValue(), true);
    }

    @LynxProp(name = "item-snap")
    public void setItemSnap(ReadableMap r4) {
        if (this.mView != 0) goto L5;
        return;
    L5:
        if (r4 != null) goto L7;
    L10:
        ((AndroidScrollView) this.mView).setScrollSnapHelper(null);
        return;
    L7:
        if (r4.size() == 0) goto L10;
        ((AndroidScrollView) this.mView).setScrollSnapHelper(new b(r4, new d(this)));
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setLowerThreshole(int r1) {
        this.r = r1;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setLynxDirection(int r6) {
        T r0 = this.mView;
        AndroidScrollView r1 = (AndroidScrollView) r0;
        if (r6 == this.mLynxDirection) goto L5;
        boolean r2 = true;
    L6:
        r1.K = r2;
        this.mLynxDirection = r6;
        if (r6 != 2) goto L9;
        ViewCompat.setLayoutDirection(r0, 1);
        ViewCompat.setLayoutDirection(((AndroidScrollView) this.mView).getHScrollView(), 1);
        ViewCompat.setLayoutDirection(((AndroidScrollView) this.mView).getLinearLayout(), 1);
        return;
    L9:
        ViewCompat.setLayoutDirection(r0, 0);
        ViewCompat.setLayoutDirection(((AndroidScrollView) this.mView).getHScrollView(), 0);
        ViewCompat.setLayoutDirection(((AndroidScrollView) this.mView).getLinearLayout(), 0);
        return;
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final void setPanInterceptAncestors(boolean r2) {
        ((AndroidScrollView) this.mView).setPanInterceptAncestors(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final void setPanInterceptDescendants(boolean r2) {
        ((AndroidScrollView) this.mView).setPanInterceptDescendants(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final void setPanInterceptSelf(boolean r2) {
        ((AndroidScrollView) this.mView).setPanInterceptSelf(r2);
    }

    @LynxProp(defaultBoolean = false, name = "android-preference-consume-gesture")
    public void setPreferenceConsumeGesture(boolean r1) {
        this.o = r1;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollBarEnable(boolean r2) {
        ((AndroidScrollView) this.mView).setScrollBarEnable(Boolean.valueOf(r2).booleanValue());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        LLog.e("UIScrollView", e.getMessage());
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollLeft(int r3) {
        E0(r3, true, false);
    }

    @LynxProp(customType = "vertical", name = "scroll-orientation")
    public void setScrollOrientation(String r5) {
        boolean r0 = this.a;
        boolean r2 = false;
        if (TextUtils.equals(r5, "vertical") == false) goto L6;
        this.a = true;
    L10:
        if (this.m == false) goto L12;
    L13:
        r2 = true;
    L14:
        this.m = r2;
        x0();
        return;
    L12:
        if (r0 == this.a) goto L14;
    L6:
        if (TextUtils.equals(r5, "horizontal") == false) goto L8;
        this.a = false;
        goto L10
    L8:
        this.a = true;
        goto L10
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollTap(boolean r1) {
        this.j = r1;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollTop(int r3) {
        F0(r3, true, false);
    }

    @LynxProp(name = "android-touch-slop")
    public void setTouchSlop(String r2) {
        this.B = TextUtils.equals(r2, "paging");
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setUpperThreshole(int r1) {
        this.s = r1;
    }

    @Override // g7a.c
    public final void z(int r2) {
        ArrayList<Integer> r0 = this.n;
        if (r0 != null) goto L6;
        this.l = false;
        return;
    L6:
        r0.remove(Integer.valueOf(r2));
        this.l = !this.n.isEmpty();
    }

    public UIScrollView(LynxContext r3, Object r4) {
        super(r3, r4);
        this.c = false;
        this.e = false;
        this.f = false;
        this.l = false;
        this.m = false;
        this.n = null;
        this.o = false;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 1;
        this.u = -1;
        this.v = -1;
        this.y = false;
        this.z = null;
        this.A = true;
        this.B = false;
        this.C = true;
        this.D = 0;
        this.I = new HashMap();
        this.J = Integer.MIN_VALUE;
    }

    public final void A0(int r4, boolean r5) {
        T r0 = this.mView;
        if (r0 != 0) goto L5;
        return;
    L5:
        if (((AndroidScrollView) r0).getLinearLayout() != null) goto L7;
        return;
    L7:
        if (r5 == false) goto L9;
        D0(-1);
    L11:
        if (r4 >= 0) goto L15;
        LLog.e("LynxUIScrollView", "Invalid scroll-to-index with index < 0: " + r4);
        return;
    L15:
        if (this.mChildren.size() != 0) goto L20;
        if (r5 == false) goto L18;
        D0(r4);
        return;
    L18:
        this.u = r4;
        return;
    L20:
        if (r4 < this.mChildren.size()) goto L23;
        LLog.e("LynxUIScrollView", "Invalid scroll-to-index with index out of boundary: " + r4);
        return;
    L23:
        LinearLayout r1 = ((AndroidScrollView) this.mView).getLinearLayout();
        if (this.a == false) goto L26;
        int r2 = ((AndroidScrollView) this.mView).getHeight();
    L28:
        if (this.a == false) goto L30;
        int r3 = r1.getHeight();
    L31:
        if (r2 == 0) goto L34;
        if (r3 == 0) goto L34;
        boolean r6 = true;
    L35:
        if (r6 == false) goto L39;
        if (r5 == true) goto L39;
        ((AndroidScrollView) this.mView).setScrollToIndex(r4);
        return;
    L39:
        if (r5 == false) goto L41;
        D0(r4);
        return;
    L41:
        this.u = r4;
        return;
    L34:
        r6 = false;
        goto L35
    L30:
        r3 = r1.getWidth();
        goto L31
    L26:
        r2 = ((AndroidScrollView) this.mView).getWidth();
        goto L28
    L9:
        this.u = -1;
        goto L11
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final boolean canConsumeGesture(float r5, float r6) {
        if (isEnableNewGesture() == false) goto L31;
        T r0 = this.mView;
        if (r0 != 0) goto L8;
        return false;
    L8:
        if (((AndroidScrollView) r0).u == false) goto L20;
        if (isAtBorder(true) == false) goto L14;
        if (r5 >= 0.0f) goto L14;
        return false;
    L14:
        if (isAtBorder(false) == true) goto L16;
    L17:
        return true;
    L16:
        if (r5 <= 0.0f) goto L17;
        return false;
    L20:
        if (isAtBorder(true) == false) goto L24;
        if (r6 >= 0.0f) goto L24;
        return false;
    L24:
        if (isAtBorder(false) == true) goto L26;
    L27:
        return true;
    L26:
        if (r6 <= 0.0f) goto L27;
        return false;
    L31:
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void drawChild(LynxFlattenUI r1, Canvas r2) {
        super.drawChild(r1, r2);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r2, int r3) {
        super.insertChild(r2, r3);
        if ((r2 instanceof UIBounceView) == false) goto L14;
        UIBounceView r4 = (UIBounceView) r2;
        if (this.y == false) goto L12;
        int r5 = r4.a;
        if (r5 != 1) goto L9;
    L11:
        this.x = r4;
        return;
    L9:
        if (r5 == 2) goto L11;
        return;
    L12:
        this.w = r4;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final void onGestureScrollBy(final float r2, final float r3) {
        if (isEnableNewGesture() == true) goto L5;
        return;
    L5:
        UIThreadUtils.runOnUiThreadImmediately(new k(this, r2, r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onListCellAppear(String r3, LynxBaseUI r4) {
        super.onListCellAppear(r3, r4);
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        this.H = r3;
        this.G = r4.getSign();
        String r5 = constructListStateCacheKey(getTagName(), r3, getIdSelector());
        Object r0 = r4.getValueFromNativeStorage(r5);
        if (r0 == null) goto L12;
        int r6 = ((Integer) r0).intValue();
        if (((AndroidScrollView) getView()).u == false) goto L10;
        E0(r6, false, false);
        return;
    L10:
        F0(r6, false, false);
        return;
    L12:
        if (this.I.containsKey("initialScrollIndex") == false) goto L17;
        if (r4.initialPropsFlushed("initialScrollIndex", r5) == true) goto L17;
        D0(this.I.get("initialScrollIndex").intValue());
    L17:
        if (this.I.containsKey("initialScrollOffset") == true) goto L19;
        return;
    L19:
        if (r4.initialPropsFlushed("initialScrollOffset", r5) == true) goto L25;
        C0(this.I.get("initialScrollOffset").intValue());
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onListCellPrepareForReuse(String r3, LynxBaseUI r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        this.G = r4.getSign();
        this.H = r3;
        if (this.a == false) goto L9;
        ((AndroidScrollView) this.mView).i(0, 0, false);
        return;
    L9:
        if (this.mLynxDirection != 2) goto L11;
        AndroidScrollView r5 = (AndroidScrollView) this.mView;
        r5.i(r5.getContentWidth() - ((AndroidScrollView) this.mView).getWidth(), 0, false);
        return;
    L11:
        ((AndroidScrollView) this.mView).i(0, 0, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final float[] scrollBy(float r10, float r11) {
        float[] r0 = new float[4];
        if (this.mView != 0) goto L5;
        return r0;
    L5:
        int r1 = getScrollX();
        int r2 = getScrollY();
        T r3 = this.mView;
        if (((AndroidScrollView) r3).u == false) goto L8;
        ((AndroidScrollView) r3).getHScrollView().scrollBy((int) r10, 0);
    L10:
        if (Math.abs(r10) <= Float.MIN_VALUE) goto L12;
    L13:
        recognizeGesturere();
    L15:
        if (((AndroidScrollView) getView()).u == false) goto L17;
        float r4 = getScrollX() - r1;
        r0[0] = r4;
        r0[1] = 0.0f;
        r0[2] = r10 - r4;
        r0[3] = r11;
    L18:
        return r0;
    L17:
        r0[0] = 0.0f;
        float r5 = getScrollY() - r2;
        r0[1] = r5;
        r0[2] = r10;
        r0[3] = r11 - r5;
        goto L18
    L12:
        if (Math.abs(r11) <= Float.MIN_VALUE) goto L15;
    L8:
        ((AndroidScrollView) r3).scrollBy(0, (int) r11);
        goto L10
    }

    @LynxUIMethod
    public void scrollTo(ReadableMap r23, Callback r24) {
        Callback r3 = this.E;
        if (r3 == null) goto L6;
        this.E = null;
        r3.invoke(new Object[]{0, "Due to the start of a new scrollTo operation, the previous scrollTo has stopped."});
    L6:
        if (this.mChildren.isEmpty() == false) goto L9;
        r24.invoke(new Object[]{4, "Invoke scrollTo failed due to empty children."});
        return;
    L9:
        this.F = NameKeys.UnloadStrategy_No_Strategy;
        double r12 = i.a(r23.getDouble("offset", 0.0d));
        boolean r9 = r23.getBoolean("smooth", false);
        if (r23.hasKey("index") == false) goto L17;
        int r1 = r23.getInt("index");
        if (r1 >= 0) goto L14;
    L15:
        r24.invoke(new Object[]{4, "scrollTo index " + r1 + " is out of range [0, " + this.mChildren.size() + "]"});
        return;
    L14:
        if (r1 >= this.mChildren.size()) goto L15;
    L19:
        if (this.a == false) goto L34;
        if (r1 < 0) goto L25;
        if (r1 >= this.mChildren.size()) goto L25;
        r12 = r12 + ((double) ((LynxBaseUI) ListProtector.get(this.mChildren, r1)).getTop());
    L25:
        if (r12 >= 0.0d) goto L27;
    L28:
        this.F = "Target scroll position = " + r12 + " is beyond threshold. ";
        r12 = MathUtils.clamp(r12, 0.0d, u0());
        this.F += "Clamped to position = " + r12;
    L30:
        if (r12 == getScrollY()) goto L32;
        boolean r2 = true;
    L33:
        ((AndroidScrollView) this.mView).i(0, (int) r12, r9);
    L51:
        if (r9 == false) goto L54;
        if (r2 == false) goto L54;
        this.E = r24;
        return;
    L54:
        Object[] r4 = new Object[2];
        if (this.F.isEmpty() == false) goto L57;
        int r8 = 0;
    L58:
        r4[0] = Integer.valueOf(r8);
        r4[1] = this.F;
        r24.invoke(r4);
        this.E = null;
        this.F = NameKeys.UnloadStrategy_No_Strategy;
        return;
    L57:
        r8 = 4;
        goto L58
    L32:
        r2 = false;
        goto L33
    L27:
        if (r12 <= u0()) goto L30;
    L34:
        if (r1 < 0) goto L42;
        if (r1 >= this.mChildren.size()) goto L42;
        if (this.mLynxDirection != 2) goto L40;
        r12 = Math.max(0.0d, ((double) ((((LynxBaseUI) ListProtector.get(this.mChildren, r1)).getLeft() + ((LynxBaseUI) ListProtector.get(this.mChildren, r1)).getWidth()) - getWidth())) - r12);
        goto L42
    L40:
        r12 = r12 + ((double) ((LynxBaseUI) ListProtector.get(this.mChildren, r1)).getLeft());
    L42:
        if (r12 >= 0.0d) goto L44;
    L45:
        this.F = "Target scroll position = " + r12 + " is beyond threshold. ";
        r12 = MathUtils.clamp(r12, 0.0d, u0());
        this.F += "Clamped to position = " + r12;
    L47:
        if (r12 == getScrollX()) goto L49;
        r2 = true;
    L50:
        ((AndroidScrollView) this.mView).i((int) r12, 0, r9);
        goto L51
    L49:
        r2 = false;
        goto L50
    L44:
        if (r12 <= u0()) goto L47;
    L17:
        r1 = -1;
        goto L19
    }

    @LynxUIMethod
    public void takeContentScreenshot(ReadableMap r19, Callback r20) {
        AndroidScrollView r1 = (AndroidScrollView) this.mView;
        if (r1 != null) goto L5;
        LinearLayout r3 = null;
    L7:
        if (r1 != null) goto L9;
        int r7 = 0;
    L10:
        if (r1 != null) goto L12;
        int r8 = 0;
    L13:
        LynxContext r9 = this.mContext;
        a r10 = new a(r1);
        if (r3 != null) goto L17;
        g7a.i.d(r1, r7, r8, r9, r19, r20, r10);
        return;
    L17:
        if (r1 != null) goto L19;
    L61:
        r20.invoke(new Object[]{6, new JavaOnlyMap()});
        return;
    L19:
        if (r1.getWidth() <= 0) goto L61;
        if (r1.getHeight() <= 0) goto L61;
        String r12 = "jpeg";
        if (r19 == null) goto L28;
        r12 = r19.getString("format", "jpeg");
    L28:
        if ("png".equals(r12) == false) goto L30;
        Bitmap.Config r13 = Bitmap.Config.ARGB_8888;
        Bitmap.CompressFormat r14 = Bitmap.CompressFormat.PNG;
        String r15 = "data:image/png;base64,";
    L31:
        if (r19 != null) goto L33;
        float r5 = 1.0f;
    L35:
        if (Float.isNaN(r5) == false) goto L37;
    L60:
        r20.invoke(new Object[]{4, "scale must be greater than 0"});
        return;
    L37:
        if (Float.isInfinite(r5) == true) goto L60;
        if (r5 <= 0.0f) goto L60;
        int r11 = Math.max(Math.max(r1.getWidth(), r3.getWidth()), r7);
        int r16 = Math.max(Math.max(r1.getHeight(), r3.getHeight()), r8);
        int[] r17 = g7a.i.c(r11, r16, r5, r13, r20);
        if (r17 == null) goto L71;
        int r18 = r17[0];
        int r21 = r17[1];
        int r110 = r10.getScrollX();
        int r2 = r10.getScrollY();
        r10.scrollTo(0, 0);     // Catch: Throwable -> L56
        Bitmap r22 = Bitmap.createBitmap(r18, r21, r13);     // Catch: Throwable -> L56
        Canvas r111 = new Canvas(r22);     // Catch: Throwable -> L55
        r111.scale(r5, r5);     // Catch: Throwable -> L55
        Drawable r4 = r1.getBackground();     // Catch: Throwable -> L55
        if (r4 == null) goto L50;
        Rect r6 = new Rect(r4.getBounds());     // Catch: Throwable -> L55
        r4.setBounds(0, 0, r11, r16);     // Catch: Throwable -> L55
        r4.draw(r111);     // Catch: Throwable -> L55
        r4.setBounds(r6);     // Catch: Throwable -> L55
    L50:
        int r23 = r111.save();     // Catch: Throwable -> L55
        r111.translate(-r3.getLeft(), -r3.getTop());     // Catch: Throwable -> L55
        boolean r24 = r3.isDirty();     // Catch: Throwable -> L55
        r3.draw(r111);     // Catch: Throwable -> L55
        if (r24 == false) goto L53;
        r3.postInvalidate();     // Catch: Throwable -> L55
    L53:
        r111.restoreToCount(r23);     // Catch: Throwable -> L55
        r10.scrollTo(r110, r2);
        LynxThreadPool.b().execute(new g7a.h(r22, r14, r15, r20));
        return;
    L55:
        Bitmap r112 = r22;
    L57:
        if (r112 == null) goto L59;
        r112.recycle();
    L59:
        r10.scrollTo(r110, r2);
        r20.invoke(new Object[]{1, new JavaOnlyMap()});
        return;
    L56:
        r112 = null;
        goto L57
    L71:
        return;
    L33:
        r5 = (float) r19.getDouble("scale", 1.0d);
        goto L35
    L30:
        r13 = Bitmap.Config.RGB_565;
        r14 = Bitmap.CompressFormat.JPEG;
        r15 = "data:image/jpeg;base64,";
        goto L31
    L12:
        r8 = r1.getContentHeight();
        goto L13
    L9:
        r7 = r1.getContentWidth();
        goto L10
    L5:
        r3 = r1.getLinearLayout();
        goto L7
    }

    @LynxUIMethod
    public void scrollBy(ReadableMap r4, final Callback r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r4 != null) goto L6;
    L10:
        r5.invoke(new Object[]{4, "Invoke scrollBy failed due to param is null"});
        return;
    L6:
        if (r4.hasKey("offset") == false) goto L10;
        final double r0 = i.a(r4.getDouble("offset", 0.0d));
        UIThreadUtils.runOnUiThreadImmediately(new j(this, r0, r5));
    }

    public static /* synthetic */ void P(UIScrollView r3, float r4, float r5) {
        T r0 = r3.mView;
        if (r0 == 0) goto L13;
        AndroidScrollView r1 = (AndroidScrollView) r0;
        if (r1.u == true) goto L8;
    L10:
        ((AndroidScrollView) r3.mView).scrollBy(0, (int) r5);
        return;
    L8:
        if (r1.getHScrollView() == null) goto L10;
        ((AndroidScrollView) r3.mView).getHScrollView().scrollBy((int) r4, 0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void E0(int r3, boolean r4, boolean r5) {
        int r0 = ((AndroidScrollView) getView()).getRealScrollY();
        if (r4 == false) goto L5;
        r3 = (int) i.b(r3, 0.0f);
    L5:
        if (r5 == false) goto L7;
    L9:
        if (r5 == false) goto L11;
        C0(r3);
        return;
    L11:
        this.p = r3;
        return;
    L7:
        if ((getWidth() + r3) > ((AndroidScrollView) getView()).getContentWidth()) goto L9;
        ((AndroidScrollView) getView()).i(r3, r0, false);
        this.p = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F0(int r3, boolean r4, boolean r5) {
        int r0 = ((AndroidScrollView) getView()).getRealScrollX();
        if (r4 == false) goto L5;
        r3 = (int) i.b(r3, 0.0f);
    L5:
        if (r5 == false) goto L7;
    L9:
        if (r5 == false) goto L11;
        C0(r3);
        return;
    L11:
        this.p = r3;
        return;
    L7:
        if ((getHeight() + r3) > ((AndroidScrollView) getView()).getContentHeight()) goto L9;
        ((AndroidScrollView) getView()).i(r0, r3, false);
        this.p = 0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onListCellDisAppear(String r3, LynxBaseUI r4, boolean r5) {
        super.onListCellDisAppear(r3, r4, r5);
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        String r0 = constructListStateCacheKey(getTagName(), r3, getIdSelector());
        this.G = r4.getSign();
        this.H = r3;
        if (r5 == false) goto L8;
        r4.storeKeyToNativeStorage(r0, Integer.valueOf(((AndroidScrollView) this.mView).getRealScrollX()));
        return;
    L8:
        r4.removeKeyFromNativeStorage(r0);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean requestChildUIRectangleOnScreen(LynxBaseUI r4, Rect r5, boolean r6) {
        if (this.A == false) goto L17;
        if (r4 == null) goto L19;
        r5.offset(r4.getLeft() - r4.getScrollX(), r4.getTop() - r4.getScrollY());
        if (this.a == false) goto L11;
        int r7 = ((AndroidScrollView) this.mView).computeScrollDeltaToGetChildRectOnScreen(r5);
        if (r7 == 0) goto L14;
        T r8 = this.mView;
        ((AndroidScrollView) r8).i(((AndroidScrollView) r8).getRealScrollX(), ((AndroidScrollView) this.mView).getRealScrollY() + r7, r6);
    L14:
        if (r7 == 0) goto L18;
        return true;
    L18:
        return false;
    L11:
        r7 = ((AndroidScrollView) this.mView).getHScrollView().computeScrollDeltaToGetChildRectOnScreen(r5);
        if (r7 == 0) goto L14;
        T r9 = this.mView;
        ((AndroidScrollView) r9).i(((AndroidScrollView) r9).getRealScrollX() + r7, ((AndroidScrollView) this.mView).getRealScrollY(), r6);
        goto L14
    L19:
        return false;
    L17:
        return false;
    }

    public final int G0(int r8, int r9, int r10, int r11) {
        if (this.a == false) goto L7;
        return r0(r9, r10, r11, 1, 2);
    L7:
        if (this.mLynxDirection != 2) goto L11;
        return r0(r8, r11, r10, 2, 1);
    L11:
        return r0(r8, r10, r11, 1, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void M(LynxBaseUI r6, boolean r7, String r8, String r9) {
        if (this.a == false) goto L21;
        if ("nearest".equals(r8) == false) goto L8;
        return;
    L8:
        if ("center".equals(r8) == false) goto L11;
        int r10 = 0 - ((((AndroidScrollView) getView()).getHeight() - r6.getHeight()) / 2);
    L14:
        if (r6 == this) goto L19;
        r10 = r10 + r6.getTop();
        r6 = r6.getParentBaseUI();
    L17:
        if ((r6 instanceof LynxFlattenUI) == false) goto L14;
        r6 = (LynxBaseUI) r6.getParent();
        goto L17
    L19:
        int r11 = Math.max(0, Math.min(r10, ((AndroidScrollView) getView()).getContentHeight() - ((AndroidScrollView) getView()).getHeight()));
        ((AndroidScrollView) this.mView).i(0, r11, r7);
        return;
    L11:
        if ("end".equals(r8) == false) goto L13;
        r10 = (0 - (((AndroidScrollView) getView()).getHeight() - r6.getHeight())) + 0;
        goto L14
    L13:
        r10 = 0;
        goto L14
    L21:
        if ("nearest".equals(r9) == false) goto L24;
        return;
    L24:
        if ("center".equals(r9) == false) goto L27;
        int r12 = (((AndroidScrollView) getView()).getWidth() - r6.getWidth()) / 2;
    L29:
        int r13 = 0 - r12;
    L31:
        if (r6 == this) goto L36;
        r13 = r13 + r6.getLeft();
        r6 = r6.getParentBaseUI();
    L34:
        if ((r6 instanceof LynxFlattenUI) == false) goto L31;
        r6 = (LynxBaseUI) r6.getParent();
        goto L34
    L36:
        int r14 = Math.max(0, Math.min(r13, ((AndroidScrollView) getView()).getContentWidth() - ((AndroidScrollView) getView()).getWidth()));
        ((AndroidScrollView) this.mView).i(r14, 0, r7);
        return;
    L27:
        if ("end".equals(r9) == false) goto L30;
        r12 = ((AndroidScrollView) getView()).getWidth() - r6.getWidth();
        goto L29
    L30:
        r13 = 0;
        goto L31
    }

    public final void B0(int r10, int r11, int r12, int r13, String r14) {
        e r8 = new e(getSign(), r14);
        r8.d(r10, r11, ((AndroidScrollView) this.mView).getContentHeight(), ((AndroidScrollView) this.mView).getContentWidth(), r10 - r12, r11 - r13);
        if (getLynxContext() == null) goto L6;
        getLynxContext().getEventEmitter().sendCustomEvent(r8);
        return;
    }

    public final int r0(int r2, int r3, int r4, int r5, int r6) {
        if (r2 > r3) goto L5;
        int r7 = r5 | 0;
    L7:
        if (((AndroidScrollView) this.mView).getHScrollView() == null) goto L16;
        View r8 = ((AndroidScrollView) this.mView).getHScrollView().getChildAt(0);
        if (this.a == false) goto L11;
        int r9 = r8.getMeasuredHeight();
        int r0 = ((AndroidScrollView) this.mView).getMeasuredHeight();
    L13:
        if (r2 >= ((r9 - r0) - r4)) goto L15;
        return r7;
    L15:
        return r7 | r6;
    L11:
        r9 = r8.getMeasuredWidth();
        r0 = ((AndroidScrollView) this.mView).getMeasuredWidth();
        goto L13
    L16:
        return r7;
    L5:
        r7 = 0;
        goto L7
    }
}
