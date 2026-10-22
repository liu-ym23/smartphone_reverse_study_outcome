package com.ss.ugc.effectplatform.task;

import bytekn.foundation.io.file.FileManager;
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
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m1 extends BaseNetworkTask<ProviderEffectModel, ProviderEffectListResponse> {
    public final EffectConfig n;
    public final String o;
    public final String p;
    public final int q;
    public final int r;
    public final String s;

    public static final class a {
    }

    static {
    }

    public final NetRequest f() {
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        HashMap r1 = com.ss.ugc.effectplatform.util.g.b(this.n, 6);
        String r2 = this.p;
        if (r2 == null) goto L5;
        r1.put("library", r2);
    L5:
        String r3 = this.o;
        if (r3 == null) goto L8;
        r1.put("word", r3);
    L8:
        r1.put("cursor", String.valueOf(this.q));
        r1.put("count", String.valueOf(this.r));
        String r4 = this.s;
        if (r4 != null) goto L11;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == true) goto L17;
        r1.put("giphy_type", this.s);
    L17:
        int r6 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r7 = new StringBuilder();
        r7.append(this.n.E);
        this.n.getClass();
        r7.append("/effect/api/stickers/search");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r7.toString()), null, HTTPMethod.GET, null, null, null, false, null, 250, null);
    L11:
        if (StringsKt.isBlank(r4) == true) goto L14;
        r5 = false;
        goto L15
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (ProviderEffectListResponse) r2.a.convertJsonToObj(r3, ProviderEffectListResponse.class);
    }

    public final void k(String r2, String r3, ExceptionResult r4) {
        r4.setTrackParams(r2, this.n.E, r3);
        super.k(r2, r3, r4);
    }

    public final void l(long r9, long r11, long r13, com.ss.ugc.effectplatform.model.e r15) {
        ProviderEffectListResponse r7 = (ProviderEffectListResponse) r15;
        ProviderEffectModel r16 = r7.getData();
        if (r16 == null) goto L13;
        List<ProviderEffect> r17 = r16.getSticker_list();
        if (r17 == null) goto L14;
        Iterator<ProviderEffect> r18 = r17.iterator();
    L8:
        if (r18.hasNext() == false) goto L10;
        ProviderEffect r0 = r18.next();
        r0.setPath(this.n.i + FileManager.a + r0.getId() + ".gif");
        goto L8
    L10:
        super.l(r9, r11, r13, r7);
        return;
    L14:
        return;
    }

    public m1(EffectConfig r8, String r9, String r10, String r11, int r12, int r13, String r14) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r9, r8.P);
        this.n = r8;
        this.o = r10;
        this.p = r11;
        this.q = r12;
        this.r = r13;
        this.s = r14;
    }
}
