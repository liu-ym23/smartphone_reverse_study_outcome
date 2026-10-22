package com.ss.android.lark.chat.service.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c1 implements Runnable {
    public final /* synthetic */ MessagePushV2 a;
    public final /* synthetic */ MessageInfo b;
    public final /* synthetic */ Chat c;
    public final /* synthetic */ ThreadTopic d;
    public final /* synthetic */ List<MessageInfo> e;
    public final /* synthetic */ List<MessageInfo> f;

    /* JADX WARN: Multi-variable type inference failed */
    public c1(MessagePushV2 r1, MessageInfo r2, Chat r3, ThreadTopic r4, List<? extends MessageInfo> r5, List<? extends MessageInfo> r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<com.ss.android.lark.biz.im.api.k0> r0 = this.a.c.iterator();     // Catch: Throwable -> L7
    L4:
        if (r0.hasNext() == false) goto L16;
        r0.next().a(new com.ss.android.lark.biz.im.api.g1(this.b, this.c, this.d, this.e, this.f));     // Catch: Throwable -> L7
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
