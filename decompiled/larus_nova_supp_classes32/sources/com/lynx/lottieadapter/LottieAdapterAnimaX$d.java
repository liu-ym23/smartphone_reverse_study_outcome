package com.lynx.lottieadapter;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LottieAdapterAnimaX$d implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ LottieAdapterAnimaX b;

    @Override // java.lang.Runnable
    public final void run() {
        LottieAdapterAnimaX r0 = this.b;     // Catch: Throwable -> L4
        LottieAdapterAnimaX.access$902(r0, LottieAdapterAnimaX.access$1000(r0, this.a));     // Catch: Throwable -> L4
        LottieAdapterAnimaX.access$300(this.b).setStartFrame(LottieAdapterAnimaX.access$900(this.b));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public LottieAdapterAnimaX$d(LottieAdapterAnimaX r1, int r2) {
        this.b = r1;
        this.a = r2;
    }
}
