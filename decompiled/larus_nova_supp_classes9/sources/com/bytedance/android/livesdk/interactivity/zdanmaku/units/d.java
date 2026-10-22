package com.bytedance.android.livesdk.interactivity.zdanmaku.units;

import com.airbnb.lottie.LottieDrawable;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements Runnable {
    public final /* synthetic */ f a;

    public d(f r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.n.d();     // Catch: Throwable -> L7
        LottieDrawable r0 = this.a.n;     // Catch: Throwable -> L7
        u0.c r1 = r0.c;     // Catch: Throwable -> L7
        if (r1.k == false) goto L5;
        r1.cancel();     // Catch: Throwable -> L7
    L5:
        r0.b = null;     // Catch: Throwable -> L7
        r0.o = null;     // Catch: Throwable -> L7
        r0.i = null;     // Catch: Throwable -> L7
        u0.c r2 = r0.c;     // Catch: Throwable -> L7
        r2.j = null;     // Catch: Throwable -> L7
        r2.h = -2.1474836E9f;     // Catch: Throwable -> L7
        r2.i = 2.1474836E9f;     // Catch: Throwable -> L7
        r0.invalidateSelf();     // Catch: Throwable -> L7
        this.a.n.setCallback(null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
