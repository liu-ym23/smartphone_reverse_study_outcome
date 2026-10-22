package com.bytedance.bdinstall;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import d84.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class d {
    public static final String[] a = null;

    static {
        a = new String[]{"aid", "app_version", "tt_data", "device_id", "bd_did"};
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static HashMap<String, String> c(boolean r3) {
        HashMap<String, String> r0 = new HashMap();
        Pair r4 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new a(r3));     // Catch: Throwable -> L7
        if (r4 == null) goto L9;
        r0.put(r4.first, r4.second);     // Catch: Throwable -> L7
    L9:
        return r0;
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L9
    }

    public static void b(StringBuilder r2, String r3, String r4) {
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

    public static String d(String r8, boolean r9, b0 r10) {
        if (TextUtils.isEmpty(r8) == true) goto L20;
        Uri r11 = UriProtector.parse(r8);
        String r0 = r11.getQuery();
        ArrayList r1 = new ArrayList();
        String[] r2 = a;
        int r3 = r2.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L10;
        String r5 = r2[r4];
        String r6 = UriProtector.getQueryParameter(r11, r5);
        if (TextUtils.isEmpty(r6) == true) goto L9;
        r1.add(new Pair(r5, r6));
    L9:
        r4 = r4 + 1;
        goto L5
    L10:
        Uri.Builder r12 = r11.buildUpon();
        r12.clearQuery();
        Iterator r7 = r1.iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        Pair r13 = (Pair) r7.next();
        r12.appendQueryParameter((String) r13.first, (String) r13.second);
        goto L12
    L14:
        r12.appendQueryParameter("tt_info", new String(Base64.encode(f(r0, r9, r10), 8)));
        return r12.build().toString();
    L20:
        return r8;
    }

    public static byte[] f(String r4, boolean r5, b0 r6) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r2 = null;
        if (r5 == false) goto L11;
        GZIPOutputStream r3 = new GZIPOutputStream(r0);     // Catch: Throwable -> L9
        r3.write(r4.getBytes("UTF-8"));     // Catch: Throwable -> L7
        r2 = r3;
    L12:
        if (r2 == null) goto L21;
        r2.close();     // Catch: IOException -> L19
    L33:
    L21:
        byte[] r7 = r0.toByteArray();
        if (r5 == false) goto L43;
        if (r6 != null) goto L25;
        return r7;
    L25:
        return r6.encrypt(r7, r7.length);
    L43:
        return r7;
    L7:
        th = th;
        r2 = r3;
    L36:
        t.e(th);     // Catch: Throwable -> L26
        if (r2 == null) goto L21;
        r2.close();     // Catch: IOException -> L19
    L26:
        th = move-exception;
        if (r2 != null) goto L40;
    L32:
        throw th;
    L40:
        r2.close();     // Catch: IOException -> L30
    L30:
        e = move-exception;
        t.e(e);
        goto L32
    L11:
        r0.write(r4.getBytes("UTF-8"));     // Catch: Throwable -> L9
    L19:
        e = move-exception;
        t.e(e);
    L9:
        th = th;
        goto L36
    }

    public static a a(g0 r3, String r4, boolean r5, b0 r6, boolean r7) {
        StringBuilder r1 = new StringBuilder(r4);
        a r2 = null;
        a r8 = new a(r4, 200, null, r3.get(d(r1.toString(), r5, r6), c(r7)));     // Catch: Exception -> L5
        t.a("network client is ready. response is " + r8);     // Catch: Exception -> L5
        return r8;
    L5:
        e = move-exception;
        if ((e instanceof RangersHttpException) == false) goto L9;
        RangersHttpException r9 = e;
        r2 = new a("", r9.getResponseCode(), null, r9.getMessage());
    L9:
        t.c("active http error = ", e);
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static a e(g0 r3, String r4, JSONObject r5, boolean r6, b0 r7, boolean r8, List r9) {
        HashMap<String, String> r10 = c(r8);
        if (r6 == false) goto L5;
        r10.put("Content-Type", "application/octet-stream;tt-data=a");
    L6:
        if (r9 != null) goto L8;
    L13:
        a r11 = null;
        byte[] r12 = f(r5.toString(), r6, r7);     // Catch: Exception -> L20
        if (r12 == null) goto L18;
        if (r6 == false) goto L18;
        r4 = r4 + "&tt_data=a";     // Catch: Exception -> L20
    L18:
        a r13 = new a(r4, 200, null, r3.post(r4, r12, r10));     // Catch: Exception -> L20
        t.a("network client is ready. response is " + r13);     // Catch: Exception -> L20
        return r13;
    L20:
        e = move-exception;
        if ((e instanceof RangersHttpException) == false) goto L24;
        RangersHttpException r14 = e;
        r11 = new a("", r14.getResponseCode(), null, r14.getMessage());
    L24:
        t.c("doRegister# http error= " + e.toString(), e);
        return r11;
    L8:
        if (r9.size() <= 0) goto L13;
        int r0 = 0;
    L11:
        if (r0 >= r9.size()) goto L13;
        Pair r1 = (Pair) ListProtector.get(r9, r0);
        r10.put(r1.first, r1.second);
        r0 = r0 + 1;
        goto L11
    L5:
        r10.put("Content-Type", "application/json; charset=utf-8");
        goto L6
    }
}
