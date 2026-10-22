package ms.bd.c;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import androidx.core.content.ContextCompat;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mobsec.metasec.ml.MSConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.KotlinVersion;
import kotlin.jvm.internal.ByteCompanionObject;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class g2 {
    public static final g4 a = null;
    public static final l2 b = null;
    public static JSONArray c;

    static {
        a = new g4();
        b = new l2();
        c = null;
    }

    public static String e() {
        Context r0 = d2.b.a;
        JSONArray r1 = new JSONArray();
        AccessibilityManager r2 = (AccessibilityManager) r0.getSystemService((String) p2.a(16777217, 0, 0, "dde69a", new byte[]{116, 101, 21, 71, 21, 101, 110, 71, 61, 106, 124, 114, 15}));
        if (r2 == null) goto L28;
        List r3 = null;
        Method r4 = r2.getClass().getDeclaredMethod((String) p2.a(16777217, 0, 0, "26862b", new byte[]{36, 49, 95, 107, 3, 102, 37, 22, 101, 106, 38, 48, 106, 65, 14, 112, 34, 4, 96, 100, 42, 56, 66, 86, 20, 70, 52, 5, ByteCompanionObject.MAX_VALUE, 111, 32, 49, 103, 75, 30, 97}), null);     // Catch: Throwable -> L29
        if (r4 == null) goto L13;
        List r9 = (List) r4.invoke(r2, null);     // Catch: Throwable -> L29
    L14:
        if (r9 == null) goto L26;
        if (r9.size() == 0) goto L26;
        Iterator r5 = r9.iterator();
    L20:
        if (r5.hasNext() == false) goto L28;
        AccessibilityServiceInfo r6 = (AccessibilityServiceInfo) r5.next();
        JSONObject r7 = new JSONObject();
        r7.put((String) p2.a(16777217, 0, 0, "d022fa", new byte[]{112, 36}), r6.eventTypes);     // Catch: Throwable -> L24
        r7.put((String) p2.a(16777217, 0, 0, "d6e298", new byte[]{124, 48}), r6.getId());     // Catch: Throwable -> L24
        r1.put(r7);     // Catch: Throwable -> L24
    L26:
        return r1.toString();
    L13:
        r9 = r3;
    L11:
        r3 = null;
    L28:
        return r1.toString();
    }

    public static String g() {
        PolarisFileWrapper r1 = new PolarisFileWrapper(d2.b.a.getFilesDir(), (String) p2.a(16777217, 0, 0, "b63976", new byte[]{61, 57, 83, 73, 9, 53, 96}));
        if (r1.exists() == true) goto L6;
        r1.mkdirs();
    L6:
        return r1.getAbsolutePath();
    }

    public static String h() {
        Context r0 = d2.b.a;
        int r1 = n.a;
        if (TextUtils.isEmpty(n.b) == false) goto L7;
        n.b = r0.getPackageManager().getApplicationInfo(r0.getPackageName(), 128).metaData.getString((String) p2.a(16777217, 0, 0, "898c82", new byte[]{26, 8, 116, 33, 34, 23, 8, 49, 70, 29, 22, 21, 106, 58, 34}));     // Catch: Throwable -> L8
    L7:
        return n.b;
    }

    public static Integer i() {
        Context r0 = d2.b.a;
        if (n.a > 0) goto L6;
        n.a = r0.getPackageManager().getPackageInfo(r0.getPackageName(), 0).versionCode;     // Catch: Throwable -> L7
    L6:
        return Integer.valueOf(n.a);
    }

    public static String j() {
        Context r0 = d2.b.a;
        int r1 = n.a;
        if (TextUtils.isEmpty(n.b) == false) goto L7;
        n.b = r0.getPackageManager().getPackageInfo(r0.getPackageName(), 0).versionName;     // Catch: Throwable -> L8
    L7:
        return n.b;
    }

    public static Integer k() {
        Context r0 = d2.b.a;
        String r1 = o.a;
        int r2 = 3;
        int r5 = KotlinVersion.MAX_COMPONENT_VALUE;
        ByteArrayOutputStream r6 = null;
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L26
        r7.append(r0.getFilesDir().getAbsolutePath());     // Catch: Throwable -> L26
        r7.append((String) p2.a(16777217, 0, 0, "a7e43b", new byte[]{63}));     // Catch: Throwable -> L26
        String r8 = o.a;     // Catch: Throwable -> L26
        r7.append(r8);     // Catch: Throwable -> L26
        String r9 = r7.toString();     // Catch: Throwable -> L26
        PolarisFileWrapper r10 = new PolarisFileWrapper(r9);     // Catch: Throwable -> L26
        if (r10.exists() == true) goto L65;
    L8:
        InputStream r3 = r0.getResources().getAssets().open(r8);     // Catch: Throwable -> L26
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();     // Catch: Throwable -> L48
        byte[] r12 = new byte[4096];     // Catch: Throwable -> L25
    L12:
        int r13 = r3.read(r12, 0, 4096);     // Catch: Throwable -> L25
        if (r13 == (-1)) goto L15;
        r11.write(r12, 0, r13);     // Catch: Throwable -> L25
        goto L12
    L15:
        PolarisFileOutputStreamWrapper r14 = new PolarisFileOutputStreamWrapper(r9);     // Catch: Throwable -> L25
        r14.write(r11.toByteArray());     // Catch: Throwable -> L25
        r14.close();     // Catch: Throwable -> L25
        if (r11.size() <= 0) goto L55;
        if (new PolarisFileWrapper(r9).exists() == false) goto L21;
        r2 = 0;
        goto L55
    L21:
        r2 = r5;
    L55:
        r3.close();     // Catch: Throwable -> L46
    L63:
        r11.close();     // Catch: Throwable -> L47
    L37:
        return Integer.valueOf(r2);
    L25:
        r6 = r11;
    L51:
        String r4 = (String) p2.a(16777217, 0, 0, "dd2ff0", new byte[]{116, 101, 126, 21});     // Catch: Throwable -> L38
        if (r3 != null) goto L53;
    L33:
        if (r6 != null) goto L59;
    L35:
        r2 = r5;
        goto L37
    L59:
        r6.close();     // Catch: Throwable -> L49
        goto L35
    L53:
        r3.close();     // Catch: Throwable -> L32
    L38:
        th = move-exception;
        if (r3 != null) goto L57;
    L43:
        if (r6 == null) goto L74;
        r6.close();     // Catch: Throwable -> L50
        throw th;
    L75:
        throw th;
    L74:
        throw th;
    L57:
        r3.close();     // Catch: Throwable -> L42
        goto L43
    L65:
        r10.delete();     // Catch: Throwable -> L7
        r5 = 2;
    L7:
        r3 = null;
        r5 = 2;
    L26:
        r3 = null;
        goto L51
    }

    public static String l() {
        Context r0 = d2.b.a;
        Class r1 = a(new String(a1.a((String) p2.a(16777217, 0, 0, "14b551", new byte[]{118, 101, 71, 71, 92, 34, 96, 16, 101, 52, 118, 51, 71, 21, 93, 116, 100, 19, 101, 60, 118, 98, 67, 68, 92, ByteCompanionObject.MAX_VALUE, 100, 16, 100, 49, 118, 99, 70, 19, 92, 35, 100, 68, 101, 102, 114, 51, 71, 71, 93, 117, 96, 16, 102, 53, 118, 48, 70, 22, 92, 115, 101, 71, 102, 53, 119, 100, 71, 71, 92, 112, 100, 76, 101, 102, 118, 99}))));     // Catch: Throwable -> L5
        Object r2 = r1.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r0});     // Catch: Throwable -> L5
        Method r3 = r1.getDeclaredMethod(new String(a1.a((String) p2.a(16777217, 0, 0, "fa60bf", new byte[]{33, 52, 19, 17, 10, 37, 49, 17, 48, 54, 33, 54, 18, 22, 11, 32, 51, 23, 49, 53, 34, 51, 19, 66, 10, 38, 51, 21, 48, 50}))), new Class[]{String.class});     // Catch: Throwable -> L5
        r3.setAccessible(true);     // Catch: Throwable -> L5
        double r4 = ((Double) r3.invoke(r2, new Object[]{new String(a1.a((String) p2.a(16777217, 0, 0, "015f7a", new byte[]{119, 97, 16, 67, 95, 34, 100, 68, 50, 99, 118, 97, 17, 75, 90, 115, 101, 67, 50, 103, 118, 99, 16, 67, 94, 37, 101, 73, 51, 98, 118, 106})))})).doubleValue();     // Catch: Throwable -> L5
    L7:
        return Integer.toString((int) r4);
    L5:
        r4 = 0.0d;
        goto L7
    }

    public static Object m() {
        m3 r0 = m3.c(d2.b.a);
        monitor-enter(r0);
        int r1 = r0.b.size();     // Catch: Throwable -> L24
        if (r1 > 0) goto L8;
    L6:
        int[] r2 = new int[0];     // Catch: Throwable -> L24
        monitor-exit(r0);
        return r2;
    L8:
        if (r1 != 1) goto L28;
        int[] r3 = {((Integer) r0.b.get(0)).intValue()};     // Catch: Throwable -> L24
    L10:
        monitor-exit(r0);
        return r3;
    L28:
        ArrayList r4 = r0.b;     // Catch: Throwable -> L27
        int r5 = r1 - 10;     // Catch: Throwable -> L27
        if (r5 > 0) goto L16;
        r5 = 0;
    L16:
        List r6 = r4.subList(r5, r1);     // Catch: Throwable -> L27
        r3 = new int[r6.size()];     // Catch: Throwable -> L27
        int r7 = 0;
    L18:
        if (r7 >= r6.size()) goto L10;
        r3[r7] = ((Integer) r6.get(r7)).intValue();     // Catch: Throwable -> L27
        r7 = r7 + 1;
    L24:
        th = move-exception;
        throw th;
    }

    public static Integer n() {
        Intent r0 = b(m3.c(d2.b.a).a, new IntentFilter((String) p2.a(16777217, 0, 0, "45f37d", new byte[]{36, 57, 17, 85, 7, 122, 51, 90, 62, 109, 49, 50, 27, 83, 70, 114, 52, 0, 62, 108, 43, 121, 55, 102, 60, 71, 18, 38, 14, 92, 6, 31, 52, 105, 47, 86, 19})));
        int r1 = -1;
        if (r0 == null) goto L13;
        int r2 = r0.getIntExtra((String) p2.a(16777217, 0, 0, "741643", new byte[]{53, 34, 67, 86, 30, 55}), -1);
        if (r2 != 2) goto L8;
    L11:
        r1 = 1;
        goto L13
    L8:
        if (r2 == 5) goto L11;
        r1 = 0;
    L13:
        return Integer.valueOf(r1);
    }

    public static String o() {
        m3 r0 = m3.c(d2.b.a);
        r0.getClass();
        monitor-enter(r0);     // Catch: Throwable -> L10 Exception -> L12
        int r1 = r0.b();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    L14:
        return "" + r1;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10 Exception -> L12
    L12:
        r1 = -1;
    L10:
        th = move-exception;
        throw th;
    }

    public static String p() {
        Context r0 = d2.b.a;
        monitor-enter(t0.class);
        String r2 = t0.a;     // Catch: Throwable -> L34
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L23
        r5.append(r0.getFilesDir().getAbsolutePath());     // Catch: Throwable -> L23
        r5.append((String) p2.a(16777217, 0, 0, "d52bf0", new byte[]{58}));     // Catch: Throwable -> L23
        String r9 = t0.a;     // Catch: Throwable -> L23
        r5.append(r9);     // Catch: Throwable -> L23
        String r6 = r5.toString();     // Catch: Throwable -> L23
        if (new PolarisFileWrapper(r6).exists() == false) goto L13;
        String r4 = t0.b(r6);     // Catch: Throwable -> L23
        if (r4 == null) goto L13;
        if (r4.length() <= 0) goto L13;
    L32:
        monitor-exit(t0.class);
        return r4;
    L13:
        InputStream r1 = r0.getResources().getAssets().open(r9);     // Catch: Throwable -> L23
        ByteArrayOutputStream r7 = new ByteArrayOutputStream();     // Catch: Throwable -> L23
        int r10 = 4096;
        byte[] r11 = new byte[4096];     // Catch: Throwable -> L23
    L14:
        int r12 = r1.read(r11, 0, r10);     // Catch: Throwable -> L23
        if (r12 == (-1)) goto L17;
        r7.write(r11, 0, r12);     // Catch: Throwable -> L23
        r10 = 4096;
        goto L14
    L17:
        PolarisFileOutputStreamWrapper r3 = new PolarisFileOutputStreamWrapper(r6);     // Catch: Throwable -> L23
        r3.write(r7.toByteArray());     // Catch: Throwable -> L23
        r3.close();     // Catch: Throwable -> L23
        t0.b(((String) p2.a(16777217, 0, 0, "e0ec6f", new byte[]{119, 58, 27, 24, 13, 49, 49, 70, 99, 115})) + r6);     // Catch: Throwable -> L23
        String r8 = t0.b(r6);     // Catch: Throwable -> L23
        if (r8 != null) goto L20;
    L21:
        RandomAccessFile r13 = new RandomAccessFile(r6, (String) p2.a(16777217, 0, 0, "a4abae", new byte[]{98, 33}));     // Catch: Throwable -> L23
        r13.seek(16);     // Catch: Throwable -> L23
        r13.write(new byte[]{2});     // Catch: Throwable -> L23
        r13.close();     // Catch: Throwable -> L23
        r8 = t0.b(r6);     // Catch: Throwable -> L23
    L25:
        if (r8 != null) goto L27;
    L30:
        r8 = (String) p2.a(16777217, 0, 0, "8f2f50", new byte[]{121, 95, 29, 83, 84, 26, 30, 117, 81, 25, 27, 95, 29, 83, 84, 26});     // Catch: Throwable -> L34
    L29:
        r4 = r8;
        goto L32
    L27:
        if (r8.length() != 0) goto L29;
        goto L24
    L20:
        if (r8.length() != 0) goto L25;
    L24:
        r8 = (String) p2.a(16777217, 0, 0, "d69a8e", new byte[]{37, 15, 22, 84, 89, 79, 66, 47, 75, 20, 69, 0, 99, 58, 41, 73, 59, 86, 54, 12});     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    }

    public static void q() {
        m3 r0 = m3.c(d2.b.a);
        r0.getClass();
        monitor-enter(r0);     // Catch: Throwable -> L10 Exception -> L12
        int r1 = r0.d();     // Catch: Throwable -> L7
        int r2 = r0.b();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        int r3 = (r1 * 10000) + r2;     // Catch: Throwable -> L7
    L13:
        r0.b.add(Integer.valueOf(r3));
        int r4 = r0.b.size();     // Catch: Throwable -> L18
        if (r4 <= 20) goto L25;
        ArrayList r5 = new ArrayList(r0.b.subList(r4 - 10, r4));     // Catch: Throwable -> L18
        r0.b.clear();     // Catch: Throwable -> L18
        r0.b = r5;     // Catch: Throwable -> L18
        return;
    L25:
        return;
    L26:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10 Exception -> L12
    L12:
        r3 = -10001;
    L10:
        th = move-exception;
        throw th;
    }

    public static String r() {
        Locale r0 = d2.b.a.getResources().getConfiguration().locale;     // Catch: Throwable -> L5
        String r1 = r0.getLanguage() + ((String) p2.a(16777217, 0, 0, "3e3555", new byte[]{29})) + r0.getCountry();     // Catch: Throwable -> L5
    L7:
        return b4.a(r1);
    L5:
        r1 = null;
        goto L7
    }

    public static String s() {
        JSONArray r0 = c;
        if (r0 != null) goto L5;
    L10:
        String r1 = (String) p2.a(16777217, 0, 0, "a5260b", new byte[]{125, 62, 73, 125, 11, 121});
    L11:
        JSONArray r2 = c;
        if (r2 == null) goto L16;
        return r2.toString();
    L16:
        return new JSONArray().toString();
    L7:
        if (n.b() != 1) goto L11;
        c = new JSONArray();     // Catch: Throwable -> L10
        DhcpInfo r3 = ((WifiManager) d2.b.a.getApplicationContext().getSystemService((String) p2.a(16777217, 0, 0, "8cd439", new byte[]{62, 104, 17, 73}))).getDhcpInfo();     // Catch: Throwable -> L10
        c.put((r3.dns1 & KotlinVersion.MAX_COMPONENT_VALUE) + ((String) p2.a(16777217, 0, 0, "eb9ec3", new byte[]{58})) + ((r3.dns1 >> 8) & KotlinVersion.MAX_COMPONENT_VALUE) + ((String) p2.a(16777217, 0, 0, "67ffac", new byte[]{105})) + ((r3.dns1 >> 16) & KotlinVersion.MAX_COMPONENT_VALUE) + ((String) p2.a(16777217, 0, 0, "071001", new byte[]{111})) + ((r3.dns1 >> 24) & KotlinVersion.MAX_COMPONENT_VALUE));     // Catch: Throwable -> L10
        c.put((r3.dns2 & KotlinVersion.MAX_COMPONENT_VALUE) + ((String) p2.a(16777217, 0, 0, "fe7938", new byte[]{57})) + ((r3.dns2 >> 8) & KotlinVersion.MAX_COMPONENT_VALUE) + ((String) p2.a(16777217, 0, 0, "6a566d", new byte[]{105})) + ((r3.dns2 >> 16) & KotlinVersion.MAX_COMPONENT_VALUE) + ((String) p2.a(16777217, 0, 0, "518d63", new byte[]{106})) + ((r3.dns2 >> 24) & KotlinVersion.MAX_COMPONENT_VALUE));     // Catch: Throwable -> L10
        goto L11
    L5:
        return r0.toString();
    }

    public static String t() {
        Locale r0 = d2.b.a.getResources().getConfiguration().locale;     // Catch: Throwable -> L5
        String r1 = r0.getLanguage() + ((String) p2.a(16777217, 0, 0, "86546c", new byte[]{22})) + r0.getCountry();     // Catch: Throwable -> L5
    L7:
        return b4.a(r1);
    L5:
        r1 = null;
        goto L7
    }

    public static String u() {
        String r0 = "";
    L26:
        e = move-exception;
        e.toString();
    L28:
        return r0;
    L4:
        if (j3.a == true) goto L23;
        if (n.b() != 1) goto L23;
        j3.a = true;     // Catch: SocketException -> L26
        Enumeration<NetworkInterface> r1 = NetworkInterface.getNetworkInterfaces();     // Catch: SocketException -> L26
    L9:
        if (r1.hasMoreElements() == false) goto L23;
        NetworkInterface r2 = r1.nextElement();     // Catch: SocketException -> L26
        Enumeration<InetAddress> r3 = r2.getInetAddresses();     // Catch: SocketException -> L26
    L12:
        if (r3.hasMoreElements() == false) goto L9;
        InetAddress r4 = r3.nextElement();     // Catch: SocketException -> L26
        String r5 = r2.getName();     // Catch: SocketException -> L26
        if (TextUtils.isEmpty(r5) == true) goto L12;
        if (r4.isLoopbackAddress() == true) goto L12;
        if ((r4 instanceof Inet4Address) == false) goto L12;
        if (r5.startsWith("rmnet") == false) goto L12;
        j3.b = r2.getName();     // Catch: SocketException -> L26
        r0 = r2.getName();     // Catch: SocketException -> L26
    L29:
    L23:
        if (TextUtils.isEmpty(j3.b) == true) goto L29;
        r0 = j3.b;     // Catch: SocketException -> L26
        goto L29
    }

    public static String w() {
        n3 r0 = n3.b(d2.b.a);
        monitor-enter(r0);
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L28
        int r2 = r0.e.size();     // Catch: Throwable -> L28
        if (r2 > 0) goto L34;
        monitor-exit(r0);
        return null;
    L34:
        ArrayList r3 = r0.e;     // Catch: Throwable -> L31
        int r4 = r2 - 50;     // Catch: Throwable -> L31
        if (r4 > 0) goto L12;
        r4 = 0;
    L12:
        List r5 = r3.subList(r4, r2);     // Catch: Throwable -> L31
        if (r5.size() <= 0) goto L22;
        Iterator r6 = r5.iterator();     // Catch: Throwable -> L31
    L16:
        if (r6.hasNext() == false) goto L22;
        JSONArray r7 = (JSONArray) r6.next();     // Catch: Throwable -> L31
        if (r7 == null) goto L16;
        r1.append(r7.get(0).toString());     // Catch: Throwable -> L31
        r1.append((String) p2.a(16777217, 0, 0, "9e30b9", new byte[]{100}));     // Catch: Throwable -> L31
        r1.append(r7.get(1).toString());     // Catch: Throwable -> L31
        r1.append((String) p2.a(16777217, 0, 0, "167743", new byte[]{108}));     // Catch: Throwable -> L31
        r1.append(r7.get(2).toString());     // Catch: Throwable -> L31
        r1.append((String) p2.a(16777217, 0, 0, "ee5c00", new byte[]{104}));     // Catch: Throwable -> L31
    L22:
        if (r1.length() <= 0) goto L24;
        r1.delete(r1.length() - 1, r1.length());     // Catch: Throwable -> L31
    L24:
        String r8 = r1.toString();     // Catch: Throwable -> L28
        monitor-exit(r0);
        return r8;
    L28:
        th = move-exception;
        throw th;
    }

    public static void x() {
        n3 r0 = n3.b(d2.b.a);
        monitor-enter(r0);
        JSONArray r1 = r0.c();     // Catch: Throwable -> L13
        if (r1 == null) goto L11;
        r0.e.add(r1);     // Catch: Throwable -> L13
        int r2 = r0.e.size();     // Catch: Throwable -> L16
        if (r2 <= 100) goto L11;
        ArrayList r3 = new ArrayList(r0.e.subList(r2 - 50, r2));     // Catch: Throwable -> L16
        r0.e.clear();     // Catch: Throwable -> L16
        r0.e = r3;     // Catch: Throwable -> L16
    L11:
        monitor-exit(r0);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public static Boolean y() {
        Context r0 = d2.b.a;
        if (r0 == null) goto L10;
        ConnectivityManager r1 = (ConnectivityManager) r0.getSystemService((String) p2.a(16777217, 0, 0, "334ea0", new byte[]{33, 62, 73, 31, 91, 36, 36, 27, 115, 60, 54, 40}));     // Catch: Throwable -> L11
        Method r2 = r1.getClass().getDeclaredMethod((String) p2.a(16777217, 0, 0, "7b9054", new byte[]{33, 101, 94, 101, 9, 55, 61, 85, 109, 78, 35, 116, 93, 75, 24, 40, 29, 77, 110, 111}), null);     // Catch: Throwable -> L11
        r2.setAccessible(true);     // Catch: Throwable -> L11
        NetworkInfo r3 = (NetworkInfo) r2.invoke(r1, null);     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        Method r4 = r3.getClass().getDeclaredMethod((String) p2.a(16777217, 0, 0, "a98a03", new byte[]{121, 40, 106, 3, 14, 45, 110, 25, 107, 61, 117}), null);     // Catch: Throwable -> L11
        r4.setAccessible(true);     // Catch: Throwable -> L11
        Boolean r5 = (Boolean) r4.invoke(r3, null);     // Catch: Throwable -> L11
        r5.getClass();     // Catch: Throwable -> L11
        return r5;
    L10:
        return Boolean.FALSE;
    }

    public static String v() {
        a4 r0 = a4.a();
        monitor-enter(r0);
        Throwable r1 = r0.b;     // Catch: Throwable -> L11
        monitor-exit(r0);
        if (r1 != null) goto L8;
        return "";
    L8:
        return Arrays.toString(r1.getStackTrace());
    L11:
        th = move-exception;
        throw th;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
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

    public static Object d(String r3) {
        Context r0 = d2.b.a;
        PackageManager r1 = r0.getPackageManager();
        String r2 = r0.getPackageName();
        if (r3 != null) goto L5;
    L7:
        r3 = r2;
    L8:
        Signature[] r4 = r1.getPackageInfo(r3, 64).signatures;
        if (r4 != null) goto L11;
    L13:
        return null;
    L11:
        if (r4.length <= 0) goto L13;
        return r4[0].toByteArray();
    L5:
        if (r3.isEmpty() == true) goto L7;
        goto L7
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent b(Context r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(null, r10);
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r1 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(null, r10, 0, null, null, 2, r9);     // Catch: Exception -> L36
        int r2 = r1.result;     // Catch: Exception -> L36
        if (r2 == 1) goto L23;
        if (r2 == 2) goto L21;
        if (r2 == 3) goto L19;
        return r9.registerReceiver(null, r10);
    L19:
        return r1.intent;
    L21:
        return new Intent();
    L23:
        return r9.registerReceiver(null, r10);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r9.registerReceiver(null, r10, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r9, null, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r9.registerReceiver(null, r10);
    }

    public static void f(String r4, String[] r5) {
        Context r0 = d2.b.a;
        if (r0 == null) goto L15;
        if (r4 == null) goto L16;
        if (r5 != null) goto L7;
        return;
    L7:
        if ((r5.length % 2) != 0) goto L18;
        Intent r1 = new Intent(r4);
        r1.setPackage(r0.getPackageName());
        int r6 = 0;
    L10:
        if (r6 >= r5.length) goto L12;
        r1.putExtra(r5[r6], r5[r6 + 1]);
        r6 = r6 + 2;
        goto L10
    L12:
        r0.sendBroadcast(r1);
        return;
    L18:
        return;
    L16:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v150 */
    /* JADX WARN: Type inference failed for: r0v198 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v242 */
    /* JADX WARN: Type inference failed for: r0v243 */
    /* JADX WARN: Type inference failed for: r0v244 */
    /* JADX WARN: Type inference failed for: r0v245 */
    /* JADX WARN: Type inference failed for: r0v246 */
    /* JADX WARN: Type inference failed for: r0v247 */
    /* JADX WARN: Type inference failed for: r0v248 */
    /* JADX WARN: Type inference failed for: r0v249 */
    /* JADX WARN: Type inference failed for: r0v250 */
    /* JADX WARN: Type inference failed for: r0v251 */
    /* JADX WARN: Type inference failed for: r0v252 */
    /* JADX WARN: Type inference failed for: r0v253 */
    /* JADX WARN: Type inference failed for: r0v254 */
    /* JADX WARN: Type inference failed for: r0v255 */
    /* JADX WARN: Type inference failed for: r0v256 */
    /* JADX WARN: Type inference failed for: r0v257 */
    /* JADX WARN: Type inference failed for: r0v258 */
    /* JADX WARN: Type inference failed for: r0v259 */
    /* JADX WARN: Type inference failed for: r0v260 */
    /* JADX WARN: Type inference failed for: r0v261 */
    /* JADX WARN: Type inference failed for: r0v262 */
    /* JADX WARN: Type inference failed for: r0v263 */
    /* JADX WARN: Type inference failed for: r0v264 */
    /* JADX WARN: Type inference failed for: r0v265 */
    /* JADX WARN: Type inference failed for: r0v266 */
    /* JADX WARN: Type inference failed for: r0v267 */
    /* JADX WARN: Type inference failed for: r0v268 */
    /* JADX WARN: Type inference failed for: r0v269 */
    /* JADX WARN: Type inference failed for: r0v270 */
    /* JADX WARN: Type inference failed for: r0v271 */
    /* JADX WARN: Type inference failed for: r0v272 */
    /* JADX WARN: Type inference failed for: r0v273 */
    /* JADX WARN: Type inference failed for: r0v274 */
    /* JADX WARN: Type inference failed for: r0v275 */
    /* JADX WARN: Type inference failed for: r0v276 */
    /* JADX WARN: Type inference failed for: r0v277 */
    /* JADX WARN: Type inference failed for: r0v278 */
    /* JADX WARN: Type inference failed for: r0v279 */
    /* JADX WARN: Type inference failed for: r0v280 */
    /* JADX WARN: Type inference failed for: r0v281 */
    /* JADX WARN: Type inference failed for: r0v282 */
    /* JADX WARN: Type inference failed for: r0v283 */
    /* JADX WARN: Type inference failed for: r0v284 */
    /* JADX WARN: Type inference failed for: r0v285 */
    /* JADX WARN: Type inference failed for: r0v286 */
    /* JADX WARN: Type inference failed for: r0v287 */
    /* JADX WARN: Type inference failed for: r0v288 */
    /* JADX WARN: Type inference failed for: r0v289 */
    /* JADX WARN: Type inference failed for: r0v290 */
    /* JADX WARN: Type inference failed for: r0v291 */
    /* JADX WARN: Type inference failed for: r0v292 */
    /* JADX WARN: Type inference failed for: r0v293 */
    /* JADX WARN: Type inference failed for: r0v294 */
    /* JADX WARN: Type inference failed for: r0v295 */
    /* JADX WARN: Type inference failed for: r0v296 */
    /* JADX WARN: Type inference failed for: r0v297 */
    /* JADX WARN: Type inference failed for: r0v298 */
    /* JADX WARN: Type inference failed for: r0v299 */
    /* JADX WARN: Type inference failed for: r0v300 */
    /* JADX WARN: Type inference failed for: r0v301 */
    /* JADX WARN: Type inference failed for: r0v302 */
    /* JADX WARN: Type inference failed for: r0v303 */
    /* JADX WARN: Type inference failed for: r0v304 */
    /* JADX WARN: Type inference failed for: r0v305 */
    /* JADX WARN: Type inference failed for: r0v306 */
    /* JADX WARN: Type inference failed for: r0v307 */
    /* JADX WARN: Type inference failed for: r0v308 */
    /* JADX WARN: Type inference failed for: r0v309 */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v31, types: [java.util.ArrayList] */
    public static Object c(int r39, int r40, long r41, String r43, Object r44) {
        if (r39 != 16777228) goto L5;
        ?? r0 = g();
    L280:
        return r0;
    L5:
        if (r39 != 33554433) goto L7;
        a.b(r41);
        r0 = Boolean.TRUE;
        goto L280
    L7:
        if (r39 == 33554434) goto L276;
        boolean r5 = false;
        int r6 = 0;
        switch(r39) {
            case 16777217: goto L19;
            case 16777218: goto L18;
            case 16777219: goto L17;
            default: goto L10;
        };
    L10:
        switch(r39) {
            case 16777221: goto L28;
            case 16777222: goto L27;
            case 16777223: goto L26;
            case 16777224: goto L25;
            case 16777225: goto L24;
            case 16777226: goto L23;
            default: goto L11;
        };
    L11:
        switch(r39) {
            case 16777232: goto L32;
            case 16777233: goto L31;
            case 16777234: goto L30;
            case 16777235: goto L29;
            default: goto L13;
        };
    L29:
        r0 = w();
        goto L280
    L30:
        r0 = h();
        goto L280
    L31:
        r0 = j();
        goto L280
    L32:
        r0 = i();
        goto L280
    L13:
        switch(r39) {
            case 16777238: goto L234;
            case 16777239: goto L233;
            case 16777240: goto L232;
            case 16777241: goto L231;
            case 16777242: goto L230;
            case 16777243: goto L229;
            case 16777244: goto L228;
            case 16777245: goto L222;
            case 16777246: goto L221;
            case 16777247: goto L220;
            case 16777248: goto L219;
            case 16777249: goto L218;
            case 16777250: goto L217;
            case 16777251: goto L215;
            case 16777252: goto L214;
            case 16777253: goto L213;
            case 16777254: goto L212;
            case 16777255: goto L178;
            case 16777256: goto L169;
            case 16777257: goto L295;
            case 16777258: goto L289;
            case 16777259: goto L297;
            case 16777260: goto L127;
            case 16777261: goto L119;
            case 16777262: goto L104;
            case 16777263: goto L92;
            case 16777264: goto L91;
            case 16777265: goto L90;
            case 16777266: goto L82;
            case 16777267: goto L311;
            case 16777268: goto L78;
            case 16777269: goto L77;
            case 16777270: goto L305;
            case 16777271: goto L63;
            case 16777272: goto L46;
            case 16777273: goto L36;
            case 16777274: goto L35;
            case 16777275: goto L34;
            case 16777276: goto L33;
            default: goto L14;
        };
    L14:
        Object r7 = null;
        switch(r39) {
            case 16777278: goto L266;
            case 16777279: goto L255;
            case 16777280: goto L238;
            default: goto L334;
        };
    L238:
        if (r40 != 0) goto L240;
        r0 = Integer.valueOf(s2.c.size());
        goto L280
    L240:
        if (r40 != 1) goto L242;
        int r1 = ((s0) ListProtector.get(s2.c, (int) r41)).a;
    L253:
        r0 = Integer.valueOf(r1);
        goto L280
    L242:
        if (r40 != 2) goto L244;
        r1 = ((s0) ListProtector.get(s2.c, (int) r41)).b;
        goto L253
    L244:
        if (r40 != 3) goto L246;
        r1 = ((s0) ListProtector.get(s2.c, (int) r41)).c;
        goto L253
    L246:
        if (r40 == 4) goto L249;
        String[] r2 = s2.a;
    L248:
        r0 = r7;
        goto L280
    L249:
        r0 = Long.valueOf(((s0) ListProtector.get(s2.c, (int) r41)).d);
        goto L280
    L255:
        int r3 = (int) r41;
        if (r40 != 1000) goto L259;
        r0 = t2.b.a(r3, (String) p2.a(16777217, 0, 0, "39c0c3", new byte[]{35, 107}), r43);
        goto L280
    L259:
        if (r40 != 1005) goto L262;
        r0 = t2.b.a(r3, (String) p2.a(16777217, 0, 0, "668b49", new byte[]{38, 101}), r43);
        goto L280
    L262:
        if (r40 != 1006) goto L264;
        r0 = t2.b.a(r3, (String) p2.a(16777217, 0, 0, "fedcbe", new byte[]{118, 53}), r43);
        goto L280
    L264:
        t2 r4 = t2.b;
        r0 = (String) p2.a(16777217, 0, 0, "38c0aa", new byte[]{114});
        goto L280
    L334:
        return null;
    L266:
        if (s1.a == null) goto L275;
        p1 r8 = s1.a;
        v1 r9 = r8.b;
        if (r9 == null) goto L273;
        if (r9.e == false) goto L273;
        u1 r10 = new u1();
        r10.b = -2;
        r0 = r10.toString();
    L273:
        if (r8.d == false) goto L275;
        r0 = r8.a.b();
    L275:
        r0 = "";
        goto L280
    L33:
        r0 = String.valueOf(n2.c);
        goto L280
    L34:
        r0 = String.valueOf(n2.b);
        goto L280
    L35:
        r0 = String.valueOf(n2.a);
        goto L280
    L36:
        Context r11 = d2.b.a;
        int r12 = n.a;
    L44:
        n.c = "";
    L45:
        r0 = n.c;
        goto L280
    L38:
        if (n.c != null) goto L41;
        n.c = String.valueOf(r11.getPackageManager().getApplicationInfo(r11.getPackageName(), 128).metaData.get((String) p2.a(16777217, 0, 0, "a3b35b", new byte[]{69, 1, 53, 102, 62, 80, 93, 36, 22, 81, 67, 24, 62, 105, 53, 86, 77, 54, 22})));     // Catch: Throwable -> L44
    L41:
        if (n.c != null) goto L45;
        n.c = "";     // Catch: Throwable -> L44
        goto L45
    L46:
        Context r13 = d2.b.a;
        int r14 = h1.a;
        PackageManager r15 = r13.getPackageManager();
        if (r15 == null) goto L61;
        Iterator<ResolveInfo> r16 = r15.queryIntentActivities(new Intent((String) p2.a(16777217, 0, 0, "ea60d8", new byte[]{117, 109, 65, 86, 84, 38, 98, 14, 110, 110, 96, 102, 75, 80, 21, 46, 101, 84, 110, 111, 122, 45, 104, 101, 114, 1}), null), 128).iterator();
    L51:
        if (r16.hasNext() == false) goto L61;
        ActivityInfo r17 = r16.next().activityInfo;
        if (r17 == null) goto L51;
        Bundle r18 = r17.applicationInfo.metaData;
        if (r18 == null) goto L51;
        if (r18.get((String) p2.a(16777217, 0, 0, "0b3e11", new byte[]{57, 112, 79, 2, 11, 34, 62, 74, 108, 35, 36, 114, 83, 24, 1, 40})) == null) goto L51;
        r5 = true;
    L62:
        r0 = Boolean.valueOf(r5);
    L61:
        r13.getPackageName();
        goto L62
    L63:
        r0 = Boolean.valueOf(p.a(r43));
        goto L280
    L77:
        r0 = x3.a();
        goto L280
    L78:
        r0 = w0.a();
        goto L280
    L82:
        JSONObject r19 = new JSONObject();
        HashMap r20 = t.a();     // Catch: Throwable -> L89
        Iterator r21 = r20.keySet().iterator();     // Catch: Throwable -> L89
    L85:
        if (r21.hasNext() == false) goto L87;
        String r22 = (String) r21.next();     // Catch: Throwable -> L89
        r19.put(r22, r20.get(r22));     // Catch: Throwable -> L89
        goto L85
    L87:
        r0 = r19.toString();     // Catch: Throwable -> L89
    L89:
        r0 = (String) p2.a(16777217, 0, 0, "be7c72", new byte[]{104, 122});
        goto L280
    L90:
        r0 = "";
        goto L280
    L91:
        r0 = i4.a(d2.b.a);
        goto L280
    L92:
        Object[] r23 = (Object[]) r44;
        int r24 = (int) r41;
        String r25 = (String) r23[0];
        String r26 = (String) r23[1];
        if (r24 != 0) goto L98;
        Class r27 = a(r25);     // Catch: Exception -> L282
        Method r28 = r27.getDeclaredMethod(r26, null);     // Catch: Exception -> L282
        if (r40 != 1) goto L97;
        Object r29 = r28.invoke(r27, new Object[]{d2.b.a});     // Catch: Exception -> L282
    L102:
        r0 = (String) r29;     // Catch: Exception -> L282
    L97:
        r29 = r28.invoke(r27, null);     // Catch: Exception -> L282
        goto L102
    L98:
        if (r24 != 1) goto L216;
        Class r30 = a(r25);     // Catch: Exception -> L282
        Field r31 = r30.getDeclaredField(r26);     // Catch: Exception -> L282
        if (r31.getType() != String.class) goto L216;
        r31.setAccessible(true);     // Catch: Exception -> L282
        r29 = r31.get(r30);     // Catch: Exception -> L282
    L216:
        r0 = 0;
        goto L280
    L104:
        String[] r32 = {(String) p2.a(16777217, 0, 0, "abb656", new byte[]{ByteCompanionObject.MAX_VALUE, 112, 1, 77}), (String) p2.a(16777217, 0, 0, "60288f", new byte[]{42, 59, 84, 69}), (String) p2.a(16777217, 0, 0, "6ea89b", new byte[]{49, 110, 4, 67}), (String) p2.a(16777217, 0, 0, "0c0f37", new byte[]{44, 100, 74, 8, 25}), (String) p2.a(16777217, 0, 0, "5c601e", new byte[]{54, 100, 65, 73, 7}), (String) p2.a(16777217, 0, 0, "7b0c63", new byte[]{62, 105, 66, 24, 4, 45}), (String) p2.a(16777217, 0, 0, "341038", new byte[]{42, 35, 67, 83, 9, 38}), (String) p2.a(16777217, 0, 0, "2592d6", new byte[]{44, 57, 79, 86, 87, 52, 34}), (String) p2.a(16777217, 0, 0, "ab705b", new byte[]{124, 105, 74, 65, 11, 114, 103}), (String) p2.a(16777217, 0, 0, "557e58", new byte[]{55, 54, 73, 2, 31, 33, 49}), (String) p2.a(16777217, 0, 0, "d25251", new byte[]{109, 32, 73, 85, 15, 34}), (String) p2.a(16777217, 0, 0, "bb8621", new byte[]{61, 108, 78, 87, 4, 104}), (String) p2.a(16777217, 0, 0, "704efd", new byte[]{52, 55, 70, 29, 84, 118}), (String) p2.a(16777217, 0, 0, "f7cbf7", new byte[]{118, 38, 5, 5}), (String) p2.a(16777217, 0, 0, "9663b6", new byte[]{42, 56, 68, 68, 86, 50, 50, 22, 117, 104}), (String) p2.a(16777217, 0, 0, "2387ad", new byte[]{46, 52, 66, 87, 75}), (String) p2.a(16777217, 0, 0, "67dcae", new byte[]{43, 60, 21, 4, 75}), (String) p2.a(16777217, 0, 0, "f825b2", new byte[]{120, 42, 77, 84, 78}), (String) p2.a(16777217, 0, 0, "3b7e41", new byte[]{42, 111, 74, 30, 25})};
        HashSet r33 = new HashSet();
        Method r34 = a((String) p2.a(16777217, 0, 0, "aa5a6d", new byte[]{113, 109, 66, 7, 6, 122, 102, 14, 107, 34, 62, 80, 67, 7, 31, 122, 97, 69, 73, 48, 126, 98, 65, 16, 27})).getDeclaredMethod((String) p2.a(16777217, 0, 0, "3167c8", new byte[]{46, 58, 86, 87, 111, 42, 34, 6, 110, 100, 39, 32}), null);     // Catch: Exception -> L283
        r34.setAccessible(true);     // Catch: Exception -> L283
        String[] r35 = (String[]) r34.invoke(null, null);     // Catch: Exception -> L283
        if (r35 == null) goto L117;
        int r36 = r35.length;     // Catch: Exception -> L283
        int r37 = 0;
    L108:
        if (r37 >= r36) goto L117;
        String r38 = r35[r37];     // Catch: Exception -> L283
        int r42 = 0;
    L111:
        if (r42 >= 19) goto L116;
        String r45 = r32[r42];     // Catch: Exception -> L283
        if (r38.toLowerCase().contains(r45) == false) goto L115;
        r33.add(r45);     // Catch: Exception -> L283
    L115:
        r42 = r42 + 1;
        goto L111
    L116:
        r37 = r37 + 1;
    L117:
        r0 = r33.toString();
        goto L280
    L127:
        Intent r46 = b(m3.c(d2.b.a).a, new IntentFilter((String) p2.a(16777217, 0, 0, "ce3198", new byte[]{115, 105, 68, 87, 9, 38, 100, 10, 107, 111, 102, 98, 78, 81, 72, 46, 99, 80, 107, 110, 124, 41, 98, 100, 50, 27, 69, 118, 91, 94, 81, 79, 97, 107, 33, 10, 68})));
        if (r46 != null) goto L130;
        int r47 = -1;
    L131:
        r0 = Integer.valueOf(r47);
        goto L280
    L130:
        r47 = r46.getIntExtra((String) p2.a(16777217, 0, 0, "40011c", new byte[]{45, 55, 66, 73, 26, 124}), -1);
        goto L131
    L178:
        a4 r48 = a4.a();
        monitor-enter(r48);
        Throwable r49 = r48.b;     // Catch: Throwable -> L208
        monitor-exit(r48);
        if (r49 == null) goto L186;
        StackTraceElement[] r50 = r49.getStackTrace();
        int r51 = 4;
        if (r50.length < 4) goto L186;
        ?? r52 = new ArrayList();
        int r110 = 1;
    L188:
        if (r110 >= r51) goto L21;
        StackTraceElement r53 = r50[r110];
        if (r53 == null) goto L207;
        if (TextUtils.isEmpty(r53.getClassName()) == true) goto L207;
        Class r54 = a(r50[r110].getClassName());
        a4 r55 = a4.a();
        String r56 = r50[r110].getMethodName();
        r55.getClass();
        ArrayList r57 = new ArrayList();
        if (TextUtils.isEmpty(r56) == true) goto L206;
        Method[] r58 = r54.getDeclaredMethods();
        int r59 = r58.length;
        int r60 = 0;
    L198:
        if (r60 >= r59) goto L206;
        Method r61 = r58[r60];
        if (r61 == null) goto L205;
        if (r61.getName().equals(r56) == false) goto L205;
        r57.add(r61);
    L205:
        r60 = r60 + 1;
    L206:
        r52.addAll(r57);
    L207:
        r110 = r110 + 1;
        r51 = 4;
    L21:
        r0 = r52;
    L186:
        r7 = null;
    L208:
        th = move-exception;
        throw th;
    L212:
        r0 = v();
        goto L280
    L213:
        r0 = UUID.randomUUID().toString();
        goto L280
    L214:
        r0 = y();
        goto L280
    L215:
        Context r62 = d2.b.a;
        String[] r63 = r43.split((String) p2.a(16777217, 0, 0, "59abf3", new byte[]{24, 39}));
        String r64 = r63[0];
        String r65 = r63[1];
        SharedPreferences.Editor r66 = r62.getSharedPreferences(r64, 0).edit();
        r66.putString(r65, (String) r44);
        r66.commit();
        goto L216
    L217:
        r0 = d2.b.a.getSharedPreferences(r43, 0).getString((String) r44, null);
        goto L280
    L218:
        r0 = Integer.valueOf(m3.c(d2.b.a).d());
        goto L280
    L219:
        r0 = n();
        goto L280
    L220:
        r0 = m();
        goto L280
    L221:
        r7 = null;
        q();
        goto L248
    L222:
        Boolean r67 = Boolean.FALSE;
        TelephonyManager r68 = (TelephonyManager) d2.b.a.getApplicationContext().getSystemService((String) p2.a(16777217, 0, 0, "8e4e50", new byte[]{57, 111, 72, 31, 15}));
        r0 = r67;
        if (r68 == null) goto L280;
        r0 = r67;
        if (r68.getSimState() != 5) goto L280;
        r0 = Boolean.TRUE;
        goto L280
    L228:
        r0 = s();
        goto L280
    L229:
        r0 = u();
        goto L280
    L230:
        r0 = r();
        goto L280
    L231:
        r7 = null;
        x();
        goto L248
    L232:
        r7 = null;
        f(r43, (String[]) r44);
        goto L248
    L233:
        r0 = o();
        goto L280
    L234:
        Context r69 = d2.b.a;
        if (r69 == null) goto L237;
        r0 = r69.getPackageName();
        goto L280
    L237:
        r0 = "";
        goto L280
    L297:
    L155:
        r0 = "";
        goto L280
    L133:
        if (r3.j != null) goto L135;
        r3.j = new r3();     // Catch: Exception -> L155
    L135:
        r3 r70 = r3.j;     // Catch: Exception -> L155
        if (r70.a <= 0) goto L138;
    L143:
        JSONObject r111 = r70.c();     // Catch: Exception -> L155
    L144:
        JSONObject r71 = v3.e;     // Catch: Exception -> L155
        if (r71 != null) goto L147;
    L151:
        if (r111 != null) goto L153;
        r0 = "";
        goto L280
    L153:
        r0 = r111.toString();     // Catch: Exception -> L155
        goto L280
    L147:
        if (r71.length() <= 0) goto L151;
        if (r111 != null) goto L150;
        r111 = new JSONObject();     // Catch: Exception -> L155
    L150:
        r111.put((String) p2.a(16777217, 0, 0, "c8ef3f", new byte[]{124, 41, 4, 6}), r71);     // Catch: Exception -> L155
        goto L151
    L138:
        if (r70.b > 0) goto L143;
        if (r70.e > 0) goto L143;
        r111 = null;
        goto L144
    L305:
        MSConfig.Builder.IMsComplianceScene r72 = u2.b.a;     // Catch: Throwable -> L76
        if (r72 != null) goto L301;
    L69:
        boolean r73 = true;
    L70:
        if (r73 == true) goto L72;
        Object r74 = p2.a(16777217, 0, 0, "96d9c5", new byte[]{120});     // Catch: Throwable -> L76
    L74:
        r0 = (String) r74;     // Catch: Throwable -> L76
        goto L280
    L72:
        r74 = p2.a(16777217, 0, 0, "123efb", new byte[]{113});     // Catch: Throwable -> L76
        goto L74
    L301:
        r73 = r72.isComplianceScene(r43);     // Catch: Throwable -> L68
    L76:
        r0 = (String) p2.a(16777217, 0, 0, "154fd1", new byte[]{113});
        goto L280
    L311:
        r6 = a0.a(d2.b.a);     // Catch: Throwable -> L281
    L81:
        r0 = Integer.valueOf(r6);
        goto L280
    L119:
        if (Build.VERSION.SDK_INT >= 23) goto L307;
    L126:
        r0 = (String) p2.a(16777217, 0, 0, "bd6d21", new byte[]{35});
        goto L280
    L307:
        ConnectivityManager r75 = (ConnectivityManager) d2.b.a.getSystemService((String) p2.a(16777217, 0, 0, "867381", new byte[]{42, 59, 74, 73, 2, 37, 47, 30, 112, 106, 61, 45}));     // Catch: Throwable -> L284
        if (r75.getNetworkCapabilities(r75.getActiveNetwork()).hasTransport(4) == false) goto L123;
        Object r76 = p2.a(16777217, 0, 0, "96d27d", new byte[]{121});     // Catch: Throwable -> L284
    L124:
        r0 = (String) r76;     // Catch: Throwable -> L284
    L123:
        r76 = p2.a(16777217, 0, 0, "83a89f", new byte[]{121});     // Catch: Throwable -> L284
        goto L124
    L289:
        x1 r77 = w1.a(d2.b.a, r43);     // Catch: Throwable -> L159
    L161:
        r0 = r77.a();
    L159:
        th = move-exception;
        r77 = new x1(-100, "", "", th);
        goto L161
    L295:
        Method r78 = a((String) p2.a(16777217, 0, 0, "04b8e6", new byte[]{34, 57, 28, 2, 88, 56, 39, 16, 55, 105, 47, 53, 20, 2, 87, 46, 49, 6, 54, 107, 111, 37, 20, 66, 73, 46, 33, 91, 62, 100, 111, 27, 34, 110})).getMethod((String) p2.a(16777217, 0, 0, "6ac499", new byte[]{38}), null);     // Catch: Throwable -> L285
        if (r78 == null) goto L167;
        r0 = (Long) r78.invoke(null, null);     // Catch: Throwable -> L285
    L167:
        r7 = null;
        goto L248
    L169:
        if (n.b() == 1) goto L303;
        Object r79 = p2.a(16777217, 0, 0, "f20dac", new byte[]{39});
    L175:
        r0 = (String) r79;
        goto L280
    L303:
        d3.a();     // Catch: Throwable -> L286
    L173:
        if (TextUtils.isEmpty(null) == false) goto L177;
        r79 = p2.a(16777217, 0, 0, "74a71f", new byte[]{118});
        goto L175
    L177:
        throw null;
    L23:
        r0 = t();
        goto L280
    L24:
        r0 = a0.b();
        goto L280
    L25:
        r0 = p();
        goto L280
    L26:
        r0 = k();
        goto L280
    L27:
        r0 = l();
        goto L280
    L28:
        r0 = f0.a(d2.b.a);
        goto L280
    L17:
        r0 = e();
        goto L280
    L18:
        r0 = d(r43);
        goto L280
    L19:
        Context r80 = d2.b.a;
        ApplicationInfo r81 = r80.getPackageManager().getApplicationInfo(r80.getPackageName(), 0);
        r52 = r81.sourceDir;
        if (r52 != 0) goto L21;
        r0 = r81.publicSourceDir;
        goto L280
    L276:
        b.b(r41);
        r0 = Boolean.TRUE;
        goto L280
    }
}
