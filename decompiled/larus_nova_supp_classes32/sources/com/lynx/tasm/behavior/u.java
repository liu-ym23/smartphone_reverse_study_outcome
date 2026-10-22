package com.lynx.tasm.behavior;

import android.graphics.RectF;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.utils.UIThreadUtils;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class u {
    public final int a;
    public final WeakReference<d0> b;
    public final LynxBaseUI c;
    public final LynxBaseUI d;
    public LynxBaseUI e;
    public float f;
    public float g;
    public float h;
    public float i;
    public final ArrayList<Float> j;
    public final float k;
    public boolean l;
    public final boolean m;
    public final ArrayList<b> n;
    public final boolean o;

    public static class a {
        public RectF a;
        public RectF b;
        public RectF c;
        public float d;
        public boolean e;
        public String f;

        public final JavaOnlyMap b() {
            JavaOnlyMap r0 = new JavaOnlyMap();
            r0.putMap("relativeRect", a(this.a));
            r0.putMap("boundingClientRect", a(this.b));
            r0.putMap("intersectionRect", a(this.c));
            r0.putDouble("intersectionRatio", this.d);
            r0.putBoolean("isIntersecting", this.e);
            r0.putDouble("time", 0.0d);
            r0.putString("observerId", this.f);
            return r0;
        }

        public void update() {
            if (this.c != null) goto L6;
            this.d = 0.0f;
            return;
        L6:
            float r0 = this.b.width() * this.b.height();
            float r2 = this.c.width() * this.c.height();
            if (r0 <= 0.0f) goto L9;
            this.d = r2 / r0;
            return;
        L9:
            this.d = 0.0f;
        }

        public a() {
        }

        public static JavaOnlyMap a(RectF r7) {
            JavaOnlyMap r0 = new JavaOnlyMap();
            if (r7 == null) goto L5;
            r0.putDouble("left", r7.left);
            r0.putDouble("right", r7.right);
            r0.putDouble("top", r7.top);
            r0.putDouble("bottom", r7.bottom);
        L6:
            return r0;
        L5:
            r0.putDouble("left", 0.0d);
            r0.putDouble("right", 0.0d);
            r0.putDouble("top", 0.0d);
            r0.putDouble("bottom", 0.0d);
            goto L6
        }
    }

    public static class b {
        public LynxBaseUI a;
        public int b;
        public a c;

        public b() {
        }
    }

    public final RectF b() {
        RectF r0 = new RectF();
        d0 r1 = this.b.get();
        if (r1 != null) goto L5;
        return r0;
    L5:
        LynxBaseUI r2 = this.e;
        if (r2 == null) goto L9;
        RectF r3 = r1.d(r2);
    L12:
        r3.left -= this.f;
        r3.right += this.g;
        r3.top -= this.h;
        r3.bottom += this.i;
        return r3;
    L9:
        if (this.l == false) goto L11;
        r3 = r1.g(getContext());
        goto L12
    L11:
        r3 = r1.d(r1.getContext().getUIBody());
        goto L12
    }

    public LynxContext getContext() {
        d0 r0 = this.b.get();
        if (r0 != null) goto L7;
        LLog.e("LynxIntersectionObserver", "getContext failed because mManager is null");
        return null;
    L7:
        return r0.getContext();
    }

    public final LynxUIOwner c() {
        LynxContext r0 = getContext();
        if (r0 != null) goto L7;
        LLog.e("LynxIntersectionObserver", "getRootUIOwner failed because context is null");
        return null;
    L7:
        return r0.getLynxUIOwner();
    }

    public final void d(ReadableMap r4) {
        this.f = com.lynx.tasm.utils.n.a(r4.getString("left", "0"), 0.0f);
        this.g = com.lynx.tasm.utils.n.a(r4.getString("right", "0"), 0.0f);
        this.h = com.lynx.tasm.utils.n.a(r4.getString("top", "0"), 0.0f);
        this.i = com.lynx.tasm.utils.n.a(r4.getString("bottom", "0"), 0.0f);
    }

    public u(d0 r4, ReadableMap r5, LynxBaseUI r6) {
        this(r4, -1, "-1", r5);
        this.c = r6;
        String r7 = r5.getString("relativeToIdSelector", null);
        this.l = r5.getBoolean("relativeToScreen", false);
        this.f = com.lynx.tasm.utils.n.a(r5.getString("marginLeft", "0"), 0.0f);
        this.g = com.lynx.tasm.utils.n.a(r5.getString("marginRight", "0"), 0.0f);
        this.h = com.lynx.tasm.utils.n.a(r5.getString("marginTop", "0"), 0.0f);
        this.i = com.lynx.tasm.utils.n.a(r5.getString("marginBottom", "0"), 0.0f);
        if (r7 != null) goto L5;
    L7:
        this.o = true;
        b r8 = new b();
        r8.a = r6;
        this.n.add(r8);
        a(r8, b(), true);
        return;
    L5:
        if (r7.startsWith("#") == false) goto L7;
        this.e = this.b.get().getContext().getLynxUIOwner().findLynxUIByIdSelectorSearchUp(r7.substring(1), r6);
        goto L7
    }

    public final void a(b r18, RectF r19, boolean r20) {
        WeakReference<d0> r3 = this.b;
        if (r3 != null) goto L5;
        return;
    L5:
        d0 r4 = r3.get();
        if (r4 != null) goto L8;
        return;
    L8:
        RectF r5 = r4.d(r18.a);
        LynxBaseUI r6 = r18.a;
        if (r6.isVisible() == false) goto L53;
        d0 r7 = this.b.get();
        if (r7 == null) goto L53;
        LynxBaseUI r8 = (LynxBaseUI) r6.getParent();
        LynxBaseUI r10 = this.e;
        if (r10 == null) goto L17;
    L23:
        RectF r12 = r5;
        boolean r11 = false;
    L24:
        if (r11 == true) goto L48;
        if (r8 == null) goto L48;
        if (r8.isVisible() == false) goto L53;
        if (r8 != r10) goto L36;
        if (this.l == false) goto L33;
        RectF r13 = r7.d(r8);
    L34:
        boolean r14 = true;
    L39:
        if (r13 != null) goto L41;
    L44:
        if (r12 == null) goto L48;
        r8 = (LynxBaseUI) r8.getParent();
        r11 = r14;
        goto L24
    L41:
        if (r13.intersects(r12.left, r12.top, r12.right, r12.bottom) == false) goto L43;
        r12 = new RectF(Math.max(r13.left, r12.left), Math.max(r13.top, r12.top), Math.min(r13.right, r12.right), Math.min(r13.bottom, r12.bottom));
        goto L44
    L43:
        r12 = null;
        goto L44
    L33:
        r13 = r19;
        goto L34
    L36:
        if (r8.getOverflow() != 0) goto L38;
        r14 = r11;
        r13 = r7.d(r8);
        goto L39
    L38:
        r14 = r11;
        r13 = null;
    L48:
        if (this.l == false) goto L54;
        RectF r9 = r7.d(r7.getContext().getLynxUIOwner().getRootUI());
        r5.offset(r9.left, r9.top);
        if (r12 == null) goto L54;
        r12.offset(r9.left, r9.top);
        if (r12.intersect(r19) == false) goto L53;
    L54:
        RectF r15 = r12;
    L55:
        a r16 = new a();
        if (r15 == null) goto L61;
        if (r15.isEmpty() == true) goto L61;
        r16.e = true;
    L61:
        r16.b = r5;
        r16.a = r19;
        r16.c = r15;
        LynxBaseUI r2 = r18.a;
        if (r2 != null) goto L64;
    L66:
        String r17 = NameKeys.UnloadStrategy_No_Strategy;
    L67:
        r16.f = r17;
        r16.update();
        a r21 = r18.c;
        r18.c = r16;
        int r1 = r18.b;
        if (r20 == true) goto L70;
        float r22 = -1.0f;
        if (r21 != null) goto L75;
    L77:
        float r23 = -1.0f;
    L79:
        if (r16.c == null) goto L82;
        r22 = r16.d;
    L82:
        if (r23 == r22) goto L101;
        Iterator<Float> r24 = this.j.iterator();
    L86:
        if (r24.hasNext() == false) goto L101;
        float r25 = r24.next().floatValue();
        if (r25 == r23) goto L100;
        if (r25 == r22) goto L100;
        if (r25 >= r23) goto L94;
        boolean r26 = true;
    L96:
        if (r25 >= r22) goto L98;
        boolean r27 = true;
    L99:
        if (r26 == r27) goto L86;
    L98:
        r27 = false;
        goto L99
    L94:
        r26 = false;
    L100:
        boolean r28 = true;
    L102:
        if (r28 == true) goto L104;
        return;
    L104:
        if (this.o == false) goto L107;
        UIThreadUtils.runOnUiThreadImmediately(new v(r4, this.c.getSign(), r16.b()));
        return;
    L107:
        if (this.m == false) goto L109;
        UIThreadUtils.runOnUiThreadImmediately(new w(r4, this.a, r1, r16.b()));
        return;
    L109:
        UIThreadUtils.runOnUiThreadImmediately(new x(r4, this.a, r1, r16.b()));
        return;
    L101:
        r28 = false;
        goto L102
    L75:
        if (r21.c == null) goto L77;
        r23 = r21.d;
        goto L79
    L70:
        if (this.k >= r16.d) goto L101;
    L64:
        if (r2.getIdSelector() == null) goto L66;
        r17 = r18.a.getIdSelector();
        goto L67
    L17:
        if (r7.getContext() != null) goto L19;
    L22:
        LLog.e("LynxIntersectionObserver", "Get UI error");
        goto L23
    L19:
        if (r7.getContext().getLynxUIOwner() == null) goto L22;
        r10 = r7.getContext().getLynxUIOwner().getRootUI();
    L53:
        r15 = null;
        goto L55
    }

    public u(d0 r4, int r5, String r6, ReadableMap r7) {
        WeakReference<d0> r0 = new WeakReference(r4);
        this.b = r0;
        this.a = r5;
        if ("-1".equals(r6) == false) goto L5;
        this.d = r0.get().getContext().getUIBody();
    L6:
        ArrayList<Float> r8 = new ArrayList();
        this.j = r8;
        ReadableArray r9 = r7.getArray("thresholds");
        if (r9 == null) goto L12;
        int r10 = 0;
    L10:
        if (r10 >= r9.size()) goto L13;
        this.j.add(Float.valueOf((float) r9.getDouble(r10)));
        r10 = r10 + 1;
    L13:
        this.k = (float) r7.getDouble("initialRatio", 0.0d);
        r7.getBoolean("observeAll", false);
        this.m = r7.getBoolean("__enableGlobalEvent", false);
        this.n = new ArrayList();
        this.o = false;
        return;
    L12:
        r8.add(Float.valueOf(0.0f));
        goto L13
    L5:
        this.d = r0.get().getContext().findLynxUIByComponentId(r6);
        goto L6
    }
}
