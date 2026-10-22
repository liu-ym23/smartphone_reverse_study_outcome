package n4a;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import android.os.RemoteException;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Xml;
import androidx.core.content.ContextCompat;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class x4 {
    public static String a = "";
    public static String b = "";
    public static volatile boolean c = true;
    public static String d = null;
    public static c e = null;
    public static volatile boolean f = false;
    public static String g = "";
    public static boolean h = false;
    public static String i = null;
    public static IBinder j = null;
    public static boolean k = false;
    public static boolean l = false;
    public static String m = "";
    public static boolean n = false;
    public static String o = "";
    public static String p = "";
    public static long q = 0;
    public static int r = 0;
    public static String s = null;
    public static String t = "";
    public static boolean u = false;
    public static int v = -1;
    public static boolean w = false;
    public static int x = -1;
    public static boolean y;
    public static volatile d z;

    public class a extends l1 {
        public final /* synthetic */ Context b;

        public a(Context r1) {
            this.b = r1;
        }

        @Override // n4a.l1
        public final void a() {
            Map<String, String> r0 = ((h) x4.e).c();     // Catch: Throwable -> L9
            c r1 = x4.e;     // Catch: Throwable -> L9
            h r2 = (h) r1;     // Catch: Throwable -> L9
            String r3 = r2.b(x4.q(this.b));     // Catch: Throwable -> L9
            if (TextUtils.isEmpty(r3) == false) goto L5;
            return;
        L5:
            com.loc.c.c();     // Catch: Throwable -> L9
            c r4 = x4.e;     // Catch: Throwable -> L9
            byte[] r5 = r3.getBytes();     // Catch: Throwable -> L9
            ((h) r4).getClass();     // Catch: Throwable -> L9
            l0 r6 = com.loc.c.a(new com.loc.b(r5, r0));     // Catch: Throwable -> L9
            c r7 = x4.e;     // Catch: Throwable -> L9
            h r8 = (h) r7;     // Catch: Throwable -> L9
            String r9 = r8.a(this.b, new String(r6.a));     // Catch: Throwable -> L9
            if (TextUtils.isEmpty(r9) == true) goto L12;
            x4.b = r9;     // Catch: Throwable -> L9
            return;
        L12:
            return;
        }
    }

    public class b extends l1 {
        public final /* synthetic */ Context b;

        public b(Context r1) {
            this.b = r1;
        }

        @Override // n4a.l1
        public final void a() {
            x4.y(this.b);
            x4.k = true;
        }
    }

    public interface c {
    }

    public static class d {
        public static a a;
        public static ConnectivityManager b;
        public static NetworkRequest c;

        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context r1, Intent r2) {
                if (f5.o("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF").equals(r2.getAction()) == false) goto L6;
                x4.v();
                return;
            }
        }

        public class b extends ConnectivityManager.NetworkCallback {
            public b() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network r1) {
                super.onAvailable(r1);
                x4.v();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network r1) {
                super.onLost(r1);
                x4.v();
            }
        }

        public d() {
        }

        public static void a(Context r10) {
            if (Build.VERSION.SDK_INT >= 24) goto L40;
            if (r10 != null) goto L6;
            return;
        L6:
            if (a != null) goto L58;
            a = new a();
            IntentFilter r0 = new IntentFilter();
            r0.addAction(f5.o("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF"));
            a r1 = a;
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L49;
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        L49:
        L33:
            e = move-exception;
            e.toString();
            e.printStackTrace();
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
            ReceiverRegisterCrashOptimizer.registerReceiver(r1, r0);
            return;
        L38:
            throw e;
        L11:
            if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L24;
            if (ReceiverRegisterAnrOptimizer.hasScreenActions(r0) == false) goto L24;
            int r3 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r1, r0, 0, null, null, 2, r10).result;     // Catch: Exception -> L33
            if (r3 != 1) goto L17;
            r10.registerReceiver(r1, r0);     // Catch: Exception -> L33
            return;
        L17:
            if (r3 != 2) goto L19;
            new Intent();     // Catch: Exception -> L33
            return;
        L19:
            if (r3 == 3) goto L50;
            r10.registerReceiver(r1, r0);     // Catch: Exception -> L33
            return;
        L50:
            return;
        L24:
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L27;
            ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
            r10.registerReceiver(r1, r0, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
            return;
        L27:
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L29;
        L31:
            r10.registerReceiver(r1, r0);     // Catch: Exception -> L33
            return;
        L29:
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r0) == false) goto L31;
            ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
            ContextCompat.registerReceiver(r10, r1, r0, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
            return;
        L58:
            return;
        L40:
            if (x4.m(r10, f5.o("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == true) goto L42;
            return;
        L42:
            if (r10 != null) goto L44;
            return;
        L44:
            if (b != null) goto L60;
            ConnectivityManager r11 = (ConnectivityManager) r10.getSystemService("connectivity");
            b = r11;
            if (r11 == null) goto L61;
            c = new NetworkRequest.Builder().addCapability(12).addTransportType(1).addTransportType(0).build();
            b r12 = new b();
            b.registerNetworkCallback(c, r12);
            return;
        L61:
            return;
        }
    }

    public static class e implements ServiceConnection {
        public e() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r1) {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r1, IBinder r2) {
            x4.j = r2;
        }
    }

    public static String a(Context r6) {
        if (TextUtils.isEmpty(p) == false) goto L5;
        String r3 = y.k(r6, "open_common", "a1");     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r3) == false) goto L9;
        p = "amap" + UUID.randomUUID().toString().replace("_", NameKeys.UnloadStrategy_No_Strategy).toLowerCase();     // Catch: Throwable -> L12
        SharedPreferences.Editor r7 = y.b(r6, "open_common");     // Catch: Throwable -> L12
        y.g(r7, "a1", f5.k(p));     // Catch: Throwable -> L12
        y.e(r7);     // Catch: Throwable -> L12
    L11:
        return p;
    L9:
        p = f5.o(r3);     // Catch: Throwable -> L12
        goto L11
    L13:
        return p;
    L5:
        return p;
    }

    public static synchronized void i(Context r2) {
        monitor-enter(x4.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (z != null) goto L10;
        if (r2 != null) goto L9;
        monitor-exit(x4.class);
        return;
    L9:
        z = new d();     // Catch: Throwable -> L12
        d.a(r2.getApplicationContext());     // Catch: Throwable -> L12
    L10:
        monitor-exit(x4.class);
    }

    public static String k(Context r12, int r13) {
        Intent r1 = new Intent();     // Catch: Throwable -> L47
        if (r13 == 2) goto L11;
        if (r13 == 4) goto L10;
        if (r13 == 5) goto L9;
        h = true;     // Catch: Throwable -> L47
        return g;
    L9:
        r1.setClassName(f5.o("YY29tLmhleXRhcC5vcGVuaWQ"), f5.o("SY29tLmhleXRhcC5vcGVuaWQuSWRlbnRpZnlTZXJ2aWNl"));     // Catch: Throwable -> L47
        r1.setAction(f5.o("EYWN0aW9uLmNvbS5oZXl0YXAub3BlbmlkLk9QRU5fSURfU0VSVklDRQ"));     // Catch: Throwable -> L47
    L12:
        e r5 = new e();     // Catch: Throwable -> L47
        if (r12.bindService(r1, r5, 1) == false) goto L46;
        int r6 = 0;
    L16:
        if (r6 >= 100) goto L44;
        if (TextUtils.isEmpty(g) == false) goto L44;
        r6 = r6 + 1;     // Catch: Throwable -> L47
        if (j == null) goto L43;
        Parcel r7 = Parcel.obtain();     // Catch: Throwable -> L47
        Parcel r8 = Parcel.obtain();     // Catch: Throwable -> L47
        if (r13 == 2) goto L29;
        if (r13 == 4) goto L27;
        if (r13 == 5) goto L26;
        boolean r9 = false;
    L32:
        if (r9 == true) goto L52;
    L34:
        r8.recycle();     // Catch: Throwable -> L47
        r7.recycle();     // Catch: Throwable -> L47
        goto L43
    L52:
        g(j, r7, r8);     // Catch: Throwable -> L36
        r8.readException();     // Catch: Throwable -> L36
        g = r8.readString();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        n.a(th, "oac", String.valueOf(r13));     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        r8.recycle();     // Catch: Throwable -> L47
        r7.recycle();     // Catch: Throwable -> L47
        throw th;     // Catch: Throwable -> L47
    L26:
        r7.writeInterfaceToken(f5.o("KY29tLmhleXRhcC5vcGVuaWQuSU9wZW5JRA"));     // Catch: Throwable -> L36
        r7.writeString(r12.getPackageName());     // Catch: Throwable -> L36
        r7.writeString(x(r12));     // Catch: Throwable -> L36
        r7.writeString(f5.o("IT1VJRA"));     // Catch: Throwable -> L36
    L31:
        r9 = true;
        goto L32
    L27:
        String r10 = "UY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuSURldmljZUlkU2VydmljZQ";
    L30:
        r7.writeInterfaceToken(f5.o(r10));     // Catch: Throwable -> L36
        goto L31
    L29:
        r10 = "UY29tLnVvZGlzLm9wZW5kZXZpY2UuYWlkbC5PcGVuRGV2aWNlSWRlbnRpZmllclNlcnZpY2U";
    L43:
        Thread.sleep(15);     // Catch: Throwable -> L47
    L44:
        r12.unbindService(r5);     // Catch: Throwable -> L47
        j = null;     // Catch: Throwable -> L47
    L46:
        return g;
    L10:
        r1.setClassName(f5.o("WY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2U"), f5.o("QY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuRGV2aWNlSWRTZXJ2aWNl"));     // Catch: Throwable -> L47
        goto L12
    L11:
        r1.setAction(f5.o("WY29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF"));     // Catch: Throwable -> L47
        r1.setPackage(f5.o("UY29tLmh1YXdlaS5od2lk"));     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        n.a(th, "oa", String.valueOf(r13));
        h = true;
        return g;
    }

    public static void l(Closeable r0) {
        if (r0 == null) goto L8;
        r0.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static boolean m(Context r0, String r1) {
        if (r0 != null) goto L4;
        return false;
    L4:
        if (r0.checkCallingOrSelfPermission(r1) != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static int r(Context r0) {
        return c(r0);
    L4:
        return -1;
    }

    public static String u(Context r3) {
        String r0 = NameKeys.UnloadStrategy_No_Strategy;
        if (TextUtils.isEmpty(NameKeys.UnloadStrategy_No_Strategy) == false) goto L7;
        String r1 = j(r3);     // Catch: Throwable -> L24
    L25:
        if (TextUtils.isEmpty(r1) == false) goto L12;
        r1 = q(r3);     // Catch: Throwable -> L22
    L12:
        if (TextUtils.isEmpty(r1) == false) goto L14;
        r1 = p(r3);     // Catch: Throwable -> L22
    L14:
        if (TextUtils.isEmpty(r1) == true) goto L19;
        r0 = r1;
    L19:
        if (TextUtils.isEmpty(r0) == false) goto L29;
        return a(r3);
    L29:
        return r0;
    L23:
        return r1;
    L7:
        r1 = NameKeys.UnloadStrategy_No_Strategy;
    L31:
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    public static void v() {
        v = -1;
        w = false;
        x = -1;
        y = false;
        t = NameKeys.UnloadStrategy_No_Strategy;
        u = false;
        m = NameKeys.UnloadStrategy_No_Strategy;
        n = false;
    }

    public static String w(Context r8) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r8.getExternalCacheDir().getAbsolutePath() + "/.UTSystemConfig/Global/Alvin2.xml");     // Catch: Throwable -> L32
        XmlPullParser r9 = Xml.newPullParser();     // Catch: Throwable -> L32
        int r1 = r9.getEventType();     // Catch: Throwable -> L32
        PolarisFileInputStreamWrapper r2 = new PolarisFileInputStreamWrapper(r0);     // Catch: Throwable -> L32
        r9.setInput(r2, "utf-8");     // Catch: Throwable -> L39
        boolean r3 = false;
    L5:
        if (1 != r1) goto L7;
    L46:
        r2.close();     // Catch: Throwable -> L38
        return NameKeys.UnloadStrategy_No_Strategy;
    L57:
        return NameKeys.UnloadStrategy_No_Strategy;
    L7:
        if (r1 == 2) goto L19;
        if (r1 != 3) goto L11;
        r3 = false;
    L28:
        r1 = r9.next();     // Catch: Throwable -> L39
        goto L5
    L11:
        if (r1 != 4) goto L28;
        if (r3 == false) goto L28;
        String r10 = r9.getText();     // Catch: Throwable -> L39
        r2.close();     // Catch: Throwable -> L37
    L16:
        return r10;
    L19:
        if (r9.getAttributeCount() <= 0) goto L28;
        int r4 = r9.getAttributeCount();     // Catch: Throwable -> L39
        int r5 = 0;
    L21:
        if (r5 >= r4) goto L28;
        String r6 = r9.getAttributeValue(r5);     // Catch: Throwable -> L39
        if ("UTDID2".equals(r6) == false) goto L25;
    L26:
        r3 = true;
    L27:
        r5 = r5 + 1;     // Catch: Throwable -> L39
        goto L21
    L25:
        if ("UTDID".equals(r6) == false) goto L27;
    L33:
        if (r2 != null) goto L46;
        return NameKeys.UnloadStrategy_No_Strategy;
    L32:
        r2 = null;
        goto L33
    }

    public static String x(Context r5) {
    L14:
        return NameKeys.UnloadStrategy_No_Strategy;
    L3:
        if (TextUtils.isEmpty(i) == false) goto L5;
        Signature[] r6 = r5.getPackageManager().getPackageInfo(r5.getPackageName(), 64).signatures;     // Catch: Throwable -> L14
        int r0 = 0;
        byte[] r7 = r6[0].toByteArray();     // Catch: Throwable -> L14
        byte[] r8 = MessageDigest.getInstance(f5.o("IU0hBMQ")).digest(r7);     // Catch: Throwable -> L14
        StringBuffer r1 = new StringBuffer();     // Catch: Throwable -> L14
    L8:
        if (r0 >= r8.length) goto L10;
        r1.append(Integer.toHexString((r8[r0] & 255) | 256).substring(1, 3));     // Catch: Throwable -> L14
        r0 = r0 + 1;     // Catch: Throwable -> L14
        goto L8
    L10:
        String r9 = r1.toString();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r9) == true) goto L13;
        i = r9;     // Catch: Throwable -> L14
    L13:
        return r9;
    L5:
        return i;
    }

    public static String b(Context r1) {
        if (u == true) goto L5;
        i(r1);
        TelephonyManager r2 = (TelephonyManager) r1.getSystemService("phone");
        if (r2 == null) goto L9;
        String r0 = r2.getSimOperatorName();
        t = r0;
        if (TextUtils.isEmpty(r0) == false) goto L13;
        t = r2.getNetworkOperatorName();
    L13:
        u = true;
        return t;
    L9:
        return t;
    L5:
        return t;
    }

    public static int c(Context r1) {
        if (w == true) goto L5;
        i(r1);
        if (r1 == null) goto L22;
        if (m(r1, f5.o("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == false) goto L22;
        ConnectivityManager r2 = (ConnectivityManager) r1.getSystemService("connectivity");
        if (r2 == null) goto L14;
        NetworkInfo r3 = r2.getActiveNetworkInfo();
        if (r3 != null) goto L19;
        w = true;
        return v;
    L19:
        int r4 = r3.getType();
        v = r4;
        w = true;
        return r4;
    L14:
        return v;
    L22:
        return v;
    L5:
        return v;
    }

    public static int d(Context r1) {
        if (y == true) goto L5;
        i(r1);
        if (m(r1, f5.o("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == false) goto L9;
        ConnectivityManager r2 = (ConnectivityManager) r1.getSystemService("connectivity");
        if (r2 == null) goto L13;
        NetworkInfo r3 = r2.getActiveNetworkInfo();
        if (r3 == null) goto L20;
        if (r3.isAvailable() == false) goto L20;
        x = r3.getSubtype();
        y = true;
    L20:
        return x;
    L13:
        return x;
    L9:
        return x;
    L5:
        return x;
    }

    public static String e(Context r6) {
        if (c == true) goto L29;
        return NameKeys.UnloadStrategy_No_Strategy;
    L29:
        String r3 = f(r6);     // Catch: Throwable -> L8
    L27:
    L16:
        r3 = null;
    L18:
        if (TextUtils.isEmpty(r3) == false) goto L25;
        c = false;
        return NameKeys.UnloadStrategy_No_Strategy;
    L25:
        byte[] r7 = f5.o("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");     // Catch: Throwable -> L23
        byte[] r4 = y4.e(r3);     // Catch: Throwable -> L23
        return new String(y4.c(f5.o("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), r4, r7), "UTF-8");
    L23:
        c = false;
        return NameKeys.UnloadStrategy_No_Strategy;
    L10:
        if (TextUtils.isEmpty(r3) == false) goto L18;
        if (r6 != null) goto L14;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
        goto L18
    L14:
        r3 = r6.getSharedPreferences(f5.o("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(b5.a(f5.o("RYW1hcF9kZXZpY2VfYWRpdQ")), NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L16
    L8:
        r3 = NameKeys.UnloadStrategy_No_Strategy;
        goto L27
    }

    public static String f(Context r9) {
        String r1 = b5.a(f5.o("LYW1hcF9kZXZpY2VfYWRpdQ"));
        ByteArrayOutputStream r2 = null;
        File r3 = r9.getExternalCacheDir();     // Catch: Exception -> L48
        if (r3 != null) goto L6;
        r3 = r9.getCacheDir();     // Catch: Exception -> L48
    L6:
        if (r3 == null) goto L9;
        String r10 = r3.getAbsolutePath();     // Catch: Exception -> L48
    L11:
        if (TextUtils.isEmpty(r10) == false) goto L13;
        return NameKeys.UnloadStrategy_No_Strategy;
    L13:
        PolarisFileWrapper r4 = new PolarisFileWrapper(r10 + File.separator + f5.o("KYmFja3Vwcw"), f5.o("MLmFkaXU"));
        if (r4.exists() == true) goto L16;
    L46:
        return NameKeys.UnloadStrategy_No_Strategy;
    L16:
        if (r4.canRead() == false) goto L46;
        if (r4.length() != 0) goto L53;
        r4.delete();
        return NameKeys.UnloadStrategy_No_Strategy;
    L53:
        RandomAccessFile r11 = new RandomAccessFile(r4, "r");     // Catch: Throwable -> L43
        byte[] r5 = new byte[1024];     // Catch: Throwable -> L47
        ByteArrayOutputStream r6 = new ByteArrayOutputStream();     // Catch: Throwable -> L47
    L51:
        int r7 = r11.read(r5);     // Catch: Throwable -> L42
        if (r7 == (-1)) goto L28;
        r6.write(r5, 0, r7);     // Catch: Throwable -> L42
        goto L51
    L28:
        String r8 = new String(r6.toByteArray(), "UTF-8");     // Catch: Throwable -> L42
        if (TextUtils.isEmpty(r8) == false) goto L31;
    L41:
        l(r6);
    L45:
        l(r11);
        goto L46
    L31:
        if (r8.contains(f5.o("SIw")) == false) goto L41;
        String[] r0 = r8.split(f5.o("SIw"));     // Catch: Throwable -> L42
        if (r0 == null) goto L41;
        if (r0.length != 2) goto L41;
        if (TextUtils.equals(r1, r0[0]) == false) goto L41;
        String r12 = r0[1];     // Catch: Throwable -> L42
        l(r6);
        l(r11);
        return r12;
    L42:
        r2 = r6;
    L44:
        l(r2);
    L43:
        r11 = null;
    L9:
        r10 = null;
        goto L11
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class h(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static String j(Context r3) {
        if (TextUtils.isEmpty(b) == false) goto L6;
        if (r3 != null) goto L9;
        return NameKeys.UnloadStrategy_No_Strategy;
    L9:
        String r1 = e(r3);     // Catch: Throwable -> L21
        b = r1;     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r1) == true) goto L14;
        return b;
    L14:
        if (e != null) goto L17;
        return NameKeys.UnloadStrategy_No_Strategy;
    L17:
        if (f == false) goto L19;
        return NameKeys.UnloadStrategy_No_Strategy;
    L19:
        f = true;     // Catch: Throwable -> L21
        k1.d.b(new a(r3));     // Catch: Throwable -> L21
        goto L20
    L6:
        return b;
    L20:
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    public static String o(ContentResolver r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13, "mqBRboGZkQPcAkyk"};
        f06.b r11 = new f06.b();
        f06.d r12 = r8.b(102003, "android/provider/Settings$System", "getString", Settings.System.class, r9, "java.lang.String", r11);
        if (r12.a == false) goto L6;
        r8.a(102003, "android/provider/Settings$System", "getString", Settings.System.class, r9, null, r11, false);
        return (String) r12.b;
    L6:
        String r14 = Settings.System.getString(r13, "mqBRboGZkQPcAkyk");
        r8.a(102003, "android/provider/Settings$System", "getString", Settings.System.class, r9, r14, r11, true);
        return r14;
    }

    public static String p(Context r2) {
        if (h == false) goto L7;
        return NameKeys.UnloadStrategy_No_Strategy;
    L7:
        if (TextUtils.isEmpty(g) == true) goto L11;
        return g;
    L11:
        if (k == false) goto L15;
        return g;
    L15:
        if (Looper.getMainLooper() != Looper.myLooper()) goto L17;
        k1.d.b(new b(r2));     // Catch: Throwable -> L21
        goto L20
    L17:
        k = true;     // Catch: Throwable -> L21
        return y(r2);
    L20:
        return g;
    }

    public static String q(Context r5) {
        if (l == false) goto L47;
        String r6 = a;
        if (r6 != null) goto L7;
        return NameKeys.UnloadStrategy_No_Strategy;
    L7:
        return r6;
    L47:
        String r2 = a;     // Catch: Throwable -> L39
        if (r2 == null) goto L16;
        if (NameKeys.UnloadStrategy_No_Strategy.equals(r2) == true) goto L16;
        return a;
    L16:
        if (m(r5, f5.o("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT")) == false) goto L19;
        a = o(r5.getContentResolver());     // Catch: Throwable -> L39
    L19:
        if (TextUtils.isEmpty(a) == true) goto L43;
        l = true;     // Catch: Throwable -> L39
        return a;
    L43:
        String r3 = y.k(r5, "Alvin2", "UTDID2");     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r3) == false) goto L41;
        r3 = y.k(r5, "Alvin2", "UTDID");     // Catch: Throwable -> L27
    L41:
        a = r3;     // Catch: Throwable -> L40
        if (TextUtils.isEmpty(r3) == true) goto L45;
        l = true;     // Catch: Throwable -> L40
        return a;
    L45:
        a = w(r5);     // Catch: Throwable -> L34
        l = true;     // Catch: Throwable -> L34
    L35:
        String r7 = a;
        if (r7 != null) goto L38;
        return NameKeys.UnloadStrategy_No_Strategy;
    L38:
        return r7;
    L27:
        r3 = NameKeys.UnloadStrategy_No_Strategy;
        goto L41
    }

    public static NetworkInfo s(Context r2) {
        if (m(r2, f5.o("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == true) goto L5;
        return null;
    L5:
        ConnectivityManager r3 = (ConnectivityManager) r2.getSystemService("connectivity");
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getActiveNetworkInfo();
    }

    public static String t(Context r2) {
    L14:
        return NameKeys.UnloadStrategy_No_Strategy;
    L4:
        if (m(r2, f5.o("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == true) goto L6;
        return NameKeys.UnloadStrategy_No_Strategy;
    L6:
        ConnectivityManager r3 = (ConnectivityManager) r2.getSystemService("connectivity");     // Catch: Throwable -> L14
        if (r3 != null) goto L9;
        return NameKeys.UnloadStrategy_No_Strategy;
    L9:
        NetworkInfo r4 = r3.getActiveNetworkInfo();     // Catch: Throwable -> L14
        if (r4 != null) goto L12;
        return NameKeys.UnloadStrategy_No_Strategy;
    L12:
        return r4.getTypeName();
    }

    public static String y(Context r8) {
        String r1 = f5.o("IeGlhb21p");
        String r2 = Build.MANUFACTURER;
        if (r1.equalsIgnoreCase(r2) == true) goto L71;
        String r0 = f5.o("IeGlhb21p");
        String r3 = Build.BRAND;
        if (r0.equalsIgnoreCase(r3) == true) goto L71;
        if (f5.o("IUkVETUk=").equalsIgnoreCase(r2) == true) goto L71;
        if (f5.o("IUkVETUk=").equalsIgnoreCase(r3) == true) goto L71;
        if (f5.o("Idml2bw").equalsIgnoreCase(r2) == false) goto L14;
    L73:
        Cursor r9 = n(r8.getContentResolver(), UriProtector.parse(f5.o("QY29udGVudDovL2NvbS52aXZvLnZtcy5JZFByb3ZpZGVyL0lkZW50aWZpZXJJZC9PQUlE")));     // Catch: Throwable -> L59
        if (r9 == null) goto L62;
    L50:
        if (r9.moveToNext() == false) goto L57;
        int r4 = r9.getColumnCount();     // Catch: Throwable -> L59
        int r5 = 0;
    L52:
        if (r5 >= r4) goto L50;
        if (f5.o("IdmFsdWU").equals(r9.getColumnName(r5)) == true) goto L55;
        r5 = r5 + 1;     // Catch: Throwable -> L59
        goto L52
    L55:
        g = r9.getString(r5);     // Catch: Throwable -> L59
        goto L50
    L57:
        r9.close();     // Catch: Throwable -> L59
    L62:
        return g;
    L59:
        th = move-exception;
        h = true;
        n.a(th, "oa", "vivo");
        goto L62
    L14:
        if (f5.o("Idml2bw").equalsIgnoreCase(r3) == true) goto L73;
        if (f5.o("IaHVhd2Vp").equalsIgnoreCase(r2) == true) goto L46;
        if (f5.o("IaHVhd2Vp").equalsIgnoreCase(r3) == true) goto L46;
        if (f5.o("ISE9OT1I=").equalsIgnoreCase(r2) == true) goto L46;
        if (f5.o("Mc2Ftc3VuZw").equalsIgnoreCase(r2) == true) goto L44;
        if (f5.o("Mc2Ftc3VuZw").equalsIgnoreCase(r3) == true) goto L44;
        if (f5.o("IT1BQTw").equalsIgnoreCase(r2) == true) goto L42;
        if (f5.o("IT1BQTw").equalsIgnoreCase(r3) == true) goto L42;
        if (f5.o("MT25lUGx1cw").equalsIgnoreCase(r2) == true) goto L42;
        if (f5.o("MT25lUGx1cw").equalsIgnoreCase(r3) == true) goto L42;
        if (f5.o("IUkVBTE1F").equalsIgnoreCase(r3) == true) goto L42;
        h = true;
        return g;
    L42:
        return k(r8, 5);
    L44:
        return k(r8, 4);
    L46:
        return k(r8, 2);
    L71:
        Class r6 = h(f5.o("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));     // Catch: Throwable -> L67
        Object r7 = r6.newInstance();     // Catch: Throwable -> L67
        Object r10 = r6.getMethod(f5.o("MZ2V0T0FJRA"), new Class[]{Context.class}).invoke(r7, new Object[]{r8});     // Catch: Throwable -> L67
        if (r10 == null) goto L70;
        String r11 = (String) r10;     // Catch: Throwable -> L67
        g = r11;     // Catch: Throwable -> L67
        return r11;
    L70:
        return g;
    L67:
        th = move-exception;
        n.a(th, "oa", "xm");
        h = true;
        goto L70
    }

    public static Cursor n(ContentResolver r12, Uri r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13, null, null, null, null};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r12, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r14 = r12.query(r13, null, null, null, null);
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, r14, r10, true);
        return r14;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static void g(IBinder r13, Parcel r14, Parcel r15) throws RemoteException {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
        r13.transact(1, r14, r15, 0);
        return;
    L6:
        long r1 = SystemClock.uptimeMillis();
        r13.transact(1, r14, r15, 0);     // Catch: Throwable -> L12
        long r7 = SystemClock.uptimeMillis() - r1;
        if (r7 < 100) goto L22;
        BinderPerformanceReporter.report(r7, r13.getClass().getName(), 1, 0, new Throwable("Slow main-thread Binder transaction"));
        return;
    L22:
        return;
    L12:
        th = move-exception;
        long r8 = SystemClock.uptimeMillis() - r1;
        if (r8 < 100) goto L19;
        if (r13 != null) goto L17;
        String r16 = NameKeys.UnloadStrategy_No_Strategy;
    L18:
        BinderPerformanceReporter.report(r8, r16, 1, 0, new Throwable("Slow main-thread Binder transaction"));
        goto L19
    L17:
        r16 = r13.getClass().getName();
    L19:
        throw th;
    }
}
