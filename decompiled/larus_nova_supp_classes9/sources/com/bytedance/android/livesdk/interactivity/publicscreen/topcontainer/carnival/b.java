package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival;

import com.bytedance.android.livesdk.interactivity.api.monitor.DanmakuMonitor;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements Runnable {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DanmakuMonitor.a("failure");     // Catch: Throwable -> L4
        this.a.a.a.getClass();     // Catch: Throwable -> L4
        DanmakuCarnivalTrayManager.m("Download Model Failed");     // Catch: Throwable -> L4
        n22.a.d = false;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
