package com.bytedance.frameworks.baselib.network.http.util;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.apm6.util.constant.NetConst;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f1861a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile String f1862b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f1863c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f1864d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile List<String> f1865e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile List<String> f1866f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile boolean f1867g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile List<Pattern> f1868h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile List<String> f1869i;

    static {
        f1865e = new ArrayList();
        f1866f = new ArrayList();
        f1867g = false;
        f1868h = new ArrayList();
        f1869i = new CopyOnWriteArrayList();
    }

    private static String a(String r10, String r11) {
        if (f1864d == true) goto L5;
        return r10;
    L5:
        String r12 = null;
        if (r11.equals("https") == false) goto L9;
        r12 = "http";
    L12:
        if (com.bytedance.common.utility.g.b(r12) == false) goto L14;
        return r10;
    L14:
        return r10.replaceFirst(r11, r12);
    L9:
        if (r11.equals("wss") == false) goto L12;
        r12 = "ws";
        goto L12
    }

    private static int b(String r10, String r11, int r12) {
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L11;
        if (r13 != 0) goto L6;
        int r15 = 0;
    L7:
        r14 = r10.indexOf(r11, r15);
        if (r14 == (-1)) goto L9;
        r13 = r13 + 1;
        goto L3
    L9:
        return 0;
    L6:
        r15 = r14 + 1;
        goto L7
    L11:
        return r14;
    }

    public static String c(Context r10, String r11) {
        InputStream r12 = null;
        r12 = r10.getAssets().open(r11);     // Catch: Throwable -> L8
        byte[] r13 = new byte[r12.available()];     // Catch: Throwable -> L8
        r12.read(r13);     // Catch: Throwable -> L8
        String r14 = new String(r13, "UTF-8");     // Catch: Throwable -> L8
        r12.close();     // Catch: IOException -> L6
        return r14;
    L6:
        e = move-exception;
        e.printStackTrace();
        return r14;
    L8:
        if (r12 != null) goto L17;
    L13:
        return "";
    L17:
        r12.close();     // Catch: IOException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    private static boolean d(String r10, String r11) {
        if (f1865e.isEmpty() == true) goto L5;
    L11:
        Iterator<String> r12 = f1865e.iterator();
    L13:
        if (r12.hasNext() == false) goto L17;
        if (k.i(r10, r12.next()) == false) goto L13;
        return true;
    L17:
        Iterator<String> r13 = f1869i.iterator();
    L19:
        if (r13.hasNext() == false) goto L23;
        if (k.i(r10, r13.next()) == false) goto L19;
        return true;
    L23:
        Iterator<String> r14 = f1866f.iterator();
    L25:
        if (r14.hasNext() == false) goto L29;
        if (k.i(r11, r14.next()) == false) goto L25;
        return true;
    L29:
        String r15 = r10 + r11;
        Iterator<Pattern> r16 = f1868h.iterator();
    L31:
        if (r16.hasNext() == false) goto L36;
        if (r16.next().matcher(r15).matches() == false) goto L31;
        return true;
    L36:
        return false;
    L5:
        if (f1866f.isEmpty() == false) goto L11;
        if (f1868h.isEmpty() == false) goto L11;
        if (f1869i.isEmpty() == false) goto L11;
        return false;
    }

    public static boolean e(Context r10) {
        String r11 = r10.getFilesDir().getAbsolutePath();
        if (TextUtils.isEmpty(r11) == true) goto L14;
        if (new File(r11 + "/ttnet_boe.flag").exists() == false) goto L15;
        return true;
    L15:
        return false;
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    L14:
        return false;
    }

    public static boolean f(Context r10) {
        String r11 = c(r10, "ttnet_config.json");
        if (TextUtils.isEmpty(r11) == false) goto L11;
    L10:
        return false;
    L11:
        if (new JSONObject(r11).optBoolean("boe_proxy_enabled", false) == false) goto L10;
        return true;
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }

    public static boolean g() {
        return f1863c;
    }

    public static void h(JSONObject r10) {
        if (f1863c == false) goto L16;
        if (r10 == null) goto L20;
        JSONArray r11 = r10.optJSONArray("boe_bypass_host_list");
        if (r11 != null) goto L9;
        return;
    L9:
        int r12 = 0;
    L11:
        if (r12 >= r11.length()) goto L21;
        String r13 = r11.optString(r12);
        if (com.bytedance.common.utility.g.b(r13) == true) goto L15;
        f1869i.add(r13);
    L15:
        r12 = r12 + 1;
        goto L11
    L21:
        return;
    L20:
        return;
    }

    private static String i(String r10, String r11) {
        if (TextUtils.isEmpty(f1862b) == false) goto L5;
        return r10;
    L5:
        String[] r12 = r11.split("\\.");
        int r13 = r12.length;
        if (r13 >= 2) goto L8;
        return r10;
    L8:
        int r14 = r13 - 2;
        String r15 = r12[r14];
        if (r15.contains(f1862b) == false) goto L12;
        return r10;
    L12:
        return j(r10, b(r10, ".", r14), r15, r15 + f1862b);
    }

    private static String j(String r10, int r11, String r12, String r13) {
        return r10.substring(0, r11) + r10.substring(r11).replaceFirst(r12, r13);
    }

    public static String k(String r10) {
        if (f1863c == true) goto L5;
    L20:
        return null;
    L5:
        if (f1864d == false) goto L20;
        if (r10 == null) goto L20;
        if (r10.contains(f1861a) == false) goto L20;
        String r11 = Uri.parse(r10).getScheme();
        String r12 = "http";
        if ("http".equals(r11) == false) goto L15;
        String r13 = "https";
    L14:
        r10 = r10.replaceFirst(r12, r13);
    L19:
        return r10.replaceFirst(f1861a, "");
    L15:
        r12 = "ws";
        if ("ws".equals(r11) == false) goto L19;
        r13 = "wss";
        goto L14
    }

    public static void l(String r10) {
        f1862b = r10;
        if (TextUtils.isEmpty(r10) == true) goto L6;
        f1864d = false;
        return;
    }

    public static void m(String r10) {
        f1861a = r10;
        if (TextUtils.isEmpty(r10) == true) goto L6;
        f1864d = true;
        return;
    }

    public static String n(Context r10, String r11, List<n4.b> r12) {
        boolean r13 = false;
        if (f1867g == true) goto L15;
        if (f1863c == true) goto L15;
        if (f(r10) == false) goto L9;
    L12:
        boolean r14 = true;
    L13:
        f1863c = r14;
        f1867g = true;
        goto L15
    L9:
        if (e(r10) == true) goto L12;
        r14 = false;
    L15:
        if (f1863c == true) goto L17;
    L61:
        return r11;
    L17:
        if (TextUtils.isEmpty(f1861a) == true) goto L19;
    L21:
        Uri r15 = Uri.parse(r11);
        if (com.bytedance.common.utility.g.b(r15.getScheme()) == true) goto L61;
        if (com.bytedance.common.utility.g.b(r15.getHost()) == true) goto L61;
        if (com.bytedance.common.utility.g.b(r15.getPath()) == true) goto L61;
        if (d(r15.getHost(), r15.getPath()) == false) goto L31;
        return r11;
    L31:
        Iterator<n4.b> r16 = r12.iterator();
    L33:
        if (r16.hasNext() == false) goto L44;
        n4.b r17 = r16.next();
        if (com.bytedance.common.utility.g.b(r17.a()) == true) goto L33;
        if (com.bytedance.common.utility.g.b(r17.b()) == true) goto L33;
        if (r17.a().equals("bypass-boe") == false) goto L33;
        if (r17.b().equals(NetConst.ENCRYPT_VERISON_CODE) == false) goto L33;
        return r11;
    L44:
        String r18 = a(r11, r15.getScheme());
        if (d.a(r15.getHost()) == false) goto L47;
    L50:
        r13 = true;
    L51:
        if (r13 == false) goto L53;
        return r18;
    L53:
        boolean r19 = f1864d;
        String r20 = r15.getHost();
        if (r19 == false) goto L60;
        if (r20.contains(f1861a) == false) goto L58;
        return r18;
    L58:
        return r18.replaceFirst(r20, r20 + f1861a);
    L60:
        return i(r18, r20);
    L47:
        if (d.c(r15.getHost()) == true) goto L50;
        if (d.b(r15.getHost()) == false) goto L51;
    L19:
        if (TextUtils.isEmpty(f1862b) == false) goto L21;
        goto L21
    }
}
