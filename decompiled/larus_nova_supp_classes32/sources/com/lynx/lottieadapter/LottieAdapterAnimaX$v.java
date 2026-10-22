package com.lynx.lottieadapter;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LottieAdapterAnimaX$v implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ LottieAdapterAnimaX b;

    @Override // java.lang.Runnable
    public final void run() {
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    L17:
        return;
    L3:
        if (LottieAdapterAnimaX.access$400(this.b) <= LottieAdapterAnimaX.access$500(this.b)) goto L12;
        int r0 = (int) LottieAdapterAnimaX.access$500(this.b);     // Catch: Throwable -> L9
        int r1 = (((int) LottieAdapterAnimaX.access$400(this.b)) - r0) + 1;     // Catch: Throwable -> L9
        int[] r2 = new int[r1];     // Catch: Throwable -> L9
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L7;
        r2[r3] = r0;     // Catch: Throwable -> L9
        r3 = r3 + 1;     // Catch: Throwable -> L9
        goto L5
    L7:
        LottieAdapterAnimaX.access$300(this.b).b(r2, this.a);     // Catch: Throwable -> L9
        return;
    }

    public LottieAdapterAnimaX$v(LottieAdapterAnimaX r1, boolean r2) {
        this.b = r1;
        this.a = r2;
    }
}
