package pb;

import qb.k;
import qb.s;

/* JADX INFO: loaded from: classes2.dex */
public class b implements s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile b f12360b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private s f12361a;

    static {
    }

    private b() {
        this.f12361a = (s) k.a(s.class);
    }

    public static b b() {
        if (f12360b != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12360b != null) goto L9;
        f12360b = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f12360b;
    }

    @Override // qb.s
    public void a(int r10) {
        this.f12361a.a(r10);
    }

    @Override // qb.s
    public void cancelNotification(int r10) {
        this.f12361a.cancelNotification(r10);
    }
}
