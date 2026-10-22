package com.bytedance.android.live.liveinteract.hamlet;

import com.bytedance.android.live.GsonHelper;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u<T> implements Consumer {
    public static final u a = null;

    static {
        a = new u();
    }

    public u() {
    }

    public final void accept(Object r8) {
        com.bytedance.android.live.network.response.e r9 = (com.bytedance.android.live.network.response.e) r8;
        ff0.d r0 = ff0.d.a;     // Catch: Exception -> L5
        com.bytedance.android.live.liveinteract.utils.j.a(1, "genOrderSingStreamInfo success", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("logId", String.valueOf(r9.logId)), TuplesKt.to("res", String.valueOf(GsonHelper.get().toJson(r9.data)))}), 12);     // Catch: Exception -> L5
        return;
    }
}
