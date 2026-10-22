package com.bytedance.android.livesdk.chatroom.ui;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t3 implements Runnable {
    public final /* synthetic */ AbsInteractionFragment a;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.f.e();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public t3(AbsInteractionFragment r1) {
        this.a = r1;
    }
}
