package com.bytedance.android.live.multilink.voicechat.impl.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class z<T> implements Consumer {
    public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;

    public z(MultiLinkVoiceChatRoomGuestWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        if (((Boolean) r3).booleanValue() == false) goto L5;
        int r4 = 4;
    L6:
        hg6.g r0 = this.a.P2();
        if (r0 == null) goto L10;
        r0.X(r4, "currentUserSingerChanged");
        return;
    L10:
        return;
    L5:
        r4 = 3;
        goto L6
    }
}
