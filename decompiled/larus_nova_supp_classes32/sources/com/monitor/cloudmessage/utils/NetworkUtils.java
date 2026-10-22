package com.monitor.cloudmessage.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.RouteInfo;
import android.net.TrafficStats;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.apm.util.m;
import com.larus.voice_setting.voice.base.VoiceDisplayScene;
import com.obric.aivoice.core.data.NameKeys;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class NetworkUtils {
    public static long a;
    public static long b;
    public static long c;
    public static long d;

    public static final enum NetworkType extends Enum<NetworkType> {
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType WIFI = null;
        public static final /* synthetic */ NetworkType[] a = null;
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
            a = new NetworkType[]{r0, r1, r3, r5, r7, r9};
        }

        public static NetworkType[] values() {
            return (NetworkType[]) a.clone();
        }

        public int getValue() {
            return this.nativeInt;
        }

        public static NetworkType valueOf(String r1) {
            return (NetworkType) r27.a.a(NetworkType.class, r1);
        }

        public NetworkType(String r1, int r2, int r3) {
            super(r1, r2);
            this.nativeInt = r3;
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[NetworkType.values().length];
            a = r0;
            r0[NetworkType.WIFI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            a[NetworkType.MOBILE_2G.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            a[NetworkType.MOBILE_3G.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            a[NetworkType.MOBILE_4G.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            a[NetworkType.MOBILE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static String d() {
        String r0 = VoiceDisplayScene.NONE;
        Enumeration<NetworkInterface> r1 = NetworkInterface.getNetworkInterfaces();     // Catch: SocketException -> L21
    L4:
        if (r1.hasMoreElements() == false) goto L23;
        NetworkInterface r2 = r1.nextElement();     // Catch: SocketException -> L21
        String r3 = r2.getName();     // Catch: SocketException -> L21
        if (r3 == null) goto L4;
        if (TextUtils.equals(r3.toLowerCase(), "eth0") == true) goto L12;
        if (TextUtils.equals(r3.toLowerCase(), "wlan0") == false) goto L4;
    L12:
        Enumeration<InetAddress> r4 = r2.getInetAddresses();     // Catch: SocketException -> L21
    L14:
        if (r4.hasMoreElements() == false) goto L4;
        InetAddress r5 = r4.nextElement();     // Catch: SocketException -> L21
        if ((r5 instanceof Inet4Address) == false) goto L14;
        if (r5.isLoopbackAddress() == true) goto L14;
        r0 = r5.getHostAddress();     // Catch: SocketException -> L21
    L23:
        return r0;
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    }

    public static String a(Context r8) {
        int r9 = r8.getApplicationInfo().uid;
        long r0 = TrafficStats.getTotalRxBytes() / 1024;
        if (r0 != (-1)) goto L6;
        return "UNSUPPORTED";
    L6:
        long r2 = System.currentTimeMillis();
        long r4 = ((r0 - a) * 1000) / (r2 - c);
        c = r2;
        a = r0;
        return String.valueOf(r4) + " KB/s";
    }

    public static List<String> b(Context r8) {
        ArrayList r0 = new ArrayList();
        ConnectivityManager r9 = (ConnectivityManager) r8.getSystemService("connectivity");     // Catch: Exception -> L15
        NetworkInfo r1 = r9.getActiveNetworkInfo();     // Catch: Exception -> L15
        Network[] r2 = r9.getAllNetworks();     // Catch: Exception -> L15
        int r3 = r2.length;     // Catch: Exception -> L15
        int r4 = 0;
    L4:
        if (r4 >= r3) goto L17;
        Network r5 = r2[r4];     // Catch: Exception -> L15
        if (r9.getNetworkInfo(r5).getType() != r1.getType()) goto L14;
        Iterator<RouteInfo> r6 = r9.getLinkProperties(r5).getRoutes().iterator();     // Catch: Exception -> L15
    L9:
        if (r6.hasNext() == false) goto L14;
        InetAddress r7 = r6.next().getGateway();     // Catch: Exception -> L15
        if (r7 == null) goto L9;
        r0.add(r7.getHostAddress());     // Catch: Exception -> L15
    L14:
        r4 = r4 + 1;
    L17:
        return r0;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static List<String> c(Context r8) {
        ArrayList r0 = new ArrayList();
        ConnectivityManager r9 = (ConnectivityManager) r8.getSystemService("connectivity");     // Catch: Exception -> L13
        NetworkInfo r1 = r9.getActiveNetworkInfo();     // Catch: Exception -> L13
        Network[] r2 = r9.getAllNetworks();     // Catch: Exception -> L13
        int r3 = r2.length;     // Catch: Exception -> L13
        int r4 = 0;
    L4:
        if (r4 >= r3) goto L15;
        Network r5 = r2[r4];     // Catch: Exception -> L13
        if (r9.getNetworkInfo(r5).getType() != r1.getType()) goto L12;
        Iterator<InetAddress> r6 = r9.getLinkProperties(r5).getDnsServers().iterator();     // Catch: Exception -> L13
    L9:
        if (r6.hasNext() == false) goto L12;
        r0.add(r6.next().getHostAddress());     // Catch: Exception -> L13
    L12:
        r4 = r4 + 1;
    L15:
        return r0;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public static String e(Context r3) {
        NetworkInfo r1 = ((ConnectivityManager) r3.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L21
        if (r1 != null) goto L6;
    L19:
        NetworkType r4 = NetworkType.NONE;     // Catch: Throwable -> L21
    L42:
    L45:
        int r5 = a.a[r4.ordinal()];     // Catch: Exception -> L41
        if (r5 != 1) goto L25;
        return "wifi";
    L25:
        if (r5 == 2) goto L50;
        if (r5 == 3) goto L49;
        if (r5 == 4) goto L48;
        if (r5 != 5) goto L39;
        return "mobile";
    L48:
        return "4g";
    L49:
        return "3g";
    L50:
        return "2g";
    L39:
        return NameKeys.UnloadStrategy_No_Strategy;
    L6:
        if (r1.isAvailable() == false) goto L19;
        int r2 = r1.getType();     // Catch: Throwable -> L21
        if (1 != r2) goto L11;
        r4 = NetworkType.WIFI;     // Catch: Throwable -> L21
        goto L42
    L11:
        if (r2 == 0) goto L13;
        r4 = NetworkType.MOBILE;     // Catch: Throwable -> L21
        goto L42
    L13:
        switch(((TelephonyManager) r3.getSystemService("phone")).getNetworkType()) {
            case 1: goto L17;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L16;
            case 7: goto L17;
            case 8: goto L16;
            case 9: goto L16;
            case 10: goto L16;
            case 11: goto L17;
            case 12: goto L16;
            case 13: goto L15;
            case 14: goto L16;
            case 15: goto L16;
            default: goto L14;
        };     // Catch: Throwable -> L21
    L14:
        r4 = NetworkType.MOBILE;     // Catch: Throwable -> L21
        goto L42
    L15:
        r4 = NetworkType.MOBILE_4G;     // Catch: Throwable -> L21
        goto L42
    L16:
        r4 = NetworkType.MOBILE_3G;     // Catch: Throwable -> L21
        goto L42
    L17:
        r4 = NetworkType.MOBILE_2G;     // Catch: Throwable -> L21
    L21:
        r4 = NetworkType.MOBILE;
        goto L45
    }

    public static String f(Context r8) {
        int r9 = r8.getApplicationInfo().uid;
        long r0 = TrafficStats.getTotalTxBytes() / 1024;
        if (r0 != (-1)) goto L6;
        return "UNSUPPORTED";
    L6:
        long r2 = System.currentTimeMillis();
        long r4 = ((r0 - b) * 1000) / (r2 - d);
        d = r2;
        b = r0;
        return String.valueOf(r4) + " KB/s";
    }

    public static boolean g(Context r2) {
        NetworkInfo r3 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L13
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.isAvailable() == false) goto L17;
        if (1 != r3.getType()) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L19:
        return false;
    }

    public static List<String> h(String r4) {
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

    public static boolean i(String r7, JSONObject r8) {
        JSONObject r0 = new JSONObject();
        boolean r1 = false;
        HttpURLConnection r2 = null;
        r2 = m.a(r7);     // Catch: Throwable -> L9 Exception -> L11
        r2.setRequestMethod("GET");     // Catch: Throwable -> L9 Exception -> L11
        r2.setReadTimeout(30000);     // Catch: Throwable -> L9 Exception -> L11
        r2.setConnectTimeout(30000);     // Catch: Throwable -> L9 Exception -> L11
        r2.setDoInput(true);     // Catch: Throwable -> L9 Exception -> L11
        r2.setDoOutput(true);     // Catch: Throwable -> L9 Exception -> L11
        r2.setUseCaches(false);     // Catch: Throwable -> L9 Exception -> L11
        String r5 = j9a.a.a;     // Catch: Throwable -> L9 Exception -> L11
        r2.setRequestProperty("Charset", "UTF-8");     // Catch: Throwable -> L9 Exception -> L11
        int r4 = r2.getResponseCode();     // Catch: Throwable -> L9 Exception -> L11
        r0.put("statusCode", r4);     // Catch: Throwable -> L9 Exception -> L11
        r0.put("header", b.a(r2.getHeaderFields()));     // Catch: Throwable -> L9 Exception -> L11
        r8.put(r7, r0);     // Catch: Throwable -> L9 Exception -> L11
    L5:
        if (r4 != 200) goto L7;
        r1 = true;
    L7:
        r2.disconnect();
        return r1;
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
        r8.put(r7, e.getMessage());     // Catch: Throwable -> L9 JSONException -> L17
        if (r2 == null) goto L16;
        r2.disconnect();
    L16:
        return false;
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
        if (r2 == null) goto L21;
        r2.disconnect();
    L21:
        return false;
    L9:
        th = move-exception;
        if (r2 == null) goto L24;
        r2.disconnect();
    L24:
        throw th;
    }
}
