package com.obric.assistant.zeus.plugin;

import android.os.Handler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class s implements Runnable {
    public final /* synthetic */ long a;

    public /* synthetic */ s(long r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long r0 = this.a;
        if (ZeusSubProcessMainProcessWakeupManager.f == false) goto L7;
        Handler r2 = ZeusSubProcessMainProcessWakeupManager.b;
        t r3 = ZeusSubProcessMainProcessWakeupManager.g;
        r2.removeCallbacks(r3);
        r2.postDelayed(r3, r0);
        return;
    }
}
