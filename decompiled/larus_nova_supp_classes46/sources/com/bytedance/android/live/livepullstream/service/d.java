package com.bytedance.android.live.livepullstream.service;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.videoarch.strategy.LiveStrategyManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements Runnable {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        LiveStrategyManager.inst().executeCommand(4, 401, 0, h.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
