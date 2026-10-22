package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.browser.jsbridge.base.ReportLiveTraceResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.livetrace.ILiveCloudGameTraceMonitor;
import com.bytedance.android.livesdkapi.livetrace.ILiveGameTraceMonitor;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import w20.jd;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "reportLiveTrace")
public final class q1 extends w20.j5<jd, ReportLiveTraceResultModel> {
    public final void onTerminate() {
    }

    public q1() {
    }

    public final JSONObject j(JsonObject r3) {
        Object r0 = null;
        if (r3 != null) goto L15;
        return null;
    L15:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Object r4 = Result.constructor-impl(tv5.a.c(r3));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r4) == true) goto L14;
        r0 = r4;
    L14:
        return (JSONObject) r0;
    L7:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final void invoke(Object r18, CallContext r19) {
        jd r1 = (jd) r18;
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r19, "context");
        String r5 = r1.d();
        String r4 = r1.b();
        boolean r3 = true;
        if (r5 != null) goto L5;
    L8:
        boolean r6 = true;
    L10:
        if (r6 == true) goto L81;
        if (r4 != null) goto L13;
    L16:
        if (r3 == true) goto L81;
        String r8 = r1.i();
        String r7 = r1.a();
        String r9 = r1.h();
        String r10 = r1.k();
        String r11 = r1.j();
        JSONObject r13 = j(r1.c());
        JSONObject r14 = j(r1.e());
        JSONObject r15 = j(r1.g());
        JSONObject r2 = j(r1.f());
        HashMap r16 = new HashMap();
        if (r2 == null) goto L30;
        JSONArray r17 = r2.names();
        int r20 = r17.length();
        int r0 = 0;
    L21:
        if (r0 >= r20) goto L30;
        Object r110 = r17.get(r0);
        if (r110 == null) goto L27;
        int r111 = r20;
        String r21 = r110.toString();
        JSONArray r112 = r17;
        if (r21 == null) goto L28;
        r16.put(r21, r2.opt(r21));
    L28:
        r0 = r0 + 1;
        r20 = r111;
        r17 = r112;
        goto L21
    L27:
        r111 = r20;
        r112 = r17;
    L30:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L43;
        StringBuilder r23 = new StringBuilder("roomId=");
        r23.append(r8);
        r23.append(", anchorId=");
        r23.append(r7);
        r23.append(", productId=");
        r23.append(r9);
        r23.append(", eventType=");
        r23.append(r5);
        r23.append(", businessType=");
        r23.append(r4);
        r23.append(", category=");
        String r24 = null;
        if (r13 == null) goto L34;
        String r113 = r13.toString();
    L35:
        r23.append(r113);
        r23.append(", extra=");
        if (r14 == null) goto L38;
        String r114 = r14.toString();
    L39:
        r23.append(r114);
        r23.append(", index=");
        if (r2 == null) goto L42;
        r24 = r2.toString();
    L42:
        r23.append(r24);
        ALogger.i("LiveTraceMethod", r23.toString());
        goto L43
    L38:
        r114 = null;
        goto L39
    L34:
        r113 = null;
    L43:
        String r25 = BuildConfig.FLAVOR;
        if (r9 == null) goto L71;
        int r26 = r9.hashCode();
        if (r26 == (-1428074950)) goto L62;
        if (r26 != 626387643) goto L71;
        if (r9.equals("webcast_client_game_promote") == false) goto L71;
        IMiddlewareLiveService r27 = TTLiveServiceMiddleware.getLiveService();
        if (r27 == null) goto L80;
        ILiveGameTraceMonitor r28 = r27.getGameTraceMonitor();
        if (r28 == null) goto L80;
        if (r11 != null) goto L59;
        String r29 = BuildConfig.FLAVOR;
    L60:
        r28.reportTraceEvent(r4, r5, r29, r10, r8, null, r13, r15, r14);
        goto L80
    L59:
        r29 = r11;
    L80:
        finishWithSuccess();
        return;
    L62:
        if (r9.equals("webcast_client_game") == false) goto L71;
        IMiddlewareLiveService r30 = TTLiveServiceMiddleware.getLiveService();
        if (r30 == null) goto L80;
        ILiveCloudGameTraceMonitor r31 = r30.getCloudGameTraceMonitor();
        if (r31 == null) goto L80;
        if (r11 != null) goto L69;
        String r33 = BuildConfig.FLAVOR;
    L70:
        r31.reportTraceEvent(r4, r5, r33, r10, r8, r16, r13, r15, r14);
        goto L80
    L69:
        r33 = r11;
    L71:
        int r34 = com.bytedance.android.live.core.monitor.trace.e.m;
        com.bytedance.android.live.core.monitor.trace.e.a r35 = com.bytedance.android.live.core.monitor.trace.e.b.a(r5, r4);
        r35.c = r9;
        r35.f = r7;
        r35.e = r8;
        IMiddlewareUserService r36 = jc1.k.f(IMiddlewareUserService.class);
        if (r36 == null) goto L79;
        com.bytedance.android.livesdk.user.e r37 = r36.user();
        if (r37 == null) goto L79;
        String r38 = r37.n();
        if (r38 == null) goto L79;
        r25 = r38;
    L79:
        r35.g = r25;
        Intrinsics.checkNotNullParameter(r16, "index");
        r35.j = r16;
        r35.d = r11;
        r35.a = r10;
        TraceMonitor.i(r35.a(), r13, r15, r14);
        goto L80
    L13:
        if (r4.length() == 0) goto L16;
        r3 = false;
    L81:
        pm0.b r39 = om0.c.f();
        if (r39 == null) goto L84;
        r39.i("LiveTraceMethod", "invoke failed; params=" + r1);
    L84:
        finishWithFailure(new Throwable("请求参数错误"));
        return;
    L5:
        if (r5.length() == 0) goto L8;
        r6 = false;
        goto L10
    }
}
