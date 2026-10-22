package com.bytedance.frameworks.baselib.network.http.impl;

import android.text.TextUtils;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: loaded from: classes.dex */
public class f implements Cloneable {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Set<String> f1644r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static Pattern f1645s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static Pattern f1646t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final ThreadLocal<DateFormat> f1647u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String[] f1648v = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f1649c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f1650g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1651h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f1652i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f1653j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f1654k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f1655l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f1656m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f1657n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f1658o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f1659p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f1660q;

    class a extends ThreadLocal<DateFormat> {
        a() {
        }

        protected DateFormat a() {
            SimpleDateFormat r10 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
            r10.setTimeZone(TimeZone.getTimeZone("UTC"));
            return r10;
        }

        @Override // java.lang.ThreadLocal
        protected /* bridge */ /* synthetic */ DateFormat initialValue() {
            return a();
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f1661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f1662b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1663c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f1664d;

        b(String r10) {
            this.f1663c = 0;
            this.f1664d = false;
            this.f1661a = r10;
            this.f1662b = r10.toLowerCase(Locale.US);
        }

        private int a(String r10) {
            int r11 = this.f1663c;
        L4:
            if (r11 >= this.f1661a.length()) goto L10;
            if (r10.indexOf(this.f1661a.charAt(r11)) != (-1)) goto L7;
            r11 = r11 + 1;
            goto L4
        L7:
            return r11;
        L10:
            return this.f1661a.length();
        }

        private String c(boolean r10) {
            g();
            int r11 = a(",;= \t");
            if (r10 == false) goto L5;
            String r12 = this.f1662b;
        L6:
            int r13 = this.f1663c;
            if (r13 >= r11) goto L9;
            String r14 = r12.substring(r13, r11);
        L10:
            this.f1663c = r11;
            return r14;
        L9:
            r14 = null;
            goto L10
        L5:
            r12 = this.f1661a;
            goto L6
        }

        private String d(String r10) {
            g();
            int r11 = a(r10);
            String r12 = this.f1661a.substring(this.f1663c, r11);
            this.f1663c = r11;
            return r12;
        }

        private boolean e() {
            g();
            if (this.f1663c < this.f1661a.length()) goto L5;
            return false;
        L5:
            if (this.f1661a.charAt(this.f1663c) != '=') goto L10;
            this.f1663c++;
            return true;
        L10:
            return false;
        }

        private void f(f r10, String r11, String r12) {
            if (r11.equals("comment") == false) goto L8;
            if (f.d(r10) != null) goto L8;
            f.f(r10, r12);
            return;
        L8:
            if (r11.equals("commenturl") == false) goto L13;
            if (f.g(r10) != null) goto L13;
            f.h(r10, r12);
            return;
        L13:
            if (r11.equals("discard") == false) goto L16;
            f.i(r10, true);
            return;
        L16:
            if (r11.equals("domain") == false) goto L26;
            if (f.j(r10) != null) goto L26;
            if (TextUtils.isEmpty(r12) == false) goto L22;
        L24:
            f.k(r10, r12);
            return;
        L22:
            if (r12.charAt(0) != '.') goto L24;
            r12 = r12.substring(1);
        L26:
            if (r11.equals("expires") == false) goto L34;
            if (f.l(r10) != (-1)) goto L70;
            Date r13 = f.N(r12);
            if (r13 == null) goto L32;
            f.n(r10, r13);
            return;
        L32:
            f.m(r10, 0);
            return;
        L70:
            return;
        L34:
            if (r11.equals("max-age") == false) goto L40;
            f.m(r10, Long.parseLong(r12));     // Catch: NumberFormatException -> L37
            return;
        L38:
            throw new IllegalArgumentException("Invalid max-age: " + r12);
        L40:
            if (r11.equals("path") == false) goto L45;
            if (f.o(r10) != null) goto L45;
            f.p(r10, r12);
            return;
        L45:
            if (r11.equals("port") == false) goto L53;
            if (f.q(r10) != null) goto L53;
            if (r12 != null) goto L51;
            r12 = "";
        L51:
            f.r(r10, r12);
            return;
        L53:
            if (r11.equals("secure") == false) goto L56;
            f.s(r10, true);
            return;
        L56:
            if (r11.equals("httponly") == false) goto L59;
            f.e(r10, true);
            return;
        L59:
            if (r11.equals("version") == true) goto L61;
            return;
        L61:
            if (this.f1664d == true) goto L78;
            f.b(r10, Integer.parseInt(r12));
            return;
        }

        private void g() {
        L3:
            if (this.f1663c >= this.f1661a.length()) goto L8;
            if (" \t".indexOf(this.f1661a.charAt(this.f1663c)) == (-1)) goto L11;
            this.f1663c++;
            goto L3
        L11:
            return;
        }

        public List<f> b() {
            ArrayList r10 = new ArrayList(2);
            if (this.f1662b.startsWith("set-cookie2:") == false) goto L6;
            this.f1663c += 12;
            this.f1664d = true;
            int r11 = 0;
        L9:
            String r12 = c(false);
            if (r12 == null) goto L12;
            if (e() == false) goto L48;
            if (r11 == 0) goto L21;
            String r13 = ";";
        L22:
            f r14 = new f(r12, d(r13));
            f.b(r14, r11 ^ 1);
            r10.add(r14);
        L23:
            g();
            if (this.f1663c == this.f1661a.length()) goto L9;
            if (this.f1661a.charAt(this.f1663c) == ',') goto L28;
            if (this.f1661a.charAt(this.f1663c) != ';') goto L32;
            this.f1663c++;
        L32:
            String r15 = c(true);
            if (r15 == null) goto L23;
            if (r11 == 0) goto L37;
        L42:
            String r16 = ";";
        L43:
            String r17 = null;
            if (e() == false) goto L46;
            r17 = d(r16);
        L46:
            f(r14, r15, r17);
            goto L23
        L37:
            if ("expires".equals(r15) == true) goto L42;
            if ("port".equals(r15) == true) goto L42;
            r16 = ";,";
            goto L43
        L28:
            this.f1663c++;
            goto L9
        L21:
            r13 = ",;";
            goto L22
        L48:
            throw new IllegalArgumentException("Expected '=' after " + r12 + " in " + this.f1661a);
        L12:
            if (r10.isEmpty() == true) goto L15;
            return r10;
        L15:
            throw new IllegalArgumentException("No cookies in " + this.f1661a);
        L6:
            if (this.f1662b.startsWith("set-cookie:") == false) goto L8;
            this.f1663c += 11;
        L8:
            r11 = 1;
            goto L9
        }
    }

    static {
        HashSet r10 = new HashSet();
        f1644r = r10;
        r10.add("comment");
        r10.add("commenturl");
        r10.add("discard");
        r10.add("domain");
        r10.add("expires");
        r10.add("httponly");
        r10.add("max-age");
        r10.add("path");
        r10.add("port");
        r10.add("secure");
        r10.add("version");
        f1645s = null;
        f1646t = null;
        f1645s = Pattern.compile("(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])", 2);     // Catch: PatternSyntaxException -> L6
        f1646t = Pattern.compile("([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}", 2);     // Catch: PatternSyntaxException -> L6
    L4:
        f1647u = new a();
        f1648v = new String[]{"EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
    }

    public f(String r10, String r11) {
        this.f1653j = -1;
        this.f1660q = 0;
        String r12 = r10.trim();
        if (K(r12) == false) goto L7;
        this.f1654k = r12;
        this.f1659p = r11;
        return;
    L7:
        throw new IllegalArgumentException("Invalid name: " + r10);
    }

    private static boolean I(String r10, int r11) {
        int r12 = r10.indexOf(46, r11 + 1);
        if (r12 != (-1)) goto L5;
    L7:
        return false;
    L5:
        if (r12 >= (r10.length() - 1)) goto L7;
        return true;
    }

    public static boolean J(String r10) {
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    L3:
        if (f1645s.matcher(r10).matches() == false) goto L5;
        return true;
    L5:
        if (f1646t.matcher(r10).matches() == false) goto L14;
        return true;
    L14:
        return false;
    }

    private boolean K(String r10) {
        if (r10.length() != 0) goto L5;
    L9:
        boolean r11 = false;
    L10:
        if (r11 == false) goto L29;
        int r12 = 0;
    L13:
        if (r12 >= r10.length()) goto L29;
        char r13 = r10.charAt(r12);
        if (r13 < 0) goto L38;
        if (r13 >= 127) goto L39;
        if (r13 == ';') goto L40;
        if (r13 == ',') goto L41;
        if (Character.isWhitespace(r13) == false) goto L27;
        if (r13 == ' ') goto L27;
        return false;
    L27:
        r12 = r12 + 1;
        goto L13
    L41:
        return false;
    L40:
        return false;
    L39:
        return false;
    L38:
        return false;
    L29:
        return r11;
    L5:
        if (r10.startsWith("$") == true) goto L9;
        if (f1644r.contains(r10.toLowerCase(Locale.US)) == true) goto L9;
        r11 = true;
        goto L10
    }

    private static String L(String r10) {
        if (r10 != null) goto L6;
        return "/";
    L6:
        if (r10.endsWith("/") == false) goto L9;
        return r10;
    L9:
        return r10 + "/";
    }

    public static List<f> M(String r10) {
        return new b(r10).b();
    }

    public static Date N(String r10) {
        return f1647u.get().parse(r10);
    L4:
        String[] r11 = f1648v;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L10;
        String r14 = r11[r13];
        return new SimpleDateFormat(r14, Locale.US).parse(r10);
    L9:
        r13 = r13 + 1;
        goto L5
    L10:
        return null;
    }

    public static boolean O(f r10, URI r11) {
        return L(r11.getPath()).startsWith(L(r10.C()));
    }

    public static boolean P(f r10, URI r11) {
        if (r10.D() != null) goto L7;
        return true;
    L7:
        return Arrays.asList(r10.D().split(",")).contains(Integer.toString(SerializableHttpCookie.getEffectivePort(r11.getScheme(), r11.getPort())));
    }

    public static boolean Q(f r10, URI r11) {
        if (r10.E() == true) goto L5;
    L8:
        return true;
    L5:
        if ("https".equalsIgnoreCase(r11.getScheme()) == true) goto L8;
        return false;
    }

    private void V(Date r10) {
        this.f1653j = (r10.getTime() - System.currentTimeMillis()) / 1000;
    }

    static /* synthetic */ int b(f r10, int r11) {
        r10.f1660q = r11;
        return r11;
    }

    static /* synthetic */ String d(f r10) {
        return r10.f1649c;
    }

    static /* synthetic */ boolean e(f r10, boolean r11) {
        r10.f1658o = r11;
        return r11;
    }

    static /* synthetic */ String f(f r10, String r11) {
        r10.f1649c = r11;
        return r11;
    }

    static /* synthetic */ String g(f r10) {
        return r10.f1650g;
    }

    static /* synthetic */ String h(f r10, String r11) {
        r10.f1650g = r11;
        return r11;
    }

    static /* synthetic */ boolean i(f r10, boolean r11) {
        r10.f1651h = r11;
        return r11;
    }

    static /* synthetic */ String j(f r10) {
        return r10.f1652i;
    }

    static /* synthetic */ String k(f r10, String r11) {
        r10.f1652i = r11;
        return r11;
    }

    static /* synthetic */ long l(f r10) {
        return r10.f1653j;
    }

    static /* synthetic */ long m(f r10, long r11) {
        r10.f1653j = r11;
        return r11;
    }

    static /* synthetic */ void n(f r10, Date r11) {
        r10.V(r11);
    }

    static /* synthetic */ String o(f r10) {
        return r10.f1655l;
    }

    static /* synthetic */ String p(f r10, String r11) {
        r10.f1655l = r11;
        return r11;
    }

    static /* synthetic */ String q(f r10) {
        return r10.f1656m;
    }

    static /* synthetic */ String r(f r10, String r11) {
        r10.f1656m = r11;
        return r11;
    }

    static /* synthetic */ boolean s(f r10, boolean r11) {
        r10.f1657n = r11;
        return r11;
    }

    public static boolean t(String r10, String r11) {
        if (r10 == null) goto L38;
        if (r11 == null) goto L42;
        Locale r12 = Locale.US;
        String r13 = r11.toLowerCase(r12);
        String r14 = r10.toLowerCase(r12);
        if (r13.equals(r14) == false) goto L14;
        if (I(r13, 0) == false) goto L11;
    L12:
        return true;
    L11:
        if (J(r13) == true) goto L12;
    L14:
        if (I(r13, 0) == true) goto L18;
        return r14.equals(".local");
    L18:
        if (r14.length() != (r13.length() + 1)) goto L27;
        if (r14.startsWith(".") == false) goto L27;
        if (r14.endsWith(r13) == false) goto L27;
        if (I(r14, 1) == false) goto L27;
        return true;
    L27:
        if (r13.length() > r14.length()) goto L29;
        return false;
    L29:
        if (r13.endsWith(r14) == true) goto L31;
        return false;
    L31:
        if (r14.startsWith(".") == false) goto L35;
        if (I(r14, 1) == false) goto L35;
    L37:
        return true;
    L35:
        if (r14.equals(".local") == true) goto L37;
        return false;
    L42:
        return false;
    L38:
        return false;
    }

    public static boolean u(Object r10, Object r11) {
        if (r10 != null) goto L7;
        if (r11 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return r10.equals(r11);
    }

    public long A() {
        return this.f1653j;
    }

    public String B() {
        return this.f1654k;
    }

    public String C() {
        return this.f1655l;
    }

    public String D() {
        return this.f1656m;
    }

    public boolean E() {
        return this.f1657n;
    }

    public String F() {
        return this.f1659p;
    }

    public int G() {
        return this.f1660q;
    }

    public boolean H() {
        long r10 = this.f1653j;
        if (r10 != (-1)) goto L6;
        return false;
    L6:
        if (r10 > 0) goto L9;
        return true;
    L9:
        return false;
    }

    public void R(String r10) {
        this.f1649c = r10;
    }

    public void S(String r10) {
        this.f1650g = r10;
    }

    public void T(boolean r10) {
        this.f1651h = r10;
    }

    public void U(String r10) {
        if (r10 != null) goto L4;
        String r11 = null;
    L5:
        this.f1652i = r11;
        return;
    L4:
        r11 = r10.toLowerCase(Locale.US);
        goto L5
    }

    public void W(boolean r10) {
        this.f1658o = r10;
    }

    public void X(long r10) {
        this.f1653j = r10;
    }

    public void Y(String r10) {
        this.f1655l = r10;
    }

    public void Z(String r10) {
        this.f1656m = r10;
    }

    public void a0(boolean r10) {
        this.f1657n = r10;
    }

    public void b0(int r10) {
        if (r10 != 0) goto L4;
    L8:
        this.f1660q = r10;
        return;
    L4:
        if (r10 == 1) goto L8;
        throw new IllegalArgumentException("Bad version: " + r10);
    }

    public Object clone() {
        return super.clone();
    L5:
        throw new AssertionError();
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof f) == false) goto L21;
        f r11 = (f) r10;
        if (this.f1654k.equalsIgnoreCase(r11.B()) == false) goto L20;
        String r12 = this.f1652i;
        if (r12 == null) goto L15;
        if (r12.equalsIgnoreCase(r11.f1652i) == false) goto L20;
    L17:
        if (u(this.f1655l, r11.f1655l) == false) goto L20;
        return true;
    L15:
        if (r11.f1652i == null) goto L17;
    L20:
        return false;
    L21:
        return false;
    }

    public int hashCode() {
        String r10 = this.f1654k;
        Locale r11 = Locale.US;
        int r12 = r10.toLowerCase(r11).hashCode();
        String r13 = this.f1652i;
        int r14 = 0;
        if (r13 != null) goto L5;
        int r15 = 0;
    L6:
        int r16 = r12 + r15;
        String r17 = this.f1655l;
        if (r17 == null) goto L11;
        r14 = r17.hashCode();
    L11:
        return r16 + r14;
    L5:
        r15 = r13.toLowerCase(r11).hashCode();
        goto L6
    }

    public String toString() {
        return this.f1654k + "=" + this.f1659p;
    }

    public String v() {
        return this.f1649c;
    }

    public String w() {
        return this.f1650g;
    }

    public boolean x() {
        return this.f1651h;
    }

    public String y() {
        return this.f1652i;
    }

    public boolean z() {
        return this.f1658o;
    }
}
