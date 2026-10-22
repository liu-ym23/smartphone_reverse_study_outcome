package com.bytedance.android.ec.core.abtest;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECByteSyncManager {
    public static final Lazy a = null;

    public ECByteSyncManager() {
    }

    static {
        a = LazyKt.lazy(ECByteSyncManager$handlers$2.INSTANCE);
    }

    public static final void a(JSONObject r10, String r11, long r12, long r13) {
        int r1 = 0;
        int r0 = r10.optInt("task_type", 0);
        if (((i) ((Map) a.getValue()).get(Integer.valueOf(r0))) == null) goto L26;
        Intrinsics.checkNotNullParameter(r10, "jsonPayload");
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L7
        i.a(r10, r12, r13);     // Catch: Throwable -> L7
        Object r15 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        JSONObject r17 = new JSONObject();     // Catch: Throwable -> L19
        if (r16 != null) goto L13;
        r1 = 1;
    L13:
        r17.put("success", r1);     // Catch: Throwable -> L19
        if (r16 == null) goto L16;
        String r18 = r16.getMessage();     // Catch: Throwable -> L19
    L17:
        r17.put(com.bytedance.android.ec.core.event.a.KEY_ERROR_MSG, r18);     // Catch: Throwable -> L19
        r17.put("data", r10);     // Catch: Throwable -> L19
        r17.put("msg_id", r11);     // Catch: Throwable -> L19
        com.bytedance.android.ec.sdk.helper.g.a.logV3("pdp_exp_disaster_recovery_monitor", r17);     // Catch: Throwable -> L19
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
        return;
    L16:
        r18 = null;
    L19:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L7:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }
}
