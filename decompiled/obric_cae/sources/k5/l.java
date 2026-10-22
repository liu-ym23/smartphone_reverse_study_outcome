package k5;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public abstract class l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile T f8949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f8950b;

    public l() {
        this.f8950b = new AtomicBoolean(false);
    }

    public abstract T a(Object... r8);

    public final T b(Object... r8) {
        if (this.f8950b.get() == true) goto L18;
        if (this.f8949a != null) goto L18;
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (this.f8950b.get() == false) goto L10;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
        goto L18
    L10:
        if (this.f8949a != null) goto L12;
        this.f8949a = a(r8);     // Catch: Throwable -> L14
        this.f8950b.set(true);     // Catch: Throwable -> L14
    L18:
        return this.f8949a;
    }
}
