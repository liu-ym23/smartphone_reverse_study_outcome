package d7;

/* JADX INFO: loaded from: classes.dex */
public final enum u extends Enum<u> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u f6946b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final u f6947m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final u f6948n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final u f6949o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final u f6950p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ u[] f6951q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6952a;

    static {
        u r8 = new u("NOT_SET", 0, 0);
        f6946b = r8;
        u r10 = new u("SERVE_FROM_CACHE", 1, 2);
        f6947m = r10;
        u r11 = new u("SERVE_FROM_PREFER_ADDR", 2, 5);
        u r12 = new u("SERVE_FROM_HTTP_DNS_JOB", 3, 6);
        f6948n = r12;
        u r13 = new u("SERVE_FROM_PROC_DNS_JOB", 4, 8);
        f6949o = r13;
        u r14 = new u("SERVE_FROM_HARDCODE_HOSTS", 5, 9);
        f6950p = r14;
        f6951q = new u[]{r8, r10, r11, r12, r13, r14, new u("SERVE_FROM_BATCH_PRELOAD", 6, 19), new u("SERVE_FROM_ASYNC_BATCH_PRELOAD", 7, 20)};
    }

    public u(String r8, int r10, int r11) {
        super(r8, r10);
        this.f6952a = r11;
    }

    public static u valueOf(String r8) {
        return (u) Enum.valueOf(u.class, r8);
    }

    public static u[] values() {
        return (u[]) f6951q.clone();
    }
}
