package fr;

import com.google.common.reflect.w;
import com.obric.oui.constraintlayout.core.SolverVariable$Type;
import java.util.ArrayList;
import java.util.Arrays;
import ym.p;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static boolean f16984q = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f16986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f16987c;
    public final d d;
    public int e;
    public int f;
    public b[] g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f16988h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean[] f16989i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f16990j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f16991k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f16992l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final w f16993m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public e[] f16994n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f16995o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b f16996p;

    public c() {
        this.f16985a = 1000;
        this.f16986b = false;
        this.f16987c = 0;
        this.e = 32;
        this.f = 32;
        this.f16988h = false;
        this.f16989i = new boolean[32];
        this.f16990j = 1;
        this.f16991k = 0;
        this.f16992l = 32;
        this.f16994n = new e[1000];
        this.f16995o = 0;
        this.g = new b[32];
        s();
        w r5 = new w(25, false);
        r5.f9377c = new al.a(6);
        r5.f9376b = new al.a(6);
        r5.d = new e[32];
        this.f16993m = r5;
        d r10 = new d(r5);
        r10.f = new e[128];
        r10.g = new e[128];
        r10.f16997h = 0;
        r10.f16998i = new p(r10);
        this.d = r10;
        this.f16996p = new b(r5);
    }

    public static int n(Object r5) {
        e r10 = ((hr.d) r5).f17391i;
        if (r10 != null) goto L5;
        return 0;
    L5:
        return (int) (r10.e + 0.5f);
    }

    public final e a(SolverVariable$Type r10) {
        al.a r5 = (al.a) this.f16993m.f9376b;
        int r11 = r5.f313a;
        Object r12 = null;
        if (r11 <= 0) goto L5;
        int r13 = r11 - 1;
        Object[] r14 = (Object[]) r5.f314b;
        Object r15 = r14[r13];
        r14[r13] = null;
        r5.f313a = r13;
        r12 = r15;
    L5:
        e r16 = (e) r12;
        if (r16 != null) goto L8;
        r16 = new e(r10);
        r16.f17003i = r10;
    L9:
        int r17 = this.f16995o;
        int r18 = this.f16985a;
        if (r17 < r18) goto L12;
        int r19 = r18 * 2;
        this.f16985a = r19;
        this.f16994n = (e[]) Arrays.copyOf(this.f16994n, r19);
    L12:
        e[] r20 = this.f16994n;
        int r21 = this.f16995o;
        this.f16995o = r21 + 1;
        r20[r21] = r16;
        return r16;
    L8:
        r16.c();
        r16.f17003i = r10;
        goto L9
    }

    public final void b(e r10, e r11, int r12, float r13, e r14, e r15, int r16, int r17) {
        b r5 = l();
        if (r11 != r14) goto L6;
        r5.d.g(r10, 1.0f);
        r5.d.g(r15, 1.0f);
        r5.d.g(r11, -2.0f);
    L22:
        if (r17 == 8) goto L24;
        r5.a(this, r17);
    L24:
        c(r5);
        return;
    L6:
        if (r13 != 0.5f) goto L12;
        r5.d.g(r10, 1.0f);
        r5.d.g(r11, -1.0f);
        r5.d.g(r14, -1.0f);
        r5.d.g(r15, 1.0f);
        if (r12 > 0) goto L10;
        if (r16 <= 0) goto L22;
    L10:
        r5.f16982b = (-r12) + r16;
        goto L22
    L12:
        if (r13 > 0.0f) goto L15;
        r5.d.g(r10, -1.0f);
        r5.d.g(r11, 1.0f);
        r5.f16982b = r12;
        goto L22
    L15:
        if (r13 < 1.0f) goto L17;
        r5.d.g(r15, -1.0f);
        r5.d.g(r14, 1.0f);
        r5.f16982b = -r16;
        goto L22
    L17:
        float r18 = 1.0f - r13;
        r5.d.g(r10, r18 * 1.0f);
        r5.d.g(r11, r18 * (-1.0f));
        r5.d.g(r14, (-1.0f) * r13);
        r5.d.g(r15, 1.0f * r13);
        if (r12 > 0) goto L20;
        if (r16 <= 0) goto L22;
    L20:
        r5.f16982b = (r16 * r13) + ((-r12) * r18);
        goto L22
    }

    public final void c(b r17) {
        boolean r5 = true;
        if ((this.f16991k + 1) < this.f16992l) goto L5;
    L6:
        o();
    L8:
        if (r17.e == false) goto L10;
        boolean r10 = false;
    L129:
        if (r10 == true) goto L157;
        h(r17);
        return;
    L157:
        return;
    L10:
        if (this.g.length == 0) goto L41;
        boolean r11 = false;
    L13:
        if (r11 == true) goto L36;
        int r12 = r17.d.d();
        int r13 = 0;
    L15:
        ArrayList r14 = r17.f16983c;
        if (r13 >= r12) goto L24;
        e r15 = r17.d.e(r13);
        if (r15.f17001c == (-1)) goto L20;
    L22:
        r14.add(r15);
    L23:
        r13 = r13 + 1;
        goto L15
    L20:
        if (r15.f == true) goto L22;
    L24:
        int r16 = r14.size();
        if (r16 > 0) goto L26;
        r11 = true;
        goto L13
    L26:
        int r18 = 0;
    L27:
        if (r18 >= r16) goto L33;
        e r19 = (e) r14.get(r18);
        if (r19.f == false) goto L31;
        r17.h(this, r19, true);
    L32:
        r18 = r18 + 1;
        goto L27
    L31:
        r17.i(this, this.g[r19.f17001c], true);
        goto L32
    L33:
        r14.clear();
        goto L13
    L36:
        if (r17.f16981a == null) goto L41;
        if (r17.d.d() != 0) goto L41;
        r17.e = true;
        this.f16986b = true;
    L41:
        if (r17.e() == false) goto L43;
        return;
    L43:
        float r20 = r17.f16982b;
        if (r20 >= 0.0f) goto L51;
        r17.f16982b = r20 * (-1.0f);
        a r21 = r17.d;
        int r22 = r21.f16978h;
        int r23 = 0;
    L47:
        if (r22 == (-1)) goto L51;
        if (r23 >= r21.f16975a) goto L51;
        float[] r24 = r21.g;
        r24[r22] = r24[r22] * (-1.0f);
        r22 = r21.f[r22];
        r23 = r23 + 1;
    L51:
        int r25 = r17.d.d();
        float r110 = 0.0f;
        float r111 = 0.0f;
        int r26 = 0;
        e r27 = null;
        e r112 = null;
        boolean r113 = false;
        boolean r114 = false;
    L52:
        if (r26 >= r25) goto L89;
        float r115 = r17.d.f(r26);
        e r28 = r17.d.e(r26);
        if (r28.f17003i != SolverVariable$Type.UNRESTRICTED) goto L70;
        if (r27 != null) goto L62;
        if (r28.f17006l <= 1) goto L69;
    L59:
        r113 = false;
    L60:
        r27 = r28;
        r110 = r115;
    L88:
        r26 = r26 + 1;
    L69:
        r113 = true;
        goto L60
    L62:
        if (r110 > r115) goto L64;
        if (r113 == true) goto L88;
        if (r28.f17006l > 1) goto L88;
    L64:
        if (r28.f17006l > 1) goto L59;
    L70:
        if (r27 != null) goto L88;
        if (r115 >= 0.0f) goto L88;
        if (r112 != null) goto L80;
        if (r28.f17006l <= 1) goto L87;
    L77:
        r114 = false;
    L78:
        r112 = r28;
        r111 = r115;
    L87:
        r114 = true;
        goto L78
    L80:
        if (r111 > r115) goto L82;
        if (r114 == true) goto L88;
        if (r28.f17006l > 1) goto L88;
    L82:
        if (r28.f17006l > 1) goto L77;
    L89:
        if (r27 != null) goto L92;
        r27 = r112;
    L92:
        if (r27 != null) goto L94;
        boolean r29 = true;
    L96:
        if (r17.d.d() != 0) goto L98;
        r17.e = true;
    L98:
        if (r29 == true) goto L100;
    L119:
        r5 = false;
    L120:
        e r30 = r17.f16981a;
        if (r30 != null) goto L123;
        return;
    L123:
        if (r30.f17003i != SolverVariable$Type.UNRESTRICTED) goto L125;
    L126:
        r10 = r5;
        goto L129
    L125:
        if (r17.f16982b >= 0.0f) goto L126;
        return;
    L100:
        if ((this.f16990j + 1) < this.f) goto L102;
        o();
    L102:
        e r31 = a(SolverVariable$Type.SLACK);
        int r32 = this.f16987c + 1;
        this.f16987c = r32;
        this.f16990j++;
        r31.f17000b = r32;
        w r33 = this.f16993m;
        ((e[]) r33.d)[r32] = r31;
        r17.f16981a = r31;
        int r34 = this.f16991k;
        h(r17);
        if (this.f16991k != (r34 + 1)) goto L119;
        b r35 = this.f16996p;
        r35.f16981a = null;
        r35.d.b();
        int r36 = 0;
    L106:
        if (r36 >= r17.d.d()) goto L108;
        r35.d.a(r17.d.e(r36), r17.d.f(r36), true);
        r36 = r36 + 1;
        goto L106
    L108:
        r(this.f16996p);
        if (r31.f17001c != (-1)) goto L120;
        if (r17.f16981a != r31) goto L116;
        e r37 = r17.f(null, r31);
        if (r37 == null) goto L116;
        r17.g(r37);
    L116:
        if (r17.e == true) goto L118;
        r17.f16981a.e(this, r17);
    L118:
        ((al.a) r33.f9377c).c(r17);
        this.f16991k--;
        goto L120
    L94:
        r17.g(r27);
        r29 = false;
        goto L96
    L5:
        if ((this.f16990j + 1) < this.f) goto L8;
        goto L6
    }

    public final void d(e r5, int r10) {
        int r11 = r5.f17001c;
        if (r11 != (-1)) goto L9;
        r5.d(this, r10);
        int r12 = 0;
    L6:
        if (r12 >= (this.f16987c + 1)) goto L8;
        e r13 = ((e[]) this.f16993m.d)[r12];
        r12 = r12 + 1;
        goto L6
    L8:
        return;
    L9:
        if (r11 == (-1)) goto L21;
        b r14 = this.g[r11];
        if (r14.e == false) goto L14;
        r14.f16982b = r10;
        return;
    L14:
        if (r14.d.d() != 0) goto L16;
        r14.e = true;
        r14.f16982b = r10;
        return;
    L16:
        b r15 = l();
        if (r10 >= 0) goto L19;
        r15.f16982b = r10 * (-1);
        r15.d.g(r5, 1.0f);
    L20:
        c(r15);
        return;
    L19:
        r15.f16982b = r10;
        r15.d.g(r5, -1.0f);
        goto L20
    L21:
        b r16 = l();
        r16.f16981a = r5;
        float r17 = r10;
        r5.e = r17;
        r16.f16982b = r17;
        r16.e = true;
        c(r16);
    }

    public final void e(e r5, e r10, int r11, int r12) {
        if (r12 == 8) goto L5;
    L10:
        b r13 = l();
        boolean r14 = false;
        if (r11 == 0) goto L16;
        if (r11 >= 0) goto L14;
        r11 = r11 * (-1);
        r14 = true;
    L14:
        r13.f16982b = r11;
    L16:
        if (r14 == true) goto L18;
        r13.d.g(r5, -1.0f);
        r13.d.g(r10, 1.0f);
    L19:
        if (r12 == 8) goto L21;
        r13.a(this, r12);
    L21:
        c(r13);
        return;
    L18:
        r13.d.g(r5, 1.0f);
        r13.d.g(r10, -1.0f);
        goto L19
    L5:
        if (r10.f == false) goto L10;
        if (r5.f17001c != (-1)) goto L10;
        r5.d(this, r10.e + r11);
    }

    public final void f(e r5, e r10, int r11, int r12) {
        b r13 = l();
        e r14 = m();
        r14.d = 0;
        r13.b(r5, r10, r14, r11);
        if (r12 == 8) goto L5;
        int r15 = (int) (r13.d.c(r14) * (-1.0f));
        r13.d.g(j(r12), r15);
    L5:
        c(r13);
    }

    public final void g(e r5, e r10, int r11, int r12) {
        b r13 = l();
        e r14 = m();
        r14.d = 0;
        r13.c(r5, r10, r14, r11);
        if (r12 == 8) goto L5;
        int r15 = (int) (r13.d.c(r14) * (-1.0f));
        r13.d.g(j(r12), r15);
    L5:
        c(r13);
    }

    public final void h(b r10) {
        if (r10.e == false) goto L5;
        r10.f16981a.d(this, r10.f16982b);
    L7:
        if (this.f16986b == false) goto L38;
        int r5 = 0;
    L10:
        if (r5 >= this.f16991k) goto L29;
        if (this.g[r5] != null) goto L14;
        System.out.println("WTF");
    L14:
        b r11 = this.g[r5];
        if (r11 == null) goto L28;
        if (r11.e == false) goto L28;
        r11.f16981a.d(this, r11.f16982b);
        ((al.a) this.f16993m.f9377c).c(r11);
        this.g[r5] = null;
        int r12 = r5 + 1;
        int r13 = r12;
    L19:
        int r14 = this.f16991k;
        if (r12 >= r14) goto L25;
        b[] r15 = this.g;
        int r16 = r12 - 1;
        b r17 = r15[r12];
        r15[r16] = r17;
        e r18 = r17.f16981a;
        if (r18.f17001c != r12) goto L24;
        r18.f17001c = r16;
    L24:
        r13 = r12;
        r12 = r12 + 1;
        goto L19
    L25:
        if (r13 >= r14) goto L27;
        this.g[r13] = null;
    L27:
        this.f16991k = r14 - 1;
        r5 = r5 - 1;
    L28:
        r5 = r5 + 1;
        goto L10
    L29:
        this.f16986b = false;
        return;
    L38:
        return;
    L5:
        b[] r19 = this.g;
        int r20 = this.f16991k;
        r19[r20] = r10;
        e r21 = r10.f16981a;
        r21.f17001c = r20;
        this.f16991k = r20 + 1;
        r21.e(this, r10);
        goto L7
    }

    public final void i() {
        int r5 = 0;
    L4:
        if (r5 >= this.f16991k) goto L6;
        b r10 = this.g[r5];
        e r11 = r10.f16981a;
        r11.e = r10.f16982b;
        r5 = r5 + 1;
        goto L4
    }

    public final e j(int r5) {
        if ((this.f16990j + 1) < this.f) goto L5;
        o();
    L5:
        e r10 = a(SolverVariable$Type.ERROR);
        int r11 = this.f16987c + 1;
        this.f16987c = r11;
        this.f16990j++;
        r10.f17000b = r11;
        r10.d = r5;
        ((e[]) this.f16993m.d)[r11] = r10;
        d r12 = this.d;
        r12.f16998i.f23312b = r10;
        float[] r13 = r10.f17002h;
        Arrays.fill(r13, 0.0f);
        r13[r10.d] = 1.0f;
        r12.j(r10);
        return r10;
    }

    public final e k(Object r5) {
        e r10 = null;
        if (r5 != null) goto L6;
        return null;
    L6:
        if ((this.f16990j + 1) < this.f) goto L9;
        o();
    L9:
        if ((r5 instanceof hr.d) == false) goto L22;
        hr.d r11 = (hr.d) r5;
        r10 = r11.f17391i;
        if (r10 != null) goto L13;
        r11.k();
        r10 = r11.f17391i;
    L13:
        int r12 = r10.f17000b;
        w r13 = this.f16993m;
        if (r12 != (-1)) goto L16;
    L19:
        if (r12 == (-1)) goto L21;
        r10.c();
    L21:
        int r14 = this.f16987c + 1;
        this.f16987c = r14;
        this.f16990j++;
        r10.f17000b = r14;
        r10.f17003i = SolverVariable$Type.UNRESTRICTED;
        ((e[]) r13.d)[r14] = r10;
        goto L22
    L16:
        if (r12 > this.f16987c) goto L19;
        if (((e[]) r13.d)[r12] == null) goto L19;
    L22:
        return r10;
    }

    public final b l() {
        w r5 = this.f16993m;
        al.a r10 = (al.a) r5.f9377c;
        int r11 = r10.f313a;
        if (r11 <= 0) goto L5;
        int r12 = r11 - 1;
        Object[] r13 = (Object[]) r10.f314b;
        Object r14 = r13[r12];
        r13[r12] = null;
        r10.f313a = r12;
    L6:
        b r15 = (b) r14;
        if (r15 == null) goto L11;
        r15.f16981a = null;
        r15.d.b();
        r15.f16982b = 0.0f;
        r15.e = false;
        return r15;
    L11:
        return new b(r5);
    L5:
        r14 = null;
        goto L6
    }

    public final e m() {
        if ((this.f16990j + 1) < this.f) goto L5;
        o();
    L5:
        e r5 = a(SolverVariable$Type.SLACK);
        int r10 = this.f16987c + 1;
        this.f16987c = r10;
        this.f16990j++;
        r5.f17000b = r10;
        ((e[]) this.f16993m.d)[r10] = r5;
        return r5;
    }

    public final void o() {
        int r5 = this.e * 2;
        this.e = r5;
        this.g = (b[]) Arrays.copyOf(this.g, r5);
        w r10 = this.f16993m;
        r10.d = (e[]) Arrays.copyOf((e[]) r10.d, this.e);
        int r11 = this.e;
        this.f16989i = new boolean[r11];
        this.f = r11;
        this.f16992l = r11;
    }

    public final void p() {
        d r5 = this.d;
        if (r5.e() == false) goto L7;
        i();
        return;
    L7:
        if (this.f16988h == false) goto L16;
        int r10 = 0;
    L10:
        if (r10 >= this.f16991k) goto L15;
        if (this.g[r10].e == false) goto L13;
        r10 = r10 + 1;
        goto L10
    L13:
        q(r5);
        return;
    L15:
        i();
        return;
    L16:
        q(r5);
    }

    public final void q(d r19) {
        int r5 = 0;
    L4:
        if (r5 >= this.f16991k) goto L47;
        b r10 = this.g[r5];
        if (r10.f16981a.f17003i == SolverVariable$Type.UNRESTRICTED) goto L46;
        float r11 = 0.0f;
        if (r10.f16982b >= 0.0f) goto L46;
        boolean r12 = false;
        int r13 = 0;
    L11:
        if (r12 == true) goto L47;
        r13 = r13 + 1;
        float r14 = Float.MAX_VALUE;
        int r15 = -1;
        int r16 = -1;
        int r17 = 0;
        int r18 = 0;
    L14:
        if (r17 >= this.f16991k) goto L39;
        b r110 = this.g[r17];
        if (r110.f16981a.f17003i == SolverVariable$Type.UNRESTRICTED) goto L38;
        if (r110.e == true) goto L38;
        if (r110.f16982b >= r11) goto L38;
        int r111 = r110.d.d();
        int r112 = 0;
    L24:
        if (r112 >= r111) goto L38;
        e r113 = r110.d.e(r112);
        float r20 = r110.d.c(r113);
        if (r20 <= r11) goto L37;
        int r21 = 0;
    L30:
        if (r21 >= 9) goto L37;
        float r22 = r113.g[r21] / r20;
        if (r22 >= r14) goto L34;
        if (r21 != r18) goto L34;
    L35:
        r18 = r21;
        r16 = r113.f17000b;
        r15 = r17;
        r14 = r22;
    L36:
        r21 = r21 + 1;
    L34:
        if (r21 <= r18) goto L36;
    L37:
        r112 = r112 + 1;
        r11 = 0.0f;
    L38:
        r17 = r17 + 1;
        r11 = 0.0f;
        goto L14
    L39:
        if (r15 == (-1)) goto L41;
        b r23 = this.g[r15];
        r23.f16981a.f17001c = -1;
        r23.g(((e[]) this.f16993m.d)[r16]);
        e r24 = r23.f16981a;
        r24.f17001c = r15;
        r24.e(this, r23);
    L43:
        if (r13 <= (this.f16990j / 2)) goto L45;
        r12 = true;
    L45:
        r11 = 0.0f;
        goto L11
    L41:
        r12 = true;
    L46:
        r5 = r5 + 1;
    L47:
        r(r19);
        i();
    }

    public final void r(b r17) {
        int r5 = 0;
        int r10 = 0;
    L4:
        if (r10 >= this.f16990j) goto L6;
        this.f16989i[r10] = false;
        r10 = r10 + 1;
        goto L4
    L6:
        boolean r11 = false;
        int r12 = 0;
    L7:
        if (r11 == true) goto L52;
        r12 = r12 + 1;
        if (r12 >= (this.f16990j * 2)) goto L10;
        e r13 = r17.f16981a;
        if (r13 == null) goto L14;
        this.f16989i[r13.f17000b] = true;
    L14:
        e r14 = r17.d(this.f16989i);
        if (r14 == null) goto L20;
        boolean[] r15 = this.f16989i;
        int r16 = r14.f17000b;
        if (r15[r16] == true) goto L18;
        r15[r16] = true;
        goto L20
    L18:
        return;
    L20:
        if (r14 == null) goto L50;
        float r18 = Float.MAX_VALUE;
        int r19 = r5;
        int r20 = -1;
    L23:
        if (r19 >= this.f16991k) goto L48;
        b r110 = this.g[r19];
        if (r110.f16981a.f17003i == SolverVariable$Type.UNRESTRICTED) goto L47;
        if (r110.e == true) goto L47;
        a r111 = r110.d;
        int r112 = r111.f16978h;
        if (r112 != (-1)) goto L33;
    L32:
        boolean r113 = false;
    L41:
        if (r113 == false) goto L47;
        float r21 = r110.d.c(r14);
        if (r21 >= 0.0f) goto L47;
        float r114 = (-r110.f16982b) / r21;
        if (r114 >= r18) goto L47;
        r20 = r19;
        r18 = r114;
        goto L47
    L33:
        int r115 = 0;
    L34:
        if (r112 == (-1)) goto L32;
        if (r115 >= r111.f16975a) goto L32;
        if (r111.e[r112] == r14.f17000b) goto L39;
        r112 = r111.f[r112];
        r115 = r115 + 1;
        goto L34
    L39:
        r113 = true;
    L47:
        r19 = r19 + 1;
        goto L23
    L48:
        if (r20 <= (-1)) goto L51;
        b r22 = this.g[r20];
        r22.f16981a.f17001c = -1;
        r22.g(r14);
        e r23 = r22.f16981a;
        r23.f17001c = r20;
        r23.e(this, r22);
    L51:
        r5 = 0;
        goto L7
    L50:
        r11 = true;
        goto L51
    L10:
        return;
    }

    public final void s() {
        int r5 = 0;
    L4:
        if (r5 >= this.f16991k) goto L9;
        b r10 = this.g[r5];
        if (r10 == null) goto L8;
        ((al.a) this.f16993m.f9377c).c(r10);
    L8:
        this.g[r5] = null;
        r5 = r5 + 1;
        goto L4
    }

    public final void t() {
        int r5 = 0;
    L3:
        w r10 = this.f16993m;
        e[] r11 = (e[]) r10.d;
        if (r5 >= r11.length) goto L9;
        e r12 = r11[r5];
        if (r12 == null) goto L8;
        r12.c();
    L8:
        r5 = r5 + 1;
        goto L3
    L9:
        al.a r13 = (al.a) r10.f9376b;
        e[] r14 = this.f16994n;
        int r15 = this.f16995o;
        r13.getClass();
        if (r15 <= r14.length) goto L12;
        r15 = r14.length;
    L12:
        int r16 = 0;
    L13:
        if (r16 >= r15) goto L18;
        e r17 = r14[r16];
        int r18 = r13.f313a;
        Object[] r19 = (Object[]) r13.f314b;
        if (r18 >= r19.length) goto L17;
        r19[r18] = r17;
        r13.f313a = r18 + 1;
    L17:
        r16 = r16 + 1;
        goto L13
    L18:
        this.f16995o = 0;
        Arrays.fill((e[]) r10.d, null);
        this.f16987c = 0;
        d r20 = this.d;
        r20.f16997h = 0;
        r20.f16982b = 0.0f;
        this.f16990j = 1;
        int r21 = 0;
    L20:
        if (r21 >= this.f16991k) goto L22;
        b r22 = this.g[r21];
        r21 = r21 + 1;
        goto L20
    L22:
        s();
        this.f16991k = 0;
        this.f16996p = new b(r10);
    }
}
