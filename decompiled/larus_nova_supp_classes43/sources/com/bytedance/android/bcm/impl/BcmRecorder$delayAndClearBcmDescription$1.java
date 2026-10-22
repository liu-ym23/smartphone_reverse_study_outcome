package com.bytedance.android.bcm.impl;

import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class BcmRecorder$delayAndClearBcmDescription$1 implements Runnable {
    public final /* synthetic */ PageInfo a;

    public BcmRecorder$delayAndClearBcmDescription$1(PageInfo r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.btm.impl.thread.b.e.a(new AnonymousClass1(this), false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
