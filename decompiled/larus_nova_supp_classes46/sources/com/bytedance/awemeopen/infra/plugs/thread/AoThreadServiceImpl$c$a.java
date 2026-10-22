package com.bytedance.awemeopen.infra.plugs.thread;

import android.os.Process;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class AoThreadServiceImpl$c$a extends PthreadThreadV2 {
    public final /* synthetic */ AoThreadServiceImpl.c v;

    public final void run() {
        Process.setThreadPriority(this.v.d);     // Catch: Throwable -> L4
        super.run();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public AoThreadServiceImpl$c$a(AoThreadServiceImpl.c r7, ThreadGroup r8, Runnable r9, String r10) {
        this.v = r7;
        super(r8, r9, r10, 0);
    }
}
