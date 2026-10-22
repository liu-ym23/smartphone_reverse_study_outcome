package kt1;

import com.bytedance.android.livesdk.config.v2;
import com.bytedance.android.livesdk.diagnose.DiagnoseEngine;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static boolean a(DiagnoseEngine r10, DiagnoseResult r11) {
        boolean r1 = false;
        v2 r2 = r10.g;     // Catch: Exception -> L20
        if (r2 != null) goto L6;
    L22:
        return r1;
    L6:
        if (r10.a.size() <= 0) goto L22;
        StringBuilder r3 = new StringBuilder();     // Catch: Exception -> L20
        int r4 = r10.a.size();     // Catch: Exception -> L20
        float r5 = 0.0f;
        int r6 = 0;
    L8:
        if (r6 >= r4) goto L14;
        int r7 = r10.a.get(r6).optInt("net_quality", 6);     // Catch: Exception -> L20
        r5 = r5 + r7;     // Catch: Exception -> L20
        if (r7 > r2.netStatus) goto L12;
        r3.append(r7);     // Catch: Exception -> L20
        r3.append("#");     // Catch: Exception -> L20
    L12:
        r6 = r6 + 1;     // Catch: Exception -> L20
        goto L8
    L14:
        if ((r5 / r4) >= r2.netStatus) goto L22;
        r1 = true;
        JSONObject r12 = r11.monitorInfo.optJSONObject(DiagnoseResult.KEY_DIAGNOSE_ASSISTANT_INFO);     // Catch: Exception -> L20
        if (r12 != null) goto L18;
        r12 = new JSONObject();     // Catch: Exception -> L20
    L18:
        r12.put("net_status_over_list", r3.toString());     // Catch: Exception -> L20
        r11.monitorInfo.put(DiagnoseResult.KEY_DIAGNOSE_ASSISTANT_INFO, r12);     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }
}
