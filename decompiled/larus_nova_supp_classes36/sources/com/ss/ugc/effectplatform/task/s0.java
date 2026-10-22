package com.ss.ugc.effectplatform.task;

import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.ProviderEffect;
import com.ss.ugc.effectplatform.model.ProviderEffectModel;
import com.ss.ugc.effectplatform.model.net.ProviderEffectListResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class s0 extends BaseNetworkTask<ProviderEffectModel, ProviderEffectListResponse> {
    public final EffectConfig n;
    public final String o;
    public final int p;
    public final int q;
    public final String r;
    public final Map<String, String> s;

    public static final class a {
    }

    static {
    }

    public final NetRequest f() {
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        HashMap r1 = com.ss.ugc.effectplatform.util.g.b(this.n, 6);
        String r2 = this.o;
        if (r2 == null) goto L5;
        r1.put("library", r2);
    L5:
        r1.put("cursor", String.valueOf(this.p));
        r1.put("count", String.valueOf(this.q));
        String r3 = this.r;
        if (r3 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == true) goto L14;
        r1.put("giphy_type", this.r);
    L14:
        Map<String, String> r5 = this.s;
        if (r5 == null) goto L17;
        r1.putAll(r5);
    L17:
        int r6 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r7 = new StringBuilder();
        r7.append(this.n.E);
        this.n.getClass();
        r7.append("/effect/api/stickers/recommend");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r7.toString()), null, HTTPMethod.GET, null, null, null, false, null, 250, null);
    L8:
        if (StringsKt.isBlank(r3) == true) goto L11;
        r4 = false;
        goto L12
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (ProviderEffectListResponse) r2.a.convertJsonToObj(r3, ProviderEffectListResponse.class);
    }

    public final void k(String r2, String r3, ExceptionResult r4) {
        r4.setTrackParams(null, null, null);
        super.k(r2, r3, r4);
    }

    public final void l(long r9, long r11, long r13, com.ss.ugc.effectplatform.model.e r15) {
        ProviderEffectListResponse r7 = (ProviderEffectListResponse) r15;
        ProviderEffectModel r16 = r7.getData();
        if (r16 != null) goto L5;
        return;
    L5:
        if (r16.getSticker_list() == null) goto L26;
        List<ProviderEffect> r0 = r16.getSticker_list();
        if (r0 == null) goto L26;
        Iterator<ProviderEffect> r1 = r0.iterator();
    L11:
        if (r1.hasNext() == false) goto L26;
        ProviderEffect r2 = r1.next();
        r2.setPath(this.n.i + FileManager.a + r2.getId() + ".gif");
    L26:
        int r3 = com.ss.ugc.effectplatform.util.f.a;     // Catch: Exception -> L22
        String r4 = com.ss.ugc.effectplatform.util.f.k(this.n.e, this.o);     // Catch: Exception -> L22
        dlc.a r5 = this.n.t;     // Catch: Exception -> L22
        if (r5 == null) goto L16;
        String r17 = r5.a.convertObjToJson(r16);     // Catch: Exception -> L22
    L17:
        if (r17 == null) goto L24;
        com.ss.ugc.effectplatform.cache.j r6 = (com.ss.ugc.effectplatform.cache.j) this.n.A.a;     // Catch: Exception -> L22
        if (r6 == null) goto L24;
        r6.save(r4, r17);     // Catch: Exception -> L22
    L24:
        super.l(r9, r11, r13, r7);
        return;
    L16:
        r17 = null;
    L22:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "FetchProviderEffectTask", String.valueOf(e), null, 4, null);
        goto L24
    }

    public s0(EffectConfig r8, String r9, String r10, int r11, int r12, String r13, Map<String, String> r14) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r9, r8.P);
        this.n = r8;
        this.o = r10;
        this.p = r11;
        this.q = r12;
        this.r = r13;
        this.s = r14;
    }
}
