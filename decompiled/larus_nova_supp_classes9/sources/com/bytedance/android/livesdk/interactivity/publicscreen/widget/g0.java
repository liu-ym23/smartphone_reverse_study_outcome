package com.bytedance.android.livesdk.interactivity.publicscreen.widget;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g0 implements Runnable {
    public final /* synthetic */ TextMessageWidget a;

    @Override // java.lang.Runnable
    public final void run() {
        TextMessageWidget r0 = this.a;     // Catch: Throwable -> L7
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.n r1 = r0.Z;     // Catch: Throwable -> L7
        if (r1 == null) goto L5;
        r1.a(r0.p);     // Catch: Throwable -> L7
    L5:
        TextMessageWidget r2 = this.a;     // Catch: Throwable -> L7
        r2.o.scrollToPosition(r2.p.getItemCount() - 1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public g0(TextMessageWidget r1) {
        this.a = r1;
    }
}
