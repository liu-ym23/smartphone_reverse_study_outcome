package com.bytedance.android.livesdk.chatroom.viewmodule.record;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o implements Runnable {
    public final /* synthetic */ LiveRecordWidget a;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.zq();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public o(LiveRecordWidget r1) {
        this.a = r1;
    }
}
