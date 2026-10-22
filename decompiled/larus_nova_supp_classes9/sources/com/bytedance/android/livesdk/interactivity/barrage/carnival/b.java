package com.bytedance.android.livesdk.interactivity.barrage.carnival;

import com.bytedance.android.livesdk.interactivity.api.barrage.data.j;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements Runnable {
    public final /* synthetic */ DanmakuCarnivalManager a;
    public final /* synthetic */ j b;

    public b(DanmakuCarnivalManager r1, j r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.p(this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
