package com.ss.android.lark.chat.api.service.impl;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.chat.Chat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i0 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ IGetDataCallback b;
    public final /* synthetic */ ChatService c;

    @Override // java.lang.Runnable
    public final void run() {
        Chat r0 = this.c.getChatById(this.a);     // Catch: Throwable -> L11
        if (r0 != null) goto L7;
        IGetDataCallback r1 = this.b;     // Catch: Throwable -> L11
        if (r1 == null) goto L16;
        r1.onError(new ErrorResult("chat is null"));     // Catch: Throwable -> L11
    L16:
        return;
    L7:
        IGetDataCallback r2 = this.b;     // Catch: Throwable -> L11
        if (r2 == null) goto L16;
        r2.onSuccess(r0);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }

    public i0(ChatService r1, String r2, IGetDataCallback r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
