package com.bytedance.android.livesdk.interactivity.service.messagelist;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements Runnable {
    public final /* synthetic */ MessageListScrollManager a;

    public i(MessageListScrollManager r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MessageListScrollManager r0 = this.a;     // Catch: Throwable -> L4
        r0.d.scrollToPosition(r0.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
