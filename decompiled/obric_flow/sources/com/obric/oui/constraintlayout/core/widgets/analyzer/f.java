package com.obric.oui.constraintlayout.core.widgets.analyzer;

import ai.j0;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f12569c;
    public Object d;
    public Object e;
    public Serializable f;
    public Object g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f12570h;

    public f(String r5, com.bytedance.android.monitorV2.webview.a r10) {
        Intrinsics.checkNotNullParameter(r5, "bid");
        Intrinsics.checkNotNullParameter(r10, "monitor");
        this.f12569c = r5;
        this.f12567a = true;
        this.f12568b = true;
        this.d = "";
        this.f = "perf_destroy";
        this.g = "";
    }

    public void a(g r10, int r11, ArrayList r12, n r13) {
        s r14 = r10.d;
        if (r14.f12594c != null) goto L48;
        hr.g r5 = (hr.g) this.f12569c;
        if (r14 != r5.d) goto L7;
        return;
    L7:
        if (r14 == r5.e) goto L70;
        if (r13 != null) goto L11;
        r13 = new n();
        r13.f12583a = null;
        r13.f12584b = new ArrayList();
        r13.f12583a = r14;
        r12.add(r13);
    L11:
        r14.f12594c = r13;
        r13.f12584b.add(r14);
        g r15 = r14.f12595h;
        Iterator r16 = r15.f12577k.iterator();
    L13:
        if (r16.hasNext() == false) goto L17;
        e r17 = (e) r16.next();
        if ((r17 instanceof g) == false) goto L13;
        a((g) r17, r11, r12, r13);
        goto L13
    L17:
        g r18 = r14.f12596i;
        Iterator r19 = r18.f12577k.iterator();
    L19:
        if (r19.hasNext() == false) goto L24;
        e r20 = (e) r19.next();
        if ((r20 instanceof g) == false) goto L19;
        a((g) r20, r11, r12, r13);
        goto L19
    L24:
        if (r11 == 1) goto L26;
    L33:
        Iterator r21 = r15.f12578l.iterator();
    L35:
        if (r21.hasNext() == false) goto L37;
        a((g) r21.next(), r11, r12, r13);
        goto L35
    L37:
        Iterator r22 = r18.f12578l.iterator();
    L39:
        if (r22.hasNext() == false) goto L41;
        a((g) r22.next(), r11, r12, r13);
        goto L39
    L41:
        if (r11 == 1) goto L43;
        return;
    L43:
        if ((r14 instanceof p) == false) goto L69;
        Iterator r23 = ((p) r14).f12586k.f12578l.iterator();
    L46:
        if (r23.hasNext() == false) goto L71;
        a((g) r23.next(), r11, r12, r13);
        goto L46
    L71:
        return;
    L69:
        return;
    L26:
        if ((r14 instanceof p) == false) goto L33;
        Iterator r24 = ((p) r14).f12586k.f12577k.iterator();
    L29:
        if (r24.hasNext() == false) goto L33;
        e r25 = (e) r24.next();
        if ((r25 instanceof g) == false) goto L29;
        a((g) r25, r11, r12, r13);
        goto L29
    L70:
        return;
    }

    public void b(hr.g r18) {
        Iterator r5 = r18.f17432u0.iterator();
    L4:
        if (r5.hasNext() == false) goto L148;
        hr.f r10 = (hr.f) r5.next();
        ConstraintWidget$DimensionBehaviour[] r11 = r10.U;
        ConstraintWidget$DimensionBehaviour r12 = r11[0];
        ConstraintWidget$DimensionBehaviour r13 = r11[1];
        if (r10.i0 == 8) goto L7;
        float r14 = r10.f17428w;
        if (r14 < 1.0f) goto L11;
    L13:
        float r15 = r10.f17431z;
        if (r15 >= 1.0f) goto L19;
        if (r13 != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L19;
        r10.s = 2;
    L19:
        if (r10.Y <= 0.0f) goto L41;
        ConstraintWidget$DimensionBehaviour r16 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        if (r12 == r16) goto L23;
    L27:
        if (r13 == r16) goto L29;
    L33:
        if (r12 != r16) goto L41;
        if (r13 != r16) goto L41;
        if (r10.f17421r != 0) goto L39;
        r10.f17421r = 3;
    L39:
        if (r10.s != 0) goto L41;
        r10.s = 3;
        goto L41
    L29:
        if (r12 != ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) goto L31;
    L32:
        r10.s = 3;
        goto L41
    L31:
        if (r12 != ConstraintWidget$DimensionBehaviour.FIXED) goto L33;
    L23:
        if (r13 != ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) goto L25;
    L26:
        r10.f17421r = 3;
        goto L41
    L25:
        if (r13 != ConstraintWidget$DimensionBehaviour.FIXED) goto L27;
    L41:
        ConstraintWidget$DimensionBehaviour r17 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        hr.d r19 = r10.L;
        hr.d r110 = r10.J;
        if (r12 == r17) goto L44;
    L50:
        hr.d r111 = r10.M;
        hr.d r112 = r10.K;
        if (r13 == r17) goto L53;
    L59:
        ConstraintWidget$DimensionBehaviour r20 = r13;
        m r21 = r10.d;
        r21.d = r12;
        int r22 = r10.f17421r;
        r21.f12592a = r22;
        p r23 = r10.e;
        r23.d = r20;
        int r24 = r10.s;
        r23.f12592a = r24;
        ConstraintWidget$DimensionBehaviour r25 = ConstraintWidget$DimensionBehaviour.MATCH_PARENT;
        if (r12 != r25) goto L62;
    L65:
        if (r20 == r25) goto L139;
        if (r20 == ConstraintWidget$DimensionBehaviour.FIXED) goto L139;
        if (r20 == ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) goto L139;
    L71:
        hr.d[] r113 = r10.R;
        if (r12 != r17) goto L78;
        ConstraintWidget$DimensionBehaviour r114 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        if (r20 == r114) goto L79;
        if (r20 != ConstraintWidget$DimensionBehaviour.FIXED) goto L78;
    L79:
        if (r22 == 3) goto L80;
        if (r22 != 1) goto L86;
        f(r10, r114, 0, r20, 0);
        r10.d.e.f12579m = r10.r();
        goto L4
    L86:
        ConstraintWidget$DimensionBehaviour r115 = r20;
        if (r22 == 2) goto L88;
        if (r113[0].f == null) goto L96;
        if (r113[1].f == null) goto L96;
    L97:
        if (r115 != r17) goto L125;
        ConstraintWidget$DimensionBehaviour r116 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        if (r12 == r116) goto L104;
        if (r12 != ConstraintWidget$DimensionBehaviour.FIXED) goto L125;
    L104:
        if (r24 == 3) goto L105;
        if (r24 != 1) goto L115;
        f(r10, r12, 0, r116, 0);
        r10.e.e.f12579m = r10.l();
        goto L4
    L115:
        if (r24 == 2) goto L116;
        if (r113[2].f == null) goto L124;
        if (r113[3].f != null) goto L125;
    L124:
        f(r10, r116, 0, r115, 0);
        r10.d.e.d(r10.r());
        r10.e.e.d(r10.l());
        r10.f17394a = true;
        goto L4
    L116:
        ConstraintWidget$DimensionBehaviour r26 = r18.U[1];
        ConstraintWidget$DimensionBehaviour r117 = ConstraintWidget$DimensionBehaviour.FIXED;
        if (r26 == r117) goto L119;
        if (r26 != r25) goto L125;
    L119:
        f(r10, r12, r10.r(), r117, (int) ((r15 * r18.l()) + 0.5f));
        r10.d.e.d(r10.r());
        r10.e.e.d(r10.l());
        r10.f17394a = true;
        goto L4
    L105:
        if (r12 != r116) goto L107;
        f(r10, r116, 0, r116, 0);
    L107:
        int r27 = r10.r();
        float r28 = r10.Y;
        if (r10.Z != (-1)) goto L110;
        r28 = 1.0f / r28;
    L110:
        ConstraintWidget$DimensionBehaviour r29 = ConstraintWidget$DimensionBehaviour.FIXED;
        f(r10, r29, r27, r29, (int) ((r27 * r28) + 0.5f));
        r10.d.e.d(r10.r());
        r10.e.e.d(r10.l());
        r10.f17394a = true;
    L125:
        if (r12 != r17) goto L4;
        if (r115 != r17) goto L4;
        if (r22 == 1) goto L138;
        if (r24 == 1) goto L138;
        if (r24 != 2) goto L4;
        if (r22 != 2) goto L4;
        ConstraintWidget$DimensionBehaviour[] r30 = r18.U;
        ConstraintWidget$DimensionBehaviour r31 = r30[0];
        ConstraintWidget$DimensionBehaviour r32 = ConstraintWidget$DimensionBehaviour.FIXED;
        if (r31 != r32) goto L4;
        if (r30[1] != r32) goto L4;
        f(r10, r32, (int) ((r14 * r18.r()) + 0.5f), r32, (int) ((r15 * r18.l()) + 0.5f));
        r10.d.e.d(r10.r());
        r10.e.e.d(r10.l());
        r10.f17394a = true;
    L138:
        ConstraintWidget$DimensionBehaviour r33 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        f(r10, r33, 0, r33, 0);
        r10.d.e.f12579m = r10.r();
        r10.e.e.f12579m = r10.l();
    L96:
        f(r10, r114, 0, r115, 0);
        r10.d.e.d(r10.r());
        r10.e.e.d(r10.l());
        r10.f17394a = true;
        goto L4
    L88:
        ConstraintWidget$DimensionBehaviour r34 = r18.U[0];
        ConstraintWidget$DimensionBehaviour r118 = ConstraintWidget$DimensionBehaviour.FIXED;
        if (r34 == r118) goto L91;
        if (r34 != r25) goto L97;
    L91:
        f(r10, r118, (int) ((r14 * r18.r()) + 0.5f), r115, r10.l());
        r10.d.e.d(r10.r());
        r10.e.e.d(r10.l());
        r10.f17394a = true;
        goto L4
    L80:
        if (r20 != r114) goto L82;
        f(r10, r114, 0, r114, 0);
    L82:
        int r35 = r10.l();
        int r36 = (int) ((r35 * r10.Y) + 0.5f);
        ConstraintWidget$DimensionBehaviour r37 = ConstraintWidget$DimensionBehaviour.FIXED;
        f(r10, r37, r36, r37, r35);
        r10.d.e.d(r10.r());
        r10.e.e.d(r10.l());
        r10.f17394a = true;
    L78:
        r115 = r20;
    L139:
        int r38 = r10.r();
        if (r12 != r25) goto L142;
        r38 = (r18.r() - r110.g) - r19.g;
        r12 = ConstraintWidget$DimensionBehaviour.FIXED;
    L142:
        int r39 = r10.l();
        if (r20 != r25) goto L146;
        int r40 = (r18.l() - r112.g) - r111.g;
        r20 = ConstraintWidget$DimensionBehaviour.FIXED;
        int r41 = r40;
    L147:
        f(r10, r12, r38, r20, r41);
        r10.d.e.d(r10.r());
        r10.e.e.d(r10.l());
        r10.f17394a = true;
        goto L4
    L146:
        r41 = r39;
        goto L147
    L62:
        if (r12 == ConstraintWidget$DimensionBehaviour.FIXED) goto L65;
        if (r12 != ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) goto L71;
    L53:
        if (r10.s != 1) goto L59;
        if (r112.f != null) goto L57;
    L58:
        r13 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        goto L59
    L57:
        if (r111.f != null) goto L59;
    L44:
        if (r10.f17421r != 1) goto L50;
        if (r110.f != null) goto L48;
    L49:
        r12 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        goto L50
    L48:
        if (r19.f != null) goto L50;
    L11:
        if (r12 != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L13;
        r10.f17421r = 2;
        goto L13
    L7:
        r10.f17394a = true;
        goto L4
    }

    public void c() {
        ArrayList r5 = (ArrayList) this.e;
        r5.clear();
        hr.g r10 = (hr.g) this.d;
        r10.d.f();
        r10.e.f();
        r5.add(r10.d);
        r5.add(r10.e);
        Iterator r11 = r10.f17432u0.iterator();
        HashSet r12 = null;
    L4:
        if (r11.hasNext() == false) goto L29;
        hr.f r13 = (hr.f) r11.next();
        if ((r13 instanceof hr.k) == true) goto L7;
        if (r13.y() == true) goto L11;
        r5.add(r13.d);
    L18:
        if (r13.z() == true) goto L20;
        r5.add(r13.e);
    L27:
        if ((r13 instanceof hr.l) == false) goto L4;
        r5.add(new k(r13));
        goto L4
    L20:
        if (r13.f17398c != null) goto L22;
        r13.f17398c = new d(r13, 1);
    L22:
        if (r12 != null) goto L24;
        r12 = new HashSet();
    L24:
        r12.add(r13.f17398c);
        goto L27
    L11:
        if (r13.f17396b != null) goto L13;
        r13.f17396b = new d(r13, 0);
    L13:
        if (r12 != null) goto L15;
        r12 = new HashSet();
    L15:
        r12.add(r13.f17396b);
        goto L18
    L7:
        j r14 = new j(r13);
        r13.d.f();
        r13.e.f();
        r14.f = ((hr.k) r13).f17460y0;
        r5.add(r14);
        goto L4
    L29:
        if (r12 == null) goto L31;
        r5.addAll(r12);
    L31:
        Iterator r15 = r5.iterator();
    L33:
        if (r15.hasNext() == false) goto L35;
        ((s) r15.next()).f();
        goto L33
    L35:
        Iterator r16 = r5.iterator();
    L37:
        if (r16.hasNext() == false) goto L42;
        s r17 = (s) r16.next();
        if (r17.f12593b == r10) goto L37;
        r17.d();
        goto L37
    L42:
        ArrayList r18 = (ArrayList) this.f;
        r18.clear();
        hr.g r19 = (hr.g) this.f12569c;
        e(r19.d, 0, r18);
        e(r19.e, 1, r18);
        this.f12567a = false;
    }

    public int d(hr.g r18, int r19) {
        ArrayList r5 = (ArrayList) this.f;
        int r10 = r5.size();
        long r11 = 0;
        int r12 = 0;
        long r13 = 0;
    L3:
        if (r12 >= r10) goto L53;
        s r14 = ((n) r5.get(r12)).f12583a;
        if ((r14 instanceof d) == true) goto L7;
        if (r19 != 0) goto L14;
        if ((r14 instanceof m) == false) goto L8;
    L16:
        if (r19 != 0) goto L19;
        s r15 = r18.d;
    L18:
        g r16 = r15.f12595h;
        if (r19 != 0) goto L23;
        s r17 = r18.d;
    L22:
        g r110 = r17.f12596i;
        boolean r111 = r14.f12595h.f12578l.contains(r16);
        g r112 = r14.f12596i;
        boolean r113 = r112.f12578l.contains(r110);
        long r114 = r14.j();
        g r115 = r14.f12595h;
        if (r111 == false) goto L45;
        if (r113 == false) goto L45;
        long r116 = n.b(r115, r11);
        ArrayList r117 = r5;
        long r20 = n.a(r112, r11);
        long r118 = r116 - r114;
        int r21 = r112.f;
        int r119 = r12;
        if (r118 < (-r21)) goto L30;
        r118 = r118 + ((long) r21);
    L30:
        long r22 = r115.f;
        long r23 = ((-r20) - r114) - r22;
        if (r23 < r22) goto L33;
        r23 = r23 - r22;
    L33:
        hr.f r24 = r14.f12593b;
        if (r19 != 0) goto L37;
        float r25 = r24.f17402f0;
    L41:
        if (r25 <= 0.0f) goto L43;
        long r26 = (long) ((r118 / (1.0f - r25)) + (r23 / r25));
    L44:
        float r27 = r26;
        long r28 = (((long) r115.f) + ((((long) ((r27 * r25) + 0.5f)) + r114) + ((long) j0.b(1.0f, r25, r27, 0.5f)))) - ((long) r112.f);
    L51:
        r13 = Math.max(r13, r28);
        r12 = r119 + 1;
        r5 = r117;
        r11 = 0;
        goto L3
    L43:
        r26 = 0;
        goto L44
    L37:
        if (r19 != 1) goto L39;
        r25 = r24.g0;
        goto L41
    L39:
        r24.getClass();
        r25 = -1.0f;
    L45:
        r117 = r5;
        r119 = r12;
        if (r111 == false) goto L48;
        r28 = Math.max(n.b(r115, r115.f), ((long) r115.f) + r114);
        goto L51
    L48:
        if (r113 == false) goto L50;
        r28 = Math.max(-n.a(r112, r112.f), ((long) (-r112.f)) + r114);
        goto L51
    L50:
        r28 = (r14.j() + r115.f) - ((long) r112.f);
        goto L51
    L23:
        r17 = r18.e;
        goto L22
    L19:
        r15 = r18.e;
    L8:
        r117 = r5;
        r28 = r11;
        r119 = r12;
        goto L51
    L14:
        if ((r14 instanceof p) == true) goto L16;
    L7:
        if (((d) r14).f == r19) goto L16;
    L53:
        return (int) r13;
    }

    public void e(s r5, int r10, ArrayList r11) {
        Iterator r12 = r5.f12595h.f12577k.iterator();
    L3:
        boolean r13 = r12.hasNext();
        g r14 = r5.f12596i;
        if (r13 == false) goto L11;
        e r15 = (e) r12.next();
        if ((r15 instanceof g) == true) goto L7;
        if ((r15 instanceof s) == false) goto L3;
        a(((s) r15).f12595h, r10, r11, null);
        goto L3
    L7:
        a((g) r15, r10, r11, null);
        goto L3
    L11:
        Iterator r16 = r14.f12577k.iterator();
    L13:
        if (r16.hasNext() == false) goto L21;
        e r17 = (e) r16.next();
        if ((r17 instanceof g) == true) goto L16;
        if ((r17 instanceof s) == false) goto L13;
        a(((s) r17).f12596i, r10, r11, null);
        goto L13
    L16:
        a((g) r17, r10, r11, null);
        goto L13
    L21:
        if (r10 != 1) goto L28;
        Iterator r18 = ((p) r5).f12586k.f12577k.iterator();
    L24:
        if (r18.hasNext() == false) goto L50;
        e r19 = (e) r18.next();
        if ((r19 instanceof g) == false) goto L24;
        a((g) r19, r10, r11, null);
        goto L24
    L50:
        return;
    }

    public void f(hr.f r5, ConstraintWidget$DimensionBehaviour r10, int r11, ConstraintWidget$DimensionBehaviour r12, int r13) {
        b r14 = (b) this.f12570h;
        r14.f12559a = r10;
        r14.f12560b = r12;
        r14.f12561c = r11;
        r14.d = r13;
        ((com.obric.oui.constraintlayout.widget.b) ((c) this.g)).b(r5, r14);
        r5.P(r14.e);
        r5.M(r14.f);
        r5.E = r14.f12562h;
        r5.J(r14.g);
    }

    public void g() {
        Iterator r5 = ((hr.g) this.f12569c).f17432u0.iterator();
    L4:
        if (r5.hasNext() == false) goto L42;
        hr.f r10 = (hr.f) r5.next();
        if (r10.f17394a == true) goto L4;
        ConstraintWidget$DimensionBehaviour[] r11 = r10.U;
        boolean r12 = false;
        ConstraintWidget$DimensionBehaviour r13 = r11[0];
        ConstraintWidget$DimensionBehaviour r14 = r11[1];
        int r15 = r10.f17421r;
        int r16 = r10.s;
        ConstraintWidget$DimensionBehaviour r17 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        if (r13 != r17) goto L11;
    L15:
        boolean r18 = true;
    L16:
        if (r14 != r17) goto L18;
    L20:
        r12 = true;
    L21:
        h r19 = r10.d.e;
        boolean r20 = r19.f12576j;
        h r21 = r10.e.e;
        boolean r110 = r21.f12576j;
        if (r20 == false) goto L25;
        if (r110 == false) goto L25;
        ConstraintWidget$DimensionBehaviour r22 = ConstraintWidget$DimensionBehaviour.FIXED;
        f(r10, r22, r19.g, r22, r21.g);
        r10.f17394a = true;
    L38:
        if (r10.f17394a == false) goto L4;
        a r23 = r10.e.f12587l;
        if (r23 == null) goto L4;
        r23.d(r10.f17399c0);
    L25:
        if (r20 == false) goto L31;
        if (r12 == false) goto L31;
        f(r10, ConstraintWidget$DimensionBehaviour.FIXED, r19.g, r17, r21.g);
        if (r14 != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L30;
        r10.e.e.f12579m = r10.l();
        goto L38
    L30:
        r10.e.e.d(r10.l());
        r10.f17394a = true;
    L31:
        if (r110 == false) goto L38;
        if (r18 == false) goto L38;
        f(r10, r17, r19.g, ConstraintWidget$DimensionBehaviour.FIXED, r21.g);
        if (r13 != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L36;
        r10.d.e.f12579m = r10.r();
        goto L38
    L36:
        r10.d.e.d(r10.r());
        r10.f17394a = true;
        goto L38
    L18:
        if (r14 != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L21;
        if (r16 != 1) goto L21;
    L11:
        if (r13 != ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) goto L14;
        if (r15 == 1) goto L15;
    L14:
        r18 = false;
        goto L16
    }

    public f(String r5) {
        Intrinsics.checkNotNullParameter(r5, "bid");
        this(r5, new com.bytedance.android.monitorV2.webview.a());
    }
}
