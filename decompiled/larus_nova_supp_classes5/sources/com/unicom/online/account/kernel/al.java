package com.unicom.online.account.kernel;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.common.EffectRequest;
import f06.c;
import f06.d;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import kotlin.UByte;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class al {
    private static final char[] a = null;
    private static int b;
    private static int c;

    static {
        a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        b = 1;
        c = 0;
    }

    public static String a() {
        return ak.d();
    }

    public static String a(int r0) {
        return aj.a(r0);
    }

    public static String a(Context r1) {
        return com_unicom_online_account_kernel_al_android_telephony_TelephonyManager_getSimOperator((TelephonyManager) r1.getSystemService("phone"));
    }

    public static String a(Context r0, String r1) {
        return b(b(r0, r1));
    L4:
        e = move-exception;
        aj.a(e);
        return "";
    }

    public static String a(Context r0, String r1, String r2) {
        return a(b(r0, r1), r2.toLowerCase());
    L4:
        e = move-exception;
        aj.a(e);
        return "";
    }

    public static String a(String r5) {
        MessageDigest r1 = MessageDigest.getInstance(new String(o.b("U0hBMjU2")));     // Catch: NoSuchAlgorithmException -> L15
        r1.update(r5.getBytes());     // Catch: NoSuchAlgorithmException -> L15
        byte[] r6 = r1.digest();     // Catch: NoSuchAlgorithmException -> L15
        StringBuffer r2 = new StringBuffer("");     // Catch: NoSuchAlgorithmException -> L15
        int r3 = 0;
    L5:
        if (r3 >= r6.length) goto L13;
        int r4 = r6[r3];     // Catch: NoSuchAlgorithmException -> L15
        if (r4 >= 0) goto L10;
        r4 = r4 + 256;     // Catch: NoSuchAlgorithmException -> L15
    L10:
        if (r4 >= 16) goto L12;
        r2.append("0");     // Catch: NoSuchAlgorithmException -> L15
    L12:
        r2.append(Integer.toHexString(r4));     // Catch: NoSuchAlgorithmException -> L15
        r3 = r3 + 1;     // Catch: NoSuchAlgorithmException -> L15
        goto L5
    L13:
        return r2.toString();
    L15:
        e = move-exception;
        aj.a(e);
        return "";
    }

    public static String a(String r0, String r1, String r2) {
        return n.b(r0, r1, r2);
    }

    private static String a(List<String> r11) {
        JSONObject r0 = new JSONObject();
        StringBuffer r1 = new StringBuffer();
        StringBuffer r2 = new StringBuffer();
        if (r11.size() == 0) goto L45;
        int r3 = 0;
        int r5 = 0;
    L6:
        if (r5 >= r11.size()) goto L28;
        String r6 = (String) ListProtector.get(r11, r5);
        String r7 = r6.substring(0, 3);
        byte[] r8 = InetAddress.getByName(r6).getAddress();     // Catch: UnknownHostException -> L24
        if (r6.length() == 0) goto L23;
        if (r8.length != 4) goto L19;
        if (r7.equals("127") == true) goto L23;
        if (r7.equals("192") == true) goto L23;
        r1.append(r6);     // Catch: UnknownHostException -> L24
        r1.append("-");     // Catch: UnknownHostException -> L24
        goto L23
    L19:
        if (r6.contains("%") == true) goto L23;
        if ("::1".equals(r6) == true) goto L23;
        r2.append(r6);     // Catch: UnknownHostException -> L24
        r2.append("-");     // Catch: UnknownHostException -> L24
    L23:
        r5 = r5 + 1;
    L24:
        e = move-exception;
        aj.a(e);
        return "{\"privateIp\":\"0.0.0.0\"}";
    L28:
        if (r1.length() == 0) goto L35;
        if ('-' != r1.charAt(r1.length() - 1)) goto L35;
        StringBuffer r12 = r1.deleteCharAt(r1.length() - 1);
        int r4 = Math.min(r2.length(), 5);
        int r9 = 0;
    L32:
        if (r9 >= r4) goto L35;
        r0.put("privateIp", r12);
        r9 = r9 + 1;
    L35:
        if (r2.length() == 0) goto L42;
        if ('-' != r2.charAt(r2.length() - 1)) goto L42;
        StringBuffer r13 = r2.deleteCharAt(r2.length() - 1);
        int r10 = Math.min(r2.length(), 5);
    L39:
        if (r3 >= r10) goto L42;
        r0.put("privateIp_v6", r13);
        r3 = r3 + 1;
    L42:
        if (r0.length() <= 0) goto L45;
        return r0.toString();
    L45:
        return "{\"privateIp\":\"0.0.0.0\"}";
    }

    private static String a(byte[] r5) {
        String r0 = "";
        int r1 = 0;
    L4:
        if (r1 >= r5.length) goto L11;
        if (r1 == 0) goto L7;
        r0 = r0 + ":";
    L7:
        String r2 = Integer.toHexString(r5[r1] & UByte.MAX_VALUE);
        if (r2.length() != 1) goto L10;
        r0 = r0 + "0";
    L10:
        r0 = r0 + r2;
        r1 = r1 + 1;
        goto L4
    L11:
        return r0;
    }

    private static String a(byte[] r0, String r1) {
        return a(MessageDigest.getInstance(r1).digest(r0));
    L4:
        e = move-exception;
        aj.a(e);
        return "";
    }

    private static boolean a(ConnectivityManager r5) {
        Method r1 = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);     // Catch: Exception -> L5
        r1.setAccessible(true);     // Catch: Exception -> L5
        return ((Boolean) r1.invoke(r5, new Object[0])).booleanValue();
    L5:
        e = move-exception;
        aj.a(e);
        return true;
    }

    public static int b(Context r0) {
        int r1 = d(r0);
        ak.a(r1);
        return r1;
    }

    public static String b(String r5) {
        MessageDigest r1 = MessageDigest.getInstance(new String(o.b("TUQ1")));     // Catch: NoSuchAlgorithmException -> L15
        r1.update(r5.getBytes());     // Catch: NoSuchAlgorithmException -> L15
        byte[] r6 = r1.digest();     // Catch: NoSuchAlgorithmException -> L15
        StringBuffer r2 = new StringBuffer("");     // Catch: NoSuchAlgorithmException -> L15
        int r3 = 0;
    L5:
        if (r3 >= r6.length) goto L13;
        int r4 = r6[r3];     // Catch: NoSuchAlgorithmException -> L15
        if (r4 >= 0) goto L10;
        r4 = r4 + 256;     // Catch: NoSuchAlgorithmException -> L15
    L10:
        if (r4 >= 16) goto L12;
        r2.append("0");     // Catch: NoSuchAlgorithmException -> L15
    L12:
        r2.append(Integer.toHexString(r4));     // Catch: NoSuchAlgorithmException -> L15
        r3 = r3 + 1;     // Catch: NoSuchAlgorithmException -> L15
        goto L5
    L13:
        return r2.toString();
    L15:
        e = move-exception;
        aj.a(e);
        return "";
    }

    public static String b(String r0, String r1, String r2) {
        return n.a(r0, r1, r2);
    }

    private static String b(byte[] r3) {
        SM3Digest r0 = new SM3Digest();     // Catch: Exception -> L4
        r0.update(r3, 0, r3.length);     // Catch: Exception -> L4
        byte[] r4 = new byte[r0.getDigestSize()];     // Catch: Exception -> L4
        r0.doFinal(r4, 0);     // Catch: Exception -> L4
        return a(r4);
    L4:
        e = move-exception;
        aj.a(e);
        return "";
    }

    public static void b() {
        aj.a();
    }

    private static byte[] b(Context r3, String r4) {
        PackageManager r0 = r3.getPackageManager();
        PackageInfo r5 = r0.getPackageInfo(r3.getPackageName(), 64);     // Catch: Exception -> L9
        if (r5.packageName.equals(r4) == true) goto L7;
        return null;
    L7:
        return r5.signatures[0].toByteArray();
    L9:
        e = move-exception;
        aj.a(e);
        return null;
    }

    public static int c() {
        c = 0;
        b = 0;
        return 0;
    }

    public static String c(Context r3) {
        ApplicationInfo r0 = r3.getPackageManager().getApplicationInfo(r3.getPackageName(), 0);     // Catch: Exception -> L4
        return (String) r3.getPackageManager().getApplicationLabel(r0);
    L4:
        return "";
    }

    public static String c(String r3) {
        SM3Digest r0 = new SM3Digest();
        byte[] r4 = r3.getBytes(Charset.forName(EffectRequest.DEFAULT_PARAMS_ENCODING));
        r0.update(r4, 0, r4.length);
        byte[] r5 = new byte[r0.getDigestSize()];
        r0.doFinal(r5, 0);
        return u.a(r5);
    }

    public static int d() {
        return b;
    }

    private static int d(Context r4) {
        ConnectivityManager r5 = (ConnectivityManager) r4.getApplicationContext().getSystemService("connectivity");     // Catch: Exception -> L24
        NetworkInfo r1 = r5.getActiveNetworkInfo();     // Catch: Exception -> L24
        if (r1 != null) goto L6;
    L23:
        return -1;
    L6:
        if (r1.isAvailable() == false) goto L23;
        if (r1.getType() != 1) goto L17;
        if (a(r5) == false) goto L14;
        aj.a("Data and WIFI");     // Catch: Exception -> L24
        return 1;
    L14:
        aj.a("Only WIFI");     // Catch: Exception -> L24
        return 2;
    L17:
        if (r1.getType() != 0) goto L26;
        aj.a("Only Data");     // Catch: Exception -> L24
        String r6 = com_unicom_online_account_kernel_al_android_net_NetworkInfo_getExtraInfo(r1);     // Catch: Exception -> L24
        if (TextUtils.isEmpty(r6) == true) goto L28;
        ak.d(r6);     // Catch: Exception -> L24
        ak.b(ak.e(r6));     // Catch: Exception -> L24
        return 0;
    L28:
        return 0;
    L26:
        return -1;
    L24:
        e = move-exception;
        aj.a(e);
        goto L26
    }

    public static int d(String r2) {
        byte[] r3 = InetAddress.getByName(r2).getAddress();
        int r0 = (((r3[3] & UByte.MAX_VALUE) << 24) | ((r3[2] & UByte.MAX_VALUE) << 16)) | ((r3[1] & UByte.MAX_VALUE) << 8);
        return (r3[0] & UByte.MAX_VALUE) | r0;
    L5:
        return -1;
    }

    public static int e() {
        return c;
    }

    public static void e(String r1) {
        aj.a(0, r1);
    }

    public static int f() {
        int r0 = c;
        if (r0 < 0) goto L9;
        if (r0 > b) goto L9;
        int r1 = r0 + 1;
        c = r1;
        return r1;
    L9:
        return b;
    }

    public static String g() {
        return a(h());
    L4:
        return "{\"privateIp\":\"0.0.0.0\"}";
    }

    private static List<String> h() {
        ArrayList r0 = new ArrayList();
        Enumeration<NetworkInterface> r1 = NetworkInterface.getNetworkInterfaces();     // Catch: SocketException -> L29
        if (r1 == null) goto L31;
    L5:
        if (r1.hasMoreElements() == false) goto L31;
        NetworkInterface r2 = r1.nextElement();     // Catch: SocketException -> L29
        if (r2.isVirtual() == true) goto L5;
        if (r2.isUp() == false) goto L5;
        Enumeration<InetAddress> r3 = r2.getInetAddresses();     // Catch: SocketException -> L29
        if (r3 == null) goto L5;
    L14:
        if (r3.hasMoreElements() == false) goto L5;
        InetAddress r4 = r3.nextElement();     // Catch: SocketException -> L29
        if (r4.isLoopbackAddress() == true) goto L14;
        if (r4.isLinkLocalAddress() == true) goto L14;
        if (r4.isMulticastAddress() == true) goto L14;
        if (r4.isAnyLocalAddress() == true) goto L14;
        if ((r4 instanceof Inet4Address) == true) goto L27;
        if ((r4 instanceof Inet6Address) == false) goto L14;
    L27:
        r0.add(r4.getHostAddress());     // Catch: SocketException -> L29
    L31:
        return r0;
    L29:
        e = move-exception;
        aj.a(e);
        goto L31
    }

    private static String com_unicom_online_account_kernel_al_android_net_NetworkInfo_getExtraInfo(NetworkInfo r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102026);
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
        d r4 = r7.preInvoke(102026, "android/net/NetworkInfo", "getExtraInfo", r18, r10, "java.lang.String", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (String) r4.b;
    L21:
        return r18.getExtraInfo();
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    private static String com_unicom_online_account_kernel_al_android_telephony_TelephonyManager_getSimOperator(TelephonyManager r13) {
        c r8 = new c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        d r11 = r8.b(102021, "android/telephony/TelephonyManager", "getSimOperator", r13, r9, "java.lang.String", r10);
        if (r11.a == false) goto L6;
        r8.a(102021, "android/telephony/TelephonyManager", "getSimOperator", r13, r9, null, r10, false);
        return (String) r11.b;
    L6:
        String r12 = r13.getSimOperator();
        r8.a(102021, "android/telephony/TelephonyManager", "getSimOperator", r13, r9, r12, r10, true);
        return r12;
    }
}
