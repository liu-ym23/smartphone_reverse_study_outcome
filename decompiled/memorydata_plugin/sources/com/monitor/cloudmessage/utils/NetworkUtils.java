package com.monitor.cloudmessage.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.RouteInfo;
import android.net.TrafficStats;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.apm.util.k;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f5859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f5860b;
    private static long c;
    private static long d;

    /* JADX INFO: renamed from: com.monitor.cloudmessage.utils.NetworkUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5861a = null;

        static {
            int[] r0 = new int[NetworkType.values().length];
            f5861a = r0;
            r0[NetworkType.WIFI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f5861a[NetworkType.MOBILE_2G.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f5861a[NetworkType.MOBILE_3G.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f5861a[NetworkType.MOBILE_4G.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f5861a[NetworkType.MOBILE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static final enum NetworkType extends Enum<NetworkType> {
        private static final /* synthetic */ NetworkType[] $VALUES = null;
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType WIFI = null;
        final int nativeInt;

        static {
            NetworkType r0 = new NetworkType("NONE", 0, 0);
            NONE = r0;
            NetworkType r1 = new NetworkType("MOBILE", 1, 1);
            MOBILE = r1;
            NetworkType r3 = new NetworkType("MOBILE_2G", 2, 2);
            MOBILE_2G = r3;
            NetworkType r5 = new NetworkType("MOBILE_3G", 3, 3);
            MOBILE_3G = r5;
            NetworkType r7 = new NetworkType("WIFI", 4, 4);
            WIFI = r7;
            NetworkType r9 = new NetworkType("MOBILE_4G", 5, 5);
            MOBILE_4G = r9;
            $VALUES = new NetworkType[]{r0, r1, r3, r5, r7, r9};
        }

        private NetworkType(String r1, int r2, int r3) {
            super(r1, r2);
            this.nativeInt = r3;
        }

        public static NetworkType valueOf(String r2) {
            return (NetworkType) ZeusTransformUtils.preCheckCast(Enum.valueOf(NetworkType.class, r2), NetworkType.class, "com.obric.memorydata.plugin");
        }

        public static NetworkType[] values() {
            return (NetworkType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NetworkType[].class, "com.obric.memorydata.plugin");
        }

        public int getValue() {
            return this.nativeInt;
        }
    }

    static {
    }

    private static long a(int r4) {
        return TrafficStats.getTotalRxBytes() / 1024;
    }

    public static String a() {
        String r1 = "none";
        Enumeration<NetworkInterface> r2 = NetworkInterface.getNetworkInterfaces();     // Catch: SocketException -> L21
    L4:
        if (r2.hasMoreElements() == false) goto L23;
        NetworkInterface r3 = (NetworkInterface) ZeusTransformUtils.preCheckCast(r2.nextElement(), NetworkInterface.class, "com.obric.memorydata.plugin");     // Catch: SocketException -> L21
        String r4 = r3.getName();     // Catch: SocketException -> L21
        if (r4 == null) goto L4;
        if (TextUtils.equals(r4.toLowerCase(), "eth0") == true) goto L12;
        if (TextUtils.equals(r4.toLowerCase(), "wlan0") == false) goto L4;
    L12:
        Enumeration<InetAddress> r5 = r3.getInetAddresses();     // Catch: SocketException -> L21
    L14:
        if (r5.hasMoreElements() == false) goto L4;
        InetAddress r6 = (InetAddress) ZeusTransformUtils.preCheckCast(r5.nextElement(), InetAddress.class, "com.obric.memorydata.plugin");     // Catch: SocketException -> L21
        if (ZeusTransformUtils.instanceOf(r6, Inet4Address.class) == false) goto L14;
        if (r6.isLoopbackAddress() == true) goto L14;
        r1 = r6.getHostAddress();     // Catch: SocketException -> L21
    L23:
        return r1;
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    }

    private static String a(NetworkType r2) {
        int r3 = AnonymousClass1.f5861a[r2.ordinal()];     // Catch: Exception -> L21
        if (r3 != 1) goto L6;
        String r4 = LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI;
    L20:
        return r4;
    L6:
        if (r3 != 2) goto L8;
        r4 = "2g";
        goto L20
    L8:
        if (r3 != 3) goto L10;
        r4 = "3g";
        goto L20
    L10:
        if (r3 != 4) goto L12;
        r4 = "4g";
        goto L20
    L12:
        if (r3 != 5) goto L24;
        r4 = "mobile";
        goto L20
    L24:
        return "";
    L25:
        return "";
    }

    public static List<String> a(String r4) {
        ArrayList r0 = new ArrayList();
        InetAddress[] r5 = InetAddress.getAllByName(r4);     // Catch: UnknownHostException -> L11
        if (r5 != null) goto L6;
    L13:
        return r0;
    L6:
        if (r5.length <= 0) goto L13;
        int r1 = r5.length;     // Catch: UnknownHostException -> L11
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L13;
        r0.add(r5[r2].getHostAddress());     // Catch: UnknownHostException -> L11
        r2 = r2 + 1;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public static boolean a(Context r3) {
        NetworkInfo r4 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin")).getActiveNetworkInfo();     // Catch: Exception -> L13
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r4.isAvailable() == false) goto L17;
        if (1 == r4.getType()) goto L12;
        return false;
    L12:
        return true;
    L17:
        return false;
    L19:
        return false;
    }

    public static boolean a(String r7, JSONObject r8) {
        JSONObject r0 = new JSONObject();
        boolean r1 = false;
        HttpURLConnection r2 = null;
        r2 = k.a(r7);     // Catch: Throwable -> L10 Exception -> L12
        r2.setRequestMethod(HttpMethodContrants.GET);     // Catch: Throwable -> L10 Exception -> L12
        r2.setReadTimeout(LocationInfoConst.HALF_MINUTES);     // Catch: Throwable -> L10 Exception -> L12
        r2.setConnectTimeout(LocationInfoConst.HALF_MINUTES);     // Catch: Throwable -> L10 Exception -> L12
        r2.setDoInput(true);     // Catch: Throwable -> L10 Exception -> L12
        r2.setDoOutput(true);     // Catch: Throwable -> L10 Exception -> L12
        r2.setUseCaches(false);     // Catch: Throwable -> L10 Exception -> L12
        r2.setRequestProperty("Charset", com.monitor.cloudmessage.f.c.a.f5858b);     // Catch: Throwable -> L10 Exception -> L12
        int r4 = r2.getResponseCode();     // Catch: Throwable -> L10 Exception -> L12
        r0.put("statusCode", r4);     // Catch: Throwable -> L10 Exception -> L12
        r0.put("header", e.a(r2.getHeaderFields()));     // Catch: Throwable -> L10 Exception -> L12
        r8.put(r7, r0);     // Catch: Throwable -> L10 Exception -> L12
    L5:
        if (r4 != 200) goto L7;
        r1 = true;
    L7:
        if (r2 == null) goto L9;
        r2.disconnect();
    L9:
        return r1;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
        r8.put(r7, e.getMessage());     // Catch: Throwable -> L10 JSONException -> L18
        if (r2 == null) goto L17;
        r2.disconnect();
    L17:
        return false;
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
        if (r2 == null) goto L22;
        r2.disconnect();
    L22:
        return false;
    L10:
        th = move-exception;
        if (r2 == null) goto L25;
        r2.disconnect();
    L25:
        throw th;
    }

    private static long b(int r4) {
        return TrafficStats.getTotalTxBytes() / 1024;
    }

    public static boolean b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L14;
        return false;
    L14:
        NetworkInfo r5 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(r4.getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin")).getActiveNetworkInfo();     // Catch: Exception -> L11
        if (r5 == null) goto L16;
        if (r5.isConnected() == false) goto L17;
        return true;
    L17:
        return false;
    L16:
        return false;
    L11:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static List<String> c(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        if (r10 != null) goto L5;
    L18:
        return r0;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L18;
        ConnectivityManager r11 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(r10.getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L16
        NetworkInfo r2 = r11.getActiveNetworkInfo();     // Catch: Exception -> L16
        Network[] r3 = r11.getAllNetworks();     // Catch: Exception -> L16
        int r4 = r3.length;     // Catch: Exception -> L16
        int r5 = 0;
    L7:
        if (r5 >= r4) goto L18;
        Network r6 = r3[r5];     // Catch: Exception -> L16
        if (r11.getNetworkInfo(r6).getType() != r2.getType()) goto L15;
        Iterator<InetAddress> r7 = r11.getLinkProperties(r6).getDnsServers().iterator();     // Catch: Exception -> L16
    L12:
        if (r7.hasNext() == false) goto L15;
        r0.add(((InetAddress) ZeusTransformUtils.preCheckCast(r7.next(), InetAddress.class, "com.obric.memorydata.plugin")).getHostAddress());     // Catch: Exception -> L16
    L15:
        r5 = r5 + 1;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    public static String d(Context r8) {
        long r0 = a(((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin")).getApplicationInfo().uid);
        if (r0 != (-1)) goto L6;
        return "UNSUPPORTED";
    L6:
        long r2 = System.currentTimeMillis();
        long r4 = ((r0 - f5859a) * 1000) / (r2 - c);
        c = r2;
        f5859a = r0;
        return String.valueOf(r4) + " KB/s";
    }

    public static String e(Context r8) {
        long r0 = b(((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin")).getApplicationInfo().uid);
        if (r0 != (-1)) goto L6;
        return "UNSUPPORTED";
    L6:
        long r2 = System.currentTimeMillis();
        long r4 = ((r0 - f5860b) * 1000) / (r2 - d);
        d = r2;
        f5860b = r0;
        return String.valueOf(r4) + " KB/s";
    }

    public static List<String> f(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        if (r10 != null) goto L5;
    L20:
        return r0;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L20;
        ConnectivityManager r11 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(r10.getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L18
        NetworkInfo r2 = r11.getActiveNetworkInfo();     // Catch: Exception -> L18
        Network[] r3 = r11.getAllNetworks();     // Catch: Exception -> L18
        int r4 = r3.length;     // Catch: Exception -> L18
        int r5 = 0;
    L7:
        if (r5 >= r4) goto L20;
        Network r6 = r3[r5];     // Catch: Exception -> L18
        if (r11.getNetworkInfo(r6).getType() != r2.getType()) goto L17;
        Iterator<RouteInfo> r7 = r11.getLinkProperties(r6).getRoutes().iterator();     // Catch: Exception -> L18
    L12:
        if (r7.hasNext() == false) goto L17;
        InetAddress r8 = ((RouteInfo) ZeusTransformUtils.preCheckCast(r7.next(), RouteInfo.class, "com.obric.memorydata.plugin")).getGateway();     // Catch: Exception -> L18
        if (r8 == null) goto L12;
        r0.add(r8.getHostAddress());     // Catch: Exception -> L18
    L17:
        r5 = r5 + 1;
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }

    public static String g(Context r2) {
        return a(h((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")));
    }

    private static NetworkType h(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        NetworkInfo r0 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(r4.getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin")).getActiveNetworkInfo();     // Catch: Throwable -> L26
        if (r0 == null) goto L25;
        if (r0.isAvailable() == false) goto L25;
        int r1 = r0.getType();     // Catch: Throwable -> L26
        if (1 == r1) goto L11;
        if (r1 != 0) goto L23;
        switch(((TelephonyManager) ZeusTransformUtils.preCheckCast(r4.getSystemService(MemoryKeyInfoEntity.KEY_PHONE), TelephonyManager.class, "com.obric.memorydata.plugin")).getNetworkType()) {
            case 1: goto L21;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L21;
            case 8: goto L19;
            case 9: goto L19;
            case 10: goto L19;
            case 11: goto L21;
            case 12: goto L19;
            case 13: goto L17;
            case 14: goto L19;
            case 15: goto L19;
            default: goto L29;
        };     // Catch: Throwable -> L26
    L29:
        return NetworkType.MOBILE;
    L17:
        return NetworkType.MOBILE_4G;
    L19:
        return NetworkType.MOBILE_3G;
    L21:
        return NetworkType.MOBILE_2G;
    L23:
        return NetworkType.MOBILE;
    L11:
        return NetworkType.WIFI;
    L25:
        return NetworkType.NONE;
    L27:
        return NetworkType.MOBILE;
    }
}
