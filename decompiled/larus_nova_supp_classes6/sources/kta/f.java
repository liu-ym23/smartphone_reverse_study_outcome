package kta;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.ss.android.common.applog.c0;
import com.ss.android.common.applog.d0;
import e84.k;
import f06.d;
import java.util.Map;
import java.util.Objects;
import jta.g;
import lta.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class f {
    public static String c(n r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        d r11 = r8.b(10000009, "com/ss/android/deviceregister/base/Oaid", "getOaidId", r13, r9, "java.lang.String", r10);
        if (r11.a == false) goto L6;
        r8.a(10000009, "com/ss/android/deviceregister/base/Oaid", "getOaidId", r13, r9, null, r10, false);
        return (String) r11.b;
    L6:
        String r12 = r13.b();
        r8.a(10000009, "com/ss/android/deviceregister/base/Oaid", "getOaidId", r13, r9, r12, r10, true);
        return r12;
    }

    public static void b(Context r4, StringBuilder r5) {
        if (g.f == false) goto L5;
        return;
    L5:
        String[] r0 = pta.c.r(r4);
        if (r0 != null) goto L8;
    L14:
        a(r5, "build_serial", pta.c.q(r4));
        return;
    L8:
        if (r0.length <= 0) goto L14;
        String r1 = r0[0];
        int r2 = 1;
    L11:
        if (r2 >= r0.length) goto L13;
        r1 = r1 + "," + r0[r2];
        r2 = r2 + 1;
        goto L11
    L13:
        a(r5, "sim_serial_number", r1);
        goto L14
    }

    public static void a(StringBuilder r2, String r3, String r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r4) == false) goto L8;
        return;
    L8:
        if (r2.toString().indexOf(63) >= 0) goto L10;
        r2.append("?");
    L11:
        r2.append(r3);
        r2.append("=");
        r2.append(Uri.encode(r4));
        return;
    L10:
        r2.append("&");
        goto L11
    }

    public static void d(Context r7, e r8, JSONObject r9, boolean r10, boolean r11) {
        if (r11 == true) goto L101;
        int r2 = 0;
        SharedPreferences r12 = r7.getSharedPreferences(b.a, 0);
        g r3 = g.a;
        boolean r4 = true;
        String r5 = pta.c.a.b(new Object[]{r7});
        String r6 = r12.getString("mac_addr", null);     // Catch: JSONException -> L25
        if (StringUtils.isEmpty(r6) == false) goto L11;
        if (StringUtils.isEmpty(r5) == false) goto L15;
    L16:
        boolean r13 = false;
    L18:
        if (StringUtils.isEmpty(r5) == false) goto L20;
    L22:
        if (r13 == false) goto L27;
        SharedPreferences.Editor r14 = r12.edit();     // Catch: JSONException -> L25
        r14.putString("mac_addr", r5);     // Catch: JSONException -> L25
        r14.commit();     // Catch: JSONException -> L25
    L27:
        if (r8 == null) goto L66;
        String r15 = ((jta.e) r8.e).g();     // Catch: JSONException -> L63
        if (StringUtils.isEmpty(r15) == true) goto L31;
        r9.put("udid", r15);     // Catch: JSONException -> L63
    L31:
        JSONArray r16 = r8.h();     // Catch: JSONException -> L63
        pta.c.a r0 = pta.c.a;     // Catch: JSONException -> L63
        if (r16 == null) goto L43;
        int r1 = r16.length();     // Catch: JSONException -> L63
        if (r1 <= 0) goto L43;
        int r17 = 0;
    L36:
        if (r17 >= r1) goto L43;
        JSONObject r18 = r16.optJSONObject(r17);     // Catch: JSONException -> L63
        if (r18 == null) goto L42;
        if (TextUtils.isEmpty(r18.optString("id")) == true) goto L42;
    L44:
        if (r4 == false) goto L46;
        r9.put("udid_list", r16);     // Catch: JSONException -> L63
    L46:
        String r19 = ((jta.e) r8.e).e();     // Catch: JSONException -> L63
        if (StringUtils.isEmpty(r19) == true) goto L49;
        r9.put("serial_number", r19);     // Catch: JSONException -> L63
    L49:
        if (r10 == false) goto L66;
        String[] r20 = ((jta.e) r8.e).f();     // Catch: JSONException -> L63
        if (r20 == null) goto L66;
        JSONArray r110 = new JSONArray();     // Catch: JSONException -> L63
        int r111 = r20.length;     // Catch: JSONException -> L63
    L54:
        if (r2 >= r111) goto L61;
        r110.put(new JSONObject().put("sim_serial_number", r20[r2]));     // Catch: JSONException -> L58
    L60:
        r2 = r2 + 1;     // Catch: JSONException -> L63
    L58:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L63
        goto L60
    L61:
        r9.put("sim_serial_number", r110);     // Catch: JSONException -> L63
    L42:
        r17 = r17 + 1;     // Catch: JSONException -> L63
    L43:
        r4 = false;
    L63:
        e = move-exception;
        e.printStackTrace();
    L66:
        if (g.g(r7) == true) goto L101;
        String r21 = pta.c.q(r7);     // Catch: Exception -> L71
        if (TextUtils.isEmpty(r21) == true) goto L101;
        r9.put("build_serial", r21);     // Catch: Exception -> L71
    L71:
        e = move-exception;
        e.printStackTrace();
        goto L101
    L20:
        if (g.g(r7) == true) goto L22;
        r9.put("mc", r5);     // Catch: JSONException -> L25
    L15:
        r13 = true;
        goto L18
    L11:
        if (StringUtils.isEmpty(r5) == false) goto L14;
        r5 = r6;
        goto L16
    L14:
        if (r6.equals(r5) == true) goto L16;
    L25:
        e = move-exception;
        e.printStackTrace();
    L101:
        eta.b r22 = c0.a;     // Catch: Exception -> L77
        String[] r23 = d0.a;     // Catch: Exception -> L77
        if (StringUtils.isEmpty(null) == true) goto L99;
        r9.put("aliyun_uuid", null);     // Catch: Exception -> L77
    L99:
        n r24 = n.c(r7);     // Catch: Throwable -> L86
        if (g.g != null) goto L82;
        g.g = new jta.j();     // Catch: Throwable -> L86
    L82:
        g.g.a.getClass();     // Catch: Throwable -> L86
        Map r25 = r24.a();     // Catch: Throwable -> L86
        Objects.toString(r25);     // Catch: Throwable -> L86
        if (r25 == null) goto L97;
        r9.put("oaid", new JSONObject(r25));     // Catch: Throwable -> L86
    L97:
        n r26 = n.c(r7);     // Catch: Throwable -> L94
        r26.getClass();     // Catch: Throwable -> L94
        if (g.f() == false) goto L91;
        k r27 = k.e(r26.a);     // Catch: Throwable -> L94
        r27.d();     // Catch: Throwable -> L94
        boolean r28 = r27.c;     // Catch: Throwable -> L94
    L92:
        r9.put("oaid_may_support", r28);     // Catch: Throwable -> L94
        return;
    L91:
        s r29 = s.b(r26.a);     // Catch: Throwable -> L94
        r29.a();     // Catch: Throwable -> L94
        r28 = r29.c;     // Catch: Throwable -> L94
    L94:
        th = move-exception;
        th.printStackTrace();
        return;
    L86:
        th = move-exception;
        th.printStackTrace();
    L77:
        e = move-exception;
        e.printStackTrace();
        goto L99
    }
}
