package com.bytedance.android.live.componentsmarket.impl.components.title;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements Runnable {
    public final /* synthetic */ TitleTetris a;

    public i(TitleTetris r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TitleTetris r0 = this.a;     // Catch: Throwable -> L6
        com.bytedance.android.livesdk.common.j r1 = r0.A;     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        r1.setTextWithEllipsis(r0.j0());     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
