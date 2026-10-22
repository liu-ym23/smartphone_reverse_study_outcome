package com.ss.ugc.effectplatform.task.pipline;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements Runnable {
    public final /* synthetic */ b a;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.getClass();     // Catch: Throwable -> L4
        throw null;     // Catch: Throwable -> L4
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(b r1, int r2, long r3) {
        this.a = r1;
    }
}
