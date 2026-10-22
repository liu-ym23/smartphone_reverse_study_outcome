package r5;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f11502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f11503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile long f11504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f11505d;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f11506b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f11507m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f11508n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final a f11509o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final a f11510p = null;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final a f11511q = null;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final a f11512r = null;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final a f11513s = null;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final a f11514t = null;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final a f11515u = null;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final a f11516v = null;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final a f11517w = null;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final /* synthetic */ a[] f11518x = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11519a;

        static {
            a r8 = new a(BdimCategoryConstants.VALUE_UNKNOWN, 0, -1);
            f11506b = r8;
            a r10 = new a(BdimCategoryConstants.VALUE_NONE, 1, 0);
            f11507m = r10;
            a r11 = new a("MOBILE", 2, 1);
            f11508n = r11;
            a r12 = new a("MOBILE_2G", 3, 2);
            f11509o = r12;
            a r13 = new a("MOBILE_3G", 4, 3);
            f11510p = r13;
            a r14 = new a("WIFI", 5, 4);
            f11511q = r14;
            a r15 = new a("MOBILE_4G", 6, 5);
            f11512r = r15;
            a r16 = new a("MOBILE_5G", 7, 6);
            f11513s = r16;
            a r17 = new a("WIFI_24GHZ", 8, 7);
            f11514t = r17;
            a r18 = new a("WIFI_5GHZ", 9, 8);
            f11515u = r18;
            a r19 = new a("MOBILE_3G_H", 10, 9);
            f11516v = r19;
            a r110 = new a("MOBILE_3G_HP", 11, 10);
            f11517w = r110;
            f11518x = new a[]{r8, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110};
        }

        public a(String r8, int r10, int r11) {
            super(r8, r10);
            this.f11519a = r11;
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f11518x.clone();
        }
    }

    static {
        f11502a = a.f11506b;
        f11503b = false;
        f11504c = 2000;
        f11505d = 0;
    }

    public static void a(Application r8) {
        if (f11503b == true) goto L7;
        if (r8 == null) goto L7;
        IntentFilter r10 = new IntentFilter();
        r10.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        r10.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        r10.addAction("android.net.wifi.STATE_CHANGE");
        r8.getApplicationContext().registerReceiver(new d(), r10);
        f11503b = true;
    L7:
        if (f11502a != a.f11506b) goto L10;
        f11502a = d(r8);
        return;
    }

    public static String b(Context r8) {
        a r10 = d(r8);
        if (r10 != a.f11511q) goto L6;
        return "wifi";
    L6:
        if (r10 != a.f11514t) goto L9;
        return "wifi24ghz";
    L9:
        if (r10 != a.f11515u) goto L12;
        return "wifi5ghz";
    L12:
        if (r10 != a.f11509o) goto L15;
        return "2g";
    L15:
        if (r10 != a.f11510p) goto L18;
        return "3g";
    L18:
        if (r10 != a.f11516v) goto L21;
        return "3gh";
    L21:
        if (r10 != a.f11517w) goto L24;
        return "3ghp";
    L24:
        if (r10 != a.f11512r) goto L27;
        return "4g";
    L27:
        if (r10 != a.f11513s) goto L30;
        return "5g";
    L30:
        if (r10 != a.f11508n) goto L32;
        return "mobile";
    L32:
        return "";
    }

    public static a c(Context r8) {
        return d(r8);
    }

    public static a d(Context r8) {
        NetworkInfo r10 = ((ConnectivityManager) r8.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L34
        if (r10 == null) goto L33;
        if (r10.isAvailable() == false) goto L33;
        int r11 = r10.getType();     // Catch: Throwable -> L34
        if (1 == r11) goto L10;
        if (r11 != 0) goto L31;
        int r12 = ((TelephonyManager) r8.getSystemService("phone")).getNetworkType();     // Catch: Throwable -> L34
        if (r12 == 3) goto L29;
        if (r12 == 20) goto L27;
        if (r12 == 5) goto L29;
        if (r12 == 6) goto L29;
        switch(r12) {
            case 8: goto L29;
            case 9: goto L29;
            case 10: goto L29;
            default: goto L21;
        };     // Catch: Throwable -> L34
    L21:
        switch(r12) {
            case 12: goto L29;
            case 13: goto L25;
            case 14: goto L29;
            case 15: goto L29;
            default: goto L23;
        };     // Catch: Throwable -> L34
    L23:
        return a.f11508n;
    L25:
        return a.f11512r;
    L27:
        return a.f11513s;
    L29:
        return a.f11510p;
    L31:
        return a.f11508n;
    L10:
        return a.f11511q;
    L33:
        return a.f11507m;
    L35:
        return a.f11508n;
    }

    public static boolean e(Context r8) {
        NetworkInfo r10 = ((ConnectivityManager) r8.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r10 == null) goto L12;
        if (r10.isConnected() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }
}
