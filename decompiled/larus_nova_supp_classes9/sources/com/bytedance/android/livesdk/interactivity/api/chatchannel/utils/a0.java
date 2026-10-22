package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a0<T> implements Consumer {
    public final /* synthetic */ RoomSquareCreator a;
    public final /* synthetic */ com.bytedance.live.datacontext.n b;

    public a0(RoomSquareCreator r1, com.bytedance.live.datacontext.n r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        sh6.b r3 = (sh6.b) r2;
        RoomSquareCreator r4 = this.a;
        vh7.c r0 = jm2.a.e((vh7.c) this.b.getValue());
        Intrinsics.checkNotNull(r0);
        r4.b((Room) r0);
    }
}
