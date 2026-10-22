package com.ss.ugc.effectplatform.task;

import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.QueryTopChecklistEffectsModel;
import com.ss.ugc.effectplatform.model.net.QueryTopChecklistEffectsResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g1 extends BaseNetworkTask<QueryTopChecklistEffectsModel, QueryTopChecklistEffectsResponse> {
    public final EffectConfig n;
    public final String o;
    public final Boolean p;
    public final Map<String, String> q;

    public static final class a {
    }

    static {
    }

    public final NetRequest f() {
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        HashMap r1 = com.ss.ugc.effectplatform.util.g.b(this.n, 6);
        r1.put("panel", this.o);
        Boolean r2 = this.p;
        if (r2 == null) goto L5;
        r1.put("show_filtered_effects", String.valueOf(r2.booleanValue()));
    L5:
        Map<String, String> r3 = this.q;
        if (r3 == null) goto L8;
        r1.putAll(r3);
    L8:
        int r4 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r5 = new StringBuilder();
        r5.append(this.n.E);
        this.n.getClass();
        r5.append("/effect/api/topchecklist/effects");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r5.toString()), null, HTTPMethod.GET, null, null, null, false, null, 250, null);
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (QueryTopChecklistEffectsResponse) r2.a.convertJsonToObj(r3, QueryTopChecklistEffectsResponse.class);
    }

    public final void k(String r7, String r8, ExceptionResult r9) {
        Logger.e$default(Logger.INSTANCE, "QueryTopChecklistEffectsTask", "url fetch error, " + r7, null, 4, null);
        super.k(r7, r8, r9);
    }

    public final void l(long r22, long r24, long r26, com.ss.ugc.effectplatform.model.e r28) {
        QueryTopChecklistEffectsResponse r7 = (QueryTopChecklistEffectsResponse) r28;
        QueryTopChecklistEffectsModel r0 = r7.getData();
        if (r0 == null) goto L10;
        List<Effect> r1 = r0.getBind_effects();
        if (r1 == null) goto L10;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        Effect r3 = (Effect) r2.next();
        r3.setId(StringsKt.replace$default(StringsKt.replace$default(r3.getId(), "\"", "_", false, 4, null), "/", "_", false, 4, null));
    L10:
        QueryTopChecklistEffectsModel r4 = r7.getData();
        if (r4 == null) goto L18;
        List<Effect> r5 = r4.getEffects();
        if (r5 == null) goto L18;
        Iterator<T> r6 = r5.iterator();
    L16:
        if (r6.hasNext() == false) goto L18;
        Effect r8 = (Effect) r6.next();
        r8.setId(StringsKt.replace$default(StringsKt.replace$default(r8.getId(), "\"", "_", false, 4, null), "/", "_", false, 4, null));
    L18:
        QueryTopChecklistEffectsModel r9 = r7.getData();
        if (r9 == null) goto L26;
        List<Effect> r10 = r9.getCollection();
        if (r10 == null) goto L26;
        Iterator<T> r11 = r10.iterator();
    L24:
        if (r11.hasNext() == false) goto L26;
        Effect r12 = (Effect) r11.next();
        r12.setId(StringsKt.replace$default(StringsKt.replace$default(r12.getId(), "\"", "_", false, 4, null), "/", "_", false, 4, null));
    L26:
        com.ss.ugc.effectplatform.util.h r13 = com.ss.ugc.effectplatform.util.h.a;
        String r14 = this.n.i;
        QueryTopChecklistEffectsModel r15 = r7.getData();
        List<Effect> r16 = null;
        if (r15 == null) goto L29;
        List<Effect> r17 = r15.getBind_effects();
    L30:
        r13.getClass();
        com.ss.ugc.effectplatform.util.h.e(r14, r17);
        String r18 = this.n.i;
        QueryTopChecklistEffectsModel r19 = r7.getData();
        if (r19 == null) goto L33;
        List<Effect> r20 = r19.getEffects();
    L34:
        com.ss.ugc.effectplatform.util.h.e(r18, r20);
        String r21 = this.n.i;
        QueryTopChecklistEffectsModel r23 = r7.getData();
        if (r23 == null) goto L37;
        r16 = r23.getCollection();
    L37:
        com.ss.ugc.effectplatform.util.h.e(r21, r16);
        super.l(r22, r24, r26, r7);
        return;
    L33:
        r20 = null;
        goto L34
    L29:
        r17 = null;
        goto L30
    }

    public g1(EffectConfig r8, String r9, Boolean r10, Map<String, String> r11, String r12) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r12, r8.P);
        this.n = r8;
        this.o = r9;
        this.p = r10;
        this.q = r11;
    }
}
