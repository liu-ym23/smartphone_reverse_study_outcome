package com.lynx.tasm.behavior.ui.list.container;

import android.content.Context;
import android.text.TextUtils;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import androidx.core.view.ViewCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.IDrawChildHook;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.utils.h;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.g;
import com.lynx.tasm.l;
import com.lynx.tasm.utils.DeviceUtils;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.tasm.utils.i;
import com.lynx.tasm.utils.n;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIListContainer extends UISimpleView<ListContainerView> implements NestedScrollContainerView.e, UIComponent.a {
    public static final /* synthetic */ int G = 0;
    public Callback A;
    public boolean B;
    public boolean C;
    public int D;
    public ListContainerProxy E;
    public final a F;
    public boolean a;
    public f b;
    public JavaOnlyArray c;
    public final HashMap<String, Integer> d;
    public boolean e;
    public int f;
    public final Map<String, Object> g;
    public final Map<String, HashSet<String>> h;
    public final HashMap<Integer, UIComponent> i;
    public final HashMap<Integer, UIComponent> j;
    public JavaOnlyArray k;
    public JavaOnlyArray l;
    public UIComponent m;
    public UIComponent n;
    public boolean o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public final HashSet<String> w;
    public final HashSet<String> x;
    public final HashMap<String, UIComponent> y;
    public final HashMap<String, UIComponent> z;

    public class a extends NestedScrollContainerView.c {
        public int a;
        public boolean b;
        public final /* synthetic */ UIListContainer c;

        @Override // com.lynx.tasm.behavior.ui.list.container.NestedScrollContainerView.c
        public final void a() {
            LynxContext r0 = this.c.getLynxContext();
            UIListContainer r1 = this.c;
            ListContainerProxy r2 = r1.E;
            if (r2 == null) goto L5;
            r2.c(r1.getSign());
            return;
        L5:
            if (r0 != null) goto L7;
            return;
        L7:
            if (r0.getListNodeInfoFetcher() == null) goto L14;
            g r3 = this.c.getLynxContext().getListNodeInfoFetcher();
            int r4 = this.c.getSign();
            LynxTemplateRender r5 = ((l) r3).a;
            if (r5 == null) goto L15;
            r5.scrollStopped(r4);
            return;
        L15:
            return;
        }

        public a(UIListContainer r1) {
            this.c = r1;
            this.a = -1;
            this.b = false;
        }
    }

    public class b implements UIComponent.b {
        public final /* synthetic */ UIListContainer a;

        public b(UIListContainer r1) {
            this.a = r1;
        }

        @Override // com.lynx.tasm.behavior.ui.view.UIComponent.b
        public final void a(UIComponent r3) {
            if (r3 == null) goto L5;
            UIListContainer r0 = this.a;
            int r1 = UIListContainer.G;
            r0.X(r3);
            return;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ UIComponent a;
        public final /* synthetic */ UIListContainer b;

        @Override // java.lang.Runnable
        public final void run() {
            UIListContainer r0 = this.b;     // Catch: Throwable -> L4
            UIComponent r1 = this.a;     // Catch: Throwable -> L4
            int r2 = UIListContainer.G;     // Catch: Throwable -> L4
            r0.S(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(UIListContainer r1, UIComponent r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class d implements e7a.f.a {
        public final /* synthetic */ UIListContainer a;

        /* JADX WARN: Multi-variable type inference failed */
        public final int b() {
            return ((ListContainerView) this.a.getView()).getScrollX();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int c() {
            return ((ListContainerView) this.a.getView()).getScrollY();
        }

        public d(UIListContainer r1) {
            this.a = r1;
        }

        public final int a(View r2) {
            if ((r2 instanceof com.lynx.tasm.behavior.ui.view.b) == false) goto L10;
            com.lynx.tasm.behavior.ui.view.b r3 = (com.lynx.tasm.behavior.ui.view.b) r2;
            if ((r3.getDrawChildHook() instanceof UIComponent) == false) goto L12;
            String r4 = ((UIComponent) r3.getDrawChildHook()).b;
            if (this.a.c.contains(r4) == true) goto L9;
            return -1;
        L9:
            return this.a.c.indexOf(r4);
        L12:
            return -1;
        L10:
            return -1;
        }
    }

    public class e implements Comparator<JavaOnlyMap> {
        public e() {
        }

        @Override // java.util.Comparator
        public final int compare(JavaOnlyMap r2, JavaOnlyMap r3) {
            return Integer.compare(r2.getInt("position"), r3.getInt("position"));
        }
    }

    public class f extends f7a.c {
        public final /* synthetic */ Callback e;
        public final /* synthetic */ UIListContainer f;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f7a.c
        public final boolean a(int r3) {
            if (r3 > 0) goto L5;
        L6:
            if (r3 < 0) goto L8;
        L10:
            return false;
        L8:
            if (((ListContainerView) this.f.getView()).b(-1) == false) goto L10;
            return true;
        L5:
            if (((ListContainerView) this.f.getView()).b(1) == false) goto L6;
            return true;
        }

        public f(UIListContainer r1, Callback r2) {
            this.f = r1;
            this.e = r2;
        }
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isScrollContainer() {
        return true;
    }

    public final boolean Y() {
        LynxContext r0 = this.mContext;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getLynxView() == null) goto L15;
        ThreadStrategyForRendering r1 = this.mContext.getLynxView().getThreadStrategyForRendering();
        if (r1 != ThreadStrategyForRendering.MOST_ON_TASM) goto L10;
    L11:
        return true;
    L10:
        if (r1 == ThreadStrategyForRendering.MULTI_THREADS) goto L11;
        return false;
    L15:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [android.view.View] */
    public final void d0() {
        if (this.e == true) goto L6;
        return;
    L6:
        if (this.a == false) goto L8;
        int r0 = getHeight() + getScrollY();
        int r1 = this.f;
    L9:
        int r2 = r0 - r1;
        Iterator<Object> r3 = this.l.iterator();
        UIComponent r4 = null;
        UIComponent r5 = null;
    L11:
        if (r3.hasNext() == false) goto L25;
        UIComponent r6 = V((Integer) r3.next(), false);
        if (r6 == null) goto L11;
        if (this.a == false) goto L18;
        int r7 = r6.getTop();
        int r8 = r6.getHeight();
    L20:
        if ((r7 + r8) < r2) goto L21;
        if (r4 != null) goto L23;
        r4 = r6;
        goto L11
    L23:
        Z(r6);
        goto L11
    L21:
        Z(r6);
        r5 = r6;
        goto L11
    L18:
        r7 = r6.getLeft();
        r8 = r6.getWidth();
        goto L20
    L25:
        if (r4 != null) goto L27;
        return;
    L27:
        if (this.n == r4) goto L33;
        if (this.a == false) goto L31;
        m7a.a r9 = new m7a.a(getSign(), "stickybottom");
        r9.a("bottom", r4.b);
        this.mContext.getEventEmitter().sendCustomEvent(r9);
    L31:
        m7a.a r10 = new m7a.a(getSign(), "stickyend");
        r10.a("end", r4.b);
        this.mContext.getEventEmitter().sendCustomEvent(r10);
        this.n = r4;
    L33:
        if (this.a == false) goto L35;
        int r11 = r4.getHeight();
    L36:
        int r12 = r2 - r11;
        if (r5 == null) goto L46;
        if (this.a == false) goto L41;
        int r13 = r2 - (r5.getTop() + r5.getHeight());
        int r14 = r4.getHeight();
    L42:
        int r15 = r14 - r13;
        if (r15 <= 0) goto L46;
        r12 = r12 + r15;
        goto L46
    L41:
        r13 = r2 - (r5.getLeft() + r5.getWidth());
        r14 = r4.getWidth();
    L46:
        if (r4.getView() != 0) goto L48;
        return;
    L48:
        if (this.a == false) goto L50;
        ((com.lynx.tasm.behavior.ui.view.a) r4.getView()).setTranslationY(r12 - r4.getTop());
    L51:
        ((com.lynx.tasm.behavior.ui.view.a) r4.getView()).bringToFront();
        ?? r16 = r4.getView();
        if (r16 == 0) goto L68;
        r16.setOutlineProvider(null);
        ViewCompat.setTranslationZ(r16, 2.1474836E9f);
        return;
    L68:
        return;
    L50:
        ((com.lynx.tasm.behavior.ui.view.a) r4.getView()).setTranslationX(r12 - r4.getLeft());
        goto L51
    L35:
        r11 = r4.getWidth();
        goto L36
    L8:
        r0 = getWidth() + getScrollX();
        r1 = this.f;
        goto L9
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        LLog.i("UIListContainer", "destroy: " + this + ", listContainerView: " + this.mView);
        super.destroy();
        T r0 = this.mView;
        if (r0 == 0) goto L17;
        ListContainerView r1 = (ListContainerView) r0;
        TraceEvent.beginSection("ListContainerView.destroy");
        NestedScrollContainerView.f r3 = r1.r;
        if (r3.e.d() == true) goto L7;
        r3.e.a();
    L7:
        r3.a = 0;
        r3.b = 0;
        r3.c = 0;
        r3.d = 0;
        ViewTreeObserver r4 = r1.getViewTreeObserver();
        if (r1.N == null) goto L13;
        if (r4 == null) goto L13;
        if (r4.isAlive() == false) goto L13;
        r4.removeOnPreDrawListener(r1.N);
        r1.N = null;
    L13:
        ListContainerView.c r5 = r1.O;
        if (r5 == null) goto L16;
        r1.removeCallbacks(r5);
        r1.O = null;
    L16:
        r1.P = false;
        r1.M = false;
        r1.k0 = false;
        r1.Q.clear();
        r1.D = null;
        r1.y = null;
        r1.z = null;
        r1.t.clear();
        r1.s.clear();
        TraceEvent.endSection("ListContainerView.destroy");
    L17:
        f r2 = this.b;
        if (r2 == null) goto L20;
        r2.b();
    L20:
        ListContainerProxy r6 = this.E;
        if (r6 == null) goto L24;
        r6.a();
        this.E = null;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final int getMemberScrollX() {
        if (this.a == false) goto L7;
        return 0;
    L7:
        return ((ListContainerView) this.mView).getScrollX();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final int getMemberScrollY() {
        if (this.a == true) goto L5;
        return 0;
    L5:
        return ((ListContainerView) this.mView).getScrollY();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final int getScrollContainerDirection() {
        if (this.a == false) goto L5;
        return 1;
    L5:
        return -1;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getScrollX() {
        return ((ListContainerView) this.mView).getScrollX();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getScrollY() {
        return ((ListContainerView) this.mView).getScrollY();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [android.view.View] */
    public final void i0() {
        if (this.e == true) goto L6;
        return;
    L6:
        if (this.a == false) goto L8;
        int r0 = getScrollY();
    L9:
        int r1 = r0 + this.f;
        JavaOnlyArray r2 = this.k;
        ListIterator<Object> r3 = r2.listIterator(r2.size());
        UIComponent r4 = null;
        UIComponent r5 = null;
    L11:
        if (r3.hasPrevious() == false) goto L24;
        UIComponent r6 = V((Integer) r3.previous(), true);
        if (r6 == null) goto L11;
        if (this.a == false) goto L18;
        int r7 = r6.getTop();
    L19:
        if (r7 > r1) goto L20;
        if (r4 != null) goto L22;
        r4 = r6;
        goto L11
    L22:
        Z(r6);
        goto L11
    L20:
        Z(r6);
        r5 = r6;
        goto L11
    L18:
        r7 = r6.getLeft();
        goto L19
    L24:
        if (r4 != null) goto L26;
        return;
    L26:
        if (this.m != r4) goto L28;
    L31:
        if (r5 == null) goto L40;
        if (this.a == false) goto L35;
        int r8 = r5.getTop() - r1;
        int r9 = r4.getHeight();
    L36:
        int r10 = r9 - r8;
        if (r10 <= 0) goto L40;
        r1 = r1 - r10;
        goto L40
    L35:
        r8 = r5.getLeft() - r1;
        r9 = r4.getWidth();
    L40:
        if (r4.getView() != 0) goto L42;
        return;
    L42:
        if (this.a == false) goto L44;
        ((com.lynx.tasm.behavior.ui.view.a) r4.getView()).setTranslationY(r1 - r4.getTop());
    L45:
        ((com.lynx.tasm.behavior.ui.view.a) r4.getView()).bringToFront();
        ?? r11 = r4.getView();
        if (r11 == 0) goto L62;
        r11.setOutlineProvider(null);
        ViewCompat.setTranslationZ(r11, 2.1474836E9f);
        return;
    L62:
        return;
    L44:
        ((com.lynx.tasm.behavior.ui.view.a) r4.getView()).setTranslationX(r1 - r4.getLeft());
        goto L45
    L28:
        if (this.a == false) goto L30;
        m7a.a r12 = new m7a.a(getSign(), "stickytop");
        r12.a("top", r4.b);
        this.mContext.getEventEmitter().sendCustomEvent(r12);
    L30:
        m7a.a r13 = new m7a.a(getSign(), "stickystart");
        r13.a("start", r4.b);
        this.mContext.getEventEmitter().sendCustomEvent(r13);
        this.m = r4;
        goto L31
    L8:
        r0 = getScrollX();
        goto L9
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.ui.k
    public final void invalidate() {
        if (((ListContainerView) this.mView).getLinearLayout() == null) goto L5;
        ((ListContainerView) this.mView).getLinearLayout().invalidate();
    L5:
        super.invalidate();
    }

    public final JavaOnlyArray j0() {
        if (this.mContext == null) goto L5;
        ArrayList r0 = new ArrayList();
        float r1 = this.mContext.getScreenMetrics().density;
        int r2 = ((ListContainerView) this.mView).getScrollX();
        int r3 = ((ListContainerView) this.mView).getScrollY();
        int r5 = 0;
    L8:
        if (r5 >= ((ListContainerView) this.mView).getLinearLayout().getChildCount()) goto L38;
        View r6 = ((ListContainerView) this.mView).getLinearLayout().getChildAt(r5);
        if ((r6 instanceof com.lynx.tasm.behavior.ui.view.b) == false) goto L37;
        com.lynx.tasm.behavior.ui.view.b r7 = (com.lynx.tasm.behavior.ui.view.b) r6;
        boolean r9 = true;
        if (this.a == false) goto L24;
        int r8 = r7.getTop();
        int r10 = r7.getBottom();
        int r11 = ((ListContainerView) this.mView).getScrollY();
        int r12 = ((ListContainerView) this.mView).getHeight() + r11;
        if (r8 > r11) goto L16;
        if (r10 < r11) goto L16;
    L22:
        if (r9 == false) goto L37;
    L34:
        IDrawChildHook r13 = r7.getDrawChildHook();
        if ((r13 instanceof UIComponent) == false) goto L37;
        UIComponent r14 = (UIComponent) r13;
        JavaOnlyMap r15 = new JavaOnlyMap();
        r15.put("id", r14.getIdSelector());
        r15.put("position", Integer.valueOf(U(r14.b)));
        r15.put("index", Integer.valueOf(U(r14.b)));
        r15.put("itemKey", r14.b);
        r15.put("top", Float.valueOf((r6.getTop() - r3) / r1));
        r15.put("bottom", Float.valueOf((r6.getBottom() - r3) / r1));
        r15.put("left", Float.valueOf((r6.getLeft() - r2) / r1));
        r15.put("right", Float.valueOf((r6.getRight() - r2) / r1));
        r0.add(r15);
    L16:
        if (r8 > r12) goto L18;
        if (r10 >= r12) goto L22;
    L18:
        if (r8 < r11) goto L21;
        if (r10 <= r12) goto L22;
    L21:
        r9 = false;
        goto L22
    L24:
        int r16 = r7.getLeft();
        int r17 = r7.getRight();
        int r18 = ((ListContainerView) this.mView).getScrollX();
        int r19 = ((ListContainerView) this.mView).getWidth() + r18;
        if (r16 > r18) goto L27;
        if (r17 < r18) goto L27;
    L33:
        if (r9 == false) goto L37;
    L27:
        if (r16 > r19) goto L29;
        if (r17 >= r19) goto L33;
    L29:
        if (r16 < r18) goto L32;
        if (r17 <= r19) goto L33;
    L32:
        r9 = false;
    L37:
        r5 = r5 + 1;
        goto L8
    L38:
        Collections.sort(r0, new e());
        return JavaOnlyArray.from(r0);
    L5:
        return new JavaOnlyArray();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final Map<Integer, t7a.a> getGestureHandlers() {
        return super.getGestureHandlers();
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void layout() {
        if (getOverflow() == 0) goto L5;
        ((ListContainerView) this.mView).setClipChildren(false);
    L5:
        super.layout();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final void onInvalidate() {
        if (isEnableNewGesture() == false) goto L9;
        T r0 = this.mView;
        if (r0 == 0) goto L10;
        ViewCompat.postInvalidateOnAnimation(r0);
        return;
    L10:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        ViewCompat.setLayoutDirection(this.mView, 0);
        if (this.a == false) goto L8;
        if (((ListContainerView) this.mView).F == getWidth()) goto L8;
        ((ListContainerView) this.mView).m(getWidth(), ((ListContainerView) this.mView).G);
    L12:
        ListContainerView r0 = (ListContainerView) this.mView;
        int r1 = this.mPaddingLeft;
        int r2 = this.mPaddingRight;
        int r3 = this.mPaddingTop;
        int r4 = this.mPaddingBottom;
        r0.H = r1;
        r0.I = r2;
        r0.J = r3;
        r0.K = r4;
        return;
    L8:
        if (this.a == true) goto L12;
        if (((ListContainerView) this.mView).G == getHeight()) goto L12;
        T r5 = this.mView;
        ((ListContainerView) r5).m(((ListContainerView) r5).F, getHeight());
        goto L12
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReady() {
        if (TraceEvent.isTracingStarted() == false) goto L5;
        String r0 = "UIListContainer.onNodeReady";
        TraceEvent.beginSection("UIListContainer.onNodeReady");
    L6:
        super.onNodeReady();
        if (this.E == null) goto L9;
    L15:
        ListContainerView r1 = (ListContainerView) this.mView;
        if (Boolean.TRUE.equals(r1.L) == false) goto L25;
        T r2 = this.mView;
        ListContainerView r3 = (ListContainerView) r2;
        if (r3.M == true) goto L20;
    L22:
        boolean r4 = false;
    L23:
        if (r4 == true) goto L25;
        ((ListContainerView) r2).k();
        goto L25
    L20:
        if (r3.k0 == false) goto L22;
        r4 = true;
    L25:
        i0();
        d0();
        if (TraceEvent.isTracingStarted() == false) goto L29;
        TraceEvent.endSection(r0);
        return;
    L29:
        return;
    L9:
        if (getLynxContext() == null) goto L15;
        if (getLynxContext().getListNodeInfoFetcher() == null) goto L15;
        if (((l) getLynxContext().getListNodeInfoFetcher()).a() == 0) goto L15;
        this.E = new ListContainerProxy(((l) getLynxContext().getListNodeInfoFetcher()).a());
        goto L15
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onPropsUpdated() {
        super.onPropsUpdated();
        if (this.e == true) goto L5;
    L7:
        T r0 = this.mView;
        if (((ListContainerView) r0).L != null) goto L11;
        Boolean r1 = Boolean.FALSE;
        ((ListContainerView) r0).L = r1;
        return;
    L11:
        return;
    L5:
        if (this.v == false) goto L7;
        T(this.w, this.k, this.y);
        T(this.x, this.l, this.z);
        goto L7
    }

    public static /* synthetic */ View N(UIListContainer r0) {
        return r0.mView;
    }

    public static /* synthetic */ View O(UIListContainer r0) {
        return r0.mView;
    }

    public static /* synthetic */ View Q(UIListContainer r0) {
        return r0.mView;
    }

    public static /* synthetic */ View R(UIListContainer r0) {
        return r0.mView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.view.View] */
    public final void S(UIComponent r5) {
        ?? r0 = r5.getView();
        if (r0 != 0) goto L5;
    L11:
        float r1 = r5.c;
        ?? r6 = r5.getView();
        if (r6 == 0) goto L15;
        r6.setOutlineProvider(null);
        ViewCompat.setTranslationZ(r6, r1);
        return;
    L15:
        return;
    L5:
        if (r0.getParent() != null) goto L11;
        ((ListContainerView) this.mView).addView(r0);
        if (this.o == false) goto L11;
        if (Y() == false) goto L11;
        AlphaAnimation r2 = new AlphaAnimation(0.0f, 1.0f);
        r2.setDuration(this.p);
        r0.startAnimation(r2);
        goto L11
    }

    public final int U(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return -1;
    L5:
        if (this.d.containsKey(r2) == true) goto L8;
        return -1;
    L8:
        return this.d.get(r2).intValue();
    }

    public final void W(LynxBaseUI r4) {
        if ((r4 instanceof UIComponent) == false) goto L30;
        UIComponent r5 = (UIComponent) r4;
        if (this.t == false) goto L8;
        X(r5);
    L17:
        if (this.e == true) goto L19;
        return;
    L19:
        if (this.v == false) goto L28;
        String r0 = r5.b;
        if (r0 != null) goto L23;
        return;
    L23:
        if (this.w.contains(r0) == false) goto L26;
        this.y.put(r0, r5);
        r5.d = this;
        return;
    L26:
        if (this.x.contains(r0) == false) goto L34;
        this.z.put(r0, r5);
        r5.d = this;
        return;
    L34:
        return;
    L28:
        int r1 = U(r5.b);
        g0(r5, this.i, this.k, r1);
        g0(r5, this.j, this.l, r1);
        return;
    L8:
        if (r5.getWidth() == 0) goto L10;
    L15:
        X(r5);
        goto L17
    L10:
        if (r5.getHeight() != 0) goto L15;
        if (r5.a != null) goto L17;
        r5.a = new b(this);
        goto L17
    }

    public final void X(UIComponent r4) {
        ListContainerView r0 = (ListContainerView) this.mView;
        if (Boolean.TRUE.equals(r0.L) == false) goto L12;
        T r1 = this.mView;
        ListContainerView r2 = (ListContainerView) r1;
        if (r2.M == true) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L12;
        c r5 = new c(this, r4);
        ((ListContainerView) r1).Q.add(r5);
        return;
    L7:
        if (r2.k0 == false) goto L9;
        r3 = true;
    L12:
        S(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View] */
    public final void Z(UIComponent r3) {
        if (r3.getView() != 0) goto L5;
        return;
    L5:
        if (this.a == false) goto L7;
        ((com.lynx.tasm.behavior.ui.view.a) r3.getView()).setTranslationY(0.0f);
    L8:
        float r0 = r3.c;
        ?? r4 = r3.getView();
        if (r4 == 0) goto L13;
        r4.setOutlineProvider(null);
        ViewCompat.setTranslationZ(r4, r0);
        return;
    L13:
        return;
    L7:
        ((com.lynx.tasm.behavior.ui.view.a) r3.getView()).setTranslationX(0.0f);
        goto L8
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void consumeGesture(boolean r3) {
        ListContainerView r0 = (ListContainerView) this.mView;
        r0.A = Boolean.valueOf(r3);
        if (r3 == false) goto L6;
        r0.C = false;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r3) {
        ListContainerView r0 = new ListContainerView(r3, this);
        r0.s.add(this);
        LLog.i("UIListContainer", "create UIListContainer: " + this + ", " + r0);
        return r0;
    }

    @LynxUIMethod
    public void getScrollInfo(Callback r5) {
        int r0 = getMemberScrollX();
        int r1 = getMemberScrollY();
        JavaOnlyMap r2 = new JavaOnlyMap();
        r2.putInt("scrollX", h.h(this.mContext, r0));
        r2.putInt("scrollY", h.h(this.mContext, r1));
        r2.putInt("maxScrollOffset", h.h(this.mContext, ((ListContainerView) this.mView).getScrollRange()));
        r5.invoke(new Object[]{0, r2});
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final Object getValueFromNativeStorage(String r2) {
        Map<String, Object> r0 = this.g;
        if (r0 != null) goto L5;
        return null;
    L5:
        return ((HashMap) r0).get(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void interceptGesture(boolean r2) {
        ListContainerView r0 = (ListContainerView) this.mView;
        r0.B = Boolean.valueOf(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final boolean isAtBorder(boolean r3) {
        if (isEnableNewGesture() == true) goto L7;
        return false;
    L7:
        if (r3 == false) goto L11;
        return !((ListContainerView) getView()).b(-1);
    L11:
        return !((ListContainerView) getView()).b(1);
    }

    @Override // com.lynx.tasm.behavior.ui.list.container.NestedScrollContainerView.e
    public final void o(int r8) {
        if (r8 == 1) goto L6;
        recognizeGesturere();
    L6:
        if (r8 != 1) goto L14;
        getLynxContext().getFluencyTraceHelper().c(getSign());
        Callback r3 = this.A;
        if (r3 == null) goto L11;
        this.A = null;
        r3.invoke(new Object[]{0});
    L11:
        if (this.r == false) goto L19;
        a0(((ListContainerView) this.mView).getScrollX(), ((ListContainerView) this.mView).getScrollY(), ((ListContainerView) this.mView).getScrollX(), ((ListContainerView) this.mView).getScrollY(), "scrollend");
    L19:
        if (this.s == false) goto L25;
        m7a.a r0 = new m7a.a(getSign(), "scrollstatechange");
        if (this.u == false) goto L23;
        r0.a("attachedCells", j0());
    L23:
        r0.a("state", Integer.valueOf(r8));
        this.mContext.getEventEmitter().sendCustomEvent(r0);
        return;
    L25:
        return;
    L14:
        if (r8 != 2) goto L19;
        getLynxContext().getFluencyTraceHelper().b(getSign(), getScrollMonitorTag());
        Callback r4 = this.A;
        if (r4 == null) goto L19;
        this.A = null;
        r4.invoke(new Object[]{1, "the scroll has stopped, triggered by dragging events"});
        goto L19
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [android.view.View] */
    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void removeChild(LynxBaseUI r4) {
        super.removeChild(r4);
        if ((r4 instanceof UIComponent) == false) goto L15;
        UIComponent r0 = (UIComponent) r4;
        if (this.o == true) goto L7;
    L13:
        r0.a = null;
        r0.d = null;
        goto L15
    L7:
        if (Y() == false) goto L13;
        ?? r1 = r0.getView();
        if (r1 == 0) goto L13;
        if (r1.getAnimation() == null) goto L13;
        r1.getAnimation().cancel();
    L15:
        if (this.e == true) goto L17;
        return;
    L17:
        if (this.v == true) goto L21;
        e0(r4, this.i);
        e0(r4, this.j);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void removeKeyFromNativeStorage(String r2) {
        Map<String, Object> r0 = this.g;
        if (r0 == null) goto L6;
        ((HashMap) r0).remove(r2);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void removeView(LynxBaseUI r4) {
        ListContainerView r0 = (ListContainerView) this.mView;
        if (Boolean.TRUE.equals(r0.L) == false) goto L12;
        T r1 = this.mView;
        ListContainerView r2 = (ListContainerView) r1;
        if (r2.M == true) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L12;
        f7a.f r5 = new f7a.f(this, r4);
        ((ListContainerView) r1).Q.add(r5);
    L14:
        if ((r4 instanceof UIComponent) == false) goto L33;
        UIComponent r6 = (UIComponent) r4;
        if (this.e == true) goto L18;
        return;
    L18:
        if (this.v == false) goto L31;
        String r7 = r6.b;
        if (r7 != null) goto L22;
        return;
    L22:
        if (this.y.get(r7) != r6) goto L27;
        this.y.remove(r7);
        r6.d = null;
        if (this.q == false) goto L36;
        Z(r6);
        return;
    L36:
        return;
    L27:
        if (this.z.get(r7) != r6) goto L38;
        this.z.remove(r7);
        r6.d = null;
        if (this.q == false) goto L39;
        Z(r6);
        return;
    L39:
        return;
    L38:
        return;
    L31:
        e0(r6, this.i);
        e0(r6, this.j);
        return;
    L33:
        return;
    L7:
        if (r2.k0 == false) goto L9;
        r3 = true;
    L12:
        super.removeView(r4);
        goto L14
    }

    @LynxProp(defaultInt = 0, name = "experimental-batch-render-strategy")
    public void setBatchRenderStrategy(int r1) {
        if (r1 <= 0) goto L4;
        boolean r2 = true;
    L5:
        this.t = r2;
        return;
    L4:
        r2 = false;
        goto L5
    }

    @LynxProp(defaultBoolean = false, name = "experimental-android-defer-child-mutation-in-draw")
    public void setDeferChildMutationInDraw(boolean r3) {
        T r0 = this.mView;
        if (((ListContainerView) r0).L != null) goto L6;
        Boolean r4 = Boolean.valueOf(r3);
        ((ListContainerView) r0).L = r4;
        return;
    }

    @LynxProp(name = "list-container-info")
    public void setDiffInfo(ReadableMap r5) {
        if (r5 == null) goto L15;
        ReadableArray r0 = r5.getArray("stickyStart");
        if (r0 == null) goto L6;
        this.k = JavaOnlyArray.shallowCopy(r0);
    L6:
        ReadableArray r1 = r5.getArray("stickyEnd");
        if (r1 == null) goto L9;
        this.l = JavaOnlyArray.shallowCopy(r1);
    L9:
        ReadableArray r6 = r5.getArray("itemkeys");
        if (r6 == null) goto L12;
        this.c = JavaOnlyArray.shallowCopy(r6);
    L12:
        int r7 = this.c.size();
        this.d.clear();
        int r2 = 0;
    L13:
        if (r2 >= r7) goto L17;
        this.d.put(this.c.getString(r2), Integer.valueOf(r2));
        r2 = r2 + 1;
        goto L13
    L17:
        return;
    }

    @LynxProp(defaultBoolean = false, name = "enable-fade-in-animation")
    public void setEnableFadeInAnimation(boolean r1) {
        this.o = r1;
    }

    @LynxProp(defaultBoolean = false, name = "enable-insert-platform-view-operation")
    public void setEnableInsertPlatformViewOperation(boolean r1) {
        this.B = r1;
    }

    @LynxProp(defaultBoolean = true, name = "sticky")
    public void setEnableListSticky(boolean r1) {
        this.e = r1;
    }

    @LynxProp(defaultBoolean = false, name = "enable-nested-scroll")
    public void setEnableNestedScroll(boolean r2) {
        ((ListContainerView) this.mView).setNestedScrollingEnabled(r2);
    }

    @LynxProp(defaultBoolean = true, name = "experimental-recycle-sticky-item")
    public void setEnableRecycleStickyItem(boolean r1) {
        this.q = r1;
    }

    @LynxProp(defaultBoolean = true, name = "enable-scroll")
    public void setEnableScroll(boolean r2) {
        ((ListContainerView) this.mView).setEnableScroll(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map<String, EventsListener> r2) {
        super.setEvents(r2);
        if (r2 != null) goto L5;
        return;
    L5:
        this.r = r2.containsKey("scrollend");
        this.s = r2.containsKey("scrollstatechange");
    }

    @LynxProp(defaultBoolean = false, name = "force-can-scroll")
    public void setForceCanScroll(boolean r2) {
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ((ListContainerView) r0).setForceCanScroll(r2);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setGestureDetectors(Map<Integer, s7a.a> r1) {
        super.setGestureDetectors(r1);
    }

    @LynxProp(name = "experimental-max-fling-distance-ratio")
    public void setMaxFlingDistanceRatio(f6a.a r4) {
        if (r4.getType() != ReadableType.String) goto L8;
        if (r4.asString().equals("auto") == false) goto L8;
        ((ListContainerView) this.mView).setMaxFlingDistanceRatio(Float.MAX_VALUE);
        return;
    L8:
        if (r4.getType() != ReadableType.Number) goto L12;
        ((ListContainerView) this.mView).setMaxFlingDistanceRatio((float) r4.asDouble());
        return;
    }

    @LynxProp(defaultBoolean = false, name = "need-visible-item-info")
    public void setNeedVisibleItemInfo(boolean r1) {
        this.u = r1;
    }

    @LynxProp(name = "item-snap")
    public void setPagingAlignment(ReadableMap r19) {
        if (r19 != null) goto L5;
    L25:
        ((ListContainerView) this.mView).a = null;
        return;
    L5:
        if (r19.size() <= 0) goto L25;
        double r2 = r19.getDouble("factor");
        if (r2 >= 0.0d) goto L9;
    L12:
        getLynxContext().handleLynxError(new LynxError(220205, "item-snap invalid!", "The factor should be constrained to the range of [0,1].", LynxError.LEVEL_WARN));
        double r11 = 0.0d;
    L13:
        int r3 = r19.getInt("offset", 0);
        if (Math.abs(r3) <= 0) goto L16;
        getLynxContext().handleLynxError(new LynxError(220205, "The unit of offset is changed from ppx to px on Android platform in Lynx SDK version 3.7. If Lynx SDK version < 3.7, you can use Math.round(offset * PixelRatio).", NameKeys.UnloadStrategy_No_Strategy, LynxError.LEVEL_WARN));
        r3 = (int) i.b(r3, 0.0f);
    L16:
        int r13 = r3;
        double r14 = 50.0f / this.mContext.getScreenMetrics().densityDpi;
        if (r19.hasKey("maxSnapCount") == false) goto L22;
        int r1 = r19.getInt("maxSnapCount", 1);
        if (r1 >= 1) goto L21;
        getLynxContext().handleLynxError(new LynxError(220205, "item-snap invalid!", "The maxSnapCount should be greater than 0.", LynxError.LEVEL_WARN));
        goto L22
    L21:
        int r16 = r1;
    L23:
        ((ListContainerView) this.mView).a = new e7a.f(r11, r13, r14, r16, new d(this));
        return;
    L22:
        r16 = 1;
        goto L23
    L9:
        if (r2 > 1.0d) goto L12;
        r11 = r2;
        goto L13
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final void setPanInterceptAncestors(boolean r2) {
        ((ListContainerView) this.mView).setPanInterceptAncestors(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final void setPanInterceptDescendants(boolean r2) {
        ((ListContainerView) this.mView).setPanInterceptDescendants(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final void setPanInterceptSelf(boolean r2) {
        ((ListContainerView) this.mView).setPanInterceptSelf(r2);
    }

    @LynxProp(customType = "vertical", name = "scroll-orientation")
    public void setScrollOrientation(String r3) {
        if (TextUtils.equals(r3, "vertical") == false) goto L6;
        this.a = true;
    L9:
        ((ListContainerView) this.mView).setOrientation(this.a ? 1 : 0);
        return;
    L6:
        if (TextUtils.equals(r3, "horizontal") == false) goto L8;
        this.a = false;
        goto L9
    L8:
        this.a = true;
        goto L9
    }

    @LynxProp(defaultFloat = 0.0f, name = "sticky-offset")
    public void setStickyOffset(float r2) {
        this.f = (int) i.b(r2, 0.0f);
    }

    @LynxProp(defaultInt = 100, name = "update-animation-fade-in-duration")
    public void setUpdateAnimationFadeInDuration(int r1) {
        this.p = r1;
    }

    @LynxProp(defaultBoolean = true, name = "experimental-update-sticky-for-diff")
    public void setUpdateStickyForDiff(boolean r1) {
        this.v = r1;
    }

    @LynxProp(defaultBoolean = false, name = "vertical-orientation")
    public void setVerticalOrientation(boolean r2) {
        this.a = r2;
        ((ListContainerView) this.mView).setOrientation(r2 ? 1 : 0);
    }

    public UIListContainer(LynxContext r3, Object r4) {
        super(r3, r4);
        this.a = true;
        this.b = null;
        this.c = new JavaOnlyArray();
        this.d = new HashMap();
        this.e = false;
        this.f = 0;
        this.g = new HashMap();
        this.h = new HashMap();
        this.i = new LinkedHashMap();
        this.j = new LinkedHashMap();
        this.k = new JavaOnlyArray();
        this.l = new JavaOnlyArray();
        this.m = null;
        this.n = null;
        this.o = false;
        this.p = 100;
        this.q = true;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = true;
        this.w = new HashSet();
        this.x = new HashSet();
        this.y = new HashMap();
        this.z = new HashMap();
        this.A = null;
        this.B = false;
        this.C = false;
        this.D = -1;
        this.E = null;
        this.F = new a(this);
    }

    public static /* synthetic */ void P(UIListContainer r0, LynxBaseUI r1) {
        super.removeView(r1);
    }

    public final UIComponent V(Integer r2, boolean r3) {
        if (this.v == false) goto L15;
        if (r3 == false) goto L6;
        HashMap<String, UIComponent> r4 = this.y;
    L7:
        int r5 = r2.intValue();
        if (r5 >= 0) goto L10;
    L14:
        return null;
    L10:
        if (r5 >= this.c.size()) goto L14;
        String r6 = this.c.getString(r5);
        if (r6 == null) goto L14;
        return r4.get(r6);
    L6:
        r4 = this.z;
        goto L7
    L15:
        if (r3 == false) goto L17;
        HashMap<Integer, UIComponent> r7 = this.i;
    L19:
        return r7.get(r2);
    L17:
        r7 = this.j;
        goto L19
    }

    @LynxUIMethod
    public void autoScroll(ReadableMap r8, Callback r9) {
        if (this.b != null) goto L6;
        this.b = new f(this, r9);
    L6:
        if (r8.hasKey("start") == false) goto L8;
    L10:
        f r0 = this.b;
        boolean r10 = r8.getBoolean("start", false);
        boolean r4 = r8.getBoolean("autoStop", true);
        r0.a = r10;
        r0.c = r4;
        f r11 = this.b;
        String r12 = r8.getString("rate", NameKeys.UnloadStrategy_No_Strategy);
        LynxContext r1 = getLynxContext();
        if (r11.a == false) goto L28;
        int r13 = (int) n.a(r12, 0.0f);
        if (r13 != 0) goto L15;
        r11.e.invoke(new Object[]{1, "rate is not right"});
        return;
    L15:
        int r2 = (int) DeviceUtils.c(r1);
        if (r2 > 0) goto L18;
        r2 = 60;
    L18:
        if (r13 <= 0) goto L20;
        int r14 = Math.max(r13 / r2, 1);
    L21:
        r11.b = r14;
        r11.b();
        UIListContainer r15 = r11.f;
        ((ListContainerView) r15.mView).w = true;
        Callback r3 = r15.A;
        if (r3 == null) goto L25;
        r15.A = null;
        r3.invoke(new Object[]{4, "the scroll has stopped, triggered by auto scroll"});
    L25:
        if (r11.a(r11.b) == false) goto L27;
        ((ListContainerView) r11.f.mView).setScrollState(4);
    L27:
        r11.e.invoke(new Object[]{0});
        r11.d = new f7a.b(r11);
        Choreographer.getInstance().postFrameCallback(r11.d);
        return;
    L20:
        r14 = Math.min(r13 / r2, -1);
        goto L21
    L28:
        ((ListContainerView) N(r11.f)).w = false;
        ((ListContainerView) O(r11.f)).setScrollState(1);
        r11.b();
        return;
    L8:
        if (this.C == true) goto L10;
        this.C = true;
        getLynxContext().handleLynxError(new LynxError(220209, "The default value of start in autoScroll is changed from true to false on Android platform in Lynx SDK version 4.1. If you need to keep the behavior before Lynx SDK version 4.1, set start to true explicitly.", NameKeys.UnloadStrategy_No_Strategy, LynxError.LEVEL_WARN));
        goto L10
    }

    public final void c0(float r9, boolean r10) {
        int r11 = (int) r9;
        this.D = r11;
        if (r10 == true) goto L32;
        NestedScrollContainerView.c r12 = ((ListContainerView) this.mView).getCustomScrollHook();
        a r0 = this.F;
        if (r12 == r0) goto L7;
        ((ListContainerView) this.mView).setCustomScrollHook(r0);
    L7:
        ListContainerView r13 = (ListContainerView) this.mView;
        boolean r1 = this.a;
        if (r1 == false) goto L10;
        int r2 = 0;
    L11:
        if (r1 == true) goto L14;
        r11 = 0;
    L14:
        NestedScrollContainerView.f r14 = r13.r;
        if (r14.e.d() == true) goto L17;
        r14.e.a();
    L17:
        r14.g.setScrollState(4);
        r14.a = r14.g.getScrollX();
        int r3 = r14.g.getScrollY();
        r14.b = r3;
        NestedScrollContainerView.c r4 = r14.f;
        if (r4 == null) goto L30;
        int r5 = r14.a;
        a r6 = (a) r4;
        boolean r7 = r6.c.a;
        if (r7 == true) goto L22;
        int r8 = r2;
    L23:
        r6.a = r8;
        if (r7 == false) goto L26;
        r5 = r3;
    L26:
        if (r8 <= r5) goto L28;
        boolean r15 = true;
    L29:
        r6.b = r15;
        goto L30
    L28:
        r15 = false;
        goto L29
    L22:
        r8 = r11;
    L30:
        f7a.a r16 = r14.e;
        int r17 = r14.a;
        r16.a = 0;
        f7a.a.C0091a r18 = r16.b;
        r18.l = false;
        r18.a = r17;
        r18.c = r17;
        r18.b = r17;
        r18.d = r17 + (r2 - r17);
        r18.h = AnimationUtils.currentAnimationTimeMillis();
        r18.i = 250;
        r18.g = 0.0f;
        r18.e = 0;
        f7a.a.C0091a r19 = r16.c;
        r19.l = false;
        r19.a = r3;
        r19.c = r3;
        r19.b = r3;
        r19.d = r3 + (r11 - r3);
        r19.h = AnimationUtils.currentAnimationTimeMillis();
        r19.i = 250;
        r19.g = 0.0f;
        r19.e = 0;
        r14.g.removeCallbacks(r14);
        ViewCompat.postOnAnimation(r14.g, r14);
        return;
    L10:
        r2 = r11;
        goto L11
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final boolean canConsumeGesture(float r5, float r6) {
        if (isEnableNewGesture() == true) goto L6;
        return false;
    L6:
        if (this.a == false) goto L18;
        if (isAtBorder(true) == false) goto L12;
        if (r6 >= 0.0f) goto L12;
        return false;
    L12:
        if (isAtBorder(false) == true) goto L14;
    L15:
        return true;
    L14:
        if (r6 <= 0.0f) goto L15;
        return false;
    L18:
        if (isAtBorder(true) == false) goto L22;
        if (r5 >= 0.0f) goto L22;
        return false;
    L22:
        if (isAtBorder(false) == true) goto L24;
    L25:
        return true;
    L24:
        if (r5 <= 0.0f) goto L25;
        return false;
    }

    public final void e0(LynxBaseUI r2, HashMap<Integer, UIComponent> r3) {
        if (this.e == true) goto L6;
        return;
    L6:
        if ((r2 instanceof UIComponent) == false) goto L20;
        Iterator<Map.Entry<Integer, UIComponent>> r4 = r3.entrySet().iterator();
    L9:
        if (r4.hasNext() == false) goto L21;
        if (r4.next().getValue() != r2) goto L9;
        if (this.q == false) goto L15;
        Z((UIComponent) r2);
    L15:
        r4.remove();
        return;
    L21:
        return;
    }

    @LynxUIMethod
    public void getVisibleCells(ReadableMap r3, Callback r4) {
        r4.invoke(new Object[]{0, j0()});
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean initialPropsFlushed(String r3, String r4) {
        Map<String, HashSet<String>> r0 = this.h;
        if (r0 == null) goto L10;
        HashSet r5 = (HashSet) ((HashMap) r0).get(r4);
        if (r5 != null) goto L7;
        return false;
    L7:
        if (r5.contains(r3) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r3, int r4) {
        super.onInsertChild(r3, r4);
        if (this.e == true) goto L5;
        return;
    L5:
        if (this.v == true) goto L9;
        int r5 = U(((UIComponent) r3).b);
        f0(r3, this.i, this.k, r5);
        f0(r3, this.j, this.l, r5);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final void onGestureScrollBy(final float r2, final float r3) {
        if (isEnableNewGesture() == true) goto L5;
        return;
    L5:
        UIThreadUtils.runOnUiThreadImmediately(new f7a.d(this, r3, r2));
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutFinish(long r1, LynxBaseUI r3) {
        super.onLayoutFinish(r1, r3);
        if (this.t == false) goto L5;
        return;
    L5:
        if (this.B == true) goto L9;
        W(r3);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final float[] scrollBy(float r10, float r11) {
        float[] r0 = new float[4];
        T r1 = this.mView;
        if (r1 != 0) goto L5;
        return r0;
    L5:
        int r2 = ((ListContainerView) r1).getScrollX();
        int r3 = ((ListContainerView) this.mView).getScrollY();
        if (this.a == true) goto L8;
        ((ListContainerView) this.mView).scrollBy((int) r10, 0);
    L10:
        if (Math.abs(r10) <= Float.MIN_VALUE) goto L12;
    L13:
        recognizeGesturere();
    L15:
        if (this.a == true) goto L17;
        float r4 = ((ListContainerView) this.mView).getScrollX() - r2;
        r0[0] = r4;
        r0[1] = 0.0f;
        r0[2] = r10 - r4;
        r0[3] = r11;
    L18:
        return r0;
    L17:
        r0[0] = 0.0f;
        float r5 = ((ListContainerView) this.mView).getScrollY() - r3;
        r0[1] = r5;
        r0[2] = r10;
        r0[3] = r11 - r5;
        goto L18
    L12:
        if (Math.abs(r11) <= Float.MIN_VALUE) goto L15;
    L8:
        ((ListContainerView) this.mView).scrollBy(0, (int) r11);
        goto L10
    }

    @LynxUIMethod
    public void scrollToPosition(ReadableMap r13, Callback r14) {
        Callback r0 = this.A;
        if (r0 == null) goto L5;
        this.A = null;
        r0.invoke(new Object[]{1, "the scroll has stopped, triggered by a new scrolling request"});
    L5:
        int r1 = r13.getInt("index", r13.getInt("position", 0));
        String r5 = r13.getString("itemKey");
        if (TextUtils.isEmpty(r5) == true) goto L10;
        Integer r6 = this.d.get(r5);
        if (r6 == null) goto L10;
        r1 = r6.intValue();
    L10:
        int r7 = r1;
        float r2 = (float) r13.getDouble("offset", 0.0d);
        boolean r11 = r13.getBoolean("smooth", false);
        int r3 = (int) i.b(r2, 0.0f);
        if (r7 >= 0) goto L13;
    L43:
        r14.invoke(new Object[]{8, "position < 0 or position >= data count"});
        return;
    L13:
        if (r7 >= this.c.size()) goto L43;
        if (r11 == true) goto L20;
        NestedScrollContainerView.f r8 = ((ListContainerView) this.mView).r;
        if (r8.e.d() == true) goto L19;
        r8.e.a();
    L19:
        r8.a = 0;
        r8.b = 0;
        r8.c = 0;
        r8.d = 0;
    L20:
        String r15 = r13.getString("alignTo");
        if (TextUtils.equals(r15, "middle") == false) goto L24;
        int r9 = 1;
    L27:
        if (r11 == false) goto L29;
        this.A = r14;
    L29:
        LynxContext r16 = getLynxContext();
        ListContainerProxy r10 = this.E;
        if (r10 == null) goto L32;
        r10.d(getSign(), r7, r3, r9, r11);
    L38:
        if (r11 == true) goto L45;
        a0(((ListContainerView) this.mView).getScrollX(), ((ListContainerView) this.mView).getScrollY(), ((ListContainerView) this.mView).getScrollX(), ((ListContainerView) this.mView).getScrollY(), "scrollend");
        r14.invoke(new Object[]{0});
        return;
    L45:
        return;
    L32:
        if (r16 != null) goto L34;
    L41:
        r14.invoke(new Object[]{1, "List has been destroyed"});
        return;
    L34:
        if (r16.getListNodeInfoFetcher() == null) goto L41;
        g r17 = r16.getListNodeInfoFetcher();
        int r12 = getSign();
        float r18 = r3;
        LynxTemplateRender r19 = ((l) r17).a;
        if (r19 == null) goto L38;
        r19.scrollToPosition(r12, r7, r18, r9, r11);
        goto L38
    L24:
        if (TextUtils.equals(r15, "bottom") == false) goto L26;
        r9 = 2;
        goto L27
    L26:
        r9 = 0;
        goto L27
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setInitialPropsHasFlushed(String r2, String r3) {
        Map<String, HashSet<String>> r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        if (((HashMap) r0).get(r3) != null) goto L7;
        HashSet r1 = new HashSet();
    L8:
        r1.add(r2);
        ((HashMap) this.h).put(r3, r1);
        return;
    L7:
        r1 = (HashSet) ((HashMap) this.h).get(r3);
        goto L8
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void storeKeyToNativeStorage(String r2, Object r3) {
        Map<String, Object> r0 = this.g;
        if (r0 == null) goto L6;
        ((HashMap) r0).put(r2, r3);
        return;
    }

    @LynxUIMethod
    public void scrollBy(ReadableMap r4, final Callback r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r4 != null) goto L6;
    L10:
        r5.invoke(new Object[]{4, "Invoke scrollBy failed due to index param is null"});
        return;
    L6:
        if (r4.hasKey("offset") == false) goto L10;
        final double r0 = i.a(r4.getDouble("offset", 0.0d));
        UIThreadUtils.runOnUiThreadImmediately(new f7a.e(this, r0, r5));
    }

    public static /* synthetic */ void M(UIListContainer r2, float r3, float r4) {
        T r0 = r2.mView;
        if (r0 != 0) goto L6;
        return;
    L6:
        if (r2.a == false) goto L8;
        ((ListContainerView) r0).scrollBy(0, (int) r3);
        return;
    L8:
        ((ListContainerView) r0).scrollBy((int) r4, 0);
    }

    public final void T(HashSet<String> r5, JavaOnlyArray r6, HashMap<String, UIComponent> r7) {
        r5.clear();
        int r0 = r6.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        int r2 = r6.getInt(r1);
        if (r2 < 0) goto L9;
        if (r2 >= this.c.size()) goto L9;
        r5.add(this.c.getString(r2));
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        Iterator<Map.Entry<String, UIComponent>> r8 = r7.entrySet().iterator();
    L12:
        if (r8.hasNext() == false) goto L19;
        Map.Entry<String, UIComponent> r9 = r8.next();
        String r3 = r9.getKey();
        UIComponent r10 = r9.getValue();
        if (r10 == null) goto L12;
        if (r3 == null) goto L12;
        if (r5.contains(r3) == true) goto L12;
        Z(r10);
        r10.d = null;
        r8.remove();
        goto L12
    }

    public final void b0(float r4, float r5, float r6) {
        ListContainerView r0 = (ListContainerView) this.mView;
        int r7 = (int) r4;
        int r8 = (int) r5;
        int r9 = (int) r6;
        boolean r1 = r0.E;
        if (r1 == true) goto L5;
    L7:
        if (r1 == false) goto L9;
    L11:
        r0.R = true;
        if (r0.E == false) goto L14;
        int r10 = r0.T + r9;
        r0.T = r10;
        r0.setScrollY(r10);
    L19:
        r0.R = false;
        return;
    L14:
        r0.S += r8;
        if (r0.y.isRtl() == false) goto L17;
        int r11 = r0.i(r0.S);
    L18:
        r0.setScrollX(r11);
        goto L19
    L17:
        r11 = r0.S;
        goto L18
    L9:
        if (r7 == r0.F) goto L11;
        r0.m(Math.max(r7, r0.y.getWidth()), r0.G);
        goto L11
    L5:
        if (r7 == r0.G) goto L7;
        r0.m(r0.F, Math.max(r7, r0.y.getHeight()));
        goto L11
    }

    public final void h0(UIComponent r4, HashMap<String, UIComponent> r5, boolean r6) {
        if (r4 == null) goto L33;
        String r0 = r4.b;
        if (r0 == null) goto L34;
        if (r6 == true) goto L7;
        Iterator<Map.Entry<String, UIComponent>> r7 = r5.entrySet().iterator();
    L19:
        if (r7.hasNext() == false) goto L37;
        if (r7.next().getValue() != r4) goto L19;
        r7.remove();
        Z(r4);
        return;
    L37:
        return;
    L7:
        if (r5.get(r0) != r4) goto L9;
        return;
    L9:
        Iterator<Map.Entry<String, UIComponent>> r8 = r5.entrySet().iterator();
    L11:
        if (r8.hasNext() == false) goto L36;
        Map.Entry<String, UIComponent> r1 = r8.next();
        if (r1.getValue() != r4) goto L11;
        if (TextUtils.equals(r1.getKey(), r0) == true) goto L11;
        r8.remove();
        r5.put(r0, r4);
        return;
    L36:
        return;
    L34:
        return;
    }

    public final void f0(LynxBaseUI r4, HashMap<Integer, UIComponent> r5, JavaOnlyArray r6, int r7) {
        if (this.e == true) goto L6;
        return;
    L6:
        if ((r4 instanceof UIComponent) == false) goto L14;
        int r0 = r6.size();
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L17;
        if (r7 == r6.getInt(r1)) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        r5.put(Integer.valueOf(r7), (UIComponent) r4);
        return;
    L17:
        return;
    }

    public final void g0(LynxBaseUI r4, HashMap<Integer, UIComponent> r5, JavaOnlyArray r6, int r7) {
        if (this.e == true) goto L6;
        return;
    L6:
        if ((r4 instanceof UIComponent) == false) goto L14;
        UIComponent r8 = (UIComponent) r4;
        int r0 = r6.size();
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L17;
        if (r7 == r6.getInt(r1)) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        r5.put(Integer.valueOf(r7), r8);
        return;
    L17:
        return;
    }

    public final void a0(int r9, int r10, int r11, int r12, String r13) {
        m7a.e r7 = new m7a.e(getSign(), "scrollend");
        ListContainerView r14 = (ListContainerView) this.mView;
        r7.d(r9, r10, r14.G, r14.F, r9 - r11, r10 - r12);
        r7.a("listWidth", Float.valueOf(i.c(getWidth())));
        r7.a("listHeight", Float.valueOf(i.c(getHeight())));
        if (isRtl() == false) goto L8;
        if (this.a == true) goto L8;
        r7.a("scrollLeft", Float.valueOf(i.c(((ListContainerView) this.mView).i(r9))));
    L8:
        if (getLynxContext() == null) goto L11;
        getLynxContext().getEventEmitter().sendCustomEvent(r7);
        return;
    }

    public final void k0(int r4, int r5, int r6, int r7, int r8) {
        m7a.a r0 = new m7a.a(getSign(), "snap");
        r0.a("position", Integer.valueOf(r4));
        r0.a("currentScrollLeft", Float.valueOf(i.c(r5)));
        r0.a("currentScrollTop", Float.valueOf(i.c(r6)));
        r0.a("targetScrollLeft", Float.valueOf(i.c(r7)));
        r0.a("targetScrollTop", Float.valueOf(i.c(r8)));
        this.mContext.getEventEmitter().sendCustomEvent(r0);
    }
}
