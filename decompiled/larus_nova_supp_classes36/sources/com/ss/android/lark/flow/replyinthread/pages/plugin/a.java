package com.ss.android.lark.flow.replyinthread.pages.plugin;

import android.widget.EditText;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements Runnable {
    public final /* synthetic */ ReplyInThreadKeyboardPlugin a;

    public a(ReplyInThreadKeyboardPlugin r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IKeyboardComponent r0 = this.a.i;     // Catch: Throwable -> L18
        if (r0 == null) goto L7;
        com.ss.android.lark.keyboard.b r1 = r0.n();     // Catch: Throwable -> L18
        if (r1 == null) goto L7;
        com.ss.android.lark.keyboard.keyboard2.b r2 = r1.L();     // Catch: Throwable -> L18
    L8:
        if (r2 == null) goto L12;
        EditText r3 = r2.c();     // Catch: Throwable -> L18
        if (r3 == null) goto L12;
        r3.requestFocus();     // Catch: Throwable -> L18
    L12:
        IKeyboardComponent r4 = this.a.i;     // Catch: Throwable -> L18
        if (r4 == null) goto L21;
        com.ss.android.lark.keyboard.b r5 = r4.n();     // Catch: Throwable -> L18
        if (r5 == null) goto L25;
        com.ss.android.lark.c.f(r5);     // Catch: Throwable -> L18
        return;
    L25:
        return;
    L21:
        return;
    L7:
        r2 = null;
    L18:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L26;
        throw th;
    }
}
