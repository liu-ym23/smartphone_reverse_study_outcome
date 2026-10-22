package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.net.GetCustomizedEffectIDData;
import com.ss.ugc.effectplatform.model.net.GetCustomizedEffectIDResponse;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class v0 extends BaseNetworkTask<GetCustomizedEffectIDData, GetCustomizedEffectIDResponse> {
    public final EffectConfig n;
    public final long o;
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
        r1.put("aid", String.valueOf(this.o));
        Map<String, String> r2 = this.p;
        if (r2 == null) goto L5;
        r1.putAll(r2);
    L5:
        HTTPMethod r5 = HTTPMethod.GET;
        int r3 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r4 = new StringBuilder();
        r4.append(this.n.E);
        this.n.getClass();
        r4.append("/effect/api/customized/id");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r4.toString()), null, r5, null, null, null, false, null, 250, null);
    }

    public final int i() {
        return this.n.q;
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (GetCustomizedEffectIDResponse) r2.a.convertJsonToObj(r3, GetCustomizedEffectIDResponse.class);
    }

    public final void k(String r2, String r3, ExceptionResult r4) {
        r4.setTrackParams(r2, this.n.E, r3);
        super.k(r2, r3, r4);
    }

    public v0(EffectConfig r8, long r9, String r11, Map<String, String> r12) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r11, r8.P);
        this.n = r8;
        this.o = r9;
        this.p = r12;
    }
}
