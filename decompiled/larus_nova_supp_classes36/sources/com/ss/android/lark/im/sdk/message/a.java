package com.ss.android.lark.im.sdk.message;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.im.sdk.message.resend.h;
import com.ss.android.lark.im.sdk.message.resend.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements Runnable {
    public final /* synthetic */ ResendMessagePipelines a;
    public final /* synthetic */ String b;
    public final /* synthetic */ i c;
    public final /* synthetic */ h d;

    public a(b r1, String r2, i r3, h r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = com.ss.android.lark.im.sdk.a.a;     // Catch: Throwable -> L4
        com.ss.android.lark.im.sdk.a.b(this.a.b(), "message send runnable start to run, cId is " + this.b);     // Catch: Throwable -> L4
        this.c.c(this.d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
