package q;

/* JADX INFO: loaded from: classes.dex */
public class h extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile long f12413e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile long f12414f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private l0.h f12415g;

    public h() {
        super("traffic_packets");
        this.f12413e = -1;
        this.f12414f = -1;
        this.f12415g = l0.h.e();
    }

    private void i(boolean r10) {
        long r11 = this.f12415g.d();
        long r12 = this.f12415g.b();
        if (this.f12414f > (-1)) goto L5;
    L8:
        this.f12413e = r11;
        this.f12414f = r12;
        return;
    L5:
        if (this.f12413e <= (-1)) goto L8;
        if (r10 == false) goto L8;
        String r13 = k.a.G().E();
        h(true, r11 - this.f12413e, r13);
        h(false, r12 - this.f12414f, r13);
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
        t4.a.d(th, "BatteryPacketsStatsImpl");
        return;
    }

    @Override // q.l
    public void e(p.b r10, b0.a r11) {
        boolean r12 = r11.k();
        long r13 = r11.a();
        if (r12 == false) goto L5;
        r10.q(r13);
        return;
    L5:
        r10.g(r13);
    }
}
