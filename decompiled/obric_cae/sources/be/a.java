package be;

/* JADX INFO: loaded from: classes2.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3165a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ a[] f3166b = null;

    static {
        a r8 = new a("COROUTINE_SUSPENDED", 0);
        f3165a = r8;
        f3166b = new a[]{r8, new a("UNDECIDED", 1), new a("RESUMED", 2)};
    }

    public a(String r8, int r10) {
        super(r8, r10);
    }

    public static a valueOf(String r8) {
        return (a) Enum.valueOf(a.class, r8);
    }

    public static a[] values() {
        return (a[]) f3166b.clone();
    }
}
