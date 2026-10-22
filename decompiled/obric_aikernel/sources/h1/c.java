package h1;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f9154a = null;

    static {
        f9154a = Collections.singletonList("EventPriorityLoader");
    }

    private static String a(com.bytedance.applog.c r10) {
        return com.bytedance.applog.b.b(r10, "priority_list");
    }

    public static a b(com.bytedance.applog.c r10, g1.b r11) {
        a r12 = new a();
        SharedPreferences r13 = r11.k().getSharedPreferences(a(r10), 0);
        r12.f9132a = r13.getInt("priority_version", 0);
        r12.f9133b = r13.getInt("base_interval", 5);
        String r14 = r13.getString("priorities", null);
        if (TextUtils.isEmpty(r14) == false) goto L9;
    L8:
        return r12;
    L9:
        d(r10, r11, r12, new JSONArray(r14));     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        r10.P().u(f9154a, "parseEventPriorityFromLocal failed", e, new Object[0]);
        goto L8
    }

    public static void c(com.bytedance.applog.c r10, g1.b r11, @NonNull JSONObject r12) {
        JSONObject r13 = r12.optJSONObject("priority_list");
        if (r13 != null) goto L15;
        return;
    L15:
        a r14 = new a();     // Catch: Throwable -> L12
        r14.f9132a = r13.optInt("priority_version", 0);     // Catch: Throwable -> L12
        r14.f9133b = r13.optInt("base_interval", 5);     // Catch: Throwable -> L12
        JSONArray r15 = r13.optJSONArray("priorities");     // Catch: Throwable -> L12
        d(r10, r11, r14, r15);     // Catch: Throwable -> L12
        a r16 = r11.o();     // Catch: Throwable -> L12
        if (r14.e() == false) goto L18;
        if (r16 != null) goto L9;
    L10:
        r11.M(r14, true);     // Catch: Throwable -> L12
        SharedPreferences.Editor r17 = r11.k().getSharedPreferences(a(r10), 0).edit();     // Catch: Throwable -> L12
        r17.putInt("priority_version", r14.f9132a);     // Catch: Throwable -> L12
        r17.putInt("base_interval", r14.f9133b);     // Catch: Throwable -> L12
        r17.putString("priorities", r15.toString());     // Catch: Throwable -> L12
        r17.apply();     // Catch: Throwable -> L12
        return;
    L9:
        if (r14.f9132a > r16.f9132a) goto L10;
        return;
    L18:
        return;
    L12:
        th = move-exception;
        r10.P().u(f9154a, "parseEventPriorityFromServer", th, new Object[0]);
    }

    private static void d(com.bytedance.applog.c r17, g1.b r18, a r19, JSONArray r20) {
        JSONArray r10 = r20;
        r19.f9134c = new HashMap();
        r19.f9136e = new HashMap();
        if (r10 != null) goto L5;
        return;
    L5:
        if (r20.length() <= 0) goto L147;
        r19.f(r20);
        int r11 = 0;
    L104:
        if (r11 >= r20.length()) goto L91;
        JSONObject r12 = r10.optJSONObject(r11);     // Catch: Throwable -> L98
        if (r12 == null) goto L90;
        b r13 = new b();     // Catch: Throwable -> L98
        int r14 = r12.optInt("priority");     // Catch: Throwable -> L98
        r13.f9138a = r14;     // Catch: Throwable -> L98
        if (r14 <= r19.f9135d) goto L14;
        r19.f9135d = r14;     // Catch: Throwable -> L98
    L14:
        r13.f9140c = r19.f9132a;     // Catch: Throwable -> L98
        int r15 = r12.optInt("interval_multiple");     // Catch: Throwable -> L98
        r13.f9141d = r15;     // Catch: Throwable -> L98
        if (r15 > 0) goto L17;
        r13.f9141d = 1;     // Catch: Throwable -> L98
    L17:
        long r16 = ((long) (r19.f9133b * r13.f9141d)) * 1000;     // Catch: Throwable -> L98
        r13.f9142e = r16;     // Catch: Throwable -> L98
        r13.f9149l = new n1.a(r17, r18, r16);     // Catch: Throwable -> L96
        r13.f9145h = r12.optString("report_host");     // Catch: Throwable -> L96
        r13.f9146i = r12.optString("report_path");     // Catch: Throwable -> L96
        r13.f9150m = r12.optInt("forward_open");     // Catch: Throwable -> L96
        r13.f9151n = r12.optString("forward_report_host");     // Catch: Throwable -> L96
        r13.f9152o = r12.optString("forward_report_path");     // Catch: Throwable -> L96
        JSONArray r21 = r12.optJSONArray("events");     // Catch: Throwable -> L96
        if (r21 != null) goto L22;
    L30:
        JSONObject r22 = r12.optJSONObject("param_keys");     // Catch: Throwable -> L96
        if (r22 == null) goto L60;
        r13.f9143f = new HashMap();     // Catch: Throwable -> L96
        Iterator<String> r23 = r22.keys();     // Catch: Throwable -> L96
    L34:
        if (r23.hasNext() == false) goto L60;
        String r24 = r23.next();     // Catch: Throwable -> L96
        if (TextUtils.isEmpty(r24) == true) goto L34;
        JSONArray r110 = r22.optJSONArray(r24);     // Catch: Throwable -> L96
        if (r110 == null) goto L34;
        if (r110.length() <= 0) goto L34;
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L96
        int r112 = 0;
    L44:
        if (r112 >= r110.length()) goto L58;
        JSONArray r113 = r110.optJSONArray(r112);     // Catch: Throwable -> L96
        if (r113 == null) goto L57;
        if (r113.length() <= 0) goto L57;
        HashSet r114 = new HashSet();     // Catch: Throwable -> L96
        int r25 = 0;
    L51:
        if (r25 >= r113.length()) goto L56;
        String r26 = r113.optString(r25);     // Catch: Throwable -> L96
        if (TextUtils.isEmpty(r26) == true) goto L55;
        r114.add(r26);     // Catch: Throwable -> L96
    L55:
        r25 = r25 + 1;     // Catch: Throwable -> L96
        goto L51
    L56:
        r111.add(r114);     // Catch: Throwable -> L96
    L57:
        r112 = r112 + 1;     // Catch: Throwable -> L96
        goto L44
    L58:
        r13.f9143f.put(r24, r111);     // Catch: Throwable -> L96
    L60:
        JSONObject r27 = r12.optJSONObject("param_key_values");     // Catch: Throwable -> L96
        if (r27 == null) goto L88;
        r13.f9144g = new HashMap();     // Catch: Throwable -> L96
        Iterator<String> r28 = r27.keys();     // Catch: Throwable -> L96
    L64:
        if (r28.hasNext() == false) goto L88;
        String r29 = r28.next();     // Catch: Throwable -> L96
        if (TextUtils.isEmpty(r29) == true) goto L64;
        JSONArray r30 = r27.optJSONArray(r29);     // Catch: Throwable -> L96
        if (r30 == null) goto L64;
        if (r30.length() <= 0) goto L64;
        ArrayList r31 = new ArrayList();     // Catch: Throwable -> L96
        int r32 = 0;
    L74:
        if (r32 >= r30.length()) goto L87;
        JSONObject r115 = r30.optJSONObject(r32);     // Catch: Throwable -> L96
        if (r115 == null) goto L86;
        HashMap r116 = new HashMap();     // Catch: Throwable -> L96
        Iterator<String> r117 = r115.keys();     // Catch: Throwable -> L96
    L79:
        if (r117.hasNext() == false) goto L85;
        String r118 = r117.next();     // Catch: Throwable -> L96
        if (TextUtils.isEmpty(r118) == true) goto L79;
        Object r119 = r115.opt(r118);     // Catch: Throwable -> L96
        if (r119 == null) goto L79;
        r116.put(r118, r119);     // Catch: Throwable -> L96
        goto L79
    L85:
        r31.add(r116);     // Catch: Throwable -> L96
    L86:
        r32 = r32 + 1;     // Catch: Throwable -> L96
        goto L74
    L87:
        r13.f9144g.put(r29, r31);     // Catch: Throwable -> L96
    L88:
        r19.f9134c.put(Integer.valueOf(r13.f9138a), r13);     // Catch: Throwable -> L96
        goto L90
    L22:
        if (r21.length() <= 0) goto L30;
        int r33 = 0;
    L25:
        if (r33 >= r21.length()) goto L30;
        String r34 = r21.optString(r33);     // Catch: Throwable -> L96
        if (TextUtils.isEmpty(r34) == true) goto L29;
        r19.f9136e.put(r34, Integer.valueOf(r13.f9138a));     // Catch: Throwable -> L96
    L29:
        r33 = r33 + 1;     // Catch: Throwable -> L96
    L96:
        th = th;
    L100:
        r17.P().u(f9154a, "parsePriorityMapFromJsonArray failed", th, new Object[0]);
        return;
    L90:
        r11 = r11 + 1;     // Catch: Throwable -> L96
        r10 = r20;
        goto L104
    L91:
        Iterator<b> r35 = r19.f9134c.values().iterator();     // Catch: Throwable -> L96
    L92:
        if (r35.hasNext() == false) goto L148;
        b r36 = r35.next();     // Catch: Throwable -> L96
        r36.f9139b = r19.f9135d;     // Catch: Throwable -> L96
        goto L92
    L148:
        return;
    L98:
        th = th;
        goto L100
    }

    public static void e(@NonNull JSONObject r10, a r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        JSONArray r12 = r10.optJSONArray("priority_request_config");
        if (r12 != null) goto L7;
        return;
    L7:
        if (r12.length() <= 0) goto L22;
        int r13 = 0;
    L10:
        if (r13 >= r12.length()) goto L23;
        JSONObject r14 = r12.optJSONObject(r13);
        if (r14 == null) goto L16;
        b r15 = r11.a(r14.optInt("priority"));
        if (r15 == null) goto L16;
        r15.f9149l.c(r14, r15.c(), r15);
    L16:
        r13 = r13 + 1;
        goto L10
    L23:
        return;
    }
}
