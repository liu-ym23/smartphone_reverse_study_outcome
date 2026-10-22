package kotlinx.coroutines.sync;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f19018a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g8.g f19019b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g8.g f19020c = null;
    public static final g8.g d = null;
    public static final g8.g e = null;
    public static final int f = 0;

    static {
        f19018a = kotlinx.coroutines.internal.f.j("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12);
        f19019b = new g8.g("PERMIT", 10);
        f19020c = new g8.g("TAKEN", 10);
        d = new g8.g("BROKEN", 10);
        e = new g8.g("CANCELLED", 10);
        f = kotlinx.coroutines.internal.f.j("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12);
    }
}
