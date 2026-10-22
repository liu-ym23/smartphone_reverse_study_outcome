package s1;

import androidx.work.WorkerParameters;

/* JADX INFO: loaded from: classes.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j1.b0 f11995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j1.t f11996b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final WorkerParameters.a f11997m;

    public q(j1.b0 r8, j1.t r10, WorkerParameters.a r11) {
        this.f11995a = r8;
        this.f11996b = r10;
        this.f11997m = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11995a.f8456f.g(this.f11996b, this.f11997m);
    }
}
