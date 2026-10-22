package com.ss.ugc.effectplatform.task;

import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.CheckUpdateVersionModel;
import com.ss.ugc.effectplatform.model.net.InfoStickerEffect;
import com.ss.ugc.effectplatform.model.net.QueryInfoStickerListModel;
import com.ss.ugc.effectplatform.model.net.QueryInfoStickerResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e1 extends BaseNetworkTask<QueryInfoStickerResponse, QueryInfoStickerResponse> {
    public final EffectConfig n;
    public final String o;
    public final Integer p;
    public final Integer q;
    public final Map<String, String> r;

    public static final class a {
    }

    static {
    }

    public final NetRequest f() {
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        HashMap r1 = com.ss.ugc.effectplatform.util.g.b(this.n, 6);
        r1.put("panel", this.o);
        Integer r2 = this.p;
        if (r2 == null) goto L5;
        r1.put("count", String.valueOf(r2.intValue()));
    L5:
        Integer r3 = this.q;
        if (r3 == null) goto L8;
        r1.put("cursor", String.valueOf(r3.intValue()));
    L8:
        Map<String, String> r4 = this.r;
        if (r4 != null) goto L11;
    L13:
        HTTPMethod r5 = HTTPMethod.GET;
        int r6 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r7 = new StringBuilder();
        r7.append(this.n.E);
        this.n.getClass();
        r7.append("/effect/api/sticker/list");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r7.toString()), null, r5, null, null, null, false, null, 250, null);
    L11:
        if ((!r4.isEmpty()) == false) goto L13;
        r1.putAll(this.r);
        goto L13
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (QueryInfoStickerResponse) r2.a.convertJsonToObj(r3, QueryInfoStickerResponse.class);
    }

    public final void l(long r9, long r11, long r13, com.ss.ugc.effectplatform.model.e r15) {
        QueryInfoStickerResponse r7 = (QueryInfoStickerResponse) r15;
        QueryInfoStickerListModel r16 = r7.getData();
        List<InfoStickerEffect> r0 = null;
        if (r16 == null) goto L5;
        String r17 = r16.getVersion();
    L6:
        if (r17 == null) goto L32;
        int r18 = com.ss.ugc.effectplatform.util.f.a;
        String r19 = com.ss.ugc.effectplatform.util.f.e(this.n.e, this.o, this.p, this.q);
        dlc.a r1 = this.n.t;     // Catch: Exception -> L30
        if (r1 == null) goto L12;
        String r2 = r1.a.convertObjToJson(r7);     // Catch: Exception -> L30
    L13:
        if (r2 == null) goto L17;
        com.ss.ugc.effectplatform.cache.j r3 = (com.ss.ugc.effectplatform.cache.j) this.n.A.a;     // Catch: Exception -> L30
        if (r3 == null) goto L17;
        r3.save(r19, r2);     // Catch: Exception -> L30
    L17:
        CheckUpdateVersionModel r110 = new CheckUpdateVersionModel(null, null, null, 7, null);     // Catch: Exception -> L30
        QueryInfoStickerListModel r4 = r7.getData();     // Catch: Exception -> L30
        if (r4 == null) goto L20;
        String r5 = r4.getVersion();     // Catch: Exception -> L30
    L21:
        r110.setVersion(r5);     // Catch: Exception -> L30
        dlc.a r6 = this.n.t;     // Catch: Exception -> L30
        if (r6 == null) goto L24;
        String r111 = r6.a.convertObjToJson(r110);     // Catch: Exception -> L30
    L25:
        if (r111 == null) goto L32;
        com.ss.ugc.effectplatform.cache.j r8 = (com.ss.ugc.effectplatform.cache.j) this.n.A.a;     // Catch: Exception -> L30
        if (r8 == null) goto L32;
        r8.save(this.o + FileManager.a + "info_sticker_version", r111);     // Catch: Exception -> L30
        goto L32
    L24:
        r111 = null;
        goto L25
    L20:
        r5 = null;
        goto L21
    L12:
        r2 = null;
    L30:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "QueryInfoStickerListTask", "Exception: " + e, null, 4, null);
    L32:
        com.ss.ugc.effectplatform.util.h r112 = com.ss.ugc.effectplatform.util.h.a;
        String r10 = this.n.i;
        QueryInfoStickerListModel r12 = r7.getData();
        if (r12 == null) goto L35;
        List<InfoStickerEffect> r14 = r12.getEffects();
    L36:
        r112.getClass();
        com.ss.ugc.effectplatform.util.h.g(r10, r14);
        String r113 = this.n.i;
        QueryInfoStickerListModel r20 = r7.getData();
        if (r20 == null) goto L39;
        r0 = r20.getCollection();
    L39:
        com.ss.ugc.effectplatform.util.h.g(r113, r0);
        super.l(r9, r11, r13, r7);
        return;
    L35:
        r14 = null;
        goto L36
    L5:
        r17 = null;
        goto L6
    }

    public e1(EffectConfig r8, String r9, Integer r10, Integer r11, Map<String, String> r12, String r13) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r13, r8.P);
        this.n = r8;
        this.o = r9;
        this.p = r10;
        this.q = r11;
        this.r = r12;
    }
}
