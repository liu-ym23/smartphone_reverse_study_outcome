package com.lynx.lottieadapter;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LottieAdapterAnimaX$p implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ LottieAdapterAnimaX b;

    @Override // java.lang.Runnable
    public final void run() {
        LottieAdapterAnimaX.access$200(this.b, this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public LottieAdapterAnimaX$p(LottieAdapterAnimaX r1, String r2) {
        this.b = r1;
        this.a = r2;
    }
}
