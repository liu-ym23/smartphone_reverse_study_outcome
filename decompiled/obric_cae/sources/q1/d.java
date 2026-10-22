package q1;

import androidx.work.impl.foreground.SystemForegroundService;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SystemForegroundService f10130b;

    public d(SystemForegroundService r8, int r10) {
        this.f10130b = r8;
        this.f10129a = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f10130b.f2898o.cancel(this.f10129a);
    }
}
