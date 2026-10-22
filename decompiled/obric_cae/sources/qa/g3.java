package qa;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class g3 {
    public static long A;
    public static HashMap<String, Long> B;
    public static long C;
    public static int D;
    public static long E;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static long f10451w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static long f10452x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static long f10453y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static long f10454z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WifiManager f10455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<n2> f10456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<n2> f10457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f10458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f10459e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public StringBuilder f10460f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f10461g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10462h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10463i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile f3 f10464j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f10465k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TreeMap<Integer, n2> f10466l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f10467m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f10468n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f10469o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final a3 f10470p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f10471q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f10472r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ConnectivityManager f10473s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f10474t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public u2 f10475u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile boolean f10476v;

    static {
        B = new HashMap(36);
        C = 0;
        D = 0;
        E = 0;
    }

    public g3(Context r8, WifiManager r10, Handler r11) {
        this.f10456b = new ArrayList();
        this.f10457c = new ArrayList();
        this.f10459e = false;
        this.f10460f = null;
        this.f10461g = true;
        this.f10462h = true;
        this.f10463i = true;
        this.f10464j = null;
        this.f10465k = null;
        this.f10466l = null;
        this.f10467m = true;
        this.f10468n = true;
        this.f10469o = false;
        this.f10471q = "";
        this.f10472r = 0;
        this.f10473s = null;
        this.f10474t = 30000;
        this.f10476v = false;
        this.f10455a = r10;
        this.f10458d = r8;
        a3 r12 = new a3(r8, "wifiAgee", r11, 1);
        this.f10470p = r12;
        if (r12.f11232b == true) goto L7;
        Handler r13 = r12.f11234d;
        if (r13 == null) goto L7;
        y2.a r14 = r12.f11237g;
        r13.removeCallbacks(r14);
        r13.postDelayed(r14, 60000);
    L7:
        r12.f11232b = true;
    }

    public static boolean c(f3 r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        WifiInfo r10 = r8.f10411a;
        if (r10 == null) goto L28;
        String r11 = null;
        if (r8.f10412b != null) goto L15;
        if (r10 != null) goto L12;
        String r12 = null;
    L13:
        r8.f10412b = r12;
        goto L15
    L12:
        r12 = r10.getSSID();
    L15:
        if (TextUtils.isEmpty(r8.f10412b) == false) goto L18;
        return false;
    L18:
        if (r8.f10413c != null) goto L24;
        if (r10 == null) goto L22;
        r11 = r10.getBSSID();
    L22:
        r8.f10413c = r11;
    L24:
        if (y3.m(r8.f10413c) == false) goto L30;
        return true;
    L30:
        return false;
    L28:
        return false;
    }

    public final boolean a() {
        Context r8 = this.f10458d;
        WifiManager r10 = this.f10455a;
        if (r10 != null) goto L5;
        boolean r11 = false;
    L6:
        this.f10467m = r11;
        if (y3.y(r8, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF") == false) goto L11;
        this.f10468n = r10.isWifiEnabled();     // Catch: Throwable -> L28
    L11:
        if (this.f10467m == true) goto L14;
        return false;
    L14:
        if (this.f10461g == true) goto L17;
        return false;
    L17:
        if (f10453y != 0) goto L20;
    L26:
        return true;
    L20:
        if ((SystemClock.elapsedRealtime() - f10453y) >= 4900) goto L23;
        return false;
    L23:
        if ((SystemClock.elapsedRealtime() - f10454z) < 1500) goto L34;
        SystemClock.elapsedRealtime();
        goto L26
    L34:
        return false;
    L5:
        r11 = y3.C(r8);
        goto L6
    }

    public final boolean b(ConnectivityManager r8) {
    L8:
        th = move-exception;
        t3.g("WifiManagerWrapper", "wifiAccess", th);
        return false;
    L4:
        if (y3.c(r8.getActiveNetworkInfo()) != 1) goto L13;
        if (c(h()) == true) goto L15;
        return false;
    L15:
        return true;
    L13:
        return false;
    }

    public final void d(boolean r10) {
        if (r10 == false) goto L27;
        if (a() == false) goto L34;
        long r8 = SystemClock.elapsedRealtime();
        if ((r8 - f10452x) < 10000) goto L10;
        this.f10456b.clear();
        A = f10454z;
    L10:
        if (a() == false) goto L18;
    L15:
        th = move-exception;
        t3.g("WifiManager", "wifiScan", th);
        goto L18
    L12:
        if (j() == false) goto L18;
        f10453y = SystemClock.elapsedRealtime();     // Catch: Throwable -> L15
    L18:
        if ((r8 - f10452x) < 10000) goto L34;
        int r11 = 20;
    L20:
        if (r11 <= 0) goto L34;
        if (f10454z != A) goto L34;
        Thread.sleep(150);     // Catch: Throwable -> L73
    L25:
        r11 = r11 - 1;
    L34:
        ArrayList r12 = null;
        boolean r13 = true;
        if (this.f10476v == false) goto L54;
        this.f10476v = false;
        WifiManager r14 = this.f10455a;     // Catch: Throwable -> L74
        if (r14 == null) goto L54;
        int r15 = r14.getWifiState();     // Catch: Throwable -> L43
    L46:
        if (this.f10456b != null) goto L48;
        this.f10456b = new ArrayList();     // Catch: Throwable -> L74
    L48:
        if (r15 == 0) goto L52;
        if (r15 == 1) goto L52;
        if (r15 != 4) goto L54;
    L52:
        this.f10464j = null;     // Catch: Throwable -> L74
        this.f10456b.clear();     // Catch: Throwable -> L74
    L43:
        th = move-exception;
        t3.g("OPENSDK_WMW", "cwsc", th);     // Catch: Throwable -> L74
        r15 = 4;
    L54:
        if (A == f10454z) goto L63;
        r12 = i();     // Catch: Throwable -> L57
    L59:
        A = f10454z;
        this.f10456b.clear();
        if (r12 == null) goto L63;
        this.f10456b.addAll(r12);
    L57:
        th = move-exception;
        t3.g("WifiManager", "updateScanResult", th);
    L63:
        if ((SystemClock.elapsedRealtime() - f10454z) <= 20000) goto L65;
        this.f10456b.clear();
    L65:
        f10452x = SystemClock.elapsedRealtime();
        if (this.f10456b.isEmpty() == false) goto L70;
        f10454z = SystemClock.elapsedRealtime();
        ArrayList r16 = i();
        if (r16 == null) goto L70;
        this.f10456b.addAll(r16);
    L71:
        f(r13);
        return;
    L70:
        r13 = false;
        goto L71
    L27:
        if (a() == false) goto L34;
    L32:
        th = move-exception;
        t3.g("WifiManager", "wifiScan", th);
        goto L34
    L29:
        if (j() == false) goto L34;
        f10453y = SystemClock.elapsedRealtime();     // Catch: Throwable -> L32
        goto L34
    }

    public final WifiInfo e() {
        WifiManager r8 = this.f10455a;
        if (r8 == null) goto L15;
    L10:
        th = move-exception;
        t3.g("WifiManagerWrapper", "getConnectionInfo", th);
        return null;
    L5:
        if (y3.y(this.f10458d, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF") == true) goto L7;
        t3.g("OPENSDK_WMW", "gci_n_aws", new Exception("gci_n_aws"));     // Catch: Throwable -> L10
        return null;
    L7:
        return r8.getConnectionInfo();
    L15:
        return null;
    }

    public final void f(boolean r10) {
        ArrayList<n2> r8 = this.f10456b;
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.isEmpty() == false) goto L8;
        return;
    L8:
        if ((SystemClock.elapsedRealtime() - f10454z) <= 3600000) goto L11;
        this.f10464j = null;
        this.f10456b.clear();
    L11:
        if (this.f10466l != null) goto L13;
        this.f10466l = new TreeMap(Collections.reverseOrder());
    L13:
        this.f10466l.clear();
        boolean r11 = this.f10469o;
        ArrayList<n2> r12 = this.f10457c;
        if (r11 == false) goto L17;
        if (r10 == false) goto L17;
        r12.clear();     // Catch: Throwable -> L54
    L17:
        int r13 = this.f10456b.size();
        this.f10472r = 0;
        int r14 = 0;
    L18:
        if (r14 >= r13) goto L48;
        n2 r15 = this.f10456b.get(r14);
        if (r15.f10858h == false) goto L23;
        this.f10472r = r15.f10856f;
    L23:
        if (y3.m(n2.b(r15.f10851a)) == false) goto L47;
        int r16 = 20;
        if (r13 <= 20) goto L36;
        r16 = WifiManager.calculateSignalLevel(r15.f10853c, 20);     // Catch: ArithmeticException -> L29
    L31:
        if (r16 <= 0) goto L33;
        boolean r17 = true;
    L34:
        if (r17 == false) goto L47;
    L33:
        r17 = false;
    L29:
        e = move-exception;
        t3.g("Aps", "wifiSigFine", e);
    L36:
        if (this.f10469o == false) goto L40;
        if (r10 == false) goto L40;
        r12.add(r15);
    L40:
        if (TextUtils.isEmpty(r15.f10852b) == false) goto L42;
        String r18 = "unkwn";
    L45:
        r15.f10852b = r18;
    L46:
        this.f10466l.put(Integer.valueOf((r15.f10853c * 25) + r14), r15);
        goto L47
    L42:
        if ("<unknown ssid>".equals(r15.f10852b) == true) goto L46;
        r18 = String.valueOf(r14);
    L47:
        r14 = r14 + 1;
        goto L18
    L48:
        this.f10456b.clear();
        Iterator<n2> r19 = this.f10466l.values().iterator();
    L50:
        if (r19.hasNext() == false) goto L52;
        this.f10456b.add(r19.next());
        goto L50
    L52:
        this.f10466l.clear();
    }

    public final ArrayList<n2> g() {
        if (this.f10456b != null) goto L6;
        return null;
    L6:
        ArrayList<n2> r8 = new ArrayList();
        if (this.f10456b.isEmpty() == true) goto L9;
        r8.addAll(this.f10456b);
    L9:
        return r8;
    }

    public final f3 h() {
        if (y3.y(this.f10458d, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF") == false) goto L6;
        this.f10468n = this.f10455a.isWifiEnabled();     // Catch: Throwable -> L14
    L6:
        if (this.f10468n == true) goto L10;
        return null;
    L10:
        if (this.f10464j != null) goto L13;
        this.f10464j = new f3(e());
    L13:
        return this.f10464j;
    }

    public final ArrayList i() {
        if (this.f10455a != null) goto L51;
    L50:
        return null;
    L51:
    L48:
        e = move-exception;
        this.f10465k = e.getMessage();
    L46:
        th = move-exception;
        this.f10465k = null;
        t3.g("WifiManagerWrapper", "getScanResults", th);
        goto L50
    L5:
        if (y3.y(this.f10458d, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF") == false) goto L7;
        List<ScanResult> r8 = this.f10455a.getScanResults();     // Catch: Throwable -> L46 SecurityException -> L48
    L8:
        HashMap<String, Long> r10 = new HashMap(36);     // Catch: Throwable -> L46 SecurityException -> L48
        if (r8 == null) goto L15;
        Iterator<ScanResult> r11 = r8.iterator();     // Catch: Throwable -> L46 SecurityException -> L48
    L12:
        if (r11.hasNext() == false) goto L15;
        ScanResult r12 = r11.next();     // Catch: Throwable -> L46 SecurityException -> L48
        r10.put(r12.BSSID, Long.valueOf(r12.timestamp));     // Catch: Throwable -> L46 SecurityException -> L48
    L15:
        if (B.isEmpty() == false) goto L17;
    L18:
        B = r10;     // Catch: Throwable -> L46 SecurityException -> L48
        C = SystemClock.elapsedRealtime();     // Catch: Throwable -> L46 SecurityException -> L48
    L19:
        this.f10465k = null;     // Catch: Throwable -> L46 SecurityException -> L48
        ArrayList r13 = new ArrayList();     // Catch: Throwable -> L46 SecurityException -> L48
        this.f10471q = "";     // Catch: Throwable -> L46 SecurityException -> L48
        this.f10464j = h();     // Catch: Throwable -> L46 SecurityException -> L48
        if (c(this.f10464j) == false) goto L29;
        f3 r14 = this.f10464j;     // Catch: Throwable -> L46 SecurityException -> L48
        if (r14.f10413c != null) goto L28;
        WifiInfo r15 = r14.f10411a;     // Catch: Throwable -> L46 SecurityException -> L48
        if (r15 != null) goto L26;
        String r16 = null;
    L27:
        r14.f10413c = r16;     // Catch: Throwable -> L46 SecurityException -> L48
        goto L28
    L26:
        r16 = r15.getBSSID();     // Catch: Throwable -> L46 SecurityException -> L48
    L28:
        this.f10471q = r14.f10413c;     // Catch: Throwable -> L46 SecurityException -> L48
    L29:
        if (r8 != null) goto L31;
    L44:
        this.f10470p.b(r13);     // Catch: Throwable -> L46 SecurityException -> L48
        return r13;
    L31:
        if (r8.size() <= 0) goto L44;
        int r17 = r8.size();     // Catch: Throwable -> L46 SecurityException -> L48
        int r18 = 0;
    L33:
        if (r18 >= r17) goto L44;
        ScanResult r19 = r8.get(r18);     // Catch: Throwable -> L46 SecurityException -> L48
        String r20 = r19.BSSID;     // Catch: Throwable -> L46 SecurityException -> L48
        if (TextUtils.isEmpty(this.f10471q) == false) goto L37;
    L39:
        boolean r21 = false;
    L40:
        n2 r22 = new n2(r21);     // Catch: Throwable -> L46 SecurityException -> L48
        r22.f10852b = r19.SSID;     // Catch: Throwable -> L46 SecurityException -> L48
        r22.f10854d = r19.frequency;     // Catch: Throwable -> L46 SecurityException -> L48
        r22.f10855e = r19.timestamp;     // Catch: Throwable -> L46 SecurityException -> L48
        r22.f10851a = n2.a(r19.BSSID);     // Catch: Throwable -> L46 SecurityException -> L48
        r22.f10853c = (short) r19.level;     // Catch: Throwable -> L46 SecurityException -> L48
        short r23 = (short) ((SystemClock.elapsedRealtime() - (r19.timestamp / 1000)) / 1000);     // Catch: Throwable -> L46 SecurityException -> L48
        r22.f10857g = r23;     // Catch: Throwable -> L46 SecurityException -> L48
        if (r23 >= 0) goto L43;
        r22.f10857g = 0;     // Catch: Throwable -> L46 SecurityException -> L48
    L43:
        r22.f10856f = SystemClock.elapsedRealtime();     // Catch: Throwable -> L46 SecurityException -> L48
        r13.add(r22);     // Catch: Throwable -> L46 SecurityException -> L48
        r18 = r18 + 1;     // Catch: Throwable -> L46 SecurityException -> L48
        goto L33
    L37:
        if (this.f10471q.equals(r20) == false) goto L39;
        r21 = true;
        goto L40
    L17:
        if (B.equals(r10) == true) goto L19;
    L7:
        t3.g("OPENSDK_WMW", "gsr_n_aws", new Exception("gst_n_aws"));     // Catch: Throwable -> L46 SecurityException -> L48
        r8 = null;
        goto L8
    }

    public final boolean j() {
        long r8 = SystemClock.elapsedRealtime() - f10451w;
        if (r8 >= 4900) goto L5;
        return false;
    L5:
        ConnectivityManager r10 = this.f10473s;
        Context r11 = this.f10458d;
        if (r10 != null) goto L9;
        this.f10473s = (ConnectivityManager) y3.d(r11, "connectivity");
    L9:
        if (b(this.f10473s) == false) goto L14;
        if (r8 >= 9900) goto L14;
        return false;
    L14:
        if (D <= 1) goto L25;
        long r12 = this.f10474t;
        if (r12 != 30000) goto L23;
        r12 = s3.f11085v;
        if (r12 != (-1)) goto L23;
        r12 = 30000;
    L23:
        if (r8 >= r12) goto L25;
        return false;
    L25:
        WifiManager r13 = this.f10455a;
        if (r13 == null) goto L35;
        f10451w = SystemClock.elapsedRealtime();
        int r14 = D;
        if (r14 >= 2) goto L31;
        D = r14 + 1;
    L31:
        if (y3.y(r11, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF") == true) goto L33;
        t3.g("OPENSDK_WMW", "wfs_n_cws", new Exception("n_cws"));
        goto L35
    L33:
        return r13.startScan();
    L35:
        return false;
    }
}
