package com.ss.android.lark.chat.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.entity.chat.Chat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j0 implements Runnable {
    public final /* synthetic */ IChatService a;
    public final /* synthetic */ Chat b;
    public final /* synthetic */ i7b.b c;

    public j0(IChatService r1, Chat r2, i7b.b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IChatService r0 = this.a;     // Catch: Throwable -> L4
        String r1 = this.b.getId();     // Catch: Throwable -> L4
        i7b.b r2 = this.c;     // Catch: Throwable -> L4
        r0.t8(r1, r2.a, r2.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
