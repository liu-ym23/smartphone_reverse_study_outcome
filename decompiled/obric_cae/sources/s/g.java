package s;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class g extends l {
    public int F0;
    public int G0;
    public int H0;
    public int I0;
    public int J0;
    public int K0;
    public float L0;
    public float M0;
    public float N0;
    public float O0;
    public float P0;
    public float Q0;
    public int R0;
    public int S0;
    public int T0;
    public int U0;
    public int V0;
    public int W0;
    public int X0;
    public final ArrayList<a> Y0;
    public e[] Z0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public e[] f11903a1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public int[] f11904b1;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public e[] f11905c1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public int f11906d1;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e f11908b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f11909c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public d f11910d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d f11911e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public d f11912f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public d f11913g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f11914h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f11915i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f11916j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f11917k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f11918l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f11919m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f11920n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f11921o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f11922p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f11923q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ g f11924r;

        public a(g r8, int r10, d r11, d r12, d r13, d r14, int r15) {
            this.f11924r = r8;
            this.f11908b = null;
            this.f11909c = 0;
            this.f11914h = 0;
            this.f11915i = 0;
            this.f11916j = 0;
            this.f11917k = 0;
            this.f11918l = 0;
            this.f11919m = 0;
            this.f11920n = 0;
            this.f11921o = 0;
            this.f11922p = 0;
            this.f11923q = 0;
            this.f11907a = r10;
            this.f11910d = r11;
            this.f11911e = r12;
            this.f11912f = r13;
            this.f11913g = r14;
            this.f11914h = r8.f11938y0;
            this.f11915i = r8.f11934u0;
            this.f11916j = r8.f11939z0;
            this.f11917k = r8.f11935v0;
            this.f11923q = r15;
        }

        public final void a(e r10) {
            int r8 = this.f11907a;
            int r11 = 0;
            g r12 = this.f11924r;
            if (r8 != 0) goto L16;
            int r13 = r12.U(this.f11923q, r10);
            if (r10.V[0] != e.a.f11893m) goto L7;
            this.f11922p++;
            r13 = 0;
        L7:
            int r14 = r12.R0;
            if (r10.f11866j0 == 8) goto L11;
            r11 = r14;
        L11:
            this.f11918l = (r13 + r11) + this.f11918l;
            int r15 = r12.T(this.f11923q, r10);
            if (this.f11908b != null) goto L14;
        L15:
            this.f11908b = r10;
            this.f11909c = r15;
            this.f11919m = r15;
        L28:
            this.f11921o++;
            return;
        L14:
            if (this.f11909c >= r15) goto L28;
        L16:
            int r16 = r12.U(this.f11923q, r10);
            int r17 = r12.T(this.f11923q, r10);
            if (r10.V[1] != e.a.f11893m) goto L19;
            this.f11922p++;
            r17 = 0;
        L19:
            int r18 = r12.S0;
            if (r10.f11866j0 == 8) goto L23;
            r11 = r18;
        L23:
            this.f11919m = (r17 + r11) + this.f11919m;
            if (this.f11908b != null) goto L26;
        L27:
            this.f11908b = r10;
            this.f11909c = r16;
            this.f11918l = r16;
            goto L28
        L26:
            if (this.f11909c >= r16) goto L28;
            goto L27
        }

        public final void b(int r21, boolean r22, boolean r23) {
            int r8 = this.f11921o;
            int r10 = 0;
        L3:
            g r11 = this.f11924r;
            if (r10 >= r8) goto L12;
            int r12 = this.f11920n + r10;
            if (r12 >= r11.f11906d1) goto L12;
            e r13 = r11.f11905c1[r12];
            if (r13 == null) goto L11;
            r13.D();
        L11:
            r10 = r10 + 1;
        L12:
            if (r8 != 0) goto L14;
            return;
        L14:
            if (this.f11908b == null) goto L240;
            if (r23 == false) goto L19;
            if (r21 != 0) goto L19;
            boolean r14 = true;
        L20:
            int r15 = 0;
            int r16 = -1;
            int r17 = -1;
        L21:
            if (r15 >= r8) goto L37;
            if (r22 == false) goto L24;
            int r18 = (r8 - 1) - r15;
        L25:
            int r19 = this.f11920n + r18;
            if (r19 >= r11.f11906d1) goto L37;
            e r110 = r11.f11905c1[r19];
            if (r110 == null) goto L35;
            if (r110.f11866j0 != 0) goto L35;
            if (r16 != (-1)) goto L34;
            r16 = r15;
        L34:
            r17 = r15;
        L35:
            r15 = r15 + 1;
            goto L21
        L24:
            r18 = r15;
        L37:
            if (this.f11907a != 0) goto L136;
            e r20 = this.f11908b;
            r20.f11872m0 = r11.G0;
            int r111 = this.f11915i;
            if (r21 <= 0) goto L41;
            r111 = r111 + r11.S0;
        L41:
            d r112 = this.f11911e;
            d r113 = r20.L;
            r113.a(r112, r111);
            d r114 = r20.N;
            if (r23 == false) goto L44;
            r114.a(this.f11913g, this.f11917k);
        L44:
            if (r21 <= 0) goto L47;
            this.f11911e.f11833d.N.a(r113, 0);
        L47:
            if (r11.U0 == 3) goto L49;
        L62:
            e r115 = r20;
        L63:
            int r116 = 0;
            e r117 = null;
        L64:
            if (r116 >= r8) goto L241;
            if (r22 == false) goto L67;
            int r118 = (r8 - 1) - r116;
        L68:
            int r119 = this.f11920n + r118;
            if (r119 >= r11.f11906d1) goto L242;
            e r24 = r11.f11905c1[r119];
            if (r24 != null) goto L74;
            r8 = r8;
            char r25 = 3;
        L135:
            r116 = r116 + 1;
            r8 = r8;
            goto L64
        L74:
            d r120 = r24.K;
            if (r116 != 0) goto L77;
            r24.g(r120, this.f11910d, this.f11914h);
        L77:
            if (r118 != 0) goto L100;
            int r26 = r11.F0;
            if (r22 == false) goto L81;
            float r27 = 1.0f - r11.L0;
        L83:
            if (this.f11920n != 0) goto L91;
            int r28 = r11.H0;
            if (r28 == (-1)) goto L91;
            if (r22 == false) goto L88;
            float r29 = 1.0f - r11.N0;
        L89:
            float r30 = r29;
            int r31 = r28;
        L98:
            r24.f11870l0 = r31;
            r24.f11860g0 = r30;
            goto L100
        L88:
            r29 = r11.N0;
        L91:
            if (r23 == false) goto L97;
            r31 = r11.J0;
            if (r31 == (-1)) goto L97;
            if (r22 == false) goto L96;
            r30 = 1.0f - r11.P0;
            goto L98
        L96:
            r30 = r11.P0;
        L97:
            r31 = r26;
            r30 = r27;
            goto L98
        L81:
            r27 = r11.L0;
        L100:
            if (r116 != (r8 - 1)) goto L103;
            r24.g(r24.M, this.f11912f, this.f11916j);
        L103:
            if (r117 == null) goto L114;
            int r32 = r11.R0;
            d r33 = r117.M;
            r120.a(r33, r32);
            if (r116 != r16) goto L109;
            int r34 = this.f11914h;
            if (r120.h() == false) goto L109;
            r120.f11837h = r34;
        L109:
            r33.a(r120, 0);
            if (r116 != (r17 + 1)) goto L114;
            int r35 = this.f11916j;
            if (r33.h() == false) goto L114;
            r33.f11837h = r35;
        L114:
            if (r24 == r20) goto L134;
            int r36 = r11.U0;
            r25 = 3;
            if (r36 == 3) goto L118;
        L123:
            d r37 = r24.L;
            if (r36 == 0) goto L132;
            d r121 = r24.N;
            if (r36 == 1) goto L130;
            if (r14 == false) goto L129;
            r37.a(this.f11911e, this.f11915i);
            r121.a(this.f11913g, this.f11917k);
        L133:
            r117 = r24;
            goto L135
        L129:
            int r38 = 0;
            r37.a(r113, 0);
        L131:
            r121.a(r114, r38);
            goto L133
        L130:
            r38 = 0;
            goto L131
        L132:
            r37.a(r113, 0);
            goto L133
        L118:
            if (r115.F == false) goto L123;
            if (r24 == r115) goto L123;
            if (r24.F == false) goto L123;
            r24.O.a(r115.O, 0);
            goto L133
        L134:
            r25 = 3;
            goto L133
        L242:
            return;
        L67:
            r118 = r116;
            goto L68
        L241:
            return;
        L49:
            if (r20.F == true) goto L62;
            int r122 = 0;
        L51:
            if (r122 >= r8) goto L62;
            if (r22 == false) goto L54;
            int r123 = (r8 - 1) - r122;
        L55:
            int r124 = this.f11920n + r123;
            if (r124 >= r11.f11906d1) goto L62;
            r115 = r11.f11905c1[r124];
            if (r115.F == true) goto L63;
            r122 = r122 + 1;
            goto L51
        L54:
            r123 = r122;
            goto L55
        L136:
            e r39 = this.f11908b;
            r39.f11870l0 = r11.F0;
            int r40 = this.f11914h;
            if (r21 <= 0) goto L139;
            r40 = r40 + r11.R0;
        L139:
            d r41 = r39.M;
            d r42 = r39.K;
            if (r22 == false) goto L146;
            r41.a(this.f11912f, r40);
            if (r23 == false) goto L144;
            r42.a(this.f11910d, this.f11916j);
        L144:
            if (r21 <= 0) goto L151;
            this.f11912f.f11833d.K.a(r41, 0);
        L151:
            int r43 = 0;
            e r125 = null;
        L152:
            if (r43 >= r8) goto L243;
            int r126 = this.f11920n + r43;
            if (r126 >= r11.f11906d1) goto L244;
            e r127 = r11.f11905c1[r126];
            if (r127 != null) goto L159;
            r127 = r125;
        L216:
            r43 = r43 + 1;
            r125 = r127;
            goto L152
        L159:
            d r128 = r127.L;
            if (r43 != 0) goto L175;
            r127.g(r128, this.f11911e, this.f11915i);
            int r129 = r11.G0;
            float r130 = r11.M0;
            if (this.f11920n != 0) goto L166;
            int r131 = r11.I0;
            int r132 = -1;
            if (r131 == (-1)) goto L167;
            r130 = r11.O0;
        L172:
            r127.f11872m0 = r131;
            r127.f11862h0 = r130;
        L167:
            if (r23 == false) goto L171;
            r131 = r11.K0;
            if (r131 == r132) goto L171;
            r130 = r11.Q0;
        L171:
            r131 = r129;
            goto L172
        L166:
            r132 = -1;
        L175:
            if (r43 != (r8 - 1)) goto L177;
            r127.g(r127.N, this.f11913g, this.f11917k);
        L177:
            if (r125 == null) goto L188;
            int r133 = r11.S0;
            d r134 = r125.N;
            r128.a(r134, r133);
            if (r43 != r16) goto L183;
            int r135 = this.f11915i;
            if (r128.h() == false) goto L183;
            r128.f11837h = r135;
        L183:
            r134.a(r128, 0);
            if (r43 != (r17 + 1)) goto L188;
            int r136 = this.f11917k;
            if (r134.h() == false) goto L188;
            r134.f11837h = r136;
        L188:
            if (r127 == r39) goto L216;
            d r137 = r127.M;
            d r138 = r127.K;
            if (r22 == false) goto L201;
            int r139 = r11.T0;
            if (r139 != 0) goto L194;
            int r140 = 0;
        L200:
            r137.a(r41, r140);
            goto L216
        L194:
            if (r139 == 1) goto L198;
            if (r139 != 2) goto L216;
            r140 = 0;
            r138.a(r42, 0);
            goto L200
        L198:
            r138.a(r42, 0);
            goto L216
        L201:
            int r141 = r11.T0;
            if (r141 != 0) goto L204;
            r138.a(r42, 0);
            goto L216
        L204:
            if (r141 == 1) goto L211;
            if (r141 != 2) goto L216;
            if (r14 == false) goto L210;
            r138.a(this.f11910d, this.f11914h);
            r137.a(this.f11912f, this.f11916j);
            goto L216
        L210:
            int r142 = 0;
            r138.a(r42, 0);
        L212:
            r137.a(r41, r142);
            goto L216
        L211:
            r142 = 0;
            goto L212
        L244:
            return;
        L243:
            return;
        L146:
            r42.a(this.f11910d, r40);
            if (r23 == false) goto L149;
            r41.a(this.f11912f, this.f11916j);
        L149:
            if (r21 <= 0) goto L151;
            this.f11910d.f11833d.M.a(r42, 0);
        L19:
            r14 = false;
            goto L20
        }

        public final int c() {
            if (this.f11907a != 1) goto L7;
            return this.f11919m - this.f11924r.S0;
        L7:
            return this.f11919m;
        }

        public final int d() {
            if (this.f11907a != 0) goto L7;
            return this.f11918l - this.f11924r.R0;
        L7:
            return this.f11918l;
        }

        public final void e(int r11) {
            int r8 = this.f11922p;
            if (r8 != 0) goto L5;
            return;
        L5:
            int r10 = this.f11921o;
            int r12 = r11 / r8;
            int r13 = 0;
        L6:
            if (r13 >= r10) goto L26;
            int r14 = this.f11920n;
            int r15 = r14 + r13;
            g r16 = this.f11924r;
            if (r15 >= r16.f11906d1) goto L26;
            e r17 = r16.f11905c1[r14 + r13];
            if (this.f11907a != 0) goto L18;
            if (r17 == null) goto L25;
            e.a[] r18 = r17.V;
            if (r18[0] != e.a.f11893m) goto L25;
            if (r17.f11883s != 0) goto L25;
            e.a r19 = e.a.f11891a;
            e.a r20 = r19;
            int r21 = r12;
            e.a r22 = r18[1];
            int r23 = r17.l();
        L24:
            r16.S(r17, r20, r21, r22, r23);
        L25:
            r13 = r13 + 1;
            goto L6
        L18:
            if (r17 == null) goto L25;
            e.a[] r24 = r17.V;
            if (r24[1] != e.a.f11893m) goto L25;
            if (r17.f11884t != 0) goto L25;
            e.a r25 = r24[0];
            r20 = r25;
            r21 = r17.q();
            r22 = e.a.f11891a;
            r23 = r12;
        L26:
            this.f11918l = 0;
            this.f11919m = 0;
            this.f11908b = null;
            this.f11909c = 0;
            int r110 = this.f11921o;
            int r26 = 0;
        L27:
            if (r26 >= r110) goto L50;
            int r27 = this.f11920n + r26;
            g r28 = this.f11924r;
            if (r27 >= r28.f11906d1) goto L66;
            e r29 = r28.f11905c1[r27];
            if (this.f11907a != 0) goto L41;
            int r30 = r29.q();
            int r31 = r28.R0;
            if (r29.f11866j0 != 8) goto L36;
            r31 = 0;
        L36:
            this.f11918l = (r30 + r31) + this.f11918l;
            int r32 = r28.T(this.f11923q, r29);
            if (this.f11908b != null) goto L39;
        L40:
            this.f11908b = r29;
            this.f11909c = r32;
            this.f11919m = r32;
        L49:
            r26 = r26 + 1;
            goto L27
        L39:
            if (this.f11909c >= r32) goto L49;
        L41:
            int r33 = r28.U(this.f11923q, r29);
            int r34 = r28.T(this.f11923q, r29);
            int r35 = r28.S0;
            if (r29.f11866j0 != 8) goto L44;
            r35 = 0;
        L44:
            this.f11919m = (r34 + r35) + this.f11919m;
            if (this.f11908b != null) goto L47;
        L48:
            this.f11908b = r29;
            this.f11909c = r33;
            this.f11918l = r33;
            goto L49
        L47:
            if (this.f11909c >= r33) goto L49;
        L66:
            return;
        }

        public final void f(int r8, d r10, d r11, d r12, d r13, int r14, int r15, int r16, int r17, int r18) {
            this.f11907a = r8;
            this.f11910d = r10;
            this.f11911e = r11;
            this.f11912f = r12;
            this.f11913g = r13;
            this.f11914h = r14;
            this.f11915i = r15;
            this.f11916j = r16;
            this.f11917k = r17;
            this.f11923q = r18;
        }
    }

    public g() {
        this.F0 = -1;
        this.G0 = -1;
        this.H0 = -1;
        this.I0 = -1;
        this.J0 = -1;
        this.K0 = -1;
        this.L0 = 0.5f;
        this.M0 = 0.5f;
        this.N0 = 0.5f;
        this.O0 = 0.5f;
        this.P0 = 0.5f;
        this.Q0 = 0.5f;
        this.R0 = 0;
        this.S0 = 0;
        this.T0 = 2;
        this.U0 = 2;
        this.V0 = 0;
        this.W0 = -1;
        this.X0 = 0;
        this.Y0 = new ArrayList();
        this.Z0 = null;
        this.f11903a1 = null;
        this.f11904b1 = null;
        this.f11906d1 = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:291:0x0505 -> B:292:0x0512). Please report as a decompilation issue!!! */
    @Override // s.l
    public final void R(int r38, int r39, int r40, int r41) {
        g r8 = this;
        if (r8.f11932t0 <= 0) goto L44;
        e r10 = r8.W;
        if (r10 == null) goto L7;
        t.b.InterfaceC0157b r11 = ((f) r10).f11899w0;
    L8:
        if (r11 != null) goto L10;
        boolean r12 = false;
    L41:
        if (r12 == true) goto L44;
        r8.B0 = 0;
        r8.C0 = 0;
        r8.A0 = false;
        return;
    L10:
        int r13 = 0;
    L12:
        if (r13 >= r8.f11932t0) goto L40;
        e r14 = r8.f11931s0[r13];
        if (r14 == null) goto L39;
        if ((r14 instanceof h) == true) goto L39;
        e.a r15 = r14.k(0);
        e.a r16 = r14.k(1);
        e.a r17 = e.a.f11893m;
        if (r15 == r17) goto L22;
    L27:
        boolean r18 = false;
    L28:
        if (r18 == true) goto L39;
        if (r15 != r17) goto L32;
        r15 = e.a.f11892b;
    L32:
        if (r16 != r17) goto L34;
        r16 = e.a.f11892b;
    L34:
        t.b.a r19 = r8.D0;
        r19.f12139a = r15;
        r19.f12140b = r16;
        r19.f12141c = r14.q();
        r19.f12142d = r14.l();
        ((ConstraintLayout.b) r11).b(r14, r19);
        r14.N(r19.f12143e);
        r14.K(r19.f12144f);
        int r20 = r19.f12145g;
        r14.d0 = r20;
        if (r20 <= 0) goto L37;
        boolean r21 = true;
    L38:
        r14.F = r21;
        goto L39
    L37:
        r21 = false;
        goto L38
    L22:
        if (r14.f11883s == 1) goto L27;
        if (r16 != r17) goto L27;
        if (r14.f11884t == 1) goto L27;
        r18 = true;
    L39:
        r13 = r13 + 1;
        goto L12
    L40:
        r12 = true;
        goto L41
    L7:
        r11 = null;
    L44:
        int r110 = r8.f11938y0;
        int r111 = r8.f11939z0;
        int r112 = r8.f11934u0;
        int r113 = r8.f11935v0;
        int[] r114 = new int[2];
        int r22 = (r39 - r110) - r111;
        int r23 = r8.X0;
        if (r23 != 1) goto L47;
        r22 = (r41 - r112) - r113;
    L47:
        int r24 = r22;
        if (r23 != 0) goto L56;
        if (r8.F0 != (-1)) goto L53;
        r8.F0 = 0;
    L53:
        if (r8.G0 == (-1)) goto L60;
    L61:
        e[] r25 = r8.f11931s0;
        int r26 = 0;
        int r27 = 0;
    L62:
        int r28 = r8.f11932t0;
        if (r26 >= r28) goto L68;
        if (r8.f11931s0[r26].f11866j0 != 8) goto L67;
        r27 = r27 + 1;
    L67:
        r26 = r26 + 1;
        goto L62
    L68:
        if (r27 <= 0) goto L76;
        r25 = new e[r28 - r27];
        int r29 = 0;
        r28 = 0;
    L71:
        if (r29 >= r8.f11932t0) goto L76;
        e r30 = r8.f11931s0[r29];
        if (r30.f11866j0 == 8) goto L75;
        r25[r28] = r30;
        r28 = r28 + 1;
    L75:
        r29 = r29 + 1;
    L76:
        e[] r31 = r25;
        r8.f11905c1 = r31;
        r8.f11906d1 = r28;
        int r32 = r8.V0;
        ArrayList<a> r33 = r8.Y0;
        if (r32 == 0) goto L391;
        d r34 = r8.L;
        d r35 = r8.K;
        d r36 = r8.M;
        d r37 = r8.N;
        e.a[] r42 = r8.V;
        if (r32 != 1) goto L81;
        int r115 = r28;
        int r210 = r110;
        int r310 = r111;
        int r311 = r112;
        int r312 = r113;
        int[] r313 = r114;
        ArrayList<a> r116 = r33;
        int r117 = r8.X0;
        if (r115 == 0) goto L393;
        r116.clear();
        a r118 = new a(this, r117, r8.K, r8.L, r8.M, r8.N, r24);
        r116.add(r118);
        if (r117 != 0) goto L327;
        int r43 = 0;
        int r44 = 0;
        int r119 = 0;
    L300:
        if (r119 >= r115) goto L326;
        e r45 = r31[r119];
        int r120 = r8.U(r24, r45);
        if (r45.V[0] != e.a.f11893m) goto L304;
        r43 = r43 + 1;
    L304:
        int r121 = r43;
        if (r44 == r24) goto L309;
        if (((r8.R0 + r44) + r120) > r24) goto L309;
    L311:
        boolean r46 = false;
    L312:
        if (r46 == true) goto L319;
        if (r119 <= 0) goto L319;
        int r47 = r8.W0;
        if (r47 <= 0) goto L319;
        if ((r119 % r47) != 0) goto L319;
        r46 = true;
    L319:
        if (r46 == false) goto L321;
        e.a[] r211 = r42;
        e r48 = r45;
        r118 = new a(this, r117, r8.K, r8.L, r8.M, r8.N, r24);
        r118.f11920n = r119;
        r116.add(r118);
    L324:
        r44 = r120;
    L325:
        r118.a(r48);
        r119 = r119 + 1;
        r43 = r121;
        r42 = r211;
        goto L300
    L321:
        r211 = r42;
        r48 = r45;
        if (r119 <= 0) goto L324;
        r44 = (r8.R0 + r120) + r44;
    L309:
        if (r118.f11908b == null) goto L311;
        r46 = true;
        goto L312
    L326:
        e.a[] r212 = r42;
    L353:
        int r49 = r116.size();
        int r50 = r8.f11938y0;
        int r51 = r8.f11934u0;
        int r52 = r8.f11939z0;
        int r53 = r8.f11935v0;
        e.a r54 = r212[0];
        e.a r55 = e.a.f11892b;
        if (r54 != r55) goto L356;
    L359:
        boolean r56 = true;
    L360:
        if (r43 <= 0) goto L369;
        if (r56 == false) goto L369;
        int r57 = 0;
    L363:
        if (r57 >= r49) goto L369;
        a r58 = r116.get(r57);
        if (r117 != 0) goto L367;
        int r59 = r58.d();
    L368:
        r58.e(r24 - r59);
        r57 = r57 + 1;
        goto L363
    L367:
        r59 = r58.c();
    L369:
        int r60 = r50;
        int r61 = r51;
        d r62 = r35;
        d r63 = r34;
        d r122 = r36;
        d r64 = r37;
        int r65 = 0;
        int r123 = 0;
        int r124 = 0;
    L370:
        if (r65 >= r49) goto L390;
        int r314 = r53;
        a r66 = r116.get(r65);
        if (r117 == 0) goto L374;
        ArrayList<a> r315 = r116;
        if (r65 >= (r49 - 1)) goto L384;
        r116 = r315;
        r122 = r116.get(r65 + 1).f11908b.K;
        r52 = 0;
    L385:
        d r67 = r66.f11908b.M;
        r66.f(r117, r62, r63, r122, r64, r60, r61, r52, r314, r24);
        int r68 = r66.d() + r123;
        int r69 = Math.max(r124, r66.c());
        if (r65 <= 0) goto L388;
        r68 = r68 + r8.R0;
    L388:
        r123 = r68;
        r124 = r69;
        r53 = r314;
        r60 = 0;
        r62 = r67;
    L389:
        r65 = r65 + 1;
        r49 = r49;
        goto L370
    L384:
        r116 = r315;
        r52 = r8.f11939z0;
        r122 = r36;
        goto L385
    L374:
        if (r65 >= (r49 - 1)) goto L376;
        r64 = r116.get(r65 + 1).f11908b.L;
        int r316 = 0;
    L377:
        d r125 = r66.f11908b.N;
        r66.f(r117, r62, r63, r122, r64, r60, r61, r52, r316, r24);
        int r70 = Math.max(r123, r66.d());
        int r71 = r66.c() + r124;
        if (r65 <= 0) goto L380;
        r71 = r71 + r8.S0;
    L380:
        r49 = r49;
        r123 = r70;
        r124 = r71;
        r63 = r125;
        r53 = r316;
        r116 = r116;
        r61 = 0;
        goto L389
    L376:
        r316 = r8.f11935v0;
        r64 = r37;
        goto L377
    L390:
        r313[0] = r123;
        r313[1] = r124;
        goto L393
    L356:
        if (r212[1] == r55) goto L359;
        r56 = false;
        goto L360
    L327:
        r212 = r42;
        r43 = 0;
        int r72 = 0;
        int r73 = 0;
    L328:
        if (r73 >= r115) goto L353;
        e r126 = r31[r73];
        int r127 = r8.T(r24, r126);
        if (r126.V[1] != e.a.f11893m) goto L332;
        r43 = r43 + 1;
    L332:
        int r128 = r43;
        if (r72 == r24) goto L337;
        if (((r8.S0 + r72) + r127) > r24) goto L337;
    L339:
        boolean r74 = false;
    L340:
        if (r74 == true) goto L347;
        if (r73 <= 0) goto L347;
        int r75 = r8.W0;
        if (r75 <= 0) goto L347;
        if ((r73 % r75) != 0) goto L347;
        r74 = true;
    L347:
        if (r74 == false) goto L349;
        r118 = new a(this, r117, r8.K, r8.L, r8.M, r8.N, r24);
        r118.f11920n = r73;
        r116.add(r118);
    L351:
        r72 = r127;
    L352:
        r118.a(r126);
        r73 = r73 + 1;
        r43 = r128;
        goto L328
    L349:
        if (r73 <= 0) goto L351;
        r72 = (r8.S0 + r127) + r72;
    L337:
        if (r118.f11908b == null) goto L339;
        r74 = true;
    L393:
        int r76 = r38;
        int r77 = r39;
        int r78 = r40;
        int r79 = r41;
        int r129 = r210;
        int r130 = r310;
        int r131 = r311;
        int r132 = r312;
    L394:
        int[] r133 = r313;
        int r80 = r79;
        int r81 = 0;
        int r82 = r78;
        int r83 = r77;
        char r84 = 1;
    L403:
        int r85 = (r133[r81] + r129) + r130;
        int r86 = (r133[r84] + r131) + r132;
        if (r76 != 1073741824) goto L406;
        int r87 = r83;
    L411:
        if (r82 != 1073741824) goto L413;
        int r88 = r80;
    L418:
        r8.B0 = r87;
        r8.C0 = r88;
        r8.N(r87);
        r8.K(r88);
        if (r8.f11932t0 <= 0) goto L421;
        boolean r89 = r84;
    L422:
        r8.A0 = r89;
        return;
    L421:
        r89 = r81;
        goto L422
    L413:
        if (r82 != Integer.MIN_VALUE) goto L415;
        r88 = Math.min(r86, r80);
        goto L418
    L415:
        if (r82 != 0) goto L417;
        r88 = r86;
        goto L418
    L417:
        r88 = r81;
        goto L418
    L406:
        if (r76 != Integer.MIN_VALUE) goto L408;
        r87 = Math.min(r85, r83);
        goto L411
    L408:
        if (r76 != 0) goto L410;
        r87 = r85;
        goto L411
    L410:
        r87 = r81;
        goto L411
    L81:
        if (r32 != 2) goto L83;
        int r317 = r28;
        e[] r318 = r31;
        r313 = r114;
        int r90 = r8.X0;
        int r91 = r8.W0;
        if (r90 != 0) goto L198;
        if (r91 > 0) goto L197;
        int r92 = 0;
        int r93 = 0;
        int r94 = 0;
    L185:
        if (r92 >= r317) goto L196;
        if (r92 <= 0) goto L188;
        r93 = r93 + r8.R0;
    L188:
        e r95 = r318[r92];
        if (r95 == null) goto L195;
        int r96 = r8.U(r24, r95) + r93;
        if (r96 > r24) goto L196;
        r94 = r94 + 1;
        r93 = r96;
    L195:
        r92 = r92 + 1;
    L196:
        r91 = r94;
    L197:
        int r97 = r91;
        r91 = 0;
    L214:
        if (r8.f11904b1 != null) goto L216;
        r8.f11904b1 = new int[2];
    L216:
        if (r91 == 0) goto L218;
    L219:
        if (r97 != 0) goto L222;
        if (r90 != 0) goto L222;
    L221:
        int r98 = r40;
        int r99 = r41;
        int r100 = r90;
        int r101 = r91;
        int r102 = r97;
        g r103 = r8;
        r129 = r110;
        r130 = r111;
        r131 = r112;
        r132 = r113;
        int[] r134 = r313;
        boolean r104 = true;
        int r105 = r38;
        int r106 = r39;
    L292:
        boolean r135 = r104;
        g r107 = r8;
        r8 = r103;
        e[] r108 = r318;
    L223:
        if (r135 == true) goto L293;
        if (r100 != 0) goto L226;
        r101 = (int) Math.ceil(r317 / r102);
    L227:
        e[] r109 = r8.f11903a1;
        if (r109 != null) goto L230;
    L233:
        r8.f11903a1 = new e[r102];
    L234:
        e[] r136 = r8.Z0;
        if (r136 != null) goto L237;
    L240:
        r8.Z0 = new e[r101];
    L241:
        int r137 = 0;
    L242:
        if (r137 >= r102) goto L266;
        int r138 = 0;
    L244:
        if (r138 >= r101) goto L265;
        int r139 = (r138 * r102) + r137;
        int r319 = r106;
        if (r100 != 1) goto L248;
        r139 = (r137 * r101) + r138;
    L248:
        int r410 = r98;
        int r140 = r139;
        if (r140 < r108.length) goto L251;
    L250:
        int r411 = r99;
    L264:
        r138 = r138 + 1;
        r106 = r319;
        r98 = r410;
        r99 = r411;
        goto L244
    L251:
        e r141 = r108[r140];
        if (r141 == null) goto L250;
        int r142 = r8.U(r24, r141);
        r411 = r99;
        e r143 = r8.f11903a1[r137];
        if (r143 != null) goto L257;
    L258:
        r8.f11903a1[r137] = r141;
    L259:
        int r144 = r8.T(r24, r141);
        e r145 = r8.Z0[r138];
        if (r145 != null) goto L262;
    L263:
        r8.Z0[r138] = r141;
        goto L264
    L262:
        if (r145.l() >= r144) goto L264;
    L257:
        if (r143.q() >= r142) goto L259;
    L265:
        r137 = r137 + 1;
        goto L242
    L266:
        int r320 = r106;
        int r412 = r98;
        int r413 = r99;
        int r146 = 0;
        int r147 = 0;
    L267:
        if (r146 >= r102) goto L274;
        e r148 = r8.f11903a1[r146];
        if (r148 == null) goto L273;
        if (r146 <= 0) goto L272;
        r147 = r147 + r8.R0;
    L272:
        r147 = r8.U(r24, r148) + r147;
    L273:
        r146 = r146 + 1;
        goto L267
    L274:
        int r149 = 0;
        int r150 = 0;
    L275:
        if (r149 >= r101) goto L282;
        e r151 = r8.Z0[r149];
        if (r151 == null) goto L281;
        if (r149 <= 0) goto L280;
        r150 = r150 + r8.S0;
    L280:
        r150 = r8.T(r24, r151) + r150;
    L281:
        r149 = r149 + 1;
        goto L275
    L282:
        r134[0] = r147;
        r104 = true;
        r134[1] = r150;
        if (r100 != 0) goto L287;
        if (r147 <= r24) goto L291;
        if (r102 <= 1) goto L291;
        r102 = r102 - 1;
    L290:
        r107 = r107;
        r105 = r105;
        r106 = r320;
        r98 = r412;
        r99 = r413;
    L291:
        r105 = r105;
        r106 = r320;
        r98 = r412;
        r99 = r413;
        r318 = r108;
        r103 = r8;
        r8 = r107;
        goto L292
    L287:
        if (r150 <= r24) goto L291;
        if (r101 <= 1) goto L291;
        r101 = r101 - 1;
        goto L290
    L237:
        if (r136.length < r101) goto L240;
        Arrays.fill(r136, null);
        goto L241
    L230:
        if (r109.length < r102) goto L233;
        Arrays.fill(r109, null);
        goto L234
    L226:
        r102 = (int) Math.ceil(r317 / r101);
        goto L227
    L293:
        int r321 = r105;
        int[] r152 = r8.f11904b1;
        r152[0] = r102;
        r152[1] = r101;
        r8 = r107;
        r76 = r321;
        r77 = r106;
        r78 = r98;
        r79 = r99;
    L222:
        r98 = r40;
        r99 = r41;
        r100 = r90;
        r101 = r91;
        r102 = r97;
        r107 = r8;
        r129 = r110;
        r130 = r111;
        r131 = r112;
        r132 = r113;
        r108 = r318;
        r134 = r313;
        r135 = false;
        r105 = r38;
        r106 = r39;
        goto L223
    L218:
        if (r90 == 1) goto L221;
    L198:
        if (r91 > 0) goto L212;
        int r153 = 0;
        int r154 = 0;
        int r155 = 0;
    L200:
        if (r153 >= r317) goto L211;
        if (r153 <= 0) goto L203;
        r154 = r154 + r8.S0;
    L203:
        e r156 = r318[r153];
        if (r156 == null) goto L210;
        int r157 = r8.T(r24, r156) + r154;
        if (r157 > r24) goto L211;
        r155 = r155 + 1;
        r154 = r157;
    L210:
        r153 = r153 + 1;
    L211:
        r91 = r155;
    L212:
        r97 = 0;
        goto L214
    L83:
        if (r32 != 3) goto L87;
        int r158 = r8.X0;
        if (r28 == 0) goto L87;
        r33.clear();
        r210 = r110;
        r310 = r111;
        ArrayList<a> r159 = r33;
        r311 = r112;
        int r160 = r28;
        int r322 = r24;
        a r161 = new a(this, r158, r8.K, r8.L, r8.M, r8.N, r322);
        r159.add(r161);
        if (r158 != 0) goto L117;
        a r162 = r161;
        int r163 = 0;
        int r164 = 0;
        int r165 = 0;
        int r166 = 0;
    L91:
        if (r166 >= r160) goto L116;
        r163 = r163 + 1;
        e r167 = r31[r166];
        int r168 = r322;
        int r169 = r8.U(r168, r167);
        if (r167.V[0] != e.a.f11893m) goto L95;
        r164 = r164 + 1;
    L95:
        int r170 = r164;
        if (r165 == r168) goto L100;
        if (((r8.R0 + r165) + r169) > r168) goto L100;
    L102:
        boolean r171 = false;
    L103:
        if (r171 == true) goto L109;
        if (r166 <= 0) goto L109;
        int r172 = r8.W0;
        if (r172 <= 0) goto L109;
        if (r163 <= r172) goto L109;
        r171 = true;
    L109:
        if (r171 == false) goto L111;
        int r323 = r113;
        int r324 = r168;
        int[] r325 = r114;
        e r173 = r167;
        a r174 = new a(this, r158, r8.K, r8.L, r8.M, r8.N, r324);
        r174.f11920n = r166;
        r159.add(r174);
        r162 = r174;
        r165 = r169;
        r163 = 1;
    L115:
        r162.a(r173);
        r166 = r166 + 1;
        r164 = r170;
        r113 = r323;
        r322 = r324;
        r114 = r325;
        goto L91
    L111:
        r324 = r168;
        r323 = r113;
        r325 = r114;
        r173 = r167;
        if (r166 <= 0) goto L114;
        r165 = (r8.R0 + r169) + r165;
        goto L115
    L114:
        r165 = r169;
    L100:
        if (r162.f11908b == null) goto L102;
        r171 = true;
        goto L103
    L116:
        r313 = r114;
        int r326 = r322;
        r312 = r113;
    L143:
        int r175 = r326;
        int r176 = r159.size();
        int r177 = r8.f11938y0;
        int r178 = r8.f11934u0;
        int r179 = r8.f11939z0;
        int r180 = r8.f11935v0;
        e.a r181 = r42[0];
        e.a r182 = e.a.f11892b;
        if (r181 != r182) goto L146;
    L149:
        boolean r183 = true;
    L150:
        if (r164 <= 0) goto L159;
        if (r183 == false) goto L159;
        int r184 = 0;
    L153:
        if (r184 >= r176) goto L159;
        a r185 = r159.get(r184);
        if (r158 != 0) goto L157;
        int r186 = r185.d();
    L158:
        r185.e(r175 - r186);
        r184 = r184 + 1;
        goto L153
    L157:
        r186 = r185.c();
    L159:
        int r187 = r177;
        int r188 = r178;
        d r189 = r35;
        d r190 = r34;
        d r191 = r36;
        d r192 = r37;
        int r193 = 0;
        int r194 = 0;
        int r195 = 0;
    L160:
        if (r193 >= r176) goto L180;
        int r327 = r180;
        a r196 = r159.get(r193);
        if (r158 == 0) goto L164;
        ArrayList<a> r328 = r159;
        if (r193 >= (r176 - 1)) goto L174;
        r159 = r328;
        r191 = r159.get(r193 + 1).f11908b.K;
        r179 = 0;
    L175:
        d r197 = r196.f11908b.M;
        r196.f(r158, r189, r190, r191, r192, r187, r188, r179, r327, r175);
        int r198 = r196.d() + r194;
        int r199 = Math.max(r195, r196.c());
        if (r193 <= 0) goto L178;
        r198 = r198 + r8.R0;
    L178:
        r194 = r198;
        r195 = r199;
        r180 = r327;
        r187 = 0;
        r189 = r197;
    L179:
        r193 = r193 + 1;
        r176 = r176;
        goto L160
    L174:
        r159 = r328;
        r179 = r8.f11939z0;
        r191 = r36;
        goto L175
    L164:
        if (r193 >= (r176 - 1)) goto L166;
        r192 = r159.get(r193 + 1).f11908b.L;
        int r329 = 0;
    L167:
        d r1100 = r196.f11908b.N;
        r196.f(r158, r189, r190, r191, r192, r187, r188, r179, r329, r175);
        int r200 = Math.max(r194, r196.d());
        int r201 = r196.c() + r195;
        if (r193 <= 0) goto L170;
        r201 = r201 + r8.S0;
    L170:
        r176 = r176;
        r194 = r200;
        r195 = r201;
        r190 = r1100;
        r180 = r329;
        r159 = r159;
        r188 = 0;
        goto L179
    L166:
        r329 = r8.f11935v0;
        r192 = r37;
        goto L167
    L180:
        r313[0] = r194;
        r313[1] = r195;
        goto L393
    L146:
        if (r42[1] == r182) goto L149;
        r183 = false;
        goto L150
    L117:
        r313 = r114;
        r326 = r322;
        r312 = r113;
        a r202 = r161;
        int r203 = 0;
        r164 = 0;
        int r204 = 0;
        int r1101 = 0;
    L118:
        if (r1101 >= r160) goto L143;
        r203 = r203 + 1;
        e r1102 = r31[r1101];
        int r1103 = r326;
        int r1104 = r8.T(r1103, r1102);
        if (r1102.V[1] != e.a.f11893m) goto L122;
        r164 = r164 + 1;
    L122:
        int r1105 = r164;
        if (r204 == r1103) goto L127;
        if (((r8.S0 + r204) + r1104) > r1103) goto L127;
    L129:
        boolean r205 = false;
    L130:
        if (r205 == true) goto L136;
        if (r1101 <= 0) goto L136;
        int r206 = r8.W0;
        if (r206 <= 0) goto L136;
        if (r203 <= r206) goto L136;
        r205 = true;
    L136:
        if (r205 == false) goto L138;
        int r330 = r160;
        a r207 = new a(this, r158, r8.K, r8.L, r8.M, r8.N, r1103);
        r207.f11920n = r1101;
        r159.add(r207);
        r202 = r207;
        r204 = r1104;
        r203 = 1;
    L142:
        r202.a(r1102);
        r1101 = r1101 + 1;
        r164 = r1105;
        r160 = r330;
        r326 = r1103;
        goto L118
    L138:
        r330 = r160;
        if (r1101 <= 0) goto L141;
        r204 = (r8.S0 + r1104) + r204;
        goto L142
    L141:
        r204 = r1104;
    L127:
        if (r202.f11908b == null) goto L129;
        r205 = true;
    L87:
        r210 = r110;
        r310 = r111;
        r311 = r112;
        r312 = r113;
        r313 = r114;
        goto L393
    L391:
        int r1106 = r28;
        r210 = r110;
        r310 = r111;
        r311 = r112;
        r312 = r113;
        r313 = r114;
        int r208 = r8.X0;
        if (r1106 == 0) goto L393;
        if (r33.size() != 0) goto L398;
        a r209 = new a(this, r208, r8.K, r8.L, r8.M, r8.N, r24);
        r33.add(r209);
    L399:
        int r213 = 0;
    L400:
        if (r213 >= r1106) goto L402;
        r209.a(r31[r213]);
        r213 = r213 + 1;
        goto L400
    L402:
        r81 = 0;
        r313[0] = r209.d();
        r84 = 1;
        r313[1] = r209.c();
        r76 = r38;
        r83 = r39;
        r82 = r40;
        r80 = r41;
        r129 = r210;
        r130 = r310;
        r131 = r311;
        r132 = r312;
        r133 = r313;
        goto L403
    L398:
        r209 = r33.get(0);
        r209.f11909c = 0;
        r209.f11908b = null;
        r209.f11918l = 0;
        r209.f11919m = 0;
        r209.f11920n = 0;
        r209.f11921o = 0;
        r209.f11922p = 0;
        r209.f(r208, r8.K, r8.L, r8.M, r8.N, r8.f11938y0, r8.f11934u0, r8.f11939z0, r8.f11935v0, r24);
    L60:
        r8.G0 = 0;
        goto L61
    L56:
        if (r8.F0 != (-1)) goto L59;
        r8.F0 = 0;
    L59:
        if (r8.G0 != (-1)) goto L61;
        goto L60
    }

    public final int T(int r11, e r12) {
        if (r12 != null) goto L5;
        return 0;
    L5:
        e.a[] r8 = r12.V;
        if (r8[1] != e.a.f11893m) goto L24;
        int r10 = r12.f11884t;
        if (r10 != 0) goto L11;
        return 0;
    L11:
        if (r10 != 2) goto L16;
        int r13 = (int) (r12.A * r11);
        if (r13 == r12.l()) goto L15;
        r12.f11859g = true;
        S(r12, r8[0], r12.q(), e.a.f11891a, r13);
    L15:
        return r13;
    L16:
        if (r10 != 1) goto L20;
        return r12.l();
    L20:
        if (r10 != 3) goto L24;
        return (int) ((r12.q() * r12.Z) + 0.5f);
    L24:
        return r12.l();
    }

    public final int U(int r11, e r12) {
        if (r12 != null) goto L5;
        return 0;
    L5:
        e.a[] r8 = r12.V;
        if (r8[0] != e.a.f11893m) goto L24;
        int r10 = r12.f11883s;
        if (r10 != 0) goto L11;
        return 0;
    L11:
        if (r10 != 2) goto L16;
        int r13 = (int) (r12.f11888x * r11);
        if (r13 == r12.q()) goto L15;
        r12.f11859g = true;
        S(r12, e.a.f11891a, r13, r8[1], r12.l());
    L15:
        return r13;
    L16:
        if (r10 != 1) goto L20;
        return r12.q();
    L20:
        if (r10 != 3) goto L24;
        return (int) ((r12.l() * r12.Z) + 0.5f);
    L24:
        return r12.q();
    }

    @Override // s.e
    public final void c(p.d r12, boolean r13) {
        super.c(r12, r13);
        e r14 = this.W;
        if (r14 != null) goto L5;
    L7:
        boolean r15 = false;
    L8:
        int r8 = this.V0;
        ArrayList<a> r10 = this.Y0;
        if (r8 == 0) goto L104;
        if (r8 != 1) goto L12;
        int r11 = r10.size();
        int r16 = 0;
    L97:
        if (r16 >= r11) goto L106;
        a r17 = r10.get(r16);
        if (r16 != (r11 - 1)) goto L101;
        boolean r18 = true;
    L102:
        r17.b(r16, r15, r18);
        r16 = r16 + 1;
        goto L97
    L101:
        r18 = false;
    L106:
        this.A0 = false;
        return;
    L12:
        if (r8 == 2) goto L24;
        if (r8 != 3) goto L106;
        int r19 = r10.size();
        int r20 = 0;
    L17:
        if (r20 >= r19) goto L106;
        a r21 = r10.get(r20);
        if (r20 != (r19 - 1)) goto L21;
        boolean r22 = true;
    L22:
        r21.b(r20, r15, r22);
        r20 = r20 + 1;
        goto L17
    L21:
        r22 = false;
        goto L22
    L24:
        if (this.f11904b1 == null) goto L106;
        if (this.f11903a1 == null) goto L106;
        if (this.Z0 == null) goto L106;
        int r23 = 0;
    L32:
        if (r23 >= this.f11906d1) goto L34;
        this.f11905c1[r23].D();
        r23 = r23 + 1;
        goto L32
    L34:
        int[] r24 = this.f11904b1;
        int r25 = r24[0];
        int r26 = r24[1];
        float r27 = this.L0;
        e r28 = null;
        int r29 = 0;
    L36:
        if (r29 >= r25) goto L56;
        if (r15 == false) goto L39;
        int r30 = (r25 - r29) - 1;
        float r31 = 1.0f - this.L0;
    L40:
        e r32 = this.f11903a1[r30];
        if (r32 == null) goto L55;
        if (r32.f11866j0 == 8) goto L55;
        d r33 = r32.K;
        if (r29 != 0) goto L49;
        r32.g(r33, this.K, this.f11938y0);
        r32.f11870l0 = this.F0;
        r32.f11860g0 = r31;
    L49:
        if (r29 != (r25 - 1)) goto L51;
        r32.g(r32.M, this.M, this.f11939z0);
    L51:
        if (r29 <= 0) goto L54;
        if (r28 == null) goto L54;
        int r34 = this.R0;
        d r35 = r28.M;
        r32.g(r33, r35, r34);
        r28.g(r35, r33, 0);
    L54:
        r28 = r32;
    L55:
        r29 = r29 + 1;
        r27 = r31;
        goto L36
    L39:
        r31 = r27;
        r30 = r29;
        goto L40
    L56:
        int r110 = 0;
    L57:
        if (r110 >= r26) goto L74;
        e r36 = this.Z0[r110];
        if (r36 == null) goto L73;
        if (r36.f11866j0 == 8) goto L73;
        d r37 = r36.L;
        if (r110 != 0) goto L67;
        r36.g(r37, this.L, this.f11934u0);
        r36.f11872m0 = this.G0;
        r36.f11862h0 = this.M0;
    L67:
        if (r110 != (r26 - 1)) goto L69;
        r36.g(r36.N, this.N, this.f11935v0);
    L69:
        if (r110 <= 0) goto L72;
        if (r28 == null) goto L72;
        int r38 = this.S0;
        d r39 = r28.N;
        r36.g(r37, r39, r38);
        r28.g(r39, r37, 0);
    L72:
        r28 = r36;
    L73:
        r110 = r110 + 1;
        goto L57
    L74:
        int r111 = 0;
    L75:
        if (r111 >= r25) goto L106;
        int r40 = 0;
    L77:
        if (r40 >= r26) goto L95;
        int r41 = (r40 * r25) + r111;
        if (this.X0 != 1) goto L81;
        r41 = (r111 * r26) + r40;
    L81:
        e[] r42 = this.f11905c1;
        if (r41 >= r42.length) goto L94;
        e r43 = r42[r41];
        if (r43 == null) goto L94;
        if (r43.f11866j0 == 8) goto L94;
        e r44 = this.f11903a1[r111];
        e r45 = this.Z0[r40];
        if (r43 == r44) goto L92;
        r43.g(r43.K, r44.K, 0);
        r43.g(r43.M, r44.M, 0);
    L92:
        if (r43 == r45) goto L94;
        r43.g(r43.L, r45.L, 0);
        r43.g(r43.N, r45.N, 0);
    L94:
        r40 = r40 + 1;
        goto L77
    L95:
        r111 = r111 + 1;
        goto L75
    L104:
        if (r10.size() <= 0) goto L106;
        r10.get(0).b(0, r15, true);
        goto L106
    L5:
        if (((f) r14).f11900x0 == false) goto L7;
        r15 = true;
        goto L8
    }
}
