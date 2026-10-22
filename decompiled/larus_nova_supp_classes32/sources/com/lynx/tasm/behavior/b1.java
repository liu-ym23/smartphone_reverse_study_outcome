package com.lynx.tasm.behavior;

import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.lynx.devtoolwrapper.LogBoxLogLevel;
import com.lynx.devtoolwrapper.LynxBaseInspectorController;
import com.lynx.devtoolwrapper.LynxBaseInspectorOwner;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.event.LynxTouchEvent;
import com.lynx.tasm.recording.LynxFrameRecorder;
import com.mammon.speechaudiosdk.session.type.SpeechEvent;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b1 {
    public long A;
    public LynxTouchEvent.a B;
    public LynxTouchEvent C;
    public EventTarget D;
    public String E;
    public LynxTouchEvent.a F;
    public UIGroup G;
    public boolean H;
    public boolean I;
    public boolean J;
    public final LynxUIOwner a;
    public final k b;
    public EventTarget c;
    public EventTarget d;
    public EventTarget e;
    public final HashMap<Integer, b> f;
    public final HashMap<Integer, v6a.a> g;
    public final LinkedList<EventTarget> h;
    public EventTarget i;
    public final LinkedList<EventTarget> j;
    public q7a.b k;
    public EventTarget.EnableStatus l;
    public boolean m;
    public PointF n;
    public float o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public final HashSet<Integer> u;
    public final HashSet<Integer> v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[EventTarget.PanInterceptScope.values().length];
            a = r0;
            r0[EventTarget.PanInterceptScope.Self.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            a[EventTarget.PanInterceptScope.Ancestors.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            a[EventTarget.PanInterceptScope.Descendants.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            a[EventTarget.PanInterceptScope.SelfAndAncestors.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            a[EventTarget.PanInterceptScope.SelfAndDescendants.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            a[EventTarget.PanInterceptScope.All.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public static class b {
        public final EventTarget a;
        public final PointF b;
        public PointF c;

        public b(EventTarget r1, float r2, float r3) {
            this.a = r1;
            this.b = new PointF(r2, r3);
            this.c = new PointF(r2, r3);
        }
    }

    public class c extends k.d {
        public final /* synthetic */ b1 a;

        public c(b1 r1) {
            this.a = r1;
        }
    }

    public final void B() {
        EventTarget r0 = this.c;
        if (r0 != null) goto L5;
    L13:
        Iterator<EventTarget> r1 = this.j.iterator();
    L15:
        if (r1.hasNext() == false) goto L17;
        r1.next().offResponseChain();
        goto L15
    L17:
        this.h.clear();
        this.j.clear();
        this.u.clear();
        this.v.clear();
        this.p = false;
        this.q = false;
        this.r = true;
        this.y = false;
        this.f.clear();
        this.g.clear();
        this.G = null;
        this.H = false;
        this.D = this.c;
        return;
    L5:
        if (r0.getChildrenLynxPageUI() == null) goto L13;
        UIBody r2 = (UIBody) this.c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.c)));
        if (r2 == null) goto L13;
        if (r2.getLynxContext() == null) goto L13;
        if (r2.getLynxContext().getTouchEventDispatcher() == null) goto L13;
        r2.getLynxContext().getTouchEventDispatcher().B();
        goto L13
    }

    public final EventEmitter l() {
        return this.a.getContext().getEventEmitter();
    }

    public final void D() {
        int r0 = ViewConfiguration.getLongPressTimeout();
        if (this.a.getContext().getLongPressDuration() < 0) goto L5;
        r0 = this.a.getContext().getLongPressDuration();
    L5:
        this.b.getClass();
        k.n = r0;
    }

    public b1(LynxUIOwner r7) {
        this.l = EventTarget.EnableStatus.Undefined;
        this.m = false;
        this.A = 0;
        this.I = false;
        this.J = false;
        this.a = r7;
        c r1 = new c(this);
        this.b = new k(r7.getContext(), r1, new Handler(Looper.getMainLooper()));
        this.h = new LinkedList();
        this.j = new LinkedList();
        this.n = new PointF(Float.MIN_VALUE, Float.MIN_VALUE);
        this.F = new LynxTouchEvent.a();
        this.o = com.lynx.tasm.utils.i.b(50.0f, 0.0f);
        this.r = true;
        this.u = new HashSet();
        this.v = new HashSet();
        this.w = false;
        this.y = false;
        this.z = false;
        this.f = new HashMap();
        this.g = new HashMap();
        this.k = r7.getGestureArenaManager();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean A(boolean r2) {
        if (this.a.getRootUI() != null) goto L5;
    L9:
        LLog.e("LynxTouchEventDispatcher", "requestNativeDisallowIntercept failed, root ui or root ui'parent is null.");
        return false;
    L5:
        if (((UIBody.UIBodyView) this.a.getRootUI().getView()).getParent() == null) goto L9;
        ((UIBody.UIBodyView) this.a.getRootUI().getView()).getParent().requestDisallowInterceptTouchEvent(r2);
        return r2;
    }

    public final int c(EventTarget r2) {
        return d(r2, this.u);
    }

    public final boolean e(MotionEvent r8) {
        int r0 = r8.getAction();
        boolean r1 = true;
        if (r0 != 0) goto L5;
        this.l = EventTarget.EnableStatus.Undefined;
        this.m = false;
        EventTarget r9 = this.c;
        if (r9 == null) goto L42;
    L35:
        if (r9 == null) goto L42;
        if (r9.parent() == r9) goto L42;
        if (r9.hasConsumeSlideEventAngles() == false) goto L41;
        this.m = true;
    L41:
        r9 = r9.parent();
    L42:
        boolean r10 = this.m;
        if (r10 == false) goto L45;
        A(r10);
    L45:
        return false;
    L5:
        if (r0 != 2) goto L28;
        if (this.m == true) goto L10;
        return false;
    L10:
        float r2 = r8.getX() - this.n.x;
        float r11 = r8.getY() - this.n.y;
        if (Math.abs(r2) > com.lynx.tasm.utils.i.b(10.0f, 0.0f)) goto L17;
        if (Math.abs(r11) > com.lynx.tasm.utils.i.b(10.0f, 0.0f)) goto L17;
        A(true);
        return false;
    L17:
        if (this.l != EventTarget.EnableStatus.Undefined) goto L28;
        this.l = EventTarget.EnableStatus.Disable;
        double r3 = (Math.atan2(r11, r2) * ((double) 180.0f)) / 3.141592653589793d;
        EventTarget r12 = this.c;
    L20:
        if (r12 == null) goto L28;
        if (r12.parent() == r12) goto L28;
        if (r12.consumeSlideEvent((float) r3) == true) goto L25;
        r12 = r12.parent();
        goto L20
    L25:
        this.l = EventTarget.EnableStatus.Enable;
    L28:
        if (this.l == EventTarget.EnableStatus.Enable) goto L32;
        r1 = false;
    L32:
        return A(r1);
    }

    public final void g(int r8) {
        if (l() != null) goto L5;
        return;
    L5:
        Iterator<EventTarget> r0 = this.h.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        EventTarget r1 = r0.next();
        if (this.w == false) goto L11;
        l().onPseudoStatusChanged(r1.getSign(), r1.getPseudoStatus(), r1.getPseudoStatus() & (~r8));
    L11:
        r1.onPseudoStatusChanged(r1.getPseudoStatus(), r1.getPseudoStatus() & (~r8));
        goto L7
    }

    public final void h(MotionEvent r4) {
        EventTarget r0 = this.c;
        if (r0 == null) goto L5;
        r0.dispatchTouch(r4);
    L5:
        EventTarget r1 = this.c;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.getChildrenLynxPageUI() == null) goto L24;
        UIBody r2 = (UIBody) this.c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.c)));
        if (r2 != null) goto L12;
        return;
    L12:
        if (r2.getLynxContext() != null) goto L14;
        return;
    L14:
        if (r2.getLynxContext().getTouchEventDispatcher() == null) goto L27;
        PointF r3 = w(r4);
        r2.getLynxContext().getTouchEventDispatcher().h(r4);     // Catch: Throwable -> L18
        r4.setLocation(r3.x, r3.y);
        return;
    L18:
        th = move-exception;
        r4.setLocation(r3.x, r3.y);
        throw th;
    L27:
        return;
    }

    public final void k(MotionEvent r24) {
        q7a.b r0 = this.k;
        if (r0 == null) goto L71;
        LynxTouchEvent r10 = this.C;
        if (r0.d() == false) goto L71;
        t7a.d r11 = r0.h;
        if (r11 == null) goto L71;
        LinkedList<p7a.a> r15 = r0.b;
        LinkedList<p7a.a> r1 = r0.c;
        int r2 = r24.getActionMasked();
        int r12 = 0;
        if (r2 == 0) goto L43;
        if (r2 != 1) goto L14;
    L25:
        r11.b(r11.j, r24.getX(), r24.getY(), null, r15, r24);
        VelocityTracker r3 = r11.f;
        if (r3 == null) goto L28;
        r3.computeCurrentVelocity(1000);
        r12 = com.lynx.tasm.behavior.ui.utils.h.h(r11.b, r11.f.getXVelocity());
        int r4 = com.lynx.tasm.behavior.ui.utils.h.h(r11.b, r11.f.getYVelocity());
    L30:
        if (r11.j != null) goto L32;
    L41:
        r11.b(r11.j, Float.MIN_VALUE, Float.MIN_VALUE, null, r15, null);
        goto L71
    L32:
        if (Math.abs(r12) <= 300) goto L34;
    L35:
        p7a.a r5 = r11.j;
        if (r5 == null) goto L71;
        if (r11.f == null) goto L71;
        r11.l = r5;
        r11.a.fling(r5.getMemberScrollX(), r11.l.getMemberScrollY(), (int) (-r11.f.getXVelocity()), (int) (-r11.f.getYVelocity()), Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
        r11.l.onInvalidate();
        r11.c = r11.l.getMemberScrollX();
        r11.d = r11.l.getMemberScrollY();
        goto L71
    L34:
        if (Math.abs(r4) <= 300) goto L41;
    L28:
        r4 = 0;
        goto L30
    L14:
        if (r2 != 2) goto L16;
        VelocityTracker r6 = r11.f;
        if (r6 == null) goto L21;
        r6.addMovement(r24);
    L21:
        p7a.a r7 = r11.e(r15, r11.j);
        r11.j = r7;
        if (r7 != r11.k) goto L24;
        r11.b(r7, r24.getX(), r24.getY(), r10, null, r24);
    L24:
        r11.c(r10, r15, r24.getX(), r24.getY(), r24);
        goto L71
    L16:
        if (r2 == 3) goto L25;
    L43:
        if (r15 == null) goto L50;
        Iterator<p7a.a> r8 = r15.iterator();
    L47:
        if (r8.hasNext() == false) goto L49;
        r11.g(r8.next());
        goto L47
    L49:
        r11.i = null;
    L50:
        if (r1 == null) goto L66;
        Iterator<p7a.a> r9 = r1.iterator();
    L54:
        if (r9.hasNext() == false) goto L66;
        p7a.a r13 = r9.next();
        if (r11.j == null) goto L60;
        if (r11.e != r13.getGestureArenaMemberId()) goto L60;
    L61:
        r11.e = 0;
        if (r11.a.isFinished() == true) goto L66;
        r11.b(r11.j, 0.0f, 0.0f, r10, r15, r24);
        r11.a.abortAnimation();
        LynxContext r14 = r11.b;
        if (r14 == null) goto L66;
        r14.onGestureRecognized();
    L60:
        if (r11.e != 0) goto L54;
    L66:
        r11.b(r11.j, r24.getX(), r24.getY(), r10, r15, r24);
        r11.c(r10, r15, r24.getX(), r24.getY(), r24);
        VelocityTracker r16 = r11.f;
        if (r16 != null) goto L69;
        r11.f = VelocityTracker.obtain();
    L70:
        r11.f.addMovement(r24);
        goto L71
    L69:
        r16.clear();
    L71:
        EventTarget r17 = this.c;
        if (r17 != null) goto L74;
        return;
    L74:
        if (r17.getChildrenLynxPageUI() == null) goto L95;
        UIBody r18 = (UIBody) this.c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.c)));
        if (r18 != null) goto L78;
        return;
    L78:
        if (r18.getLynxContext() != null) goto L80;
        return;
    L80:
        if (r18.getLynxContext().getTouchEventDispatcher() == null) goto L98;
        PointF r19 = w(r24);
        r18.getLynxContext().getTouchEventDispatcher().k(r24);     // Catch: Throwable -> L84
        r24.setLocation(r19.x, r19.y);
        return;
    L84:
        th = move-exception;
        r24.setLocation(r19.x, r19.y);
        throw th;
    L98:
        return;
    }

    public final void n(MotionEvent r4) {
        if (this.j.isEmpty() == false) goto L5;
        return;
    L5:
        if (this.j.getLast() == null) goto L54;
        int r0 = c(this.j.getLast());
        int r1 = d(this.j.getLast(), this.v);
        if (this.z == false) goto L12;
        if (this.y == false) goto L12;
        return;
    L12:
        if (this.t == false) goto L14;
        return;
    L14:
        if (this.s == false) goto L16;
        return;
    L16:
        if (this.j.isEmpty() == false) goto L18;
        return;
    L18:
        if (this.j.getLast() != null) goto L20;
        return;
    L20:
        if (r0 != (-1)) goto L46;
        if (r1 != (-1)) goto L47;
        i(this.j.getLast(), LynxTouchEvent.EVENT_CLICK, r4);
        EventTarget r2 = this.c;
        if (r2 != null) goto L25;
        return;
    L25:
        if (r2.getChildrenLynxPageUI() == null) goto L49;
        UIBody r3 = (UIBody) this.c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.c)));
        if (r3 != null) goto L29;
        return;
    L29:
        if (r3.getLynxContext() != null) goto L31;
        return;
    L31:
        if (r3.getLynxContext().getTouchEventDispatcher() == null) goto L52;
        PointF r5 = w(r4);
        r3.getLynxContext().getTouchEventDispatcher().n(r4);     // Catch: Throwable -> L35
        r4.setLocation(r5.x, r5.y);
        return;
    L35:
        th = move-exception;
        r4.setLocation(r5.x, r5.y);
        throw th;
    L52:
        return;
    L49:
        return;
    L47:
        return;
    L46:
        return;
    }

    public final void o(MotionEvent r5) {
        LynxUIOwner r0 = this.a;
        l r1 = null;
        if (r0 == null) goto L11;
        LynxContext r2 = r0.getContext();
        if (r2 == null) goto L11;
        if (r2.isFragmentLayerRenderOn() == false) goto L11;
        r1 = this.a.getPaintingContext();
    L11:
        if (r1 == null) goto L14;
        r1.e();
        return;
    L14:
        int r3 = c(this.c);
        int r4 = d(this.c, this.v);
        if (this.z == true) goto L17;
    L18:
        EventTarget r6 = this.c;
        if (r6 != null) goto L21;
        return;
    L21:
        if (r3 != (-1)) goto L43;
        if (r4 != (-1)) goto L44;
        i(r6, LynxTouchEvent.EVENT_LONG_PRESS, r5);
        EventTarget r7 = this.c;
        if (r7 != null) goto L26;
        return;
    L26:
        if (r7.getChildrenLynxPageUI() == null) goto L46;
        UIBody r8 = (UIBody) this.c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.c)));
        if (r8 != null) goto L30;
        return;
    L30:
        if (r8.getLynxContext() != null) goto L32;
        return;
    L32:
        if (r8.getLynxContext().getTouchEventDispatcher() == null) goto L49;
        PointF r9 = w(r5);
        r8.getLynxContext().getTouchEventDispatcher().o(r5);     // Catch: Throwable -> L36
        r5.setLocation(r9.x, r9.y);
        return;
    L36:
        th = move-exception;
        r5.setLocation(r9.x, r9.y);
        throw th;
    L49:
        return;
    L46:
        return;
    L44:
        return;
    L43:
        return;
    L17:
        if (this.y == false) goto L18;
    }

    public final void p(MotionEvent r5) {
        int r0 = c(this.c);
        int r1 = d(this.c, this.v);
        if (this.z == false) goto L7;
        if (this.y == false) goto L7;
    L33:
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L35;
        C("LynxTouchEventDispatcher: tap failed due to [gesture] " + this.s + ", [move] " + this.p + ", [slide] " + r0 + ", [props] " + r1, LogBoxLogLevel.Warn.ordinal());
    L35:
        LLog.i("LynxTouchEventDispatcher", "tap failed:" + this.s + " " + this.p + " " + r0 + " " + r1);
        return;
    L7:
        if (this.s == true) goto L33;
        if (this.p == true) goto L33;
        if (r0 != (-1)) goto L33;
        if (r1 != (-1)) goto L33;
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L16;
        C("LynxTouchEventDispatcher: fire tap for target " + this.c.getSign(), LogBoxLogLevel.Info.ordinal());
    L16:
        i(this.c, LynxTouchEvent.EVENT_TAP, r5);
        EventTarget r2 = this.c;
        if (r2 != null) goto L19;
        return;
    L19:
        if (r2.getChildrenLynxPageUI() == null) goto L40;
        UIBody r3 = (UIBody) this.c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.c)));
        if (r3 != null) goto L23;
        return;
    L23:
        if (r3.getLynxContext() != null) goto L25;
        return;
    L25:
        if (r3.getLynxContext().getTouchEventDispatcher() == null) goto L43;
        PointF r4 = w(r5);
        r3.getLynxContext().getTouchEventDispatcher().p(r5);     // Catch: Throwable -> L29
        r5.setLocation(r4.x, r4.y);
        return;
    L29:
        th = move-exception;
        r5.setLocation(r4.x, r4.y);
        throw th;
    L43:
        return;
    }

    public final void r(MotionEvent r7) {
        EventTarget r0 = this.c;
        if (r0 == null) goto L36;
        if (r0.ignoreFocus() == true) goto L36;
        if (this.s == true) goto L36;
        if (c(this.c) != (-1)) goto L36;
        if (d(this.c, this.v) != (-1)) goto L36;
        EventTarget r1 = this.i;
        EventTarget r3 = this.c;
        this.i = r3;
        if (r3 == r1) goto L36;
        boolean r4 = true;
        if (r3 != null) goto L17;
    L25:
        if (r1 == null) goto L36;
        if (r1.isFocusable() == false) goto L36;
        EventTarget r5 = this.c;
        if (r5 != null) goto L31;
    L33:
        r4 = false;
    L34:
        r1.onFocusChanged(false, r4);
        goto L36
    L31:
        if (r5.isFocusable() == false) goto L33;
    L17:
        if (r3.isFocusable() == false) goto L25;
        EventTarget r6 = this.c;
        if (r1 != null) goto L21;
    L23:
        boolean r8 = false;
    L24:
        r6.onFocusChanged(true, r8);
        goto L25
    L21:
        if (r1.isFocusable() == false) goto L23;
        r8 = true;
    L36:
        if (this.z == false) goto L38;
        JavaOnlyMap r2 = new JavaOnlyMap();
        b(r2, r7, 0);
        j(LynxTouchEvent.EVENT_TOUCH_END, r7, r2);
    L39:
        g(-1);
        EventTarget r9 = this.c;
        if (r9 != null) goto L42;
        return;
    L42:
        if (r9.getChildrenLynxPageUI() == null) goto L58;
        UIBody r10 = (UIBody) this.c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.c)));
        if (r10 != null) goto L46;
        return;
    L46:
        if (r10.getLynxContext() != null) goto L48;
        return;
    L48:
        if (r10.getLynxContext().getTouchEventDispatcher() == null) goto L61;
        PointF r11 = w(r7);
        r10.getLynxContext().getTouchEventDispatcher().r(r7);     // Catch: Throwable -> L52
        r7.setLocation(r11.x, r11.y);
        return;
    L52:
        th = move-exception;
        r7.setLocation(r11.x, r11.y);
        throw th;
    L61:
        return;
    L58:
        return;
    L38:
        i(this.c, LynxTouchEvent.EVENT_TOUCH_END, r7);
        goto L39
    }

    public final void t(MotionEvent r4) {
        int r0 = r4.getActionIndex();
        if (this.z == true) goto L5;
    L8:
        this.f.remove(Integer.valueOf(r4.getPointerId(r0)));
        EventTarget r1 = this.c;
        if (r1 != null) goto L11;
        return;
    L11:
        if (r1.getChildrenLynxPageUI() == null) goto L27;
        UIBody r2 = (UIBody) this.c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.c)));
        if (r2 != null) goto L15;
        return;
    L15:
        if (r2.getLynxContext() != null) goto L17;
        return;
    L17:
        if (r2.getLynxContext().getTouchEventDispatcher() == null) goto L30;
        PointF r3 = w(r4);
        r2.getLynxContext().getTouchEventDispatcher().t(r4);     // Catch: Throwable -> L21
        r4.setLocation(r3.x, r3.y);
        return;
    L21:
        th = move-exception;
        r4.setLocation(r3.x, r3.y);
        throw th;
    L30:
        return;
    L27:
        return;
    L5:
        if (r4.getPointerId(r0) != 0) goto L7;
        g(-1);
    L7:
        JavaOnlyMap r5 = new JavaOnlyMap();
        b(r5, r4, r0);
        j(LynxTouchEvent.EVENT_TOUCH_END, r4, r5);
        goto L8
    }

    public final void u(MotionEvent r5) {
        if (this.z == false) goto L9;
        JavaOnlyMap r0 = new JavaOnlyMap();
        Iterator<b> r2 = this.f.values().iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        b r3 = r2.next();
        b(r0, r5, 0);
        goto L6
    L8:
        j(LynxTouchEvent.EVENT_TOUCH_CANCEL, r5, r0);
    L10:
        g(-1);
        EventTarget r1 = this.c;
        if (r1 != null) goto L13;
        return;
    L13:
        if (r1.getChildrenLynxPageUI() == null) goto L30;
        UIBody r4 = (UIBody) this.c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.c)));
        if (r4 != null) goto L17;
        return;
    L17:
        if (r4.getLynxContext() != null) goto L19;
        return;
    L19:
        if (r4.getLynxContext().getTouchEventDispatcher() == null) goto L33;
        PointF r6 = w(r5);
        r4.getLynxContext().getTouchEventDispatcher().u(r5);     // Catch: Throwable -> L23
        r5.setLocation(r6.x, r6.y);
        return;
    L23:
        th = move-exception;
        r5.setLocation(r6.x, r6.y);
        throw th;
    L33:
        return;
    L30:
        return;
    L9:
        i(this.c, LynxTouchEvent.EVENT_TOUCH_CANCEL, r5);
        goto L10
    }

    public final void v(MotionEvent r6) {
        int r1 = 0;
        if (this.r == false) goto L11;
        float r0 = r6.getX(0) - this.n.x;
        float r3 = r6.getY(0) - this.n.y;
        if (Math.abs(r0) <= 0.0f) goto L7;
    L10:
        this.r = false;
        goto L11
    L7:
        if (Math.abs(r3) > 0.0f) goto L10;
        boolean r2 = false;
    L12:
        if (r2 == false) goto L26;
        this.q = true;
        if (this.z == false) goto L24;
        JavaOnlyMap r4 = new JavaOnlyMap();
    L17:
        if (r1 >= r6.getPointerCount()) goto L22;
        if (y(r6, r1) == false) goto L21;
        b(r4, r6, r1);
    L21:
        r1 = r1 + 1;
        goto L17
    L22:
        j(LynxTouchEvent.EVENT_TOUCH_MOVE, r6, r4);
        goto L26
    L24:
        if (y(r6, 0) == false) goto L26;
        i(this.c, LynxTouchEvent.EVENT_TOUCH_MOVE, r6);
    L26:
        EventTarget r5 = this.c;
        if (r5 != null) goto L29;
        return;
    L29:
        if (r5.getChildrenLynxPageUI() == null) goto L48;
        UIBody r7 = (UIBody) this.c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.c)));
        if (r7 != null) goto L33;
        return;
    L33:
        if (r7.getLynxContext() != null) goto L35;
        return;
    L35:
        if (r7.getLynxContext().getTouchEventDispatcher() == null) goto L51;
        PointF r8 = w(r6);
        r7.getLynxContext().getTouchEventDispatcher().v(r6);     // Catch: Throwable -> L39
        r6.setLocation(r8.x, r8.y);
        return;
    L39:
        th = move-exception;
        r6.setLocation(r8.x, r8.y);
        throw th;
    L51:
        return;
    L48:
        return;
    L11:
        r2 = true;
        goto L12
    }

    public final PointF w(MotionEvent r4) {
        PointF r0 = new PointF(r4.getX(), r4.getY());
        r4.setLocation(this.C.getViewPoint().a, this.C.getViewPoint().b);
        return r0;
    }

    public static int d(EventTarget r1, HashSet r2) {
        if (r1 != null) goto L5;
        return 0;
    L5:
        if (r2 != null) goto L7;
    L16:
        return -1;
    L7:
        if (r2.isEmpty() == true) goto L16;
    L9:
        if (r1 == null) goto L16;
        if (r1.parent() == r1) goto L16;
        if (r2.contains(Integer.valueOf(r1.getSign())) == true) goto L21;
        r1 = r1.parent();
        goto L9
    L21:
        return r1.getSign();
    }

    public final void C(String r2, int r3) {
        if (this.a.getRootUI() != null) goto L5;
        return;
    L5:
        if (this.a.getRootUI().getBodyView() == null) goto L13;
        LynxBaseInspectorController r0 = ((LynxView) this.a.getRootUI().getBodyView()).getBaseInspectorController();
        if (r0 != null) goto L10;
        return;
    L10:
        r0.showMessageOnConsole(r2, r3);
        return;
    }

    public final LynxTouchEvent.a f(EventTarget r5, LynxTouchEvent.a r6) {
        if ((r5 instanceof LynxBaseUI) == false) goto L10;
        LynxBaseUI r7 = (LynxBaseUI) r5;
        if (this.a.getContext().getEnableTransformedTouchPosition() == false) goto L8;
        PointF r8 = com.lynx.tasm.behavior.ui.utils.h.a(this.a.getRootUI(), r7, new PointF(r6.a, r6.b));
        return new LynxTouchEvent.a(r8.x, r8.y);
    L8:
        RectF r9 = com.lynx.tasm.behavior.ui.utils.h.e(r7, new RectF(0.0f, 0.0f, r7.getWidth(), r7.getHeight()));
        return new LynxTouchEvent.a(r6.a - r9.left, r6.b - r9.top);
    L10:
        return r6;
    }

    public final boolean q(MotionEvent r19, UIGroup r20) {
        LynxTouchEvent.a r0 = this.F;
        r0.a = 0.0f;
        r0.b = 0.0f;
        this.c = m(r19, 0, r20);
        LynxTouchEvent.a r3 = new LynxTouchEvent.a(r19.getX(), r19.getY());
        this.F = r3;
        EventTarget r4 = this.c;
        if ((r4 instanceof LynxBaseUI) == false) goto L5;
        this.F = f(r4, r3);
    L5:
        EventTarget r5 = this.c;
        if (r5 == null) goto L10;
        LynxTouchEvent.a r6 = this.F;
        if (r5.eventThrough(r6.a, r6.b) == false) goto L10;
        return false;
    L10:
        this.p = false;
        this.q = false;
        this.r = true;
        this.n = new PointF(r19.getX(), r19.getY());
        this.s = false;
        new PointF(r19.getX(), r19.getY());
        this.u.clear();
        this.v.clear();
        this.y = false;
        this.f.clear();
        this.g.clear();
        this.j.clear();
        EventTarget r7 = this.c;
        if (r7 == null) goto L30;
    L13:
        if (r7 == null) goto L16;
        this.j.push(r7);
        r7 = r7.parent();
    L16:
        if (this.j.isEmpty() == true) goto L22;
        if (this.j.getLast().getEvents() == null) goto L21;
        if (this.j.getLast().getEvents().containsKey(LynxTouchEvent.EVENT_CLICK) == true) goto L22;
    L21:
        this.j.removeLast();
    L22:
        Iterator<EventTarget> r8 = this.j.iterator();
    L24:
        if (r8.hasNext() == false) goto L27;
        r8.next().onResponseChain();
        goto L24
    L27:
        if (this.j.isEmpty() == false) goto L29;
        this.t = true;
        goto L30
    L29:
        this.t = false;
    L30:
        this.J = false;
        EventTarget r9 = this.e;
        if (r9 == null) goto L33;
        r9.setPanInterceptSelf(false);
        this.e.setPanInterceptAncestors(false);
        this.e.setPanInterceptDescendants(false);
    L33:
        List r10 = null;
        this.e = null;
        this.d = null;
        EventTarget r11 = this.c;
        if (r11 == null) goto L45;
    L35:
        if (r11 == null) goto L42;
        if (r11.parent() == r11) goto L42;
        if (r11.panInterceptDirection() != EventTarget.PanInterceptDirection.None) goto L40;
        r11 = r11.parent();
        goto L35
    L40:
        this.d = r11;
    L42:
        EventTarget r12 = this.d;
        if (r12 == null) goto L45;
        r12.setPanInterceptAncestors(true);
    L45:
        this.f.put(Integer.valueOf(r19.getPointerId(0)), new b(this.c, r19.getX(0), r19.getY(0)));
        this.g.put(Integer.valueOf(this.c.getSign()), this.c);
        q7a.b r13 = this.k;
        if (r13 == null) goto L189;
        EventTarget r14 = this.c;
        if (r13.d() == false) goto L189;
        r13.g = null;
        LinkedList<p7a.a> r15 = r13.c;
        if (r15 == null) goto L53;
        r15.clear();
    L53:
        LinkedList<p7a.a> r16 = r13.b;
        if (r16 == null) goto L56;
        r16.clear();
    L56:
        Map<Integer, WeakReference<p7a.a>> r17 = r13.a;
        if (r17 == null) goto L189;
        if (((HashMap) r17).isEmpty() == true) goto L189;
        if (r13.h == null) goto L189;
    L63:
        if (r14 == null) goto L79;
        Iterator r18 = ((HashMap) r13.a).values().iterator();
    L66:
        if (r18.hasNext() == false) goto L78;
        WeakReference r21 = (WeakReference) r18.next();
        if (r21 == null) goto L66;
        p7a.a r22 = (p7a.a) r21.get();
        if (r22 == null) goto L66;
        if (r22.getGestureArenaMemberId() <= 0) goto L66;
        if (r22.getGestureArenaMemberId() != r14.getGestureArenaMemberId()) goto L66;
        r13.c.add(r22);
        goto L66
    L78:
        r14 = r14.parent();
        goto L63
    L79:
        s7a.b r23 = r13.e;
        if (r23 == null) goto L180;
        LinkedList<p7a.a> r24 = r13.c;
        LinkedList<p7a.a> r25 = new LinkedList();
        if (r24 != null) goto L84;
    L179:
        r13.b = r25;
        goto L180
    L84:
        if (r24.isEmpty() == true) goto L179;
        int r26 = 0;
    L88:
        if (r26 >= r24.size()) goto L179;
        p7a.a r110 = r24.get(r26);
        Map<Integer, s7a.a> r111 = r110.getGestureDetectorMap();
        if (r111 != null) goto L92;
        r25.add(r110);
    L178:
        r26 = r26 + 1;
        r10 = null;
        goto L88
    L92:
        Iterator r112 = new TreeMap(r111).entrySet().iterator();
        List r113 = r10;
        List r114 = r113;
    L94:
        if (r112.hasNext() == false) goto L104;
        Map.Entry r115 = (Map.Entry) r112.next();
        List r116 = (List) ((HashMap) ((s7a.a) r115.getValue()).d).get("waitFor");
        List r117 = (List) ((HashMap) ((s7a.a) r115.getValue()).d).get("continueWith");
        if (r116 != null) goto L98;
    L99:
        if (r117 == null) goto L103;
        if (r117.isEmpty() == true) goto L103;
    L102:
        r114 = r117;
        r113 = r116;
    L103:
        r114 = r117;
        r113 = r116;
        goto L94
    L98:
        if (r116.isEmpty() == false) goto L102;
    L104:
        if (r114 != null) goto L106;
    L107:
        if (r113 != null) goto L109;
    L177:
        r25.add(r110);
        goto L178
    L109:
        if (r113.isEmpty() == true) goto L177;
    L111:
        if (r113 != null) goto L113;
    L149:
        r25.add(r110);
    L150:
        if (r114 == null) goto L178;
        if (r114.isEmpty() == true) goto L178;
        LinkedHashSet r1 = new LinkedHashSet();
        Iterator r27 = r114.iterator();
    L155:
        if (r27.hasNext() == false) goto L160;
        Integer r28 = (Integer) r27.next();
        if (((HashMap) r23.a).get(r28) == null) goto L155;
        r1.addAll((Collection) ((HashMap) r23.a).get(r28));
        goto L155
    L160:
        if (r23.a != null) goto L162;
    L172:
        LinkedList r29 = null;
    L173:
        if (r29 == null) goto L179;
        if (r29.isEmpty() == true) goto L179;
        r25.addAll(r29);
        goto L179
    L162:
        if (r23.b == null) goto L172;
        r29 = new LinkedList();
        Iterator r2 = r1.iterator();
    L166:
        if (r2.hasNext() == false) goto L173;
        Integer r30 = (Integer) r2.next();
        q7a.b r31 = r23.b;
        int r32 = r30.intValue();
        Map<Integer, WeakReference<p7a.a>> r33 = r31.a;
        HashMap r34 = (HashMap) r33;
        WeakReference r35 = (WeakReference) r34.get(Integer.valueOf(r32));
        if (r35 == null) goto L170;
        p7a.a r36 = (p7a.a) r35.get();
    L171:
        r29.add(r36);
        goto L166
    L170:
        r36 = null;
        goto L171
    L113:
        if (r113.isEmpty() == true) goto L149;
        LinkedHashSet r118 = new LinkedHashSet();
        Iterator r119 = r113.iterator();
    L116:
        if (r119.hasNext() == false) goto L120;
        Integer r120 = (Integer) r119.next();
        if (((HashMap) r23.a).get(r120) == null) goto L116;
        r118.addAll((Collection) ((HashMap) r23.a).get(r120));
        goto L116
    L120:
        int r121 = r24.lastIndexOf(r110);
        if (r121 >= 0) goto L123;
    L136:
        LinkedList r122 = null;
    L137:
        if (r122 != null) goto L139;
    L148:
        r25.add(r110);
        goto L178
    L139:
        if (r122.isEmpty() == true) goto L148;
        Iterator r37 = r122.iterator();
    L143:
        if (r37.hasNext() == false) goto L147;
        Integer r38 = (Integer) r37.next();
        if (r24.get(r38.intValue()) == null) goto L143;
        r25.add(r24.get(r38.intValue()));
        goto L143
    L147:
        r25.add(r110);
        r26 = r24.size();
        goto L150
    L123:
        if (r121 >= r24.size()) goto L136;
        r122 = new LinkedList();
        Iterator r123 = r118.iterator();
    L127:
        if (r123.hasNext() == false) goto L137;
        int r124 = ((Integer) r123.next()).intValue();
        int r39 = r121 + 1;
    L130:
        if (r39 >= r24.size()) goto L127;
        if (r124 != r24.get(r39).getGestureArenaMemberId()) goto L134;
        r122.add(Integer.valueOf(r39));
    L134:
        r39 = r39 + 1;
        goto L130
    L106:
        if (r114.isEmpty() == false) goto L111;
    L180:
        LinkedList<p7a.a> r40 = r13.b;
        if (r40 != null) goto L183;
    L185:
        t7a.d r41 = r13.h;
        p7a.a r42 = r13.g;
        r41.j = r42;
        if (r41.k == r42) goto L188;
        r41.k = r42;
    L188:
        r41.h(r42);
        r41.g(r41.j);
        r41.n = new r7a.a();
        goto L189
    L183:
        if (r40.isEmpty() == true) goto L185;
        r13.g = r13.b.getFirst();
    L189:
        D();
        if (this.z == false) goto L192;
        JavaOnlyMap r43 = new JavaOnlyMap();
        b(r43, r19, 0);
        j(LynxTouchEvent.EVENT_TOUCH_START, r19, r43);
    L194:
        if (l() == null) goto L210;
        EventTarget r44 = this.c;
    L197:
        if (r44 == null) goto L202;
        this.h.push(r44);
        if (r44.enableTouchPseudoPropagation() == false) goto L202;
        r44 = r44.parent();
    L202:
        int r45 = 0;
    L204:
        if (r45 >= this.h.size()) goto L210;
        EventTarget r46 = this.h.get(r45);
        if (this.w == false) goto L208;
        int r47 = 0;
        l().onPseudoStatusChanged(r46.getSign(), 0, 8);
    L209:
        r46.onPseudoStatusChanged(r47, 8);
        r45 = r45 + 1;
        goto L204
    L208:
        r47 = 0;
    L210:
        EventTarget r48 = this.c;
        if (r48 != null) goto L213;
    L226:
        return true;
    L213:
        if (r48.getChildrenLynxPageUI() == null) goto L226;
        UIGroup r49 = (UIBody) this.c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.c)));
        if (r49 == null) goto L226;
        if (r49.getLynxContext() == null) goto L226;
        if (r49.getLynxContext().getTouchEventDispatcher() == null) goto L226;
        PointF r50 = w(r19);
        r49.getLynxContext().getTouchEventDispatcher().q(r19, r49);     // Catch: Throwable -> L223
        r19.setLocation(r50.x, r50.y);
    L223:
        th = move-exception;
        r19.setLocation(r50.x, r50.y);
        throw th;
    L192:
        i(this.c, LynxTouchEvent.EVENT_TOUCH_START, r19);
        goto L194
    }

    public final void s(MotionEvent r7, UIGroup r8) {
        this.y = true;
        int r0 = r7.getActionIndex();
        EventTarget r9 = m(r7, r0, r8);
        this.f.put(Integer.valueOf(r7.getPointerId(r0)), new b(r9, r7.getX(r0), r7.getY(r0)));
        this.g.put(Integer.valueOf(r9.getSign()), r9);
        if (this.z == false) goto L5;
        JavaOnlyMap r10 = new JavaOnlyMap();
        b(r10, r7, r0);
        j(LynxTouchEvent.EVENT_TOUCH_START, r7, r10);
    L5:
        EventTarget r11 = this.c;
        if (r11 != null) goto L8;
        return;
    L8:
        if (r11.getChildrenLynxPageUI() == null) goto L24;
        UIGroup r12 = (UIBody) this.c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.c)));
        if (r12 != null) goto L12;
        return;
    L12:
        if (r12.getLynxContext() != null) goto L14;
        return;
    L14:
        if (r12.getLynxContext().getTouchEventDispatcher() == null) goto L27;
        PointF r1 = w(r7);
        r12.getLynxContext().getTouchEventDispatcher().s(r7, r12);     // Catch: Throwable -> L18
        r7.setLocation(r1.x, r1.y);
        return;
    L18:
        th = move-exception;
        r7.setLocation(r1.x, r1.y);
        throw th;
    L27:
        return;
    }

    public final boolean x(MotionEvent r8, UIGroup r9) {
        LynxUIOwner r0 = this.a;
        if (r0 != null) goto L5;
    L4:
        l r1 = null;
    L12:
        if (r1 == null) goto L30;
        if (r9 == null) goto L15;
        int r10 = r9.getSign();
    L20:
        if (r1.c(r8, r10) == true) goto L23;
        return false;
    L23:
        if (r8.getActionMasked() != 0) goto L26;
        D();
    L28:
        this.b.b(r8);
        return true;
    L26:
        if (r8.getActionMasked() != 1) goto L28;
        r1.i();
        r1.f();
        goto L28
    L15:
        LynxUIOwner r11 = this.a;
        if (r11 == null) goto L18;
        r10 = r11.getRootSign();
        goto L20
    L18:
        r10 = -1;
        goto L20
    L30:
        this.A = System.currentTimeMillis();
        if (r8.getActionMasked() != 0) goto L46;
        if (r9 == null) goto L34;
        UIGroup r2 = r9;
    L35:
        this.G = r2;
        if (r9 != null) goto L38;
    L40:
        boolean r12 = false;
    L41:
        this.H = r12;
        this.I = false;
        if (q(r8, this.G) == true) goto L74;
        this.G = null;
        this.H = false;
        LLog.i("LynxTouchEventDispatcher", "hit event through");
        return false;
    L74:
        boolean r13 = false;
    L75:
        EventTarget r3 = this.c;
        if (r3 == null) goto L83;
        LynxTouchEvent.a r4 = this.F;
        if (r3.eventThrough(r4.a, r4.b) == false) goto L83;
        LLog.i("LynxTouchEventDispatcher", "hit event through");
        if (r13 == false) goto L82;
        B();
    L82:
        return false;
    L83:
        h(r8);
        this.b.b(r8);
        k(r8);
        if (r13 == false) goto L86;
        B();
    L86:
        return true;
    L38:
        if (r9 == this.a.getRootUI()) goto L40;
        r12 = true;
        goto L41
    L34:
        r2 = this.a.getRootUI();
        goto L35
    L46:
        if (r8.getActionMasked() != 5) goto L53;
        UIGroup r14 = this.G;
        if (r14 != null) goto L51;
        r14 = this.a.getRootUI();
    L51:
        s(r8, r14);
        goto L74
    L53:
        if (this.c == null) goto L74;
        if (this.f.isEmpty() == true) goto L74;
        EventTarget r15 = this.c;
        LynxTouchEvent.a r5 = this.F;
        if (r15.eventThrough(r5.a, r5.b) == false) goto L60;
        LLog.i("LynxTouchEventDispatcher", "hit event through");
        return false;
    L60:
        int r16 = r8.getActionMasked();
        if (r16 != 1) goto L63;
        r(r8);
        n(r8);
        p(r8);
    L73:
        r13 = true;
        goto L75
    L63:
        if (r16 != 2) goto L65;
        v(r8);
        goto L74
    L65:
        if (r16 != 3) goto L67;
        u(r8);
        goto L73
    L67:
        if (r16 != 6) goto L74;
        t(r8);
        goto L74
    L5:
        LynxContext r6 = r0.getContext();
        if (r6 == null) goto L4;
        if (r6.isFragmentLayerRenderOn() == false) goto L4;
        r1 = this.a.getPaintingContext();
        goto L12
    }

    public final boolean y(MotionEvent r10, int r11) {
        b r0 = this.f.get(Integer.valueOf(r10.getPointerId(r11)));
        boolean r1 = true;
        if (r0 == null) goto L67;
        PointF r3 = r0.c;
        PointF r4 = r0.b;
        if (this.z == true) goto L8;
        r4 = this.n;
    L8:
        if (r3.x != r10.getX(r11)) goto L14;
        if (r3.y != r10.getY(r11)) goto L14;
        boolean r5 = false;
        boolean r6 = false;
    L66:
        r0.c = r3;
    L68:
        if (r5 == false) goto L120;
        UIGroup r2 = this.G;
        if (r2 != null) goto L73;
        r2 = this.a.getRootUI();
    L73:
        EventTarget r12 = m(r10, r11, r2);
        if (this.s == false) goto L76;
    L106:
        this.t = r1;
        if (this.h.isEmpty() == true) goto L113;
        if (this.z == true) goto L113;
        if (this.p == false) goto L113;
    L119:
        g(8);
    L113:
        if (this.z == false) goto L116;
        if (r6 == true) goto L119;
    L116:
        if (c(this.c) != (-1)) goto L119;
        if (d(this.c, this.v) == (-1)) goto L120;
    L76:
        if (this.j.isEmpty() == true) goto L80;
        if (c(this.j.getLast()) != (-1)) goto L106;
    L80:
        if (this.t == true) goto L106;
        LynxUIOwner r13 = this.a;
        if (r13 != null) goto L84;
    L102:
        boolean r14 = true;
    L103:
        if (r14 == true) goto L106;
        r1 = false;
        goto L106
    L84:
        if (r13.getRootUI() == null) goto L102;
        LinkedList r15 = new LinkedList();
    L87:
        if (r12 == null) goto L90;
        r15.push(r12);
        r12 = r12.parent();
        goto L87
    L90:
        if (r15.size() < this.j.size()) goto L102;
        int r16 = 0;
    L94:
        if (r16 >= this.j.size()) goto L101;
        EventTarget r7 = this.j.get(r16);
        if (r7 == null) goto L102;
        if (r7 != r15.get(r16)) goto L102;
        r16 = r16 + 1;
        goto L94
    L101:
        r14 = false;
    L120:
        return r5;
    L14:
        if (Math.abs(r4.x - r10.getX(r11)) <= this.o) goto L16;
    L17:
        this.p = true;
        if (r10.getPointerId(r11) != 0) goto L20;
        r6 = true;
    L22:
        if (r10.getPointerId(r11) != 0) goto L65;
        float r8 = Math.abs(r4.x - r10.getX(r11));
        float r9 = Math.abs(r4.y - r10.getY(r11));
        if (this.J == true) goto L65;
        if (r8 <= 10.0f) goto L28;
    L29:
        this.J = true;
        EventTarget.PanInterceptDirection r17 = EventTarget.PanInterceptDirection.Horizontal;
        if (r8 <= r9) goto L32;
        EventTarget.PanInterceptDirection r18 = EventTarget.PanInterceptDirection.Horizontal;
    L33:
        EventTarget r19 = this.d;
        if (r19 == null) goto L37;
        r19.setPanInterceptAncestors(false);
    L37:
        if (r18 == EventTarget.PanInterceptDirection.None) goto L47;
        EventTarget r20 = this.c;
    L40:
        if (r20 == null) goto L47;
        if (r20.parent() == r20) goto L47;
        if (r20.panInterceptDirection() == r18) goto L48;
        r20 = r20.parent();
    L48:
        this.e = r20;
        if (r20 != null) goto L51;
        EventTarget.PanInterceptScope r21 = EventTarget.PanInterceptScope.None;
    L53:
        if (this.e == null) goto L65;
        if (r21 == EventTarget.PanInterceptScope.None) goto L65;
        switch(a.a[r21.ordinal()]) {
            case 1: goto L64;
            case 2: goto L63;
            case 3: goto L62;
            case 4: goto L61;
            case 5: goto L60;
            case 6: goto L59;
            default: goto L65;
        };
    L59:
        this.e.setPanInterceptSelf(true);
        this.e.setPanInterceptAncestors(true);
        this.e.setPanInterceptDescendants(true);
        goto L65
    L60:
        this.e.setPanInterceptSelf(true);
        this.e.setPanInterceptDescendants(true);
        goto L65
    L61:
        this.e.setPanInterceptSelf(true);
        this.e.setPanInterceptAncestors(true);
        goto L65
    L62:
        this.e.setPanInterceptDescendants(true);
        goto L65
    L63:
        this.e.setPanInterceptAncestors(true);
        goto L65
    L64:
        this.e.setPanInterceptSelf(true);
        goto L65
    L51:
        r21 = r20.panInterceptScope();
    L47:
        r20 = null;
        goto L48
    L32:
        r18 = EventTarget.PanInterceptDirection.Vertical;
        goto L33
    L28:
        if (r9 > 10.0f) goto L29;
    L65:
        r3.x = r10.getX(r11);
        r3.y = r10.getY(r11);
        r5 = true;
    L20:
        r6 = false;
        goto L22
    L16:
        if (Math.abs(r4.y - r10.getY(r11)) <= this.o) goto L20;
    L67:
        r5 = false;
        r6 = false;
        goto L68
    }

    public final void z(String r11, MotionEvent r12) {
        LynxUIOwner r0 = this.a;
        if (r0 == null) goto L5;
        LynxContext r1 = r0.getContext();
    L6:
        if (r1 == null) goto L8;
        final int r4 = r1.getInstanceId();
    L10:
        if (LynxFrameRecorder.k.k(r4) == true) goto L13;
        return;
    L13:
        if (LynxTouchEvent.EVENT_TOUCH_START.equals(r11) == false) goto L16;
        final int r6 = 201;
    L24:
        ArrayList r13 = new ArrayList(r12.getPointerCount());
        int r2 = 0;
    L26:
        if (r2 >= r12.getPointerCount()) goto L35;
        b r3 = this.f.get(Integer.valueOf(r12.getPointerId(r2)));
        if (r3 == null) goto L30;
        EventTarget r5 = r3.a;
    L31:
        if (r5 == null) goto L33;
        Integer r7 = Integer.valueOf(r5.getSign());
    L34:
        r13.add(new LynxFrameRecorder.n(r12.getX(r2), r12.getY(r2), r12.getPointerId(r2), r7));
        r2 = r2 + 1;
        goto L26
    L33:
        r7 = null;
        goto L34
    L30:
        r5 = this.c;
        goto L31
    L35:
        final LynxFrameRecorder r8 = LynxFrameRecorder.k;
        final long r9 = r12.getEventTime();
        r8.getClass();
        final List r10 = Collections.unmodifiableList(new ArrayList(r13));
        final Integer r14 = r8.e(r4);
        if (r14 == null) goto L44;
        r8.a.execute(new com.lynx.tasm.recording.e(r8, r4, r14, r6, r10, r9));
        return;
    L44:
        return;
    L16:
        if (LynxTouchEvent.EVENT_TOUCH_MOVE.equals(r11) == false) goto L19;
        r6 = SpeechEvent.SERVER_DOWNLINK_EVENT_TASK_FINISHED;
        goto L24
    L19:
        if (LynxTouchEvent.EVENT_TOUCH_END.equals(r11) == false) goto L22;
        r6 = SpeechEvent.SERVER_DOWNLINK_EVENT_TASK_FAILED;
        goto L24
    L22:
        if (LynxTouchEvent.EVENT_TOUCH_CANCEL.equals(r11) == false) goto L43;
        r6 = SpeechEvent.SERVER_DOWNLINK_EVENT_SESSION_STARTED;
        goto L24
    L43:
        return;
    L8:
        r4 = -1;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final void b(JavaOnlyMap r10, MotionEvent r11, int r12) {
        b r0 = this.f.get(Integer.valueOf(r11.getPointerId(r12)));
        if (r0 != null) goto L5;
        return;
    L5:
        EventTarget r1 = r0.a;
        String r2 = String.valueOf(r1.getSign());
        ReadableArray r3 = r10.getArray(r2);
        JavaOnlyArray r4 = new JavaOnlyArray();
        LynxTouchEvent.a r5 = new LynxTouchEvent.a(r11.getX(r12), r11.getY(r12));
        if ((r1 instanceof LynxBaseUI) == false) goto L8;
        LynxTouchEvent.a r6 = f(r1, r5);
    L9:
        PointF r7 = com.lynx.tasm.behavior.ui.utils.h.c(this.a.getRootUI(), new PointF(r5.a, r5.b));
        float r8 = r7.x;
        float r9 = r7.y;
        r4.add(Integer.valueOf(r11.getPointerId(r12)));
        r4.add(Float.valueOf(r8));
        r4.add(Float.valueOf(r9));
        r4.add(Float.valueOf(r5.a));
        r4.add(Float.valueOf(r5.b));
        r4.add(Float.valueOf(r6.a));
        r4.add(Float.valueOf(r6.b));
        if (r3 == null) goto L12;
        r3.asArrayList().add(r4);
        return;
    L12:
        JavaOnlyArray r13 = new JavaOnlyArray();
        r13.add(r4);
        r10.putArray(r2, r13);
        return;
    L8:
        r6 = r5;
        goto L9
    }

    public final void i(EventTarget r12, String r13, MotionEvent r14) {
        z(r13, r14);
        this.B = f(this.c, new LynxTouchEvent.a(r14.getX(0), r14.getY(0)));
        LynxTouchEvent.a r7 = new LynxTouchEvent.a(r14.getX(0), r14.getY(0));
        PointF r0 = com.lynx.tasm.behavior.ui.utils.h.c(this.a.getRootUI(), new PointF(r7.a, r7.b));
        LynxTouchEvent r1 = new LynxTouchEvent(r12.getSign(), r13, new LynxTouchEvent.a(r0.x, r0.y), r7, this.B);
        this.C = r1;
        r1.setMotionEvent(r14);
        this.C.setTarget(this.c);
        this.C.setTimestamp(this.A);
        LynxTouchEvent r15 = this.C;
        if (this.H == false) goto L6;
        r15.setEventID(Long.MIN_VALUE);
    L6:
        if (LynxTouchEvent.EVENT_TOUCH_START.equals(r13) == false) goto L32;
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L29;
        if (this.c == null) goto L29;
        if (this.a.getRootUI() == null) goto L29;
        if (this.a.getRootUI().getBodyView() == null) goto L29;
        LynxBaseInspectorOwner r2 = ((LynxView) this.a.getRootUI().getBodyView()).getBaseInspectorOwner();
        if (r2 == null) goto L29;
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L27
        r3.put("id", 1);     // Catch: Exception -> L27
        r3.put("method", "DOM.setAttributesAsText");     // Catch: Exception -> L27
        if (this.D != null) goto L23;
    L25:
        r3.put("method", "CSS.getInlineStylesForNode");     // Catch: Exception -> L27
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L27
        r16.put("nodeId", this.c.getSign());     // Catch: Exception -> L27
        r3.put(LynxResourceModule.PARAMS_KEY, r16);     // Catch: Exception -> L27
        r2.invokeCDPFromSDK(r3.toString(), new z0(this, r3, r16, r2));     // Catch: Exception -> L27
        goto L29
    L23:
        if (this.E == null) goto L25;
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L27
        r4.put("nodeId", this.D.getSign());     // Catch: Exception -> L27
        r4.put("text", String.format("style=\"%s\"", new Object[]{this.E}));     // Catch: Exception -> L27
        r4.put(EasyGoDbTable.Server.NAME, "style");     // Catch: Exception -> L27
        r3.put(LynxResourceModule.PARAMS_KEY, r4);     // Catch: Exception -> L27
        r2.invokeCDPFromSDK(r3.toString(), new y0());     // Catch: Exception -> L27
    L27:
        LLog.e("LynxTouchEventDispatcher", "inspectHitTarget json generate error");
    L29:
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L32;
        C("LynxTouchEventDispatcher: hit the target with sign = " + r12.getSign(), LogBoxLogLevel.Info.ordinal());
    L32:
        if (l() != null) goto L35;
        LLog.i("LynxTouchEventDispatcher", "dispatchEvent failed since eventEmitter() null");
        return;
    L35:
        q7a.b r17 = this.k;
        if (r17 == null) goto L38;
        r17.c(r13, this.C);
    L38:
        l().sendTouchEvent(this.C);
    }

    public final void j(String r9, MotionEvent r10, JavaOnlyMap r11) {
        z(r9, r10);
        EventTarget r0 = this.c;
        LynxTouchEvent.a r5 = new LynxTouchEvent.a(r10.getX(), r10.getY());
        PointF r1 = com.lynx.tasm.behavior.ui.utils.h.c(this.a.getRootUI(), new PointF(r5.a, r5.b));
        LynxTouchEvent.a r4 = new LynxTouchEvent.a(r1.x, r1.y);
        LynxTouchEvent r7 = new LynxTouchEvent(r0.getSign(), r9, r4, r5, this.B);
        this.C = r7;
        r7.setMotionEvent(r10);
        LynxTouchEvent r2 = new LynxTouchEvent(r9, r11);
        r2.setMotionEvent(r10);
        r2.setActiveTargetMap(this.g);
        r2.setTarget(this.c);
        r2.setTimestamp(this.A);
        if (this.H == false) goto L5;
        r2.setEventID(Long.MIN_VALUE);
    L5:
        q7a.b r12 = this.k;
        if (r12 == null) goto L8;
        r12.c(r9, this.C);
    L8:
        l().sendMultiTouchEvent(r2);
    }

    public final EventTarget m(MotionEvent r2, int r3, UIGroup r4) {
        if (r4 != null) goto L5;
        r4 = this.a.getRootUI();
    L5:
        return r4.hitTest(r2.getX(r3), r2.getY(r3));
    }

    public static void a(b1 r2, JSONObject r3, JSONObject r4, LynxBaseInspectorOwner r5, String r6) throws JSONException {
        r2.getClass();
        Matcher r7 = PatternProtector.compile("\"cssText\"\\s*:\\s*\"([^\"]*)\"").matcher(r6);
        if (r7.find() == false) goto L5;
        r2.E = r7.group(1);
    L5:
        String r8 = r2.E;
        if (r8 != null) goto L9;
        r8 = NameKeys.UnloadStrategy_No_Strategy;
    L9:
        String r9 = r8.concat("background-color:#9CC4E6;border-width:2px;border-color:red;");
        r3.put("method", "DOM.setAttributesAsText");
        r4.put("text", String.format("style=\"%s\"", new Object[]{r9}));
        r4.put(EasyGoDbTable.Server.NAME, "style");
        r3.put(LynxResourceModule.PARAMS_KEY, r4);
        r5.invokeCDPFromSDK(r3.toString(), new a1());
    }
}
