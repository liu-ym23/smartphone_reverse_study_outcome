package com.ss.android.lark.im.sdk.message;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.im.sdk.message.send.k;
import com.ss.android.lark.im.sdk.message.send.l;
import com.ss.android.lark.im.sdk.service.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements Runnable {
    public final /* synthetic */ SendMessagePipelines a;
    public final /* synthetic */ MessageParams<?, ?> b;
    public final /* synthetic */ o c;
    public final /* synthetic */ l d;
    public final /* synthetic */ k e;

    public e(f r1, MessageParams r2, o r3, l r4, k r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void a() {
        int r0 = com.ss.android.lark.im.sdk.a.a;
        com.ss.android.lark.im.sdk.a.b(this.a.c(), "send message runnable start to run, cId is " + this.b.d);
        com.ss.android.lark.biz.im.api.l r1 = this.b;
        if ((r1 instanceof com.ss.android.lark.biz.im.api.l) == true) goto L5;
    L6:
        this.c.i();
    L7:
        this.d.c(this.e);
        return;
    L5:
        if (r1.K == null) goto L7;
        goto L6
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
