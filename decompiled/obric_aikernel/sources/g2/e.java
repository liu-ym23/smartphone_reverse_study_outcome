package g2;

/* JADX INFO: loaded from: classes.dex */
public abstract class e implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f8950c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f8951g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f8952h;

    public e() {
        this(0);
    }

    public e(long r10) {
        this(r10, 0);
    }

    public e(long r10, long r11) {
        this.f8950c = r10;
        this.f8952h = r11;
        if (r11 <= 0) goto L6;
        this.f8951g = true;
        return;
    }

    public final long a() {
        return this.f8950c;
    }

    public final long b() {
        return this.f8952h;
    }

    public final boolean c() {
        return this.f8951g;
    }
}
