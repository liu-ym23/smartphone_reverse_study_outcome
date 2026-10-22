package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f1 extends BaseNetworkTask<QueryRewardEffectsResponse, QueryRewardEffectsResponse> {
    public final EffectConfig n;
    public final String o;
    public final int p;
    public final int q;
    public final Map<String, String> r;

    public static final class a {
    }

    static {
    }

    public final int h() {
        return 10002;
    }

    public final NetRequest f() {
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        HashMap r1 = com.ss.ugc.effectplatform.util.g.b(this.n, 6);
        r1.put("panel", this.o);
        r1.put("cursor", String.valueOf(this.q));
        r1.put("count", String.valueOf(this.p));
        Map<String, String> r2 = this.r;
        if (r2 == null) goto L5;
        r1.putAll(r2);
    L5:
        HTTPMethod r5 = HTTPMethod.GET;
        int r3 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r4 = new StringBuilder();
        r4.append(this.n.E);
        this.n.getClass();
        r4.append("/effect/api/v3/effect/reward");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r4.toString()), null, r5, null, null, null, false, null, 250, null);
    }

    public final int i() {
        return this.n.q;
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (QueryRewardEffectsResponse) r2.a.convertJsonToObj(r3, QueryRewardEffectsResponse.class);
    }

    public final void k(String r2, String r3, ExceptionResult r4) {
        r4.setTrackParams(r2, this.n.E, r3);
        super.k(r2, r3, r4);
    }

    public final void l(long r9, long r11, long r13, com.ss.ugc.effectplatform.model.e r15) {
        QueryRewardEffectsResponse r7 = (QueryRewardEffectsResponse) r15;
        com.ss.ugc.effectplatform.util.h r16 = com.ss.ugc.effectplatform.util.h.a;
        String r0 = this.n.i;
        String r1 = this.o;
        List<Effect> r2 = r7.getReward_effects();
        r16.getClass();
        com.ss.ugc.effectplatform.util.h.d(r0, r1, r2);
        if (this.n.s != 2) goto L5;
        com.ss.ugc.effectplatform.util.h.h(r7.getUrl_prefix(), r7.getReward_effects());
    L5:
        super.l(r9, r11, r13, r7);
    }

    public f1(EffectConfig r8, String r9, String r10, int r11, int r12, Map<String, String> r13) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r10, r8.P);
        this.n = r8;
        this.o = r9;
        this.p = r11;
        this.q = r12;
        this.r = r13;
    }
}
