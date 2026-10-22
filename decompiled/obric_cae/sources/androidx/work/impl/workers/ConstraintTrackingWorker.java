package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.WorkerParameters;
import androidx.work.l;
import androidx.work.m;
import he.i;
import java.util.ArrayList;
import java.util.List;
import n1.c;
import r1.t;
import v1.a;
import xd.j;

/* JADX INFO: loaded from: classes.dex */
public final class ConstraintTrackingWorker extends l implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WorkerParameters f2920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f2921b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f2922m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final t1.c<l.a> f2923n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public l f2924o;

    public ConstraintTrackingWorker(Context r8, WorkerParameters r10) {
        i.f(r8, "appContext");
        i.f(r10, "workerParameters");
        super(r8, r10);
        this.f2920a = r10;
        this.f2921b = new Object();
        this.f2923n = new t1.c();
    }

    @Override // n1.c
    public final void c(ArrayList r8) {
        i.f(r8, "workSpecs");
        m.d().a(a.f12704a, "Constraints changed for " + r8);
        Object r10 = this.f2921b;
        monitor-enter(r10);
        this.f2922m = true;     // Catch: Throwable -> L8
        j r11 = j.f13877a;     // Catch: Throwable -> L8
        monitor-exit(r10);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // n1.c
    public final void e(List<t> r8) {
    }

    @Override // androidx.work.l
    public final void onStopped() {
        super.onStopped();
        l r8 = this.f2924o;
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.isStopped() == true) goto L9;
        r8.stop();
        return;
    }

    @Override // androidx.work.l
    public final ga.a<l.a> startWork() {
        getBackgroundExecutor().execute(new androidx.activity.j(this, 10));
        t1.c<l.a> r8 = this.f2923n;
        i.e(r8, "future");
        return r8;
    }
}
