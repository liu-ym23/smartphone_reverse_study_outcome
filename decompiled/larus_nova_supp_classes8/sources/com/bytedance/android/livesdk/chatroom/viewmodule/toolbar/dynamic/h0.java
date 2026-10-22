package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h0 implements Runnable {
    public final /* synthetic */ s a;
    public final /* synthetic */ ToolbarOperateManager b;

    public h0(s r1, ToolbarOperateManager r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
