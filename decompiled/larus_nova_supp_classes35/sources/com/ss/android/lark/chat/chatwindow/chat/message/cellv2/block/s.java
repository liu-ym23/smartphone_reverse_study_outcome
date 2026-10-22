package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class s implements Runnable {
    public final /* synthetic */ MediaContentBlock a;
    public final /* synthetic */ com.larksuite.component.universe_design.toast.c b;

    public s(MediaContentBlock r1, com.ss.android.lark.compose.foundation.toast.g r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.a.k == false) goto L9;
        this.b.show();     // Catch: Throwable -> L6
        return;
    }
}
