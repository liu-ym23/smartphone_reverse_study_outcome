package com.bytedance.android.live.liveinteract.hamlet;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r implements Runnable {
    public final /* synthetic */ HamletAvatarWidget a;

    public r(HamletAvatarWidget r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HamletAvatarWidget r0 = this.a;     // Catch: Throwable -> L4
        int r1 = HamletAvatarWidget.T;     // Catch: Throwable -> L4
        r0.zq();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
