package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import android.view.View;
import com.bytedance.android.live.core.utils.a1;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l implements Runnable {
    public final /* synthetic */ AudienceShareIMElement a;
    public final /* synthetic */ int b;

    public l(AudienceShareIMElement r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r0 = this.a.i;     // Catch: Throwable -> L9
        if (r0 == null) goto L5;
        r0.setTranslationY(0.0f);     // Catch: Throwable -> L9
    L5:
        View r1 = this.a.i;     // Catch: Throwable -> L9
        if (r1 == null) goto L12;
        a1.k(r1, r1.getHeight() - this.b);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
