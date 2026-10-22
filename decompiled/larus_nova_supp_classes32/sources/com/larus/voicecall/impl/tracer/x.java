package com.larus.voicecall.impl.tracer;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.utils.logger.FLogger;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class x {
    public static final Integer a(String r4) {
        if (r4 != null) goto L12;
        return null;
    L12:
        JSONObject r2 = new JSONObject(StringsKt.removePrefix(StringsKt.removePrefix(r4, "error: sami WebSocketStateChanged:"), "error: "));     // Catch: Throwable -> L9
        if (r2.has("statusCode") == false) goto L11;
        return Integer.valueOf(JSONObjectProtectorUtils.getInt(r2, "statusCode"));
    L11:
        return null;
    L9:
        th = move-exception;
        FLogger.a.e("TRACER_HELPER", "getSubErrorCode on err! msg=" + th);
        goto L11
    }
}
