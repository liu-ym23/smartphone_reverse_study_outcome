package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import android.animation.Animator;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements Runnable {
    public final /* synthetic */ GamePlatformGiftCombView a;

    public c(GamePlatformGiftCombView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        GamePlatformGiftCombView r0 = this.a;     // Catch: Throwable -> L9
        r0.c = r0.k.c(r0, r0.p);     // Catch: Throwable -> L9
        Animator r1 = this.a.c;     // Catch: Throwable -> L9
        if (r1 == null) goto L5;
        r1.start();     // Catch: Throwable -> L9
    L5:
        s02.a r2 = this.a.l;     // Catch: Throwable -> L9
        if (r2 == null) goto L12;
        r2.a();     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
