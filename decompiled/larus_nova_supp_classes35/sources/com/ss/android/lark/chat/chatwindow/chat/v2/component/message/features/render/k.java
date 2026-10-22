package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k implements Runnable {
    public final /* synthetic */ MessageListRendererFeature a;

    public k(MessageListRendererFeature r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MessageListRendererFeature.d r0 = this.a.o;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.run();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
