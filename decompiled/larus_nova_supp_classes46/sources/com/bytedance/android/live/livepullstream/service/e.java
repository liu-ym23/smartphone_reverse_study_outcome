package com.bytedance.android.live.livepullstream.service;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.videoarch.strategy.LiveStrategyManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements Runnable {
    public final /* synthetic */ JSONObject a;

    public e(JSONObject r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LiveStrategyManager.inst().executeCommand(4, 406, 0, this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
