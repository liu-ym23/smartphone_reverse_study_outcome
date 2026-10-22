package l1;

import android.os.Handler;
import androidx.work.impl.background.systemalarm.c;
import androidx.work.m;
import r1.l;
import s1.d0;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f9128b;

    public /* synthetic */ b(c r8, int r10) {
        this.f9127a = r10;
        this.f9128b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f9127a) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        c.b(this.f9128b);
        return;
    L7:
        c r8 = this.f9128b;
        if (r8.f2868q != 0) goto L20;
        r8.f2868q = 1;
        m.d().a(c.f2861w, "onAllConstraintsMet for " + r8.f2864m);
        if (r8.f2865n.f2878n.g(r8.f2873v, null) == false) goto L19;
        d0 r10 = r8.f2865n.f2877m;
        l r11 = r8.f2864m;
        Object r12 = r10.f11968d;
        monitor-enter(r12);
        m.d().a(d0.f11964e, "Starting timer for " + r11);     // Catch: Throwable -> L16
        r10.a(r11);     // Catch: Throwable -> L16
        d0.b r13 = new d0.b(r10, r11);     // Catch: Throwable -> L16
        r10.f11966b.put(r11, r13);     // Catch: Throwable -> L16
        r10.f11967c.put(r11, r8);     // Catch: Throwable -> L16
        ((Handler) ((b9.a) r10.f11965a).f3135b).postDelayed(r13, 600000);     // Catch: Throwable -> L16
        monitor-exit(r12);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    L19:
        r8.d();
        return;
    L20:
        m.d().a(c.f2861w, "Already started work for " + r8.f2864m);
    }
}
