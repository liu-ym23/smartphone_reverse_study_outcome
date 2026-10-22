package com.bytedance.android.live.liveinteract.feed;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ MultiLinkVoiceChatFeedView a;

    public m(MultiLinkVoiceChatFeedView r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        com.bytedance.android.live.network.response.e r3 = (com.bytedance.android.live.network.response.e) r2;
        if (r3 == null) goto L7;
        MultiLinkVoiceChatFeedView r0 = this.a;
        r0.V0 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.g) r3.data;
        r0.T();
        return;
    }
}
