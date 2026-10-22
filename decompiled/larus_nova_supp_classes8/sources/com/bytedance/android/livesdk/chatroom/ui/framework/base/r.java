package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r implements Runnable {
    public final /* synthetic */ InteractionWidgetsPosContext a;

    public r(InteractionWidgetsPosContext r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.share();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
