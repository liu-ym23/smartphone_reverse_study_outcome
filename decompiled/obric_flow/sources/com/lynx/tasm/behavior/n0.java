package com.lynx.tasm.behavior;

import android.animation.AnimatorSet;
import android.graphics.Rect;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import com.lynx.tasm.EventEmitter$LynxEventType;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxEnvKey;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.TraceController;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import com.lynx.tasm.behavior.ui.swiper.XSwiperUI;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.eventreport.LynxEventReporter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes2.dex */
public final class n0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ca.d f10286u = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UIBody f10288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.lynx.tasm.b0 f10289c;
    public final ConcurrentHashMap.KeySetView d;
    public final HashSet e;
    public final ArrayList f;
    public final HashMap g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashSet f10290h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HashMap f10291i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f10292j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f10293k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f10294l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f10295m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public WeakReference f10296n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public sn.a f10297o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f10298p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ConcurrentLinkedQueue f10299q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final HashMap f10300r;
    public com.lynx.tasm.behavior.ui.u s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f10301t;

    static {
        f10286u = new ca.d(13);
    }

    public n0(com.lynx.tasm.b0 r5, c r10, UIBody.UIBodyView r11) {
        this.f10295m = false;
        this.f10299q = new ConcurrentLinkedQueue();
        TraceEvent.c("LynxUIOwner initialized");
        this.f10289c = r5;
        this.f10292j = r10;
        this.d = ConcurrentHashMap.newKeySet();
        this.e = new HashSet();
        this.f = new ArrayList();
        this.g = new HashMap();
        new HashMap();
        this.f10291i = new HashMap();
        this.f10287a = -1;
        UIBody r12 = new UIBody(this.f10289c, r11);
        this.f10288b = r12;
        this.f10289c.f10145m = r12;
        this.f10293k = true;
        this.f10294l = true;
        this.f10290h = new HashSet();
        this.f10298p = LynxEnv.getBooleanFromExternalEnv(LynxEnvKey.f9981r, false);
        this.f10300r = new HashMap();
        r5.getClass();
        s(r11);
        TraceEvent.a(0, "LynxUIOwner initialized");
    }

    public static void A(LynxBaseUI r5) {
        Iterator<LynxBaseUI> r10 = r5.getChildren().iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L9;
        LynxBaseUI r12 = r10.next();
        int r13 = r11 + 1;
        r(r5, r12, r11);
        if (r12.isFlatten() == false) goto L8;
        A(r12);
    L8:
        r11 = r13;
        goto L4
    }

    public static LynxBaseUI C(String r5, LynxBaseUI r10) {
        if (r10.getRefIdSelector() != null) goto L5;
    L7:
        Iterator<LynxBaseUI> r11 = r10.getChildren().iterator();
    L9:
        if (r11.hasNext() == false) goto L20;
        LynxBaseUI r12 = r11.next();
        if (r12.getRefIdSelector() == null) goto L16;
        if (r12.getRefIdSelector().equals(r5) == false) goto L16;
        return r12;
    L16:
        if (r12.getTagName().equals("component") == true) goto L9;
        LynxBaseUI r13 = C(r5, r12);
        if (r13 == null) goto L9;
        return r13;
    L20:
        return null;
    L5:
        if (r10.getRefIdSelector().equals(r5) == false) goto L7;
        return r10;
    }

    public static void D(LynxBaseUI r5) {
        boolean r10 = r5 instanceof UIShadowProxy;
        if (r10 == false) goto L5;
        LynxBaseUI r11 = ((UIShadowProxy) r5).f10388a;
    L6:
        r11.onNodeRemoved();
        if (r10 == true) goto L12;
        Iterator<LynxBaseUI> r12 = r5.getChildren().iterator();
    L10:
        if (r12.hasNext() == false) goto L14;
        D(r12.next());
        goto L10
    L14:
        return;
    L12:
        return;
    L5:
        r11 = r5;
        goto L6
    }

    public static void F(LynxBaseUI r10) {
        UIGroup r5 = (UIGroup) r10.getDrawParent();
        LynxBaseUI r11 = r10.getParentBaseUI();
        if (r5 == null) goto L44;
        if (r11 != null) goto L7;
        return;
    L7:
        if (r10.isFlatten() == true) goto L21;
        LynxBaseUI r12 = r10.getPreviousDrawUI();
        LynxBaseUI r13 = r10.getNextDrawUI();
        if (r12 == null) goto L13;
        r12.setNextDrawUI(r13);
        if (r13 == null) goto L17;
        r13.setPreviousDrawUI(r12);
    L17:
        if (r11.isFlatten() == false) goto L19;
        r5.removeView(r10);
    L19:
        r10.setNextDrawUI(null);
        r10.setPreviousDrawUI(null);
        r10.setDrawParent(null);
        return;
    L13:
        r5.setDrawHead(r13);
        if (r13 == null) goto L17;
        r13.setPreviousDrawUI(null);
        goto L17
    L21:
        LynxBaseUI r14 = r10;
    L23:
        if (r14.isFlatten() == false) goto L27;
        if (r14.getChildren().isEmpty() == true) goto L27;
        r14 = r14.getChildAt(r14.getChildren().size() - 1);
    L27:
        LynxBaseUI r15 = r10.getPreviousDrawUI();
        if (r15 == null) goto L32;
        r15.setNextDrawUI(r14.getNextDrawUI());
        if (r14.getNextDrawUI() == null) goto L35;
        r14.getNextDrawUI().setPreviousDrawUI(r15);
    L35:
        r10.setPreviousDrawUI(null);
        LynxBaseUI r16 = r10.getNextDrawUI();
    L37:
        if (r16 == r14.getNextDrawUI()) goto L39;
        r16.getPreviousDrawUI().setNextDrawUI(null);
        r16.setPreviousDrawUI(null);
        r5.removeView(r16);
        r16.setDrawParent(null);
        r16 = r16.getNextDrawUI();
        goto L37
    L39:
        r14.setNextDrawUI(null);
        r10.setDrawParent(null);
        r11.invalidate();
        return;
    L32:
        r5.setDrawHead(r14.getNextDrawUI());
        if (r14.getNextDrawUI() == null) goto L35;
        r14.getNextDrawUI().setPreviousDrawUI(null);
        goto L35
    }

    public static LynxBaseUI d(String r5, LynxBaseUI r10) {
        if (r10 == null) goto L9;
        if (r10.getIdSelector() == null) goto L9;
        if (r10.getIdSelector().equals(r5) == false) goto L9;
        return r10;
    L9:
        if (r10 != null) goto L11;
        return null;
    L11:
        Iterator<LynxBaseUI> r11 = r10.getChildren().iterator();
    L13:
        if (r11.hasNext() == false) goto L24;
        LynxBaseUI r12 = r11.next();
        if (r12.getIdSelector() == null) goto L20;
        if (r12.getIdSelector().equals(r5) == false) goto L20;
        return r12;
    L20:
        if ((r12 instanceof UIComponent) == true) goto L13;
        LynxBaseUI r13 = d(r5, r12);
        if (r13 == null) goto L13;
        return r13;
    L24:
        return null;
    }

    public static void r(LynxBaseUI r5, LynxBaseUI r10, int r11) {
        r10.setNextDrawUI(null);
        if (r5.isFlatten() == false) goto L5;
        LynxBaseUI r12 = r5.getDrawParent();
    L6:
        if (r12 == null) goto L31;
        if (r11 != 0) goto L14;
        LynxUI r13 = (LynxUI) r12;
        if (r5.isFlatten() == true) goto L13;
        r5 = null;
    L13:
        r13.insertDrawList(r5, r10);
    L22:
        if (r10.isFlatten() == true) goto L29;
        UIGroup r14 = (UIGroup) r12;
        if (r14.isInsertViewCalled() == false) goto L30;
        r14.insertView((LynxUI) r10);
        return;
    L30:
        return;
    L29:
        return;
    L14:
        LynxBaseUI r15 = r5.getChildAt(r11 - 1);
    L16:
        if (r15.isFlatten() == false) goto L20;
        if (r15.getChildren().isEmpty() == true) goto L20;
        r15 = r15.getChildAt(r15.getChildren().size() - 1);
    L20:
        ((LynxUI) r12).insertDrawList(r15, r10);
        goto L22
    L31:
        return;
    L5:
        r12 = r5;
        goto L6
    }

    public static boolean u(y0 r5) {
        if (r5.f10815a.hasKey("box-shadow") == true) goto L13;
        ReadableMap r10 = r5.f10815a;
        if (r10.hasKey("outline-color") == false) goto L7;
        return true;
    L7:
        if (r10.hasKey("outline-style") == false) goto L9;
        return true;
    L9:
        if (r10.hasKey("outline-width") == true) goto L17;
        return false;
    L17:
        return true;
    L13:
        return true;
    }

    public static LynxBaseUI x(String r5, LynxBaseUI r10) {
        if (r10 != null) goto L6;
        LynxLog.b(4, "LynxUIOwner", "findLynxUIByIdSelectorSearchUp failed, the ui is null for " + r5 + ".");
        return null;
    L6:
        if (r10.getIdSelector() == null) goto L11;
        if (r10.getIdSelector().equals(r5) == false) goto L11;
        return r10;
    L11:
        return x(r5, r10.getParentBaseUI());
    }

    public final LynxBaseUI B(String r5) {
        boolean r10 = r5.isEmpty();
        UIBody r11 = this.f10288b;
        if (r10 == false) goto L5;
    L17:
        return r11;
    L5:
        if ("-1".equals(r5) == true) goto L17;
        HashMap r12 = this.f10291i;
        if (r12.containsKey(r5) == false) goto L18;
        int r13 = ((Integer) r12.get(r5)).intValue();
    L13:
        if (r13 != (-1)) goto L16;
        return r11;
    L16:
        return v(r13);
    L18:
        r13 = Integer.parseInt(r5);     // Catch: NumberFormatException -> L12
    L12:
        r13 = -1;
        goto L13
    }

    public final LynxBaseUI E(String r5) {
        Iterator r10 = this.g.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        LynxBaseUI r11 = (LynxBaseUI) r10.next();
        if (r11 == null) goto L4;
        if (r5.equals(r11.getIdSelector()) == false) goto L4;
        return r11;
    L10:
        return null;
    }

    public final void G(String r5) {
        if (LynxEnv.inst().enableComponentStatisticReport() == true) goto L5;
        return;
    L5:
        if (this.f10289c == null) goto L15;
        ConcurrentHashMap.KeySetView r10 = this.d;
        if (r10.contains(r5) == true) goto L16;
        r10.add(r5);
        com.lynx.tasm.b0 r11 = this.f10289c;
        if (r11 != null) goto L11;
        int r12 = -1;
    L12:
        LynxEventReporter.onEvent("lynxsdk_component_statistic", r12, new com.lynx.animax.c(r5, 4));
        return;
    L11:
        r12 = r11.A;
        goto L12
    L16:
        return;
    }

    public final LynxBaseUI a(int r5) {
        HashMap r10 = this.g;
        if ((r10.get(Integer.valueOf(r5)) instanceof UIShadowProxy) == false) goto L7;
        return ((UIShadowProxy) r10.get(Integer.valueOf(r5))).f10388a;
    L7:
        return (LynxBaseUI) r10.get(Integer.valueOf(r5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LynxBaseUI b(LynxBaseUI r5, UIShadowProxy r10, y0 r11) {
        if ((r5 instanceof u0) == false) goto L9;
        com.lynx.tasm.b0 r12 = this.f10289c;
        u0 r13 = (u0) r5;
        if (r12.f10154w != null) goto L7;
        r12.f10154w = new ArrayList();
    L7:
        r12.f10154w.add(r13);
    L9:
        if ((r5 instanceof g) == false) goto L13;
        g r14 = (g) r5;
        ArrayList r15 = this.f;
        if (r15 == null) goto L13;
        r15.add(r14);
    L13:
        if (r11 == null) goto L26;
        r5.afterPropsUpdated(r11);
        ReadableMap r16 = r11.f10815a;
        boolean r17 = r16.hasKey("transition");
        ReadableMapBuffer r18 = r11.f10816b;
        if (r17 == true) goto L19;
        if (r18 == null) goto L21;
        if (r18.e(109) != (-1)) goto L19;
    L21:
        if (r16.hasKey("animation") == true) goto L25;
        if (r18 == null) goto L26;
        if (r18.e(64) == (-1)) goto L26;
    L25:
        r5.setAnimation(r16.getArray("animation"));
    L19:
        r5.initTransitionAnimator(r16);
    L26:
        if (r10 == null) goto L28;
        return r10;
    L28:
        return r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LynxBaseUI c(com.lynx.tasm.behavior.ui.z r10) {
        int r5 = this.f10287a;
        int r11 = r10.f10784a;
        String r12 = r10.d;
        if (r5 < 0) goto L5;
    L43:
        LynxBaseUI r13 = e(r12, r10.f10786c, r10);
    L44:
        if (r13 != null) goto L46;
        return r13;
    L46:
        r13.setEvents(r10.e);
        r13.setSign(r11, r12);
        r13.setNodeIndex(r10.f10785b);
        r13.setGestureDetectors(r10.f);
        return r13;
    L5:
        if (r12.equals("page") == false) goto L43;
        this.f10287a = r11;
        r13 = this.f10288b;
        if (r13 == null) goto L44;
        com.lynx.tasm.behavior.ui.u r14 = this.s;
        if (r14 == null) goto L44;
        WeakReference r15 = new WeakReference(r13);
        cn.b r16 = (cn.b) r14;
        if ((r15.get() instanceof UIBody) == false) goto L44;
        UIBody r17 = (UIBody) r15.get();
        if (r17.getLynxContext() == null) goto L44;
        LynxContext r18 = r17.getLynxContext();
        if (r18.f10140h != null) goto L27;
        UIBody.UIBodyView r19 = r18.l();
        if (r19 == null) goto L27;
        i r20 = r19.getLynxUIRendererInternal();
        if (r20 == null) goto L27;
        if ((r20 instanceof LynxUIRenderer) == false) goto L27;
        ((LynxUIRenderer) r20).b();
    L27:
        LynxBaseUI r21 = (LynxBaseUI) r16.f1223a.get();
        if (r21 == null) goto L44;
        if (r21.getChildrenLynxPageUI() != null) goto L33;
        r21.setChildrenLynxPageUI(new HashMap());
    L33:
        r21.getChildrenLynxPageUI().put(String.valueOf(System.identityHashCode(r21)), r17);
        if (r21.getLynxContext() == null) goto L41;
        if (((n0) r21.getLynxContext().f10147o.get()) == null) goto L41;
        if (((n0) r21.getLynxContext().f10147o.get()).f10288b == null) goto L41;
        r17.f10386b = ((n0) r21.getLynxContext().f10147o.get()).f10288b;
    L41:
        if (r17.getView() == 0) goto L44;
        ((UIBody.UIBodyView) r17.getView()).setIsChildLynxPageUI(true);
        goto L44
    }

    public final LynxBaseUI e(String r5, boolean r10, com.lynx.tasm.behavior.ui.z r11) {
        com.lynx.tasm.u0 r12 = this.f10289c.K;
        if (r12 == null) goto L5;
        boolean r13 = r12.f10971i;
    L6:
        if (r13 == true) goto L8;
    L12:
        LynxBaseUI r14 = null;
    L13:
        if (r14 != null) goto L31;
        a r15 = this.f10292j.a(r5);
        com.lynx.tasm.behavior.ui.accessibility.d r16 = this.f10289c.j();
        if (r16 != null) goto L17;
    L24:
        if (r10 == true) goto L26;
    L28:
        if (r14 != null) goto L31;
        return r15.e(this.f10289c, r11);
    L26:
        if (r15.f10173b == false) goto L28;
        r14 = r15.b(this.f10289c, r11);
        goto L28
    L17:
        if (r16.g() == true) goto L19;
    L21:
        boolean r17 = false;
    L22:
        if (r17 == false) goto L24;
        r10 = false;
        goto L24
    L19:
        if (r16.h() == false) goto L21;
        r17 = true;
    L31:
        return r14;
    L8:
        if ("swiper".equals(r5) == false) goto L10;
    L11:
        r14 = new XSwiperUI(this.f10289c, r11);
        goto L13
    L10:
        if ("x-swiper".equals(r5) == false) goto L12;
    L5:
        r13 = false;
        goto L6
    }

    public final UIShadowProxy f(LynxBaseUI r5, y0 r10) {
        UIShadowProxy r11 = null;
        if (r10 != null) goto L5;
    L8:
        return r11;
    L5:
        if (u(r10) == false) goto L7;
        r11 = new UIShadowProxy(this.f10289c, r5);
    L7:
        r5.updatePropertiesInterval(r10);
        goto L8
    }

    public final void g() {
        HashSet r5 = this.f10290h;
        if (r5.isEmpty() == false) goto L5;
        return;
    L5:
        HashSet r10 = new HashSet(r5);
        r5.clear();
        Iterator r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        ((LynxBaseUI) r11.next()).uiOwnerDidPerformLayout();
        goto L7
    L9:
        g();
    }

    public final void h(int r5, int r10) {
        com.lynx.tasm.u0 r11 = this.f10289c.K;
        if (r11 == null) goto L5;
        boolean r12 = r11.C;
    L6:
        if (r12 == false) goto L21;
        HashMap r13 = this.g;
        LynxBaseUI r14 = (LynxBaseUI) r13.get(Integer.valueOf(r5));
        if (r14 != null) goto L12;
        return;
    L12:
        if (r14.getTranslationZ() == r14.getLastTranslateZ()) goto L20;
        LynxBaseUI r15 = (LynxBaseUI) r13.get(Integer.valueOf(r10));
        if (r15 != null) goto L16;
    L18:
        LynxBaseUI r16 = (LynxBaseUI) r13.get(Integer.valueOf(r10));
        this.e.add(r16);
        r16.setNeedSortChildren(true);
        r14.setLastTranslateZ(r14.getTranslationZ());
        return;
    L16:
        if (r15.isFlatten() == false) goto L18;
        o(r10, false);
        goto L18
    L20:
        return;
    L21:
        return;
    L5:
        r12 = false;
        goto L6
    }

    public final void i(int r5, int r10, int r11) {
        HashMap r12 = this.g;
        if (r12.size() > 0) goto L5;
        return;
    L5:
        if (((LynxBaseUI) r12.get(Integer.valueOf(r5))) == null) goto L27;
        LynxBaseUI r13 = (LynxBaseUI) r12.get(Integer.valueOf(r10));
        if (r13 == null) goto L25;
        h(r10, r5);
        LynxBaseUI r14 = (LynxBaseUI) r12.get(Integer.valueOf(r5));
        if (r14.canHaveFlattenChild() == true) goto L14;
        if (r13.isFlatten() == false) goto L14;
        o(r10, false);
        r13 = (LynxBaseUI) r12.get(Integer.valueOf(r10));
    L14:
        if (r11 != (-1)) goto L16;
        r11 = r14.getChildren().size();
    L16:
        r14.insertChild(r13, r11);
        r(r14, r13, r11);
        if (r13.isFlatten() == false) goto L20;
        r14.flattenChildrenCountIncrement();
    L20:
        if (r13.isFlatten() == false) goto L22;
        A(r13);
        r13.requestLayout();
        r13.invalidate();
    L22:
        q(r13, 0);
        return;
    L25:
        throw new RuntimeException(com.lynx.jsbridge.a.d(r10, "Insertion (new) failed due to unknown child signature: "));
    L27:
        throw new RuntimeException(com.lynx.jsbridge.a.d(r5, "Insertion (new) failed due to unknown parent signature: "));
    }

    /* JADX WARN: Failed to calculate best type for var: r3v15 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v15 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r3v15 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v15 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v15 java.lang.String, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.applyResolvedVars(TypeSearch.java:100)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:76)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.runMultiVariableSearch(FixTypesVisitor.java:119)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 5 more
     */
    public final void j(int r51, int r52, int r53, int r54, int r55, int r56, int r57, int r58, int r59, int r60, int r61, int r62, int r63, int r64, int r65, int r66, int r67, Rect r68, float[] r69, float r70, int r71) {
        LynxBaseUI r5 = (LynxBaseUI) this.g.get(Integer.valueOf(r51));
        if (r5 != null) goto L6;
        LynxError r10 = new LynxError(60301, "Can't find ui tag", "", "error");
        r10.b("node_index", Integer.toString(r71));
        this.f10289c.b(r10);
        return;
    L6:
        boolean r11 = r5 instanceof UIShadowProxy;
        if (r11 == false) goto L9;
        LynxBaseUI r12 = ((UIShadowProxy) r5).f10388a;
    L10:
        r12.updateLayoutSize(r54, r55);
        if (r5.getLayoutAnimator() == null) goto L14;
        um.e r13 = r5.getLayoutAnimator();
        r13.f22377b = r52;
        r13.f22378c = r53;
        r13.d = r54;
        r13.e = r55;
        r13.f = r56;
        r13.g = r57;
        r13.f22379h = r58;
        r13.f22380i = r59;
        r13.f22385n = r60;
        r13.f22386o = r61;
        r13.f22387p = r62;
        r13.f22388q = r63;
        r13.f22381j = r64;
        r13.f22382k = r65;
        r13.f22383l = r66;
        r13.f22384m = r67;
        r13.f22389r = r68;
    L14:
        vm.i r14 = r5.getTransitionAnimator();
        if (TraceController.g == false) goto L18;
        TraceEvent.c("UIOwner.updateLayout." + r5.getTagName());
    L18:
        UIBody r15 = this.f10288b;
        if (r14 != null) goto L21;
        UIBody r46 = r15;
    L157:
        if (r5.enableLayoutAnimation() == true) goto L159;
    L244:
        LynxBaseUI r16 = r5;
        r16.updateLayout(r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68);
    L245:
        r16.updateSticky(r69);
        r16.updateMaxHeight(r70);
        q(r16, 3);
        if (TraceController.g == false) goto L253;
        TraceEvent.a(0, r4);
        return;
    L253:
        return;
    L159:
        if (this.f10293k == true) goto L244;
        int r17 = this.f10287a;
        if (r51 != r17) goto L165;
        if (r51 != r17) goto L244;
        if (this.f10294l == false) goto L244;
    L165:
        um.e r18 = r5.getLayoutAnimator();
        if (r11 == 0) goto L168;
        r5 = r5;
        LynxUI r19 = (LynxUI) ((UIShadowProxy) r5).f10388a;
    L169:
        r18.getClass();
        View r21 = r19.getView();
        r18.f22376a = new WeakReference(r19);
        r18.f22377b = r52;
        r18.f22378c = r53;
        r18.d = r54;
        r18.e = r55;
        r18.f = r56;
        r18.g = r57;
        r18.f22379h = r58;
        r18.f22380i = r59;
        r18.f22385n = r60;
        r18.f22386o = r61;
        r18.f22387p = r62;
        r18.f22388q = r63;
        r18.f22381j = r64;
        r18.f22382k = r65;
        r18.f22383l = r66;
        r18.f22384m = r67;
        r18.f22389r = r68;
        if (r18.f22394x != (-1.0f)) goto L173;
        if (r21 == null) goto L173;
        r18.f22394x = r21.getAlpha();
    L173:
        int r20 = r19.getSign();
        SparseArray r22 = r18.f22393w;
        um.h r110 = (um.h) r22.get(r20);
        if (r110 == null) goto L182;
        if (r21 != null) goto L177;
    L180:
        r22.remove(r20);
        goto L182
    L177:
        if (r21.getAnimation() == null) goto L180;
        ((um.k) r110).a(r52, r53, r54, r55);
    L179:
        r5 = r5;
    L243:
        r46.invalidate();
    L154:
        r16 = r5;
    L182:
        if (r19.getWidth() == 0) goto L184;
    L186:
        um.a r23 = r18.f22391u;
    L187:
        um.g r24 = r18.f22392v;
        if (r24 != null) goto L190;
    L203:
        um.g r25 = r18.f22392v;
        if (r25 != null) goto L206;
    L207:
        if (r54 != 0) goto L210;
        if (r55 != 0) goto L210;
        r19.updateLayout(r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68);
        r5 = r5;
    L210:
        if (r23 == null) goto L213;
        float r26 = r18.f22394x;
        if (r23.k() == false) goto L213;
        Animation r27 = r23.f(r19, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r26);
        if (r27 == null) goto L217;
        tm.b r28 = (tm.b) r23.f22372b;
        r27.setDuration(r28.f22141b);
        r27.setStartOffset(r28.f22142c);
        r27.setInterpolator(tm.e.a(r28));
    L217:
        Animation r29 = r27;
    L219:
        if ((r29 instanceof TranslateAnimation) == true) goto L221;
    L223:
        View r111 = r21;
        if (r29 != null) goto L233;
        float r30 = r18.f22394x;
        if (r30 == (-1.0f)) goto L228;
        r111.setAlpha(r30);
    L228:
        WeakReference r31 = r18.f22376a;
        if (r31 == null) goto L231;
        r31.clear();
    L231:
        r19.updateLayout(r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68);
        goto L243
    L233:
        if (r19.getWidth() == 0) goto L235;
    L237:
        r29.setAnimationListener(new um.c(r18, "layout-animation-update"));
        r18.a(r111, "layout-animation-update");
    L239:
        if ((r29 instanceof um.h) == false) goto L241;
        r19.requestLayout();
    L242:
        r19.onBeforeAnimation(r52, r53, r54, r55, r56, r57, r58, r59);
        r111.startAnimation(r29);
        goto L243
    L241:
        r19.updateLayout(r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68);
        goto L242
    L235:
        if (r19.getHeight() != 0) goto L237;
        r29.setAnimationListener(new um.c(r18, "layout-animation-create"));
        r18.a(r111, "layout-animation-create");
        goto L239
    L221:
        if ((r19.getParent() instanceof UIShadowProxy) == false) goto L223;
        r21 = ((LynxUI) r19.getParent()).getView();
    L213:
        r29 = null;
        goto L219
    L206:
        if (r25.k() == true) goto L210;
    L190:
        if (r24.k() == false) goto L203;
        if (r54 != 0) goto L203;
        if (r55 != 0) goto L203;
        View r32 = r19.getView();
        if (r32 == null) goto L179;
        r18.f22376a = new WeakReference(r19);
        um.g r33 = r18.f22392v;
        int r210 = r32.getLeft();
        int r211 = r32.getTop();
        int r212 = r32.getWidth();
        int r213 = r32.getHeight();
        Rect r37 = new Rect();
        float r34 = r18.f22394x;
        if (r33.k() == true) goto L199;
        Animation r35 = null;
    L200:
        if (r35 != null) goto L202;
        r19.updateLayout(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, new Rect());
        goto L179
    L202:
        r35.setAnimationListener(new um.c(r18, "layout-animation-delete"));
        r18.a(r32, "layout-animation-delete");
        r32.startAnimation(r35);
        goto L179
    L199:
        r35 = r33.f(r19, r210, r211, r212, r213, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r37, r34);
        tm.b r36 = (tm.b) r33.f22372b;
        r35.setDuration(r36.f22141b);
        r35.setStartOffset(r36.f22142c);
        r35.setInterpolator(tm.e.a(r36));
        goto L200
    L184:
        if (r19.getHeight() != 0) goto L186;
        r23 = r18.f22390t;
        goto L187
    L168:
        r5 = r5;
        r19 = (LynxUI) r5;
        goto L169
    L21:
        if (r14.f22605j.size() != 0) goto L23;
    L35:
        r46 = r15;
        goto L157
    L23:
        if (r14.e(256) == true) goto L37;
        if (r14.e(1024) == true) goto L37;
        if (r14.e(512) == true) goto L37;
        if (r14.e(2048) == true) goto L37;
        if (r14.e(16) == true) goto L37;
        if (r14.e(32) == false) goto L35;
    L37:
        if (this.f10293k == true) goto L35;
        if (r5.isFirstAnimatedReady() == true) goto L35;
        if (r11 == false) goto L42;
        LynxUI r38 = (LynxUI) ((UIShadowProxy) r5).f10388a;
    L43:
        if (r38 == null) goto L153;
        LynxUI r112 = r14.g;
        if (r112 != null) goto L50;
        r112 = r38;
    L50:
        if (r112.getOriginLeft() == r52) goto L52;
        boolean r39 = true;
    L54:
        if (r112.getOriginTop() == r53) goto L56;
        boolean r40 = true;
    L58:
        if (r112.getWidth() == r54) goto L60;
        boolean r41 = true;
    L62:
        if (r112.getHeight() == r55) goto L64;
        boolean r42 = true;
    L66:
        if ((r112.getWidth() + r112.getOriginLeft()) != (r52 + r54)) goto L68;
        boolean r43 = true;
    L70:
        if ((r112.getHeight() + r112.getOriginTop()) != (r53 + r55)) goto L72;
        boolean r44 = true;
    L73:
        int r45 = 256;
        r112.onBeforeAnimation(r52, r53, r54, r55, r56, r57, r58, r59);
        if (r20.e(256) == false) goto L76;
    L80:
        boolean r47 = true;
    L82:
        if (r20.e(512) == false) goto L84;
    L88:
        boolean r48 = true;
    L89:
        boolean r49 = r20.e(16);
        boolean r50 = r20.e(32);
        if (r47 == false) goto L92;
        if (r39 == false) goto L92;
    L94:
        int r113 = r112.getOriginLeft();
    L96:
        if (r48 == false) goto L98;
        if (r40 == false) goto L98;
    L100:
        int r114 = r112.getOriginTop();
    L102:
        if (r41 == false) goto L105;
        if (r49 == false) goto L105;
        int r115 = r112.getWidth();
    L106:
        if (r42 == false) goto L109;
        if (r50 == false) goto L109;
        int r214 = r112.getHeight();
    L110:
        r20.d(256);
        r20.d(1024);
        r20.d(512);
        r20.d(2048);
        r20.d(32);
        r20.d(16);
        r112.updateLayout(r113, r114, r115, r214, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68);
        HashMap r72 = new HashMap();
        int r73 = 0;
    L112:
        if (r73 >= r20.f22605j.size()) goto L150;
        tm.b r74 = (tm.b) r20.f22605j.valueAt(r73);
        int r75 = r74.d;
        if ((r75 & 3888) != 0) goto L117;
    L148:
        r73 = r73 + 1;
        r45 = 256;
        goto L112
    L117:
        if (r75 == 16) goto L141;
        if (r75 == 32) goto L133;
        if (r75 == r45) goto L130;
        if (r75 == 512) goto L127;
        if (r75 == 1024) goto L130;
        if (r75 != 2048) goto L148;
    L127:
        if (r40 == false) goto L148;
        r72.put(Integer.valueOf(r74.d), r20.a(r75, r112, r112.getOriginTop(), r53, r74, true));
    L130:
        if (r39 == false) goto L148;
        r72.put(Integer.valueOf(r74.d), r20.a(r75, r112, r112.getOriginLeft(), r52, r74, true));
        goto L148
    L133:
        if (r42 == false) goto L148;
        AnimatorSet r76 = new AnimatorSet();
        ArrayList r77 = new ArrayList();
        r77.add(r20.a(32, r112, r112.getHeight(), r55, r74, true));
        if (r40 == false) goto L139;
        if (r44 == false) goto L139;
        if (r48 == true) goto L139;
        r77.add(r20.a(512, r112, r112.getOriginTop(), r53, r74, false));
    L139:
        r76.playTogether(r77);
        r72.put(32, r76);
        goto L148
    L141:
        if (r41 == false) goto L148;
        AnimatorSet r78 = new AnimatorSet();
        ArrayList r79 = new ArrayList();
        r79.add(r20.a(16, r112, r112.getWidth(), r54, r74, true));
        if (r39 == false) goto L147;
        if (r43 == false) goto L147;
        if (r47 == true) goto L147;
        r79.add(r20.a(256, r112, r112.getOriginLeft(), r52, r74, false));
    L147:
        r78.playTogether(r79);
        r72.put(16, r78);
        goto L148
    L150:
        if (r72.isEmpty() == true) goto L152;
        r20.f22604i.putAll(r72);
    L152:
        r20.f22600a = r52;
        r20.f22601b = r53;
        r20.f22602c = r54;
        r20.d = r55;
    L109:
        r214 = r55;
    L105:
        r115 = r54;
    L98:
        if (r50 == false) goto L101;
        if (r44 == true) goto L100;
    L101:
        r114 = r53;
    L92:
        if (r49 == false) goto L95;
        if (r43 == true) goto L94;
    L95:
        r113 = r52;
        goto L96
    L84:
        if (r20.e(2048) == true) goto L88;
        r48 = false;
        goto L89
    L76:
        if (r14.e(1024) == true) goto L80;
        r47 = false;
        goto L82
    L72:
        r44 = false;
        goto L73
    L68:
        r43 = false;
        goto L70
    L64:
        r42 = false;
        goto L66
    L60:
        r41 = false;
        goto L62
    L56:
        r40 = false;
        goto L58
    L52:
        r39 = false;
    L153:
        r15.invalidate();
        goto L154
    L42:
        r38 = (LynxUI) r5;
        goto L43
    L9:
        r12 = r5;
        goto L10
    }

    public final void k(int r5, Object r10) {
        if (com.lynx.tasm.utils.j.j() == false) goto L15;
        LynxBaseUI r11 = (LynxBaseUI) this.g.get(Integer.valueOf(r5));
        if (r11 != null) goto L7;
        return;
    L7:
        if (TraceController.g == false) goto L9;
        String r12 = "UIOwner.updateViewExtraData." + r11.getTagName();
        TraceEvent.c(r12);
    L10:
        r11.updateExtraData(r10);
        if (TraceController.g == false) goto L17;
        TraceEvent.a(0, r12);
        return;
    L17:
        return;
    L9:
        r12 = null;
        goto L10
    L15:
        throw new AssertionError("Expected to run on UI thread!");
    }

    public final void l(int r17, String r18, ReadableMap r19, ReadableMapBuffer r20, ReadableArray r21, boolean r22, int r23, ReadableArray r24) {
        LynxBaseUI r12 = null;
        if (r19 == null) goto L5;
        y0 r13 = new y0(r19, r20);
    L6:
        HashMap r10 = on.a.a(r21);
        HashMap r11 = un.a.a(r24);
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L9:
        if (TraceController.g == false) goto L13;
        String r5 = "UIOwner.createView." + r18;     // Catch: Throwable -> L11
        TraceEvent.c(r5);     // Catch: Throwable -> L11
        String r15 = r5;
    L15:
        if (com.lynx.tasm.utils.j.j() == false) goto L40;
        r12 = c(new com.lynx.tasm.behavior.ui.z(r17, r23, r22, r18, r10, r11));     // Catch: Throwable -> L23
        LynxBaseUI r14 = b(r12, f(r12, r13), r13);     // Catch: Throwable -> L23
        if (r14 == null) goto L21;
        G(r18);     // Catch: Throwable -> L11
        m(r17, r18, r13);     // Catch: Throwable -> L11
        this.g.put(Integer.valueOf(r17), r14);     // Catch: Throwable -> L11
    L30:
        if (TraceController.g == false) goto L32;
        TraceEvent.a(0, r15);     // Catch: Throwable -> L11
    L32:
        monitor-exit(this);
        return;
    L21:
        String r16 = "createUI got null ui for tag:" + r18;     // Catch: Throwable -> L11
    L28:
        LynxLog.b(4, "LynxUIOwner", r16);     // Catch: Throwable -> L11
        goto L30
    L23:
        th = move-exception;
        RuntimeException r25 = new RuntimeException("createUI catch error while createUI for tag: " + r18 + ", " + th.getMessage(), th);     // Catch: Throwable -> L34
        r25.setStackTrace(th.getStackTrace());     // Catch: Throwable -> L34
        ((com.lynx.tasm.b0) this.f10288b.getLynxContext()).o(r25);     // Catch: Throwable -> L34
        if (r12 == null) goto L27;
        G(r18);     // Catch: Throwable -> L11
        m(r17, r18, r13);     // Catch: Throwable -> L11
        this.g.put(Integer.valueOf(r17), r12);     // Catch: Throwable -> L11
        goto L30
    L27:
        r16 = "createUI got null ui for tag:" + r18;     // Catch: Throwable -> L11
        goto L28
    L34:
        th = move-exception;
        if (r12 == null) goto L37;
        G(r18);     // Catch: Throwable -> L11
        m(r17, r18, r13);     // Catch: Throwable -> L11
        this.g.put(Integer.valueOf(r17), r12);     // Catch: Throwable -> L11
    L38:
        throw th;     // Catch: Throwable -> L11
    L37:
        LynxLog.b(4, "LynxUIOwner", "createUI got null ui for tag:" + r18);     // Catch: Throwable -> L11
        goto L38
    L40:
        throw new AssertionError("Expected to run on UI thread!");     // Catch: Throwable -> L11
    L13:
        r15 = null;
        goto L15
    L5:
        r13 = null;
        goto L6
    }

    public final void m(int r5, String r10, y0 r11) {
        if (r10.equals("component") == true) goto L5;
        return;
    L5:
        if (r11.f10815a.hasKey("ComponentID") == false) goto L12;
        String r12 = r11.f10815a.getString("ComponentID");
        if (r12 != null) goto L9;
        r12 = "-1";
    L9:
        this.f10291i.put(r12, Integer.valueOf(r5));
        return;
    }

    public final void n(int r5, final String r10, final boolean r11) {
        if (this.f10289c != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r10, "page") == false) goto L8;
        return;
    L8:
        if (this.f10298p == false) goto L18;
        HashMap r12 = this.f10300r;
        if (r12.containsKey(r10) == true) goto L19;
        r12.put(r10, Boolean.valueOf(r11));
        LynxBaseUI r13 = v(r5);
        if (r13 == null) goto L14;
        final String r14 = r13.getClass().getSimpleName();
    L15:
        LynxEventReporter.onEvent("lynxsdk_async_create_config", this.f10289c.A, new h0(r10, r14, r11));
        return;
    L14:
        r14 = null;
        goto L15
    L19:
        return;
    }

    public final void o(int r11, boolean r12) {
        HashMap r5 = this.g;
        LynxBaseUI r13 = (LynxBaseUI) r5.get(Integer.valueOf(r11));
        if (r13 == null) goto L42;
        LynxBaseUI r10 = r13.getParentBaseUI();
        y0 r14 = new y0(r13.getProps());
        ArrayList r15 = new ArrayList(r13.getChildren());
        if (TraceController.g == false) goto L8;
        String r16 = "UIOwner.updateFlatten." + r13.getTagName();
        TraceEvent.c(r16);
    L9:
        int r17 = 0;
        if (r10 == null) goto L12;
        int r18 = r10.getIndex(r13);
        F(r13);
        r10.removeChild(r13);
    L14:
        if (r13.isFlatten() == true) goto L19;
        Iterator r19 = r15.iterator();
    L17:
        if (r19.hasNext() == false) goto L19;
        F((LynxBaseUI) r19.next());
    L19:
        int r20 = r13.getChildren().size() - 1;
    L20:
        if (r20 < 0) goto L22;
        r13.removeChild(r13.getChildAt(r20));
        r20 = r20 - 1;
        goto L20
    L22:
        LynxBaseUI r110 = e(r13.getTagName(), r12, null);
        r13.applyUIPaintStylesToTarget(r110);
        r110.setSign(r13.getSign(), r13.getTagName());
        b(r110, f(r110, r14), r14);
        r5.put(Integer.valueOf(r13.getSign()), r110);
        HashSet r111 = this.e;
        if (r111.contains(r13) == false) goto L25;
        r111.remove(r13);
        r111.add(r110);
    L25:
        if (r10 == null) goto L27;
        r10.insertChild(r110, r18);
        r(r10, r110, r18);
    L27:
        Iterator r112 = r15.iterator();
    L29:
        if (r112.hasNext() == false) goto L31;
        LynxBaseUI r21 = (LynxBaseUI) r112.next();
        r21.setBound(null);
        r21.setLeft(r21.getOriginLeft());
        r21.setTop(r21.getOriginTop());
        r110.insertChild(r21, r17);
        r17 = r17 + 1;
        goto L29
    L31:
        A(r110);
        r110.updateLayoutInfo(r13);
        r110.copyPropFromOldUiInUpdateFlatten(r13);
        r110.measure();
        ((LynxUI) r110).handleLayout();
        if ((r110 instanceof UIGroup) == false) goto L34;
        ((UIGroup) r110).layoutChildren();
    L34:
        r110.invalidate();
        r13.destroy();
        if (TraceController.g == false) goto L41;
        TraceEvent.a(0, r16);
        return;
    L41:
        return;
    L12:
        r18 = 0;
        goto L14
    L8:
        r16 = null;
        goto L9
    }

    public final void p(LynxBaseUI r5) {
        int r10 = 0;
    L4:
        if (r10 >= r5.getChildren().size()) goto L6;
        LynxBaseUI r11 = r5.getChildAt(r10);
        r11.destroy();
        this.g.remove(Integer.valueOf(r11.getSign()));
        this.e.remove(r11);
        this.f10289c.c(r11);
        p(r11);
        r10 = r10 + 1;
        goto L4
    }

    public final void q(LynxBaseUI r5, int r10) {
        com.lynx.tasm.behavior.ui.accessibility.d r11 = this.f10288b.d;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.f10411k != null) goto L7;
        return;
    L7:
        if (r11.i() == false) goto L12;
        r11.f10411k.j(r10, r5, "");
        return;
    }

    public final void s(UIBody.UIBodyView r5) {
        UIBody r10 = this.f10288b;
        com.lynx.tasm.b0 r11 = this.f10289c;
        monitor-enter(r10);
        com.lynx.tasm.base.g r12 = new com.lynx.tasm.base.g(new com.lynx.tasm.behavior.ui.t(r10, r5, r11), r10.f);     // Catch: Throwable -> L9
        if (r10.e != null) goto L7;
        r12.run();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r10);
        if (this.f10295m == true) goto L14;
        return;
    L14:
        if (this.f10299q.isEmpty() == true) goto L28;
        FutureTask r13 = (FutureTask) this.f10299q.poll();
        if (r13 == null) goto L14;
        LynxEnv.runJavaTaskOnConcurrentLoop(new j0(r13), 0);
        goto L14
    L28:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void t(final String r5, int r10, final int r11, final boolean r12) {
        if (this.f10289c != null) goto L5;
        return;
    L5:
        if (this.f10298p == false) goto L13;
        LynxBaseUI r13 = v(r10);
        if (r13 == null) goto L9;
        final String r14 = r13.getClass().getSimpleName();
    L10:
        LynxEventReporter.onEvent("lynxsdk_async_create_success_event", this.f10289c.A, new i0(r5, r14, r12, r11));
        return;
    L9:
        r14 = null;
        goto L10
    }

    public final LynxBaseUI v(int r5) {
        HashMap r10 = this.g;
        if (r10 != null) goto L5;
        return null;
    L5:
        return (LynxBaseUI) r10.get(Integer.valueOf(r5));
    }

    public final LynxBaseUI w(String r5) {
        if (r5.isEmpty() == false) goto L5;
        return null;
    L5:
        HashMap r10 = this.g;
        Iterator r11 = r10.keySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L13;
        LynxBaseUI r12 = (LynxBaseUI) r10.get((Integer) r11.next());
        if (r12 == null) goto L7;
        if (r5.equals(r12.getAccessibilityId()) == false) goto L7;
        return r12;
    L13:
        return null;
    }

    public final void y() {
        UIBody r5 = this.f10288b;
        r5.layoutChildren();
        if (r5.getLynxContext().g == null) goto L8;
        com.lynx.tasm.r r10 = r5.getLynxContext().g;
        EventEmitter$LynxEventType r11 = EventEmitter$LynxEventType.f9957b;
        r10.getClass();
        com.lynx.tasm.q r12 = new com.lynx.tasm.q(r10, r11, null, 0);
        if (Looper.getMainLooper() != Looper.myLooper()) goto L7;
        r12.run();
        goto L8
    L7:
        r10.g.post(r12);
    L8:
        g();
    }

    public final void z(int r5, int r10) {
        HashMap r11 = this.g;
        if (r11.size() <= 0) goto L26;
        LynxBaseUI r12 = (LynxBaseUI) r11.get(Integer.valueOf(r10));
        if (r12 == null) goto L25;
        if (r5 != (-1)) goto L9;
        LynxBaseUI r13 = r12.getParentBaseUI();
    L10:
        if (r13 == null) goto L23;
        if (TraceController.g == false) goto L14;
        String r14 = "UIOwner.remove." + r13.getTagName() + "." + r12.getTagName();
        TraceEvent.c(r14);
    L15:
        F(r12);
        r13.removeChild(r12);
        r12.setBound(null);
        r12.setLeft(r12.getOriginLeft());
        r12.setTop(r12.getOriginTop());
        if (r12.isFlatten() == false) goto L18;
        r13.flattenChildrenCountDecrement();
    L18:
        r12.removeChildrenExposureUI();
        q(r12, 1);
        if (TraceController.g == false) goto L27;
        TraceEvent.a(0, r14);
        return;
    L27:
        return;
    L14:
        r14 = null;
        goto L15
    L23:
        throw new RuntimeException(com.lynx.jsbridge.a.d(r10, "Trying to remove unknown ui signature: "));
    L9:
        r13 = (LynxBaseUI) r11.get(Integer.valueOf(r5));
        goto L10
    L25:
        throw new RuntimeException(com.lynx.jsbridge.a.d(r10, "Trying to remove unknown ui signature: "));
    }
}
