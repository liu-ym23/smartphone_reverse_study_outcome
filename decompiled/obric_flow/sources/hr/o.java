package hr;

import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o extends l {
    public int A0;
    public int B0;
    public boolean C0;
    public int D0;
    public int E0;
    public final com.obric.oui.constraintlayout.core.widgets.analyzer.b F0;
    public com.obric.oui.constraintlayout.core.widgets.analyzer.c G0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f17465w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f17466x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f17467y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public int f17468z0;

    public o() {
        this.f17465w0 = 0;
        this.f17466x0 = 0;
        this.f17467y0 = 0;
        this.f17468z0 = 0;
        this.A0 = 0;
        this.B0 = 0;
        this.C0 = false;
        this.D0 = 0;
        this.E0 = 0;
        this.F0 = new com.obric.oui.constraintlayout.core.widgets.analyzer.b();
        this.G0 = null;
    }

    @Override // hr.l
    public final void U() {
        int r5 = 0;
    L4:
        if (r5 >= this.f17463v0) goto L9;
        f r10 = this.f17462u0[r5];
        if (r10 == null) goto L8;
        r10.G = true;
    L8:
        r5 = r5 + 1;
        goto L4
    }

    public abstract void V(int r5, int r10, int r11, int r12);

    public final void W(f r5, ConstraintWidget$DimensionBehaviour r10, int r11, ConstraintWidget$DimensionBehaviour r12, int r13) {
    L2:
        com.obric.oui.constraintlayout.core.widgets.analyzer.c r14 = this.G0;
        if (r14 != null) goto L7;
        f r15 = this.V;
        if (r15 == null) goto L7;
        this.G0 = ((g) r15).f17436y0;
    L7:
        com.obric.oui.constraintlayout.core.widgets.analyzer.b r16 = this.F0;
        r16.f12559a = r10;
        r16.f12560b = r12;
        r16.f12561c = r11;
        r16.d = r13;
        ((com.obric.oui.constraintlayout.widget.b) r14).b(r5, r16);
        r5.P(r16.e);
        r5.M(r16.f);
        r5.E = r16.f12562h;
        r5.J(r16.g);
    }
}
