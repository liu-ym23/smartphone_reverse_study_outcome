package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.m;
import j1.b0;

/* JADX INFO: loaded from: classes.dex */
public class RescheduleReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2848a = null;

    static {
        f2848a = m.f("RescheduleReceiver");
    }

    public RescheduleReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r8, Intent r10) {
        m.d().a(f2848a, "Received intent " + r10);
        b0 r11 = b0.f(r8);     // Catch: IllegalStateException -> L16
        BroadcastReceiver.PendingResult r12 = goAsync();     // Catch: IllegalStateException -> L16
        r11.getClass();     // Catch: IllegalStateException -> L16
        Object r13 = b0.f8450m;     // Catch: IllegalStateException -> L16
        monitor-enter(r13);     // Catch: IllegalStateException -> L16
        BroadcastReceiver.PendingResult r14 = r11.f8459i;     // Catch: Throwable -> L13
        if (r14 == null) goto L8;
        r14.finish();     // Catch: Throwable -> L13
    L8:
        r11.f8459i = r12;     // Catch: Throwable -> L13
        if (r11.f8458h == false) goto L11;
        r12.finish();     // Catch: Throwable -> L13
        r11.f8459i = null;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r13);     // Catch: Throwable -> L13
    L23:
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: IllegalStateException -> L16
    L16:
        e = move-exception;
        m.d().c(f2848a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e);
    }
}
