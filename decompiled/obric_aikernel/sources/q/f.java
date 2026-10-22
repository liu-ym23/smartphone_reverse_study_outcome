package q;

/* JADX INFO: loaded from: classes.dex */
public class f extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f12411e;

    public f() {
        super("cpu_active_time");
        this.f12411e = 0;
    }

    private long i() {
        return com.bytedance.apm.util.b.k(100);
    }

    @Override // q.b
    protected void c(boolean r10, boolean r11) {
        long r12 = com.bytedance.apm.util.b.b();
        long r13 = this.f12411e;
        if (r13 <= 0) goto L9;
        if (r11 == false) goto L9;
        long r14 = r12 - r13;
        if (r14 <= 0) goto L8;
        h(r10, r14, k.a.G().E());
        goto L9
    L8:
        e0.a.d("APM-Battery", "CPU Value:" + r14);
    L9:
        this.f12411e = r12;
    }

    @Override // q.l
    public void e(p.b r10, b0.a r11) {
        boolean r12 = r11.k();
        double r13 = (r11.a() / i()) * 1000.0d;
        if (r12 == false) goto L5;
        r10.l((long) r13);
        return;
    L5:
        r10.b((long) r13);
    }
}
