package com.ss.ugc.effectplatform.task;

import com.ss.android.lark.keyboard.plugin.tool.face.Conf$StickerSetManagerPosition;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.net.EffectListPreloadResponse;
import com.ss.ugc.effectplatform.model.net.PreloadDataModel;
import com.ss.ugc.effectplatform.model.net.PreloadedEffectsRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class z0 extends BaseNetworkTask<EffectListPreloadResponse, EffectListPreloadResponse> {
    public final EffectConfig n;
    public final boolean o;

    public final int h() {
        return 10014;
    }

    public final NetRequest f() {
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        boolean r2 = false;
        HashMap r1 = com.ss.ugc.effectplatform.util.g.a(this.n, false, this.o);
        com.ss.ugc.effectplatform.cache.j r3 = (com.ss.ugc.effectplatform.cache.j) this.n.A.a;
        Object r4 = null;
        if (r3 == null) goto L5;
        String r5 = r3.queryToValue("preloaded_effects");
    L6:
        ArrayList r6 = new ArrayList();
        ArrayList r7 = new ArrayList();
        if (r5 != null) goto L9;
    L10:
        r2 = true;
    L11:
        if (r2 == true) goto L52;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L18
        dlc.a r9 = this.n.t;     // Catch: Throwable -> L18
        if (r9 == null) goto L15;
        PreloadedEffectsRecord r10 = (PreloadedEffectsRecord) r9.a.convertJsonToObj(r5, JvmClassMappingKt.getJavaClass(Reflection.getOrCreateKotlinClass(PreloadedEffectsRecord.class)));     // Catch: Throwable -> L18
    L16:
        Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L18
    L21:
        if (Result.isFailure-impl(r11) == true) goto L24;
        r4 = r11;
    L24:
        PreloadedEffectsRecord r12 = (PreloadedEffectsRecord) r4;
        if (r12 == null) goto L38;
        List<PreloadDataModel> r13 = r12.getEffect_list();
        if (r13 == null) goto L38;
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r13.iterator();
    L30:
        if (r15.hasNext() == false) goto L34;
        Object r16 = r15.next();
        if ((!StringsKt.isBlank(((PreloadDataModel) r16).getMd5())) == false) goto L30;
        r14.add(r16);
        goto L30
    L34:
        Iterator r17 = r14.iterator();
    L36:
        if (r17.hasNext() == false) goto L38;
        r6.add(((PreloadDataModel) r17.next()).getMd5());
    L38:
        if (r12 == null) goto L52;
        List<PreloadDataModel> r18 = r12.getModel_list();
        if (r18 == null) goto L52;
        ArrayList r19 = new ArrayList();
        Iterator<T> r20 = r18.iterator();
    L43:
        if (r20.hasNext() == false) goto L47;
        Object r21 = r20.next();
        if ((!StringsKt.isBlank(((PreloadDataModel) r21).getMd5())) == false) goto L43;
        r19.add(r21);
        goto L43
    L47:
        Iterator r22 = r19.iterator();
    L49:
        if (r22.hasNext() == false) goto L52;
        r7.add(((PreloadDataModel) r22.next()).getMd5());
        goto L49
    L15:
        r10 = null;
    L18:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L52:
        if ((!r6.isEmpty()) == false) goto L59;
        dlc.a r24 = this.n.t;
        if (r24 == null) goto L59;
        String r25 = r24.a.convertObjToJson(r6);
        if (r25 == null) goto L59;
        r1.put("preloaded_effects", r25);
    L59:
        if ((!r7.isEmpty()) == false) goto L66;
        dlc.a r26 = this.n.t;
        if (r26 == null) goto L66;
        String r27 = r26.a.convertObjToJson(r7);
        if (r27 == null) goto L66;
        r1.put("preloaded_models", r27);
    L66:
        if (this.n.V == false) goto L68;
        String r28 = Conf$StickerSetManagerPosition.STICKER_SET_CHAT_PANEL;
    L69:
        r1.put("model_mapping", r28);
        int r29 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r30 = new StringBuilder();
        r30.append(this.n.E);
        this.n.getClass();
        r30.append("/effect/api/v3/effect/preload");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r30.toString()), null, HTTPMethod.GET, null, null, null, false, null, 250, null);
    L68:
        r28 = "0";
        goto L69
    L9:
        if (StringsKt.isBlank(r5) == false) goto L11;
    L5:
        r5 = null;
        goto L6
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (EffectListPreloadResponse) r2.a.convertJsonToObj(r3, EffectListPreloadResponse.class);
    }

    public z0(EffectConfig r8, String r9, boolean r10) {
        super((INetworkClient) r8.u.a, r8.t, r8.N, r9, r8.P);
        this.n = r8;
        this.o = r10;
    }

    public final void l(long r22, long r24, long r26, com.ss.ugc.effectplatform.model.e r28) {
        EffectListPreloadResponse r7 = (EffectListPreloadResponse) r28;
        List<Effect> r0 = r7.getData();
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        Effect r2 = (Effect) r1.next();
        r2.setId(StringsKt.replace$default(StringsKt.replace$default(r2.getId(), "\"", "_", false, 4, null), "/", "_", false, 4, null));
    L8:
        List<Effect> r3 = r7.getCollection();
        if (r3 == null) goto L14;
        Iterator<T> r4 = r3.iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        Effect r5 = (Effect) r4.next();
        r5.setId(StringsKt.replace$default(StringsKt.replace$default(r5.getId(), "\"", "_", false, 4, null), "/", "_", false, 4, null));
    L14:
        List<Effect> r6 = r7.getBind_effects();
        if (r6 == null) goto L20;
        Iterator<T> r8 = r6.iterator();
    L18:
        if (r8.hasNext() == false) goto L20;
        Effect r9 = (Effect) r8.next();
        r9.setId(StringsKt.replace$default(StringsKt.replace$default(r9.getId(), "\"", "_", false, 4, null), "/", "_", false, 4, null));
    L20:
        com.ss.ugc.effectplatform.util.h r10 = com.ss.ugc.effectplatform.util.h.a;
        List<String> r11 = r7.getUrl_prefix();
        List<Effect> r12 = r7.getData();
        r10.getClass();
        com.ss.ugc.effectplatform.util.h.h(r11, r12);
        com.ss.ugc.effectplatform.util.h.h(r7.getUrl_prefix(), r7.getCollection());
        com.ss.ugc.effectplatform.util.h.h(r7.getUrl_prefix(), r7.getBind_effects());
        com.ss.ugc.effectplatform.util.h.e(this.n.i, r7.getData());
        com.ss.ugc.effectplatform.util.h.e(this.n.i, r7.getCollection());
        com.ss.ugc.effectplatform.util.h.e(this.n.i, r7.getBind_effects());
        super.l(r22, r24, r26, r7);
    }
}
