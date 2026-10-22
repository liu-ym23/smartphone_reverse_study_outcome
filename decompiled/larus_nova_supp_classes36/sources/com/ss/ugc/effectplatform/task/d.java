package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.net.CustomizedStickerCreateResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d extends BaseNetworkTask<CustomizedStickerCreateResponse, CustomizedStickerCreateResponse> {
    public final EffectConfig n;

    public final NetRequest f() {
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        com.ss.ugc.effectplatform.util.g.b(this.n, 6);
        throw null;
    }

    public d(EffectConfig r8, String r9) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r9, r8.P);
        this.n = r8;
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (CustomizedStickerCreateResponse) r2.a.convertJsonToObj(r3, CustomizedStickerCreateResponse.class);
    }
}
