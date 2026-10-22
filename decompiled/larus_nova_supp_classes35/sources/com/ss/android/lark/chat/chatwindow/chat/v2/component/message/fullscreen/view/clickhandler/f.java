package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements Runnable {
    public final /* synthetic */ com.ss.android.lark.widget.select.m a;
    public final /* synthetic */ ContentLongClickListener b;

    public f(com.ss.android.lark.widget.select.m r1, ContentLongClickListener r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a();     // Catch: Throwable -> L6
        if (this.a.i == true) goto L9;
        this.b.d = null;     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
