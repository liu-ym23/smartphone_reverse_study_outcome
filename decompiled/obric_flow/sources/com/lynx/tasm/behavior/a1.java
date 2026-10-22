package com.lynx.tasm.behavior;

import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.event.EventTarget$EnableStatus;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.core.LynxEngineProxy;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a1 {
    public on.g A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n0 f10177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f10178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public wm.a f10179c;
    public final HashMap d;
    public final HashMap e;
    public final LinkedList f;
    public wm.a g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedList f10180h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public sn.a f10181i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public EventTarget$EnableStatus f10182j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f10183k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PointF f10184l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f10185m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f10186n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f10187o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f10188p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f10189q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f10190r;
    public final HashSet s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final HashSet f10191t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f10192u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f10193v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f10194w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f10195x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public on.g f10196y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public on.h f10197z;

    public a1(n0 r10) {
        this.f10182j = EventTarget$EnableStatus.f10246c;
        this.f10183k = false;
        this.f10195x = 0;
        this.f10177a = r10;
        ym.o r5 = new ym.o(this, 5);
        this.f10178b = new h(r10.f10289c, r5, new Handler(Looper.getMainLooper()));
        this.f = new LinkedList();
        this.f10180h = new LinkedList();
        this.f10184l = new PointF(Float.MIN_VALUE, Float.MIN_VALUE);
        on.g r11 = new on.g();
        r11.f20784a = 0.0f;
        r11.f20785b = 0.0f;
        this.A = r11;
        this.f10185m = com.lynx.tasm.utils.g.a(50.0f, 0.0f);
        this.f10188p = true;
        this.s = new HashSet();
        this.f10191t = new HashSet();
        this.f10192u = false;
        this.f10193v = false;
        this.f10194w = false;
        this.d = new HashMap();
        this.e = new HashMap();
        this.f10181i = r10.f10297o;
    }

    public static int a(wm.a r5, HashSet r10) {
        if (r5 != null) goto L6;
        return 0;
    L6:
        if (r10 != null) goto L8;
    L18:
        return -1;
    L8:
        if (r10.isEmpty() == true) goto L18;
    L10:
        if (r5 == null) goto L18;
        if (r5.parent() == r5) goto L18;
        if (r10.contains(Integer.valueOf(r5.getSign())) == true) goto L16;
        r5 = r5.parent();
        goto L10
    L16:
        return r5.getSign();
    }

    public static on.g c(wm.a r5, on.g r10) {
        if ((r5 instanceof LynxBaseUI) == false) goto L6;
        LynxBaseUI r11 = (LynxBaseUI) r5;
        RectF r12 = i.a.d(r11, new RectF(0.0f, 0.0f, r11.getWidth(), r11.getHeight()));
        return new on.g(r10.f20784a - r12.left, r10.f20785b - r12.top);
    L6:
        return r10;
    }

    public final com.lynx.tasm.r b() {
        return this.f10177a.f10289c.g;
    }

    public final void d(int r10) {
        if (b() == null) goto L12;
        Iterator r5 = this.f.iterator();
    L7:
        if (r5.hasNext() == false) goto L16;
        wm.a r11 = (wm.a) r5.next();
        if (this.f10192u == false) goto L11;
        b().a(r11.getSign(), r11.getPseudoStatus(), r11.getPseudoStatus() & (~r10));
    L11:
        r11.onPseudoStatusChanged(r11.getPseudoStatus(), r11.getPseudoStatus() & (~r10));
        goto L7
    L16:
        return;
    }

    public final void e(MotionEvent r5) {
        LinkedList r10 = this.f10180h;
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        if (r10.getLast() == null) goto L41;
        int r11 = a((wm.a) r10.getLast(), this.s);
        int r12 = a((wm.a) r10.getLast(), this.f10191t);
        if (this.f10194w == false) goto L12;
        if (this.f10193v == false) goto L12;
    L23:
        wm.a r13 = this.f10179c;
        if (r13 != null) goto L26;
        return;
    L26:
        if (r13.getChildrenLynxPageUI() == null) goto L37;
        UIBody r14 = (UIBody) this.f10179c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.f10179c)));
        if (r14 != null) goto L30;
        return;
    L30:
        if (r14.getLynxContext() != null) goto L32;
        return;
    L32:
        if (r14.getLynxContext().f10140h == null) goto L40;
        on.g r15 = this.f10197z.f20787i;
        r5.setLocation(r15.f20784a, r15.f20785b);
        r14.getLynxContext().f10140h.e(r5);
        return;
    L40:
        return;
    L37:
        return;
    L12:
        if (this.f10190r == true) goto L23;
        if (this.f10189q == true) goto L23;
        if (r10.isEmpty() == true) goto L23;
        if (r10.getLast() == null) goto L23;
        if (r11 != (-1)) goto L23;
        if (r12 != (-1)) goto L23;
        h((wm.a) r10.getLast(), "click", r5);
        goto L23
    }

    public final void f(JavaOnlyMap r10, MotionEvent r11, int r12) {
        z0 r5 = (z0) this.d.get(Integer.valueOf(r11.getPointerId(r12)));
        if (r5 != null) goto L5;
        return;
    L5:
        wm.a r13 = r5.f10819a;
        String r14 = String.valueOf(r13.getSign());
        ReadableArray r15 = r10.getArray(r14);
        JavaOnlyArray r16 = new JavaOnlyArray();
        on.g r17 = new on.g(r11.getX(r12), r11.getY(r12));
        if ((r13 instanceof LynxBaseUI) == false) goto L8;
        on.g r18 = c(r13, r17);
    L9:
        PointF r19 = i.a.c(this.f10177a.f10288b, new PointF(r17.f20784a, r17.f20785b));
        float r20 = r19.x;
        float r21 = r19.y;
        r16.add(Integer.valueOf(r11.getPointerId(r12)));
        r16.add(Float.valueOf(r20));
        r16.add(Float.valueOf(r21));
        r16.add(Float.valueOf(r17.f20784a));
        r16.add(Float.valueOf(r17.f20785b));
        r16.add(Float.valueOf(r18.f20784a));
        r16.add(Float.valueOf(r18.f20785b));
        if (r15 == null) goto L13;
        r15.asArrayList().add(r16);
        return;
    L13:
        JavaOnlyArray r22 = new JavaOnlyArray();
        r22.add(r16);
        r10.putArray(r14, r22);
        return;
    L8:
        r18 = r17;
        goto L9
    }

    public final void g(String r10, MotionEvent r11, JavaOnlyMap r12) {
        wm.a r5 = this.f10179c;
        on.g r13 = new on.g(r11.getX(), r11.getY());
        PointF r14 = i.a.c(this.f10177a.f10288b, new PointF(r13.f20784a, r13.f20785b));
        this.f10197z = new on.h(r5.getSign(), r10, new on.g(r14.x, r14.y), r13, this.f10196y);
        on.h r15 = new on.h(r10, r12);
        r15.f20790l = this.e;
        r15.d = this.f10179c;
        r15.e = this.f10195x;
        sn.a r16 = this.f10181i;
        if (r16 == null) goto L5;
        r16.b(r10, this.f10197z);
    L5:
        com.lynx.tasm.r r17 = b();
        com.lynx.tasm.i r18 = r17.e;
        if (r18 != null) goto L8;
    L31:
        LynxLog.b(4, "EventEmitter", "sendMultiTouchEvent event: " + r10 + " failed since mEngineProxy is null or in preload.");
        return;
    L8:
        if (r17.f10940b == true) goto L31;
        if (r17.c(r15) == true) goto L37;
        wm.a r19 = r15.d;
        LynxEngineProxy r110 = (LynxEngineProxy) r18.f10879a;
        if (r19 != null) goto L15;
    L29:
        if (r110 == null) goto L35;
        com.lynx.tasm.utils.j.f(new mn.c(r110, r15, 1));
        return;
    L35:
        return;
    L15:
        if (r19.getParentLynxPageUI() != null) goto L19;
        if (r19.getChildrenLynxPageUI() == null) goto L29;
    L19:
        if (r19.getParentLynxPageUI() != null) goto L21;
        r17.f10939a = (r17.f10939a + 1) % 9223372036854775806L;
    L21:
        long r20 = r17.f10939a;
        r15.f = r20;
        r19.setEventID(r20);
        LynxLog.b(2, "LynxEventEmitter", "TouchEventHandler " + r10 + " " + r15.f + " " + r17);
        if (r110 == null) goto L25;
        com.lynx.tasm.utils.j.f(new mn.c(r110, r15, 2));
    L25:
        if (r19.getChildrenLynxPageUI() != null) goto L27;
    L28:
        r19.getRootLynxPageUI().startEventCapture(r17.f10939a);
        return;
    L27:
        if (r19.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(r19))) == null) goto L28;
        return;
    }

    public final void h(wm.a r10, String r11, MotionEvent r12) {
        this.f10196y = c(this.f10179c, new on.g(r12.getX(0), r12.getY(0)));
        on.g r13 = new on.g(r12.getX(0), r12.getY(0));
        n0 r14 = this.f10177a;
        PointF r5 = i.a.c(r14.f10288b, new PointF(r13.f20784a, r13.f20785b));
        on.g r15 = new on.g(r5.x, r5.y);
        on.h r16 = new on.h(r10.getSign(), r11, r15, r13, this.f10196y);
        this.f10197z = r16;
        r16.d = this.f10179c;
        r16.e = this.f10195x;
        if ("touchstart".equals(r11) == false) goto L22;
        boolean r17 = LynxEnv.inst().isHighlightTouchEnabled();
        UIBody r18 = r14.f10288b;
        if (r17 == false) goto L14;
        if (this.f10179c == null) goto L14;
        if (r18 == null) goto L14;
        UIBody.UIBodyView r19 = r18.f10385a;
        if (r19 == null) goto L14;
        ((LynxView) r19).getBaseInspectorOwner();
    L14:
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L22;
        r10.getSign();
        if (r18 == null) goto L22;
        UIBody.UIBodyView r110 = r18.f10385a;
        if (r110 == null) goto L22;
        ((LynxView) r110).getBaseInspectorOwner();
    L22:
        if (b() != null) goto L25;
        LynxLog.b(2, "LynxTouchEventDispatcher", "dispatchEvent failed since eventEmitter() null");
        return;
    L25:
        sn.a r111 = this.f10181i;
        if (r111 == null) goto L28;
        r111.b(r11, this.f10197z);
    L28:
        b().d(this.f10197z);
    }

    public final boolean i(MotionEvent r10, int r11) {
        z0 r5 = (z0) this.d.get(Integer.valueOf(r10.getPointerId(r11)));
        boolean r12 = true;
        if (r5 == null) goto L23;
        PointF r13 = r5.f10821c;
        PointF r14 = r5.f10820b;
        if (this.f10194w == true) goto L8;
        r14 = this.f10184l;
    L8:
        if (r13.x != r10.getX(r11)) goto L14;
        if (r13.y != r10.getY(r11)) goto L14;
        boolean r15 = false;
        boolean r16 = false;
    L22:
        r5.f10821c = r13;
    L24:
        if (r16 == false) goto L66;
        n0 r17 = this.f10177a;
        wm.a r18 = r17.f10288b.hitTest(r10.getX(r11), r10.getY(r11));
        boolean r19 = this.f10189q;
        HashSet r20 = this.s;
        if (r19 == true) goto L52;
        LinkedList r110 = this.f10180h;
        if (r110.isEmpty() == true) goto L32;
        if (a((wm.a) r110.getLast(), r20) != (-1)) goto L52;
    L32:
        if (this.f10190r == true) goto L52;
        if (r17.f10288b == null) goto L52;
        LinkedList r21 = new LinkedList();
    L37:
        if (r18 == null) goto L40;
        r21.push(r18);
        r18 = r18.parent();
        goto L37
    L40:
        if (r21.size() < r110.size()) goto L52;
        int r111 = 0;
    L44:
        if (r111 >= r110.size()) goto L51;
        wm.a r22 = (wm.a) r110.get(r111);
        if (r22 == null) goto L52;
        if (r22 != r21.get(r111)) goto L52;
        r111 = r111 + 1;
        goto L44
    L51:
        r12 = false;
    L52:
        this.f10190r = r12;
        if (this.f.isEmpty() == true) goto L59;
        if (this.f10194w == true) goto L59;
        if (this.f10186n == false) goto L59;
    L65:
        d(8);
    L59:
        if (this.f10194w == false) goto L62;
        if (r15 == true) goto L65;
    L62:
        if (a(this.f10179c, r20) != (-1)) goto L65;
        if (a(this.f10179c, this.f10191t) != (-1)) goto L65;
    L66:
        return r16;
    L14:
        if (Math.abs(r14.x - r10.getX(r11)) <= this.f10185m) goto L16;
    L17:
        this.f10186n = true;
        if (r10.getPointerId(r11) != 0) goto L20;
        r15 = true;
    L21:
        r13.x = r10.getX(r11);
        r13.y = r10.getY(r11);
        r16 = true;
    L20:
        r15 = false;
        goto L21
    L16:
        if (Math.abs(r14.y - r10.getY(r11)) <= this.f10185m) goto L20;
    L23:
        r15 = false;
        r16 = false;
        goto L24
    }

    public final boolean j(MotionEvent r18, UIGroup r19) {
        on.g r5 = this.A;
        r5.f20784a = 0.0f;
        r5.f20785b = 0.0f;
        n0 r10 = this.f10177a;
        if (r19 != null) goto L5;
        UIGroup r11 = r10.f10288b;
    L6:
        this.f10179c = r11.hitTest(r18.getX(0), r18.getY(0));
        on.g r12 = new on.g(r18.getX(), r18.getY());
        this.A = r12;
        wm.a r13 = this.f10179c;
        if ((r13 instanceof LynxBaseUI) == false) goto L9;
        this.A = c(r13, r12);
    L9:
        wm.a r14 = this.f10179c;
        if (r14 == null) goto L14;
        on.g r15 = this.A;
        if (r14.eventThrough(r15.f20784a, r15.f20785b) == false) goto L14;
        return false;
    L14:
        this.f10186n = false;
        this.f10187o = false;
        this.f10188p = true;
        this.f10184l = new PointF(r18.getX(), r18.getY());
        this.f10189q = false;
        new PointF(r18.getX(), r18.getY());
        this.s.clear();
        this.f10191t.clear();
        this.f10193v = false;
        HashMap r16 = this.d;
        r16.clear();
        HashMap r17 = this.e;
        r17.clear();
        LinkedList r20 = this.f10180h;
        r20.clear();
        wm.a r21 = this.f10179c;
        if (r21 == null) goto L34;
    L17:
        if (r21 == null) goto L20;
        r20.push(r21);
        r21 = r21.parent();
    L20:
        if (r20.isEmpty() == true) goto L26;
        if (((wm.a) r20.getLast()).getEvents() == null) goto L25;
        if (((wm.a) r20.getLast()).getEvents().containsKey("click") == true) goto L26;
    L25:
        r20.removeLast();
    L26:
        Iterator r22 = r20.iterator();
    L28:
        if (r22.hasNext() == false) goto L31;
        ((wm.a) r22.next()).onResponseChain();
        goto L28
    L31:
        if (r20.isEmpty() == false) goto L33;
        this.f10190r = true;
        goto L34
    L33:
        this.f10190r = false;
    L34:
        r16.put(Integer.valueOf(r18.getPointerId(0)), new z0(this.f10179c, r18.getX(0), r18.getY(0)));
        r17.put(Integer.valueOf(this.f10179c.getSign()), this.f10179c);
        sn.a r23 = this.f10181i;
        if (r23 == null) goto L181;
        wm.a r24 = this.f10179c;
        if (r23.f == false) goto L181;
        List r25 = null;
        r23.g = null;
        LinkedList r26 = r23.f21958c;
        if (r26 == null) goto L42;
        r26.clear();
    L42:
        LinkedList r27 = r23.f21957b;
        if (r27 == null) goto L45;
        r27.clear();
    L45:
        HashMap r28 = r23.f21956a;
        if (r28 == null) goto L181;
        if (r28.isEmpty() == true) goto L181;
        if (r23.f21959h == null) goto L181;
    L52:
        if (r24 == null) goto L68;
        Iterator r29 = r23.f21956a.values().iterator();
    L55:
        if (r29.hasNext() == false) goto L67;
        WeakReference r110 = (WeakReference) r29.next();
        if (r110 == null) goto L55;
        rn.a r111 = (rn.a) r110.get();
        if (r111 == null) goto L55;
        if (r111.getGestureArenaMemberId() <= 0) goto L55;
        if (r111.getGestureArenaMemberId() != r24.getGestureArenaMemberId()) goto L55;
        r23.f21958c.add(r111);
        goto L55
    L67:
        r24 = r24.parent();
        goto L52
    L68:
        s6.c r30 = r23.e;
        if (r30 == null) goto L172;
        LinkedList r31 = r23.f21958c;
        LinkedList r112 = new LinkedList();
        if (r31 != null) goto L73;
    L171:
        r23.f21957b = r112;
        goto L172
    L73:
        if (r31.isEmpty() == true) goto L171;
        int r113 = 0;
    L77:
        if (r113 >= r31.size()) goto L171;
        rn.a r114 = (rn.a) r31.get(r113);
        Map r115 = r114.getGestureDetectorMap();
        if (r115 != null) goto L81;
        r112.add(r114);
    L170:
        r113 = r113 + 1;
        r25 = null;
        goto L77
    L81:
        Iterator r116 = new TreeMap(r115).entrySet().iterator();
        List r117 = r25;
        List r118 = r117;
    L83:
        if (r116.hasNext() == false) goto L93;
        Map.Entry r119 = (Map.Entry) r116.next();
        List r32 = (List) ((un.a) r119.getValue()).d.get("waitFor");
        r118 = (List) ((un.a) r119.getValue()).d.get("continueWith");
        if (r32 != null) goto L87;
    L88:
        if (r118 == null) goto L92;
        if (r118.isEmpty() == true) goto L92;
    L91:
        r117 = r32;
    L92:
        r117 = r32;
        goto L83
    L87:
        if (r32.isEmpty() == false) goto L91;
    L93:
        if (r118 != null) goto L95;
    L96:
        if (r117 != null) goto L98;
    L169:
        r112.add(r114);
        goto L170
    L98:
        if (r117.isEmpty() == true) goto L169;
    L100:
        HashMap r33 = (HashMap) r30.f21828b;
        if (r117 != null) goto L103;
    L140:
        r112.add(r114);
    L141:
        if (r118 == null) goto L170;
        if (r118.isEmpty() == true) goto L170;
        LinkedHashSet r34 = new LinkedHashSet();
        Iterator r35 = r118.iterator();
    L146:
        if (r35.hasNext() == false) goto L150;
        Integer r36 = (Integer) r35.next();
        if (r33.get(r36) == null) goto L146;
        r34.addAll((Collection) r33.get(r36));
        goto L146
    L150:
        if (r33 == null) goto L163;
        sn.a r37 = (sn.a) r30.f21829c;
        if (r37 == null) goto L163;
        LinkedList r38 = new LinkedList();
        Iterator r39 = r34.iterator();
    L156:
        if (r39.hasNext() == false) goto L162;
        Integer r40 = (Integer) r39.next();
        r40.getClass();
        WeakReference r41 = (WeakReference) r37.f21956a.get(r40);
        if (r41 == null) goto L160;
        rn.a r42 = (rn.a) r41.get();
    L161:
        r38.add(r42);
        goto L156
    L160:
        r42 = null;
        goto L161
    L162:
        LinkedList r43 = r38;
    L164:
        if (r43 == null) goto L171;
        if (r43.isEmpty() == true) goto L171;
        r112.addAll(r43);
    L163:
        r43 = null;
        goto L164
    L103:
        if (r117.isEmpty() == true) goto L140;
        LinkedHashSet r120 = new LinkedHashSet();
        Iterator r121 = r117.iterator();
    L106:
        if (r121.hasNext() == false) goto L111;
        Integer r44 = (Integer) r121.next();
        if (r33.get(r44) == null) goto L106;
        r120.addAll((Collection) r33.get(r44));
        goto L106
    L111:
        int r45 = r31.lastIndexOf(r114);
        if (r45 >= 0) goto L114;
    L127:
        LinkedList r122 = null;
    L128:
        if (r122 != null) goto L130;
    L139:
        r112.add(r114);
        goto L170
    L130:
        if (r122.isEmpty() == true) goto L139;
        Iterator r46 = r122.iterator();
    L134:
        if (r46.hasNext() == false) goto L138;
        Integer r47 = (Integer) r46.next();
        if (r31.get(r47.intValue()) == null) goto L134;
        r112.add(r31.get(r47.intValue()));
        goto L134
    L138:
        r112.add(r114);
        r113 = r31.size();
        goto L141
    L114:
        if (r45 >= r31.size()) goto L127;
        r122 = new LinkedList();
        Iterator r123 = r120.iterator();
    L118:
        if (r123.hasNext() == false) goto L128;
        int r48 = ((Integer) r123.next()).intValue();
        int r49 = r45 + 1;
        int r124 = r45;
    L121:
        if (r49 >= r31.size()) goto L126;
        if (r48 != ((rn.a) r31.get(r49)).getGestureArenaMemberId()) goto L125;
        r122.add(Integer.valueOf(r49));
    L125:
        r49 = r49 + 1;
        goto L121
    L126:
        r45 = r124;
        goto L118
    L95:
        if (r118.isEmpty() == false) goto L100;
    L172:
        LinkedList r50 = r23.f21957b;
        if (r50 != null) goto L175;
    L177:
        vn.d r51 = r23.f21959h;
        rn.a r52 = r23.g;
        r51.f22623j = r52;
        if (r51.f22624k == r52) goto L180;
        r51.f22624k = r52;
    L180:
        r51.f(r52);
        r51.e(r51.f22623j);
        tn.a r53 = new tn.a();
        r53.f22154a = 0;
        r53.f22155b = 0.0f;
        r53.f22156c = 0.0f;
        r53.d = false;
        r51.f22627n = r53;
        goto L181
    L175:
        if (r50.isEmpty() == true) goto L177;
        r23.g = (rn.a) r23.f21957b.getFirst();
    L181:
        int r54 = ViewConfiguration.getLongPressTimeout();
        com.lynx.tasm.u0 r55 = r10.f10289c.K;
        if (r55 == null) goto L184;
        int r56 = r55.J;
    L185:
        if (r56 < 0) goto L189;
        if (r55 == null) goto L188;
        r54 = r55.J;
        goto L189
    L188:
        r54 = -1;
    L189:
        this.f10178b.getClass();
        h.f10254m = r54;
        if (this.f10194w == false) goto L192;
        JavaOnlyMap r57 = new JavaOnlyMap();
        f(r57, r18, 0);
        g("touchstart", r18, r57);
    L194:
        if (b() == null) goto L211;
        wm.a r58 = this.f10179c;
    L197:
        LinkedList r59 = this.f;
        if (r58 == null) goto L203;
        r59.push(r58);
        if (r58.enableTouchPseudoPropagation() == false) goto L203;
        r58 = r58.parent();
    L203:
        int r60 = 0;
    L205:
        if (r60 >= r59.size()) goto L211;
        wm.a r61 = (wm.a) r59.get(r60);
        if (this.f10192u == false) goto L209;
        int r62 = 0;
        b().a(r61.getSign(), 0, 8);
    L210:
        r61.onPseudoStatusChanged(r62, 8);
        r60 = r60 + 1;
        goto L205
    L209:
        r62 = 0;
    L211:
        wm.a r63 = this.f10179c;
        if (r63 != null) goto L214;
        return true;
    L214:
        if (r63.getChildrenLynxPageUI() == null) goto L275;
        UIBody r64 = (UIBody) this.f10179c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.f10179c)));
        if (r64 != null) goto L218;
        return true;
    L218:
        if (r64.getLynxContext() != null) goto L220;
        return true;
    L220:
        if (r64.getLynxContext().f10140h == null) goto L278;
        on.g r65 = this.f10197z.f20787i;
        r18.setLocation(r65.f20784a, r65.f20785b);
        r64.getLynxContext().f10140h.j(r18, r64);
        return true;
    L278:
        return true;
    L275:
        return true;
    L192:
        h(this.f10179c, "touchstart", r18);
        goto L194
    L184:
        r56 = -1;
        goto L185
    L5:
        r11 = r19;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean k(boolean r5) {
        n0 r10 = this.f10177a;
        UIBody r11 = r10.f10288b;
        if (r11 != null) goto L5;
    L9:
        LynxLog.b(4, "LynxTouchEventDispatcher", "requestNativeDisallowIntercept failed, root ui or root ui'parent is null.");
        return false;
    L5:
        if (((UIBody.UIBodyView) r11.getView()).getParent() == null) goto L9;
        ((UIBody.UIBodyView) r10.f10288b.getView()).getParent().requestDisallowInterceptTouchEvent(r5);
        return r5;
    }

    public final void l() {
        LinkedList r5 = this.f10180h;
        Iterator r10 = r5.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((wm.a) r10.next()).offResponseChain();
        goto L4
    L6:
        this.f.clear();
        r5.clear();
        this.s.clear();
        this.f10191t.clear();
        this.f10186n = false;
        this.f10187o = false;
        this.f10188p = true;
        this.f10193v = false;
        this.d.clear();
        this.e.clear();
    }

    public final void m(MotionEvent r5) {
        int r10 = a(this.f10179c, this.s);
        int r11 = a(this.f10179c, this.f10191t);
        if (this.f10194w == true) goto L5;
    L6:
        wm.a r12 = this.f10179c;
        if (r12 != null) goto L9;
    L12:
        wm.a r13 = this.f10179c;
        if (r13 != null) goto L15;
        return;
    L15:
        if (r13.getChildrenLynxPageUI() == null) goto L25;
        UIBody r14 = (UIBody) this.f10179c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.f10179c)));
        if (r14 != null) goto L19;
        return;
    L19:
        if (r14.getLynxContext() != null) goto L21;
        return;
    L21:
        if (r14.getLynxContext().f10140h == null) goto L28;
        on.g r15 = this.f10197z.f20787i;
        r5.setLocation(r15.f20784a, r15.f20785b);
        r14.getLynxContext().f10140h.m(r5);
        return;
    L28:
        return;
    L25:
        return;
    L9:
        if (r10 != (-1)) goto L12;
        if (r11 != (-1)) goto L12;
        h(r12, "longpress", r5);
        goto L12
    L5:
        if (this.f10193v == true) goto L12;
        goto L6
    }

    public final void n(MotionEvent r10, UIGroup r11) {
        this.f10193v = true;
        int r5 = r10.getActionIndex();
        if (r11 != null) goto L5;
        r11 = this.f10177a.f10288b;
    L5:
        wm.a r12 = r11.hitTest(r10.getX(r5), r10.getY(r5));
        this.d.put(Integer.valueOf(r10.getPointerId(r5)), new z0(r12, r10.getX(r5), r10.getY(r5)));
        this.e.put(Integer.valueOf(r12.getSign()), r12);
        if (this.f10194w == false) goto L8;
        JavaOnlyMap r13 = new JavaOnlyMap();
        f(r13, r10, r5);
        g("touchstart", r10, r13);
    L8:
        wm.a r14 = this.f10179c;
        if (r14 != null) goto L11;
        return;
    L11:
        if (r14.getChildrenLynxPageUI() == null) goto L21;
        UIBody r15 = (UIBody) this.f10179c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.f10179c)));
        if (r15 != null) goto L15;
        return;
    L15:
        if (r15.getLynxContext() != null) goto L17;
        return;
    L17:
        if (r15.getLynxContext().f10140h == null) goto L24;
        on.g r16 = this.f10197z.f20787i;
        r10.setLocation(r16.f20784a, r16.f20785b);
        r15.getLynxContext().f10140h.n(r10, r15);
        return;
    L24:
        return;
    }

    public final void o(MotionEvent r10) {
        int r5 = a(this.f10179c, this.s);
        int r11 = a(this.f10179c, this.f10191t);
        boolean r12 = this.f10194w;
        n0 r13 = this.f10177a;
        if (r12 == false) goto L7;
        if (this.f10193v == false) goto L7;
    L23:
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L30;
        UIBody r14 = r13.f10288b;
        if (r14 == null) goto L30;
        UIBody.UIBodyView r15 = r14.f10385a;
        if (r15 == null) goto L30;
        ((LynxView) r15).getBaseInspectorOwner();
    L30:
        LynxLog.b(2, "LynxTouchEventDispatcher", "tap failed:" + this.f10189q + " " + this.f10186n + " " + r5 + " " + r11);
    L31:
        wm.a r16 = this.f10179c;
        if (r16 != null) goto L34;
        return;
    L34:
        if (r16.getChildrenLynxPageUI() == null) goto L44;
        UIBody r17 = (UIBody) this.f10179c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.f10179c)));
        if (r17 != null) goto L38;
        return;
    L38:
        if (r17.getLynxContext() != null) goto L40;
        return;
    L40:
        if (r17.getLynxContext().f10140h == null) goto L47;
        on.g r18 = this.f10197z.f20787i;
        r10.setLocation(r18.f20784a, r18.f20785b);
        r17.getLynxContext().f10140h.o(r10);
        return;
    L47:
        return;
    L44:
        return;
    L7:
        if (this.f10189q == true) goto L23;
        if (this.f10186n == true) goto L23;
        if (r5 != (-1)) goto L23;
        if (r11 != (-1)) goto L23;
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L21;
        this.f10179c.getSign();
        UIBody r19 = r13.f10288b;
        if (r19 == null) goto L21;
        UIBody.UIBodyView r20 = r19.f10385a;
        if (r20 == null) goto L21;
        ((LynxView) r20).getBaseInspectorOwner();
    L21:
        h(this.f10179c, "tap", r10);
        goto L31
    }

    public final boolean p(MotionEvent r28, UIGroup r29) {
        this.f10195x = System.currentTimeMillis();
        if (r28.getActionMasked() != 0) goto L9;
        if (j(r28, r29) == true) goto L29;
        LynxLog.b(2, "LynxTouchEventDispatcher", "hit event through");
        return false;
    L29:
        wm.a r5 = this.f10179c;
        if (r5 == null) goto L35;
        on.g r11 = this.A;
        if (r5.eventThrough(r11.f20784a, r11.f20785b) == false) goto L35;
        LynxLog.b(2, "LynxTouchEventDispatcher", "hit event through");
        return false;
    L35:
        wm.a r10 = this.f10179c;
        if (r10 == null) goto L38;
        r10.dispatchTouch(r28);
    L38:
        h r12 = this.f10178b;
        r12.getClass();
        int r13 = r28.getAction();
        float r14 = r28.getY();
        float r15 = r28.getX();
        int r16 = r13 & 255;
        ym.o r17 = r12.f10258c;
        bb.b r18 = r12.f10257b;
        if (r16 == 0) goto L88;
        if (r16 == 1) goto L78;
        boolean r19 = r12.f10263l;
        if (r16 == 2) goto L63;
        if (r16 == 3) goto L59;
        if (r16 == 5) goto L55;
        if (r16 != 6) goto L95;
        if (r19 == false) goto L95;
        if (r28.getPointerCount() != 2) goto L95;
        if (((65280 & r13) >> 8) != 0) goto L53;
        int r20 = 1;
    L54:
        r12.f10261j = r28.getX(r20);
        r12.f10260i = r28.getY(r20);
        goto L95
    L53:
        r20 = 0;
    L95:
        sn.a r21 = this.f10181i;
        if (r21 == null) goto L167;
        on.h r22 = this.f10197z;
        if (r21.f == false) goto L167;
        vn.d r110 = r21.f21959h;
        if (r110 == null) goto L167;
        LinkedList r111 = r21.f21957b;
        LinkedList r23 = r21.f21958c;
        int r24 = r28.getActionMasked();
        OverScroller r112 = r110.f22618a;
        if (r24 == 0) goto L132;
        if (r24 == 1) goto L115;
        if (r24 == 2) goto L108;
        if (r24 == 3) goto L115;
    L108:
        VelocityTracker r25 = r110.f;
        if (r25 == null) goto L111;
        r25.addMovement(r28);
    L111:
        rn.a r26 = r110.b(r111, r110.f22623j);
        r110.f22623j = r26;
        if (r26 != r110.f22624k) goto L114;
        r110.d(r26, r28.getX(), r28.getY(), r22, null, r28);
    L114:
        r110.c(r22, r111, r28.getX(), r28.getY(), r28);
    L115:
        r110.d(r110.f22623j, r28.getX(), r28.getY(), null, r111, r28);
        VelocityTracker r27 = r110.f;
        if (r27 == null) goto L118;
        r27.computeCurrentVelocity(1000);
        int r30 = i.a.b(r110.f22619b, r110.f.getXVelocity());
        int r31 = i.a.b(r110.f22619b, r110.f.getYVelocity());
    L120:
        if (r110.f22623j != null) goto L122;
    L131:
        r110.d(r110.f22623j, Float.MIN_VALUE, Float.MIN_VALUE, null, r111, null);
        goto L167
    L122:
        if (Math.abs(r30) <= 300) goto L124;
    L125:
        rn.a r32 = r110.f22623j;
        if (r32 == null) goto L167;
        if (r110.f == null) goto L167;
        r110.f22625l = r32;
        r112.fling(r32.getMemberScrollX(), r110.f22625l.getMemberScrollY(), (int) (-r110.f.getXVelocity()), (int) (-r110.f.getYVelocity()), Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
        r110.f22625l.onInvalidate();
        r110.f22620c = r110.f22625l.getMemberScrollX();
        r110.d = r110.f22625l.getMemberScrollY();
        goto L167
    L124:
        if (Math.abs(r31) <= 300) goto L131;
    L118:
        r31 = 0;
        r30 = 0;
        goto L120
    L132:
        if (r111 == null) goto L139;
        Iterator r33 = r111.iterator();
    L136:
        if (r33.hasNext() == false) goto L138;
        r110.e((rn.a) r33.next());
        goto L136
    L138:
        r110.f22622i = null;
    L139:
        if (r23 == null) goto L162;
        Iterator r34 = r23.iterator();
    L143:
        if (r34.hasNext() == false) goto L162;
        rn.a r35 = (rn.a) r34.next();
        if (r110.f22623j == null) goto L151;
        if (r110.e != r35.getGestureArenaMemberId()) goto L151;
    L153:
        r110.e = 0;
        if (r112.isFinished() == true) goto L162;
        r110.d(r110.f22623j, 0.0f, 0.0f, r22, r111, r28);
        r112.abortAnimation();
        LynxContext r36 = r110.f22619b;
        if (r36 == null) goto L162;
        a1 r37 = r36.f10140h;
        if (r37 == null) goto L162;
        r37.f10189q = true;
        if (r37.f.isEmpty() == true) goto L162;
        r37.d(8);
    L151:
        if (r110.e != 0) goto L143;
    L162:
        r110.d(r110.f22623j, r28.getX(), r28.getY(), r22, r111, r28);
        r110.c(r22, r111, r28.getX(), r28.getY(), r28);
        VelocityTracker r38 = r110.f;
        if (r38 != null) goto L165;
        r110.f = VelocityTracker.obtain();
    L166:
        r110.f.addMovement(r28);
        goto L167
    L165:
        r38.clear();
    L167:
        return true;
    L55:
        if (r19 == false) goto L95;
        r18.removeMessages(1);
        r18.removeMessages(2);
        r18.removeMessages(3);
        r12.f = false;
        if (r12.e == false) goto L95;
        r12.e = false;
        goto L95
    L59:
        r18.removeMessages(1);
        r18.removeMessages(2);
        r18.removeMessages(3);
        r12.f = false;
        if (r12.e == false) goto L95;
        r12.e = false;
        goto L95
    L63:
        if (r12.e == true) goto L95;
        if (r19 == true) goto L66;
    L68:
        float r39 = r12.f10261j - r15;
        float r40 = r12.f10260i - r14;
        if (r12.f == false) goto L74;
        int r41 = (int) (r15 - r12.g.getX());
        int r42 = (int) (r14 - r12.g.getY());
        if (((r42 * r42) + (r41 * r41)) <= r12.f10256a) goto L95;
        r17.getClass();
        r12.f10261j = r15;
        r12.f10260i = r14;
        r12.f = false;
        r18.removeMessages(3);
        r18.removeMessages(1);
        r18.removeMessages(2);
        goto L95
    L74:
        if (Math.abs(r39) < 1.0f) goto L76;
    L77:
        r17.getClass();
        r12.f10261j = r15;
        r12.f10260i = r14;
        goto L95
    L76:
        if (Math.abs(r40) < 1.0f) goto L95;
    L66:
        if (r28.getPointerCount() <= 1) goto L68;
    L78:
        MotionEvent r43 = MotionEvent.obtain(r28);
        if (r12.e == false) goto L82;
        r18.removeMessages(3);
        r12.e = false;
    L84:
        MotionEvent r44 = r12.f10259h;
        if (r44 == null) goto L87;
        r44.recycle();
    L87:
        r12.f10259h = r43;
        r18.removeMessages(1);
        r18.removeMessages(2);
        goto L95
    L82:
        if (r12.f == false) goto L84;
        r17.getClass();
        goto L84
    L88:
        r12.f10261j = r15;
        r12.f10260i = r14;
        MotionEvent r45 = r12.g;
        if (r45 == null) goto L91;
        r45.recycle();
    L91:
        r12.g = MotionEvent.obtain(r28);
        r12.f = true;
        r12.e = false;
        if (r12.f10262k == false) goto L94;
        r18.removeMessages(2);
        r18.sendEmptyMessageAtTime(2, (r12.g.getDownTime() + ((long) h.f10255n)) + ((long) h.f10254m));
    L94:
        r18.sendEmptyMessageAtTime(1, r12.g.getDownTime() + ((long) h.f10255n));
        r17.getClass();
        goto L95
    L9:
        if (r28.getActionMasked() != 5) goto L12;
        n(r28, r29);
        goto L29
    L12:
        if (this.f10179c == null) goto L29;
        if (this.d.isEmpty() == true) goto L29;
        wm.a r46 = this.f10179c;
        on.g r113 = this.A;
        if (r46.eventThrough(r113.f20784a, r113.f20785b) == false) goto L19;
        LynxLog.b(2, "LynxTouchEventDispatcher", "hit event through");
        return false;
    L19:
        int r47 = r28.getActionMasked();
        if (r47 == 1) goto L28;
        if (r47 == 2) goto L27;
        if (r47 == 3) goto L26;
        if (r47 != 6) goto L29;
        r(r28);
        goto L29
    L26:
        s(r28);
        goto L29
    L27:
        t(r28);
        goto L29
    L28:
        q(r28);
        d(-1);
        e(r28);
        o(r28);
        l();
        goto L29
    }

    public final void q(MotionEvent r10) {
        wm.a r5 = this.f10179c;
        if (r5 == null) goto L36;
        if (r5.ignoreFocus() == true) goto L36;
        if (this.f10189q == true) goto L36;
        if (a(this.f10179c, this.s) != (-1)) goto L36;
        if (a(this.f10179c, this.f10191t) != (-1)) goto L36;
        wm.a r11 = this.g;
        wm.a r12 = this.f10179c;
        this.g = r12;
        if (r12 == r11) goto L36;
        boolean r13 = true;
        if (r12 != null) goto L17;
    L25:
        if (r11 == null) goto L36;
        if (r11.isFocusable() == false) goto L36;
        wm.a r14 = this.f10179c;
        if (r14 != null) goto L31;
    L33:
        r13 = false;
    L34:
        r11.onFocusChanged(false, r13);
        goto L36
    L31:
        if (r14.isFocusable() == false) goto L33;
    L17:
        if (r12.isFocusable() == false) goto L25;
        wm.a r15 = this.f10179c;
        if (r11 != null) goto L21;
    L23:
        boolean r16 = false;
    L24:
        r15.onFocusChanged(true, r16);
        goto L25
    L21:
        if (r11.isFocusable() == false) goto L23;
        r16 = true;
    L36:
        if (this.f10194w == false) goto L38;
        JavaOnlyMap r17 = new JavaOnlyMap();
        f(r17, r10, 0);
        g("touchend", r10, r17);
    L39:
        wm.a r18 = this.f10179c;
        if (r18 != null) goto L42;
        return;
    L42:
        if (r18.getChildrenLynxPageUI() == null) goto L52;
        UIBody r19 = (UIBody) this.f10179c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.f10179c)));
        if (r19 != null) goto L46;
        return;
    L46:
        if (r19.getLynxContext() != null) goto L48;
        return;
    L48:
        if (r19.getLynxContext().f10140h == null) goto L55;
        on.g r20 = this.f10197z.f20787i;
        r10.setLocation(r20.f20784a, r20.f20785b);
        r19.getLynxContext().f10140h.q(r10);
        return;
    L55:
        return;
    L52:
        return;
    L38:
        h(this.f10179c, "touchend", r10);
        goto L39
    }

    public final void r(MotionEvent r5) {
        int r10 = r5.getActionIndex();
        if (this.f10194w == true) goto L5;
    L8:
        this.d.remove(Integer.valueOf(r5.getPointerId(r10)));
        wm.a r11 = this.f10179c;
        if (r11 != null) goto L11;
        return;
    L11:
        if (r11.getChildrenLynxPageUI() == null) goto L21;
        UIBody r12 = (UIBody) this.f10179c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.f10179c)));
        if (r12 != null) goto L15;
        return;
    L15:
        if (r12.getLynxContext() != null) goto L17;
        return;
    L17:
        if (r12.getLynxContext().f10140h == null) goto L24;
        on.g r13 = this.f10197z.f20787i;
        r5.setLocation(r13.f20784a, r13.f20785b);
        r12.getLynxContext().f10140h.r(r5);
        return;
    L24:
        return;
    L21:
        return;
    L5:
        if (r5.getPointerId(r10) != 0) goto L7;
        d(-1);
    L7:
        JavaOnlyMap r14 = new JavaOnlyMap();
        f(r14, r5, r10);
        g("touchend", r5, r14);
        goto L8
    }

    public final void s(MotionEvent r5) {
        if (this.f10194w == false) goto L9;
        JavaOnlyMap r10 = new JavaOnlyMap();
        Iterator r11 = this.d.values().iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        z0 r12 = (z0) r11.next();
        f(r10, r5, 0);
        goto L6
    L8:
        g("touchcancel", r5, r10);
    L10:
        d(-1);
        l();
        wm.a r13 = this.f10179c;
        if (r13 != null) goto L13;
        return;
    L13:
        if (r13.getChildrenLynxPageUI() == null) goto L24;
        UIBody r14 = (UIBody) this.f10179c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.f10179c)));
        if (r14 != null) goto L17;
        return;
    L17:
        if (r14.getLynxContext() != null) goto L19;
        return;
    L19:
        if (r14.getLynxContext().f10140h == null) goto L27;
        on.g r15 = this.f10197z.f20787i;
        r5.setLocation(r15.f20784a, r15.f20785b);
        r14.getLynxContext().f10140h.s(r5);
        return;
    L27:
        return;
    L24:
        return;
    L9:
        h(this.f10179c, "touchcancel", r5);
        goto L10
    }

    public final void t(MotionEvent r5) {
        int r10 = 0;
        if (this.f10188p == false) goto L9;
        float r11 = r5.getX(0) - this.f10184l.x;
        float r12 = r5.getY(0) - this.f10184l.y;
        if (Math.abs(r11) <= 0.0f) goto L7;
    L8:
        this.f10188p = false;
        goto L9
    L7:
        if (Math.abs(r12) > 0.0f) goto L8;
    L22:
        wm.a r13 = this.f10179c;
        if (r13 != null) goto L25;
        return;
    L25:
        if (r13.getChildrenLynxPageUI() == null) goto L38;
        UIBody r14 = (UIBody) this.f10179c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.f10179c)));
        if (r14 != null) goto L29;
        return;
    L29:
        if (r14.getLynxContext() != null) goto L31;
        return;
    L31:
        if (r14.getLynxContext().f10140h == null) goto L41;
        on.g r15 = this.f10197z.f20787i;
        r5.setLocation(r15.f20784a, r15.f20785b);
        r14.getLynxContext().f10140h.t(r5);
        return;
    L41:
        return;
    L38:
        return;
    L9:
        this.f10187o = true;
        if (this.f10194w == false) goto L20;
        JavaOnlyMap r16 = new JavaOnlyMap();
    L13:
        if (r10 >= r5.getPointerCount()) goto L18;
        if (i(r5, r10) == false) goto L17;
        f(r16, r5, r10);
    L17:
        r10 = r10 + 1;
        goto L13
    L18:
        g("touchmove", r5, r16);
        goto L22
    L20:
        if (i(r5, 0) == false) goto L22;
        h(this.f10179c, "touchmove", r5);
        goto L22
    }
}
