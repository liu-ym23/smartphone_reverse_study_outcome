package com.larus.dora.obric.device_management.device_home;

import android.os.SystemClock;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h1 implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ DoraObricDeviceHomeFragment b;
    public final /* synthetic */ long c;

    public h1(View r1, DoraObricDeviceHomeFragment r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    L14:
        return;
    L3:
        if (this.b.H != this.c) goto L10;
        g49.d.a("DoraObricDeviceHomeFragment", "reconnect connected UI rendered durationMs=" + (SystemClock.elapsedRealtime() - this.c));     // Catch: Throwable -> L7
        this.b.H = 0;     // Catch: Throwable -> L7
        return;
    }
}
