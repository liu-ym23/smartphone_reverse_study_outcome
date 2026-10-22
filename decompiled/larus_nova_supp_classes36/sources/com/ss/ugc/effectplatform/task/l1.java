package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.net.SearchEffectResponseV2;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l1 extends BaseNetworkTask<SearchEffectResponseV2, SearchEffectResponseV2> {
    public final EffectConfig n;
    public final String o;
    public final String p;
    public final int q;
    public final int r;
    public final String s;
    public final Map<String, String> t;

    public final int h() {
        return 10014;
    }

    public final NetRequest f() {
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        HashMap r1 = com.ss.ugc.effectplatform.util.g.b(this.n, 6);
        String r2 = this.o;
        if (r2 == null) goto L5;
        r1.put("search_id", r2);
    L5:
        r1.put("keyword", this.p);
        r1.put("cursor", String.valueOf(this.r));
        r1.put("count", String.valueOf(this.q));
        String r3 = this.s;
        if (r3 == null) goto L8;
        r1.put("panel", r3);
    L8:
        Map<String, String> r4 = this.t;
        if (r4 == null) goto L11;
        r1.putAll(r4);
    L11:
        int r5 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r6 = new StringBuilder();
        r6.append(this.n.E);
        this.n.getClass();
        r6.append("/effect/api/search/effects");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r6.toString()), null, HTTPMethod.GET, null, null, null, false, null, 250, null);
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (SearchEffectResponseV2) r2.a.convertJsonToObj(r3, SearchEffectResponseV2.class);
    }

    public l1(EffectConfig r8, String r9, String r10, int r11, int r12, String r13, Map<String, String> r14, String r15) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r15, r8.P);
        this.n = r8;
        this.o = r9;
        this.p = r10;
        this.q = r11;
        this.r = r12;
        this.s = r13;
        this.t = r14;
    }
}
