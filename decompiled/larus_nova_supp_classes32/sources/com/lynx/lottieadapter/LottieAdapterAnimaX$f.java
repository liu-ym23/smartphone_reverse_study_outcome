package com.lynx.lottieadapter;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LottieAdapterAnimaX$f implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ LottieAdapterAnimaX c;

    public final void a() {
        LottieAdapterAnimaX r0 = this.c;
        LottieAdapterAnimaX.access$902(r0, LottieAdapterAnimaX.access$1000(r0, this.a));
        LottieAdapterAnimaX.access$300(this.c).setStartFrame(LottieAdapterAnimaX.access$900(this.c));
        LottieAdapterAnimaX r1 = this.c;
        LottieAdapterAnimaX.access$1102(r1, LottieAdapterAnimaX.access$1200(r1, this.b));
        LottieAdapterAnimaX.access$300(this.c).setEndFrame(LottieAdapterAnimaX.access$1100(this.c));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public LottieAdapterAnimaX$f(LottieAdapterAnimaX r1, int r2, int r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
