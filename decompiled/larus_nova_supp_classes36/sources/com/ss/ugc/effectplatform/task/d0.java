package com.ss.ugc.effectplatform.task;

import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.ByteReadStream;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.CategoryInfoResponse;
import com.ss.ugc.effectplatform.model.EffectCategoryModelList;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d0 extends BaseNetworkTask<EffectCategoryModelList, CategoryInfoResponse> {
    public final a0.b<Long> n;
    public final EffectConfig o;
    public final String p;
    public final List<Integer> q;
    public final Map<String, String> r;

    public static final class a {
    }

    static {
    }

    public final int h() {
        return 10002;
    }

    public final NetRequest f() {
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        HashMap r1 = com.ss.ugc.effectplatform.util.g.b(this.o, 6);
        r1.put("panel", this.p);
        dlc.a r2 = this.o.t;
        if (r2 == null) goto L7;
        List<Integer> r3 = this.q;
        String r4 = r2.a.convertObjToJson(r3);
        if (r4 == null) goto L7;
        r1.put("category_ids", r4);
    L7:
        Map<String, String> r5 = this.r;
        if (r5 == null) goto L10;
        r1.putAll(r5);
    L10:
        HTTPMethod r6 = HTTPMethod.GET;
        int r7 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r8 = new StringBuilder();
        r8.append(this.o.E);
        this.o.getClass();
        r8.append("/effect/api/category/info");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r8.toString()), null, r6, null, null, null, false, null, 250, null);
    }

    public final int i() {
        return this.o.q;
    }

    public final com.ss.ugc.effectplatform.model.e o(dlc.a r2, ByteReadStream r3) {
        return (CategoryInfoResponse) r2.a.convertJsonToObj(r3, CategoryInfoResponse.class);
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (CategoryInfoResponse) r2.a.convertJsonToObj(r3, CategoryInfoResponse.class);
    }

    public final void k(String r8, String r9, ExceptionResult r10) {
        Logger.e$default(Logger.INSTANCE, "FetchCategoryInfoTask", "Failed: " + r10, null, 4, null);
        r10.setTrackParams(r8, this.o.E, r9);
        super.k(r8, r9, r10);
        EffectConfig r4 = this.o;
        klc.a r1 = (klc.a) r4.v.a;
        if (r1 == null) goto L6;
        klc.b.b(r1, false, "category_info", r4, MapsKt.mapOf(new Pair[]{TuplesKt.to("log_id", ((BaseNetworkTask) this).g), TuplesKt.to("panel", this.p), TuplesKt.to("error_code", Integer.valueOf(r10.getErrorCode()))}), r10.getMsg());
        return;
    }

    public d0(EffectConfig r8, String r9, String r10, List<Integer> r11, Map<String, String> r12) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r10, r8.P);
        this.o = r8;
        this.p = r9;
        this.q = r11;
        this.r = r12;
        this.n = new a0.b(0L);
    }

    public final void m(long r14, long r16, long r18, String r20, com.ss.ugc.effectplatform.model.e r21) {
        CategoryInfoResponse r8 = (CategoryInfoResponse) r21;
        if (r8.getData() == null) goto L34;
        int r0 = com.ss.ugc.effectplatform.util.f.a;
        String r1 = com.ss.ugc.effectplatform.util.f.b(this.o.e, this.p, this.q);
    L27:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "NewFetchPanelInfoTask", "Exception: " + e, null, 4, null);
    L29:
        l(r14, r16, r18, r8);
        int r2 = b0.a.a;
        long r3 = System.currentTimeMillis();
        EffectConfig r4 = this.o;
        klc.a r5 = (klc.a) r4.v.a;
        if (r5 == null) goto L35;
        klc.b.c(r5, "category_info", r4, MapsKt.mapOf(new Pair[]{TuplesKt.to("log_id", ((BaseNetworkTask) this).g), TuplesKt.to("panel", this.p), TuplesKt.to("duration", Long.valueOf(r3 - r14)), TuplesKt.to("network_time", Long.valueOf(r16 - r14)), TuplesKt.to("json_time", Long.valueOf(r18 - r16)), TuplesKt.to("io_time", Long.valueOf(r3 - r18)), TuplesKt.to("size", this.n)}));
        return;
    L35:
        return;
    L6:
        if (r20.length() <= 0) goto L8;
        boolean r6 = true;
    L9:
        long r7 = 0;
        if (r6 == false) goto L17;
        EffectConfig r9 = this.o;     // Catch: Exception -> L27
        if (r9.W != 2) goto L17;
        a0.b<Long> r10 = this.n;     // Catch: Exception -> L27
        com.ss.ugc.effectplatform.cache.j r11 = (com.ss.ugc.effectplatform.cache.j) r9.A.a;     // Catch: Exception -> L27
        if (r11 == null) goto L16;
        r7 = r11.save(r1, r20);     // Catch: Exception -> L27
    L16:
        int r12 = elc.a.a;     // Catch: Exception -> L27
        r10.a = Long.valueOf(r7 / ((long) 1024));     // Catch: Exception -> L27
    L17:
        dlc.a r13 = this.o.t;     // Catch: Exception -> L27
        if (r13 == null) goto L20;
        String r15 = r13.a.convertObjToJson(r8);     // Catch: Exception -> L27
    L21:
        if (r15 == null) goto L29;
        a0.b<Long> r17 = this.n;     // Catch: Exception -> L27
        com.ss.ugc.effectplatform.cache.j r19 = (com.ss.ugc.effectplatform.cache.j) this.o.A.a;     // Catch: Exception -> L27
        if (r19 == null) goto L25;
        r7 = r19.save(r1, r15);     // Catch: Exception -> L27
    L25:
        int r22 = elc.a.a;     // Catch: Exception -> L27
        r17.a = Long.valueOf(r7 / ((long) 1024));     // Catch: Exception -> L27
        goto L29
    L20:
        r15 = null;
        goto L21
    L8:
        r6 = false;
        goto L9
    }
}
