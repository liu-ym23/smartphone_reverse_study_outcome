package com.ss.android.lark.inline.ai.creationai;

import com.ss.android.lark.log.Log;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d0 {
    public static long a;
    public static final /* synthetic */ int b = 0;

    public static final class a {
        public static void a(Integer r2, String r3, int r4) {
            JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
            r0.put("errCode", r2);     // Catch: Exception -> L4
            r0.put("errReason", r3);     // Catch: Exception -> L4
            r0.put("cost", r4);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            Log.e("CreationAIReport", "Exception: " + e);
        }
    }

    static {
    }
}
