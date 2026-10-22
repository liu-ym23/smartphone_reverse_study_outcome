package akb;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.statistics.Statistics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends q5c.a {

    public static class a {
        public static final c a = null;

        static {
            a = new c(0);
        }
    }

    public c(int r1) {
    }

    public static void a(ErrorResult r3) {
        JSONObject r0 = new JSONObject();
        r0.put("errorCode", r3.getErrorCode());     // Catch: JSONException -> L6
        r0.put("error", r3.getDebugMsg());     // Catch: JSONException -> L6
    L4:
        Statistics.sendEvent("lark_guide_fetch_info_failed", r0);
    }
}
