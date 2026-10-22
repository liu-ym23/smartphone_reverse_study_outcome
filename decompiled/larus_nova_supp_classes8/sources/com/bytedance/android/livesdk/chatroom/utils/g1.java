package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g1<T> implements Consumer {
    public final /* synthetic */ DataCenter a;
    public final /* synthetic */ RoomContext b;

    public g1(DataCenter r1, RoomContext r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        h1.b.getClass();
        ALogger.d(h1.a, "subscribe mRoom setted ");
        h1.a.e((IRoom) sh6.c.b((sh6.b) r3), this.a, this.b);
    }
}
