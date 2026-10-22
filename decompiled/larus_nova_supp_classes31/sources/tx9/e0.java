package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e0 {
    public static void b(Long r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r4 != null) goto L10;
    L8:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r1 = new by7.a("delete_own_voice_result");
        r1.a.merge(r5);
        r1.b();
        return;
    L10:
        r0.put("success", r4.longValue());     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        FLogger.a.e("CloneVoiceEventHelper", "error in CloneVoiceEventHelper refreshBotResult " + e.getLocalizedMessage());
        goto L8
    }

    public static void c(Long r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r4 != null) goto L10;
    L8:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r1 = new by7.a("edit_own_voice_name_result");
        r1.a.merge(r5);
        r1.b();
        return;
    L10:
        r0.put("success", r4.longValue());     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        FLogger.a.e("CloneVoiceEventHelper", "error in CloneVoiceEventHelper refreshBotResult " + e.getLocalizedMessage());
        goto L8
    }

    public static void a(String r3, Long r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r3 != null) goto L13;
    L7:
        if (r4 == null) goto L11;
        r0.put("success", r4.longValue());     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("CloneVoiceEventHelper", "error in CloneVoiceEventHelper refreshBotResult " + e.getLocalizedMessage());
    L11:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("check_own_voice_result");
        r6.a.merge(r5);
        r6.b();
        return;
    L13:
        r0.put("previous_page", r3);     // Catch: JSONException -> L5
        goto L7
    }
}
