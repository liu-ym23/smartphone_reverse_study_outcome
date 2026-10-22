package com.bytedance.android.live.core.monitor;

import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.core.monitor.trace.b;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.livetrace.ILiveCloudGameTraceMonitor;
import com.bytedance.android.livesdkapi.livetrace.ILiveGameTraceMonitor;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import java.util.HashMap;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012Jr\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/core/monitor/TraceMonitorServiceImpl;", "Lcom/bytedance/android/live/core/monitor/trace/b;", "", "eventType", "businessType", "productId", "anchorId", "roomId", "step", "traceId", "Lorg/json/JSONObject;", "index", "category", "extra", "metric", "", "reportTraceEvent", "<init>", "()V", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TraceMonitorServiceImpl implements b {
    public TraceMonitorServiceImpl() {
        k.l(b.class, this);
    }

    public void reportTraceEvent(String r15, String r16, String r17, String r18, String r19, String r21, String r22, JSONObject r23, JSONObject r24, JSONObject r25, JSONObject r26) {
        Intrinsics.checkNotNullParameter(r15, "eventType");
        Intrinsics.checkNotNullParameter(r16, "businessType");
        HashMap r11 = new HashMap();
        if (r23 == null) goto L15;
        JSONArray r3 = r23.names();
        if (r3 != null) goto L7;
        r3 = new JSONArray();
    L7:
        int r4 = r3.length();
        int r7 = 0;
    L8:
        if (r7 >= r4) goto L15;
        Object r8 = r3.get(r7);
        if (r8 == null) goto L14;
        String r9 = r8.toString();
        if (r9 == null) goto L14;
        r11.put(r9, r23.opt(r9));
    L14:
        r7 = r7 + 1;
    L15:
        String r2 = "";
        if (r17 == null) goto L43;
        int r5 = r17.hashCode();
        if (r5 == (-1428074950)) goto L34;
        if (r5 != 626387643) goto L43;
        if (r17.equals("webcast_client_game_promote") == false) goto L43;
        IMiddlewareLiveService r0 = TTLiveServiceMiddleware.getLiveService();
        if (r0 == null) goto L57;
        ILiveGameTraceMonitor r6 = r0.getGameTraceMonitor();
        if (r6 == null) goto L58;
        if (r21 != null) goto L31;
        String r12 = "";
    L32:
        r6.reportTraceEvent(r16, r15, r12, r22, r19, null, r24, r26, r25);
        return;
    L31:
        r12 = r21;
        goto L32
    L58:
        return;
    L57:
        return;
    L34:
        if (r17.equals("webcast_client_game") == false) goto L43;
        IMiddlewareLiveService r1 = TTLiveServiceMiddleware.getLiveService();
        if (r1 == null) goto L60;
        ILiveCloudGameTraceMonitor r13 = r1.getCloudGameTraceMonitor();
        if (r13 == null) goto L61;
        if (r21 != null) goto L41;
        String r14 = "";
    L42:
        r13.reportTraceEvent(r16, r15, r14, r22, r19, r11, r24, r26, r25);
        return;
    L41:
        r14 = r21;
        goto L42
    L61:
        return;
    L60:
        return;
    L43:
        IMiddlewareUserService r27 = k.f(IMiddlewareUserService.class);
        if (r27 == null) goto L51;
        e r28 = r27.user();
        if (r28 == null) goto L51;
        String r29 = r28.n();
        if (r29 == null) goto L51;
        r2 = r29;
    L51:
        int r31 = com.bytedance.android.live.core.monitor.trace.e.m;
        com.bytedance.android.live.core.monitor.trace.e.a r32 = com.bytedance.android.live.core.monitor.trace.e.b.a(r15, r16);
        r32.c = r17;
        r32.f = r18;
        r32.e = r19;
        r32.g = r2;
        Intrinsics.checkNotNullParameter(r11, "index");
        r32.j = r11;
        r32.d = r21;
        r32.a = r22;
        TraceMonitor.i(r32.a(), r24, r26, r25);
    }
}
