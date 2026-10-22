package i1;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import f1.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static void a(b r17, JSONArray r18) {
        JSONArray r10 = r18;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r18.length() <= 0) goto L125;
        r17.e(r18);
        int r11 = 0;
    L90:
        if (r11 >= r18.length()) goto L126;
        JSONObject r12 = r10.optJSONObject(r11);     // Catch: Throwable -> L87
        if (r12 == null) goto L86;
        int r13 = r12.optInt("sampling_rate");     // Catch: Throwable -> L87
        int r14 = r12.optInt("sampling_method");     // Catch: Throwable -> L87
        HashSet r15 = new HashSet();     // Catch: Throwable -> L87
        JSONArray r16 = r12.optJSONArray("events");     // Catch: Throwable -> L87
        if (r16 != null) goto L14;
    L22:
        HashMap r19 = new HashMap();     // Catch: Throwable -> L87
        JSONObject r20 = r12.optJSONObject("param_keys");     // Catch: Throwable -> L87
        if (r20 == null) goto L52;
        Iterator<String> r21 = r20.keys();     // Catch: Throwable -> L87
    L26:
        if (r21.hasNext() == false) goto L52;
        String r110 = r21.next();     // Catch: Throwable -> L87
        if (TextUtils.isEmpty(r110) == true) goto L26;
        JSONArray r111 = r20.optJSONArray(r110);     // Catch: Throwable -> L87
        if (r111 == null) goto L26;
        if (r111.length() <= 0) goto L26;
        ArrayList r112 = new ArrayList();     // Catch: Throwable -> L87
        int r113 = 0;
    L36:
        if (r113 >= r111.length()) goto L50;
        JSONArray r114 = r111.optJSONArray(r113);     // Catch: Throwable -> L87
        if (r114 == null) goto L49;
        if (r114.length() <= 0) goto L49;
        HashSet r115 = new HashSet();     // Catch: Throwable -> L87
        int r22 = 0;
    L43:
        if (r22 >= r114.length()) goto L48;
        String r23 = r114.optString(r22);     // Catch: Throwable -> L87
        if (TextUtils.isEmpty(r23) == true) goto L47;
        r115.add(r23);     // Catch: Throwable -> L87
    L47:
        r22 = r22 + 1;     // Catch: Throwable -> L87
        goto L43
    L48:
        r112.add(r115);     // Catch: Throwable -> L87
    L49:
        r113 = r113 + 1;     // Catch: Throwable -> L87
        goto L36
    L50:
        r19.put(r110, r112);     // Catch: Throwable -> L87
    L52:
        HashMap r116 = new HashMap();     // Catch: Throwable -> L87
        JSONObject r24 = r12.optJSONObject("param_key_values");     // Catch: Throwable -> L87
        if (r24 == null) goto L85;
        Iterator<String> r25 = r24.keys();     // Catch: Throwable -> L87
    L56:
        if (r25.hasNext() == false) goto L85;
        String r26 = r25.next();     // Catch: Throwable -> L87
        if (TextUtils.isEmpty(r26) == true) goto L56;
        JSONArray r27 = r24.optJSONArray(r26);     // Catch: Throwable -> L87
        if (r27 != null) goto L63;
    L83:
        JSONObject r117 = r24;
    L84:
        r24 = r117;
        goto L56
    L63:
        if (r27.length() <= 0) goto L83;
        ArrayList r28 = new ArrayList();     // Catch: Throwable -> L87
        int r118 = 0;
    L66:
        if (r118 >= r27.length()) goto L82;
        JSONObject r119 = r27.optJSONObject(r118);     // Catch: Throwable -> L87
        if (r119 == null) goto L80;
        HashMap r120 = new HashMap();     // Catch: Throwable -> L87
        Iterator<String> r121 = r119.keys();     // Catch: Throwable -> L87
    L71:
        if (r121.hasNext() == false) goto L79;
        String r122 = r121.next();     // Catch: Throwable -> L87
        if (TextUtils.isEmpty(r122) == true) goto L77;
        JSONObject r123 = r24;
        Object r29 = r119.opt(r122);     // Catch: Throwable -> L87
        if (r29 == null) goto L78;
        r120.put(r122, r29);     // Catch: Throwable -> L87
    L78:
        r24 = r123;
        goto L71
    L77:
        r123 = r24;
        goto L78
    L79:
        JSONObject r124 = r24;
        r28.add(r120);     // Catch: Throwable -> L87
    L81:
        r118 = r118 + 1;     // Catch: Throwable -> L87
        r24 = r124;
        goto L66
    L80:
        r124 = r24;
        goto L81
    L82:
        r117 = r24;
        r116.put(r26, r28);     // Catch: Throwable -> L87
    L85:
        r17.a(r13, r14, r15, r19, r116);     // Catch: Throwable -> L87
        goto L86
    L14:
        if (r16.length() <= 0) goto L22;
        int r30 = 0;
    L17:
        if (r30 >= r16.length()) goto L22;
        String r31 = r16.optString(r30);     // Catch: Throwable -> L87
        if (TextUtils.isEmpty(r31) == true) goto L21;
        r15.add(r31);     // Catch: Throwable -> L87
    L21:
        r30 = r30 + 1;     // Catch: Throwable -> L87
    L86:
        r11 = r11 + 1;
        r10 = r18;
        goto L90
    L126:
        return;
    L87:
        th = move-exception;
        n.B().v(12, "loadSamplingMapFromJsonArray error", th, new Object[0]);
        return;
    }

    public static b b(Context r10, String r11, JSONObject r12, b r13) {
        if (r12 != null) goto L21;
        return r13;
    L21:
        b r14 = new b();     // Catch: Throwable -> L18
        r14.f(r12.optInt("event_sampling_version", 0));     // Catch: Throwable -> L18
        JSONArray r15 = r12.optJSONArray("samplings");     // Catch: Throwable -> L18
        a(r14, r15);     // Catch: Throwable -> L18
        if (r13 == null) goto L11;
        if (r14.c() > r13.c()) goto L11;
    L20:
        return r13;
    L11:
        if (TextUtils.isEmpty(r11) == false) goto L13;
        r11 = "sampling_list";
    L13:
        SharedPreferences.Editor r16 = r10.getSharedPreferences(r11, 0).edit();     // Catch: Throwable -> L18
        r16.putInt("event_sampling_version", r14.c());     // Catch: Throwable -> L18
        if (r15 == null) goto L16;
        r16.putString("samplings", r15.toString());     // Catch: Throwable -> L18
    L16:
        r16.apply();     // Catch: Throwable -> L18
        return r14;
    L18:
        th = move-exception;
        n.B().v(12, "parseEventSamplingFromServer", th, new Object[0]);
        goto L20
    }

    public static b c(Context r10, String r11) {
        b r12 = new b();
        if (TextUtils.isEmpty(r11) == false) goto L5;
        r11 = "sampling_list";
    L5:
        SharedPreferences r13 = r10.getSharedPreferences(r11, 0);
        r12.f(r13.getInt("event_sampling_version", 0));
        String r14 = r13.getString("samplings", null);
        if (TextUtils.isEmpty(r14) == false) goto L12;
    L11:
        return r12;
    L12:
        a(r12, new JSONArray(r14));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        n.B().v(12, "parseEventSamplingFromLocal", th, new Object[0]);
        goto L11
    }
}
