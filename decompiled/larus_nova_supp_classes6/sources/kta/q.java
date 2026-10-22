package kta;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class q {
    public final SharedPreferences a;

    public q(Context r3) {
        SharedPreferences r0 = r3.getSharedPreferences("device_register_oaid_refine", 0);
        this.a = r0;
        a(r3, r0);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public static void a(Context r21, SharedPreferences r22) {
        if (r22.getBoolean("migrated", false) == false) goto L5;
        return;
    L5:
        r22.edit().putBoolean("migrated", true).apply();
        SharedPreferences r1 = r21.getSharedPreferences("device-register-oaid", 0);
        long r6 = -1;
        p r12 = null;
        if (r1.contains("lastSuccessQueryOaid") == false) goto L32;
        String r0 = r1.getString("lastSuccessQueryOaid", null);
        Integer r19 = Integer.valueOf(r1.getInt("queryHmsTimes", -1));
        if (TextUtils.isEmpty(r0) == false) goto L64;
    L31:
        r1.edit().clear().apply();
    L54:
        Objects.toString(r12);
        if (r12 == null) goto L72;
        r22.edit().putString("oaid", r12.a().toString()).apply();
        return;
    L72:
        return;
    L64:
        JSONObject r2 = new JSONObject(r0);     // Catch: JSONException -> L29
        String r14 = r2.optString("id");     // Catch: JSONException -> L29
        String r3 = r2.optString("is_track_limited");     // Catch: JSONException -> L29
        String r4 = r2.optString("take_ms");     // Catch: JSONException -> L29
        String r5 = r2.optString("time");     // Catch: JSONException -> L29
        String r15 = r2.optString("req_id");     // Catch: JSONException -> L29
        String r7 = r2.optString("hw_id_version_code");     // Catch: JSONException -> L29
        Boolean r16 = Boolean.valueOf(Boolean.parseBoolean(r3));     // Catch: JSONException -> L29
        long r10 = CastLongProtector.parseLong(r4);     // Catch: NumberFormatException -> L12 JSONException -> L29
    L15:
        Long r17 = Long.valueOf(r10);     // Catch: JSONException -> L29
        long r8 = CastLongProtector.parseLong(r5);     // Catch: NumberFormatException -> L18 JSONException -> L29
    L21:
        Long r18 = Long.valueOf(r8);     // Catch: JSONException -> L29
        r6 = CastLongProtector.parseLong(r7);     // Catch: NumberFormatException -> L24 JSONException -> L29
    L27:
        r12 = new p(r14, r15, r16, r17, r18, r19, Long.valueOf(r6));     // Catch: JSONException -> L29
        goto L31
    L24:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L29
        goto L27
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L29
        r8 = -1;
        goto L21
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L29
        r10 = -1;
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L31
    L32:
        SharedPreferences r9 = r21.getSharedPreferences("device-register-oaid-xiaomi", 0);
        if (r9.contains("lastSuccessQueryOaid") == false) goto L53;
        String r11 = r9.getString("lastSuccessQueryOaid", null);
        Integer r110 = Integer.valueOf(r9.getInt("queryXiaomiTimes", -1));
        if (TextUtils.isEmpty(r11) == true) goto L53;
        JSONObject r13 = new JSONObject(r11);     // Catch: JSONException -> L51
        String r111 = r13.optString("oaid");     // Catch: JSONException -> L51
        String r112 = r13.optString("req_id");     // Catch: JSONException -> L51
        String r20 = r13.optString("last_success_query_oaid_time");     // Catch: JSONException -> L51
        long r23 = CastLongProtector.parseLong(r13.optString("take_ms"));     // Catch: NumberFormatException -> L40 JSONException -> L51
    L43:
        Long r113 = Long.valueOf(r23);     // Catch: JSONException -> L51
        r6 = CastLongProtector.parseLong(r20);     // Catch: NumberFormatException -> L46 JSONException -> L51
    L49:
        r12 = new p(r111, r112, null, r113, Long.valueOf(r6), r110, null);     // Catch: JSONException -> L51
        goto L53
    L46:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L51
        goto L49
    L40:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L51
        r23 = -1;
    L51:
        e = move-exception;
        e.printStackTrace();
    L53:
        r9.edit().clear().apply();
        goto L54
    }
}
