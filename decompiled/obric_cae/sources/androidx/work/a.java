package androidx.work;

/* JADX INFO: loaded from: classes.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2791a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f2792b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ a[] f2793m = null;

    static {
        a r8 = new a("EXPONENTIAL", 0);
        f2791a = r8;
        a r10 = new a("LINEAR", 1);
        f2792b = r10;
        f2793m = new a[]{r8, r10};
    }

    public a(String r8, int r10) {
        super(r8, r10);
    }

    public static a valueOf(String r8) {
        return (a) Enum.valueOf(a.class, r8);
    }

    public static a[] values() {
        return (a[]) f2793m.clone();
    }
}
