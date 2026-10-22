package com.bytedance.frameworks.baselib.network.e;

import android.text.TextUtils;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a.c f2346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f2347b = null;
    private static double c;

    static {
        HashSet r0 = new HashSet();
        f2347b = r0;
        c = 1.0E-9d;
        r0.add("ttnet_high_lvl_conn");
        r0.add("multinetwork");
        r0.add("mpa_client");
        r0.add("ttnet_feedback_detect");
        r0.add("ttnet_exception_detect");
        r0.add("ttnet_stress_detect");
        r0.add("ttnet_polling_detect");
        r0.add("long_cost_net_task");
        r0.add("ws_all");
        r0.add("frontier_all");
        r0.add("frontier_msg");
        r0.add("user_msg");
        r0.add("store_idc");
        r0.add("ttnet_route_select");
        r0.add("ws_ping");
        r0.add("frontier_online");
        r0.add("ttnet_all_log");
        r0.add("cookie_mismatch");
        r0.add("cronet_native_requestlog");
        r0.add("ttnet_debug_trace_info");
        r0.add("ttnet_http_dns_fail");
        r0.add("ttnet_tnc_update_result");
        r0.add("cronet_native_requestlog_empty");
        r0.add("frontier_qos");
        r0.add("ttnet_net_exp");
        r0.add("bad_request_diagnosis");
        r0.add("ttnet_raw_detect");
        r0.add("gna_raw_detect");
        r0.add("ttnet_network_environment");
        r0.add("game_network");
        r0.add("ttnet_zstd_stream");
        r0.add("ttnet_zstd_dict_error");
        r0.add("ttnet_load");
        r0.add("ttnet_insec_rect");
        r0.add("ttquiche_native_request_log");
        r0.add("otel_log");
    }

    public static a.c a(JSONObject r26, int r27) {
        if (r27 <= 0) goto L84;
        if (r26 == null) goto L84;
        JSONObject r4 = r26.optJSONObject("network_image_modules");     // Catch: Exception -> L91
        JSONObject r0 = r26.optJSONObject("custom_event_settings");     // Catch: Exception -> L91
        if (r4 == null) goto L9;
        r4 = r4.optJSONObject("network");     // Catch: Exception -> L91
    L9:
        if (r4 != null) goto L11;
    L12:
        if (r0 != null) goto L14;
        return null;
    L14:
        if (r0.length() > 0) goto L17;
        return null;
    L17:
        if (r4 == null) goto L57;
        JSONObject r7 = r4.optJSONObject("api_allow_list");     // Catch: Exception -> L91
        if (r7 != null) goto L21;
    L24:
        boolean r8 = true;
    L25:
        ArrayList r9 = new ArrayList();     // Catch: Exception -> L91
        a(r4, "api_allow_list_path_equal", r9);     // Catch: Exception -> L91
        if (r9.isEmpty() == true) goto L28;
        boolean r10 = true;
    L29:
        boolean r11 = r10 | false;     // Catch: Exception -> L91
        ArrayList r12 = new ArrayList();     // Catch: Exception -> L91
        a(r4, "api_allow_list_path_prefix", r12);     // Catch: Exception -> L91
        if (r12.isEmpty() == true) goto L32;
        boolean r13 = true;
    L33:
        boolean r14 = r11 | r13;     // Catch: Exception -> L91
        ArrayList r15 = new ArrayList();     // Catch: Exception -> L91
        a(r4, "api_allow_list_path_contain", r15);     // Catch: Exception -> L91
        if (r15.isEmpty() == true) goto L36;
        boolean r16 = true;
    L37:
        boolean r17 = r14 | r16;     // Catch: Exception -> L91
        ArrayList r18 = new ArrayList();     // Catch: Exception -> L91
        a(r4, "api_allow_list_path_regexp", r18);     // Catch: Exception -> L91
        if (r18.isEmpty() == true) goto L40;
        boolean r19 = true;
    L41:
        boolean r110 = r17 | r19;     // Catch: Exception -> L91
        ArrayList r111 = new ArrayList();     // Catch: Exception -> L91
        a(r4, "api_allow_list_host_pattern", r111);     // Catch: Exception -> L91
        if (r111.isEmpty() == true) goto L44;
        boolean r112 = true;
    L45:
        boolean r113 = r110 | r112;     // Catch: Exception -> L91
        ArrayList r114 = new ArrayList();     // Catch: Exception -> L91
        a(r4, "api_allow_list_url_regexp", r114);     // Catch: Exception -> L91
        boolean r3 = (!r114.isEmpty()) | r113;     // Catch: Exception -> L91
        if (r8 == true) goto L48;
        if (r3 == false) goto L57;
    L48:
        ArrayList r5 = new ArrayList();     // Catch: Exception -> L91
        b(r4, "api_block_list", r5);     // Catch: Exception -> L91
        if (Math.abs(r4.optDouble("enable_base_api_all")) <= c) goto L51;
        boolean r115 = true;
    L53:
        if (r4.optInt("enable_api_all_upload") != 1) goto L55;
        boolean r116 = true;
    L56:
        a.b r20 = new a.b(r115, r116, (String[]) ZeusTransformUtils.preCheckCast(r5.toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"), (String[]) ZeusTransformUtils.preCheckCast(r9.toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"), (String[]) ZeusTransformUtils.preCheckCast(r15.toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"), (String[]) ZeusTransformUtils.preCheckCast(r12.toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"), (String[]) ZeusTransformUtils.preCheckCast(r18.toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"), (String[]) ZeusTransformUtils.preCheckCast(r114.toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"), (String[]) ZeusTransformUtils.preCheckCast(r111.toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L91
    L58:
        ArrayList r6 = new ArrayList();     // Catch: Exception -> L91
        if (r0 != null) goto L61;
    L63:
        a.C0122a r1 = null;
    L64:
        if (r20 != null) goto L71;
        if (r1 != null) goto L71;
        if (Logger.debug() == false) goto L95;
        Logger.d("SlaSamplingSCreator", "create slaSamplingSetting failed, api and event rule is null");     // Catch: Exception -> L91
        return null;
    L95:
        return null;
    L71:
        a.c r21 = new a.c(r27, r20, r1);     // Catch: Exception -> L91
        a.c r2 = f2346a;     // Catch: Exception -> L91
        if (r2 != null) goto L74;
    L80:
        f2346a = r21;     // Catch: Exception -> L91
        return r21;
    L74:
        if (r2.equals(r21) == false) goto L80;
        if (Logger.debug() == false) goto L96;
        Logger.d("SlaSamplingSCreator", "slaSamplingSetting same");     // Catch: Exception -> L91
        return null;
    L96:
        return null;
    L61:
        if (a(r0, SlardarSettingsConstants.KEY_ALLOW_LOG_TYPE, r6) == false) goto L63;
        r6.retainAll(f2347b);     // Catch: Exception -> L91
        r1 = new a.C0122a((String[]) ZeusTransformUtils.preCheckCast(r6.toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L91
        goto L64
    L55:
        r116 = false;
        goto L56
    L51:
        r115 = false;
        goto L53
    L44:
        r112 = false;
        goto L45
    L40:
        r19 = false;
        goto L41
    L36:
        r16 = false;
        goto L37
    L32:
        r13 = false;
        goto L33
    L28:
        r10 = false;
        goto L29
    L21:
        if (r7.length() == 0) goto L24;
        r8 = false;
    L57:
        r20 = null;
        goto L58
    L11:
        if (r4.length() > 0) goto L17;
    L84:
        StringBuilder r22 = new StringBuilder().append("create slaSamplingSetting failed, ");     // Catch: Exception -> L91
        if (r26 != null) goto L87;
        String r23 = "jsonObject is null";
    L88:
        Logger.e("SlaSamplingSCreator", r22.append(r23).toString());     // Catch: Exception -> L91
        return null;
    L87:
        r23 = "appId is invalid";
    L91:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private static boolean a(JSONObject r3, String r4, List<String> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L19;
        if (r6 == null) goto L19;
        JSONObject r7 = r3.optJSONObject(r4);
        if (r7 != null) goto L11;
        return false;
    L11:
        Iterator<String> r8 = r7.keys();
    L13:
        if (r8.hasNext() == false) goto L17;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r9) == true) goto L13;
        r6.add(r9);
        goto L13
    L17:
        return true;
    }

    private static void b(JSONObject r2, String r3, List<String> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L22;
        if (r5 == null) goto L23;
        JSONArray r6 = r2.optJSONArray(r3);
        if (r6 != null) goto L11;
        return;
    L11:
        int r7 = 0;
    L13:
        if (r7 >= r6.length()) goto L24;
        String r0 = r6.optString(r7);
        if (TextUtils.isEmpty(r0) == true) goto L17;
        r5.add(r0);
    L17:
        r7 = r7 + 1;
        goto L13
    L24:
        return;
    L23:
        return;
    }
}
