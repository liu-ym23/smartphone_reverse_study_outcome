package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class p0 {
    public static void a(String r3, String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r3 != null) goto L13;
    L7:
        if (r4 == null) goto L11;
        r0.put(CustomFeedPlayerEvent.EXTRA_KEY_REASON, r4);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("DeepResearchEventHelper", "error in DeepResearchEventHelper mobEndDeepSearch " + e.getLocalizedMessage());
    L11:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("end_deep_research");
        r6.a.merge(r5);
        r6.b();
        return;
    L13:
        r0.put("deep_research_id", r3);     // Catch: JSONException -> L5
        goto L7
    }
}
