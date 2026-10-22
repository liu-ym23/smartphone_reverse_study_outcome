package com.bytedance.android.live.effect.avadjust;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n implements Runnable {
    public final /* synthetic */ List a;
    public final /* synthetic */ l.c b;

    public n(List r1, l.c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List r0 = this.a;     // Catch: Throwable -> L13
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        this.b.onError();     // Catch: Throwable -> L13
        return;
    L11:
        this.b.onSuccess(this.a);     // Catch: Throwable -> L13
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
