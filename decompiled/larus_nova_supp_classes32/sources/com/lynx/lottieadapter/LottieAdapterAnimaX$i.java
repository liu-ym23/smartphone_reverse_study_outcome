package com.lynx.lottieadapter;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LottieAdapterAnimaX$i implements Runnable {
    public final /* synthetic */ float a;
    public final /* synthetic */ float b;
    public final /* synthetic */ LottieAdapterAnimaX c;

    public final void a() {
        int r0 = (int) LottieAdapterAnimaX.access$1300(this.c, this.a);
        int r1 = (int) LottieAdapterAnimaX.access$1300(this.c, this.b);
        if (r0 != r1) goto L5;
        r0 = r0 - 1;
    L5:
        LottieAdapterAnimaX.access$300(this.c).setStartFrame(LottieAdapterAnimaX.access$1000(this.c, r0));
        LottieAdapterAnimaX.access$300(this.c).setEndFrame(LottieAdapterAnimaX.access$1200(this.c, r1));
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

    public LottieAdapterAnimaX$i(LottieAdapterAnimaX r1, float r2, float r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
