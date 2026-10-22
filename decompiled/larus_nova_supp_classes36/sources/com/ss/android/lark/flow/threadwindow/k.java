package com.ss.android.lark.flow.threadwindow;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k implements Runnable {
    public final /* synthetic */ FlowThreadWindowMediaRootStateHandler a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ErrorResult c;

    public k(FlowThreadWindowMediaRootStateHandler r1, String r2, ErrorResult r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FlowThreadWindowMediaRootStateHandler.a(this.a, this.b, this.c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
