package com.ss.android.lark.message.card.view;

import com.ss.android.lark.log.Log;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j {
    public static void a(String r2, JSONObject r3, JSONObject r4) {
        com.ss.android.lark.message.card.b.a().monitorEvent(r2, r3, r4, null);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("ReportUtil", e.getMessage());
    }
}
