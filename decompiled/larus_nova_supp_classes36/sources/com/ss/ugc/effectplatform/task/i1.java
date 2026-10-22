package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.net.RecommendSearchWordsResponse;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i1 extends BaseNetworkTask<RecommendSearchWordsResponse, RecommendSearchWordsResponse> {
    public final EffectConfig n;
    public final String o;

    public final int h() {
        return 10003;
    }

    public final NetRequest f() {
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        HashMap r1 = com.ss.ugc.effectplatform.util.g.b(this.n, 6);
        String r2 = this.o;
        if (r2 == null) goto L5;
        r1.put("panel", r2);
    L5:
        int r3 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r4 = new StringBuilder();
        r4.append(this.n.E);
        this.n.getClass();
        r4.append("/effect/api/search/recommend");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r4.toString()), null, HTTPMethod.GET, null, null, null, false, null, 250, null);
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (RecommendSearchWordsResponse) r2.a.convertJsonToObj(r3, RecommendSearchWordsResponse.class);
    }

    public i1(EffectConfig r8, String r9, String r10) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r10, r8.P);
        this.n = r8;
        this.o = r9;
    }
}
