package com.ss.android.lark.chat.service.impl;

import com.bytedance.lark.pb.im.v1.PushChatChatterListDepartmentName;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n0 implements Runnable {
    public final /* synthetic */ ImSdkChatPushImplV2 a;
    public final /* synthetic */ PushChatChatterListDepartmentName b;

    public n0(ImSdkChatPushImplV2 r1, PushChatChatterListDepartmentName r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r0 = ((CopyOnWriteArrayList) this.a.y).iterator();     // Catch: Throwable -> L7
    L4:
        if (r0.hasNext() == false) goto L16;
        b0 r1 = (b0) r0.next();     // Catch: Throwable -> L7
        String r2 = this.b.chat_id;     // Catch: Throwable -> L7
        r1.a();     // Catch: Throwable -> L7
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
