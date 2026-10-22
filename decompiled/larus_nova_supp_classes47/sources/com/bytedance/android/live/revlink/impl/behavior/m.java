package com.bytedance.android.live.revlink.impl.behavior;

import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m implements Runnable {
    public final /* synthetic */ n a;
    public final /* synthetic */ AnimatedDrawable2 b;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a.c();     // Catch: Throwable -> L6
        AnimatedDrawable2 r0 = this.b;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.start();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public m(n r1, AnimatedDrawable2 r2) {
        this.a = r1;
        this.b = r2;
    }
}
