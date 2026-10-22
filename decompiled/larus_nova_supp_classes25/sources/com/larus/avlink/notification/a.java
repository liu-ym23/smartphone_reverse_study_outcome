package com.larus.avlink.notification;

import com.bytedance.keva.Keva;
import com.larus.avlink.n1;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final a a = null;
    public static String b;
    public static String c;
    public static String d;
    public static String e;
    public static Long f;
    public static Boolean g;
    public static String h;
    public static long i;
    public static final ConcurrentHashMap<String, Long> j = null;

    public a() {
    }

    static {
        a = new a();
        j = new ConcurrentHashMap();
    }

    public static Keva a() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Keva.getRepo("proactive_summary_cache", 1));     // Catch: Throwable -> L4
    L7:
        if (Result.exceptionOrNull-impl(r1) == null) goto L11;
        n1.e("ProactiveSummaryRecords", "[NotificationTracer] skip proactive summary cache because keva is not ready");
        r1 = null;
    L11:
        return (Keva) r1;
    L4:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static boolean b(Long r7) {
        if (i > 0) goto L9;
        Keva r0 = a();
        if (r0 == null) goto L7;
        long r1 = r0.getLong("last_unlock_timestamp_ms", 0);
    L8:
        i = r1;
        goto L9
    L7:
        r1 = 0;
    L9:
        long r2 = i;
        boolean r4 = false;
        if (r7 != null) goto L14;
        n1.d("ProactiveSummaryRecords", "[NotificationTracer] skip unlock drop check because earliestClientReceiveTimestampMs is null. lastUnlockTimestampMs=" + r2);
        return false;
    L14:
        if (r2 > 0) goto L16;
    L18:
        n1.d("ProactiveSummaryRecords", "[NotificationTracer] check unlock drop. earliestClientReceiveTimestampMs=" + r7 + ", lastUnlockTimestampMs=" + r2 + ", shouldDrop=" + r4);
        return r4;
    L16:
        if (r7.longValue() > r2) goto L18;
        r4 = true;
        goto L18
    }
}
