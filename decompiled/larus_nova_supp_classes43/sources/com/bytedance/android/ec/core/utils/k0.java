package com.bytedance.android.ec.core.utils;

import com.byted.cast.sink.api.IServerListener;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.retrofit2.SsResponse;
import com.google.gson.Gson;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final di.d b(CommerceBaseResponse r10) {
        Intrinsics.checkNotNullParameter(r10, "baseResponse");
        if (r10.getTtNetExtraInfo() != null) goto L8;
        return null;
    L8:
        return a(com.bytedance.android.ec.hybrid.list.util.k.d(r10.getTtNetExtraInfo()), r10.getEcNetRequestEnd());
    L10:
        return null;
    }

    @JvmStatic
    public static final di.l e(Object r10) {
        if (r10 != null) goto L14;
        return null;
    L14:
        Gson r1 = new Gson();     // Catch: Exception -> L11
        di.l r11 = (di.l) r1.fromJson(com.bytedance.android.ec.hybrid.list.util.k.d(r10), di.l.class);     // Catch: Exception -> L11
        if (r11 == null) goto L8;
        String r12 = r11.f();     // Catch: Exception -> L11
    L9:
        r11.a = (di.m) r1.fromJson(r12, di.m.class);     // Catch: Exception -> L11
        return r11;
    L8:
        r12 = null;
    L11:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    }

    public static di.b f(di.l r20) {
        Intrinsics.checkNotNullParameter(r20, "requestInfo");
        di.m r10 = r20.a;
        if (r10 == null) goto L8;
        di.a r11 = r10.a();
        if (r11 == null) goto L8;
        String r12 = r11.b();
        if (r12 == null) goto L8;
    L9:
        String r13 = UriProtector.parse(r12).getPath();
        di.m r14 = r20.a;
        if (r14 == null) goto L14;
        di.a r15 = r14.a();
        if (r15 == null) goto L14;
        String r16 = r15.a();
    L15:
        di.m r17 = r20.a;
        if (r17 == null) goto L20;
        di.n r18 = r17.d();
        if (r18 == null) goto L20;
        Integer r19 = r18.a();
    L21:
        di.m r21 = r20.a;
        if (r21 == null) goto L26;
        di.n r22 = r21.d();
        if (r22 == null) goto L26;
        Integer r23 = r22.c();
    L27:
        di.m r24 = r20.a;
        if (r24 == null) goto L32;
        di.n r25 = r24.d();
        if (r25 == null) goto L32;
        Integer r26 = r25.d();
    L33:
        di.m r27 = r20.a;
        if (r27 == null) goto L38;
        di.o r28 = r27.e();
        if (r28 == null) goto L38;
        Boolean r29 = r28.a();
    L39:
        Integer r30 = Integer.valueOf(Intrinsics.areEqual(r29, Boolean.TRUE) ? 1 : 0);
        di.m r31 = r20.a;
        if (r31 == null) goto L44;
        di.n r32 = r31.d();
        if (r32 == null) goto L44;
        Integer r110 = r32.b();
    L45:
        di.m r33 = r20.a;
        if (r33 == null) goto L50;
        di.k r34 = r33.c();
        if (r34 == null) goto L50;
        Integer r111 = r34.a();
    L51:
        di.m r35 = r20.a;
        if (r35 == null) goto L56;
        di.k r36 = r35.c();
        if (r36 == null) goto L56;
        String r112 = r36.b();
    L57:
        di.e r37 = r20.c();
        if (r37 == null) goto L60;
        Integer r113 = r37.a();
    L61:
        di.e r38 = r20.c();
        if (r38 == null) goto L64;
        String r114 = r38.b();
    L65:
        di.e r39 = r20.c();
        if (r39 == null) goto L68;
        String r115 = r39.c();
    L69:
        di.m r40 = r20.a;
        if (r40 == null) goto L74;
        di.g r41 = r40.b();
        if (r41 == null) goto L74;
        Integer r116 = r41.a();
    L75:
        di.m r42 = r20.a;
        if (r42 == null) goto L80;
        di.g r43 = r42.b();
        if (r43 == null) goto L80;
        Integer r117 = r43.b();
    L81:
        di.m r44 = r20.a;
        if (r44 == null) goto L86;
        di.g r45 = r44.b();
        if (r45 == null) goto L86;
        Integer r118 = r45.c();
    L87:
        di.m r46 = r20.a;
        if (r46 == null) goto L92;
        di.g r47 = r46.b();
        if (r47 == null) goto L92;
        Integer r119 = r47.e();
    L93:
        di.m r0 = r20.a;
        if (r0 == null) goto L98;
        di.g r1 = r0.b();
        if (r1 == null) goto L98;
        Integer r48 = r1.d();
    L100:
        return new di.b(r13, r16, r19, r23, r26, r30, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r48);
    L98:
        r48 = null;
    L92:
        r119 = null;
    L86:
        r118 = null;
    L80:
        r117 = null;
    L74:
        r116 = null;
        goto L75
    L68:
        r115 = null;
        goto L69
    L64:
        r114 = null;
        goto L65
    L60:
        r113 = null;
    L56:
        r112 = null;
    L50:
        r111 = null;
    L44:
        r110 = null;
    L38:
        r29 = null;
    L32:
        r26 = null;
    L26:
        r23 = null;
    L20:
        r19 = null;
    L14:
        r16 = null;
    L8:
        r12 = "";
        goto L9
    }

    public static JSONObject i(di.d r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$toJSONObject");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L5
        r1.putOpt("path", r10.c.a);     // Catch: Throwable -> L5
        r1.putOpt("method", r10.c.b);     // Catch: Throwable -> L5
        r1.putOpt("code", r10.c.c);     // Catch: Throwable -> L5
        r1.putOpt("socket_reused", r10.c.f);     // Catch: Throwable -> L5
        r1.putOpt("connection_info", r10.c.g);     // Catch: Throwable -> L5
        r1.putOpt("net_thread_priority", r10.c.h);     // Catch: Throwable -> L5
        r1.putOpt("ttnet_version", r10.c.i);     // Catch: Throwable -> L5
        r1.putOpt("priority_level", r10.c.j);     // Catch: Throwable -> L5
        r1.putOpt("request_compress_type", r10.c.k);     // Catch: Throwable -> L5
        r1.putOpt("response_compress_type", r10.c.l);     // Catch: Throwable -> L5
        r1.putOpt("effective_net_type", r10.c.n);     // Catch: Throwable -> L5
        r1.putOpt("real_net_type", r10.c.q);     // Catch: Throwable -> L5
        r1.putOpt("before_stream", r10.a.a);     // Catch: Throwable -> L5
        r1.putOpt("body_recv", r10.a.b);     // Catch: Throwable -> L5
        r1.putOpt("connect_delay", r10.a.c);     // Catch: Throwable -> L5
        r1.putOpt("create_stream", r10.a.d);     // Catch: Throwable -> L5
        r1.putOpt("dispatch", r10.a.e);     // Catch: Throwable -> L5
        r1.putOpt("dns", r10.a.f);     // Catch: Throwable -> L5
        r1.putOpt("edge", r10.a.g);     // Catch: Throwable -> L5
        r1.putOpt("header_recv", r10.a.h);     // Catch: Throwable -> L5
        r1.putOpt("inner", r10.a.i);     // Catch: Throwable -> L5
        r1.putOpt("origin", r10.a.j);     // Catch: Throwable -> L5
        r1.putOpt("proxy", r10.a.k);     // Catch: Throwable -> L5
        r1.putOpt("rtt", r10.a.l);     // Catch: Throwable -> L5
        r1.putOpt("security_callback", r10.a.m);     // Catch: Throwable -> L5
        r1.putOpt("send", r10.a.n);     // Catch: Throwable -> L5
        r1.putOpt("ssl", r10.a.o);     // Catch: Throwable -> L5
        r1.putOpt("tcp", r10.a.p);     // Catch: Throwable -> L5
        r1.putOpt("ttfb", r10.a.q);     // Catch: Throwable -> L5
        r1.putOpt("tt_agw", r10.a.r);     // Catch: Throwable -> L5
        r1.putOpt("pre_request_duration", Long.valueOf(r10.a.s));     // Catch: Throwable -> L5
        r1.putOpt("net_total_duration", r10.a.t);     // Catch: Throwable -> L5
        r1.putOpt("after_request_duration", Long.valueOf(r10.a.u));     // Catch: Throwable -> L5
        r1.putOpt("response_serializer_duration", Long.valueOf(r10.a.v));     // Catch: Throwable -> L5
        r1.putOpt("start_time", r10.b.a);     // Catch: Throwable -> L5
        r1.putOpt("create_stream_start", r10.b.b);     // Catch: Throwable -> L5
        r1.putOpt("create_stream_finish", r10.b.c);     // Catch: Throwable -> L5
        r1.putOpt("request_sent_time", r10.b.d);     // Catch: Throwable -> L5
        r1.putOpt("response_recv_time", r10.b.e);     // Catch: Throwable -> L5
        r1.putOpt("end_time", r10.b.f);     // Catch: Throwable -> L5
        r1.putOpt("ec_net_request_start", r10.b.g);     // Catch: Throwable -> L5
        r1.putOpt("ec_net_request_end", r10.b.h);     // Catch: Throwable -> L5
        r1.putOpt("app_level_request_start", r10.b.i);     // Catch: Throwable -> L5
        r1.putOpt("before_all_interceptors", r10.b.j);     // Catch: Throwable -> L5
        r1.putOpt("received_bytes", r10.c.d);     // Catch: Throwable -> L5
        r1.putOpt("sent_bytes", r10.c.e);     // Catch: Throwable -> L5
        r1.putOpt("downlink_throughput", r10.c.m);     // Catch: Throwable -> L5
        r1.putOpt("http_rtt", r10.c.o);     // Catch: Throwable -> L5
        r1.putOpt("tcp_rtt", r10.c.p);     // Catch: Throwable -> L5
        return r1;
    L5:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return null;
    }

    @JvmStatic
    public static final di.d a(String r10, Long r11) {
        Intrinsics.checkNotNullParameter(r10, "info");
        boolean r1 = false;
        if (r10.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L28;
        return null;
    L28:
        di.l r12 = (di.l) new Gson().fromJson(r10, di.l.class);     // Catch: Exception -> L25
        if (r12 == null) goto L12;
        String r13 = r12.f();     // Catch: Exception -> L25
    L13:
        if (r13 != null) goto L15;
    L16:
        r1 = true;
    L17:
        if (r1 == false) goto L19;
        return null;
    L19:
        Gson r14 = new Gson();     // Catch: Exception -> L25
        if (r12 == null) goto L22;
        String r15 = r12.f();     // Catch: Exception -> L25
    L23:
        r12.a = (di.m) r14.fromJson(r15, di.m.class);     // Catch: Exception -> L25
        return new di.d(g(r12, r11), h(r12, r11), f(r12));
    L22:
        r15 = null;
        goto L23
    L15:
        if (r13.length() != 0) goto L17;
    L12:
        r13 = null;
    L25:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    L5:
        r0 = false;
        goto L7
    }

    @JvmStatic
    public static final di.d c(SsResponse<?> r15, long r16) {
        Intrinsics.checkNotNullParameter(r15, "retrofitResponse");
        if (r15.raw().getExtraInfo() != null) goto L18;
        return null;
    L18:
        di.l r0 = (di.l) new Gson().fromJson(com.bytedance.android.ec.hybrid.list.util.k.d(r15.raw().getExtraInfo()), di.l.class);     // Catch: Exception -> L15
        Gson r1 = new Gson();     // Catch: Exception -> L15
        if (r0 == null) goto L8;
        String r10 = r0.f();     // Catch: Exception -> L15
    L9:
        r0.a = (di.m) r1.fromJson(r10, di.m.class);     // Catch: Exception -> L15
        di.c r11 = g(r0, null);     // Catch: Exception -> L15
        Long r12 = r0.e();     // Catch: Exception -> L15
        if (r12 == null) goto L12;
        long r13 = r16 - r12.longValue();     // Catch: Exception -> L15
    L13:
        r11.u = r13;     // Catch: Exception -> L15
        Unit r14 = Unit.INSTANCE;     // Catch: Exception -> L15
        di.q r17 = h(r0, null);     // Catch: Exception -> L15
        return new di.d(r11, new di.q(r17.a, r17.b, r17.c, r17.d, r17.e, r17.f, r17.g, Long.valueOf(r16), r17.i, r17.j), f(r0));
    L12:
        r13 = -1;
        goto L13
    L8:
        r10 = null;
    L15:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    }

    public static di.c g(di.l r33, Long r34) {
        Intrinsics.checkNotNullParameter(r33, "requestInfo");
        di.m r1 = r33.a;
        if (r1 == null) goto L9;
        di.p r10 = r1.f();
        if (r10 == null) goto L9;
        di.j r11 = r10.a();
        if (r11 == null) goto L9;
        Integer r12 = r11.a();
    L10:
        di.m r13 = r33.a;
        if (r13 == null) goto L17;
        di.p r14 = r13.f();
        if (r14 == null) goto L17;
        di.j r15 = r14.a();
        if (r15 == null) goto L17;
        Integer r16 = r15.b();
    L18:
        di.m r17 = r33.a;
        if (r17 == null) goto L25;
        di.p r18 = r17.f();
        if (r18 == null) goto L25;
        di.j r19 = r18.a();
        if (r19 == null) goto L25;
        Integer r20 = r19.c();
    L26:
        di.m r21 = r33.a;
        if (r21 == null) goto L33;
        di.p r22 = r21.f();
        if (r22 == null) goto L33;
        di.j r23 = r22.a();
        if (r23 == null) goto L33;
        Integer r24 = r23.d();
    L34:
        di.m r25 = r33.a;
        if (r25 == null) goto L41;
        di.p r26 = r25.f();
        if (r26 == null) goto L41;
        di.j r27 = r26.a();
        if (r27 == null) goto L41;
        Integer r28 = r27.e();
    L42:
        di.m r29 = r33.a;
        if (r29 == null) goto L49;
        di.p r30 = r29.f();
        if (r30 == null) goto L49;
        di.j r31 = r30.a();
        if (r31 == null) goto L49;
        Integer r32 = r31.f();
    L50:
        di.m r35 = r33.a;
        if (r35 == null) goto L57;
        di.p r36 = r35.f();
        if (r36 == null) goto L57;
        di.j r37 = r36.a();
        if (r37 == null) goto L57;
        Integer r110 = r37.g();
    L58:
        di.m r38 = r33.a;
        if (r38 == null) goto L65;
        di.p r39 = r38.f();
        if (r39 == null) goto L65;
        di.j r40 = r39.a();
        if (r40 == null) goto L65;
        Integer r111 = r40.h();
    L66:
        di.m r41 = r33.a;
        if (r41 == null) goto L73;
        di.p r42 = r41.f();
        if (r42 == null) goto L73;
        di.j r43 = r42.a();
        if (r43 == null) goto L73;
        Integer r112 = r43.i();
    L74:
        di.m r44 = r33.a;
        if (r44 == null) goto L81;
        di.p r45 = r44.f();
        if (r45 == null) goto L81;
        di.j r46 = r45.a();
        if (r46 == null) goto L81;
        Integer r113 = r46.j();
    L82:
        di.m r47 = r33.a;
        if (r47 == null) goto L89;
        di.p r48 = r47.f();
        if (r48 == null) goto L89;
        di.j r49 = r48.a();
        if (r49 == null) goto L89;
        Integer r114 = r49.k();
    L90:
        di.m r50 = r33.a;
        if (r50 == null) goto L97;
        di.p r51 = r50.f();
        if (r51 == null) goto L97;
        di.j r52 = r51.a();
        if (r52 == null) goto L97;
        Integer r115 = r52.l();
    L98:
        di.m r53 = r33.a;
        if (r53 == null) goto L105;
        di.p r54 = r53.f();
        if (r54 == null) goto L105;
        di.j r55 = r54.a();
        if (r55 == null) goto L105;
        Integer r116 = r55.m();
    L106:
        di.m r56 = r33.a;
        if (r56 == null) goto L113;
        di.p r57 = r56.f();
        if (r57 == null) goto L113;
        di.j r58 = r57.a();
        if (r58 == null) goto L113;
        Integer r117 = r58.n();
    L114:
        di.m r59 = r33.a;
        if (r59 == null) goto L121;
        di.p r60 = r59.f();
        if (r60 == null) goto L121;
        di.j r61 = r60.a();
        if (r61 == null) goto L121;
        Integer r118 = r61.o();
    L122:
        di.m r62 = r33.a;
        if (r62 == null) goto L129;
        di.p r63 = r62.f();
        if (r63 == null) goto L129;
        di.j r64 = r63.a();
        if (r64 == null) goto L129;
        Integer r119 = r64.p();
    L130:
        di.m r65 = r33.a;
        if (r65 == null) goto L137;
        di.p r66 = r65.f();
        if (r66 == null) goto L137;
        di.j r67 = r66.a();
        if (r67 == null) goto L137;
        Integer r210 = r67.r();
    L138:
        di.m r68 = r33.a;
        if (r68 == null) goto L145;
        di.p r69 = r68.f();
        if (r69 == null) goto L145;
        di.j r70 = r69.a();
        if (r70 == null) goto L145;
        Integer r211 = r70.q();
    L146:
        Long r71 = r33.a();
        if (r71 == null) goto L160;
        long r72 = r71.longValue();
        di.m r73 = r33.a;
        if (r73 == null) goto L157;
        di.p r74 = r73.f();
        if (r74 == null) goto L157;
        di.h r75 = r74.b();
        if (r75 == null) goto L157;
        Double r76 = r75.f();
        if (r76 == null) goto L157;
        Double r77 = Double.valueOf((r76.doubleValue() * ((double) IServerListener.WHAT_BYTELINK_SINK_ERROR)) - r72);
    L158:
        if (r77 == null) goto L161;
        long r78 = (long) r77.doubleValue();
    L162:
        di.m r79 = r33.a;
        if (r79 == null) goto L169;
        di.p r80 = r79.f();
        if (r80 == null) goto L169;
        di.h r81 = r80.b();
        if (r81 == null) goto L169;
        Long r212 = r81.c();
    L170:
        Long r82 = r33.e();
        if (r82 == null) goto L178;
        long r120 = r82.longValue();
        if (r34 == null) goto L175;
        Long r83 = Long.valueOf(r34.longValue() - r120);
    L176:
        if (r83 == null) goto L178;
        long r213 = r83.longValue();
    L179:
        di.e r84 = r33.c();
        if (r84 == null) goto L191;
        Long r85 = r84.e();
        if (r85 == null) goto L191;
        long r121 = r85.longValue();
        di.e r0 = r33.c();
        if (r0 == null) goto L188;
        Long r86 = r0.d();
        if (r86 == null) goto L188;
        Long r87 = Long.valueOf(r86.longValue() - r121);
    L189:
        if (r87 == null) goto L191;
        long r310 = r87.longValue();
    L193:
        return new di.c(r12, r16, r20, r24, r28, r32, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r78, r212, r213, r310);
    L188:
        r87 = null;
    L191:
        r310 = -1;
        goto L193
    L175:
        r83 = null;
    L178:
        r213 = -1;
    L169:
        r212 = null;
    L161:
        r78 = -1;
    L157:
        r77 = null;
        goto L158
    L160:
        r114 = r114;
        r115 = r115;
    L145:
        r211 = null;
    L137:
        r210 = null;
    L129:
        r119 = null;
    L121:
        r118 = null;
    L113:
        r117 = null;
    L105:
        r116 = null;
    L97:
        r115 = null;
    L89:
        r114 = null;
    L81:
        r113 = null;
    L73:
        r112 = null;
    L65:
        r111 = null;
    L57:
        r110 = null;
    L49:
        r32 = null;
    L41:
        r28 = null;
    L33:
        r24 = null;
    L25:
        r20 = null;
    L17:
        r16 = null;
    L9:
        r12 = null;
        goto L10
    }

    public static di.q h(di.l r12, Long r13) {
        Intrinsics.checkNotNullParameter(r12, "requestInfo");
        di.m r1 = r12.a;
        if (r1 == null) goto L11;
        di.p r10 = r1.f();
        if (r10 == null) goto L11;
        di.h r11 = r10.b();
        if (r11 == null) goto L11;
        Double r14 = r11.f();
        if (r14 == null) goto L11;
        Long r15 = Long.valueOf((long) (r14.doubleValue() * ((double) IServerListener.WHAT_BYTELINK_SINK_ERROR)));
    L12:
        di.m r16 = r12.a;
        if (r16 == null) goto L21;
        di.p r17 = r16.f();
        if (r17 == null) goto L21;
        di.h r18 = r17.b();
        if (r18 == null) goto L21;
        Double r19 = r18.b();
        if (r19 == null) goto L21;
        Long r20 = Long.valueOf((long) (r19.doubleValue() * ((double) IServerListener.WHAT_BYTELINK_SINK_ERROR)));
    L22:
        di.m r21 = r12.a;
        if (r21 == null) goto L31;
        di.p r22 = r21.f();
        if (r22 == null) goto L31;
        di.h r23 = r22.b();
        if (r23 == null) goto L31;
        Double r24 = r23.a();
        if (r24 == null) goto L31;
        Long r25 = Long.valueOf((long) (r24.doubleValue() * ((double) IServerListener.WHAT_BYTELINK_SINK_ERROR)));
    L32:
        di.m r26 = r12.a;
        if (r26 == null) goto L41;
        di.p r27 = r26.f();
        if (r27 == null) goto L41;
        di.h r28 = r27.b();
        if (r28 == null) goto L41;
        Double r29 = r28.d();
        if (r29 == null) goto L41;
        Long r30 = Long.valueOf((long) (r29.doubleValue() * ((double) IServerListener.WHAT_BYTELINK_SINK_ERROR)));
    L42:
        di.m r31 = r12.a;
        if (r31 == null) goto L51;
        di.p r32 = r31.f();
        if (r32 == null) goto L51;
        di.h r33 = r32.b();
        if (r33 == null) goto L51;
        Double r34 = r33.e();
        if (r34 == null) goto L51;
        Long r35 = Long.valueOf((long) (r34.doubleValue() * ((double) IServerListener.WHAT_BYTELINK_SINK_ERROR)));
    L53:
        return new di.q(r15, r20, r25, r30, r35, r12.e(), r12.a(), r13, r12.a(), r12.b());
    L51:
        r35 = null;
    L41:
        r30 = null;
    L31:
        r25 = null;
    L21:
        r20 = null;
    L11:
        r15 = null;
        goto L12
    }

    public static Map d(Object r10, di.l r11, int r12) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        if (r10 != null) goto L11;
        if (r11 != null) goto L11;
        return null;
    L11:
        if (r11 == null) goto L135;
    L13:
        LinkedHashMap r13 = new LinkedHashMap();     // Catch: Exception -> L132
        if (r11 == null) goto L16;
        di.m r14 = r11.a;     // Catch: Exception -> L132
    L17:
        if (r14 == null) goto L137;
        if (r11.c() == null) goto L137;
        di.m r15 = r11.a;     // Catch: Exception -> L132
        if (r15 == null) goto L25;
        di.p r0 = r15.f();     // Catch: Exception -> L132
        if (r0 == null) goto L25;
        di.j r1 = r0.a();     // Catch: Exception -> L132
    L26:
        if (r15 == null) goto L30;
        di.p r16 = r15.f();     // Catch: Exception -> L132
        if (r16 == null) goto L30;
        di.h r17 = r16.b();     // Catch: Exception -> L132
    L31:
        di.e r18 = r11.c();     // Catch: Exception -> L132
        if (r17 == null) goto L34;
        Long r19 = r17.c();     // Catch: Exception -> L132
    L35:
        r13.put("tt_total_duration", String.valueOf(r19));     // Catch: Exception -> L132
        if (r1 == null) goto L38;
        Integer r20 = r1.r();     // Catch: Exception -> L132
    L39:
        r13.put("tt_net_duration", String.valueOf(r20));     // Catch: Exception -> L132
        if (r1 == null) goto L42;
        Integer r21 = r1.f();     // Catch: Exception -> L132
    L43:
        r13.put("tt_timing_dns", String.valueOf(r21));     // Catch: Exception -> L132
        if (r1 == null) goto L46;
        Integer r22 = r1.p();     // Catch: Exception -> L132
    L47:
        r13.put("tt_timing_connect", String.valueOf(r22));     // Catch: Exception -> L132
        if (r1 == null) goto L50;
        Integer r23 = r1.o();     // Catch: Exception -> L132
    L51:
        r13.put("tt_timing_ssl", String.valueOf(r23));     // Catch: Exception -> L132
        if (r1 == null) goto L54;
        Integer r24 = r1.k();     // Catch: Exception -> L132
    L55:
        r13.put("tt_timing_proxy", String.valueOf(r24));     // Catch: Exception -> L132
        if (r1 == null) goto L58;
        Integer r25 = r1.n();     // Catch: Exception -> L132
    L59:
        r13.put("tt_timing_send", String.valueOf(r25));     // Catch: Exception -> L132
        if (r1 == null) goto L62;
        Integer r26 = r1.h();     // Catch: Exception -> L132
    L63:
        r13.put("tt_timing_header_recv", String.valueOf(r26));     // Catch: Exception -> L132
        if (r1 == null) goto L66;
        Integer r27 = r1.b();     // Catch: Exception -> L132
    L67:
        r13.put("tt_timing_body_recv", String.valueOf(r27));     // Catch: Exception -> L132
        if (r1 == null) goto L70;
        Integer r28 = r1.g();     // Catch: Exception -> L132
    L71:
        r13.put("tt_timing_ttfb_edge", String.valueOf(r28));     // Catch: Exception -> L132
        if (r1 == null) goto L74;
        Integer r29 = r1.j();     // Catch: Exception -> L132
    L75:
        r13.put("tt_timing_ttfb_origin", String.valueOf(r29));     // Catch: Exception -> L132
        if (r1 == null) goto L78;
        Integer r30 = r1.i();     // Catch: Exception -> L132
    L79:
        r13.put("tt_timing_ttfb_inner", String.valueOf(r30));     // Catch: Exception -> L132
        if (r1 == null) goto L82;
        Integer r31 = r1.l();     // Catch: Exception -> L132
    L83:
        r13.put("tt_timing_ttfb_rtt", String.valueOf(r31));     // Catch: Exception -> L132
        Long r110 = r11.g();     // Catch: Exception -> L132
        Long r32 = r11.b();     // Catch: Exception -> L132
        if (r110 == null) goto L87;
        if (r32 == null) goto L87;
        r13.put("tt_timing_req_interceptor", String.valueOf(r110.longValue() - r32.longValue()));     // Catch: Exception -> L132
    L87:
        int r33 = 0;
        if (r1 == null) goto L92;
        Integer r34 = r1.m();     // Catch: Exception -> L132
        if (r34 == null) goto L92;
        int r35 = r34.intValue();     // Catch: Exception -> L132
    L93:
        if (r1 == null) goto L97;
        Integer r36 = r1.e();     // Catch: Exception -> L132
        if (r36 == null) goto L97;
        int r37 = r36.intValue();     // Catch: Exception -> L132
    L98:
        r13.put("tt_timing_req_pre_process", String.valueOf(r35 + r37));     // Catch: Exception -> L132
        if (r1 == null) goto L103;
        Integer r38 = r1.k();     // Catch: Exception -> L132
        if (r38 == null) goto L103;
        int r39 = r38.intValue();     // Catch: Exception -> L132
    L104:
        if (r1 == null) goto L108;
        Integer r40 = r1.f();     // Catch: Exception -> L132
        if (r40 == null) goto L108;
        int r41 = r40.intValue();     // Catch: Exception -> L132
    L109:
        int r42 = r39 + r41;     // Catch: Exception -> L132
        if (r1 == null) goto L114;
        Integer r43 = r1.p();     // Catch: Exception -> L132
        if (r43 == null) goto L114;
        int r44 = r43.intValue();     // Catch: Exception -> L132
    L115:
        int r45 = r42 + r44;     // Catch: Exception -> L132
        if (r1 == null) goto L120;
        Integer r46 = r1.o();     // Catch: Exception -> L132
        if (r46 == null) goto L120;
        r33 = r46.intValue();     // Catch: Exception -> L132
    L120:
        r13.put("tt_timing_req_create", String.valueOf(r45 + r33));     // Catch: Exception -> L132
        long r47 = 0;
        if (r18 == null) goto L125;
        Long r111 = r18.d();     // Catch: Exception -> L132
        if (r111 == null) goto L125;
        long r48 = r111.longValue();     // Catch: Exception -> L132
    L126:
        if (r18 == null) goto L130;
        Long r112 = r18.e();     // Catch: Exception -> L132
        if (r112 == null) goto L130;
        r47 = r112.longValue();     // Catch: Exception -> L132
    L130:
        r13.put("tt_timing_parse", String.valueOf(r48 - r47));     // Catch: Exception -> L132
        r13.put("tt_resp_body_size", String.valueOf(r11.d()));     // Catch: Exception -> L132
        r13.put("tt_req_body_size", String.valueOf(r11.h()));     // Catch: Exception -> L132
    L132:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    L125:
        r48 = 0;
    L114:
        r44 = 0;
    L108:
        r41 = 0;
    L103:
        r39 = 0;
    L97:
        r37 = 0;
    L92:
        r35 = 0;
        goto L93
    L82:
        r31 = null;
        goto L83
    L78:
        r30 = null;
        goto L79
    L74:
        r29 = null;
        goto L75
    L70:
        r28 = null;
        goto L71
    L66:
        r27 = null;
        goto L67
    L62:
        r26 = null;
        goto L63
    L58:
        r25 = null;
        goto L59
    L54:
        r24 = null;
        goto L55
    L50:
        r23 = null;
        goto L51
    L46:
        r22 = null;
        goto L47
    L42:
        r21 = null;
        goto L43
    L38:
        r20 = null;
        goto L39
    L34:
        r19 = null;
    L30:
        r17 = null;
    L25:
        r1 = null;
    L137:
        return r13;
    L16:
        r14 = null;
        goto L17
    L135:
        r11 = e(r10);     // Catch: Exception -> L132
        goto L13
    }
}
