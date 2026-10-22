package com.ss.android.lark.inline.ai.creationai;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l implements Runnable {
    public final /* synthetic */ CreationAIDragView a;

    public l(CreationAIDragView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CreationAIDragView r0 = this.a;     // Catch: Throwable -> L4
        r0.d.b(r0.Z);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
