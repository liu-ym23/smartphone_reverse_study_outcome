package t;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class l extends p {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f12182k = null;

    static {
        f12182k = new int[2];
    }

    public l(s.e r8) {
        super(r8);
        f r10 = this.f12200h;
        r10.f12163e = f.a.f12174n;
        f r11 = this.f12201i;
        r11.f12163e = f.a.f12175o;
        this.f12198f = 0;
    }

    public static void m(int[] r8, int r10, int r11, int r12, int r13, float r14, int r15) {
        int r16 = r11 - r10;
        int r17 = r13 - r12;
        if (r15 == (-1)) goto L9;
        if (r15 == 0) goto L8;
        if (r15 != 1) goto L19;
        r8[0] = r16;
        r8[1] = (int) ((r16 * r14) + 0.5f);
        return;
    L19:
        return;
    L8:
        r8[0] = (int) ((r17 * r14) + 0.5f);
        r8[1] = r17;
        return;
    L9:
        int r18 = (int) ((r17 * r14) + 0.5f);
        int r19 = (int) ((r16 / r14) + 0.5f);
        if (r18 > r16) goto L12;
        r8[0] = r18;
        r8[1] = r17;
        return;
    L12:
        if (r19 > r17) goto L18;
        r8[0] = r16;
        r8[1] = r19;
        return;
    }

    @Override // t.p, t.d
    public final void a(d r23) {
        if (this.f12202j.ordinal() == 3) goto L173;
        g r8 = this.f12197e;
        boolean r10 = r8.f12168j;
        f r11 = this.f12200h;
        f r12 = this.f12201i;
        if (r10 == true) goto L129;
        if (this.f12196d != s.e.a.f11893m) goto L129;
        s.e r13 = this.f12194b;
        int r14 = r13.f11883s;
        if (r14 == 2) goto L120;
        if (r14 != 3) goto L129;
        int r15 = r13.f11884t;
        if (r15 == 0) goto L23;
        if (r15 == 3) goto L23;
        int r16 = r13.f11849a0;
        if (r16 == (-1)) goto L22;
        if (r16 == 0) goto L21;
        if (r16 == 1) goto L22;
        int r17 = 0;
    L127:
        r8.d(r17);
        goto L129
    L21:
        float r18 = r13.f11855e.f12197e.f12165g / r13.Z;
    L126:
        r17 = (int) (r18 + 0.5f);
    L22:
        float r19 = r13.f11855e.f12197e.f12165g;
        float r20 = r13.Z;
    L125:
        r18 = r19 * r20;
    L23:
        n r21 = r13.f11855e;
        f r22 = r21.f12200h;
        f r24 = r21.f12201i;
        if (r13.K.f11835f == null) goto L26;
        boolean r110 = true;
    L28:
        if (r13.L.f11835f == null) goto L30;
        boolean r111 = true;
    L32:
        if (r13.M.f11835f == null) goto L34;
        boolean r112 = true;
    L36:
        if (r13.N.f11835f == null) goto L38;
        boolean r113 = true;
    L39:
        int r114 = r13.f11849a0;
        if (r110 == false) goto L77;
        if (r111 == false) goto L77;
        if (r112 == false) goto L77;
        if (r113 == false) goto L77;
        float r25 = r13.Z;
        boolean r115 = r22.f12168j;
        int[] r116 = f12182k;
        if (r115 == true) goto L47;
    L55:
        boolean r117 = r11.f12168j;
        ArrayList r118 = r22.f12170l;
        if (r117 == false) goto L67;
        if (r12.f12168j == false) goto L67;
        if (r22.f12161c == true) goto L62;
        return;
    L62:
        if (r24.f12161c == false) goto L177;
        m(r116, r11.f12165g + r11.f12164f, r12.f12165g - r12.f12164f, ((f) r118.get(0)).f12165g + r22.f12164f, ((f) r24.f12170l.get(0)).f12165g - r24.f12164f, r25, r114);
        r8.d(r116[0]);
        this.f12194b.f11855e.f12197e.d(r116[1]);
        goto L67
    L177:
        return;
    L67:
        if (r11.f12161c == true) goto L69;
        return;
    L69:
        if (r12.f12161c == true) goto L71;
        return;
    L71:
        if (r22.f12161c == true) goto L73;
        return;
    L73:
        if (r24.f12161c == false) goto L180;
        m(r116, ((f) r11.f12170l.get(0)).f12165g + r11.f12164f, ((f) r12.f12170l.get(0)).f12165g - r12.f12164f, ((f) r118.get(0)).f12165g + r22.f12164f, ((f) r24.f12170l.get(0)).f12165g - r24.f12164f, r25, r114);
        r8.d(r116[0]);
        g r26 = this.f12194b.f11855e.f12197e;
        int r27 = r116[1];
    L118:
        r26.d(r27);
        goto L129
    L180:
        return;
    L47:
        if (r24.f12168j == false) goto L55;
        if (r11.f12161c == true) goto L51;
        return;
    L51:
        if (r12.f12161c == false) goto L176;
        m(r116, ((f) r11.f12170l.get(0)).f12165g + r11.f12164f, ((f) r12.f12170l.get(0)).f12165g - r12.f12164f, r22.f12165g + r22.f12164f, r24.f12165g - r24.f12164f, r25, r114);
        r8.d(r116[0]);
        this.f12194b.f11855e.f12197e.d(r116[1]);
        return;
    L176:
        return;
    L77:
        if (r110 == false) goto L98;
        if (r112 == false) goto L98;
        if (r11.f12161c == true) goto L82;
        return;
    L82:
        if (r12.f12161c == false) goto L181;
        float r28 = r13.Z;
        int r29 = ((f) r11.f12170l.get(0)).f12165g + r11.f12164f;
        int r30 = ((f) r12.f12170l.get(0)).f12165g - r12.f12164f;
        if (r114 == (-1)) goto L92;
        if (r114 == 0) goto L92;
        if (r114 != 1) goto L129;
        int r31 = g(r30 - r29, 0);
        int r32 = (int) ((r31 / r28) + 0.5f);
        int r119 = g(r32, 1);
        if (r32 == r119) goto L96;
        float r33 = r119 * r28;
    L95:
        r31 = (int) (r33 + 0.5f);
    L96:
        r8.d(r31);
        this.f12194b.f11855e.f12197e.d(r119);
    L92:
        r31 = g(r30 - r29, 0);
        int r34 = (int) ((r31 * r28) + 0.5f);
        r119 = g(r34, 1);
        if (r34 == r119) goto L96;
        r33 = r119 / r28;
        goto L95
    L181:
        return;
    L98:
        if (r111 == false) goto L129;
        if (r113 == false) goto L129;
        if (r22.f12161c == true) goto L103;
        return;
    L103:
        if (r24.f12161c == false) goto L182;
        float r35 = r13.Z;
        int r120 = ((f) r22.f12170l.get(0)).f12165g + r22.f12164f;
        int r36 = ((f) r24.f12170l.get(0)).f12165g - r24.f12164f;
        if (r114 == (-1)) goto L113;
        if (r114 == 0) goto L110;
        if (r114 == 1) goto L113;
    L110:
        int r37 = g(r36 - r120, 1);
        int r38 = (int) ((r37 * r35) + 0.5f);
        int r121 = g(r38, 0);
        if (r38 == r121) goto L117;
        float r39 = r121 / r35;
    L116:
        r37 = (int) (r39 + 0.5f);
    L117:
        r27 = r37;
        r8.d(r121);
        r26 = this.f12194b.f11855e.f12197e;
    L113:
        r37 = g(r36 - r120, 1);
        int r40 = (int) ((r37 / r35) + 0.5f);
        r121 = g(r40, 0);
        if (r40 == r121) goto L117;
        r39 = r121 * r35;
        goto L116
    L182:
        return;
    L38:
        r113 = false;
        goto L39
    L34:
        r112 = false;
        goto L36
    L30:
        r111 = false;
        goto L32
    L26:
        r110 = false;
        goto L28
    L120:
        s.e r41 = r13.W;
        if (r41 == null) goto L129;
        g r42 = r41.f11854d.f12197e;
        if (r42.f12168j == false) goto L129;
        r20 = r13.f11888x;
        r19 = r42.f12165g;
    L129:
        if (r11.f12161c == true) goto L131;
        return;
    L131:
        if (r12.f12161c == true) goto L134;
        return;
    L134:
        if (r11.f12168j == true) goto L136;
    L140:
        boolean r43 = r8.f12168j;
        ArrayList r44 = r11.f12170l;
        ArrayList r45 = r12.f12170l;
        if (r43 == true) goto L151;
        if (this.f12196d != s.e.a.f11893m) goto L151;
        s.e r46 = this.f12194b;
        if (r46.f11883s != 0) goto L151;
        if (r46.x() == true) goto L151;
        f r47 = (f) r44.get(0);
        f r48 = (f) r45.get(0);
        int r49 = r47.f12165g + r11.f12164f;
        int r50 = r48.f12165g + r12.f12164f;
        r11.d(r49);
        r12.d(r50);
        r8.d(r50 - r49);
        return;
    L151:
        if (r8.f12168j == true) goto L165;
        if (this.f12196d != s.e.a.f11893m) goto L165;
        if (this.f12193a != 1) goto L165;
        if (r44.size() <= 0) goto L165;
        if (r45.size() <= 0) goto L165;
        f r51 = (f) r44.get(0);
        f r52 = (f) r45.get(0);
        int r53 = Math.min((r52.f12165g + r12.f12164f) - (r51.f12165g + r11.f12164f), r8.f12180m);
        s.e r54 = this.f12194b;
        int r122 = r54.f11887w;
        int r55 = Math.max(r54.f11886v, r53);
        if (r122 <= 0) goto L163;
        r55 = Math.min(r122, r55);
    L163:
        r8.d(r55);
    L165:
        if (r8.f12168j == true) goto L167;
        return;
    L167:
        f r56 = (f) r44.get(0);
        f r57 = (f) r45.get(0);
        int r58 = r56.f12165g;
        int r59 = r11.f12164f + r58;
        int r60 = r57.f12165g;
        int r123 = r12.f12164f + r60;
        float r61 = this.f12194b.f11860g0;
        if (r56 != r57) goto L170;
        r61 = 0.5f;
    L171:
        r11.d((int) ((((r60 - r58) - r8.f12165g) * r61) + (r58 + 0.5f)));
        r12.d(r11.f12165g + r8.f12165g);
        return;
    L170:
        r58 = r59;
        r60 = r123;
        goto L171
    L136:
        if (r12.f12168j == false) goto L140;
        if (r8.f12168j == false) goto L140;
        return;
    L173:
        s.e r62 = this.f12194b;
        l(r62.K, r62.M, 0);
    }

    @Override // t.p
    public final void d() {
        s.e r8 = this.f12194b;
        boolean r10 = r8.f11848a;
        g r11 = this.f12197e;
        if (r10 == false) goto L5;
        r11.d(r8.q());
    L5:
        boolean r12 = r11.f12168j;
        f r13 = this.f12201i;
        f r14 = this.f12200h;
        if (r12 == true) goto L21;
        s.e r15 = this.f12194b;
        s.e.a r16 = r15.V[0];
        this.f12196d = r16;
        if (r16 == s.e.a.f11893m) goto L31;
        s.e.a r17 = s.e.a.f11894n;
        if (r16 != r17) goto L19;
        s.e r18 = r15.W;
        if (r18 == null) goto L19;
        s.e.a r19 = r18.V[0];
        if (r19 == s.e.a.f11891a) goto L16;
        if (r19 != r17) goto L19;
    L16:
        int r20 = (r18.q() - this.f12194b.K.e()) - this.f12194b.M.e();
        p.b(r14, r18.f11854d.f12200h, this.f12194b.K.e());
        p.b(r13, r18.f11854d.f12201i, -this.f12194b.M.e());
        r11.d(r20);
        return;
    L19:
        if (r16 != s.e.a.f11891a) goto L31;
        r11.d(r15.q());
    L31:
        if (r11.f12168j == false) goto L67;
        s.e r21 = this.f12194b;
        if (r21.f11848a == false) goto L67;
        s.d[] r22 = r21.S;
        s.d r23 = r22[0];
        s.d r24 = r23.f11835f;
        if (r24 != null) goto L37;
    L48:
        if (r24 == null) goto L53;
        f r25 = p.h(r23);
        if (r25 == null) goto L119;
        int r110 = this.f12194b.S[0].e();
    L52:
        p.b(r14, r25, r110);
        p.b(r13, r14, r11.f12165g);
        return;
    L119:
        return;
    L53:
        s.d r26 = r22[1];
        if (r26.f11835f == null) goto L59;
        f r27 = p.h(r26);
        if (r27 == null) goto L120;
        p.b(r13, r27, -this.f12194b.S[1].e());
        p.b(r14, r13, -r11.f12165g);
        return;
    L120:
        return;
    L59:
        if ((r21 instanceof s.i) == false) goto L61;
        return;
    L61:
        if (r21.W != null) goto L63;
        return;
    L63:
        if (r21.j(s.d.a.f11844p).f11835f != null) goto L124;
        s.e r111 = this.f12194b;
        r25 = r111.W.f11854d.f12200h;
        r110 = r111.r();
        goto L52
    L124:
        return;
    L37:
        if (r22[1].f11835f == null) goto L48;
        if (r21.x() == false) goto L41;
        r14.f12164f = this.f12194b.S[0].e();
        s.d r112 = this.f12194b.S[1];
    L95:
        r13.f12164f = -r112.e();
        return;
    L41:
        f r28 = p.h(this.f12194b.S[0]);
        if (r28 == null) goto L44;
        p.b(r14, r28, this.f12194b.S[0].e());
    L44:
        f r29 = p.h(this.f12194b.S[1]);
        if (r29 == null) goto L47;
        p.b(r13, r29, -this.f12194b.S[1].e());
    L47:
        r14.f12160b = true;
        r13.f12160b = true;
        return;
    L67:
        if (this.f12196d != s.e.a.f11893m) goto L88;
        s.e r30 = this.f12194b;
        int r31 = r30.f11883s;
        ArrayList r32 = r11.f12169k;
        ArrayList r33 = r11.f12170l;
        if (r31 != 2) goto L71;
        s.e r34 = r30.W;
        if (r34 == null) goto L88;
        g r35 = r34.f11855e.f12197e;
        r33.add(r35);
        r35.f12169k.add(r11);
        r11.f12160b = true;
        r32.add(r14);
        r32.add(r13);
        goto L88
    L71:
        if (r31 != 3) goto L88;
        if (r30.f11884t != 3) goto L82;
        r14.f12159a = this;
        r13.f12159a = this;
        n r36 = r30.f11855e;
        r36.f12200h.f12159a = this;
        r36.f12201i.f12159a = this;
        r11.f12159a = this;
        if (r30.y() == false) goto L79;
        r33.add(this.f12194b.f11855e.f12197e);
        this.f12194b.f11855e.f12197e.f12169k.add(r11);
        n r37 = this.f12194b.f11855e;
        r37.f12197e.f12159a = this;
        r33.add(r37.f12200h);
        r33.add(this.f12194b.f11855e.f12201i);
        this.f12194b.f11855e.f12200h.f12169k.add(r11);
        ArrayList r38 = this.f12194b.f11855e.f12201i.f12169k;
    L83:
        r38.add(r11);
        goto L88
    L79:
        if (this.f12194b.x() == false) goto L81;
        this.f12194b.f11855e.f12197e.f12170l.add(r11);
        r32.add(this.f12194b.f11855e.f12197e);
        goto L88
    L81:
        r38 = this.f12194b.f11855e.f12197e.f12170l;
        goto L83
    L82:
        g r39 = r30.f11855e.f12197e;
        r33.add(r39);
        r39.f12169k.add(r11);
        this.f12194b.f11855e.f12200h.f12169k.add(r11);
        this.f12194b.f11855e.f12201i.f12169k.add(r11);
        r11.f12160b = true;
        r32.add(r14);
        r32.add(r13);
        r14.f12170l.add(r11);
        r38 = r13.f12170l;
    L88:
        s.e r40 = this.f12194b;
        s.d[] r41 = r40.S;
        s.d r42 = r41[0];
        s.d r43 = r42.f11835f;
        if (r43 != null) goto L91;
    L102:
        if (r43 == null) goto L106;
        f r44 = p.h(r42);
        if (r44 == null) goto L128;
        p.b(r14, r44, this.f12194b.S[0].e());
    L116:
        c(r13, r14, 1, r11);
        return;
    L128:
        return;
    L106:
        s.d r45 = r41[1];
        if (r45.f11835f == null) goto L112;
        f r46 = p.h(r45);
        if (r46 == null) goto L129;
        p.b(r13, r46, -this.f12194b.S[1].e());
        c(r14, r13, -1, r11);
        return;
    L129:
        return;
    L112:
        if ((r40 instanceof s.i) == true) goto L131;
        s.e r47 = r40.W;
        if (r47 == null) goto L132;
        p.b(r14, r47.f11854d.f12200h, r40.r());
        goto L116
    L132:
        return;
    L131:
        return;
    L91:
        if (r41[1].f11835f == null) goto L102;
        if (r40.x() == false) goto L96;
        r14.f12164f = this.f12194b.S[0].e();
        r112 = this.f12194b.S[1];
        goto L95
    L96:
        f r48 = p.h(this.f12194b.S[0]);
        f r49 = p.h(this.f12194b.S[1]);
        if (r48 == null) goto L99;
        r48.b(this);
    L99:
        if (r49 == null) goto L101;
        r49.b(this);
    L101:
        this.f12202j = p.a.f12204b;
        return;
    L21:
        s.e.a r50 = this.f12196d;
        s.e.a r51 = s.e.a.f11894n;
        if (r50 != r51) goto L31;
        s.e r52 = this.f12194b;
        s.e r53 = r52.W;
        if (r53 == null) goto L31;
        s.e.a r54 = r53.V[0];
        if (r54 == s.e.a.f11891a) goto L28;
        if (r54 != r51) goto L31;
    L28:
        p.b(r14, r53.f11854d.f12200h, r52.K.e());
        p.b(r13, r53.f11854d.f12201i, -this.f12194b.M.e());
    }

    @Override // t.p
    public final void e() {
        f r8 = this.f12200h;
        if (r8.f12168j == false) goto L6;
        s.e r10 = this.f12194b;
        r10.f11851b0 = r8.f12165g;
        return;
    }

    @Override // t.p
    public final void f() {
        this.f12195c = null;
        this.f12200h.c();
        this.f12201i.c();
        this.f12197e.c();
        this.f12199g = false;
    }

    @Override // t.p
    public final boolean k() {
        if (this.f12196d == s.e.a.f11893m) goto L5;
        return true;
    L5:
        if (this.f12194b.f11883s != 0) goto L7;
        return true;
    L7:
        return false;
    }

    public final void n() {
        this.f12199g = false;
        f r8 = this.f12200h;
        r8.c();
        r8.f12168j = false;
        f r10 = this.f12201i;
        r10.c();
        r10.f12168j = false;
        this.f12197e.f12168j = false;
    }

    public final String toString() {
        return "HorizontalRun " + this.f12194b.f11868k0;
    }
}
