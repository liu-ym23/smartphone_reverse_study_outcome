package com.bytedance.android.live.liveinteract.feed;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements com.bytedance.android.live.liveinteract.feed.datamerge.m.a {
    public final /* synthetic */ CommonMultiLinkFeedView a;

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.m.a
    public final IRoom getRoom() {
        return this.a.getMRoom();
    }

    public g(CommonMultiLinkFeedView r1) {
        this.a = r1;
    }
}
