package com.bytedance.android.live.recharge.exchange.service;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m<T> implements Consumer {
    public static final m a = null;

    static {
        a = new m();
    }

    public m() {
    }

    public final void accept(Object r4) {
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r0 = com.bytedance.android.live.recharge.utils.f.a;
        com.bytedance.android.live.recharge.utils.f.d("loadExchangeInfo", MapsKt.mapOf(TuplesKt.to("error", ((Throwable) r4).toString())), new Class[]{IRoom.class});
    }
}
