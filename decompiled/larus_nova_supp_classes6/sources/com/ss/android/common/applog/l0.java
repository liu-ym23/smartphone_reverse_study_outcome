package com.ss.android.common.applog;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class l0 {
    public static void a(Object r1, String r2) {
        if (r1 == null) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r2.concat("can not be null"));
    }

    public static long b(JSONObject r0, String r1) {
        return CastLongProtector.valueOf(r0.optString(r1)).longValue();
    L5:
        return 0;
    }
}
