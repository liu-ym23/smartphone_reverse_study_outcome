package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ RoomChatChannelCreator a;
    public final /* synthetic */ long b;

    public r(RoomChatChannelCreator r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        IBaseUser r4 = (IBaseUser) r3;
        RoomChatChannelCreator r5 = this.a;
        int r0 = RoomChatChannelCreator.m;
        s22.e r6 = r5.b();
        if (r6 == null) goto L6;
        r6.joinChannel(this.b);
        return;
    }
}
