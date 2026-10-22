package com.bytedance.android.livesdk.chatroom.ui;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q5 implements Runnable {
    public final /* synthetic */ CameraTransitionViewHolder a;

    public q5(CameraTransitionViewHolder r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraTransitionViewHolder r0 = this.a;     // Catch: Throwable -> L4
        CameraTransitionViewHolder.State r1 = CameraTransitionViewHolder.State.IDLE;     // Catch: Throwable -> L4
        r0.getClass();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
