package com.ss.android.lark.flow.threadwindow;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l implements Runnable {
    public final /* synthetic */ FlowThreadWindowMediaRootStateHandler a;
    public final /* synthetic */ Message b;

    public l(FlowThreadWindowMediaRootStateHandler r1, Message r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FlowThreadWindowMediaRootStateHandler.b(this.a, this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
