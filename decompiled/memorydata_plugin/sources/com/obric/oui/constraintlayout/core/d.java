package com.obric.oui.constraintlayout.core;

import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f13524a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f13525b = true;
    public static boolean c = true;
    public static boolean d = true;
    public static boolean e = true;
    public static boolean f = false;
    public static e o;
    public static long p;
    public static long q;
    private a A;
    public boolean g;
    int h;
    com.obric.oui.constraintlayout.core.b[] i;
    public boolean j;
    public boolean k;
    int l;
    int m;
    final c n;
    private int r;
    private HashMap<String, SolverVariable> s;
    private a t;
    private int u;
    private int v;
    private boolean[] w;
    private int x;
    private SolverVariable[] y;
    private int z;

    interface a {
        SolverVariable a(d r1, boolean[] r2);

        void a(a r1);

        void d(SolverVariable r1);

        boolean e();

        void f();

        SolverVariable g();
    }

    static class b extends com.obric.oui.constraintlayout.core.b {
        b(c r2) {
            this.e = new h(this, r2);
        }
    }

    static {
    }

    public d() {
        this.r = 1000;
        this.g = false;
        this.h = 0;
        this.s = null;
        this.u = 32;
        this.v = 32;
        this.i = null;
        this.j = false;
        this.k = false;
        this.w = new boolean[32];
        this.l = 1;
        this.m = 0;
        this.x = 32;
        this.y = new SolverVariable[1000];
        this.z = 0;
        this.i = new com.obric.oui.constraintlayout.core.b[32];
        k();
        c r0 = new c();
        this.n = r0;
        this.t = new g(r0);
        if (f == false) goto L5;
        a r1 = new b(r0);
    L6:
        this.A = r1;
        return;
    L5:
        r1 = new com.obric.oui.constraintlayout.core.b(r0);
        goto L6
    }

    private int a(a r13, boolean r14) {
        a r15 = (a) ZeusTransformUtils.wrapperContextForParams(r13, a.class, "com.obric.memorydata.plugin");
        e r16 = o;
        if (r16 == null) goto L5;
        r16.j++;
    L5:
        int r2 = 0;
    L7:
        if (r2 >= this.l) goto L9;
        this.w[r2] = false;
        r2 = r2 + 1;
        goto L7
    L9:
        boolean r3 = false;
        int r4 = 0;
    L10:
        if (r3 == true) goto L50;
        e r5 = o;
        if (r5 == null) goto L14;
        r5.k++;
    L14:
        r4 = r4 + 1;
        if (r4 >= (this.l * 2)) goto L16;
        if (r15.g() == null) goto L20;
        this.w[r15.g().f13517b] = true;
    L20:
        SolverVariable r6 = r15.a(this, this.w);
        if (r6 != null) goto L23;
    L26:
        if (r6 != null) goto L27;
        r3 = true;
        goto L10
    L27:
        float r7 = Float.MAX_VALUE;
        int r8 = 0;
        int r9 = -1;
    L29:
        if (r8 >= this.m) goto L44;
        com.obric.oui.constraintlayout.core.b r10 = this.i[r8];
        if (r10.f13520a.i == SolverVariable.Type.UNRESTRICTED) goto L43;
        if (r10.f == true) goto L43;
        if (r10.a(r6) == false) goto L43;
        float r11 = r10.e.b(r6);
        if (r11 >= 0.0f) goto L43;
        float r12 = (-r10.f13521b) / r11;
        if (r12 >= r7) goto L43;
        r9 = r8;
        r7 = r12;
    L43:
        r8 = r8 + 1;
        goto L29
    L44:
        if (r9 <= (-1)) goto L10;
        com.obric.oui.constraintlayout.core.b r17 = this.i[r9];
        r17.f13520a.c = -1;
        e r18 = o;
        if (r18 == null) goto L48;
        r18.l++;
    L48:
        r17.b(r6);
        r17.f13520a.c = r9;
        r17.f13520a.a(this, r17);
        goto L10
    L23:
        if (this.w[r6.f13517b] == true) goto L24;
        this.w[r6.f13517b] = true;
        goto L26
    L24:
        return r4;
    L16:
        return r4;
    L50:
        return r4;
    }

    private SolverVariable a(SolverVariable.Type r4, String r5) {
        SolverVariable r0 = (SolverVariable) ZeusTransformUtils.preCheckCast(this.n.c.a(), SolverVariable.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = new SolverVariable(r4, r5);
    L6:
        r0.a(r4, r5);
        int r6 = this.z;
        int r7 = this.r;
        if (r6 < r7) goto L9;
        int r8 = r7 * 2;
        this.r = r8;
        this.y = (SolverVariable[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(this.y, r8), SolverVariable[].class, "com.obric.memorydata.plugin");
    L9:
        SolverVariable[] r9 = this.y;
        int r10 = this.z;
        this.z = r10 + 1;
        r9[r10] = r0;
        return r0;
    L5:
        r0.b();
        goto L6
    }

    public static com.obric.oui.constraintlayout.core.b a(d r0, SolverVariable r1, SolverVariable r2, float r3) {
        return r0.c().a(r1, r2, r3);
    }

    public static e a() {
        return o;
    }

    private int b(a r20) {
        a r1 = (a) ZeusTransformUtils.wrapperContextForParams(r20, a.class, "com.obric.memorydata.plugin");
        int r2 = 0;
    L4:
        if (r2 >= this.m) goto L12;
        if (this.i[r2].f13520a.i == SolverVariable.Type.UNRESTRICTED) goto L11;
        if (this.i[r2].f13521b >= 0.0f) goto L11;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L73;
        boolean r4 = false;
        int r5 = 0;
    L15:
        if (r4 == true) goto L98;
        e r6 = o;
        if (r6 == null) goto L19;
        r6.m++;
    L19:
        r5 = r5 + 1;
        float r7 = Float.MAX_VALUE;
        int r10 = 0;
        int r11 = -1;
        int r12 = -1;
        int r13 = 0;
    L21:
        if (r10 >= this.m) goto L63;
        com.obric.oui.constraintlayout.core.b r14 = this.i[r10];
        if (r14.f13520a.i == SolverVariable.Type.UNRESTRICTED) goto L61;
        if (r14.f == true) goto L61;
        if (r14.f13521b >= 0.0f) goto L61;
        int r15 = 9;
        if (e == false) goto L46;
        int r8 = r14.e.c();
        int r9 = 0;
    L33:
        if (r9 >= r8) goto L61;
        SolverVariable r16 = r14.e.a(r9);
        float r17 = r14.e.b(r16);
        if (r17 <= 0.0f) goto L45;
        int r18 = 0;
    L38:
        if (r18 >= r15) goto L45;
        float r19 = r16.g[r18] / r17;
        if (r19 >= r7) goto L42;
        if (r18 != r13) goto L42;
    L43:
        r12 = r16.f13517b;
        r13 = r18;
        r11 = r10;
        r7 = r19;
    L44:
        r18 = r18 + 1;
        r15 = 9;
    L42:
        if (r18 <= r13) goto L44;
    L45:
        r9 = r9 + 1;
        r15 = 9;
        goto L33
    L46:
        int r21 = 1;
    L48:
        if (r21 >= this.l) goto L61;
        SolverVariable r22 = this.n.d[r21];
        float r23 = r14.e.b(r22);
        if (r23 <= 0.0f) goto L60;
        int r24 = 0;
    L53:
        if (r24 >= 9) goto L60;
        float r110 = r22.g[r24] / r23;
        if (r110 >= r7) goto L57;
        if (r24 != r13) goto L57;
    L58:
        r12 = r21;
        r13 = r24;
        r11 = r10;
        r7 = r110;
    L59:
        r24 = r24 + 1;
    L57:
        if (r24 <= r13) goto L59;
    L60:
        r21 = r21 + 1;
    L61:
        r10 = r10 + 1;
        goto L21
    L63:
        if (r11 == (-1)) goto L68;
        com.obric.oui.constraintlayout.core.b r25 = this.i[r11];
        r25.f13520a.c = -1;
        e r26 = o;
        if (r26 == null) goto L67;
        r26.l++;
    L67:
        r25.b(this.n.d[r12]);
        r25.f13520a.c = r11;
        r25.f13520a.a(this, r25);
    L70:
        if (r5 <= (this.l / 2)) goto L15;
        r4 = true;
        goto L15
    L68:
        r4 = true;
        goto L70
    L98:
        return r5;
    L73:
        return 0;
    L11:
        r2 = r2 + 1;
        goto L4
    L12:
        r3 = false;
        goto L13
    }

    private void b(com.obric.oui.constraintlayout.core.b r8) {
        if (c == true) goto L5;
    L7:
        this.i[this.m] = r8;
        r8.f13520a.c = this.m;
        this.m++;
        r8.f13520a.a(this, r8);
    L9:
        if (c == true) goto L11;
        return;
    L11:
        if (this.g == false) goto L47;
        int r0 = 0;
    L14:
        if (r0 >= this.m) goto L37;
        if (this.i[r0] != null) goto L18;
        System.out.println("WTF");
    L18:
        com.obric.oui.constraintlayout.core.b[] r1 = this.i;
        if (r1[r0] == null) goto L36;
        if (r1[r0].f == false) goto L36;
        com.obric.oui.constraintlayout.core.b r2 = this.i[r0];
        r2.f13520a.a(this, r2.f13521b);
        if (f == false) goto L25;
        f.a<com.obric.oui.constraintlayout.core.b> r3 = this.n.f13522a;
    L26:
        r3.a(r2);
        this.i[r0] = null;
        int r4 = r0 + 1;
        int r5 = r4;
    L27:
        int r6 = this.m;
        if (r4 >= r6) goto L33;
        com.obric.oui.constraintlayout.core.b[] r7 = this.i;
        int r9 = r4 - 1;
        r7[r9] = r7[r4];
        if (r7[r9].f13520a.c != r4) goto L32;
        this.i[r9].f13520a.c = r9;
    L32:
        r5 = r4;
        r4 = r4 + 1;
        goto L27
    L33:
        if (r5 >= r6) goto L35;
        this.i[r5] = null;
    L35:
        this.m = r6 - 1;
        r0 = r0 - 1;
        goto L36
    L25:
        r3 = this.n.f13523b;
    L36:
        r0 = r0 + 1;
        goto L14
    L37:
        this.g = false;
        return;
    L47:
        return;
    L5:
        if (r8.f == false) goto L7;
        r8.f13520a.a(this, r8.f13521b);
        goto L9
    }

    private void j() {
        int r0 = this.u * 2;
        this.u = r0;
        this.i = (com.obric.oui.constraintlayout.core.b[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(this.i, r0), com.obric.oui.constraintlayout.core.b[].class, "com.obric.memorydata.plugin");
        c r1 = this.n;
        r1.d = (SolverVariable[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r1.d, this.u), SolverVariable[].class, "com.obric.memorydata.plugin");
        int r2 = this.u;
        this.w = new boolean[r2];
        this.v = r2;
        this.x = r2;
        e r3 = o;
        if (r3 == null) goto L6;
        r3.f++;
        e r4 = o;
        r4.q = Math.max(r4.q, this.u);
        e r5 = o;
        r5.z = r5.q;
        return;
    }

    private void k() {
        int r2 = 0;
        if (f == false) goto L11;
    L5:
        if (r2 >= this.m) goto L16;
        com.obric.oui.constraintlayout.core.b r0 = this.i[r2];
        if (r0 == null) goto L9;
        this.n.f13522a.a(r0);
    L9:
        this.i[r2] = null;
        r2 = r2 + 1;
        goto L5
    L16:
        return;
    L11:
        if (r2 >= this.m) goto L23;
        com.obric.oui.constraintlayout.core.b r1 = this.i[r2];
        if (r1 == null) goto L15;
        this.n.f13523b.a(r1);
    L15:
        this.i[r2] = null;
        r2 = r2 + 1;
        goto L11
    }

    private void l() {
        int r0 = 0;
    L4:
        if (r0 >= this.m) goto L6;
        com.obric.oui.constraintlayout.core.b r1 = this.i[r0];
        SolverVariable r2 = r1.f13520a;
        r2.e = r1.f13521b;
        r0 = r0 + 1;
        goto L4
    }

    public SolverVariable a(int r6, String r7) {
        e r0 = o;
        if (r0 == null) goto L6;
        r0.n++;
    L6:
        if ((this.l + 1) < this.v) goto L8;
        j();
    L8:
        SolverVariable r8 = a(SolverVariable.Type.ERROR, r7);
        int r1 = this.h + 1;
        this.h = r1;
        this.l++;
        r8.f13517b = r1;
        r8.d = r6;
        this.n.d[this.h] = r8;
        this.t.d(r8);
        return r8;
    }

    public SolverVariable a(Object r4) {
        SolverVariable r0 = null;
        if (r4 != null) goto L6;
        return null;
    L6:
        if ((this.l + 1) < this.v) goto L9;
        j();
    L9:
        if (ZeusTransformUtils.instanceOf(r4, ConstraintAnchor.class) == false) goto L23;
        r0 = ((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r4, ConstraintAnchor.class, "com.obric.memorydata.plugin")).g();
        if (r0 != null) goto L14;
        ((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r4, ConstraintAnchor.class, "com.obric.memorydata.plugin")).a(this.n);
        r0 = ((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r4, ConstraintAnchor.class, "com.obric.memorydata.plugin")).g();
    L14:
        if (r0.f13517b == (-1)) goto L20;
        if (r0.f13517b > this.h) goto L20;
        if (this.n.d[r0.f13517b] != null) goto L23;
    L20:
        if (r0.f13517b == (-1)) goto L22;
        r0.b();
    L22:
        int r5 = this.h + 1;
        this.h = r5;
        this.l++;
        r0.f13517b = r5;
        r0.i = SolverVariable.Type.UNRESTRICTED;
        this.n.d[this.h] = r0;
    L23:
        return r0;
    }

    public void a(SolverVariable r6, int r7) {
        e r0 = o;
        if (r0 == null) goto L6;
        r0.P++;
    L6:
        if (f13525b == true) goto L8;
    L21:
        int r1 = r6.c;
        if (r6.c == (-1)) goto L30;
        com.obric.oui.constraintlayout.core.b r2 = this.i[r1];
        if (r2.f == false) goto L27;
    L25:
        r2.f13521b = r7;
        return;
    L27:
        if (r2.e.c() != 0) goto L29;
        r2.f = true;
        goto L25
    L29:
        com.obric.oui.constraintlayout.core.b r3 = c();
        r3.b(r6, r7);
    L31:
        a(r3);
        return;
    L30:
        r3 = c();
        r3.a(r6, r7);
        goto L31
    L8:
        if (r6.c != (-1)) goto L21;
        float r8 = r7;
        r6.a(this, r8);
        int r4 = 0;
    L11:
        if (r4 >= (this.h + 1)) goto L20;
        SolverVariable r5 = this.n.d[r4];
        if (r5 == null) goto L19;
        if (r5.m == false) goto L19;
        if (r5.n != r6.f13517b) goto L19;
        r5.a(this, r5.o + r8);
    L19:
        r4 = r4 + 1;
        goto L11
    }

    public void a(SolverVariable r12, SolverVariable r13, int r14, float r15, SolverVariable r16, SolverVariable r17, int r18, int r19) {
        com.obric.oui.constraintlayout.core.b r10 = c();
        r10.a(r12, r13, r14, r15, r16, r17, r18);
        if (r19 == 8) goto L5;
        r10.a(this, r19);
    L5:
        a(r10);
    }

    public void a(SolverVariable r4, SolverVariable r5, int r6, int r7) {
        com.obric.oui.constraintlayout.core.b r0 = c();
        SolverVariable r1 = d();
        r1.d = 0;
        r0.a(r4, r5, r1, r6);
        if (r7 == 8) goto L5;
        a(r0, (int) (r0.e.b(r1) * (-1.0f)), r7);
    L5:
        a(r0);
    }

    public void a(SolverVariable r3, SolverVariable r4, int r5, boolean r6) {
        com.obric.oui.constraintlayout.core.b r7 = c();
        SolverVariable r0 = d();
        r0.d = 0;
        r7.a(r3, r4, r0, r5);
        a(r7);
    }

    public void a(SolverVariable r8, SolverVariable r9, SolverVariable r10, SolverVariable r11, float r12, int r13) {
        com.obric.oui.constraintlayout.core.b r6 = c();
        r6.a(r8, r9, r10, r11, r12);
        if (r13 == 8) goto L5;
        r6.a(this, r13);
    L5:
        a(r6);
    }

    public void a(com.obric.oui.constraintlayout.core.b r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        e r0 = o;
        if (r0 == null) goto L9;
        r0.h++;
        if (r8.f == false) goto L9;
        o.i++;
    L9:
        boolean r3 = true;
        if ((this.m + 1) < this.x) goto L12;
    L13:
        j();
    L14:
        boolean r1 = false;
        if (r8.f == true) goto L46;
        r8.c(this);
        if (r8.e() == false) goto L19;
        return;
    L19:
        r8.d();
        if (r8.a(this) == false) goto L41;
        SolverVariable r4 = e();
        r8.f13520a = r4;
        int r5 = this.m;
        b(r8);
        if (this.m != (r5 + 1)) goto L41;
        this.A.a(r8);
        a(this.A, true);
        if (r4.c != (-1)) goto L43;
        if (r8.f13520a != r4) goto L34;
        SolverVariable r2 = r8.c(r4);
        if (r2 == null) goto L34;
        e r6 = o;
        if (r6 == null) goto L32;
        r6.l++;
    L32:
        r8.b(r2);
    L34:
        if (r8.f == true) goto L37;
        r8.f13520a.a(this, r8);
    L37:
        if (f == false) goto L39;
        f.a<com.obric.oui.constraintlayout.core.b> r7 = this.n.f13522a;
    L40:
        r7.a(r8);
        this.m--;
        goto L43
    L39:
        r7 = this.n.f13523b;
    L43:
        if (r8.a() == true) goto L45;
        return;
    L45:
        r1 = r3;
    L41:
        r3 = false;
    L46:
        if (r1 == true) goto L49;
        b(r8);
        return;
    L49:
        return;
    L12:
        if ((this.l + 1) < this.v) goto L14;
        goto L13
    }

    void a(com.obric.oui.constraintlayout.core.b r2, int r3, int r4) {
        r2.c(a(r4, null), r3);
    }

    void a(a r6) {
        a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r6, a.class, "com.obric.memorydata.plugin");
        e r0 = o;
        if (r0 == null) goto L5;
        r0.v++;
        e r1 = o;
        r1.w = Math.max(r1.w, this.l);
        e r2 = o;
        r2.x = Math.max(r2.x, this.m);
    L5:
        b(r7);
        a(r7, false);
        l();
    }

    public void a(e r1) {
        o = r1;
    }

    public void a(ConstraintWidget r19, ConstraintWidget r20, float r21, int r22) {
        SolverVariable r5 = a(r19.a(ConstraintAnchor.Type.LEFT));
        SolverVariable r7 = a(r19.a(ConstraintAnchor.Type.TOP));
        SolverVariable r3 = a(r19.a(ConstraintAnchor.Type.RIGHT));
        SolverVariable r8 = a(r19.a(ConstraintAnchor.Type.BOTTOM));
        SolverVariable r1 = a(r20.a(ConstraintAnchor.Type.LEFT));
        SolverVariable r9 = a(r20.a(ConstraintAnchor.Type.TOP));
        SolverVariable r12 = a(r20.a(ConstraintAnchor.Type.RIGHT));
        SolverVariable r10 = a(r20.a(ConstraintAnchor.Type.BOTTOM));
        com.obric.oui.constraintlayout.core.b r2 = c();
        double r13 = r21;
        double r4 = r22;
        r2.b(r7, r8, r9, r10, (float) (Math.sin(r13) * r4));
        a(r2);
        com.obric.oui.constraintlayout.core.b r6 = c();
        r6.b(r5, r3, r1, r12, (float) (Math.cos(r13) * r4));
        a(r6);
    }

    public int b(Object r2) {
        SolverVariable r1 = ((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r2, ConstraintAnchor.class, "com.obric.memorydata.plugin")).g();
        if (r1 != null) goto L5;
        return 0;
    L5:
        return (int) (r1.e + 0.5f);
    }

    public void b() {
        int r1 = 0;
    L4:
        if (r1 >= this.n.d.length) goto L9;
        SolverVariable r2 = this.n.d[r1];
        if (r2 == null) goto L8;
        r2.b();
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        this.n.c.a(this.y, this.z);
        this.z = 0;
        Arrays.fill(this.n.d, null);
        HashMap<String, SolverVariable> r3 = this.s;
        if (r3 == null) goto L12;
        r3.clear();
    L12:
        this.h = 0;
        this.t.f();
        this.l = 1;
        int r4 = 0;
    L14:
        if (r4 >= this.m) goto L19;
        com.obric.oui.constraintlayout.core.b[] r5 = this.i;
        if (r5[r4] == null) goto L18;
        r5[r4].c = false;
    L18:
        r4 = r4 + 1;
        goto L14
    L19:
        k();
        this.m = 0;
        if (f == false) goto L22;
        a r0 = new b(this.n);
    L23:
        this.A = r0;
        return;
    L22:
        r0 = new com.obric.oui.constraintlayout.core.b(this.n);
        goto L23
    }

    public void b(SolverVariable r4, SolverVariable r5, int r6, int r7) {
        com.obric.oui.constraintlayout.core.b r0 = c();
        SolverVariable r1 = d();
        r1.d = 0;
        r0.b(r4, r5, r1, r6);
        if (r7 == 8) goto L5;
        a(r0, (int) (r0.e.b(r1) * (-1.0f)), r7);
    L5:
        a(r0);
    }

    public void b(SolverVariable r3, SolverVariable r4, int r5, boolean r6) {
        com.obric.oui.constraintlayout.core.b r7 = c();
        SolverVariable r0 = d();
        r0.d = 0;
        r7.b(r3, r4, r0, r5);
        a(r7);
    }

    public com.obric.oui.constraintlayout.core.b c() {
        if (f == false) goto L7;
        com.obric.oui.constraintlayout.core.b r0 = (com.obric.oui.constraintlayout.core.b) ZeusTransformUtils.preCheckCast(this.n.f13522a.a(), com.obric.oui.constraintlayout.core.b.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        r0 = new b(this.n);
        q++;
    L11:
        SolverVariable.a();
        return r0;
    L10:
        r0.c();
        goto L11
    L7:
        r0 = (com.obric.oui.constraintlayout.core.b) ZeusTransformUtils.preCheckCast(this.n.f13523b.a(), com.obric.oui.constraintlayout.core.b.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        r0 = new com.obric.oui.constraintlayout.core.b(this.n);
        p++;
        goto L11
    }

    public com.obric.oui.constraintlayout.core.b c(SolverVariable r6, SolverVariable r7, int r8, int r9) {
        e r0 = o;
        if (r0 == null) goto L6;
        r0.P++;
    L6:
        if (f13525b == false) goto L14;
        if (r9 != 8) goto L14;
        if (r7.f == false) goto L14;
        if (r6.c != (-1)) goto L14;
        r6.a(this, r7.e + r8);
        return null;
    L14:
        com.obric.oui.constraintlayout.core.b r1 = c();
        r1.a(r6, r7, r8);
        if (r9 == 8) goto L17;
        r1.a(this, r9);
    L17:
        a(r1);
        return r1;
    }

    public SolverVariable d() {
        e r0 = o;
        if (r0 == null) goto L6;
        r0.o++;
    L6:
        if ((this.l + 1) < this.v) goto L8;
        j();
    L8:
        SolverVariable r1 = a(SolverVariable.Type.SLACK, null);
        int r2 = this.h + 1;
        this.h = r2;
        this.l++;
        r1.f13517b = r2;
        this.n.d[this.h] = r1;
        return r1;
    }

    public SolverVariable e() {
        e r0 = o;
        if (r0 == null) goto L6;
        r0.p++;
    L6:
        if ((this.l + 1) < this.v) goto L8;
        j();
    L8:
        SolverVariable r1 = a(SolverVariable.Type.SLACK, null);
        int r2 = this.h + 1;
        this.h = r2;
        this.l++;
        r1.f13517b = r2;
        this.n.d[this.h] = r1;
        return r1;
    }

    public void f() {
        e r0 = o;
        if (r0 == null) goto L6;
        r0.g++;
    L6:
        if (this.t.e() == false) goto L10;
        l();
        return;
    L10:
        if (this.j == false) goto L12;
    L15:
        e r1 = o;
        if (r1 == null) goto L18;
        r1.s++;
    L18:
        boolean r2 = false;
        int r3 = 0;
    L20:
        if (r3 >= this.m) goto L25;
        if (this.i[r3].f == false) goto L26;
        r3 = r3 + 1;
    L26:
        if (r2 == false) goto L14;
        e r4 = o;
        if (r4 == null) goto L31;
        r4.r++;
    L31:
        l();
        return;
    L14:
        a(this.t);
        return;
    L25:
        r2 = true;
        goto L26
    L12:
        if (this.k == false) goto L14;
        goto L14
    }

    public int g() {
        return this.m;
    }

    public int h() {
        return this.h;
    }

    public c i() {
        return this.n;
    }
}
