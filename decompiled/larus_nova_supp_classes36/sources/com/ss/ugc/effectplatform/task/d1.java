package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.net.QueryCustomizedEffectsData;
import com.ss.ugc.effectplatform.model.net.QueryCustomizedEffectsResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d1 extends BaseNetworkTask<QueryCustomizedEffectsData, QueryCustomizedEffectsResponse> {
    public final EffectConfig n;
    public final String o;
    public final Map<String, String> p;

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
        Map<String, String> r2 = this.p;
        if (r2 == null) goto L5;
        r1.putAll(r2);
    L5:
        HTTPMethod r5 = HTTPMethod.GET;
        int r3 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r4 = new StringBuilder();
        r4.append(this.n.E);
        this.n.getClass();
        r4.append("/effect/api/customized");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r4.toString()), null, r5, null, null, null, false, null, 250, null);
    }

    public final int i() {
        return this.n.q;
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (QueryCustomizedEffectsResponse) r2.a.convertJsonToObj(r3, QueryCustomizedEffectsResponse.class);
    }

    public final void k(String r2, String r3, ExceptionResult r4) {
        r4.setTrackParams(r2, this.n.E, r3);
        super.k(r2, r3, r4);
    }

    public d1(EffectConfig r8, String r9, String r10, Map<String, String> r11) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r10, r8.P);
        this.n = r8;
        this.o = r9;
        this.p = r11;
    }

    public final void l(long r21, long r23, long r25, com.ss.ugc.effectplatform.model.e r27) {
        QueryCustomizedEffectsResponse r7 = (QueryCustomizedEffectsResponse) r27;
        QueryCustomizedEffectsData r0 = r7.getData();
        if (r0 == null) goto L10;
        List<Effect> r1 = r0.getEffects();
        if (r1 == null) goto L10;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        Effect r3 = (Effect) r2.next();
        r3.setId(StringsKt.replace$default(StringsKt.replace$default(r3.getId(), "\"", "_", false, 4, null), "/", "_", false, 4, null));
    L10:
        com.ss.ugc.effectplatform.util.h r4 = com.ss.ugc.effectplatform.util.h.a;
        QueryCustomizedEffectsData r5 = r7.getData();
        List<Effect> r6 = null;
        if (r5 == null) goto L13;
        List<String> r8 = r5.getUrl_prefix();
    L14:
        QueryCustomizedEffectsData r9 = r7.getData();
        if (r9 == null) goto L17;
        List<Effect> r10 = r9.getEffects();
    L18:
        r4.getClass();
        com.ss.ugc.effectplatform.util.h.h(r8, r10);
        String r11 = this.n.i;
        QueryCustomizedEffectsData r12 = r7.getData();
        if (r12 == null) goto L21;
        r6 = r12.getEffects();
    L21:
        com.ss.ugc.effectplatform.util.h.e(r11, r6);
        super.l(r21, r23, r25, r7);
        return;
    L17:
        r10 = null;
        goto L18
    L13:
        r8 = null;
        goto L14
    }
}
