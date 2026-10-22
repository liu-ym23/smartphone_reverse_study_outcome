package com.ss.android.lark.flow.chat.page.flow.plugin;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollScene;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements Runnable {
    public final /* synthetic */ FlowChatReadablePlugin a;

    public f(FlowChatReadablePlugin r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r0 = this.a.g;     // Catch: Throwable -> L8
        if (r0 == null) goto L11;
        IMessageListComponent r1 = r0.a(IMessageListComponent.class);     // Catch: Throwable -> L8
        if (r1 == null) goto L15;
        r1.sf(ScrollScene.AUTO_BOTTOM);     // Catch: Throwable -> L8
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
