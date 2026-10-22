package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ UgcGiftPoolDialog b;

    public e(View r1, UgcGiftPoolDialog r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r0 = this.b.k;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.setVisibility(0);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
