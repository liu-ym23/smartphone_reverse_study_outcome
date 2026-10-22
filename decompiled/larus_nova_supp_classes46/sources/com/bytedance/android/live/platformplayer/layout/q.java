package com.bytedance.android.live.platformplayer.layout;

import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q implements Runnable {
    public final /* synthetic */ LivePlayerWidget a;
    public final /* synthetic */ ILivePlayerClient b;

    public q(LivePlayerWidget r1, ILivePlayerClient r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LivePlayerWidget r0 = this.a;     // Catch: Throwable -> L4
        int r1 = LivePlayerWidget.V2;     // Catch: Throwable -> L4
        r0.Xr();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
