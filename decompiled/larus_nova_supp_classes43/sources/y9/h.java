package y9;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.android.annie.Annie;
import com.bytedance.ies.bullet.service.base.m0;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h {
    public static final Map<String, JSONObject> a = null;
    public static final Map<String, Map<String, Object>> b = null;
    public static final String c = null;
    public static SharedPreferences d;
    public static SharedPreferences e;

    static {
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
        c = "annie_setting_from_server_key";
        b();
        boolean r0 = j.a;
        j.b.observeOn(Schedulers.io()).map(new b()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(), new d());
        j.c.map(new e()).subscribe(new f(), new g());
    }

    private static Context getContext() {
        if (com.bytedance.android.annie.ng.g.g == true) goto L5;
        return null;
    L5:
        return com.bytedance.android.annie.ng.g.a;
    }

    public static SharedPreferences b() {
        if (d() == false) goto L5;
        return null;
    L5:
        SharedPreferences r0 = d;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (getContext() == null) goto L18;
        d = getContext().getSharedPreferences("annie_setting_sp", 0);
        s26.d r1 = s26.d.c;
        m0 r10 = s26.d.c.c(m0.class);
        if (r10 == null) goto L20;
        r10.a0();
    L20:
        SharedPreferences r11 = d;     // Catch: JSONException -> L14
        String r12 = c;     // Catch: JSONException -> L14
        ((ConcurrentHashMap) a).put(r12, new JSONObject(r11.getString(r12, "")));     // Catch: JSONException -> L14
    L17:
        return d;
    L14:
        e = move-exception;
        int r13 = x8.a.a;
        x8.a.a("AnnieSettingCache", "init e: " + e);
        ((ConcurrentHashMap) a).put(c, new JSONObject());
        goto L17
    L18:
        return null;
    }

    public static boolean d() {
        if (com.bytedance.ies.bullet.base.settings.c.a().b() != 0) goto L7;
        return false;
    L7:
        if (com.bytedance.android.annie.ng.g.g == true) goto L10;
        return true;
    L10:
        return !com.bytedance.android.annie.ng.g.b().c.c;
    }

    public static SharedPreferences a(Context r10) {
        if (d() == false) goto L6;
        return null;
    L6:
        if (e != null) goto L15;
        if (r10 == null) goto L11;
        e = r10.getSharedPreferences("annie_setting_sp_local_test", 0);
        goto L15
    L11:
        if (getContext() == null) goto L13;
        e = getContext().getSharedPreferences("annie_setting_sp_local_test", 0);
        goto L15
    L13:
        return null;
    L15:
        return e;
    }

    public static Boolean f(String r10) {
        if (com.bytedance.android.annie.ng.g.g == true) goto L5;
    L11:
        boolean r11 = false;
    L13:
        return Boolean.valueOf(r11);
    L5:
        if (com.bytedance.android.annie.ng.g.b.a.a == false) goto L11;
        if (a(null) == null) goto L11;
        if (a(null).contains(r10) == false) goto L11;
        r11 = true;
        goto L13
    }

    public static Object c(String r10, Type r11, Object r12) {
        if ((Annie.getService(n.class) instanceof k) == false) goto L5;
        b();
        if (r11 != Boolean.class) goto L23;
        boolean r13 = ((Boolean) r12).booleanValue();
        if (f(r10).booleanValue() == false) goto L13;
        SharedPreferences r14 = e;
        if (r14 == null) goto L13;
        r13 = r14.getBoolean(r10, r13);
    L129:
        return Boolean.valueOf(r13);
    L13:
        JSONObject r15 = (JSONObject) ((ConcurrentHashMap) a).get("annie_setting_from_server_key");
        if (r15 == null) goto L129;
        r13 = JSONObjectProtectorUtils.getBoolean(r15, r10);     // Catch: Exception -> L17
    L17:
        if (JSONObjectProtectorUtils.getInt(r15, r10) == 0) goto L20;
        r13 = true;
        goto L129
    L20:
        r13 = false;
        goto L129
    L23:
        if (r11 != Integer.class) goto L25;
    L108:
        int r16 = ((Integer) r12).intValue();
        if (f(r10).booleanValue() == false) goto L113;
        SharedPreferences r17 = e;
        if (r17 == null) goto L113;
        int r18 = r17.getInt(r10, r16);
    L119:
        return Integer.valueOf(r18);
    L113:
        ConcurrentHashMap r19 = (ConcurrentHashMap) a;
        if (r19.get("annie_setting_from_server_key") == null) goto L117;
        r16 = ((JSONObject) r19.get("annie_setting_from_server_key")).optInt(r10, r16);
    L117:
        r18 = r16;
        goto L119
    L25:
        if (r11 == Short.class) goto L108;
        if (r11 != Float.class) goto L41;
        float r20 = ((Float) r12).floatValue();
        if (f(r10).booleanValue() == false) goto L34;
        SharedPreferences r21 = e;
        if (r21 == null) goto L34;
        float r22 = r21.getFloat(r10, r20);
    L130:
        return Float.valueOf(r22);
    L34:
        ConcurrentHashMap r23 = (ConcurrentHashMap) a;
        if (r23.get("annie_setting_from_server_key") == null) goto L38;
        r20 = (float) ((JSONObject) r23.get("annie_setting_from_server_key")).optDouble(r10, r20);
    L38:
        r22 = r20;
        goto L130
    L41:
        if (r11 != Long.class) goto L54;
        long r24 = ((Long) r12).longValue();
        if (f(r10).booleanValue() == false) goto L47;
        SharedPreferences r0 = e;
        if (r0 == null) goto L47;
        long r25 = r0.getLong(r10, r24);
    L131:
        return Long.valueOf(r25);
    L47:
        ConcurrentHashMap r1 = (ConcurrentHashMap) a;
        if (r1.get("annie_setting_from_server_key") == null) goto L51;
        r24 = ((JSONObject) r1.get("annie_setting_from_server_key")).optLong(r10, r24);
    L51:
        r25 = r24;
        goto L131
    L54:
        if (r11 != Double.class) goto L69;
        double r26 = ((Double) r12).doubleValue();
        if (f(r10).booleanValue() == false) goto L63;
        SharedPreferences r27 = e;
        if (r27 == null) goto L63;
        r26 = CastDoubleProtector.parseDouble(r27.getString(r10, String.valueOf(r26)));     // Catch: Exception -> L61
    L132:
        return Double.valueOf(r26);
    L61:
        e = move-exception;
        e.printStackTrace();
    L63:
        ConcurrentHashMap r28 = (ConcurrentHashMap) a;
        if (r28.get("annie_setting_from_server_key") == null) goto L132;
        r26 = ((JSONObject) r28.get("annie_setting_from_server_key")).optDouble(r10, r26);
        goto L132
    L69:
        if (r11 != String.class) goto L121;
        String r29 = (String) r12;
        if (f(r10).booleanValue() == false) goto L75;
        SharedPreferences r30 = e;
        if (r30 == null) goto L75;
        return r30.getString(r10, r29);
    L75:
        ConcurrentHashMap r31 = (ConcurrentHashMap) a;
        Object r32 = r29;
        if (r31.get("annie_setting_from_server_key") == null) goto L134;
        r32 = ((JSONObject) r31.get("annie_setting_from_server_key")).optString(r10, r29);
    L134:
        return r32;
    L121:
        Map<String, Map<String, Object>> r33 = b;     // Catch: JsonSyntaxException -> L105
        if (((ConcurrentHashMap) r33).get("annie_setting_from_server_key") != null) goto L83;
        ((ConcurrentHashMap) r33).put("annie_setting_from_server_key", new ConcurrentHashMap());     // Catch: JsonSyntaxException -> L105
    L83:
        if (((Map) ((ConcurrentHashMap) r33).get("annie_setting_from_server_key")).containsKey(r10) == true) goto L126;
    L90:
        Map<String, JSONObject> r34 = a;     // Catch: JsonSyntaxException -> L105
        String r35 = "";
        if (((ConcurrentHashMap) r34).get("annie_setting_from_server_key") == null) goto L96;
        r35 = ((JSONObject) ((ConcurrentHashMap) r34).get("annie_setting_from_server_key")).optString(r10, "");     // Catch: JsonSyntaxException -> L105
    L96:
        if (f(r10).booleanValue() == false) goto L100;
        SharedPreferences r36 = e;     // Catch: JsonSyntaxException -> L105
        if (r36 == null) goto L100;
        r35 = r36.getString(r10, r35);     // Catch: JsonSyntaxException -> L105
    L100:
        Object r37 = GsonProtectorUtils.fromJson(new GsonBuilder().create(), r35, r11);     // Catch: JsonSyntaxException -> L105
        if (r37 != null) goto L103;
        ((Map) ((ConcurrentHashMap) b).get("annie_setting_from_server_key")).remove(r10);     // Catch: JsonSyntaxException -> L105
        r32 = r12;
        goto L134
    L103:
        ((Map) ((ConcurrentHashMap) b).get("annie_setting_from_server_key")).put(r10, r37);     // Catch: JsonSyntaxException -> L105
        r32 = r37;
        goto L134
    L126:
        Object r38 = ((Map) ((ConcurrentHashMap) r33).get("annie_setting_from_server_key")).get(r10);     // Catch: Exception -> L88
        r32 = r12;
        if (r38 == null) goto L134;
        r32 = r38;
        goto L134
    L88:
        e = move-exception;
        e.printStackTrace();     // Catch: JsonSyntaxException -> L105
    L105:
        e = move-exception;
        e.printStackTrace();
        r32 = r12;
        goto L134
    L5:
        return ((n) Annie.getService(n.class)).u1(r10, r11, r12);
    }

    public static void e(Context r10, String r11, String r12, Type r13) {
        if ((Annie.getService(n.class) instanceof k) == true) goto L6;
        ((n) Annie.getService(n.class)).u(r11, r12, r13);     // Catch: NumberFormatException -> L38
        return;
    L6:
        a(r10);     // Catch: NumberFormatException -> L38
        if (e != null) goto L9;
        return;
    L9:
        if (r12 != null) goto L11;
    L34:
        e.edit().remove(r11).apply();     // Catch: NumberFormatException -> L38
        Map<String, Map<String, Object>> r14 = b;     // Catch: NumberFormatException -> L38
        if (((ConcurrentHashMap) r14).get(r11) == null) goto L53;
        ((Map) ((ConcurrentHashMap) r14).get(r11)).remove(r11);     // Catch: NumberFormatException -> L38
        return;
    L53:
        return;
    L11:
        if (TextUtils.isEmpty(r12) == true) goto L34;
        if (r13 != Boolean.class) goto L17;
        e.edit().putBoolean(r11, Boolean.valueOf(Boolean.parseBoolean(r12)).booleanValue()).apply();     // Catch: NumberFormatException -> L38
        return;
    L17:
        if (r13 != Integer.class) goto L20;
        e.edit().putInt(r11, CastIntegerProtector.parseInt(r12)).apply();     // Catch: NumberFormatException -> L38
        return;
    L20:
        if (r13 != Long.class) goto L23;
        e.edit().putLong(r11, CastLongProtector.parseLong(r12)).apply();     // Catch: NumberFormatException -> L38
        return;
    L23:
        if (r13 != Float.class) goto L26;
        e.edit().putFloat(r11, CastFloatProtector.parseFloat(r12)).apply();     // Catch: NumberFormatException -> L38
        return;
    L26:
        if (r13 != Double.class) goto L29;
        e.edit().putString(r11, String.valueOf(CastLongProtector.parseLong(r12))).apply();     // Catch: NumberFormatException -> L38
        return;
    L29:
        if (r13 != String.class) goto L31;
        e.edit().putString(r11, r12).apply();     // Catch: NumberFormatException -> L38
        return;
    L31:
        e.edit().putString(r11, r12).apply();     // Catch: NumberFormatException -> L38
        Map<String, Map<String, Object>> r15 = b;     // Catch: NumberFormatException -> L38
        if (((ConcurrentHashMap) r15).get(r11) == null) goto L51;
        ((Map) ((ConcurrentHashMap) r15).get(r11)).remove(r11);     // Catch: NumberFormatException -> L38
        return;
    L51:
        return;
    L39:
        if (com.bytedance.android.annie.ng.g.g == true) goto L41;
        return;
    L41:
        if (com.bytedance.android.annie.ng.g.b.a.a == false) goto L55;
        Toast.makeText(getContext(), String.format(Locale.US, "Illegal value of %s : %s", new Object[]{r11, r12}), 0).show();
        return;
    }
}
