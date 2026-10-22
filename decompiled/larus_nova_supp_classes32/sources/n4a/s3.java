package n4a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.AutoEndConversationTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class s3 {
    public static long A;
    public static HashMap<String, Long> B;
    public static long C;
    public static int D;
    public static long E;
    public static long w;
    public static long x;
    public static long y;
    public static long z;
    public final WifiManager a;
    public ArrayList<v2> b;
    public final ArrayList<v2> c;
    public final Context d;
    public boolean e;
    public StringBuilder f;
    public boolean g;
    public boolean h;
    public boolean i;
    public volatile r3 j;
    public String k;
    public TreeMap<Integer, v2> l;
    public boolean m;
    public boolean n;
    public boolean o;
    public final q3 p;
    public String q;
    public long r;
    public ConnectivityManager s;
    public long t;
    public d3 u;
    public volatile boolean v;

    static {
        B = new HashMap(36);
        C = 0;
        D = 0;
        E = 0;
    }

    public final boolean b(ConnectivityManager r4) {
    L8:
        th = move-exception;
        c4.g(th, "WifiManagerWrapper", "wifiAccess");
        return false;
    L4:
        if (j4.d(r4.getActiveNetworkInfo()) != 1) goto L13;
        if (c(j()) == false) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    }

    public final WifiInfo e() {
    L11:
        th = move-exception;
        c4.g(th, "WifiManagerWrapper", "getConnectionInfo");
        return null;
    L4:
        if (this.a != null) goto L6;
        return null;
    L6:
        if (j4.A(this.d, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF") == true) goto L8;
        c4.g(new Exception("gci_n_aws"), "OPENSDK_WMW", "gci_n_aws");     // Catch: Throwable -> L11
        return null;
    L8:
        return f(this.a);
    }

    public final ArrayList<v2> i() {
        if (this.b != null) goto L6;
        return null;
    L6:
        ArrayList<v2> r0 = new ArrayList();
        if (this.b.isEmpty() == true) goto L9;
        r0.addAll(this.b);
    L9:
        return r0;
    }

    public final boolean a() {
        if (this.a != null) goto L5;
        boolean r0 = false;
    L6:
        this.m = r0;
        if (j4.A(this.d, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF") == false) goto L11;
        this.n = this.a.isWifiEnabled();     // Catch: Throwable -> L28
    L11:
        if (this.m == true) goto L14;
        return false;
    L14:
        if (this.g == true) goto L17;
        return false;
    L17:
        if (y != 0) goto L20;
    L26:
        return true;
    L20:
        if ((SystemClock.elapsedRealtime() - y) >= 4900) goto L23;
        return false;
    L23:
        if ((SystemClock.elapsedRealtime() - z) < 1500) goto L34;
        SystemClock.elapsedRealtime();
        goto L26
    L34:
        return false;
    L5:
        r0 = j4.G(this.d);
        goto L6
    }

    public final r3 j() {
        if (j4.A(this.d, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF") == false) goto L6;
        this.n = this.a.isWifiEnabled();     // Catch: Throwable -> L14
    L6:
        if (this.n == true) goto L10;
        return null;
    L10:
        if (this.j != null) goto L13;
        this.j = new r3(e());
    L13:
        return this.j;
    }

    public final List<v2> k() {
        if (this.a != null) goto L47;
    L46:
        return null;
    L47:
    L44:
        e = move-exception;
        this.k = e.getMessage();
    L42:
        th = move-exception;
        this.k = null;
        c4.g(th, "WifiManagerWrapper", "getScanResults");
        goto L46
    L5:
        if (j4.A(this.d, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF") == false) goto L7;
        List r0 = g(this.a);     // Catch: Throwable -> L42 SecurityException -> L44
    L8:
        HashMap<String, Long> r2 = new HashMap(36);     // Catch: Throwable -> L42 SecurityException -> L44
        if (r0 == null) goto L15;
        Iterator r3 = r0.iterator();     // Catch: Throwable -> L42 SecurityException -> L44
    L12:
        if (r3.hasNext() == false) goto L15;
        ScanResult r4 = (ScanResult) r3.next();     // Catch: Throwable -> L42 SecurityException -> L44
        r2.put(r4.BSSID, Long.valueOf(r4.timestamp));     // Catch: Throwable -> L42 SecurityException -> L44
    L15:
        if (B.isEmpty() == false) goto L17;
    L18:
        B = r2;     // Catch: Throwable -> L42 SecurityException -> L44
        C = SystemClock.elapsedRealtime();     // Catch: Throwable -> L42 SecurityException -> L44
    L19:
        this.k = null;     // Catch: Throwable -> L42 SecurityException -> L44
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L42 SecurityException -> L44
        this.q = NameKeys.UnloadStrategy_No_Strategy;     // Catch: Throwable -> L42 SecurityException -> L44
        this.j = j();     // Catch: Throwable -> L42 SecurityException -> L44
        if (c(this.j) == false) goto L25;
        r3 r6 = this.j;     // Catch: Throwable -> L42 SecurityException -> L44
        if (r6.c != null) goto L24;
        r6.c = p3.a(r6.a);     // Catch: Throwable -> L42 SecurityException -> L44
    L24:
        this.q = r6.c;     // Catch: Throwable -> L42 SecurityException -> L44
    L25:
        if (r0 != null) goto L27;
    L40:
        this.p.b(r5);     // Catch: Throwable -> L42 SecurityException -> L44
        return r5;
    L27:
        if (r0.size() <= 0) goto L40;
        int r7 = r0.size();     // Catch: Throwable -> L42 SecurityException -> L44
        int r8 = 0;
    L29:
        if (r8 >= r7) goto L40;
        ScanResult r9 = (ScanResult) ListProtector.get(r0, r8);     // Catch: Throwable -> L42 SecurityException -> L44
        String r10 = r9.BSSID;     // Catch: Throwable -> L42 SecurityException -> L44
        if (TextUtils.isEmpty(this.q) == false) goto L33;
    L35:
        boolean r11 = false;
    L36:
        v2 r12 = new v2(r11);     // Catch: Throwable -> L42 SecurityException -> L44
        r12.b = r9.SSID;     // Catch: Throwable -> L42 SecurityException -> L44
        r12.d = r9.frequency;     // Catch: Throwable -> L42 SecurityException -> L44
        r12.e = r9.timestamp;     // Catch: Throwable -> L42 SecurityException -> L44
        r12.a = v2.a(r9.BSSID);     // Catch: Throwable -> L42 SecurityException -> L44
        r12.c = (short) r9.level;     // Catch: Throwable -> L42 SecurityException -> L44
        short r13 = (short) ((SystemClock.elapsedRealtime() - (r9.timestamp / 1000)) / 1000);     // Catch: Throwable -> L42 SecurityException -> L44
        r12.g = r13;     // Catch: Throwable -> L42 SecurityException -> L44
        if (r13 >= 0) goto L39;
        r12.g = 0;     // Catch: Throwable -> L42 SecurityException -> L44
    L39:
        r12.f = SystemClock.elapsedRealtime();     // Catch: Throwable -> L42 SecurityException -> L44
        r5.add(r12);     // Catch: Throwable -> L42 SecurityException -> L44
        r8 = r8 + 1;     // Catch: Throwable -> L42 SecurityException -> L44
        goto L29
    L33:
        if (this.q.equals(r10) == false) goto L35;
        r11 = true;
        goto L36
    L17:
        if (B.equals(r2) == true) goto L19;
    L7:
        c4.g(new Exception("gst_n_aws"), "OPENSDK_WMW", "gsr_n_aws");     // Catch: Throwable -> L42 SecurityException -> L44
        r0 = null;
        goto L8
    }

    public final boolean l() {
        long r1 = SystemClock.elapsedRealtime() - w;
        if (r1 >= 4900) goto L6;
        return false;
    L6:
        if (this.s != null) goto L9;
        this.s = (ConnectivityManager) j4.e(this.d, "connectivity");
    L9:
        if (b(this.s) == false) goto L14;
        if (r1 >= 9900) goto L14;
        return false;
    L14:
        if (D <= 1) goto L28;
        long r6 = this.t;
        if (r6 != AutoEndConversationTime.AFTER_30_SECONDS) goto L23;
        r6 = com.loc.h.v;
        if (r6 != (-1)) goto L23;
        r6 = 30000;
    L23:
        if (Build.VERSION.SDK_INT < 28) goto L28;
        if (r1 >= r6) goto L28;
        return false;
    L28:
        if (this.a == null) goto L63;
        w = SystemClock.elapsedRealtime();
        int r2 = D;
        if (r2 >= 2) goto L33;
        D = r2 + 1;
    L33:
        if (j4.A(this.d, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF") == false) goto L53;
        WifiManager r3 = this.a;
        ArrayList r4 = new ArrayList();
        Object[] r5 = new Object[0];
        f06.b r7 = new f06.b();
        g06.a r8 = (g06.a) ApiHookConfig.b.get(102302);
        if (r8 == null) goto L37;
        f06.a[] r9 = r8.i;
    L38:
        f06.a[] r13 = r9;
        int r12 = r13.length;
        int r11 = 0;
    L40:
        if (r11 >= r12) goto L47;
        f06.a r10 = r13[r11];
        int r17 = r11;
        int r18 = r12;
        f06.a[] r19 = r13;
        f06.d r14 = r10.preInvoke(102302, "android/net/wifi/WifiManager", "startScan", r3, r5, "boolean", r7);     // Catch: Exception -> L56
        if (r14.a == true) goto L49;
        r4.add(r10);     // Catch: Exception -> L56
    L49:
        if (r14.a == false) goto L52;
        return ((Boolean) r14.b).booleanValue();
    L52:
        return r3.startScan();
    L46:
        r11 = r17 + 1;
        r12 = r18;
        r13 = r19;
        goto L40
    L47:
        r14 = new f06.d(false, null);
        goto L49
    L37:
        r9 = ApiHookConfig.d;
        goto L38
    L53:
        c4.g(new Exception("n_cws"), "OPENSDK_WMW", "wfs_n_cws");
        return false;
    L63:
        return false;
    }

    public static boolean c(r3 r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.a != null) goto L9;
        return false;
    L9:
        if (TextUtils.isEmpty(r2.a()) == false) goto L12;
        return false;
    L12:
        if (r2.c != null) goto L15;
        r2.c = p3.a(r2.a);
    L15:
        if (j4.n(r2.c) == false) goto L21;
        return true;
    L21:
        return false;
    }

    public static WifiInfo f(WifiManager r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102301);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(102301, "android/net/wifi/WifiManager", "getConnectionInfo", r18, r10, "android.net.wifi.WifiInfo", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (WifiInfo) r4.b;
    L21:
        return r18.getConnectionInfo();
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static List g(WifiManager r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(102300, "android/net/wifi/WifiManager", "getScanResults", r13, r9, "java.util.List", r10);
        if (r11.a == false) goto L6;
        r8.a(102300, "android/net/wifi/WifiManager", "getScanResults", r13, r9, null, r10, false);
        return (List) r11.b;
    L6:
        List<ScanResult> r12 = r13.getScanResults();
        r8.a(102300, "android/net/wifi/WifiManager", "getScanResults", r13, r9, r12, r10, true);
        return r12;
    }

    public final void d(boolean r9) {
        if (r9 == false) goto L27;
        if (a() == false) goto L34;
        long r2 = SystemClock.elapsedRealtime();
        if ((r2 - x) < AutoEndConversationTime.AFTER_10_SECONDS) goto L10;
        this.b.clear();
        A = z;
    L10:
        if (a() == false) goto L18;
    L15:
        th = move-exception;
        c4.g(th, "WifiManager", "wifiScan");
        goto L18
    L12:
        if (l() == false) goto L18;
        y = SystemClock.elapsedRealtime();     // Catch: Throwable -> L15
    L18:
        if ((r2 - x) < AutoEndConversationTime.AFTER_10_SECONDS) goto L34;
        int r10 = 20;
    L20:
        if (r10 <= 0) goto L34;
        if (z != A) goto L34;
        Thread.sleep(150);     // Catch: Throwable -> L74
    L25:
        r10 = r10 - 1;
    L34:
        List<v2> r0 = null;
        boolean r3 = false;
        if (this.v == false) goto L56;
        this.v = false;
        WifiManager r11 = this.a;     // Catch: Throwable -> L54
        if (r11 == null) goto L56;
        int r12 = r11.getWifiState();     // Catch: Throwable -> L43
    L46:
        if (this.b != null) goto L48;
        this.b = new ArrayList();     // Catch: Throwable -> L54
    L48:
        if (r12 == 0) goto L52;
        if (r12 == 1) goto L52;
        if (r12 != 4) goto L56;
    L52:
        this.j = null;     // Catch: Throwable -> L54
        this.b.clear();     // Catch: Throwable -> L54
    L43:
        th = move-exception;
        c4.g(th, "OPENSDK_WMW", "cwsc");     // Catch: Throwable -> L54
        r12 = 4;
    L56:
        if (A == z) goto L65;
        r0 = k();     // Catch: Throwable -> L59
    L61:
        A = z;
        this.b.clear();
        if (r0 == null) goto L65;
        this.b.addAll(r0);
    L59:
        th = move-exception;
        c4.g(th, "WifiManager", "updateScanResult");
    L65:
        if ((SystemClock.elapsedRealtime() - z) <= AutoEndConversationTime.AFTER_20_SECONDS) goto L67;
        this.b.clear();
    L67:
        x = SystemClock.elapsedRealtime();
        if (this.b.isEmpty() == false) goto L72;
        z = SystemClock.elapsedRealtime();
        List<v2> r13 = k();
        if (r13 == null) goto L72;
        this.b.addAll(r13);
        r3 = true;
    L72:
        h(r3);
        return;
    L27:
        if (a() == false) goto L34;
    L32:
        th = move-exception;
        c4.g(th, "WifiManager", "wifiScan");
        goto L34
    L29:
        if (l() == false) goto L34;
        y = SystemClock.elapsedRealtime();     // Catch: Throwable -> L32
        goto L34
    }

    public final void h(boolean r9) {
        ArrayList<v2> r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == false) goto L8;
        return;
    L8:
        if ((SystemClock.elapsedRealtime() - z) <= 3600000) goto L11;
        this.j = null;
        this.b.clear();
    L11:
        if (this.l != null) goto L13;
        this.l = new TreeMap(Collections.reverseOrder());
    L13:
        this.l.clear();
        if (this.o == false) goto L17;
        if (r9 == false) goto L17;
        this.c.clear();     // Catch: Throwable -> L54
    L17:
        int r1 = this.b.size();
        this.r = 0;
        int r2 = 0;
    L18:
        if (r2 >= r1) goto L48;
        v2 r3 = (v2) ListProtector.get(this.b, r2);
        if (r3.h == false) goto L23;
        this.r = r3.f;
    L23:
        if (j4.n(v2.b(r3.a)) == false) goto L47;
        int r4 = 20;
        if (r1 <= 20) goto L36;
        r4 = WifiManager.calculateSignalLevel(r3.c, 20);     // Catch: ArithmeticException -> L29
    L31:
        if (r4 <= 0) goto L33;
        boolean r5 = true;
    L34:
        if (r5 == false) goto L47;
    L33:
        r5 = false;
    L29:
        e = move-exception;
        c4.g(e, "Aps", "wifiSigFine");
    L36:
        if (this.o == false) goto L40;
        if (r9 == false) goto L40;
        this.c.add(r3);
    L40:
        if (TextUtils.isEmpty(r3.b) == false) goto L42;
        String r6 = "unkwn";
    L45:
        r3.b = r6;
    L46:
        this.l.put(Integer.valueOf((r3.c * 25) + r2), r3);
        goto L47
    L42:
        if ("<unknown ssid>".equals(r3.b) == true) goto L46;
        r6 = String.valueOf(r2);
    L47:
        r2 = r2 + 1;
        goto L18
    L48:
        this.b.clear();
        Iterator<v2> r10 = this.l.values().iterator();
    L50:
        if (r10.hasNext() == false) goto L52;
        v2 r7 = r10.next();
        this.b.add(r7);
        goto L50
    L52:
        this.l.clear();
    }

    public s3(Context r6, WifiManager r7, Handler r8) {
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.e = false;
        this.f = null;
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = true;
        this.n = true;
        this.o = false;
        this.q = NameKeys.UnloadStrategy_No_Strategy;
        this.r = 0;
        this.s = null;
        this.t = AutoEndConversationTime.AFTER_30_SECONDS;
        this.v = false;
        this.a = r7;
        this.d = r6;
        q3 r9 = new q3(r6, r8);
        this.p = r9;
        if (r9.b == true) goto L7;
        Handler r10 = r9.d;
        if (r10 == null) goto L7;
        r10.removeCallbacks(r9.g);
        r9.d.postDelayed(r9.g, AutoEndConversationTime.AFTER_60_SECONDS);
    L7:
        r9.b = true;
    }
}
