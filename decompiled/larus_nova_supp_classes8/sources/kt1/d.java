package kt1;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.v2;
import com.bytedance.android.livesdk.diagnose.DiagnoseEngine;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements e {
    public d() {
    }

    @Override // kt1.e
    public final DiagnoseResult a(DiagnoseEngine r10, DiagnoseResult r11) {
    L32:
        e = move-exception;
        ALogger.e("DiagnoseIDiagnoseProcessor", e);
    L34:
        return r11;
    L4:
        if (c.b().a == false) goto L34;
        v2 r2 = r10.g;     // Catch: Exception -> L32
        if (r2 == null) goto L34;
        v2.a r3 = r2.diagnoseTypeHot;     // Catch: Exception -> L32
        if (r3 == null) goto L34;
        if (r3.enable == false) goto L34;
        if (c.b().b == false) goto L14;
        double r4 = r2.diagnoseTypeHot.temperatureAnchor;     // Catch: Exception -> L32
    L15:
        int r5 = 0;
        if (r10.a.isEmpty() == true) goto L29;
        int r6 = 0;
    L19:
        if (r5 >= r10.a.size()) goto L28;
        JSONObject r7 = r10.a.get(r5);     // Catch: Exception -> L32
        if ((r7.opt("diagnoseDataBasicPerformance") instanceof Map) == false) goto L27;
        String r8 = (String) ((Map) r7.opt("diagnoseDataBasicPerformance")).get("thermal");     // Catch: Exception -> L32
        if (TextUtils.isEmpty(r8) == true) goto L27;
        if (new JSONObject(r8).optDouble("value") <= r4) goto L27;
        r6 = 1;
    L27:
        r5 = r5 + 1;     // Catch: Exception -> L32
        goto L19
    L28:
        r5 = r6;
    L29:
        if (r5 == 0) goto L34;
        JSONArray r12 = r11.monitorInfo.optJSONArray(DiagnoseResult.KEY_DIAGNOSE_TYPE);     // Catch: Exception -> L32
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L32
        r0.put(DiagnoseResult.KEY_DIAGNOSE_TYPE, DiagnoseResult.DIAGNOSE_TYPE_HOT);     // Catch: Exception -> L32
        r0.put(DiagnoseResult.KEY_DIAGNOSE_LEVEL, DiagnoseResult.DIAGNOSE_LEVEL_P2);     // Catch: Exception -> L32
        r12.put(r0);     // Catch: Exception -> L32
        goto L34
    L14:
        r4 = r2.diagnoseTypeHot.temperature;     // Catch: Exception -> L32
        goto L15
    }
}
