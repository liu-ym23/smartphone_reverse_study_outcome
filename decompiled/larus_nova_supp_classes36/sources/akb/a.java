package akb;

import com.bytedance.apm.ApmAgent;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(boolean r2, long r3, String r5) {
        JSONObject r0 = new JSONObject();
        r0.put("succeed", r2);
        JSONObject r4 = new JSONObject();
        r4.put("cost", r3);
        JSONObject r6 = new JSONObject();
        r6.put("error_msg", r5);
        ApmAgent.monitorEvent("ug_get_user_guide", r0, r4, r6);
    }

    public static void b(boolean r2, long r3, String r5, Integer r6, String r7) {
        JSONObject r0 = new JSONObject();
        r0.put("succeed", r2);
        r0.put("error_code", r6);
        r0.put("guide_keys", r5);
        JSONObject r4 = new JSONObject();
        r4.put("cost", r3);
        JSONObject r8 = new JSONObject();
        r8.put("error_msg", r7);
        ApmAgent.monitorEvent("ug_post_user_consuming_guide", r0, r4, r8);
    }
}
