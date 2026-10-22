package kt1;

import android.text.TextUtils;
import com.bytedance.android.livesdk.config.v2;
import com.bytedance.android.livesdk.diagnose.DiagnoseEngine;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static boolean a(DiagnoseEngine r27, Map r28, DiagnoseResult r29) {
        String r2 = "cpu_rate";
        String r4 = "diagnoseDataBasicPerformance";
        v2 r7 = r27.g;     // Catch: Exception -> L70
        if (r7 == null) goto L69;
        HashMap r8 = (HashMap) r28;     // Catch: Exception -> L70
        if ((r8.get("performanceData") instanceof LinkedList) == false) goto L69;
        LinkedList r5 = (LinkedList) r8.get("performanceData");     // Catch: Exception -> L70
        if (r5 == null) goto L69;
        if (r5.size() <= 0) goto L69;
        boolean r9 = c.b().b;     // Catch: Exception -> L70
        int r10 = r5.size();     // Catch: Exception -> L70
        if (r9 == false) goto L14;
        double r11 = r7.cpuRateAnchor;     // Catch: Exception -> L70
    L15:
        if (r9 == false) goto L17;
        double r12 = r7.gpuAnchor;     // Catch: Exception -> L70
    L18:
        StringBuilder r13 = new StringBuilder();     // Catch: Exception -> L70
        StringBuilder r14 = new StringBuilder();     // Catch: Exception -> L70
        StringBuilder r15 = new StringBuilder();     // Catch: Exception -> L70
        StringBuilder r16 = new StringBuilder();     // Catch: Exception -> L70
        Iterator r6 = r5.iterator();     // Catch: Exception -> L70
        double r18 = 0.0d;
        double r20 = 0.0d;
        int r3 = 0;
        int r17 = 0;
    L19:
        if (r6.hasNext() == false) goto L49;
        Iterator r210 = r6;
        JSONObject r19 = (JSONObject) r6.next();     // Catch: Exception -> L70
        if ((r19.opt(r4) instanceof Map) == false) goto L46;
        Map r0 = (Map) r19.opt(r4);     // Catch: Exception -> L70
        if (r0.isEmpty() == true) goto L46;
        String r23 = r4;
        if (TextUtils.isEmpty((CharSequence) r0.get(r2)) == true) goto L36;
        String r24 = r2;
        int r211 = r3;
        double r21 = CastDoubleProtector.parseDouble((String) r0.get(r2));     // Catch: Exception -> L70
        if (r21 <= 0.0d) goto L31;
    L33:
        r18 = r18 + r21;     // Catch: Exception -> L70
        if (r21 <= r11) goto L38;
        r17 = r17 + 1;     // Catch: Exception -> L70
        r13.append(r21);     // Catch: Exception -> L70
        r13.append("#");     // Catch: Exception -> L70
    L38:
        if (TextUtils.isEmpty((CharSequence) r0.get("gpu_usage")) == true) goto L47;
        double r22 = CastDoubleProtector.parseDouble((String) r0.get("gpu_usage"));     // Catch: Exception -> L70
        if (r22 > 0.0d) goto L42;
        r16.append(r22);     // Catch: Exception -> L70
        r16.append("#");     // Catch: Exception -> L70
        r22 = 0.0d;
    L42:
        r20 = r20 + r22;     // Catch: Exception -> L70
        if (r22 <= r12) goto L47;
        int r1 = r211 + 1;     // Catch: Exception -> L70
        r15.append(r22);     // Catch: Exception -> L70
        r15.append("#");     // Catch: Exception -> L70
        r3 = r1;
    L48:
        r6 = r210;
        r4 = r23;
        r2 = r24;
    L47:
        r3 = r211;
        goto L48
    L31:
        if (r21 <= 1.0d) goto L33;
        r14.append(r21);     // Catch: Exception -> L70
        r14.append("#");     // Catch: Exception -> L70
        r21 = 0.0d;
        goto L33
    L36:
        r24 = r2;
        r211 = r3;
    L46:
        r24 = r2;
        r211 = r3;
        r23 = r4;
        goto L47
    L49:
        int r212 = r3;
        if (r10 <= 0) goto L52;
        double r25 = r10;
        r18 = r18 / r25;
        r20 = r20 / r25;
    L52:
        double r26 = r18;
        double r30 = r20;
        if (r26 <= r11) goto L55;
    L58:
        boolean r31 = true;
        DiagnoseResult r32 = r29;
        JSONObject r33 = r32.monitorInfo.optJSONObject(DiagnoseResult.KEY_DIAGNOSE_ASSISTANT_INFO);     // Catch: Exception -> L67
        if (r33 != null) goto L62;
        r33 = new JSONObject();     // Catch: Exception -> L67
    L62:
        r33.put("cpu_rate_over_list", r13.toString());     // Catch: Exception -> L67
        r33.put("cpu_rate_error_list", r14.toString());     // Catch: Exception -> L67
        r33.put("gpu_over_list", r15.toString());     // Catch: Exception -> L67
        r33.put("gpu_error_list", r16.toString());     // Catch: Exception -> L67
        r32.monitorInfo.put(DiagnoseResult.KEY_DIAGNOSE_ASSISTANT_INFO, r33);     // Catch: Exception -> L67
    L78:
        r32.monitorInfo.put("cp_cpu_rate_over_count", r17);     // Catch: Exception -> L65
        r32.monitorInfo.put("cp_cpu_rate_avg", r26);     // Catch: Exception -> L65
        r32.monitorInfo.put("cp_gpu_over_count", r212);     // Catch: Exception -> L65
        r32.monitorInfo.put("cp_gpu_usage_avg", r30);     // Catch: Exception -> L65
        return r31;
    L65:
        e = e;
        boolean r34 = r31;
    L72:
        e.printStackTrace();
        return r34;
    L67:
        e = e;
        r34 = true;
        goto L72
    L55:
        if (r30 > r12) goto L58;
        r32 = r29;
        r31 = false;
        goto L78
    L17:
        r12 = r7.gpu;     // Catch: Exception -> L70
        goto L18
    L14:
        r11 = r7.cpuRate;     // Catch: Exception -> L70
    L69:
        return false;
    L70:
        e = e;
        r34 = false;
        goto L72
    }
}
