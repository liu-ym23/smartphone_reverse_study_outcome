package com.ss.android.deviceregister.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.loader.SstLoader;
import com.bytedance.bdinstall.oaid.Oaid;
import com.ss.android.common.applog.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class f {
    static String a(Bundle r1) {
        return r1.getString("UMENG_CHANNEL");
    }

    public static void a(Context r2) {
        s.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).a();
    }

    public static void a(Context r2, com.ss.android.common.a r3, Map<String, String> r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        com.ss.android.common.a r7 = (com.ss.android.common.a) ZeusTransformUtils.wrapperContextForParams(r3, com.ss.android.common.a.class, "com.obric.memorydata.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if (r5 == true) goto L9;
        if (com.ss.android.deviceregister.f.o().b() == false) goto L23;
        s.a(r6).a();
        return;
    L23:
        return;
    L9:
        if (com.ss.android.deviceregister.f.f() == true) goto L13;
        String r9 = r7.f();
        if (y.a(r9) == true) goto L13;
        r8.put(Api.KEY_UUID, r9);
    L13:
        if (r5 == false) goto L24;
        String r10 = m.a(r6).a();     // Catch: Throwable -> L18
        if (r10 == null) goto L25;
        r8.put(Oaid.KEY_OAID_ID, r10);     // Catch: Throwable -> L18
        return;
    L25:
        return;
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    static void a(Context r7, com.ss.android.deviceregister.b.d r8, JSONObject r9, boolean r10, boolean r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        if (r11 == true) goto L84;
        SharedPreferences r13 = b.a(r12);
        if (com.ss.android.deviceregister.f.r() == null) goto L7;
        String r2 = com.ss.android.deviceregister.f.r().a();
    L8:
        int r3 = 0;
        String r4 = r13.getString("mac_addr", null);     // Catch: JSONException -> L29
        boolean r6 = true;
        if (com.bytedance.common.utility.h.a(r4) == false) goto L15;
        if (com.bytedance.common.utility.h.a(r2) == false) goto L22;
    L20:
        r6 = false;
    L22:
        if (com.bytedance.common.utility.h.a(r2) == false) goto L24;
    L26:
        if (r6 == false) goto L31;
        SharedPreferences.Editor r14 = r13.edit();     // Catch: JSONException -> L29
        r14.putString("mac_addr", r2);     // Catch: JSONException -> L29
        r14.commit();     // Catch: JSONException -> L29
    L31:
        if (r8 == null) goto L58;
        String r15 = r8.a();     // Catch: JSONException -> L55
        if (com.bytedance.common.utility.h.a(r15) == true) goto L35;
        r9.put(SstLoader.KEY_UDID, r15);     // Catch: JSONException -> L55
    L35:
        JSONArray r16 = r8.b();     // Catch: JSONException -> L55
        if (com.ss.android.deviceregister.d.c.a(r16) == false) goto L38;
        r9.put(SstLoader.KEY_UDID_LIST, r16);     // Catch: JSONException -> L55
    L38:
        String r17 = r8.d();     // Catch: JSONException -> L55
        if (com.bytedance.common.utility.h.a(r17) == true) goto L41;
        r9.put("serial_number", r17);     // Catch: JSONException -> L55
    L41:
        if (r10 == false) goto L58;
        String[] r18 = r8.c();     // Catch: JSONException -> L55
        if (r18 == null) goto L58;
        JSONArray r19 = new JSONArray();     // Catch: JSONException -> L55
        int r110 = r18.length;     // Catch: JSONException -> L55
    L46:
        if (r3 >= r110) goto L53;
        r19.put(new JSONObject().put("sim_serial_number", r18[r3]));     // Catch: JSONException -> L50
    L52:
        r3 = r3 + 1;     // Catch: JSONException -> L55
    L50:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L55
        goto L52
    L53:
        r9.put("sim_serial_number", r19);     // Catch: JSONException -> L55
    L55:
        e = move-exception;
        e.printStackTrace();
    L58:
        if (com.ss.android.deviceregister.f.b(r12) == true) goto L84;
        String r20 = com.ss.android.deviceregister.d.c.a(r12);     // Catch: Exception -> L63
        if (TextUtils.isEmpty(r20) == true) goto L84;
        r9.put("build_serial", r20);     // Catch: Exception -> L63
    L63:
        e = move-exception;
        e.printStackTrace();
        goto L84
    L24:
        if (com.ss.android.deviceregister.f.b(r12) == true) goto L26;
        r9.put(SstLoader.KEY_MC, r2);     // Catch: JSONException -> L29
        goto L26
    L15:
        if (com.bytedance.common.utility.h.a(r2) == false) goto L18;
        r6 = false;
        r2 = r4;
        goto L22
    L18:
        if (r4.equals(r2) == true) goto L20;
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L31
    L7:
        r2 = com.ss.android.deviceregister.d.c.i(r12);
    L84:
    L69:
        e = move-exception;
        e.printStackTrace();
    L82:
        Map<String, String> r21 = m.a(r12).a(com.ss.android.deviceregister.f.o().a());     // Catch: Throwable -> L75
        Log.d("ARegistrationHeader", "getOaid: returned=" + r21);     // Catch: Throwable -> L75
        if (r21 == null) goto L90;
        r9.put(Oaid.KEY_OAID_ID, new JSONObject(r21));     // Catch: Throwable -> L75
    L90:
        boolean r22 = m.a(r12).b();     // Catch: Throwable -> L79
        Log.d("ARegistrationHeader", "maySupport: returned=" + r22);     // Catch: Throwable -> L79
        r9.put(SstLoader.KEY_OAID_SUPPORT, r22);     // Catch: Throwable -> L79
        return;
    L79:
        th = move-exception;
        th.printStackTrace();
        return;
    L75:
        th = move-exception;
        th.printStackTrace();
        goto L90
    L66:
        if (com.bytedance.common.utility.h.a(y.a()) == true) goto L82;
        r9.put(Api.KEY_ALIYUN_UUID, y.a());     // Catch: Exception -> L69
        goto L82
    }

    public static void a(Context r5, StringBuilder r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (com.ss.android.deviceregister.f.f() == false) goto L5;
        return;
    L5:
        String[] r0 = com.ss.android.deviceregister.d.c.b(r7);
        if (r0 != null) goto L8;
    L14:
        a(r6, "build_serial", com.ss.android.deviceregister.d.c.a(r7), true);
        return;
    L8:
        if (r0.length <= 0) goto L14;
        String r2 = r0[0];
        int r3 = 1;
    L11:
        if (r3 >= r0.length) goto L13;
        r2 = r2 + "," + r0[r3];
        r3 = r3 + 1;
        goto L11
    L13:
        a(r6, "sim_serial_number", r2, true);
        goto L14
    }

    private static void a(StringBuilder r2, String r3, String r4, boolean r5) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r4) == false) goto L9;
        return;
    L9:
        if (r2.toString().indexOf(63) >= 0) goto L11;
        String r0 = "?";
    L12:
        r2.append(r0);
        StringBuilder r6 = r2.append(r3).append("=");
        if (r5 == false) goto L15;
        r4 = Uri.encode(r4);
    L15:
        r6.append(r4);
        return;
    L11:
        r0 = "&";
        goto L12
    }

    public static void a(JSONObject r1) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (u.f() == true) goto L13;
        r1.remove("sim_serial_number");     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
