package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements Runnable {
    public final /* synthetic */ PSTopContainer a;

    public c(PSTopContainer r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PSTopContainer.a r0 = (PSTopContainer.a) ((PriorityQueue) this.a.j.getValue()).poll();     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        this.a.w(r0);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
