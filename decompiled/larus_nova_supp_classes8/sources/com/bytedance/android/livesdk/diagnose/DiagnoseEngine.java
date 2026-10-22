package com.bytedance.android.livesdk.diagnose;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.v2;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kt1.a;
import kt1.b;
import kt1.c;
import kt1.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class DiagnoseEngine {
    public static volatile DiagnoseEngine h;
    public final LinkedList<JSONObject> a;
    public final LinkedList<JSONObject> b;
    public final LinkedList<JSONObject> c;
    public final LinkedList<JSONObject> d;
    public final Map<Integer, e> e;
    public boolean f;
    public v2 g;

    public @interface DiagnoseReasonType {
    }

    public @interface DiagnoseType {
    }

    public static DiagnoseEngine d() {
        if (h != null) goto L15;
        monitor-enter(DiagnoseEngine.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (h != null) goto L9;
        h = new DiagnoseEngine();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DiagnoseEngine.class);     // Catch: Throwable -> L11
    L15:
        return h;
    }

    public DiagnoseEngine() {
        this.a = new LinkedList();
        this.b = new LinkedList();
        this.c = new LinkedList();
        this.d = new LinkedList();
        this.e = new ConcurrentHashMap();
        this.g = null;
    }

    public final Map<String, String> a(DiagnoseResult r20) {
        String r2 = DiagnoseResult.KEY_DIAGNOSE_ASSISTANT_INFO;
        String r7 = "diagnoseDataBasicPerformance";
        HashMap r10 = new HashMap();
        r20.monitorInfo.put("diagnose_duration", this.g.diagnoseOnceDuration);     // Catch: Exception -> L52
        StringBuilder r11 = new StringBuilder();     // Catch: Exception -> L52
        StringBuilder r12 = new StringBuilder();     // Catch: Exception -> L52
        StringBuilder r13 = new StringBuilder();     // Catch: Exception -> L52
        StringBuilder r14 = new StringBuilder();     // Catch: Exception -> L52
        if (this.a.size() <= 0) goto L27;
        Iterator<JSONObject> r15 = this.a.iterator();     // Catch: Exception -> L52
    L7:
        if (r15.hasNext() == false) goto L27;
        Iterator<JSONObject> r17 = r15;
        JSONObject r16 = r15.next();     // Catch: Exception -> L52
        String r18 = r2;
        if ((r16.opt(r7) instanceof Map) == false) goto L25;
        Map r3 = (Map) r16.opt(r7);     // Catch: Exception -> L52
        if (r3.isEmpty() == true) goto L25;
        String r19 = r7;
        if (TextUtils.isEmpty((CharSequence) r3.get("anchor_id")) == true) goto L17;
        r11.append((String) r3.get("anchor_id"));     // Catch: Exception -> L52
        r11.append("#");     // Catch: Exception -> L52
    L17:
        if (TextUtils.isEmpty((CharSequence) r3.get("room_id")) == true) goto L20;
        r12.append((String) r3.get("room_id"));     // Catch: Exception -> L52
        r12.append("#");     // Catch: Exception -> L52
    L20:
        if (TextUtils.isEmpty((CharSequence) r3.get("room_type")) == true) goto L23;
        r13.append((String) r3.get("room_type"));     // Catch: Exception -> L52
        r13.append("#");     // Catch: Exception -> L52
    L23:
        if (TextUtils.isEmpty((CharSequence) r3.get("scene")) == true) goto L26;
        r14.append((String) r3.get("scene"));     // Catch: Exception -> L52
        r14.append("#");     // Catch: Exception -> L52
    L26:
        r2 = r18;
        r15 = r17;
        r7 = r19;
    L25:
        r19 = r7;
    L27:
        String r110 = r2;
        r10.put("cb_anchor_id_list", r11.toString());     // Catch: Exception -> L52
        r10.put("cb_room_id_list", r12.toString());     // Catch: Exception -> L52
        r10.put("cb_is_degraded", "-1");     // Catch: Exception -> L52
        r10.put("cb_degraded_list", "");     // Catch: Exception -> L52
        r10.put("cb_room_type_list", r13.toString());     // Catch: Exception -> L52
        if (c.b().b == false) goto L30;
        String r4 = "1";
    L31:
        r10.put("cb_is_anchor", r4);     // Catch: Exception -> L52
        r10.put("cb_scene_list", r14.toString());     // Catch: Exception -> L52
        r10.put("cp_battery_state_duration", "-1");     // Catch: Exception -> L52
        r10.put("cp_cpu_total_rate_avg", "-1");     // Catch: Exception -> L52
        r10.put("cp_low_power_mode_duration", "-1");     // Catch: Exception -> L52
        r10.put("cp_pss_total_count", "-1");     // Catch: Exception -> L52
        r10.put("cp_pss_total_avg", "-1");     // Catch: Exception -> L52
        r10.put("cp_gc_count", "-1");     // Catch: Exception -> L52
        r10.put("cp_java_pss_count", "-1");     // Catch: Exception -> L52
        long r5 = 0;
        if (this.d.size() <= 0) goto L42;
        Iterator<JSONObject> r6 = this.d.iterator();     // Catch: Exception -> L52
    L34:
        boolean r8 = false;
    L36:
        if (r6.hasNext() == false) goto L42;
        if (r6.next().optBoolean("isPK") == false) goto L34;
        if (r8 == false) goto L41;
        r5 = r5 + 15;     // Catch: Exception -> L52
    L41:
        r8 = true;
    L42:
        r10.put("ab_pk_duration", String.valueOf(r5));     // Catch: Exception -> L52
        r10.put("ab_sing_duration", "");     // Catch: Exception -> L52
        r10.put("ab_guest_count", "");     // Catch: Exception -> L52
        r10.put("ab_audience_count", "");     // Catch: Exception -> L52
        r10.put("ab_small_to_big_gift_count", "");     // Catch: Exception -> L52
        r10.put("ab_video_gift_avg", "");     // Catch: Exception -> L52
        r10.put("ab_effect_gift_avg", "");     // Catch: Exception -> L52
        r10.put("ab_comment_num", "");     // Catch: Exception -> L52
        r10.put("ab_digg_avg", "");     // Catch: Exception -> L52
        r10.put("ab_sticker_list", "");     // Catch: Exception -> L52
        r10.put("ab_video_gift_duration", "");     // Catch: Exception -> L52
        r10.put("ab_effect_gift_duration", "");     // Catch: Exception -> L52
        r10.put("ab_diagnose_comment", "");     // Catch: Exception -> L52
        Iterator<String> r9 = r20.monitorInfo.keys();     // Catch: Exception -> L52
    L44:
        if (r9.hasNext() == false) goto L46;
        String r21 = r9.next();     // Catch: Exception -> L52
        r10.put(r21, String.valueOf(r20.monitorInfo.get(r21)));     // Catch: Exception -> L52
        goto L44
    L46:
        JSONObject r0 = r20.monitorInfo.optJSONObject(r110);     // Catch: Exception -> L52
        if (r0 != null) goto L49;
    L54:
        return r10;
    L49:
        if (r0.length() <= 0) goto L54;
        r10.put(r110, r0.toString());     // Catch: Exception -> L52
        goto L54
    L30:
        r4 = "0";
    L52:
        e = move-exception;
        ALogger.e("DiagnoseDiagnoseEngine", e);
        goto L54
    }

    public final boolean b(int r3) {
        if (this.a.isEmpty() == true) goto L5;
        this.a.clear();
    L5:
        this.a.addAll(c.b().d);
        e(this.a);
        if (this.a.size() >= r3) goto L10;
        return false;
    L10:
        if (this.b.isEmpty() == true) goto L12;
        this.b.clear();
    L12:
        this.b.addAll(c.b().f);
        e(this.b);
        if (this.c.isEmpty() == true) goto L15;
        this.c.clear();
    L15:
        this.c.addAll(c.b().g);
        e(this.c);
        if (this.d.isEmpty() == true) goto L18;
        this.d.clear();
    L18:
        this.d.addAll(c.b().h);
        e(this.d);
        return true;
    }

    public final void c(DiagnoseResult r5) {
        StringBuilder r0 = new StringBuilder();     // Catch: Exception -> L18
        if (this.a.isEmpty() == true) goto L13;
        HashMap r1 = new HashMap();     // Catch: Exception -> L18
        r1.put("performanceData", this.a);     // Catch: Exception -> L18
        boolean r2 = a.a(h, r5);     // Catch: Exception -> L18
        if (r2 == false) goto L7;
        r0.append("网络异常#");     // Catch: Exception -> L18
    L7:
        boolean r3 = b.a(h, r1, r5);     // Catch: Exception -> L18
        if (r3 == false) goto L10;
        r0.append("功耗异常");     // Catch: Exception -> L18
    L10:
        if (r2 == true) goto L12;
        if (r3 == false) goto L13;
    L12:
        boolean r4 = true;
    L14:
        if (r4 == true) goto L16;
        r0.append("其他");     // Catch: Exception -> L18
    L16:
        r5.monitorInfo.put(DiagnoseResult.KEY_DIAGNOSE_REASON, r0.toString());     // Catch: Exception -> L18
        return;
    L13:
        r4 = false;
    L18:
        e = move-exception;
        ALogger.e("DiagnoseDiagnoseEngine", e);
    }

    public final void e(LinkedList<JSONObject> r11) {
        long r0 = System.currentTimeMillis();     // Catch: Exception -> L19
        v2 r2 = this.g;     // Catch: Exception -> L19
        if (r2 == null) goto L7;
        long r3 = r2.dataCacheDuration;     // Catch: Exception -> L19
        if (r3 <= 0) goto L7;
    L8:
        boolean r4 = false;
    L9:
        if (r11.isEmpty() == true) goto L32;
        if (r4 == true) goto L33;
        JSONObject r5 = r11.peek();     // Catch: Exception -> L19
        if (r5 == null) goto L18;
        if ((r0 - r5.optLong("addTime")) <= (1000 * r3)) goto L18;
        r11.poll();     // Catch: Exception -> L19
    L18:
        r4 = true;
        goto L9
    L33:
        return;
    L32:
        return;
    L7:
        r3 = 300;
    L19:
        e = move-exception;
        ALogger.e("DiagnoseDiagnoseDiagnoseEngine", e);
    }
}
