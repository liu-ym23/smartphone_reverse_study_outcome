package com.bytedance.android.live.core.tetris.widgets;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o implements Runnable {
    public final /* synthetic */ LiveRecyclableWidget a;
    public final /* synthetic */ RecyclableWidgetManager b;

    @Override // java.lang.Runnable
    public final void run() {
        this.b.continueLoad(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public o(RecyclableWidgetManager r1, LiveRecyclableWidget r2) {
        this.b = r1;
        this.a = r2;
    }
}
