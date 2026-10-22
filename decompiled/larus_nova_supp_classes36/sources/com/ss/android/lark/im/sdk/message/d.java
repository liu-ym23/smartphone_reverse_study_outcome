package com.ss.android.lark.im.sdk.message;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.p0;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.im.sdk.message.send.k;
import com.ss.android.lark.im.sdk.message.send.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements Runnable {
    public final /* synthetic */ SendMessagePipelines a;
    public final /* synthetic */ MessageParams<?, ?> b;
    public final /* synthetic */ k c;

    public d(f r1, p0 r2, k r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        int r0 = com.ss.android.lark.im.sdk.a.a;
        com.ss.android.lark.im.sdk.a.b(this.a.c(), "send local pre-message runnable start to run, cId is " + this.b.d);
        ((l) this.a.m.getValue()).c(this.c);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
