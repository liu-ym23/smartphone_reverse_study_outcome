package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.net.EffectListResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h1 extends BaseNetworkTask<List<? extends Effect>, EffectListResponse> {
    public final EffectConfig n;
    public final Map<String, String> o;
    public final String p;

    public final int h() {
        return 10003;
    }

    public final NetRequest f() {
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        HashMap r1 = com.ss.ugc.effectplatform.util.g.b(this.n, 6);
        Map<String, String> r2 = this.o;
        if (r2 != null) goto L5;
    L7:
        HTTPMethod r5 = HTTPMethod.GET;
        int r3 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r4 = new StringBuilder();
        r4.append(this.n.E);
        this.n.getClass();
        r4.append("/effect/api/user/usedSticker");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r4.toString()), null, r5, null, null, null, false, null, 250, null);
    L5:
        if ((!r2.isEmpty()) == false) goto L7;
        r1.putAll(this.o);
        goto L7
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (EffectListResponse) r2.a.convertJsonToObj(r3, EffectListResponse.class);
    }

    public h1(EffectConfig r8, Map<String, String> r9, String r10) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r10, r8.P);
        this.n = r8;
        this.o = r9;
        this.p = r10;
    }

    public final void l(long r15, long r17, long r19, com.ss.ugc.effectplatform.model.e r21) {
        final EffectListResponse r1 = (EffectListResponse) r21;
        String r2 = this.n.i;
        List<Effect> r3 = r1.getEffect_list();
        if (r3 == null) goto L8;
        Iterator<T> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        Effect r5 = (Effect) r4.next();
        r5.setId(StringsKt.replace$default(StringsKt.replace$default(r5.getId(), "\"", "_", false, 4, null), "/", "_", false, 4, null));
    L8:
        List<Effect> r6 = r1.getCollection_list();
        if (r6 == null) goto L14;
        Iterator<T> r7 = r6.iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        Effect r8 = (Effect) r7.next();
        r8.setId(StringsKt.replace$default(StringsKt.replace$default(r8.getId(), "\"", "_", false, 4, null), "/", "_", false, 4, null));
    L14:
        com.ss.ugc.effectplatform.util.h r9 = com.ss.ugc.effectplatform.util.h.a;
        List<Effect> r10 = r1.getEffect_list();
        r9.getClass();
        com.ss.ugc.effectplatform.util.h.e(r2, r10);
        com.ss.ugc.effectplatform.util.h.e(r2, r1.getCollection_list());
        e(new QueryVideoUsedStickerTask$onSuccess$3(this, r1));
    }
}
