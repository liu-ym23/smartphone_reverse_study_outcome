package c4;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f3326b;

    public /* synthetic */ b(int r8) {
        this.f3325a = r8;
    }

    public abstract Object a(Object... r8);

    public final Object b(Object... r8) {
        switch(this.f3325a) {
            case 0: goto L19;
            case 1: goto L6;
            default: goto L32;
        };
    L6:
        if (this.f3326b != null) goto L17;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.f3326b != null) goto L11;
        this.f3326b = a(r8);     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
    L17:
        return this.f3326b;
    L19:
        if (this.f3326b != null) goto L30;
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L22:
        if (this.f3326b != null) goto L24;
        this.f3326b = a(r8);     // Catch: Throwable -> L26
    L24:
        monitor-exit(this);     // Catch: Throwable -> L26
    L30:
        return this.f3326b;
    L32:
        if (this.f3326b != null) goto L43;
        monitor-enter(this);
    L39:
        th = move-exception;
        throw th;
    L35:
        if (this.f3326b != null) goto L37;
        this.f3326b = a(r8);     // Catch: Throwable -> L39
    L37:
        monitor-exit(this);     // Catch: Throwable -> L39
    L43:
        return this.f3326b;
    }
}
