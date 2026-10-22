package q1;

import android.app.Notification;
import androidx.work.impl.foreground.SystemForegroundService;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Notification f10127b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ SystemForegroundService f10128m;

    public c(SystemForegroundService r8, int r10, Notification r11) {
        this.f10128m = r8;
        this.f10126a = r10;
        this.f10127b = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f10128m.f2898o.notify(this.f10126a, this.f10127b);
    }
}
