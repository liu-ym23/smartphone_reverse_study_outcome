package com.ss.ugc.effectplatform.task;

import bytekn.foundation.logger.Logger;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.ByteReadStream;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import com.ss.ugc.effectplatform.exception.JsonException;
import com.ss.ugc.effectplatform.exception.NetException;
import com.ss.ugc.effectplatform.exception.StatusCodeException;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i0 extends BaseNetworkTask<FetchHotEffectResponse, FetchHotEffectResponse> {
    public final EffectConfig n;
    public final int o;
    public final int p;
    public final Map<String, String> q;

    public static final class a {
    }

    static {
    }

    public final void a() {
        int r0 = b0.a.a;
        long r10 = System.currentTimeMillis();
        long r3 = 0;
        String r5 = null;
        String r6 = null;
        String r14 = null;
        long r1 = 0;
        int r2 = 1;
    L3:
        int r15 = r2 - 1;
        if (r2 == 0) goto L109;
    L70:
        e = e;
        boolean r12 = false;
    L72:
        String r16 = r5;
    L73:
        Exception r8 = e;
        String r17 = r6;
        long r7 = r3;
        long r4 = r1;
    L74:
        if (r15 == 0) goto L80;
        if ((r8 instanceof StatusCodeException) == true) goto L80;
        r1 = r4;
        r3 = r7;
        r5 = r16;
        r6 = r17;
    L79:
        r2 = r15;
    L80:
        ExceptionResult r9 = new ExceptionResult(r8);
        int r11 = b0.a.a;
        long r13 = System.currentTimeMillis();
        EffectConfig r18 = this.n;
        klc.a r19 = (klc.a) r18.v.a;
        if (r19 == null) goto L84;
        Pair[] r110 = new Pair[3];
        r110[r12 ? 1 : 0] = TuplesKt.to("log_id", ((BaseNetworkTask) this).g);
        r110[1] = TuplesKt.to("duration", Long.valueOf(r13 - r10));
        r110[2] = TuplesKt.to("error_code", Integer.valueOf(r9.getErrorCode()));
        klc.b.h(r19, r12, r18, MapsKt.mapOf(r110), r9.getMsg());
    L84:
        com.ss.ugc.effectplatform.cache.j r20 = (com.ss.ugc.effectplatform.cache.j) this.n.A.a;
        if (r20 == null) goto L87;
        int r21 = com.ss.ugc.effectplatform.util.f.a;
        String r22 = r20.queryToValue("effectgalleryhot");
    L88:
        if (r22 != null) goto L124;
    L96:
        FetchHotEffectResponse r23 = null;
    L97:
        if (r23 != null) goto L99;
    L102:
        k(null, null, r9);
    L103:
        Logger r24 = Logger.INSTANCE;
        String r25 = r8.getMessage();
        if (r25 != null) goto L107;
        r25 = "";
    L107:
        Logger.e$default(r24, "FetchHotEffectListTask", r25, null, 4, null);
        return;
    L99:
        if (r23.checkValue() == false) goto L102;
        r23.setFromCache(true);
        q(r10, r4, r7, r23);
        goto L103
    L124:
        dlc.a r26 = this.n.t;     // Catch: Exception -> L94
        if (r26 == null) goto L96;
        r23 = (FetchHotEffectResponse) r26.a.convertJsonToObj(r22, FetchHotEffectResponse.class);     // Catch: Exception -> L94
    L94:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "FetchHotEffectListTask", "Json Exception: " + e, null, 4, null);
        goto L96
    L87:
        r22 = null;
        goto L88
    L7:
        if (((BaseTask) this).b == true) goto L8;
        NetRequest r27 = f();     // Catch: Exception -> L70
        r16 = r27.getUrl();     // Catch: Exception -> L70
        r17 = bytekn.foundation.utils.e.a(r16);     // Catch: Exception -> L68
        INetworkClient r28 = (INetworkClient) this.n.u.a;     // Catch: Exception -> L65
        if (r28 == null) goto L60;
        NetResponse r29 = r28.fetchFromNetwork(r27);     // Catch: Exception -> L65
        if (r29 == null) goto L60;
        int r30 = b0.a.a;     // Catch: Exception -> L65
        long r111 = System.currentTimeMillis();     // Catch: Exception -> L65
        String r31 = com.ss.ugc.effectplatform.extension.c.a(r29.getBodyStream());     // Catch: Exception -> L52
        if (r31.length() != 0) goto L19;
        boolean r32 = true;
    L121:
        if (r32 == true) goto L57;
        dlc.a r33 = this.n.t;     // Catch: Exception -> L52
        if (r33 == null) goto L55;
        FetchHotEffectResponse r34 = (FetchHotEffectResponse) r33.a.convertJsonToObj(r31, FetchHotEffectResponse.class);     // Catch: Exception -> L52
        if (r34 == null) goto L51;
        long r210 = System.currentTimeMillis();     // Catch: Exception -> L52
    L46:
        e = e;
        r12 = false;
    L48:
        r8 = e;
        r4 = r111;
        r7 = r210;
        goto L74
    L27:
        if (r34.getStatusCode() != 0) goto L43;
        if (r34.checkValue() == false) goto L116;
        if (this.n.P == true) goto L36;
        q(r10, r111, r210, r34);     // Catch: Exception -> L44
        return;
    L36:
        if (r34.verifySign() == false) goto L40;
        q(r10, r111, r210, r34);     // Catch: Exception -> L44
        return;
    L40:
        throw new IllegalArgumentException("verify failed");     // Catch: Exception -> L44
    L116:
        r12 = false;
        r14 = r34.getResponseMessage();     // Catch: Exception -> L44
        r5 = r16;
        r6 = r17;
        r1 = r111;
        r3 = r210;
    L44:
        e = e;
        goto L48
    L43:
        throw new StatusCodeException(r34.getStatusCode(), r34.getResponseMessage());     // Catch: Exception -> L44
    L51:
        throw new JsonException("json parser returned null!");     // Catch: Exception -> L58
    L55:
        throw new RuntimeException("json converter is null");     // Catch: Exception -> L58
    L57:
        throw new NetException(-2, "net response returned empty response!");     // Catch: Exception -> L58
    L58:
        e = e;
    L59:
        r8 = e;
        r7 = r3;
        r4 = r111;
        goto L74
    L19:
        r32 = false;
    L52:
        e = e;
        r12 = false;
    L60:
        r12 = false;
    L63:
        e = e;
    L67:
        r6 = r17;
        goto L73
    L62:
        throw new NetException(-2, "net response returned null!");     // Catch: Exception -> L63
    L65:
        e = e;
        r12 = false;
    L68:
        e = e;
        r12 = false;
        r5 = r16;
        goto L72
    L8:
        return;
    L109:
        ExceptionResult r35 = new ExceptionResult(10002);
        if (r14 == null) goto L112;
        r35.setMsg(r14);
    L112:
        k(r5, r6, r35);
    }

    public final NetRequest f() {
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        HashMap r1 = com.ss.ugc.effectplatform.util.g.b(this.n, 6);
        r1.put("cursor", String.valueOf(this.p));
        r1.put("count", String.valueOf(this.o));
        r1.put("panel", LocationHitPoint$ResultType.DEFAULT);
        Map<String, String> r2 = this.q;
        if (r2 == null) goto L5;
        r1.putAll(r2);
    L5:
        int r3 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r4 = new StringBuilder();
        r4.append(this.n.E);
        this.n.getClass();
        r4.append("/effect/api/hoteffects");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r4.toString()), null, null, null, null, null, false, null, 254, null);
    }

    public final com.ss.ugc.effectplatform.model.e o(dlc.a r2, ByteReadStream r3) {
        return (FetchHotEffectResponse) r2.a.convertJsonToObj(r3, FetchHotEffectResponse.class);
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (FetchHotEffectResponse) r2.a.convertJsonToObj(r3, FetchHotEffectResponse.class);
    }

    public final /* bridge */ /* synthetic */ void l(long r1, long r3, long r5, com.ss.ugc.effectplatform.model.e r7) {
        q(r1, r3, r5, (FetchHotEffectResponse) r7);
    }

    public final void q(long r18, long r20, long r22, FetchHotEffectResponse r24) {
        int r0 = b0.a.a;
        long r2 = System.currentTimeMillis();
        List<Effect> r1 = r24.getEffect_list();
        if (r1 == null) goto L8;
        Iterator<T> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        Effect r4 = (Effect) r3.next();
        r4.setId(StringsKt.replace$default(StringsKt.replace$default(r4.getId(), "\"", "_", false, 4, null), "/", "_", false, 4, null));
    L8:
        List<Effect> r5 = r24.getCollection_list();
        if (r5 == null) goto L14;
        Iterator<T> r6 = r5.iterator();
    L12:
        if (r6.hasNext() == false) goto L14;
        Effect r7 = (Effect) r6.next();
        r7.setId(StringsKt.replace$default(StringsKt.replace$default(r7.getId(), "\"", "_", false, 4, null), "/", "_", false, 4, null));
    L14:
        com.ss.ugc.effectplatform.util.h r8 = com.ss.ugc.effectplatform.util.h.a;
        String r9 = this.n.i;
        List<Effect> r10 = r24.getEffect_list();
        r8.getClass();
        com.ss.ugc.effectplatform.util.h.e(r9, r10);
        com.ss.ugc.effectplatform.util.h.e(this.n.i, r24.getCollection_list());
        com.ss.ugc.effectplatform.util.h.h(r24.getUrlPrefix(), r24.getEffect_list());
        com.ss.ugc.effectplatform.util.h.h(r24.getUrlPrefix(), r24.getCollection_list());
        com.ss.ugc.effectplatform.util.h.f(r24.getRecId(), r24.getEffect_list());
        com.ss.ugc.effectplatform.util.h.f(r24.getRecId(), r24.getCollection_list());
        EffectConfig r11 = this.n;
        klc.a r12 = (klc.a) r11.v.a;
        if (r12 == null) goto L17;
        klc.b.h(r12, true, r11, MapsKt.mapOf(new Pair[]{TuplesKt.to("log_id", ((BaseNetworkTask) this).g), TuplesKt.to("duration", Long.valueOf(r2 - r18)), TuplesKt.to("network_time", Long.valueOf(r20 - r18)), TuplesKt.to("json_time", Long.valueOf(r22 - r20))}), "");
    L17:
        super.l(r18, r20, r22, r24);
        int r13 = com.ss.ugc.effectplatform.util.f.a;
        dlc.a r14 = this.n.t;     // Catch: Throwable -> L29 Exception -> L31
        if (r14 == null) goto L21;
        String r15 = r14.a.convertObjToJson(r24);     // Catch: Throwable -> L29 Exception -> L31
    L22:
        if (r15 == null) goto L40;
        com.ss.ugc.effectplatform.cache.j r16 = (com.ss.ugc.effectplatform.cache.j) this.n.A.a;     // Catch: Throwable -> L29 Exception -> L31
        if (r16 == null) goto L26;
        long r17 = r16.save("effectgalleryhot", r15);     // Catch: Throwable -> L29 Exception -> L31
    L27:
        int r19 = elc.a.a;     // Catch: Throwable -> L29 Exception -> L31
        long r21 = r17 / ((long) 1024);     // Catch: Throwable -> L29 Exception -> L31
    L41:
        return;
    L26:
        r17 = 0;
        goto L27
    L40:
        return;
    L21:
        r15 = null;
    L31:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "FetchHotEffectListTask", "saveHotEffectList: " + e, null, 4, null);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;
    }

    public i0(EffectConfig r9, int r10, int r11, String r12, Map<String, String> r13) {
        super((INetworkClient) r9.u.a, r9.t, r9.N, r12, r9.P, r9);
        this.n = r9;
        this.o = r10;
        this.p = r11;
        this.q = r13;
    }
}
