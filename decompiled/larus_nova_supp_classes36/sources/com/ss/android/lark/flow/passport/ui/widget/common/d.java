package com.ss.android.lark.flow.passport.ui.widget.common;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements Runnable {
    public final /* synthetic */ FlowBaseActivity a;

    public d(FlowBaseActivity r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FlowBaseActivity r0 = this.a;     // Catch: Throwable -> L4
        int r1 = FlowBaseActivity.c;     // Catch: Throwable -> L4
        r0.showLoading();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
