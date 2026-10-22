package com.ss.android.lark.chat.service.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.chat.Chat;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i0 implements Runnable {
    public final /* synthetic */ ImSdkChatPushImplV2 a;
    public final /* synthetic */ Chat b;

    public i0(ImSdkChatPushImplV2 r1, Chat r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r0 = ((CopyOnWriteArrayList) this.a.m).iterator();     // Catch: Throwable -> L7
    L4:
        if (r0.hasNext() == false) goto L16;
        ((z) r0.next()).onPushChatRemoveMe(this.b);     // Catch: Throwable -> L7
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
