package d3;

/* JADX INFO: loaded from: classes.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f8445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f8447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f8448d;

    a() {
        this.f8445a = false;
        this.f8446b = -1;
        this.f8447c = -1;
        this.f8448d = -1;
    }

    public int a() {
        return this.f8446b;
    }

    public long b() {
        long r10 = this.f8447c;
        if (r10 < 0) goto L11;
        long r11 = this.f8448d;
        if (r11 >= 0) goto L7;
        return -1;
    L7:
        if (r10 <= r11) goto L10;
        return -1;
    L10:
        return r11 - r10;
    L11:
        return -1;
    }

    public boolean c() {
        return this.f8445a;
    }

    public void d(long r10) {
        this.f8448d = r10;
    }

    public void e(boolean r10) {
        this.f8445a = r10;
    }

    public void f(int r10) {
        this.f8446b = r10;
    }

    public void g(long r10) {
        this.f8447c = r10;
    }
}
