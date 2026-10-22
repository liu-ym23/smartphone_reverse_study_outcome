package s1;

import android.content.Context;
import android.content.Intent;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t1.c f12013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UUID f12014b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ androidx.work.h f12015m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Context f12016n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ a0 f12017o;

    public z(a0 r8, t1.c r10, UUID r11, androidx.work.h r12, Context r13) {
        this.f12017o = r8;
        this.f12013a = r10;
        this.f12014b = r11;
        this.f12015m = r12;
        this.f12016n = r13;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L13:
        th = move-exception;
        this.f12013a.k(th);
        return;
    L3:
        if ((this.f12013a.f12216a instanceof t1.a.b) == true) goto L11;
        String r8 = this.f12014b.toString();     // Catch: Throwable -> L13
        r1.t r10 = this.f12017o.f11949c.g(r8);     // Catch: Throwable -> L13
        if (r10 == null) goto L10;
        if (r10.f11340b.a() == true) goto L10;
        q1.a r11 = this.f12017o.f11948b;     // Catch: Throwable -> L13
        j1.p r12 = (j1.p) r11;     // Catch: Throwable -> L13
        r12.e(r8, this.f12015m);     // Catch: Throwable -> L13
        Intent r13 = androidx.work.impl.foreground.a.a(this.f12016n, l6.a.L(r10), this.f12015m);     // Catch: Throwable -> L13
        this.f12016n.startService(r13);     // Catch: Throwable -> L13
    L10:
        throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");     // Catch: Throwable -> L13
    L11:
        this.f12013a.j(null);     // Catch: Throwable -> L13
    }
}
