package gy;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdk.config.w90;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrlExtra;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public final String a;
    public long b;
    public long c;
    public long d;
    public long e;
    public final h f;
    public final Room g;

    public final HashMap<String, Object> a() {
        HashMap<String, Object> r0 = new HashMap();
        r0.put("interact_first_video_time_interval", Long.valueOf(this.d));
        r0.put("interact_first_frame_render_interval", Long.valueOf(this.e));
        r0.put("interact_start_join_channel_time_interval", Long.valueOf(this.c));
        r0.put("interact_join_channel_success_time_interval", Long.valueOf(this.b));
        r0.put("scene", 0);
        StreamUrlExtra r1 = this.g.getStreamUrlExtraSafely();
        if (r1 == null) goto L5;
        StringBuilder r2 = new StringBuilder();
        r2.append(r1.getWidth());
        r2.append('-');
        r2.append(r1.getHeight());
        r0.put("push_stream_info", r2.toString());
    L5:
        return r0;
    }

    public a(Room r2) {
        Intrinsics.checkNotNullParameter(r2, NewBroadcastMonitor.PAGE.ROOM);
        this.g = r2;
        this.a = "ttlive_anchor_link_rtc";
        this.f = new h(r2);
    }

    public final void c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "reqSrc");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("req_src", r5);
        h r6 = this.f;
        LiveTracingMonitor.EventModule r2 = LiveTracingMonitor.b(0);
        int r3 = h.d;
        r6.m(r2, "trace_null_client", r0, false);
    }

    public static void b(a r9, String r11, String r12, int r13, int r14) {
        if (r14 == 0) goto L60;
        if (r13 != 0) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L63;
        HashMap<String, Object> r0 = r9.a();
        if (r11 != null) goto L10;
        String r2 = "";
    L11:
        r0.put("rtc_params", r2);
        if (r12 != null) goto L14;
        r12 = "";
    L14:
        r0.put("update_src", r12);
        r0.put("self_layer_width", Integer.valueOf(r13));
        r0.put("self_layer_height", Integer.valueOf(r14));
        JSONObject r15 = new JSONObject(r11);     // Catch: JSONException -> L55
        JSONObject r16 = r15.optJSONObject("live_rtc_video_param");     // Catch: JSONException -> L55
        String r17 = r15.optString("rtc_business_id");     // Catch: JSONException -> L55
        if (r16 == null) goto L62;
        int r1 = r16.optInt("rtc_video_param_mode");     // Catch: JSONException -> L55
        int r3 = -1;
        if (r1 != 1) goto L21;
        JSONObject r18 = r16.optJSONObject("rtc_video_param_server_define");     // Catch: JSONException -> L55
        if (r18 == null) goto L41;
        int r7 = r18.optInt("width");     // Catch: JSONException -> L55
    L42:
        if (r18 == null) goto L45;
        int r19 = r18.optInt("height");     // Catch: JSONException -> L55
    L44:
        r3 = r19;
    L45:
        r0.put("update_rtc_width", Integer.valueOf(r7));     // Catch: JSONException -> L55
        r0.put("update_rtc_height", Integer.valueOf(r3));     // Catch: JSONException -> L55
        r0.put("rtc_user_size", 1);     // Catch: JSONException -> L55
        r0.put("ext_rtc_business_id", r17);     // Catch: JSONException -> L55
        StringBuilder r110 = new StringBuilder();     // Catch: JSONException -> L55
        r110.append(r7);     // Catch: JSONException -> L55
        r110.append('*');     // Catch: JSONException -> L55
        r110.append(r3);     // Catch: JSONException -> L55
        r0.put("ext_rtc_resolution", r110.toString());     // Catch: JSONException -> L55
        if (r7 == 0) goto L49;
        if (r13 == 0) goto L49;
        float r111 = ((r3 * 1.0f) / r7) - ((r14 * 1.0f) / r13);     // Catch: JSONException -> L55
    L51:
        if (r111 <= ((Float) w90.a.getValue()).floatValue()) goto L53;
        h r112 = r9.f;     // Catch: JSONException -> L55
        LiveTracingMonitor.EventModule r113 = LiveTracingMonitor.b(0);     // Catch: JSONException -> L55
        int r114 = h.d;     // Catch: JSONException -> L55
        r112.m(r113, "pushstream_resolution_redundancy", r0, false);     // Catch: JSONException -> L55
    L53:
        r9.f.m(LiveTracingMonitor.b(0), "switch_rtc_and_livecore_ext_info", r0, true);     // Catch: JSONException -> L55
        return;
    L49:
        r111 = 0.0f;
        goto L51
    L41:
        r7 = 0;
        goto L42
    L21:
        if (r1 == 3) goto L23;
        r7 = 0;
        goto L45
    L23:
        JSONObject r4 = r16.optJSONObject("rtc_video_param_1v1_client");     // Catch: JSONException -> L55
        if (r4 == null) goto L26;
        r7 = r4.optInt("width");     // Catch: JSONException -> L55
    L27:
        if (r4 == null) goto L29;
        int r8 = r4.optInt("height");     // Catch: JSONException -> L55
    L30:
        if (r4 != null) goto L37;
        JSONObject r115 = r16.optJSONObject("rtc_video_param_1v1_server");     // Catch: JSONException -> L55
        if (r115 == null) goto L34;
        r7 = r115.optInt("width");     // Catch: JSONException -> L55
    L35:
        if (r115 == null) goto L45;
        r19 = r115.optInt("height");     // Catch: JSONException -> L55
        goto L44
    L34:
        r7 = 0;
        goto L35
    L37:
        r3 = r8;
        goto L45
    L29:
        r8 = -1;
        goto L30
    L26:
        r7 = 0;
        goto L27
    L62:
        return;
    L55:
        e = move-exception;
        ALogger.e("monitorPushResolution", "e = " + e);
        return;
    L10:
        r2 = r11;
        goto L11
    L63:
        return;
    }
}
