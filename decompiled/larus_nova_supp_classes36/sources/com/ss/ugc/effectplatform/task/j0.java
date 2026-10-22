package com.ss.ugc.effectplatform.task;

import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.net.InspirationFeedEffectsResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j0 extends BaseNetworkTask<List<? extends Effect>, InspirationFeedEffectsResponse> {
    public final EffectConfig n;
    public final String o;
    public final int p;
    public final int q;
    public final String r;
    public final String s;
    public final Map<String, String> t;

    public static final class a {
    }

    static {
    }

    public final NetRequest f() {
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        HashMap r1 = com.ss.ugc.effectplatform.util.g.b(this.n, 6);
        r1.put("inspiration_category", String.valueOf(this.p));
        r1.put("count", String.valueOf(this.q));
        String r2 = this.r;
        if (r2 == null) goto L5;
        r1.put("insert_aweme_ids", r2);
    L5:
        String r3 = this.s;
        if (r3 == null) goto L8;
        r1.put("enter_from", r3);
    L8:
        Map<String, String> r4 = this.t;
        if (r4 == null) goto L11;
        r1.putAll(r4);
    L11:
        int r5 = com.ss.ugc.effectplatform.util.m.a;
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, this.o + "/aweme/v1/inspiration/feed/"), null, HTTPMethod.GET, null, null, null, false, null, 250, null);
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (InspirationFeedEffectsResponse) r2.a.convertJsonToObj(r3, InspirationFeedEffectsResponse.class);
    }

    public final void k(String r7, String r8, ExceptionResult r9) {
        Logger.e$default(Logger.INSTANCE, "FetchInspirationFeedEffectsTask", "url fetch error, " + r7, null, 4, null);
        super.k(r7, r8, r9);
    }

    public final void l(long r21, long r23, long r25, com.ss.ugc.effectplatform.model.e r27) {
        InspirationFeedEffectsResponse r7 = (InspirationFeedEffectsResponse) r27;
        List<Effect> r0 = r7.m1542getResponseData();
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        Effect r2 = (Effect) r1.next();
        r2.setId(StringsKt.replace$default(StringsKt.replace$default(r2.getId(), "\"", "_", false, 4, null), "/", "_", false, 4, null));
    L8:
        com.ss.ugc.effectplatform.util.h r3 = com.ss.ugc.effectplatform.util.h.a;
        String r4 = this.n.i;
        List<Effect> r5 = r7.m1542getResponseData();
        r3.getClass();
        com.ss.ugc.effectplatform.util.h.e(r4, r5);
        super.l(r21, r23, r25, r7);
    }

    public j0(EffectConfig r8, String r9, int r10, int r11, String r12, String r13, Map<String, String> r14, String r15) {
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
