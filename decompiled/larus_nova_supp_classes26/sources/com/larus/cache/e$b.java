package com.larus.cache;

import android.os.Process;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e$b implements Runnable {
    public final Runnable a;
    public final int b;

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.b);     // Catch: Throwable -> L4
        this.a.run();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public e$b(Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "r");
        this.a = r2;
        this.b = 10;
    }
}
