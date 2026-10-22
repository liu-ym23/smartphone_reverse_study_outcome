package com.bytedance.android.livesdk.interactivity.like;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i0 implements Runnable {
    public final /* synthetic */ DiggWidget a;

    public i0(DiggWidget r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r0 = this.a.c;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.performHapticFeedback(1, 2);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
