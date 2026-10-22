package com.bytedance.android.live.effect.beauty.makeups;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements Runnable {
    public final /* synthetic */ List a;
    public final /* synthetic */ a.c b;

    public g(List r1, a.c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.c r0 = this.b;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.onSuccess(this.a);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
