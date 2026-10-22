package com.bytedance.frameworks.baselib.network.http.util;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f2538a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile String f2539b = null;
    private static volatile boolean c = false;
    private static volatile boolean d = false;
    private static volatile List<String> e;
    private static volatile List<String> f;
    private static volatile boolean g;
    private static volatile List<Pattern> h;
    private static volatile List<String> i;

    static {
        e = new ArrayList();
        f = new ArrayList();
        g = false;
        h = new ArrayList();
        i = new CopyOnWriteArrayList();
    }

    private static int a(String r4, String r5, int r6) {
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r6) goto L11;
        if (r1 != 0) goto L6;
        int r3 = 0;
    L7:
        r2 = r4.indexOf(r5, r3);
        if (r2 == (-1)) goto L9;
        r1 = r1 + 1;
        goto L3
    L9:
        return 0;
    L6:
        r3 = r2 + 1;
        goto L7
    L11:
        return r2;
    }

    public static String a(Context r2, String r3) {
        InputStream r0 = null;
        r0 = ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getAssets().open(r3);     // Catch: Throwable -> L9
        byte[] r4 = new byte[r0.available()];     // Catch: Throwable -> L9
        r0.read(r4);     // Catch: Throwable -> L9
        String r5 = new String(r4, RpcUtils.CHARSET_UTF8);     // Catch: Throwable -> L9
        if (r0 == null) goto L22;
        r0.close();     // Catch: IOException -> L7
        return r5;
    L7:
        e = move-exception;
        e.printStackTrace();
        return r5;
    L22:
        return r5;
    L9:
        if (r0 != null) goto L18;
    L14:
        return "";
    L18:
        r0.close();     // Catch: IOException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static String a(Context r6, String r7, List<Header> r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (g == true) goto L15;
        if (c == true) goto L15;
        if (a(r9) == false) goto L9;
    L12:
        boolean r11 = true;
    L13:
        c = r11;
        g = true;
        goto L15
    L9:
        if (b(r9) == true) goto L12;
        r11 = false;
    L15:
        if (c == true) goto L17;
    L61:
        return r7;
    L17:
        if (TextUtils.isEmpty(f2538a) == true) goto L19;
    L21:
        Uri r12 = Uri.parse(r7);
        if (com.bytedance.common.utility.h.a(r12.getScheme()) == true) goto L61;
        if (com.bytedance.common.utility.h.a(r12.getHost()) == true) goto L61;
        if (com.bytedance.common.utility.h.a(r12.getPath()) == true) goto L61;
        if (c(r12.getHost(), r12.getPath()) == false) goto L31;
        return r7;
    L31:
        Iterator r13 = r10.iterator();
    L33:
        if (r13.hasNext() == false) goto L44;
        Header r0 = (Header) ZeusTransformUtils.preCheckCast(r13.next(), Header.class, "com.obric.memorydata.plugin");
        if (com.bytedance.common.utility.h.a(r0.getName()) == true) goto L33;
        if (com.bytedance.common.utility.h.a(r0.getValue()) == true) goto L33;
        if (r0.getName().equals("bypass-boe") == false) goto L33;
        if (r0.getValue().equals("1") == false) goto L33;
        return r7;
    L44:
        String r14 = b(r7, r12.getScheme());
        if (d.a(r12.getHost()) == false) goto L47;
    L50:
        r2 = true;
    L51:
        if (r2 == false) goto L53;
        return r14;
    L53:
        boolean r15 = d;
        String r16 = r12.getHost();
        if (r15 == false) goto L60;
        if (r16.contains(f2538a) == false) goto L58;
        return r14;
    L58:
        return r14.replaceFirst(r16, r16 + f2538a);
    L60:
        return a(r14, r16);
    L47:
        if (d.b(r12.getHost()) == true) goto L50;
        if (d.c(r12.getHost()) == false) goto L51;
    L19:
        if (TextUtils.isEmpty(f2539b) == false) goto L21;
        goto L21
    }

    public static String a(String r3) {
        if (c == true) goto L5;
    L20:
        return null;
    L5:
        if (d == false) goto L20;
        if (r3 == null) goto L20;
        if (r3.contains(f2538a) == false) goto L20;
        String r0 = Uri.parse(r3).getScheme();
        String r1 = "http";
        if ("http".equals(r0) == false) goto L15;
        String r2 = LocationInfoConst.HTTPS;
    L14:
        r3 = r3.replaceFirst(r1, r2);
    L19:
        return r3.replaceFirst(f2538a, "");
    L15:
        r1 = "ws";
        if ("ws".equals(r0) == false) goto L19;
        r2 = "wss";
        goto L14
    }

    private static String a(String r1, int r2, String r3, String r4) {
        return r1.substring(0, r2) + r1.substring(r2).replaceFirst(r3, r4);
    }

    private static String a(String r3, String r4) {
        if (TextUtils.isEmpty(f2539b) == false) goto L5;
        return r3;
    L5:
        String[] r5 = r4.split("\\.");
        int r0 = r5.length;
        if (r0 >= 2) goto L8;
        return r3;
    L8:
        int r1 = r0 - 2;
        String r6 = r5[r1];
        if (r6.contains(f2539b) == false) goto L12;
        return r3;
    L12:
        return a(r3, a(r3, ".", r1), r6, r6 + f2539b);
    }

    public static void a(JSONObject r3) {
        if (c == false) goto L16;
        if (r3 == null) goto L20;
        JSONArray r4 = r3.optJSONArray("boe_bypass_host_list");
        if (r4 != null) goto L9;
        return;
    L9:
        int r0 = 0;
    L11:
        if (r0 >= r4.length()) goto L21;
        String r1 = r4.optString(r0);
        if (com.bytedance.common.utility.h.a(r1) == true) goto L15;
        i.add(r1);
    L15:
        r0 = r0 + 1;
        goto L11
    L21:
        return;
    L20:
        return;
    }

    public static boolean a() {
        return c;
    }

    public static boolean a(Context r2) {
        String r3 = a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), "ttnet_config.json");
        if (TextUtils.isEmpty(r3) == false) goto L11;
    L10:
        return false;
    L11:
        if (new JSONObject(r3).optBoolean("boe_proxy_enabled", false) == false) goto L10;
        return true;
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }

    private static String b(String r2, String r3) {
        if (d == true) goto L5;
        return r2;
    L5:
        String r0 = null;
        if (r3.equals(LocationInfoConst.HTTPS) == false) goto L9;
        r0 = "http";
    L12:
        if (com.bytedance.common.utility.h.a(r0) == false) goto L14;
        return r2;
    L14:
        return r2.replaceFirst(r3, r0);
    L9:
        if (r3.equals("wss") == false) goto L12;
        r0 = "ws";
        goto L12
    }

    public static void b(String r0) {
        f2538a = r0;
        if (TextUtils.isEmpty(r0) == true) goto L6;
        d = true;
        return;
    }

    public static boolean b(Context r2) {
        String r3 = ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getFilesDir().getAbsolutePath();
        if (TextUtils.isEmpty(r3) == true) goto L14;
        if (new File(r3 + "/ttnet_boe.flag").exists() == false) goto L15;
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

    public static void c(String r0) {
        f2539b = r0;
        if (TextUtils.isEmpty(r0) == true) goto L6;
        d = false;
        return;
    }

    private static boolean c(String r6, String r7) {
        if (e.isEmpty() == true) goto L5;
    L11:
        Iterator<String> r0 = e.iterator();
    L13:
        if (r0.hasNext() == false) goto L17;
        if (k.a(r6, (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L13;
        return true;
    L17:
        Iterator<String> r1 = i.iterator();
    L19:
        if (r1.hasNext() == false) goto L23;
        if (k.a(r6, (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L19;
        return true;
    L23:
        Iterator<String> r2 = f.iterator();
    L25:
        if (r2.hasNext() == false) goto L29;
        if (k.a(r7, (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L25;
        return true;
    L29:
        String r8 = r6 + r7;
        Iterator<Pattern> r9 = h.iterator();
    L31:
        if (r9.hasNext() == false) goto L36;
        if (((Pattern) ZeusTransformUtils.preCheckCast(r9.next(), Pattern.class, "com.obric.memorydata.plugin")).matcher(r8).matches() == false) goto L31;
        return true;
    L36:
        return false;
    L5:
        if (f.isEmpty() == false) goto L11;
        if (h.isEmpty() == false) goto L11;
        if (i.isEmpty() == false) goto L11;
        return false;
    }
}
