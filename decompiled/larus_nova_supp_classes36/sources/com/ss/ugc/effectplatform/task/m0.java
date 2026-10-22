package com.ss.ugc.effectplatform.task;

import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.io.file.IOException;
import bytekn.foundation.logger.Logger;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.ByteReadStream;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.CategoryEffectModel;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.PanelInfoModel;
import com.ss.ugc.effectplatform.model.net.PanelInfoCheckedResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m0 extends BaseNetworkTask<PanelInfoModel, PanelInfoCheckedResponse> {
    public PanelInfoCheckedResponse n;
    public final a0.b<Long> o;
    public final EffectConfig p;
    public final String q;
    public final boolean r;
    public final String s;
    public final int t;
    public final int u;
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
        HashMap r1 = com.ss.ugc.effectplatform.util.g.b(this.p, 6);
        r1.put("panel", this.q);
        EffectConfig r2 = this.p;
        com.ss.ugc.effectplatform.cache.j r3 = (com.ss.ugc.effectplatform.cache.j) r2.A.a;
        PanelInfoCheckedResponse r4 = null;
        if (r3 == null) goto L5;
        int r5 = com.ss.ugc.effectplatform.util.f.a;
        bytekn.foundation.io.file.b r6 = r3.queryToStream(com.ss.ugc.effectplatform.util.f.f(r2.e, this.q, this.r, this.s, this.u, this.t));
    L6:
        if (r6 != null) goto L53;
    L26:
        this.n = r4;
        if (r4 == null) goto L34;
        PanelInfoModel r7 = r4.getData();
        if (r7 == null) goto L34;
        String r8 = r7.getVersion();
        if (r8 == null) goto L34;
        r1.put("version", r8);
    L34:
        if (this.r == false) goto L40;
        r1.put("has_category_effects", String.valueOf(true));
        String r9 = this.s;
        if (r9 != null) goto L39;
        r9 = LocationHitPoint$ResultType.DEFAULT;
    L39:
        r1.put("category", r9);
        r1.put("cursor", String.valueOf(this.u));
        r1.put("count", String.valueOf(this.t));
    L40:
        String r10 = this.p.C;
        if (r10 == null) goto L43;
        r1.put("test_status", r10);
    L43:
        Map<String, String> r11 = this.v;
        if (r11 == null) goto L46;
        r1.putAll(r11);
    L46:
        HTTPMethod r12 = HTTPMethod.GET;
        int r13 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r14 = new StringBuilder();
        r14.append(this.p.E);
        this.p.getClass();
        r14.append("/effect/api/panel/tryGetInfo");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r14.toString()), null, r12, null, null, null, false, null, 250, null);
    L53:
        String r15 = FileManager.a;     // Catch: Throwable -> L14
        String r16 = FileManager.h(r6);     // Catch: Throwable -> L14
        dlc.a r17 = this.p.t;     // Catch: Throwable -> L14
        if (r17 == null) goto L12;
        PanelInfoCheckedResponse r18 = (PanelInfoCheckedResponse) r17.a.convertJsonToObj(r16, PanelInfoCheckedResponse.class);     // Catch: Throwable -> L14
    L13:
        FileManager.b(r6);
    L17:
        if (r18 == null) goto L26;
        if (r18.checkValue() == false) goto L26;
        if (this.p.P == true) goto L23;
    L25:
        r4 = r18;
        goto L26
    L23:
        if (r18.verifySign() == true) goto L25;
    L12:
        r18 = null;
    L14:
        th = move-exception;
        Logger.e$default(Logger.INSTANCE, "FetchPanelInfoCheckedTask", "Json Parse Exception: " + th, null, 4, null);     // Catch: Throwable -> L48
        String r19 = FileManager.a;
        FileManager.b(r6);
        r18 = null;
    L48:
        th = move-exception;
        String r20 = FileManager.a;
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
        return (PanelInfoCheckedResponse) r2.a.convertJsonToObj(r3, PanelInfoCheckedResponse.class);
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (PanelInfoCheckedResponse) r2.a.convertJsonToObj(r3, PanelInfoCheckedResponse.class);
    }

    public final void k(String r8, String r9, ExceptionResult r10) {
        Logger.e$default(Logger.INSTANCE, "FetchPanelInfoCheckedTask", "Failed: " + r10, null, 4, null);
        r10.setTrackParams(r8, this.p.E, r9);
        super.k(r8, r9, r10);
        EffectConfig r4 = this.p;
        klc.a r1 = (klc.a) r4.v.a;
        if (r1 == null) goto L6;
        klc.b.b(r1, false, "panel_checked", r4, MapsKt.mapOf(new Pair[]{TuplesKt.to("log_id", ((BaseNetworkTask) this).g), TuplesKt.to("panel", this.q), TuplesKt.to("error_code", Integer.valueOf(r10.getErrorCode()))}), r10.getMsg());
        return;
    }

    public final void l(long r18, long r20, long r22, com.ss.ugc.effectplatform.model.e r24) {
        PanelInfoCheckedResponse r8 = (PanelInfoCheckedResponse) r24;
        String r2 = null;
        if (Intrinsics.areEqual(r8.getUpdated(), Boolean.FALSE) == true) goto L5;
        Logger.INSTANCE.d("FetchPanelInfoCheckedTask", "Suc: load data from server");
        PanelInfoModel r0 = r8.getData();
        if (r0 == null) goto L42;
        CategoryEffectModel r1 = r0.getCategory_effects();
        if (r1 == null) goto L22;
        com.ss.ugc.effectplatform.util.h r3 = com.ss.ugc.effectplatform.util.h.a;
        String r4 = this.p.i;
        String r5 = this.q;
        List<Effect> r6 = r1.getCategory_effects();
        r3.getClass();
        com.ss.ugc.effectplatform.util.h.d(r4, r5, r6);
        com.ss.ugc.effectplatform.util.h.d(this.p.i, this.q, r1.getCollection());
        com.ss.ugc.effectplatform.util.h.d(this.p.i, this.q, r1.getBind_effects());
        if (this.p.s != 2) goto L22;
        com.ss.ugc.effectplatform.util.h.h(r0.getUrl_prefix(), r1.getCategory_effects());
        com.ss.ugc.effectplatform.util.h.h(r0.getUrl_prefix(), r1.getCollection());
        com.ss.ugc.effectplatform.util.h.h(r0.getUrl_prefix(), r1.getBind_effects());
        PanelInfoModel.Extra r7 = r0.getExtra();
        if (r7 == null) goto L22;
        String r9 = r7.getRec_id();
        if (r9 == null) goto L22;
        com.ss.ugc.effectplatform.util.h.f(r9, r1.getCategory_effects());
        com.ss.ugc.effectplatform.util.h.f(r9, r1.getCollection());
        com.ss.ugc.effectplatform.util.h.f(r9, r1.getBind_effects());
    L22:
        int r10 = com.ss.ugc.effectplatform.util.f.a;
        String r11 = com.ss.ugc.effectplatform.util.f.f(this.p.e, this.q, this.r, this.s, this.u, this.t);
        dlc.a r12 = this.p.t;     // Catch: Exception -> L33
        if (r12 == null) goto L26;
        r2 = r12.a.convertObjToJson(r8);     // Catch: Exception -> L33
    L26:
        if (r2 == null) goto L35;
        a0.b<Long> r13 = this.o;     // Catch: Exception -> L33
        com.ss.ugc.effectplatform.cache.j r14 = (com.ss.ugc.effectplatform.cache.j) this.p.A.a;     // Catch: Exception -> L33
        if (r14 == null) goto L30;
        long r15 = r14.save(r11, r2);     // Catch: Exception -> L33
    L31:
        int r16 = elc.a.a;     // Catch: Exception -> L33
        r13.a = Long.valueOf(r15 / ((long) 1024));     // Catch: Exception -> L33
        goto L35
    L30:
        r15 = 0;
    L35:
        super.l(r18, r20, r22, r8);
    L36:
        int r17 = b0.a.a;
        long r19 = System.currentTimeMillis();
        EffectConfig r21 = this.p;
        klc.a r23 = (klc.a) r21.v.a;
        if (r23 == null) goto L43;
        klc.b.c(r23, "panel_checked", r21, MapsKt.mapOf(new Pair[]{TuplesKt.to("log_id", ((BaseNetworkTask) this).g), TuplesKt.to("panel", this.q), TuplesKt.to("duration", Long.valueOf(r19 - r18)), TuplesKt.to("network_time", Long.valueOf(r20 - r18)), TuplesKt.to("json_time", Long.valueOf(r22 - r20)), TuplesKt.to("io_time", Long.valueOf(r19 - r22)), TuplesKt.to("size", this.o.a)}));
        return;
    L43:
        return;
    L33:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "NewFetchPanelInfoTask", "Exception: " + e, null, 4, null);
        goto L35
    L42:
        return;
    L5:
        if (this.n == null) goto L10;
        Logger.INSTANCE.d("FetchPanelInfoCheckedTask", "Suc: load data from cache");
        PanelInfoCheckedResponse r25 = this.n;
        if (r25 != null) goto L9;
        Intrinsics.throwNpe();
    L9:
        super.l(r18, r20, r22, r25);
        goto L36
    L10:
        Logger.e$default(Logger.INSTANCE, "FetchPanelInfoCheckedTask", "Failed: Local Data dismiss", null, 4, null);
        super.k(null, null, new ExceptionResult(10012, new IOException("Local Data dismiss")));
        goto L36
    }

    public m0(EffectConfig r10, String r11, String r12, boolean r13, String r14, int r15, int r16, Map<String, String> r17) {
        super((INetworkClient) r10.u.a, r10.t, r10.N, r12, r10.P, r10);
        this.p = r10;
        this.q = r11;
        this.r = r13;
        this.s = r14;
        this.t = r15;
        this.u = r16;
        this.v = r17;
        this.o = new a0.b(0L);
    }
}
