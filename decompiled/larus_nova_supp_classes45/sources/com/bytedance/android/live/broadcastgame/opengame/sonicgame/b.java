package com.bytedance.android.live.broadcastgame.opengame.sonicgame;

import com.bytedance.android.live.broadcastgame.opengame.service.OpenPlatformMonitorService;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements Runnable {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a r0 = this.a;     // Catch: Throwable -> L7
        r0.getClass();     // Catch: Throwable -> L7
        double r1 = jc1.k.n(IPerformanceManager.class).getStreamRealFps();     // Catch: Throwable -> L7
        if (r1 <= 0) goto L5;
        ((OpenPlatformMonitorService) r0.c.o(OpenPlatformMonitorService.class)).f(r1);     // Catch: Throwable -> L7
    L5:
        r0.a.postDelayed(r0.b, 6000);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
