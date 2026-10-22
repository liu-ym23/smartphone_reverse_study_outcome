package com.bytedance.android.livesdk.chatroom.view;

import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j implements Runnable {
    public final /* synthetic */ k a;

    public j(k r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k r0 = this.a;     // Catch: Throwable -> L4
        PopupWindowLancet.handleDismissBeforeOrigin(r0);     // Catch: Throwable -> L4
        r0.dismiss();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
