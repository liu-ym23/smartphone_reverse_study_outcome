package com.bytedance.android.live.liveinteract.feed;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements com.bytedance.android.live.liveinteract.plantform.datamergev2.c {
    public final /* synthetic */ CommonMultiLinkFeedView a;

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.c
    public final void a() {
        this.a.onOnlineListChanged();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.c
    public final IRoom getRoom() {
        return this.a.getMRoom();
    }

    public f(CommonMultiLinkFeedView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.c
    public final void b(int r2) {
        CommonMultiLinkFeedView.f(this.a, r2);
    }
}
