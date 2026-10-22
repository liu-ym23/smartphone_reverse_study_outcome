package pta;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import jta.g;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class c {
    public static final a a = null;

    public static class a extends e<String> {
        public a() {
        }

        @Override // pta.e
        public final String a(Object[] r17) {
            Context r0 = (Context) r17[0];
            String r2 = "";
            if (r0 == null) goto L71;
            d.a r3 = d.a;
            int r4 = Build.VERSION.SDK_INT;
            if (r4 < 29) goto L7;
        L12:
            boolean r5 = true;
        L13:
            if (r5 == true) goto L15;
        L20:
            g r6 = g.a;
            WifiInfo r7 = c.c((WifiManager) r0.getApplicationContext().getSystemService("wifi"));     // Catch: Exception -> L25
            String r8 = c.b(r7);     // Catch: Exception -> L25
            if (((ConnectivityManager) r0.getApplicationContext().getSystemService("connectivity")).getNetworkInfo(1).getState() != NetworkInfo.State.CONNECTED) goto L27;
            if (r8 == null) goto L27;
        L28:
            if (r7 == null) goto L34;
            f06.c r1 = new f06.c();
            Object[] r9 = new Object[0];
            f06.b r13 = new f06.b();
            f06.d r14 = r1.b(101700, "android/net/wifi/WifiInfo", "getMacAddress", r7, r9, "java.lang.String", r13);
            if (r14.a == false) goto L32;
            r1.a(101700, "android/net/wifi/WifiInfo", "getMacAddress", r7, r9, null, r13, false);
            r2 = (String) r14.b;
            goto L34
        L32:
            String r15 = r7.getMacAddress();
            r1.a(101700, "android/net/wifi/WifiInfo", "getMacAddress", r7, r9, r15, r13, true);
            r2 = r15;
        L34:
            if ("02:00:00:00:00:00".equals(r2) == false) goto L36;
        L57:
            Enumeration<NetworkInterface> r10 = NetworkInterface.getNetworkInterfaces();     // Catch: Exception -> L54
            String r11 = c.p();     // Catch: Exception -> L54
        L38:
            if (r10.hasMoreElements() == false) goto L75;
            NetworkInterface r12 = r10.nextElement();     // Catch: Exception -> L54
            byte[] r16 = c.l(r12);     // Catch: Exception -> L54
            if (r16 == null) goto L38;
            if (r16.length == 0) goto L38;
            StringBuilder r18 = new StringBuilder();     // Catch: Exception -> L54
            int r19 = r16.length;     // Catch: Exception -> L54
            int r20 = 0;
        L46:
            if (r20 >= r19) goto L49;
            r18.append(String.format("%02X:", new Object[]{Byte.valueOf(r16[r20])}));     // Catch: Exception -> L54
            r20 = r20 + 1;     // Catch: Exception -> L54
            goto L46
        L49:
            if (r18.length() <= 0) goto L51;
            r18.deleteCharAt(r18.length() - 1);     // Catch: Exception -> L54
        L51:
            String r21 = r18.toString();     // Catch: Exception -> L54
            if (r12.getName().equals(r11) == false) goto L38;
            return r21;
        L75:
            return r2;
        L54:
            e = move-exception;
            e.printStackTrace();
            return r2;
        L36:
            if (TextUtils.isEmpty(r2) == true) goto L57;
            return r2;
        L27:
            r7 = null;
        L25:
            e = move-exception;
            e.printStackTrace();
            goto L27
        L15:
            if (r0.getApplicationInfo().targetSdkVersion < 29) goto L17;
            boolean r22 = true;
        L18:
            if (r22 == false) goto L20;
            return "";
        L17:
            r22 = false;
            goto L18
        L7:
            if (r4 == 28) goto L9;
        L11:
            r5 = false;
            goto L13
        L9:
            if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L11;
        L71:
            return "";
        }
    }

    static {
        a = new a();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.SystemProperties");
    }

    public static String d() {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(101200);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r9 = r3;
        int r8 = r9.length;
        int r7 = 0;
    L8:
        if (r7 >= r8) goto L15;
        f06.a r6 = r9[r7];
        int r16 = r7;
        int r17 = r8;
        f06.a[] r18 = r9;
        f06.d r4 = r6.preInvoke(101200, "android/os/Build", "getSerial", Build.class, r10, "java.lang.String", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r6);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (String) r4.b;
    L21:
        return Build.getSerial();
    L14:
        r7 = r16 + 1;
        r8 = r17;
        r9 = r18;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static String p() {
        Class r1 = a();     // Catch: Exception -> L5
        return (String) r1.getMethod("get", new Class[]{String.class, String.class}).invoke(r1, new Object[]{"wifi.interface", "wlan0"});
    L5:
        e = move-exception;
        e.printStackTrace();
        return "wlan0";
    }

    public static String b(WifiInfo r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(101000);
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
        f06.d r4 = r7.preInvoke(101000, "android/net/wifi/WifiInfo", "getSSID", r18, r10, "java.lang.String", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (String) r4.b;
    L21:
        return r18.getSSID();
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

    public static WifiInfo c(WifiManager r18) {
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

    public static String e(ContentResolver r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13, "android_id"};
        f06.b r11 = new f06.b();
        f06.d r12 = r8.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r9, "java.lang.String", r11);
        if (r12.a == false) goto L6;
        r8.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r9, null, r11, false);
        return (String) r12.b;
    L6:
        String r14 = Settings.Secure.getString(r13, "android_id");
        r8.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r9, r14, r11, true);
        return r14;
    }

    public static String f(SubscriptionInfo r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(101500, "android/telephony/SubscriptionInfo", "getIccId", r13, r9, "java.lang.String", r10);
        if (r11.a == false) goto L6;
        r8.a(101500, "android/telephony/SubscriptionInfo", "getIccId", r13, r9, null, r10, false);
        return (String) r11.b;
    L6:
        String r12 = r13.getIccId();
        r8.a(101500, "android/telephony/SubscriptionInfo", "getIccId", r13, r9, r12, r10, true);
        return r12;
    }

    public static List g(SubscriptionManager r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102008);
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
        f06.d r4 = r7.preInvoke(102008, "android/telephony/SubscriptionManager", "getActiveSubscriptionInfoList", r18, r10, "java.util.List", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (List) r4.b;
    L21:
        return r18.getActiveSubscriptionInfoList();
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

    public static String h(TelephonyManager r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(101600, "android/telephony/TelephonyManager", "getDeviceId", r13, r9, "java.lang.String", r10);
        if (r11.a == false) goto L6;
        r8.a(101600, "android/telephony/TelephonyManager", "getDeviceId", r13, r9, null, r10, false);
        return (String) r11.b;
    L6:
        String r12 = r13.getDeviceId();
        r8.a(101600, "android/telephony/TelephonyManager", "getDeviceId", r13, r9, r12, r10, true);
        return r12;
    }

    public static String k(TelephonyManager r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(101400, "android/telephony/TelephonyManager", "getSimSerialNumber", r13, r9, "java.lang.String", r10);
        if (r11.a == false) goto L6;
        r8.a(101400, "android/telephony/TelephonyManager", "getSimSerialNumber", r13, r9, null, r10, false);
        return (String) r11.b;
    L6:
        String r12 = r13.getSimSerialNumber();
        r8.a(101400, "android/telephony/TelephonyManager", "getSimSerialNumber", r13, r9, r12, r10, true);
        return r12;
    }

    public static byte[] l(NetworkInterface r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(101701, "java/net/NetworkInterface", "getHardwareAddress", r13, r9, "byte[]", r10);
        if (r11.a == false) goto L6;
        r8.a(101701, "java/net/NetworkInterface", "getHardwareAddress", r13, r9, null, r10, false);
        return (byte[]) r11.b;
    L6:
        byte[] r12 = r13.getHardwareAddress();
        r8.a(101701, "java/net/NetworkInterface", "getHardwareAddress", r13, r9, r12, r10, true);
        return r12;
    }

    public static JSONArray o(Context r8) throws JSONException {
        g r2 = g.a;
        boolean r3 = g.e;
        JSONArray r4 = new JSONArray();
        TelephonyManager r5 = (TelephonyManager) r8.getSystemService("phone");
        if (Build.VERSION.SDK_INT >= 26) goto L28;
        r4.put(m(n(r8, 0), 0, "unknown"));
        r4.put(m(n(r8, 1), 1, "unknown"));
    L21:
        return r4;
    L28:
        r4.put(m(j(r5, 0), 0, "meid"));     // Catch: Exception -> L6
    L26:
        r4.put(m(j(r5, 1), 1, "meid"));     // Catch: Exception -> L10
    L24:
        r4.put(m(i(r5, 0), 0, "imei"));     // Catch: Exception -> L14
    L22:
        r4.put(m(i(r5, 1), 1, "imei"));     // Catch: Exception -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
    L14:
        e = move-exception;
        e.printStackTrace();
    L10:
        e = move-exception;
        e.printStackTrace();
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L26
    }

    public static String q(Context r21) {
        if (r21 != null) goto L5;
        return null;
    L5:
        int r1 = Build.VERSION.SDK_INT;
        if (r1 >= 26) goto L8;
    L10:
        g r3 = g.a;
        if (r1 >= 26) goto L13;
    L17:
        String r2 = null;
    L19:
        if (StringUtils.isEmpty(r2) == false) goto L21;
    L22:
        ArrayList r4 = new ArrayList();
        Object[] r12 = new Object[0];
        f06.b r13 = new f06.b();
        g06.a r5 = (g06.a) ApiHookConfig.b.get(102002);
        if (r5 == null) goto L25;
        f06.a[] r6 = r5.i;
    L26:
        f06.a[] r11 = r6;
        int r10 = r11.length;
        int r9 = 0;
    L28:
        if (r9 >= r10) goto L35;
        f06.a r8 = r11[r9];
        int r18 = r9;
        int r19 = r10;
        f06.a[] r20 = r11;
        f06.d r7 = r8.preInvoke(102002, "android/os/Build", "SERIAL", Build.class, r12, "java.lang.String", r13);     // Catch: Exception -> L49
        if (r7.a == true) goto L37;
        r4.add(r8);     // Catch: Exception -> L49
    L37:
        if (r7.a == false) goto L39;
        String r0 = (String) r7.b;
    L40:
        r2 = r0;
    L42:
        if (StringUtils.isEmpty(r2) == false) goto L44;
        return "";
    L44:
        if (TextUtils.equals(r2, "unknown") == true) goto L57;
        return r2;
    L57:
        return "";
    L39:
        r0 = Build.SERIAL;
    L34:
        r9 = r18 + 1;
        r10 = r19;
        r11 = r20;
        goto L28
    L35:
        r7 = new f06.d(false, null);
        goto L37
    L25:
        r6 = ApiHookConfig.d;
        goto L26
    L21:
        if (TextUtils.equals(r2, "unknown") == false) goto L42;
    L13:
        if (r21.getApplicationInfo().targetSdkVersion < 26) goto L17;
        r2 = d();     // Catch: SecurityException -> L16
    L8:
        if (r21.getApplicationInfo().targetSdkVersion < 26) goto L10;
        g r14 = g.a;
        goto L10
    }

    public static String[] r(Context r5) {
        if (r5 == null) goto L34;
        d.a r1 = d.a;
        int r2 = Build.VERSION.SDK_INT;
        int r3 = 0;
        if (r2 < 30) goto L7;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == true) goto L35;
        g r6 = g.a;
        if (r2 < 22) goto L36;
        List r7 = g(SubscriptionManager.from(r5));     // Catch: Throwable -> L29
        if (r7 != null) goto L20;
    L26:
        return null;
    L20:
        if (r7.isEmpty() == true) goto L26;
        String[] r0 = new String[r7.size()];     // Catch: Throwable -> L29
    L24:
        if (r3 >= r7.size()) goto L37;
        r0[r3] = f((SubscriptionInfo) ListProtector.get(r7, r3));     // Catch: Throwable -> L29
        r3 = r3 + 1;     // Catch: Throwable -> L29
        goto L24
    L37:
        return r0;
    L36:
        return new String[]{k((TelephonyManager) r5.getSystemService("phone"))};
    L29:
        th = move-exception;
        th.printStackTrace();
        return null;
    L35:
        return null;
    L7:
        if (r2 == 29) goto L9;
    L11:
        r4 = false;
        goto L13
    L9:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L11;
    L34:
        return null;
    }

    public static String i(TelephonyManager r12, int r13) throws JSONException {
        f06.c r8 = new f06.c();
        Object[] r9 = {Integer.valueOf(r13)};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(101601, "android/telephony/TelephonyManager", "getImei", r12, r9, "java.lang.String", r10);
        if (r11.a == false) goto L6;
        r8.a(101601, "android/telephony/TelephonyManager", "getImei", r12, r9, null, r10, false);
        return (String) r11.b;
    L6:
        String r14 = r12.getImei(r13);
        r8.a(101601, "android/telephony/TelephonyManager", "getImei", r12, r9, r14, r10, true);
        return r14;
    }

    public static String j(TelephonyManager r12, int r13) throws JSONException {
        f06.c r8 = new f06.c();
        Object[] r9 = {Integer.valueOf(r13)};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(101602, "android/telephony/TelephonyManager", "getMeid", r12, r9, "java.lang.String", r10);
        if (r11.a == false) goto L6;
        r8.a(101602, "android/telephony/TelephonyManager", "getMeid", r12, r9, null, r10, false);
        return (String) r11.b;
    L6:
        String r14 = r12.getMeid(r13);
        r8.a(101602, "android/telephony/TelephonyManager", "getMeid", r12, r9, r14, r10, true);
        return r14;
    }

    public static String n(Context r11, int r12) {
        Object r1 = null;
        TelephonyManager r13 = (TelephonyManager) r11.getSystemService("phone");     // Catch: Exception -> L24
        Class<?> r2 = r13.getClass();     // Catch: Exception -> L24
        Method[] r5 = TelephonyManager.class.getDeclaredMethods();     // Catch: Exception -> L17
        int r6 = r5.length;     // Catch: Exception -> L17
        Class<?>[] r8 = null;
        int r7 = 0;
    L7:
        if (r7 >= r6) goto L20;
        Method r9 = r5[r7];     // Catch: Exception -> L15
        if ("getDeviceId".equals(r9.getName()) == false) goto L14;
        r8 = r9.getParameterTypes();     // Catch: Exception -> L15
        if (r8.length < 1) goto L14;
    L14:
        r7 = r7 + 1;
    L15:
        e = e;
    L19:
        e.printStackTrace();     // Catch: Exception -> L24
        e.getMessage();     // Catch: Exception -> L24
    L20:
        Method r0 = r2.getMethod("getDeviceId", r8);     // Catch: Exception -> L24
        if (r12 < 0) goto L27;
        r1 = r0.invoke(r13, new Object[]{Integer.valueOf(r12)});     // Catch: Exception -> L24
    L27:
        return (String) r1;
    L17:
        e = e;
        r8 = null;
    L24:
        e = move-exception;
        e.printStackTrace();
        e.getMessage();
        goto L27
    }

    public static JSONObject m(String r2, int r3, String r4) throws JSONException {
        JSONObject r0 = new JSONObject();
        if (TextUtils.isEmpty(r2) == true) goto L5;
        r0.put("id", r2);
        r0.put("slot_index", r3);
        r0.put("type", r4);
    L5:
        return r0;
    }
}
