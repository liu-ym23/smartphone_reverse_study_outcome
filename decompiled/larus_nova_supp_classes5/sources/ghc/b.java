package ghc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class b<T> {
    public volatile boolean a;
    public volatile boolean b;
    public T c;

    public T b() {
        throw null;
    }

    public final T a() {
        T r0 = this.c;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.b == true) goto L23;
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L10:
        if (this.b == false) goto L14;
        T r1 = this.c;     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
    L20:
        return r1;
    L14:
        this.c = b();     // Catch: Throwable -> L17
        this.b = true;     // Catch: Throwable -> L17
        r1 = this.c;     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        goto L20
    L23:
        return this.c;
    }

    public b() {
        this.a = false;
        this.b = false;
    }
}
