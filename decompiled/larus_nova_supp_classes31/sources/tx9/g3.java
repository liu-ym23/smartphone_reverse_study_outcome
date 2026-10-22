package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g3 {
    public static void a(String r1, String r2, String r3, String r4, String r5, String r6, JSONObject r7) {
        Intrinsics.checkNotNullParameter(r7, "params");
        r7.put("bot_from_status", r1);     // Catch: JSONException -> L23
        if (r2 == null) goto L6;
        r7.put("bot_id", r2);     // Catch: JSONException -> L23
    L6:
        if (r3 == null) goto L8;
        r7.put("call_id", r3);     // Catch: JSONException -> L23
    L8:
        if (r5 == null) goto L11;
        r7.put("conversation_id", r5);     // Catch: JSONException -> L23
    L11:
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        if (r4.length() != 0) goto L16;
        boolean r8 = true;
    L17:
        if (r8 == false) goto L19;
        r4 = "abnormal_exit";
    L19:
        r7.put("enter_method", r4);     // Catch: JSONException -> L23
        if (r6 == null) goto L25;
        r7.put("call_scene", r6);     // Catch: JSONException -> L23
    L25:
        TrackParams r9 = new TrackParams().merge(r7);
        by7.a r10 = new by7.a("mute_call");
        r10.a.merge(r9);
        r10.b();
        return;
    L16:
        r8 = false;
    L23:
        e = move-exception;
        FLogger.a.e("RtcEventHelper", "error in mobMuteCall muteCall " + e.getLocalizedMessage());
        goto L25
    }
}
