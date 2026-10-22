package com.ss.ugc.effectplatform.task;

import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.io.file.IOException;
import bytekn.foundation.logger.Logger;
import com.ss.android.lark.keyboard.plugin.tool.face.Conf$StickerSetManagerPosition;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.ByteReadStream;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.CategoryEffectModel;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.PanelInfoModel;
import com.ss.ugc.effectplatform.model.net.PanelInfoCheckedResponse;
import com.ss.ugc.effectplatform.model.net.PanelInfoPagingCheckedResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n0 extends BaseNetworkTask<PanelInfoModel, PanelInfoPagingCheckedResponse> {
    public PanelInfoPagingCheckedResponse n;
    public final a0.b<Long> o;
    public final EffectConfig p;
    public final String q;
    public final String r;
    public final int s;
    public final int t;
    public final int u;
    public final String v;
    public final Map<String, String> w;

    public static final class a {
    }

    static {
    }

    public final int h() {
        return 10002;
    }

    public final NetRequest f() {
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        HashMap r1 = com.ss.ugc.effectplatform.util.g.b(this.p, 6);
        r1.put("panel", this.q);
        EffectConfig r2 = this.p;
        com.ss.ugc.effectplatform.cache.j r3 = (com.ss.ugc.effectplatform.cache.j) r2.A.a;
        PanelInfoPagingCheckedResponse r4 = null;
        if (r3 == null) goto L5;
        int r5 = com.ss.ugc.effectplatform.util.f.a;
        bytekn.foundation.io.file.b r6 = r3.queryToStream(com.ss.ugc.effectplatform.util.f.h(r2.e, this.q, this.r, this.t, this.s, this.u, this.v));
    L6:
        if (r6 != null) goto L56;
    L26:
        this.n = r4;
        if (r4 == null) goto L35;
        PanelInfoCheckedResponse r7 = r4.getPanelInfoResponse();
        if (r7 == null) goto L35;
        PanelInfoModel r8 = r7.getData();
        if (r8 == null) goto L35;
        String r9 = r8.getVersion();
        if (r9 == null) goto L35;
        r1.put("panel_version", r9);
    L35:
        String r10 = this.r;
        if (r10 != null) goto L39;
        r10 = "all";
    L39:
        r1.put("category", r10);
        r1.put("cursor", String.valueOf(this.t));
        r1.put("count", String.valueOf(this.s));
        r1.put("sorting_position", String.valueOf(this.u));
        String r11 = this.v;
        if (r11 != null) goto L43;
        r11 = "0";
    L43:
        r1.put("version", r11);
        String r12 = this.p.C;
        if (r12 == null) goto L46;
        r1.put("test_status", r12);
    L46:
        Map<String, String> r13 = this.w;
        if (r13 == null) goto L49;
        r1.putAll(r13);
    L49:
        r1.remove("is_on_success_current_thread");
        HTTPMethod r14 = HTTPMethod.GET;
        int r15 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r16 = new StringBuilder();
        r16.append(this.p.E);
        this.p.getClass();
        r16.append("/effect/api/panel/infoAndCategoryEffectsPaged");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r16.toString()), null, r14, null, null, null, false, null, 250, null);
    L56:
        String r17 = FileManager.a;     // Catch: Throwable -> L14
        String r18 = FileManager.h(r6);     // Catch: Throwable -> L14
        dlc.a r19 = this.p.t;     // Catch: Throwable -> L14
        if (r19 == null) goto L12;
        PanelInfoPagingCheckedResponse r20 = (PanelInfoPagingCheckedResponse) r19.a.convertJsonToObj(r18, PanelInfoPagingCheckedResponse.class);     // Catch: Throwable -> L14
    L13:
        FileManager.b(r6);
    L17:
        if (r20 == null) goto L26;
        if (r20.checkValue() == false) goto L26;
        if (this.p.P == true) goto L23;
    L25:
        r4 = r20;
        goto L26
    L23:
        if (r20.verifySign() == true) goto L25;
    L12:
        r20 = null;
    L14:
        th = move-exception;
        Logger.e$default(Logger.INSTANCE, "FetchPanelInfoPagingCheckedTask", "Json Parse Exception: " + th, null, 4, null);     // Catch: Throwable -> L51
        String r21 = FileManager.a;
        FileManager.b(r6);
        r20 = null;
    L51:
        th = move-exception;
        String r22 = FileManager.a;
        FileManager.b(r6);
        throw th;
    L5:
        r6 = null;
        goto L6
    }

    public final int i() {
        return this.p.q;
    }

    public final com.ss.ugc.effectplatform.model.e o(dlc.a r2, ByteReadStream r3) {
        return (PanelInfoPagingCheckedResponse) r2.a.convertJsonToObj(r3, PanelInfoPagingCheckedResponse.class);
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (PanelInfoPagingCheckedResponse) r2.a.convertJsonToObj(r3, PanelInfoPagingCheckedResponse.class);
    }

    public final void k(String r8, String r9, ExceptionResult r10) {
        r10.setTrackParams(r8, this.p.E, r9);
        super.k(r8, r9, r10);
        EffectConfig r4 = this.p;
        klc.a r1 = (klc.a) r4.v.a;
        if (r1 == null) goto L6;
        klc.b.b(r1, false, "panel_paged", r4, MapsKt.mapOf(new Pair[]{TuplesKt.to("log_id", ((BaseNetworkTask) this).g), TuplesKt.to("panel", this.q), TuplesKt.to("error_code", Integer.valueOf(r10.getErrorCode()))}), r10.getMsg());
        return;
    }

    public final void l(long r19, long r21, long r23, com.ss.ugc.effectplatform.model.e r25) {
        PanelInfoPagingCheckedResponse r8 = (PanelInfoPagingCheckedResponse) r25;
        PanelInfoCheckedResponse r0 = r8.getPanelInfoResponse();
        String r1 = null;
        if (r0 == null) goto L5;
        Boolean r2 = r0.getUpdated();
    L7:
        if (Intrinsics.areEqual(r2, Boolean.FALSE) == true) goto L9;
        Logger.INSTANCE.d("FetchPanelInfoPagingCheckedTask", "Suc: load data from server");
        PanelInfoModel r3 = r8.getResponseData();
        if (r3 == null) goto L60;
        CategoryEffectModel r4 = r3.getCategory_effects();
        if (r4 == null) goto L52;
        com.ss.ugc.effectplatform.util.h r5 = com.ss.ugc.effectplatform.util.h.a;
        String r6 = this.p.i;
        String r7 = this.q;
        List<Effect> r9 = r4.getCategory_effects();
        r5.getClass();
        com.ss.ugc.effectplatform.util.h.d(r6, r7, r9);
        com.ss.ugc.effectplatform.util.h.d(this.p.i, this.q, r4.getCollection());
        com.ss.ugc.effectplatform.util.h.d(this.p.i, this.q, r4.getBind_effects());
        if (this.p.s != 2) goto L26;
        com.ss.ugc.effectplatform.util.h.h(r3.getUrl_prefix(), r4.getCategory_effects());
        com.ss.ugc.effectplatform.util.h.h(r3.getUrl_prefix(), r4.getCollection());
        com.ss.ugc.effectplatform.util.h.h(r3.getUrl_prefix(), r4.getBind_effects());
        PanelInfoModel.Extra r10 = r3.getExtra();
        if (r10 == null) goto L26;
        String r11 = r10.getRec_id();
        if (r11 == null) goto L26;
        com.ss.ugc.effectplatform.util.h.f(r11, r4.getCategory_effects());
        com.ss.ugc.effectplatform.util.h.f(r11, r4.getCollection());
        com.ss.ugc.effectplatform.util.h.f(r11, r4.getBind_effects());
    L26:
        int r12 = com.ss.ugc.effectplatform.util.f.a;
        String r13 = com.ss.ugc.effectplatform.util.f.h(this.p.e, this.q, this.r, this.t, this.s, this.u, this.v);
        dlc.a r14 = this.p.t;     // Catch: Exception -> L37
        if (r14 == null) goto L30;
        r1 = r14.a.convertObjToJson(r8);     // Catch: Exception -> L37
    L30:
        if (r1 == null) goto L39;
        a0.b<Long> r15 = this.o;     // Catch: Exception -> L37
        com.ss.ugc.effectplatform.cache.j r16 = (com.ss.ugc.effectplatform.cache.j) this.p.A.a;     // Catch: Exception -> L37
        if (r16 == null) goto L34;
        long r17 = r16.save(r13, r1);     // Catch: Exception -> L37
    L35:
        int r18 = elc.a.a;     // Catch: Exception -> L37
        r15.a = Long.valueOf(r17 / ((long) 1024));     // Catch: Exception -> L37
        goto L39
    L34:
        r17 = 0;
    L39:
        Map<String, String> r20 = this.w;
        if (r20 != null) goto L42;
    L51:
        super.l(r19, r21, r23, r8);
        goto L52
    L42:
        if (Intrinsics.areEqual(r20.get("is_on_success_current_thread"), Conf$StickerSetManagerPosition.STICKER_SET_CHAT_PANEL) == false) goto L51;
        Object r22 = r8.m1545getResponseData();
        if (r22 == null) goto L52;
        String r24 = ((BaseNetworkTask) this).k;
        if (r24 == null) goto L52;
        IEffectPlatformBaseListener r26 = ((BaseNetworkTask) this).j.a(r24);
        if (r26 == null) goto L50;
        r26.onSuccess(r22);
    L50:
        ((BaseNetworkTask) this).j.c(((BaseNetworkTask) this).k);
    L37:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "NewFetchPanelInfoTask", "Exception: " + e, null, 4, null);
    L52:
        int r27 = b0.a.a;
        long r28 = System.currentTimeMillis();
        EffectConfig r29 = this.p;
        klc.a r30 = (klc.a) r29.v.a;
        if (r30 == null) goto L61;
        klc.b.c(r30, "panel_paged", r29, MapsKt.mapOf(new Pair[]{TuplesKt.to("log_id", ((BaseNetworkTask) this).g), TuplesKt.to("panel", this.q), TuplesKt.to("duration", Long.valueOf(r28 - r19)), TuplesKt.to("network_time", Long.valueOf(r21 - r19)), TuplesKt.to("json_time", Long.valueOf(r23 - r21)), TuplesKt.to("io_time", Long.valueOf(r28 - r23)), TuplesKt.to("size", this.o.a)}));
        return;
    L61:
        return;
    L60:
        return;
    L9:
        if (this.n == null) goto L14;
        Logger.INSTANCE.d("FetchPanelInfoPagingCheckedTask", "Suc: load data from cache");
        PanelInfoPagingCheckedResponse r31 = this.n;
        if (r31 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        super.l(r19, r21, r23, r31);
        return;
    L14:
        Logger.e$default(Logger.INSTANCE, "FetchPanelInfoPagingCheckedTask", "Failed: Local Data dismiss", null, 4, null);
        super.k(null, null, new ExceptionResult(10012, new IOException("Local Data dismiss")));
        return;
    L5:
        r2 = null;
        goto L7
    }

    public n0(EffectConfig r10, String r11, String r12, String r13, int r14, int r15, int r16, String r17, Map<String, String> r18) {
        super((INetworkClient) r10.u.a, r10.t, r10.N, r12, r10.P, r10);
        this.p = r10;
        this.q = r11;
        this.r = r13;
        this.s = r14;
        this.t = r15;
        this.u = r16;
        this.v = r17;
        this.w = r18;
        this.o = new a0.b(0L);
    }
}
