package com.bytedance.android.live.liveinteract.feedv2.feedview;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements Runnable {
    public final /* synthetic */ MultiLinkCommonVideoFeedPreview a;

    public e(MultiLinkCommonVideoFeedPreview r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MultiLinkCommonVideoFeedPreview r0 = this.a;     // Catch: Throwable -> L4
        int r1 = MultiLinkCommonVideoFeedPreview.H;     // Catch: Throwable -> L4
        r0.g();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
