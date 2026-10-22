package com.larksuite.framework.thread;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f extends r {
    public final /* synthetic */ k a;
    public final /* synthetic */ Runnable b;

    public final void a() {
        this.a.run();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("CoreScheduledThreadPoolExecutor", "schedule task exception, task name: " + this.b.getClass());
        a.c().a(e);
        a.c().getClass();
        System.currentTimeMillis();
        throw e;
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

    public f(k r1, Runnable r2) {
        this.a = r1;
        this.b = r2;
    }
}
