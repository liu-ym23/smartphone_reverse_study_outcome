package com.larus.dora.o.impl.health.calendar;

import android.os.SystemClock;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraOHealthCalendarRepo {
    public static final DoraOHealthCalendarRepo a = null;
    public static final ConcurrentHashMap<String, a> b = null;

    public static final class a {
        public final d a;
        public final long b;

        public a(d r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a = r2;
            this.b = r3;
        }
    }

    public DoraOHealthCalendarRepo() {
    }

    static {
        a = new DoraOHealthCalendarRepo();
        b = new ConcurrentHashMap();
    }

    public final Object a(String r25, Continuation<? super d> r26) {
        final String r1 = r25;
        if ((r26 instanceof DoraOHealthCalendarRepo$fetchCalendar$1) == false) goto L7;
        DoraOHealthCalendarRepo$fetchCalendar$1 r3 = (DoraOHealthCalendarRepo$fetchCalendar$1) r26;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        DoraOHealthCalendarRepo$fetchCalendar$1 r10 = r3;
        Object r0 = r10.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r10.label;
        if (r6 == 0) goto L18;
        if (r6 != 1) goto L17;
        r1 = (String) r10.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L14 CancellationException -> L55
        String r12 = "OHealthCalendar";
    L29:
        final y r2 = (com.larus.network.http.a) r0;     // Catch: Exception -> L40 CancellationException -> L55
        if ((r2 instanceof y) == false) goto L32;
        y r7 = r2;     // Catch: Exception -> L40 CancellationException -> L55
    L33:
        if (r7 == null) goto L35;
        d r8 = (d) ((com.larus.network.http.a) r7).b;     // Catch: Exception -> L40 CancellationException -> L55
    L36:
        if (r8 != null) goto L42;
        FLogger.a.f(r12, new b(r1, r2));     // Catch: Exception -> L40 CancellationException -> L55
        return null;
    L40:
        Exception e = e;
    L41:
        Object r9 = null;
    L53:
        FLogger.a.e(r12, "fetch month=" + r1 + " error: " + e.getMessage());
        return r9;
    L42:
        r9 = null;
        List<e> r11 = r8.a();     // Catch: Exception -> L52 CancellationException -> L55
        if (r11 != null) goto L46;
        r11 = CollectionsKt.emptyList();     // Catch: Exception -> L52 CancellationException -> L55
    L46:
        String r13 = CollectionsKt.joinToString$default(CollectionsKt.filterNotNull(r11), " ", null, null, 0, null, new c(), 30, null);     // Catch: Exception -> L52 CancellationException -> L55
        FLogger r14 = FLogger.a;     // Catch: Exception -> L52 CancellationException -> L55
        StringBuilder r15 = new StringBuilder("loaded month=");     // Catch: Exception -> L52 CancellationException -> L55
        r15.append(r1);     // Catch: Exception -> L52 CancellationException -> L55
        r15.append(" days=");     // Catch: Exception -> L52 CancellationException -> L55
        List<e> r16 = r8.a();     // Catch: Exception -> L52 CancellationException -> L55
        if (r16 == null) goto L49;
        int r17 = r16.size();     // Catch: Exception -> L52 CancellationException -> L55
    L50:
        r15.append(r17);     // Catch: Exception -> L52 CancellationException -> L55
        r15.append(" [");     // Catch: Exception -> L52 CancellationException -> L55
        r15.append(r13);     // Catch: Exception -> L52 CancellationException -> L55
        r15.append(']');     // Catch: Exception -> L52 CancellationException -> L55
        r14.i(r12, r15.toString());     // Catch: Exception -> L52 CancellationException -> L55
        b.put(r1, new a(r8, SystemClock.elapsedRealtime()));     // Catch: Exception -> L52 CancellationException -> L55
        return r8;
    L49:
        r17 = 0;
    L52:
        e = e;
        goto L53
    L35:
        r8 = null;
        goto L36
    L32:
        r7 = null;
    L14:
        e = e;
        r12 = "OHealthCalendar";
        goto L41
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        a r18 = b.get(r1);
        if (r18 != null) goto L21;
        r12 = "OHealthCalendar";
    L61:
        FLogger.a.i(r12, "fetch month=" + r1);     // Catch: Exception -> L40 CancellationException -> L55
        com.larus.dora.api.network.a r20 = com.larus.dora.api.network.a.a;     // Catch: Exception -> L40 CancellationException -> L55
        JSONObject r21 = new JSONObject();     // Catch: Exception -> L40 CancellationException -> L55
        r21.put("month", r1);     // Catch: Exception -> L40 CancellationException -> L55
        Unit r22 = Unit.INSTANCE;     // Catch: Exception -> L40 CancellationException -> L55
        r10.L$0 = r1;     // Catch: Exception -> L40 CancellationException -> L55
        r10.label = 1;     // Catch: Exception -> L40 CancellationException -> L55
        r0 = com.larus.dora.api.network.a.c(r20, d.class, "/alice/wearable/health/calendar", r21, null, r10, 248);     // Catch: Exception -> L40 CancellationException -> L55
        if (r0 != r5) goto L29;
        return r5;
    L21:
        if ((SystemClock.elapsedRealtime() - r18.b) >= 300000) goto L24;
        FLogger.a.g("OHealthCalendar", new com.larus.dora.o.impl.health.calendar.a(r1));
        return r18.a;
    L24:
        r12 = "OHealthCalendar";
    L55:
        e = move-exception;
        throw e;
    L7:
        r3 = new DoraOHealthCalendarRepo$fetchCalendar$1(this, r26);
        goto L8
    }
}
