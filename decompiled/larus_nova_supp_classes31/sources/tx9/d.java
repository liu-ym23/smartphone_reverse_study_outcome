package tx9;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public static void b(boolean r3, long r4, String r6, boolean r7, Integer r8) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r6, "scene");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("is_block", r3);     // Catch: Exception -> L5
        r0.put("scene", r6);     // Catch: Exception -> L5
        r0.put("time_interval_from_cold_start", r4);     // Catch: Exception -> L5
        r0.put("is_improve_asr", r7);     // Catch: Exception -> L5
        r0.put("bot_conversation_type", r8);     // Catch: Exception -> L5
    L7:
        com.larus.platform.service.o.a.reportEvent("rd_add_local_message_start", r0);
        return;
    L5:
        e = move-exception;
        FLogger.a.e("AddLocalMessageEventHelper", "mobAddLocalMessageStart error: " + e.getLocalizedMessage());
        goto L7
    }

    public static void a(boolean r2, String r3, long r4, Integer r6, String r7, long r8, boolean r10, boolean r11, Integer r12, int r13) {
        JSONObject r1 = null;
        if ((r13 & 8) == 0) goto L6;
        r6 = null;
    L6:
        if ((r13 & 16) == 0) goto L9;
        r7 = null;
    L9:
        if ((r13 & 512) == 0) goto L11;
        r1 = new JSONObject();
    L11:
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.put("is_block", r10);     // Catch: Exception -> L19
        r1.put("is_success", r2);     // Catch: Exception -> L19
        r1.put("time_interval_from_cold_start", r4);     // Catch: Exception -> L19
        if (r6 == null) goto L15;
        r1.put("error_code", r6.intValue());     // Catch: Exception -> L19
    L15:
        if (r7 == null) goto L17;
        r1.put("error_msg", r7);     // Catch: Exception -> L19
    L17:
        r1.put("duration", r8);     // Catch: Exception -> L19
        r1.put("scene", r3);     // Catch: Exception -> L19
        r1.put("is_improve_asr", r11);     // Catch: Exception -> L19
        r1.put("bot_conversation_type", r12);     // Catch: Exception -> L19
    L21:
        com.larus.platform.service.o.a.reportEvent("rd_add_local_message_end", r1);
        return;
    L19:
        e = move-exception;
        FLogger.a.e("AddLocalMessageEventHelper", "mobAddLocalMessageEnd error: " + e.getLocalizedMessage());
        goto L21
    }
}
