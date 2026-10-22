package com.ss.ugc.effectplatform.task;

import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.net.CategoryEffect;
import com.ss.ugc.effectplatform.model.net.CategoryEffectsWithThemeData;
import com.ss.ugc.effectplatform.model.net.CategoryEffectsWithThemeResponse;
import com.ss.ugc.effectplatform.model.net.EffectWithVideoURL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c0 extends BaseNetworkTask<CategoryEffectsWithThemeData, CategoryEffectsWithThemeResponse> {
    public final EffectConfig n;
    public final String o;
    public final String p;
    public final String q;
    public final Integer r;
    public final Map<String, String> s;

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
        r1.put("category", this.p);
        String r2 = this.q;
        if (r2 == null) goto L5;
        r1.put("spec_category", r2);
    L5:
        Integer r3 = this.r;
        if (r3 == null) goto L8;
        r1.put("need_personal_recommend", String.valueOf(r3.intValue()));
    L8:
        String r4 = this.n.C;
        if (r4 == null) goto L11;
        r1.put("test_status", r4);
    L11:
        Map<String, String> r5 = this.s;
        if (r5 == null) goto L14;
        r1.putAll(r5);
    L14:
        HTTPMethod r6 = HTTPMethod.GET;
        int r7 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r8 = new StringBuilder();
        r8.append(this.n.E);
        this.n.getClass();
        r8.append("/effect/api/category/effects/theme");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r8.toString()), null, r6, null, null, null, false, null, 250, null);
    }

    public final int i() {
        return this.n.q;
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (CategoryEffectsWithThemeResponse) r2.a.convertJsonToObj(r3, CategoryEffectsWithThemeResponse.class);
    }

    public final void k(String r7, String r8, ExceptionResult r9) {
        Logger.e$default(Logger.INSTANCE, "FetchPanelInfoWithOneEffectTask", "Failed: " + r9, null, 4, null);
        super.k(r7, r8, r9);
    }

    public final void l(long r9, long r11, long r13, com.ss.ugc.effectplatform.model.e r15) {
        CategoryEffectsWithThemeResponse r7 = (CategoryEffectsWithThemeResponse) r15;
        CategoryEffectsWithThemeData r16 = r7.getData();
        List<String> r0 = null;
        if (r16 == null) goto L5;
        CategoryEffect r17 = r16.category_effects_theme;
    L6:
        if (r17 == null) goto L53;
        ArrayList r1 = new ArrayList();
        List<? extends Effect> r2 = r17.bind_effects;
        if (r2 == null) goto L10;
        r1.addAll(r2);
    L10:
        List<? extends Effect> r3 = r17.collection;
        if (r3 == null) goto L13;
        r1.addAll(r3);
    L13:
        EffectWithVideoURL r4 = r17.effect_with_video_url;
        if (r4 == null) goto L18;
        Effect r5 = r4.effect;
        if (r5 == null) goto L18;
        r1.add(r5);
    L18:
        List<EffectWithVideoURL> r6 = r17.effect_with_video_url_list;
        if (r6 == null) goto L26;
        Iterator<T> r8 = r6.iterator();
    L22:
        if (r8.hasNext() == false) goto L26;
        Effect r10 = ((EffectWithVideoURL) r8.next()).effect;
        if (r10 == null) goto L22;
        r1.add(r10);
    L26:
        Effect r18 = r17.effects;
        if (r18 == null) goto L29;
        r1.add(r18);
    L29:
        com.ss.ugc.effectplatform.util.h r19 = com.ss.ugc.effectplatform.util.h.a;
        String r12 = this.n.i;
        String r14 = this.o;
        r19.getClass();
        com.ss.ugc.effectplatform.util.h.d(r12, r14, r1);
        if (this.n.s != 2) goto L46;
        CategoryEffectsWithThemeData r110 = r7.getData();
        if (r110 == null) goto L34;
        r0 = r110.url_prefix;
    L34:
        List<String> r20 = r0;
        if (r20 != null) goto L37;
    L40:
        boolean r111 = true;
    L41:
        if (r111 == true) goto L46;
        CategoryEffectsWithThemeData r112 = r7.getData();
        if (r112 != null) goto L45;
        Intrinsics.throwNpe();
    L45:
        com.ss.ugc.effectplatform.util.h.h(r112.url_prefix, r1);
        goto L46
    L37:
        if (r20.isEmpty() == true) goto L40;
        r111 = false;
    L46:
        super.l(r9, r11, r13, r7);
        return;
    L53:
        return;
    L5:
        r17 = null;
        goto L6
    }

    public c0(EffectConfig r8, String r9, String r10, String r11, String r12, Integer r13, Map<String, String> r14) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r11, r8.P);
        this.n = r8;
        this.o = r9;
        this.p = r10;
        this.q = r12;
        this.r = r13;
        this.s = r14;
    }
}
