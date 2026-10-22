package com.bytedance.android.live.room.widget;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h<T> implements h80.a {
    public final /* synthetic */ LiveRoomAudienceWidget a;

    public h(LiveRoomAudienceWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        IRoom r3 = (IRoom) r2;
        LiveRoomAudienceWidget r0 = this.a;
        r0.d = r3;
        r0.Aq(r3);
    }
}
