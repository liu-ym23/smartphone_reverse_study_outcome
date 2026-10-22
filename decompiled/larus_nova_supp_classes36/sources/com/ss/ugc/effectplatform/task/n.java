package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.net.StickerUploadAuthKeyResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n extends BaseNetworkTask<StickerUploadAuthKeyResponse, StickerUploadAuthKeyResponse> {
    public final EffectConfig n;

    public final NetRequest f() {
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        com.ss.ugc.effectplatform.util.g.b(this.n, 6);
        throw null;
    }

    public n(EffectConfig r8, String r9) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r9, r8.P);
        this.n = r8;
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (StickerUploadAuthKeyResponse) r2.a.convertJsonToObj(r3, StickerUploadAuthKeyResponse.class);
    }

    public final void k(String r2, String r3, ExceptionResult r4) {
        r4.setTrackParams(r2, this.n.E, r3);
        super.k(r2, r3, r4);
    }
}
