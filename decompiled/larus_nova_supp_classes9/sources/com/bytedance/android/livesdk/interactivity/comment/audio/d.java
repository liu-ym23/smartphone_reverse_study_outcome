package com.bytedance.android.livesdk.interactivity.comment.audio;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements Runnable {
    public final /* synthetic */ c.d a;
    public final /* synthetic */ byte[] b;

    public d(c.d r1, byte[] r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.b r0 = this.a.a.o;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.c(this.b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
