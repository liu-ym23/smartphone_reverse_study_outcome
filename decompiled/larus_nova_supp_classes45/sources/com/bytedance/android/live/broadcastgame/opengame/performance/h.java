package com.bytedance.android.live.broadcastgame.opengame.performance;

import io.reactivex.functions.Consumer;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ c a;

    public h(c r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        com.bytedance.android.live.network.response.e r3 = (com.bytedance.android.live.network.response.e) r2;
        c r4 = this.a;
        r4.d = new JSONArray();
    }
}
