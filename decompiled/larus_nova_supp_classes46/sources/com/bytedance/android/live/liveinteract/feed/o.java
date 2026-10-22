package com.bytedance.android.live.liveinteract.feed;

import com.bytedance.android.livesdk.chatroom.model.interact.k1;
import com.bytedance.android.livesdk.chatroom.model.interact.p2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ MultiLinkVoiceChatFeedView a;

    public o(MultiLinkVoiceChatFeedView r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r3;
        if (r4 == null) goto L13;
        MultiLinkVoiceChatFeedView r0 = this.a;
        k1 r1 = (k1) r4.data;
        if (r1 == null) goto L10;
        p2 r2 = r1.getLinkmicPlayModeInfo();
        if (r2 == null) goto L10;
        com.bytedance.android.live.liveinteract.multiscene.a r5 = r2.getTeamFightInfo();
    L11:
        MultiLinkVoiceChatFeedView.s(r0, r5);
        MultiLinkVoiceChatFeedView.o(this.a, r4);
        return;
    L10:
        r5 = null;
        goto L11
    }
}
