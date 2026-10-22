package tx9;

import com.ixigua.lib.track.TrackParams;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class y1 {
    public static final void b(String r1, JSONObject r2) {
        by7.a r0 = new by7.a(r1);
        TrackParams r3 = new TrackParams().merge(r2);
        r0.a.merge(r3);
        r0.b();
    }

    public static final JSONObject a(String r3, String r4, boolean r5) {
        JSONObject r0 = new JSONObject();
        r0.put("current_page", "chat");
        r0.put("skill_id", "");
        r0.put("mention_type", r3);
        r0.put("item_name", r4);
        r0.put("is_search_result", r5 ? 1 : 0);
        return r0;
    }
}
