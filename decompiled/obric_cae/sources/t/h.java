package t;

import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b.a f12181a = null;

    static {
        f12181a = new b.a();
    }

    public static boolean a(s.e r8) {
        s.e.a[] r10 = r8.V;
        s.e.a r11 = r10[0];
        s.e.a r12 = r10[1];
        s.e r13 = r8.W;
        if (r13 == null) goto L5;
        s.f r14 = (s.f) r13;
    L6:
        if (r14 == null) goto L8;
        s.e.a r15 = r14.V[0];
        s.e.a r16 = s.e.a.f11891a;
    L8:
        if (r14 == null) goto L10;
        s.e.a r17 = r14.V[1];
        s.e.a r18 = s.e.a.f11891a;
    L10:
        s.e.a r19 = s.e.a.f11891a;
        if (r11 != r19) goto L13;
    L31:
        boolean r20 = true;
    L32:
        if (r12 != r19) goto L34;
    L52:
        boolean r21 = true;
    L54:
        if (r8.Z <= 0.0f) goto L58;
        if (r20 == true) goto L57;
        if (r21 == false) goto L58;
    L57:
        return true;
    L58:
        if (r20 == false) goto L62;
        if (r21 == true) goto L61;
        return false;
    L61:
        return true;
    L62:
        return false;
    L34:
        if (r8.B() == true) goto L52;
        if (r12 == s.e.a.f11892b) goto L52;
        s.e.a r22 = s.e.a.f11893m;
        if (r12 == r22) goto L40;
    L45:
        if (r12 == r22) goto L47;
    L51:
        r21 = false;
        goto L54
    L47:
        if (r8.f11884t != 1) goto L51;
        if (r8.u(1, r8.l()) == false) goto L51;
    L40:
        if (r8.f11884t != 0) goto L45;
        if (r8.Z != 0.0f) goto L45;
        if (r8.t(1) == true) goto L52;
    L13:
        if (r8.A() == true) goto L31;
        if (r11 == s.e.a.f11892b) goto L31;
        s.e.a r23 = s.e.a.f11893m;
        if (r11 == r23) goto L19;
    L24:
        if (r11 == r23) goto L26;
    L30:
        r20 = false;
        goto L32
    L26:
        if (r8.f11883s != 1) goto L30;
        if (r8.u(0, r8.q()) == false) goto L30;
    L19:
        if (r8.f11883s != 0) goto L24;
        if (r8.Z != 0.0f) goto L24;
        if (r8.t(0) == true) goto L31;
    L5:
        r14 = null;
        goto L6
    }

    public static void b(int r16, s.e r17, b.InterfaceC0157b r18, boolean r19) {
        if (r17.f11873n == false) goto L6;
        return;
    L6:
        if ((r17 instanceof s.f) == false) goto L8;
    L12:
        s.d r8 = r17.j(s.d.a.f11839a);
        s.d r10 = r17.j(s.d.a.f11841m);
        int r11 = r8.d();
        int r12 = r10.d();
        HashSet<s.d> r13 = r8.f11830a;
        char r14 = 0;
        if (r13 == null) goto L77;
        if (r8.f11832c == false) goto L77;
        Iterator<s.d> r15 = r13.iterator();
    L18:
        if (r15.hasNext() == false) goto L77;
        s.d r20 = r15.next();
        s.e r110 = r20.f11833d;
        int r111 = r16 + 1;
        boolean r112 = a(r110);
        if (r110.z() == false) goto L23;
        if (r112 == false) goto L23;
        s.f.U(r110, r18, new b.a());
    L23:
        s.d r113 = r110.K;
        s.d r114 = r110.M;
        if (r20 != r113) goto L29;
        s.d r21 = r114.f11835f;
        if (r21 == null) goto L29;
        if (r21.f11832c == false) goto L29;
    L34:
        char r22 = 1;
    L36:
        s.e.a r23 = r110.V[r14];
        s.e.a r115 = s.e.a.f11893m;
        if (r23 != r115) goto L60;
        if (r112 == true) goto L60;
        if (r23 != r115) goto L75;
        if (r110.f11887w < 0) goto L75;
        if (r110.f11886v < 0) goto L75;
        if (r110.f11866j0 == 8) goto L52;
        if (r110.f11883s != 0) goto L75;
        if (r110.Z != 0.0f) goto L75;
    L52:
        if (r110.x() == true) goto L75;
        if (r110.H == true) goto L75;
        if (r22 == 0) goto L75;
        if (r110.x() == true) goto L75;
        d(r111, r17, r18, r110, r19);
    L75:
        r14 = 0;
    L60:
        if (r110.z() == true) goto L75;
        if (r20 == r113) goto L64;
    L66:
        if (r20 == r114) goto L68;
    L71:
        if (r22 == 0) goto L75;
        if (r110.x() == true) goto L75;
        c(r111, r110, r18, r19);
        goto L75
    L68:
        if (r113.f11835f != null) goto L71;
        int r24 = r11 - r114.e();
        r110.I(r24 - r110.q(), r24);
    L70:
        b(r111, r110, r18, r19);
        goto L75
    L64:
        if (r114.f11835f != null) goto L66;
        int r25 = r113.e() + r11;
        r110.I(r25, r110.q() + r25);
    L29:
        if (r20 != r114) goto L35;
        s.d r26 = r113.f11835f;
        if (r26 == null) goto L35;
        if (r26.f11832c == true) goto L34;
    L35:
        r22 = r14;
    L77:
        if ((r17 instanceof s.h) == false) goto L79;
        return;
    L79:
        HashSet<s.d> r27 = r10.f11830a;
        if (r27 != null) goto L82;
    L146:
        r17.f11873n = true;
        return;
    L82:
        if (r10.f11832c == false) goto L146;
        Iterator<s.d> r28 = r27.iterator();
    L85:
        if (r28.hasNext() == false) goto L146;
        s.d r29 = r28.next();
        s.e r30 = r29.f11833d;
        int r31 = r16 + 1;
        boolean r32 = a(r30);
        if (r30.z() == false) goto L90;
        if (r32 == false) goto L90;
        s.f.U(r30, r18, new b.a());
    L90:
        s.d r33 = r30.K;
        s.d r116 = r30.M;
        if (r29 != r33) goto L96;
        s.d r117 = r116.f11835f;
        if (r117 == null) goto L96;
        if (r117.f11832c == false) goto L96;
    L101:
        boolean r118 = true;
    L103:
        s.e.a r119 = r30.V[0];
        s.e.a r120 = s.e.a.f11893m;
        if (r119 != r120) goto L131;
        if (r32 == true) goto L131;
        if (r119 != r120) goto L85;
        if (r30.f11887w < 0) goto L85;
        if (r30.f11886v < 0) goto L85;
        if (r30.f11866j0 == 8) goto L121;
        if (r30.f11883s != 0) goto L85;
        if (r30.Z != 0.0f) goto L85;
    L121:
        if (r30.x() == true) goto L85;
        if (r30.H == true) goto L85;
        if (r118 == false) goto L85;
        if (r30.x() == true) goto L85;
        d(r31, r17, r18, r30, r19);
    L131:
        if (r30.z() == true) goto L85;
        if (r29 == r33) goto L135;
    L137:
        if (r29 != r116) goto L142;
        if (r33.f11835f != null) goto L142;
        int r34 = r12 - r116.e();
        r30.I(r34 - r30.q(), r34);
    L141:
        b(r31, r30, r18, r19);
    L142:
        if (r118 == false) goto L85;
        if (r30.x() == true) goto L85;
        c(r31, r30, r18, r19);
        goto L85
    L135:
        if (r116.f11835f != null) goto L137;
        int r35 = r33.e() + r12;
        r30.I(r35, r30.q() + r35);
    L96:
        if (r29 != r116) goto L102;
        s.d r121 = r33.f11835f;
        if (r121 == null) goto L102;
        if (r121.f11832c == true) goto L101;
    L102:
        r118 = false;
        goto L103
    L8:
        if (r17.z() == false) goto L12;
        if (a(r17) == false) goto L12;
        s.f.U(r17, r18, new b.a());
        goto L12
    }

    public static void c(int r8, s.e r10, b.InterfaceC0157b r11, boolean r12) {
        float r13 = r10.f11860g0;
        s.d r14 = r10.K;
        int r15 = r14.f11835f.d();
        s.d r16 = r10.M;
        int r17 = r16.f11835f.d();
        int r18 = r14.e() + r15;
        int r19 = r17 - r16.e();
        if (r15 != r17) goto L5;
        r13 = 0.5f;
    L6:
        int r20 = r10.q();
        int r21 = (r17 - r15) - r20;
        if (r15 <= r17) goto L9;
        r21 = (r15 - r17) - r20;
    L9:
        if (r21 <= 0) goto L11;
        float r22 = (r13 * r21) + 0.5f;
    L12:
        int r23 = ((int) r22) + r15;
        int r24 = r23 + r20;
        if (r15 <= r17) goto L15;
        r24 = r23 - r20;
    L15:
        r10.I(r23, r24);
        b(r8 + 1, r10, r11, r12);
        return;
    L11:
        r22 = r13 * r21;
        goto L12
    L5:
        r15 = r18;
        r17 = r19;
        goto L6
    }

    public static void d(int r8, s.e r10, b.InterfaceC0157b r11, s.e r12, boolean r13) {
        float r14 = r12.f11860g0;
        s.d r15 = r12.K;
        int r16 = r15.e() + r15.f11835f.d();
        s.d r17 = r12.M;
        int r18 = r17.f11835f.d() - r17.e();
        if (r18 < r16) goto L20;
        int r19 = r12.q();
        if (r12.f11866j0 == 8) goto L18;
        int r20 = r12.f11883s;
        if (r20 == 2) goto L9;
        if (r20 != 0) goto L15;
        r19 = r18 - r16;
    L15:
        r19 = Math.max(r12.f11886v, r19);
        int r21 = r12.f11887w;
        if (r21 <= 0) goto L18;
        r19 = Math.min(r21, r19);
        goto L18
    L9:
        if ((r10 instanceof s.f) == true) goto L12;
        r10 = r10.W;
    L12:
        r19 = (int) ((r12.f11860g0 * 0.5f) * r10.q());
    L18:
        int r22 = r16 + ((int) ((r14 * ((r18 - r16) - r19)) + 0.5f));
        r12.I(r22, r19 + r22);
        b(r8 + 1, r12, r11, r13);
        return;
    }

    public static void e(int r8, s.e r10, b.InterfaceC0157b r11) {
        float r12 = r10.f11862h0;
        s.d r13 = r10.L;
        int r14 = r13.f11835f.d();
        s.d r15 = r10.N;
        int r16 = r15.f11835f.d();
        int r17 = r13.e() + r14;
        int r18 = r16 - r15.e();
        if (r14 != r16) goto L5;
        r12 = 0.5f;
    L6:
        int r19 = r10.l();
        int r20 = (r16 - r14) - r19;
        if (r14 <= r16) goto L9;
        r20 = (r14 - r16) - r19;
    L9:
        if (r20 <= 0) goto L11;
        float r21 = (r12 * r20) + 0.5f;
    L12:
        int r22 = (int) r21;
        int r23 = r14 + r22;
        int r24 = r23 + r19;
        if (r14 <= r16) goto L15;
        r23 = r14 - r22;
        r24 = r23 - r19;
    L15:
        r10.J(r23, r24);
        g(r8 + 1, r10, r11);
        return;
    L11:
        r21 = r12 * r20;
        goto L12
    L5:
        r14 = r17;
        r16 = r18;
        goto L6
    }

    public static void f(int r8, s.e r10, b.InterfaceC0157b r11, s.e r12) {
        float r13 = r12.f11862h0;
        s.d r14 = r12.L;
        int r15 = r14.e() + r14.f11835f.d();
        s.d r16 = r12.N;
        int r17 = r16.f11835f.d() - r16.e();
        if (r17 < r15) goto L20;
        int r18 = r12.l();
        if (r12.f11866j0 == 8) goto L18;
        int r19 = r12.f11884t;
        if (r19 == 2) goto L9;
        if (r19 != 0) goto L15;
        r18 = r17 - r15;
    L15:
        r18 = Math.max(r12.f11889y, r18);
        int r20 = r12.f11890z;
        if (r20 <= 0) goto L18;
        r18 = Math.min(r20, r18);
        goto L18
    L9:
        if ((r10 instanceof s.f) == true) goto L12;
        r10 = r10.W;
    L12:
        r18 = (int) ((r13 * 0.5f) * r10.l());
    L18:
        int r21 = r15 + ((int) ((r13 * ((r17 - r15) - r18)) + 0.5f));
        r12.J(r21, r18 + r21);
        g(r8 + 1, r12, r11);
        return;
    }

    public static void g(int r16, s.e r17, b.InterfaceC0157b r18) {
        if (r17.f11875o == false) goto L6;
        return;
    L6:
        if ((r17 instanceof s.f) == false) goto L8;
    L12:
        s.d r8 = r17.j(s.d.a.f11840b);
        s.d r10 = r17.j(s.d.a.f11842n);
        int r11 = r8.d();
        int r12 = r10.d();
        HashSet<s.d> r13 = r8.f11830a;
        char r14 = 1;
        if (r13 == null) goto L77;
        if (r8.f11832c == false) goto L77;
        Iterator<s.d> r15 = r13.iterator();
    L18:
        if (r15.hasNext() == false) goto L77;
        s.d r19 = r15.next();
        s.e r110 = r19.f11833d;
        int r111 = r16 + 1;
        boolean r112 = a(r110);
        if (r110.z() == false) goto L23;
        if (r112 == false) goto L23;
        s.f.U(r110, r18, new b.a());
    L23:
        s.d r113 = r110.L;
        s.d r114 = r110.N;
        if (r19 != r113) goto L29;
        s.d r20 = r114.f11835f;
        if (r20 == null) goto L29;
        if (r20.f11832c == false) goto L29;
    L34:
        char r21 = r14;
    L36:
        s.e.a r22 = r110.V[r14];
        s.e.a r23 = s.e.a.f11893m;
        if (r22 != r23) goto L60;
        if (r112 == true) goto L60;
        if (r22 != r23) goto L75;
        if (r110.f11890z < 0) goto L75;
        if (r110.f11889y < 0) goto L75;
        if (r110.f11866j0 == 8) goto L52;
        if (r110.f11884t != 0) goto L75;
        if (r110.Z != 0.0f) goto L75;
    L52:
        if (r110.y() == true) goto L75;
        if (r110.H == true) goto L75;
        if (r21 == 0) goto L75;
        if (r110.y() == true) goto L75;
        f(r111, r17, r18, r110);
    L75:
        r14 = 1;
    L60:
        if (r110.z() == true) goto L75;
        if (r19 == r113) goto L64;
    L66:
        if (r19 == r114) goto L68;
    L71:
        if (r21 == 0) goto L75;
        if (r110.y() == true) goto L75;
        e(r111, r110, r18);
        goto L75
    L68:
        if (r113.f11835f != null) goto L71;
        int r24 = r11 - r114.e();
        r110.J(r24 - r110.l(), r24);
    L70:
        g(r111, r110, r18);
        goto L75
    L64:
        if (r114.f11835f != null) goto L66;
        int r25 = r113.e() + r11;
        r110.J(r25, r110.l() + r25);
    L29:
        if (r19 != r114) goto L35;
        s.d r26 = r113.f11835f;
        if (r26 == null) goto L35;
        if (r26.f11832c == true) goto L34;
    L35:
        r21 = 0;
    L77:
        if ((r17 instanceof s.h) == false) goto L79;
        return;
    L79:
        HashSet<s.d> r27 = r10.f11830a;
        if (r27 != null) goto L82;
    L145:
        s.d r28 = r17.j(s.d.a.f11843o);
        if (r28.f11830a != null) goto L148;
    L169:
        r17.f11875o = true;
        return;
    L148:
        if (r28.f11832c == false) goto L169;
        int r29 = r28.d();
        Iterator<s.d> r30 = r28.f11830a.iterator();
    L151:
        if (r30.hasNext() == false) goto L169;
        s.d r31 = r30.next();
        s.e r32 = r31.f11833d;
        int r33 = r16 + 1;
        boolean r34 = a(r32);
        if (r32.z() == false) goto L157;
        if (r34 == false) goto L157;
        s.f.U(r32, r18, new b.a());
    L157:
        if (r32.V[1] != s.e.a.f11893m) goto L160;
        if (r34 == false) goto L151;
    L160:
        if (r32.z() == true) goto L151;
        s.d r35 = r32.O;
        if (r31 != r35) goto L151;
        int r36 = r31.e() + r29;
        if (r32.F == false) goto L168;
        int r37 = r36 - r32.d0;
        int r38 = r32.Y + r37;
        r32.f11853c0 = r37;
        r32.L.l(r37);
        r32.N.l(r38);
        r35.l(r36);
        r32.f11871m = true;
    L168:
        g(r33, r32, r18);
        goto L151
    L82:
        if (r10.f11832c == false) goto L145;
        Iterator<s.d> r39 = r27.iterator();
    L85:
        if (r39.hasNext() == false) goto L145;
        s.d r40 = r39.next();
        s.e r41 = r40.f11833d;
        int r42 = r16 + 1;
        boolean r43 = a(r41);
        if (r41.z() == false) goto L90;
        if (r43 == false) goto L90;
        s.f.U(r41, r18, new b.a());
    L90:
        s.d r44 = r41.L;
        s.d r45 = r41.N;
        if (r40 != r44) goto L96;
        s.d r115 = r45.f11835f;
        if (r115 == null) goto L96;
        if (r115.f11832c == false) goto L96;
    L101:
        boolean r116 = true;
    L103:
        s.e.a r117 = r41.V[1];
        s.e.a r118 = s.e.a.f11893m;
        if (r117 != r118) goto L130;
        if (r43 == true) goto L130;
        if (r117 != r118) goto L85;
        if (r41.f11890z < 0) goto L85;
        if (r41.f11889y < 0) goto L85;
        if (r41.f11866j0 == 8) goto L121;
        if (r41.f11884t != 0) goto L85;
        if (r41.Z != 0.0f) goto L85;
    L121:
        if (r41.y() == true) goto L85;
        if (r41.H == true) goto L85;
        if (r116 == false) goto L85;
        if (r41.y() == true) goto L85;
        f(r42, r17, r18, r41);
    L130:
        if (r41.z() == true) goto L85;
        if (r40 == r44) goto L134;
    L136:
        if (r40 != r45) goto L141;
        if (r44.f11835f != null) goto L141;
        int r46 = r12 - r45.e();
        r41.J(r46 - r41.l(), r46);
    L140:
        g(r42, r41, r18);
    L141:
        if (r116 == false) goto L85;
        if (r41.y() == true) goto L85;
        e(r42, r41, r18);
        goto L85
    L134:
        if (r45.f11835f != null) goto L136;
        int r47 = r44.e() + r12;
        r41.J(r47, r41.l() + r47);
    L96:
        if (r40 != r45) goto L102;
        s.d r119 = r44.f11835f;
        if (r119 == null) goto L102;
        if (r119.f11832c == true) goto L101;
    L102:
        r116 = false;
        goto L103
    L8:
        if (r17.z() == false) goto L12;
        if (a(r17) == false) goto L12;
        s.f.U(r17, r18, new b.a());
        goto L12
    }
}
