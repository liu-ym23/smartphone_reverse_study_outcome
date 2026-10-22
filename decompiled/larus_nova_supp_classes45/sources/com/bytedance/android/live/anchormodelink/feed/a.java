package com.bytedance.android.live.anchormodelink.feed;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements Runnable {
    public final /* synthetic */ AnchorModeDynamicFeedPreview a;

    public a(AnchorModeDynamicFeedPreview r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AnchorModeDynamicFeedPreview r0 = this.a;     // Catch: Throwable -> L4
        int r1 = AnchorModeDynamicFeedPreview.r;     // Catch: Throwable -> L4
        r0.b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
