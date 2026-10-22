package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.RoomChannelData;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public x(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        RoomChannelData r4 = (RoomChannelData) r3;
        if (r4 != null) goto L5;
    L7:
        this.a.invoke(null);
        return;
    L5:
        if (r4.getStatus() != 1) goto L7;
        this.a.invoke(r4);
    }
}
