package o4;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
import c4.m;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static void a(c r19, JSONArray r20) {
        JSONArray r8 = r20;
        if (r8 != null) goto L5;
        return;
    L5:
        if (r20.length() <= 0) goto L148;
        r19.f9653c = r8;
        int r10 = 0;
    L112:
        if (r10 >= r20.length()) goto L149;
        JSONObject r11 = r8.optJSONObject(r10);     // Catch: Throwable -> L109
        if (r11 == null) goto L108;
        int r12 = r11.optInt("sampling_rate");     // Catch: Throwable -> L109
        if (r12 >= 10000) goto L108;
        int r13 = r11.optInt("sampling_method");     // Catch: Throwable -> L109
        HashSet r14 = new HashSet();     // Catch: Throwable -> L109
        JSONArray r15 = r11.optJSONArray("events");     // Catch: Throwable -> L109
        if (r15 != null) goto L17;
    L25:
        HashMap r16 = new HashMap();     // Catch: Throwable -> L109
        JSONObject r17 = r11.optJSONObject("param_keys");     // Catch: Throwable -> L109
        if (r17 == null) goto L57;
        Iterator<String> r18 = r17.keys();     // Catch: Throwable -> L109
    L29:
        if (r18.hasNext() == false) goto L57;
        String r110 = r18.next();     // Catch: Throwable -> L109
        if (TextUtils.isEmpty(r110) == true) goto L29;
        JSONArray r111 = r17.optJSONArray(r110);     // Catch: Throwable -> L109
        if (r111 != null) goto L36;
    L55:
        JSONObject r112 = r17;
    L56:
        r17 = r112;
        goto L29
    L36:
        if (r111.length() <= 0) goto L55;
        ArrayList r113 = new ArrayList();     // Catch: Throwable -> L109
        int r114 = 0;
    L39:
        if (r114 >= r111.length()) goto L54;
        JSONArray r115 = r111.optJSONArray(r114);     // Catch: Throwable -> L109
        if (r115 == null) goto L53;
        if (r115.length() <= 0) goto L53;
        HashSet r21 = new HashSet();     // Catch: Throwable -> L109
        int r22 = 0;
    L46:
        if (r22 >= r115.length()) goto L51;
        String r23 = r115.optString(r22);     // Catch: Throwable -> L109
        if (TextUtils.isEmpty(r23) == true) goto L50;
        r21.add(r23);     // Catch: Throwable -> L109
    L50:
        r22 = r22 + 1;     // Catch: Throwable -> L109
        goto L46
    L51:
        r113.add(r21);     // Catch: Throwable -> L109
    L53:
        r114 = r114 + 1;     // Catch: Throwable -> L109
        r17 = r17;
        goto L39
    L54:
        r112 = r17;
        r16.put(r110, r113);     // Catch: Throwable -> L109
    L57:
        HashMap r116 = new HashMap();     // Catch: Throwable -> L109
        JSONObject r24 = r11.optJSONObject("param_key_values");     // Catch: Throwable -> L109
        if (r24 == null) goto L91;
        Iterator<String> r25 = r24.keys();     // Catch: Throwable -> L109
    L61:
        if (r25.hasNext() == false) goto L91;
        String r26 = r25.next();     // Catch: Throwable -> L109
        if (TextUtils.isEmpty(r26) == true) goto L61;
        JSONArray r27 = r24.optJSONArray(r26);     // Catch: Throwable -> L109
        if (r27 != null) goto L68;
    L88:
        JSONObject r117 = r24;
        Iterator<String> r118 = r25;
    L89:
        r25 = r118;
        r24 = r117;
        goto L61
    L68:
        if (r27.length() <= 0) goto L88;
        ArrayList r28 = new ArrayList();     // Catch: Throwable -> L109
        int r119 = 0;
    L71:
        if (r119 >= r27.length()) goto L87;
        JSONObject r120 = r27.optJSONObject(r119);     // Catch: Throwable -> L109
        if (r120 == null) goto L85;
        HashMap r121 = new HashMap();     // Catch: Throwable -> L109
        Iterator<String> r122 = r120.keys();     // Catch: Throwable -> L109
    L76:
        if (r122.hasNext() == false) goto L84;
        JSONObject r123 = r24;
        String r29 = r122.next();     // Catch: Throwable -> L109
        if (TextUtils.isEmpty(r29) == true) goto L82;
        Iterator<String> r124 = r25;
        Object r30 = r120.opt(r29);     // Catch: Throwable -> L109
        if (r30 == null) goto L83;
        r121.put(r29, r30);     // Catch: Throwable -> L109
    L83:
        r25 = r124;
        r24 = r123;
        goto L76
    L82:
        r124 = r25;
        goto L83
    L84:
        JSONObject r125 = r24;
        Iterator<String> r126 = r25;
        r28.add(r121);     // Catch: Throwable -> L109
    L86:
        r119 = r119 + 1;     // Catch: Throwable -> L109
        r25 = r126;
        r24 = r125;
        goto L71
    L85:
        r125 = r24;
        r126 = r25;
        goto L86
    L87:
        r117 = r24;
        r118 = r25;
        r116.put(r26, r28);     // Catch: Throwable -> L109
    L91:
        if (r13 != 1) goto L93;
        Object r31 = new g(r12, r14, r16, r116);     // Catch: Throwable -> L109
    L106:
        if (r31 == null) goto L108;
        r19.f9655e.add(r31);     // Catch: Throwable -> L109
        goto L108
    L93:
        if (r13 != 2) goto L95;
        r31 = new e(r12, 0, r16, r116, r14);     // Catch: Throwable -> L109
        goto L106
    L95:
        if (r13 != 3) goto L97;
        r31 = new f(r12, 0, r16, r116, r14);     // Catch: Throwable -> L109
        goto L106
    L97:
        if (r13 != 4) goto L99;
        r31 = new e(r12, 1, r16, r116, r14);     // Catch: Throwable -> L109
        goto L106
    L99:
        if (r13 == 6) goto L101;
        r31 = null;
        goto L106
    L101:
        r31 = new f(r12, 1, r16, r116, r14);     // Catch: Throwable -> L109
        goto L106
    L17:
        if (r15.length() <= 0) goto L25;
        int r32 = 0;
    L20:
        if (r32 >= r15.length()) goto L25;
        String r33 = r15.optString(r32);     // Catch: Throwable -> L109
        if (TextUtils.isEmpty(r33) == true) goto L24;
        r14.add(r33);     // Catch: Throwable -> L109
    L24:
        r32 = r32 + 1;     // Catch: Throwable -> L109
    L108:
        r10 = r10 + 1;
        r8 = r20;
        goto L112
    L149:
        return;
    L109:
        th = move-exception;
        m.u().k(th, 12, "loadSamplingMapFromJsonArray error", new Object[0]);
        return;
    }

    public static c b(Application r8, String r10, JSONObject r11, c r12) {
        c r13 = new c();     // Catch: Throwable -> L14
        r13.f9651a = r11.optInt("event_sampling_version", 0);     // Catch: Throwable -> L14
        r13.f9652b = r11.optInt(QesdkUtils.TAGS.JSON_TAG_CAPABILITY, 0);     // Catch: Throwable -> L14
        r13.f9654d = r11.optJSONArray("config_ids");     // Catch: Throwable -> L14
        JSONArray r14 = r11.optJSONArray("samplings");     // Catch: Throwable -> L14
        a(r13, r14);     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r10) == false) goto L6;
        r10 = "sampling_list";
    L6:
        SharedPreferences.Editor r15 = r8.getSharedPreferences(r10, 0).edit();     // Catch: Throwable -> L14
        r15.putInt(QesdkUtils.TAGS.JSON_TAG_CAPABILITY, r13.f9652b);     // Catch: Throwable -> L14
        r15.putInt("version", r13.f9651a);     // Catch: Throwable -> L14
        if (r14 == null) goto L9;
        r15.putString("samplings", r14.toString());     // Catch: Throwable -> L14
    L9:
        JSONArray r16 = r13.f9654d;     // Catch: Throwable -> L14
        if (r16 == null) goto L12;
        r15.putString("config_ids", r16.toString());     // Catch: Throwable -> L14
    L12:
        r15.apply();     // Catch: Throwable -> L14
        return r13;
    L14:
        th = move-exception;
        m.u().k(th, 12, "parseEventSamplingFromServer", new Object[0]);
        return r12;
    }
}
