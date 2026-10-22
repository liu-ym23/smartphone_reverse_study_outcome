package com.lynx.tasm.behavior.ui.swiper;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.utils.ColorUtils;
import com.lynx.tasm.utils.i;
import com.lynx.tasm.utils.n;
import com.lynx.xelement.viewpager.viewpager.BaseLynxViewPager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@LynxBehavior(isCreateAsync = true, tagName = {"swiper"})
@LynxGeneratorName(packageName = "com.lynx.tasm.behavior.ui.swiper")
public class XSwiperUI extends UISimpleView<SwiperView> {
    public static final int G = 0;
    public static final int H = 0;
    public final com.lynx.tasm.behavior.ui.swiper.b A;
    public final com.lynx.tasm.behavior.ui.swiper.a B;
    public final Handler C;
    public final List<View> D;
    public final a E;
    public b F;
    public String a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public int r;
    public int s;
    public long t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public static class a implements Runnable {
        public final WeakReference<XSwiperUI> a;

        /* JADX WARN: Multi-variable type inference failed */
        public final void a() {
            XSwiperUI r0 = this.a.get();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.u == true) goto L7;
            return;
        L7:
            if (r0.n == false) goto L20;
            ViewPager r1 = ((SwiperView) r0.getView()).a;
            boolean r3 = true;
            int r2 = r1.getCurrentIndex() + 1;
            if (r2 == r1.getTotalCount()) goto L11;
        L15:
            r3 = false;
        L16:
            r0.Z(r1, r2, r0.p, r3);
            r0.C.postDelayed(this, r0.q);
            return;
        L11:
            if (r0.v == false) goto L13;
        L14:
            r2 = 0;
            goto L16
        L13:
            if (r0.o == false) goto L15;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(XSwiperUI r2) {
            this.a = new WeakReference(r2);
        }
    }

    public class b extends AccessibilityDelegateCompat {
        public final /* synthetic */ XSwiperUI a;

        public final boolean canScroll() {
            XSwiperUI r0 = this.a;
            if (r0.z == true) goto L5;
        L11:
            return false;
        L5:
            if (((SwiperView) XSwiperUI.T(r0)).a == null) goto L11;
            List<View> r1 = this.a.D;
            if (r1 == null) goto L11;
            if (((ArrayList) r1).size() <= 1) goto L11;
            return true;
        }

        public b(XSwiperUI r1) {
            this.a = r1;
        }

        public final boolean a(ViewPager r2, int r3) {
            if (this.a.m == false) goto L7;
            if (r2.canScrollVertically(r3) == false) goto L7;
        L10:
            return true;
        L7:
            if (this.a.m == false) goto L9;
        L11:
            return false;
        L9:
            if (r2.canScrollHorizontally(r3) == false) goto L11;
            goto L10
        }

        public final void onInitializeAccessibilityEvent(View r2, AccessibilityEvent r3) {
            super.onInitializeAccessibilityEvent(r2, r3);
            if (((SwiperView) XSwiperUI.O(this.a)).a == null) goto L10;
            r3.setClassName(ViewPager.class.getName());
            boolean r4 = canScroll();
            r3.setScrollable(r4);
            if (r4 == true) goto L7;
            return;
        L7:
            if (r3.getEventType() != 4096) goto L12;
            r3.setItemCount(((ArrayList) this.a.D).size());
            return;
        L12:
            return;
        }

        public final void onInitializeAccessibilityNodeInfo(View r6, AccessibilityNodeInfoCompat r7) {
            super.onInitializeAccessibilityNodeInfo(r6, r7);
            r7.setClassName(ViewPager.class.getName());
            boolean r8 = canScroll();
            r7.setScrollable(r8);
            if (((SwiperView) XSwiperUI.R(this.a)).a == null) goto L12;
            List<View> r0 = this.a.D;
            if (r0 == null) goto L12;
            if (((ArrayList) r0).isEmpty() == true) goto L12;
            XSwiperUI r1 = this.a;
            if (r1.m == false) goto L12;
            int r2 = ((ArrayList) r1.D).size();
        L14:
            if (((SwiperView) XSwiperUI.S(this.a)).a == null) goto L24;
            List<View> r3 = this.a.D;
            if (r3 == null) goto L24;
            if (((ArrayList) r3).isEmpty() == true) goto L24;
            XSwiperUI r4 = this.a;
            if (r4.m == true) goto L24;
            int r5 = ((ArrayList) r4.D).size();
        L25:
            r7.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(r2, r5, false, 0));
            ViewPager r9 = ((SwiperView) XSwiperUI.P(this.a)).a;
            if (r8 == false) goto L43;
            if (r9 != null) goto L29;
            return;
        L29:
            if (this.a.m == false) goto L37;
            if (r9.canScrollVertically(1) == false) goto L34;
            r7.addAction(4096);
        L34:
            if (r9.canScrollVertically(-1) == false) goto L45;
            r7.addAction(8192);
            return;
        L45:
            return;
        L37:
            if (r9.canScrollHorizontally(1) == false) goto L40;
            r7.addAction(4096);
        L40:
            if (r9.canScrollHorizontally(-1) == false) goto L47;
            r7.addAction(8192);
            return;
        L47:
            return;
        L43:
            return;
        L24:
            r5 = 1;
        L12:
            r2 = 1;
            goto L14
        }

        public final boolean performAccessibilityAction(View r5, int r6, Bundle r7) {
            if (super.performAccessibilityAction(r5, r6, r7) == false) goto L5;
            return true;
        L5:
            ViewPager r8 = ((SwiperView) XSwiperUI.Q(this.a)).a;
            if (r8 != null) goto L8;
        L23:
            return false;
        L8:
            if (r8.getCurrentIndex() == (-1)) goto L23;
            int r1 = r8.getCurrentIndex();
            if (r6 == 4096) goto L20;
            if (r6 != 8192) goto L23;
            if (a(r8, -1) == false) goto L18;
            this.a.setCurrentIndex(r1 - 1);
            return true;
        L18:
            return false;
        L20:
            if (a(r8, 1) == false) goto L23;
            this.a.setCurrentIndex(r1 + 1);
            return true;
        }
    }

    public XSwiperUI() {
        throw null;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final boolean enableAutoClipRadius() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isAccessibilityHostUI() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isScrollContainer() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final boolean isScrollable() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean needCustomLayout() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onListCellPrepareForReuse(String r1, LynxBaseUI r2) {
    }

    static {
        G = Color.argb(255, 255, 255, 255);
        H = Color.argb(89, 255, 255, 255);
    }

    public final void W() {
        com.lynx.tasm.behavior.ui.accessibility.d r0 = this.mContext.getLynxAccessibilityWrapper();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.e() == true) goto L9;
        if (r0.f() == true) goto L9;
        return;
    L9:
        if (this.F != null) goto L11;
        this.F = new b(this);
    L11:
        ViewPager r1 = ((SwiperView) this.mView).a;
        if (r1 == null) goto L17;
        ViewCompat.setAccessibilityDelegate(r1, this.F);
        ViewCompat.setImportantForAccessibility(r1, 1);
        ViewCompat.setImportantForAccessibility(this.mView, 2);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final View getAccessibilityHostView() {
        return ((SwiperView) this.mView).a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void X() {
        ((SwiperView) getView()).a.setAdapter(new e(this));
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        int r0 = getWidth();
        int r1 = getHeight();
        super.onLayoutUpdated();
        int r2 = this.mPaddingTop + this.mBorderTopWidth;
        int r3 = this.mPaddingBottom + this.mBorderBottomWidth;
        ((SwiperView) this.mView).setPadding(this.mPaddingLeft + this.mBorderLeftWidth, r2, this.mPaddingRight + this.mBorderRightWidth, r3);
        ((ArrayList) this.D).clear();
        Iterator<LynxBaseUI> r4 = this.mChildren.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        LynxBaseUI r5 = r4.next();
        ((ArrayList) this.D).add(((LynxUI) r5).getView());
        goto L4
    L6:
        X();
        ((SwiperView) this.mView).c(isRtl());
        if (getOverflow() == 0) goto L9;
        ((SwiperView) this.mView).setClipChildren(false);
    L9:
        boolean r6 = true;
        if (this.h == r0) goto L12;
        boolean r7 = true;
    L14:
        if (this.i != r1) goto L17;
        r6 = false;
    L17:
        V(r7, r6, false);
        if (this.h == r0) goto L20;
    L21:
        float r8 = r0;
        float r9 = r1;
        if (this.g == true) goto L24;
    L28:
        this.h = r0;
        this.i = r1;
        return;
    L24:
        if (this.mContext.getScreenMetrics() == null) goto L28;
        m7a.a r10 = new m7a.a(getSign(), "contentsizechanged");
        r10.a("contentWidth", Float.valueOf(i.c(r8)));
        r10.a("contentHeight", Float.valueOf(i.c(r9)));
        if (getLynxContext() == null) goto L28;
        getLynxContext().getEventEmitter().sendCustomEvent(r10);
        goto L28
    L20:
        if (this.i != r1) goto L21;
        return;
    L12:
        r7 = false;
        goto L14
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReload() {
        super.onNodeReload();
        Y(0, false);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onPropsUpdated() {
        super.onPropsUpdated();
        if (this.w == false) goto L5;
        V(false, false, true);
        this.w = false;
    L5:
        W();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isAccessibilityDirectionVertical() {
        return this.m;
    }

    public static /* synthetic */ View M(XSwiperUI r0) {
        return r0.mView;
    }

    public static /* synthetic */ View N(XSwiperUI r0) {
        return r0.mView;
    }

    public static /* synthetic */ View O(XSwiperUI r0) {
        return r0.mView;
    }

    public static /* synthetic */ View P(XSwiperUI r0) {
        return r0.mView;
    }

    public static /* synthetic */ View Q(XSwiperUI r0) {
        return r0.mView;
    }

    public static /* synthetic */ View R(XSwiperUI r0) {
        return r0.mView;
    }

    public static /* synthetic */ View S(XSwiperUI r0) {
        return r0.mView;
    }

    public static /* synthetic */ View T(XSwiperUI r0) {
        return r0.mView;
    }

    public static /* synthetic */ View U(XSwiperUI r0) {
        return r0.mView;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r3) {
        SwiperView r0 = new SwiperView(r3, null);
        ViewPager r4 = r0.a;
        c r1 = new c(this, r0);
        ((ArrayList) r4.U).add(r1);
        r0.addOnAttachStateChangeListener(new d(this));
        LLog.i("LynxSwiperUI", "create Android NewSwiperView");
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void removeChild(LynxBaseUI r3) {
        if ((r3 instanceof LynxUI) == false) goto L9;
        this.mChildren.remove(r3);
        List<View> r0 = this.D;
        ArrayList r1 = (ArrayList) r0;
        r1.remove(((LynxUI) r3).getView());
        X();
        SwiperView r4 = (SwiperView) getView();
        if (r4.b.getChildCount() <= 0) goto L7;
        r4.b.removeViewAt(0);
        r4.f = r4.f;
        r4.e();
    L7:
        V(false, false, true);
        return;
    }

    @LynxProp(defaultBoolean = false, name = "autoplay")
    public void setAutoPlay(boolean r4) {
        this.n = r4;
        this.C.removeCallbacks(this.E);
        if (this.n == false) goto L6;
        this.C.postDelayed(this.E, this.q);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultFloat = 0.3f, name = "bounce-begin-threshold")
    public void setBounceBeginThreshold(float r2) {
        ((SwiperView) getView()).a.setBounceBeginThreshold(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultInt = 500, name = "bounce-duration")
    public void setBounceDuration(int r2) {
        ((SwiperView) getView()).a.setBounceDuration(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultFloat = 0.3f, name = "bounce-end-threshold")
    public void setBounceEndThreshold(float r2) {
        ((SwiperView) getView()).a.setBounceEndThreshold(r2);
    }

    @LynxProp(defaultBoolean = false, name = "circular")
    public void setCircular(boolean r2) {
        this.o = r2;
        ((SwiperView) this.mView).a.setLoop(r2);
    }

    @LynxProp(defaultBoolean = true, name = "compatible")
    public void setCompatible(boolean r1) {
        this.x = r1;
        this.w = true;
    }

    @LynxProp(defaultInt = 0, name = "current")
    public void setCurrentIndex(int r2) {
        Y(r2, this.p);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultInt = 500, name = "duration")
    public void setDuration(int r2) {
        this.r = r2;
        if (this.p == false) goto L5;
        ((SwiperView) getView()).a.setAnimDuration(r2);
        return;
    L5:
        ((SwiperView) getView()).a.setAnimDuration(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = false, name = "enable-bounce")
    public void setEnableBounce(boolean r2) {
        ((SwiperView) getView()).a.setEnableBounce(r2);
    }

    @LynxProp(defaultBoolean = false, name = "enable-nested-child")
    public void setEnableNestedChild(boolean r2) {
        ViewPager r0 = ((SwiperView) this.mView).a;
        if (r0 == null) goto L6;
        r0.setEnableNestedChild(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = true, name = "enable-vice-loop")
    public void setEnableViceLoop(boolean r2) {
        ((SwiperView) getView()).a.setEnableViceLoop(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map<String, EventsListener> r2) {
        super.setEvents(r2);
        if (r2 == null) goto L6;
        this.b = r2.containsKey(BaseLynxViewPager.BIND_ON_CHANGED);
        this.c = r2.containsKey("scrollstart");
        this.d = r2.containsKey("scrollend");
        this.e = r2.containsKey("transition");
        this.f = r2.containsKey("scrolltobounce");
        this.g = r2.containsKey("contentsizechanged");
        return;
    }

    @LynxProp(defaultBoolean = false, name = "finish-reset")
    public void setFinishReset(boolean r1) {
        this.v = r1;
    }

    @LynxProp(defaultBoolean = false, name = "force-can-scroll")
    public void setForceCanScroll(boolean r2) {
        ((SwiperView) this.mView).a.setForceCanScroll(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = true, name = "handle-gesture")
    public void setHandleGesture(boolean r2) {
        ((SwiperView) getView()).a.setHandleGesture(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = false, name = "ignore-layout-update")
    public void setIgnoreLayoutUpdate(boolean r2) {
        ((SwiperView) getView()).a.setIgnoreLayoutUpdate(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = false, name = "indicator-dots")
    public void setIndicator(boolean r2) {
        LinearLayout r0 = ((SwiperView) getView()).b;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "indicator-active-color")
    public void setIndicatorActiveColor(String r4) {
        int r5 = ColorUtils.b(r4);     // Catch: Exception -> L4
    L5:
        SwiperView r0 = (SwiperView) getView();
        r0.d = r5;
        int r6 = r0.b.getChildCount() - 1;
    L6:
        if (r6 <= (-1)) goto L16;
        if (r6 == r0.f) goto L9;
        r6 = r6 - 1;
        goto L6
    L9:
        r0.b.getChildAt(r6).setBackground(r0.b(r0.d));
        return;
    L16:
        return;
    L4:
        r5 = G;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "indicator-color")
    public void setIndicatorColor(String r5) {
        int r6 = ColorUtils.b(r5);     // Catch: Exception -> L4
    L5:
        SwiperView r0 = (SwiperView) getView();
        r0.e = r6;
        int r7 = r0.b.getChildCount() - 1;
    L6:
        if (r7 <= (-1)) goto L12;
        if (r7 == r0.f) goto L11;
        r0.b.getChildAt(r7).setBackground(r0.b(r0.e));
    L11:
        r7 = r7 - 1;
        goto L6
    L12:
        return;
    L4:
        r6 = H;
        goto L5
    }

    @LynxProp(defaultInt = 5000, name = "interval")
    public void setInterval(int r1) {
        this.q = r1;
    }

    @LynxProp(defaultBoolean = false, name = "keep-item-view")
    public void setKeepItemView(boolean r2) {
        ((SwiperView) this.mView).a.setKeepItemView(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setLynxDirection(int r3) {
        super.setLynxDirection(r3);
        if (r3 == 2) goto L7;
        if (r3 == 2) goto L7;
        ((SwiperView) getView()).c(false);
    L8:
        this.w = true;
        return;
    L7:
        ((SwiperView) getView()).c(true);
        goto L8
    }

    @LynxProp(name = "max-x-scale")
    public void setMaxXScale(double r2) {
        float r3 = (float) r2;
        this.B.c = r3;
    }

    @LynxProp(name = "max-y-scale")
    public void setMaxYScale(double r2) {
        float r3 = (float) r2;
        this.B.e = r3;
    }

    @LynxProp(name = "min-x-scale")
    public void setMinXScale(double r2) {
        float r3 = (float) r2;
        this.B.b = r3;
    }

    @LynxProp(name = "min-y-scale")
    public void setMinYScale(double r2) {
        float r3 = (float) r2;
        this.B.d = r3;
    }

    @LynxProp(name = "mode")
    public void setMode(String r1) {
        this.a = r1;
        this.w = true;
    }

    @LynxProp(name = "next-margin")
    public void setNextMargin(f6a.a r10) {
        if (r10.getType() == ReadableType.String) goto L5;
        return;
    L5:
        String r2 = r10.asString();
        if (r2.endsWith("px") == false) goto L8;
    L9:
        int r11 = (int) n.b(r2, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, getLynxContext().getScreenMetrics());
        if (r11 >= 0) goto L13;
        r11 = -1;
    L13:
        this.k = r11;
        this.w = true;
        return;
    L8:
        if (r2.endsWith("rpx") == true) goto L9;
    }

    @LynxProp(defaultFloat = 0.0f, name = "norm-translation-factor")
    public void setNormalTranslationFactor(double r4) {
        if (r4 <= 1.0d) goto L5;
        return;
    L5:
        if (r4 < (-1.0d)) goto L9;
        float r5 = (float) r4;
        this.B.a = r5;
        this.w = true;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "orientation")
    public void setOrientation(String r3) {
        if ("vertical".equals(r3) == false) goto L6;
        this.m = true;
        ((SwiperView) getView()).d(1);
    L8:
        this.w = true;
        return;
    L6:
        if ("horizontal".equals(r3) == false) goto L8;
        this.m = false;
        ((SwiperView) getView()).d(0);
        goto L8
    }

    @LynxProp(name = "page-margin")
    public void setPageMargin(f6a.a r10) {
        if (r10.getType() != ReadableType.String) goto L14;
        String r2 = r10.asString();
        if (r2.endsWith("px") == false) goto L7;
    L8:
        int r11 = (int) n.b(r2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, getLynxContext().getScreenMetrics());
        if (r11 > 0) goto L12;
        r11 = 0;
    L12:
        this.j = r11;
        this.w = true;
        return;
    L7:
        if (r2.endsWith("rpx") == true) goto L8;
        return;
    }

    @LynxProp(name = "previous-margin")
    public void setPreviousMargin(f6a.a r10) {
        if (r10.getType() == ReadableType.String) goto L5;
        return;
    L5:
        String r2 = r10.asString();
        if (r2.endsWith("px") == false) goto L8;
    L9:
        int r11 = (int) n.b(r2, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, getLynxContext().getScreenMetrics());
        if (r11 >= 0) goto L13;
        r11 = -1;
    L13:
        this.l = r11;
        this.w = true;
        return;
    L8:
        if (r2.endsWith("rpx") == true) goto L9;
    }

    @LynxProp(defaultBoolean = false, name = "scroll-before-detached")
    public void setScrollBeforeDetached(boolean r1) {
        this.y = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = true, name = "smooth-scroll")
    public void setSmoothScroll(boolean r2) {
        this.p = r2;
        if (r2 == false) goto L5;
        ((SwiperView) getView()).a.setAnimDuration(this.r);
        return;
    L5:
        ((SwiperView) getView()).a.setAnimDuration(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = false, name = "touchable")
    public void setTouchable(boolean r2) {
        this.z = r2;
        ((SwiperView) getView()).a.setTouchable(r2);
    }

    @LynxProp(defaultInt = 0, name = "transition-throttle")
    public void setTransitionThrottle(int r1) {
        this.s = r1;
    }

    @LynxProp(defaultBoolean = false, name = "vertical")
    public void setVertical(boolean r4) {
        if (r4 == false) goto L5;
        ((SwiperView) this.mView).d(1);
    L6:
        this.m = r4;
        this.w = true;
        return;
    L5:
        ((SwiperView) this.mView).d(0);
        goto L6
    }

    public XSwiperUI(LynxContext r3, Object r4) {
        super(r3, r4);
        this.a = "normal";
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = true;
        this.q = 5000;
        this.r = 500;
        this.s = 0;
        this.t = 0;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = true;
        this.y = false;
        this.z = true;
        this.A = new com.lynx.tasm.behavior.ui.swiper.b();
        this.B = new com.lynx.tasm.behavior.ui.swiper.a();
        this.C = new Handler(Looper.getMainLooper());
        this.D = new ArrayList();
        this.E = new a(this);
        this.F = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y(int r4, boolean r5) {
        ViewPager r0 = ((SwiperView) getView()).a;
        if (r0.getChildCount() <= 0) goto L5;
        r0.h = r4;
        r0.a = r5;
        Z(r0, r4, r5, false);
        return;
    L5:
        r0.h = r4;
        r0.a = false;
    }

    public final boolean a0(ViewPager r5, int r6) {
        int r0 = this.l;
        int r1 = this.k;
        int r7 = (r6 - r0) - r1;
        int r2 = this.j;
        int r3 = (r7 - r2) - r2;
        if (this.x == false) goto L6;
        r7 = r3;
    L6:
        if (r0 < 0) goto L20;
        if (r1 < 0) goto L22;
        if (r7 <= 0) goto L23;
        r5.setPageSize(r7);
        int r8 = this.l;
        int r4 = this.j + r8;
        if (this.x == false) goto L14;
        r8 = r4;
    L14:
        if (isRtl() == true) goto L16;
    L18:
        r5.u(r8, false);
    L19:
        return false;
    L16:
        if (this.m == true) goto L18;
        r5.u(-r8, false);
        goto L19
    L23:
        return true;
    L22:
        return true;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r2, int r3) {
        if ((r2 instanceof LynxUI) == false) goto L6;
        ListProtector.add(this.mChildren, r3, r2);
        r2.setParent(this);
        ListProtector.add(this.D, r3, ((LynxUI) r2).getView());
        X();
        ((SwiperView) getView()).a();
        V(false, false, true);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final void onListCellAppear(String r3, UIList r4) {
        super.onListCellPrepareForReuse(r3, r4);
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        String r5 = constructListStateCacheKey(getTagName(), r3, getIdSelector());
        if (((HashMap) r4.y).containsKey(r5) == false) goto L8;
        int r6 = ((Integer) ((HashMap) r4.y).get(r5)).intValue();
    L9:
        Y(r6, false);
        return;
    L8:
        r6 = -1;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxUIMethod
    public void scrollTo(ReadableMap r10, Callback r11) {
        ViewPager r0 = ((SwiperView) getView()).a;
        if (r0 != null) goto L5;
    L23:
        r11.invoke(new Object[]{1, "Check failed when invoking scrollTo method: viewPager == null || adapter == null"});
        return;
    L5:
        if (r0.getAdapter() == null) goto L23;
        int r5 = r10.getInt("index", -1);
        boolean r6 = r10.getBoolean("smooth", this.p);
        int r12 = !r10.getString("direction", "end").equals("begin") ? 1 : 0;
        if (r0.getChildCount() != 0) goto L11;
        r11.invoke(new Object[]{1, "Check failed when invoking scrollTo method: no swiper item added to viewpager"});
        return;
    L11:
        if (r5 >= 0) goto L13;
    L21:
        r11.invoke(new Object[]{4, "Check failed when invoking scrollTo method: index < 0 or index >= data count"});
        return;
    L13:
        if (r5 >= r0.getTotalCount()) goto L21;
        int r1 = r0.getTotalCount();
        if (r5 < 0) goto L19;
        if (r5 >= r1) goto L19;
        r0.t(r5, r6, r12);
    L19:
        r11.invoke(new Object[]{0});
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V(boolean r6, boolean r7, boolean r8) {
        ViewPager r0 = ((SwiperView) getView()).a;
        if (this.m == false) goto L5;
        int r1 = ((getHeight() - getPaddingTop()) - getPaddingBottom()) - getBorderTopWidth();
        int r2 = getBorderBottomWidth();
    L6:
        int r3 = r1 - r2;
        if (r3 != 0) goto L9;
        return;
    L9:
        r0.setHLayoutUpdated(r6);
        r0.setVLayoutUpdated(r7);
        r0.setPropsUpdated(r8);
        r0.setPageMargin(this.j);
        String r9 = this.a;
        r9.getClass();
        byte r4 = -1;
        switch(r9.hashCode()) {
            case -1039745817: goto L29;
            case 2908512: goto L25;
            case 94431515: goto L21;
            case 1720139793: goto L17;
            case 1980277093: goto L13;
            default: goto L33;
        };
    L13:
        if (r9.equals("coverflow") == false) goto L33;
        r4 = 4;
        goto L33
    L17:
        if (r9.equals("flat-coverflow") == false) goto L33;
        r4 = 3;
        goto L33
    L21:
        if (r9.equals("carry") == false) goto L33;
        r4 = 2;
        goto L33
    L25:
        if (r9.equals("carousel") == false) goto L33;
        r4 = 1;
        goto L33
    L29:
        if (r9.equals("normal") == false) goto L33;
        r4 = 0;
    L33:
        switch(r4) {
            case 0: goto L55;
            case 1: goto L54;
            case 2: goto L51;
            case 3: goto L43;
            case 4: goto L35;
            default: goto L56;
        };
    L35:
        r0.setTransformer(this.A);
        if (a0(r0, r3) == false) goto L56;
        float r5 = r3;
        r0.setPageSize((int) Math.ceil(0.6f * r5));
        int r10 = (int) ((r5 * 0.4f) / 2.0f);
        if (isRtl() == true) goto L40;
    L42:
        r0.u(r10, false);
        goto L56
    L40:
        if (this.m == true) goto L42;
        r0.u(-r10, false);
        goto L56
    L43:
        r0.setTransformer(null);
        if (a0(r0, r3) == false) goto L56;
        float r11 = r3;
        r0.setPageSize((int) Math.ceil(0.6f * r11));
        int r12 = (int) ((r11 * 0.4f) / 2.0f);
        if (isRtl() == true) goto L48;
    L50:
        r0.u(r12, false);
        goto L56
    L48:
        if (this.m == true) goto L50;
        r0.u(-r12, false);
        goto L56
    L51:
        r0.setTransformer(this.B);
        if (a0(r0, r3) == false) goto L56;
        r0.setPageSize(r3);
        r0.u(0, false);
        goto L56
    L54:
        r0.setPageSize((int) Math.ceil(r3 * 0.8f));
        r0.setTransformer(null);
        r0.u(0, false);
        goto L56
    L55:
        r0.setPageSize(r3);
        r0.setTransformer(null);
        r0.u(0, false);
    L56:
        r0.requestLayout();
        return;
    L5:
        r1 = ((getWidth() - getPaddingLeft()) - getPaddingRight()) - getBorderLeftWidth();
        r2 = getBorderRightWidth();
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onListCellDisAppear(String r3, LynxBaseUI r4, boolean r5) {
        super.onListCellDisAppear(r3, r4, r5);
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        String r6 = constructListStateCacheKey(getTagName(), r3, getIdSelector());
        if (r5 == false) goto L8;
        r4.storeKeyToNativeStorage(r6, Integer.valueOf(((SwiperView) this.mView).a.getCurrentIndex()));
        return;
    L8:
        r4.removeKeyFromNativeStorage(r6);
    }

    public final void Z(ViewPager r8, int r9, boolean r10, boolean r11) {
        int r0 = r8.getTotalCount();
        int r1 = r8.getCurrentIndex();
        boolean r2 = this.o;
        int r3 = 1;
        if (r2 == false) goto L15;
        if (r9 != 0) goto L15;
        if (r1 != (r0 - 1)) goto L15;
        if (r0 > 2) goto L11;
        if (r11 == true) goto L11;
        r3 = 0;
    L11:
        int r12 = r8.getTotalCount();
        if (r9 < 0) goto L32;
        if (r9 >= r12) goto L33;
        r8.t(r9, r10, r3);
        return;
    L33:
        return;
    L32:
        return;
    L15:
        if (r2 == true) goto L17;
    L25:
        if (r9 >= r1) goto L27;
        r3 = 0;
    L27:
        int r13 = r8.getTotalCount();
        if (r9 < 0) goto L38;
        if (r9 >= r13) goto L39;
        r8.t(r9, r10, r3);
        return;
    L39:
        return;
    L38:
        return;
    L17:
        if (r9 != (r0 - 1)) goto L25;
        if (r1 != 0) goto L25;
        if (r0 <= 2) goto L21;
        r3 = 0;
    L21:
        int r14 = r8.getTotalCount();
        if (r9 < 0) goto L35;
        if (r9 >= r14) goto L36;
        r8.t(r9, r10, r3);
        return;
    L36:
        return;
    }
}
