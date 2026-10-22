package com.ss.android.lark.chat.service.impl;

import com.bytedance.lark.pb.contact.v1.PushChannelNickname;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.Channel;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class u0 implements Runnable {
    public final /* synthetic */ PushChannelNickname a;
    public final /* synthetic */ ImSdkChatterPushImplV2 b;
    public final /* synthetic */ Channel c;

    public u0(PushChannelNickname r1, ImSdkChatterPushImplV2 r2, Channel r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        Log.i("ImSdkChatterPushImplV2", "onPushChannelNickname " + this.a.user_id);
        Iterator r0 = ((CopyOnWriteArrayList) this.b.k).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        w r1 = (w) r0.next();
        PushChannelNickname r2 = this.a;
        r1.a(r2.user_id, r2.nickname, this.c);
        goto L4
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
