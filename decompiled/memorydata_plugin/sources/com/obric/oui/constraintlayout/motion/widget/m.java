package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.motion.widget.Key;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class m {
    private ArrayList<d> A;
    private HashMap<String, com.obric.oui.constraintlayout.motion.a.f> B;
    private HashMap<String, com.obric.oui.constraintlayout.motion.a.d> C;
    private HashMap<String, com.obric.oui.constraintlayout.motion.a.c> D;
    private k[] E;
    private int F;
    private int G;
    private View H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private float f13696J;
    private Interpolator K;
    private boolean L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Rect f13697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    View f13698b;
    int c;
    boolean d;
    String e;
    float f;
    float g;
    float h;
    float i;
    float j;
    private int k;
    private p l;
    private p m;
    private l n;
    private l o;
    private com.obric.oui.constraintlayout.core.motion.a.b[] p;
    private com.obric.oui.constraintlayout.core.motion.a.b q;
    private int[] r;
    private double[] s;
    private double[] t;
    private String[] u;
    private int[] v;
    private int w;
    private float[] x;
    private ArrayList<p> y;
    private float[] z;

    m(View r5) {
        this.f13697a = new Rect();
        this.d = false;
        this.k = -1;
        this.l = new p();
        this.m = new p();
        this.n = new l();
        this.o = new l();
        this.f = Float.NaN;
        this.g = 0.0f;
        this.h = 1.0f;
        this.w = 4;
        this.x = new float[4];
        this.y = new ArrayList();
        this.z = new float[1];
        this.A = new ArrayList();
        this.F = d.f13685a;
        this.G = d.f13685a;
        this.H = null;
        this.I = d.f13685a;
        this.f13696J = Float.NaN;
        this.K = null;
        this.L = false;
        a(r5);
    }

    private float a(float r12, float[] r13) {
        float r0 = 0.0f;
        float r2 = 1.0f;
        if (r13 == null) goto L5;
        r13[0] = 1.0f;
    L15:
        com.obric.oui.constraintlayout.core.motion.a.c r3 = this.l.f13701b;
        float r4 = Float.NaN;
        Iterator<p> r11 = this.y.iterator();
    L17:
        if (r11.hasNext() == false) goto L26;
        p r5 = (p) ZeusTransformUtils.preCheckCast(r11.next(), p.class, "com.obric.memorydata.plugin");
        if (r5.f13701b == null) goto L17;
        if (r5.d < r12) goto L22;
        if (Float.isNaN(r4) == false) goto L17;
        r4 = r5.d;
        goto L17
    L22:
        r3 = r5.f13701b;
        r0 = r5.d;
        goto L17
    L26:
        if (r3 != null) goto L28;
        return r12;
    L28:
        if (Float.isNaN(r4) == true) goto L31;
        r2 = r4;
    L31:
        float r6 = r2 - r0;
        double r14 = (r12 - r0) / r6;
        float r1 = r0 + (((float) r3.a(r14)) * r6);
        if (r13 == null) goto L35;
        r13[0] = (float) r3.b(r14);
    L35:
        return r1;
    L5:
        float r7 = this.h;
        if (r7 == 1.0d) goto L15;
        float r8 = this.g;
        if (r12 >= r8) goto L11;
        r12 = 0.0f;
    L11:
        if (r12 <= r8) goto L15;
        if (r12 >= 1.0d) goto L15;
        r12 = Math.min((r12 - r8) * r7, 1.0f);
        goto L15
    }

    private static Interpolator a(Context r2, int r3, String r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 == (-2)) goto L30;
        if (r3 == (-1)) goto L27;
        if (r3 == 0) goto L26;
        if (r3 == 1) goto L24;
        if (r3 == 2) goto L22;
        if (r3 == 4) goto L20;
        if (r3 == 5) goto L18;
        return null;
    L18:
        return new OvershootInterpolator();
    L20:
        return new BounceInterpolator();
    L22:
        return new DecelerateInterpolator();
    L24:
        return new AccelerateInterpolator();
    L26:
        return new AccelerateDecelerateInterpolator();
    L27:
        final com.obric.oui.constraintlayout.core.motion.a.c r7 = com.obric.oui.constraintlayout.core.motion.a.c.a(r4);
        return new AnonymousClass1(r7);
    L30:
        return AnimationUtils.loadInterpolator(r6, r5);
    }

    private void a(p r4) {
        int r0 = Collections.binarySearch(this.y, r4);
        if (r0 != 0) goto L5;
        Log.e("MotionController", " KeyPath position \"" + r4.e + "\" outside of range");
    L5:
        this.y.add((-r0) - 1, r4);
    }

    private void b(p r4) {
        r4.a((int) this.f13698b.getX(), (int) this.f13698b.getY(), this.f13698b.getWidth(), this.f13698b.getHeight());
    }

    private float k() {
        float[] r1 = new float[2];
        float r10 = 1.0f / 99;
        double r13 = 0.0d;
        double r15 = 0.0d;
        int r8 = 0;
        float r17 = 0.0f;
    L4:
        if (r8 >= 100) goto L27;
        float r2 = r8 * r10;
        double r3 = r2;
        com.obric.oui.constraintlayout.core.motion.a.c r5 = this.l.f13701b;
        float r6 = Float.NaN;
        Iterator<p> r7 = this.y.iterator();
        float r18 = 0.0f;
    L7:
        if (r7.hasNext() == false) goto L17;
        p r9 = (p) ZeusTransformUtils.preCheckCast(r7.next(), p.class, "com.obric.memorydata.plugin");
        if (r9.f13701b == null) goto L7;
        if (r9.d >= r2) goto L14;
        r5 = r9.f13701b;
        r18 = r9.d;
        goto L7
    L14:
        if (Float.isNaN(r6) == false) goto L7;
        r6 = r9.d;
        goto L7
    L17:
        if (r5 != null) goto L19;
    L22:
        this.p[0].a(r3, this.s);
        int r12 = r8;
        this.l.a(r3, this.r, this.s, r1, 0);
        if (r12 <= 0) goto L25;
        char r11 = 0;
        r17 = r17 + ((float) Math.hypot(r15 - ((double) r1[1]), r13 - ((double) r1[0])));
    L26:
        r13 = r1[r11];
        r8 = r12 + 1;
        r15 = r1[1];
        goto L4
    L25:
        r11 = 0;
        goto L26
    L19:
        if (Float.isNaN(r6) == false) goto L21;
        r6 = 1.0f;
    L21:
        float r14 = r6 - r18;
        r3 = (((float) r5.a((r2 - r18) / r14)) * r14) + r18;
        goto L22
    L27:
        return r17;
    }

    public float a() {
        return this.l.f;
    }

    int a(float[] r11, int[] r12) {
        if (r11 == null) goto L16;
        double[] r1 = this.p[0].a();
        if (r12 == null) goto L10;
        Iterator<p> r2 = this.y.iterator();
        int r3 = 0;
    L8:
        if (r2.hasNext() == false) goto L10;
        r12[r3] = ((p) ZeusTransformUtils.preCheckCast(r2.next(), p.class, "com.obric.memorydata.plugin")).q;
        r3 = r3 + 1;
    L10:
        int r13 = 0;
        int r9 = 0;
    L12:
        if (r13 >= r1.length) goto L15;
        this.p[0].a(r1[r13], this.s);
        this.l.a(r1[r13], this.r, this.s, r11, r9);
        r9 = r9 + 2;
        r13 = r13 + 1;
        goto L12
    L15:
        return r9 / 2;
    L16:
        return 0;
    }

    p a(int r2) {
        return (p) ZeusTransformUtils.preCheckCast(this.y.get(r2), p.class, "com.obric.memorydata.plugin");
    }

    public void a(double r10, float[] r12, float[] r13) {
        double[] r5 = new double[4];
        double[] r7 = new double[4];
        this.p[0].a(r10, r5);
        this.p[0].b(r10, r7);
        Arrays.fill(r13, 0.0f);
        this.l.a(r10, this.r, r5, r12, r7, r13);
    }

    void a(float r12, float r13, float r14, float[] r15) {
        float r16 = a(r12, this.z);
        com.obric.oui.constraintlayout.core.motion.a.b[] r0 = this.p;
        int r1 = 0;
        if (r0 == null) goto L16;
        double r2 = r16;
        r0[0].b(r2, this.t);
        this.p[0].a(r2, this.s);
        float r17 = this.z[0];
    L5:
        double[] r9 = this.t;
        if (r1 >= r9.length) goto L8;
        r9[r1] = r9[r1] * ((double) r17);
        r1 = r1 + 1;
        goto L5
    L8:
        com.obric.oui.constraintlayout.core.motion.a.b r18 = this.q;
        if (r18 == null) goto L14;
        double[] r3 = this.s;
        if (r3.length <= 0) goto L19;
        r18.a(r2, r3);
        this.q.b(r2, this.t);
        this.l.a(r13, r14, r15, this.r, this.t, this.s);
        return;
    L19:
        return;
    L14:
        this.l.a(r13, r14, r15, this.r, r9, this.s);
        return;
    L16:
        float r19 = this.m.f - this.l.f;
        float r4 = this.m.g - this.l.g;
        float r5 = (this.m.h - this.l.h) + r19;
        float r6 = (this.m.i - this.l.i) + r4;
        r15[0] = (r19 * (1.0f - r13)) + (r5 * r13);
        r15[1] = (r4 * (1.0f - r14)) + (r6 * r14);
    }

    void a(float r19, int r20, int r21, float r22, float r23, float[] r24) {
        float r1 = a(r19, this.z);
        HashMap<String, com.obric.oui.constraintlayout.motion.a.d> r2 = this.C;
        com.obric.oui.constraintlayout.motion.a.c r4 = null;
        if (r2 != null) goto L5;
        com.obric.oui.constraintlayout.core.motion.a.j r3 = null;
    L6:
        HashMap<String, com.obric.oui.constraintlayout.motion.a.d> r6 = this.C;
        if (r6 != null) goto L9;
        com.obric.oui.constraintlayout.core.motion.a.j r7 = null;
    L10:
        HashMap<String, com.obric.oui.constraintlayout.motion.a.d> r8 = this.C;
        if (r8 != null) goto L13;
        com.obric.oui.constraintlayout.core.motion.a.j r9 = null;
    L14:
        HashMap<String, com.obric.oui.constraintlayout.motion.a.d> r10 = this.C;
        if (r10 != null) goto L17;
        com.obric.oui.constraintlayout.core.motion.a.j r11 = null;
    L18:
        HashMap<String, com.obric.oui.constraintlayout.motion.a.d> r12 = this.C;
        if (r12 != null) goto L21;
        com.obric.oui.constraintlayout.core.motion.a.j r13 = null;
    L22:
        HashMap<String, com.obric.oui.constraintlayout.motion.a.c> r14 = this.D;
        if (r14 != null) goto L25;
        com.obric.oui.constraintlayout.motion.a.c r5 = null;
    L26:
        HashMap<String, com.obric.oui.constraintlayout.motion.a.c> r15 = this.D;
        if (r15 != null) goto L29;
        com.obric.oui.constraintlayout.motion.a.c r16 = null;
    L30:
        HashMap<String, com.obric.oui.constraintlayout.motion.a.c> r17 = this.D;
        if (r17 != null) goto L33;
        com.obric.oui.constraintlayout.motion.a.c r18 = null;
    L34:
        HashMap<String, com.obric.oui.constraintlayout.motion.a.c> r110 = this.D;
        if (r110 != null) goto L37;
        com.obric.oui.constraintlayout.motion.a.c r111 = null;
    L38:
        HashMap<String, com.obric.oui.constraintlayout.motion.a.c> r112 = this.D;
        if (r112 == null) goto L42;
        r4 = (com.obric.oui.constraintlayout.motion.a.c) ZeusTransformUtils.preCheckCast(r112.get("scaleY"), com.obric.oui.constraintlayout.motion.a.c.class, "com.obric.memorydata.plugin");
    L42:
        com.obric.oui.constraintlayout.core.motion.a.q r113 = new com.obric.oui.constraintlayout.core.motion.a.q();
        r113.a();
        r113.a(r9, r1);
        r113.a(r3, r7, r1);
        r113.b(r11, r13, r1);
        r113.a(r18, r1);
        r113.a(r5, r16, r1);
        r113.b(r111, r4, r1);
        com.obric.oui.constraintlayout.core.motion.a.b r25 = this.q;
        if (r25 == null) goto L49;
        double[] r26 = this.s;
        if (r26.length <= 0) goto L47;
        double r27 = r1;
        r25.a(r27, r26);
        this.q.b(r27, this.t);
        this.l.a(r22, r23, r24, this.r, this.t, this.s);
    L47:
        r113.a(r22, r23, r20, r21, r24);
        return;
    L49:
        int r114 = 0;
        if (this.p == null) goto L57;
        double r28 = a(r1, this.z);
        this.p[0].b(r28, this.t);
        this.p[0].a(r28, this.s);
        float r29 = this.z[0];
    L52:
        double[] r30 = this.t;
        if (r114 >= r30.length) goto L55;
        r30[r114] = r30[r114] * ((double) r29);
        r114 = r114 + 1;
        goto L52
    L55:
        this.l.a(r22, r23, r24, this.r, r30, this.s);
        r113.a(r22, r23, r20, r21, r24);
        return;
    L57:
        float r31 = this.m.f - this.l.f;
        float r115 = this.m.g - this.l.g;
        com.obric.oui.constraintlayout.motion.a.c r116 = r4;
        float r117 = (this.m.h - this.l.h) + r31;
        float r32 = (this.m.i - this.l.i) + r115;
        r24[0] = (r31 * (1.0f - r22)) + (r117 * r22);
        r24[1] = (r115 * (1.0f - r23)) + (r32 * r23);
        r113.a();
        r113.a(r9, r1);
        r113.a(r3, r7, r1);
        r113.b(r11, r13, r1);
        r113.a(r18, r1);
        r113.a(r5, r16, r1);
        r113.b(r111, r116, r1);
        r113.a(r22, r23, r20, r21, r24);
        return;
    L37:
        r111 = (com.obric.oui.constraintlayout.motion.a.c) ZeusTransformUtils.preCheckCast(r110.get("scaleX"), com.obric.oui.constraintlayout.motion.a.c.class, "com.obric.memorydata.plugin");
        goto L38
    L33:
        r18 = (com.obric.oui.constraintlayout.motion.a.c) ZeusTransformUtils.preCheckCast(r17.get(Key.ROTATION), com.obric.oui.constraintlayout.motion.a.c.class, "com.obric.memorydata.plugin");
        goto L34
    L29:
        r16 = (com.obric.oui.constraintlayout.motion.a.c) ZeusTransformUtils.preCheckCast(r15.get("translationY"), com.obric.oui.constraintlayout.motion.a.c.class, "com.obric.memorydata.plugin");
        goto L30
    L25:
        r5 = (com.obric.oui.constraintlayout.motion.a.c) ZeusTransformUtils.preCheckCast(r14.get("translationX"), com.obric.oui.constraintlayout.motion.a.c.class, "com.obric.memorydata.plugin");
        goto L26
    L21:
        r13 = (com.obric.oui.constraintlayout.core.motion.a.j) ZeusTransformUtils.preCheckCast(r12.get("scaleY"), com.obric.oui.constraintlayout.core.motion.a.j.class, "com.obric.memorydata.plugin");
        goto L22
    L17:
        r11 = (com.obric.oui.constraintlayout.core.motion.a.j) ZeusTransformUtils.preCheckCast(r10.get("scaleX"), com.obric.oui.constraintlayout.core.motion.a.j.class, "com.obric.memorydata.plugin");
        goto L18
    L13:
        r9 = (com.obric.oui.constraintlayout.core.motion.a.j) ZeusTransformUtils.preCheckCast(r8.get(Key.ROTATION), com.obric.oui.constraintlayout.core.motion.a.j.class, "com.obric.memorydata.plugin");
        goto L14
    L9:
        r7 = (com.obric.oui.constraintlayout.core.motion.a.j) ZeusTransformUtils.preCheckCast(r6.get("translationY"), com.obric.oui.constraintlayout.core.motion.a.j.class, "com.obric.memorydata.plugin");
        goto L10
    L5:
        r3 = (com.obric.oui.constraintlayout.core.motion.a.j) ZeusTransformUtils.preCheckCast(r2.get("translationX"), com.obric.oui.constraintlayout.core.motion.a.j.class, "com.obric.memorydata.plugin");
        goto L6
    }

    void a(float r4, float[] r5, int r6) {
        this.p[0].a(a(r4, null), this.s);
        this.l.a(this.r, this.s, r5, r6);
    }

    public void a(int r20, int r21, float r22, long r23) {
        new HashSet();
        HashSet<String> r2 = new HashSet();
        HashSet<String> r3 = new HashSet();
        HashSet<String> r4 = new HashSet();
        HashMap<String, Integer> r5 = new HashMap();
        if (this.F == d.f13685a) goto L5;
        this.l.l = this.F;
    L5:
        this.n.a(this.o, r3);
        ArrayList<d> r6 = this.A;
        if (r6 == null) goto L27;
        Iterator<d> r7 = r6.iterator();
        ArrayList r9 = null;
    L9:
        if (r7.hasNext() == false) goto L29;
        d r10 = (d) ZeusTransformUtils.preCheckCast(r7.next(), d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, h.class) == true) goto L12;
        if (ZeusTransformUtils.instanceOf(r10, f.class) == true) goto L17;
        if (ZeusTransformUtils.instanceOf(r10, j.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r10, k.class) == true) goto L23;
        r10.b(r5);
        r10.a(r3);
        goto L9
    L23:
        if (r9 != null) goto L25;
        r9 = new ArrayList();
    L25:
        r9.add((k) ZeusTransformUtils.preCheckCast(r10, k.class, "com.obric.memorydata.plugin"));
        goto L9
    L20:
        r10.a(r2);
        goto L9
    L17:
        r10.a(r4);
        goto L9
    L12:
        h r11 = (h) ZeusTransformUtils.preCheckCast(r10, h.class, "com.obric.memorydata.plugin");
        a(new p(r20, r21, r11, this.l, this.m));
        if (r11.q == d.f13685a) goto L9;
        this.k = r11.q;
    L29:
        if (r9 == null) goto L31;
        this.E = (k[]) ZeusTransformUtils.preCheckCast(r9.toArray(new k[0]), k[].class, "com.obric.memorydata.plugin");
    L31:
        char r12 = 1;
        if (r3.isEmpty() == true) goto L75;
        this.C = new HashMap();
        Iterator<String> r8 = r3.iterator();
    L35:
        if (r8.hasNext() == false) goto L54;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        if (r13.startsWith("CUSTOM,") == false) goto L49;
        SparseArray r14 = new SparseArray();
        String r15 = r13.split(",")[r12];
        Iterator<d> r16 = this.A.iterator();
    L40:
        if (r16.hasNext() == false) goto L48;
        d r17 = (d) ZeusTransformUtils.preCheckCast(r16.next(), d.class, "com.obric.memorydata.plugin");
        if (r17.f == null) goto L40;
        Iterator<String> r18 = r8;
        ConstraintAttribute r19 = (ConstraintAttribute) ZeusTransformUtils.preCheckCast(r17.f.get(r15), ConstraintAttribute.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L47;
        r14.append(r17.f13686b, r19);
    L47:
        r8 = r18;
        goto L40
    L48:
        Iterator<String> r110 = r8;
        com.obric.oui.constraintlayout.motion.a.d r24 = com.obric.oui.constraintlayout.motion.a.d.a(r13, r14);
    L50:
        if (r24 == null) goto L53;
        r24.a(r13);
        this.C.put(r13, r24);
    L53:
        r8 = r110;
        r12 = 1;
        goto L35
    L49:
        r110 = r8;
        r24 = com.obric.oui.constraintlayout.motion.a.d.b(r13);
        goto L50
    L54:
        ArrayList<d> r25 = this.A;
        if (r25 == null) goto L62;
        Iterator<d> r26 = r25.iterator();
    L58:
        if (r26.hasNext() == false) goto L62;
        d r27 = (d) ZeusTransformUtils.preCheckCast(r26.next(), d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r27, e.class) == false) goto L58;
        r27.a(this.C);
    L62:
        this.n.a(this.C, 0);
        this.o.a(this.C, 100);
        Iterator<String> r28 = this.C.keySet().iterator();
    L64:
        if (r28.hasNext() == false) goto L75;
        String r29 = (String) ZeusTransformUtils.preCheckCast(r28.next(), String.class, "com.obric.memorydata.plugin");
        if (r5.containsKey(r29) == false) goto L70;
        Integer r111 = (Integer) ZeusTransformUtils.preCheckCast(r5.get(r29), Integer.class, "com.obric.memorydata.plugin");
        if (r111 == null) goto L70;
        int r112 = r111.intValue();
    L71:
        com.obric.oui.constraintlayout.core.motion.a.j r30 = (com.obric.oui.constraintlayout.core.motion.a.j) ZeusTransformUtils.preCheckCast(this.C.get(r29), com.obric.oui.constraintlayout.core.motion.a.j.class, "com.obric.memorydata.plugin");
        if (r30 == null) goto L64;
        r30.a(r112);
    L70:
        r112 = 0;
    L75:
        if (r2.isEmpty() == false) goto L77;
    L117:
        int r31 = 2;
        int r32 = this.y.size() + 2;
        p[] r33 = new p[r32];
        r33[0] = this.l;
        r33[r32 - 1] = this.m;
        if (this.y.size() > 0) goto L120;
    L122:
        Iterator<p> r34 = this.y.iterator();
        int r35 = 1;
    L124:
        if (r34.hasNext() == false) goto L126;
        r33[r35] = (p) ZeusTransformUtils.preCheckCast(r34.next(), p.class, "com.obric.memorydata.plugin");
        r35 = r35 + 1;
        goto L124
    L126:
        HashSet r36 = new HashSet();
        Iterator<String> r113 = this.m.p.keySet().iterator();
    L128:
        if (r113.hasNext() == false) goto L134;
        String r114 = (String) ZeusTransformUtils.preCheckCast(r113.next(), String.class, "com.obric.memorydata.plugin");
        if (this.l.p.containsKey(r114) == false) goto L128;
        if (r3.contains("CUSTOM," + r114) == true) goto L128;
        r36.add(r114);
        goto L128
    L134:
        String[] r37 = (String[]) ZeusTransformUtils.preCheckCast(r36.toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
        this.u = r37;
        this.v = new int[r37.length];
        int r38 = 0;
    L135:
        String[] r39 = this.u;
        if (r38 >= r39.length) goto L147;
        String r40 = r39[r38];
        this.v[r38] = 0;
        int r115 = 0;
    L138:
        if (r115 >= r32) goto L145;
        if (r33[r115].p.containsKey(r40) == false) goto L144;
        ConstraintAttribute r116 = (ConstraintAttribute) ZeusTransformUtils.preCheckCast(r33[r115].p.get(r40), ConstraintAttribute.class, "com.obric.memorydata.plugin");
        if (r116 == null) goto L144;
        int[] r41 = this.v;
        r41[r38] = r41[r38] + r116.c();
    L144:
        r115 = r115 + 1;
    L145:
        r38 = r38 + 1;
        goto L135
    L147:
        if (r33[0].l == d.f13685a) goto L149;
        boolean r42 = true;
    L150:
        int r43 = 18 + this.u.length;
        boolean[] r44 = new boolean[r43];
        int r117 = 1;
    L151:
        if (r117 >= r32) goto L153;
        r33[r117].a(r33[r117 - 1], r44, this.u, r42);
        r117 = r117 + 1;
        goto L151
    L153:
        int r45 = 1;
        int r118 = 0;
    L154:
        if (r45 >= r43) goto L159;
        if (r44[r45] == false) goto L158;
        r118 = r118 + 1;
    L158:
        r45 = r45 + 1;
        goto L154
    L159:
        this.r = new int[r118];
        int r46 = Math.max(2, r118);
        this.s = new double[r46];
        this.t = new double[r46];
        int r47 = 1;
        int r119 = 0;
    L160:
        if (r47 >= r43) goto L165;
        if (r44[r47] == false) goto L164;
        this.r[r119] = r47;
        r119 = r119 + 1;
    L164:
        r47 = r47 + 1;
        goto L160
    L165:
        double[][] r48 = (double[][]) Array.newInstance(double.class, new int[]{r32, this.r.length});
        double[] r49 = new double[r32];
        int r50 = 0;
    L166:
        if (r50 >= r32) goto L168;
        r33[r50].a(r48[r50], this.r);
        r49[r50] = r33[r50].d;
        r50 = r50 + 1;
        goto L166
    L168:
        int r51 = 0;
    L169:
        int[] r120 = this.r;
        if (r51 >= r120.length) goto L177;
        if (r120[r51] >= p.f13700a.length) goto L176;
        String r121 = p.f13700a[this.r[r51]] + " [";
        int r122 = 0;
    L174:
        if (r122 >= r32) goto L176;
        r121 = r121 + r48[r122][r51];
        r122 = r122 + 1;
    L176:
        r51 = r51 + 1;
        goto L169
    L177:
        this.p = new com.obric.oui.constraintlayout.core.motion.a.b[this.u.length + 1];
        int r52 = 0;
    L178:
        String[] r123 = this.u;
        if (r52 >= r123.length) goto L191;
        String r124 = r123[r52];
        int r125 = 0;
        int r126 = 0;
        double[] r127 = null;
        double[][] r128 = null;
    L181:
        if (r125 >= r32) goto L190;
        if (r33[r125].a(r124) == false) goto L189;
        if (r128 != null) goto L186;
        r127 = new double[r32];
        int[] r129 = new int[r31];
        r129[1] = r33[r125].b(r124);
        r129[0] = r32;
        double[][] r130 = (double[][]) Array.newInstance(double.class, r129);
        int r131 = 0;
        r128 = r130;
    L187:
        r127[r126] = r33[r125].d;
        r33[r125].a(r124, r128[r126], r131);
        r126 = r126 + 1;
        goto L189
    L186:
        r131 = 0;
    L189:
        r125 = r125 + 1;
        r4 = r4;
        r31 = 2;
        goto L181
    L190:
        r52 = r52 + 1;
        this.p[r52] = com.obric.oui.constraintlayout.core.motion.a.b.a(this.k, Arrays.copyOf(r127, r126), (double[][]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r128, r126), double[][].class, "com.obric.memorydata.plugin"));
        r4 = r4;
        r31 = 2;
        goto L178
    L191:
        HashSet<String> r132 = r4;
        this.p[0] = com.obric.oui.constraintlayout.core.motion.a.b.a(this.k, r49, r48);
        if (r33[0].l == d.f13685a) goto L197;
        int[] r53 = new int[r32];
        double[] r54 = new double[r32];
        double[][] r1 = (double[][]) Array.newInstance(double.class, new int[]{r32, 2});
        int r133 = 0;
    L194:
        if (r133 >= r32) goto L196;
        r53[r133] = r33[r133].l;
        r54[r133] = r33[r133].d;
        r1[r133][0] = r33[r133].f;
        r1[r133][1] = r33[r133].g;
        r133 = r133 + 1;
        goto L194
    L196:
        this.q = com.obric.oui.constraintlayout.core.motion.a.b.a(r53, r54, r1);
    L197:
        float r55 = Float.NaN;
        this.D = new HashMap();
        if (this.A == null) goto L221;
        Iterator<String> r56 = r132.iterator();
    L201:
        if (r56.hasNext() == false) goto L211;
        String r57 = (String) ZeusTransformUtils.preCheckCast(r56.next(), String.class, "com.obric.memorydata.plugin");
        com.obric.oui.constraintlayout.motion.a.c r58 = com.obric.oui.constraintlayout.motion.a.c.b(r57);
        if (r58 == null) goto L201;
        if (r58.a() == true) goto L208;
    L210:
        r58.a(r57);
        this.D.put(r57, r58);
        goto L201
    L208:
        if (Float.isNaN(r55) == false) goto L210;
        r55 = k();
        goto L210
    L211:
        Iterator<d> r59 = this.A.iterator();
    L213:
        if (r59.hasNext() == false) goto L217;
        d r60 = (d) ZeusTransformUtils.preCheckCast(r59.next(), d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r60, f.class) == false) goto L213;
        ((f) ZeusTransformUtils.preCheckCast(r60, f.class, "com.obric.memorydata.plugin")).c(this.D);
        goto L213
    L217:
        Iterator<com.obric.oui.constraintlayout.motion.a.c> r0 = this.D.values().iterator();
    L219:
        if (r0.hasNext() == false) goto L318;
        ((com.obric.oui.constraintlayout.motion.a.c) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.oui.constraintlayout.motion.a.c.class, "com.obric.memorydata.plugin")).c(r55);
        goto L219
    L318:
        return;
    L221:
        return;
    L149:
        r42 = false;
        goto L150
    L120:
        if (this.k != (-1)) goto L122;
        this.k = 0;
        goto L122
    L77:
        if (this.B != null) goto L79;
        this.B = new HashMap();
    L79:
        Iterator<String> r61 = r2.iterator();
    L81:
        if (r61.hasNext() == false) goto L101;
        String r62 = (String) ZeusTransformUtils.preCheckCast(r61.next(), String.class, "com.obric.memorydata.plugin");
        if (this.B.containsKey(r62) == true) goto L81;
        if (r62.startsWith("CUSTOM,") == false) goto L97;
        SparseArray r63 = new SparseArray();
        String r134 = r62.split(",")[1];
        Iterator<d> r135 = this.A.iterator();
    L89:
        if (r135.hasNext() == false) goto L96;
        d r136 = (d) ZeusTransformUtils.preCheckCast(r135.next(), d.class, "com.obric.memorydata.plugin");
        if (r136.f == null) goto L89;
        ConstraintAttribute r137 = (ConstraintAttribute) ZeusTransformUtils.preCheckCast(r136.f.get(r134), ConstraintAttribute.class, "com.obric.memorydata.plugin");
        if (r137 == null) goto L89;
        r63.append(r136.f13686b, r137);
        goto L89
    L96:
        com.obric.oui.constraintlayout.motion.a.f r64 = com.obric.oui.constraintlayout.motion.a.f.a(r62, r63);
    L98:
        if (r64 == null) goto L81;
        r64.a(r62);
        this.B.put(r62, r64);
        goto L81
    L97:
        r64 = com.obric.oui.constraintlayout.motion.a.f.a(r62, r23);
        goto L98
    L101:
        ArrayList<d> r65 = this.A;
        if (r65 == null) goto L109;
        Iterator<d> r66 = r65.iterator();
    L105:
        if (r66.hasNext() == false) goto L109;
        d r67 = (d) ZeusTransformUtils.preCheckCast(r66.next(), d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r67, j.class) == false) goto L105;
        ((j) ZeusTransformUtils.preCheckCast(r67, j.class, "com.obric.memorydata.plugin")).c(this.B);
    L109:
        Iterator<String> r68 = this.B.keySet().iterator();
    L111:
        if (r68.hasNext() == false) goto L117;
        String r69 = (String) ZeusTransformUtils.preCheckCast(r68.next(), String.class, "com.obric.memorydata.plugin");
        if (r5.containsKey(r69) == false) goto L115;
        int r70 = ((Integer) ZeusTransformUtils.preCheckCast(r5.get(r69), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L116:
        ((com.obric.oui.constraintlayout.motion.a.f) ZeusTransformUtils.preCheckCast(this.B.get(r69), com.obric.oui.constraintlayout.motion.a.f.class, "com.obric.memorydata.plugin")).a(r70);
        goto L111
    L115:
        r70 = 0;
        goto L116
    L27:
        r9 = null;
        goto L29
    }

    void a(Rect r2, Rect r3, int r4, int r5, int r6) {
        if (r4 == 1) goto L14;
        if (r4 != 2) goto L6;
        int r1 = r2.left + r2.right;
        int r7 = r2.top;
        int r8 = r2.bottom;
    L13:
        r3.left = r5 - (((r7 + r8) + r2.width()) / 2);
        r3.top = (r1 - r2.height()) / 2;
    L16:
        r3.right = r3.left + r2.width();
        r3.bottom = r3.top + r2.height();
        return;
    L6:
        if (r4 != 3) goto L8;
        int r9 = r2.left + r2.right;
        int r10 = r2.top;
        int r11 = r2.bottom;
        int r12 = ((r2.height() / 2) + r2.top) - (r9 / 2);
    L15:
        r3.left = r12;
        r3.top = r6 - ((r9 + r2.height()) / 2);
        goto L16
    L8:
        if (r4 != 4) goto L18;
        r1 = r2.left + r2.right;
        r7 = r2.bottom;
        r8 = r2.top;
        goto L13
    L18:
        return;
    L14:
        r9 = r2.left + r2.right;
        r12 = ((r2.top + r2.bottom) - r2.width()) / 2;
        goto L15
    }

    void a(Rect r8, com.obric.oui.constraintlayout.widget.b r9, int r10, int r11) {
        int r6 = r9.c;
        if (r6 == 0) goto L5;
        a(r8, this.f13697a, r6, r10, r11);
    L5:
        this.l.d = 0.0f;
        this.l.e = 0.0f;
        b(this.l);
        this.l.a(r8.left, r8.top, r8.width(), r8.height());
        com.obric.oui.constraintlayout.widget.b.a r12 = r9.a(this.c);
        this.l.a(r12);
        this.f = r12.d.g;
        this.n.a(r8, r9, r6, this.c);
        this.G = r12.f.i;
        this.I = r12.d.k;
        this.f13696J = r12.d.j;
        this.K = a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13698b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r12.d.m, r12.d.l, r12.d.n);
    }

    public void a(View r3) {
        this.f13698b = r3;
        this.c = r3.getId();
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r4, ConstraintLayout.LayoutParams.class) == false) goto L6;
        this.e = ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin")).c();
        return;
    }

    public void a(com.obric.oui.constraintlayout.motion.a.e r5, View r6, int r7, int r8, int r9) {
        this.l.d = 0.0f;
        this.l.e = 0.0f;
        Rect r0 = new Rect();
        if (r7 == 1) goto L7;
        if (r7 != 2) goto L9;
        int r10 = r5.f13664b + r5.d;
        r0.left = r9 - (((r5.c + r5.e) + r5.a()) / 2);
        int r11 = (r10 - r5.b()) / 2;
    L8:
        r0.top = r11;
        r0.right = r0.left + r5.a();
        r0.bottom = r0.top + r5.b();
    L9:
        this.l.a(r0.left, r0.top, r0.width(), r0.height());
        this.n.a(r0, r6, r7, r5.f13663a);
        return;
    L7:
        int r12 = r5.f13664b + r5.d;
        r0.left = ((r5.c + r5.e) - r5.a()) / 2;
        r11 = r8 - ((r12 + r5.b()) / 2);
        goto L8
    }

    public void a(d r1) {
        this.A.add(r1);
    }

    public void a(m r3) {
        this.l.a(r3, r3.l);
        this.m.a(r3, r3.m);
    }

    void a(ArrayList<d> r1) {
        this.A.addAll(r1);
    }

    void a(boolean r5) {
        if ("button".equals(a.a(this.f13698b)) == true) goto L5;
        return;
    L5:
        if (this.E == null) goto L18;
        int r0 = 0;
    L7:
        k[] r1 = this.E;
        if (r0 >= r1.length) goto L19;
        k r2 = r1[r0];
        if (r5 == false) goto L12;
        float r3 = -100.0f;
    L13:
        r2.a(r3, this.f13698b);
        r0 = r0 + 1;
        goto L7
    L12:
        r3 = 100.0f;
        goto L13
    L19:
        return;
    }

    void a(float[] r22, int r23) {
        m r0 = this;
        float r9 = 1.0f;
        float r10 = 1.0f / (r23 - 1);
        HashMap<String, com.obric.oui.constraintlayout.motion.a.d> r1 = r0.C;
        com.obric.oui.constraintlayout.motion.a.c r3 = null;
        if (r1 != null) goto L5;
        com.obric.oui.constraintlayout.core.motion.a.j r12 = null;
    L6:
        HashMap<String, com.obric.oui.constraintlayout.motion.a.d> r2 = r0.C;
        if (r2 != null) goto L9;
        com.obric.oui.constraintlayout.core.motion.a.j r13 = null;
    L10:
        HashMap<String, com.obric.oui.constraintlayout.motion.a.c> r4 = r0.D;
        if (r4 != null) goto L13;
        com.obric.oui.constraintlayout.motion.a.c r14 = null;
    L14:
        HashMap<String, com.obric.oui.constraintlayout.motion.a.c> r5 = r0.D;
        if (r5 == null) goto L18;
        r3 = (com.obric.oui.constraintlayout.motion.a.c) ZeusTransformUtils.preCheckCast(r5.get("translationY"), com.obric.oui.constraintlayout.motion.a.c.class, "com.obric.memorydata.plugin");
    L18:
        com.obric.oui.constraintlayout.motion.a.c r15 = r3;
        int r7 = 0;
    L19:
        if (r7 >= r23) goto L64;
        float r6 = r7 * r10;
        float r8 = r0.h;
        if (r8 == r9) goto L30;
        float r11 = r0.g;
        if (r6 >= r11) goto L26;
        r6 = 0.0f;
    L26:
        if (r6 <= r11) goto L30;
        if (r6 >= 1.0d) goto L30;
        r6 = Math.min((r6 - r11) * r8, r9);
    L30:
        float r16 = r6;
        double r17 = r16;
        com.obric.oui.constraintlayout.core.motion.a.c r18 = r0.l.f13701b;
        float r19 = Float.NaN;
        Iterator<p> r20 = r0.y.iterator();
        float r110 = 0.0f;
    L32:
        if (r20.hasNext() == false) goto L42;
        double r111 = r17;
        p r21 = (p) ZeusTransformUtils.preCheckCast(r20.next(), p.class, "com.obric.memorydata.plugin");
        if (r21.f13701b == null) goto L41;
        if (r21.d >= r16) goto L39;
        com.obric.oui.constraintlayout.core.motion.a.c r24 = r21.f13701b;
        r110 = r21.d;
        r18 = r24;
        goto L41
    L39:
        if (Float.isNaN(r19) == false) goto L41;
        r19 = r21.d;
    L41:
        r17 = r111;
        goto L32
    L42:
        double r112 = r17;
        if (r18 != null) goto L45;
        double r25 = r112;
    L49:
        r0.p[0].a(r25, r0.s);
        com.obric.oui.constraintlayout.core.motion.a.b r26 = r0.q;
        if (r26 == null) goto L54;
        double[] r27 = r0.s;
        if (r27.length <= 0) goto L54;
        r26.a(r25, r27);
    L54:
        int r28 = r7 * 2;
        int r113 = r7;
        r0.l.a(r25, r0.r, r0.s, r22, r28);
        if (r14 == null) goto L57;
        r22[r28] = r22[r28] + r14.a(r16);
    L59:
        if (r15 == null) goto L61;
        int r29 = r28 + 1;
        r22[r29] = r22[r29] + r15.a(r16);
    L63:
        r7 = r113 + 1;
        r9 = 1.0f;
        r0 = this;
        goto L19
    L61:
        if (r13 == null) goto L63;
        int r30 = r28 + 1;
        r22[r30] = r22[r30] + r13.a(r16);
        goto L63
    L57:
        if (r12 == null) goto L59;
        r22[r28] = r22[r28] + r12.a(r16);
        goto L59
    L45:
        if (Float.isNaN(r19) == false) goto L47;
        r19 = 1.0f;
    L47:
        float r31 = r19 - r110;
        r25 = (((float) r18.a((r16 - r110) / r31)) * r31) + r110;
        goto L49
    L64:
        return;
    L13:
        r14 = (com.obric.oui.constraintlayout.motion.a.c) ZeusTransformUtils.preCheckCast(r4.get("translationX"), com.obric.oui.constraintlayout.motion.a.c.class, "com.obric.memorydata.plugin");
        goto L14
    L9:
        r13 = (com.obric.oui.constraintlayout.core.motion.a.j) ZeusTransformUtils.preCheckCast(r2.get("translationY"), com.obric.oui.constraintlayout.core.motion.a.j.class, "com.obric.memorydata.plugin");
        goto L10
    L5:
        r12 = (com.obric.oui.constraintlayout.core.motion.a.j) ZeusTransformUtils.preCheckCast(r1.get("translationX"), com.obric.oui.constraintlayout.core.motion.a.j.class, "com.obric.memorydata.plugin");
        goto L6
    }

    boolean a(View r21, float r22, long r23, com.obric.oui.constraintlayout.core.motion.a.d r25) {
        float r2 = a(r22, null);
        if (this.I == d.f13685a) goto L15;
        float r3 = 1.0f / this.I;
        float r4 = ((float) Math.floor(r2 / r3)) * r3;
        float r5 = (r2 % r3) / r3;
        if (Float.isNaN(this.f13696J) == true) goto L7;
        r5 = (r5 + this.f13696J) % 1.0f;
    L7:
        Interpolator r6 = this.K;
        if (r6 == null) goto L11;
        float r7 = r6.getInterpolation(r5);
    L14:
        r2 = (r7 * r3) + r4;
        goto L15
    L11:
        if (r5 <= 0.5d) goto L13;
        r7 = 1.0f;
        goto L14
    L13:
        r7 = 0.0f;
    L15:
        float r14 = r2;
        HashMap<String, com.obric.oui.constraintlayout.motion.a.d> r8 = this.C;
        if (r8 == null) goto L21;
        Iterator<com.obric.oui.constraintlayout.motion.a.d> r9 = r8.values().iterator();
    L19:
        if (r9.hasNext() == false) goto L21;
        ((com.obric.oui.constraintlayout.motion.a.d) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.oui.constraintlayout.motion.a.d.class, "com.obric.memorydata.plugin")).a(r21, r14);
    L21:
        HashMap<String, com.obric.oui.constraintlayout.motion.a.f> r10 = this.B;
        if (r10 == null) goto L31;
        Iterator<com.obric.oui.constraintlayout.motion.a.f> r11 = r10.values().iterator();
        com.obric.oui.constraintlayout.motion.a.f.d r12 = null;
        boolean r13 = false;
    L25:
        if (r11.hasNext() == false) goto L30;
        com.obric.oui.constraintlayout.motion.a.f r1 = (com.obric.oui.constraintlayout.motion.a.f) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.oui.constraintlayout.motion.a.f.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, com.obric.oui.constraintlayout.motion.a.f.d.class) == true) goto L28;
        r13 = r13 | r1.a(r21, r14, r23, r25);
        goto L25
    L28:
        r12 = (com.obric.oui.constraintlayout.motion.a.f.d) ZeusTransformUtils.preCheckCast(r1, com.obric.oui.constraintlayout.motion.a.f.d.class, "com.obric.memorydata.plugin");
        goto L25
    L30:
        boolean r16 = r13;
        com.obric.oui.constraintlayout.motion.a.f.d r15 = r12;
    L32:
        com.obric.oui.constraintlayout.core.motion.a.b[] r17 = this.p;
        if (r17 == null) goto L93;
        double r18 = r14;
        r17[0].a(r18, this.s);
        this.p[0].b(r18, this.t);
        com.obric.oui.constraintlayout.core.motion.a.b r19 = this.q;
        if (r19 == null) goto L40;
        double[] r20 = this.s;
        if (r20.length <= 0) goto L40;
        r19.a(r18, r20);
        this.q.b(r18, this.t);
    L40:
        if (this.L == true) goto L44;
        this.l.a(r14, r21, this.r, this.s, this.t, null, this.d);
        this.d = false;
    L44:
        if (this.G != d.f13685a) goto L46;
    L55:
        HashMap<String, com.obric.oui.constraintlayout.motion.a.d> r24 = this.C;
        if (r24 == null) goto L67;
        Iterator<com.obric.oui.constraintlayout.motion.a.d> r26 = r24.values().iterator();
    L59:
        if (r26.hasNext() == false) goto L67;
        com.obric.oui.constraintlayout.core.motion.a.j r27 = (com.obric.oui.constraintlayout.core.motion.a.j) ZeusTransformUtils.preCheckCast(r26.next(), com.obric.oui.constraintlayout.core.motion.a.j.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r27, com.obric.oui.constraintlayout.motion.a.d.C0739d.class) == false) goto L59;
        if (this.t.length <= 1) goto L59;
        com.obric.oui.constraintlayout.motion.a.d.C0739d r28 = (com.obric.oui.constraintlayout.motion.a.d.C0739d) ZeusTransformUtils.preCheckCast(r27, com.obric.oui.constraintlayout.motion.a.d.C0739d.class, "com.obric.memorydata.plugin");
        double[] r29 = this.t;
        r28.a(r21, r14, r29[0], r29[1]);
    L67:
        char r110 = 1;
        if (r15 == null) goto L70;
        double[] r30 = this.t;
        r16 = r16 | r15.a(r21, r25, r14, r23, r30[0], r30[1]);
    L70:
        int r31 = 1;
    L71:
        com.obric.oui.constraintlayout.core.motion.a.b[] r32 = this.p;
        if (r31 >= r32.length) goto L75;
        r32[r31].a(r18, this.x);
        com.obric.oui.constraintlayout.motion.a.a.a((ConstraintAttribute) ZeusTransformUtils.preCheckCast(this.l.p.get(this.u[r31 - 1]), ConstraintAttribute.class, "com.obric.memorydata.plugin"), r21, this.x);
        r31 = r31 + 1;
        goto L71
    L75:
        if (this.n.c == 0) goto L77;
    L86:
        int r33 = 0;
    L88:
        if (this.E == null) goto L101;
        int r34 = r33;
    L90:
        k[] r35 = this.E;
        if (r34 >= r35.length) goto L101;
        r35[r34].a(r14, r21);
        r34 = r34 + 1;
    L101:
        HashMap<String, com.obric.oui.constraintlayout.motion.a.c> r36 = this.D;
        if (r36 == null) goto L110;
        Iterator<com.obric.oui.constraintlayout.motion.a.c> r37 = r36.values().iterator();
    L105:
        if (r37.hasNext() == false) goto L110;
        com.obric.oui.constraintlayout.motion.a.c r38 = (com.obric.oui.constraintlayout.motion.a.c) ZeusTransformUtils.preCheckCast(r37.next(), com.obric.oui.constraintlayout.motion.a.c.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r38, com.obric.oui.constraintlayout.motion.a.c.d.class) == true) goto L108;
        r38.a(r21, r14);
        goto L105
    L108:
        com.obric.oui.constraintlayout.motion.a.c.d r39 = (com.obric.oui.constraintlayout.motion.a.c.d) ZeusTransformUtils.preCheckCast(r38, com.obric.oui.constraintlayout.motion.a.c.d.class, "com.obric.memorydata.plugin");
        double[] r40 = this.t;
        r39.a(r21, r14, r40[r33], r40[r110]);
    L110:
        return r16;
    L77:
        if (r14 > 0.0f) goto L81;
        l r41 = this.n;
    L79:
        r21.setVisibility(r41.d);
        goto L86
    L81:
        if (r14 < 1.0f) goto L84;
        r41 = this.o;
        goto L79
    L84:
        if (this.o.d == this.n.d) goto L86;
        r33 = 0;
        r21.setVisibility(0);
        goto L88
    L46:
        if (this.H != null) goto L48;
        this.H = ((View) ZeusTransformUtils.preCheckCast(r21.getParent(), View.class, "com.obric.memorydata.plugin")).findViewById(this.G);
    L48:
        View r42 = this.H;
        if (r42 == null) goto L55;
        float r43 = (r42.getTop() + this.H.getBottom()) / 2.0f;
        float r44 = (this.H.getLeft() + this.H.getRight()) / 2.0f;
        if ((r21.getRight() - r21.getLeft()) <= 0) goto L55;
        if ((r21.getBottom() - r21.getTop()) <= 0) goto L55;
        float r45 = r44 - r21.getLeft();
        float r46 = r43 - r21.getTop();
        r21.setPivotX(r45);
        r21.setPivotY(r46);
        goto L55
    L93:
        r110 = 1;
        r33 = 0;
        float r47 = this.l.f + ((this.m.f - this.l.f) * r14);
        float r48 = this.l.g + ((this.m.g - this.l.g) * r14);
        float r49 = this.l.h + ((this.m.h - this.l.h) * r14);
        float r50 = r47 + 0.5f;
        int r51 = (int) r50;
        float r52 = r48 + 0.5f;
        int r53 = (int) r52;
        int r54 = (int) (r50 + r49);
        int r55 = (int) (r52 + (this.l.i + ((this.m.i - this.l.i) * r14)));
        int r56 = r54 - r51;
        int r57 = r55 - r53;
        if (this.m.h == this.l.h) goto L96;
    L99:
        r21.measure(View.MeasureSpec.makeMeasureSpec(r56, 1073741824), View.MeasureSpec.makeMeasureSpec(r57, 1073741824));
        this.d = false;
    L100:
        r21.layout(r51, r53, r54, r55);
        goto L101
    L96:
        if (this.m.i != this.l.i) goto L99;
        if (this.d == false) goto L100;
    L31:
        r15 = null;
        r16 = false;
        goto L32
    }

    public float b() {
        return this.l.g;
    }

    public void b(int r1) {
        this.F = r1;
    }

    void b(Rect r8, com.obric.oui.constraintlayout.widget.b r9, int r10, int r11) {
        int r6 = r9.c;
        if (r6 == 0) goto L5;
        a(r8, this.f13697a, r6, r10, r11);
        r8 = this.f13697a;
    L5:
        this.m.d = 1.0f;
        this.m.e = 1.0f;
        b(this.m);
        this.m.a(r8.left, r8.top, r8.width(), r8.height());
        this.m.a(r9.a(this.c));
        this.o.a(r8, r9, r6, this.c);
    }

    void b(View r6) {
        this.l.d = 0.0f;
        this.l.e = 0.0f;
        this.l.a(r6.getX(), r6.getY(), r6.getWidth(), r6.getHeight());
        this.n.b(r6);
    }

    public float c() {
        return this.m.f;
    }

    void c(View r6) {
        this.l.d = 0.0f;
        this.l.e = 0.0f;
        this.L = true;
        this.l.a(r6.getX(), r6.getY(), r6.getWidth(), r6.getHeight());
        this.m.a(r6.getX(), r6.getY(), r6.getWidth(), r6.getHeight());
        this.n.b(r6);
        this.o.b(r6);
    }

    public float d() {
        return this.m.g;
    }

    public int e() {
        return this.l.m;
    }

    public float f() {
        return this.i;
    }

    public float g() {
        return this.j;
    }

    public void h() {
        this.d = true;
    }

    public View i() {
        return this.f13698b;
    }

    public int j() {
        int r0 = this.l.c;
        Iterator<p> r1 = this.y.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        r0 = Math.max(r0, ((p) ZeusTransformUtils.preCheckCast(r1.next(), p.class, "com.obric.memorydata.plugin")).c);
        goto L4
    L7:
        return Math.max(r0, this.m.c);
    }

    public String toString() {
        return " start: x: " + this.l.f + " y: " + this.l.g + " end: x: " + this.m.f + " y: " + this.m.g;
    }
}
