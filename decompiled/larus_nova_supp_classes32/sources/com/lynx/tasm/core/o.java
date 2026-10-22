package com.lynx.tasm.core;

import android.view.Choreographer;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.utils.CallStackUtil;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o implements Runnable {
    public o() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        VSyncMonitor.c = Choreographer.getInstance();     // Catch: Throwable -> L4 RuntimeException -> L6
    L13:
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    L17:
        return;
    L6:
        e = move-exception;
        LLog.e("VSyncMonitor", "initUIThreadChoreographer failed: " + CallStackUtil.a(e));     // Catch: Throwable -> L4
        goto L13
    }
}
