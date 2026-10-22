package com.bytedance.android.livesdk.dynamicstrategy.impl.source;

import com.bytedance.android.livesdkapi.ws.LiveWsConnectState;
import com.bytedance.android.livesdkapi.ws.LiveWsMessage;
import com.bytedance.android.livesdkapi.ws.OnLiveWsMessageReceiveListener;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import lu1.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements OnLiveWsMessageReceiveListener {
    public static final c a = null;

    public c() {
    }

    public final void onReceiveConnectEvent(LiveWsConnectState r1, JSONObject r2) {
    }

    static {
        a = new c();
    }

    public final void onReceiveMsg(LiveWsMessage r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r5 = k.a;
        k.g("DynamicStrategy_message", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("status", "frontier_message")}));
        DynamicStrategyFetcher.updateStrategyWhenMessageNotify$default(DynamicStrategyFetcher.INSTANCE, null, 1, null);
    }
}
