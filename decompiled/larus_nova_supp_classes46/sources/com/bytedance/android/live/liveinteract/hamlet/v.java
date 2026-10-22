package com.bytedance.android.live.liveinteract.hamlet;

import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v<T> implements Consumer {
    public static final v a = null;

    static {
        a = new v();
    }

    public v() {
    }

    public final void accept(Object r8) {
        ff0.d r0 = ff0.d.a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "genOrderSingStreamInfo fail", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("logId", String.valueOf(ff0.c.a((Throwable) r8)))}), 12);
    }
}
