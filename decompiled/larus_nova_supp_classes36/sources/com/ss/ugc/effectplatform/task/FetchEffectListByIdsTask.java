package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.net.EffectListResponse;
import com.ss.ugc.effectplatform.repository.EffectRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FetchEffectListByIdsTask extends BaseNetworkTask<List<? extends Effect>, EffectListResponse> {
    public final EffectConfig n;
    public final List<String> o;
    public final String p;
    public final Map<String, String> q;
    public final boolean r;
    public final q s;

    public final int h() {
        return 10014;
    }

    public final NetRequest f() {
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        HashMap r1 = com.ss.ugc.effectplatform.util.g.b(this.n, 6);
        Map<String, String> r2 = this.q;
        if (r2 == null) goto L5;
        r1.putAll(r2);
    L5:
        List<String> r3 = this.o;
        if (r3 == null) goto L15;
        dlc.a r4 = this.n.t;
        if (r4 == null) goto L15;
        String r5 = r4.a.convertObjToJson(r3);
        if (r5 == null) goto L15;
        if (this.r == false) goto L14;
        r1.put("effect_ids", r5);
        goto L15
    L14:
        r1.put("resource_ids", r5);
    L15:
        int r6 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r7 = new StringBuilder();
        r7.append(this.n.E);
        this.n.getClass();
        r7.append("/effect/api");
        if (this.r == false) goto L18;
        String r8 = "/v3/effect/list";
    L19:
        r7.append(r8);
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r7.toString()), null, HTTPMethod.GET, null, null, null, false, null, 250, null);
    L18:
        r8 = "/v3/effect/listByResourceId";
        goto L19
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (EffectListResponse) r2.a.convertJsonToObj(r3, EffectListResponse.class);
    }

    public final void k(String r1, String r2, final ExceptionResult r3) {
        e(new FetchEffectListByIdsTask$onFailure$1(this, r3));
    }

    public final void l(long r14, long r16, long r18, com.ss.ugc.effectplatform.model.e r20) {
        final EffectListResponse r1 = (EffectListResponse) r20;
        List<Effect> r2 = r1.getEffect_list();
        if (r2 == null) goto L8;
        Iterator<T> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        Effect r4 = (Effect) r3.next();
        r4.setId(StringsKt.replace$default(StringsKt.replace$default(r4.getId(), "\"", "_", false, 4, null), "/", "_", false, 4, null));
    L8:
        List<Effect> r5 = r1.getCollection_list();
        if (r5 == null) goto L14;
        Iterator<T> r6 = r5.iterator();
    L12:
        if (r6.hasNext() == false) goto L14;
        Effect r7 = (Effect) r6.next();
        r7.setId(StringsKt.replace$default(StringsKt.replace$default(r7.getId(), "\"", "_", false, 4, null), "/", "_", false, 4, null));
    L14:
        com.ss.ugc.effectplatform.util.h r8 = com.ss.ugc.effectplatform.util.h.a;
        String r9 = this.n.i;
        List<Effect> r10 = r1.getEffect_list();
        r8.getClass();
        com.ss.ugc.effectplatform.util.h.e(r9, r10);
        com.ss.ugc.effectplatform.util.h.e(this.n.i, r1.getCollection_list());
        ArrayList r11 = new ArrayList();
        r11.addAll(r1.getEffect_list());
        r11.addAll(r1.getBind_effects());
        r11.addAll(r1.getCollection_list());
        if (r11.isEmpty() == false) goto L17;
        e(new FetchEffectListByIdsTask$onSuccess$3(this, r1));
        return;
    L17:
        this.s.a(r11, new FetchEffectListByIdsTask$onSuccess$4(this, r1));
    }

    public FetchEffectListByIdsTask(EffectConfig r8, List r9, String r10, Map r11, boolean r12, EffectRepository.a r13) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r10, r8.P);
        this.n = r8;
        this.o = r9;
        this.p = r10;
        this.q = r11;
        this.r = r12;
        this.s = r13;
    }
}
