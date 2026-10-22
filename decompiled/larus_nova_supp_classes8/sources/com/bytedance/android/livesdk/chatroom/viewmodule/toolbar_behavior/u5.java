package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import com.bytedance.android.livesdk.chatroom.viewmodel.IAnimationScheduler;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u5 implements Runnable {
    public final /* synthetic */ t5 a;

    public u5(t5 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAnimationScheduler.Companion r0 = IAnimationScheduler.M0;     // Catch: Throwable -> L6
        DataCenter r1 = this.a.i;     // Catch: Throwable -> L6
        r0.getClass();     // Catch: Throwable -> L6
        IAnimationScheduler r2 = IAnimationScheduler.Companion.a(r1);     // Catch: Throwable -> L6
        if (r2 == null) goto L9;
        r2.registerListener(this.a.h);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
