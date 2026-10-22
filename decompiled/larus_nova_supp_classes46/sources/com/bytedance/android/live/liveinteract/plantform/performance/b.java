package com.bytedance.android.live.liveinteract.plantform.performance;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements Runnable {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Disposable r0 = this.a.b;     // Catch: Throwable -> L7
        if (r0 == null) goto L5;
        r0.dispose();     // Catch: Throwable -> L7
    L5:
        this.a.b = null;     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
