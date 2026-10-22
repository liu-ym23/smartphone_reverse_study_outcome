package androidx.work.impl.foreground;

import android.app.Notification;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Notification f2910b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f2911m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ SystemForegroundService f2912n;

    public b(SystemForegroundService r8, int r10, Notification r11, int r12) {
        this.f2912n = r8;
        this.f2909a = r10;
        this.f2910b = r11;
        this.f2911m = r12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Notification r8 = this.f2910b;
        int r10 = this.f2911m;
        SystemForegroundService.a.a(this.f2912n, this.f2909a, r8, r10);
    }
}
