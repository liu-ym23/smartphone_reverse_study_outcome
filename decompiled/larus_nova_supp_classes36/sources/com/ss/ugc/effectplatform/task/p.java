package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.net.ConvertOidToUrlResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class p extends BaseNetworkTask<ConvertOidToUrlResponse, ConvertOidToUrlResponse> {
    public final EffectConfig n;
    public final String o;
    public final String p;
    public final List<String> q;
    public final Map<String, String> r;

    public static final class a {
    }

    static {
    }

    public final int h() {
        return 10002;
    }

    public final NetRequest f() {
        HashMap r0 = new HashMap();
        r0.put("scene", this.p);
        dlc.a r1 = this.n.t;
        if (r1 == null) goto L7;
        List<String> r2 = this.q;
        String r3 = r1.a.convertObjToJson(r2);
        if (r3 == null) goto L7;
        r0.put("object_ids", r3);
    L7:
        Map<String, String> r4 = this.r;
        if (r4 == null) goto L10;
        r0.putAll(r4);
    L10:
        int r5 = com.ss.ugc.effectplatform.util.m.a;
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r0, this.o), null, HTTPMethod.GET, null, null, null, false, null, 250, null);
    }

    public final int i() {
        return this.n.q;
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (ConvertOidToUrlResponse) r2.a.convertJsonToObj(r3, ConvertOidToUrlResponse.class);
    }

    public final void k(String r2, String r3, ExceptionResult r4) {
        r4.setTrackParams(r2, this.n.E, r3);
        super.k(r2, r3, r4);
    }

    public p(EffectConfig r8, String r9, String r10, List<String> r11, String r12, Map<String, String> r13) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r12, r8.P);
        this.n = r8;
        this.o = r9;
        this.p = r10;
        this.q = r11;
        this.r = r13;
    }
}
