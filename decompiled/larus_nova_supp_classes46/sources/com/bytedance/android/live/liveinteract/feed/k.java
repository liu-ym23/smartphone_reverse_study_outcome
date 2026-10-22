package com.bytedance.android.live.liveinteract.feed;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ MultiLinkVoiceChatFeedView a;

    public k(MultiLinkVoiceChatFeedView r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        com.bytedance.android.live.network.response.e r3 = (com.bytedance.android.live.network.response.e) r2;
        if (r3 == null) goto L7;
        MultiLinkVoiceChatFeedView.o(this.a, r3);
        return;
    }
}
