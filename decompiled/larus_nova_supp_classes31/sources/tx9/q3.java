package tx9;

import com.ixigua.lib.track.TrackParams;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class q3 {
    public static final void b(String r1, JSONObject r2) {
        by7.a r0 = new by7.a(r1);
        TrackParams r3 = new TrackParams().merge(r2);
        r0.a.merge(r3);
        r0.b();
    }

    public static final JSONObject a(String r3, String r4, String r5, String r6, boolean r7) {
        JSONObject r0 = new JSONObject();
        r0.put("current_page", "chat");
        r0.put("option_label", r3);
        if (r4 == null) goto L5;
        r0.put("option_sub_label", r4);
    L5:
        if (r5 == null) goto L7;
        r0.put("skill_option_id", r5);
    L7:
        if (r6 == null) goto L9;
        r0.put("skill_tab", r6);
    L9:
        r0.put("is_search_result", r7 ? 1 : 0);
        return r0;
    }
}
