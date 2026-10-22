package com.obric.oui.constraintlayout.core.widgets;

import com.obric.oui.constraintlayout.core.SolverVariable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public class f extends ConstraintWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected float f13641a;
    protected int aA;
    protected boolean aB;
    private ConstraintAnchor aC;
    private int aD;
    private int aE;
    private boolean aF;
    protected int az;

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.core.widgets.f$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13642a = null;

        static {
            int[] r0 = new int[ConstraintAnchor.Type.values().length];
            f13642a = r0;
            r0[ConstraintAnchor.Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            f13642a[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            f13642a[ConstraintAnchor.Type.TOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            f13642a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            f13642a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f13642a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            f13642a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f13642a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            f13642a[ConstraintAnchor.Type.NONE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    public f() {
        this.f13641a = -1.0f;
        this.az = -1;
        this.aA = -1;
        this.aB = true;
        this.aC = this.C;
        int r0 = 0;
        this.aD = 0;
        this.aE = 0;
        this.K.clear();
        this.K.add(this.aC);
        int r1 = this.f13606J.length;
    L3:
        if (r0 >= r1) goto L5;
        this.f13606J[r0] = this.aC;
        r0 = r0 + 1;
        goto L3
    }

    public void A(int r3) {
        if (r3 <= (-1)) goto L6;
        this.f13641a = -1.0f;
        this.az = -1;
        this.aA = r3;
        return;
    }

    public void B(int r2) {
        this.aC.a(r2);
        this.aF = true;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public ConstraintAnchor a(ConstraintAnchor.Type r3) {
        int r4 = AnonymousClass1.f13642a[r3.ordinal()];
        if (r4 == 1) goto L16;
        if (r4 == 2) goto L16;
        if (r4 == 3) goto L12;
        if (r4 == 4) goto L12;
        return null;
    L12:
        if (this.aD == 0) goto L14;
        return null;
    L14:
        return this.aC;
    L16:
        if (this.aD == 1) goto L18;
        return null;
    L18:
        return this.aC;
    }

    public void a(int r4) {
        if (this.aD != r4) goto L5;
        return;
    L5:
        this.aD = r4;
        this.K.clear();
        if (this.aD != 1) goto L8;
        ConstraintAnchor r5 = this.B;
    L9:
        this.aC = r5;
        this.K.add(this.aC);
        int r6 = this.f13606J.length;
        int r0 = 0;
    L10:
        if (r0 >= r6) goto L12;
        this.f13606J[r0] = this.aC;
        r0 = r0 + 1;
        goto L10
    L12:
        return;
    L8:
        r5 = this.C;
        goto L9
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public void a(com.obric.oui.constraintlayout.core.d r8, boolean r9) {
        d r10 = (d) ZeusTransformUtils.preCheckCast(A(), d.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L5;
        return;
    L5:
        ConstraintAnchor r0 = r10.a(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor r1 = r10.a(ConstraintAnchor.Type.RIGHT);
        boolean r3 = true;
        if (this.M != null) goto L8;
    L10:
        boolean r2 = false;
    L12:
        if (this.aD != 0) goto L21;
        r0 = r10.a(ConstraintAnchor.Type.TOP);
        r1 = r10.a(ConstraintAnchor.Type.BOTTOM);
        if (this.M != null) goto L16;
    L18:
        r3 = false;
    L19:
        r2 = r3;
        goto L21
    L16:
        if (this.M.L[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L18;
    L21:
        if (this.aF == false) goto L35;
        if (this.aC.f() == false) goto L35;
        SolverVariable r11 = r8.a(this.aC);
        r8.a(r11, this.aC.d());
        if (this.az == (-1)) goto L29;
        if (r2 == false) goto L32;
        r8.a(r8.a(r1), r11, 0, 5);
    L32:
        this.aF = false;
        return;
    L29:
        if (this.aA == (-1)) goto L32;
        if (r2 == false) goto L32;
        SolverVariable r4 = r8.a(r1);
        r8.a(r11, r8.a(r0), 0, 5);
        r8.a(r4, r11, 0, 5);
    L35:
        if (this.az == (-1)) goto L40;
        SolverVariable r12 = r8.a(this.aC);
        r8.c(r12, r8.a(r0), this.az, 8);
        if (r2 == false) goto L48;
        r8.a(r8.a(r1), r12, 0, 5);
        return;
    L48:
        return;
    L40:
        if (this.aA == (-1)) goto L45;
        SolverVariable r13 = r8.a(this.aC);
        SolverVariable r5 = r8.a(r1);
        r8.c(r13, r5, -this.aA, 8);
        if (r2 == false) goto L50;
        r8.a(r13, r8.a(r0), 0, 5);
        r8.a(r5, r13, 0, 5);
        return;
    L50:
        return;
    L45:
        if (this.f13641a == (-1.0f)) goto L52;
        r8.a(com.obric.oui.constraintlayout.core.d.a(r8, r8.a(this.aC), r8.a(r1), this.f13641a));
        return;
    L52:
        return;
    L8:
        if (this.M.L[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L10;
        r2 = true;
        goto L12
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public void a(ConstraintWidget r2, HashMap<ConstraintWidget, ConstraintWidget> r3) {
        super.a(r2, r3);
        f r4 = (f) ZeusTransformUtils.preCheckCast(r2, f.class, "com.obric.memorydata.plugin");
        this.f13641a = r4.f13641a;
        this.az = r4.az;
        this.aA = r4.aA;
        this.aB = r4.aB;
        a(r4.aD);
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public boolean a() {
        return true;
    }

    public ConstraintAnchor b() {
        return this.aC;
    }

    public void b(int r3) {
        if (r3 <= (-1)) goto L6;
        this.f13641a = -1.0f;
        this.az = r3;
        this.aA = -1;
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public void b(com.obric.oui.constraintlayout.core.d r3, boolean r4) {
        if (A() != null) goto L5;
        return;
    L5:
        int r5 = r3.b(this.aC);
        if (this.aD != 1) goto L8;
        o(r5);
        p(0);
        r(A().G());
        q(0);
        return;
    L8:
        o(0);
        p(r5);
        q(A().F());
        r(0);
    }

    public int c() {
        return this.aD;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public boolean d() {
        return this.aF;
    }

    public void e(float r2) {
        if (r2 <= (-1.0f)) goto L6;
        this.f13641a = r2;
        this.az = -1;
        this.aA = -1;
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public boolean e() {
        return this.aF;
    }

    public float f() {
        return this.f13641a;
    }

    public int g() {
        return this.az;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public String getType() {
        return "Guideline";
    }

    public int h() {
        return this.aA;
    }
}
