package h;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f17253b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f17254c = 0;
    public static final int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f17255a;

    static {
        f17253b = new b();
        int r5 = Runtime.getRuntime().availableProcessors();
        f17254c = r5 + 1;
        d = (r5 * 2) + 1;
    }

    public b() {
        this.f17255a = new a(0);
    }
}
