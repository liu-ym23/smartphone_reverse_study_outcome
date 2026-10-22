package com.bytedance.ttnet.tnc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.TTDelayStateManager;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.b;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.h;
import com.bytedance.frameworks.baselib.network.http.util.g;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.bytedance.ttnet.config.TTHttpCallThrottleControl;
import com.bytedance.ttnet.priority.TTHttpCallPriorityControl;
import d3.e;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import w4.c;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f5.a f2927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f2930e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f2931f;

    public a(Context r10, boolean r11) {
        this.f2929d = "";
        this.f2930e = "";
        this.f2931f = "";
        this.f2926a = r10;
        this.f2928c = r11;
        this.f2927b = new f5.a();
    }

    private String e() {
        if (TextUtils.isEmpty(TNCManager.l()) == false) goto L13;
        Logger.d("TNCConfigHandler", "getGetDomainDefaultJson no existed");
        return null;
    L13:
        String r10 = new JSONObject(TNCManager.l()).getString("data");     // Catch: JSONException -> L10
        if (Logger.debug() == false) goto L9;
        Logger.d("TNCConfigHandler", "use get domain default json.");     // Catch: JSONException -> L10
    L9:
        return r10;
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private void h(JSONObject r10) {
        if (w4.a.r(this.f2926a).i() == true) goto L6;
        b.q().x(r10);
        sc.a.d().f(r10);
    L6:
        if (g.h(this.f2926a) == false) goto L8;
        c.g(r10);
        TTHttpCallThrottleControl.l().q(r10);
        TTHttpCallPriorityControl.h().l(r10);
    L8:
        z2.c.c(r10);
        TTDelayStateManager.e(r10);
        e.f().g(r10);
        TTRequestCompressManager.l(r10);
        com.bytedance.frameworks.baselib.network.http.util.c.h(r10);
        k2.a.d(r10);
        k2.b.g(r10);
        x2.c.e(r10);
    }

    private f5.a i(JSONObject r10) {
        h.l().f().clear();     // Catch: Throwable -> L48
        JSONObject r11 = r10.optJSONObject("tnc_config");     // Catch: Throwable -> L48
        f5.a r12 = new f5.a();     // Catch: Throwable -> L48
        if (r11 != null) goto L6;
        return r12;
    L6:
        boolean r13 = true;
        if (r11.has("local_enable") == false) goto L14;
        if (r11.getInt("local_enable") != 0) goto L11;
        boolean r14 = false;
    L12:
        r12.f8853a = r14;     // Catch: Throwable -> L48
        goto L14
    L11:
        r14 = true;
    L14:
        if (r11.has("probe_enable") == false) goto L20;
        if (r11.getInt("probe_enable") != 0) goto L18;
        r13 = false;
    L18:
        r12.f8854b = r13;     // Catch: Throwable -> L48
    L20:
        if (r11.has("local_host_filter") == false) goto L32;
        JSONArray r15 = r11.getJSONArray("local_host_filter");     // Catch: Throwable -> L48
        HashMap r16 = new HashMap();     // Catch: Throwable -> L48
        if (r15.length() <= 0) goto L31;
        int r17 = 0;
    L25:
        if (r17 >= r15.length()) goto L31;
        String r18 = r15.getString(r17);     // Catch: Throwable -> L48
        if (TextUtils.isEmpty(r18) == true) goto L30;
        r16.put(r18, 0);     // Catch: Throwable -> L48
    L30:
        r17 = r17 + 1;     // Catch: Throwable -> L48
    L31:
        r12.f8855c = r16;     // Catch: Throwable -> L48
    L34:
        if (r11.has("host_replace_map") == false) goto L46;
        JSONObject r19 = r11.getJSONObject("host_replace_map");     // Catch: Throwable -> L48
        if (r19.length() <= 0) goto L46;
        Iterator<String> r20 = r19.keys();     // Catch: Throwable -> L48
    L39:
        if (r20.hasNext() == false) goto L46;
        String r21 = r20.next();     // Catch: Throwable -> L48
        String r22 = r19.getString(r21);     // Catch: Throwable -> L48
        if (TextUtils.isEmpty(r21) == true) goto L39;
        if (TextUtils.isEmpty(r22) == true) goto L39;
        h.l().f().put(r21, r22);     // Catch: Throwable -> L48
    L46:
        r12.f8856d = r11.optInt("req_to_cnt", r12.f8856d);     // Catch: Throwable -> L48
        r12.f8857e = r11.optInt("req_to_api_cnt", r12.f8857e);     // Catch: Throwable -> L48
        r12.f8858f = r11.optInt("req_to_ip_cnt", r12.f8858f);     // Catch: Throwable -> L48
        r12.f8859g = r11.optInt("req_err_cnt", r12.f8859g);     // Catch: Throwable -> L48
        r12.f8860h = r11.optInt("req_err_api_cnt", r12.f8860h);     // Catch: Throwable -> L48
        r12.f8861i = r11.optInt("req_err_ip_cnt", r12.f8861i);     // Catch: Throwable -> L48
        r12.f8862j = r11.optInt("update_interval", r12.f8862j);     // Catch: Throwable -> L48
        r12.f8863k = r11.optInt("update_random_range", r12.f8863k);     // Catch: Throwable -> L48
        r12.f8864l = r11.optString("http_code_black", r12.f8864l);     // Catch: Throwable -> L48
        return r12;
    L32:
        r12.f8855c = null;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public String a() {
        return this.f2929d;
    }

    public String b() {
        return this.f2930e;
    }

    public f5.a c() {
        return this.f2927b;
    }

    public boolean d(Object r18, TNCManager.TNCUpdateSource r19, String r20, String r21, long r22) {
        if (Logger.debug() == false) goto L6;
        Logger.d("TNCConfigHandler", "handleConfigChanged");
    L6:
        if (this.f2928c == false) goto L8;
        JSONObject r10 = w4.e.f(r18);
        h.l().o(r10, r19.mValue, r20, this.f2931f, r22);
        h(r10);
        f5.a r11 = i(r10);     // Catch: Throwable -> L47
        if (Logger.debug() == false) goto L19;
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L47
        r12.append("handleConfigChanged, newConfig: ");     // Catch: Throwable -> L47
        if (r11 != null) goto L17;
        String r13 = "null";
    L18:
        r12.append(r13);     // Catch: Throwable -> L47
        Logger.d("TNCConfigHandler", r12.toString());     // Catch: Throwable -> L47
        goto L19
    L17:
        r13 = r11.toString();     // Catch: Throwable -> L47
    L19:
        if (r11 != null) goto L28;
        SharedPreferences.Editor r14 = this.f2926a.getSharedPreferences("ttnet_tnc_config", 0).edit();
        r14.putBoolean("is_full_config", false);
        r14.putString("tnc_config_str", "").apply();
        com.bytedance.ttnet.utils.b.c(this.f2926a, 7, com.bytedance.ttnet.utils.b.a(false));
        com.bytedance.ttnet.utils.b.c(this.f2926a, 4, "");
        if (TextUtils.isEmpty(r20) == true) goto L24;
        r14.putString("ttnet_tnc_etag", r20).apply();
        com.bytedance.ttnet.utils.b.c(this.f2926a, 5, r20);
    L24:
        if (TextUtils.isEmpty(this.f2931f) == false) goto L26;
        this.f2931f = "";
    L26:
        r14.putString("ttnet_tnc_abtest", this.f2931f).apply();
        com.bytedance.ttnet.utils.b.c(this.f2926a, 6, this.f2931f);
        return false;
    L28:
        String r15 = "ttnet_tnc_abtest";
        this.f2927b = r11;     // Catch: Throwable -> L45
        if ((r18 instanceof w4.e.b) == true) goto L68;
        String r16 = r10.toString();     // Catch: Throwable -> L45
        boolean r17 = false;
    L37:
        SharedPreferences.Editor r23 = this.f2926a.getSharedPreferences("ttnet_tnc_config", 0).edit();
        r23.putBoolean("is_full_config", r17);
        r23.putString("tnc_config_str", r16).apply();
        com.bytedance.ttnet.utils.b.c(this.f2926a, 7, com.bytedance.ttnet.utils.b.a(r17));
        com.bytedance.ttnet.utils.b.c(this.f2926a, 4, r16);
        if (TextUtils.isEmpty(r20) == true) goto L41;
        r23.putString("ttnet_tnc_etag", r20).apply();
        com.bytedance.ttnet.utils.b.c(this.f2926a, 5, r20);
    L41:
        if (TextUtils.isEmpty(this.f2931f) == false) goto L43;
        this.f2931f = "";
    L43:
        r23.putString(r15, this.f2931f).apply();
        com.bytedance.ttnet.utils.b.c(this.f2926a, 6, this.f2931f);
        return true;
    L68:
        r16 = ((w4.e.b) r18).c();     // Catch: Throwable -> L33
        r17 = true;
    L33:
        th = th;
        boolean r24 = true;
    L72:
        th.printStackTrace();     // Catch: Throwable -> L59
        this.f2927b = new f5.a();     // Catch: Throwable -> L59
        SharedPreferences.Editor r25 = this.f2926a.getSharedPreferences("ttnet_tnc_config", 0).edit();
        r25.putBoolean("is_full_config", r24);
        r25.putString("tnc_config_str", "").apply();
        com.bytedance.ttnet.utils.b.c(this.f2926a, 7, com.bytedance.ttnet.utils.b.a(r24));
        com.bytedance.ttnet.utils.b.c(this.f2926a, 4, "");
        if (TextUtils.isEmpty(r20) == true) goto L55;
        r25.putString("ttnet_tnc_etag", r20).apply();
        com.bytedance.ttnet.utils.b.c(this.f2926a, 5, r20);
    L55:
        if (TextUtils.isEmpty(this.f2931f) == false) goto L57;
        this.f2931f = "";
    L57:
        r25.putString(r15, this.f2931f).apply();
        com.bytedance.ttnet.utils.b.c(this.f2926a, 6, this.f2931f);
        return false;
    L59:
        th = move-exception;
        SharedPreferences.Editor r26 = this.f2926a.getSharedPreferences("ttnet_tnc_config", 0).edit();
        r26.putBoolean("is_full_config", r24);
        r26.putString("tnc_config_str", "").apply();
        com.bytedance.ttnet.utils.b.c(this.f2926a, 7, com.bytedance.ttnet.utils.b.a(r24));
        com.bytedance.ttnet.utils.b.c(this.f2926a, 4, "");
        if (TextUtils.isEmpty(r20) == true) goto L64;
        r26.putString("ttnet_tnc_etag", r20).apply();
        com.bytedance.ttnet.utils.b.c(this.f2926a, 5, r20);
    L64:
        if (TextUtils.isEmpty(this.f2931f) == false) goto L66;
        this.f2931f = "";
    L66:
        r26.putString(r15, this.f2931f).apply();
        com.bytedance.ttnet.utils.b.c(this.f2926a, 6, this.f2931f);
        throw th;
    L45:
        th = th;
    L49:
        r24 = false;
    L47:
        th = th;
        r15 = "ttnet_tnc_abtest";
        goto L49
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d("TNCConfigHandler", "handleConfigChanged: no mainProc");
    L10:
        return false;
    }

    public void f(long r16) {
        if (Logger.debug() == false) goto L6;
        Logger.d("TNCConfigHandler", "load local config");
    L6:
        if (this.f2928c == true) goto L8;
        return;
    L8:
        boolean r10 = false;
        SharedPreferences r11 = this.f2926a.getSharedPreferences("ttnet_tnc_config", 0);
        boolean r12 = r11.getBoolean("is_full_config", false);
        String r13 = r11.getString("tnc_config_str", null);
        String r14 = r11.getString("ttnet_tnc_etag", null);
        String r15 = r11.getString("ttnet_tnc_abtest", null);
        if (TextUtils.isEmpty(r13) == false) goto L16;
        r13 = e();
        if (TextUtils.isEmpty(r13) == true) goto L13;
    L38:
        JSONObject r17 = new JSONObject(r13);     // Catch: Throwable -> L33
        if (r10 == false) goto L22;
        JSONObject r18 = r17.optJSONObject("data");     // Catch: Throwable -> L33
        if (r18 == null) goto L22;
        r17 = r18;
    L22:
        h.l().o(r17, TNCManager.TNCUpdateSource.TTCACHE.mValue, r14, r15, r16);     // Catch: Throwable -> L33
        h(r17);     // Catch: Throwable -> L33
        f5.a r19 = i(r17);     // Catch: Throwable -> L33
        if (r19 == null) goto L26;
        this.f2927b = r19;     // Catch: Throwable -> L33
    L26:
        if (Logger.debug() == false) goto L41;
        StringBuilder r20 = new StringBuilder();     // Catch: Throwable -> L33
        r20.append("loadLocalConfig: ");     // Catch: Throwable -> L33
        if (r19 != null) goto L30;
        String r21 = "null";
    L31:
        r20.append(r21);     // Catch: Throwable -> L33
        Logger.d("TNCConfigHandler", r20.toString());     // Catch: Throwable -> L33
        return;
    L30:
        r21 = r19.toString();     // Catch: Throwable -> L33
        goto L31
    L41:
        return;
    L33:
        th = move-exception;
        th.printStackTrace();
        if (Logger.debug() == false) goto L42;
        Logger.d("TNCConfigHandler", "loadLocalConfig: except: " + th.getMessage());
        return;
    L42:
        return;
    L13:
        if (Logger.debug() == false) goto L40;
        Logger.d("TNCConfigHandler", "load local config failed.");
        return;
    L40:
        return;
    L16:
        r10 = r12;
        goto L38
    }

    public void g(long r11) {
        boolean r10 = com.bytedance.ttnet.utils.b.d(com.bytedance.ttnet.utils.b.b(this.f2926a, 7));     // Catch: Throwable -> L26
        String r12 = com.bytedance.ttnet.utils.b.b(this.f2926a, 4);     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r12) == false) goto L11;
        r10 = false;
        r12 = e();     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r12) == false) goto L11;
        if (Logger.debug() == false) goto L32;
        Logger.d("TNCConfigHandler", "load local config failed.");     // Catch: Throwable -> L26
        return;
    L32:
        return;
    L11:
        JSONObject r13 = new JSONObject(r12);     // Catch: Throwable -> L26
        if (r10 == false) goto L16;
        JSONObject r14 = r13.optJSONObject("data");     // Catch: Throwable -> L26
        if (r14 == null) goto L16;
        r13 = r14;
    L16:
        JSONObject r15 = r13;
        f5.a r16 = i(r15);     // Catch: Throwable -> L26
        h.l().o(r15, TNCManager.TNCUpdateSource.TTCACHE.mValue, com.bytedance.ttnet.utils.b.b(this.f2926a, 5), com.bytedance.ttnet.utils.b.b(this.f2926a, 6), r11);     // Catch: Throwable -> L26
        h(r15);     // Catch: Throwable -> L26
        if (Logger.debug() == false) goto L23;
        StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L26
        r17.append("loadLocalConfigForOtherProcess, config: ");     // Catch: Throwable -> L26
        if (r16 != null) goto L21;
        String r18 = "null";
    L22:
        r17.append(r18);     // Catch: Throwable -> L26
        Logger.d("TNCConfigHandler", r17.toString());     // Catch: Throwable -> L26
        goto L23
    L21:
        r18 = r16.toString();     // Catch: Throwable -> L26
    L23:
        if (r16 == null) goto L33;
        this.f2927b = r16;     // Catch: Throwable -> L26
        return;
    L33:
        return;
    L26:
        th = move-exception;
        if (Logger.debug() == false) goto L34;
        Logger.d("TNCConfigHandler", "loadLocalConfigForOtherProcess, except: " + th.getMessage());
        return;
    }

    public void j(String r10) {
        this.f2931f = r10;
        h.l().s(r10);
    }
}
