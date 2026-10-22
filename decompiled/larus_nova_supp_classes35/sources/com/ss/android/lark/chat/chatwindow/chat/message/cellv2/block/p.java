package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class p implements Runnable {
    public final /* synthetic */ com.larksuite.component.universe_design.toast.c a;

    public p(com.ss.android.lark.compose.foundation.toast.g r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.cancel();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
