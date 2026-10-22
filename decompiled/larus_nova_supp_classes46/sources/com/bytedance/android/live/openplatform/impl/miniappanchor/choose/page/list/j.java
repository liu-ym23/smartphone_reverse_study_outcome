package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements Runnable {
    public final /* synthetic */ k a;

    public j(k r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        mp0.a r0 = lp0.b.a(this.a.a.g);     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.f(true);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
