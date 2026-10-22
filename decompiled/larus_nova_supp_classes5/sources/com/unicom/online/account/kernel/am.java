package com.unicom.online.account.kernel;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class am {
    public static String a(Context r3, String r4) {
        return r3.getSharedPreferences("cu_auth", 0).getString(r4, "");
    L5:
        e = move-exception;
        aj.a(e);
        return "";
    }

    public static void a(Context r8, String r9, List<d> r10) {
        if (r10.size() != 0) goto L14;
        return;
    L14:
        JSONArray r0 = new JSONArray();     // Catch: Exception -> L11
        int r2 = 0;
    L7:
        if (r2 >= r10.size()) goto L9;
        d r3 = (d) ListProtector.get(r10, r2);     // Catch: Exception -> L11
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L11
        r4.put("domain", r3.a);     // Catch: Exception -> L11
        r4.put("ip", r3.b);     // Catch: Exception -> L11
        r4.put("expire", r3.c);     // Catch: Exception -> L11
        r0.put(r4);     // Catch: Exception -> L11
        r2 = r2 + 1;     // Catch: Exception -> L11
        goto L7
    L9:
        SharedPreferences.Editor r11 = r8.getSharedPreferences("cu_auth", 0).edit();     // Catch: Exception -> L11
        r11.putString(r9, r0.toString());     // Catch: Exception -> L11
        r11.apply();     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    public static List<d> b(Context r5, String r6) {
        int r1 = 0;
        String r7 = r5.getSharedPreferences("cu_auth", 0).getString(r6, null);     // Catch: Exception -> L8
        ArrayList r8 = new ArrayList();     // Catch: Exception -> L8
        JSONArray r0 = new JSONArray(r7);     // Catch: Exception -> L8
    L4:
        if (r1 >= r0.length()) goto L7;
        JSONObject r9 = JSONArrayProtectorUtils.getJSONObject(r0, r1);     // Catch: Exception -> L8
        d r2 = new d();     // Catch: Exception -> L8
        r2.a = r9.optString("domain");     // Catch: Exception -> L8
        r2.b = r9.optString("ip");     // Catch: Exception -> L8
        r2.c = r9.optLong("expire");     // Catch: Exception -> L8
        r8.add(r2);     // Catch: Exception -> L8
        r1 = r1 + 1;
        goto L4
    L7:
        return r8;
    L8:
        e = move-exception;
        e.printStackTrace();
        return new ArrayList();
    }
}
