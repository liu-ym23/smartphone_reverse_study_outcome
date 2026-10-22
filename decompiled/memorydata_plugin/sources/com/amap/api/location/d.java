package com.amap.api.location;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.loc.ec;
import com.loc.ev;
import com.loc.o;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class d extends PluginService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ec f495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f496b;
    boolean c;

    public d() {
        this.f496b = 0;
        this.c = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
    L8:
        th = move-exception;
        ev.a(th, "APSService", "onCreate");
    L10:
        super/*android.app.Service*/.onCreate();
        return;
    L4:
        if (this.f495a != null) goto L6;
        this.f495a = new ec(r4);     // Catch: Throwable -> L8
    L6:
        this.f495a.a();     // Catch: Throwable -> L8
        goto L10
    }

    public IBinder onBind(Intent r2) {
        return this.f495a.a(r2);
    L4:
        th = move-exception;
        ev.a(th, "APSService", "onBind");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        this.f495a.c();     // Catch: Throwable -> L6
        if (this.c == false) goto L8;
        stopForeground(true);     // Catch: Throwable -> L6
    L8:
        super/*android.app.Service*/.onDestroy();
        return;
    L6:
        th = move-exception;
        ev.a(th, "APSService", "onDestroy");
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int onStartCommand(Intent r6, int r7, int r8) {
        if (r6 == null) goto L27;
        int r0 = r6.getIntExtra(o.f, 0);     // Catch: Throwable -> L25
        if (r0 != 1) goto L10;
        int r1 = r6.getIntExtra("i", 0);     // Catch: Throwable -> L25
        Notification r2 = (Notification) ZeusTransformUtils.preCheckCast(r6.getParcelableExtra(o.g), Notification.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (r1 == 0) goto L27;
        if (r2 == null) goto L27;
        startForeground(r1, r2);     // Catch: Throwable -> L25
        this.c = true;     // Catch: Throwable -> L25
        this.f496b++;     // Catch: Throwable -> L25
        goto L27
    L10:
        if (r0 != 2) goto L27;
        if (r6.getBooleanExtra(o.j, true) == false) goto L17;
        int r3 = this.f496b;     // Catch: Throwable -> L25
        if (r3 <= 0) goto L17;
        this.f496b = r3 - 1;     // Catch: Throwable -> L25
    L17:
        if (this.f496b > 0) goto L19;
        stopForeground(true);     // Catch: Throwable -> L25
        this.c = false;     // Catch: Throwable -> L25
        goto L27
    L19:
        stopForeground(false);     // Catch: Throwable -> L25
    L27:
        return this.f495a.b();
    L22:
        th = move-exception;
        ev.a(th, "APSService", "onStartCommand");
        return super/*android.app.Service*/.onStartCommand(r6, r7, r8);
    }
}
