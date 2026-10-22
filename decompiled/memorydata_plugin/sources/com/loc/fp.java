package com.loc;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Xml;
import android.view.WindowManager;
import com.bytedance.apm6.util.proc.CommonProcUtil;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.rpc.internal.RpcUtils;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.Map;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes3.dex */
public final class fp {
    private static boolean A = false;
    private static String B = "";
    private static boolean C = false;
    private static String D = "";
    private static String E = "";
    private static String F = "";
    private static boolean G = false;
    private static boolean H = false;
    private static String I = "";

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static boolean f5576J = false;
    private static boolean K = false;
    private static long L = 0;
    private static int M = 0;
    private static String N = null;
    private static String O = "";
    private static boolean P = true;
    private static boolean Q = false;
    private static String R = "";
    private static boolean S = false;
    private static int T = -1;
    private static boolean U = false;
    private static int V = -1;
    private static boolean W = false;
    private static volatile b X = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f5577a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static String f5578b = "";
    static volatile boolean c = true;
    public static boolean d = false;
    static String e = "";
    static boolean f = false;
    public static a g = null;
    static int h = -1;
    static String i = "";
    static String j = "";
    private static String k = null;
    private static boolean l = false;
    private static String m = "";
    private static volatile boolean n = false;
    private static String o = "";
    private static boolean p = false;
    private static boolean q = true;
    private static String r = null;
    private static IBinder s = null;
    private static boolean t = false;
    private static boolean u = false;
    private static String v = "";
    private static String w = "";
    private static boolean x = false;
    private static boolean y = false;
    private static String z = "";

    public interface a {
        bo a(byte[] r1, Map<String, String> r2);

        String a();

        String a(Context r1, String r2);

        String a(String r1, String r2, String r3, String r4);

        Map<String, String> b();
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Context f5581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static PluginBroadcastReceiver f5582b;
        private static ConnectivityManager c;
        private static NetworkRequest d;
        private static ConnectivityManager.NetworkCallback e;

        static {
        }

        public b() {
        }

        public final void a(Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            if (Build.VERSION.SDK_INT >= 24) goto L10;
            if (r5 != null) goto L6;
            return;
        L6:
            if (f5582b != null) goto L20;
            f5582b = new AnonymousClass1(this);
            IntentFilter r3 = new IntentFilter();
            r3.addAction(fx.c("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF"));
            ZeusTransformUtils.registerReceiver(r5, f5582b, r3, "com.obric.memorydata.plugin");
            return;
        L20:
            return;
        L10:
            if (fp.a(r5, fx.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == true) goto L12;
            return;
        L12:
            if (r5 != null) goto L14;
            return;
        L14:
            if (c != null) goto L22;
            ConnectivityManager r0 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(r5.getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");
            c = r0;
            if (r0 == null) goto L23;
            d = new NetworkRequest.Builder().addCapability(12).addTransportType(1).addTransportType(0).build();
            ConnectivityManager.NetworkCallback r1 = new AnonymousClass2(this);
            e = r1;
            c.registerNetworkCallback(d, r1);
            f5581a = r5;
            return;
        L23:
            return;
        }
    }

    static class c implements ServiceConnection {
        c() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r1, IBinder r2) {
            fp.a((IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.memorydata.plugin"));
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r1) {
        }
    }

    static {
    }

    private static String A(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(I) == false) goto L5;
        String r3 = z.b(r7, "open_common", "a1", "");     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r3) == false) goto L9;
        I = "amap" + UUID.randomUUID().toString().replace("_", "").toLowerCase();     // Catch: Throwable -> L12
        SharedPreferences.Editor r8 = z.a(r7, "open_common");     // Catch: Throwable -> L12
        z.a(r8, "a1", fx.b(I));     // Catch: Throwable -> L12
        z.a(r8);     // Catch: Throwable -> L12
    L11:
        return I;
    L9:
        I = fx.c(r3);     // Catch: Throwable -> L12
        goto L11
    L13:
        return I;
    L5:
        return I;
    }

    private static String B(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (S == true) goto L5;
        K(r3);
        TelephonyManager r4 = F(r3);
        if (r4 == null) goto L9;
        String r0 = r4.getSimOperatorName();
        R = r0;
        if (TextUtils.isEmpty(r0) == false) goto L13;
        R = r4.getNetworkOperatorName();
    L13:
        S = true;
        return R;
    L9:
        return R;
    L5:
        return R;
    }

    private static int C(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (U == true) goto L5;
        K(r3);
        if (r3 == null) goto L22;
        if (b(r3, fx.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == false) goto L22;
        ConnectivityManager r4 = D(r3);
        if (r4 == null) goto L14;
        NetworkInfo r5 = r4.getActiveNetworkInfo();
        if (r5 != null) goto L19;
        U = true;
        return T;
    L19:
        int r6 = r5.getType();
        T = r6;
        U = true;
        return r6;
    L14:
        return T;
    L22:
        return T;
    L5:
        return T;
    }

    private static ConnectivityManager D(Context r2) {
        return (ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");
    }

    private static int E(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (W == true) goto L5;
        K(r3);
        if (b(r3, fx.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == false) goto L9;
        ConnectivityManager r4 = D(r3);
        if (r4 == null) goto L13;
        NetworkInfo r5 = r4.getActiveNetworkInfo();
        if (r5 == null) goto L20;
        if (r5.isAvailable() == false) goto L20;
        V = r5.getSubtype();
        W = true;
    L20:
        return V;
    L13:
        return V;
    L9:
        return V;
    L5:
        return V;
    }

    private static TelephonyManager F(Context r2) {
        return (TelephonyManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSystemService(MemoryKeyInfoEntity.KEY_PHONE), TelephonyManager.class, "com.obric.memorydata.plugin");
    }

    private static String G(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        if (c == true) goto L5;
        return "";
    L5:
        String r1 = null;
        r1 = H(r7);     // Catch: Throwable -> L15
    L8:
        if (TextUtils.isEmpty(r1) == false) goto L16;
        c = false;
        return "";
    L16:
        byte[] r8 = fx.c("MAAAAAAAAAAAAAAAAAAAAAA").getBytes(RpcUtils.CHARSET_UTF8);     // Catch: Throwable -> L13
        byte[] r2 = fq.b(r1);     // Catch: Throwable -> L13
        return new String(fq.a(fx.c("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes(RpcUtils.CHARSET_UTF8), r2, r8), RpcUtils.CHARSET_UTF8);
    L13:
        c = false;
        return "";
    }

    private static String H(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        String r1 = I(r4);     // Catch: Throwable -> L5
    L7:
        if (TextUtils.isEmpty(r1) == true) goto L9;
        return r1;
    L9:
        if (r4 != null) goto L12;
        return "";
    L12:
        return r4.getSharedPreferences(fx.c("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(ft.a(fx.c("RYW1hcF9kZXZpY2VfYWRpdQ")), "");
    L5:
        r1 = "";
        goto L7
    }

    private static String I(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        String r1 = ft.a(fx.c("LYW1hcF9kZXZpY2VfYWRpdQ"));
        String r10 = J(r9);
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return "";
    L5:
        File r2 = new File(r10 + File.separator + fx.c("KYmFja3Vwcw"), fx.c("MLmFkaXU"));
        if (r2.exists() == true) goto L8;
    L39:
        return "";
    L8:
        if (r2.canRead() == false) goto L39;
        if (r2.length() != 0) goto L14;
        r2.delete();
        return "";
    L14:
        ByteArrayOutputStream r11 = null;
        RandomAccessFile r4 = new RandomAccessFile(r2, "r");     // Catch: Throwable -> L36
        byte[] r3 = new byte[1024];     // Catch: Throwable -> L40
        ByteArrayOutputStream r5 = new ByteArrayOutputStream();     // Catch: Throwable -> L40
    L41:
        int r12 = r4.read(r3);     // Catch: Throwable -> L35
        if (r12 == (-1)) goto L21;
        r5.write(r3, 0, r12);     // Catch: Throwable -> L35
        goto L41
    L21:
        String r13 = new String(r5.toByteArray(), RpcUtils.CHARSET_UTF8);     // Catch: Throwable -> L35
        if (TextUtils.isEmpty(r13) == false) goto L24;
    L34:
        a(r5);
    L38:
        a(r4);
        goto L39
    L24:
        if (r13.contains(fx.c("SIw")) == false) goto L34;
        String[] r14 = r13.split(fx.c("SIw"));     // Catch: Throwable -> L35
        if (r14 == null) goto L34;
        if (r14.length != 2) goto L34;
        if (TextUtils.equals(r1, r14[0]) == false) goto L34;
        String r15 = r14[1];     // Catch: Throwable -> L35
        a(r5);
        a(r4);
        return r15;
    L35:
        r11 = r5;
    L37:
        a(r11);
    L36:
        r4 = null;
        goto L37
    }

    private static String J(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 8) goto L6;
        File r1 = r4.getExternalCacheDir();     // Catch: Exception -> L13
    L7:
        if (r1 != null) goto L9;
        r1 = r4.getCacheDir();     // Catch: Exception -> L13
    L9:
        if (r1 == null) goto L12;
        return r1.getAbsolutePath();
    L6:
        r1 = null;
    L12:
        return null;
    }

    private static synchronized b K(Context r4) {
        monitor-enter(fp.class);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (X != null) goto L11;
        if (r5 == null) goto L8;
        b r1 = new b();     // Catch: Throwable -> L14
        X = r1;     // Catch: Throwable -> L14
        r1.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
        goto L11
    L8:
        monitor-exit(fp.class);
        return null;
    L11:
        b r6 = X;     // Catch: Throwable -> L14
        monitor-exit(fp.class);
        return r6;
    L14:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ IBinder a(IBinder r2) {
        IBinder r3 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.memorydata.plugin");
        s = r3;
        return r3;
    }

    public static String a() {
        return k;
    }

    public static String a(Context r3) {
        final Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(f5578b) == false) goto L6;
        if (r4 != null) goto L9;
        return "";
    L9:
        String r1 = G(r4);     // Catch: Throwable -> L21
        f5578b = r1;     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r1) == true) goto L14;
        return f5578b;
    L14:
        if (c() != null) goto L17;
        return "";
    L17:
        if (n == false) goto L19;
        return "";
    L19:
        n = true;     // Catch: Throwable -> L21
        bp.a().b(new AnonymousClass1(r4));     // Catch: Throwable -> L21
        goto L20
    L6:
        return f5578b;
    L20:
        return "";
    }

    private static String a(Context r13, int r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        Intent r2 = new Intent();     // Catch: Throwable -> L46
        if (r14 == 2) goto L11;
        if (r14 == 4) goto L10;
        if (r14 == 5) goto L9;
        p = true;     // Catch: Throwable -> L46
        return o;
    L9:
        r2.setClassName(fx.c("YY29tLmhleXRhcC5vcGVuaWQ"), fx.c("SY29tLmhleXRhcC5vcGVuaWQuSWRlbnRpZnlTZXJ2aWNl"));     // Catch: Throwable -> L46
        r2.setAction(fx.c("EYWN0aW9uLmNvbS5oZXl0YXAub3BlbmlkLk9QRU5fSURfU0VSVklDRQ"));     // Catch: Throwable -> L46
    L12:
        c r6 = new c();     // Catch: Throwable -> L46
        if (ZeusTransformUtils.bindService(r15, r2, r6, 1, "com.obric.memorydata.plugin") == false) goto L45;
        int r7 = 0;
    L16:
        if (r7 >= 100) goto L43;
        if (TextUtils.isEmpty(o) == false) goto L43;
        r7 = r7 + 1;     // Catch: Throwable -> L46
        if (s == null) goto L42;
        Parcel r8 = Parcel.obtain();     // Catch: Throwable -> L46
        Parcel r9 = Parcel.obtain();     // Catch: Throwable -> L46
        if (r14 == 2) goto L29;
        if (r14 == 4) goto L27;
        if (r14 == 5) goto L26;
        boolean r10 = false;
    L31:
        if (r10 == true) goto L51;
    L33:
        r9.recycle();     // Catch: Throwable -> L46
    L34:
        r8.recycle();     // Catch: Throwable -> L46
        goto L42
    L51:
        s.transact(1, r8, r9, 0);     // Catch: Throwable -> L36
        r9.readException();     // Catch: Throwable -> L36
        o = r9.readString();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        n.a(th, "oac", String.valueOf(r14));     // Catch: Throwable -> L39
        r9.recycle();     // Catch: Throwable -> L46
        goto L34
    L39:
        th = move-exception;
        r9.recycle();     // Catch: Throwable -> L46
        r8.recycle();     // Catch: Throwable -> L46
        throw th;     // Catch: Throwable -> L46
    L26:
        r8.writeInterfaceToken(fx.c("KY29tLmhleXRhcC5vcGVuaWQuSU9wZW5JRA"));     // Catch: Throwable -> L36
        r8.writeString(r15.getPackageName());     // Catch: Throwable -> L36
        r8.writeString(w(r15));     // Catch: Throwable -> L36
        r8.writeString(fx.c("IT1VJRA"));     // Catch: Throwable -> L36
    L30:
        r10 = true;
        goto L31
    L27:
        String r11 = fx.c("UY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuSURldmljZUlkU2VydmljZQ");     // Catch: Throwable -> L36
    L28:
        r8.writeInterfaceToken(r11);     // Catch: Throwable -> L36
        goto L30
    L29:
        r11 = fx.c("UY29tLnVvZGlzLm9wZW5kZXZpY2UuYWlkbC5PcGVuRGV2aWNlSWRlbnRpZmllclNlcnZpY2U");     // Catch: Throwable -> L36
    L42:
        Thread.sleep(15);     // Catch: Throwable -> L46
    L43:
        ZeusTransformUtils.unbindService(r15, r6, "com.obric.memorydata.plugin");     // Catch: Throwable -> L46
        s = null;     // Catch: Throwable -> L46
    L45:
        return o;
    L10:
        r2.setClassName(fx.c("WY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2U"), fx.c("QY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuRGV2aWNlSWRTZXJ2aWNl"));     // Catch: Throwable -> L46
        goto L12
    L11:
        r2.setAction(fx.c("WY29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF"));     // Catch: Throwable -> L46
        r2.setPackage(fx.c("UY29tLmh1YXdlaS5od2lk"));     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        n.a(th, "oa", String.valueOf(r14));
        p = true;
        return o;
    }

    public static void a(a r2) {
        a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
        if (g != null) goto L6;
        g = r3;
        return;
    }

    private static void a(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        r3.close();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void a(String r0) {
        k = r0;
    }

    static /* synthetic */ boolean a(Context r2, String r3) {
        return b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3);
    }

    public static String b() {
        if (TextUtils.isEmpty(e) == false) goto L6;
        a r1 = g;     // Catch: Throwable -> L12
        if (r1 != null) goto L11;
        return "";
    L11:
        return r1.a();
    L6:
        return e;
    L14:
        return "";
    }

    public static String b(Context r2) {
        return B((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    L5:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    private static boolean b(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.checkCallingOrSelfPermission(r3) != 0) goto L10;
        return true;
    L10:
        return false;
    }

    public static int c(Context r2) {
        return E((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    L5:
        th = move-exception;
        th.printStackTrace();
        return -1;
    }

    public static a c() {
        return g;
    }

    public static int d(Context r2) {
        return C((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    L5:
        th = move-exception;
        th.printStackTrace();
        return -1;
    }

    public static String d() {
        if (Build.VERSION.SDK_INT < 29) goto L13;
        return "";
    L13:
        String r0 = n();     // Catch: Throwable -> L10
        if (r0.length() >= 5) goto L8;
        return "";
    L8:
        return r0.substring(3, 5);
    L10:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public static String e() {
        return "";
    }

    public static String e(Context r2) {
        final Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (q == true) goto L8;
        return "";
    L8:
        if (p == false) goto L11;
        return "";
    L11:
        if (TextUtils.isEmpty(o) == true) goto L15;
        return o;
    L15:
        if (t == false) goto L19;
        return o;
    L19:
        if (Looper.getMainLooper() != Looper.myLooper()) goto L21;
        bp.a().b(new AnonymousClass2(r3));     // Catch: Throwable -> L25
        goto L24
    L21:
        t = true;     // Catch: Throwable -> L25
        return z(r3);
    L24:
        return o;
    }

    public static String f() {
        return "";
    }

    public static String f(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (u == false) goto L36;
        String r6 = f5577a;
        if (r6 != null) goto L7;
        return "";
    L7:
        return r6;
    L36:
        String r2 = f5577a;     // Catch: Throwable -> L31
        if (r2 == null) goto L16;
        if ("".equals(r2) == true) goto L16;
        return f5577a;
    L16:
        if (b(r5, fx.c("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT")) == false) goto L19;
        f5577a = Settings.System.getString(r5.getContentResolver(), "mqBRboGZkQPcAkyk");     // Catch: Throwable -> L31
    L19:
        if (TextUtils.isEmpty(f5577a) == true) goto L37;
        u = true;     // Catch: Throwable -> L31
        return f5577a;
    L37:
        String r3 = u(r5);     // Catch: Throwable -> L32
        f5577a = r3;     // Catch: Throwable -> L32
        if (TextUtils.isEmpty(r3) == true) goto L34;
        u = true;     // Catch: Throwable -> L32
        return f5577a;
    L34:
        f5577a = v(r5);     // Catch: Throwable -> L33
        u = true;     // Catch: Throwable -> L33
    L27:
        String r7 = f5577a;
        if (r7 != null) goto L30;
        return "";
    L30:
        return r7;
    }

    public static String g() {
        return "";
    }

    static String g(Context r3) {
        TelephonyManager r4 = F((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L13
        if (r4 != null) goto L6;
        return "";
    L6:
        String r5 = r4.getNetworkOperator();     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r5) == false) goto L9;
        return "";
    L9:
        if (r5.length() < 3) goto L17;
        return r5.substring(0, 3);
    L17:
        return "";
    L18:
        return "";
    }

    public static String h() {
        return z;
    }

    static String h(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (C == true) goto L5;
        K(r4);     // Catch: Throwable -> L20
        TelephonyManager r5 = F(r4);     // Catch: Throwable -> L20
        if (r5 == null) goto L9;
        String r6 = r5.getNetworkOperator();     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r6) == false) goto L13;
    L16:
        C = true;     // Catch: Throwable -> L20
        return B;
    L13:
        if (r6.length() < 3) goto L16;
        B = r6.substring(3);     // Catch: Throwable -> L20
        C = true;     // Catch: Throwable -> L20
        goto L19
    L9:
        return B;
    L19:
        return B;
    L5:
        return B;
    }

    public static int i(Context r2) {
        return E((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    L5:
        return -1;
    }

    static String[] i() {
        return new String[]{"", ""};
    }

    public static int j(Context r2) {
        return C((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    L5:
        return -1;
    }

    public static String j() {
        return i;
    }

    public static NetworkInfo k(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (b(r3, fx.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == true) goto L5;
        return null;
    L5:
        ConnectivityManager r4 = D(r3);
        if (r4 != null) goto L9;
        return null;
    L9:
        return r4.getActiveNetworkInfo();
    }

    public static String k() {
        return E;
    }

    static String l(Context r2) {
        NetworkInfo r3 = k((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L8
        if (r3 != null) goto L6;
        return null;
    L6:
        return r3.getExtraInfo();
    L11:
        return null;
    }

    public static void l() {
        m.a();     // Catch: Throwable -> L4
        return;
    }

    public static String m() {
        return "";
    }

    static String m(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        String r0 = D;     // Catch: Throwable -> L22
        if (r0 != null) goto L7;
    L10:
        DisplayMetrics r1 = new DisplayMetrics();     // Catch: Throwable -> L22
        WindowManager r6 = (WindowManager) ZeusTransformUtils.preCheckCast(r5.getSystemService("window"), WindowManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (r6 != null) goto L13;
        return "";
    L13:
        r6.getDefaultDisplay().getMetrics(r1);     // Catch: Throwable -> L22
        int r7 = r1.widthPixels;     // Catch: Throwable -> L22
        int r2 = r1.heightPixels;     // Catch: Throwable -> L22
        if (r2 <= r7) goto L18;
        StringBuilder r8 = new StringBuilder().append(r7).append("*").append(r2);     // Catch: Throwable -> L22
    L19:
        D = r8.toString();     // Catch: Throwable -> L22
        goto L21
    L18:
        r8 = new StringBuilder().append(r2).append("*").append(r7);     // Catch: Throwable -> L22
        goto L19
    L7:
        if ("".equals(r0) == true) goto L10;
        return D;
    L21:
        return D;
    }

    public static String n() {
        return "";
    }

    public static String n(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
    L12:
        return "";
    L4:
        if (b(r4, fx.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) == false) goto L6;
        TelephonyManager r5 = F(r4);     // Catch: Throwable -> L12
        if (r5 != null) goto L11;
        return "";
    L11:
        return r5.getNetworkOperatorName();
    L6:
        return O;
    }

    public static long o() {
        long r0 = L;
        if (r0 == 0) goto L13;
        return r0;
    L13:
        StatFs r1 = new StatFs(Environment.getRootDirectory().getAbsolutePath());     // Catch: Throwable -> L12
        StatFs r2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());     // Catch: Throwable -> L12
        if (Build.VERSION.SDK_INT < 18) goto L8;
        long r3 = (r1.getBlockCountLong() * r1.getBlockSizeLong()) / 1048576;     // Catch: Throwable -> L12
        long r6 = (r2.getBlockCountLong() * r2.getBlockSizeLong()) / 1048576;     // Catch: Throwable -> L12
    L9:
        L = r3 + r6;     // Catch: Throwable -> L12
        goto L11
    L8:
        r3 = (((long) r1.getBlockCount()) * ((long) r1.getBlockSize())) / 1048576;     // Catch: Throwable -> L12
        r6 = (((long) r2.getBlockCount()) * ((long) r2.getBlockSize())) / 1048576;     // Catch: Throwable -> L12
    L11:
        return L;
    }

    public static String o(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
    L14:
        return "";
    L4:
        if (b(r4, fx.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == true) goto L6;
        return "";
    L6:
        ConnectivityManager r5 = D(r4);     // Catch: Throwable -> L14
        if (r5 != null) goto L9;
        return "";
    L9:
        NetworkInfo r6 = r5.getActiveNetworkInfo();     // Catch: Throwable -> L14
        if (r6 != null) goto L12;
        return "";
    L12:
        return r6.getTypeName();
    }

    public static String p() {
        if (TextUtils.isEmpty(N) == false) goto L5;
        String r0 = System.getProperty("os.arch");
        N = r0;
        return r0;
    L5:
        return N;
    }

    public static String p(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        String r0 = k();     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r0) == false) goto L8;
        r0 = a(r3);     // Catch: Throwable -> L22
    L8:
        if (TextUtils.isEmpty(r0) == false) goto L11;
        r0 = f(r3);     // Catch: Throwable -> L22
    L11:
        if (TextUtils.isEmpty(r0) == false) goto L14;
        r0 = e(r3);     // Catch: Throwable -> L22
    L14:
        if (TextUtils.isEmpty(r0) == false) goto L17;
        r0 = g();     // Catch: Throwable -> L22
    L17:
        if (TextUtils.isEmpty(r0) == false) goto L27;
        return A(r3);
    L27:
        return r0;
    L29:
        return r0;
    L20:
        return "";
    }

    public static String q(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        return k() + "#" + a(r4) + "#" + p(r4);
    }

    public static void q() {
        T = -1;
        U = false;
        V = -1;
        W = false;
        R = "";
        S = false;
        B = "";
        C = false;
    }

    public static int r(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        int r0 = M;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        int r3 = 0;
        if (Build.VERSION.SDK_INT < 16) goto L11;
        ActivityManager r6 = (ActivityManager) ZeusTransformUtils.preCheckCast(r5.getSystemService("activity"), ActivityManager.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L10;
        return 0;
    L10:
        ActivityManager.MemoryInfo r1 = new ActivityManager.MemoryInfo();
        r6.getMemoryInfo(r1);
        r3 = (int) (r1.totalMem / 1024);
    L18:
        int r7 = r3 / 1024;
        M = r7;
        return r7;
    L11:
        BufferedReader r8 = null;
        BufferedReader r2 = new BufferedReader(new FileReader(new File(CommonProcUtil.MEMORY_INFO_PATH)));     // Catch: Throwable -> L21
        r3 = Integer.valueOf(r2.readLine().split("\\s+")[1]).intValue();     // Catch: Throwable -> L15
        r2.close();     // Catch: IOException -> L20
    L24:
    L15:
        r8 = r2;
    L16:
        if (r8 == null) goto L18;
        r8.close();     // Catch: IOException -> L20
        goto L24
    }

    static /* synthetic */ boolean r() {
        t = true;
        return true;
    }

    static String s(Context r2) {
        return B((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    L5:
        return "";
    }

    static /* synthetic */ String t(Context r2) {
        return z((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    private static String u(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        String r2 = z.b(r5, "Alvin2", "UTDID2", "");     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return z.b(r5, "Alvin2", "UTDID", "");
    L10:
        return r2;
    L7:
        return "";
    }

    private static String v(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        FileInputStream r0 = null;
        if (Build.VERSION.SDK_INT <= 8) goto L35;
        File r1 = new File(r9.getExternalCacheDir().getAbsolutePath() + "/.UTSystemConfig/Global/Alvin2.xml");     // Catch: Throwable -> L44
        XmlPullParser r10 = Xml.newPullParser();     // Catch: Throwable -> L44
        int r2 = r10.getEventType();     // Catch: Throwable -> L44
        FileInputStream r3 = new FileInputStream(r1);     // Catch: Throwable -> L44
        r10.setInput(r3, "utf-8");     // Catch: Throwable -> L34
        boolean r4 = false;
    L8:
        if (1 == r2) goto L33;
        if (r2 == 2) goto L22;
        if (r2 != 3) goto L14;
        r4 = false;
    L31:
        r2 = r10.next();     // Catch: Throwable -> L34
        goto L8
    L14:
        if (r2 != 4) goto L31;
        if (r4 == false) goto L31;
        String r11 = r10.getText();     // Catch: Throwable -> L34
        r3.close();     // Catch: Throwable -> L42
    L19:
        return r11;
    L22:
        if (r10.getAttributeCount() <= 0) goto L31;
        int r5 = r10.getAttributeCount();     // Catch: Throwable -> L34
        int r6 = 0;
    L24:
        if (r6 >= r5) goto L31;
        String r7 = r10.getAttributeValue(r6);     // Catch: Throwable -> L34
        if ("UTDID2".equals(r7) == false) goto L28;
    L29:
        r4 = true;
    L30:
        r6 = r6 + 1;     // Catch: Throwable -> L34
        goto L24
    L28:
        if ("UTDID".equals(r7) == false) goto L30;
    L33:
        r0 = r3;
    L34:
        r0 = r3;
    L35:
        if (r0 != null) goto L47;
        return "";
    L47:
        r0.close();     // Catch: Throwable -> L43
        return "";
    L64:
        return "";
    L38:
        if (r0 != null) goto L47;
        return "";
    }

    private static String w(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
    L15:
        return "";
    L4:
        if (TextUtils.isEmpty(r) == false) goto L6;
        Signature[] r7 = r6.getPackageManager().getPackageInfo(r6.getPackageName(), 64).signatures;     // Catch: Throwable -> L15
        int r0 = 0;
        byte[] r8 = r7[0].toByteArray();     // Catch: Throwable -> L15
        byte[] r9 = MessageDigest.getInstance(fx.c("IU0hBMQ")).digest(r8);     // Catch: Throwable -> L15
        StringBuffer r1 = new StringBuffer();     // Catch: Throwable -> L15
    L9:
        if (r0 >= r9.length) goto L11;
        r1.append(Integer.toHexString((r9[r0] & 255) | 256).substring(1, 3));     // Catch: Throwable -> L15
        r0 = r0 + 1;     // Catch: Throwable -> L15
        goto L9
    L11:
        String r10 = r1.toString();     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r10) == true) goto L14;
        r = r10;     // Catch: Throwable -> L15
    L14:
        return r10;
    L6:
        return r;
    }

    private static String x(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Class r2 = ZeusTransformUtils.forName(fx.c("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"), "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        Object r3 = r2.newInstance();     // Catch: Throwable -> L7
        Object r10 = r2.getMethod(fx.c("MZ2V0T0FJRA"), new Class[]{Context.class}).invoke(r3, new Object[]{r9});     // Catch: Throwable -> L7
        if (r10 == null) goto L10;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        o = r11;     // Catch: Throwable -> L7
        return r11;
    L10:
        return o;
    L7:
        th = move-exception;
        n.a(th, "oa", "xm");
        p = true;
        goto L10
    }

    private static String y(Context r7) {
        Cursor r8 = ZeusProviderTransform.query(((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin")).getContentResolver(), Uri.parse(fx.c("QY29udGVudDovL2NvbS52aXZvLnZtcy5JZFByb3ZpZGVyL0lkZW50aWZpZXJJZC9PQUlE")), null, null, null, null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r8 == null) goto L18;
    L6:
        if (r8.moveToNext() == false) goto L13;
        int r0 = r8.getColumnCount();     // Catch: Throwable -> L15
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L6;
        if (fx.c("IdmFsdWU").equals(r8.getColumnName(r1)) == true) goto L11;
        r1 = r1 + 1;     // Catch: Throwable -> L15
        goto L8
    L11:
        o = r8.getString(r1);     // Catch: Throwable -> L15
        goto L6
    L13:
        r8.close();     // Catch: Throwable -> L15
    L18:
        return o;
    L15:
        th = move-exception;
        p = true;
        n.a(th, "oa", DimLocationCheckUtil.VIVO);
        goto L18
    }

    private static String z(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (fx.c("IeGlhb21p").equalsIgnoreCase(Build.MANUFACTURER) == true) goto L50;
        if (fx.c("IeGlhb21p").equalsIgnoreCase(Build.BRAND) == true) goto L50;
        if (fx.c("IUkVETUk=").equalsIgnoreCase(Build.MANUFACTURER) == true) goto L50;
        if (fx.c("IUkVETUk=").equalsIgnoreCase(Build.BRAND) == true) goto L50;
        if (fx.c("Idml2bw").equalsIgnoreCase(Build.MANUFACTURER) == true) goto L48;
        if (fx.c("Idml2bw").equalsIgnoreCase(Build.BRAND) == true) goto L48;
        if (fx.c("IaHVhd2Vp").equalsIgnoreCase(Build.MANUFACTURER) == true) goto L46;
        if (fx.c("IaHVhd2Vp").equalsIgnoreCase(Build.BRAND) == true) goto L46;
        if (fx.c("ISE9OT1I=").equalsIgnoreCase(Build.MANUFACTURER) == true) goto L46;
        if (fx.c("Mc2Ftc3VuZw").equalsIgnoreCase(Build.MANUFACTURER) == true) goto L44;
        if (fx.c("Mc2Ftc3VuZw").equalsIgnoreCase(Build.BRAND) == true) goto L44;
        if (fx.c("IT1BQTw").equalsIgnoreCase(Build.MANUFACTURER) == true) goto L42;
        if (fx.c("IT1BQTw").equalsIgnoreCase(Build.BRAND) == true) goto L42;
        if (fx.c("MT25lUGx1cw").equalsIgnoreCase(Build.MANUFACTURER) == true) goto L42;
        if (fx.c("MT25lUGx1cw").equalsIgnoreCase(Build.BRAND) == true) goto L42;
        if (fx.c("IUkVBTE1F").equalsIgnoreCase(Build.BRAND) == true) goto L42;
        p = true;
        return o;
    L42:
        return a(r4, 5);
    L44:
        return a(r4, 4);
    L46:
        return a(r4, 2);
    L48:
        return y(r4);
    L50:
        return x(r4);
    }
}
