package com.lynx.lottieadapter;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Objects;
import x4a.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LottieAdapterAnimaX$j implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ LottieAdapterAnimaX b;

    @Override // java.lang.Runnable
    public final void run() {
        e r0 = LottieAdapterAnimaX.access$300(this.b);     // Catch: Throwable -> L4
        Objects.requireNonNull(r0);     // Catch: Throwable -> L4
        r0.a(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public LottieAdapterAnimaX$j(LottieAdapterAnimaX r1, int r2) {
        this.b = r1;
        this.a = r2;
    }
}
