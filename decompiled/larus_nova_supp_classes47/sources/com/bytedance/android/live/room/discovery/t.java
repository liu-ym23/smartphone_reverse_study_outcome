package com.bytedance.android.live.room.discovery;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t implements Runnable {
    public final /* synthetic */ AnchorPerfMonitorWidget.i a;

    public t(AnchorPerfMonitorWidget.i r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AnchorPerfMonitorWidget.zq(this.a.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
