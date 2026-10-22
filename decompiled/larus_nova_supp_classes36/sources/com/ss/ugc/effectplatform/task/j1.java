package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.net.InfoStickerEffect;
import com.ss.ugc.effectplatform.model.net.InfoStickerListModel;
import com.ss.ugc.effectplatform.model.net.InfoStickerListResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j1 extends BaseNetworkTask<InfoStickerListResponse, InfoStickerListResponse> {
    public final EffectConfig n;
    public final int o;
    public final String p;
    public final String q;
    public final Integer r;
    public final Integer s;
    public final String t;
    public final Map<String, String> u;

    public final NetRequest f() {
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        HashMap r1 = com.ss.ugc.effectplatform.util.g.b(this.n, 6);
        r1.put("creation_id", this.p);
        r1.put("source", String.valueOf(this.o));
        r1.put("image_uri", this.q);
        Integer r2 = this.r;
        if (r2 == null) goto L5;
        r1.put("count", String.valueOf(r2.intValue()));
    L5:
        Integer r3 = this.s;
        if (r3 == null) goto L8;
        r1.put("cursor", String.valueOf(r3.intValue()));
    L8:
        String r4 = this.t;
        if (r4 == null) goto L11;
        r1.put("library", r4);
    L11:
        Map<String, String> r5 = this.u;
        if (r5 != null) goto L14;
    L17:
        boolean r6 = true;
    L18:
        if (r6 == true) goto L20;
        r1.putAll(this.u);
    L20:
        HTTPMethod r7 = HTTPMethod.GET;
        int r8 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r9 = new StringBuilder();
        r9.append(this.n.E);
        this.n.getClass();
        r9.append("/effect/api/sticker/recommend");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r9.toString()), null, r7, null, null, null, false, null, 250, null);
    L14:
        if (r5.isEmpty() == true) goto L17;
        r6 = false;
        goto L18
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (InfoStickerListResponse) r2.a.convertJsonToObj(r3, InfoStickerListResponse.class);
    }

    public final void l(long r9, long r11, long r13, com.ss.ugc.effectplatform.model.e r15) {
        InfoStickerListResponse r7 = (InfoStickerListResponse) r15;
        com.ss.ugc.effectplatform.util.h r16 = com.ss.ugc.effectplatform.util.h.a;
        String r0 = this.n.i;
        InfoStickerListModel r1 = r7.getData();
        if (r1 == null) goto L5;
        List<InfoStickerEffect> r2 = r1.getSticker_list();
    L6:
        r16.getClass();
        com.ss.ugc.effectplatform.util.h.g(r0, r2);
        super.l(r9, r11, r13, r7);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public j1(EffectConfig r9, int r10, String r11, String r12, Integer r13, Integer r14, String r15, Map<String, String> r16, String r17) {
        super((INetworkClient) r9.u.a, r9.t, r9.N, r17, r9.P);
        this.n = r9;
        this.o = r10;
        this.p = r11;
        this.q = r12;
        this.r = r13;
        this.s = r14;
        this.t = r15;
        this.u = r16;
    }
}
