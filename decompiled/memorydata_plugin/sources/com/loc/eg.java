package com.loc;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.Api;
import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public final class eg {
    static long d;
    static long e;
    static long f;
    public static long g;
    static long h;
    public static HashMap<String, Long> v;
    public static long w;
    static int x;
    public static long z;
    volatile boolean A;
    private volatile ef B;
    private String C;
    private long D;
    private dm E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    WifiManager f5485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ArrayList<db> f5486b;
    ArrayList<db> c;
    Context i;
    boolean j;
    StringBuilder k;
    boolean l;
    boolean m;
    boolean n;
    String o;
    TreeMap<Integer, db> p;
    public boolean q;
    public boolean r;
    public boolean s;
    ee t;
    long u;
    ConnectivityManager y;

    static {
        v = new HashMap(36);
        w = 0;
        x = 0;
        z = 0;
    }

    public eg(Context r6, WifiManager r7, Handler r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        this.f5486b = new ArrayList();
        this.c = new ArrayList();
        this.j = false;
        this.k = null;
        this.l = true;
        this.m = true;
        this.n = true;
        this.B = null;
        this.o = null;
        this.p = null;
        this.q = true;
        this.r = true;
        this.s = false;
        this.C = "";
        this.u = 0;
        this.y = null;
        this.D = 30000;
        this.A = false;
        this.f5485a = r7;
        this.i = ZeusTransformUtils.wrapperContext(r9, "com.obric.memorydata.plugin");
        ee r10 = new ee(r9, "wifiAgee", r8);
        this.t = r10;
        r10.a();
    }

    private void A() {
        if (this.f5485a != null) goto L23;
        return;
    L23:
        int r1 = t();     // Catch: Throwable -> L8
    L11:
        if (this.f5486b != null) goto L13;
        this.f5486b = new ArrayList();     // Catch: Throwable -> L20
    L13:
        if (r1 != 0) goto L15;
    L18:
        g();     // Catch: Throwable -> L20
        return;
    L15:
        if (r1 == 1) goto L18;
        if (r1 == 4) goto L18;
        return;
    L8:
        th = move-exception;
        ev.a(th, "OPENSDK_WMW", "cwsc");     // Catch: Throwable -> L20
        r1 = 4;
    }

    private void B() {
    L6:
        ex.b();
        return;
    L3:
        if (fd.c(this.i, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF") == false) goto L10;
        this.r = this.f5485a.isWifiEnabled();     // Catch: Throwable -> L6
        return;
    }

    private boolean C() {
        this.q = w();
        B();
        if (this.q == true) goto L6;
    L19:
        return false;
    L6:
        if (this.l == false) goto L19;
        if (f != 0) goto L12;
        return true;
    L12:
        if ((fd.b() - f) < 4900) goto L19;
        if ((fd.b() - g) < 1500) goto L19;
        int r9 = ((fd.b() - g) > 4900 ? 1 : ((fd.b() - g) == 4900 ? 0 : -1));
        return true;
    }

    private static boolean a(int r3) {
        int r0 = 20;
        r0 = WifiManager.calculateSignalLevel(r3, 20);     // Catch: ArithmeticException -> L5
    L7:
        if (r0 <= 0) goto L10;
        return true;
    L10:
        return false;
    L5:
        e = move-exception;
        ev.a(e, "Aps", "wifiSigFine");
        goto L7
    }

    public static boolean a(ef r0) {
        if (r0 != null) goto L6;
        return false;
    L6:
        return r0.d();
    }

    public static long b() {
        return ((fd.b() - w) / 1000) + 1;
    }

    private void d(boolean r6) {
        ArrayList<db> r0 = this.f5486b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == false) goto L8;
        return;
    L8:
        if ((fd.b() - g) <= ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS) goto L11;
        g();
    L11:
        if (this.p != null) goto L13;
        this.p = new TreeMap(Collections.reverseOrder());
    L13:
        this.p.clear();
        if (this.s == false) goto L17;
        if (r6 == false) goto L17;
        this.c.clear();     // Catch: Throwable -> L51
    L17:
        int r1 = this.f5486b.size();
        this.u = 0;
        int r2 = 0;
    L19:
        if (r2 >= r1) goto L45;
        db r3 = (db) ZeusTransformUtils.preCheckCast(this.f5486b.get(r2), db.class, "com.obric.memorydata.plugin");
        if (r3.h == false) goto L23;
        this.u = r3.f;
    L23:
        if (r3 == null) goto L25;
        String r4 = db.a(r3.f5428a);
    L27:
        if (fd.a(r4) == false) goto L44;
        if (r1 <= 20) goto L33;
        if (a(r3.c) == false) goto L44;
    L33:
        if (this.s == false) goto L37;
        if (r6 == false) goto L37;
        this.c.add(r3);
    L37:
        if (TextUtils.isEmpty(r3.f5429b) == false) goto L39;
        String r5 = "unkwn";
    L42:
        r3.f5429b = r5;
    L43:
        this.p.put(Integer.valueOf((r3.c * 25) + r2), r3);
        goto L44
    L39:
        if ("<unknown ssid>".equals(r3.f5429b) == true) goto L43;
        r5 = String.valueOf(r2);
    L44:
        r2 = r2 + 1;
        goto L19
    L25:
        r4 = "";
        goto L27
    L45:
        this.f5486b.clear();
        Iterator<db> r7 = this.p.values().iterator();
    L47:
        if (r7.hasNext() == false) goto L49;
        db r8 = (db) ZeusTransformUtils.preCheckCast(r7.next(), db.class, "com.obric.memorydata.plugin");
        this.f5486b.add(r8);
        goto L47
    L49:
        this.p.clear();
    }

    public static String q() {
        return String.valueOf(fd.b() - g);
    }

    private List<db> s() {
        if (this.f5485a != null) goto L51;
    L50:
        return null;
    L51:
    L48:
        e = move-exception;
        this.o = e.getMessage();
    L46:
        th = move-exception;
        this.o = null;
        ev.a(th, "WifiManagerWrapper", "getScanResults");
        goto L50
    L5:
        if (fd.c(this.i, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF") == false) goto L7;
        List<ScanResult> r0 = this.f5485a.getScanResults();     // Catch: Throwable -> L46 SecurityException -> L48
    L10:
        if (Build.VERSION.SDK_INT < 17) goto L23;
        HashMap<String, Long> r2 = new HashMap(36);     // Catch: Throwable -> L46 SecurityException -> L48
        if (r0 == null) goto L18;
        Iterator<ScanResult> r5 = r0.iterator();     // Catch: Throwable -> L46 SecurityException -> L48
    L15:
        if (r5.hasNext() == false) goto L18;
        ScanResult r6 = (ScanResult) ZeusTransformUtils.preCheckCast(r5.next(), ScanResult.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L46 SecurityException -> L48
        r2.put(r6.BSSID, Long.valueOf(r6.timestamp));     // Catch: Throwable -> L46 SecurityException -> L48
    L18:
        if (v.isEmpty() == false) goto L20;
    L21:
        v = r2;     // Catch: Throwable -> L46 SecurityException -> L48
        long r7 = fd.b();     // Catch: Throwable -> L46 SecurityException -> L48
    L22:
        w = r7;     // Catch: Throwable -> L46 SecurityException -> L48
    L24:
        this.o = null;     // Catch: Throwable -> L46 SecurityException -> L48
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L46 SecurityException -> L48
        this.C = "";     // Catch: Throwable -> L46 SecurityException -> L48
        this.B = n();     // Catch: Throwable -> L46 SecurityException -> L48
        if (a(this.B) == false) goto L27;
        this.C = this.B.a();     // Catch: Throwable -> L46 SecurityException -> L48
    L27:
        if (r0 != null) goto L29;
    L44:
        this.t.a(r3);     // Catch: Throwable -> L46 SecurityException -> L48
        return r3;
    L29:
        if (r0.size() <= 0) goto L44;
        int r8 = r0.size();     // Catch: Throwable -> L46 SecurityException -> L48
        int r9 = 0;
    L31:
        if (r9 >= r8) goto L44;
        ScanResult r10 = (ScanResult) ZeusTransformUtils.preCheckCast(r0.get(r9), ScanResult.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L46 SecurityException -> L48
        String r11 = r10.BSSID;     // Catch: Throwable -> L46 SecurityException -> L48
        if (TextUtils.isEmpty(this.C) == false) goto L35;
    L37:
        boolean r12 = false;
    L38:
        db r13 = new db(r12);     // Catch: Throwable -> L46 SecurityException -> L48
        r13.f5429b = r10.SSID;     // Catch: Throwable -> L46 SecurityException -> L48
        r13.d = r10.frequency;     // Catch: Throwable -> L46 SecurityException -> L48
        r13.e = r10.timestamp;     // Catch: Throwable -> L46 SecurityException -> L48
        r13.f5428a = db.a(r10.BSSID);     // Catch: Throwable -> L46 SecurityException -> L48
        r13.c = (short) r10.level;     // Catch: Throwable -> L46 SecurityException -> L48
        if (Build.VERSION.SDK_INT < 17) goto L43;
        r13.g = (short) ((SystemClock.elapsedRealtime() - (r10.timestamp / 1000)) / 1000);     // Catch: Throwable -> L46 SecurityException -> L48
        if (r13.g >= 0) goto L43;
        r13.g = 0;     // Catch: Throwable -> L46 SecurityException -> L48
    L43:
        r13.f = fd.b();     // Catch: Throwable -> L46 SecurityException -> L48
        r3.add(r13);     // Catch: Throwable -> L46 SecurityException -> L48
        r9 = r9 + 1;     // Catch: Throwable -> L46 SecurityException -> L48
        goto L31
    L35:
        if (this.C.equals(r11) == false) goto L37;
        r12 = true;
        goto L38
    L20:
        if (v.equals(r2) == true) goto L24;
    L23:
        r7 = fd.b();     // Catch: Throwable -> L46 SecurityException -> L48
        goto L22
    L7:
        ev.a(new Exception("gst_n_aws"), "OPENSDK_WMW", "gsr_n_aws");     // Catch: Throwable -> L46 SecurityException -> L48
        r0 = null;
        goto L10
    }

    private int t() {
        WifiManager r0 = this.f5485a;
        if (r0 != null) goto L5;
        return 4;
    L5:
        return r0.getWifiState();
    }

    private boolean u() {
        long r0 = fd.b() - d;
        if (r0 >= 4900) goto L6;
        return false;
    L6:
        if (v() == false) goto L11;
        if (r0 >= 9900) goto L11;
        return false;
    L11:
        if (x <= 1) goto L25;
        long r5 = this.D;
        if (r5 != 30000) goto L20;
        if (eu.o() == (-1)) goto L18;
        r5 = eu.o();
        goto L20
    L18:
        r5 = 30000;
    L20:
        if (Build.VERSION.SDK_INT < 28) goto L25;
        if (r0 >= r5) goto L25;
        return false;
    L25:
        if (this.f5485a == null) goto L34;
        d = fd.b();
        int r1 = x;
        if (r1 >= 2) goto L30;
        x = r1 + 1;
    L30:
        if (fd.c(this.i, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF") == true) goto L32;
        ev.a(new Exception("n_cws"), "OPENSDK_WMW", "wfs_n_cws");
        goto L34
    L32:
        return this.f5485a.startScan();
    L34:
        return false;
    }

    private boolean v() {
        if (this.y != null) goto L6;
        this.y = (ConnectivityManager) ZeusTransformUtils.preCheckCast(fd.a(this.i, "connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");
    L6:
        return a(this.y);
    }

    private boolean w() {
        if (this.f5485a != null) goto L7;
        return false;
    L7:
        return fd.g(this.i);
    }

    private void x() {
        if (C() == false) goto L15;
        long r0 = fd.b();
        int r2 = 20;
        if ((r0 - e) < 10000) goto L7;
        this.f5486b.clear();
        h = g;
    L7:
        y();
        if ((r0 - e) < 10000) goto L22;
    L9:
        if (r2 <= 0) goto L23;
        if (g != h) goto L24;
        Thread.sleep(150);     // Catch: Throwable -> L16
    L14:
        r2 = r2 - 1;
        goto L9
    L24:
        return;
    L23:
        return;
    L22:
        return;
    }

    private void y() {
        if (C() == false) goto L14;
    L8:
        th = move-exception;
        ev.a(th, "WifiManager", "wifiScan");
        return;
    L5:
        if (u() == false) goto L13;
        f = fd.b();     // Catch: Throwable -> L8
        return;
    L13:
        return;
    }

    private void z() {
        if (h == g) goto L17;
        List<db> r0 = null;
        r0 = s();     // Catch: Throwable -> L7
    L9:
        h = g;
        if (r0 == null) goto L13;
        this.f5486b.clear();
        this.f5486b.addAll(r0);
        return;
    L13:
        this.f5486b.clear();
        return;
    L7:
        th = move-exception;
        ev.a(th, "WifiManager", "updateScanResult");
        goto L9
    }

    public final ArrayList<db> a() {
        if (this.s == false) goto L5;
        b(true);
        return this.c;
    L5:
        return this.c;
    }

    public final void a(dm r1) {
        this.E = r1;
    }

    public final void a(boolean r8) {
        Context r0 = this.i;
        if (eu.n() == true) goto L5;
        return;
    L5:
        if (this.n == true) goto L8;
        return;
    L8:
        if (this.f5485a == null) goto L27;
        if (r0 == null) goto L28;
        if (r8 == true) goto L13;
        return;
    L13:
        if (fd.c() > 17) goto L15;
        return;
    L15:
        ContentResolver r7 = r0.getContentResolver();
    L20:
        th = move-exception;
        ev.a(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
        return;
    L17:
        if (((Integer) ZeusTransformUtils.preCheckCast(ez.a("android.provider.Settings$Global", "getInt", new Object[]{r7, "wifi_scan_always_enabled"}, new Class[]{ContentResolver.class, String.class}), Integer.class, "com.obric.memorydata.plugin")).intValue() != 0) goto L25;
        ez.a("android.provider.Settings$Global", "putInt", new Object[]{r7, "wifi_scan_always_enabled", 1}, new Class[]{ContentResolver.class, String.class, Integer.TYPE});     // Catch: Throwable -> L20
        return;
    L25:
        return;
    L28:
        return;
    }

    public final void a(boolean r1, boolean r2, boolean r3, long r4) {
        this.l = r1;
        this.m = r2;
        this.n = r3;
        if (r4 >= 10000) goto L6;
        this.D = 10000;
        return;
    L6:
        this.D = r4;
    }

    public final boolean a(ConnectivityManager r3) {
    L8:
        th = move-exception;
        ev.a(th, "WifiManagerWrapper", "wifiAccess");
        return false;
    L4:
        if (fd.a(r3.getActiveNetworkInfo()) != 1) goto L13;
        if (a(n()) == true) goto L15;
        return false;
    L15:
        return true;
    L13:
        return false;
    }

    public final void b(boolean r6) {
        if (r6 == false) goto L4;
        x();
    L5:
        boolean r0 = false;
        if (this.A == false) goto L8;
        this.A = false;
        A();
    L8:
        z();
        if ((fd.b() - g) <= 20000) goto L11;
        this.f5486b.clear();
    L11:
        e = fd.b();
        if (this.f5486b.isEmpty() == false) goto L16;
        g = fd.b();
        List<db> r7 = s();
        if (r7 == null) goto L16;
        this.f5486b.addAll(r7);
        r0 = true;
    L16:
        d(r0);
        return;
    L4:
        y();
        goto L5
    }

    public final WifiInfo c() {
    L11:
        th = move-exception;
        ev.a(th, "WifiManagerWrapper", "getConnectionInfo");
        return null;
    L4:
        if (this.f5485a != null) goto L6;
        return null;
    L6:
        if (fd.c(this.i, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF") == true) goto L8;
        ev.a(new Exception("gci_n_aws"), "OPENSDK_WMW", "gci_n_aws");     // Catch: Throwable -> L11
        return null;
    L8:
        return this.f5485a.getConnectionInfo();
    }

    public final void c(boolean r2) {
        g();
        this.f5486b.clear();
        this.t.a(r2);
    }

    public final String d() {
        return this.o;
    }

    public final ArrayList<db> e() {
        if (this.f5486b != null) goto L6;
        return null;
    L6:
        ArrayList<db> r0 = new ArrayList();
        if (this.f5486b.isEmpty() == true) goto L9;
        r0.addAll(this.f5486b);
    L9:
        return r0;
    }

    public final void f() {
        this.s = true;     // Catch: Throwable -> L8
        List<db> r1 = s();     // Catch: Throwable -> L8
        if (r1 == null) goto L6;
        this.f5486b.clear();     // Catch: Throwable -> L8
        this.f5486b.addAll(r1);     // Catch: Throwable -> L8
    L6:
        d(true);     // Catch: Throwable -> L8
        return;
    }

    public final void g() {
        this.B = null;
        this.f5486b.clear();
    }

    public final void h() {
        this.B = null;
    }

    public final void i() {
        z = System.currentTimeMillis();
        dm r2 = this.E;
        if (r2 == null) goto L6;
        r2.b();
        return;
    }

    public final void j() {
        if (this.f5485a != null) goto L6;
        return;
    L6:
        if ((fd.b() - g) <= 4900) goto L9;
        g = fd.b();
        return;
    }

    public final void k() {
        if (this.f5485a != null) goto L5;
        return;
    L5:
        this.A = true;
    }

    public final boolean l() {
        return this.q;
    }

    public final boolean m() {
        return this.r;
    }

    public final ef n() {
        B();
        if (m() == true) goto L7;
        return null;
    L7:
        if (this.B != null) goto L10;
        this.B = new ef(c());
    L10:
        return this.B;
    }

    public final boolean o() {
        return this.j;
    }

    public final String p() {
        StringBuilder r0 = this.k;
        if (r0 != null) goto L5;
        this.k = new StringBuilder(TypedValues.TransitionType.TYPE_DURATION);
    L6:
        this.j = false;
        int r1 = this.f5486b.size();
        int r2 = 0;
        boolean r3 = false;
        boolean r4 = false;
    L8:
        if (r2 >= r1) goto L22;
        String r6 = db.a(((db) ZeusTransformUtils.preCheckCast(this.f5486b.get(r2), db.class, "com.obric.memorydata.plugin")).f5428a);
        if (this.m == true) goto L15;
        if ("<unknown ssid>".equals(((db) ZeusTransformUtils.preCheckCast(this.f5486b.get(r2), db.class, "com.obric.memorydata.plugin")).f5429b) == true) goto L15;
        r3 = true;
    L15:
        if (TextUtils.isEmpty(this.C) == false) goto L17;
    L19:
        boolean r7 = r4;
        String r5 = "nb";
    L20:
        this.k.append(String.format(Locale.US, "#%s,%s", new Object[]{r6, r5}));
        r2 = r2 + 1;
        r4 = r7;
        goto L8
    L17:
        if (this.C.equals(r6) == false) goto L19;
        r5 = Api.KEY_ACCESS;
        r7 = true;
        goto L20
    L22:
        if (this.f5486b.size() != 0) goto L25;
        r3 = true;
    L25:
        if (this.m == true) goto L28;
        if (r3 == true) goto L28;
        this.j = true;
    L28:
        if (r4 == true) goto L33;
        if (TextUtils.isEmpty(this.C) == true) goto L33;
        this.k.append("#").append(this.C);
        this.k.append(",access");
    L33:
        return this.k.toString();
    L5:
        r0.delete(0, r0.length());
        goto L6
    }

    public final long r() {
        return this.u;
    }
}
