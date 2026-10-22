package com.ss.ugc.effectplatform.task;

import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.net.CategoryEffect;
import com.ss.ugc.effectplatform.model.net.PanelInfoWithOneEffectData;
import com.ss.ugc.effectplatform.model.net.PanelInfoWithOneEffectResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class p0 extends BaseNetworkTask<PanelInfoWithOneEffectData, PanelInfoWithOneEffectResponse> {
    public final EffectConfig n;
    public final String o;
    public final String p;
    public final Integer q;
    public final Map<String, String> r;
    public final boolean s;

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
        r1.put("panel", this.o);
        String r2 = this.p;
        if (r2 == null) goto L5;
        r1.put("spec_category", r2);
    L5:
        Integer r3 = this.q;
        if (r3 == null) goto L8;
        r1.put("need_personal_recommend", String.valueOf(r3.intValue()));
    L8:
        String r4 = this.n.C;
        if (r4 == null) goto L11;
        r1.put("test_status", r4);
    L11:
        Map<String, String> r5 = this.r;
        if (r5 == null) goto L14;
        r1.putAll(r5);
    L14:
        HTTPMethod r6 = HTTPMethod.GET;
        int r7 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r8 = new StringBuilder();
        r8.append(this.n.E);
        this.n.getClass();
        r8.append("/effect/api");
        if (this.s == false) goto L17;
        String r9 = "/panel/info/theme";
    L18:
        r8.append(r9);
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r8.toString()), null, r6, null, null, null, false, null, 250, null);
    L17:
        r9 = "/panel/info/one";
        goto L18
    }

    public final int i() {
        return this.n.q;
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (PanelInfoWithOneEffectResponse) r2.a.convertJsonToObj(r3, PanelInfoWithOneEffectResponse.class);
    }

    public final void k(String r7, String r8, ExceptionResult r9) {
        Logger.e$default(Logger.INSTANCE, "FetchPanelInfoWithOneEffectTask", "Failed: " + r9, null, 4, null);
        super.k(r7, r8, r9);
    }

    public final void l(long r9, long r11, long r13, com.ss.ugc.effectplatform.model.e r15) {
        PanelInfoWithOneEffectResponse r7 = (PanelInfoWithOneEffectResponse) r15;
        PanelInfoWithOneEffectData r16 = r7.getData();
        if (r16 == null) goto L34;
        ArrayList r0 = new ArrayList();
        Effect r1 = r16.front_effect;
        if (r1 == null) goto L7;
        r0.add(r1);
    L7:
        Effect r2 = r16.rear_effect;
        if (r2 == null) goto L10;
        r0.add(r2);
    L10:
        List<CategoryEffect> r3 = r16.category_effect_list;
        if (r3 == null) goto L24;
        Iterator<T> r4 = r3.iterator();
    L14:
        if (r4.hasNext() == false) goto L24;
        CategoryEffect r5 = (CategoryEffect) r4.next();
        List<? extends Effect> r6 = r5.bind_effects;
        if (r6 == null) goto L18;
        r0.addAll(r6);
    L18:
        List<? extends Effect> r8 = r5.collection;
        if (r8 == null) goto L21;
        r0.addAll(r8);
    L21:
        Effect r10 = r5.effects;
        if (r10 == null) goto L14;
        r0.add(r10);
    L24:
        com.ss.ugc.effectplatform.util.h r12 = com.ss.ugc.effectplatform.util.h.a;
        String r14 = this.n.i;
        String r17 = this.o;
        r12.getClass();
        com.ss.ugc.effectplatform.util.h.d(r14, r17, r0);
        if (this.n.s != 2) goto L27;
        com.ss.ugc.effectplatform.util.h.h(r16.url_prefix, r0);
    L27:
        super.l(r9, r11, r13, r7);
        return;
    }

    public p0(EffectConfig r8, String r9, String r10, String r11, Integer r12, Map<String, String> r13, boolean r14) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r10, r8.P);
        this.n = r8;
        this.o = r9;
        this.p = r11;
        this.q = r12;
        this.r = r13;
        this.s = r14;
    }
}
