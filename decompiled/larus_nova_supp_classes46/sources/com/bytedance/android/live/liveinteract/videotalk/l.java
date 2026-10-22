package com.bytedance.android.live.liveinteract.videotalk;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ MultiLinkVideoTalkRoomAnchorWidget a;

    public l(MultiLinkVideoTalkRoomAnchorWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        MultiLinkVideoTalkRoomAnchorWidget r4 = this.a;
        int r0 = MultiLinkVideoTalkRoomAnchorWidget.h2;
        r4.fr();
    }
}
