package com.ss.ugc.effectplatform.task;

import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.ByteReadStream;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.CategoryEffectModel;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.PanelInfoModel;
import com.ss.ugc.effectplatform.model.net.PanelInfoPagingResponse;
import com.ss.ugc.effectplatform.model.net.PanelInfoResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class o0 extends BaseNetworkTask<PanelInfoModel, PanelInfoPagingResponse> {
    public final a0.b<Long> n;
    public final EffectConfig o;
    public final String p;
    public final String q;
    public final int r;
    public final int s;
    public final int t;
    public final String u;
    public final Map<String, String> v;

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
        String r2 = this.q;
        if (r2 != null) goto L6;
        r2 = "all";
    L6:
        r1.put("category", r2);
        r1.put("cursor", String.valueOf(this.s));
        r1.put("count", String.valueOf(this.r));
        r1.put("sorting_position", String.valueOf(this.t));
        String r3 = this.u;
        if (r3 != null) goto L10;
        r3 = "0";
    L10:
        r1.put("version", r3);
        String r4 = this.o.C;
        if (r4 == null) goto L13;
        r1.put("test_status", r4);
    L13:
        Map<String, String> r5 = this.v;
        if (r5 == null) goto L16;
        r1.putAll(r5);
    L16:
        HTTPMethod r6 = HTTPMethod.GET;
        int r7 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r8 = new StringBuilder();
        r8.append(this.o.E);
        this.o.getClass();
        r8.append("/effect/api/panel/infoAndCategoryEffectsPaged");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r8.toString()), null, r6, null, null, null, false, null, 250, null);
    }

    public final int i() {
        return this.o.q;
    }

    public final com.ss.ugc.effectplatform.model.e o(dlc.a r2, ByteReadStream r3) {
        return (PanelInfoPagingResponse) r2.a.convertJsonToObj(r3, PanelInfoPagingResponse.class);
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (PanelInfoPagingResponse) r2.a.convertJsonToObj(r3, PanelInfoPagingResponse.class);
    }

    public final void k(String r8, String r9, ExceptionResult r10) {
        r10.setTrackParams(r8, this.o.E, r9);
        super.k(r8, r9, r10);
        EffectConfig r4 = this.o;
        klc.a r1 = (klc.a) r4.v.a;
        if (r1 == null) goto L6;
        klc.b.b(r1, false, "panel_paged", r4, MapsKt.mapOf(new Pair[]{TuplesKt.to("log_id", ((BaseNetworkTask) this).g), TuplesKt.to("panel", this.p), TuplesKt.to("error_code", Integer.valueOf(r10.getErrorCode()))}), r10.getMsg());
        return;
    }

    public final void l(long r19, long r21, long r23, com.ss.ugc.effectplatform.model.e r25) {
        PanelInfoPagingResponse r8 = (PanelInfoPagingResponse) r25;
        PanelInfoModel r0 = r8.getResponseData();
        if (r0 == null) goto L51;
        CategoryEffectModel r1 = r0.getCategory_effects();
        if (r1 == null) goto L13;
        com.ss.ugc.effectplatform.util.h r2 = com.ss.ugc.effectplatform.util.h.a;
        String r3 = this.o.i;
        String r4 = this.p;
        List<Effect> r5 = r1.getCategory_effects();
        r2.getClass();
        com.ss.ugc.effectplatform.util.h.d(r3, r4, r5);
        com.ss.ugc.effectplatform.util.h.d(this.o.i, this.p, r1.getCollection());
        com.ss.ugc.effectplatform.util.h.d(this.o.i, this.p, r1.getBind_effects());
        if (this.o.s != 2) goto L13;
        com.ss.ugc.effectplatform.util.h.h(r0.getUrl_prefix(), r1.getCategory_effects());
        com.ss.ugc.effectplatform.util.h.h(r0.getUrl_prefix(), r1.getCollection());
        com.ss.ugc.effectplatform.util.h.h(r0.getUrl_prefix(), r1.getBind_effects());
        PanelInfoModel.Extra r6 = r0.getExtra();
        if (r6 == null) goto L13;
        String r7 = r6.getRec_id();
        if (r7 == null) goto L13;
        com.ss.ugc.effectplatform.util.h.f(r7, r1.getCategory_effects());
        com.ss.ugc.effectplatform.util.h.f(r7, r1.getCollection());
        com.ss.ugc.effectplatform.util.h.f(r7, r1.getBind_effects());
    L13:
        PanelInfoResponse r9 = r8.getPanelInfoResponse();
        if (r9 == null) goto L43;
        int r10 = com.ss.ugc.effectplatform.util.f.a;
        String r11 = com.ss.ugc.effectplatform.util.f.i(this.o.e, this.p, this.q, this.s, this.r, this.t, this.u);
        String r12 = null;
        dlc.a r13 = this.o.t;     // Catch: Exception -> L27
        if (r13 == null) goto L19;
        String r14 = r13.a.convertObjToJson(r9);     // Catch: Exception -> L27
    L20:
        if (r14 == null) goto L49;
        a0.b<Long> r15 = this.n;     // Catch: Exception -> L27
        com.ss.ugc.effectplatform.cache.j r16 = (com.ss.ugc.effectplatform.cache.j) this.o.A.a;     // Catch: Exception -> L27
        if (r16 == null) goto L24;
        long r17 = r16.save(r11, r14);     // Catch: Exception -> L27
    L25:
        int r18 = elc.a.a;     // Catch: Exception -> L27
        r15.a = Long.valueOf(r17 / ((long) 1024));     // Catch: Exception -> L27
        goto L49
    L24:
        r17 = 0;
    L49:
        PanelInfoModel r20 = r9.getResponseData();     // Catch: Exception -> L41
        if (r20 == null) goto L32;
        String r22 = r20.getVersion();     // Catch: Exception -> L41
    L33:
        FetchPanelInfoTask.Version r24 = new FetchPanelInfoTask.Version(r22);     // Catch: Exception -> L41
        dlc.a r26 = this.o.t;     // Catch: Exception -> L41
        if (r26 == null) goto L36;
        r12 = r26.a.convertObjToJson(r24);     // Catch: Exception -> L41
    L36:
        if (r12 == null) goto L43;
        com.ss.ugc.effectplatform.cache.j r27 = (com.ss.ugc.effectplatform.cache.j) this.o.A.a;     // Catch: Exception -> L41
        if (r27 == null) goto L43;
        int r28 = com.ss.ugc.effectplatform.util.f.a;     // Catch: Exception -> L41
        r27.save(com.ss.ugc.effectplatform.util.f.j(this.p), r12);     // Catch: Exception -> L41
        goto L43
    L32:
        r22 = null;
    L41:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "FetchPanelInfoPagingTask", "Json Exception: " + e, null, 4, null);
        goto L43
    L19:
        r14 = null;
    L27:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "NewFetchPanelInfoTask", "Exception: " + e, null, 4, null);
    L43:
        super.l(r19, r21, r23, r8);
        int r29 = b0.a.a;
        long r30 = System.currentTimeMillis();
        EffectConfig r31 = this.o;
        klc.a r32 = (klc.a) r31.v.a;
        if (r32 == null) goto L52;
        klc.b.c(r32, "panel_paged", r31, MapsKt.mapOf(new Pair[]{TuplesKt.to("log_id", ((BaseNetworkTask) this).g), TuplesKt.to("panel", this.p), TuplesKt.to("duration", Long.valueOf(r30 - r19)), TuplesKt.to("network_time", Long.valueOf(r21 - r19)), TuplesKt.to("json_time", Long.valueOf(r23 - r21)), TuplesKt.to("io_time", Long.valueOf(r30 - r23)), TuplesKt.to("size", this.n.a)}));
        return;
    L52:
        return;
    }

    public o0(EffectConfig r10, String r11, String r12, String r13, int r14, int r15, int r16, String r17, Map<String, String> r18) {
        super((INetworkClient) r10.u.a, r10.t, r10.N, r12, r10.P, r10);
        this.o = r10;
        this.p = r11;
        this.q = r13;
        this.r = r14;
        this.s = r15;
        this.t = r16;
        this.u = r17;
        this.v = r18;
        this.n = new a0.b(0L);
    }
}
