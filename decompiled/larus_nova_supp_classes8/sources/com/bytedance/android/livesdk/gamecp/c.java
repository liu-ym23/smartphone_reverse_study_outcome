package com.bytedance.android.livesdk.gamecp;

import android.os.Handler;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.x6;
import com.bytedance.android.livesdk.config.y5;
import com.bytedance.android.livesdkapi.livetrace.ILiveGameTraceMonitor;
import com.bytedance.android.livesdkapi.livetrace.TraceMetaWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements ILiveGameTraceMonitor {
    public static final x6 a = null;
    public static final HashSet<String> b = null;
    public static final HashSet<String> c = null;
    public static final HashSet<String> d = null;
    public static PthreadHandlerThreadV2 e;
    public static Handler f;
    public static final c g = null;

    public static final class a implements Runnable {
        public final /* synthetic */ com.bytedance.android.live.core.monitor.trace.e a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ JSONObject d;

        public a(com.bytedance.android.live.core.monitor.trace.e r1, JSONObject r2, JSONObject r3, JSONObject r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.live.core.monitor.trace.e r0 = this.a;     // Catch: Throwable -> L7
            JSONObject r1 = this.b;     // Catch: Throwable -> L7
            if (r1 != null) goto L5;
            r1 = new JSONObject();     // Catch: Throwable -> L7
        L5:
            r1.put("step", this.a.f);     // Catch: Throwable -> L7
            Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L7
            TraceMonitor.i(r0, r1, this.c, this.d);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public c() {
    }

    static {
        g = new c();
        x6 r0 = y5.a.getValue();
        a = r0;
        Map<String, String[]> r1 = r0.a();
        if (r1 == null) goto L32;
        Iterator<Map.Entry<String, String[]>> r2 = r1.entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L50;
        Map.Entry<String, String[]> r3 = r2.next();
        String r4 = r3.getKey();
        int r5 = r4.hashCode();
        HashSet<String> r6 = null;
        if (r5 != 3540684) goto L10;
        if (r4.equals("step") == false) goto L6;
        String[] r7 = r3.getValue();
        if (r7 == null) goto L31;
        r6 = ArraysKt.toHashSet(r7);
    L31:
        d = r6;
        goto L6
    L10:
        if (r5 != 630087769) goto L12;
        if (r4.equals("business_type") == false) goto L6;
        String[] r8 = r3.getValue();
        if (r8 == null) goto L25;
        r6 = ArraysKt.toHashSet(r8);
    L25:
        b = r6;
        goto L6
    L12:
        if (r5 != 984376767) goto L6;
        if (r4.equals("event_type") == false) goto L6;
        String[] r9 = r3.getValue();
        if (r9 == null) goto L19;
        r6 = ArraysKt.toHashSet(r9);
    L19:
        c = r6;
        goto L6
    L50:
        return;
    }

    public static com.bytedance.android.live.core.monitor.trace.e a(TraceMetaWrapper r3) {
        int r0 = com.bytedance.android.live.core.monitor.trace.e.m;
        com.bytedance.android.live.core.monitor.trace.e.a r1 = com.bytedance.android.live.core.monitor.trace.e.b.a(r3.getEventType(), r3.getBusinessType());
        r1.g = r3.getUserId();
        r1.f = r3.getAnchorId();
        r1.a = r3.getTraceId();
        r1.e = r3.getRoomId();
        Map r2 = r3.getIndex();
        if (r2 != null) goto L5;
        r2 = new LinkedHashMap();
    L5:
        Intrinsics.checkNotNullParameter(r2, "index");
        r1.j = r2;
        r1.b = r3.getLogId();
        r1.d = r3.getStep();
        r1.c = r3.getProductId();
        r1.h = r3.getStatusCode();
        r1.i = r3.getStatusMsg();
        return r1.a();
    }

    public static boolean b(HashSet r2, String r3) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.contains("*") == false) goto L8;
        return true;
    L8:
        if (r2.contains(r3) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final void reportTraceEvent(TraceMetaWrapper r3, JSONObject r4, JSONObject r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r3, "traceMetaWrapper");
        if (a.b() == true) goto L6;
        return;
    L6:
        if (b(b, r3.getBusinessType()) == false) goto L16;
        if (b(c, r3.getEventType()) == false) goto L16;
        HashSet<String> r0 = d;
        String r1 = r3.getStep();
        if (r1 != null) goto L13;
        r1 = "";
    L13:
        if (b(r0, r1) == false) goto L16;
        return;
    L16:
        if (e != null) goto L30;
        PthreadHandlerThreadV2 r2 = new PthreadHandlerThreadV2("game_promote_trace");
        e = r2;
        ThreadMethodProxy.start(r2);
        f = new Handler(r2.getLooper());
    L30:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L24
        com.bytedance.android.live.core.monitor.trace.e r8 = a(r3);     // Catch: Throwable -> L24
        Handler r9 = f;     // Catch: Throwable -> L24
        if (r9 == null) goto L21;
        Boolean r10 = Boolean.valueOf(r9.post(new a(r8, r4, r5, r6)));     // Catch: Throwable -> L24
    L22:
        Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L24
    L26:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L32;
        ALogger.e("ILiveGameTraceMonitor", r12);
        return;
    L32:
        return;
    L21:
        r10 = null;
    L24:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    }

    public final void reportTraceEvent(String r3, String r4, String r5, String r6, String r7, String r8, JSONObject r9, JSONObject r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r3, "business_type");
        Intrinsics.checkNotNullParameter(r4, "event_type");
        Intrinsics.checkNotNullParameter(r5, "step");
        String r0 = jc1.k.n(IUserService.class).user().n();
        reportTraceEvent(TraceMetaWrapper.Companion.builder(r4, r3).productId("webcast_client_game_promote").step(r5).traceId(r6).userId(r0).roomId(r7).logId(r8).build(), r9, r10, r11);
    }
}
