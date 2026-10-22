package com.bytedance.android.livesdk.feed.openui.view;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i implements Runnable {
    public final /* synthetic */ SimpleLiveView a;

    public i(SimpleLiveView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SimpleLiveView.b(this.a, false, 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
