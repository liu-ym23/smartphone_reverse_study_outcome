package pta;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public abstract class e<T> {
    public volatile T a;

    public e() {
    }

    public abstract T a(Object... r1);

    public final T b(Object... r2) {
        if (this.a != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.a != null) goto L8;
        this.a = a(r2);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.a;
    }
}
