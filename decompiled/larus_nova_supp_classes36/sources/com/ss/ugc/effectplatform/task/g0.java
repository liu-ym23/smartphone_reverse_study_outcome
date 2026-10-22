package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.RankingEffectInfoModel;
import com.ss.ugc.effectplatform.model.net.RankingEffectResponse;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g0 extends BaseNetworkTask<List<? extends RankingEffectInfoModel>, RankingEffectResponse> {
    public final EffectConfig n;
    public final String o;

    public static final class a {
    }

    static {
    }

    public final NetRequest f() {
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        HashMap r1 = com.ss.ugc.effectplatform.util.g.b(this.n, 6);
        r1.put("ranking_category", this.o);
        int r2 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r3 = new StringBuilder();
        r3.append(this.n.E);
        this.n.getClass();
        r3.append("/effect/api/rankinglist/effectranking/list");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r3.toString()), null, HTTPMethod.GET, null, null, null, false, null, 250, null);
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (RankingEffectResponse) r2.a.convertJsonToObj(r3, RankingEffectResponse.class);
    }

    public g0(EffectConfig r8, String r9, String r10) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r9, r8.P);
        this.n = r8;
        this.o = r10;
    }

    public final void k(String r2, String r3, ExceptionResult r4) {
        r4.setTrackParams(r2, this.n.E, r3);
        super.k(r2, r3, r4);
    }
}
