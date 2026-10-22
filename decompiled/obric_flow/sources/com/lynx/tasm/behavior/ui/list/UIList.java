package com.lynx.tasm.behavior.ui.list;

import ai.g0;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import bi.e;
import com.google.android.material.color.utilities.Contrast;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.b0;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.f0;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.behavior.ui.z;
import com.lynx.tasm.behavior.y;
import com.lynx.tasm.featurecount.LynxFeatureCounter;
import com.lynx.tasm.i;
import com.lynx.tasm.ui.image.h;
import com.lynx.tasm.utils.DeviceUtils;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.lynx.tasm.utils.k;
import com.obric.oui.orecyclerview.widget.w0;
import en.b;
import en.d;
import en.f;
import en.g;
import en.j;
import en.l;
import en.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import rn.a;
import s6.c;

/* JADX INFO: loaded from: classes2.dex */
public class UIList extends AbsLynxList<RecyclerView> implements a {
    public static final /* synthetic */ int S = 0;
    public boolean A;
    public int B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public e I;
    public int J;
    public boolean K;
    public GapItemDecoration L;
    public b M;
    public boolean N;
    public boolean O;
    public c7.e P;
    public int Q;
    public boolean R;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UIListAdapter f10509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10510c;
    public String d;
    public boolean e;
    public ListEventManager f;
    public c g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10511h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PagerSnapHelper f10512i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FactoredPagerSnapHelper f10513j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f10514k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f10515l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public g f10516m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ListStickyManager f10517n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public c5.a f10518o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f10519p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f10520q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f10521r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final HashMap f10522t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final HashMap f10523u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ReadableMap f10524v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList f10525w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final HashMap f10526x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ReadableMap f10527y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f10528z;

    public UIList(b0 r5, z r10) {
        super(r5, r10);
        this.f10510c = 1;
        this.d = "single";
        this.e = true;
        this.f10511h = false;
        this.f10514k = true;
        this.f10515l = false;
        this.f10519p = -1;
        this.f10520q = true;
        this.f10521r = false;
        this.s = true;
        this.f10522t = new HashMap();
        this.f10523u = new HashMap();
        this.f10525w = new ArrayList();
        this.f10526x = new HashMap();
        this.A = false;
        this.B = 0;
        this.C = true;
        this.D = false;
        this.E = true;
        this.F = false;
        this.G = false;
        this.H = false;
        this.J = 0;
        this.K = false;
        this.L = null;
        this.M = null;
        this.N = false;
        this.O = false;
        this.P = null;
        this.Q = -1;
        this.R = false;
    }

    @f0
    public void autoScroll(ReadableMap r5, Callback r10) {
        String r11 = r5.getString("rate", "");
        this.A = r5.getBoolean("start", true);
        this.C = r5.getBoolean("autoStop", true);
        if (this.A == false) goto L19;
        int r12 = (int) k.d(r11, 0.0f, 0.0f, this.mContext.f10152u);
        if (r12 != 0) goto L8;
        r10.invoke(new Object[]{1, "rate is not right"});
        return;
    L8:
        LynxContext r13 = getLynxContext();
        if (r13 != null) goto L11;
        float r14 = 60.0f;
    L12:
        int r15 = (int) r14;
        if (r15 > 0) goto L15;
        r15 = 60;
    L15:
        if (r12 <= 0) goto L17;
        int r16 = Math.max(r12 / r15, 1);
    L18:
        this.B = r16;
        l();
        this.P = new c7.e(this, 3);
        Choreographer.getInstance().postFrameCallback(this.P);
    L20:
        r10.invoke(new Object[]{0});
        return;
    L17:
        r16 = Math.min(r12 / r15, -1);
        goto L18
    L11:
        r14 = DeviceUtils.a(r13.a());
        goto L12
    L19:
        l();
        goto L20
    }

    public final /* synthetic */ void b(float r5, float r10) {
        T r11 = this.mView;
        if (r11 != 0) goto L5;
        return;
    L5:
        ((RecyclerView) r11).scrollBy((int) r5, (int) r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean c(int r5) {
        if (this.s == false) goto L7;
        return ((RecyclerView) getView()).canScrollVertically(r5);
    L7:
        return ((RecyclerView) getView()).canScrollHorizontally(r5);
    }

    @Override // rn.a
    public final boolean canConsumeGesture(float r5, float r10) {
        if (isEnableNewGesture() == true) goto L6;
        return false;
    L6:
        if (this.s == false) goto L19;
        if (isAtBorder(true) == false) goto L12;
        if (r10 >= 0.0f) goto L12;
    L16:
        return false;
    L12:
        if (isAtBorder(false) == true) goto L14;
    L17:
        return true;
    L14:
        if (r10 > 0.0f) goto L16;
    L19:
        if (isAtBorder(true) == false) goto L23;
        if (r5 >= 0.0f) goto L23;
    L27:
        return false;
    L23:
        if (isAtBorder(false) == true) goto L25;
    L28:
        return true;
    L25:
        if (r5 > 0.0f) goto L27;
        goto L27
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void consumeGesture(boolean r5) {
        T r10 = this.mView;
        if ((r10 instanceof l) == false) goto L6;
        ((l) r10).getClass();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        l r10 = new l(r5);
        if (r5 != null) goto L5;
    L7:
        r10.setClipToPadding(false);
        r10.setRecycledViewPool(new j());
        this.f = new ListEventManager(getLynxContext().g, r10, this);
        this.f10518o = new c5.a(getLynxContext().g, r10);
        r10.setItemAnimator(null);
        this.f10509b = new UIListAdapter(this);
        this.g = new c(r5, r10);
        r10.setOverScrollMode(2);
        if (k() == false) goto L10;
        LynxFeatureCounter.a(78, this.mContext.A);
    L10:
        return r10;
    L5:
        if ((r5 instanceof LynxContext) == false) goto L7;
        new WeakReference((LynxContext) r5);
        new WeakReference(this);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        if (this.M == null) goto L5;
        ((RecyclerView) getView()).removeOnScrollListener(this.M);
    L5:
        e r5 = this.I;
        if (r5 == null) goto L12;
        ((ArrayList) r5.d).clear();
        ((ArrayList) r5.e).clear();
        UIList r10 = (UIList) r5.f931c;
        if (r10 == null) goto L12;
        if (r10.getView() == 0) goto L12;
        ((RecyclerView) r10.getView()).removeOnScrollListener((b) r5.f);
    L12:
        super.destroy();
        l();
        this.f10522t.clear();
    }

    @c0(defaultBoolean = true, name = "enable-nested-scroll")
    public void enableNestedScroll(boolean r5) {
        T r10 = this.mView;
        if (r10 != 0) goto L5;
        return;
    L5:
        ((RecyclerView) r10).setNestedScrollingEnabled(r5);
    }

    @c0(defaultBoolean = false, name = "enable-rtl")
    public void enableRtl(boolean r5) {
        this.G = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final Rect getBoundRectForOverflow() {
        if (this.R == true) goto L7;
        return super.getBoundRectForOverflow();
    L7:
        return super.getClipBounds();
    }

    @Override // rn.a
    public final int getMemberScrollX() {
        if (this.s == false) goto L7;
        return 0;
    L7:
        return this.f.e;
    }

    @Override // rn.a
    public final int getMemberScrollY() {
        if (this.s == true) goto L5;
        return 0;
    L5:
        return this.f.e;
    }

    @Override // rn.a
    public final int getScrollContainerDirection() {
        if (this.s == false) goto L6;
        return 1;
    L6:
        return -1;
    }

    @f0
    public void getScrollInfo(Callback r5) {
        int r10 = getMemberScrollX();
        int r11 = getMemberScrollY();
        JavaOnlyMap r12 = new JavaOnlyMap();
        r12.putInt("scrollX", i.a.b(this.mContext, r10));
        r12.putInt("scrollY", i.a.b(this.mContext, r11));
        r5.invoke(new Object[]{0, r12});
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final Object getValueFromNativeStorage(String r5) {
        HashMap r10 = this.f10522t;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.get(r5);
    }

    @f0
    public void getVisibleCells(Callback r5) {
        if (r5 != null) goto L5;
        LynxLog.b(2, "UIList", "getVisibleCells with null callback");
        return;
    L5:
        r5.invoke(new Object[]{0, this.f.b()});
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final wm.a hitTest(float r5, float r10) {
        hitTest(r5, r10, false);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int i() {
        RecyclerView.LayoutManager r5 = ((RecyclerView) getView()).getLayoutManager();
        if ((r5 instanceof LinearLayoutManager) == false) goto L7;
        return ((LinearLayoutManager) r5).findFirstVisibleItemPosition();
    L7:
        if ((r5 instanceof StaggeredGridLayoutManager) == false) goto L15;
        int r10 = this.f10510c;
        if (r10 <= 0) goto L18;
        int[] r11 = new int[r10];
        ((StaggeredGridLayoutManager) r5).findFirstVisibleItemPositions(r11);
        int r12 = r11[0];
        int r13 = 1;
    L12:
        if (r13 >= this.f10510c) goto L14;
        r12 = Math.min(r12, r11[r13]);
        r13 = r13 + 1;
        goto L12
    L14:
        return r12;
    L18:
        return -1;
    L15:
        return -1;
    }

    @f0
    public void initCache() {
        e r5 = this.I;
        if (r5 == null) goto L57;
        ((ArrayList) r5.d).clear();
        ((ArrayList) r5.e).clear();
        e r15 = this.I;
        UIList r10 = (UIList) r15.f931c;
        if (r10 == null) goto L70;
        UIListAdapter r11 = r10.f10509b;
        if (r11 == null) goto L72;
        JavaOnlyArray r12 = r11.f10541q;
        HashMap r13 = r11.f10542r;
        if (r12 == null) goto L71;
        if (r13 == null) goto L73;
        int r14 = r10.i();
        UIList r16 = (UIList) r15.f931c;
        int r17 = r16.j();
        ((ArrayList) r15.e).clear();
        ((ArrayList) r15.d).clear();
        int r18 = 1;
    L15:
        if (r18 > r15.f930b) goto L74;
        i r19 = r16.f10502a;
        if (r14 == (-1)) goto L37;
        int r20 = r14 - r18;
        if (r20 < 0) goto L37;
        if (r20 >= r12.size()) goto L37;
        if (r15.b(r12.getString(r20)) == true) goto L37;
        UIListAdapter r110 = r16.f10509b;
        long r111 = ((long) r110.f10531c.getSign()) << 32;
        int r112 = r110.f10540p;
        r110.f10540p = r112 + 1;
        long r113 = r111 + ((long) r112);
        if (r16 == null) goto L37;
        UIListAdapter r114 = r16.f10509b;
        if (r114 == null) goto L37;
        JavaOnlyArray r115 = r114.f10541q;
        if (r115 == null) goto L37;
        int r116 = r115.size() - 1;
        if (r20 < 0) goto L37;
        if (r20 > r116) goto L37;
        int r117 = r16.getSign();
        LynxTemplateRender r118 = (LynxTemplateRender) r19.f10879a;
        if (r118 == null) goto L37;
        r118.i(r117, r113, r20);
    L37:
        if (r17 == (-1)) goto L56;
        int r21 = r17 + r18;
        if (r21 >= r12.size()) goto L56;
        if (r21 < 0) goto L56;
        if (r15.b(r12.getString(r21)) == true) goto L56;
        UIListAdapter r22 = r16.f10509b;
        long r119 = ((long) r22.f10531c.getSign()) << 32;
        int r23 = r22.f10540p;
        r22.f10540p = r23 + 1;
        long r120 = r119 + ((long) r23);
        if (r16 == null) goto L56;
        UIListAdapter r24 = r16.f10509b;
        if (r24 == null) goto L56;
        JavaOnlyArray r25 = r24.f10541q;
        if (r25 == null) goto L56;
        int r26 = r25.size() - 1;
        if (r21 < 0) goto L56;
        if (r21 > r26) goto L56;
        int r27 = r16.getSign();
        LynxTemplateRender r28 = (LynxTemplateRender) r19.f10879a;
        if (r28 == null) goto L56;
        r28.i(r27, r120, r21);
    L56:
        r18 = r18 + 1;
        goto L15
    L74:
        return;
    L73:
        return;
    L71:
        return;
    L72:
        return;
    L70:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean initialPropsFlushed(String r5, String r10) {
        if (this.f10522t == null) goto L10;
        HashSet r11 = (HashSet) this.f10523u.get(r5);
        if (r11 != null) goto L7;
        return false;
    L7:
        if (r11.contains(r5) == false) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void interceptGesture(boolean r5) {
        T r10 = this.mView;
        if ((r10 instanceof l) == false) goto L6;
        ((l) r10).getClass();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isAccessibilityDirectionVertical() {
        return this.s;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isAccessibilityHostUI() {
        return true;
    }

    @Override // rn.a
    public final boolean isAtBorder(boolean r5) {
        if (isEnableNewGesture() == true) goto L7;
        return false;
    L7:
        if (r5 == false) goto L11;
        boolean r10 = c(-1);
    L10:
        return !r10;
    L11:
        r10 = c(1);
        goto L10
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isScrollContainer() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int j() {
        RecyclerView.LayoutManager r5 = ((RecyclerView) getView()).getLayoutManager();
        if ((r5 instanceof LinearLayoutManager) == true) goto L5;
        int r10 = -1;
        if ((r5 instanceof StaggeredGridLayoutManager) == false) goto L14;
        int r11 = this.f10510c;
        if (r11 <= 0) goto L14;
        int[] r12 = new int[r11];
        ((StaggeredGridLayoutManager) r5).findLastVisibleItemPositions(r12);
        int r13 = 0;
    L12:
        if (r13 >= this.f10510c) goto L14;
        r10 = Math.max(r10, r12[r13]);
        r13 = r13 + 1;
    L14:
        return r10;
    L5:
        return ((LinearLayoutManager) r5).findLastVisibleItemPosition();
    }

    public final boolean k() {
        LynxContext r5 = this.mContext;
        if (r5 != null) goto L5;
    L15:
        return false;
    L5:
        if (r5.k() == null) goto L15;
        ThreadStrategyForRendering r10 = this.mContext.k().getThreadStrategyForRendering();
        if (r10 != ThreadStrategyForRendering.f10066c) goto L10;
        return true;
    L10:
        if (r10 == ThreadStrategyForRendering.e) goto L16;
        return false;
    L16:
        return true;
    }

    public final void l() {
        if (this.P == null) goto L6;
        Choreographer.getInstance().removeFrameCallback(this.P);
        this.P = null;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void layout() {
        TraceEvent.c("UIList.layout");
        View r5 = this.f10516m;
        if (r5 != null) goto L7;
        r5 = (RecyclerView) this.mView;
    L7:
        if (r5.isLayoutRequested() == true) goto L10;
        TraceEvent.a(0, "UIList.layout");
        return;
    L10:
        layoutChildren();
        g r10 = this.f10516m;
        if (r10 == null) goto L13;
        r10.layout(getLeft(), getTop(), getWidth() + getLeft(), getHeight() + getTop());
    L15:
        if (this.R == false) goto L36;
        View r11 = this.f10516m;
        if (r11 == null) goto L20;
    L19:
        ViewParent r12 = r11.getParent();
        if (getOverflow() == 0) goto L24;
        boolean r13 = true;
    L25:
        if (r13 == true) goto L27;
    L29:
        if (r13 == false) goto L34;
        g r14 = this.f10516m;
        if (r14 == null) goto L34;
        r14.setClipChildren(false);
    L34:
        if (this.mOverflow == 0) goto L36;
        ((RecyclerView) this.mView).setOverScrollMode(2);
        goto L36
    L27:
        if ((r12 instanceof ViewGroup) == false) goto L29;
        ((ViewGroup) r12).setClipChildren(false);
        goto L29
    L24:
        r13 = false;
        goto L25
    L20:
        r11 = (RecyclerView) this.mView;
    L36:
        ViewCompat.setClipBounds(this.mView, getBoundRectForOverflow());
        ((en.c) this.f10518o.d).a();
        TraceEvent.a(0, "UIList.layout");
        return;
    L13:
        ((RecyclerView) this.mView).layout(getLeft(), getTop(), getWidth() + getLeft(), getHeight() + getTop());
        goto L15
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void layoutChildren() {
        if (this.D == true) goto L5;
    L7:
        super.layoutChildren();
        return;
    L5:
        if (this.f10516m == null) goto L7;
        this.f10517n.f10508c.getClass();
        this.f10517n.d.getClass();
        goto L7
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void measure() {
        TraceEvent.c("UIList.measure");
        View r5 = this.f10516m;
        if (r5 != null) goto L7;
        r5 = (RecyclerView) this.mView;
    L7:
        if (r5.isLayoutRequested() == true) goto L10;
        TraceEvent.a(0, "UIList.measure");
        return;
    L10:
        measureChildren();
        setLayoutParamsInternal();
        int r10 = View.MeasureSpec.makeMeasureSpec(getWidth(), BasicMeasure.EXACTLY);
        if (this.f10511h == false) goto L13;
        int r11 = View.MeasureSpec.makeMeasureSpec((int) this.mMaxHeight, Integer.MIN_VALUE);
    L14:
        g r12 = this.f10516m;
        if (r12 == null) goto L17;
        r12.measure(r10, r11);
    L17:
        ((RecyclerView) this.mView).measure(r10, r11);
        this.f10509b.e = true;
        TraceEvent.a(0, "UIList.measure");
        return;
    L13:
        r11 = View.MeasureSpec.makeMeasureSpec(getHeight(), BasicMeasure.EXACTLY);
        goto L14
    }

    @Override // rn.a
    public final void onGestureScrollBy(float r5, float r10) {
        if (isEnableNewGesture() == true) goto L5;
        return;
    L5:
        com.lynx.tasm.utils.j.f(new en.i(this, r5, r10, 0));
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList, com.lynx.tasm.behavior.ui.UIGroup
    public final void onInsertChild(LynxBaseUI r5, int r10) {
    }

    @Override // rn.a
    public final void onInvalidate() {
        if (isEnableNewGesture() == false) goto L9;
        T r5 = this.mView;
        if (r5 == 0) goto L10;
        ViewCompat.postInvalidateOnAnimation(r5);
        return;
    L10:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutFinish(long r10, LynxBaseUI r11) {
        if (k() == true) goto L5;
        UIListAdapter r12 = this.f10509b;
        r12.getClass();
        if (r12.f == false) goto L59;
        return;
    L59:
        if (r12.f10530b.remove(Long.valueOf(r10)) != null) goto L62;
        return;
    L62:
        throw new ClassCastException();
    L5:
        if ((r11 instanceof UIComponent) == false) goto L53;
        UIListAdapter r13 = this.f10509b;
        UIComponent r14 = (UIComponent) r11;
        if (r13.f10530b.get(Long.valueOf(r10)) != null) goto L52;
        UIList r15 = r13.f10531c;
        if (r15.H == false) goto L20;
        if (r14 == null) goto L20;
        if (TextUtils.isEmpty(r14.f10770b) == true) goto L20;
        if (r15.s == false) goto L17;
        int r16 = r14.getHeight();
    L18:
        r13.f10545v.put(r14.f10770b, Integer.valueOf(r16));
        goto L20
    L17:
        r16 = r14.getWidth();
    L20:
        if (r15.I == null) goto L49;
        int r17 = r15.i();
        int r5 = r15.j();
        HashMap r18 = r13.f10542r;
        if (r18 != null) goto L24;
    L48:
        r13.b(r14);
        return;
    L24:
        if (r18.containsKey(r14.f10770b) == false) goto L48;
        int r19 = ((Integer) r13.f10542r.get(r14.f10770b)).intValue();
        if (r17 == (-1)) goto L30;
        if (r19 > r17) goto L30;
        boolean r20 = true;
    L31:
        if (r20 == true) goto L35;
        if (r5 == (-1)) goto L35;
        if (r19 < r5) goto L35;
        boolean r21 = true;
    L36:
        int r22 = r15.J;
        if (r19 >= (r17 - r22)) goto L39;
        return;
    L39:
        if (r19 > (r5 + r22)) goto L64;
        if (r20 == true) goto L42;
        if (r21 == true) goto L46;
        return;
    L46:
        if (r15.I.b(r14.f10770b) == true) goto L68;
        r15.I.a(r14, false);
        return;
    L68:
        return;
    L42:
        if (r15.I.b(r14.f10770b) == true) goto L65;
        r15.I.a(r14, true);
        return;
    L65:
        return;
    L64:
        return;
    L35:
        r21 = false;
    L30:
        r20 = false;
        goto L31
    L49:
        r13.b(r14);
        return;
    L52:
        throw new ClassCastException();
    L53:
        LynxLog.b(4, "UIList", "component is null! the operationId is " + r10);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        int r5 = this.mPaddingTop + this.mBorderTopWidth;
        int r10 = this.mPaddingBottom + this.mBorderBottomWidth;
        int r11 = this.mPaddingLeft + this.mBorderLeftWidth;
        int r12 = this.mPaddingRight + this.mBorderRightWidth;
        if (1 != ((RecyclerView) this.mView).getLayoutDirection()) goto L6;
        ((RecyclerView) this.mView).setPadding(r12, r5, r11, r10);
        return;
    L6:
        ((RecyclerView) this.mView).setPadding(r11, r5, r12, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onPropsUpdated() {
        UIList r5 = this;
        super.onPropsUpdated();
        if (r5.f10515l == false) goto L7;
        r5.f10515l = false;
        return;
    L7:
        if (((RecyclerView) r5.mView).getAdapter() != null) goto L10;
        ((RecyclerView) r5.mView).setAdapter(r5.f10509b);
    L10:
        if (k() == true) goto L12;
        boolean r10 = true;
    L16:
        if (r10 == true) goto L25;
        LynxContext r11 = r5.mContext;
        if (r11 != null) goto L20;
        return;
    L20:
        if (r11.k() == null) goto L301;
        r5.mContext.b(new LynxError(220207, "Multi thread strategy can not be used by default.", "Please set the attribute of enable-async-list to true at LynxSDK 2.10+ .", "error"));
        return;
    L301:
        return;
    L25:
        if (r5.f10528z == false) goto L178;
        r5.f10509b.f = k();
        int r12 = r5.Q;
        if (r12 < 0) goto L34;
        JavaOnlyArray r13 = r5.f10509b.g;
        if (r13 == null) goto L31;
        int r14 = r13.size();
    L32:
        if (r12 >= r14) goto L34;
        ((RecyclerView) getView()).scrollToPosition(r5.Q);
        r5.Q = -1;
        goto L34
    L31:
        r14 = 0;
    L34:
        ReadableMap r15 = r5.f10527y;
        if (r15 == null) goto L161;
        UIListAdapter r16 = r5.f10509b;
        r16.d = true;
        ReadableArray r17 = r15.getArray("updateAction");
        ReadableArray r18 = r15.getArray("insertAction");
        ReadableArray r19 = r15.getArray("removeAction");
        if (r17 != null) goto L42;
        if (r18 != null) goto L42;
        if (r19 != null) goto L42;
        ReadableMap r20 = null;
    L159:
        r5.f10527y = r20;
    L184:
        if (r5.e == false) goto L216;
        UIListAdapter r21 = r5.f10509b;
        r21.f10544u.clear();
        int r22 = 0;
    L187:
        if (r22 >= r21.f10531c.f10510c) goto L189;
        r21.f10544u.add(new HashMap());
        r22 = r22 + 1;
        goto L187
    L189:
        new WeakReference(r5);
        if (TextUtils.equals(r5.d, "single") == false) goto L196;
        ListLayoutManager$ListLinearLayoutManager r23 = new ListLayoutManager$ListLinearLayoutManager(r5.mContext);
        r23.setOrientation(r5.s ? 1 : 0);
        RecyclerView.LayoutManager r24 = r23;
        if (r5.E == true) goto L194;
        r23.setInitialPrefetchItemCount(0);
        r24 = r23;
    L194:
        int r25 = 1;
        RecyclerView.LayoutManager r26 = r24;
    L204:
        ListStickyManager r27 = r5.f10517n;
        if (r27 == null) goto L208;
        r27.f10508c.getClass();
        r27.d.getClass();
    L208:
        if (r5.E == true) goto L211;
        if (r26 == null) goto L211;
        boolean r28 = false;
        r26.setItemPrefetchEnabled(false);
    L213:
        if (r5.I == null) goto L215;
        ((RecyclerView) r5.mView).setItemViewCacheSize(r28 ? 1 : 0);
    L215:
        ((RecyclerView) r5.mView).setLayoutManager(r26);
    L217:
        r5.e = r28;
        if ((((RecyclerView) r5.mView).getLayoutManager() instanceof ListLayoutManager$ListLinearLayoutManager) == false) goto L223;
        ListLayoutManager$ListLinearLayoutManager r29 = (ListLayoutManager$ListLinearLayoutManager) ((RecyclerView) r5.mView).getLayoutManager();
        boolean r30 = r29.getStackFromEnd();
        boolean r31 = r5.N;
        if (r30 == r31) goto L223;
        r29.setStackFromEnd(r31);
    L223:
        if ((((RecyclerView) r5.mView).getLayoutManager() instanceof GridLayoutManager) == false) goto L226;
        ((GridLayoutManager) ((RecyclerView) r5.mView).getLayoutManager()).setSpanSizeLookup(new en.k());
    L226:
        if (r5.G == true) goto L228;
    L230:
        int r32 = 0;
    L231:
        ((RecyclerView) r5.mView).setLayoutDirection(r32);
        JavaOnlyArray r33 = r5.f10509b.g;
        if (r33 != null) goto L234;
        int r34 = 0;
    L235:
        int r35 = r5.f10519p;
        if (r34 > r35) goto L238;
    L240:
        int r36 = 0;
    L241:
        LynxLog.b(2, "UIList", "onPropsUpdated viewNames " + r34);
        if ((r5.f.f10505c & 16) == 0) goto L244;
        int r37 = r25;
    L245:
        if (r37 != 0) goto L247;
    L249:
        ListStickyManager r38 = r5.f10517n;
        if (r38 == null) goto L252;
        r38.d.getClass();
        r38.f10508c.getClass();
        r5.f10517n.e = r5.f10520q;
    L252:
        ((w0) r5.g.f21829c).e = r5.s;
        T r39 = r5.mView;
        if (r39 != 0) goto L255;
    L269:
        LynxLog.b(4, "UIList", "Fail to update gap item decoration because mView == null or LayoutManager == null");
        return;
    L255:
        if (((RecyclerView) r39).getLayoutManager() == null) goto L269;
        if (r5.K == true) goto L260;
        GapItemDecoration r40 = r5.L;
        if (r40 == null) goto L303;
        ((RecyclerView) r5.mView).removeItemDecoration(r40);
        return;
    L303:
        return;
    L260:
        if (r5.L != null) goto L262;
        GapItemDecoration r41 = new GapItemDecoration();
        r5.L = r41;
        ((RecyclerView) r5.mView).addItemDecoration(r41);
    L262:
        r5.L.getClass();
        GapItemDecoration r42 = r5.L;
        if (r5.G == false) goto L265;
        isRtl();
    L265:
        r42.getClass();
        r5.L.getClass();
        r5.L.getClass();
        r5.L.getClass();
        ((RecyclerView) r5.mView).invalidateItemDecorations();
        return;
    L247:
        if (r5.O == false) goto L249;
        ((RecyclerView) r5.mView).isLayoutRequested();
        goto L249
    L244:
        r37 = r36;
        goto L245
    L238:
        if (r35 <= (-1)) goto L240;
        r36 = 0;
        r5.g.e(r35, 0, null);
        r5.f10519p = -1;
        goto L241
    L234:
        r34 = r33.size();
        goto L235
    L228:
        if (isRtl() == false) goto L230;
        r32 = r25;
    L211:
        r28 = false;
        goto L213
    L196:
        if (TextUtils.equals(r5.d, "flow") == false) goto L201;
        ListLayoutManager$ListGridLayoutManager r43 = new ListLayoutManager$ListGridLayoutManager(r5.mContext, r5.f10510c);
        r43.setOrientation(r5.s ? 1 : 0);
        r24 = r43;
        if (r5.E == true) goto L194;
        r43.setInitialPrefetchItemCount(0);
        r24 = r43;
        goto L194
    L201:
        if (TextUtils.equals(r5.d, "waterfall") == false) goto L203;
        r25 = 1;
        en.e r44 = new en.e(r5.f10510c, 1);
        r44.setOrientation(r5.s ? 1 : 0);
        r26 = r44;
        goto L204
    L203:
        r25 = 1;
        r26 = null;
        goto L204
    L216:
        r28 = false;
        r25 = 1;
    L42:
        if (r16.f10541q != null) goto L45;
        r16.f10541q = new JavaOnlyArray();
    L45:
        if (r16.g != null) goto L48;
        r16.g = new JavaOnlyArray();
    L48:
        if (r16.f10532h != null) goto L51;
        r16.f10532h = new JavaOnlyArray();
    L51:
        if (r16.f10536l != null) goto L54;
        r16.f10536l = new JavaOnlyArray();
    L54:
        if (r16.f10537m != null) goto L57;
        r16.f10537m = new JavaOnlyArray();
    L57:
        if (r16.f10533i != null) goto L60;
        r16.f10533i = new JavaOnlyArray();
    L60:
        if (r16.f10538n != null) goto L63;
        r16.f10538n = new JavaOnlyArray();
    L63:
        if (r16.f10534j != null) goto L66;
        r16.f10534j = new JavaOnlyArray();
    L66:
        if (r16.f10535k != null) goto L68;
        r16.f10535k = new JavaOnlyArray();
    L68:
        g0 r110 = r16.f10539o;
        r110.getClass();
        UIListAdapter r111 = (UIListAdapter) r110.g;
        if (r19 == null) goto L77;
        int r112 = r19.size() - 1;
    L71:
        if (r112 < 0) goto L77;
        int r113 = r19.getInt(r112);
        if (r113 < 0) goto L76;
        r111.f10541q.remove(r113);
        r111.g.remove(r113);
        r111.f10535k.remove(r113);
        r111.f10536l.remove(r113);
        r111.f10537m.remove(r113);
        r111.f10538n.remove(r113);
    L76:
        r112 = r112 - 1;
    L77:
        String r114 = "type";
        String r45 = "item-key";
        String r46 = "position";
        if (r18 == null) goto L90;
        int r47 = 0;
    L81:
        if (r47 >= r18.size()) goto L90;
        ReadableMap r48 = r18.getMap(r47);
        if (r48 == null) goto L89;
        int r49 = r48.getInt(r46);
        String r50 = r48.getString("item-key");
        String r51 = r48.getString("type");
        boolean r115 = r48.getBoolean("full-span", false);
        boolean r210 = r48.getBoolean("sticky-top", false);
        boolean r211 = r48.getBoolean("sticky-bottom", false);
        int r52 = r48.getInt("estimated-height-px", -1);
        r111.f10541q.add(r49, r50);
        r111.g.add(r49, r51);
        HashMap r53 = r111.f10529a;
        if (r53.containsKey(r51) == true) goto L88;
        r53.put(r51, Integer.valueOf(r53.size()));
    L88:
        r111.f10536l.add(r49, Boolean.valueOf(r115));
        r111.f10537m.add(r49, Boolean.valueOf(r210));
        r111.f10538n.add(r49, Boolean.valueOf(r211));
        r111.f10535k.add(r49, Integer.valueOf(r52));
    L89:
        r47 = r47 + 1;
        r46 = r46;
        r18 = r18;
        r19 = r19;
    L90:
        String r116 = r46;
        ReadableArray r117 = r18;
        ReadableArray r118 = r19;
        if (r17 == null) goto L103;
        int r54 = 0;
    L94:
        if (r54 >= r17.size()) goto L103;
        ReadableMap r55 = r17.getMap(r54);
        if (r55 == null) goto L102;
        int r56 = r55.getInt("from");
        r55.getInt("to");
        String r57 = r55.getString(r45);
        String r58 = r55.getString(r114);
        boolean r212 = r55.getBoolean("full-span", false);
        boolean r213 = r55.getBoolean("sticky-top", false);
        boolean r214 = r55.getBoolean("sticky-bottom", false);
        int r59 = r55.getInt("estimated-height-px", -1);
        r111.f10541q.set(r56, r57);
        r111.g.set(r56, r58);
        HashMap r60 = r111.f10529a;
        if (r60.containsKey(r58) == true) goto L101;
        r60.put(r58, Integer.valueOf(r60.size()));
    L101:
        r111.f10536l.set(r56, Boolean.valueOf(r212));
        r111.f10537m.set(r56, Boolean.valueOf(r213));
        r111.f10538n.set(r56, Boolean.valueOf(r214));
        r111.f10535k.set(r56, Integer.valueOf(r59));
    L102:
        r54 = r54 + 1;
        r45 = r45;
        r114 = r114;
    L103:
        r111.f10532h.clear();
        int r61 = 0;
    L105:
        if (r61 >= r111.f10536l.size()) goto L110;
        if (r111.f10536l.getBoolean(r61) == false) goto L109;
        r111.f10532h.add(Integer.valueOf(r61));
    L109:
        r61 = r61 + 1;
        goto L105
    L110:
        r111.f10533i.clear();
        int r62 = 0;
    L112:
        if (r62 >= r111.f10537m.size()) goto L117;
        if (r111.f10537m.getBoolean(r62) == false) goto L116;
        r111.f10533i.add(Integer.valueOf(r62));
    L116:
        r62 = r62 + 1;
        goto L112
    L117:
        r111.f10534j.clear();
        int r63 = 0;
    L119:
        if (r63 >= r111.f10538n.size()) goto L125;
        if (r111.f10538n.getBoolean(r63) == false) goto L123;
        r111.f10534j.add(Integer.valueOf(r63));
    L123:
        r63 = r63 + 1;
        goto L119
    L125:
        if (r15.getBoolean("reloadAll", false) == false) goto L131;
        boolean r64 = r16.c();
        m r65 = r16.f10543t;
        if (r64 == false) goto L130;
        com.lynx.tasm.utils.j.a().post(r65);
    L129:
        r20 = null;
        r5 = this;
        goto L159
    L130:
        r65.run();
        goto L129
    L131:
        if (r118 == null) goto L139;
        int r66 = r118.size() - 1;
    L133:
        if (r66 < 0) goto L139;
        ReadableArray r67 = r118;
        int r68 = r67.getInt(r66);
        if (r68 < 0) goto L138;
        r111.notifyItemRemoved(r68);
    L138:
        r66 = r66 - 1;
        r118 = r67;
    L139:
        if (r117 == null) goto L148;
        int r69 = 0;
    L142:
        if (r69 >= r117.size()) goto L148;
        ReadableArray r70 = r117;
        ReadableMap r71 = r70.getMap(r69);
        if (r71 != null) goto L146;
        String r72 = r116;
    L147:
        r69 = r69 + 1;
        r117 = r70;
        r116 = r72;
        goto L142
    L146:
        r72 = r116;
        r111.notifyItemInserted(r71.getInt(r72));
    L148:
        if (r17 == null) goto L129;
        int r73 = 0;
    L151:
        if (r73 >= r17.size()) goto L129;
        ReadableMap r74 = r17.getMap(r73);
        if (r74 == null) goto L158;
        int r75 = r74.getInt("from");
        int r76 = r74.getInt("to");
        if (r74.getBoolean("flush", false) == false) goto L158;
        r111.notifyItemChanged(r75, Integer.valueOf(r76));
    L158:
        r73 = r73 + 1;
        goto L151
    L161:
        if (r5.f10524v == null) goto L184;
        if (r5.J > 0) goto L165;
    L177:
        r5.f10509b.a((JavaOnlyMap) r5.f10524v);
        r5.f10524v = null;
        goto L184
    L165:
        if (k() == false) goto L177;
        if (r5.I != null) goto L170;
        r5.I = new e(r5, r5.J);
    L170:
        if (r5.J > 0) goto L172;
        e r77 = r5.I;
        if (r77 == null) goto L177;
        ((ArrayList) r77.d).clear();
        ((ArrayList) r77.e).clear();
        goto L177
    L172:
        if (r5.M != null) goto L177;
        r5.M = new b();
        ((RecyclerView) getView()).addOnScrollListener(r5.M);
        goto L177
    L178:
        UIListAdapter r78 = r5.f10509b;
        int r79 = getSign();
        LynxTemplateRender r80 = (LynxTemplateRender) r5.f10502a.f10879a;
        if (r80 == null) goto L181;
        JavaOnlyMap r81 = r80.Q(r79);
    L182:
        r78.a(r81);
        goto L184
    L181:
        r81 = null;
        goto L182
    L12:
        if (r5.f10528z == false) goto L14;
        r10 = r5.F;
        goto L16
    L14:
        r10 = false;
        goto L16
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void removeKeyFromNativeStorage(String r5) {
        HashMap r10 = this.f10522t;
        if (r10 == null) goto L6;
        r10.remove(r5);
        return;
    }

    @f0
    public void removeStickyView() {
        ListStickyManager r5 = this.f10517n;
        if (r5 == null) goto L6;
        r5.f10508c.getClass();
        r5.d.getClass();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean requestChildUIRectangleOnScreen(LynxBaseUI r5, Rect r10, boolean r11) {
        if (this.f10514k == true) goto L5;
    L10:
        return false;
    L5:
        if ((r5 instanceof UIComponent) == false) goto L10;
        UIComponent r12 = (UIComponent) r5;
        if (r12.getView() == 0) goto L10;
        ((com.lynx.tasm.behavior.ui.view.b) r12.getView()).getParent();
        goto L10
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.ui.a0
    public final void requestLayout() {
        ((RecyclerView) this.mView).requestLayout();
        if (((RecyclerView) this.mView).isLayoutRequested() == true) goto L6;
        T r5 = this.mView;
        ((RecyclerView) r5).post(new h(r5, 15));
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final float[] scrollBy(float r10, float r11) {
        float[] r5 = new float[4];
        ((RecyclerView) this.mView).scrollBy((int) r10, (int) r11);
        if (Math.abs(r10) <= Float.MIN_VALUE) goto L5;
    L6:
        recognizeGesturere();
    L8:
        if ((((RecyclerView) this.mView).getLayoutManager() instanceof d) == true) goto L10;
        r5[0] = 0.0f;
        r5[1] = 0.0f;
        r5[2] = r10;
        r5[3] = r11;
        return r5;
    L10:
        if (this.s == false) goto L13;
        r5[0] = 0.0f;
        ((d) ((RecyclerView) this.mView).getLayoutManager()).getClass();
        r5[1] = 0.0f;
        r5[2] = r10;
        r5[3] = r11 - 0.0f;
        return r5;
    L13:
        ((d) ((RecyclerView) this.mView).getLayoutManager()).getClass();
        r5[0] = 0.0f;
        r5[1] = 0.0f;
        r5[2] = r10 - 0.0f;
        r5[3] = r11;
        return r5;
    L5:
        if (Math.abs(r11) <= Float.MIN_VALUE) goto L8;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f0
    public void scrollToPosition(ReadableMap r10, Callback r11) {
        if (this.f10509b != null) goto L6;
        r11.invoke(new Object[]{1, "scrollToPosition before init"});
        return;
    L6:
        int r5 = r10.getInt("index", r10.getInt("position", 0));
        int r12 = (int) com.lynx.tasm.utils.g.a((float) r10.getDouble("offset", 0.0d), 0.0f);
        boolean r13 = r10.getBoolean("smooth", false);
        int r14 = (int) com.lynx.tasm.utils.g.a((float) r10.getDouble("itemHeight", 0.0d), 0.0f);
        String r15 = "none";
        String r16 = r10.getString("alignTo", "none");
        if (r5 < 0) goto L43;
        JavaOnlyArray r17 = this.f10509b.g;
        if (r17 == null) goto L11;
        int r18 = r17.size();
    L12:
        if (r5 > r18) goto L43;
        if (r13 == false) goto L35;
        c r19 = this.g;
        r19.getClass();
        StringBuilder r20 = new StringBuilder("ListScroller scrollToPositionSmoothly: position=");
        r20.append(r5);
        r20.append(", offset=");
        r20.append(r12);
        r20.append(", alignTo: ");
        if (r16 == null) goto L19;
        r15 = r16;
    L19:
        com.lynx.tasm.behavior.ui.utils.e.i(r20, r15, 2, "UIList");
        w0 r21 = (w0) r19.f21829c;
        RecyclerView r22 = (RecyclerView) ((WeakReference) r21.f).get();
        if (r22 != null) goto L22;
    L32:
        r21.d = false;
        r11.invoke(new Object[]{4, "can not scroll before init"});
        return;
    L22:
        if (r22.getLayoutManager() == null) goto L32;
        if (r22.getChildCount() == 0) goto L32;
        if (r22.isAttachedToWindow() == true) goto L29;
        r21.d = false;
        LynxLog.b(4, "UIList", "ListScroller start: early return due to view is not attached to window.");
        r11.invoke(new Object[]{7, "can not invoke scroll when the view is not attached to window."});
        return;
    L29:
        r21.g = r11;
        r21.f13926b = r5;
        if (r21.d == true) goto L46;
        r21.d = true;
        r22.stopScroll();
        r22.stopNestedScroll();
        r22.addOnItemTouchListener((f) r21.f13928h);
        r22.post(r21);
        return;
    L46:
        return;
    L35:
        if (TextUtils.equals(r16, "middle") == false) goto L39;
        int r110 = (((RecyclerView) getView()).getHeight() - r14) / 2;
    L37:
        r12 = r12 + r110;
    L41:
        this.g.e(r5, r12, r11);
        ((RecyclerView) this.mView).post(new h(this, 16));
        return;
    L39:
        if (TextUtils.equals(r16, "bottom") == false) goto L41;
        r110 = ((RecyclerView) getView()).getHeight() - r14;
        goto L37
    L11:
        r18 = 0;
    L43:
        r11.invoke(new Object[]{4, "position < 0 or position >= data count"});
    }

    @c0(defaultBoolean = false, name = "android-ignore-attach-for-binding")
    public void setAndroidIgnoreAttachForBinding(boolean r5) {
    }

    @c0(customType = "false", name = "auto-measure")
    public void setAutoMeasure(pm.a r5) {
        this.f10511h = ListEventManager.c(r5, false);
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setCacheQueueRatio(pm.a r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setColumnCount(int r5) {
        if (this.f10510c == r5) goto L14;
        this.f10510c = r5;
        RecyclerView.LayoutManager r10 = ((RecyclerView) this.mView).getLayoutManager();
        if ((r10 instanceof GridLayoutManager) == false) goto L10;
        ((GridLayoutManager) r10).setSpanCount(this.f10510c);
        return;
    L10:
        if ((r10 instanceof StaggeredGridLayoutManager) == false) goto L13;
        ((StaggeredGridLayoutManager) r10).setSpanCount(this.f10510c);
        return;
    L13:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setComponentInitMeasure(boolean r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setCrossAxisGap(float r5) {
        Math.round(r5);
        RecyclerView.LayoutManager r10 = ((RecyclerView) this.mView).getLayoutManager();
        if ((r10 instanceof ListLayoutManager$ListGridLayoutManager) == false) goto L7;
        ((ListLayoutManager$ListGridLayoutManager) r10).getClass();
        return;
    L7:
        if ((r10 instanceof en.e) == false) goto L10;
        ((en.e) r10).getClass();
        return;
    }

    @c0(customType = "true", name = "android-diffable")
    public void setDiffable(pm.a r5) {
        if (((RecyclerView) this.mView).getAdapter() != null) goto L6;
        this.f10509b.setHasStableIds(!ListEventManager.c(r5, true));
        return;
    }

    @c0(defaultBoolean = false, name = "enable-async-list")
    public void setEnableAsyncList(boolean r5) {
        this.F = r5;
    }

    @c0(defaultBoolean = false, name = "enable-disappear")
    public void setEnableDisappear(boolean r5) {
        en.c r10 = (en.c) this.f10518o.d;
        if ((r10 instanceof en.a) == false) goto L6;
        ((en.a) r10).getClass();
        return;
    }

    @c0(defaultBoolean = true, name = "android-enable-focus-search")
    public void setEnableFocusSearch(boolean r5) {
    }

    @c0(defaultBoolean = false, name = "android-enable-gap-item-decoration")
    public void setEnableGapItemDecoration(boolean r5) {
        this.K = r5;
    }

    @c0(defaultBoolean = true, name = "android-enable-item-prefetch")
    public void setEnableItemPrefetch(boolean r5) {
        this.E = r5;
    }

    @c0(defaultBoolean = false, name = "android-enable-overflow")
    public void setEnableOverflow(boolean r5) {
        this.R = r5;
        T r10 = this.mView;
        if ((r10 instanceof l) == false) goto L6;
        ((l) r10).getClass();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setEnablePagerSnap(pm.a r5) {
        if (ListEventManager.c(r5, false) == true) goto L5;
    L11:
        PagerSnapHelper r10 = this.f10512i;
        if (r10 == null) goto L15;
        r10.attachToRecyclerView(null);
        this.f10512i = null;
        return;
    L15:
        return;
    L5:
        if (this.f10513j != null) goto L11;
        if (this.f10512i != null) goto L9;
        this.f10512i = new PagerSnapHelper();
    L9:
        this.f10512i.attachToRecyclerView((RecyclerView) this.mView);
    }

    @c0(defaultBoolean = false, name = "enable-size-cache")
    public void setEnableSizeCache(boolean r5) {
        this.H = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setEnableSticky(pm.a r5) {
        if (ListEventManager.c(r5, false) == true) goto L5;
        return;
    L5:
        if (this.f10516m != null) goto L9;
        ListStickyManager r10 = new ListStickyManager(this);
        this.f10517n = r10;
        this.f10516m = r10.f10507b;
        return;
    }

    @c0(defaultBoolean = false, name = "android-enable-strict-scrollable")
    public void setEnableStrictScrollable(boolean r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map r5) {
        super.setEvents(r5);
        ListEventManager r10 = this.f;
        r10.f10505c = 0;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.containsKey("scroll") == false) goto L8;
        int r11 = r10.f10505c | 1;
    L9:
        r10.f10505c = r11;
        if (r5.containsKey("scrolltoupper") == false) goto L12;
        int r12 = r10.f10505c | 2;
    L13:
        r10.f10505c = r12;
        if (r5.containsKey("scrolltolower") == false) goto L16;
        int r13 = r10.f10505c | 4;
    L17:
        r10.f10505c = r13;
        if (r5.containsKey("scrollstatechange") == false) goto L20;
        int r14 = r10.f10505c | 8;
    L21:
        r10.f10505c = r14;
        if (r5.containsKey("layoutcomplete") == false) goto L24;
        int r15 = r10.f10505c | 16;
    L25:
        r10.f10505c = r15;
        return;
    L24:
        r15 = r10.f10505c;
        goto L25
    L20:
        r14 = r10.f10505c;
        goto L21
    L16:
        r13 = r10.f10505c;
        goto L17
    L12:
        r12 = r10.f10505c;
        goto L13
    L8:
        r11 = r10.f10505c;
        goto L9
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setInitialPropsHasFlushed(String r5, String r10) {
        HashMap r11 = this.f10522t;
        if (r11 == null) goto L6;
        HashSet r12 = (HashSet) this.f10523u.getOrDefault(r10, new HashSet());
        r12.add(r5);
        r11.put(r10, r12);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setInitialScrollIndex(pm.a r5) {
        this.f10519p = ListEventManager.a(r5, -1);
    }

    @c0(defaultInt = 0, name = "item-holder-type")
    public void setItemHolderType(pm.a r5) {
        ListEventManager.a(r5, 0);
    }

    @c0(defaultBoolean = false, name = "android-new-scroll-top")
    public void setListNewScrollTopSwitch(boolean r5) {
        this.f10521r = r5;
    }

    @c0(defaultBoolean = true, name = "use-old-sticky")
    public void setListOldStickySwitch(boolean r5) {
        this.f10520q = r5;
    }

    @c0(name = "list-platform-info")
    public void setListPlatformInfo(@NonNull ReadableMap r5) {
        this.f10528z = true;
        this.f10524v = r5;
        this.f10527y = null;
        this.O = false;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setListType(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        r5 = "single";
    L6:
        if (TextUtils.equals(r5, this.d) == true) goto L9;
        this.e = true;
        this.d = r5;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setLowerThreshold(pm.a r5) {
        this.f.getClass();
        ListEventManager.a(r5, 50);
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setLowerThresholdItemCount(pm.a r5) {
        this.f.getClass();
        ListEventManager.a(r5, 0);
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setMainAxisGap(float r5) {
        Math.round(r5);
    }

    @c0(defaultDouble = Contrast.RATIO_MIN, name = "max-fling-velocity-percent")
    public void setMaxFlingVelocityPercent(float r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setNeedVisibleCells(boolean r5) {
        this.f.f = r5;
    }

    @c0(defaultBoolean = false, name = "enable-new-exposure-strategy")
    public void setNewAppear(boolean r10) {
        c5.a r5 = this.f10518o;
        if (r10 != r5.f1118b) goto L5;
        return;
    L5:
        r5.f1118b = r10;
        if (r10 == false) goto L9;
        l r11 = (l) r5.f1119c;
        b0.c r12 = new b0.c();
        r12.e = new HashSet();
        Rect r13 = new Rect();
        new Rect();
        r12.f807a = 0;
        DisplayMetrics r14 = DisplayMetricsHolder.b(r11.getContext());
        r13.set(0, 0, r14.widthPixels, r14.heightPixels);
        r12.f808b = new Handler(Looper.getMainLooper());
        r12.f809c = new h(r12, 14);
        r12.d = r11;
        r11.addOnScrollListener(new b());
        ViewTreeObserver r15 = r11.getViewTreeObserver();
        r15.addOnDrawListener(new com.lynx.tasm.behavior.z(r12, 1));
        r15.addOnScrollChangedListener(new y(r12, 1));
        r5.d = r12;
        return;
    L9:
        r5.d = new en.a();
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setNoInvalidate(boolean r5) {
        this.f10515l = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setPagingAlignment(ReadableMap r10) {
        if ((r10 instanceof JavaOnlyMap) == true) goto L5;
    L16:
        FactoredPagerSnapHelper r11 = this.f10513j;
        if (r11 == null) goto L20;
        r11.a(null);
        this.f10513j = null;
        return;
    L20:
        return;
    L5:
        if (((JavaOnlyMap) r10).size() == 0) goto L16;
        double r5 = r10.getDouble("factor");
        if (r5 >= 0.0d) goto L9;
    L10:
        getLynxContext().b(new LynxError(220205, "item-snap invalid!", "The factor should be constrained to the range of [0,1].", "warn"));
    L11:
        r10.getInt("offset", 0);
        if (this.f10513j != null) goto L14;
        FactoredPagerSnapHelper r12 = new FactoredPagerSnapHelper();
        this.f10513j = r12;
        r12.a((RecyclerView) this.mView);
        this.f10513j.getClass();
    L14:
        this.f10513j.getClass();
        this.f10513j.getClass();
        return;
    L9:
        if (r5 <= 1.0d) goto L11;
        goto L10
    }

    @c0(defaultBoolean = false, name = "android-preference-consume-gesture")
    public void setPreferenceConsumeGesture(boolean r5) {
        T r10 = this.mView;
        if ((r10 instanceof l) == false) goto L6;
        ((l) r10).getClass();
        return;
    }

    @c0(defaultInt = 0, name = "preload-buffer-count")
    public void setPreloadBufferCount(pm.a r5) {
        this.J = ListEventManager.a(r5, 0);
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setScrollEnable(pm.a r5) {
        this.f10514k = ListEventManager.c(r5, true);
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setScrollEventThrottle(pm.a r5) {
        this.f.getClass();
        ListEventManager.a(r5, 200);
    }

    @c0(defaultInt = -1, name = "scroll-index")
    public void setScrollIndex(int r5) {
        this.Q = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setScrollStateChangeEventThrottle(String r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setScrollX(pm.a r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setScrollY(pm.a r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setShouldRequestStateRestore(boolean r5) {
        super.setInternalCellAppearNotification(r5);
        UIListAdapter r10 = this.f10509b;
        if (r10 == null) goto L6;
        r10.getClass();
        this.f10509b.getClass();
        return;
    }

    @c0(defaultBoolean = false, name = "android-stack-from-end")
    public void setStackFromEnd(boolean r5) {
        this.N = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setStickyOffset(pm.a r5) {
        com.lynx.tasm.utils.g.a(ListEventManager.a(r5, 0), 0.0f);
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setTouchScroll(pm.a r5) {
        T r10 = this.mView;
        if ((r10 instanceof l) == false) goto L6;
        ListEventManager.c(r5, true);
        ((l) r10).getClass();
        return;
    }

    @c0(defaultBoolean = false, name = "android-trigger-sticky-layout")
    public void setTriggerStickyLayout(boolean r5) {
        this.D = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setUpdateAnimation(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L6:
        ((RecyclerView) this.mView).setItemAnimator(null);
    L8:
        if (TextUtils.equals(r5, "default") == false) goto L11;
        ((RecyclerView) this.mView).setItemAnimator(new DefaultItemAnimator());
        return;
    L11:
        return;
    L5:
        if (TextUtils.equals(r5, "none") == false) goto L8;
        goto L6
    }

    @c0(defaultBoolean = false, name = "scroll-upper-lower-switch")
    public void setUpperLowerSwitch(boolean r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setUpperThreshold(pm.a r5) {
        this.f.getClass();
        ListEventManager.a(r5, 50);
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setUpperThresholdItemCount(pm.a r5) {
        this.f.getClass();
        ListEventManager.a(r5, 0);
    }

    @c0(defaultBoolean = true, name = "vertical-orientation")
    public void setVerticalOrientation(boolean r5) {
        this.s = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void storeKeyToNativeStorage(String r5, Object r10) {
        HashMap r11 = this.f10522t;
        if (r11 == null) goto L6;
        r11.put(r5, r10);
        return;
    }

    @c0(name = "update-list-info")
    public void updateListActionInfo(@NonNull ReadableMap r5) {
        this.f10528z = true;
        this.f10527y = r5;
        this.f10524v = null;
        this.O = true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final wm.a hitTest(float r5, float r10, boolean r11) {
        if (this.f10509b == null) goto L11;
        ListStickyManager r12 = this.f10517n;
        if (r12 == null) goto L8;
        r12.f10508c.getClass();
        r12.d.getClass();
    L8:
        int r13 = ((RecyclerView) this.mView).getChildCount() - 1;
    L9:
        if (r13 < 0) goto L11;
        ((RecyclerView) this.mView).getChildViewHolder(((RecyclerView) this.mView).getChildAt(r13));
        r13 = r13 - 1;
    L11:
        return this;
    }

    @f0
    public void scrollBy(ReadableMap r10, Callback r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r10 != null) goto L6;
    L10:
        r11.invoke(new Object[]{4, "Invoke scrollBy failed due to index param is null"});
        return;
    L6:
        if (r10.hasKey("offset") == false) goto L10;
        com.lynx.tasm.utils.j.f(new com.bytedance.ies.xelement.viewpager.foldview.d(this, com.lynx.tasm.utils.g.a((float) r10.getDouble("offset", 0.0d), 0.0f), r11, 1));
    }
}
