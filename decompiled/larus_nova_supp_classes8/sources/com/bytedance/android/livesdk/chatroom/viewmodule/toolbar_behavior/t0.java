package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t0 implements Runnable {
    public final /* synthetic */ LandscapeToolbarMoreBehavior a;

    @Override // java.lang.Runnable
    public final void run() {
        LandscapeToolbarMoreBehavior r0 = this.a;     // Catch: Throwable -> L6
        yo2.e r1 = r0.O;     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        r1.i(r0.M, 1, 0, com.bytedance.android.live.core.utils.s1.f(r0.P), com.bytedance.android.live.core.utils.s1.f(this.a.Q));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public t0(LandscapeToolbarMoreBehavior r1) {
        this.a = r1;
    }
}
