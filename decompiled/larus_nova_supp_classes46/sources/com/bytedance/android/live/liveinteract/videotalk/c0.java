package com.bytedance.android.live.liveinteract.videotalk;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfig;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c0 implements Runnable {
    public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;
    public final /* synthetic */ ILinkPlayerInfoBridge b;
    public final /* synthetic */ ILiveLinkCameraBackUpConfig c;

    public c0(MultiLinkVideoTalkRoomGuestWidget r1, ILinkPlayerInfoBridge r2, ILiveLinkCameraBackUpConfig r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        tf0.o r0 = this.a.T;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.c(tc0.c.h().f, true);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
