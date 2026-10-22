package com.bytedance.android.live.liveinteract.videotalk;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements Runnable {
    public final /* synthetic */ MultiLinkVideoTalkRoomAnchorWidget a;

    public c(MultiLinkVideoTalkRoomAnchorWidget r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MultiLinkVideoTalkRoomAnchorWidget r0 = this.a;     // Catch: Throwable -> L4
        r0.S1 = true;     // Catch: Throwable -> L4
        r0.yq().v();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
