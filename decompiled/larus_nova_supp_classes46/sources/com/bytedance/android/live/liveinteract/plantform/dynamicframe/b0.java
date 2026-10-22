package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b0 implements Runnable {
    public final /* synthetic */ i a;
    public final /* synthetic */ ih0.c b;

    public b0(i r1, ih0.c r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        this.a.c = System.currentTimeMillis();
        ALogger.i("MultiLinkDynamicWidget-Time", ThreadMethodProxy.currentThread().getName() + ":load card start");
        ih0.c r0 = this.b;
        if (r0 == null) goto L5;
        ih0.c.a.a(r0, null, null, 7);
    L5:
        ALogger.i("MultiLinkDynamicWidget-Time", ThreadMethodProxy.currentThread().getName() + ":load card end");
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
