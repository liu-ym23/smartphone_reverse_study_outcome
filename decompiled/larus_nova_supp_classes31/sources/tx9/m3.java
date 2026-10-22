package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class m3 {
    public static void a(String r2, String r3, Long r4, String r5, String r6, String r7, String r8, String r9, Long r10, JSONObject r11, TraceFragment r12, int r13) {
        if ((r13 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r13 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r13 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r13 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r13 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r13 & 256) == 0) goto L30;
        r10 = null;
    L30:
        if ((r13 & 512) == 0) goto L33;
        r11 = new JSONObject();
    L33:
        if ((r13 & 1024) == 0) goto L35;
        r12 = null;
    L35:
        Intrinsics.checkNotNullParameter(r11, "params");
        if (r2 != null) goto L63;
    L40:
        if (r3 == null) goto L42;
        r11.put("current_page", r3);     // Catch: JSONException -> L38
    L42:
        if (r4 == null) goto L44;
        r11.put("err_code", r4.longValue());     // Catch: JSONException -> L38
    L44:
        if (r5 == null) goto L46;
        r11.put("err_tips", r5);     // Catch: JSONException -> L38
    L46:
        if (r6 == null) goto L48;
        r11.put("group_type", r6);     // Catch: JSONException -> L38
    L48:
        if (r7 == null) goto L50;
        r11.put("is_immersive_background", r7);     // Catch: JSONException -> L38
    L50:
        if (r8 == null) goto L52;
        r11.put("recommend_from", r8);     // Catch: JSONException -> L38
    L52:
        if (r9 == null) goto L54;
        r11.put("req_id", r9);     // Catch: JSONException -> L38
    L54:
        if (r10 == null) goto L58;
        r11.put("success", r10.longValue());     // Catch: JSONException -> L38
    L38:
        e = move-exception;
        FLogger.a.e("SettingEventHelper", "error in SettingEventHelper settingClearMessageResult " + e.getLocalizedMessage());
    L58:
        TrackParams r14 = new TrackParams().merge(r11);
        by7.a r15 = new by7.a("setting_clear_message_result");
        if (r12 == null) goto L61;
        r15.b = r12;
    L61:
        r15.a.merge(r14);
        r15.b();
        return;
    L63:
        r11.put("bot_id", r2);     // Catch: JSONException -> L38
        goto L40
    }
}
