package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.net.AddCustomizedEffectResponse;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends BaseNetworkTask<AddCustomizedEffectResponse, AddCustomizedEffectResponse> {
    public final EffectConfig n;
    public final long o;
    public final String p;
    public final String q;
    public final int r;
    public final String s;
    public final String t;
    public final int u;
    public final String v;
    public final String w;
    public final Map<String, Object> x;

    /* JADX INFO: renamed from: com.ss.ugc.effectplatform.task.a$a, reason: collision with other inner class name */
    public static final class C0200a {
    }

    static {
    }

    public final int h() {
        return 10002;
    }

    public final NetRequest f() {
        HashMap r5 = new HashMap();
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        r5.putAll(com.ss.ugc.effectplatform.util.g.b(this.n, 6));
        r5.remove("aid");
        r5.put("aid", Long.valueOf(this.o));
        r5.put("effect_id", this.p);
        r5.put("effect_source_id", this.q);
        r5.put("effect_file", this.s);
        String r1 = this.v;
        if (r1 == null) goto L5;
        r5.put("icon", r1);
    L5:
        r5.put("file_url_type", Integer.valueOf(this.r));
        r5.put("file_md5", this.t);
        r5.put("icon_url_type", Integer.valueOf(this.u));
        String r2 = this.w;
        if (r2 == null) goto L8;
        r5.put("effect_description", r2);
    L8:
        Map<String, Object> r3 = this.x;
        if (r3 == null) goto L11;
        r5.putAll(r3);
    L11:
        StringBuilder r4 = new StringBuilder();
        r4.append(this.n.E);
        this.n.getClass();
        r4.append("/effect/api/customized/add");
        return new NetRequest(r4.toString(), null, HTTPMethod.POST, null, r5, "application/json", false, null, 202, null);
    }

    public final int i() {
        return this.n.q;
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (AddCustomizedEffectResponse) r2.a.convertJsonToObj(r3, AddCustomizedEffectResponse.class);
    }

    public final void k(String r2, String r3, ExceptionResult r4) {
        r4.setTrackParams(r2, this.n.E, r3);
        super.k(r2, r3, r4);
    }

    public a(EffectConfig r9, long r10, String r12, String r13, int r14, String r15, String r16, int r17, String r18, String r19, String r20, Map<String, ? extends Object> r21) {
        super((INetworkClient) r9.u.a, r9.t, r9.N, r20, r9.P);
        this.n = r9;
        this.o = r10;
        this.p = r12;
        this.q = r13;
        this.r = r14;
        this.s = r15;
        this.t = r16;
        this.u = r17;
        this.v = r18;
        this.w = r19;
        this.x = r21;
    }
}
