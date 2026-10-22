package d9;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import e7.e;
import g7.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f6972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6974d;

    public b(Context r8, boolean r10) {
        this.f6974d = "";
        this.f6971a = r8;
        this.f6973c = r10;
        this.f6972b = new a();
    }

    public static String b() {
        if (TextUtils.isEmpty(d.f6977p) == false) goto L11;
        Logger.d("TNCConfigHandler", "getGetDomainDefaultJson no existed");
        return null;
    L11:
        String r8 = new JSONObject(d.f6977p).getString("data");     // Catch: JSONException -> L8
        Logger.d("TNCConfigHandler", "use get domain default json.");     // Catch: JSONException -> L8
        return r8;
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static a d(JSONObject r10) {
        j.e().c().clear();     // Catch: Throwable -> L48
        JSONObject r11 = r10.optJSONObject("tnc_config");     // Catch: Throwable -> L48
        a r8 = new a();     // Catch: Throwable -> L48
        if (r11 != null) goto L6;
        return r8;
    L6:
        boolean r12 = true;
        if (r11.has("local_enable") == false) goto L14;
        if (r11.getInt("local_enable") != 0) goto L11;
        boolean r13 = false;
    L12:
        r8.f6959a = r13;     // Catch: Throwable -> L48
        goto L14
    L11:
        r13 = true;
    L14:
        if (r11.has("probe_enable") == false) goto L20;
        if (r11.getInt("probe_enable") != 0) goto L18;
        r12 = false;
    L18:
        r8.f6960b = r12;     // Catch: Throwable -> L48
    L20:
        if (r11.has("local_host_filter") == false) goto L32;
        JSONArray r14 = r11.getJSONArray("local_host_filter");     // Catch: Throwable -> L48
        HashMap r15 = new HashMap();     // Catch: Throwable -> L48
        if (r14.length() <= 0) goto L31;
        int r16 = 0;
    L25:
        if (r16 >= r14.length()) goto L31;
        String r17 = r14.getString(r16);     // Catch: Throwable -> L48
        if (TextUtils.isEmpty(r17) == true) goto L30;
        r15.put(r17, 0);     // Catch: Throwable -> L48
    L30:
        r16 = r16 + 1;     // Catch: Throwable -> L48
    L31:
        r8.f6961c = r15;     // Catch: Throwable -> L48
    L34:
        if (r11.has("host_replace_map") == false) goto L46;
        JSONObject r18 = r11.getJSONObject("host_replace_map");     // Catch: Throwable -> L48
        if (r18.length() <= 0) goto L46;
        Iterator<String> r19 = r18.keys();     // Catch: Throwable -> L48
    L39:
        if (r19.hasNext() == false) goto L46;
        String r20 = r19.next();     // Catch: Throwable -> L48
        String r21 = r18.getString(r20);     // Catch: Throwable -> L48
        if (TextUtils.isEmpty(r20) == true) goto L39;
        if (TextUtils.isEmpty(r21) == true) goto L39;
        j.e().c().put(r20, r21);     // Catch: Throwable -> L48
    L46:
        r8.f6962d = r11.optInt("req_to_cnt", r8.f6962d);     // Catch: Throwable -> L48
        r8.f6963e = r11.optInt("req_to_api_cnt", r8.f6963e);     // Catch: Throwable -> L48
        r8.f6964f = r11.optInt("req_to_ip_cnt", r8.f6964f);     // Catch: Throwable -> L48
        r8.f6965g = r11.optInt("req_err_cnt", r8.f6965g);     // Catch: Throwable -> L48
        r8.f6966h = r11.optInt("req_err_api_cnt", r8.f6966h);     // Catch: Throwable -> L48
        r8.f6967i = r11.optInt("req_err_ip_cnt", r8.f6967i);     // Catch: Throwable -> L48
        r8.f6968j = r11.optInt("update_interval", r8.f6968j);     // Catch: Throwable -> L48
        r8.f6969k = r11.optInt("update_random_range", r8.f6969k);     // Catch: Throwable -> L48
        r8.f6970l = r11.optString("http_code_black", r8.f6970l);     // Catch: Throwable -> L48
        return r8;
    L32:
        r8.f6961c = null;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a(JSONObject r19, d.b r20, String r21, String r22, long r23) {
        Context r15 = this.f6971a;
        Logger.d("TNCConfigHandler", "handleConfigChanged");
        if (this.f6973c == true) goto L9;
        if (Logger.debug() == false) goto L7;
        Logger.d("TNCConfigHandler", "handleConfigChanged: no mainProc");
    L7:
        return false;
    L9:
        if (TextUtils.isEmpty(r22) == true) goto L46;
        k7.b r8 = k7.b.e();
        if (r8.f8970j == true) goto L13;
    L15:
        Object[] r10 = false;
    L16:
        if (r10 == false) goto L46;
        ArrayList r11 = new ArrayList();
        if (t2.b.W(r22, ";", r11) == true) goto L21;
    L45:
        boolean r12 = false;
    L47:
        if (r12 == true) goto L50;
        return false;
    L50:
        j.e().g(r19, r20.f7004a, r21, this.f6974d, r23);
        e.g().k(r19);
        w8.e.a(r19);
        t6.a.a(r19);
        a r13 = d(r19);     // Catch: Throwable -> L80
        if (Logger.debug() == false) goto L58;
        StringBuilder r14 = new StringBuilder("handleConfigChanged, newConfig: ");     // Catch: Throwable -> L80
        if (r13 != null) goto L56;
        String r16 = "null";
    L57:
        r14.append(r16);     // Catch: Throwable -> L80
        Logger.d("TNCConfigHandler", r14.toString());     // Catch: Throwable -> L80
        goto L58
    L56:
        r16 = r13.toString();     // Catch: Throwable -> L80
    L58:
        if (r13 != null) goto L68;
        SharedPreferences.Editor r17 = r15.getSharedPreferences("ttnet_tnc_config", 0).edit();
        r17.putString("tnc_config_str", "").apply();
        defpackage.c.f0(r15, 4, "");
        if (TextUtils.isEmpty(r21) == true) goto L62;
        r17.putString("ttnet_tnc_etag", r21).apply();
        defpackage.c.f0(r15, 5, r21);
    L62:
        boolean r18 = false;
        b r24 = this;
        if (TextUtils.isEmpty(r24.f6974d) == false) goto L65;
        r24.f6974d = "";
    L65:
        String r25 = r24.f6974d;
        String r26 = "ttnet_tnc_abtest";
    L66:
        r17.putString(r26, r25).apply();
        defpackage.c.f0(r15, 6, r24.f6974d);
        return r18;
    L68:
        r18 = false;
        r26 = "ttnet_tnc_abtest";
        r24 = this;
        r24.f6972b = r13;     // Catch: Throwable -> L78
        String r27 = r19.toString();     // Catch: Throwable -> L78
        SharedPreferences.Editor r28 = r15.getSharedPreferences("ttnet_tnc_config", 0).edit();
        r28.putString("tnc_config_str", r27).apply();
        defpackage.c.f0(r15, 4, r27);
        if (TextUtils.isEmpty(r21) == true) goto L74;
        r28.putString("ttnet_tnc_etag", r21).apply();
        defpackage.c.f0(r15, 5, r21);
    L74:
        if (TextUtils.isEmpty(r24.f6974d) == false) goto L76;
        r24.f6974d = "";
    L76:
        r28.putString(r26, r24.f6974d).apply();
        defpackage.c.f0(r15, 6, r24.f6974d);
        return true;
    L78:
        th = th;
    L101:
        th.printStackTrace();     // Catch: Throwable -> L90
        r24.f6972b = new a();     // Catch: Throwable -> L90
        r17 = r15.getSharedPreferences("ttnet_tnc_config", r18 ? 1 : 0).edit();
        r17.putString("tnc_config_str", "").apply();
        defpackage.c.f0(r15, 4, "");
        if (TextUtils.isEmpty(r21) == true) goto L87;
        r17.putString("ttnet_tnc_etag", r21).apply();
        defpackage.c.f0(r15, 5, r21);
    L87:
        if (TextUtils.isEmpty(r24.f6974d) == false) goto L89;
        r24.f6974d = "";
    L89:
        r25 = r24.f6974d;
    L90:
        th = move-exception;
        SharedPreferences.Editor r29 = r15.getSharedPreferences("ttnet_tnc_config", r18 ? 1 : 0).edit();
        r29.putString("tnc_config_str", "").apply();
        defpackage.c.f0(r15, 4, "");
        if (TextUtils.isEmpty(r21) == true) goto L95;
        r29.putString("ttnet_tnc_etag", r21).apply();
        defpackage.c.f0(r15, 5, r21);
    L95:
        if (TextUtils.isEmpty(r24.f6974d) == false) goto L97;
        r24.f6974d = "";
    L97:
        r29.putString(r26, r24.f6974d).apply();
        defpackage.c.f0(r15, 6, r24.f6974d);
        throw th;
    L80:
        th = th;
        r18 = false;
        r26 = "ttnet_tnc_abtest";
        r24 = this;
        goto L101
    L21:
        if (r11.size() != 3) goto L45;
        String r30 = (String) ((Pair) r11.get(1)).second;
        String r31 = (String) ((Pair) r11.get(0)).second;
        if (((String) ((Pair) r11.get(2)).first).equals("force_accept") == true) goto L26;
    L28:
        String r32 = k7.b.e().f8965e;
        if (r32.equals("did") == true) goto L39;
        if (r32.equals("uid") == true) goto L39;
        if (r30.equals("did") == false) goto L36;
    L43:
        r12 = false;
    L44:
        Logger.d("TNCConfigHandler", "accept: " + r12 + " tnc source: " + r30 + " tnc region: " + r31 + " user source: " + r32 + " user region: " + k7.b.e().f8961a);
        goto L47
    L36:
        if (r30.equals("uid") == true) goto L43;
    L42:
        r12 = true;
    L39:
        if (r30.equals(r32) == false) goto L43;
        if (r31.equals(k7.b.e().f8961a) == false) goto L43;
    L26:
        if (((String) ((Pair) r11.get(2)).second).equals("true") == false) goto L28;
    L13:
        if (r8.f8971k == true) goto L15;
        r10 = true;
    L46:
        r12 = true;
        goto L47
    }

    public final void c(long r13) {
        Context r8 = this.f6971a;
        String r10 = defpackage.c.H(r8, 4);     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r10) == false) goto L9;
        r10 = b();     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r10) == false) goto L9;
        Logger.d("TNCConfigHandler", "load local config failed.");     // Catch: Throwable -> L19
        return;
    L9:
        JSONObject r11 = new JSONObject(r10);     // Catch: Throwable -> L19
        a r12 = d(r11);     // Catch: Throwable -> L19
        String r14 = defpackage.c.H(r8, 5);     // Catch: Throwable -> L19
        String r15 = defpackage.c.H(r8, 6);     // Catch: Throwable -> L19
        j r16 = j.e();     // Catch: Throwable -> L19
        d.b r17 = d.b.f6993b;     // Catch: Throwable -> L19
        r16.g(r11, 0, r14, r15, r13);     // Catch: Throwable -> L19
        e.g().k(r11);     // Catch: Throwable -> L19
        w8.e.a(r11);     // Catch: Throwable -> L19
        t6.a.a(r11);     // Catch: Throwable -> L19
        if (Logger.debug() == false) goto L16;
        StringBuilder r18 = new StringBuilder("loadLocalConfigForOtherProcess, config: ");     // Catch: Throwable -> L19
        if (r12 != null) goto L14;
        String r19 = "null";
    L15:
        r18.append(r19);     // Catch: Throwable -> L19
        Logger.d("TNCConfigHandler", r18.toString());     // Catch: Throwable -> L19
        goto L16
    L14:
        r19 = r12.toString();     // Catch: Throwable -> L19
    L16:
        if (r12 == null) goto L25;
        this.f6972b = r12;     // Catch: Throwable -> L19
        return;
    L25:
        return;
    L19:
        th = move-exception;
        if (Logger.debug() == false) goto L26;
        Logger.d("TNCConfigHandler", "loadLocalConfigForOtherProcess, except: " + th.getMessage());
        return;
    }
}
