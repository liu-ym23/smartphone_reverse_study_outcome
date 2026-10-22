package com.bytedance.android.live.liveinteract.feedv2.feedview;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q implements Runnable {
    public final /* synthetic */ MultiLinkCommonVoiceFeedPreview a;

    public q(MultiLinkCommonVoiceFeedPreview r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MultiLinkCommonVoiceFeedPreview r0 = this.a;     // Catch: Throwable -> L4
        MultiLinkCommonVoiceFeedPreview.S(r0, r0.V1, r0.b2, false, false, null, 28);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
