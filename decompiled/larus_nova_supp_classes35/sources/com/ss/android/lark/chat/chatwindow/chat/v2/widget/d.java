package com.ss.android.lark.chat.chatwindow.chat.v2.widget;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements Runnable {
    public final /* synthetic */ c<Object> a;

    public d(c<Object> r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.a(this.a, false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
