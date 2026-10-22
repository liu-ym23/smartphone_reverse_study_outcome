package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.ResourceListModel;
import com.ss.ugc.effectplatform.model.net.ResourceListResponse;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class u0 extends BaseNetworkTask<ResourceListModel, ResourceListResponse> {
    public final EffectConfig n;
    public final Map<String, String> o;

    public final NetRequest f() {
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        HashMap r1 = com.ss.ugc.effectplatform.util.g.b(this.n, 6);
        Map<String, String> r2 = this.o;
        if (r2 == null) goto L5;
        r1.putAll(r2);
    L5:
        int r3 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r4 = new StringBuilder();
        r4.append(this.n.E);
        this.n.getClass();
        r4.append("/effect/api/moji/resource");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r4.toString()), null, HTTPMethod.GET, null, null, null, false, null, 250, null);
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (ResourceListResponse) r2.a.convertJsonToObj(r3, ResourceListResponse.class);
    }

    public u0(EffectConfig r8, String r9, Map<String, String> r10) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r9, r8.P);
        this.n = r8;
        this.o = r10;
    }
}
