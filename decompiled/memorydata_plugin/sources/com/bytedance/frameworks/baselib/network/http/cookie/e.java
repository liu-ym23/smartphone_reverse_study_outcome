package com.bytedance.frameworks.baselib.network.http.cookie;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class e implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f2391a = null;
    private static final ThreadLocal<DateFormat> j = null;
    private static final String[] k = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2392b;
    private boolean c;
    private long d;
    private String e;
    private String f;
    private String g;
    private boolean h;
    private String i;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f2393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f2394b;
        private final String c;
        private int d;

        a(String r2) {
            this.d = 0;
            this.f2393a = false;
            this.f2394b = r2;
            this.c = r2.toLowerCase(Locale.US);
        }

        private int a(String r4) {
            int r0 = this.d;
        L4:
            if (r0 >= this.f2394b.length()) goto L10;
            if (r4.indexOf(this.f2394b.charAt(r0)) != (-1)) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return r0;
        L10:
            return this.f2394b.length();
        }

        private String a(boolean r3) {
            c();
            int r0 = a(";= \t");
            if (r3 == false) goto L5;
            String r4 = this.c;
        L6:
            int r1 = this.d;
            if (r1 >= r0) goto L9;
            String r5 = r4.substring(r1, r0);
        L10:
            this.d = r0;
            return r5;
        L9:
            r5 = null;
            goto L10
        L5:
            r4 = this.f2394b;
            goto L6
        }

        private void a(e r5, String r6, String r7) {
            if (TextUtils.isEmpty(r7) == true) goto L27;
            if (r6.equals("domain") == false) goto L11;
            if (r7.charAt(0) == '.') goto L9;
            r7 = "." + r7;
        L9:
            r5.a(r7.toLowerCase(Locale.US), false);
            return;
        L11:
            if (r6.equals("max-age") == false) goto L17;
            long r2 = Long.parseLong(r7);     // Catch: NumberFormatException -> L14
            this.f2393a = true;     // Catch: NumberFormatException -> L14
            e.a(r5, r2);     // Catch: NumberFormatException -> L14
            return;
        L15:
            throw new IllegalArgumentException("Invalid max-age: " + r7);
        L17:
            if (r6.equals("expires") == false) goto L24;
            if (this.f2393a == true) goto L24;
            Date r4 = e.e(r7);
            if (r4 == null) goto L33;
            e.b(r5, r4.getTime());
            return;
        L33:
            return;
        L24:
            if (r6.equals("path") == false) goto L35;
            e.a(r5, r7);
            return;
        L35:
            return;
        L27:
            if (r6.equals("secure") == false) goto L37;
            e.a(r5, true);
            return;
        }

        private boolean a() {
            c();
            if (this.d < this.f2394b.length()) goto L5;
            return false;
        L5:
            if (this.f2394b.charAt(this.d) != '=') goto L10;
            this.d++;
            return true;
        L10:
            return false;
        }

        private String b() {
            c();
            int r0 = a(";");
            String r1 = this.f2394b.substring(this.d, r0);
            this.d = r0;
            return r1;
        }

        private void c() {
        L3:
            if (this.d >= this.f2394b.length()) goto L8;
            if (" \t".indexOf(this.f2394b.charAt(this.d)) == (-1)) goto L11;
            this.d++;
            goto L3
        L11:
            return;
        }

        e a(URI r7) {
            if (this.c.startsWith("set-cookie:") == false) goto L5;
            this.d += 11;
        L5:
            int r0 = 0;
            String r1 = a(false);
            if (TextUtils.isEmpty(r1) == true) goto L39;
            if (a() == false) goto L37;
            e r3 = new e(r1, b());
            r3.b(String.valueOf(System.currentTimeMillis()), false);
        L10:
            c();
            if (this.d >= this.f2394b.length()) goto L26;
            r0 = r0 + 1;
            if (this.f2394b.charAt(this.d) != ';') goto L16;
            this.d++;
        L16:
            String r2 = a(true);
            if (TextUtils.isEmpty(r2) == true) goto L24;
            String r4 = null;
            if (a() == false) goto L22;
            r4 = b();
        L22:
            a(r3, r2, r4);
        L24:
            if (r0 < 100) goto L10;
        L26:
            if (TextUtils.isEmpty(r3.a()) == false) goto L33;
            String r5 = d.a(r7);
            if (TextUtils.isEmpty(r5) == true) goto L31;
            r3.a(r5, !r5.startsWith("."));
            goto L33
        L31:
            throw new IllegalArgumentException("No domain in " + this.f2394b);
        L33:
            if (TextUtils.isEmpty(r3.d()) == false) goto L35;
            r3.a(e.d(r7.getPath()));
        L35:
            return r3;
        L37:
            throw new IllegalArgumentException("Expected '=' after " + r1 + " in " + this.f2394b);
        L39:
            throw new IllegalArgumentException("No cookies in " + this.f2394b);
        }
    }

    static {
        HashSet r0 = new HashSet();
        f2391a = r0;
        r0.add("comment");
        r0.add("commenturl");
        r0.add("discard");
        r0.add("domain");
        r0.add("expires");
        r0.add("httponly");
        r0.add("max-age");
        r0.add("path");
        r0.add("port");
        r0.add("secure");
        r0.add("version");
        j = new AnonymousClass1();
        k = new String[]{"EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
    }

    public e() {
        this.c = true;
        this.d = -1;
    }

    e(String r3, String r4) {
        this.c = true;
        this.d = -1;
        String r0 = r3.trim();
        if (f(r0) == false) goto L7;
        this.f = r0;
        this.i = r4;
        return;
    L7:
        throw new IllegalArgumentException("Invalid name: " + r3);
    }

    static e a(URI r1, String r2) {
        return new a(r2).a(r1);
    }

    static /* synthetic */ String a(e r0, String r1) {
        r0.g = r1;
        return r1;
    }

    static /* synthetic */ void a(e r0, long r1) {
        r0.b(r1);
    }

    static /* synthetic */ boolean a(e r0, boolean r1) {
        r0.h = r1;
        return r1;
    }

    private void b(long r5) {
        long r0 = 0;
        if (r5 <= 0) goto L5;
        r0 = System.currentTimeMillis() + (r5 * 1000);
    L5:
        this.d = r0;
    }

    static /* synthetic */ void b(e r0, long r1) {
        r0.c(r1);
    }

    private void c(long r5) {
        if ((r5 - System.currentTimeMillis()) <= 0) goto L5;
        this.d = r5;
        return;
    L5:
        this.d = 0;
    }

    static /* synthetic */ String d(String r0) {
        return h(r0);
    }

    static /* synthetic */ Date e(String r0) {
        return g(r0);
    }

    private boolean f(String r5) {
        if (r5.isEmpty() == false) goto L5;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L25;
        int r1 = 0;
    L13:
        if (r1 >= r5.length()) goto L25;
        char r2 = r5.charAt(r1);
        if (r2 >= 127) goto L34;
        if (r2 == ';') goto L31;
        if (r2 == ',') goto L32;
        if (Character.isWhitespace(r2) == true) goto L33;
        r1 = r1 + 1;
        goto L13
    L33:
        return false;
    L32:
        return false;
    L31:
        return false;
    L34:
        return false;
    L25:
        return r4;
    L5:
        if (r5.startsWith("$") == true) goto L9;
        if (f2391a.contains(r5.toLowerCase(Locale.US)) == true) goto L9;
        r4 = true;
        goto L10
    }

    private static Date g(String r6) {
        return ((DateFormat) ZeusTransformUtils.preCheckCast(j.get(), DateFormat.class, "com.obric.memorydata.plugin")).parse(r6);
    L4:
        String[] r0 = k;
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L10;
        String r3 = r0[r2];
        return new SimpleDateFormat(r3, Locale.US).parse(r6);
    L9:
        r2 = r2 + 1;
        goto L5
    L10:
        return null;
    }

    private static String h(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L12:
        return "/";
    L5:
        if (r2.startsWith("/") == false) goto L12;
        int r0 = r2.lastIndexOf(47);
        if (r0 > 0) goto L11;
        return "/";
    L11:
        return r2.substring(0, r0);
    }

    public String a() {
        return this.f2392b;
    }

    public void a(long r1) {
        this.d = r1;
    }

    public void a(String r1) {
        this.g = r1;
    }

    public void a(String r2, boolean r3) {
        if (TextUtils.isEmpty(this.f2392b) == true) goto L5;
        return;
    L5:
        if (r2 != null) goto L7;
        String r4 = null;
    L8:
        this.f2392b = r4;
        this.c = r3;
        return;
    L7:
        r4 = r2.toLowerCase(Locale.US);
        goto L8
    }

    public void a(boolean r1) {
        this.h = r1;
    }

    public void b(String r1) {
        this.f = r1;
    }

    public void b(String r2, boolean r3) {
        if (r3 == false) goto L4;
        String r4 = "s_";
    L5:
        this.e = r4 + r2;
        return;
    L4:
        r4 = "";
        goto L5
    }

    boolean b() {
        return this.c;
    }

    public String c() {
        return this.f;
    }

    public void c(String r1) {
        this.i = r1;
    }

    public Object clone() {
        return super.clone();
    L5:
        throw new AssertionError();
    }

    public String d() {
        return this.g;
    }

    public boolean e() {
        return this.h;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == false) goto L23;
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
        if (this.f.equals(r6.c()) == false) goto L22;
        String r0 = this.f2392b;
        if (r0 == null) goto L15;
        if (r0.equalsIgnoreCase(r6.f2392b) == false) goto L22;
    L17:
        if (Objects.equals(this.g, r6.g) == false) goto L22;
        if (this.c != r6.c) goto L22;
        return true;
    L15:
        if (r6.f2392b == null) goto L17;
    L22:
        return false;
    L23:
        return false;
    }

    public String f() {
        return this.i;
    }

    public long g() {
        return this.d;
    }

    public String h() {
        return this.e;
    }

    public int hashCode() {
        int r0 = (this.f.hashCode() * 31) + 17;
        String r1 = this.f2392b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = r0 + (r3 * 31);
        String r5 = this.g;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return (r4 + (r2 * 31)) + ((!this.c ? 1 : 0) * 31);
    L5:
        r3 = r1.toLowerCase(Locale.US).hashCode();
        goto L6
    }

    long i() {
        if (TextUtils.isEmpty(this.e) == false) goto L6;
        return -1;
    L6:
        boolean r0 = this.e.startsWith("s_");
        String r2 = this.e;
        if (r0 == false) goto L11;
        return Long.parseLong(r2.substring(2));
    L11:
        return Long.parseLong(r2);
    }

    long j() {
        long r0 = this.d;
        if (r0 > 0) goto L6;
        return r0;
    L6:
        return r0 - System.currentTimeMillis();
    }

    boolean k() {
        long r0 = this.d;
        if (r0 != (-1)) goto L6;
        return false;
    L6:
        if (r0 != 0) goto L9;
        return true;
    L9:
        if (System.currentTimeMillis() > this.d) goto L11;
        return false;
    L11:
        return true;
    }

    String l() {
        return this.f + "=" + this.i + "|dom=" + this.f2392b + "|path=" + this.g + "|sec=" + this.h + "|ho=" + this.c + "|exp_t=" + this.d + "|age=" + j() + "|ct=" + this.e;
    }

    public String toString() {
        return this.f + "=" + this.i;
    }
}
