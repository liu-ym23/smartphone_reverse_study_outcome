package com.bytedance.android.live.multilink.voicechat.impl.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ MultiLinkVoiceChatRoomAnchorWidget a;

    public m(MultiLinkVoiceChatRoomAnchorWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        MultiLinkVoiceChatRoomAnchorWidget r4 = this.a;
        int r0 = MultiLinkVoiceChatRoomAnchorWidget.E2;
        r4.jr();
    }
}
