package com.lynx.tasm.core;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m implements Runnable {
    public final /* synthetic */ FutureTask a;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.run();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public m(FutureTask r1) {
        this.a = r1;
    }
}
