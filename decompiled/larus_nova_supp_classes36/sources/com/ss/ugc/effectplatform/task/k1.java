package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.net.SearchEffectResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k1 extends BaseNetworkTask<SearchEffectResponse, SearchEffectResponse> {
    public final EffectConfig n;
    public final String o;
    public final String p;
    public final int q;
    public final int r;
    public final Map<String, String> s;

    public final int h() {
        return 10014;
    }

    public final NetRequest f() {
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        HashMap r1 = com.ss.ugc.effectplatform.util.g.b(this.n, 6);
        r1.put("panel", this.o);
        r1.put("keyword", this.p);
        r1.put("cursor", String.valueOf(this.r));
        r1.put("count", String.valueOf(this.q));
        Map<String, String> r2 = this.s;
        if (r2 == null) goto L5;
        r1.putAll(r2);
    L5:
        int r3 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r4 = new StringBuilder();
        r4.append(this.n.E);
        this.n.getClass();
        r4.append("/effect/api/search");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r4.toString()), null, HTTPMethod.GET, null, null, null, false, null, 250, null);
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (SearchEffectResponse) r2.a.convertJsonToObj(r3, SearchEffectResponse.class);
    }

    public final void l(long r9, long r11, long r13, com.ss.ugc.effectplatform.model.e r15) {
        SearchEffectResponse r7 = (SearchEffectResponse) r15;
        com.ss.ugc.effectplatform.util.h r16 = com.ss.ugc.effectplatform.util.h.a;
        String r0 = this.n.i;
        String r1 = this.o;
        List<Effect> r2 = r7.getEffect_list();
        r16.getClass();
        com.ss.ugc.effectplatform.util.h.d(r0, r1, r2);
        com.ss.ugc.effectplatform.util.h.d(this.n.i, this.o, r7.getCollection_list());
        com.ss.ugc.effectplatform.util.h.d(this.n.i, this.o, r7.getBind_effects());
        super.l(r9, r11, r13, r7);
    }

    public k1(EffectConfig r8, String r9, String r10, int r11, int r12, Map<String, String> r13, String r14) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r14, r8.P);
        this.n = r8;
        this.o = r9;
        this.p = r10;
        this.q = r11;
        this.r = r12;
        this.s = r13;
    }
}
