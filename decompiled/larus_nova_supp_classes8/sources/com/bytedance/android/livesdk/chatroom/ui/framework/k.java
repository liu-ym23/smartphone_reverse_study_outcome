package com.bytedance.android.livesdk.chatroom.ui.framework;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k implements Runnable {
    public final /* synthetic */ NewAudienceInteractionFragment a;

    public k(NewAudienceInteractionFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.f.x();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
