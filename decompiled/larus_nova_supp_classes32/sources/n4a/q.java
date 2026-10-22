package n4a;

import android.os.Looper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q extends l1 {
    public final /* synthetic */ e5 b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ r d;

    public q(r r1, e5 r2, boolean r3) {
        this.d = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // n4a.l1
    public final void a() {
        Looper r0 = Looper.getMainLooper();     // Catch: Throwable -> L13
        monitor-enter(r0);     // Catch: Throwable -> L13
        p.a(this.b);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
    L7:
        if (this.c == false) goto L19;
        t.a(this.d.d);     // Catch: Throwable -> L13
        return;
    L19:
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.printStackTrace();
    }
}
