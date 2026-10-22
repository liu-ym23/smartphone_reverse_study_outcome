package com.bytedance.android.live.ktv.common.view;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements Runnable {
    public final /* synthetic */ ContinuousSurfaceAdapterView a;

    public c(ContinuousSurfaceAdapterView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ContinuousSurfaceAdapterView r0 = this.a;     // Catch: Throwable -> L6
        if (r0.a == true) goto L9;
        ContinuousSurfaceAdapterView.a(r0);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
