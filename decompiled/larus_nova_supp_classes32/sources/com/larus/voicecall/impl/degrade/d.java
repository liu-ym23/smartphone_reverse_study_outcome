package com.larus.voicecall.impl.degrade;

import com.larus.platform.service.o;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d {
    public static final void a(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L9
        r4.put("scene", r2);     // Catch: Throwable -> L9
        if (r3 == false) goto L6;
        String r5 = "total";
    L7:
        r4.put("type", r5);     // Catch: Throwable -> L9
        Object r6 = Result.constructor-impl(r4);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r6) == false) goto L14;
        r6 = null;
    L14:
        com.larus.platform.service.g.a.monitorEventForSlardar("downgrade_time_limit", (JSONObject) r6, null, null);
        return;
    L6:
        r5 = "once";
    L9:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public static final void b(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "entrance");
        Intrinsics.checkNotNullParameter(r4, "limitType");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L15
        r1.put("limited_biz", r2);     // Catch: Throwable -> L15
        r1.put("limited_entrance", r3);     // Catch: Throwable -> L15
        if (Intrinsics.areEqual(r3, "video_button") == false) goto L6;
    L9:
        boolean r5 = true;
    L10:
        if (r5 == false) goto L12;
        String r6 = "switch";
    L13:
        r1.put("limited_trigger", r6);     // Catch: Throwable -> L15
        r1.put("limited_type", r4);     // Catch: Throwable -> L15
        Object r7 = Result.constructor-impl(r1);     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r7) == false) goto L20;
        r7 = null;
    L20:
        o r8 = o.a;
        r8.reportEvent("to_limited_toast_show", (JSONObject) r7);
        return;
    L12:
        r6 = "entry";
        goto L13
    L6:
        if (Intrinsics.areEqual(r3, "voice_button") == true) goto L9;
        r5 = false;
    L15:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }
}
