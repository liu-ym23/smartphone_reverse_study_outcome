package com.bytedance.android.ec.core.anchorv3;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class PdpTaskManager$tryExecuteEndTask$1 implements Runnable {
    public final /* synthetic */ PdpTaskManager a;

    public PdpTaskManager$tryExecuteEndTask$1(PdpTaskManager r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PdpTaskManager.d(this.a, 4, new AnonymousClass1(this), 2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
