package com.larus.audio.flow.client.mob;

import android.os.SystemClock;
import h68.e;
import j78.a;
import j78.b;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import m58.h;
import m58.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class FlowAudioAsrAndTTSCostMobHelper {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(new a());
        b = LazyKt.lazy(new b());
    }

    public static void a(y58.b r5) {
        Intrinsics.checkNotNullParameter(r5, "result");
        JSONObject r0 = (JSONObject) ((FlowAudioAsrAndTTSCostMobHelper$asrMap$2$1) a.getValue()).get(r5.a);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.has("on_asr_end") == true) goto L15;
        ConcurrentHashMap<String, e> r2 = g68.a.a;
        y58.a r3 = g68.a.c(r5.a);
        if (r3 == null) goto L9;
        String r4 = r3.y;
    L10:
        r0.put("err_code", r5.b);
        r0.put("err_msg", r5.c);
        r0.put("bot_id", r4);
        r0.put("on_asr_end", SystemClock.elapsedRealtime());
        s r6 = h.b;
        if (r6 == null) goto L16;
        r6.report("flow_asr_recog_trace", r0);
        return;
    L16:
        return;
    L9:
        r4 = null;
        goto L10
    }

    public static void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "msgId");
        JSONObject r4 = (JSONObject) ((FlowAudioAsrAndTTSCostMobHelper$ttsMap$2$1) b.getValue()).get(r3);
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.has("on_start_tts_to_sami") == true) goto L9;
        r4.put("on_start_tts_to_sami", SystemClock.elapsedRealtime());
        return;
    }

    public static void c(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "msgId");
        Intrinsics.checkNotNullParameter(r6, "funcChannel");
        FlowAudioAsrAndTTSCostMobHelper$ttsMap$2$1 r0 = (FlowAudioAsrAndTTSCostMobHelper$ttsMap$2$1) b.getValue();
        JSONObject r1 = new JSONObject();
        r1.put("start_tts_wait", SystemClock.elapsedRealtime());
        r1.put("func_channel", r6);
        r1.put("msg_id", r5);
        r0.put(r5, r1);
    }

    public static void d(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "taskId");
        Intrinsics.checkNotNullParameter(r6, "funcChannel");
        FlowAudioAsrAndTTSCostMobHelper$asrMap$2$1 r0 = (FlowAudioAsrAndTTSCostMobHelper$asrMap$2$1) a.getValue();
        JSONObject r1 = new JSONObject();
        r1.put("start_asr_recog_delay", SystemClock.elapsedRealtime());
        r1.put("func_channel", r6);
        r1.put("task_id", r5);
        r0.put(r5, r1);
    }
}
