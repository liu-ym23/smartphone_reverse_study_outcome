package com.lynx.lottieadapter;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LottieAdapterAnimaX$k implements Runnable {
    public final /* synthetic */ LottieAdapterAnimaX a;

    @Override // java.lang.Runnable
    public final void run() {
        LottieAdapterAnimaX.access$000(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public LottieAdapterAnimaX$k(LottieAdapterAnimaX r1) {
        this.a = r1;
    }
}
