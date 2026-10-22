package com.lynx.tasm.behavior.ui.list.container;

import android.content.Context;
import android.text.TextUtils;
import android.view.Choreographer;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import c7.e;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.ies.xelement.viewpager.foldview.d;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.b0;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.f0;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.list.ListEventManager;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.behavior.ui.view.b;
import com.lynx.tasm.behavior.ui.view.c;
import com.lynx.tasm.behavior.ui.z;
import com.lynx.tasm.utils.DeviceUtils;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.lynx.tasm.utils.k;
import fn.f;
import fn.g;
import fn.h;
import fn.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import rn.a;
import ym.j;
import ym.o;

/* JADX INFO: loaded from: classes2.dex */
public class UIListContainer extends UISimpleView<ListContainerView> implements f, a {
    public Callback A;
    public boolean B;
    public int C;
    public final h D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f10567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f10568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JavaOnlyArray f10569c;
    public final HashMap d;
    public boolean e;
    public int f;
    public final HashMap g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap f10570h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinkedHashMap f10571i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashMap f10572j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public JavaOnlyArray f10573k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public JavaOnlyArray f10574l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public UIComponent f10575m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public UIComponent f10576n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f10577o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f10578p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f10579q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f10580r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f10581t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f10582u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f10583v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final HashSet f10584w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final HashSet f10585x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final HashMap f10586y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final HashMap f10587z;

    public UIListContainer(b0 r5, z r10) {
        super(r5, r10);
        this.f10567a = true;
        this.f10568b = null;
        this.f10569c = new JavaOnlyArray();
        this.d = new HashMap();
        this.e = false;
        this.f = 0;
        this.g = new HashMap();
        this.f10570h = new HashMap();
        this.f10571i = new LinkedHashMap();
        this.f10572j = new LinkedHashMap();
        this.f10573k = new JavaOnlyArray();
        this.f10574l = new JavaOnlyArray();
        this.f10575m = null;
        this.f10576n = null;
        this.f10577o = false;
        this.f10578p = 100;
        this.f10579q = true;
        this.f10580r = false;
        this.s = false;
        this.f10581t = false;
        this.f10582u = false;
        this.f10583v = true;
        this.f10584w = new HashSet();
        this.f10585x = new HashSet();
        this.f10586y = new HashMap();
        this.f10587z = new HashMap();
        this.A = null;
        this.B = false;
        this.C = -1;
        this.D = new h(this);
    }

    public static /* synthetic */ View c(UIListContainer r5) {
        return r5.mView;
    }

    public static /* synthetic */ View s(UIListContainer r5) {
        return r5.mView;
    }

    public static /* synthetic */ View v(UIListContainer r5) {
        return r5.mView;
    }

    public static /* synthetic */ View w(UIListContainer r5) {
        return r5.mView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f0
    public void autoScroll(ReadableMap r10, Callback r11) {
        if (this.f10568b != null) goto L5;
        this.f10568b = new i(this, r11);
    L5:
        i r12 = this.f10568b;
        boolean r5 = r10.getBoolean("start", true);
        boolean r13 = r10.getBoolean("autoStop", true);
        r12.f16958a = r5;
        r12.f16960c = r13;
        i r14 = this.f10568b;
        String r15 = r10.getString("rate", "");
        LynxContext r16 = getLynxContext();
        boolean r17 = r14.f16958a;
        UIListContainer r18 = (UIListContainer) r14.f;
        if (r17 == false) goto L29;
        int r19 = (int) k.b(r15);
        Callback r20 = (Callback) r14.e;
        if (r19 != 0) goto L10;
        r20.invoke(new Object[]{1, "rate is not right"});
        return;
    L10:
        int r21 = (int) DeviceUtils.a(r16);
        if (r21 > 0) goto L14;
        r21 = 60;
    L14:
        if (r19 <= 0) goto L16;
        int r22 = Math.max(r19 / r21, 1);
    L17:
        r14.f16959b = r22;
        r14.a();
        ((ListContainerView) r18.mView).f10566x = true;
        Callback r23 = r18.A;
        if (r23 == null) goto L20;
        r18.A = null;
        r23.invoke(new Object[]{4, "the scroll has stopped, triggered by auto scroll"});
    L20:
        int r24 = r14.f16959b;
        if (r24 > 0) goto L23;
    L24:
        if (r24 < 0) goto L26;
    L28:
        r20.invoke(new Object[]{0});
        r14.d = new e(r14, 4);
        Choreographer.getInstance().postFrameCallback((e) r14.d);
        return;
    L26:
        if (((ListContainerView) r18.getView()).b(-1) == false) goto L28;
    L27:
        ((ListContainerView) r18.mView).setScrollState(4);
        goto L28
    L23:
        if (((ListContainerView) r18.getView()).b(1) == true) goto L27;
    L16:
        r22 = Math.min(r19 / r21, -1);
        goto L17
    L29:
        T r25 = r18.mView;
        ((ListContainerView) r25).f10566x = false;
        ((ListContainerView) r25).setScrollState(1);
        r14.a();
    }

    public final int b(String r5) {
        if (TextUtils.isEmpty(r5) == true) goto L9;
        HashMap r10 = this.d;
        if (r10.containsKey(r5) == true) goto L8;
        return -1;
    L8:
        return ((Integer) r10.get(r5)).intValue();
    L9:
        return -1;
    }

    @Override // rn.a
    public final boolean canConsumeGesture(float r5, float r10) {
        if (isEnableNewGesture() == true) goto L6;
        return false;
    L6:
        if (this.f10567a == false) goto L19;
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
        ListContainerView r10 = (ListContainerView) this.mView;
        r10.B = Boolean.valueOf(r5);
        if (r5 == false) goto L6;
        r10.D = false;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r10) {
        ListContainerView r5 = new ListContainerView(r10);
        r5.B = null;
        r5.C = null;
        r5.D = true;
        r5.F = true;
        r5.G = 0;
        r5.H = 0;
        r5.I = false;
        r5.L = false;
        r5.f10546z = this;
        if (r5.A != null) goto L5;
        r5.A = new fn.a(r5, r5.getContext(), 0);
        LynxLog.b(2, "ListContainerView", "Create CustomLinearLayout: " + r5.A + ", " + r5);
    L5:
        r5.A.setOrientation(1);
        r5.A.setWillNotDraw(true);
        r5.A.setFocusableInTouchMode(true);
        r5.addView(r5.A, new FrameLayout.LayoutParams(-1, -1));
        r5.s.add(this);
        LynxLog.b(2, "UIListContainer", "create UIListContainer: " + this + ", " + r5);
        return r5;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        LynxLog.b(2, "UIListContainer", "destroy: " + this + ", listContainerView: " + this.mView);
        super.destroy();
        T r5 = this.mView;
        if (r5 == 0) goto L5;
        ListContainerView r10 = (ListContainerView) r5;
        TraceEvent.c("ListContainerView.destroy");
        r10.E = null;
        r10.f10546z = null;
        r10.A = null;
        r10.f10562t.clear();
        r10.s.clear();
        TraceEvent.a(0, "ListContainerView.destroy");
    L5:
        i r11 = this.f10568b;
        if (r11 == null) goto L9;
        r11.a();
        return;
    }

    @Override // rn.a
    public final int getMemberScrollX() {
        if (this.f10567a == false) goto L7;
        return 0;
    L7:
        return ((ListContainerView) this.mView).getScrollX();
    }

    @Override // rn.a
    public final int getMemberScrollY() {
        if (this.f10567a == true) goto L5;
        return 0;
    L5:
        return ((ListContainerView) this.mView).getScrollY();
    }

    @Override // rn.a
    public final int getScrollContainerDirection() {
        if (this.f10567a == false) goto L6;
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
    public final int getScrollX() {
        return ((ListContainerView) this.mView).getScrollX();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getScrollY() {
        return ((ListContainerView) this.mView).getScrollY();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final Object getValueFromNativeStorage(String r5) {
        HashMap r10 = this.g;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.get(r5);
    }

    @f0
    public void getVisibleCells(ReadableMap r5, Callback r10) {
        r10.invoke(new Object[]{0, z()});
    }

    public final UIComponent i(Integer r5, boolean r10) {
        if (this.f10583v == false) goto L17;
        if (r10 == false) goto L6;
        HashMap r11 = this.f10586y;
    L7:
        int r12 = r5.intValue();
        if (r12 >= 0) goto L10;
        return null;
    L10:
        if (r12 >= this.f10569c.size()) goto L22;
        String r13 = this.f10569c.getString(r12);
        if (r13 != null) goto L14;
        return null;
    L14:
        return (UIComponent) r11.get(r13);
    L22:
        return null;
    L6:
        r11 = this.f10587z;
        goto L7
    L17:
        if (r10 == false) goto L19;
        LinkedHashMap r14 = this.f10571i;
    L21:
        return (UIComponent) r14.get(r5);
    L19:
        r14 = this.f10572j;
        goto L21
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean initialPropsFlushed(String r5, String r10) {
        HashMap r11 = this.f10570h;
        if (r11 == null) goto L10;
        HashSet r12 = (HashSet) r11.get(r10);
        if (r12 == null) goto L10;
        if (r12.contains(r5) == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r10, int r11) {
        super.onInsertChild(r10, r11);
        if (this.e == true) goto L5;
        return;
    L5:
        if (this.f10583v == true) goto L34;
        int r12 = b(((UIComponent) r10).f10770b);
        LinkedHashMap r5 = this.f10571i;
        JavaOnlyArray r13 = this.f10573k;
        int r14 = 0;
        if (this.e == true) goto L10;
    L17:
        LinkedHashMap r15 = this.f10572j;
        JavaOnlyArray r16 = this.f10574l;
        if (this.e == true) goto L21;
        return;
    L21:
        if ((r10 instanceof UIComponent) == false) goto L35;
        int r17 = r16.size();
    L23:
        if (r14 >= r17) goto L37;
        if (r12 == r16.getInt(r14)) goto L26;
        r14 = r14 + 1;
        goto L23
    L26:
        r15.put(Integer.valueOf(r12), (UIComponent) r10);
        return;
    L37:
        return;
    L35:
        return;
    L10:
        if ((r10 instanceof UIComponent) == false) goto L17;
        int r18 = r13.size();
        int r19 = 0;
    L12:
        if (r19 >= r18) goto L17;
        if (r12 == r13.getInt(r19)) goto L15;
        r19 = r19 + 1;
        goto L12
    L15:
        r5.put(Integer.valueOf(r12), (UIComponent) r10);
        goto L17
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void interceptGesture(boolean r5) {
        ListContainerView r10 = (ListContainerView) this.mView;
        r10.C = Boolean.valueOf(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.ui.a0
    public final void invalidate() {
        if (((ListContainerView) this.mView).getLinearLayout() == null) goto L5;
        ((ListContainerView) this.mView).getLinearLayout().invalidate();
    L5:
        super.invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rn.a
    public final boolean isAtBorder(boolean r5) {
        if (isEnableNewGesture() == true) goto L7;
        return false;
    L7:
        if (r5 == false) goto L11;
        boolean r10 = ((ListContainerView) getView()).b(-1);
    L10:
        return !r10;
    L11:
        r10 = ((ListContainerView) getView()).b(1);
        goto L10
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isScrollContainer() {
        return true;
    }

    public final /* synthetic */ void j(float r5, float r10) {
        T r11 = this.mView;
        if (r11 != 0) goto L6;
        return;
    L6:
        if (this.f10567a == false) goto L9;
        ((ListContainerView) r11).scrollBy(0, (int) r5);
        return;
    L9:
        ((ListContainerView) r11).scrollBy((int) r10, 0);
    }

    public final void k(float r5, float r10, float r11) {
        ListContainerView r12 = (ListContainerView) this.mView;
        int r13 = (int) r5;
        int r14 = (int) r10;
        int r15 = (int) r11;
        boolean r16 = r12.F;
        if (r16 == true) goto L5;
    L7:
        if (r16 == false) goto L9;
    L11:
        r12.I = true;
        if (r12.F == false) goto L14;
        int r17 = r12.K + r15;
        r12.K = r17;
        r12.setScrollY(r17);
    L19:
        r12.I = false;
        return;
    L14:
        r12.J += r14;
        if (r12.f10546z.isRtl() == false) goto L17;
        int r18 = (int) Math.max((r12.G - r12.J) - r12.f10546z.getWidth(), 0.0f);
    L18:
        r12.setScrollX(r18);
        goto L19
    L17:
        r18 = r12.J;
        goto L18
    L9:
        if (r13 == r12.G) goto L11;
        r12.d(Math.max(r13, r12.f10546z.getWidth()), r12.H);
        goto L11
    L5:
        if (r13 == r12.H) goto L7;
        r12.d(r12.G, Math.max(r13, r12.f10546z.getHeight()));
        goto L11
    }

    public final void l(float r10, boolean r11) {
        int r12 = (int) r10;
        this.C = r12;
        if (r11 == true) goto L31;
        fn.e r13 = ((ListContainerView) this.mView).getCustomScrollHook();
        h r5 = this.D;
        if (r13 == r5) goto L7;
        ((ListContainerView) this.mView).setCustomScrollHook(r5);
    L7:
        ListContainerView r14 = (ListContainerView) this.mView;
        boolean r15 = this.f10567a;
        boolean r16 = false;
        if (r15 == false) goto L10;
        int r17 = 0;
    L11:
        if (r15 == true) goto L14;
        r12 = 0;
    L14:
        g r18 = r14.f10561r;
        if (r18.e.g() == true) goto L17;
        r18.e.a();
    L17:
        ListContainerView r19 = r18.g;
        r19.setScrollState(4);
        r18.f16952a = r19.getScrollX();
        int r20 = r19.getScrollY();
        r18.f16953b = r20;
        fn.e r21 = r18.f;
        if (r21 == null) goto L29;
        int r22 = r18.f16952a;
        h r23 = (h) r21;
        boolean r24 = r23.f16957c.f10567a;
        if (r24 == true) goto L22;
        int r25 = r17;
    L23:
        r23.f16955a = r25;
        if (r24 == false) goto L26;
        r22 = r20;
    L26:
        if (r25 <= r22) goto L28;
        r16 = true;
    L28:
        r23.f16956b = r16;
        goto L29
    L22:
        r25 = r12;
    L29:
        int r26 = r18.f16952a;
        r18.e.b(r26, r20, r17 - r26, r12 - r20, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        r19.removeCallbacks(r18);
        ViewCompat.postOnAnimation(r19, r18);
        return;
    L10:
        r17 = r12;
        goto L11
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void layout() {
        if (getOverflow() == 0) goto L5;
        ((ListContainerView) this.mView).setClipChildren(false);
    L5:
        super.layout();
    }

    public final void m(int r5, int r10, int r11, int r12, int r13) {
        com.lynx.animax.i r14 = new com.lynx.animax.i(getSign(), "snap");
        r14.a("position", Integer.valueOf(r5));
        r14.a("currentScrollLeft", Float.valueOf(r10 / DisplayMetricsHolder.a().density));
        r14.a("currentScrollTop", Float.valueOf(r11 / DisplayMetricsHolder.a().density));
        r14.a("targetScrollLeft", Float.valueOf(r12 / DisplayMetricsHolder.a().density));
        r14.a("targetScrollTop", Float.valueOf(r13 / DisplayMetricsHolder.a().density));
        this.mContext.g.b(r14);
    }

    public final void n(LynxBaseUI r10) {
        if ((r10 instanceof UIComponent) == false) goto L49;
        UIComponent r11 = (UIComponent) r10;
        if (this.f10581t == false) goto L8;
        p(r11);
    L17:
        if (this.e == true) goto L19;
        return;
    L19:
        if (this.f10583v == false) goto L30;
        String r5 = r11.f10770b;
        if (r5 != null) goto L23;
        return;
    L23:
        if (this.f10584w.contains(r5) == false) goto L27;
        this.f10586y.put(r5, r11);
        r11.d = this;
        return;
    L27:
        if (this.f10585x.contains(r5) == false) goto L56;
        this.f10587z.put(r5, r11);
        r11.d = this;
        return;
    L56:
        return;
    L30:
        int r12 = b(r11.f10770b);
        LinkedHashMap r13 = this.f10571i;
        JavaOnlyArray r14 = this.f10573k;
        int r15 = 0;
        if (this.e == false) goto L39;
        int r16 = r14.size();
        int r17 = 0;
    L34:
        if (r17 >= r16) goto L39;
        if (r12 == r14.getInt(r17)) goto L37;
        r17 = r17 + 1;
        goto L34
    L37:
        r13.put(Integer.valueOf(r12), r11);
    L39:
        LinkedHashMap r18 = this.f10572j;
        JavaOnlyArray r19 = this.f10574l;
        if (this.e == false) goto L57;
        int r20 = r19.size();
    L43:
        if (r15 >= r20) goto L58;
        if (r12 == r19.getInt(r15)) goto L46;
        r15 = r15 + 1;
        goto L43
    L46:
        r18.put(Integer.valueOf(r12), r11);
        return;
    L58:
        return;
    L57:
        return;
    L8:
        if (r11.getWidth() == 0) goto L10;
    L15:
        p(r11);
        goto L17
    L10:
        if (r11.getHeight() != 0) goto L15;
        if (r11.f10769a != null) goto L17;
        r11.f10769a = new j(this);
        goto L17
    }

    public final void o(LynxBaseUI r5, LinkedHashMap r10) {
        if (this.e == true) goto L6;
        return;
    L6:
        if ((r5 instanceof UIComponent) == false) goto L20;
        Iterator r11 = r10.entrySet().iterator();
    L9:
        if (r11.hasNext() == false) goto L22;
        if (((Map.Entry) r11.next()).getValue() != r5) goto L9;
        if (this.f10579q == false) goto L15;
        u((UIComponent) r5);
    L15:
        r11.remove();
        return;
    L22:
        return;
    }

    @Override // rn.a
    public final void onGestureScrollBy(float r5, float r10) {
        if (isEnableNewGesture() == true) goto L5;
        return;
    L5:
        com.lynx.tasm.utils.j.f(new en.i(this, r10, r5, 1));
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
    public final void onLayoutFinish(long r5, LynxBaseUI r10) {
        super.onLayoutFinish(r5, r10);
        if (this.f10581t == false) goto L5;
        return;
    L5:
        if (this.B == true) goto L9;
        n(r10);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        ViewCompat.setLayoutDirection(this.mView, 0);
        if (this.f10567a == false) goto L9;
        if (((ListContainerView) this.mView).G == getWidth()) goto L9;
        ((ListContainerView) this.mView).d(getWidth(), ((ListContainerView) this.mView).H);
        return;
    L9:
        if (this.f10567a == false) goto L11;
        return;
    L11:
        if (((ListContainerView) this.mView).H == getHeight()) goto L15;
        ListContainerView r5 = (ListContainerView) this.mView;
        r5.d(r5.G, getHeight());
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReady() {
        onAnimationNodeReady();
        afterAnimationNodeReady();
        y();
        x();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onPropsUpdated() {
        super.onPropsUpdated();
        if (this.e == true) goto L5;
        return;
    L5:
        if (this.f10583v == false) goto L9;
        r(this.f10584w, this.f10573k, this.f10586y);
        r(this.f10585x, this.f10574l, this.f10587z);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.view.View] */
    public final void p(UIComponent r5) {
        ?? r10 = r5.getView();
        if (r10 != 0) goto L5;
    L18:
        float r11 = r5.f10771c;
        ?? r12 = r5.getView();
        if (r12 == 0) goto L22;
        r12.setOutlineProvider(null);
        ViewCompat.setTranslationZ(r12, r11);
        return;
    L22:
        return;
    L5:
        if (r10.getParent() != null) goto L18;
        ((ListContainerView) this.mView).addView(r10);
        if (this.f10577o == false) goto L18;
        LynxContext r13 = this.mContext;
        if (r13 == null) goto L18;
        if (r13.k() == null) goto L18;
        ThreadStrategyForRendering r14 = this.mContext.k().getThreadStrategyForRendering();
        if (r14 != ThreadStrategyForRendering.f10066c) goto L16;
    L17:
        AlphaAnimation r15 = new AlphaAnimation(0.0f, 1.0f);
        r15.setDuration(this.f10578p);
        r10.startAnimation(r15);
        goto L18
    L16:
        if (r14 != ThreadStrategyForRendering.e) goto L18;
        goto L17
    }

    public final void q(UIComponent r5, HashMap r10, boolean r11) {
        if (r5 == null) goto L34;
        String r12 = r5.f10770b;
        if (r12 == null) goto L35;
        if (r11 == true) goto L7;
        Iterator r13 = r10.entrySet().iterator();
    L20:
        if (r13.hasNext() == false) goto L38;
        if (((Map.Entry) r13.next()).getValue() != r5) goto L20;
        r13.remove();
        u(r5);
        return;
    L38:
        return;
    L7:
        if (r10.get(r12) == r5) goto L36;
        Iterator r14 = r10.entrySet().iterator();
    L11:
        if (r14.hasNext() == false) goto L37;
        Map.Entry r15 = (Map.Entry) r14.next();
        if (r15.getValue() != r5) goto L11;
        if (TextUtils.equals((CharSequence) r15.getKey(), r12) == true) goto L11;
        r14.remove();
        r10.put(r12, r5);
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    }

    public final void r(HashSet r5, JavaOnlyArray r10, HashMap r11) {
        r5.clear();
        int r12 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L10;
        int r14 = r10.getInt(r13);
        if (r14 < 0) goto L9;
        if (r14 >= this.f10569c.size()) goto L9;
        r5.add(this.f10569c.getString(r14));
    L9:
        r13 = r13 + 1;
        goto L3
    L10:
        Iterator r15 = r11.entrySet().iterator();
    L12:
        if (r15.hasNext() == false) goto L19;
        Map.Entry r16 = (Map.Entry) r15.next();
        String r17 = (String) r16.getKey();
        UIComponent r18 = (UIComponent) r16.getValue();
        if (r18 == null) goto L12;
        if (r17 == null) goto L12;
        if (r5.contains(r17) == true) goto L12;
        u(r18);
        r18.d = null;
        r15.remove();
        goto L12
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [android.view.View] */
    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void removeChild(LynxBaseUI r5) {
        super.removeChild(r5);
        if ((r5 instanceof UIComponent) == false) goto L22;
        UIComponent r10 = (UIComponent) r5;
        if (this.f10577o == false) goto L20;
        LynxContext r11 = this.mContext;
        if (r11 == null) goto L20;
        if (r11.k() == null) goto L20;
        ThreadStrategyForRendering r12 = this.mContext.k().getThreadStrategyForRendering();
        if (r12 != ThreadStrategyForRendering.f10066c) goto L14;
    L15:
        ?? r13 = r10.getView();
        if (r13 == 0) goto L20;
        if (r13.getAnimation() == null) goto L20;
        r13.getAnimation().cancel();
        goto L20
    L14:
        if (r12 == ThreadStrategyForRendering.e) goto L15;
    L20:
        r10.f10769a = null;
        r10.d = null;
    L22:
        if (this.e == true) goto L24;
        return;
    L24:
        if (this.f10583v == true) goto L28;
        o(r5, this.f10571i);
        o(r5, this.f10572j);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void removeKeyFromNativeStorage(String r5) {
        HashMap r10 = this.g;
        if (r10 == null) goto L6;
        r10.remove(r5);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void removeView(LynxBaseUI r5) {
        super.removeView(r5);
        if ((r5 instanceof UIComponent) == false) goto L24;
        UIComponent r10 = (UIComponent) r5;
        if (this.e == true) goto L7;
        return;
    L7:
        if (this.f10583v == false) goto L22;
        String r11 = r10.f10770b;
        if (r11 == null) goto L26;
        HashMap r12 = this.f10586y;
        if (r12.get(r11) != r10) goto L16;
        r12.remove(r11);
        r10.d = null;
        if (this.f10579q == false) goto L27;
        u(r10);
        return;
    L27:
        return;
    L16:
        HashMap r13 = this.f10587z;
        if (r13.get(r11) != r10) goto L28;
        r13.remove(r11);
        r10.d = null;
        if (this.f10579q == false) goto L29;
        u(r10);
        return;
    L29:
        return;
    L28:
        return;
    L26:
        return;
    L22:
        o(r10, this.f10571i);
        o(r10, this.f10572j);
        return;
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
        com.lynx.tasm.utils.j.f(new d(this, com.lynx.tasm.utils.g.a((float) r10.getDouble("offset", 0.0d), 0.0f), r11, 2));
    }

    @f0
    public void scrollToPosition(ReadableMap r13, Callback r14) {
        Callback r5 = this.A;
        com.lynx.tasm.i r10 = null;
        int r11 = 1;
        if (r5 == null) goto L5;
        this.A = null;
        r5.invoke(new Object[]{1, "the scroll has stopped, triggered by a new scrolling request"});
    L5:
        int r12 = r13.getInt("index", r13.getInt("position", 0));
        float r15 = (float) r13.getDouble("offset", 0.0d);
        boolean r16 = r13.getBoolean("smooth", false);
        int r17 = (int) com.lynx.tasm.utils.g.a(r15, 0.0f);
        if (r12 >= 0) goto L8;
    L39:
        r14.invoke(new Object[]{1, "position < 0 or position >= data count"});
        return;
    L8:
        if (r12 >= this.f10569c.size()) goto L39;
        if (r16 == true) goto L15;
        g r18 = ((ListContainerView) this.mView).f10561r;
        if (r18.e.g() == true) goto L14;
        r18.e.a();
    L14:
        r18.f16952a = 0;
        r18.f16953b = 0;
        r18.f16954c = 0;
        r18.d = 0;
    L15:
        String r19 = r13.getString("alignTo");
        if (TextUtils.equals(r19, "middle") == false) goto L19;
    L17:
        int r110 = r11;
    L22:
        if (r16 == false) goto L24;
        this.A = r14;
    L24:
        LynxContext r111 = getLynxContext();
        if (r111 == null) goto L27;
        r10 = r111.f10141i;
    L27:
        if (r10 == null) goto L37;
        int r20 = getSign();
        float r112 = r17;
        LynxTemplateRender r21 = (LynxTemplateRender) r10.f10879a;
        if (r21 == null) goto L31;
        r21.H(r16, r20, r12, r110, r112);
    L31:
        if (r16 == true) goto L41;
        int r22 = ((ListContainerView) this.mView).getScrollX();
        int r23 = ((ListContainerView) this.mView).getScrollY();
        int r113 = ((ListContainerView) this.mView).getScrollX();
        int r24 = ((ListContainerView) this.mView).getScrollY();
        on.f r25 = new on.f(getSign(), "scrollend");
        r25.d(r22, r23, ((ListContainerView) this.mView).getMeasuredHeight(), ((ListContainerView) this.mView).getMeasuredWidth(), r22 - r113, r23 - r24);
        if (getLynxContext() == null) goto L35;
        getLynxContext().g.b(r25);
    L35:
        r14.invoke(new Object[]{0});
        return;
    L41:
        return;
    L37:
        r14.invoke(new Object[]{1, "List has been destroyed"});
        return;
    L19:
        if (TextUtils.equals(r19, "bottom") == false) goto L21;
        r11 = 2;
        goto L17
    L21:
        r110 = 0;
        goto L22
    }

    @c0(defaultInt = 0, name = "experimental-batch-render-strategy")
    public void setBatchRenderStrategy(int r5) {
        if (r5 <= 0) goto L4;
        boolean r10 = true;
    L5:
        this.f10581t = r10;
        return;
    L4:
        r10 = false;
        goto L5
    }

    @c0(name = "list-container-info")
    public void setDiffInfo(ReadableMap r5) {
        if (r5 == null) goto L15;
        ReadableArray r10 = r5.getArray("stickyStart");
        if (r10 == null) goto L6;
        this.f10573k = JavaOnlyArray.a(r10);
    L6:
        ReadableArray r11 = r5.getArray("stickyEnd");
        if (r11 == null) goto L9;
        this.f10574l = JavaOnlyArray.a(r11);
    L9:
        ReadableArray r12 = r5.getArray("itemkeys");
        if (r12 == null) goto L12;
        this.f10569c = JavaOnlyArray.a(r12);
    L12:
        int r13 = this.f10569c.size();
        HashMap r14 = this.d;
        r14.clear();
        int r15 = 0;
    L13:
        if (r15 >= r13) goto L17;
        r14.put(this.f10569c.getString(r15), Integer.valueOf(r15));
        r15 = r15 + 1;
        goto L13
    L17:
        return;
    }

    @c0(defaultBoolean = false, name = "enable-fade-in-animation")
    public void setEnableFadeInAnimation(boolean r5) {
        this.f10577o = r5;
    }

    @c0(defaultBoolean = false, name = "enable-insert-platform-view-operation")
    public void setEnableInsertPlatformViewOperation(boolean r5) {
        this.B = r5;
    }

    @c0(defaultBoolean = true, name = "sticky")
    public void setEnableListSticky(boolean r5) {
        this.e = r5;
    }

    @c0(defaultBoolean = false, name = "enable-nested-scroll")
    public void setEnableNestedScroll(boolean r5) {
        ((ListContainerView) this.mView).setNestedScrollingEnabled(r5);
    }

    @c0(defaultBoolean = true, name = "experimental-recycle-sticky-item")
    public void setEnableRecycleStickyItem(boolean r5) {
        this.f10579q = r5;
    }

    @c0(defaultBoolean = true, name = "enable-scroll")
    public void setEnableScroll(boolean r5) {
        ((ListContainerView) this.mView).setEnableScroll(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map r5) {
        super.setEvents(r5);
        if (r5 != null) goto L5;
        return;
    L5:
        this.f10580r = r5.containsKey("scrollend");
        this.s = r5.containsKey("scrollstatechange");
    }

    @c0(defaultBoolean = false, name = "force-can-scroll")
    public void setForceCanScroll(boolean r5) {
        T r10 = this.mView;
        if (r10 == 0) goto L6;
        ((ListContainerView) r10).setForceCanScroll(r5);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setInitialPropsHasFlushed(String r5, String r10) {
        HashMap r11 = this.f10570h;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.get(r10) != null) goto L7;
        HashSet r12 = new HashSet();
    L8:
        r12.add(r5);
        r11.put(r10, r12);
        return;
    L7:
        r12 = (HashSet) r11.get(r10);
        goto L8
    }

    @c0(name = "experimental-max-fling-distance-ratio")
    public void setMaxFlingDistanceRatio(pm.a r5) {
        if (r5.getType() != ReadableType.String) goto L9;
        if (r5.asString().equals("auto") == false) goto L9;
        ((ListContainerView) this.mView).setMaxFlingDistanceRatio(Float.MAX_VALUE);
        return;
    L9:
        if (r5.getType() != ReadableType.Number) goto L12;
        ((ListContainerView) this.mView).setMaxFlingDistanceRatio((float) r5.asDouble());
        return;
    }

    @c0(defaultBoolean = false, name = "need-visible-item-info")
    public void setNeedVisibleItemInfo(boolean r5) {
        this.f10582u = r5;
    }

    @c0(name = "item-snap")
    public void setPagingAlignment(ReadableMap r18) {
        if (r18 != null) goto L5;
    L15:
        ((ListContainerView) this.mView).f10548a = null;
        return;
    L5:
        if (r18.size() <= 0) goto L15;
        double r5 = r18.getDouble("factor");
        if (r5 >= 0.0d) goto L9;
    L12:
        getLynxContext().b(new LynxError(220205, "item-snap invalid!", "The factor should be constrained to the range of [0,1].", "warn"));
        double r11 = 0.0d;
    L13:
        int r13 = r18.getInt("offset", 0);
        double r14 = 50.0f / this.mContext.f10152u.densityDpi;
        ((ListContainerView) this.mView).f10548a = new en.h(r11, r13, r14, new o(this, 7));
        return;
    L9:
        if (r5 > 1.0d) goto L12;
        r11 = r5;
        goto L13
    }

    @c0(customType = "vertical", name = "scroll-orientation")
    public void setScrollOrientation(String r5) {
        if (TextUtils.equals(r5, "vertical") == false) goto L6;
        this.f10567a = true;
    L9:
        ((ListContainerView) this.mView).setOrientation(this.f10567a ? 1 : 0);
        return;
    L6:
        if (TextUtils.equals(r5, "horizontal") == false) goto L8;
        this.f10567a = false;
        goto L9
    L8:
        this.f10567a = true;
        goto L9
    }

    @c0(defaultInt = 0, name = "sticky-offset")
    public void setStickyOffset(pm.a r5) {
        this.f = (int) com.lynx.tasm.utils.g.a(ListEventManager.a(r5, 0), 0.0f);
    }

    @c0(defaultInt = 100, name = "update-animation-fade-in-duration")
    public void setUpdateAnimationFadeInDuration(int r5) {
        this.f10578p = r5;
    }

    @c0(defaultBoolean = true, name = "experimental-update-sticky-for-diff")
    public void setUpdateStickyForDiff(boolean r5) {
        this.f10583v = r5;
    }

    @c0(defaultBoolean = false, name = "vertical-orientation")
    public void setVerticalOrientation(boolean r5) {
        this.f10567a = r5;
        ((ListContainerView) this.mView).setOrientation(r5 ? 1 : 0);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void storeKeyToNativeStorage(String r5, Object r10) {
        HashMap r11 = this.g;
        if (r11 == null) goto L6;
        r11.put(r5, r10);
        return;
    }

    public final void t(int r10) {
        if (r10 == 1) goto L6;
        recognizeGesturere();
    L6:
        if (r10 != 1) goto L19;
        LynxContext r5 = getLynxContext();
        if (r5.C != null) goto L10;
        r5.C = new qn.a(r5);
    L10:
        r5.C.b(getSign());
        Callback r11 = this.A;
        if (r11 == null) goto L14;
        this.A = null;
        r11.invoke(new Object[]{0});
    L14:
        if (this.f10580r == false) goto L27;
        int r12 = ((ListContainerView) this.mView).getScrollX();
        int r13 = ((ListContainerView) this.mView).getScrollY();
        int r14 = ((ListContainerView) this.mView).getScrollX();
        int r15 = ((ListContainerView) this.mView).getScrollY();
        on.f r16 = new on.f(getSign(), "scrollend");
        r16.d(r12, r13, ((ListContainerView) this.mView).getMeasuredHeight(), ((ListContainerView) this.mView).getMeasuredWidth(), r12 - r14, r13 - r15);
        if (getLynxContext() == null) goto L27;
        getLynxContext().g.b(r16);
    L27:
        if (this.s == false) goto L33;
        com.lynx.animax.i r17 = new com.lynx.animax.i(getSign(), "scrollstatechange");
        if (this.f10582u == false) goto L31;
        r17.a("attachedCells", z());
    L31:
        r17.a("state", Integer.valueOf(r10));
        this.mContext.g.b(r17);
        return;
    L33:
        return;
    L19:
        if (r10 != 2) goto L27;
        LynxContext r18 = getLynxContext();
        if (r18.C != null) goto L23;
        r18.C = new qn.a(r18);
    L23:
        r18.C.c(getSign(), getScrollMonitorTag());
        Callback r19 = this.A;
        if (r19 == null) goto L27;
        this.A = null;
        r19.invoke(new Object[]{1, "the scroll has stopped, triggered by dragging events"});
        goto L27
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.view.View] */
    public final void u(UIComponent r5) {
        if (r5.getView() != 0) goto L5;
        return;
    L5:
        if (this.f10567a == false) goto L7;
        ((b) r5.getView()).setTranslationY(0.0f);
    L8:
        float r10 = r5.f10771c;
        ?? r11 = r5.getView();
        if (r11 == 0) goto L13;
        r11.setOutlineProvider(null);
        ViewCompat.setTranslationZ(r11, r10);
        return;
    L13:
        return;
    L7:
        ((b) r5.getView()).setTranslationX(0.0f);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v6, types: [android.view.View] */
    public final void x() {
        if (this.e == true) goto L6;
        return;
    L6:
        if (this.f10567a == false) goto L9;
        int r5 = ((ListContainerView) this.mView).getScrollY() + getHeight();
        int r10 = this.f;
    L8:
        int r11 = r5 - r10;
        Iterator<Object> r12 = this.f10574l.iterator();
        UIComponent r13 = null;
        UIComponent r14 = null;
    L12:
        if (r12.hasNext() == false) goto L26;
        UIComponent r15 = i((Integer) r12.next(), false);
        if (r15 == null) goto L12;
        if (this.f10567a == false) goto L20;
        int r16 = r15.getTop();
        int r17 = r15.getHeight();
    L21:
        if ((r17 + r16) < r11) goto L22;
        if (r13 != null) goto L24;
        r13 = r15;
        goto L12
    L24:
        u(r15);
        goto L12
    L22:
        u(r15);
        r14 = r15;
        goto L12
    L20:
        r16 = r15.getLeft();
        r17 = r15.getWidth();
        goto L21
    L26:
        if (r13 != null) goto L28;
        return;
    L28:
        if (this.f10576n == r13) goto L34;
        if (this.f10567a == false) goto L32;
        com.lynx.animax.i r18 = new com.lynx.animax.i(getSign(), "stickybottom");
        r18.a("bottom", r13.f10770b);
        this.mContext.g.b(r18);
    L32:
        com.lynx.animax.i r19 = new com.lynx.animax.i(getSign(), "stickyend");
        r19.a("end", r13.f10770b);
        this.mContext.g.b(r19);
        this.f10576n = r13;
    L34:
        if (this.f10567a == false) goto L36;
        int r20 = r13.getHeight();
    L37:
        int r21 = r11 - r20;
        if (r14 == null) goto L47;
        if (this.f10567a == false) goto L43;
        int r22 = r11 - (r14.getHeight() + r14.getTop());
        int r23 = r13.getHeight();
    L42:
        int r24 = r23 - r22;
        if (r24 <= 0) goto L47;
        r21 = r21 + r24;
        goto L47
    L43:
        r22 = r11 - (r14.getWidth() + r14.getLeft());
        r23 = r13.getWidth();
    L47:
        if (r13.getView() != 0) goto L49;
        return;
    L49:
        if (this.f10567a == false) goto L51;
        ((b) r13.getView()).setTranslationY(r21 - r13.getTop());
    L52:
        ((b) r13.getView()).bringToFront();
        ?? r25 = r13.getView();
        if (r25 == 0) goto L69;
        r25.setOutlineProvider(null);
        ViewCompat.setTranslationZ(r25, 2.1474836E9f);
        return;
    L69:
        return;
    L51:
        ((b) r13.getView()).setTranslationX(r21 - r13.getLeft());
        goto L52
    L36:
        r20 = r13.getWidth();
        goto L37
    L9:
        r5 = ((ListContainerView) this.mView).getScrollX() + getWidth();
        r10 = this.f;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v6, types: [android.view.View] */
    public final void y() {
        if (this.e == true) goto L6;
        return;
    L6:
        if (this.f10567a == false) goto L8;
        int r5 = ((ListContainerView) this.mView).getScrollY();
    L9:
        int r10 = r5 + this.f;
        JavaOnlyArray r11 = this.f10573k;
        ListIterator<Object> r12 = r11.listIterator(r11.size());
        UIComponent r13 = null;
        UIComponent r14 = null;
    L11:
        if (r12.hasPrevious() == false) goto L24;
        UIComponent r15 = i((Integer) r12.previous(), true);
        if (r15 == null) goto L11;
        if (this.f10567a == false) goto L18;
        int r16 = r15.getTop();
    L19:
        if (r16 > r10) goto L20;
        if (r13 != null) goto L22;
        r13 = r15;
        goto L11
    L22:
        u(r15);
        goto L11
    L20:
        u(r15);
        r14 = r15;
        goto L11
    L18:
        r16 = r15.getLeft();
        goto L19
    L24:
        if (r13 != null) goto L26;
        return;
    L26:
        if (this.f10575m != r13) goto L28;
    L31:
        if (r14 == null) goto L40;
        if (this.f10567a == false) goto L36;
        int r17 = r14.getTop() - r10;
        int r18 = r13.getHeight();
    L35:
        int r19 = r18 - r17;
        if (r19 <= 0) goto L40;
        r10 = r10 - r19;
        goto L40
    L36:
        r17 = r14.getLeft() - r10;
        r18 = r13.getWidth();
    L40:
        if (r13.getView() != 0) goto L42;
        return;
    L42:
        if (this.f10567a == false) goto L44;
        ((b) r13.getView()).setTranslationY(r10 - r13.getTop());
    L45:
        ((b) r13.getView()).bringToFront();
        ?? r20 = r13.getView();
        if (r20 == 0) goto L62;
        r20.setOutlineProvider(null);
        ViewCompat.setTranslationZ(r20, 2.1474836E9f);
        return;
    L62:
        return;
    L44:
        ((b) r13.getView()).setTranslationX(r10 - r13.getLeft());
        goto L45
    L28:
        if (this.f10567a == false) goto L30;
        com.lynx.animax.i r21 = new com.lynx.animax.i(getSign(), "stickytop");
        r21.a("top", r13.f10770b);
        this.mContext.g.b(r21);
    L30:
        com.lynx.animax.i r22 = new com.lynx.animax.i(getSign(), "stickystart");
        r22.a("start", r13.f10770b);
        this.mContext.g.b(r22);
        this.f10575m = r13;
        goto L31
    L8:
        r5 = ((ListContainerView) this.mView).getScrollX();
        goto L9
    }

    public final JavaOnlyArray z() {
        if (this.mContext == null) goto L5;
        ArrayList r5 = new ArrayList();
        float r10 = this.mContext.f10152u.density;
        int r11 = ((ListContainerView) this.mView).getScrollX();
        int r12 = ((ListContainerView) this.mView).getScrollY();
        int r13 = 0;
    L8:
        if (r13 >= ((ListContainerView) this.mView).getLinearLayout().getChildCount()) goto L32;
        View r14 = ((ListContainerView) this.mView).getLinearLayout().getChildAt(r13);
        if ((r14 instanceof c) == false) goto L31;
        c r15 = (c) r14;
        if (this.f10567a == false) goto L21;
        int r16 = r15.getTop();
        int r17 = r15.getBottom();
        int r18 = ((ListContainerView) this.mView).getScrollY();
        int r19 = ((ListContainerView) this.mView).getHeight() + r18;
        if (r16 > r18) goto L16;
        if (r17 < r18) goto L16;
    L28:
        com.lynx.tasm.behavior.ui.b r20 = r15.getDrawChildHook();
        if ((r20 instanceof UIComponent) == false) goto L31;
        UIComponent r21 = (UIComponent) r20;
        JavaOnlyMap r22 = new JavaOnlyMap();
        r22.put("id", r21.getIdSelector());
        r22.put("position", Integer.valueOf(b(r21.f10770b)));
        r22.put("index", Integer.valueOf(b(r21.f10770b)));
        r22.put("itemKey", r21.f10770b);
        r22.put("top", Float.valueOf((r14.getTop() - r12) / r10));
        r22.put("bottom", Float.valueOf((r14.getBottom() - r12) / r10));
        r22.put(OpenPageMethod.ALIGN_LEFT, Float.valueOf((r14.getLeft() - r11) / r10));
        r22.put("right", Float.valueOf((r14.getRight() - r11) / r10));
        r5.add(r22);
    L16:
        if (r16 > r19) goto L18;
        if (r17 >= r19) goto L28;
    L18:
        if (r16 < r18) goto L31;
        if (r17 > r19) goto L31;
    L21:
        int r23 = r15.getLeft();
        int r24 = r15.getRight();
        int r25 = ((ListContainerView) this.mView).getScrollX();
        int r110 = ((ListContainerView) this.mView).getWidth() + r25;
        if (r23 > r25) goto L24;
        if (r24 >= r25) goto L28;
    L24:
        if (r23 > r110) goto L26;
        if (r24 >= r110) goto L28;
    L26:
        if (r23 < r25) goto L31;
        if (r24 <= r110) goto L28;
    L31:
        r13 = r13 + 1;
        goto L8
    L32:
        Collections.sort(r5, new ca.d(17));
        return new JavaOnlyArray(r5);
    L5:
        return new JavaOnlyArray();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final float[] scrollBy(float r10, float r11) {
        float[] r5 = new float[4];
        T r12 = this.mView;
        if (r12 != 0) goto L5;
        return r5;
    L5:
        int r13 = ((ListContainerView) r12).getScrollX();
        int r14 = ((ListContainerView) this.mView).getScrollY();
        if (this.f10567a == true) goto L8;
        ((ListContainerView) this.mView).scrollBy((int) r10, 0);
    L10:
        if (Math.abs(r10) <= Float.MIN_VALUE) goto L12;
    L13:
        recognizeGesturere();
    L15:
        if (this.f10567a == true) goto L18;
        float r15 = ((ListContainerView) this.mView).getScrollX() - r13;
        r5[0] = r15;
        r5[1] = 0.0f;
        r5[2] = r10 - r15;
        r5[3] = r11;
        return r5;
    L18:
        r5[0] = 0.0f;
        float r16 = ((ListContainerView) this.mView).getScrollY() - r14;
        r5[1] = r16;
        r5[2] = r10;
        r5[3] = r11 - r16;
        return r5;
    L12:
        if (Math.abs(r11) <= Float.MIN_VALUE) goto L15;
    L8:
        ((ListContainerView) this.mView).scrollBy(0, (int) r11);
        goto L10
    }
}
