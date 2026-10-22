package s;

/* JADX INFO: loaded from: classes.dex */
public final class a extends j {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f11809u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f11810v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f11811w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f11812x0;

    public a() {
        this.f11809u0 = 0;
        this.f11810v0 = true;
        this.f11811w0 = 0;
        this.f11812x0 = false;
    }

    @Override // s.e
    public final boolean A() {
        return this.f11812x0;
    }

    @Override // s.e
    public final boolean B() {
        return this.f11812x0;
    }

    public final boolean R() {
        int r8 = 0;
        boolean r10 = true;
        int r11 = 0;
    L3:
        int r12 = this.f11932t0;
        if (r11 >= r12) goto L23;
        e r13 = this.f11931s0[r11];
        if (this.f11810v0 == false) goto L8;
    L10:
        int r14 = this.f11809u0;
        if (r14 == 0) goto L14;
        if (r14 == 1) goto L14;
    L16:
        int r15 = this.f11809u0;
        if (r15 == 2) goto L20;
        if (r15 == 3) goto L20;
    L22:
        r11 = r11 + 1;
    L20:
        if (r13.B() == true) goto L22;
    L15:
        r10 = false;
    L14:
        if (r13.A() == true) goto L16;
    L8:
        if (r13.d() == true) goto L10;
    L23:
        if (r10 == false) goto L65;
        if (r12 <= 0) goto L65;
        int r16 = 0;
        boolean r17 = false;
    L27:
        if (r8 >= this.f11932t0) goto L57;
        e r18 = this.f11931s0[r8];
        if (this.f11810v0 == false) goto L31;
    L33:
        if (r17 == true) goto L45;
        int r19 = this.f11809u0;
        if (r19 != 0) goto L38;
        d.a r20 = d.a.f11839a;
    L37:
        r16 = r18.j(r20).d();
    L44:
        r17 = true;
        goto L45
    L38:
        if (r19 != 1) goto L40;
        r20 = d.a.f11841m;
        goto L37
    L40:
        if (r19 != 2) goto L42;
        r20 = d.a.f11840b;
        goto L37
    L42:
        if (r19 != 3) goto L44;
        r20 = d.a.f11842n;
    L45:
        int r21 = this.f11809u0;
        if (r21 != 0) goto L49;
        d.a r22 = d.a.f11839a;
    L48:
        r16 = Math.min(r16, r18.j(r22).d());
    L56:
        r8 = r8 + 1;
        goto L27
    L49:
        if (r21 != 1) goto L52;
        d.a r23 = d.a.f11841m;
    L51:
        r16 = Math.max(r16, r18.j(r23).d());
        goto L56
    L52:
        if (r21 != 2) goto L54;
        r22 = d.a.f11840b;
        goto L48
    L54:
        if (r21 != 3) goto L56;
        r23 = d.a.f11842n;
        goto L51
    L31:
        if (r18.d() == true) goto L33;
    L57:
        int r24 = r16 + this.f11811w0;
        int r25 = this.f11809u0;
        if (r25 == 0) goto L62;
        if (r25 == 1) goto L62;
        J(r24, r24);
    L63:
        this.f11812x0 = true;
        return true;
    L62:
        I(r24, r24);
    L65:
        return false;
    }

    public final int S() {
        int r8 = this.f11809u0;
        if (r8 != 0) goto L5;
        return 0;
    L5:
        if (r8 != 1) goto L7;
        return 0;
    L7:
        if (r8 != 2) goto L9;
    L12:
        return 1;
    L9:
        if (r8 == 3) goto L12;
        return -1;
    }

    @Override // s.e
    public final void c(p.d r17, boolean r18) {
        d[] r8 = this.S;
        d r10 = this.K;
        r8[0] = r10;
        int r11 = 2;
        d r12 = this.L;
        r8[2] = r12;
        d r13 = this.M;
        r8[1] = r13;
        d r14 = this.N;
        r8[3] = r14;
        int r15 = 0;
    L4:
        if (r15 >= r8.length) goto L6;
        d r16 = r8[r15];
        r16.f11838i = r17.l(r16);
        r15 = r15 + 1;
        goto L4
    L6:
        int r19 = this.f11809u0;
        if (r19 >= 0) goto L9;
        return;
    L9:
        if (r19 >= 4) goto L132;
        d r20 = r8[r19];
        if (this.f11812x0 == true) goto L14;
        R();
    L14:
        if (this.f11812x0 == false) goto L25;
        this.f11812x0 = false;
        int r21 = this.f11809u0;
        if (r21 == 0) goto L22;
        if (r21 == 1) goto L22;
        if (r21 == 2) goto L21;
        if (r21 == 3) goto L21;
        return;
    L21:
        r17.d(r12.f11838i, this.f11853c0);
        p.h r22 = r14.f11838i;
        int r23 = this.f11853c0;
    L23:
        r17.d(r22, r23);
        return;
    L22:
        r17.d(r10.f11838i, this.f11851b0);
        r22 = r13.f11838i;
        r23 = this.f11851b0;
        goto L23
    L25:
        int r110 = 0;
    L27:
        if (r110 >= this.f11932t0) goto L53;
        e r111 = this.f11931s0[r110];
        if (this.f11810v0 == false) goto L31;
    L33:
        int r112 = this.f11809u0;
        if (r112 == 0) goto L37;
        if (r112 == 1) goto L37;
    L43:
        if (r112 == 2) goto L46;
        if (r112 == 3) goto L46;
    L52:
        r110 = r110 + 1;
    L46:
        if (r111.V[1] != e.a.f11893m) goto L52;
        if (r111.L.f11835f == null) goto L52;
        if (r111.N.f11835f == null) goto L52;
    L51:
        boolean r113 = true;
    L55:
        if (r10.g() == false) goto L57;
    L60:
        boolean r114 = true;
    L62:
        if (r12.g() == false) goto L64;
    L67:
        boolean r115 = true;
    L68:
        if (r113 == true) goto L79;
        int r116 = this.f11809u0;
        if (r116 != 0) goto L72;
        if (r114 == false) goto L72;
    L78:
        boolean r117 = true;
    L80:
        if (r117 == true) goto L82;
        int r118 = 4;
    L83:
        int r119 = 0;
    L85:
        if (r119 >= this.f11932t0) goto L104;
        e r120 = this.f11931s0[r119];
        if (this.f11810v0 == false) goto L89;
    L91:
        p.h r121 = r17.l(r120.S[this.f11809u0]);
        int r122 = this.f11809u0;
        d r123 = r120.S[r122];
        r123.f11838i = r121;
        d r24 = r123.f11835f;
        if (r24 != null) goto L94;
    L96:
        int r25 = 0;
    L97:
        if (r122 == 0) goto L101;
        if (r122 == r11) goto L101;
        p.h r124 = r20.f11838i;
        int r125 = this.f11811w0 + r25;
        p.b r26 = r17.m();
        p.h r27 = r17.n();
        r27.f9898n = 0;
        r26.c(r124, r121, r27, r125);
        r17.c(r26);
    L102:
        r17.e(r20.f11838i, r121, this.f11811w0 + r25, r118);
    L103:
        r119 = r119 + 1;
        r11 = 2;
    L101:
        p.h r28 = r20.f11838i;
        int r29 = this.f11811w0 - r25;
        p.b r126 = r17.m();
        p.h r127 = r17.n();
        r127.f9898n = 0;
        r126.d(r28, r121, r127, r29);
        r17.c(r126);
        goto L102
    L94:
        if (r24.f11833d != this) goto L96;
        r25 = r123.f11836g + 0;
        goto L97
    L89:
        if (r120.d() == true) goto L91;
    L104:
        int r30 = this.f11809u0;
        if (r30 != 0) goto L108;
        r17.e(r13.f11838i, r10.f11838i, 0, 8);
        r17.e(r10.f11838i, this.W.M.f11838i, 0, 4);
        p.h r31 = r10.f11838i;
        d r32 = this.W.K;
    L116:
        r17.e(r31, r32.f11838i, 0, 0);
        return;
    L108:
        if (r30 != 1) goto L111;
        r17.e(r10.f11838i, r13.f11838i, 0, 8);
        r17.e(r10.f11838i, this.W.K.f11838i, 0, 4);
        r31 = r10.f11838i;
        r32 = this.W.M;
        goto L116
    L111:
        if (r30 != 2) goto L114;
        r17.e(r14.f11838i, r12.f11838i, 0, 8);
        r17.e(r12.f11838i, this.W.N.f11838i, 0, 4);
        r31 = r12.f11838i;
        r32 = this.W.L;
        goto L116
    L114:
        if (r30 != 3) goto L133;
        r17.e(r12.f11838i, r14.f11838i, 0, 8);
        r17.e(r12.f11838i, this.W.L.f11838i, 0, 4);
        r31 = r12.f11838i;
        r32 = this.W.N;
        goto L116
    L133:
        return;
    L82:
        r118 = 5;
    L72:
        if (r116 != 2) goto L74;
        if (r115 == true) goto L78;
    L74:
        if (r116 != 1) goto L76;
        if (r114 == true) goto L78;
    L76:
        if (r116 != 3) goto L79;
        if (r115 == true) goto L78;
    L79:
        r117 = false;
        goto L80
    L64:
        if (r14.g() == true) goto L67;
        r115 = false;
        goto L68
    L57:
        if (r13.g() == true) goto L60;
        r114 = false;
    L37:
        if (r111.V[0] != e.a.f11893m) goto L43;
        if (r111.K.f11835f == null) goto L43;
        if (r111.M.f11835f == null) goto L43;
    L31:
        if (r111.d() == true) goto L33;
    L53:
        r113 = false;
        goto L55
    }

    @Override // s.e
    public final boolean d() {
        return true;
    }

    @Override // s.e
    public final String toString() {
        String r8 = android.aimedia.a.i(new StringBuilder("[Barrier] "), this.f11868k0, " {");
        int r10 = 0;
    L4:
        if (r10 >= this.f11932t0) goto L10;
        e r11 = this.f11931s0[r10];
        if (r10 <= 0) goto L8;
        r8 = defpackage.a.e(r8, ", ");
    L8:
        StringBuilder r12 = android.aimedia.a.j(r8);
        r12.append(r11.f11868k0);
        r8 = r12.toString();
        r10 = r10 + 1;
        goto L4
    L10:
        return defpackage.a.e(r8, "}");
    }
}
