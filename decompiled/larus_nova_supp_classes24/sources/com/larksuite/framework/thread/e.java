package com.larksuite.framework.thread;

import com.ss.android.lark.log.Log;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e extends q<Object> {
    public final /* synthetic */ Callable a;
    public final /* synthetic */ Callable b;

    @Override // com.larksuite.framework.thread.q, java.util.concurrent.Callable
    public Object call() throws Exception {
        return this.a.call();
    L4:
        e = move-exception;
        Log.e("CoreScheduledThreadPoolExecutor", "schedule task exception, task name: " + this.b.getClass());
        a.c().a(e);
        a.c().getClass();
        System.currentTimeMillis();
        throw e;
    }

    public e(c r1, Callable r2) {
        this.a = r1;
        this.b = r2;
    }
}
