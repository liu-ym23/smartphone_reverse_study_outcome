package com.bytedance.android.livesdk.feed.drawerfeed.autoplay;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements Runnable {
    public final /* synthetic */ DrawerFeedPreviewHelper.b a;

    public b(DrawerFeedPreviewHelper.b r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a.c();     // Catch: Throwable -> L4
        this.a.a.d();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
