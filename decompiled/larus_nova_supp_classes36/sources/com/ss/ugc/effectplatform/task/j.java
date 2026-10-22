package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.net.InfoStickerEffect;
import com.ss.ugc.effectplatform.model.net.InfoStickerListModel;
import com.ss.ugc.effectplatform.model.net.InfoStickerListResponse;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j extends BaseNetworkTask<InfoStickerListResponse, InfoStickerListResponse> {
    public final EffectConfig n;

    public final NetRequest f() {
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        com.ss.ugc.effectplatform.util.g.b(this.n, 6);
        throw null;
    }

    public j(EffectConfig r8, String r9) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r9, r8.P);
        this.n = r8;
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (InfoStickerListResponse) r2.a.convertJsonToObj(r3, InfoStickerListResponse.class);
    }

    public final void l(long r9, long r11, long r13, com.ss.ugc.effectplatform.model.e r15) {
        InfoStickerListResponse r7 = (InfoStickerListResponse) r15;
        com.ss.ugc.effectplatform.util.h r16 = com.ss.ugc.effectplatform.util.h.a;
        String r0 = this.n.i;
        InfoStickerListModel r1 = r7.getData();
        if (r1 == null) goto L5;
        List<InfoStickerEffect> r2 = r1.getSticker_list();
    L6:
        r16.getClass();
        com.ss.ugc.effectplatform.util.h.g(r0, r2);
        super.l(r9, r11, r13, r7);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
