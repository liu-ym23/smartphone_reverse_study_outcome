package kt1;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.v2;
import com.bytedance.android.livesdk.diagnose.DiagnoseEngine;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i implements e {
    public i() {
    }

    @Override // kt1.e
    public final DiagnoseResult a(DiagnoseEngine r39, DiagnoseResult r40) {
        String r2 = DiagnoseResult.KEY_DIAGNOSE_ASSISTANT_INFO;
        String r3 = DiagnoseResult.KEY_DIAGNOSE_TYPE;
        String r4 = "diagnoseDataBasicPerformance";
    L113:
        e = move-exception;
        ALogger.e("DiagnoseIDiagnoseProcessor", e);
    L115:
        return r40;
    L4:
        if (c.b().a == false) goto L115;
        v2 r5 = r39.g;     // Catch: Exception -> L113
        if (r5 == null) goto L115;
        v2.b r6 = r5.diagnoseTypeStreamStall;     // Catch: Exception -> L113
        if (r6 == null) goto L115;
        if (r6.enable == false) goto L115;
        StringBuilder r7 = new StringBuilder();     // Catch: Exception -> L113
        StringBuilder r8 = new StringBuilder();     // Catch: Exception -> L113
        StringBuilder r9 = new StringBuilder();     // Catch: Exception -> L113
        StringBuilder r10 = new StringBuilder();     // Catch: Exception -> L113
        String r11 = "cs_preview_fps_avg";
        String r12 = "cs_preview_fps_count";
        boolean r16 = true;
        boolean r17 = false;
        if (c.b().b == true) goto L15;
        String r29 = DiagnoseResult.KEY_DIAGNOSE_ASSISTANT_INFO;
        String r30 = DiagnoseResult.KEY_DIAGNOSE_TYPE;
        StringBuilder r27 = r9;
        StringBuilder r28 = r10;
        String r13 = "cs_preview_fps_count";
        if (r39.c.isEmpty() == true) goto L60;
        double r14 = 0.0d;
        int r15 = 0;
        int r18 = 0;
    L46:
        if (r15 >= r39.c.size()) goto L61;
        JSONObject r19 = r39.c.get(r15);     // Catch: Exception -> L113
        if (r19 == null) goto L59;
        if (r19.length() <= 0) goto L59;
        String r110 = r19.optString("event_key");     // Catch: Exception -> L113
        if (TextUtils.equals(r110, "render_stall") == false) goto L55;
        r18 = r18 + 1;     // Catch: Exception -> L113
        r14 = r14 + 1.0d;     // Catch: Exception -> L113
        goto L59
    L55:
        if (TextUtils.equals(r110, "demux_stall") == false) goto L57;
    L58:
        r18 = r18 + 1;     // Catch: Exception -> L113
        goto L59
    L57:
        if (TextUtils.equals(r110, "stall") == true) goto L58;
    L59:
        r15 = r15 + 1;     // Catch: Exception -> L113
    L61:
        double r25 = r14;
        if (r39.a.isEmpty() == true) goto L100;
        int r20 = 0;
        int r111 = 0;
        double r112 = 0.0d;
        double r21 = 0.0d;
        double r22 = 0.0d;
        int r24 = 0;
    L65:
        if (r20 >= r39.a.size()) goto L96;
        JSONObject r23 = r39.a.get(r20);     // Catch: Exception -> L113
        if ((r23.get(r4) instanceof Map) == false) goto L94;
        Map r26 = (Map) r23.get(r4);     // Catch: Exception -> L113
        String r31 = (String) r26.get("stream_preview_fps");     // Catch: Exception -> L113
        if (TextUtils.isEmpty(r31) == false) goto L71;
        double r113 = 0.0d;
        double r32 = 0.0d;
    L73:
        if (r32 > r113) goto L75;
        double r33 = r5.diagnoseTypeStreamStall.previewFps;     // Catch: Exception -> L113
    L76:
        double r114 = r112 + r33;     // Catch: Exception -> L113
        if (r33 >= r5.diagnoseTypeStreamStall.previewFps) goto L79;
        r111 = r111 + 1;     // Catch: Exception -> L113
        r7.append(r33);     // Catch: Exception -> L113
        r7.append("#");     // Catch: Exception -> L113
    L79:
        String r34 = (String) r26.get("stream_real_fps");     // Catch: Exception -> L113
        if (TextUtils.isEmpty(r34) == false) goto L82;
        double r35 = r113;
    L83:
        r21 = r21 + r35;     // Catch: Exception -> L113
        if (r35 >= r5.diagnoseTypeStreamStall.renderFps) goto L86;
        r24 = r24 + 1;     // Catch: Exception -> L113
        r8.append(r35);     // Catch: Exception -> L113
        r8.append("#");     // Catch: Exception -> L113
    L86:
        String r36 = (String) r26.get("stall_video_rate");     // Catch: Exception -> L113
        if (TextUtils.isEmpty(r36) == false) goto L89;
        double r115 = r113;
    L90:
        r22 = r22 + r115;     // Catch: Exception -> L113
        int r37 = r111;
        if (r115 <= r5.diagnoseTypeStreamStall.renderStallRate) goto L93;
        r8.append(r35);     // Catch: Exception -> L113
        r8.append("#");     // Catch: Exception -> L113
    L93:
        r112 = r114;
        r111 = r37;
    L95:
        r20 = r20 + 1;     // Catch: Exception -> L113
        r4 = r4;
        r13 = r13;
        goto L65
    L89:
        r115 = CastDoubleProtector.parseDouble(r36);     // Catch: Exception -> L113
        goto L90
    L82:
        r35 = CastDoubleProtector.parseDouble(r34);     // Catch: Exception -> L113
        goto L83
    L75:
        r33 = r32;
        goto L76
    L71:
        r32 = CastDoubleProtector.parseDouble(r31);     // Catch: Exception -> L113
        r113 = 0.0d;
        goto L73
    L94:
        r4 = r4;
        goto L95
    L96:
        String r38 = r13;
        if (r39.a.isEmpty() == true) goto L99;
        double r41 = r39.a.size();     // Catch: Exception -> L113
        double r116 = r112 / r41;     // Catch: Exception -> L113
        double r117 = r21 / r41;     // Catch: Exception -> L113
        double r42 = r22 / r41;     // Catch: Exception -> L113
        double r43 = r117;
        int r44 = r24;
        double r45 = r116;
        double r118 = r42;
    L101:
        if (r18 > 0) goto L103;
    L105:
        r16 = false;
    L106:
        r40.monitorInfo.put(r38, r111);     // Catch: Exception -> L113
        r40.monitorInfo.put("cs_preview_fps_avg", r45);     // Catch: Exception -> L113
        r40.monitorInfo.put("cs_render_stall_count_avg", r25);     // Catch: Exception -> L113
        r40.monitorInfo.put("cs_render_fps_count", r44);     // Catch: Exception -> L113
        r40.monitorInfo.put("cs_render_fps_avg", r43);     // Catch: Exception -> L113
        r17 = r16;
    L107:
        if (r17 == false) goto L115;
        String r46 = r30;
        JSONArray r47 = r40.monitorInfo.optJSONArray(r46);     // Catch: Exception -> L113
        JSONObject r48 = new JSONObject();     // Catch: Exception -> L113
        r48.put(r46, DiagnoseResult.DIAGNOSE_TYPE_STREAM_STALL);     // Catch: Exception -> L113
        r48.put(DiagnoseResult.KEY_DIAGNOSE_LEVEL, DiagnoseResult.DIAGNOSE_LEVEL_P2);     // Catch: Exception -> L113
        r47.put(r48);     // Catch: Exception -> L113
        String r49 = r29;
        JSONObject r50 = r40.monitorInfo.optJSONObject(r49);     // Catch: Exception -> L113
        if (r50 != null) goto L111;
        r50 = new JSONObject();     // Catch: Exception -> L113
    L111:
        r50.put("preview_fps_over_list", r7.toString());     // Catch: Exception -> L113
        r50.put("real_fps_over_list", r8.toString());     // Catch: Exception -> L113
        r50.put("render_fps_over_list", r27.toString());     // Catch: Exception -> L113
        r50.put("video_stall_rate_over_list", r28.toString());     // Catch: Exception -> L113
        r40.monitorInfo.put(r49, r50);     // Catch: Exception -> L113
        goto L115
    L103:
        if (r118 <= r5.diagnoseTypeStreamStall.renderStallRate) goto L105;
    L99:
        r45 = r112;
        r43 = r21;
        r118 = r22;
        r44 = r24;
        goto L101
    L100:
        r38 = r13;
        r45 = 0.0d;
        r43 = 0.0d;
        r118 = 0.0d;
        r44 = 0;
        r111 = 0;
        goto L101
    L60:
        r14 = 0.0d;
        r18 = 0;
        goto L61
    L15:
        if (r39.b.isEmpty() == true) goto L40;
        int r51 = 0;
        int r119 = 0;
        double r210 = 0.0d;
        double r211 = 60.0d;
        int r212 = 0;
    L18:
        if (r51 >= r39.b.size()) goto L31;
        JSONObject r120 = r39.b.get(r51);     // Catch: Exception -> L113
        if (r120 != null) goto L22;
    L29:
        String r213 = r2;
        String r310 = r3;
        StringBuilder r214 = r9;
        StringBuilder r215 = r10;
        String r52 = r11;
        String r121 = r12;
    L30:
        r51 = r51 + 1;     // Catch: Exception -> L113
        r11 = r52;
        r12 = r121;
        r9 = r214;
        r10 = r215;
        r2 = r213;
        r3 = r310;
        goto L18
    L22:
        if (r120.length() <= 0) goto L29;
        r213 = r2;
        r310 = r3;
        r214 = r9;
        r215 = r10;
        double r53 = r120.optDouble("preview_fps", 0.0d);     // Catch: Exception -> L113
        r210 = r210 + r53;     // Catch: Exception -> L113
        if (r53 >= r5.diagnoseTypeStreamStall.previewFps) goto L26;
        r119 = r119 + 1;     // Catch: Exception -> L113
        r7.append(r53);     // Catch: Exception -> L113
        r7.append("#");     // Catch: Exception -> L113
    L26:
        r52 = r11;
        r121 = r12;
        double r216 = r120.optDouble("avg_fps", 60.0d);     // Catch: Exception -> L113
        r211 = r211 + r216;     // Catch: Exception -> L113
        if (r216 >= r5.diagnoseTypeStreamStall.realFps) goto L30;
        r212 = r212 + 1;     // Catch: Exception -> L113
        r8.append(r53);     // Catch: Exception -> L113
        r8.append("#");     // Catch: Exception -> L113
        goto L30
    L31:
        r29 = r2;
        r30 = r3;
        r27 = r9;
        r28 = r10;
        String r54 = r11;
        String r122 = r12;
        if (r39.b.isEmpty() == true) goto L35;
        r210 = r210 / ((double) r39.b.size());     // Catch: Exception -> L113
        r211 = r211 / ((double) r39.b.size());     // Catch: Exception -> L113
    L35:
        if (r210 >= r5.diagnoseTypeStreamStall.previewFps) goto L38;
        if (r119 <= 0) goto L38;
    L39:
        r17 = r16;
        double r55 = r210;
        double r56 = r211;
        int r0 = r212;
    L41:
        r40.monitorInfo.put(r122, r119);     // Catch: Exception -> L113
        r40.monitorInfo.put(r54, r55);     // Catch: Exception -> L113
        r40.monitorInfo.put("cs_real_fps_count", r0);     // Catch: Exception -> L113
        r40.monitorInfo.put("cs_real_fps_avg", r56);     // Catch: Exception -> L113
        r8 = r8;
    L38:
        r16 = false;
        goto L39
    L40:
        r29 = DiagnoseResult.KEY_DIAGNOSE_ASSISTANT_INFO;
        r30 = DiagnoseResult.KEY_DIAGNOSE_TYPE;
        r27 = r9;
        r28 = r10;
        r54 = "cs_preview_fps_avg";
        r122 = "cs_preview_fps_count";
        r0 = 0;
        r55 = 0.0d;
        r56 = 60.0d;
        r119 = 0;
        goto L41
    }
}
