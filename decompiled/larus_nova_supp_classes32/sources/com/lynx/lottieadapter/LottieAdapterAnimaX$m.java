package com.lynx.lottieadapter;

import android.graphics.drawable.Drawable;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LottieAdapterAnimaX$m implements Runnable {
    public final /* synthetic */ Drawable a;
    public final /* synthetic */ LottieAdapterAnimaX b;

    @Override // java.lang.Runnable
    public final void run() {
        LottieAdapterAnimaX.access$1500(this.b, this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public LottieAdapterAnimaX$m(LottieAdapterAnimaX r1, Drawable r2) {
        this.b = r1;
        this.a = r2;
    }
}
