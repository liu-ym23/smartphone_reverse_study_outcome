package com.ss.android.lark.flow.chat.page.flow.plugin.select;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements Runnable {
    public final /* synthetic */ FlowMessageSelectPlugin a;

    public b(FlowMessageSelectPlugin r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FlowMessageSelectPlugin.I(this.a);     // Catch: Throwable -> L4
        this.a.K();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
