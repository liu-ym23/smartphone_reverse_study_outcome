package com.bytedance.android.live.liveinteract.animation.universalwidget;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o implements Runnable {
    public final /* synthetic */ MultiLinkUniversalAnimWidget a;

    public o(MultiLinkUniversalAnimWidget r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.Kc();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
