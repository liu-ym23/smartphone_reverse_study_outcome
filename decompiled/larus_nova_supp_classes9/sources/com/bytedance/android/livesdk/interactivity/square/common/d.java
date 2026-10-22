package com.bytedance.android.livesdk.interactivity.square.common;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements Runnable {
    public final /* synthetic */ BaseModelListScrollManager a;

    public d(BaseModelListScrollManager r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseModelListScrollManager r0 = this.a;     // Catch: Throwable -> L4
        r0.d(r0.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
