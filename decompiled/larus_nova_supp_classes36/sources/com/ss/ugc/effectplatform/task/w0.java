package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.net.ModfifyFavoriteResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class w0 extends BaseNetworkTask<List<? extends String>, ModfifyFavoriteResponse> {
    public final EffectConfig n;
    public final String o;
    public final String p;
    public final List<String> q;
    public final boolean r;
    public final Map<String, String> s;

    public final NetRequest f() {
        HashMap r5 = new HashMap();
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        r5.putAll(com.ss.ugc.effectplatform.util.g.b(this.n, 6));
        String r1 = this.o;
        if (r1 == null) goto L5;
        r5.put("panel", r1);
    L5:
        r5.put("effect_ids", this.q);
        r5.put("type", Integer.valueOf(this.r ? 1 : 0));
        Map<String, String> r2 = this.s;
        if (r2 == null) goto L8;
        r5.putAll(r2);
    L8:
        StringBuilder r3 = new StringBuilder();
        r3.append(this.n.E);
        this.n.getClass();
        r3.append("/effect/api/v3/effect/favorite");
        return new NetRequest(r3.toString(), null, HTTPMethod.POST, null, r5, "application/json", false, null, 202, null);
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (ModfifyFavoriteResponse) r2.a.convertJsonToObj(r3, ModfifyFavoriteResponse.class);
    }

    public final void l(long r1, long r3, long r5, com.ss.ugc.effectplatform.model.e r7) {
        ModfifyFavoriteResponse r8 = (ModfifyFavoriteResponse) r7;
        e(new ModFavoriteTask$onSuccess$1(this));
    }

    public w0(EffectConfig r8, String r9, String r10, List<String> r11, boolean r12, Map<String, String> r13) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r10, r8.P);
        this.n = r8;
        this.o = r9;
        this.p = r10;
        this.q = r11;
        this.r = r12;
        this.s = r13;
    }
}
