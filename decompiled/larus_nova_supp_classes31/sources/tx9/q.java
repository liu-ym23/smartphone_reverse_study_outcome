package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class q {
    public static final void a(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, Long r10, String r11, JSONObject r12, by7.e r13) {
        Intrinsics.checkNotNullParameter(r12, "params");
        if (r1 != null) goto L34;
    L7:
        if (r2 == null) goto L9;
        r12.put("current_page", r2);     // Catch: JSONException -> L5
    L9:
        if (r3 == null) goto L11;
        r12.put("previous_page", r3);     // Catch: JSONException -> L5
    L11:
        if (r4 == null) goto L13;
        r12.put("chat_type", r4);     // Catch: JSONException -> L5
    L13:
        if (r5 == null) goto L15;
        r12.put("bot_id", r5);     // Catch: JSONException -> L5
    L15:
        if (r6 == null) goto L17;
        r12.put("conversation_id", r6);     // Catch: JSONException -> L5
    L17:
        if (r7 == null) goto L19;
        r12.put("message_id", r7);     // Catch: JSONException -> L5
    L19:
        if (r8 == null) goto L21;
        r12.put("show_from", r8);     // Catch: JSONException -> L5
    L21:
        if (r9 == null) goto L23;
        r12.put("section_id", r9);     // Catch: JSONException -> L5
    L23:
        if (r10 == null) goto L25;
        r12.put("with_code", r10.longValue());     // Catch: JSONException -> L5
    L25:
        if (r11 == null) goto L29;
        r12.put("code_type", r11);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("ButtonEventHelper", "error in ButtonEventHelper showButton " + e.getLocalizedMessage());
    L29:
        TrackParams r14 = new TrackParams().merge(r12);
        by7.a r15 = new by7.a("show_button");
        if (r13 == null) goto L32;
        r15.b = r13;
    L32:
        r15.a.merge(r14);
        r15.b();
        return;
    L34:
        r12.put("button_name", r1);     // Catch: JSONException -> L5
        goto L7
    }
}
