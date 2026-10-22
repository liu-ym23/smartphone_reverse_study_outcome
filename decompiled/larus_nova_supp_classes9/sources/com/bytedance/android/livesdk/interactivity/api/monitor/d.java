package com.bytedance.android.livesdk.interactivity.api.monitor;

import com.bytedance.android.live.core.log.ALogger;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public static final void a(JSONObject r1, String r2, String r3) {
    L6:
        e = move-exception;
        ALogger.e("InteractivityTraceMonitor", e);
        return;
    L3:
        if (r1.has(r2) == true) goto L11;
        r1.putOpt(r2, r3);     // Catch: Exception -> L6
        return;
    }
}
