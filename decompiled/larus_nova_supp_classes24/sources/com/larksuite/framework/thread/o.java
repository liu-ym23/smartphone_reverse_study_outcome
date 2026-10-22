package com.larksuite.framework.thread;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class o extends r {
    public final /* synthetic */ k a;
    public final /* synthetic */ Runnable b;
    public final /* synthetic */ p c;

    public final void a() {
        this.a.run();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("CoreThreadPool", "task exception, task name: " + this.b.getClass());
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

    public o(p r1, k r2, Runnable r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
