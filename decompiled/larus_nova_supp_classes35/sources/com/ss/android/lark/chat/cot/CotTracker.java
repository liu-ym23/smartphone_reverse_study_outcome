package com.ss.android.lark.chat.cot;

import com.ss.android.lark.log.Log;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CotTracker {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, CotTracker$statistics$2.INSTANCE);
    }

    public static void a(String r3, JSONObject r4) {
        Log.d("CotTracker", "send event=" + r3 + ", params=" + r4);
        ((o5c.b) a.getValue()).sendEvent(r3, r4);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.w("CotTracker", "send event=" + r3 + " failed", th);
    }

    public static void b(String r2, String r3, String r4, String r5) {
        JSONObject r0 = new JSONObject();
        r0.put("click", r5);
        r0.put("cot_id", r2);
        r0.put("msg_id", r3);
        r0.put("chat_id", r4);
        Unit r6 = Unit.INSTANCE;
        a("im_ai_agent_cot_msg_click", r0);
    }
}
