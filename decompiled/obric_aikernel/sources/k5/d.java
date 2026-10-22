package k5;

/* JADX INFO: loaded from: classes.dex */
public class d implements m5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f10087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f10088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected long f10089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected long f10090d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected long f10091e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected double f10092f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected double f10093g;

    public d() {
        this.f10087a = null;
        this.f10088b = -1;
        this.f10089c = 0;
        this.f10090d = 0;
        this.f10091e = 0;
        this.f10092f = 0.0d;
        this.f10093g = 0.0d;
    }

    public void a(m5.b r10) {
        long r11 = b();
        if (r10 != null) goto L5;
        long r12 = 0;
    L6:
        long r13 = r11 - r12;
        this.f10090d = r13;
        if (this.f10091e != 0) goto L10;
        this.f10091e = r13;
        return;
    L10:
        return;
    L5:
        r12 = ((d) r10).b();
        goto L6
    }

    public long b() {
        return this.f10089c;
    }

    public long c() {
        return this.f10090d;
    }

    public void d() {
        this.f10087a = null;
        this.f10088b = -1;
        this.f10089c = 0;
        this.f10090d = 0;
        this.f10091e = 0;
        this.f10092f = 0.0d;
        this.f10093g = 0.0d;
    }

    public void e(long r10) {
        if (this.f10090d >= 0) goto L5;
        return;
    L5:
        if (r10 <= 0) goto L9;
        this.f10093g = c() / r10;
        return;
    }

    public void f(long r10) {
        this.f10089c = r10;
    }

    public void g(long r10) {
        if (this.f10090d >= 0) goto L5;
        return;
    L5:
        if (r10 <= 0) goto L9;
        this.f10092f = c() / r10;
        return;
    }

    public void h(int r10) {
        this.f10088b = r10;
    }

    public void i(String r10) {
        this.f10087a = r10;
    }

    public String toString() {
        return "proc_stat:{pid=" + this.f10088b + " process_name:" + this.f10087a + " delta cpu_time:" + c() + " cpu_usage:" + (this.f10092f * 100.0d) + "% cpu_rate:" + this.f10093g + "}";
    }
}
