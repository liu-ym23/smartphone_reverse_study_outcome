package com.larus.bmhome.resource.access;

import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u {
    public static final u a = null;
    public static final Set<String> b = null;

    public u() {
    }

    static {
        a = new u();
        b = SetsKt.setOf(new String[]{"task_id", "file_identifier", "scene", "source_type", "media_type", "node_key", "stage", "cost_ms", "result", "error_code", "policy_version", "route_decision", "route_reason", "cache_hit", "sdk_route", "remote_resolve", "is_task_reused", "wait_cost_ms", "estimated_saved_ms"});
    }

    public static void b(t r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[trace] taskId=");
        r1.append(r7.a);
        r1.append(", fileIdentifier=");
        r1.append(r7.e);
        r1.append(", scene=");
        r1.append(r7.b);
        r1.append(", resourceInputType=");
        r1.append(r7.c);
        r1.append(", mediaType=");
        r1.append(r7.d);
        r1.append(", nodeKey=");
        r1.append(r7.f);
        r1.append(", stage=");
        r1.append(r7.g);
        r1.append(", costMs=");
        r1.append(r7.h);
        r1.append(", result=");
        r1.append(r7.i);
        r1.append(", errorCode=");
        String r2 = r7.j;
        String r3 = "";
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r1.append(r2);
        r1.append(", policyVersion=");
        String r4 = r7.k;
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        r1.append(r4);
        r1.append(", routeDecision=");
        String r5 = r7.l;
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        r1.append(r5);
        r1.append(", routeReason=");
        String r6 = r7.m;
        if (r6 != null) goto L14;
        r6 = "";
    L14:
        r1.append(r6);
        r1.append(", cacheHit=");
        String r8 = r7.n;
        if (r8 != null) goto L17;
        r8 = "";
    L17:
        r1.append(r8);
        r1.append(", sdkRoute=");
        String r9 = r7.o;
        if (r9 != null) goto L20;
        r9 = "";
    L20:
        r1.append(r9);
        r1.append(", remoteResolve=");
        String r10 = r7.p;
        if (r10 != null) goto L23;
        r10 = "";
    L23:
        r1.append(r10);
        r1.append(", isTaskReused=");
        r1.append(r7.q);
        r1.append(", waitCostMs=");
        r1.append(r7.r);
        r1.append(", estimatedSavedMs=");
        r1.append(r7.s);
        r1.append(", attributes=");
        r1.append(r7.t);
        r0.i("ResourceAccessObserveReporter", r1.toString());
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L61
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L61
        r12.put("task_id", r7.a);     // Catch: Throwable -> L61
        r12.put("file_identifier", r7.e);     // Catch: Throwable -> L61
        r12.put("scene", r7.b.a);     // Catch: Throwable -> L61
        r12.put("source_type", r7.c.name());     // Catch: Throwable -> L61
        r12.put("media_type", r7.d.name());     // Catch: Throwable -> L61
        r12.put("node_key", r7.f);     // Catch: Throwable -> L61
        r12.put("stage", r7.g);     // Catch: Throwable -> L61
        r12.put("cost_ms", r7.h);     // Catch: Throwable -> L61
        r12.put("result", r7.i);     // Catch: Throwable -> L61
        String r13 = r7.j;     // Catch: Throwable -> L61
        if (r13 != null) goto L27;
        r13 = "";
    L27:
        r12.put("error_code", r13);     // Catch: Throwable -> L61
        String r14 = r7.k;     // Catch: Throwable -> L61
        if (r14 != null) goto L30;
        r14 = "";
    L30:
        r12.put("policy_version", r14);     // Catch: Throwable -> L61
        String r15 = r7.l;     // Catch: Throwable -> L61
        if (r15 != null) goto L33;
        r15 = "";
    L33:
        r12.put("route_decision", r15);     // Catch: Throwable -> L61
        String r16 = r7.m;     // Catch: Throwable -> L61
        if (r16 != null) goto L36;
        r16 = "";
    L36:
        r12.put("route_reason", r16);     // Catch: Throwable -> L61
        String r17 = r7.n;     // Catch: Throwable -> L61
        if (r17 != null) goto L39;
        r17 = "";
    L39:
        r12.put("cache_hit", r17);     // Catch: Throwable -> L61
        String r18 = r7.o;     // Catch: Throwable -> L61
        if (r18 != null) goto L42;
        r18 = "";
    L42:
        r12.put("sdk_route", r18);     // Catch: Throwable -> L61
        String r19 = r7.p;     // Catch: Throwable -> L61
        if (r19 == null) goto L46;
        r3 = r19;
    L46:
        r12.put("remote_resolve", r3);     // Catch: Throwable -> L61
        Boolean r20 = r7.q;     // Catch: Throwable -> L61
        if (r20 != null) goto L49;
    L53:
        Long r21 = r7.r;     // Catch: Throwable -> L61
        if (r21 == null) goto L56;
        r12.put("wait_cost_ms", r21.longValue());     // Catch: Throwable -> L61
    L56:
        Long r22 = r7.s;     // Catch: Throwable -> L61
        if (r22 == null) goto L59;
        r12.put("estimated_saved_ms", r22.longValue());     // Catch: Throwable -> L61
    L59:
        a(r12, r7.t);     // Catch: Throwable -> L61
        com.larus.platform.service.o.a.reportEvent("resource_access_pipeline_trace", r12);     // Catch: Throwable -> L61
        Object r23 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L61
    L63:
        Throwable r24 = Result.exceptionOrNull-impl(r23);
        if (r24 == null) goto L81;
        FLogger.a.e("ResourceAccessObserveReporter", "[trace] report applog failed", r24);
    L81:
        Set r25 = ServiceManager.get().getServices(ResourceAccessObserver.class, true);     // Catch: Throwable -> L75
        if (r25 != null) goto L69;
        r25 = SetsKt.emptySet();     // Catch: Throwable -> L75
    L69:
        Iterator r26 = r25.iterator();     // Catch: Throwable -> L75
    L71:
        if (r26.hasNext() == false) goto L73;
        ((ResourceAccessObserver) r26.next()).onEvent(r7);     // Catch: Throwable -> L75
        goto L71
    L73:
        Object r27 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L75
    L77:
        Throwable r28 = Result.exceptionOrNull-impl(r27);
        if (r28 == null) goto L86;
        FLogger.a.e("ResourceAccessObserveReporter", "[trace] notify observer failed", r28);
        return;
    L86:
        return;
    L75:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L77
    L49:
        if (r20.booleanValue() == false) goto L51;
        int r30 = 1;
    L52:
        r12.put("is_task_reused", r30);     // Catch: Throwable -> L61
        goto L53
    L51:
        r30 = 0;
    L61:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L63
    }

    public static void a(JSONObject r4, Map r5) {
        Iterator r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L12;
        Map.Entry r0 = (Map.Entry) r6.next();
        String r1 = (String) r0.getKey();
        String r2 = (String) r0.getValue();
        if (StringsKt.isBlank(r1) == true) goto L4;
        if (b.contains(r1) == false) goto L11;
        r1 = "attr_" + r1;
    L11:
        r4.put(r1, r2);
        goto L4
    }
}
