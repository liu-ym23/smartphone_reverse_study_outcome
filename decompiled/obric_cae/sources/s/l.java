package s;

import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: classes.dex */
public class l extends j {
    public boolean A0;
    public int B0;
    public int C0;
    public final t.b.a D0;
    public t.b.InterfaceC0157b E0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f11934u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f11935v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f11936w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f11937x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f11938y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public int f11939z0;

    public l() {
        this.f11934u0 = 0;
        this.f11935v0 = 0;
        this.f11936w0 = 0;
        this.f11937x0 = 0;
        this.f11938y0 = 0;
        this.f11939z0 = 0;
        this.A0 = false;
        this.B0 = 0;
        this.C0 = 0;
        this.D0 = new t.b.a();
        this.E0 = null;
    }

    public void R(int r8, int r10, int r11, int r12) {
    }

    public final void S(e r8, e.a r10, int r11, e.a r12, int r13) {
    L2:
        t.b.InterfaceC0157b r14 = this.E0;
        if (r14 != null) goto L7;
        e r15 = this.W;
        if (r15 == null) goto L7;
        this.E0 = ((f) r15).f11899w0;
    L7:
        t.b.a r16 = this.D0;
        r16.f12139a = r10;
        r16.f12140b = r12;
        r16.f12141c = r11;
        r16.f12142d = r13;
        ((ConstraintLayout.b) r14).b(r8, r16);
        r8.N(r16.f12143e);
        r8.K(r16.f12144f);
        r8.F = r16.f12146h;
        int r17 = r16.f12145g;
        r8.d0 = r17;
        if (r17 <= 0) goto L10;
        boolean r18 = true;
    L11:
        r8.F = r18;
        return;
    L10:
        r18 = false;
        goto L11
    }

    @Override // s.j, s.i
    public final void a() {
        int r8 = 0;
    L4:
        if (r8 >= this.f11932t0) goto L9;
        e r10 = this.f11931s0[r8];
        if (r10 == null) goto L8;
        r10.H = true;
    L8:
        r8 = r8 + 1;
        goto L4
    }
}
