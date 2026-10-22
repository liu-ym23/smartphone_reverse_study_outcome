package x40;

import com.bytedance.android.live.core.activity.ActivityMonitor;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.JvmStatic;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void c(JSONObject r0, String r1, String r2) {
        r0.put(r1, r2);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        ALogger.e("SchemaMonitor", e);
    }

    @JvmStatic
    public static final void b(String r3, String r4, String r5, JSONObject r6) {
        if (e.a(r5) == false) goto L14;
        if (r3 == null) goto L15;
        JSONObject r7 = new JSONObject();
        r7.put("status_code", 0);     // Catch: JSONException -> L8
    L10:
        c(r7, "enter_room_type", "draw");
        c(r7, "enter_method", r4);
        c(r7, "enter_from_merge", r5);
        ActivityMonitor.c("ttlive_enter_room_feed_api_result", r7, null, r6);
        return;
    L8:
        e = move-exception;
        ALogger.e("SchemaMonitor", e);
        goto L10
    L15:
        return;
    }

    @JvmStatic
    public static final void a(String r2, int r3, String r4, String r5, String r6, JSONObject r7) {
        if (r2 == null) goto L15;
        JSONObject r8 = new JSONObject();
        r8.put("status_code", r3);     // Catch: JSONException -> L6
    L8:
        c(r8, "enter_room_type", r6);
        if (e.a(r5) == false) goto L11;
        c(r8, "enter_method", r4);
        c(r8, "enter_from_merge", r5);
    L11:
        ActivityMonitor.c("ttlive_enter_room_schema_param_result", r8, null, r7);
        return;
    L6:
        e = move-exception;
        ALogger.e("SchemaMonitor", e);
        goto L8
    }
}
