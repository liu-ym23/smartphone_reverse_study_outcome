package com.bytedance.android.live.room.navi.userinfo_p.widget;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements h80.a {
    public final /* synthetic */ LiveRoomUserInfoPlatformWidget a;

    public b(LiveRoomUserInfoPlatformWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        IRoom r3 = (IRoom) r2;
        UserInfoElementManager r0 = this.a.a;
        if (r0 == null) goto L6;
        r0.j(r3);
        return;
    }
}
