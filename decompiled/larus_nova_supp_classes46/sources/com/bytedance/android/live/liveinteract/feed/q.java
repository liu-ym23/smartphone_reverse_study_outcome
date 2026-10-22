package com.bytedance.android.live.liveinteract.feed;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q implements Runnable {
    public final /* synthetic */ MultiLinkVoiceChatFeedView a;

    public q(MultiLinkVoiceChatFeedView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MultiLinkVoiceChatFeedView r0 = this.a;     // Catch: Throwable -> L4
        r0.h = false;     // Catch: Throwable -> L4
        int r1 = MultiLinkVoiceChatFeedView.h(r0);     // Catch: Throwable -> L4
        int r2 = MultiLinkVoiceChatFeedView.f(this.a);     // Catch: Throwable -> L4
        MultiLinkVoiceChatFeedView.t(this.a, r1, r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
