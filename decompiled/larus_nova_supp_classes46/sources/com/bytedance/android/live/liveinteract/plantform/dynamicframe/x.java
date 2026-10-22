package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x implements Runnable {
    public final /* synthetic */ MultiLinkFeedHybridCardManager a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ Map c;

    public x(MultiLinkFeedHybridCardManager r1, Map r2, Map r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        ALogger.i("MultiLinkDynamicWidget-Time", ThreadMethodProxy.currentThread().getName() + ":load micseat card start");
        ih0.c r0 = this.a.b;
        if (r0 == null) goto L5;
        r0.h(this.b, this.c);
    L5:
        ALogger.i("MultiLinkDynamicWidget-Time", ThreadMethodProxy.currentThread().getName() + ":load micseat card end");
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
