package qa;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Xml;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public final class k4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f10748a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f10749b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f10750c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f10751d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static c f10752e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f10753f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f10754g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f10755h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f10756i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static IBinder f10757j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f10758k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f10759l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f10760m = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f10761n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String f10762o = "";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static String f10763p = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static long f10764q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static int f10765r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static String f10766s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static String f10767t = "";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f10768u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static int f10769v = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static boolean f10770w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static int f10771x = -1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static boolean f10772y = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static volatile d f10773z;

    public class a extends m1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f10774b;

        public a(Context r8) {
            this.f10774b = r8;
        }

        @Override // qa.m1
        public final void a() {
            Context r8 = this.f10774b;
            HashMap r10 = ((g) k4.f10752e).c();     // Catch: Throwable -> L10
            c r11 = k4.f10752e;     // Catch: Throwable -> L10
            g r12 = (g) r11;     // Catch: Throwable -> L10
            String r13 = r12.b(k4.m(r8));     // Catch: Throwable -> L10
            if (TextUtils.isEmpty(r13) == false) goto L6;
            return;
        L6:
            h0.c();     // Catch: Throwable -> L10
            c r14 = k4.f10752e;     // Catch: Throwable -> L10
            byte[] r15 = r13.getBytes();     // Catch: Throwable -> L10
            ((g) r14).getClass();     // Catch: Throwable -> L10
            n0 r16 = h0.a(new g0(r15, r10));     // Catch: Throwable -> L10
            c r17 = k4.f10752e;     // Catch: Throwable -> L10
            g r18 = (g) r17;     // Catch: Throwable -> L10
            String r19 = r18.a(r8, new String(r16.f10842a));     // Catch: Throwable -> L10
            if (TextUtils.isEmpty(r19) == true) goto L13;
            k4.f10749b = r19;     // Catch: Throwable -> L10
            return;
        L13:
            return;
        }
    }

    public class b extends m1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f10775b;

        public b(Context r8) {
            this.f10775b = r8;
        }

        @Override // qa.m1
        public final void a() {
            k4.u(this.f10775b);
            k4.f10758k = true;
        }
    }

    public interface c {
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static ConnectivityManager f10776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static NetworkRequest f10777b;

        public class a extends ConnectivityManager.NetworkCallback {
            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network r8) {
                super.onAvailable(r8);
                k4.r();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network r8) {
                super.onLost(r8);
                k4.r();
            }
        }

        @SuppressLint({"WrongConstant"})
        public static void a(Context r8) {
            if (k4.k(r8, t4.n("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == true) goto L5;
            return;
        L5:
            if (r8 != null) goto L7;
            return;
        L7:
            if (f10776a != null) goto L13;
            ConnectivityManager r10 = (ConnectivityManager) r8.getSystemService("connectivity");
            f10776a = r10;
            if (r10 == null) goto L14;
            f10777b = new NetworkRequest.Builder().addCapability(12).addTransportType(1).addTransportType(0).build();
            a r11 = new a();
            f10776a.registerNetworkCallback(f10777b, r11);
            return;
        L14:
            return;
        }
    }

    public static class e implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r8, IBinder r10) {
            k4.f10757j = r10;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r8) {
        }
    }

    public static String a(Context r8) {
        if (TextUtils.isEmpty(f10763p) == false) goto L5;
        String r10 = z.k(r8, "open_common", "a1");     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r10) == false) goto L9;
        f10763p = "amap" + UUID.randomUUID().toString().replace("_", "").toLowerCase();     // Catch: Throwable -> L12
        SharedPreferences.Editor r11 = z.b(r8, "open_common");     // Catch: Throwable -> L12
        z.g(r11, "a1", t4.j(f10763p));     // Catch: Throwable -> L12
        z.e(r11);     // Catch: Throwable -> L12
    L11:
        return f10763p;
    L9:
        f10763p = t4.n(r10);     // Catch: Throwable -> L12
        goto L11
    L13:
        return f10763p;
    L5:
        return f10763p;
    }

    public static String b(Context r8) {
        if (f10768u == true) goto L5;
        g(r8);
        TelephonyManager r10 = (TelephonyManager) r8.getSystemService("phone");
        if (r10 == null) goto L9;
        String r11 = r10.getSimOperatorName();
        f10767t = r11;
        if (TextUtils.isEmpty(r11) == false) goto L13;
        f10767t = r10.getNetworkOperatorName();
    L13:
        f10768u = true;
        return f10767t;
    L9:
        return f10767t;
    L5:
        return f10767t;
    }

    public static int c(Context r8) {
        if (f10770w == true) goto L5;
        g(r8);
        if (r8 == null) goto L22;
        if (k(r8, t4.n("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == false) goto L22;
        ConnectivityManager r10 = (ConnectivityManager) r8.getSystemService("connectivity");
        if (r10 == null) goto L14;
        NetworkInfo r11 = r10.getActiveNetworkInfo();
        if (r11 != null) goto L19;
        f10770w = true;
        return f10769v;
    L19:
        int r12 = r11.getType();
        f10769v = r12;
        f10770w = true;
        return r12;
    L14:
        return f10769v;
    L22:
        return f10769v;
    L5:
        return f10769v;
    }

    public static int d(Context r8) {
        if (f10772y == true) goto L5;
        g(r8);
        if (k(r8, t4.n("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == false) goto L9;
        ConnectivityManager r10 = (ConnectivityManager) r8.getSystemService("connectivity");
        if (r10 == null) goto L13;
        NetworkInfo r11 = r10.getActiveNetworkInfo();
        if (r11 == null) goto L20;
        if (r11.isAvailable() == false) goto L20;
        f10771x = r11.getSubtype();
        f10772y = true;
    L20:
        return f10771x;
    L13:
        return f10771x;
    L9:
        return f10771x;
    L5:
        return f10771x;
    }

    public static String e(Context r8) {
        if (f10750c == true) goto L29;
        return "";
    L29:
        String r10 = f(r8);     // Catch: Throwable -> L8
    L27:
    L16:
        r10 = null;
    L18:
        if (TextUtils.isEmpty(r10) == false) goto L25;
        f10750c = false;
        return "";
    L25:
        byte[] r11 = t4.n("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");     // Catch: Throwable -> L23
        byte[] r12 = l4.e(r10);     // Catch: Throwable -> L23
        return new String(l4.c(t4.n("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), r12, r11), "UTF-8");
    L23:
        f10750c = false;
        return "";
    L10:
        if (TextUtils.isEmpty(r10) == false) goto L18;
        if (r8 != null) goto L14;
        r10 = "";
        goto L18
    L14:
        r10 = r8.getSharedPreferences(t4.n("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(l6.a.j(t4.n("RYW1hcF9kZXZpY2VfYWRpdQ")), "");     // Catch: Throwable -> L16
    L8:
        r10 = "";
        goto L27
    }

    public static String f(Context r10) {
        String r8 = l6.a.j(t4.n("LYW1hcF9kZXZpY2VfYWRpdQ"));
        ByteArrayOutputStream r11 = null;
        File r12 = r10.getExternalCacheDir();     // Catch: Exception -> L48
        if (r12 != null) goto L6;
        r12 = r10.getCacheDir();     // Catch: Exception -> L48
    L6:
        if (r12 == null) goto L9;
        String r13 = r12.getAbsolutePath();     // Catch: Exception -> L48
    L11:
        if (TextUtils.isEmpty(r13) == false) goto L13;
        return "";
    L13:
        StringBuilder r14 = android.aimedia.a.j(r13);
        r14.append(File.separator);
        r14.append(t4.n("KYmFja3Vwcw"));
        File r15 = new File(r14.toString(), t4.n("MLmFkaXU"));
        if (r15.exists() == true) goto L16;
    L46:
        return "";
    L16:
        if (r15.canRead() == false) goto L46;
        if (r15.length() != 0) goto L51;
        r15.delete();
        return "";
    L51:
        RandomAccessFile r16 = new RandomAccessFile(r15, "r");     // Catch: Throwable -> L43
        byte[] r17 = new byte[1024];     // Catch: Throwable -> L47
        ByteArrayOutputStream r18 = new ByteArrayOutputStream();     // Catch: Throwable -> L47
    L49:
        int r19 = r16.read(r17);     // Catch: Throwable -> L42
        if (r19 == (-1)) goto L28;
        r18.write(r17, 0, r19);     // Catch: Throwable -> L42
        goto L49
    L28:
        String r20 = new String(r18.toByteArray(), "UTF-8");     // Catch: Throwable -> L42
        if (TextUtils.isEmpty(r20) == false) goto L31;
    L41:
        j(r18);
    L45:
        j(r16);
        goto L46
    L31:
        if (r20.contains(t4.n("SIw")) == false) goto L41;
        String[] r21 = r20.split(t4.n("SIw"));     // Catch: Throwable -> L42
        if (r21 == null) goto L41;
        if (r21.length != 2) goto L41;
        if (TextUtils.equals(r8, r21[0]) == false) goto L41;
        String r22 = r21[1];     // Catch: Throwable -> L42
        j(r18);
        j(r16);
        return r22;
    L42:
        r11 = r18;
    L44:
        j(r11);
    L43:
        r16 = null;
    L9:
        r13 = null;
        goto L11
    }

    public static synchronized void g(Context r8) {
        monitor-enter(k4.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f10773z != null) goto L10;
        if (r8 != null) goto L9;
        monitor-exit(k4.class);
        return;
    L9:
        f10773z = new d();     // Catch: Throwable -> L12
        d.a(r8.getApplicationContext());     // Catch: Throwable -> L12
    L10:
        monitor-exit(k4.class);
    }

    public static String h(Context r8) {
        if (TextUtils.isEmpty(f10749b) == false) goto L6;
        if (r8 != null) goto L9;
        return "";
    L9:
        String r10 = e(r8);     // Catch: Throwable -> L21
        f10749b = r10;     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r10) == true) goto L14;
        return f10749b;
    L14:
        if (f10752e != null) goto L17;
        return "";
    L17:
        if (f10753f == false) goto L19;
        return "";
    L19:
        f10753f = true;     // Catch: Throwable -> L21
        l1.f10784d.a(new a(r8));     // Catch: Throwable -> L21
        goto L20
    L6:
        return f10749b;
    L20:
        return "";
    }

    public static String i(Context r12, int r13) {
        Intent r8 = new Intent();     // Catch: Throwable -> L46
        if (r13 == 2) goto L11;
        if (r13 == 4) goto L10;
        if (r13 == 5) goto L9;
        f10755h = true;     // Catch: Throwable -> L46
        return f10754g;
    L9:
        r8.setClassName(t4.n("YY29tLmhleXRhcC5vcGVuaWQ"), t4.n("SY29tLmhleXRhcC5vcGVuaWQuSWRlbnRpZnlTZXJ2aWNl"));     // Catch: Throwable -> L46
        r8.setAction(t4.n("EYWN0aW9uLmNvbS5oZXl0YXAub3BlbmlkLk9QRU5fSURfU0VSVklDRQ"));     // Catch: Throwable -> L46
    L12:
        e r10 = new e();     // Catch: Throwable -> L46
        if (r12.bindService(r8, r10, 1) == false) goto L45;
        int r11 = 0;
    L16:
        if (r11 >= 100) goto L43;
        if (TextUtils.isEmpty(f10754g) == false) goto L43;
        r11 = r11 + 1;     // Catch: Throwable -> L46
        if (f10757j == null) goto L42;
        Parcel r14 = Parcel.obtain();     // Catch: Throwable -> L46
        Parcel r15 = Parcel.obtain();     // Catch: Throwable -> L46
        if (r13 == 2) goto L29;
        if (r13 == 4) goto L27;
        if (r13 == 5) goto L26;
        boolean r16 = false;
    L31:
        if (r16 == true) goto L51;
    L33:
        r15.recycle();     // Catch: Throwable -> L46
    L34:
        r14.recycle();     // Catch: Throwable -> L46
        goto L42
    L51:
        f10757j.transact(1, r14, r15, 0);     // Catch: Throwable -> L36
        r15.readException();     // Catch: Throwable -> L36
        f10754g = r15.readString();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        l.a("oac", String.valueOf(r13), th);     // Catch: Throwable -> L39
        r15.recycle();     // Catch: Throwable -> L46
        goto L34
    L39:
        th = move-exception;
        r15.recycle();     // Catch: Throwable -> L46
        r14.recycle();     // Catch: Throwable -> L46
        throw th;     // Catch: Throwable -> L46
    L26:
        r14.writeInterfaceToken(t4.n("KY29tLmhleXRhcC5vcGVuaWQuSU9wZW5JRA"));     // Catch: Throwable -> L36
        r14.writeString(r12.getPackageName());     // Catch: Throwable -> L36
        r14.writeString(t(r12));     // Catch: Throwable -> L36
        r14.writeString(t4.n("IT1VJRA"));     // Catch: Throwable -> L36
    L30:
        r16 = true;
        goto L31
    L27:
        String r17 = t4.n("UY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuSURldmljZUlkU2VydmljZQ");     // Catch: Throwable -> L36
    L28:
        r14.writeInterfaceToken(r17);     // Catch: Throwable -> L36
        goto L30
    L29:
        r17 = t4.n("UY29tLnVvZGlzLm9wZW5kZXZpY2UuYWlkbC5PcGVuRGV2aWNlSWRlbnRpZmllclNlcnZpY2U");     // Catch: Throwable -> L36
    L42:
        Thread.sleep(15);     // Catch: Throwable -> L46
    L43:
        r12.unbindService(r10);     // Catch: Throwable -> L46
        f10757j = null;     // Catch: Throwable -> L46
    L45:
        return f10754g;
    L10:
        r8.setClassName(t4.n("WY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2U"), t4.n("QY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuRGV2aWNlSWRTZXJ2aWNl"));     // Catch: Throwable -> L46
        goto L12
    L11:
        r8.setAction(t4.n("WY29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF"));     // Catch: Throwable -> L46
        r8.setPackage(t4.n("UY29tLmh1YXdlaS5od2lk"));     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        l.a("oa", String.valueOf(r13), th);
        f10755h = true;
        return f10754g;
    }

    public static void j(Closeable r8) {
        if (r8 == null) goto L8;
        r8.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static boolean k(Context r8, String r10) {
        if (r8 != null) goto L4;
        return false;
    L4:
        if (r8.checkCallingOrSelfPermission(r10) != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static String l(Context r8) {
        if (f10755h == false) goto L7;
        return "";
    L7:
        if (TextUtils.isEmpty(f10754g) == true) goto L11;
        return f10754g;
    L11:
        if (f10758k == false) goto L15;
        return f10754g;
    L15:
        if (Looper.getMainLooper() != Looper.myLooper()) goto L17;
        l1.f10784d.a(new b(r8));     // Catch: Throwable -> L21
        goto L20
    L17:
        f10758k = true;     // Catch: Throwable -> L21
        return u(r8);
    L20:
        return f10754g;
    }

    public static String m(Context r8) {
        if (f10759l == false) goto L46;
        String r10 = f10748a;
        if (r10 != null) goto L7;
        return "";
    L7:
        return r10;
    L46:
        String r11 = f10748a;     // Catch: Throwable -> L37
        if (r11 == null) goto L16;
        if ("".equals(r11) == true) goto L16;
        return f10748a;
    L16:
        if (k(r8, t4.n("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT")) == false) goto L19;
        f10748a = Settings.System.getString(r8.getContentResolver(), "mqBRboGZkQPcAkyk");     // Catch: Throwable -> L37
    L19:
        if (TextUtils.isEmpty(f10748a) == true) goto L42;
        f10759l = true;     // Catch: Throwable -> L37
        return f10748a;
    L42:
        String r12 = z.k(r8, "Alvin2", "UTDID2");     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r12) == false) goto L40;
        r12 = z.k(r8, "Alvin2", "UTDID");     // Catch: Throwable -> L27
    L40:
        f10748a = r12;     // Catch: Throwable -> L38
        if (TextUtils.isEmpty(r12) == true) goto L44;
        f10759l = true;     // Catch: Throwable -> L38
        return f10748a;
    L44:
        f10748a = s(r8);     // Catch: Throwable -> L39
        f10759l = true;     // Catch: Throwable -> L39
    L33:
        String r13 = f10748a;
        if (r13 != null) goto L36;
        return "";
    L36:
        return r13;
    L27:
        r12 = "";
        goto L40
    }

    public static int n(Context r8) {
        return c(r8);
    L4:
        return -1;
    }

    public static NetworkInfo o(Context r8) {
        if (k(r8, t4.n("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == true) goto L5;
        return null;
    L5:
        ConnectivityManager r10 = (ConnectivityManager) r8.getSystemService("connectivity");
        if (r10 != null) goto L9;
        return null;
    L9:
        return r10.getActiveNetworkInfo();
    }

    public static String p(Context r8) {
    L14:
        return "";
    L4:
        if (k(r8, t4.n("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == true) goto L6;
        return "";
    L6:
        ConnectivityManager r10 = (ConnectivityManager) r8.getSystemService("connectivity");     // Catch: Throwable -> L14
        if (r10 != null) goto L9;
        return "";
    L9:
        NetworkInfo r11 = r10.getActiveNetworkInfo();     // Catch: Throwable -> L14
        if (r11 != null) goto L12;
        return "";
    L12:
        return r11.getTypeName();
    }

    public static String q(Context r8) {
        String r10 = "";
        if (TextUtils.isEmpty("") == false) goto L7;
        String r11 = h(r8);     // Catch: Throwable -> L24
    L25:
        if (TextUtils.isEmpty(r11) == false) goto L12;
        r11 = m(r8);     // Catch: Throwable -> L22
    L12:
        if (TextUtils.isEmpty(r11) == false) goto L14;
        r11 = l(r8);     // Catch: Throwable -> L22
    L14:
        if (TextUtils.isEmpty(r11) == true) goto L19;
        r10 = r11;
    L19:
        if (TextUtils.isEmpty(r10) == false) goto L29;
        return a(r8);
    L29:
        return r10;
    L23:
        return r11;
    L7:
        r11 = "";
    L31:
        return "";
    }

    public static void r() {
        f10769v = -1;
        f10770w = false;
        f10771x = -1;
        f10772y = false;
        f10767t = "";
        f10768u = false;
        f10760m = "";
        f10761n = false;
    }

    public static String s(Context r8) {
        File r10 = new File(r8.getExternalCacheDir().getAbsolutePath() + "/.UTSystemConfig/Global/Alvin2.xml");     // Catch: Throwable -> L32
        XmlPullParser r11 = Xml.newPullParser();     // Catch: Throwable -> L32
        int r12 = r11.getEventType();     // Catch: Throwable -> L32
        FileInputStream r13 = new FileInputStream(r10);     // Catch: Throwable -> L32
        r11.setInput(r13, "utf-8");     // Catch: Throwable -> L39
        boolean r14 = false;
    L5:
        if (1 != r12) goto L7;
    L46:
        r13.close();     // Catch: Throwable -> L38
        return "";
    L57:
        return "";
    L7:
        if (r12 == 2) goto L19;
        if (r12 != 3) goto L11;
        r14 = false;
    L28:
        r12 = r11.next();     // Catch: Throwable -> L39
        goto L5
    L11:
        if (r12 != 4) goto L28;
        if (r14 == false) goto L28;
        String r15 = r11.getText();     // Catch: Throwable -> L39
        r13.close();     // Catch: Throwable -> L37
    L16:
        return r15;
    L19:
        if (r11.getAttributeCount() <= 0) goto L28;
        int r16 = r11.getAttributeCount();     // Catch: Throwable -> L39
        int r17 = 0;
    L21:
        if (r17 >= r16) goto L28;
        String r18 = r11.getAttributeValue(r17);     // Catch: Throwable -> L39
        if ("UTDID2".equals(r18) == false) goto L25;
    L26:
        r14 = true;
    L27:
        r17 = r17 + 1;     // Catch: Throwable -> L39
        goto L21
    L25:
        if ("UTDID".equals(r18) == false) goto L27;
    L33:
        if (r13 != null) goto L46;
        return "";
    L32:
        r13 = null;
        goto L33
    }

    public static String t(Context r8) {
    L14:
        return "";
    L3:
        if (TextUtils.isEmpty(f10756i) == false) goto L5;
        Signature[] r10 = r8.getPackageManager().getPackageInfo(r8.getPackageName(), 64).signatures;     // Catch: Throwable -> L14
        int r11 = 0;
        byte[] r12 = r10[0].toByteArray();     // Catch: Throwable -> L14
        byte[] r13 = MessageDigest.getInstance(t4.n("IU0hBMQ")).digest(r12);     // Catch: Throwable -> L14
        StringBuffer r14 = new StringBuffer();     // Catch: Throwable -> L14
    L8:
        if (r11 >= r13.length) goto L10;
        r14.append(Integer.toHexString((r13[r11] & 255) | 256).substring(1, 3));     // Catch: Throwable -> L14
        r11 = r11 + 1;     // Catch: Throwable -> L14
        goto L8
    L10:
        String r15 = r14.toString();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r15) == true) goto L13;
        f10756i = r15;     // Catch: Throwable -> L14
    L13:
        return r15;
    L5:
        return f10756i;
    }

    public static String u(Context r12) {
        String r8 = t4.n("IeGlhb21p");
        String r10 = Build.MANUFACTURER;
        if (r8.equalsIgnoreCase(r10) == true) goto L71;
        String r11 = t4.n("IeGlhb21p");
        String r13 = Build.BRAND;
        if (r11.equalsIgnoreCase(r13) == true) goto L71;
        if (t4.n("IUkVETUk=").equalsIgnoreCase(r10) == true) goto L71;
        if (t4.n("IUkVETUk=").equalsIgnoreCase(r13) == true) goto L71;
        if (t4.n("Idml2bw").equalsIgnoreCase(r10) == false) goto L14;
    L73:
        Cursor r14 = r12.getContentResolver().query(Uri.parse(t4.n("QY29udGVudDovL2NvbS52aXZvLnZtcy5JZFByb3ZpZGVyL0lkZW50aWZpZXJJZC9PQUlE")), null, null, null, null);     // Catch: Throwable -> L59
        if (r14 == null) goto L62;
    L50:
        if (r14.moveToNext() == false) goto L57;
        int r15 = r14.getColumnCount();     // Catch: Throwable -> L59
        int r16 = 0;
    L52:
        if (r16 >= r15) goto L50;
        if (t4.n("IdmFsdWU").equals(r14.getColumnName(r16)) == true) goto L55;
        r16 = r16 + 1;     // Catch: Throwable -> L59
        goto L52
    L55:
        f10754g = r14.getString(r16);     // Catch: Throwable -> L59
        goto L50
    L57:
        r14.close();     // Catch: Throwable -> L59
    L62:
        return f10754g;
    L59:
        th = move-exception;
        f10755h = true;
        l.a("oa", DimLocationCheckUtil.VIVO, th);
        goto L62
    L14:
        if (t4.n("Idml2bw").equalsIgnoreCase(r13) == true) goto L73;
        if (t4.n("IaHVhd2Vp").equalsIgnoreCase(r10) == true) goto L46;
        if (t4.n("IaHVhd2Vp").equalsIgnoreCase(r13) == true) goto L46;
        if (t4.n("ISE9OT1I=").equalsIgnoreCase(r10) == true) goto L46;
        if (t4.n("Mc2Ftc3VuZw").equalsIgnoreCase(r10) == true) goto L44;
        if (t4.n("Mc2Ftc3VuZw").equalsIgnoreCase(r13) == true) goto L44;
        if (t4.n("IT1BQTw").equalsIgnoreCase(r10) == true) goto L42;
        if (t4.n("IT1BQTw").equalsIgnoreCase(r13) == true) goto L42;
        if (t4.n("MT25lUGx1cw").equalsIgnoreCase(r10) == true) goto L42;
        if (t4.n("MT25lUGx1cw").equalsIgnoreCase(r13) == true) goto L42;
        if (t4.n("IUkVBTE1F").equalsIgnoreCase(r13) == true) goto L42;
        f10755h = true;
        return f10754g;
    L42:
        return i(r12, 5);
    L44:
        return i(r12, 4);
    L46:
        return i(r12, 2);
    L71:
        Class<?> r17 = Class.forName(t4.n("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));     // Catch: Throwable -> L67
        Object r18 = r17.getMethod(t4.n("MZ2V0T0FJRA"), new Class[]{Context.class}).invoke(r17.newInstance(), new Object[]{r12});     // Catch: Throwable -> L67
        if (r18 == null) goto L70;
        String r19 = (String) r18;     // Catch: Throwable -> L67
        f10754g = r19;     // Catch: Throwable -> L67
        return r19;
    L70:
        return f10754g;
    L67:
        th = move-exception;
        l.a("oa", "xm", th);
        f10755h = true;
        goto L70
    }
}
