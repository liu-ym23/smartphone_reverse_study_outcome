package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements Runnable {
    public final /* synthetic */ ChatChannelAnimManager a;
    public final /* synthetic */ ChatChannelAnimManager.b b;

    public g(ChatChannelAnimManager r1, ChatChannelAnimManager.b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatChannelAnimManager.b(this.a, this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
