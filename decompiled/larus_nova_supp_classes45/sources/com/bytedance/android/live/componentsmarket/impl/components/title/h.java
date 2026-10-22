package com.bytedance.android.live.componentsmarket.impl.components.title;

import android.graphics.Paint;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements Runnable {
    public final /* synthetic */ TitleTetris a;

    public h(TitleTetris r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.livesdk.common.j r0 = this.a.A;     // Catch: Throwable -> L10
        if (r0 == null) goto L13;
        Paint r1 = r0.getPaint();     // Catch: Throwable -> L10
        if (r1 == null) goto L17;
        float r2 = r1.measureText("正正正正正正正正正正正正正正正...");     // Catch: Throwable -> L10
        com.bytedance.android.livesdk.common.j r3 = this.a.A;     // Catch: Throwable -> L10
        if (r3 == null) goto L18;
        r3.setMaxWidth((int) r2);     // Catch: Throwable -> L10
        return;
    L18:
        return;
    L17:
        return;
    L13:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
