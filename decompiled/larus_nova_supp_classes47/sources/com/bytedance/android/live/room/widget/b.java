package com.bytedance.android.live.room.widget;

import io.reactivex.functions.Consumer;
import zg1.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ LiveRoomAudienceWidget a;

    public b(LiveRoomAudienceWidget r1) {
        this.a = r1;
    }

    public final void accept(n r2) {
        LiveRoomAudienceWidget r3 = this.a;
        int r0 = LiveRoomAudienceWidget.w;
        r3.yq();
    }

    public final /* bridge */ /* synthetic */ void accept(Object r1) {
        accept((n) r1);
    }
}
