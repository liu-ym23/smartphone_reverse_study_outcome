package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n1 implements Runnable {
    public final /* synthetic */ PortraitToolbarMoreBehavior a;

    @Override // java.lang.Runnable
    public final void run() {
        PortraitToolbarMoreBehavior r0 = this.a;     // Catch: Throwable -> L6
        yo2.e r1 = r0.P;     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        r1.i(r0.L, 1, 0, com.bytedance.android.live.core.utils.s1.f(r0.Q), com.bytedance.android.live.core.utils.s1.f(this.a.R));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public n1(PortraitToolbarMoreBehavior r1) {
        this.a = r1;
    }
}
