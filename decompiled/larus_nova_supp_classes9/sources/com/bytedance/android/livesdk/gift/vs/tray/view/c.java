package com.bytedance.android.livesdk.gift.vs.tray.view;

import android.animation.Animator;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements Runnable {
    public final /* synthetic */ VSGiftTrayAnimationView.d a;

    public c(VSGiftTrayAnimationView.d r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VSGiftTrayAnimationView.d r0 = this.a;     // Catch: Throwable -> L9
        VSGiftTrayAnimationView r1 = r0.a;     // Catch: Throwable -> L9
        r1.b = r1.h.c(r1, r0);     // Catch: Throwable -> L9
        Animator r2 = this.a.a.b;     // Catch: Throwable -> L9
        if (r2 == null) goto L5;
        r2.start();     // Catch: Throwable -> L9
    L5:
        s02.a r3 = this.a.a.i;     // Catch: Throwable -> L9
        if (r3 == null) goto L12;
        r3.a();     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
