package com.bytedance.android.live.liveinteract.feedv2.feedview;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i0 implements com.bytedance.android.live.liveinteract.feed.datamerge.m.a {
    public final /* synthetic */ MultiLinkLinkRoomFightFeedPreview a;

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.m.a
    public final IRoom getRoom() {
        return this.a.getConfigOuterProvider().getRoom();
    }

    public i0(MultiLinkLinkRoomFightFeedPreview r1) {
        this.a = r1;
    }
}
