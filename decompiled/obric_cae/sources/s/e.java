package s;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import t.n;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public float A;
    public int B;
    public float C;
    public final int[] D;
    public float E;
    public boolean F;
    public boolean G;
    public boolean H;
    public int I;
    public int J;
    public final d K;
    public final d L;
    public final d M;
    public final d N;
    public final d O;
    public final d P;
    public final d Q;
    public final d R;
    public final d[] S;
    public final ArrayList<d> T;
    public final boolean[] U;
    public final a[] V;
    public e W;
    public int X;
    public int Y;
    public float Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f11848a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f11849a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t.c f11850b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f11851b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t.c f11852c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f11853c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public t.l f11854d;
    public int d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n f11855e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f11856e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean[] f11857f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f11858f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f11859g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public float f11860g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f11861h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public float f11862h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f11863i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public Object f11864i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f11865j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f11866j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f11867k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public String f11868k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f11869l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public int f11870l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f11871m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f11872m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f11873n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public final float[] f11874n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f11875o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public final e[] f11876o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f11877p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final e[] f11878p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f11879q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f11880q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f11881r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f11882r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f11883s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f11884t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int[] f11885u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f11886v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f11887w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f11888x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f11889y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f11890z;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11891a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f11892b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f11893m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f11894n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final /* synthetic */ a[] f11895o = null;

        static {
            a r8 = new a("FIXED", 0);
            f11891a = r8;
            a r10 = new a("WRAP_CONTENT", 1);
            f11892b = r10;
            a r11 = new a("MATCH_CONSTRAINT", 2);
            f11893m = r11;
            a r12 = new a("MATCH_PARENT", 3);
            f11894n = r12;
            f11895o = new a[]{r8, r10, r11, r12};
        }

        public a(String r8, int r10) {
            super(r8, r10);
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f11895o.clone();
        }
    }

    public e() {
        this.f11848a = false;
        this.f11854d = null;
        this.f11855e = null;
        this.f11857f = new boolean[]{true, true};
        this.f11859g = true;
        this.f11861h = true;
        this.f11863i = -1;
        this.f11865j = -1;
        new r.a();
        this.f11869l = false;
        this.f11871m = false;
        this.f11873n = false;
        this.f11875o = false;
        this.f11877p = -1;
        this.f11879q = -1;
        this.f11881r = 0;
        this.f11883s = 0;
        this.f11884t = 0;
        this.f11885u = new int[2];
        this.f11886v = 0;
        this.f11887w = 0;
        this.f11888x = 1.0f;
        this.f11889y = 0;
        this.f11890z = 0;
        this.A = 1.0f;
        this.B = -1;
        this.C = 1.0f;
        this.D = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.E = Float.NaN;
        this.F = false;
        this.H = false;
        this.I = 0;
        this.J = 0;
        d r8 = new d(this, d.a.f11839a);
        this.K = r8;
        d r12 = new d(this, d.a.f11840b);
        this.L = r12;
        d r13 = new d(this, d.a.f11841m);
        this.M = r13;
        d r14 = new d(this, d.a.f11842n);
        this.N = r14;
        d r15 = new d(this, d.a.f11843o);
        this.O = r15;
        d r11 = new d(this, d.a.f11845q);
        this.P = r11;
        d r10 = new d(this, d.a.f11846r);
        this.Q = r10;
        d r16 = new d(this, d.a.f11844p);
        this.R = r16;
        this.S = new d[]{r8, r13, r12, r14, r15, r16};
        ArrayList<d> r17 = new ArrayList();
        this.T = r17;
        this.U = new boolean[2];
        a r18 = a.f11891a;
        this.V = new a[]{r18, r18};
        this.W = null;
        this.X = 0;
        this.Y = 0;
        this.Z = 0.0f;
        this.f11849a0 = -1;
        this.f11851b0 = 0;
        this.f11853c0 = 0;
        this.d0 = 0;
        this.f11860g0 = 0.5f;
        this.f11862h0 = 0.5f;
        this.f11866j0 = 0;
        this.f11868k0 = null;
        this.f11870l0 = 0;
        this.f11872m0 = 0;
        this.f11874n0 = new float[]{-1.0f, -1.0f};
        this.f11876o0 = new e[]{null, null};
        this.f11878p0 = new e[]{null, null};
        this.f11880q0 = -1;
        this.f11882r0 = -1;
        r17.add(r8);
        r17.add(r12);
        r17.add(r13);
        r17.add(r14);
        r17.add(r11);
        r17.add(r10);
        r17.add(r16);
        r17.add(r15);
    }

    public static void G(int r8, int r10, String r11, StringBuilder r12) {
        if (r8 != r10) goto L4;
        return;
    L4:
        r12.append(r11);
        r12.append(" :   ");
        r12.append(r8);
        r12.append(",\n");
    }

    public static void H(StringBuilder r8, String r10, float r11, float r12) {
        if (r11 != r12) goto L5;
        return;
    L5:
        r8.append(r10);
        r8.append(" :   ");
        r8.append(r11);
        r8.append(",\n");
    }

    public static void o(StringBuilder r8, String r10, int r11, int r12, int r13, int r14, int r15, float r16, a r17) {
        r8.append(r10);
        r8.append(" :  {\n");
        String r18 = r17.toString();
        a r19 = a.f11891a;
        if ("FIXED".equals(r18) == true) goto L6;
        r8.append("      behavior");
        r8.append(" :   ");
        r8.append(r18);
        r8.append(",\n");
    L6:
        G(r11, 0, "      size", r8);
        G(r12, 0, "      min", r8);
        G(r13, Integer.MAX_VALUE, "      max", r8);
        G(r14, 0, "      matchMin", r8);
        G(r15, 0, "      matchDef", r8);
        H(r8, "      matchPercent", r16, 1.0f);
        r8.append("    },\n");
    }

    public static void p(StringBuilder r8, String r10, d r11) {
        if (r11.f11835f != null) goto L5;
        return;
    L5:
        r8.append("    ");
        r8.append(r10);
        r8.append(" : [ '");
        r8.append(r11.f11835f);
        r8.append("'");
        if (r11.f11837h == Integer.MIN_VALUE) goto L8;
    L9:
        r8.append(",");
        r8.append(r11.f11836g);
        if (r11.f11837h == Integer.MIN_VALUE) goto L12;
        r8.append(",");
        r8.append(r11.f11837h);
        r8.append(",");
    L12:
        r8.append(" ] ,\n");
        return;
    L8:
        if (r11.f11836g == 0) goto L12;
        goto L9
    }

    public boolean A() {
        if (this.f11869l == false) goto L5;
    L10:
        return true;
    L5:
        if (this.K.f11832c == true) goto L7;
    L9:
        return false;
    L7:
        if (this.M.f11832c == false) goto L9;
        goto L9
    }

    public boolean B() {
        if (this.f11871m == false) goto L5;
    L10:
        return true;
    L5:
        if (this.L.f11832c == true) goto L7;
    L9:
        return false;
    L7:
        if (this.N.f11832c == false) goto L9;
        goto L9
    }

    public void C() {
        this.K.j();
        this.L.j();
        this.M.j();
        this.N.j();
        this.O.j();
        this.P.j();
        this.Q.j();
        this.R.j();
        this.W = null;
        this.E = Float.NaN;
        this.X = 0;
        this.Y = 0;
        this.Z = 0.0f;
        this.f11849a0 = -1;
        this.f11851b0 = 0;
        this.f11853c0 = 0;
        this.d0 = 0;
        this.f11856e0 = 0;
        this.f11858f0 = 0;
        this.f11860g0 = 0.5f;
        this.f11862h0 = 0.5f;
        a r8 = a.f11891a;
        a[] r10 = this.V;
        r10[0] = r8;
        r10[1] = r8;
        this.f11864i0 = null;
        this.f11866j0 = 0;
        this.f11870l0 = 0;
        this.f11872m0 = 0;
        float[] r11 = this.f11874n0;
        r11[0] = -1.0f;
        r11[1] = -1.0f;
        this.f11877p = -1;
        this.f11879q = -1;
        int[] r12 = this.D;
        r12[0] = Integer.MAX_VALUE;
        r12[1] = Integer.MAX_VALUE;
        this.f11883s = 0;
        this.f11884t = 0;
        this.f11888x = 1.0f;
        this.A = 1.0f;
        this.f11887w = Integer.MAX_VALUE;
        this.f11890z = Integer.MAX_VALUE;
        this.f11886v = 0;
        this.f11889y = 0;
        this.B = -1;
        this.C = 1.0f;
        boolean[] r13 = this.f11857f;
        r13[0] = true;
        r13[1] = true;
        this.H = false;
        boolean[] r14 = this.U;
        r14[0] = false;
        r14[1] = false;
        this.f11859g = true;
        int[] r15 = this.f11885u;
        r15[0] = 0;
        r15[1] = 0;
        this.f11863i = -1;
        this.f11865j = -1;
    }

    public final void D() {
        e r8 = this.W;
        if (r8 != null) goto L5;
    L7:
        ArrayList<d> r10 = this.T;
        int r11 = r10.size();
        int r12 = 0;
    L8:
        if (r12 >= r11) goto L10;
        r10.get(r12).j();
        r12 = r12 + 1;
        goto L8
    L10:
        return;
    L5:
        if ((r8 instanceof f) == false) goto L7;
        ((f) r8).getClass();
        goto L7
    }

    public final void E() {
        this.f11869l = false;
        this.f11871m = false;
        this.f11873n = false;
        this.f11875o = false;
        ArrayList<d> r8 = this.T;
        int r10 = r8.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        d r12 = r8.get(r11);
        r12.f11832c = false;
        r12.f11831b = 0;
        r11 = r11 + 1;
        goto L3
    }

    public void F(p.c r8) {
        this.K.k();
        this.L.k();
        this.M.k();
        this.N.k();
        this.O.k();
        this.R.k();
        this.P.k();
        this.Q.k();
    }

    public final void I(int r8, int r10) {
        if (this.f11869l == false) goto L5;
        return;
    L5:
        this.K.l(r8);
        this.M.l(r10);
        this.f11851b0 = r8;
        this.X = r10 - r8;
        this.f11869l = true;
    }

    public final void J(int r8, int r10) {
        if (this.f11871m == false) goto L5;
        return;
    L5:
        this.L.l(r8);
        this.N.l(r10);
        this.f11853c0 = r8;
        this.Y = r10 - r8;
        if (this.F == false) goto L8;
        int r11 = r8 + this.d0;
        this.O.l(r11);
    L8:
        this.f11871m = true;
    }

    public final void K(int r8) {
        this.Y = r8;
        int r10 = this.f11858f0;
        if (r8 >= r10) goto L6;
        this.Y = r10;
        return;
    }

    public final void L(a r8) {
        this.V[0] = r8;
    }

    public final void M(a r8) {
        this.V[1] = r8;
    }

    public final void N(int r8) {
        this.X = r8;
        int r10 = this.f11856e0;
        if (r8 >= r10) goto L6;
        this.X = r10;
        return;
    }

    public void O(boolean r8, boolean r10) {
        t.l r11 = this.f11854d;
        boolean r12 = r8 & r11.f12199g;
        n r13 = this.f11855e;
        boolean r14 = r10 & r13.f12199g;
        int r15 = r11.f12200h.f12165g;
        int r16 = r13.f12200h.f12165g;
        int r17 = r11.f12201i.f12165g;
        int r18 = r13.f12201i.f12165g;
        int r19 = r18 - r16;
        if ((r17 - r15) < 0) goto L15;
        if (r19 < 0) goto L15;
        if (r15 == Integer.MIN_VALUE) goto L15;
        if (r15 == Integer.MAX_VALUE) goto L15;
        if (r16 == Integer.MIN_VALUE) goto L15;
        if (r16 == Integer.MAX_VALUE) goto L15;
        if (r17 == Integer.MIN_VALUE) goto L15;
        if (r17 == Integer.MAX_VALUE) goto L15;
        if (r18 == Integer.MIN_VALUE) goto L15;
        if (r18 == Integer.MAX_VALUE) goto L15;
    L16:
        int r20 = r17 - r15;
        int r21 = r18 - r16;
        if (r12 == false) goto L19;
        this.f11851b0 = r15;
    L19:
        if (r14 == false) goto L22;
        this.f11853c0 = r16;
    L22:
        if (this.f11866j0 != 8) goto L25;
        this.X = 0;
        this.Y = 0;
        return;
    L25:
        a[] r22 = this.V;
        if (r12 == true) goto L28;
    L35:
        if (r14 == true) goto L37;
        return;
    L37:
        if (r22[1] != a.f11891a) goto L41;
        int r23 = this.Y;
        if (r21 >= r23) goto L41;
        r21 = r23;
    L41:
        this.Y = r21;
        int r24 = this.f11858f0;
        if (r21 >= r24) goto L46;
        this.Y = r24;
        return;
    L46:
        return;
    L28:
        if (r22[0] != a.f11891a) goto L32;
        int r25 = this.X;
        if (r20 >= r25) goto L32;
        r20 = r25;
    L32:
        this.X = r20;
        int r26 = this.f11856e0;
        if (r20 >= r26) goto L35;
        this.X = r26;
    L15:
        r17 = 0;
        r18 = 0;
        r15 = 0;
        r16 = 0;
        goto L16
    }

    public void P(p.d r8, boolean r10) {
        r8.getClass();
        int r11 = p.d.o(this.K);
        int r12 = p.d.o(this.L);
        int r13 = p.d.o(this.M);
        int r14 = p.d.o(this.N);
        if (r10 == false) goto L11;
        t.l r15 = this.f11854d;
        if (r15 == null) goto L11;
        t.f r16 = r15.f12200h;
        if (r16.f12168j == false) goto L11;
        t.f r17 = r15.f12201i;
        if (r17.f12168j == false) goto L11;
        r11 = r16.f12165g;
        r13 = r17.f12165g;
    L11:
        if (r10 == false) goto L19;
        n r18 = this.f11855e;
        if (r18 == null) goto L19;
        t.f r19 = r18.f12200h;
        if (r19.f12168j == false) goto L19;
        t.f r20 = r18.f12201i;
        if (r20.f12168j == false) goto L19;
        r12 = r19.f12165g;
        r14 = r20.f12165g;
    L19:
        int r21 = r14 - r12;
        if ((r13 - r11) < 0) goto L32;
        if (r21 < 0) goto L32;
        if (r11 == Integer.MIN_VALUE) goto L32;
        if (r11 == Integer.MAX_VALUE) goto L32;
        if (r12 == Integer.MIN_VALUE) goto L32;
        if (r12 == Integer.MAX_VALUE) goto L32;
        if (r13 == Integer.MIN_VALUE) goto L32;
        if (r13 == Integer.MAX_VALUE) goto L32;
        if (r14 == Integer.MIN_VALUE) goto L32;
        if (r14 == Integer.MAX_VALUE) goto L32;
    L33:
        int r22 = r13 - r11;
        int r23 = r14 - r12;
        this.f11851b0 = r11;
        this.f11853c0 = r12;
        if (this.f11866j0 != 8) goto L36;
        this.X = 0;
        this.Y = 0;
        return;
    L36:
        a[] r24 = this.V;
        a r25 = r24[0];
        a r26 = a.f11891a;
        if (r25 != r26) goto L42;
        int r27 = this.X;
        if (r22 >= r27) goto L42;
        r22 = r27;
    L42:
        if (r24[1] != r26) goto L46;
        int r28 = this.Y;
        if (r23 >= r28) goto L46;
        r23 = r28;
    L46:
        this.X = r22;
        this.Y = r23;
        int r29 = this.f11858f0;
        if (r23 >= r29) goto L49;
        this.Y = r29;
    L49:
        int r30 = this.f11856e0;
        if (r22 >= r30) goto L52;
        this.X = r30;
    L52:
        int r31 = this.f11887w;
        if (r31 > 0) goto L55;
    L57:
        int r32 = this.f11890z;
        if (r32 > 0) goto L60;
    L62:
        int r33 = this.X;
        if (r22 == r33) goto L65;
        this.f11863i = r33;
    L65:
        int r34 = this.Y;
        if (r23 == r34) goto L70;
        this.f11865j = r34;
        return;
    L70:
        return;
    L60:
        if (r24[1] != a.f11893m) goto L62;
        this.Y = Math.min(this.Y, r32);
        goto L62
    L55:
        if (r25 != a.f11893m) goto L57;
        this.X = Math.min(this.X, r31);
    L32:
        r11 = 0;
        r12 = 0;
        r13 = 0;
        r14 = 0;
        goto L33
    }

    public final void b(f r8, p.d r10, HashSet<e> r11, int r12, boolean r13) {
        if (r13 == true) goto L4;
    L7:
        if (r12 != 0) goto L20;
        HashSet<d> r14 = this.K.f11830a;
        if (r14 == null) goto L14;
        Iterator<d> r15 = r14.iterator();
    L12:
        if (r15.hasNext() == false) goto L14;
        r15.next().f11833d.b(r8, r10, r11, r12, true);
    L14:
        HashSet<d> r16 = this.M.f11830a;
        if (r16 == null) goto L38;
        Iterator<d> r17 = r16.iterator();
    L18:
        if (r17.hasNext() == false) goto L45;
        r17.next().f11833d.b(r8, r10, r11, r12, true);
        goto L18
    L45:
        return;
    L38:
        return;
    L20:
        HashSet<d> r18 = this.L.f11830a;
        if (r18 == null) goto L26;
        Iterator<d> r19 = r18.iterator();
    L24:
        if (r19.hasNext() == false) goto L26;
        r19.next().f11833d.b(r8, r10, r11, r12, true);
    L26:
        HashSet<d> r110 = this.N.f11830a;
        if (r110 == null) goto L32;
        Iterator<d> r111 = r110.iterator();
    L30:
        if (r111.hasNext() == false) goto L32;
        r111.next().f11833d.b(r8, r10, r11, r12, true);
    L32:
        HashSet<d> r20 = this.O.f11830a;
        if (r20 == null) goto L44;
        Iterator<d> r21 = r20.iterator();
    L36:
        if (r21.hasNext() == false) goto L46;
        r21.next().f11833d.b(r8, r10, r11, r12, true);
        goto L36
    L46:
        return;
    L44:
        return;
    L4:
        if (r11.contains(this) == true) goto L6;
        return;
    L6:
        k.a(r8, r10, this);
        r11.remove(this);
        c(r10, r8.V(64));
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3, types: [s.e] */
    /* JADX WARN: Type inference failed for: r15v7, types: [s.e] */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r27v1 */
    /* JADX WARN: Type inference failed for: r27v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r61v0, types: [s.e] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v8 */
    public void c(p.d r62, boolean r63) {
        d r8 = this.K;
        p.h r13 = r62.l(r8);
        d r10 = this.M;
        p.h r12 = r62.l(r10);
        d r11 = this.L;
        p.h r14 = r62.l(r11);
        d r15 = this.N;
        p.h r16 = r62.l(r15);
        d r17 = this.O;
        p.h r18 = r62.l(r17);
        e r19 = this.W;
        if (r19 == null) goto L20;
        a[] r20 = r19.V;
        a r21 = r20[0];
        a r22 = a.f11892b;
        if (r21 != r22) goto L7;
        boolean r23 = true;
    L9:
        if (r20[1] != r22) goto L11;
        boolean r24 = true;
    L12:
        int r25 = this.f11881r;
        if (r25 != 1) goto L15;
        boolean r29 = r23;
        boolean r28 = false;
    L22:
        int r26 = this.f11866j0;
        boolean[] r27 = this.U;
        if (r26 != 8) goto L43;
        ArrayList<d> r30 = this.T;
        int r31 = r30.size();
        int r32 = 0;
    L25:
        if (r32 >= r31) goto L36;
        ArrayList<d> r210 = r30;
        HashSet<d> r33 = r30.get(r32).f11830a;
        if (r33 != null) goto L30;
    L32:
        boolean r34 = false;
    L33:
        if (r34 == true) goto L34;
        r32 = r32 + 1;
        r30 = r210;
        goto L25
    L34:
        boolean r35 = true;
    L37:
        if (r35 == true) goto L43;
        if (r27[0] == true) goto L43;
        if (r27[1] == true) goto L43;
        return;
    L30:
        if (r33.size() <= 0) goto L32;
        r34 = true;
        goto L33
    L36:
        r35 = false;
    L43:
        boolean r36 = this.f11869l;
        if (r36 == false) goto L46;
    L49:
        boolean r37 = this.f11861h;
        if (r36 == false) goto L73;
        r62.d(r13, this.f11851b0);
        r62.d(r12, this.f11851b0 + this.X);
        if (r29 == false) goto L73;
        e r38 = this.W;
        if (r38 == null) goto L73;
        if (r37 == false) goto L72;
        f r39 = (f) r38;
        WeakReference<d> r40 = r39.J0;
        if (r40 != null) goto L59;
    L63:
        boolean[] r211 = r27;
    L64:
        r39.J0 = new WeakReference(r8);
    L65:
        WeakReference<d> r41 = r39.L0;
        if (r41 != null) goto L68;
    L71:
        r39.L0 = new WeakReference(r10);
    L75:
        if (this.f11871m == false) goto L104;
        r62.d(r14, this.f11853c0);
        r62.d(r16, this.f11853c0 + this.Y);
        HashSet<d> r42 = r17.f11830a;
        if (r42 != null) goto L80;
    L82:
        boolean r43 = false;
    L83:
        if (r43 == false) goto L85;
        r62.d(r18, this.f11853c0 + this.d0);
    L85:
        if (r28 == false) goto L104;
        e r44 = this.W;
        if (r44 == null) goto L104;
        if (r37 == false) goto L103;
        f r45 = (f) r44;
        WeakReference<d> r46 = r45.I0;
        if (r46 != null) goto L92;
    L95:
        r45.I0 = new WeakReference(r11);
    L96:
        WeakReference<d> r47 = r45.K0;
        if (r47 != null) goto L99;
    L102:
        r45.K0 = new WeakReference(r15);
        goto L104
    L99:
        if (r47.get() == null) goto L102;
        if (r15.d() <= r45.K0.get().d()) goto L104;
    L92:
        if (r46.get() == null) goto L95;
        if (r11.d() <= r45.I0.get().d()) goto L96;
    L103:
        boolean r48 = false;
        r62.f(r62.l(r44.N), r16, 0, 5);
    L106:
        if (this.f11869l == true) goto L108;
    L111:
        boolean[] r49 = this.f11857f;
        if (r63 == false) goto L142;
        t.l r50 = this.f11854d;
        if (r50 == null) goto L142;
        n r51 = this.f11855e;
        if (r51 == null) goto L142;
        t.f r52 = r50.f12200h;
        d r212 = r17;
        if (r52.f12168j == false) goto L144;
        if (r50.f12201i.f12168j == false) goto L144;
        if (r51.f12200h.f12168j == false) goto L144;
        if (r51.f12201i.f12168j == false) goto L144;
        r62.d(r13, r52.f12165g);
        r62.d(r12, this.f11854d.f12201i.f12165g);
        r62.d(r14, this.f11855e.f12200h.f12165g);
        r62.d(r16, this.f11855e.f12201i.f12165g);
        r62.d(r18, this.f11855e.f12185k.f12165g);
        if (this.W == null) goto L139;
        if (r29 == true) goto L129;
    L133:
        if (r28 == false) goto L139;
        if (r49[1] == false) goto L139;
        if (y() == true) goto L139;
        boolean r53 = false;
        r62.f(r62.l(this.W.N), r16, 0, 8);
    L140:
        this.f11869l = r53;
        this.f11871m = r53;
        return;
    L129:
        if (r49[0] == false) goto L133;
        if (x() == true) goto L133;
        r62.f(r62.l(this.W.M), r12, 0, 8);
    L139:
        r53 = false;
    L144:
        if (this.W != null) goto L146;
        boolean r310 = false;
        boolean r311 = false;
    L175:
        int r54 = this.X;
        int r55 = this.f11856e0;
        if (r54 < r55) goto L179;
        r55 = r54;
    L179:
        int r56 = this.Y;
        int r57 = this.f11858f0;
        if (r56 < r57) goto L183;
        r57 = r56;
    L183:
        p.h r213 = r14;
        a[] r110 = this.V;
        int r214 = r55;
        a r58 = r110[0];
        p.h r312 = r16;
        a r59 = a.f11893m;
        p.h r313 = r18;
        if (r58 == r59) goto L186;
        boolean r215 = true;
    L187:
        a r60 = r110[1];
        int r314 = r57;
        if (r60 == r59) goto L190;
        boolean r216 = true;
    L191:
        int r61 = this.f11849a0;
        this.B = r61;
        float r64 = this.Z;
        this.C = r64;
        int r111 = this.f11883s;
        int r112 = this.f11884t;
        if (r64 <= 0.0f) goto L281;
        a[] r315 = r110;
        if (this.f11866j0 == 8) goto L282;
        if (r58 != r59) goto L198;
        if (r111 != 0) goto L198;
        r111 = 3;
    L198:
        if (r60 != r59) goto L202;
        if (r112 != 0) goto L202;
        r112 = 3;
    L202:
        if (r58 != r59) goto L263;
        if (r60 != r59) goto L263;
        if (r111 != 3) goto L263;
        if (r112 != 3) goto L263;
        if (r61 != (-1)) goto L218;
        if (r215 == false) goto L212;
        if (r216 == true) goto L212;
        this.B = 0;
    L212:
        if (r215 == true) goto L218;
        if (r216 == false) goto L218;
        this.B = 1;
        if (r61 != (-1)) goto L218;
        this.C = 1.0f / r64;
    L218:
        if (this.B != 0) goto L225;
        if (r11.h() == true) goto L222;
    L223:
        int r65 = 1;
    L231:
        this.B = r65;
    L233:
        if (this.B != (-1)) goto L253;
        if (r11.h() == false) goto L243;
        if (r15.h() == false) goto L243;
        if (r8.h() == false) goto L243;
        if (r10.h() == true) goto L253;
    L243:
        if (r11.h() == false) goto L248;
        if (r15.h() == false) goto L248;
        this.B = 0;
    L248:
        if (r8.h() == false) goto L253;
        if (r10.h() == false) goto L253;
        this.C = 1.0f / this.C;
        this.B = 1;
    L253:
        if (this.B != (-1)) goto L278;
        int r66 = this.f11886v;
        if (r66 > 0) goto L257;
    L259:
        if (r66 != 0) goto L278;
        if (this.f11889y <= 0) goto L278;
        this.C = 1.0f / this.C;
        this.B = 1;
        goto L278
    L257:
        if (this.f11889y != 0) goto L259;
        this.B = 0;
    L278:
        int r67 = r214;
    L279:
        int r68 = r314;
    L280:
        int r410 = r68;
        int r411 = r111;
        int r412 = r112;
        boolean r316 = true;
    L285:
        int[] r69 = this.f11885u;
        r69[0] = r411;
        r69[1] = r412;
        if (r316 == false) goto L291;
        int r70 = this.B;
        int r71 = -1;
        if (r70 == 0) goto L290;
        if (r70 == (-1)) goto L290;
    L292:
        boolean r317 = false;
    L293:
        if (r316 == false) goto L298;
        int r72 = this.B;
        if (r72 == 1) goto L297;
        if (r72 != r71) goto L298;
    L297:
        char r73 = 0;
        boolean r413 = true;
    L299:
        a r74 = r315[r73];
        a r113 = a.f11892b;
        if (r74 == r113) goto L302;
    L304:
        boolean r114 = false;
    L305:
        if (r114 == false) goto L307;
        int r115 = 0;
    L308:
        d r116 = this.R;
        boolean r414 = !r116.h();
        boolean r415 = r211[0];
        boolean r416 = r211[1];
        int r75 = this.f11877p;
        int[] r76 = this.D;
        if (r75 != 2) goto L311;
    L345:
        d r510 = r15;
        p.h r318 = r12;
        p.h r319 = r13;
    L346:
        if (r63 == false) goto L364;
        ?? r117 = this;
        n r77 = r117.f11855e;
        if (r77 == null) goto L363;
        t.f r78 = r77.f12200h;
        if (r78.f12168j == false) goto L363;
        if (r77.f12201i.f12168j == false) goto L363;
        r62 = r62;
        r213 = r213;
        r62.d(r213, r78.f12165g);
        r312 = r312;
        r62.d(r312, r117.f11855e.f12201i.f12165g);
        r313 = r313;
        r62.d(r313, r117.f11855e.f12185k.f12165g);
        e r79 = r117.W;
        if (r79 == null) goto L361;
        if (r310 == true) goto L361;
        if (r28 == false) goto L361;
        int r118 = 1;
        if (r49[1] == false) goto L360;
        int r80 = 8;
        int r119 = 0;
        r62.f(r62.l(r79.N), r312, 0, 8);
    L362:
        int r81 = r119;
        ?? r120 = r117;
    L367:
        if (r120.f11879q != 2) goto L369;
        int r82 = r119;
    L370:
        if (r82 == 0) goto L411;
        if (r120.f11871m == true) goto L411;
        if (r315[r118] == r113) goto L376;
    L378:
        ?? r83 = r119;
    L379:
        if (r83 == 0) goto L381;
        r410 = r119;
    L381:
        e r84 = r120.W;
        if (r84 == null) goto L384;
        p.h r85 = r62.l(r84.N);
    L385:
        e r86 = r120.W;
        if (r86 == null) goto L388;
        p.h r87 = r62.l(r86.L);
    L389:
        int r88 = r120.d0;
        if (r88 <= 0) goto L392;
    L393:
        d r89 = r212;
        if (r89.f11835f == null) goto L400;
        r62.e(r313, r213, r88, r80);
        r62.e(r313, r62.l(r89.f11835f), r89.e(), r80);
        if (r28 == false) goto L398;
        r62.f(r85, r62.l(r510), r119, 5);
    L398:
        ?? r217 = r119;
    L404:
        boolean r90 = r49[r118];
        a r91 = r315[r118];
        d r92 = r120.L;
        d r93 = r120.N;
        int r94 = r120.f11853c0;
        int r95 = r120.f11858f0;
        int r121 = r76[r118];
        float r96 = r120.f11862h0;
        if (r315[r119] != r59) goto L407;
        boolean r122 = true;
    L408:
        e(r62, false, r28, r29, r90, r87, r85, r91, r83, r92, r93, r94, r410, r95, r121, r96, r413, r122, r310, r311, r416, r412, r411, r120.f11889y, r120.f11890z, r120.A, r217);
        goto L411
    L407:
        r122 = false;
        goto L408
    L400:
        if (r120.f11866j0 != r80) goto L402;
        r88 = r89.e();
    L402:
        r62.e(r313, r213, r88, r80);
    L403:
        r217 = r414;
        goto L404
    L392:
        if (r120.f11866j0 != r80) goto L403;
    L388:
        r87 = null;
        goto L389
    L384:
        r85 = null;
        goto L385
    L376:
        if ((r120 instanceof f) == false) goto L378;
        r83 = r118;
    L411:
        if (r316 == false) goto L418;
        int r97 = this.B;
        float r98 = this.C;
        if (r97 != 1) goto L415;
        p.h r99 = r312;
        p.h r100 = r213;
        p.h r101 = r319;
        p.h r102 = r318;
    L416:
        r62.h(r99, r100, r102, r101, r98);
        goto L418
    L415:
        r102 = r312;
        r101 = r213;
        r100 = r319;
        r99 = r318;
    L418:
        if (r116.h() == false) goto L420;
        e r103 = r116.f11835f.f11833d;
        float r104 = (float) Math.toRadians(this.E + 90.0f);
        int r105 = r116.e();
        d.a r106 = d.a.f11839a;
        p.h r107 = r62.l(j(r106));
        d.a r108 = d.a.f11840b;
        p.h r109 = r62.l(j(r108));
        d.a r123 = d.a.f11841m;
        p.h r124 = r62.l(j(r123));
        d.a r125 = d.a.f11842n;
        p.h r126 = r62.l(j(r125));
        p.h r127 = r62.l(r103.j(r106));
        p.h r128 = r62.l(r103.j(r108));
        p.h r129 = r62.l(r103.j(r123));
        p.h r130 = r62.l(r103.j(r125));
        p.b r131 = r62.m();
        double r132 = r104;
        double r133 = r105;
        float r134 = (float) (Math.sin(r132) * r133);
        r131.f9864d.e(r128, 0.5f);
        r131.f9864d.e(r130, 0.5f);
        r131.f9864d.e(r109, -0.5f);
        r131.f9864d.e(r126, -0.5f);
        r131.f9862b = -r134;
        r62.c(r131);
        p.b r135 = r62.m();
        float r136 = (float) (Math.cos(r132) * r133);
        r135.f9864d.e(r127, 0.5f);
        r135.f9864d.e(r129, 0.5f);
        r135.f9864d.e(r107, -0.5f);
        r135.f9864d.e(r124, -0.5f);
        r135.f9862b = -r136;
        r62.c(r135);
    L420:
        this.f11869l = false;
        this.f11871m = false;
        return;
    L369:
        r82 = r81;
        goto L370
    L360:
        r80 = 8;
        r119 = 0;
    L361:
        r80 = 8;
        r119 = 0;
        r118 = 1;
    L363:
        r80 = 8;
        r119 = 0;
        r118 = 1;
        ?? r137 = r117;
    L365:
        r81 = r118;
        r120 = r137;
        goto L367
    L364:
        r80 = 8;
        r119 = 0;
        r118 = 1;
        r137 = this;
        goto L365
    L311:
        if (this.f11869l == true) goto L345;
        if (r63 == false) goto L332;
        t.l r138 = this.f11854d;
        if (r138 == null) goto L332;
        t.f r139 = r138.f12200h;
        if (r139.f12168j == false) goto L332;
        if (r138.f12201i.f12168j == false) goto L332;
        if (r63 == false) goto L345;
        r62.d(r13, r139.f12165g);
        r62.d(r12, this.f11854d.f12201i.f12165g);
        if (this.W == null) goto L330;
        if (r29 == false) goto L330;
        if (r49[0] == false) goto L330;
        if (x() == true) goto L330;
        r62.f(r62.l(this.W.M), r12, 0, 8);
    L330:
        r319 = r13;
        r510 = r15;
        r318 = r12;
    L332:
        e r140 = this.W;
        if (r140 == null) goto L335;
        p.h r141 = r62.l(r140.M);
    L336:
        e r142 = this.W;
        if (r142 == null) goto L339;
        p.h r143 = r62.l(r142.K);
    L340:
        boolean r218 = r49[0];
        a r219 = r315[0];
        d r144 = this.K;
        d r145 = this.M;
        int r146 = this.f11851b0;
        int r147 = this.f11856e0;
        int r320 = r76[0];
        float r148 = this.f11860g0;
        if (r315[1] != r59) goto L343;
        boolean r511 = true;
    L344:
        r510 = r15;
        r318 = r12;
        r319 = r13;
        e(r62, true, r29, r28, r218, r143, r141, r219, r114, r144, r145, r146, r115, r147, r320, r148, r317, r511, r311, r310, r415, r411, r412, this.f11886v, this.f11887w, this.f11888x, r414);
        goto L346
    L343:
        r511 = false;
        goto L344
    L339:
        r143 = null;
        goto L340
    L335:
        r141 = null;
        goto L336
    L307:
        r115 = r67;
        goto L308
    L302:
        if ((this instanceof f) == false) goto L304;
        r114 = true;
    L298:
        r73 = 0;
        r413 = false;
    L290:
        r317 = true;
        goto L293
    L291:
        r71 = -1;
        goto L292
    L222:
        if (r15.h() == false) goto L223;
    L225:
        if (this.B != 1) goto L233;
        if (r8.h() == true) goto L229;
    L230:
        r65 = 0;
        goto L231
    L229:
        if (r10.h() == true) goto L233;
    L263:
        int r149 = 4;
        if (r58 != r59) goto L269;
        if (r111 != 3) goto L269;
        this.B = 0;
        r67 = (int) (r64 * r56);
        if (r60 == r59) goto L279;
        r111 = 4;
    L283:
        r149 = r112;
        r68 = r314;
    L284:
        r412 = r149;
        r410 = r68;
        r411 = r111;
        r316 = false;
    L269:
        if (r60 != r59) goto L278;
        if (r112 != 3) goto L278;
        this.B = 1;
        if (r61 != (-1)) goto L274;
        this.C = 1.0f / r64;
    L274:
        r68 = (int) (this.C * r54);
        if (r58 == r59) goto L277;
        r67 = r214;
        goto L284
    L277:
        r67 = r214;
    L282:
        r67 = r214;
        goto L283
    L281:
        r315 = r110;
        goto L282
    L190:
        r216 = false;
        goto L191
    L186:
        r215 = false;
        goto L187
    L146:
        if (w(0) == false) goto L148;
        ((f) this.W).R(0, this);
        boolean r150 = true;
    L150:
        if (w(1) == false) goto L152;
        ((f) this.W).R(1, this);
        boolean r151 = true;
    L153:
        if (r150 == true) goto L163;
        if (r29 == false) goto L163;
        if (this.f11866j0 == 8) goto L163;
        if (r8.f11835f != null) goto L163;
        if (r10.f11835f != null) goto L163;
        r62.f(r62.l(this.W.M), r12, 0, 1);
    L163:
        if (r151 == true) goto L173;
        if (r28 == false) goto L173;
        if (this.f11866j0 == 8) goto L173;
        if (r11.f11835f != null) goto L173;
        if (r15.f11835f != null) goto L173;
        if (r212 != null) goto L173;
        r62.f(r62.l(this.W.N), r16, 0, 1);
    L173:
        r310 = r151;
        r311 = r150;
        goto L175
    L152:
        r151 = y();
        goto L153
    L148:
        r150 = x();
    L142:
        r212 = r17;
        goto L144
    L108:
        if (this.f11871m == false) goto L111;
        this.f11869l = r48;
        this.f11871m = r48;
        return;
    L80:
        if (r42.size() <= 0) goto L82;
        r43 = true;
    L104:
        r48 = false;
        goto L106
    L68:
        if (r41.get() == null) goto L71;
        if (r10.d() <= r39.L0.get().d()) goto L75;
    L59:
        if (r40.get() == null) goto L63;
        r211 = r27;
        if (r8.d() <= r39.J0.get().d()) goto L65;
    L72:
        r211 = r27;
        r62.f(r62.l(r38.M), r12, 0, 5);
    L73:
        r211 = r27;
        goto L75
    L46:
        if (this.f11871m == true) goto L49;
        r211 = r27;
        goto L111
    L15:
        if (r25 != 2) goto L17;
    L21:
        r28 = r24;
        r29 = false;
        goto L22
    L17:
        if (r25 == 3) goto L20;
        r28 = r24;
        r29 = r23;
        goto L22
    L11:
        r24 = false;
        goto L12
    L7:
        r23 = false;
    L20:
        r24 = false;
        goto L21
    }

    public boolean d() {
        if (this.f11866j0 == 8) goto L5;
        return true;
    L5:
        return false;
    }

    public final void e(p.d r36, boolean r37, boolean r38, boolean r39, boolean r40, p.h r41, p.h r42, a r43, boolean r44, d r45, d r46, int r47, int r48, int r49, int r50, float r51, boolean r52, boolean r53, boolean r54, boolean r55, boolean r56, int r57, int r58, int r59, int r60, float r61, boolean r62) {
        int r8 = r59;
        int r10 = r60;
        p.h r11 = r36.l(r45);
        p.h r12 = r36.l(r46);
        p.h r13 = r36.l(r45.f11835f);
        p.h r14 = r36.l(r46.f11835f);
        boolean r16 = r45.h();
        boolean r17 = r46.h();
        boolean r15 = this.R.h();
        if (r17 == false) goto L5;
        int r18 = (r16 ? 1 : 0) + 1;
    L6:
        if (r15 == false) goto L8;
        r18 = r18 + 1;
    L8:
        int r19 = r18;
        if (r52 == false) goto L11;
        int r110 = 3;
    L12:
        int r111 = r43.ordinal();
        if (r111 == 0) goto L22;
        if (r111 == 1) goto L22;
        if (r111 != 2) goto L22;
        if (r110 == 4) goto L22;
        boolean r112 = true;
    L23:
        int r20 = this.f11863i;
        boolean r22 = r112;
        if (r20 == (-1)) goto L27;
        if (r37 == false) goto L27;
        this.f11863i = -1;
        r48 = r20;
        r22 = false;
    L27:
        int r21 = this.f11865j;
        if (r21 == (-1)) goto L31;
        if (r37 == true) goto L31;
        this.f11865j = -1;
        r22 = false;
    L32:
        int r410 = r21;
        if (this.f11866j0 != 8) goto L35;
        int r113 = 0;
        r22 = false;
    L36:
        if (r62 == false) goto L45;
        if (r16 == true) goto L41;
        if (r17 == true) goto L41;
        if (r15 == true) goto L41;
        r36.d(r11, r47);
    L44:
        int r114 = 8;
    L46:
        if (r22 == true) goto L58;
        if (r44 == false) goto L55;
        r36.e(r12, r11, 0, 3);
        if (r49 <= 0) goto L53;
        r36.f(r12, r11, r49, r114);
    L53:
        if (r50 >= Integer.MAX_VALUE) goto L94;
        r36.g(r12, r11, r50, r114);
    L94:
        boolean r115 = r40;
        r19 = r19 == true ? 1 : 0;
    L95:
        int r116 = r8;
        if (r62 == false) goto L336;
        if (r54 == false) goto L114;
        int r23 = 8;
        int r24 = 0;
        char r25 = 2;
        int r26 = 1;
    L337:
        if (r19 >= r25) goto L368;
        if (r38 == false) goto L369;
        if (r115 == false) goto L370;
        r36.f(r11, r41, r24, r23);
        d r27 = this.O;
        if (r37 == false) goto L343;
    L346:
        int r28 = r26;
    L347:
        if (r37 == true) goto L358;
        d r29 = r27.f11835f;
        if (r29 == null) goto L358;
        e r30 = r29.f11833d;
        if (r30.Z == 0.0f) goto L357;
        a[] r31 = r30.V;
        a r32 = r31[r24];
        a r33 = a.f11893m;
        if (r32 != r33) goto L357;
        if (r31[r26] != r33) goto L357;
    L359:
        if (r26 == 0) goto L371;
        r36.f(r42, r12, r24, r23);
        return;
    L371:
        return;
    L357:
        r26 = r24;
    L358:
        r26 = r28;
        goto L359
    L343:
        if (r27.f11835f == null) goto L346;
        r28 = r24;
        goto L347
    L370:
        return;
    L369:
        return;
    L368:
        return;
    L114:
        if (r16 == true) goto L119;
        if (r17 == true) goto L119;
        if (r15 == true) goto L119;
        p.h r34 = r14;
    L118:
        int r35 = 0;
    L133:
        p.h r63 = r34;
        int r64 = 5;
    L134:
        int r65 = r35;
        p.h r66 = r12;
        boolean r210 = r38;
    L327:
        if (r210 == false) goto L365;
        if (r115 == true) goto L330;
        return;
    L330:
        if (r46.f11835f == null) goto L333;
        r65 = r46.e();
    L333:
        if (r63 == r42) goto L367;
        r36.f(r42, r66, r65, r64);
        return;
    L367:
        return;
    L365:
        return;
    L119:
        if (r16 == false) goto L128;
        if (r17 == true) goto L128;
        e r67 = r45.f11835f.f11833d;
        if (r38 == true) goto L124;
    L126:
        int r68 = 5;
    L127:
        r210 = r38;
        r46 = r46;
        r64 = r68;
        r66 = r12;
        r115 = r115;
        r63 = r14;
    L325:
        r65 = 0;
        goto L327
    L124:
        if ((r67 instanceof s.a) == false) goto L126;
        r68 = 8;
    L128:
        if (r16 == true) goto L135;
        if (r17 == false) goto L135;
        r34 = r14;
        r36.e(r12, r34, -r46.e(), 8);
        if (r38 == false) goto L118;
        r64 = 5;
        r35 = 0;
        r36.f(r11, r41, 0, 5);
        r63 = r34;
    L135:
        r34 = r14;
        r35 = 0;
        if (r16 == false) goto L133;
        if (r17 == false) goto L133;
        e r69 = r45.f11835f.f11833d;
        r46 = r46;
        e r70 = r46.f11835f.f11833d;
        e r117 = this.W;
        int r118 = 6;
        if (r22 == false) goto L212;
        if (r110 != 0) goto L158;
        if (r10 != 0) goto L150;
        if (r116 != 0) goto L150;
        if (r13.f9900p == true) goto L146;
    L149:
        int r119 = 8;
        int r120 = 8;
        boolean r211 = true;
        boolean r212 = false;
        boolean r213 = false;
    L152:
        if ((r69 instanceof s.a) == false) goto L154;
    L157:
        r110 = r110;
        int r71 = r119;
        boolean r121 = true;
        int r122 = 8;
    L208:
        r42 = r42;
        int r214 = r71;
        r118 = 6;
        boolean r215 = r211;
        int r72 = 5;
        int r216 = 4;
    L228:
        if (r212 == false) goto L232;
        if (r13 != r34) goto L232;
        if (r69 == r117) goto L232;
        boolean r217 = false;
        boolean r218 = false;
    L233:
        if (r213 == false) goto L242;
        if (r22 == true) goto L240;
        if (r53 == true) goto L240;
        if (r55 == true) goto L240;
        if (r13 != r41) goto L240;
        if (r34 != r42) goto L240;
        int r219 = r122;
        r214 = r219;
        r210 = false;
        r217 = false;
    L241:
        int r123 = 4;
        boolean r220 = true;
        r36.b(r11, r13, r45.e(), r51, r34, r12, r46.e(), r219);
    L243:
        boolean r73 = r217;
        if (this.f11866j0 != r122) goto L254;
        HashSet<d> r74 = r46.f11830a;
        if (r74 != null) goto L249;
    L251:
        boolean r75 = false;
    L252:
        if (r75 == true) goto L254;
        return;
    L249:
        if (r74.size() <= 0) goto L251;
        r75 = r220;
    L254:
        r63 = r34;
        if (r218 == false) goto L266;
        if (r210 == false) goto L264;
        if (r13 == r63) goto L264;
        if (r22 == true) goto L264;
        if ((r69 instanceof s.a) == false) goto L262;
    L263:
        int r76 = 6;
    L265:
        p.h r77 = r11;
        r36.f(r77, r13, r45.e(), r76);
        r66 = r12;
        r36.g(r66, r63, -r46.e(), r76);
        r214 = r76;
    L267:
        if (r210 == false) goto L275;
        if (r56 == false) goto L275;
        if ((r69 instanceof s.a) == true) goto L275;
        if ((r70 instanceof s.a) == true) goto L275;
        if (r70 == r117) goto L275;
        int r78 = 6;
        int r79 = 6;
        r73 = r220;
    L276:
        if (r73 == false) goto L307;
        if (r215 == false) goto L298;
        if (r55 == false) goto L280;
        if (r39 == false) goto L298;
    L280:
        if (r69 == r117) goto L284;
        if (r70 == r117) goto L284;
        int r80 = r78;
    L286:
        if ((r69 instanceof h) == false) goto L288;
    L289:
        r80 = 5;
    L291:
        if ((r69 instanceof s.a) == false) goto L293;
    L294:
        r80 = 5;
    L295:
        if (r55 == false) goto L297;
        r80 = 5;
    L297:
        r78 = Math.max(r80, r78);
        goto L298
    L293:
        if ((r70 instanceof s.a) == false) goto L295;
    L288:
        if ((r70 instanceof h) == false) goto L291;
    L284:
        r80 = 6;
    L298:
        int r81 = r78;
        if (r210 == false) goto L306;
        r81 = Math.min(r79, r81);
        if (r52 == false) goto L306;
        if (r55 == true) goto L306;
        if (r69 == r117) goto L305;
        if (r70 != r117) goto L306;
    L305:
        r81 = r123;
    L306:
        r36.e(r77, r13, r45.e(), r81);
        r36.e(r66, r63, -r46.e(), r81);
    L307:
        if (r210 == false) goto L314;
        int r82 = r122;
        if (r41 != r13) goto L311;
        int r83 = r45.e();
    L312:
        if (r13 == r41) goto L315;
        r64 = 5;
        r36.f(r77, r41, r83, 5);
    L316:
        if (r210 == false) goto L325;
        if (r22 == false) goto L325;
        if (r49 != 0) goto L325;
        if (r116 != 0) goto L325;
        if (r22 == true) goto L322;
    L324:
        r65 = 0;
        r36.f(r66, r77, 0, r64);
        goto L327
    L322:
        if (r110 != 3) goto L324;
        r65 = 0;
        r36.f(r66, r77, 0, r82);
    L315:
        r64 = 5;
        goto L316
    L311:
        r83 = 0;
        goto L312
    L314:
        r82 = r122;
    L275:
        r78 = r216;
        r79 = r214;
        goto L276
    L262:
        if ((r70 instanceof s.a) == true) goto L263;
    L264:
        r76 = r214;
        goto L265
    L266:
        r66 = r12;
        r77 = r11;
    L240:
        r219 = r118;
        r210 = r38;
        goto L241
    L242:
        r220 = r121;
        r123 = 4;
        r210 = r38;
    L232:
        r218 = r212;
        r217 = r121;
        goto L233
    L154:
        if ((r70 instanceof s.a) == true) goto L157;
        r214 = r119;
        r215 = r211;
        r72 = 5;
        r121 = true;
        r122 = 8;
        r216 = r120;
        r110 = r110;
    L172:
        r42 = r42;
        goto L228
    L146:
        if (r34.f9900p == false) goto L149;
        r36.e(r11, r13, r45.e(), 8);
        r36.e(r12, r34, -r46.e(), 8);
        return;
    L150:
        r119 = 5;
        r120 = 5;
        r211 = false;
        r212 = true;
        r213 = true;
        goto L152
    L158:
        r122 = 8;
        if (r110 != 2) goto L169;
        if ((r69 instanceof s.a) == false) goto L163;
    L166:
        int r84 = 4;
    L167:
        int r124 = 5;
    L171:
        r216 = r84;
        r110 = r110;
        r214 = r124;
        r72 = 5;
        r121 = true;
        r212 = true;
        r213 = true;
        r215 = false;
        goto L172
    L163:
        if ((r70 instanceof s.a) == true) goto L166;
        r84 = 5;
        goto L167
    L169:
        if (r110 != 1) goto L174;
        r124 = 8;
        r84 = 4;
        goto L171
    L174:
        if (r110 != 3) goto L211;
        r110 = r110;
        if (this.B != (-1)) goto L183;
        if (r55 == false) goto L181;
        if (r38 == false) goto L180;
        int r85 = 5;
    L182:
        r42 = r42;
        r118 = r85;
        r214 = 8;
        r72 = 5;
        r121 = true;
        r216 = 5;
        r212 = true;
        r213 = true;
        r215 = true;
        goto L228
    L180:
        r85 = 4;
        goto L182
    L181:
        r85 = 8;
        goto L182
    L183:
        if (r52 == true) goto L185;
        r121 = true;
        if (r10 <= 0) goto L199;
        int r86 = 5;
    L210:
        r42 = r42;
        r216 = r86;
        r212 = true;
        r213 = true;
        r215 = true;
        r118 = 6;
        r72 = 5;
        r214 = 5;
        goto L228
    L199:
        if (r10 != 0) goto L209;
        if (r116 != 0) goto L209;
        if (r55 == true) goto L203;
        r86 = 8;
        goto L210
    L203:
        if (r69 == r117) goto L206;
        if (r70 == r117) goto L206;
        r71 = 4;
    L207:
        r211 = true;
        r212 = true;
        r213 = true;
    L206:
        r71 = 5;
    L209:
        r86 = 4;
        goto L210
    L185:
        if (r58 == 2) goto L190;
        r121 = true;
        if (r58 == 1) goto L191;
        boolean r87 = false;
    L192:
        if (r87 == true) goto L194;
        int r125 = 8;
        int r88 = 5;
    L195:
        r216 = r88;
        r214 = r125;
        r212 = r121;
        r213 = r212;
        r215 = r213;
        r72 = 5;
        goto L172
    L194:
        r88 = 4;
        r125 = 5;
    L191:
        r87 = r121;
        goto L192
    L190:
        r121 = true;
        goto L191
    L211:
        r121 = true;
        r72 = 5;
        boolean r221 = false;
        boolean r222 = false;
    L227:
        r214 = r72;
        r212 = r221;
        r213 = r222;
        r216 = 4;
        r215 = false;
        r118 = 6;
        goto L228
    L212:
        r121 = true;
        r122 = 8;
        if (r13.f9900p == true) goto L215;
    L226:
        r72 = 5;
        r221 = true;
        r222 = true;
        goto L227
    L215:
        if (r34.f9900p == false) goto L226;
        r36.b(r11, r13, r45.e(), r51, r34, r12, r46.e(), 8);
        if (r38 == false) goto L362;
        if (r115 == true) goto L220;
        return;
    L220:
        if (r46.f11835f == null) goto L222;
        int r89 = r46.e();
    L223:
        if (r34 == r42) goto L364;
        r36.f(r42, r12, r89, 5);
        return;
    L364:
        return;
    L222:
        r89 = 0;
        goto L223
    L362:
        return;
    L336:
        r23 = 8;
        r24 = 0;
        r26 = 1;
        r25 = 2;
        goto L337
    L55:
        r36.e(r12, r11, r113, r114);
        goto L94
    L58:
        if (r19 == 2) goto L68;
        if (r52 == true) goto L68;
        if (r110 == 1) goto L63;
        if (r110 != 0) goto L68;
    L63:
        int r90 = Math.max(r8, r113);
        if (r10 <= 0) goto L66;
        r90 = Math.min(r10, r90);
    L66:
        r36.e(r12, r11, r90, 8);
        r22 = false;
    L68:
        if (r8 != (-2)) goto L70;
        r8 = r113;
    L70:
        if (r10 != (-2)) goto L72;
        r10 = r113;
    L72:
        if (r113 > 0) goto L74;
    L76:
        if (r8 <= 0) goto L78;
        r36.f(r12, r11, r8, 8);
        r113 = Math.max(r113, r8);
    L78:
        if (r10 <= 0) goto L88;
        if (r38 == true) goto L81;
    L83:
        boolean r91 = true;
    L84:
        if (r91 == false) goto L86;
        int r92 = 8;
        r36.g(r12, r11, r10, 8);
    L87:
        r113 = Math.min(r113, r10);
    L90:
        if (r110 != 1) goto L97;
        if (r38 == false) goto L93;
        r36.e(r12, r11, r113, r92);
        goto L94
    L93:
        r36.e(r12, r11, r113, 5);
        r36.g(r12, r11, r113, r92);
        goto L94
    L97:
        if (r110 != 2) goto L109;
        d.a r93 = d.a.f11840b;
        d.a r126 = r45.f11834e;
        if (r126 != r93) goto L101;
    L104:
        p.h r94 = r36.l(this.W.j(r93));
        e r127 = this.W;
        d.a r128 = d.a.f11842n;
    L105:
        p.h r129 = r36.l(r127.j(r128));
        p.b r130 = r36.m();
        r130.f9864d.e(r12, -1.0f);
        r130.f9864d.e(r11, 1.0f);
        r130.f9864d.e(r129, r61);
        r130.f9864d.e(r94, -r61);
        r36.c(r130);
        if (r38 == false) goto L108;
        r22 = false;
    L108:
        boolean r95 = r40;
    L110:
        r115 = r95;
        goto L95
    L101:
        if (r126 == d.a.f11842n) goto L104;
        r94 = r36.l(this.W.j(d.a.f11839a));
        r127 = this.W;
        r128 = d.a.f11841m;
        goto L105
    L109:
        r95 = true;
        goto L110
    L86:
        r92 = 8;
        goto L87
    L81:
        if (r110 != 1) goto L83;
        r91 = false;
        goto L84
    L88:
        r92 = 8;
        goto L90
    L74:
        if (r110 == 1) goto L76;
        r113 = 0;
    L41:
        if (r16 == false) goto L44;
        if (r17 == true) goto L44;
        r114 = 8;
        r36.e(r11, r13, r45.e(), 8);
        goto L46
    L45:
        r114 = 8;
        goto L46
    L35:
        r113 = r410;
    L31:
        r21 = r48;
    L22:
        r112 = false;
        goto L23
    L11:
        r110 = r57;
        goto L12
    L5:
        r18 = r16 ? 1 : 0;
        goto L6
    }

    public final void f(d.a r10, e r11, d.a r12, int r13) {
        d.a r8 = d.a.f11844p;
        if (r10 != r8) goto L42;
        d.a r14 = d.a.f11839a;
        if (r12 != r8) goto L31;
        d r15 = j(r14);
        d.a r16 = d.a.f11841m;
        d r17 = j(r16);
        d.a r18 = d.a.f11840b;
        d r19 = j(r18);
        d.a r20 = d.a.f11842n;
        d r21 = j(r20);
        boolean r22 = true;
        if (r15 != null) goto L9;
    L10:
        if (r17 != null) goto L12;
    L14:
        f(r14, r11, r14, 0);
        f(r16, r11, r16, 0);
        boolean r23 = true;
    L15:
        if (r19 != null) goto L17;
    L18:
        if (r21 != null) goto L20;
    L22:
        f(r18, r11, r18, 0);
        f(r20, r11, r20, 0);
    L23:
        if (r23 == false) goto L26;
        if (r22 == false) goto L26;
        d r24 = j(r8);
        d r25 = r11.j(r8);
    L63:
        r24.a(r25, 0);
        return;
    L26:
        if (r23 == false) goto L28;
        d.a r26 = d.a.f11845q;
    L30:
        r24 = j(r26);
        r25 = r11.j(r26);
        goto L63
    L28:
        if (r22 == false) goto L100;
        r26 = d.a.f11846r;
        goto L30
    L100:
        return;
    L20:
        if (r21.h() == false) goto L22;
    L21:
        r22 = false;
        goto L23
    L17:
        if (r19.h() == true) goto L21;
    L12:
        if (r17.h() == false) goto L14;
    L13:
        r23 = false;
        goto L15
    L9:
        if (r15.h() == true) goto L13;
    L31:
        if (r12 != r14) goto L33;
    L40:
        f(r14, r11, r12, 0);
        d.a r27 = d.a.f11841m;
    L41:
        f(r27, r11, r12, 0);
        r24 = j(r8);
    L62:
        r25 = r11.j(r12);
        goto L63
    L33:
        if (r12 == d.a.f11841m) goto L40;
        d.a r28 = d.a.f11840b;
        if (r12 != r28) goto L38;
    L39:
        f(r28, r11, r12, 0);
        r27 = d.a.f11842n;
        goto L41
    L38:
        if (r12 == d.a.f11842n) goto L39;
        return;
    L42:
        d.a r29 = d.a.f11845q;
        if (r10 != r29) goto L49;
        d.a r30 = d.a.f11839a;
        if (r12 != r30) goto L47;
    L48:
        d r31 = j(r30);
        d r110 = r11.j(r12);
        d r111 = j(d.a.f11841m);
        r31.a(r110, 0);
        r111.a(r110, 0);
        j(r29).a(r110, 0);
        return;
    L47:
        if (r12 == d.a.f11841m) goto L48;
    L49:
        d.a r32 = d.a.f11846r;
        if (r10 != r32) goto L56;
        d.a r33 = d.a.f11840b;
        if (r12 != r33) goto L54;
    L55:
        r25 = r11.j(r12);
        j(r33).a(r25, 0);
        j(d.a.f11842n).a(r25, 0);
        r24 = j(r32);
        goto L63
    L54:
        if (r12 == d.a.f11842n) goto L55;
    L56:
        if (r10 != r29) goto L59;
        if (r12 != r29) goto L59;
        d.a r34 = d.a.f11839a;
        j(r34).a(r11.j(r34), 0);
        d.a r35 = d.a.f11841m;
        j(r35).a(r11.j(r35), 0);
        r24 = j(r29);
    L59:
        if (r10 != r32) goto L64;
        if (r12 != r32) goto L64;
        d.a r36 = d.a.f11840b;
        j(r36).a(r11.j(r36), 0);
        d.a r37 = d.a.f11842n;
        j(r37).a(r11.j(r37), 0);
        r24 = j(r32);
    L64:
        d r38 = j(r10);
        d r112 = r11.j(r12);
        if (r38.i(r112) == false) goto L104;
        d.a r113 = d.a.f11843o;
        if (r10 != r113) goto L74;
        d r39 = j(d.a.f11840b);
        d r40 = j(d.a.f11842n);
        if (r39 == null) goto L71;
        r39.j();
    L71:
        if (r40 != null) goto L97;
    L98:
        r38.a(r112, r13);
        return;
    L97:
        r40.j();
        goto L98
    L74:
        if (r10 != d.a.f11840b) goto L76;
    L88:
        d r114 = j(r113);
        if (r114 == null) goto L91;
        r114.j();
    L91:
        d r115 = j(r8);
        if (r115.f11835f == r112) goto L94;
        r115.j();
    L94:
        d r41 = j(r10).f();
        r40 = j(r32);
        if (r40.h() == false) goto L98;
    L96:
        r41.j();
        goto L97
    L76:
        if (r10 == d.a.f11842n) goto L88;
        if (r10 != d.a.f11839a) goto L81;
    L82:
        d r116 = j(r8);
        if (r116.f11835f == r112) goto L85;
        r116.j();
    L85:
        r41 = j(r10).f();
        r40 = j(r29);
        if (r40.h() == false) goto L98;
    L81:
        if (r10 != d.a.f11841m) goto L98;
    }

    public final void g(d r8, d r10, int r11) {
        if (r8.f11833d != this) goto L6;
        e r12 = r10.f11833d;
        f(r8.f11834e, r12, r10.f11834e, r11);
        return;
    }

    public final void h(p.d r8) {
        r8.l(this.K);
        r8.l(this.L);
        r8.l(this.M);
        r8.l(this.N);
        if (this.d0 <= 0) goto L6;
        r8.l(this.O);
        return;
    }

    public final void i() {
        if (this.f11854d != null) goto L6;
        this.f11854d = new t.l(this);
    L6:
        if (this.f11855e != null) goto L9;
        this.f11855e = new n(this);
        return;
    }

    public d j(d.a r8) {
        switch(r8.ordinal()) {
            case 0: goto L6;
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            default: goto L5;
        };
    L6:
        return null;
    L5:
        throw new AssertionError(r8.name());
    L9:
        return this.Q;
    L11:
        return this.P;
    L13:
        return this.R;
    L15:
        return this.O;
    L17:
        return this.N;
    L19:
        return this.M;
    L21:
        return this.L;
    L23:
        return this.K;
    }

    public final a k(int r8) {
        a[] r10 = this.V;
        if (r8 != 0) goto L7;
        return r10[0];
    L7:
        if (r8 == 1) goto L9;
        return null;
    L9:
        return r10[1];
    }

    public final int l() {
        if (this.f11866j0 != 8) goto L7;
        return 0;
    L7:
        return this.Y;
    }

    public final e m(int r8) {
        if (r8 != 0) goto L10;
        d r10 = this.M;
        d r11 = r10.f11835f;
        if (r11 != null) goto L6;
        return null;
    L6:
        if (r11.f11835f == r10) goto L8;
        return null;
    L8:
        return r11.f11833d;
    L10:
        if (r8 != 1) goto L20;
        d r12 = this.N;
        d r13 = r12.f11835f;
        if (r13 != null) goto L14;
        return null;
    L14:
        if (r13.f11835f == r12) goto L16;
        return null;
    L16:
        return r13.f11833d;
    L20:
        return null;
    }

    public void n(StringBuilder r16) {
        r16.append("  " + this.f11867k + ":{\n");
        StringBuilder r8 = new StringBuilder("    actualWidth:");
        r8.append(this.X);
        r16.append(r8.toString());
        r16.append("\n");
        r16.append("    actualHeight:" + this.Y);
        r16.append("\n");
        r16.append("    actualLeft:" + this.f11851b0);
        r16.append("\n");
        r16.append("    actualTop:" + this.f11853c0);
        r16.append("\n");
        p(r16, "left", this.K);
        p(r16, "top", this.L);
        p(r16, "right", this.M);
        p(r16, "bottom", this.N);
        p(r16, "baseline", this.O);
        p(r16, "centerX", this.P);
        p(r16, "centerY", this.Q);
        int r10 = this.X;
        int r11 = this.f11856e0;
        int[] r12 = this.D;
        int r13 = r12[0];
        int r14 = this.f11886v;
        int r15 = this.f11883s;
        float r17 = this.f11888x;
        a[] r18 = this.V;
        a r19 = r18[0];
        float[] r110 = this.f11874n0;
        float r20 = r110[0];
        o(r16, "    width", r10, r11, r13, r14, r15, r17, r19);
        int r21 = this.Y;
        int r22 = this.f11858f0;
        int r23 = r12[1];
        int r24 = this.f11889y;
        int r25 = this.f11884t;
        float r26 = this.A;
        a r27 = r18[1];
        float r28 = r110[1];
        o(r16, "    height", r21, r22, r23, r24, r25, r26, r27);
        float r29 = this.Z;
        int r30 = this.f11849a0;
        if (r29 == 0.0f) goto L6;
        r16.append("    dimensionRatio");
        r16.append(" :  [");
        r16.append(r29);
        r16.append(",");
        r16.append(r30);
        r16.append("");
        r16.append("],\n");
    L6:
        H(r16, "    horizontalBias", this.f11860g0, 0.5f);
        H(r16, "    verticalBias", this.f11862h0, 0.5f);
        G(this.f11870l0, 0, "    horizontalChainStyle", r16);
        G(this.f11872m0, 0, "    verticalChainStyle", r16);
        r16.append("  }");
    }

    public final int q() {
        if (this.f11866j0 != 8) goto L7;
        return 0;
    L7:
        return this.X;
    }

    public final int r() {
        e r8 = this.W;
        if (r8 == null) goto L9;
        if ((r8 instanceof f) == false) goto L9;
        return ((f) r8).f11902z0 + this.f11851b0;
    L9:
        return this.f11851b0;
    }

    public final int s() {
        e r8 = this.W;
        if (r8 == null) goto L9;
        if ((r8 instanceof f) == false) goto L9;
        return ((f) r8).A0 + this.f11853c0;
    L9:
        return this.f11853c0;
    }

    public final boolean t(int r8) {
        if (r8 != 0) goto L18;
        if (this.K.f11835f == null) goto L7;
        int r10 = 1;
    L9:
        if (this.M.f11835f == null) goto L11;
        int r11 = 1;
    L13:
        if ((r10 + r11) >= 2) goto L16;
        return true;
    L16:
        return false;
    L11:
        r11 = 0;
        goto L13
    L7:
        r10 = 0;
        goto L9
    L18:
        if (this.L.f11835f == null) goto L20;
        int r12 = 1;
    L22:
        if (this.N.f11835f == null) goto L24;
        int r13 = 1;
    L25:
        int r14 = r12 + r13;
        if (this.O.f11835f == null) goto L28;
        int r15 = 1;
    L30:
        if ((r14 + r15) >= 2) goto L33;
        return true;
    L33:
        return false;
    L28:
        r15 = 0;
        goto L30
    L24:
        r13 = 0;
        goto L25
    L20:
        r12 = 0;
        goto L22
    }

    public String toString() {
        String r8 = "";
        StringBuilder r10 = android.aimedia.a.j("");
        if (this.f11868k0 == null) goto L5;
        r8 = android.aimedia.a.i(new StringBuilder("id: "), this.f11868k0, " ");
    L5:
        r10.append(r8);
        r10.append("(");
        r10.append(this.f11851b0);
        r10.append(", ");
        r10.append(this.f11853c0);
        r10.append(") - (");
        r10.append(this.X);
        r10.append(" x ");
        return android.aimedia.a.h(r10, this.Y, ")");
    }

    public final boolean u(int r8, int r10) {
        if (r8 != 0) goto L17;
        d r11 = this.K;
        d r12 = r11.f11835f;
        if (r12 != null) goto L7;
    L30:
        return false;
    L7:
        if (r12.f11832c == false) goto L30;
        d r13 = this.M;
        d r14 = r13.f11835f;
        if (r14 == null) goto L30;
        if (r14.f11832c == false) goto L30;
        int r15 = r14.d() - r13.e();
        int r16 = r11.f11835f.d();
        if ((r15 - (r11.e() + r16)) < r10) goto L16;
        return true;
    L16:
        return false;
    L17:
        d r17 = this.L;
        d r18 = r17.f11835f;
        if (r18 == null) goto L30;
        if (r18.f11832c == false) goto L30;
        d r19 = this.N;
        d r20 = r19.f11835f;
        if (r20 == null) goto L30;
        if (r20.f11832c == false) goto L30;
        int r21 = r20.d() - r19.e();
        int r22 = r17.f11835f.d();
        if ((r21 - (r17.e() + r22)) < r10) goto L29;
        return true;
    L29:
        return false;
    }

    public final void v(d.a r8, e r10, d.a r11, int r12, int r13) {
        j(r8).b(r10.j(r11), r12, r13, true);
    }

    public final boolean w(int r8) {
        int r10 = r8 * 2;
        d[] r11 = this.S;
        d r12 = r11[r10];
        d r13 = r12.f11835f;
        if (r13 != null) goto L5;
    L11:
        return false;
    L5:
        if (r13.f11835f == r12) goto L11;
        d r14 = r11[r10 + 1];
        d r15 = r14.f11835f;
        if (r15 == null) goto L11;
        if (r15.f11835f != r14) goto L11;
        return true;
    }

    public final boolean x() {
        d r8 = this.K;
        d r10 = r8.f11835f;
        if (r10 != null) goto L5;
    L6:
        d r11 = this.M;
        d r12 = r11.f11835f;
        if (r12 != null) goto L9;
        return false;
    L9:
        if (r12.f11835f != r11) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r10.f11835f != r8) goto L6;
        return true;
    }

    public final boolean y() {
        d r8 = this.L;
        d r10 = r8.f11835f;
        if (r10 != null) goto L5;
    L6:
        d r11 = this.N;
        d r12 = r11.f11835f;
        if (r12 != null) goto L9;
        return false;
    L9:
        if (r12.f11835f != r11) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r10.f11835f != r8) goto L6;
        return true;
    }

    public final boolean z() {
        if (this.f11859g == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f11866j0 == 8) goto L7;
        return true;
    }
}
