package ms.bd.c;

import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class y3 implements SDKMonitor.IGetExtendParams {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ String b;

    public final String getSessionId() {
        return null;
    }

    public final Map getCommonParams() {
        HashMap r1 = new HashMap();
        String r2 = (String) p2.a(16777217, 0, 0, "ffa594", new byte[]{120, 114, 23, 83, 21, 38, 100});     // Catch: JSONException -> L9
        if (JSONObjectProtectorUtils.getBoolean(this.a, (String) p2.a(16777217, 0, 0, "37a3b2", new byte[]{45, 35, 23, 85, 78, 32, 49})) == false) goto L6;
        Object r3 = p2.a(16777217, 0, 0, "1f64af", new byte[]{113});     // Catch: JSONException -> L9
    L7:
        r1.put(r2, (String) r3);     // Catch: JSONException -> L9
    L10:
        r1.put((String) p2.a(16777217, 0, 0, "ecc023", new byte[]{124, 110, 3, 80, 50, 37, 111, 70}), this.b);
        return r1;
    L6:
        r3 = p2.a(16777217, 0, 0, "515e11", new byte[]{116});     // Catch: JSONException -> L9
    L9:
        String r4 = (String) p2.a(16777217, 0, 0, "9ad9f4", new byte[]{59, 102, 26, 114, 94, 48});
        goto L10
    }

    public y3(JSONObject r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
