package ee8;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public static void b(String r2, String r3, String r4, String r5) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
    L16:
        e = move-exception;
        FLogger.a.e("CotDetailEventHelper", "onDownloadEvent error: " + e.getLocalizedMessage());
    L18:
        TrackParams r6 = new TrackParams().merge(r0);
        by7.a r7 = new by7.a("general_agent_end_task");
        r7.a.merge(r6);
        r7.b();
        return;
    L4:
        if (o0.d(r2) == false) goto L7;
        r0.put("message_id", r2);     // Catch: Exception -> L16
    L7:
        if (o0.d(r3) == false) goto L10;
        r0.put("conversation_id", r3);     // Catch: Exception -> L16
    L10:
        if (o0.d(r4) == false) goto L13;
        r0.put("bot_id", r4);     // Catch: Exception -> L16
    L13:
        if (o0.d(r5) == false) goto L18;
        r0.put("click_from", r5);     // Catch: Exception -> L16
        goto L18
    }

    public static void c(String r2, String r3, String r4, String r5) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
    L16:
        e = move-exception;
        FLogger.a.e("CotDetailEventHelper", "onDownloadEvent error: " + e.getLocalizedMessage());
    L18:
        TrackParams r6 = new TrackParams().merge(r0);
        by7.a r7 = new by7.a("general_agent_end_task_confirm");
        r7.a.merge(r6);
        r7.b();
        return;
    L4:
        if (o0.d(r2) == false) goto L7;
        r0.put("message_id", r2);     // Catch: Exception -> L16
    L7:
        if (o0.d(r3) == false) goto L10;
        r0.put("conversation_id", r3);     // Catch: Exception -> L16
    L10:
        if (o0.d(r4) == false) goto L13;
        r0.put("bot_id", r4);     // Catch: Exception -> L16
    L13:
        if (o0.d(r5) == false) goto L18;
        r0.put("click_from", r5);     // Catch: Exception -> L16
        goto L18
    }

    public static void a(String r2, String r3, String r4, String r5, String r6) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
    L18:
        e = move-exception;
        FLogger.a.e("CotDetailEventHelper", "onDownloadEvent error: " + e.getLocalizedMessage());
    L20:
        TrackParams r7 = new TrackParams().merge(r0);
        by7.a r8 = new by7.a("general_agent_add_thread");
        r8.a.merge(r7);
        r8.b();
        return;
    L4:
        if (o0.d(r2) == false) goto L7;
        r0.put("message_id", r2);     // Catch: Exception -> L18
    L7:
        if (o0.d(r3) == false) goto L10;
        r0.put("conversation_id", r3);     // Catch: Exception -> L18
    L10:
        if (o0.d(r4) == false) goto L13;
        r0.put("bot_id", r4);     // Catch: Exception -> L18
    L13:
        if (o0.d(r5) == false) goto L15;
        r0.put("click_from", r5);     // Catch: Exception -> L18
    L15:
        if (r6 == null) goto L20;
        r0.put("is_answering", r6);     // Catch: Exception -> L18
        goto L20
    }
}
