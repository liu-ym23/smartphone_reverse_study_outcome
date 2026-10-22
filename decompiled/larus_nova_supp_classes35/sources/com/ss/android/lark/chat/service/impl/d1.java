package com.ss.android.lark.chat.service.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.message.MessageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d1 implements Runnable {
    public final /* synthetic */ g0 a;
    public final /* synthetic */ MessageInfo b;

    public d1(g0 r1, MessageInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.c(this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
