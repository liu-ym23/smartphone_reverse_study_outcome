package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class o {
    public static void a(String r2, String r3, String r4, String r5, by7.e r6) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L19;
    L7:
        r0.put("click_from", r3);     // Catch: JSONException -> L5
        if (r4 == null) goto L10;
        r0.put("from_activity_name", r4);     // Catch: JSONException -> L5
    L10:
        if (r5 == null) goto L14;
        r0.put("from_activity_module", r5);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("BotEventHelper", "error in BotEventHelper botMakerCardClick " + e.getLocalizedMessage());
    L14:
        TrackParams r7 = new TrackParams().merge(r0);
        by7.a r8 = new by7.a("bot_maker_card_click");
        if (r6 == null) goto L17;
        r8.b = r6;
    L17:
        r8.a.merge(r7);
        r8.b();
        return;
    L19:
        r0.put("previous_page", r2);     // Catch: JSONException -> L5
        goto L7
    }
}
