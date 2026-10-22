package w1;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import qa.k2;
import qa.t3;

/* JADX INFO: loaded from: classes.dex */
public final class c extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n4.b f12953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12954b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f12955m;

    public c() {
        this.f12954b = 0;
        this.f12955m = false;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r8) {
        return this.f12953a.a(r8);
    L4:
        th = move-exception;
        t3.g("APSService", "onBind", th);
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
    L7:
        th = move-exception;
        t3.g("APSService", "onCreate", th);
    L9:
        super.onCreate();
        return;
    L3:
        if (this.f12953a != null) goto L5;
        this.f12953a = new n4.b(this);     // Catch: Throwable -> L7
    L5:
        this.f12953a.b();     // Catch: Throwable -> L7
        goto L9
    }

    @Override // android.app.Service
    public final void onDestroy() {
        n4.b r8 = this.f12953a;     // Catch: Throwable -> L14
        r8.getClass();     // Catch: Throwable -> L14
        Object r10 = r8.f9430a;     // Catch: Throwable -> L8
        if (((k2) r10) == null) goto L11;
        ((k2) r10).f10730g.sendEmptyMessage(11);     // Catch: Throwable -> L8
    L11:
        if (this.f12955m == false) goto L16;
        stopForeground(true);     // Catch: Throwable -> L14
    L16:
        super.onDestroy();
        return;
    L8:
        th = move-exception;
        t3.g("ApsServiceCore", "onDestroy", th);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        t3.g("APSService", "onDestroy", th);
        goto L16
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r8, int r10, int r11) {
        if (r8 == null) goto L33;
        int r12 = r8.getIntExtra("g", 0);     // Catch: Throwable -> L31
        if (r12 != 1) goto L10;
        int r13 = r8.getIntExtra("i", 0);     // Catch: Throwable -> L31
        Notification r14 = (Notification) r8.getParcelableExtra("h");     // Catch: Throwable -> L31
        if (r13 == 0) goto L33;
        if (r14 == null) goto L33;
        startForeground(r13, r14);     // Catch: Throwable -> L31
        this.f12955m = true;     // Catch: Throwable -> L31
        this.f12954b++;     // Catch: Throwable -> L31
        goto L33
    L10:
        if (r12 != 2) goto L33;
        if (r8.getBooleanExtra("j", true) == false) goto L17;
        int r15 = this.f12954b;     // Catch: Throwable -> L31
        if (r15 <= 0) goto L17;
        this.f12954b = r15 - 1;     // Catch: Throwable -> L31
    L17:
        if (this.f12954b > 0) goto L19;
        stopForeground(true);     // Catch: Throwable -> L31
        this.f12955m = false;     // Catch: Throwable -> L31
        goto L33
    L19:
        stopForeground(false);     // Catch: Throwable -> L31
    L33:
        Object r16 = this.f12953a.f9430a;     // Catch: Throwable -> L25
        if (((k2) r16) == null) goto L27;
        if (((k2) r16).f10745v.G == true) goto L27;
        return 2;
    L27:
        return 3;
    L25:
        th = move-exception;
        t3.g("APSService", "onStartCommand", th);
        return super.onStartCommand(r8, r10, r11);
    }
}
