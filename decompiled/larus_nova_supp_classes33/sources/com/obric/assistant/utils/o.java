package com.obric.assistant.utils;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.ixigua.lib.track.TrackParams;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.t1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class o {
    public static final o a = null;
    public static final Lazy b = null;

    public o() {
    }

    static {
        a = new o();
        new Handler(Looper.getMainLooper());
        b = LazyKt.lazy(new n());
    }

    public static JSONObject a(String r3, String r4, String r5) {
        JSONObject r0 = new JSONObject();
        r0.put("event_stage", "stage3_entry");
        r0.put("error_message", r3);
        String r6 = Build.VERSION.RELEASE;
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        r0.put("os_version", r6);
        a.getClass();
        r0.put("app_version", (String) b.getValue());
        r0.put("session_type", r5);
        r0.put("timestamp", System.currentTimeMillis());
        if (o0.d(r4) == false) goto L8;
        r0.put("extra", r4);
    L8:
        return r0;
    }

    public static void b(String r5, String r6, String r7) {
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L14
        JSONObject r8 = a(r5, r6, r7);     // Catch: Throwable -> L14
        by7.a r9 = new by7.a("wakeup_flow_interrupted");     // Catch: Throwable -> L14
        r9.a.merge(new TrackParams().merge(r8));     // Catch: Throwable -> L14
        r9.b();     // Catch: Throwable -> L14
        if (t1.a.o0() == true) goto L22;
    L12:
        FLogger.a.i("WakeupErrorEventHelper", "report event wakeup_flow_interrupted: " + r8);     // Catch: Throwable -> L14
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L24;
        FLogger.a.w("WakeupErrorEventHelper", "report failed: " + r11.getMessage(), r11);
        return;
    L24:
        return;
    L22:
        g.a.monitorEventForSlardar("wakeup_flow_interrupted", r8, null, null);     // Catch: Throwable -> L7
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r13 = Result.exceptionOrNull-impl(r12);     // Catch: Throwable -> L14
        if (r13 == null) goto L12;
        FLogger.a.w("WakeupErrorEventHelper", "monitorEventForSlardar failed: " + r13.getMessage(), r13);     // Catch: Throwable -> L14
        goto L12
    L7:
        th = move-exception;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L14
        r12 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    public static void c(Bundle r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "errorMessage");
        String r1 = "VOICE";
        String r5 = r2.getString("sessionName", "VOICE");
        if (r5 == null) goto L6;
        r1 = r5;
    L6:
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        b(r3, r4, r1);
    }
}
