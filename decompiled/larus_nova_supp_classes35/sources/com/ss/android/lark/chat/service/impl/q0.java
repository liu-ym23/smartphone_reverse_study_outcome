package com.ss.android.lark.chat.service.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.chat.Chat;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class q0 implements Runnable {
    public final /* synthetic */ Map<String, Chat> a;
    public final /* synthetic */ ImSdkChatPushImplV2 b;

    public q0(Map<String, Chat> r1, ImSdkChatPushImplV2 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        Iterator<String> r0 = this.a.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        String r1 = r0.next();
        Iterator r2 = ((CopyOnWriteArrayList) this.b.h).iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        ((y) r2.next()).onPushChat(this.a.get(r1));
        goto L7
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
