package com.bytedance.android.livesdk.chatroom.ui;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.message.model.cm;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ToastMessageController implements vlc.l {
    public ToastMessageController(RoomContext r2) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        r2.getMessageManager().c(new AnonymousClass1(this));
    }

    public final void onMessage(tlc.d r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        if ((r2 instanceof cm) == true) goto L5;
        r2 = null;
    L5:
        cm r3 = (cm) r2;
        if (r3 == null) goto L12;
        String r4 = r3.getContent();
        if (r4 == null) goto L13;
        com.bytedance.android.live.core.utils.f2.c(r4, 0);
        return;
    L13:
        return;
    }
}
