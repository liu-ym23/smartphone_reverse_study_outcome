package t;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class n extends p {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f12185k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f12186l;

    public n(s.e r8) {
        super(r8);
        f r10 = new f(this);
        this.f12185k = r10;
        this.f12186l = null;
        f r11 = this.f12200h;
        r11.f12163e = f.a.f12176p;
        f r12 = this.f12201i;
        r12.f12163e = f.a.f12177q;
        r10.f12163e = f.a.f12178r;
        this.f12198f = 1;
    }

    @Override // t.p, t.d
    public final void a(d r10) {
        if (this.f12202j.ordinal() == 3) goto L80;
        g r11 = this.f12197e;
        if (r11.f12161c == true) goto L7;
    L31:
        f r8 = this.f12200h;
        if (r8.f12161c == false) goto L82;
        f r12 = this.f12201i;
        if (r12.f12161c == true) goto L37;
        return;
    L37:
        if (r8.f12168j == true) goto L39;
    L43:
        boolean r13 = r11.f12168j;
        ArrayList r14 = r8.f12170l;
        ArrayList r15 = r12.f12170l;
        if (r13 == true) goto L54;
        if (this.f12196d != s.e.a.f11893m) goto L54;
        s.e r16 = this.f12194b;
        if (r16.f11883s != 0) goto L54;
        if (r16.y() == true) goto L54;
        f r17 = (f) r14.get(0);
        f r18 = (f) r15.get(0);
        int r19 = r17.f12165g + r8.f12164f;
        int r20 = r18.f12165g + r12.f12164f;
        r8.d(r19);
        r12.d(r20);
        r11.d(r20 - r19);
        return;
    L54:
        if (r11.f12168j == true) goto L68;
        if (this.f12196d != s.e.a.f11893m) goto L68;
        if (this.f12193a != 1) goto L68;
        if (r14.size() <= 0) goto L68;
        if (r15.size() <= 0) goto L68;
        f r21 = (f) r14.get(0);
        f r22 = (f) r15.get(0);
        int r23 = (r22.f12165g + r12.f12164f) - (r21.f12165g + r8.f12164f);
        int r24 = r11.f12180m;
        if (r23 >= r24) goto L66;
        r11.d(r23);
        goto L68
    L66:
        r11.d(r24);
    L68:
        if (r11.f12168j == true) goto L71;
        return;
    L71:
        if (r14.size() > 0) goto L73;
        return;
    L73:
        if (r15.size() <= 0) goto L84;
        f r25 = (f) r14.get(0);
        f r26 = (f) r15.get(0);
        int r27 = r25.f12165g;
        int r28 = r8.f12164f + r27;
        int r29 = r26.f12165g;
        int r30 = r12.f12164f + r29;
        float r31 = this.f12194b.f11862h0;
        if (r25 != r26) goto L77;
        r31 = 0.5f;
    L78:
        r8.d((int) ((((r29 - r27) - r11.f12165g) * r31) + (r27 + 0.5f)));
        r12.d(r8.f12165g + r11.f12165g);
        return;
    L77:
        r27 = r28;
        r29 = r30;
        goto L78
    L84:
        return;
    L39:
        if (r12.f12168j == false) goto L43;
        if (r11.f12168j == false) goto L43;
        return;
    L82:
        return;
    L7:
        if (r11.f12168j == true) goto L31;
        if (this.f12196d != s.e.a.f11893m) goto L31;
        s.e r32 = this.f12194b;
        int r33 = r32.f11884t;
        if (r33 == 2) goto L23;
        if (r33 != 3) goto L31;
        g r34 = r32.f11854d.f12197e;
        if (r34.f12168j == false) goto L31;
        int r35 = r32.f11849a0;
        if (r35 == (-1)) goto L22;
        if (r35 == 0) goto L21;
        if (r35 == 1) goto L22;
        int r36 = 0;
    L30:
        r11.d(r36);
        goto L31
    L21:
        float r37 = r34.f12165g;
        float r38 = r32.Z;
    L28:
        float r39 = r37 * r38;
    L29:
        r36 = (int) (r39 + 0.5f);
    L22:
        r39 = r34.f12165g / r32.Z;
        goto L29
    L23:
        s.e r40 = r32.W;
        if (r40 == null) goto L31;
        g r41 = r40.f11855e.f12197e;
        if (r41.f12168j == false) goto L31;
        r38 = r32.A;
        r37 = r41.f12165g;
        goto L28
    L80:
        s.e r110 = this.f12194b;
        l(r110.L, r110.N, 1);
    }

    @Override // t.p
    public final void d() {
        s.e r8 = this.f12194b;
        boolean r10 = r8.f11848a;
        g r11 = this.f12197e;
        if (r10 == false) goto L5;
        r11.d(r8.l());
    L5:
        boolean r12 = r11.f12168j;
        f r13 = this.f12201i;
        f r14 = this.f12200h;
        if (r12 == true) goto L24;
        s.e r15 = this.f12194b;
        this.f12196d = r15.V[1];
        if (r15.F == false) goto L10;
        this.f12186l = new a(this);
    L10:
        s.e.a r16 = this.f12196d;
        if (r16 != s.e.a.f11893m) goto L13;
    L31:
        boolean r17 = r11.f12168j;
        f r18 = this.f12185k;
        if (r17 == false) goto L80;
        s.e r19 = this.f12194b;
        if (r19.f11848a == false) goto L80;
        s.d[] r20 = r19.S;
        s.d r110 = r20[2];
        s.d r111 = r110.f11835f;
        if (r111 != null) goto L38;
    L52:
        if (r111 == null) goto L58;
        f r21 = p.h(r110);
        if (r21 == null) goto L161;
        p.b(r14, r21, this.f12194b.S[2].e());
        p.b(r13, r14, r11.f12165g);
        s.e r112 = this.f12194b;
        if (r112.F == false) goto L162;
    L79:
        p.b(r18, r14, r112.d0);
        return;
    L162:
        return;
    L161:
        return;
    L58:
        s.d r22 = r20[3];
        if (r22.f11835f == null) goto L66;
        f r23 = p.h(r22);
        if (r23 == null) goto L63;
        p.b(r13, r23, -this.f12194b.S[3].e());
        p.b(r14, r13, -r11.f12165g);
    L63:
        r112 = this.f12194b;
        if (r112.F == true) goto L79;
        return;
    L66:
        s.d r24 = r20[4];
        if (r24.f11835f == null) goto L72;
        f r25 = p.h(r24);
        if (r25 == null) goto L164;
        p.b(r18, r25, 0);
        p.b(r14, r18, -this.f12194b.d0);
        p.b(r13, r14, r11.f12165g);
        return;
    L164:
        return;
    L72:
        if ((r19 instanceof s.i) == false) goto L74;
        return;
    L74:
        if (r19.W != null) goto L76;
        return;
    L76:
        if (r19.j(s.d.a.f11844p).f11835f != null) goto L168;
        s.e r26 = this.f12194b;
        p.b(r14, r26.W.f11855e.f12200h, r26.s());
        p.b(r13, r14, r11.f12165g);
        r112 = this.f12194b;
        if (r112.F == true) goto L79;
        return;
    L168:
        return;
    L38:
        if (r20[3].f11835f == null) goto L52;
        if (r19.y() == false) goto L42;
        r14.f12164f = this.f12194b.S[2].e();
        r13.f12164f = -this.f12194b.S[3].e();
    L49:
        r112 = this.f12194b;
        if (r112.F == true) goto L79;
        return;
    L42:
        f r27 = p.h(this.f12194b.S[2]);
        if (r27 == null) goto L45;
        p.b(r14, r27, this.f12194b.S[2].e());
    L45:
        f r28 = p.h(this.f12194b.S[3]);
        if (r28 == null) goto L48;
        p.b(r13, r28, -this.f12194b.S[3].e());
    L48:
        r14.f12160b = true;
        r13.f12160b = true;
    L80:
        ArrayList r113 = r11.f12170l;
        if (r17 == false) goto L83;
    L99:
        r11.b(this);
    L100:
        s.e r29 = this.f12194b;
        s.d[] r114 = r29.S;
        s.d r115 = r114[2];
        s.d r116 = r115.f11835f;
        if (r116 == null) goto L117;
        if (r114[3].f11835f == null) goto L117;
        if (r29.y() == false) goto L107;
        r14.f12164f = this.f12194b.S[2].e();
        r13.f12164f = -this.f12194b.S[3].e();
    L114:
        if (this.f12194b.F == false) goto L157;
    L136:
        c(r18, r14, 1, this.f12186l);
    L157:
        if (r113.size() != 0) goto L171;
        r11.f12161c = true;
        return;
    L171:
        return;
    L107:
        f r30 = p.h(this.f12194b.S[2]);
        f r31 = p.h(this.f12194b.S[3]);
        if (r30 == null) goto L110;
        r30.b(this);
    L110:
        if (r31 == null) goto L112;
        r31.b(this);
    L112:
        this.f12202j = p.a.f12204b;
    L117:
        if (r116 == null) goto L130;
        f r32 = p.h(r115);
        if (r32 == null) goto L157;
        p.b(r14, r32, this.f12194b.S[2].e());
        c(r13, r14, 1, r11);
        if (this.f12194b.F == false) goto L123;
        c(r18, r14, 1, this.f12186l);
    L123:
        s.e.a r33 = this.f12196d;
        s.e.a r34 = s.e.a.f11893m;
        if (r33 != r34) goto L157;
        s.e r35 = this.f12194b;
        if (r35.Z <= 0.0f) goto L157;
        l r36 = r35.f11854d;
        if (r36.f12196d != r34) goto L157;
    L155:
        r36.f12197e.f12169k.add(r11);
        r113.add(this.f12194b.f11854d.f12197e);
        r11.f12159a = this;
        goto L157
    L130:
        s.d r37 = r114[3];
        if (r37.f11835f == null) goto L137;
        f r38 = p.h(r37);
        if (r38 == null) goto L157;
        p.b(r13, r38, -this.f12194b.S[3].e());
        c(r14, r13, -1, r11);
        if (this.f12194b.F == false) goto L157;
    L137:
        s.d r39 = r114[4];
        if (r39.f11835f == null) goto L143;
        f r40 = p.h(r39);
        if (r40 == null) goto L157;
        p.b(r18, r40, 0);
        c(r14, r18, -1, this.f12186l);
        c(r13, r14, 1, r11);
        goto L157
    L143:
        if ((r29 instanceof s.i) == true) goto L157;
        s.e r41 = r29.W;
        if (r41 == null) goto L157;
        p.b(r14, r41.f11855e.f12200h, r29.s());
        c(r13, r14, 1, r11);
        if (this.f12194b.F == false) goto L149;
        c(r18, r14, 1, this.f12186l);
    L149:
        s.e.a r42 = this.f12196d;
        s.e.a r43 = s.e.a.f11893m;
        if (r42 != r43) goto L157;
        s.e r44 = this.f12194b;
        if (r44.Z <= 0.0f) goto L157;
        r36 = r44.f11854d;
        if (r36.f12196d != r43) goto L157;
    L83:
        if (this.f12196d != s.e.a.f11893m) goto L99;
        s.e r45 = this.f12194b;
        int r117 = r45.f11884t;
        if (r117 == 2) goto L94;
        if (r117 != 3) goto L100;
        if (r45.y() == true) goto L100;
        s.e r46 = this.f12194b;
        if (r46.f11883s == 3) goto L100;
        p r47 = r46.f11854d;
    L98:
        g r48 = r47.f12197e;
        r113.add(r48);
        r48.f12169k.add(r11);
        r11.f12160b = true;
        ArrayList r49 = r11.f12169k;
        r49.add(r14);
        r49.add(r13);
        goto L100
    L94:
        s.e r50 = r45.W;
        if (r50 == null) goto L100;
        r47 = r50.f11855e;
        goto L98
    L13:
        if (r16 != s.e.a.f11894n) goto L21;
        s.e r51 = this.f12194b.W;
        if (r51 == null) goto L21;
        if (r51.V[1] != s.e.a.f11891a) goto L21;
        int r52 = (r51.l() - this.f12194b.L.e()) - this.f12194b.N.e();
        p.b(r14, r51.f11855e.f12200h, this.f12194b.L.e());
        p.b(r13, r51.f11855e.f12201i, -this.f12194b.N.e());
        r11.d(r52);
        return;
    L21:
        if (r16 != s.e.a.f11891a) goto L31;
        r11.d(this.f12194b.l());
        goto L31
    L24:
        if (this.f12196d != s.e.a.f11894n) goto L31;
        s.e r53 = this.f12194b;
        s.e r54 = r53.W;
        if (r54 == null) goto L31;
        if (r54.V[1] != s.e.a.f11891a) goto L31;
        p.b(r14, r54.f11855e.f12200h, r53.L.e());
        p.b(r13, r54.f11855e.f12201i, -this.f12194b.N.e());
    }

    @Override // t.p
    public final void e() {
        f r8 = this.f12200h;
        if (r8.f12168j == false) goto L6;
        s.e r10 = this.f12194b;
        r10.f11853c0 = r8.f12165g;
        return;
    }

    @Override // t.p
    public final void f() {
        this.f12195c = null;
        this.f12200h.c();
        this.f12201i.c();
        this.f12185k.c();
        this.f12197e.c();
        this.f12199g = false;
    }

    @Override // t.p
    public final boolean k() {
        if (this.f12196d == s.e.a.f11893m) goto L5;
        return true;
    L5:
        if (this.f12194b.f11884t != 0) goto L7;
        return true;
    L7:
        return false;
    }

    public final void m() {
        this.f12199g = false;
        f r8 = this.f12200h;
        r8.c();
        r8.f12168j = false;
        f r10 = this.f12201i;
        r10.c();
        r10.f12168j = false;
        f r11 = this.f12185k;
        r11.c();
        r11.f12168j = false;
        this.f12197e.f12168j = false;
    }

    public final String toString() {
        return "VerticalRun " + this.f12194b.f11868k0;
    }
}
