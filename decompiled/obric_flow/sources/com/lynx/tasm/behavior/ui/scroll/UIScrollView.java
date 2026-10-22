package com.lynx.tasm.behavior.ui.scroll;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.Nullable;
import androidx.core.math.MathUtils;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.lynx.animax.i;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.a0;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.f0;
import com.lynx.tasm.behavior.n0;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.list.container.UIListContainer;
import com.lynx.tasm.behavior.ui.z;
import com.lynx.tasm.p;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.lynx.tasm.utils.g;
import com.lynx.tasm.utils.j;
import com.lynx.tasm.utils.k;
import gn.c;
import gn.d;
import gn.h;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import on.f;

/* JADX INFO: loaded from: classes2.dex */
public class UIScrollView extends AbsLynxUIScroll<AndroidScrollView> implements d, rn.a {
    public static final /* synthetic */ int G = 0;
    public int A;
    public Callback B;
    public String C;
    public int D;
    public String E;
    public final HashMap F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f10636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10638c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10639h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10640i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f10641j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f10642k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f10643l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f10644m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f10645n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f10646o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f10647p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f10648q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f10649r;
    public int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f10650t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public UIBounceView f10651u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public UIBounceView f10652v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f10653w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CustomUIScrollViewAccessibilityDelegate f10654x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f10655y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f10656z;

    public class CustomUIScrollViewAccessibilityDelegate extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UIScrollView f10657a;

        public CustomUIScrollViewAccessibilityDelegate(UIScrollView r5) {
            this.f10657a = r5;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityEvent(View r5, AccessibilityEvent r10) {
            super.onInitializeAccessibilityEvent(r5, r10);
            UIScrollView r11 = this.f10657a;
            int r12 = r11.E();
            if (r11.f10655y == false) goto L6;
            if (r12 <= 0) goto L6;
            boolean r13 = true;
        L7:
            r10.setScrollable(r13);
            r10.setScrollX(((AndroidScrollView) UIScrollView.t(r11)).getRealScrollX());
            r10.setScrollY(((AndroidScrollView) UIScrollView.v(r11)).getRealScrollY());
            if (r11.f10636a == false) goto L11;
            r10.setMaxScrollX(((AndroidScrollView) UIScrollView.x(r11)).getRealScrollX());
            r10.setMaxScrollY(r12);
            return;
        L11:
            r10.setMaxScrollX(r12);
            r10.setMaxScrollY(((AndroidScrollView) UIScrollView.z(r11)).getRealScrollY());
            return;
        L6:
            r13 = false;
            goto L7
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r5, AccessibilityNodeInfoCompat r10) {
            super.onInitializeAccessibilityNodeInfo(r5, r10);
            UIScrollView r11 = this.f10657a;
            int r12 = r11.E();
            if (r11.f10655y == false) goto L6;
            if (r12 <= 0) goto L6;
            boolean r13 = true;
        L7:
            r10.setScrollable(r13);
            if (r13 == true) goto L10;
            return;
        L10:
            if (r11.f10636a == false) goto L20;
            if (((AndroidScrollView) UIScrollView.A(r11)).getRealScrollY() <= 0) goto L16;
            r10.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            return;
        L16:
            if (((AndroidScrollView) UIScrollView.B(r11)).getRealScrollY() >= r12) goto L28;
            r10.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            return;
        L28:
            return;
        L20:
            if (((AndroidScrollView) UIScrollView.C(r11)).getRealScrollX() <= 0) goto L24;
            r10.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            return;
        L24:
            if (((AndroidScrollView) UIScrollView.F(r11)).getRealScrollX() >= r12) goto L29;
            r10.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            return;
        L29:
            return;
        L6:
            r13 = false;
            goto L7
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean performAccessibilityAction(View r10, int r11, Bundle r12) {
            int r13 = UIScrollView.G;
            UIScrollView r5 = this.f10657a;
            int r14 = r5.G();
            int r15 = r5.E();
            if (r5.f10655y == false) goto L28;
            if (r15 <= 0) goto L28;
            int r16 = ((AndroidScrollView) UIScrollView.H(r5)).getRealScrollX();
            int r17 = ((AndroidScrollView) UIScrollView.I(r5)).getRealScrollY();
            if (r11 == 4096) goto L20;
            if (r11 == 8192) goto L11;
            return false;
        L11:
            if (r5.f10636a == false) goto L15;
            int r18 = Math.max(r17 - (r14 / 2), 0);
            if (r18 == r17) goto L18;
            ((AndroidScrollView) UIScrollView.O(r5)).d(0, r18, true);
        L18:
            return true;
        L15:
            int r19 = Math.max(r16 - (r14 / 2), 0);
            if (r19 == r16) goto L18;
            ((AndroidScrollView) UIScrollView.P(r5)).d(r19, 0, true);
            goto L18
        L20:
            if (r5.f10636a == false) goto L24;
            int r20 = Math.min((r14 / 2) + r17, r15);
            if (r20 == r17) goto L27;
            ((AndroidScrollView) UIScrollView.K(r5)).d(0, r20, true);
        L27:
            return true;
        L24:
            int r21 = Math.min((r14 / 2) + r16, r15);
            if (r21 == r16) goto L27;
            ((AndroidScrollView) UIScrollView.M(r5)).d(r21, 0, true);
        L28:
            return false;
        }
    }

    public UIScrollView(b0 r5, z r10) {
        super(r5, r10);
        this.f10638c = false;
        this.e = false;
        this.f = false;
        this.f10643l = false;
        this.f10644m = false;
        this.f10645n = 0;
        this.f10646o = 0;
        this.f10647p = 0;
        this.f10648q = 0;
        this.f10649r = 1;
        this.s = -1;
        this.f10650t = -1;
        this.f10653w = false;
        this.f10654x = null;
        this.f10655y = true;
        this.f10656z = false;
        this.A = 0;
        this.F = new HashMap();
    }

    public static /* synthetic */ View A(UIScrollView r5) {
        return r5.mView;
    }

    public static /* synthetic */ View B(UIScrollView r5) {
        return r5.mView;
    }

    public static /* synthetic */ View C(UIScrollView r5) {
        return r5.mView;
    }

    public static /* synthetic */ View F(UIScrollView r5) {
        return r5.mView;
    }

    public static /* synthetic */ View H(UIScrollView r5) {
        return r5.mView;
    }

    public static /* synthetic */ View I(UIScrollView r5) {
        return r5.mView;
    }

    public static /* synthetic */ View K(UIScrollView r5) {
        return r5.mView;
    }

    public static /* synthetic */ View M(UIScrollView r5) {
        return r5.mView;
    }

    public static /* synthetic */ View O(UIScrollView r5) {
        return r5.mView;
    }

    public static /* synthetic */ View P(UIScrollView r5) {
        return r5.mView;
    }

    public static /* synthetic */ View k(UIScrollView r5) {
        return r5.mView;
    }

    public static /* synthetic */ View q(UIScrollView r5) {
        return r5.mView;
    }

    public static /* synthetic */ View t(UIScrollView r5) {
        return r5.mView;
    }

    public static /* synthetic */ View v(UIScrollView r5) {
        return r5.mView;
    }

    public static /* synthetic */ View x(UIScrollView r5) {
        return r5.mView;
    }

    public static /* synthetic */ View z(UIScrollView r5) {
        return r5.mView;
    }

    public final LynxBaseUI D() {
        LynxBaseUI r5 = ((n0) getLynxContext().f10147o.get()).a(this.D);
        if ((r5 instanceof UIList) == false) goto L5;
        return r5;
    L5:
        if ((r5 instanceof UIListContainer) == true) goto L10;
        return null;
    L10:
        return r5;
    }

    public final int E() {
        if (this.f10636a == false) goto L5;
        int r5 = ((AndroidScrollView) this.mView).getContentHeight();
    L7:
        return r5 - G();
    L5:
        r5 = ((AndroidScrollView) this.mView).getContentWidth();
        goto L7
    }

    public final int G() {
        if (this.f10636a == false) goto L7;
        int r5 = getHeight() - ((AndroidScrollView) this.mView).getPaddingBottom();
        int r10 = ((AndroidScrollView) this.mView).getPaddingTop();
    L6:
        return r5 - r10;
    L7:
        r5 = getWidth() - ((AndroidScrollView) this.mView).getPaddingLeft();
        r10 = ((AndroidScrollView) this.mView).getPaddingRight();
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void J() {
        if (this.f10646o <= 0) goto L24;
        if (this.mFirstRender == true) goto L11;
        if (D() == null) goto L11;
        if (D().initialPropsFlushed("initialScrollOffset", constructListStateCacheKey(getTagName(), this.E, getIdSelector())) == true) goto L24;
    L11:
        if (D() == null) goto L14;
        D().setInitialPropsHasFlushed("initialScrollOffset", constructListStateCacheKey(getTagName(), this.E, getIdSelector()));
    L14:
        if (this.f10636a == false) goto L19;
        int r5 = this.f10646o;
        if ((getHeight() + r5) > ((AndroidScrollView) getView()).getContentHeight()) goto L19;
        int r10 = ((AndroidScrollView) getView()).getRealScrollX();
        ((AndroidScrollView) getView()).d(r10, this.f10646o, false);
        w(0);
    L19:
        if (this.f10636a == true) goto L24;
        int r11 = this.f10646o;
        if ((getWidth() + r11) > ((AndroidScrollView) getView()).getContentWidth()) goto L24;
        int r12 = ((AndroidScrollView) getView()).getRealScrollY();
        ((AndroidScrollView) getView()).d(this.f10646o, r12, false);
        w(0);
    L24:
        if (this.f10650t != (-1)) goto L26;
        return;
    L26:
        if (this.mFirstRender == true) goto L32;
        if (D() == null) goto L32;
        if (D().initialPropsFlushed("initialScrollIndex", constructListStateCacheKey(getTagName(), this.E, getIdSelector())) == false) goto L32;
    L35:
        this.f10650t = -1;
        return;
    L32:
        if (D() == null) goto L34;
        D().setInitialPropsHasFlushed("initialScrollIndex", constructListStateCacheKey(getTagName(), this.E, getIdSelector()));
    L34:
        ((AndroidScrollView) this.mView).setScrollToIndex(this.f10650t);
        goto L35
    }

    public final void L() {
        int r5 = ((AndroidScrollView) this.mView).getHScrollView().getScrollX();
        int r10 = ((AndroidScrollView) this.mView).getScrollY();
        int r11 = 0;
    L4:
        if (r11 >= this.mChildren.size()) goto L6;
        this.mChildren.get(r11).checkStickyOnParentScroll(r5, r10);
        r11 = r11 + 1;
        goto L4
    }

    public final void N() {
        if (this.f10653w == true) goto L42;
        UIBounceView r5 = this.f10651u;
        if (r5 == null) goto L43;
        int r10 = -1;
        if (this.f10636a == false) goto L26;
        if (r5.f10635a != 3) goto L13;
        int r11 = r5.getTop();
        int r12 = ((AndroidScrollView) this.mView).getScrollY();
        if (r11 >= (getHeight() + r12)) goto L13;
        r10 = this.f10651u.getTop() - getHeight();
    L18:
        if (r10 <= 0) goto L44;
        T r13 = this.mView;
        if (r13 == 0) goto L23;
        ((AndroidScrollView) r13).fling((int) 0.0d);
    L23:
        ((AndroidScrollView) this.mView).d(0, r10, true);
        return;
    L44:
        return;
    L13:
        UIBounceView r14 = this.f10651u;
        if (r14.f10635a != 2) goto L18;
        if (r14.getHeight() <= ((AndroidScrollView) this.mView).getScrollY()) goto L18;
        r10 = this.f10651u.getHeight();
        goto L18
    L26:
        if (r5.f10635a != 0) goto L30;
        int r15 = r5.getLeft();
        int r16 = ((AndroidScrollView) this.mView).getHScrollView().getScrollX();
        if (r15 >= (getWidth() + r16)) goto L30;
        r10 = this.f10651u.getLeft() - getWidth();
    L35:
        if (r10 <= 0) goto L45;
        T r17 = this.mView;
        if (r17 == 0) goto L40;
        ((AndroidScrollView) r17).getHScrollView().fling((int) 0.0d);
    L40:
        ((AndroidScrollView) this.mView).d(r10, 0, true);
        return;
    L45:
        return;
    L30:
        UIBounceView r18 = this.f10651u;
        if (r18.f10635a != 1) goto L35;
        if (r18.getWidth() <= ((AndroidScrollView) this.mView).getHScrollView().getScrollX()) goto L35;
        r10 = this.f10651u.getWidth();
        goto L35
    L43:
        return;
    }

    @f0
    public void autoScroll(ReadableMap r10) {
        AndroidScrollView r11 = (AndroidScrollView) this.mView;
        r11.getClass();
        double r5 = r10.getDouble("rate", 0.0d);
        if (r10.getBoolean("start", true) == false) goto L12;
        int r12 = (int) g.a((float) (r5 / 60.0d), 0.0f);
        if (r5 != 0.0d) goto L9;
        LynxLog.b(4, "LynxUIScrollView", "the rate of speed  is not right, current value is 0");
        return;
    L9:
        if (r11.C == true) goto L14;
        r11.C = true;
        r11.E = r12;
        r11.post(new a0(r11));
        return;
    L14:
        return;
    L12:
        r11.C = false;
        r11.E = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void b(LynxBaseUI r10, boolean r11, String r12, String r13) {
        if (this.f10636a == false) goto L23;
        if ("nearest".equals(r12) == false) goto L8;
        return;
    L8:
        if ("center".equals(r12) == false) goto L12;
        int r14 = (((AndroidScrollView) getView()).getHeight() - r10.getHeight()) / 2;
    L10:
        int r15 = 0 - r14;
    L15:
        if (r10 == this) goto L20;
        r15 = r15 + r10.getTop();
        r10 = r10.getParentBaseUI();
    L18:
        if ((r10 instanceof LynxFlattenUI) == false) goto L15;
        r10 = (LynxBaseUI) r10.getParent();
        goto L18
    L20:
        ((AndroidScrollView) this.mView).d(0, Math.max(0, Math.min(r15, ((AndroidScrollView) getView()).getContentHeight() - ((AndroidScrollView) getView()).getHeight())), r11);
        return;
    L12:
        if ("end".equals(r12) == false) goto L14;
        r14 = ((AndroidScrollView) getView()).getHeight() - r10.getHeight();
        goto L10
    L14:
        r15 = 0;
        goto L15
    L23:
        if ("nearest".equals(r13) == false) goto L26;
        return;
    L26:
        if ("center".equals(r13) == false) goto L30;
        int r16 = (((AndroidScrollView) getView()).getWidth() - r10.getWidth()) / 2;
    L28:
        int r17 = 0 - r16;
    L33:
        if (r10 == this) goto L38;
        r17 = r17 + r10.getLeft();
        r10 = r10.getParentBaseUI();
    L36:
        if ((r10 instanceof LynxFlattenUI) == false) goto L33;
        r10 = (LynxBaseUI) r10.getParent();
        goto L36
    L38:
        ((AndroidScrollView) this.mView).d(Math.max(0, Math.min(r17, ((AndroidScrollView) getView()).getContentWidth() - ((AndroidScrollView) getView()).getWidth())), 0, r11);
        return;
    L30:
        if ("end".equals(r13) == false) goto L32;
        r16 = ((AndroidScrollView) getView()).getWidth() - r10.getWidth();
        goto L28
    L32:
        r17 = 0;
        goto L33
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void c(boolean r5) {
        this.f10636a = !r5;
        if (r5 == true) goto L6;
        ((AndroidScrollView) this.mView).setOrientation(1);
        return;
    L6:
        ((AndroidScrollView) this.mView).setOrientation(0);
    }

    @Override // rn.a
    public final boolean canConsumeGesture(float r5, float r10) {
        if (isEnableNewGesture() == false) goto L31;
        T r11 = this.mView;
        if (r11 == 0) goto L31;
        if (((AndroidScrollView) r11).s == false) goto L21;
        if (isAtBorder(true) == false) goto L14;
        if (r5 >= 0.0f) goto L14;
    L18:
        return false;
    L14:
        if (isAtBorder(false) == true) goto L16;
    L19:
        return true;
    L16:
        if (r5 > 0.0f) goto L18;
    L21:
        if (isAtBorder(true) == false) goto L25;
        if (r10 >= 0.0f) goto L25;
    L29:
        return false;
    L25:
        if (isAtBorder(false) == true) goto L27;
    L30:
        return true;
    L27:
        if (r10 > 0.0f) goto L29;
    L31:
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void consumeGesture(boolean r5) {
        AndroidScrollView r10 = (AndroidScrollView) this.mView;
        r10.f10596k = Boolean.valueOf(r5);
        if (r5 == false) goto L6;
        r10.f10595j = false;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        AndroidScrollView r10 = new AndroidScrollView(r5, this);
        r10.setOnScrollListener(new h(this, r10));
        return r10;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        this.B = null;
        ArrayList r5 = ((AndroidScrollView) this.mView).f10607w;
        if (r5 == null) goto L6;
        r5.clear();
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

    @Override // rn.a
    public final int getMemberScrollX() {
        return ((AndroidScrollView) this.mView).getHScrollView().getScrollX();
    }

    @Override // rn.a
    public final int getMemberScrollY() {
        return ((AndroidScrollView) this.mView).getScrollY();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final View getRealParentView() {
        AndroidScrollView r5 = (AndroidScrollView) getView();
        if (this.f10636a == true) goto L7;
        if (r5 == null) goto L7;
        return r5.getHScrollView();
    L7:
        return r5;
    }

    @Override // rn.a
    public final int getScrollContainerDirection() {
        if (((AndroidScrollView) this.mView).s == false) goto L6;
        return -1;
    L6:
        return 1;
    }

    @f0
    public void getScrollInfo(Callback r5) {
        int r10 = getMemberScrollX();
        int r11 = ((AndroidScrollView) this.mView).getScrollY();
        JavaOnlyMap r12 = new JavaOnlyMap();
        r12.putInt("scrollX", i.a.b(this.mContext, r10));
        r12.putInt("scrollY", i.a.b(this.mContext, r11));
        r12.putInt("scrollRange", i.a.b(this.mContext, E()));
        r5.invoke(new Object[]{0, r12});
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getScrollX() {
        return ((AndroidScrollView) this.mView).getHScrollView().getScrollX();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getScrollY() {
        return ((AndroidScrollView) this.mView).getScrollY();
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void i(boolean r5) {
        this.f10636a = r5;
        if (r5 == false) goto L6;
        ((AndroidScrollView) this.mView).setOrientation(1);
        return;
    L6:
        ((AndroidScrollView) this.mView).setOrientation(0);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r5, int r10) {
        super.insertChild(r5, r10);
        if ((r5 instanceof UIBounceView) == false) goto L15;
        UIBounceView r11 = (UIBounceView) r5;
        if (this.f10653w == false) goto L13;
        int r12 = r11.f10635a;
        if (r12 != 1) goto L9;
    L11:
        this.f10652v = r11;
        return;
    L9:
        if (r12 == 2) goto L11;
        return;
    L13:
        this.f10651u = r11;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void interceptGesture(boolean r5) {
        AndroidScrollView r10 = (AndroidScrollView) this.mView;
        r10.f10597l = Boolean.valueOf(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.ui.a0
    public final void invalidate() {
        ((AndroidScrollView) this.mView).getLinearLayout().invalidate();
        ((AndroidScrollView) this.mView).invalidate();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isAccessibilityDirectionVertical() {
        return this.f10636a;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isAccessibilityHostUI() {
        return true;
    }

    @Override // rn.a
    public final boolean isAtBorder(boolean r5) {
        if (isEnableNewGesture() == false) goto L19;
        T r10 = this.mView;
        if (r10 == 0) goto L19;
        if (r5 == false) goto L16;
        if (((AndroidScrollView) r10).s == false) goto L14;
        boolean r11 = s(2);
    L13:
        return !r11;
    L14:
        r11 = s(0);
        goto L13
    L16:
        if (((AndroidScrollView) r10).s == false) goto L18;
        r11 = s(3);
        goto L13
    L18:
        r11 = s(1);
    L19:
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isScrollContainer() {
        return true;
    }

    public final int j(int r5, int r10, int r11, int r12, int r13) {
        if (r5 <= r10) goto L7;
        r12 = 0;
    L7:
        if (((AndroidScrollView) this.mView).getHScrollView() == null) goto L16;
        View r14 = ((AndroidScrollView) this.mView).getHScrollView().getChildAt(0);
        if (this.f10636a == false) goto L12;
        int r15 = r14.getMeasuredHeight();
        int r16 = ((AndroidScrollView) this.mView).getMeasuredHeight();
    L13:
        if (r5 < ((r15 - r16) - r11)) goto L16;
        return r12 | r13;
    L12:
        r15 = r14.getMeasuredWidth();
        r16 = ((AndroidScrollView) this.mView).getMeasuredWidth();
    L16:
        return r12;
    }

    public final /* synthetic */ void l(float r5, float r10) {
        T r11 = this.mView;
        if (r11 != 0) goto L5;
        return;
    L5:
        AndroidScrollView r12 = (AndroidScrollView) r11;
        if (r12.s == true) goto L8;
    L11:
        ((AndroidScrollView) this.mView).scrollBy(0, (int) r10);
        return;
    L8:
        if (r12.getHScrollView() == null) goto L11;
        ((AndroidScrollView) this.mView).getHScrollView().scrollBy((int) r5, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void layout() {
        if (getOverflow() == 0) goto L10;
        ((AndroidScrollView) this.mView).setClipChildren(false);
        if (((AndroidScrollView) this.mView).getHScrollView() == null) goto L8;
        ((AndroidScrollView) this.mView).getHScrollView().setClipChildren(false);
    L8:
        if (((AndroidScrollView) this.mView).getLinearLayout() == null) goto L10;
        ((AndroidScrollView) this.mView).getLinearLayout().setClipToPadding(false);
    L10:
        boolean r5 = this.f10653w;
        if (r5 == true) goto L13;
    L26:
        if (r5 == true) goto L28;
    L41:
        super.layout();
        int r10 = this.f10645n;
        if (r10 > 0) goto L44;
        return;
    L44:
        if (this.f10636a == false) goto L50;
        if ((getHeight() + r10) > ((AndroidScrollView) getView()).getContentHeight()) goto L50;
        ((AndroidScrollView) getView()).d(((AndroidScrollView) getView()).getRealScrollX(), this.f10645n, false);
        this.f10645n = 0;
        return;
    L50:
        if (this.f10636a == false) goto L52;
        return;
    L52:
        if ((getWidth() + this.f10645n) > ((AndroidScrollView) getView()).getContentWidth()) goto L57;
        ((AndroidScrollView) getView()).d(this.f10645n, ((AndroidScrollView) getView()).getRealScrollY(), false);
        this.f10645n = 0;
        return;
    L57:
        return;
    L28:
        if (this.f10636a == false) goto L41;
        UIBounceView r11 = this.f10652v;
        if (r11 == null) goto L32;
        int r12 = r11.getHeight();
    L33:
        AndroidScrollView r13 = (AndroidScrollView) this.mView;
        int r14 = E();
        c r15 = r13.f10634i;
        if (r15 == null) goto L41;
        if (r14 == r15.e) goto L38;
    L39:
        r13.requestLayout();
    L40:
        c r16 = r13.f10634i;
        r16.e = r14;
        r16.f = r12;
        goto L41
    L38:
        if (r12 == r15.f) goto L40;
    L32:
        r12 = 0;
        goto L33
    L13:
        if (this.f10636a == true) goto L26;
        UIBounceView r17 = this.f10652v;
        if (r17 == null) goto L17;
        int r18 = r17.getWidth();
    L18:
        AndroidScrollView.CustomHorizontalScrollView r19 = ((AndroidScrollView) this.mView).getHScrollView();
        int r20 = E();
        c r21 = r19.f10629r;
        if (r21 == null) goto L41;
        if (r20 == r21.e) goto L23;
    L24:
        r19.requestLayout();
    L25:
        c r22 = r19.f10629r;
        r22.e = r20;
        r22.f = r18;
        goto L41
    L23:
        if (r18 == r21.f) goto L25;
    L17:
        r18 = 0;
        goto L18
    }

    public final void m(int r5, boolean r10) {
        T r11 = this.mView;
        if (r11 != 0) goto L5;
        return;
    L5:
        if (((AndroidScrollView) r11).getLinearLayout() != null) goto L7;
        return;
    L7:
        if (r10 == false) goto L9;
        this.f10650t = -1;
    L11:
        if (r5 >= 0) goto L15;
        LynxLog.b(4, "LynxUIScrollView", "Invalid scroll-to-index with index < 0: " + r5);
        return;
    L15:
        if (this.mChildren.size() != 0) goto L22;
        if (r10 == false) goto L19;
        y(r5);
        return;
    L19:
        this.s = r5;
        return;
    L22:
        if (r5 < this.mChildren.size()) goto L25;
        LynxLog.b(4, "LynxUIScrollView", "Invalid scroll-to-index with index out of boundary: " + r5);
        return;
    L25:
        LinearLayout r12 = ((AndroidScrollView) this.mView).getLinearLayout();
        if (this.f10636a == false) goto L28;
        int r13 = ((AndroidScrollView) this.mView).getHeight();
    L30:
        if (this.f10636a == false) goto L32;
        int r14 = r12.getHeight();
    L33:
        if (r13 == 0) goto L39;
        if (r14 == 0) goto L39;
        if (r10 == true) goto L39;
        ((AndroidScrollView) this.mView).setScrollToIndex(r5);
        return;
    L39:
        if (r10 == false) goto L42;
        y(r5);
        return;
    L42:
        this.s = r5;
        return;
    L32:
        r14 = r12.getWidth();
        goto L33
    L28:
        r13 = ((AndroidScrollView) this.mView).getWidth();
        goto L30
    L9:
        this.s = -1;
        goto L11
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void measure() {
        int r5 = 0;
        if (((AndroidScrollView) this.mView).getOrientation() != 0) goto L5;
        boolean r10 = true;
    L6:
        int r11 = getWidth();
        int r12 = getHeight();
    L8:
        if (r5 >= getChildCount()) goto L15;
        LynxBaseUI r13 = getChildAt(r5);
        if (r10 == false) goto L12;
        r11 = Math.max(r11, (r13.getMarginRight() + (r13.getLeft() + r13.getWidth())) + this.mPaddingRight);
    L13:
        r5 = r5 + 1;
        goto L8
    L12:
        r12 = Math.max(r12, (r13.getMarginBottom() + (r13.getTop() + r13.getHeight())) + this.mPaddingBottom);
        goto L13
    L15:
        if (((AndroidScrollView) this.mView).getContentWidth() == r11) goto L17;
    L18:
        float r14 = r11;
        float r15 = r12;
        if (this.f10642k == false) goto L23;
        i r16 = new i(getSign(), "contentsizechanged");
        r16.a("scrollWidth", Float.valueOf(r14 / DisplayMetricsHolder.a().density));
        r16.a("scrollHeight", Float.valueOf(r15 / DisplayMetricsHolder.a().density));
        if (getLynxContext() == null) goto L23;
        getLynxContext().g.b(r16);
    L23:
        AndroidScrollView r17 = (AndroidScrollView) this.mView;
        r17.f10606v = r12;
        r17.f10605u = r11;
        fn.a r18 = r17.f10599n;
        if (r18 == null) goto L26;
        r18.requestLayout();
    L26:
        AndroidScrollView r19 = (AndroidScrollView) this.mView;
        r19.h(r19.getScrollX(), ((AndroidScrollView) this.mView).getScrollY());
    L27:
        super.measure();
        return;
    L17:
        if (((AndroidScrollView) this.mView).getContentHeight() == r12) goto L27;
    L5:
        r10 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n(int r5, boolean r10, boolean r11) {
        int r12 = ((AndroidScrollView) getView()).getRealScrollY();
        if (r10 == false) goto L5;
        r5 = (int) g.a(r5, 0.0f);
    L5:
        if (r11 == false) goto L7;
    L10:
        if (r11 == false) goto L13;
        w(r5);
        return;
    L13:
        this.f10645n = r5;
        return;
    L7:
        if ((getWidth() + r5) > ((AndroidScrollView) getView()).getContentWidth()) goto L10;
        ((AndroidScrollView) getView()).d(r5, r12, false);
        this.f10645n = 0;
    }

    public final void o(String r10, int r11, int r12, int r13, int r14) {
        f r15 = new f(getSign(), r10);
        r15.d(r11, r12, ((AndroidScrollView) this.mView).getContentHeight(), ((AndroidScrollView) this.mView).getContentWidth(), r11 - r13, r12 - r14);
        if (getLynxContext() == null) goto L6;
        getLynxContext().g.b(r15);
        return;
    }

    @Override // rn.a
    public final void onGestureScrollBy(float r5, float r10) {
        if (isEnableNewGesture() == true) goto L5;
        return;
    L5:
        j.f(new en.i(this, r5, r10, 2));
    }

    @Override // rn.a
    public final void onInvalidate() {
        if (this.mView != 0) goto L5;
        return;
    L5:
        if (isEnableNewGesture() == false) goto L9;
        ViewCompat.postInvalidateOnAnimation(this.mView);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        int r5 = this.mPaddingLeft + this.mBorderLeftWidth;
        int r10 = this.mPaddingRight + this.mBorderRightWidth;
        int r11 = this.mPaddingTop + this.mBorderTopWidth;
        int r12 = this.mPaddingBottom + this.mBorderBottomWidth;
        ((AndroidScrollView) this.mView).f10599n.setPadding(r5, r11, r10, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onListCellAppear(String r5, LynxBaseUI r10) {
        super.onListCellAppear(r5, r10);
        if (TextUtils.isEmpty(r5) == true) goto L26;
        this.E = r5;
        this.D = r10.getSign();
        String r11 = constructListStateCacheKey(getTagName(), r5, getIdSelector());
        Object r12 = r10.getValueFromNativeStorage(r11);
        if (r12 == null) goto L13;
        int r13 = ((Integer) r12).intValue();
        if (((AndroidScrollView) getView()).s == false) goto L11;
        n(r13, false, false);
        return;
    L11:
        r(r13, false, false);
        return;
    L13:
        HashMap r14 = this.F;
        if (r14.containsKey("initialScrollIndex") == false) goto L19;
        if (r10.initialPropsFlushed("initialScrollIndex", r11) == true) goto L19;
        y(((Integer) r14.get("initialScrollIndex")).intValue());
    L19:
        if (r14.containsKey("initialScrollOffset") == true) goto L21;
        return;
    L21:
        if (r10.initialPropsFlushed("initialScrollOffset", r11) == true) goto L25;
        w(((Integer) r14.get("initialScrollOffset")).intValue());
        return;
    L25:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onListCellDisAppear(String r5, LynxBaseUI r10, boolean r11) {
        super.onListCellDisAppear(r5, r10, r11);
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        String r12 = constructListStateCacheKey(getTagName(), r5, getIdSelector());
        this.D = r10.getSign();
        this.E = r5;
        if (r11 == false) goto L9;
        r10.storeKeyToNativeStorage(r12, Integer.valueOf(((AndroidScrollView) this.mView).getRealScrollX()));
        return;
    L9:
        r10.removeKeyFromNativeStorage(r12);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onListCellPrepareForReuse(String r5, LynxBaseUI r10) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        this.D = r10.getSign();
        this.E = r5;
        if (this.f10636a == false) goto L10;
        ((AndroidScrollView) this.mView).d(0, 0, false);
        return;
    L10:
        if (this.mLynxDirection != 2) goto L13;
        AndroidScrollView r11 = (AndroidScrollView) this.mView;
        r11.d(r11.getContentWidth() - ((AndroidScrollView) this.mView).getWidth(), 0, false);
        return;
    L13:
        ((AndroidScrollView) this.mView).d(0, 0, false);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReady() {
        onAnimationNodeReady();
        afterAnimationNodeReady();
        int r5 = this.A;
        if (r5 <= 0) goto L6;
        ((AndroidScrollView) this.mView).setFadingEdgeLength(r5);
        ((AndroidScrollView) this.mView).setHorizontalFadingEdgeEnabled(!this.f10636a);
        ((AndroidScrollView) this.mView).setVerticalFadingEdgeEnabled(this.f10636a);
    L6:
        if (this.f10656z == true) goto L8;
    L25:
        this.mFirstRender = false;
        return;
    L8:
        if (this.f10636a == true) goto L17;
        AndroidScrollView.CustomHorizontalScrollView r10 = ((AndroidScrollView) this.mView).getHScrollView();
        r10.getClass();
        ViewConfiguration r11 = ViewConfiguration.get(r10.getContext());     // Catch: IllegalAccessException -> L15 NoSuchFieldException -> L16
        Field r12 = HorizontalScrollView.class.getDeclaredField("mTouchSlop");     // Catch: IllegalAccessException -> L15 NoSuchFieldException -> L16
        if (r11 == null) goto L25;
        if (r12 == null) goto L25;
        int r13 = r11.getScaledPagingTouchSlop();     // Catch: IllegalAccessException -> L15 NoSuchFieldException -> L16
        r12.setAccessible(true);     // Catch: IllegalAccessException -> L15 NoSuchFieldException -> L16
        r12.set(r10, Integer.valueOf(r13));     // Catch: IllegalAccessException -> L15 NoSuchFieldException -> L16
        r10.f = r13;     // Catch: IllegalAccessException -> L15 NoSuchFieldException -> L16
    L15:
        LynxLog.b(4, "LynxNestedHorizontalScrollView", "Failed to get mTouchSlop field of HorizontalScrollView!");
    L16:
        LynxLog.b(4, "LynxNestedHorizontalScrollView", "Failed to get mTouchSlop field of HorizontalScrollView!");
        goto L25
    L17:
        AndroidScrollView r14 = (AndroidScrollView) this.mView;
        r14.getClass();
        ViewConfiguration r15 = ViewConfiguration.get(r14.getContext());     // Catch: IllegalAccessException -> L23 NoSuchFieldException -> L24
        Field r16 = ScrollView.class.getDeclaredField("mTouchSlop");     // Catch: IllegalAccessException -> L23 NoSuchFieldException -> L24
        if (r15 == null) goto L25;
        if (r16 == null) goto L25;
        int r17 = r15.getScaledPagingTouchSlop();     // Catch: IllegalAccessException -> L23 NoSuchFieldException -> L24
        r16.setAccessible(true);     // Catch: IllegalAccessException -> L23 NoSuchFieldException -> L24
        r16.set(r14, Integer.valueOf(r17));     // Catch: IllegalAccessException -> L23 NoSuchFieldException -> L24
    L23:
        LynxLog.b(4, "LynxNestedScrollView", "Failed to get mTouchSlop field of NestedScrollView!");
    L24:
        LynxLog.b(4, "LynxNestedScrollView", "Failed to get mTouchSlop field of NestedScrollView!");
        goto L25
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReload() {
        super.onNodeReload();
        if (this.mLynxDirection != 2) goto L6;
        ((AndroidScrollView) getView()).d(E(), 0, false);
        return;
    L6:
        ((AndroidScrollView) getView()).d(0, 0, false);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onPropsUpdated() {
        super.onPropsUpdated();
        if (this.f10636a == false) goto L5;
        ((AndroidScrollView) this.mView).setEnableNewBounce(this.f10653w);
    L6:
        com.lynx.tasm.behavior.ui.accessibility.d r5 = this.mContext.j();
        if (r5 != null) goto L9;
        return;
    L9:
        if (r5.f() == true) goto L13;
        if (r5.g() == true) goto L13;
        return;
    L13:
        if (this.f10654x != null) goto L16;
        this.f10654x = new CustomUIScrollViewAccessibilityDelegate(this);
    L16:
        if (this.f10636a == false) goto L18;
        ViewCompat.setAccessibilityDelegate(this.mView, this.f10654x);
        ViewCompat.setAccessibilityDelegate(((AndroidScrollView) this.mView).getHScrollView(), null);
    L20:
        if (r5.g() == false) goto L32;
        T r10 = this.mView;
        int r11 = 1;
        if (this.f10636a == false) goto L24;
        int r12 = 1;
    L25:
        ViewCompat.setImportantForAccessibility(r10, r12);
        AndroidScrollView.CustomHorizontalScrollView r13 = ((AndroidScrollView) this.mView).getHScrollView();
        if (this.f10636a == false) goto L28;
        r11 = 2;
    L28:
        ViewCompat.setImportantForAccessibility(r13, r11);
        ViewCompat.setImportantForAccessibility(((AndroidScrollView) this.mView).getLinearLayout(), 2);
        return;
    L24:
        r12 = 2;
        goto L25
    L32:
        return;
    L18:
        ViewCompat.setAccessibilityDelegate(this.mView, null);
        ViewCompat.setAccessibilityDelegate(((AndroidScrollView) this.mView).getHScrollView(), this.f10654x);
        goto L20
    L5:
        ((AndroidScrollView) this.mView).getHScrollView().setEnableNewBounce(this.f10653w);
        goto L6
    }

    public final int p(int r10, int r11, int r12, int r13) {
        if (this.f10636a == false) goto L7;
        return j(r11, r12, r13, 1, 2);
    L7:
        if (this.mLynxDirection != 2) goto L11;
        return j(r10, r13, r12, 2, 1);
    L11:
        return j(r10, r12, r13, 1, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r(int r5, boolean r10, boolean r11) {
        int r12 = ((AndroidScrollView) getView()).getRealScrollX();
        if (r10 == false) goto L5;
        r5 = (int) g.a(r5, 0.0f);
    L5:
        if (r11 == false) goto L7;
    L10:
        if (r11 == false) goto L13;
        w(r5);
        return;
    L13:
        this.f10645n = r5;
        return;
    L7:
        if ((getHeight() + r5) > ((AndroidScrollView) getView()).getContentHeight()) goto L10;
        ((AndroidScrollView) getView()).d(r12, r5, false);
        this.f10645n = 0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean requestChildUIRectangleOnScreen(LynxBaseUI r5, Rect r10, boolean r11) {
        if (this.f10655y == false) goto L17;
        if (r5 == null) goto L17;
        r10.offset(r5.getLeft() - r5.getScrollX(), r5.getTop() - r5.getScrollY());
        if (this.f10636a == false) goto L11;
        int r12 = ((AndroidScrollView) this.mView).computeScrollDeltaToGetChildRectOnScreen(r10);
        if (r12 == 0) goto L14;
        AndroidScrollView r13 = (AndroidScrollView) this.mView;
        r13.d(r13.getRealScrollX(), ((AndroidScrollView) this.mView).getRealScrollY() + r12, r11);
    L14:
        if (r12 == 0) goto L17;
        return true;
    L11:
        r12 = ((AndroidScrollView) this.mView).getHScrollView().computeScrollDeltaToGetChildRectOnScreen(r10);
        if (r12 == 0) goto L14;
        AndroidScrollView r14 = (AndroidScrollView) this.mView;
        r14.d(r14.getRealScrollX() + r12, ((AndroidScrollView) this.mView).getRealScrollY(), r11);
    L17:
        return false;
    }

    public final boolean s(int r5) {
        T r10 = this.mView;
        if (r10 != 0) goto L6;
        return false;
    L6:
        if (r5 == 0) goto L21;
        if (r5 == 1) goto L19;
        if (r5 == 2) goto L17;
        if (r5 == 3) goto L15;
        return false;
    L15:
        return ((AndroidScrollView) r10).getHScrollView().canScrollHorizontally(1);
    L17:
        return ((AndroidScrollView) r10).getHScrollView().canScrollHorizontally(-1);
    L19:
        return ((AndroidScrollView) r10).canScrollVertically(1);
    L21:
        return ((AndroidScrollView) r10).canScrollVertically(-1);
    }

    @f0
    public void scrollBy(ReadableMap r10, Callback r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r10 != null) goto L6;
    L10:
        r11.invoke(new Object[]{4, "Invoke scrollBy failed due to param is null"});
        return;
    L6:
        if (r10.hasKey("offset") == false) goto L10;
        j.f(new com.bytedance.ies.xelement.viewpager.foldview.d(this, g.a((float) r10.getDouble("offset", 0.0d), 0.0f), r11, 3));
    }

    @f0
    public void scrollTo(ReadableMap r23, Callback r24) {
        Callback r5 = this.B;
        if (r5 == null) goto L6;
        this.B = null;
        r5.invoke(new Object[]{0, "Due to the start of a new scrollTo operation, the previous scrollTo has stopped."});
    L6:
        if (this.mChildren.isEmpty() == false) goto L9;
        r24.invoke(new Object[]{4, "Invoke scrollTo failed due to empty children."});
        return;
    L9:
        this.C = "";
        double r10 = g.a((float) r23.getDouble("offset", 0.0d), 0.0f);
        boolean r11 = r23.getBoolean("smooth", false);
        if (r23.hasKey("index") == false) goto L17;
        int r12 = r23.getInt("index");
        if (r12 >= 0) goto L14;
    L15:
        StringBuilder r13 = p.d(r12, "scrollTo index ", " is out of range [0, ");
        r13.append(this.mChildren.size());
        r13.append("]");
        r24.invoke(new Object[]{4, r13.toString()});
        return;
    L14:
        if (r12 >= this.mChildren.size()) goto L15;
    L18:
        boolean r14 = true;
        if (this.f10636a == false) goto L34;
        if (r12 < 0) goto L25;
        if (r12 >= this.mChildren.size()) goto L25;
        r10 = r10 + ((double) this.mChildren.get(r12).getTop());
    L25:
        if (r10 >= 0.0d) goto L27;
    L28:
        this.C = "Target scroll position = " + r10 + " is beyond threshold. ";
        r10 = MathUtils.clamp(r10, 0.0d, E());
        this.C += "Clamped to position = " + r10;
    L30:
        if (r10 != ((AndroidScrollView) this.mView).getScrollY()) goto L33;
        r14 = false;
    L33:
        int r15 = 0;
        ((AndroidScrollView) this.mView).d(0, (int) r10, r11);
    L51:
        if (r11 == false) goto L56;
        if (r14 == false) goto L56;
        this.B = r24;
        return;
    L56:
        if (this.C.isEmpty() == true) goto L59;
        r15 = 4;
    L59:
        r24.invoke(new Object[]{Integer.valueOf(r15), this.C});
        this.B = null;
        this.C = "";
        return;
    L27:
        if (r10 <= E()) goto L30;
    L34:
        if (r12 < 0) goto L42;
        if (r12 >= this.mChildren.size()) goto L42;
        if (this.mLynxDirection != 2) goto L40;
        r10 = Math.max(0.0d, ((double) ((this.mChildren.get(r12).getWidth() + this.mChildren.get(r12).getLeft()) - getWidth())) - r10);
        goto L42
    L40:
        r10 = r10 + ((double) this.mChildren.get(r12).getLeft());
    L42:
        if (r10 >= 0.0d) goto L44;
    L45:
        this.C = "Target scroll position = " + r10 + " is beyond threshold. ";
        r10 = MathUtils.clamp(r10, 0.0d, E());
        this.C += "Clamped to position = " + r10;
    L47:
        if (r10 != ((AndroidScrollView) this.mView).getHScrollView().getScrollX()) goto L50;
        r14 = false;
    L50:
        r15 = 0;
        ((AndroidScrollView) this.mView).d((int) r10, 0, r11);
        goto L51
    L44:
        if (r10 <= E()) goto L47;
    L17:
        r12 = -1;
        goto L18
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void scrollToIndex(int r5) {
        m(r5, false);
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setBlockDescendantFocusability(boolean r5) {
        T r10 = this.mView;
        if (r10 == 0) goto L6;
        ((AndroidScrollView) r10).setBlockDescendantFocusability(r5);
        return;
    }

    @c0(defaultBoolean = false, name = "enable-nested-scroll")
    public void setEnableNestedScroll(boolean r5) {
        T r10 = this.mView;
        if (r10 == 0) goto L10;
        ((AndroidScrollView) r10).setNestedScrollingEnabled(r5);
        if (((AndroidScrollView) this.mView).getHScrollView() == null) goto L9;
        ((AndroidScrollView) this.mView).getHScrollView().setNestedScrollingEnabled(r5);
        return;
    L9:
        return;
    }

    @c0(defaultBoolean = false, name = "android-enable-new-bounce")
    public void setEnableNewBounce(boolean r5) {
        this.f10653w = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setEnableNewNested(boolean r5) {
        T r10 = this.mView;
        if (r10 == 0) goto L10;
        ((AndroidScrollView) r10).setEnableNewNested(r5);
        if (((AndroidScrollView) this.mView).getHScrollView() == null) goto L9;
        ((AndroidScrollView) this.mView).getHScrollView().setEnableNewNested(r5);
        return;
    L9:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setEnableScroll(boolean r5) {
        T r10 = this.mView;
        if (r10 == 0) goto L5;
        ((AndroidScrollView) r10).setEnableScroll(r5);
    L5:
        this.f10655y = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map r5) {
        super.setEvents(r5);
        if (r5 == null) goto L34;
        this.f10637b = false;
        this.d = false;
        this.g = false;
        this.f10640i = false;
        if (r5.containsKey("scrolltolower") == false) goto L9;
        this.d = true;
    L9:
        if (r5.containsKey("scrolltoloweredge") == false) goto L12;
        this.e = true;
    L12:
        if (r5.containsKey("scrolltoupper") == false) goto L15;
        this.f10637b = true;
    L15:
        if (r5.containsKey("scrolltoupperedge") == false) goto L18;
        this.f10638c = true;
    L18:
        if (r5.containsKey("scrolltonormalstate") == false) goto L21;
        this.f = true;
    L21:
        if (r5.containsKey("scroll") == false) goto L24;
        this.g = true;
    L24:
        if (r5.containsKey("scrollstart") == false) goto L27;
        this.f10639h = true;
    L27:
        if (r5.containsKey("scrollend") == false) goto L30;
        this.f10640i = true;
    L30:
        if (r5.containsKey("contentsizechanged") == false) goto L33;
        this.f10642k = true;
        return;
    L33:
        return;
    }

    @c0(name = "fading-edge-length")
    public void setFadingEdgeLength(String r5) {
        int r10 = (int) k.d(r5, 0.0f, 0.0f, this.mContext.f10152u);
        this.A = r10;
        if (r10 > 0) goto L8;
        T r11 = this.mView;
        if (r11 == 0) goto L9;
        ((AndroidScrollView) r11).setHorizontalFadingEdgeEnabled(false);
        ((AndroidScrollView) this.mView).setVerticalFadingEdgeEnabled(false);
        return;
    L9:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setForbidFlingFocusChange(boolean r5) {
        T r10 = this.mView;
        if (r10 == 0) goto L6;
        ((AndroidScrollView) r10).setForbidFlingFocusChange(r5);
        return;
    }

    @c0(defaultBoolean = false, name = "force-can-scroll")
    public void setForceCanScroll(boolean r5) {
        T r10 = this.mView;
        if (r10 == 0) goto L6;
        ((AndroidScrollView) r10).setForceCanScroll(r5);
        return;
    }

    @c0(name = "initial-scroll-offset")
    public void setInitialScrollOffset(@Nullable Integer r5) {
        HashMap r10 = this.F;
        if (r5 != null) goto L6;
        r10.remove("initialScrollOffset");
        return;
    L6:
        r10.put("initialScrollOffset", Integer.valueOf((int) g.a(r5.intValue(), 0.0f)));
        if (this.f10636a == false) goto L10;
        r(r5.intValue(), true, true);
        return;
    L10:
        n(r5.intValue(), true, true);
    }

    @c0(name = "initial-scroll-to-index")
    public void setInitialScrollToIndex(@Nullable Integer r5) {
        HashMap r10 = this.F;
        if (r5 != null) goto L6;
        r10.remove("initialScrollIndex");
        return;
    L6:
        r10.put("initialScrollIndex", r5);
        m(r5.intValue(), true);
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setLowerThreshole(int r5) {
        this.f10647p = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setLynxDirection(int r10) {
        T r5 = this.mView;
        AndroidScrollView r11 = (AndroidScrollView) r5;
        if (r10 == this.mLynxDirection) goto L5;
        boolean r12 = true;
    L6:
        r11.G = r12;
        this.mLynxDirection = r10;
        if (r10 != 2) goto L10;
        ViewCompat.setLayoutDirection(r5, 1);
        ViewCompat.setLayoutDirection(((AndroidScrollView) this.mView).getHScrollView(), 1);
        ViewCompat.setLayoutDirection(((AndroidScrollView) this.mView).getLinearLayout(), 1);
        return;
    L10:
        ViewCompat.setLayoutDirection(r5, 0);
        ViewCompat.setLayoutDirection(((AndroidScrollView) this.mView).getHScrollView(), 0);
        ViewCompat.setLayoutDirection(((AndroidScrollView) this.mView).getLinearLayout(), 0);
        return;
    L5:
        r12 = false;
        goto L6
    }

    @c0(defaultBoolean = false, name = "android-preference-consume-gesture")
    public void setPreferenceConsumeGesture(boolean r5) {
        this.f10644m = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollBarEnable(boolean r5) {
        ((AndroidScrollView) this.mView).setScrollBarEnable(r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        LynxLog.b(4, "UIScrollView", e.getMessage());
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollLeft(int r5) {
        n(r5, true, false);
    }

    @c0(customType = "vertical", name = "scroll-orientation")
    public void setScrollOrientation(String r5) {
        if (TextUtils.equals(r5, "vertical") == false) goto L6;
        this.f10636a = true;
    L10:
        if (this.f10636a == false) goto L13;
        ((AndroidScrollView) this.mView).setOrientation(1);
        return;
    L13:
        ((AndroidScrollView) this.mView).setOrientation(0);
        return;
    L6:
        if (TextUtils.equals(r5, "horizontal") == false) goto L8;
        this.f10636a = false;
        goto L10
    L8:
        this.f10636a = true;
        goto L10
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollTap(boolean r5) {
        this.f10641j = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollTop(int r5) {
        r(r5, true, false);
    }

    @c0(name = "android-touch-slop")
    public void setTouchSlop(String r5) {
        this.f10656z = TextUtils.equals(r5, "paging");
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setUpperThreshole(int r5) {
        this.f10648q = r5;
    }

    public final void u(int r5) {
        if (this.f10641j == true) goto L10;
        if (r5 != 0) goto L6;
        return;
    L6:
        if (r5 == 3) goto L17;
        recognizeGesturere();
        return;
    L17:
        return;
    L10:
        if (r5 != 1) goto L12;
    L15:
        recognizeGesturere();
        return;
    L12:
        if (r5 == 4) goto L15;
    }

    public final void w(int r10) {
        if (r10 != 0) goto L7;
        this.f10646o = 0;
        return;
    L7:
        if (D() != null) goto L9;
        this.f10646o = r10;
        return;
    L9:
        if (D().initialPropsFlushed("initialScrollOffset", constructListStateCacheKey(getTagName(), this.E, getIdSelector())) == false) goto L11;
        r10 = 0;
    L11:
        this.f10646o = r10;
    }

    public final void y(int r10) {
        if (r10 != (-1)) goto L7;
        this.f10650t = -1;
        return;
    L7:
        if (D() != null) goto L9;
        this.f10650t = r10;
        return;
    L9:
        if (D().initialPropsFlushed("initialScrollIndex", constructListStateCacheKey(getTagName(), this.E, getIdSelector())) == false) goto L11;
        r10 = -1;
    L11:
        this.f10650t = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final float[] scrollBy(float r10, float r11) {
        float[] r5 = new float[4];
        T r12 = this.mView;
        if (r12 != 0) goto L5;
        return r5;
    L5:
        int r13 = ((AndroidScrollView) r12).getHScrollView().getScrollX();
        int r14 = ((AndroidScrollView) this.mView).getScrollY();
        AndroidScrollView r15 = (AndroidScrollView) this.mView;
        if (r15.s == false) goto L8;
        r15.getHScrollView().scrollBy((int) r10, 0);
    L10:
        if (Math.abs(r10) <= Float.MIN_VALUE) goto L12;
    L13:
        recognizeGesturere();
    L15:
        if (((AndroidScrollView) getView()).s == false) goto L18;
        float r16 = ((AndroidScrollView) this.mView).getHScrollView().getScrollX() - r13;
        r5[0] = r16;
        r5[1] = 0.0f;
        r5[2] = r10 - r16;
        r5[3] = r11;
        return r5;
    L18:
        r5[0] = 0.0f;
        float r17 = ((AndroidScrollView) this.mView).getScrollY() - r14;
        r5[1] = r17;
        r5[2] = r10;
        r5[3] = r11 - r17;
        return r5;
    L12:
        if (Math.abs(r11) <= Float.MIN_VALUE) goto L15;
    L8:
        r15.scrollBy(0, (int) r11);
        goto L10
    }
}
