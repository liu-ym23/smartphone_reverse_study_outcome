package com.bytedance.android.livesdk.chatroom.vs_base.base.util;

import com.bytedance.android.livesdk.vs.LiveBlurAnimView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k implements Runnable {
    public final /* synthetic */ g a;

    public k(g r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        wr1.b r0 = this.a.c;     // Catch: Throwable -> L8
        if (r0 == null) goto L11;
        LiveBlurAnimView r1 = r0.getView();     // Catch: Throwable -> L8
        if (r1 == null) goto L15;
        r1.setVisibility(8);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
