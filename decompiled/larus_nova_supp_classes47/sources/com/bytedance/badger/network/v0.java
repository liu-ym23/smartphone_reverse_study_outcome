package com.bytedance.badger.network;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v0 implements ThreadFactory {
    public final String a;

    public v0(String r1) {
        this.a = r1;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r4) {
        PthreadThreadV2 r0 = new PthreadThreadV2(r4, "badger-delay-" + this.a + '-' + z0.g.getAndIncrement());
        if (r0.isDaemon() == false) goto L6;
        r0.setDaemon(false);
    L6:
        if (r0.getPriority() == 5) goto L8;
        ThreadMethodProxy.setPriority(r0, 5);
    L8:
        return r0;
    }
}
