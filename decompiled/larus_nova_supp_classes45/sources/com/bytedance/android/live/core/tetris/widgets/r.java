package com.bytedance.android.live.core.tetris.widgets;

import android.view.ViewGroup;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r implements Runnable {
    public final /* synthetic */ LiveRecyclableWidget a;
    public final /* synthetic */ ViewGroup b;
    public final /* synthetic */ RecyclableWidgetManager c;

    @Override // java.lang.Runnable
    public final void run() {
        RecyclableWidgetManager r0 = this.c;     // Catch: Throwable -> L4
        LiveRecyclableWidget r1 = this.a;     // Catch: Throwable -> L4
        r0.continueLoad(r1, this.b, ((Widget) r1).contentView);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public r(RecyclableWidgetManager r1, LiveRecyclableWidget r2, ViewGroup r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
