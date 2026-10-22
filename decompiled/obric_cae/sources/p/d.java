package p;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static boolean f9870q = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f9874d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9875e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f9876f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b[] f9877g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f9878h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean[] f9879i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f9880j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f9881k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f9882l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f9883m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public h[] f9884n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f9885o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b f9886p;

    public interface a {
        h a(boolean[] r8);
    }

    public d() {
        this.f9871a = 1000;
        this.f9872b = false;
        this.f9873c = 0;
        this.f9875e = 32;
        this.f9876f = 32;
        this.f9878h = false;
        this.f9879i = new boolean[32];
        this.f9880j = 1;
        this.f9881k = 0;
        this.f9882l = 32;
        this.f9884n = new h[1000];
        this.f9885o = 0;
        this.f9877g = new b[32];
        t();
        c r8 = new c(0);
        this.f9883m = r8;
        this.f9874d = new g(r8);
        this.f9886p = new b(r8);
    }

    public static int o(s.d r8) {
        h r10 = r8.f11838i;
        if (r10 != null) goto L5;
        return 0;
    L5:
        return (int) (r10.f9899o + 0.5f);
    }

    public final h a(h.a r8) {
        f r10 = (f) ((e) this.f9883m.f9868c);
        int r11 = r10.f9887a;
        Object r12 = null;
        if (r11 <= 0) goto L5;
        int r13 = r11 - 1;
        Object[] r14 = (Object[]) r10.f9888b;
        Object r15 = r14[r13];
        r14[r13] = null;
        r10.f9887a = r13;
        r12 = r15;
    L5:
        h r16 = (h) r12;
        if (r16 != null) goto L8;
        r16 = new h(r8);
    L9:
        r16.f9903s = r8;
        int r17 = this.f9885o;
        int r18 = this.f9871a;
        if (r17 < r18) goto L12;
        int r19 = r18 * 2;
        this.f9871a = r19;
        this.f9884n = (h[]) Arrays.copyOf(this.f9884n, r19);
    L12:
        h[] r20 = this.f9884n;
        int r21 = this.f9885o;
        this.f9885o = r21 + 1;
        r20[r21] = r16;
        return r16;
    L8:
        r16.c();
        goto L9
    }

    public final void b(h r8, h r10, int r11, float r12, h r13, h r14, int r15, int r16) {
        b r17 = m();
        if (r10 != r13) goto L6;
        r17.f9864d.e(r8, 1.0f);
        r17.f9864d.e(r14, 1.0f);
        r17.f9864d.e(r10, -2.0f);
    L24:
        if (r16 == 8) goto L26;
        r17.b(this, r16);
    L26:
        c(r17);
        return;
    L6:
        if (r12 != 0.5f) goto L12;
        r17.f9864d.e(r8, 1.0f);
        r17.f9864d.e(r10, -1.0f);
        r17.f9864d.e(r13, -1.0f);
        r17.f9864d.e(r14, 1.0f);
        if (r11 > 0) goto L10;
        if (r15 <= 0) goto L24;
    L10:
        int r18 = (-r11) + r15;
    L17:
        float r19 = r18;
    L18:
        r17.f9862b = r19;
        goto L24
    L12:
        if (r12 > 0.0f) goto L15;
        r17.f9864d.e(r8, -1.0f);
        r17.f9864d.e(r10, 1.0f);
        r19 = r11;
        goto L18
    L15:
        if (r12 < 1.0f) goto L19;
        r17.f9864d.e(r14, -1.0f);
        r17.f9864d.e(r13, 1.0f);
        r18 = -r15;
        goto L17
    L19:
        float r20 = 1.0f - r12;
        r17.f9864d.e(r8, r20 * 1.0f);
        r17.f9864d.e(r10, r20 * (-1.0f));
        r17.f9864d.e(r13, (-1.0f) * r12);
        r17.f9864d.e(r14, 1.0f * r12);
        if (r11 > 0) goto L22;
        if (r15 <= 0) goto L24;
    L22:
        r17.f9862b = (r15 * r12) + ((-r11) * r20);
        goto L24
    }

    public final void c(b r17) {
        boolean r8 = true;
        if ((this.f9881k + 1) < this.f9882l) goto L5;
    L6:
        p();
    L8:
        if (r17.f9865e == false) goto L10;
        boolean r10 = false;
    L134:
        if (r10 == true) goto L159;
        i(r17);
        return;
    L159:
        return;
    L10:
        if (this.f9877g.length == 0) goto L41;
        boolean r11 = false;
    L13:
        if (r11 == true) goto L36;
        int r12 = r17.f9864d.g();
        int r13 = 0;
    L15:
        ArrayList<h> r14 = r17.f9863c;
        if (r13 >= r12) goto L24;
        h r15 = r17.f9864d.a(r13);
        if (r15.f9897m == (-1)) goto L20;
    L22:
        r14.add(r15);
    L23:
        r13 = r13 + 1;
        goto L15
    L20:
        if (r15.f9900p == true) goto L22;
    L24:
        int r16 = r14.size();
        if (r16 > 0) goto L26;
        r11 = true;
        goto L13
    L26:
        int r18 = 0;
    L27:
        if (r18 >= r16) goto L33;
        h r19 = r14.get(r18);
        if (r19.f9900p == false) goto L31;
        r17.h(this, r19, true);
    L32:
        r18 = r18 + 1;
        goto L27
    L31:
        r17.i(this, this.f9877g[r19.f9897m], true);
        goto L32
    L33:
        r14.clear();
        goto L13
    L36:
        if (r17.f9861a == null) goto L41;
        if (r17.f9864d.g() != 0) goto L41;
        r17.f9865e = true;
        this.f9872b = true;
    L41:
        if (r17.e() == false) goto L43;
        return;
    L43:
        float r20 = r17.f9862b;
        if (r20 >= 0.0f) goto L46;
        r17.f9862b = r20 * (-1.0f);
        r17.f9864d.b();
    L46:
        int r21 = r17.f9864d.g();
        float r110 = 0.0f;
        float r111 = 0.0f;
        int r22 = 0;
        h r23 = null;
        h r112 = null;
        boolean r113 = false;
        boolean r114 = false;
    L47:
        if (r22 >= r21) goto L90;
        float r115 = r17.f9864d.h(r22);
        h r24 = r17.f9864d.a(r22);
        if (r24.f9903s != h.a.f9907a) goto L68;
        if (r23 != null) goto L55;
        if (r24.f9906v <= 1) goto L66;
    L59:
        r113 = false;
    L67:
        r23 = r24;
        r110 = r115;
    L89:
        r22 = r22 + 1;
    L66:
        r113 = true;
        goto L67
    L55:
        if (r110 > r115) goto L57;
        if (r113 == true) goto L89;
        if (r24.f9906v > 1) goto L64;
        boolean r25 = true;
    L65:
        if (r25 == false) goto L89;
    L64:
        r25 = false;
        goto L65
    L57:
        if (r24.f9906v > 1) goto L59;
    L68:
        if (r23 != null) goto L89;
        if (r115 >= 0.0f) goto L89;
        if (r112 != null) goto L76;
        if (r24.f9906v <= 1) goto L87;
    L80:
        r114 = false;
    L88:
        r112 = r24;
        r111 = r115;
    L87:
        r114 = true;
        goto L88
    L76:
        if (r111 > r115) goto L78;
        if (r114 == true) goto L89;
        if (r24.f9906v > 1) goto L85;
        boolean r26 = true;
    L86:
        if (r26 == false) goto L89;
    L85:
        r26 = false;
        goto L86
    L78:
        if (r24.f9906v > 1) goto L80;
    L90:
        if (r23 != null) goto L93;
        r23 = r112;
    L93:
        if (r23 != null) goto L95;
        boolean r27 = true;
    L97:
        if (r17.f9864d.g() != 0) goto L99;
        r17.f9865e = true;
    L99:
        if (r27 == true) goto L101;
    L121:
        boolean r28 = false;
    L122:
        h r29 = r17.f9861a;
        if (r29 != null) goto L125;
    L129:
        r8 = false;
    L130:
        if (r8 == true) goto L132;
        return;
    L132:
        r10 = r28;
        goto L134
    L125:
        if (r29.f9903s == h.a.f9907a) goto L130;
        if (r17.f9862b < 0.0f) goto L129;
    L101:
        if ((this.f9880j + 1) < this.f9876f) goto L103;
        p();
    L103:
        h r30 = a(h.a.f9908b);
        int r31 = this.f9873c + 1;
        this.f9873c = r31;
        this.f9880j++;
        r30.f9896b = r31;
        c r32 = this.f9883m;
        ((h[]) r32.f9869d)[r31] = r30;
        r17.f9861a = r30;
        int r33 = this.f9881k;
        i(r17);
        if (this.f9881k != (r33 + 1)) goto L121;
        b r34 = this.f9886p;
        r34.getClass();
        r34.f9861a = null;
        r34.f9864d.clear();
        int r35 = 0;
    L107:
        if (r35 >= r17.f9864d.g()) goto L109;
        r34.f9864d.f(r17.f9864d.a(r35), r17.f9864d.h(r35), true);
        r35 = r35 + 1;
        goto L107
    L109:
        s(this.f9886p);
        if (r30.f9897m == (-1)) goto L112;
    L120:
        r28 = true;
        goto L122
    L112:
        if (r17.f9861a != r30) goto L117;
        h r36 = r17.f(null, r30);
        if (r36 == null) goto L117;
        r17.g(r36);
    L117:
        if (r17.f9865e == true) goto L119;
        r17.f9861a.e(this, r17);
    L119:
        ((f) ((e) r32.f9867b)).d(r17);
        this.f9881k--;
        goto L120
    L95:
        r17.g(r23);
        r27 = false;
        goto L97
    L5:
        if ((this.f9880j + 1) < this.f9876f) goto L8;
        goto L6
    }

    public final void d(h r8, int r10) {
        int r11 = r8.f9897m;
        if (r11 != (-1)) goto L9;
        r8.d(this, r10);
        int r12 = 0;
    L6:
        if (r12 >= (this.f9873c + 1)) goto L8;
        h r13 = ((h[]) this.f9883m.f9869d)[r12];
        r12 = r12 + 1;
        goto L6
    L8:
        return;
    L9:
        if (r11 == (-1)) goto L21;
        b r14 = this.f9877g[r11];
        if (r14.f9865e == false) goto L14;
    L12:
        r14.f9862b = r10;
        return;
    L14:
        if (r14.f9864d.g() != 0) goto L16;
        r14.f9865e = true;
        goto L12
    L16:
        b r15 = m();
        if (r10 >= 0) goto L19;
        r15.f9862b = r10 * (-1);
        b.a r16 = r15.f9864d;
        float r17 = 1.0f;
    L20:
        r16.e(r8, r17);
    L22:
        c(r15);
        return;
    L19:
        r15.f9862b = r10;
        r16 = r15.f9864d;
        r17 = -1.0f;
        goto L20
    L21:
        r15 = m();
        r15.f9861a = r8;
        float r18 = r10;
        r8.f9899o = r18;
        r15.f9862b = r18;
        r15.f9865e = true;
        goto L22
    }

    public final void e(h r8, h r10, int r11, int r12) {
        if (r12 == 8) goto L5;
    L10:
        b r13 = m();
        boolean r14 = false;
        if (r11 == 0) goto L16;
        if (r11 >= 0) goto L14;
        r11 = r11 * (-1);
        r14 = true;
    L14:
        r13.f9862b = r11;
    L16:
        if (r14 == true) goto L18;
        r13.f9864d.e(r8, -1.0f);
        r13.f9864d.e(r10, 1.0f);
    L19:
        if (r12 == 8) goto L21;
        r13.b(this, r12);
    L21:
        c(r13);
        return;
    L18:
        r13.f9864d.e(r8, 1.0f);
        r13.f9864d.e(r10, -1.0f);
        goto L19
    L5:
        if (r10.f9900p == false) goto L10;
        if (r8.f9897m != (-1)) goto L10;
        r8.d(this, r10.f9899o + r11);
    }

    public final void f(h r8, h r10, int r11, int r12) {
        b r13 = m();
        h r14 = n();
        r14.f9898n = 0;
        r13.c(r8, r10, r14, r11);
        if (r12 == 8) goto L5;
        int r15 = (int) (r13.f9864d.j(r14) * (-1.0f));
        r13.f9864d.e(k(r12), r15);
    L5:
        c(r13);
    }

    public final void g(h r8, h r10, int r11, int r12) {
        b r13 = m();
        h r14 = n();
        r14.f9898n = 0;
        r13.d(r8, r10, r14, r11);
        if (r12 == 8) goto L5;
        int r15 = (int) (r13.f9864d.j(r14) * (-1.0f));
        r13.f9864d.e(k(r12), r15);
    L5:
        c(r13);
    }

    public final void h(h r8, h r10, h r11, h r12, float r13) {
        b r14 = m();
        r14.f9864d.e(r8, -1.0f);
        r14.f9864d.e(r10, 1.0f);
        r14.f9864d.e(r11, r13);
        r14.f9864d.e(r12, -r13);
        c(r14);
    }

    public final void i(b r8) {
        if (r8.f9865e == false) goto L5;
        r8.f9861a.d(this, r8.f9862b);
    L7:
        if (this.f9872b == false) goto L38;
        int r10 = 0;
    L10:
        if (r10 >= this.f9881k) goto L29;
        if (this.f9877g[r10] != null) goto L14;
        System.out.println("WTF");
    L14:
        b r11 = this.f9877g[r10];
        if (r11 == null) goto L28;
        if (r11.f9865e == false) goto L28;
        r11.f9861a.d(this, r11.f9862b);
        ((f) ((e) this.f9883m.f9867b)).d(r11);
        this.f9877g[r10] = null;
        int r12 = r10 + 1;
        int r13 = r12;
    L19:
        int r14 = this.f9881k;
        if (r12 >= r14) goto L25;
        b[] r15 = this.f9877g;
        int r16 = r12 - 1;
        b r17 = r15[r12];
        r15[r16] = r17;
        h r18 = r17.f9861a;
        if (r18.f9897m != r12) goto L24;
        r18.f9897m = r16;
    L24:
        r13 = r12;
        r12 = r12 + 1;
        goto L19
    L25:
        if (r13 >= r14) goto L27;
        this.f9877g[r13] = null;
    L27:
        this.f9881k = r14 - 1;
        r10 = r10 - 1;
    L28:
        r10 = r10 + 1;
        goto L10
    L29:
        this.f9872b = false;
        return;
    L38:
        return;
    L5:
        b[] r19 = this.f9877g;
        int r20 = this.f9881k;
        r19[r20] = r8;
        h r21 = r8.f9861a;
        r21.f9897m = r20;
        this.f9881k = r20 + 1;
        r21.e(this, r8);
        goto L7
    }

    public final void j() {
        int r8 = 0;
    L4:
        if (r8 >= this.f9881k) goto L6;
        b r10 = this.f9877g[r8];
        h r11 = r10.f9861a;
        r11.f9899o = r10.f9862b;
        r8 = r8 + 1;
        goto L4
    }

    public final h k(int r8) {
        if ((this.f9880j + 1) < this.f9876f) goto L5;
        p();
    L5:
        h r10 = a(h.a.f9909m);
        int r11 = this.f9873c + 1;
        this.f9873c = r11;
        this.f9880j++;
        r10.f9896b = r11;
        r10.f9898n = r8;
        ((h[]) this.f9883m.f9869d)[r11] = r10;
        g r12 = this.f9874d;
        r12.f9892i.f9893a = r10;
        float[] r13 = r10.f9902r;
        Arrays.fill(r13, 0.0f);
        r13[r10.f9898n] = 1.0f;
        r12.j(r10);
        return r10;
    }

    public final h l(Object r8) {
        h r10 = null;
        if (r8 != null) goto L6;
        return null;
    L6:
        if ((this.f9880j + 1) < this.f9876f) goto L9;
        p();
    L9:
        if ((r8 instanceof s.d) == false) goto L22;
        s.d r11 = (s.d) r8;
        r10 = r11.f11838i;
        if (r10 != null) goto L13;
        r11.k();
        r10 = r11.f11838i;
    L13:
        int r12 = r10.f9896b;
        c r13 = this.f9883m;
        if (r12 != (-1)) goto L16;
    L19:
        if (r12 == (-1)) goto L21;
        r10.c();
    L21:
        int r14 = this.f9873c + 1;
        this.f9873c = r14;
        this.f9880j++;
        r10.f9896b = r14;
        r10.f9903s = h.a.f9907a;
        ((h[]) r13.f9869d)[r14] = r10;
        goto L22
    L16:
        if (r12 > this.f9873c) goto L19;
        if (((h[]) r13.f9869d)[r12] == null) goto L19;
    L22:
        return r10;
    }

    public final b m() {
        c r8 = this.f9883m;
        f r10 = (f) ((e) r8.f9867b);
        int r11 = r10.f9887a;
        if (r11 <= 0) goto L5;
        int r12 = r11 - 1;
        Object[] r13 = (Object[]) r10.f9888b;
        Object r14 = r13[r12];
        r13[r12] = null;
        r10.f9887a = r12;
    L6:
        b r15 = (b) r14;
        if (r15 == null) goto L11;
        r15.f9861a = null;
        r15.f9864d.clear();
        r15.f9862b = 0.0f;
        r15.f9865e = false;
        return r15;
    L11:
        return new b(r8);
    L5:
        r14 = null;
        goto L6
    }

    public final h n() {
        if ((this.f9880j + 1) < this.f9876f) goto L5;
        p();
    L5:
        h r8 = a(h.a.f9908b);
        int r10 = this.f9873c + 1;
        this.f9873c = r10;
        this.f9880j++;
        r8.f9896b = r10;
        ((h[]) this.f9883m.f9869d)[r10] = r8;
        return r8;
    }

    public final void p() {
        int r8 = this.f9875e * 2;
        this.f9875e = r8;
        this.f9877g = (b[]) Arrays.copyOf(this.f9877g, r8);
        c r10 = this.f9883m;
        r10.f9869d = (h[]) Arrays.copyOf((h[]) r10.f9869d, this.f9875e);
        int r11 = this.f9875e;
        this.f9879i = new boolean[r11];
        this.f9876f = r11;
        this.f9882l = r11;
    }

    public final void q() {
        g r8 = this.f9874d;
        if (r8.e() == false) goto L7;
        j();
        return;
    L7:
        if (this.f9878h == false) goto L19;
        boolean r10 = false;
        int r11 = 0;
    L10:
        if (r11 >= this.f9881k) goto L15;
        if (this.f9877g[r11].f9865e == false) goto L16;
        r11 = r11 + 1;
    L16:
        if (r10 == false) goto L19;
        j();
        return;
    L15:
        r10 = true;
    L19:
        r(r8);
    }

    public final void r(g r19) {
        int r8 = 0;
    L3:
        float r10 = 0.0f;
        int r11 = 1;
        if (r8 >= this.f9881k) goto L12;
        b r12 = this.f9877g[r8];
        if (r12.f9861a.f9903s == h.a.f9907a) goto L11;
        if (r12.f9862b >= 0.0f) goto L11;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L50;
        boolean r14 = false;
        int r15 = 0;
    L15:
        if (r14 == true) goto L50;
        r15 = r15 + r11;
        float r16 = Float.MAX_VALUE;
        int r17 = -1;
        int r18 = -1;
        int r20 = 0;
        int r110 = 0;
    L18:
        if (r20 >= this.f9881k) goto L43;
        b r111 = this.f9877g[r20];
        if (r111.f9861a.f9903s == h.a.f9907a) goto L42;
        if (r111.f9865e == true) goto L42;
        if (r111.f9862b >= r10) goto L42;
        int r112 = r111.f9864d.g();
        int r113 = 0;
    L28:
        if (r113 >= r112) goto L42;
        h r114 = r111.f9864d.a(r113);
        float r21 = r111.f9864d.j(r114);
        if (r21 <= r10) goto L41;
        int r22 = 0;
    L34:
        if (r22 >= 9) goto L41;
        float r23 = r114.f9901q[r22] / r21;
        if (r23 >= r16) goto L38;
        if (r22 != r110) goto L38;
    L39:
        r18 = r114.f9896b;
        r110 = r22;
        r16 = r23;
        r17 = r20;
    L40:
        r22 = r22 + 1;
    L38:
        if (r22 <= r110) goto L40;
    L41:
        r113 = r113 + 1;
        r10 = 0.0f;
    L42:
        r20 = r20 + 1;
        r10 = 0.0f;
        goto L18
    L43:
        if (r17 == (-1)) goto L45;
        b r24 = this.f9877g[r17];
        r24.f9861a.f9897m = -1;
        r24.g(((h[]) this.f9883m.f9869d)[r18]);
        h r25 = r24.f9861a;
        r25.f9897m = r17;
        r25.e(this, r24);
    L47:
        if (r15 <= (this.f9880j / 2)) goto L49;
        r14 = true;
    L49:
        r10 = 0.0f;
        r11 = 1;
        goto L15
    L45:
        r14 = true;
    L50:
        s(r19);
        j();
        return;
    L11:
        r8 = r8 + 1;
        goto L3
    L12:
        r13 = false;
        goto L13
    }

    public final void s(b r12) {
        int r8 = 0;
    L4:
        if (r8 >= this.f9880j) goto L6;
        this.f9879i[r8] = false;
        r8 = r8 + 1;
        goto L4
    L6:
        boolean r10 = false;
        int r11 = 0;
    L7:
        if (r10 == true) goto L41;
        r11 = r11 + 1;
        if (r11 >= (this.f9880j * 2)) goto L10;
        h r13 = r12.f9861a;
        if (r13 == null) goto L14;
        this.f9879i[r13.f9896b] = true;
    L14:
        h r14 = r12.a(this.f9879i);
        if (r14 == null) goto L20;
        boolean[] r15 = this.f9879i;
        int r16 = r14.f9896b;
        if (r15[r16] == true) goto L18;
        r15[r16] = true;
        goto L20
    L18:
        return;
    L20:
        if (r14 != null) goto L21;
        r10 = true;
        goto L7
    L21:
        float r17 = Float.MAX_VALUE;
        int r18 = 0;
        int r19 = -1;
    L23:
        if (r18 >= this.f9881k) goto L38;
        b r20 = this.f9877g[r18];
        if (r20.f9861a.f9903s == h.a.f9907a) goto L37;
        if (r20.f9865e == true) goto L37;
        if (r20.f9864d.i(r14) == false) goto L37;
        float r21 = r20.f9864d.j(r14);
        if (r21 >= 0.0f) goto L37;
        float r22 = (-r20.f9862b) / r21;
        if (r22 >= r17) goto L37;
        r19 = r18;
        r17 = r22;
    L37:
        r18 = r18 + 1;
        goto L23
    L38:
        if (r19 <= (-1)) goto L7;
        b r23 = this.f9877g[r19];
        r23.f9861a.f9897m = -1;
        r23.g(r14);
        h r24 = r23.f9861a;
        r24.f9897m = r19;
        r24.e(this, r23);
        goto L7
    L10:
        return;
    }

    public final void t() {
        int r8 = 0;
    L4:
        if (r8 >= this.f9881k) goto L9;
        b r10 = this.f9877g[r8];
        if (r10 == null) goto L8;
        ((f) ((e) this.f9883m.f9867b)).d(r10);
    L8:
        this.f9877g[r8] = null;
        r8 = r8 + 1;
        goto L4
    }

    public final void u() {
        int r8 = 0;
    L3:
        c r10 = this.f9883m;
        h[] r11 = (h[]) r10.f9869d;
        if (r8 >= r11.length) goto L9;
        h r12 = r11[r8];
        if (r12 == null) goto L8;
        r12.c();
    L8:
        r8 = r8 + 1;
        goto L3
    L9:
        e r13 = (e) r10.f9868c;
        h[] r14 = this.f9884n;
        int r15 = this.f9885o;
        f r16 = (f) r13;
        r16.getClass();
        if (r15 <= r14.length) goto L12;
        r15 = r14.length;
    L12:
        int r17 = 0;
    L13:
        if (r17 >= r15) goto L18;
        h r18 = r14[r17];
        int r19 = r16.f9887a;
        Object[] r20 = (Object[]) r16.f9888b;
        if (r19 >= r20.length) goto L17;
        r20[r19] = r18;
        r16.f9887a = r19 + 1;
    L17:
        r17 = r17 + 1;
        goto L13
    L18:
        this.f9885o = 0;
        Arrays.fill((h[]) r10.f9869d, null);
        this.f9873c = 0;
        g r21 = this.f9874d;
        r21.f9891h = 0;
        r21.f9862b = 0.0f;
        this.f9880j = 1;
        int r22 = 0;
    L20:
        if (r22 >= this.f9881k) goto L22;
        b r23 = this.f9877g[r22];
        r22 = r22 + 1;
        goto L20
    L22:
        t();
        this.f9881k = 0;
        this.f9886p = new b(r10);
    }
}
