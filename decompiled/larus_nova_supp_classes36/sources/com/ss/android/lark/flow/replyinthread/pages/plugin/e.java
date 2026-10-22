package com.ss.android.lark.flow.replyinthread.pages.plugin;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements Runnable {
    public final /* synthetic */ ReplyInThreadMsgTipsPlugin a;

    public e(ReplyInThreadMsgTipsPlugin r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        wgb.b<y6b.c<?>> r0 = this.a.j;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.f(true);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
