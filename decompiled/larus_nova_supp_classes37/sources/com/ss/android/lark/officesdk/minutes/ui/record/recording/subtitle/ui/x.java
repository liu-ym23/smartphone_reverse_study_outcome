package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class x implements Runnable {
    public final /* synthetic */ w a;

    public x(w r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        w r0 = this.a;     // Catch: Throwable -> L13
        boolean r2 = true;
        if (r0.a.canScrollVertically(1) == false) goto L5;
    L8:
        boolean r1 = r0.d;     // Catch: Throwable -> L13
        if (r1 == false) goto L16;
        if (r1 == r2) goto L20;
        r0.f(r2, "onRVHeightChanged");     // Catch: Throwable -> L13
        return;
    L20:
        return;
    L16:
        return;
    L5:
        if (r0.a.canScrollVertically(-1) == true) goto L8;
        r2 = false;
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L21;
        throw th;
    }
}
