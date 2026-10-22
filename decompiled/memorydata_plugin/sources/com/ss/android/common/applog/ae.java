package com.ss.android.common.applog;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class ae {
    public static long a() {
        return System.currentTimeMillis();
    }

    public static long a(JSONObject r2, String r3) {
        if (r2 != null) goto L9;
        return 0;
    L9:
        return Long.valueOf(r2.optString(r3)).longValue();
    L11:
        return 0;
    }

    public static boolean a(Object r0, Object r1) {
        if (r0 != null) goto L7;
        if (r1 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return r0.equals(r1);
    }
}
