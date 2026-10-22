package nt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f20308a = null;

    static {
        d r5 = a.f20307a;     // Catch: Throwable -> L8
        if (r5 == null) goto L7;
        f20308a = r5;
        return;
    L7:
        throw new NullPointerException("Scheduler Callable returned null");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw io.reactivex.internal.util.d.d(th);
    }
}
