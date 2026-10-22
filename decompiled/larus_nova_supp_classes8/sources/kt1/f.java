package kt1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.v2;
import com.bytedance.android.livesdk.diagnose.DiagnoseEngine;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements Consumer<Long> {
    public f() {
    }

    public final void accept(Object r12) throws Exception {
        Long r13 = (Long) r12;
        if (h.a == true) goto L54;
        DiagnoseEngine r14 = DiagnoseEngine.d();
        if (r14.f == true) goto L55;
        v2 r2 = r14.g;
        if (r2 == null) goto L21;
        int r3 = r2.strategy;
        if (r3 != 1) goto L12;
        boolean r4 = c.b().b;
    L19:
        if (r4 == false) goto L21;
        boolean r5 = true;
    L22:
        if (r5 == false) goto L56;
        r14.f = true;
        DiagnoseResult r6 = new DiagnoseResult();
    L42:
        e = move-exception;
        ALogger.e("DiagnoseDiagnoseEngine", e);
    L44:
        r14.f = false;
        return;
    L26:
        if (r14.b(r14.g.diagnoseDataSize) == false) goto L44;
        r6.monitorInfo.put(DiagnoseResult.KEY_DIAGNOSE_TYPE, new JSONArray());     // Catch: Exception -> L42
        Iterator r7 = ((ConcurrentHashMap) r14.e).keySet().iterator();     // Catch: Exception -> L42
    L29:
        if (r7.hasNext() == false) goto L33;
        e r8 = (e) ((ConcurrentHashMap) r14.e).get((Integer) r7.next());     // Catch: Exception -> L42
        if (r8 == null) goto L29;
        r6 = r8.a(DiagnoseEngine.h, r6);     // Catch: Exception -> L42
        goto L29
    L33:
        JSONArray r9 = r6.monitorInfo.optJSONArray(DiagnoseResult.KEY_DIAGNOSE_TYPE);     // Catch: Exception -> L42
        if (r9 == null) goto L44;
        if (r9.length() <= 0) goto L44;
        r14.c(r6);     // Catch: Exception -> L42
        Map<String, String> r10 = r14.a(r6);     // Catch: Exception -> L42
        int r11 = 0;
    L38:
        if (r11 >= r9.length()) goto L44;
        JSONObject r15 = (JSONObject) r9.get(r11);     // Catch: Exception -> L42
        HashMap r16 = (HashMap) r10;     // Catch: Exception -> L42
        r16.put(DiagnoseResult.KEY_DIAGNOSE_TYPE, r15.optString(DiagnoseResult.KEY_DIAGNOSE_TYPE));     // Catch: Exception -> L42
        r16.put(DiagnoseResult.KEY_DIAGNOSE_LEVEL, r15.optString(DiagnoseResult.KEY_DIAGNOSE_LEVEL));     // Catch: Exception -> L42
        u.l().sendLog("livesdk_performance_diagnose_base", r10, new Object[]{Room.class});     // Catch: Exception -> L42
        r11 = r11 + 1;
        goto L38
    L56:
        return;
    L12:
        if (r3 != 2) goto L14;
        r4 = !c.b().b;
        goto L19
    L14:
        if (r3 == 3) goto L16;
        r4 = false;
        goto L19
    L16:
        r4 = true;
    L21:
        r5 = false;
        goto L22
    L55:
        return;
    }
}
