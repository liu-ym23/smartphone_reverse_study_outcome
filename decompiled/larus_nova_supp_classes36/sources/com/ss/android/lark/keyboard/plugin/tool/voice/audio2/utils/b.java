package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r5, Pair... r6) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L7
        int r1 = r6.length;     // Catch: Exception -> L7
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        Pair r3 = r6[r2];     // Catch: Exception -> L7
        r0.put((String) r3.getFirst(), r3.getSecond());     // Catch: Exception -> L7
        r2 = r2 + 1;     // Catch: Exception -> L7
        goto L3
    L5:
        Statistics.sendEvent(r5, r0);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        Log.e("AudioHitPointUtil", "sendHitPoint / event: " + r5 + ", error: " + e);
    }
}
