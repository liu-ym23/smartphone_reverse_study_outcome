package com.bytedance.android.live.room.navi.userinfo_p.widget;

import io.reactivex.functions.Consumer;
import zg1.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ LiveRoomUserInfoPlatformWidget a;

    public a(LiveRoomUserInfoPlatformWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        LiveRoomUserInfoPlatformWidget r0 = this.a;
        r0.onEvent((x0) r2);
    }
}
