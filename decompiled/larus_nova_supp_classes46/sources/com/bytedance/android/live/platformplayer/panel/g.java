package com.bytedance.android.live.platformplayer.panel;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements Runnable {
    public final /* synthetic */ o a;
    public final /* synthetic */ ds0.b b;
    public final /* synthetic */ View c;

    public g(o r1, ds0.b r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ds0.b r0 = this.b;     // Catch: Throwable -> L4
        r0.c = this.c.getHeight();     // Catch: Throwable -> L4
        o r1 = this.a;     // Catch: Throwable -> L4
        ds0.b r2 = this.b;     // Catch: Throwable -> L4
        r1.d.c(r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
