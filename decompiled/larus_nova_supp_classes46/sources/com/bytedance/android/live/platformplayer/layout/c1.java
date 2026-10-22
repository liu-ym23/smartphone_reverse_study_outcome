package com.bytedance.android.live.platformplayer.layout;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c1 implements Runnable {
    public final /* synthetic */ LivePlayerWidget a;

    public c1(LivePlayerWidget r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LivePlayerWidget r0 = this.a;     // Catch: Throwable -> L4
        int r1 = LivePlayerWidget.V2;     // Catch: Throwable -> L4
        r0.Qq();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
