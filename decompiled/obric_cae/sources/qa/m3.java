package qa;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public final class m3 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static m3 f10827i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f10828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<String> f10829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v2 f10830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v2 f10831d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f10832e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f10833f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f10834g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10835h;

    public m3(Context r8) {
        this.f10828a = 0;
        this.f10829b = new ArrayList();
        this.f10830c = new v2();
        this.f10831d = new v2();
        this.f10832e = 120000;
        this.f10835h = false;
        this.f10833f = r8;
    }

    public static synchronized m3 b(Context r8) {
        monitor-enter(m3.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f10827i != null) goto L7;
        f10827i = new m3(r8);     // Catch: Throwable -> L10
    L7:
        m3 r10 = f10827i;     // Catch: Throwable -> L10
        monitor-exit(m3.class);
        return r10;
    }

    public static boolean d(String[] r8, String[] r10) {
        if (r8.length == 0) goto L23;
        if (r10 != null) goto L7;
        return false;
    L7:
        if (r10.length != 0) goto L10;
        return false;
    L10:
        if (r8.length != r10.length) goto L25;
        int r11 = r8.length;
        int r12 = 0;
    L13:
        if (r12 >= r11) goto L18;
        if (r8[r12].equals(r10[r12]) == false) goto L26;
        r12 = r12 + 1;
        goto L13
    L26:
        return false;
    L18:
        return true;
    L25:
        return false;
    L23:
        return false;
    }

    public static String[] e(JSONArray r8, int r10) {
        int r11 = 0;
        if (r8 == null) goto L17;
        if (r8.length() == 0) goto L17;
        int r12 = r8.length();
        String[] r13 = new String[r12];
    L8:
        if (r11 >= r12) goto L21;
        String r14 = r8.getString(r11);
        if (TextUtils.isEmpty(r14) == true) goto L15;
        if (r10 != 2) goto L14;
        r14 = defpackage.b.d("[", r14, "]");
    L14:
        r13[r11] = r14;
    L15:
        r11 = r11 + 1;
        goto L8
    L21:
        return r13;
    L17:
        return new String[0];
    }

    public static void h(m3 r8, int r10) {
        if (r8.f(r10).f11158a != null) goto L5;
        return;
    L5:
        if (r8.f(r10).f11158a.length <= 0) goto L20;
        String r11 = r8.f(r10).f11158a[0];
        if (r11.equals(r8.f10834g) == false) goto L10;
        return;
    L10:
        if (r8.f10829b.contains(r11) == true) goto L19;
        r8.f10834g = r11;
        SharedPreferences.Editor r12 = x3.c(r8.f10833f, "cbG9jaXA");
        if (r10 != 2) goto L14;
        String r13 = "last_ip_6";
    L15:
        x3.h(r12, r13, r11);
        x3.e(r12);
        return;
    L14:
        r13 = "last_ip_4";
        goto L15
    L19:
        return;
    }

    public final String a(p3 r8, int r10) {
        if (s3.f11088y == true) goto L6;
        return null;
    L6:
        String r11 = r8.f10895p;     // Catch: Throwable -> L31
        String r12 = new URL(r11).getHost();     // Catch: Throwable -> L31
        if ("http://abroad.apilocate.amap.com/mobile/binary".equals(r11) == true) goto L30;
        if ("abroad.apilocate.amap.com".equals(r12) == true) goto L30;
        if ("apilocate.amap.com".equalsIgnoreCase(r12) == false) goto L14;
        String r13 = "httpdns.apilocate.amap.com";
    L16:
        if (i4.A(r13) == true) goto L18;
        return null;
    L18:
        String r14 = j(r10);     // Catch: Throwable -> L31
        if (TextUtils.isEmpty(r14) == true) goto L30;
        r8.f10896q = r11.replace(r12, r14);     // Catch: Throwable -> L31
        r8.f10893n.put("host", r13);     // Catch: Throwable -> L31
        if (TextUtils.isEmpty(r13) == true) goto L23;
        r8.f10894o = r13;     // Catch: Throwable -> L31
    L25:
        if (r10 != 2) goto L27;
        boolean r15 = true;
    L28:
        r8.f10803g = r15;     // Catch: Throwable -> L31
        return r14;
    L27:
        r15 = false;
        goto L28
    L23:
        r8.f10894o = "";     // Catch: Throwable -> L31
        goto L25
    L14:
        r13 = r12;
    L30:
        return null;
    }

    public final void c(int r8, boolean r10) {
        f(r8).f11162e = r10;
        if (r10 == false) goto L14;
        String r11 = f(r8).f11160c;
        String r12 = f(r8).f11159b;
        if (TextUtils.isEmpty(r12) == false) goto L7;
        return;
    L7:
        if (r12.equals(r11) == true) goto L16;
        SharedPreferences.Editor r13 = x3.c(this.f10833f, "cbG9jaXA");
        if (r8 != 2) goto L11;
        String r14 = "last_ip_6";
    L12:
        x3.h(r13, r14, r12);
        x3.e(r13);
        return;
    L11:
        r14 = "last_ip_4";
        goto L12
    L16:
        return;
    }

    public final v2 f(int r8) {
        if (r8 != 2) goto L7;
        return this.f10831d;
    L7:
        return this.f10830c;
    }

    public final synchronized void g(int r10, boolean r11) {
        monitor-enter(this);
        if (r11 == true) goto L11;
    L27:
        th = move-exception;
        throw th;
    L5:
        if (s3.A == true) goto L11;
        if (this.f10835h == false) goto L11;
        monitor-exit(this);
        return;
    L11:
        if (this.f10828a == 0) goto L21;
        long r8 = System.currentTimeMillis();     // Catch: Throwable -> L27
        long r12 = this.f10828a;     // Catch: Throwable -> L27
        if ((r8 - r12) >= this.f10832e) goto L18;
        monitor-exit(this);
        return;
    L18:
        if ((r8 - r12) >= 60000) goto L21;
        monitor-exit(this);
        return;
    L21:
        this.f10828a = System.currentTimeMillis();     // Catch: Throwable -> L27
        this.f10835h = true;     // Catch: Throwable -> L27
        StackTraceElement[] r13 = Thread.currentThread().getStackTrace();     // Catch: Throwable -> L27
        StringBuffer r14 = new StringBuffer();     // Catch: Throwable -> L27
        int r15 = r13.length;     // Catch: Throwable -> L27
        int r16 = 0;
    L22:
        if (r16 >= r15) goto L24;
        StackTraceElement r17 = r13[r16];     // Catch: Throwable -> L27
        r14.append(r17.getClassName() + "(" + r17.getMethodName() + BdimCategoryConstants.SEPARATOR_COLON + r17.getLineNumber() + "),");     // Catch: Throwable -> L27
        r16 = r16 + 1;     // Catch: Throwable -> L27
        goto L22
    L24:
        l1.f10784d.a(new l3(this, r10));     // Catch: Throwable -> L27
        monitor-exit(this);
    }

    public final void i(int r8) {
        if (f(r8).f11161d == false) goto L16;
        SharedPreferences.Editor r10 = x3.c(this.f10833f, "cbG9jaXA");
        if (r8 != 2) goto L7;
        String r11 = "last_ip_6";
    L14:
        r10.remove(r11);     // Catch: Throwable -> L10
    L12:
        x3.e(r10);
        f(r8).f11161d = false;
        return;
    L10:
        th = move-exception;
        t3.g("SpUtil", "setPrefsLong", th);
        goto L12
    L7:
        r11 = "last_ip_4";
        goto L14
    }

    public final String j(int r8) {
        int r10 = 0;
        g(r8, false);
        String[] r11 = f(r8).f11158a;
        ArrayList<String> r12 = this.f10829b;
        if (r11 == null) goto L19;
        if (r11.length <= 0) goto L19;
        int r13 = r11.length;
    L7:
        if (r10 >= r13) goto L12;
        String r14 = r11[r10];
        if (r12.contains(r14) == false) goto L14;
        r10 = r10 + 1;
    L14:
        if (TextUtils.isEmpty(r14) == false) goto L16;
        return null;
    L16:
        f(r8).f11159b = r14;
        return r14;
    L12:
        r14 = null;
    L19:
        if (r8 != 2) goto L21;
        String r15 = "last_ip_6";
    L22:
        String r16 = x3.d(this.f10833f, "cbG9jaXA", r15, null);
        if (TextUtils.isEmpty(r16) == true) goto L28;
        if (r12.contains(r16) == true) goto L28;
        f(r8).f11159b = r16;
        f(r8).f11160c = r16;
        f(r8).f11161d = true;
    L28:
        return f(r8).f11159b;
    L21:
        r15 = "last_ip_4";
        goto L22
    }
}
