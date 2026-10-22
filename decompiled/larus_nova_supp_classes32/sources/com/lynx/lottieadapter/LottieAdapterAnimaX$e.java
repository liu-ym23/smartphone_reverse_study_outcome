package com.lynx.lottieadapter;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LottieAdapterAnimaX$e implements Runnable {
    public final /* synthetic */ LottieAdapterAnimaX a;

    @Override // java.lang.Runnable
    public final void run() {
        LottieAdapterAnimaX r0 = this.a;     // Catch: Throwable -> L4
        LottieAdapterAnimaX.access$1102(r0, LottieAdapterAnimaX.access$1200(r0, LottieAdapterAnimaX.access$1100(r0)));     // Catch: Throwable -> L4
        LottieAdapterAnimaX.access$300(this.a).setEndFrame(LottieAdapterAnimaX.access$1100(this.a));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public LottieAdapterAnimaX$e(LottieAdapterAnimaX r1) {
        this.a = r1;
    }
}
