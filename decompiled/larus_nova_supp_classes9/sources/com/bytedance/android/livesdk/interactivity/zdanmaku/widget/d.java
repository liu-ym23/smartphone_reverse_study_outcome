package com.bytedance.android.livesdk.interactivity.zdanmaku.widget;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements Runnable {
    public final /* synthetic */ LandscapeDanmakuPresenterV2 a;

    public d(LandscapeDanmakuPresenterV2 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.A.k();     // Catch: Throwable -> L4
        this.a.A.k();     // Catch: Throwable -> L4
        this.a.D.k();     // Catch: Throwable -> L4
        this.a.D.k();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
