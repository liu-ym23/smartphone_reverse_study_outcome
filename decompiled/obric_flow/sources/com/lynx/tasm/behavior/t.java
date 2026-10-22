package com.lynx.tasm.behavior;

import android.graphics.RectF;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference f10365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LynxBaseUI f10366c;
    public final LynxBaseUI d;
    public LynxBaseUI e;
    public float f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f10367h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f10368i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList f10369j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f10370k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f10371l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList f10372m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f10373n;

    public t(w r5, int r10, String r11, ReadableMap r12) {
        WeakReference r13 = new WeakReference(r5);
        this.f10365b = r13;
        this.f10364a = r10;
        if ("-1".equals(r11) == false) goto L5;
        this.d = ((LynxContext) ((w) r13.get()).f10806w.get()).f10145m;
    L10:
        ArrayList r14 = new ArrayList();
        this.f10369j = r14;
        ReadableArray r15 = r12.getArray("thresholds");
        if (r15 == null) goto L16;
        int r16 = 0;
    L14:
        if (r16 >= r15.size()) goto L17;
        this.f10369j.add(Float.valueOf((float) r15.getDouble(r16)));
        r16 = r16 + 1;
    L17:
        this.f10370k = (float) r12.getDouble("initialRatio", 0.0d);
        r12.getBoolean("observeAll", false);
        this.f10372m = new ArrayList();
        this.f10373n = false;
        return;
    L16:
        r14.add(Float.valueOf(0.0f));
        goto L17
    L5:
        n0 r17 = (n0) ((LynxContext) ((w) r13.get()).f10806w.get()).f10147o.get();
        if (r17 == null) goto L8;
        LynxBaseUI r18 = r17.B(r11);
    L9:
        this.d = r18;
        goto L10
    L8:
        r18 = null;
        goto L9
    }

    public final void a(ReadableMap r5) {
        this.f = com.lynx.tasm.utils.k.b(r5.getString(OpenPageMethod.ALIGN_LEFT, "0"));
        this.g = com.lynx.tasm.utils.k.b(r5.getString("right", "0"));
        this.f10367h = com.lynx.tasm.utils.k.b(r5.getString("top", "0"));
        this.f10368i = com.lynx.tasm.utils.k.b(r5.getString("bottom", "0"));
    }

    public final void b(s r19, RectF r20, boolean r21) {
        WeakReference r5 = this.f10365b;
        if (r5 == null) goto L126;
        w r10 = (w) r5.get();
        if (r10 == null) goto L127;
        RectF r11 = r10.b(r19.f10327a);
        LynxBaseUI r12 = r19.f10327a;
        if (r12.isVisible() == false) goto L54;
        w r13 = (w) r5.get();
        if (r13 == null) goto L54;
        LynxBaseUI r14 = (LynxBaseUI) r12.getParent();
        LynxBaseUI r15 = this.e;
        WeakReference r16 = r13.f10806w;
        if (r15 == null) goto L17;
    L23:
        RectF r17 = r11;
        boolean r18 = false;
    L24:
        if (r18 == true) goto L49;
        if (r14 == null) goto L49;
        if (r14.isVisible() == false) goto L54;
        if (r14 != r15) goto L36;
        if (this.f10371l == false) goto L34;
        RectF r110 = r13.b(r14);
    L33:
        boolean r111 = true;
    L39:
        if (r110 == null) goto L45;
        if (r110.intersects(r17.left, r17.top, r17.right, r17.bottom) == false) goto L43;
        r17 = new RectF(Math.max(r110.left, r17.left), Math.max(r110.top, r17.top), Math.min(r110.right, r17.right), Math.min(r110.bottom, r17.bottom));
        goto L45
    L43:
        r17 = null;
    L45:
        if (r17 == null) goto L49;
        r14 = (LynxBaseUI) r14.getParent();
        r18 = r111;
        r15 = r15;
        goto L24
    L34:
        r110 = r20;
        goto L33
    L36:
        if (r14.getOverflow() != 0) goto L38;
        r111 = r18;
        r110 = r13.b(r14);
        goto L39
    L38:
        r111 = r18;
        r110 = null;
    L49:
        if (this.f10371l == false) goto L55;
        RectF r22 = r13.b(((n0) ((LynxContext) r16.get()).f10147o.get()).f10288b);
        r11.offset(r22.left, r22.top);
        if (r17 == null) goto L55;
        r17.offset(r22.left, r22.top);
        if (r17.intersect(r20) == false) goto L54;
    L55:
        RectF r23 = r17;
    L56:
        r r24 = new r();
        if (r23 != null) goto L59;
    L61:
        boolean r25 = true;
    L62:
        r24.f10322b = r11;
        r24.f10321a = r20;
        r24.f10323c = r23;
        LynxBaseUI r26 = r19.f10327a;
        if (r26 != null) goto L65;
    L67:
        String r27 = "";
    L68:
        r24.f = r27;
        if (r24.f10323c != null) goto L71;
        r24.d = 0.0f;
    L75:
        r r28 = r19.f10329c;
        r19.f10329c = r24;
        int r29 = r19.f10328b;
        if (r21 == true) goto L78;
        float r30 = -1.0f;
        if (r28 != null) goto L83;
    L85:
        float r31 = -1.0f;
    L87:
        if (r24.f10323c == null) goto L90;
        r30 = r24.d;
    L90:
        if (r31 == r30) goto L128;
        Iterator r32 = this.f10369j.iterator();
    L94:
        if (r32.hasNext() == false) goto L129;
        float r33 = ((Float) r32.next()).floatValue();
        if (r33 == r31) goto L109;
        if (r33 == r30) goto L109;
        if (r33 >= r31) goto L102;
        boolean r34 = r25;
    L104:
        if (r33 >= r30) goto L106;
        boolean r35 = r25;
    L107:
        if (r34 == r35) goto L94;
    L106:
        r35 = false;
        goto L107
    L102:
        r34 = false;
    L109:
        if (this.f10373n == false) goto L112;
        int r36 = this.f10366c.getSign();
        JavaOnlyMap r37 = new JavaOnlyMap();
        r37.putMap("relativeRect", r.a(r24.f10321a));
        r37.putMap("boundingClientRect", r.a(r24.f10322b));
        r37.putMap("intersectionRect", r.a(r24.f10323c));
        r37.putDouble("intersectionRatio", r24.d);
        r37.putBoolean("isIntersecting", r24.e);
        r37.putDouble("time", 0.0d);
        r37.putString("observerId", r24.f);
        com.lynx.tasm.utils.j.f(new a7.a(r10, r36, r37, 1));
        return;
    L112:
        JavaOnlyMap r38 = new JavaOnlyMap();
        r38.putMap("relativeRect", r.a(r24.f10321a));
        r38.putMap("boundingClientRect", r.a(r24.f10322b));
        r38.putMap("intersectionRect", r.a(r24.f10323c));
        r38.putDouble("intersectionRatio", r24.d);
        r38.putBoolean("isIntersecting", r24.e);
        r38.putDouble("time", 0.0d);
        r38.putString("observerId", r24.f);
        com.lynx.tasm.utils.j.f(new u(r10, this.f10364a, r29, r38));
        return;
    L129:
        return;
    L128:
        return;
    L83:
        if (r28.f10323c == null) goto L85;
        r31 = r28.d;
        goto L87
    L78:
        if (this.f10370k < r24.d) goto L109;
        return;
    L71:
        float r39 = r24.f10322b.height() * r24.f10322b.width();
        float r40 = r24.f10323c.height() * r24.f10323c.width();
        if (r39 <= 0.0f) goto L74;
        r24.d = r40 / r39;
        goto L75
    L74:
        r24.d = 0.0f;
        goto L75
    L65:
        if (r26.getIdSelector() == null) goto L67;
        r27 = r19.f10327a.getIdSelector();
        goto L68
    L59:
        if (r23.isEmpty() == true) goto L61;
        r25 = true;
        r24.e = true;
        goto L62
    L17:
        if (((LynxContext) r16.get()) != null) goto L19;
    L22:
        LynxLog.b(4, "LynxIntersectionObserver", "Get UI error");
        goto L23
    L19:
        if (((n0) ((LynxContext) r16.get()).f10147o.get()) == null) goto L22;
        r15 = ((n0) ((LynxContext) r16.get()).f10147o.get()).f10288b;
    L54:
        r23 = null;
        goto L56
    L127:
        return;
    }

    public final LynxContext c() {
        w r5 = (w) this.f10365b.get();
        if (r5 != null) goto L7;
        LynxLog.b(4, "LynxIntersectionObserver", "getContext failed because mManager is null");
        return null;
    L7:
        return (LynxContext) r5.f10806w.get();
    }

    public final RectF d() {
        RectF r5 = new RectF();
        w r10 = (w) this.f10365b.get();
        if (r10 != null) goto L5;
        return r5;
    L5:
        LynxBaseUI r11 = this.e;
        if (r11 == null) goto L9;
        RectF r12 = r10.b(r11);
    L12:
        r12.left -= this.f;
        r12.right += this.g;
        r12.top -= this.f10367h;
        r12.bottom += this.f10368i;
        return r12;
    L9:
        if (this.f10371l == false) goto L11;
        r12 = r10.a(c());
        goto L12
    L11:
        r12 = r10.b(((LynxContext) r10.f10806w.get()).f10145m);
        goto L12
    }

    public final n0 e() {
        LynxContext r5 = c();
        if (r5 != null) goto L7;
        LynxLog.b(4, "LynxIntersectionObserver", "getRootUIOwner failed because context is null");
        return null;
    L7:
        return (n0) r5.f10147o.get();
    }

    public t(w r5, ReadableMap r10, LynxBaseUI r11) {
        this(r5, -1, "-1", r10);
        this.f10366c = r11;
        String r12 = r10.getString("relativeToIdSelector", null);
        this.f10371l = r10.getBoolean("relativeToScreen", false);
        this.f = com.lynx.tasm.utils.k.b(r10.getString("marginLeft", "0"));
        this.g = com.lynx.tasm.utils.k.b(r10.getString("marginRight", "0"));
        this.f10367h = com.lynx.tasm.utils.k.b(r10.getString("marginTop", "0"));
        this.f10368i = com.lynx.tasm.utils.k.b(r10.getString("marginBottom", "0"));
        if (r12 != null) goto L5;
    L7:
        this.f10373n = true;
        s r13 = new s();
        r13.f10327a = r11;
        this.f10372m.add(r13);
        b(r13, d(), true);
        return;
    L5:
        if (r12.startsWith("#") == false) goto L7;
        n0 r14 = (n0) ((LynxContext) ((w) this.f10365b.get()).f10806w.get()).f10147o.get();
        String r15 = r12.substring(1);
        r14.getClass();
        this.e = n0.x(r15, r11);
        goto L7
    }
}
