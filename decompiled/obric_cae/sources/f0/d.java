package f0;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f7233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f7234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7235c;

    public interface a {
        void onCancel();
    }

    public d() {
    }

    public final void a() {
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L4:
        if (this.f7233a == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L7:
        this.f7233a = true;     // Catch: Throwable -> L28
        this.f7235c = true;     // Catch: Throwable -> L28
        a r8 = this.f7234b;     // Catch: Throwable -> L28
        monitor-exit(this);     // Catch: Throwable -> L28
        if (r8 != null) goto L31;
    L21:
        monitor-enter(this);
        this.f7235c = false;     // Catch: Throwable -> L25
        notifyAll();     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        throw th;
    L31:
        r8.onCancel();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        monitor-enter(this);
        this.f7235c = false;     // Catch: Throwable -> L18
        notifyAll();     // Catch: Throwable -> L18
        throw th;
    L18:
        th = move-exception;
        throw th;
    }

    public final void b(a r8) {
        monitor-enter(this);
    L24:
    L18:
        th = move-exception;
        throw th;
    L4:
        if (this.f7235c == false) goto L8;
        wait();     // Catch: InterruptedException -> L21 Throwable -> L18
        goto L24
    L8:
        if (this.f7234b != r8) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L11:
        this.f7234b = r8;     // Catch: Throwable -> L18
        if (this.f7233a == false) goto L16;
        monitor-exit(this);     // Catch: Throwable -> L18
        r8.onCancel();
        return;
    L16:
        monitor-exit(this);     // Catch: Throwable -> L18
    }
}
