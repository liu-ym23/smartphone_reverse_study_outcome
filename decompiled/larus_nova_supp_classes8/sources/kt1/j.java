package kt1;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.v2;
import com.bytedance.android.livesdk.diagnose.DiagnoseEngine;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j implements e {
    public j() {
    }

    @Override // kt1.e
    public final DiagnoseResult a(DiagnoseEngine r24, DiagnoseResult r25) {
        DiagnoseEngine r0 = r24;
        String r3 = "diagnoseDataBasicPerformance";
    L56:
        e = move-exception;
        ALogger.e("DiagnoseIDiagnoseProcessor", e);
    L58:
        return r25;
    L4:
        if (c.b().a == false) goto L58;
        v2 r5 = r0.g;     // Catch: Exception -> L56
        if (r5 == null) goto L58;
        v2.c r6 = r5.diagnoseTypeUIStall;     // Catch: Exception -> L56
        if (r6 == null) goto L58;
        if (r6.enable == false) goto L58;
        StringBuilder r7 = new StringBuilder();     // Catch: Exception -> L56
        StringBuilder r8 = new StringBuilder();     // Catch: Exception -> L56
        if (r0.a.isEmpty() == true) goto L48;
        int r9 = r0.a.size();     // Catch: Exception -> L56
        int r12 = 0;
        double r13 = 0.0d;
        int r15 = 0;
    L14:
        if (r12 >= r9) goto L41;
        JSONObject r11 = r0.a.get(r12);     // Catch: Exception -> L56
        new HashMap();     // Catch: Exception -> L56
        if ((r11.get(r3) instanceof Map) == false) goto L39;
        Map r10 = (Map) r11.get(r3);     // Catch: Exception -> L56
        if (TextUtils.equals("1", (String) r10.get("has_stall")) == false) goto L20;
        r15 = r15 + 1;     // Catch: Exception -> L56
    L20:
        String r14 = (String) r10.get("stall_ui_rate");     // Catch: Exception -> L56
        if (TextUtils.isEmpty(r14) == true) goto L32;
        double r19 = CastDoubleProtector.parseDouble(r14);     // Catch: Exception -> L56
        if (r19 >= 0.0d) goto L26;
    L27:
        r19 = 0.0d;
    L28:
        double r16 = r13 + r19;     // Catch: Exception -> L56
        if (r19 < r5.diagnoseTypeUIStall.uiStallRate) goto L31;
        r8.append(r14);     // Catch: Exception -> L56
        r8.append("#");     // Catch: Exception -> L56
    L31:
        r13 = r16;
        goto L32
    L26:
        if (r19 <= 1.0d) goto L28;
    L32:
        String r17 = (String) r10.get("fps");     // Catch: Exception -> L56
        if (TextUtils.isEmpty(r17) == true) goto L37;
        String r110 = r3;
        double r20 = r13;
        if (CastDoubleProtector.parseDouble(r17) < r5.diagnoseTypeUIStall.fps) goto L38;
        r7.append(r17);     // Catch: Exception -> L56
        r7.append("#");     // Catch: Exception -> L56
    L38:
        r13 = r20;
    L40:
        r12 = r12 + 1;     // Catch: Exception -> L56
        r0 = r24;
        r3 = r110;
        goto L14
    L37:
        r110 = r3;
        r20 = r13;
        goto L38
    L39:
        r110 = r3;
        goto L40
    L41:
        double r18 = r9;
        double r111 = 0.0d / r18;     // Catch: Exception -> L56
        double r112 = r13 / r18;     // Catch: Exception -> L56
        v2.c r1 = r5.diagnoseTypeUIStall;     // Catch: Exception -> L56
        if (r15 >= r1.hasStallCount) goto L44;
    L46:
        boolean r113 = false;
    L47:
        double r21 = r111;
        int r114 = r15;
    L49:
        r25.monitorInfo.put("cp_ui_has_stall_count", r114);     // Catch: Exception -> L56
        r25.monitorInfo.put("cp_ui_stall_count_avg", r21);     // Catch: Exception -> L56
        if (r113 == false) goto L58;
        JSONArray r2 = r25.monitorInfo.optJSONArray(DiagnoseResult.KEY_DIAGNOSE_TYPE);     // Catch: Exception -> L56
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L56
        r4.put(DiagnoseResult.KEY_DIAGNOSE_TYPE, DiagnoseResult.DIAGNOSE_TYPE_UI_STALL);     // Catch: Exception -> L56
        r4.put(DiagnoseResult.KEY_DIAGNOSE_LEVEL, DiagnoseResult.DIAGNOSE_LEVEL_P2);     // Catch: Exception -> L56
        r2.put(r4);     // Catch: Exception -> L56
        JSONObject r22 = r25.monitorInfo.optJSONObject(DiagnoseResult.KEY_DIAGNOSE_ASSISTANT_INFO);     // Catch: Exception -> L56
        if (r22 != null) goto L54;
        r22 = new JSONObject();     // Catch: Exception -> L56
    L54:
        r22.put("fps_over_list", r7.toString());     // Catch: Exception -> L56
        r22.put("ui_stall_rate_over_list", r8.toString());     // Catch: Exception -> L56
        r25.monitorInfo.put(DiagnoseResult.KEY_DIAGNOSE_ASSISTANT_INFO, r22);     // Catch: Exception -> L56
        goto L58
    L44:
        if (r112 < r1.uiStallRate) goto L46;
        r113 = true;
        goto L47
    L48:
        r21 = 0.0d;
        r114 = 0;
        r113 = false;
        goto L49
    }
}
