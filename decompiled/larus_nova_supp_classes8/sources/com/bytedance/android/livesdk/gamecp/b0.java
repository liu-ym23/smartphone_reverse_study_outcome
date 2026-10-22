package com.bytedance.android.livesdk.gamecp;

import com.bytedance.android.livesdk.chatroom.utils.n3;
import com.bytedance.android.livesdkapi.service.gamecp.ILiveIMService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b0 implements ILiveIMService {
    public b0() {
    }

    public final void removeMessageListener(long r2, vlc.l r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        vlc.d r3 = n3.c(r2);
        if (r3 == null) goto L6;
        r3.removeMessageListener(r4);
        return;
    }

    public final void addMessageListener(long r2, String r4, vlc.l r5) {
        Intrinsics.checkNotNullParameter(r4, "messageType");
        Intrinsics.checkNotNullParameter(r5, "listener");
        vlc.d r3 = n3.c(r2);
        if (r3 == null) goto L6;
        r3.addMessageListener(r4, r5);
        return;
    }
}
