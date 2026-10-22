package com.obric.oui.constraintlayout.core.widgets;

import com.obric.oui.constraintlayout.core.SolverVariable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class d extends l {
    static int aU;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.obric.oui.constraintlayout.core.widgets.analyzer.b f13638a;
    protected com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC0736b aA;
    public com.obric.oui.constraintlayout.core.e aB;
    protected com.obric.oui.constraintlayout.core.d aC;
    int aD;
    int aE;
    int aF;
    int aG;
    public int aH;
    public int aI;
    c[] aJ;
    c[] aK;
    public boolean aL;
    public boolean aM;
    public boolean aN;
    public int aO;
    public int aP;
    public boolean aQ;
    int aR;
    HashSet<ConstraintWidget> aS;
    public com.obric.oui.constraintlayout.core.widgets.analyzer.b.a aT;
    private int aW;
    private boolean aX;
    private int aY;
    private boolean aZ;
    public com.obric.oui.constraintlayout.core.widgets.analyzer.e az;
    private boolean ba;
    private WeakReference<ConstraintAnchor> bb;
    private WeakReference<ConstraintAnchor> bc;
    private WeakReference<ConstraintAnchor> bd;
    private WeakReference<ConstraintAnchor> be;

    static {
    }

    public d() {
        this.f13638a = new com.obric.oui.constraintlayout.core.widgets.analyzer.b(this);
        this.az = new com.obric.oui.constraintlayout.core.widgets.analyzer.e(this);
        this.aA = null;
        this.aX = false;
        this.aC = new com.obric.oui.constraintlayout.core.d();
        this.aH = 0;
        this.aI = 0;
        this.aJ = new c[4];
        this.aK = new c[4];
        this.aL = false;
        this.aM = false;
        this.aN = false;
        this.aO = 0;
        this.aP = 0;
        this.aY = 257;
        this.aQ = false;
        this.aZ = false;
        this.ba = false;
        this.aR = 0;
        this.bb = null;
        this.bc = null;
        this.bd = null;
        this.be = null;
        this.aS = new HashSet();
        this.aT = new com.obric.oui.constraintlayout.core.widgets.analyzer.b.a();
    }

    private void a(ConstraintAnchor r3, SolverVariable r4) {
        SolverVariable r5 = this.aC.a(r3);
        this.aC.a(r5, r4, 0, 5);
    }

    public static boolean a(int r5, ConstraintWidget r6, com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC0736b r7, com.obric.oui.constraintlayout.core.widgets.analyzer.b.a r8, int r9) {
        com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC0736b r10 = (com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC0736b) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC0736b.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r6.B() != 8) goto L8;
    L88:
        r8.h = 0;
        r8.i = 0;
        return false;
    L8:
        if (ZeusTransformUtils.instanceOf(r6, f.class) == true) goto L88;
        if (ZeusTransformUtils.instanceOf(r6, a.class) == true) goto L88;
        r8.d = r6.aa();
        r8.e = r6.ab();
        r8.f = r6.F();
        r8.g = r6.G();
        r8.l = false;
        r8.m = r9;
        if (r8.d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L15;
        boolean r11 = true;
    L17:
        if (r8.e != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L19;
        boolean r0 = true;
    L21:
        if (r11 == true) goto L23;
    L25:
        boolean r3 = false;
    L26:
        if (r0 == true) goto L28;
    L30:
        boolean r2 = false;
    L31:
        if (r11 == true) goto L33;
    L43:
        if (r0 == false) goto L56;
        if (r6.g(1) == false) goto L56;
        if (r6.o != 0) goto L56;
        if (r2 == true) goto L56;
        r8.e = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r11 == true) goto L52;
    L54:
        r0 = false;
        goto L56
    L52:
        if (r6.n != 0) goto L54;
        r8.e = ConstraintWidget.DimensionBehaviour.FIXED;
    L56:
        if (r6.d() == false) goto L59;
        r8.d = ConstraintWidget.DimensionBehaviour.FIXED;
        r11 = false;
    L59:
        if (r6.e() == false) goto L62;
        r8.e = ConstraintWidget.DimensionBehaviour.FIXED;
        r0 = false;
    L62:
        if (r3 == true) goto L64;
    L72:
        if (r2 == true) goto L74;
    L86:
        r10.a(r6, r8);
        r6.q(r8.h);
        r6.r(r8.i);
        r6.c(r8.k);
        r6.u(r8.j);
        r8.m = com.obric.oui.constraintlayout.core.widgets.analyzer.b.a.f13617a;
        return r8.l;
    L74:
        if (r6.p[1] != 4) goto L76;
        r8.e = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L86
    L76:
        if (r11 == true) goto L86;
        if (r8.d != ConstraintWidget.DimensionBehaviour.FIXED) goto L80;
        int r12 = r8.f;
    L81:
        r8.e = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r6.V() != (-1)) goto L84;
        int r13 = (int) (r12 / r6.U());
    L85:
        r8.g = r13;
        goto L86
    L84:
        r13 = (int) (r6.U() * r12);
        goto L85
    L80:
        r8.e = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r10.a(r6, r8);
        r12 = r8.h;
        goto L81
    L64:
        if (r6.p[0] != 4) goto L66;
        r8.d = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L72
    L66:
        if (r0 == true) goto L72;
        if (r8.e != ConstraintWidget.DimensionBehaviour.FIXED) goto L70;
        int r14 = r8.g;
    L71:
        r8.d = ConstraintWidget.DimensionBehaviour.FIXED;
        r8.f = (int) (r6.U() * r14);
        goto L72
    L70:
        r8.d = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r10.a(r6, r8);
        r14 = r8.i;
        goto L71
    L33:
        if (r6.g(0) == false) goto L43;
        if (r6.n != 0) goto L43;
        if (r3 == true) goto L43;
        r8.d = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r0 == true) goto L40;
    L42:
        r11 = false;
        goto L43
    L40:
        if (r6.o != 0) goto L42;
        r8.d = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L42
    L28:
        if (r6.P <= 0.0f) goto L30;
        r2 = true;
        goto L31
    L23:
        if (r6.P <= 0.0f) goto L25;
        r3 = true;
        goto L26
    L19:
        r0 = false;
        goto L21
    L15:
        r11 = false;
        goto L17
    }

    private void am() {
        this.aH = 0;
        this.aI = 0;
    }

    private void b(ConstraintAnchor r3, SolverVariable r4) {
        SolverVariable r5 = this.aC.a(r3);
        this.aC.a(r4, r5, 0, 5);
    }

    private void d(ConstraintWidget r6) {
        int r0 = this.aH + 1;
        c[] r1 = this.aK;
        if (r0 < r1.length) goto L5;
        this.aK = (c[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r1, r1.length * 2), c[].class, "com.obric.memorydata.plugin");
    L5:
        this.aK[this.aH] = new c(r6, 0, ag());
        this.aH++;
    }

    private void e(ConstraintWidget r6) {
        int r0 = this.aI + 1;
        c[] r2 = this.aJ;
        if (r0 < r2.length) goto L5;
        this.aJ = (c[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r2, r2.length * 2), c[].class, "com.obric.memorydata.plugin");
    L5:
        this.aJ[this.aI] = new c(r6, 1, ag());
        this.aI++;
    }

    public void A(int r1) {
        this.aW = r1;
    }

    public long a(int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20) {
        this.aD = r19;
        this.aE = r20;
        return this.f13638a.a(this, r12, r19, r20, r13, r14, r15, r16, r17, r18);
    }

    public void a(int r1) {
        this.aY = r1;
        com.obric.oui.constraintlayout.core.d.f13524a = b(512);
    }

    public void a(com.obric.oui.constraintlayout.core.e r1) {
        this.aB = r1;
        this.aC.a(r1);
    }

    void a(ConstraintAnchor r5) {
        WeakReference<ConstraintAnchor> r0 = this.bb;
        if (r0 != null) goto L5;
    L8:
        this.bb = new WeakReference(r5);
        return;
    L5:
        if (r0.get() == null) goto L8;
        if (r5.d() > ((ConstraintAnchor) ZeusTransformUtils.preCheckCast(this.bb.get(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).d()) goto L8;
    }

    void a(ConstraintWidget r2, int r3) {
        if (r3 != 0) goto L5;
        d(r2);
        return;
    L5:
        if (r3 != 1) goto L9;
        e(r2);
        return;
    }

    public void a(com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC0736b r3) {
        com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC0736b r4 = (com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC0736b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC0736b.class, "com.obric.memorydata.plugin");
        this.aA = r4;
        this.az.a(r4);
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public void a(StringBuilder r4) {
        r4.append(this.k + ":{\n");
        r4.append("  actualWidth:" + this.N);
        r4.append("\n");
        r4.append("  actualHeight:" + this.O);
        r4.append("\n");
        Iterator<ConstraintWidget> r3 = ak().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((ConstraintWidget) ZeusTransformUtils.preCheckCast(r3.next(), ConstraintWidget.class, "com.obric.memorydata.plugin")).a(r4);
        r4.append(",\n");
        goto L4
    L6:
        r4.append("}");
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public void a(boolean r6, boolean r7) {
        super.a(r6, r7);
        int r0 = this.aV.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((ConstraintWidget) ZeusTransformUtils.preCheckCast(this.aV.get(r1), ConstraintWidget.class, "com.obric.memorydata.plugin")).a(r6, r7);
        r1 = r1 + 1;
        goto L3
    }

    public boolean a(com.obric.oui.constraintlayout.core.d r7, boolean[] r8) {
        int r1 = 0;
        r8[2] = false;
        boolean r9 = b(64);
        b(r7, r9);
        int r0 = this.aV.size();
        boolean r2 = false;
    L3:
        if (r1 >= r0) goto L8;
        ConstraintWidget r3 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(this.aV.get(r1), ConstraintWidget.class, "com.obric.memorydata.plugin");
        r3.b(r7, r9);
        if (r3.y() == false) goto L7;
        r2 = true;
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r2;
    }

    public boolean a(boolean r1) {
        return this.az.a(r1);
    }

    public boolean a(boolean r1, int r2) {
        return this.az.a(r1, r2);
    }

    public boolean af() {
        return this.ba;
    }

    public boolean ag() {
        return this.aX;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v35 */
    /* JADX WARN: Type inference failed for: r11v36 */
    /* JADX WARN: Type inference failed for: r11v37 */
    /* JADX WARN: Type inference failed for: r11v38 */
    /* JADX WARN: Type inference failed for: r11v39 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v40 */
    /* JADX WARN: Type inference failed for: r11v41 */
    /* JADX WARN: Type inference failed for: r11v42 */
    /* JADX WARN: Type inference failed for: r11v43 */
    /* JADX WARN: Type inference failed for: r11v44 */
    /* JADX WARN: Type inference failed for: r11v45 */
    /* JADX WARN: Type inference failed for: r11v46 */
    /* JADX WARN: Type inference failed for: r11v47 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [boolean] */
    @Override // com.obric.oui.constraintlayout.core.widgets.l
    public void ah() {
        this.R = 0;
        this.S = 0;
        this.aZ = false;
        this.ba = false;
        int r3 = this.aV.size();
        int r0 = Math.max(0, F());
        int r4 = Math.max(0, G());
        ConstraintWidget.DimensionBehaviour r5 = this.L[1];
        ConstraintWidget.DimensionBehaviour r7 = this.L[0];
        com.obric.oui.constraintlayout.core.e r8 = this.aB;
        if (r8 == null) goto L6;
        r8.F++;
    L6:
        if (this.aW != 0) goto L35;
        if (i.a(this.aY, 1) == false) goto L35;
        com.obric.oui.constraintlayout.core.widgets.analyzer.g.a(this, g());
        int r9 = 0;
    L10:
        if (r9 >= r3) goto L35;
        ConstraintWidget r10 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(this.aV.get(r9), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r10.t() == false) goto L33;
        if (ZeusTransformUtils.instanceOf(r10, f.class) == true) goto L33;
        if (ZeusTransformUtils.instanceOf(r10, a.class) == true) goto L33;
        if (ZeusTransformUtils.instanceOf(r10, k.class) == true) goto L33;
        if (r10.p() == true) goto L33;
        ConstraintWidget.DimensionBehaviour r11 = r10.x(0);
        ConstraintWidget.DimensionBehaviour r12 = r10.x(1);
        if (r11 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
    L30:
        boolean r13 = false;
    L31:
        if (r13 == true) goto L33;
        a(0, r10, this.aA, new com.obric.oui.constraintlayout.core.widgets.analyzer.b.a(), com.obric.oui.constraintlayout.core.widgets.analyzer.b.a.f13617a);
        goto L33
    L24:
        if (r10.n == 1) goto L30;
        if (r12 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L30;
        if (r10.o == 1) goto L30;
        r13 = true;
    L33:
        r9 = r9 + 1;
    L35:
        if (r3 > 2) goto L37;
    L59:
        int r14 = r4;
        int r6 = r0;
        boolean r1 = false;
    L61:
        if (b(64) == false) goto L63;
    L66:
        boolean r15 = true;
    L67:
        this.aC.j = false;
        this.aC.k = false;
        if (this.aY == 0) goto L71;
        if (r15 == false) goto L71;
        this.aC.k = true;
    L71:
        ArrayList<ConstraintWidget> r16 = this.aV;
        if (aa() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L74;
    L77:
        boolean r17 = true;
    L78:
        am();
        int r18 = 0;
    L79:
        if (r18 >= r3) goto L84;
        ConstraintWidget r2 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(this.aV.get(r18), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, l.class) == false) goto L83;
        ((l) ZeusTransformUtils.preCheckCast(r2, l.class, "com.obric.memorydata.plugin")).ah();
    L83:
        r18 = r18 + 1;
        goto L79
    L84:
        boolean r19 = b(64);
        ?? r110 = r1;
        boolean r111 = true;
        int r20 = 0;
    L85:
        if (r111 == false) goto L167;
        int r112 = r20 + 1;
        this.aC.b();     // Catch: Exception -> L113
        am();     // Catch: Exception -> L113
        a(this.aC);     // Catch: Exception -> L113
        int r21 = 0;
    L88:
        if (r21 >= r3) goto L90;
        ((ConstraintWidget) ZeusTransformUtils.preCheckCast(this.aV.get(r21), ConstraintWidget.class, "com.obric.memorydata.plugin")).a(this.aC);     // Catch: Exception -> L113
        r21 = r21 + 1;     // Catch: Exception -> L113
        goto L88
    L90:
        boolean r113 = b(this.aC);     // Catch: Exception -> L113
        WeakReference<ConstraintAnchor> r22 = this.bb;     // Catch: Exception -> L113
        if (r22 != null) goto L93;
    L95:
        WeakReference<ConstraintAnchor> r23 = this.bd;     // Catch: Exception -> L113
        if (r23 != null) goto L98;
    L100:
        WeakReference<ConstraintAnchor> r24 = this.bc;     // Catch: Exception -> L113
        if (r24 != null) goto L103;
    L105:
        WeakReference<ConstraintAnchor> r25 = this.be;     // Catch: Exception -> L113
        if (r25 != null) goto L108;
    L110:
        if (r113 == false) goto L115;
        this.aC.f();     // Catch: Exception -> L113
    L115:
        com.obric.oui.constraintlayout.core.d r26 = this.aC;
        if (r113 == false) goto L118;
        boolean r27 = a(r26, i.f13643a);
    L123:
        if (r17 == false) goto L141;
        if (r112 >= 8) goto L141;
        if (i.f13643a[2] == false) goto L141;
        int r28 = 0;
        int r29 = 0;
        int r114 = 0;
    L128:
        boolean r115 = r27;
        if (r29 >= r3) goto L131;
        ConstraintWidget r30 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(this.aV.get(r29), ConstraintWidget.class, "com.obric.memorydata.plugin");
        r114 = Math.max(r114, r30.R + r30.F());
        r28 = Math.max(r28, r30.S + r30.G());
        r29 = r29 + 1;
        r27 = r115 ? 1 : 0;
        r19 = r19;
        goto L128
    L131:
        boolean r116 = r19;
        int r31 = Math.max(this.Y, r114);
        int r32 = Math.max(this.Z, r28);
        ?? r117 = r110;
        if (r7 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L136;
        r117 = r110;
        if (F() >= r31) goto L136;
        q(r31);
        this.L[0] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r117 = 1;
        r115 = true;
    L136:
        ?? r118 = r117;
        if (r5 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L142;
        r118 = r117;
        if (G() >= r32) goto L142;
        r(r32);
        this.L[1] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r118 = 1;
        r115 = true;
    L142:
        int r33 = Math.max(this.Y, F());
        ?? r119 = r118;
        if (r33 <= F()) goto L145;
        q(r33);
        this.L[0] = ConstraintWidget.DimensionBehaviour.FIXED;
        r119 = 1;
        r115 = true;
    L145:
        int r34 = Math.max(this.Z, G());
        if (r34 <= G()) goto L148;
        r(r34);
        ?? r35 = 1;
        this.L[1] = ConstraintWidget.DimensionBehaviour.FIXED;
        ?? r120 = 1;
        r115 = true;
    L149:
        if (r120 != 0) goto L162;
        r120 = r120;
        r120 = r120;
        if (this.L[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L157;
        if (r6 <= 0) goto L157;
        r120 = r120;
        if (F() <= r6) goto L157;
        this.aZ = r35;
        this.L[0] = ConstraintWidget.DimensionBehaviour.FIXED;
        q(r6);
        ?? r121 = r35;
        r115 = r121 == true ? 1 : 0;
        r120 = r121;
    L157:
        if (this.L[r35] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L162;
        if (r14 <= 0) goto L162;
        if (G() <= r14) goto L162;
        this.ba = r35;
        this.L[r35] = ConstraintWidget.DimensionBehaviour.FIXED;
        r(r14);
        int r36 = 8;
        boolean r37 = true;
        ?? r122 = 1;
    L163:
        if (r112 <= r36) goto L165;
        r111 = false;
    L166:
        r20 = r112;
        r19 = r116;
        r110 = r122;
        goto L85
    L165:
        r111 = r37;
    L162:
        r37 = r115;
        r36 = 8;
        r122 = r120;
        goto L163
    L148:
        r35 = 1;
        r120 = r119;
    L141:
        r115 = r27 ? 1 : 0;
        r116 = r19;
        r118 = r110;
        goto L142
    L118:
        b(r26, r19);
        int r38 = 0;
    L119:
        if (r38 >= r3) goto L121;
        ((ConstraintWidget) ZeusTransformUtils.preCheckCast(this.aV.get(r38), ConstraintWidget.class, "com.obric.memorydata.plugin")).b(this.aC, r19);
        r38 = r38 + 1;
        goto L119
    L121:
        r27 = false;
        goto L123
    L108:
        if (r25.get() == null) goto L110;
        b((ConstraintAnchor) ZeusTransformUtils.preCheckCast(this.be.get(), ConstraintAnchor.class, "com.obric.memorydata.plugin"), this.aC.a(this.D));     // Catch: Exception -> L113
        this.be = null;     // Catch: Exception -> L113
        goto L110
    L103:
        if (r24.get() == null) goto L105;
        a((ConstraintAnchor) ZeusTransformUtils.preCheckCast(this.bc.get(), ConstraintAnchor.class, "com.obric.memorydata.plugin"), this.aC.a(this.B));     // Catch: Exception -> L113
        this.bc = null;     // Catch: Exception -> L113
        goto L105
    L98:
        if (r23.get() == null) goto L100;
        b((ConstraintAnchor) ZeusTransformUtils.preCheckCast(this.bd.get(), ConstraintAnchor.class, "com.obric.memorydata.plugin"), this.aC.a(this.E));     // Catch: Exception -> L113
        this.bd = null;     // Catch: Exception -> L113
        goto L100
    L93:
        if (r22.get() == null) goto L95;
        a((ConstraintAnchor) ZeusTransformUtils.preCheckCast(this.bb.get(), ConstraintAnchor.class, "com.obric.memorydata.plugin"), this.aC.a(this.C));     // Catch: Exception -> L113
        this.bb = null;     // Catch: Exception -> L113
    L113:
        e = move-exception;
        e.printStackTrace();
        System.out.println("EXCEPTION : " + e);
        r113 = r111 ? 1 : 0;
        goto L115
    L167:
        this.aV = (ArrayList) ZeusTransformUtils.preCheckCast(r16, ArrayList.class, "com.obric.memorydata.plugin");
        if (r110 == 0) goto L170;
        this.L[0] = r7;
        this.L[1] = r5;
    L170:
        a(this.aC.i());
        return;
    L74:
        if (ab() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L77;
        r17 = false;
        goto L78
    L63:
        if (b(128) == true) goto L66;
        r15 = false;
        goto L67
    L37:
        if (r7 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L41;
        if (r5 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L59;
    L41:
        if (i.a(this.aY, 1024) == false) goto L59;
        if (com.obric.oui.constraintlayout.core.widgets.analyzer.h.a(this, g()) == false) goto L59;
        if (r7 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L52;
        if (r0 >= F()) goto L50;
        if (r0 <= 0) goto L50;
        q(r0);
        this.aZ = true;
    L50:
        r0 = F();
    L52:
        if (r5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L54;
    L58:
        r14 = r4;
        r6 = r0;
        r1 = true;
        goto L61
    L54:
        if (r4 >= G()) goto L57;
        if (r4 <= 0) goto L57;
        r(r4);
        this.ba = true;
    L57:
        r4 = G();
        goto L58
    }

    public boolean ai() {
        return false;
    }

    public com.obric.oui.constraintlayout.core.d aj() {
        return this.aC;
    }

    public void b() {
        this.az.b();
    }

    public void b(ConstraintAnchor r5) {
        WeakReference<ConstraintAnchor> r0 = this.bc;
        if (r0 != null) goto L5;
    L8:
        this.bc = new WeakReference(r5);
        return;
    L5:
        if (r0.get() == null) goto L8;
        if (r5.d() > ((ConstraintAnchor) ZeusTransformUtils.preCheckCast(this.bc.get(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).d()) goto L8;
    }

    public boolean b(int r1) {
        if ((this.aY & r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean b(com.obric.oui.constraintlayout.core.d r14) {
        boolean r0 = b(64);
        a(r14, r0);
        int r1 = this.aV.size();
        int r3 = 0;
        boolean r4 = false;
    L4:
        if (r3 >= r1) goto L9;
        ConstraintWidget r5 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(this.aV.get(r3), ConstraintWidget.class, "com.obric.memorydata.plugin");
        r5.a(0, false);
        r5.a(1, false);
        if (ZeusTransformUtils.instanceOf(r5, a.class) == false) goto L8;
        r4 = true;
    L8:
        r3 = r3 + 1;
        goto L4
    L9:
        if (r4 == false) goto L16;
        int r6 = 0;
    L11:
        if (r6 >= r1) goto L16;
        ConstraintWidget r7 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(this.aV.get(r6), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, a.class) == false) goto L15;
        ((a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin")).f();
    L15:
        r6 = r6 + 1;
    L16:
        this.aS.clear();
        int r8 = 0;
    L17:
        if (r8 >= r1) goto L26;
        ConstraintWidget r9 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(this.aV.get(r8), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r9.ae() == false) goto L24;
        if (ZeusTransformUtils.instanceOf(r9, k.class) == false) goto L23;
        this.aS.add(r9);
        goto L24
    L23:
        r9.a(r14, r0);
    L24:
        r8 = r8 + 1;
    L26:
        if (this.aS.size() <= 0) goto L41;
        int r10 = this.aS.size();
        Iterator<ConstraintWidget> r11 = this.aS.iterator();
    L29:
        if (r11.hasNext() == false) goto L34;
        k r12 = (k) ZeusTransformUtils.preCheckCast((ConstraintWidget) ZeusTransformUtils.preCheckCast(r11.next(), ConstraintWidget.class, "com.obric.memorydata.plugin"), k.class, "com.obric.memorydata.plugin");
        if (r12.a(this.aS) == false) goto L29;
        r12.a(r14, r0);
        this.aS.remove(r12);
    L34:
        if (r10 != this.aS.size()) goto L26;
        Iterator<ConstraintWidget> r13 = this.aS.iterator();
    L37:
        if (r13.hasNext() == false) goto L39;
        ((ConstraintWidget) ZeusTransformUtils.preCheckCast(r13.next(), ConstraintWidget.class, "com.obric.memorydata.plugin")).a(r14, r0);
        goto L37
    L39:
        this.aS.clear();
        goto L26
    L41:
        if (com.obric.oui.constraintlayout.core.d.f13524a == false) goto L56;
        HashSet<ConstraintWidget> r15 = new HashSet();
        int r16 = 0;
    L43:
        if (r16 >= r1) goto L49;
        ConstraintWidget r17 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(this.aV.get(r16), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r17.ae() == true) goto L47;
        r15.add(r17);
    L47:
        r16 = r16 + 1;
        goto L43
    L49:
        if (aa() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L51;
        int r18 = 0;
    L52:
        a(this, r14, r15, r18, false);
        Iterator<ConstraintWidget> r2 = r15.iterator();
    L54:
        if (r2.hasNext() == false) goto L77;
        ConstraintWidget r19 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r2.next(), ConstraintWidget.class, "com.obric.memorydata.plugin");
        i.a(this, r14, r19);
        r19.a(r14, r0);
    L77:
        if (this.aH <= 0) goto L80;
        b.a(this, r14, null, 0);
    L80:
        if (this.aI <= 0) goto L82;
        b.a(this, r14, null, 1);
    L82:
        return true;
    L51:
        r18 = 1;
        goto L52
    L56:
        int r20 = 0;
    L57:
        if (r20 >= r1) goto L77;
        ConstraintWidget r21 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(this.aV.get(r20), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r21, d.class) == false) goto L72;
        ConstraintWidget.DimensionBehaviour r22 = r21.L[0];
        ConstraintWidget.DimensionBehaviour r23 = r21.L[1];
        if (r22 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L64;
        r21.a(ConstraintWidget.DimensionBehaviour.FIXED);
    L64:
        if (r23 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L66;
        r21.b(ConstraintWidget.DimensionBehaviour.FIXED);
    L66:
        r21.a(r14, r0);
        if (r22 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L70;
        r21.a(r22);
    L70:
        if (r23 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L75;
        r21.b(r23);
    L75:
        r20 = r20 + 1;
        goto L57
    L72:
        i.a(this, r14, r21);
        if (r21.ae() == true) goto L75;
        r21.a(r14, r0);
        goto L75
    }

    public void c() {
        this.az.c();
    }

    void c(ConstraintAnchor r5) {
        WeakReference<ConstraintAnchor> r0 = this.bd;
        if (r0 != null) goto L5;
    L8:
        this.bd = new WeakReference(r5);
        return;
    L5:
        if (r0.get() == null) goto L8;
        if (r5.d() > ((ConstraintAnchor) ZeusTransformUtils.preCheckCast(this.bd.get(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).d()) goto L8;
    }

    public void d(ConstraintAnchor r5) {
        WeakReference<ConstraintAnchor> r0 = this.be;
        if (r0 != null) goto L5;
    L8:
        this.be = new WeakReference(r5);
        return;
    L5:
        if (r0.get() == null) goto L8;
        if (r5.d() > ((ConstraintAnchor) ZeusTransformUtils.preCheckCast(this.be.get(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).d()) goto L8;
    }

    public void f() {
        this.f13638a.a(this);
    }

    public com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC0736b g() {
        return this.aA;
    }

    public boolean g(boolean r1) {
        return this.az.b(r1);
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public String getType() {
        return "ConstraintLayout";
    }

    public int h() {
        return this.aY;
    }

    public void h(boolean r1) {
        this.aX = r1;
    }

    public boolean i() {
        return this.aZ;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.l, com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public void w() {
        this.aC.b();
        this.aD = 0;
        this.aF = 0;
        this.aE = 0;
        this.aG = 0;
        this.aQ = false;
        super.w();
    }
}
