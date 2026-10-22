package com.bytedance.lego.init.monitor;

import com.bytedance.lego.init.InitScheduler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class InitMonitor$a implements Runnable {
    public static final InitMonitor$a a = null;

    static {
        a = new InitMonitor$a();
    }

    public InitMonitor$a() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable r0 = a.a;     // Catch: Throwable -> L9
        ThreadPoolExecutor r1 = InitScheduler.INSTANCE.getExecutorServiceOrNull$initscheduler_release();     // Catch: Throwable -> L9
        if (r1 != null) goto L5;
    L7:
        String r2 = InitMonitor.TASKDISPATCHER_INIT;     // Catch: Throwable -> L9
        ThreadMethodProxy.start(new PthreadThreadV2(r0, "InitMonitor$sendStartUpTimeAsync$1"));     // Catch: Throwable -> L9
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L9
        return;
    L5:
        if (r1.submit(r0) == null) goto L7;
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
