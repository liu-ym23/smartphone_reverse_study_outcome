package q;

/* JADX INFO: loaded from: classes.dex */
public class j extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile long f12420e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile long f12421f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private l0.h f12422g;

    public j() {
        super("traffic");
        this.f12420e = -1;
        this.f12421f = -1;
        this.f12422g = l0.h.e();
    }

    private void i(boolean r10) {
        long r11 = this.f12422g.c();
        long r12 = this.f12422g.a();
        if (this.f12421f > (-1)) goto L5;
    L8:
        this.f12420e = r11;
        this.f12421f = r12;
        return;
    L5:
        if (this.f12420e <= (-1)) goto L8;
        if (r10 == false) goto L8;
        String r13 = k.a.G().E();
        h(true, r11 - this.f12420e, r13);
        h(false, r12 - this.f12421f, r13);
        goto L8
    }

    @Override // q.b
    protected void c(boolean r10, boolean r11) {
        if (g() == false) goto L14;
        i(r11);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        if (com.bytedance.apm.d.D() == false) goto L10;
        e0.e.d(e0.b.f8548b, new String[]{"handleTrafficMonitor error: " + th.getCause()});
    L10:
        t4.a.d(th, "BatteryTrafficStatsImpl");
        return;
    }

    @Override // q.l
    public void e(p.b r10, b0.a r11) {
        boolean r12 = r11.k();
        long r13 = r11.a();
        if (r12 == false) goto L5;
        r10.p(r13);
        return;
    L5:
        r10.f(r13);
    }
}
