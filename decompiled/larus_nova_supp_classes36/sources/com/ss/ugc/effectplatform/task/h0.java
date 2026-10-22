package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h0 extends BaseNetworkTask<FetchFavoriteListResponse, FetchFavoriteListResponse> {
    public final EffectConfig n;
    public final String o;
    public final Map<String, String> p;

    public final NetRequest f() {
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        HashMap r1 = com.ss.ugc.effectplatform.util.g.b(this.n, 6);
        String r2 = this.o;
        if (r2 == null) goto L5;
        r1.put("panel", r2);
    L5:
        Map<String, String> r3 = this.p;
        if (r3 == null) goto L8;
        r1.putAll(r3);
    L8:
        int r4 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r5 = new StringBuilder();
        r5.append(this.n.E);
        this.n.getClass();
        r5.append("/effect/api/v3/effect/my");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r5.toString()), null, HTTPMethod.GET, null, null, null, false, null, 250, null);
    }

    public final int i() {
        return this.n.q;
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (FetchFavoriteListResponse) r2.a.convertJsonToObj(r3, FetchFavoriteListResponse.class);
    }

    public h0(EffectConfig r8, String r9, String r10, Map<String, String> r11) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r10, r8.P);
        this.n = r8;
        this.o = r9;
        this.p = r11;
    }

    public final void l(long r22, long r24, long r26, com.ss.ugc.effectplatform.model.e r28) {
        FetchFavoriteListResponse r7 = (FetchFavoriteListResponse) r28;
        List<Effect> r0 = r7.getEffect_list();
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        Effect r2 = (Effect) r1.next();
        r2.setId(StringsKt.replace$default(StringsKt.replace$default(r2.getId(), "\"", "_", false, 4, null), "/", "_", false, 4, null));
    L8:
        List<Effect> r3 = r7.getCollection_effects();
        if (r3 == null) goto L14;
        Iterator<T> r4 = r3.iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        Effect r5 = (Effect) r4.next();
        r5.setId(StringsKt.replace$default(StringsKt.replace$default(r5.getId(), "\"", "_", false, 4, null), "/", "_", false, 4, null));
    L14:
        com.ss.ugc.effectplatform.util.h r6 = com.ss.ugc.effectplatform.util.h.a;
        String r8 = this.n.i;
        List<Effect> r9 = r7.getEffect_list();
        r6.getClass();
        com.ss.ugc.effectplatform.util.h.e(r8, r9);
        com.ss.ugc.effectplatform.util.h.e(this.n.i, r7.getCollection_effects());
        super.l(r22, r24, r26, r7);
    }
}
