package i0;

/* JADX INFO: loaded from: classes.dex */
public final class e<T> extends d<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f8083c;

    public e() {
        super(12);
        this.f8083c = new Object();
    }

    @Override // i0.d
    public final T a() {
        Object r8 = this.f8083c;
        monitor-enter(r8);
        T r10 = (T) super.a();
        monitor-exit(r8);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // i0.d
    public final boolean b(T r8) {
        Object r10 = this.f8083c;
        monitor-enter(r10);
        boolean r11 = super.b(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }
}
