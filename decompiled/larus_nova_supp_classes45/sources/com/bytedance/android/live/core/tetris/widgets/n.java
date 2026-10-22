package com.bytedance.android.live.core.tetris.widgets;

import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.perf.WidgetPerfManager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n implements Runnable {
    public final /* synthetic */ LiveRecyclableWidget a;
    public final /* synthetic */ RecyclableWidgetManager b;

    @Override // java.lang.Runnable
    public final void run() {
        WidgetPerfManager.getInstance().onPerfEnd(this.a, "inflate");     // Catch: Throwable -> L6
        this.b.onLoadSuccessByAsync(this.a);     // Catch: Throwable -> L6
        Widget r0 = this.a;     // Catch: Throwable -> L6
        if (r0.dataCenter == null) goto L9;
        this.b.continueLoad(r0);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public n(RecyclableWidgetManager r1, LiveRecyclableWidget r2) {
        this.b = r1;
        this.a = r2;
    }
}
