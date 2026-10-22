package t;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s.f f12151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s.f f12154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<p> f12155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b.InterfaceC0157b f12156f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b.a f12157g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<m> f12158h;

    public e(s.f r8) {
        this.f12152b = true;
        this.f12153c = true;
        this.f12155e = new ArrayList();
        new ArrayList();
        this.f12156f = null;
        this.f12157g = new b.a();
        this.f12158h = new ArrayList();
        this.f12151a = r8;
        this.f12154d = r8;
    }

    public final void a(f r10, int r11, int r12, ArrayList r13, m r14) {
        p r15 = r10.f12162d;
        if (r15.f12195c != null) goto L48;
        s.f r16 = this.f12151a;
        if (r15 != r16.f11854d) goto L7;
        return;
    L7:
        if (r15 == r16.f11855e) goto L70;
        if (r14 != null) goto L11;
        r14 = new m(r15);
        r13.add(r14);
    L11:
        r15.f12195c = r14;
        r14.f12184b.add(r15);
        f r17 = r15.f12200h;
        Iterator r8 = r17.f12169k.iterator();
    L13:
        if (r8.hasNext() == false) goto L17;
        d r18 = (d) r8.next();
        if ((r18 instanceof f) == false) goto L13;
        a((f) r18, r11, 0, r13, r14);
        goto L13
    L17:
        f r19 = r15.f12201i;
        Iterator r20 = r19.f12169k.iterator();
    L19:
        if (r20.hasNext() == false) goto L24;
        d r21 = (d) r20.next();
        if ((r21 instanceof f) == false) goto L19;
        a((f) r21, r11, 1, r13, r14);
        goto L19
    L24:
        if (r11 == 1) goto L26;
    L33:
        Iterator r110 = r17.f12170l.iterator();
    L35:
        if (r110.hasNext() == false) goto L37;
        a((f) r110.next(), r11, 0, r13, r14);
        goto L35
    L37:
        Iterator r111 = r19.f12170l.iterator();
    L39:
        if (r111.hasNext() == false) goto L41;
        a((f) r111.next(), r11, 1, r13, r14);
        goto L39
    L41:
        if (r11 == 1) goto L43;
        return;
    L43:
        if ((r15 instanceof n) == false) goto L69;
        Iterator r112 = ((n) r15).f12185k.f12170l.iterator();
    L46:
        if (r112.hasNext() == false) goto L71;
        a((f) r112.next(), r11, 2, r13, r14);
        goto L46
    L71:
        return;
    L69:
        return;
    L26:
        if ((r15 instanceof n) == false) goto L33;
        Iterator r22 = ((n) r15).f12185k.f12169k.iterator();
    L29:
        if (r22.hasNext() == false) goto L33;
        d r23 = (d) r22.next();
        if ((r23 instanceof f) == false) goto L29;
        a((f) r23, r11, 2, r13, r14);
        goto L29
    L70:
        return;
    }

    public final void b(s.f r18) {
        Iterator<s.e> r8 = r18.f11940s0.iterator();
    L4:
        if (r8.hasNext() == false) goto L152;
        s.e r10 = r8.next();
        s.e.a[] r11 = r10.V;
        s.e.a r12 = r11[0];
        s.e.a r13 = r11[1];
        if (r10.f11866j0 == 8) goto L7;
        float r14 = r10.f11888x;
        if (r14 < 1.0f) goto L11;
    L13:
        float r15 = r10.A;
        if (r15 >= 1.0f) goto L19;
        if (r13 != s.e.a.f11893m) goto L19;
        r10.f11884t = 2;
    L19:
        if (r10.Z <= 0.0f) goto L41;
        s.e.a r16 = s.e.a.f11893m;
        if (r12 == r16) goto L23;
    L27:
        if (r13 == r16) goto L29;
    L33:
        if (r12 != r16) goto L41;
        if (r13 != r16) goto L41;
        if (r10.f11883s != 0) goto L39;
        r10.f11883s = 3;
    L39:
        if (r10.f11884t != 0) goto L41;
    L40:
        r10.f11884t = 3;
        goto L41
    L29:
        if (r12 == s.e.a.f11892b) goto L40;
        if (r12 != s.e.a.f11891a) goto L33;
    L23:
        if (r13 != s.e.a.f11892b) goto L25;
    L26:
        r10.f11883s = 3;
        goto L41
    L25:
        if (r13 != s.e.a.f11891a) goto L27;
    L41:
        s.e.a r17 = s.e.a.f11893m;
        s.d r19 = r10.M;
        s.d r110 = r10.K;
        if (r12 == r17) goto L44;
    L50:
        s.d r111 = r10.N;
        s.d r112 = r10.L;
        if (r13 == r17) goto L53;
    L59:
        s.e.a r20 = r13;
        l r21 = r10.f11854d;
        r21.f12196d = r12;
        int r22 = r10.f11883s;
        r21.f12193a = r22;
        n r23 = r10.f11855e;
        r23.f12196d = r20;
        int r24 = r10.f11884t;
        r23.f12193a = r24;
        s.e.a r25 = s.e.a.f11894n;
        if (r12 != r25) goto L62;
    L65:
        if (r20 == r25) goto L143;
        if (r20 == s.e.a.f11891a) goto L143;
        if (r20 == s.e.a.f11892b) goto L143;
    L71:
        s.e.a[] r113 = r18.V;
        s.d[] r114 = r10.S;
        if (r12 != r17) goto L98;
        s.e.a r115 = s.e.a.f11892b;
        if (r20 == r115) goto L78;
        if (r20 != s.e.a.f11891a) goto L98;
    L78:
        if (r22 == 3) goto L79;
        if (r22 == 1) goto L84;
        s.e.a r116 = r20;
        if (r22 != 2) goto L94;
        s.e.a r117 = r113[0];
        s.e.a r26 = s.e.a.f11891a;
        if (r117 == r26) goto L90;
        if (r117 == r25) goto L90;
    L99:
        if (r116 != r17) goto L127;
        s.e.a r118 = s.e.a.f11892b;
        if (r12 == r118) goto L105;
        if (r12 != s.e.a.f11891a) goto L127;
    L105:
        if (r24 == 3) goto L106;
        if (r24 == 1) goto L114;
        if (r24 != 2) goto L122;
        s.e.a r119 = r113[1];
        s.e.a r27 = s.e.a.f11891a;
        if (r119 == r27) goto L120;
        if (r119 != r25) goto L127;
    L120:
        int r28 = r10.q();
        int r29 = (int) ((r15 * r18.l()) + 0.5f);
        s.e.a r30 = r27;
        int r31 = r29;
        int r32 = r28;
    L151:
        f(r10, r12, r32, r30, r31);
        r10.f11854d.f12197e.d(r10.q());
        r10.f11855e.f12197e.d(r10.l());
        r10.f11848a = true;
        goto L4
    L122:
        if (r114[2].f11835f == null) goto L125;
        if (r114[3].f11835f != null) goto L127;
    L125:
        r32 = 0;
        r31 = 0;
        r12 = r118;
        r30 = r116;
        goto L151
    L114:
        f(r10, r12, 0, r118, 0);
    L141:
        g r33 = r10.f11855e.f12197e;
        int r34 = r10.l();
    L142:
        r33.f12180m = r34;
        goto L4
    L106:
        if (r12 != r118) goto L108;
        f(r10, r118, 0, r118, 0);
    L108:
        int r35 = r10.q();
        float r36 = r10.Z;
        if (r10.f11849a0 != (-1)) goto L111;
        r36 = 1.0f / r36;
    L111:
        int r37 = (int) ((r35 * r36) + 0.5f);
        s.e.a r38 = s.e.a.f11891a;
        s.e.a r39 = r38;
    L92:
        f(r10, r39, r35, r38, r37);
        r10.f11854d.f12197e.d(r10.q());
        r10.f11855e.f12197e.d(r10.l());
        r10.f11848a = true;
    L127:
        if (r12 != r17) goto L4;
        if (r116 != r17) goto L4;
        if (r22 == 1) goto L140;
        if (r24 == 1) goto L140;
        if (r24 != 2) goto L4;
        if (r22 != 2) goto L4;
        s.e.a r40 = r113[0];
        r12 = s.e.a.f11891a;
        if (r40 != r12) goto L4;
        if (r113[1] != r12) goto L4;
        int r41 = (int) ((r14 * r18.q()) + 0.5f);
        r31 = (int) ((r15 * r18.l()) + 0.5f);
        r32 = r41;
        r30 = r12;
    L140:
        s.e.a r42 = s.e.a.f11892b;
        f(r10, r42, 0, r42, 0);
        r10.f11854d.f12197e.f12180m = r10.q();
    L90:
        r35 = (int) ((r14 * r18.q()) + 0.5f);
        r37 = r10.l();
        r38 = r116;
        r39 = r26;
        goto L92
    L94:
        if (r114[0].f11835f == null) goto L97;
        if (r114[1].f11835f != null) goto L99;
    L97:
        r12 = r115;
        r30 = r116;
        r32 = 0;
        r31 = 0;
        goto L151
    L84:
        f(r10, r115, 0, r20, 0);
        r33 = r10.f11854d.f12197e;
        r34 = r10.q();
        goto L142
    L79:
        if (r20 != r115) goto L81;
        f(r10, r115, 0, r115, 0);
    L81:
        int r43 = r10.l();
        int r44 = (int) ((r43 * r10.Z) + 0.5f);
        r39 = s.e.a.f11891a;
        r37 = r43;
        r35 = r44;
        r38 = r39;
    L98:
        r116 = r20;
    L143:
        r32 = r10.q();
        if (r12 != r25) goto L146;
        r32 = (r18.q() - r110.f11836g) - r19.f11836g;
        r12 = s.e.a.f11891a;
    L146:
        int r45 = r10.l();
        if (r20 != r25) goto L149;
        r45 = (r18.l() - r112.f11836g) - r111.f11836g;
        r20 = s.e.a.f11891a;
    L149:
        r31 = r45;
        r30 = r20;
        goto L151
    L62:
        if (r12 == s.e.a.f11891a) goto L65;
        if (r12 != s.e.a.f11892b) goto L71;
    L53:
        if (r10.f11884t != 1) goto L59;
        if (r112.f11835f != null) goto L57;
    L58:
        r13 = s.e.a.f11892b;
        goto L59
    L57:
        if (r111.f11835f != null) goto L59;
    L44:
        if (r10.f11883s != 1) goto L50;
        if (r110.f11835f != null) goto L48;
    L49:
        r12 = s.e.a.f11892b;
        goto L50
    L48:
        if (r19.f11835f != null) goto L50;
    L11:
        if (r12 != s.e.a.f11893m) goto L13;
        r10.f11883s = 2;
        goto L13
    L7:
        r10.f11848a = true;
        goto L4
    }

    public final void c() {
        ArrayList<p> r8 = this.f12155e;
        r8.clear();
        s.f r10 = this.f12154d;
        r10.f11854d.f();
        r10.f11855e.f();
        r8.add(r10.f11854d);
        r8.add(r10.f11855e);
        Iterator<s.e> r11 = r10.f11940s0.iterator();
        HashSet r12 = null;
    L4:
        if (r11.hasNext() == false) goto L30;
        s.e r13 = r11.next();
        if ((r13 instanceof s.h) == true) goto L7;
        if (r13.x() == true) goto L11;
        r8.add(r13.f11854d);
    L18:
        if (r13.y() == true) goto L20;
        r8.add(r13.f11855e);
    L27:
        if ((r13 instanceof s.j) == false) goto L4;
        p r14 = new k(r13);
    L29:
        r8.add(r14);
        goto L4
    L20:
        if (r13.f11852c != null) goto L22;
        r13.f11852c = new c(1, r13);
    L22:
        if (r12 != null) goto L24;
        r12 = new HashSet();
    L24:
        r12.add(r13.f11852c);
        goto L27
    L11:
        if (r13.f11850b != null) goto L13;
        r13.f11850b = new c(0, r13);
    L13:
        if (r12 != null) goto L15;
        r12 = new HashSet();
    L15:
        r12.add(r13.f11850b);
        goto L18
    L7:
        r14 = new j(r13);
        goto L29
    L30:
        if (r12 == null) goto L32;
        r8.addAll(r12);
    L32:
        Iterator<p> r15 = r8.iterator();
    L34:
        if (r15.hasNext() == false) goto L36;
        r15.next().f();
        goto L34
    L36:
        Iterator<p> r16 = r8.iterator();
    L38:
        if (r16.hasNext() == false) goto L43;
        p r17 = r16.next();
        if (r17.f12194b == r10) goto L38;
        r17.d();
        goto L38
    L43:
        ArrayList<m> r18 = this.f12158h;
        r18.clear();
        s.f r19 = this.f12151a;
        e(r19.f11854d, 0, r18);
        e(r19.f11855e, 1, r18);
        this.f12152b = false;
    }

    public final int d(s.f r19, int r20) {
        ArrayList<m> r8 = this.f12158h;
        int r10 = r8.size();
        int r11 = 0;
        long r12 = 0;
        long r13 = 0;
    L3:
        if (r11 >= r10) goto L53;
        p r14 = r8.get(r11).f12183a;
        if ((r14 instanceof c) == true) goto L7;
        if (r20 != 0) goto L14;
        if ((r14 instanceof l) == false) goto L15;
    L16:
        if (r20 != 0) goto L18;
        p r15 = r19.f11854d;
    L19:
        f r16 = r15.f12200h;
        if (r20 != 0) goto L22;
        p r17 = r19.f11854d;
    L23:
        f r18 = r17.f12201i;
        boolean r110 = r14.f12200h.f12170l.contains(r16);
        f r111 = r14.f12201i;
        boolean r112 = r111.f12170l.contains(r18);
        long r113 = r14.j();
        f r114 = r14.f12200h;
        if (r110 == false) goto L44;
        if (r112 == false) goto L44;
        long r115 = m.b(r114, r13);
        long r21 = m.a(r111, r13);
        long r116 = r115 - r113;
        int r22 = r111.f12164f;
        ArrayList<m> r117 = r8;
        int r118 = r10;
        int r119 = r11;
        if (r116 < (-r22)) goto L29;
        r116 = r116 + ((long) r22);
    L29:
        long r23 = r114.f12164f;
        long r24 = ((-r21) - r113) - r23;
        if (r24 < r23) goto L32;
        r24 = r24 - r23;
    L32:
        s.e r25 = r14.f12194b;
        if (r20 != 0) goto L36;
        float r26 = r25.f11860g0;
    L40:
        if (r26 <= 0.0f) goto L42;
        long r27 = (long) ((r116 / (1.0f - r26)) + (r24 / r26));
    L43:
        float r28 = r27;
        r13 = (((long) r114.f12164f) + ((((long) ((r28 * r26) + 0.5f)) + r113) + ((long) defpackage.a.a(1.0f, r26, r28, 0.5f)))) - ((long) r111.f12164f);
    L51:
        r12 = Math.max(r12, r13);
        r11 = r119 + 1;
        r13 = 0;
        r8 = r117;
        r10 = r118;
        goto L3
    L42:
        r27 = 0;
        goto L43
    L36:
        if (r20 != 1) goto L38;
        r26 = r25.f11862h0;
        goto L40
    L38:
        r25.getClass();
        r26 = -1.0f;
    L44:
        r117 = r8;
        r118 = r10;
        r119 = r11;
        if (r110 == false) goto L47;
        long r29 = m.b(r114, r114.f12164f);
        long r30 = ((long) r114.f12164f) + r113;
    L49:
        r13 = Math.max(r29, r30);
        goto L51
    L47:
        if (r112 == false) goto L50;
        long r31 = m.a(r111, r111.f12164f);
        r30 = ((long) (-r111.f12164f)) + r113;
        r29 = -r31;
        goto L49
    L50:
        r13 = (r14.j() + r114.f12164f) - ((long) r111.f12164f);
        goto L51
    L22:
        r17 = r19.f11855e;
        goto L23
    L18:
        r15 = r19.f11855e;
    L15:
        r117 = r8;
        r118 = r10;
        r119 = r11;
        goto L51
    L14:
        if ((r14 instanceof n) == true) goto L16;
    L7:
        if (((c) r14).f12198f == r20) goto L16;
    L53:
        return (int) r12;
    }

    public final void e(p r10, int r11, ArrayList<m> r12) {
        Iterator r8 = r10.f12200h.f12169k.iterator();
    L3:
        boolean r13 = r8.hasNext();
        f r14 = r10.f12201i;
        if (r13 == false) goto L13;
        d r15 = (d) r8.next();
        if ((r15 instanceof f) == true) goto L7;
        if ((r15 instanceof p) == false) goto L3;
        f r16 = ((p) r15).f12200h;
    L12:
        a(r16, r11, 0, r12, null);
        goto L3
    L7:
        r16 = (f) r15;
        goto L12
    L13:
        Iterator r17 = r14.f12169k.iterator();
    L15:
        if (r17.hasNext() == false) goto L25;
        d r18 = (d) r17.next();
        if ((r18 instanceof f) == true) goto L18;
        if ((r18 instanceof p) == false) goto L15;
        f r19 = ((p) r18).f12201i;
    L23:
        a(r19, r11, 1, r12, null);
        goto L15
    L18:
        r19 = (f) r18;
        goto L23
    L25:
        if (r11 != 1) goto L32;
        Iterator r20 = ((n) r10).f12185k.f12169k.iterator();
    L28:
        if (r20.hasNext() == false) goto L50;
        d r21 = (d) r20.next();
        if ((r21 instanceof f) == false) goto L28;
        a((f) r21, r11, 2, r12, null);
        goto L28
    L50:
        return;
    }

    public final void f(s.e r8, s.e.a r10, int r11, s.e.a r12, int r13) {
        b.a r14 = this.f12157g;
        r14.f12139a = r10;
        r14.f12140b = r12;
        r14.f12141c = r11;
        r14.f12142d = r13;
        ((ConstraintLayout.b) this.f12156f).b(r8, r14);
        r8.N(r14.f12143e);
        r8.K(r14.f12144f);
        r8.F = r14.f12146h;
        int r15 = r14.f12145g;
        r8.d0 = r15;
        if (r15 <= 0) goto L5;
        boolean r16 = true;
    L6:
        r8.F = r16;
        return;
    L5:
        r16 = false;
        goto L6
    }

    public final void g() {
        Iterator<s.e> r8 = this.f12151a.f11940s0.iterator();
    L4:
        if (r8.hasNext() == false) goto L45;
        s.e r10 = r8.next();
        if (r10.f11848a == true) goto L4;
        s.e.a[] r11 = r10.V;
        boolean r12 = false;
        s.e.a r13 = r11[0];
        s.e.a r14 = r11[1];
        int r15 = r10.f11883s;
        int r16 = r10.f11884t;
        s.e.a r17 = s.e.a.f11892b;
        if (r13 != r17) goto L11;
    L15:
        boolean r18 = true;
    L16:
        if (r14 != r17) goto L18;
    L20:
        r12 = true;
    L21:
        g r19 = r10.f11854d.f12197e;
        boolean r20 = r19.f12168j;
        g r21 = r10.f11855e.f12197e;
        boolean r110 = r21.f12168j;
        if (r20 == false) goto L25;
        if (r110 == false) goto L25;
        s.e.a r22 = s.e.a.f11891a;
        f(r10, r22, r19.f12165g, r22, r21.f12165g);
    L39:
        r10.f11848a = true;
    L41:
        if (r10.f11848a == false) goto L4;
        a r23 = r10.f11855e.f12186l;
        if (r23 == null) goto L4;
        r23.d(r10.d0);
    L25:
        if (r20 == false) goto L31;
        if (r12 == false) goto L31;
        f(r10, s.e.a.f11891a, r19.f12165g, r17, r21.f12165g);
        if (r14 != s.e.a.f11893m) goto L30;
        g r24 = r10.f11855e.f12197e;
        int r25 = r10.l();
    L36:
        r24.f12180m = r25;
        goto L41
    L30:
        g r26 = r10.f11855e.f12197e;
        int r27 = r10.l();
    L38:
        r26.d(r27);
    L31:
        if (r110 == false) goto L41;
        if (r18 == false) goto L41;
        f(r10, r17, r19.f12165g, s.e.a.f11891a, r21.f12165g);
        if (r13 != s.e.a.f11893m) goto L37;
        r24 = r10.f11854d.f12197e;
        r25 = r10.q();
        goto L36
    L37:
        r26 = r10.f11854d.f12197e;
        r27 = r10.q();
        goto L38
    L18:
        if (r14 != s.e.a.f11893m) goto L21;
        if (r16 != 1) goto L21;
    L11:
        if (r13 != s.e.a.f11893m) goto L14;
        if (r15 == 1) goto L15;
    L14:
        r18 = false;
        goto L16
    }
}
