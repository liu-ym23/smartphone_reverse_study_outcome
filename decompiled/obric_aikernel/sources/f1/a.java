package f1;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile T f8785a;

    public a() {
    }

    protected abstract T a(Object... r10);

    public final T b(Object... r10) {
        if (this.f8785a != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f8785a != null) goto L8;
        this.f8785a = a(r10);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f8785a;
    }
}
