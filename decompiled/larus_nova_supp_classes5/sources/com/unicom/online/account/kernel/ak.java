package com.unicom.online.account.kernel;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ak {
    public static String a = "123.125.99.31";
    public static final String b = null;
    public static final String c = null;
    public static final String d = null;
    public static final String e = null;
    public static final String f = null;
    public static final String g = null;
    public static final String h = null;
    public static final String i = null;
    public static final String j = null;
    public static final String k = null;
    public static final String l = null;
    public static final String m = null;
    public static final String n = null;
    public static List<d> o;
    public static Set<String> p;
    public static int q;
    public static String r;
    private static String s;
    private static String t;
    private static String u;
    private static int v;
    private static int w;
    private static String x;
    private static String y;
    private static String z;

    static {
        b = new String(o.b("MTAwMTAuY29t"));
        c = new String(o.b("aWQ2Lm1l"));
        d = new String(o.b("Y21wYXNzcG9ydC5jb20="));
        e = new String(o.b("bXN2Ni53b3Ntcy5jbg=="));
        f = new String(o.b("YWxpLndvc21zLmNu"));
        g = new String(o.b("bS56enguY25rbG9nLmNvbQ=="));
        h = new String(o.b("dGVzdC53b3Ntcy5jbg=="));
        i = new String(o.b("YXV0aC53b3Ntcy5jbg=="));
        j = new String(o.b("c2RrbG9nLndvc21zLmNu"));
        k = new String(o.b("L2Ryby92MS9yZXBvcnQ="));
        l = new String(o.b("L3VuaWNvbUF1dGgvYW5kcm9pZC92My4wL3Fj"));
        m = new String(o.b("L3VuaWNvbUF1dGgvYW5kcm9pZC92My4wL3Fj"));
        n = new String(o.b("L3VuaWNvbVVhaWQvYW5kcm9pZC92MS4wL3Fj"));
        p = new HashSet();
        r = "0";
        s = "";
        t = "";
        u = "";
        v = 5;
        w = -1;
        x = "";
        y = "";
        z = "";
    }

    public static int a() {
        int r0 = q;
        if (r0 != 0) goto L5;
        return 1;
    L5:
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L9;
        return -1;
    L9:
        return 0;
    L11:
        return 2;
    }

    public static void a(int r0) {
        q = r0;
    }

    public static void a(Context r2, String r3) {
        d r0 = new d();
        r0.a = r3;
        if (o.isEmpty() == false) goto L5;
        o.add(r0);
    L8:
        am.a(r2, "DNSCache", new ArrayList(o));
        return;
    L5:
        ListProtector.add(o, 1, r0);
        if (o.size() <= 4) goto L8;
        ListProtector.remove(o, 4);
        goto L8
    }

    public static boolean a(String r1) {
        if (r1.startsWith(i) == false) goto L5;
        return true;
    L5:
        if (r1.startsWith(e) == false) goto L7;
        return true;
    L7:
        if (r1.startsWith(g) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public static boolean a(String r4, String r5) {
        aj.a("\nhostname : " + r4 + "\nsubjectName : " + r5);
        if (ac.b() == false) goto L16;
        if (r4 == null) goto L16;
    L13:
        e = move-exception;
        aj.a(e);
        goto L16
    L6:
        if (r4.length() <= 0) goto L16;
        InetAddress r0 = InetAddress.getByName(r4.replaceFirst("^\\[", "").replaceAll("\\]$", ""));     // Catch: UnknownHostException -> L13
        Iterator<String> r1 = p.iterator();     // Catch: UnknownHostException -> L13
    L9:
        if (r1.hasNext() == false) goto L16;
        if (r0.equals(InetAddress.getByName(r1.next())) == false) goto L9;
        return true;
    L16:
        if (r4.endsWith(".10010.com") == true) goto L18;
    L19:
        String r2 = i;
        if (r4.equals(r2) == true) goto L22;
    L23:
        String r3 = e;
        if (r4.equals(r3) == true) goto L26;
    L27:
        String r6 = f;
        if (r4.equals(r6) == true) goto L30;
    L31:
        String r7 = h;
        if (r4.equals(r7) == true) goto L34;
    L35:
        String r8 = g;
        if (r4.equals(r8) == false) goto L40;
        if (b(r5, "CN=" + r8) == false) goto L40;
    L47:
        return true;
    L40:
        if (r4.equals("id6.me") == false) goto L44;
        if (b(r5, "CN=*.id6.me") == true) goto L47;
    L44:
        if (r4.equals("cert.cmpassport.com") == true) goto L46;
        return false;
    L46:
        if (b(r5, "CN=*.cmpassport.com") == true) goto L47;
        return false;
    L34:
        if (b(r5, "CN=" + r7) == true) goto L47;
    L30:
        if (b(r5, "CN=" + r6) == true) goto L47;
    L26:
        if (b(r5, "CN=" + r3) == true) goto L47;
    L22:
        if (b(r5, "CN=" + r2) == true) goto L47;
    L18:
        if (b(r5, "CN=10010.com") == true) goto L47;
        goto L19
    }

    public static String b() {
        return r;
    }

    public static String b(int r3) {
        if (ac.a(r3) == false) goto L8;
        StringBuilder r4 = new StringBuilder("https://");
        r4.append(i.d());
        String r0 = l;
    L5:
        r4.append(r0);
        r4.append("?");
        return r4.toString();
    L8:
        if (ac.b(r3) == false) goto L10;
        r4 = new StringBuilder("https://");
        r4.append(i.d());
        r0 = n;
        goto L5
    L10:
        r4 = new StringBuilder("https://");
        r4.append(i.d());
        r0 = m;
        goto L5
    }

    public static void b(Context r2, String r3) {
        d r4 = i(r3);
        if (r4 == null) goto L6;
        r4.b = "";
        r4.c = 0;
        am.a(r2, "DNSCache", new ArrayList(o));
        return;
    }

    public static void b(String r0) {
        r = r0;
    }

    private static boolean b(String r1, String r2) {
        if (r1.startsWith(r2) == false) goto L5;
        return true;
    L5:
        if (r1.endsWith(r2) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static String c() {
        return s;
    }

    public static void c(int r0) {
        v = r0;
    }

    public static void c(String r0) {
        s = r0;
    }

    public static String d() {
        if (t.length() == 32) goto L6;
        e();
    L6:
        return t;
    }

    public static void d(int r0) {
        w = r0;
    }

    public static void d(String r2) {
        aj.a("APN:".concat(String.valueOf(r2)));
        u = r2;
    }

    public static String e() {
        t = n.a();
        return d();
    }

    public static String e(String r1) {
        if ("cmnet".equals(r1) == false) goto L5;
    L24:
        return "1";
    L5:
        if ("cmwap".equals(r1) == true) goto L24;
        if ("3gwap".equals(r1) == false) goto L10;
    L23:
        return "3";
    L10:
        if ("uniwap".equals(r1) == true) goto L23;
        if ("3gnet".equals(r1) == true) goto L23;
        if ("uninet".equals(r1) == true) goto L23;
        if ("ctnet".equals(r1) == false) goto L19;
    L22:
        return "2";
    L19:
        if ("ctwap".equals(r1) == true) goto L22;
        return "0";
    }

    public static String f() {
        return u;
    }

    public static void f(String r0) {
        x = r0;
    }

    public static int g() {
        return v;
    }

    public static void g(String r0) {
        y = r0;
    }

    public static int h() {
        return w;
    }

    public static void h(String r0) {
        z = r0;
    }

    public static d i(String r3) {
        int r0 = 0;
    L4:
        if (r0 >= o.size()) goto L9;
        d r1 = (d) ListProtector.get(o, r0);
        if (r1.a.equalsIgnoreCase(r3) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r1;
    L9:
        return null;
    }
}
