package com.bytedance.android.live.room.widget;

import com.bytedance.android.live.room.adapter.AudienceListAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements AudienceListAdapter.b {
    public final /* synthetic */ LiveRoomAudienceWidget a;

    public d(LiveRoomAudienceWidget r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.room.adapter.AudienceListAdapter.b
    public final void onShow() {
        LiveRoomAudienceWidget.wq(this.a);
    }
}
