package com.bytedance.android.live.multilink.voicechat.impl.widget;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements Runnable {
    public final /* synthetic */ MultiLinkVoiceChatRoomAnchorWidget.d a;

    public f(MultiLinkVoiceChatRoomAnchorWidget.d r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        hg6.g r0 = this.a.a.D;     // Catch: Throwable -> L10
        if (r0 == null) goto L13;
        ei6.a r1 = r0.V0();     // Catch: Throwable -> L10
        if (r1 == null) goto L17;
        vi6.a r2 = r1.v();     // Catch: Throwable -> L10
        if (r2 == null) goto L18;
        r2.f();     // Catch: Throwable -> L10
        return;
    L18:
        return;
    L17:
        return;
    L13:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
