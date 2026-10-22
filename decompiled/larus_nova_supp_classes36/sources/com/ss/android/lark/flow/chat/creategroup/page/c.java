package com.ss.android.lark.flow.chat.creategroup.page;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements Runnable {
    public final /* synthetic */ FlowGroupCreateActivity a;

    public c(FlowGroupCreateActivity r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FlowGroupCreateActivity r0 = this.a;     // Catch: Throwable -> L4
        int r1 = FlowGroupCreateActivity.l;     // Catch: Throwable -> L4
        r0.getClass();     // Catch: Throwable -> L4
        this.a.A1(0.0f, 1.0f, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
