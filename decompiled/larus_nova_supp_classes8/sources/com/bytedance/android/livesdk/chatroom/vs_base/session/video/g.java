package com.bytedance.android.livesdk.chatroom.vs_base.session.video;

import com.larus.apm.impl.protector.RunnableProtector;
import fq1.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements Runnable {
    public final /* synthetic */ ReplayVideoMetrics a;
    public final /* synthetic */ long b;

    public g(ReplayVideoMetrics r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b.c(j.a().J(), "watcher kit out", this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
