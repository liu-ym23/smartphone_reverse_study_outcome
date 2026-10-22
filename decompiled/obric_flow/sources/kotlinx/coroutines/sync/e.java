package kotlinx.coroutines.sync;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g8.g f19013a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g8.g f19014b = null;

    static {
        int r5 = 10;
        f19013a = new g8.g("NO_OWNER", r5);
        f19014b = new g8.g("ALREADY_LOCKED_BY_OWNER", r5);
    }

    public static d a() {
        return new d(false);
    }
}
