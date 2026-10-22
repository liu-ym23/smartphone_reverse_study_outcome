package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.net.EffectListResponse;
import com.ss.ugc.effectplatform.repository.EffectRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class t extends BaseNetworkTask<List<? extends Effect>, EffectListResponse> {
    public final EffectConfig n;
    public final List<String> o;
    public final Map<String, String> p;
    public final q q;

    public final NetRequest f() {
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        HashMap r1 = com.ss.ugc.effectplatform.util.g.b(this.n, 6);
        Map<String, String> r2 = this.p;
        if (r2 == null) goto L5;
        r1.putAll(r2);
    L5:
        List<String> r3 = this.o;
        if (r3 == null) goto L12;
        dlc.a r4 = this.n.t;
        if (r4 == null) goto L12;
        String r5 = r4.a.convertObjToJson(r3);
        if (r5 == null) goto L12;
        r1.put("effect_ids", r5);
    L12:
        int r6 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r7 = new StringBuilder();
        r7.append(this.n.E);
        this.n.getClass();
        r7.append("/effect/api/v3/effect/list");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r7.toString()), null, HTTPMethod.GET, null, null, null, false, null, 250, null);
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (EffectListResponse) r2.a.convertJsonToObj(r3, EffectListResponse.class);
    }

    public final void l(long r17, long r19, long r21, com.ss.ugc.effectplatform.model.e r23) {
        EffectListResponse r8 = (EffectListResponse) r23;
        List<Effect> r0 = r8.getEffect_list();
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        Effect r2 = (Effect) r1.next();
        r2.setId(StringsKt.replace$default(StringsKt.replace$default(r2.getId(), "\"", "_", false, 4, null), "/", "_", false, 4, null));
    L8:
        com.ss.ugc.effectplatform.util.h r3 = com.ss.ugc.effectplatform.util.h.a;
        String r4 = this.n.i;
        List<Effect> r5 = r8.getEffect_list();
        r3.getClass();
        com.ss.ugc.effectplatform.util.h.e(r4, r5);
        ArrayList r10 = new ArrayList();
        r10.addAll(r8.getEffect_list());
        r10.addAll(r8.getBind_effects());
        r10.addAll(r8.getCollection_list());
        if (r10.isEmpty() == false) goto L11;
        super.l(r17, r19, r21, r8);
        return;
    L11:
        this.q.a(r10, new s(this, r17, r19, r21, r8));
    }

    public t(EffectConfig r8, List r9, String r10, Map r11, EffectRepository.a r12) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r10, r8.P);
        this.n = r8;
        this.o = r9;
        this.p = r11;
        this.q = r12;
    }

    public static final /* synthetic */ void q(t r0, long r1, long r3, long r5, EffectListResponse r7) {
        super.l(r1, r3, r5, r7);
    }
}
