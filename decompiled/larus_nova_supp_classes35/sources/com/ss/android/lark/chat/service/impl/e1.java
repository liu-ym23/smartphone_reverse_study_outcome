package com.ss.android.lark.chat.service.impl;

import com.bytedance.lark.pb.im.v1.PushMessageReactions;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e1 implements Runnable {
    public final /* synthetic */ MessagePushV2 a;
    public final /* synthetic */ PushMessageReactions b;

    public e1(MessagePushV2 r1, PushMessageReactions r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<com.ss.android.lark.biz.im.api.k0> r0 = this.a.c.iterator();     // Catch: Throwable -> L7
    L4:
        if (r0.hasNext() == false) goto L16;
        r0.next().f(this.b);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
