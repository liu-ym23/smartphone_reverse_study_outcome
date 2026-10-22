package x4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13566a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f13567b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, c0> f13568c = null;

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static final class a implements c0 {
        @Override // x4.c0
        public final String a(int r8, j0 r10) {
            return r10.H.f7907c.I.getMeid(r8);
        }

        @Override // x4.c0
        public final String b(Context r8, j0 r10) {
            String r11 = "";
            Enumeration<NetworkInterface> r12 = null;
            if (r8 != null) goto L59;
        L15:
            WifiInfo r13 = null;
        L16:
            r10.H.getClass();
            if (r13 == null) goto L20;
            r11 = r13.getMacAddress();
        L20:
            if ("02:00:00:00:00:00".equals(r11) == false) goto L22;
        L65:
            r12 = NetworkInterface.getNetworkInterfaces();     // Catch: SocketException -> L25 Exception -> L56
        L27:
            String r14 = "wlan0";
            String r15 = (String) k5.n.a("wifi.interface");     // Catch: Exception -> L32
            if (TextUtils.isEmpty(r15) == true) goto L35;
            r14 = r15;
        L35:
            if (r12.hasMoreElements() == false) goto L80;
            NetworkInterface r16 = r12.nextElement();     // Catch: Exception -> L56
            if (r16.getName().equals(r14) == false) goto L35;
            byte[] r17 = r16.getHardwareAddress();     // Catch: SocketException -> L42 Exception -> L56
        L44:
            if (r17 == null) goto L35;
            if (r17.length == 0) goto L35;
            StringBuilder r18 = new StringBuilder();     // Catch: Exception -> L56
            int r19 = r17.length;     // Catch: Exception -> L56
            int r20 = 0;
        L49:
            if (r20 >= r19) goto L52;
            r18.append(String.format("%02X:", new Object[]{Byte.valueOf(r17[r20])}));     // Catch: Exception -> L56
            r20 = r20 + 1;     // Catch: Exception -> L56
            goto L49
        L52:
            if (r18.length() <= 0) goto L54;
            r18.deleteCharAt(r18.length() - 1);     // Catch: Exception -> L56
        L54:
            return r18.toString();
        L42:
            e = move-exception;
            e.printStackTrace();     // Catch: Exception -> L56
            r17 = new byte[0];     // Catch: Exception -> L56
            goto L44
        L80:
            return r11;
        L32:
            e = move-exception;
            e.printStackTrace();     // Catch: Exception -> L56
            goto L35
        L56:
            e = move-exception;
            e.printStackTrace();
            return r11;
        L25:
            e = move-exception;
            e.printStackTrace();     // Catch: Exception -> L56
            goto L27
        L22:
            if (TextUtils.isEmpty(r11) == true) goto L65;
            return r11;
        L59:
            r13 = ((WifiManager) r10.H.f7907c.f13465c.getApplicationContext().getSystemService("wifi")).getConnectionInfo();     // Catch: Exception -> L13
            if (r13 == null) goto L8;
            String r21 = r13.getSSID();     // Catch: Exception -> L13
        L9:
            if (((ConnectivityManager) r8.getApplicationContext().getSystemService("connectivity")).getNetworkInfo(1).getState() != NetworkInfo.State.CONNECTED) goto L15;
            if (r21 == null) goto L15;
        L8:
            r21 = "";
        L13:
            e = move-exception;
            e.printStackTrace();
            goto L15
        }

        @Override // x4.c0
        public final String c(Context r8, j0 r10) {
            h5.b r11 = r10.H;
            if (r8.getApplicationInfo().targetSdkVersion >= 26) goto L23;
        L9:
            String r12 = null;
        L11:
            if (TextUtils.isEmpty(r12) == false) goto L13;
        L14:
            r12 = Build.SERIAL;
        L16:
            if (TextUtils.isEmpty(r12) == false) goto L18;
        L21:
            return "";
        L18:
            if (TextUtils.equals(r12, "unknown") == true) goto L21;
            return r12;
        L13:
            if (TextUtils.equals(r12, "unknown") == false) goto L16;
        L23:
            if (r11.f7907c.f13465c.getApplicationInfo().targetSdkVersion < 26) goto L8;
            r12 = Build.getSerial();     // Catch: Throwable -> L22
        L8:
            r12 = "";
            goto L11
        }

        @Override // x4.c0
        public final JSONArray d() {
            JSONArray r8 = new JSONArray();
        L46:
            e = move-exception;
            e.printStackTrace();
        L48:
            return r8;
        L4:
            if (NetworkInterface.getNetworkInterfaces() == null) goto L6;
            Iterator r10 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();     // Catch: Exception -> L46
        L9:
            if (r10.hasNext() == false) goto L48;
            NetworkInterface r11 = (NetworkInterface) r10.next();     // Catch: Exception -> L46
            String r12 = r11.getName();     // Catch: Exception -> L46
            if ("dummy0".equals(r12) == true) goto L16;
            if ("wlan0".equals(r12) == false) goto L9;
        L16:
            Iterator r13 = Collections.list(r11.getInetAddresses()).iterator();     // Catch: Exception -> L46
        L18:
            if (r13.hasNext() == false) goto L9;
            String r14 = ((InetAddress) r13.next()).getHostAddress();     // Catch: Exception -> L46
            if (TextUtils.isEmpty(r14) == true) goto L18;
            if (r14.indexOf(58) >= 0) goto L24;
            boolean r15 = true;
        L25:
            if (r15 == true) goto L18;
            int r16 = r14.indexOf(37);     // Catch: Exception -> L46
            if ("dummy0".equals(r12) == true) goto L29;
            if ("wlan0".equals(r12) == true) goto L39;
            if ("fe80".equalsIgnoreCase(r14.split("::")[0]) == false) goto L18;
        L39:
            JSONObject r17 = new JSONObject();     // Catch: Exception -> L46
            r17.put("type", "client_anpi");     // Catch: Exception -> L46
            if (r16 < 0) goto L43;
            r14 = r14.substring(0, r16);     // Catch: Exception -> L46
        L43:
            String r18 = r14.toUpperCase();     // Catch: Exception -> L46
        L34:
            r17.put("value", r18);     // Catch: Exception -> L46
            r8.put(r17);     // Catch: Exception -> L46
            goto L18
        L29:
            r17 = new JSONObject();     // Catch: Exception -> L46
            r17.put("type", "client_tun");     // Catch: Exception -> L46
            if (r16 < 0) goto L33;
            r14 = r14.substring(0, r16);     // Catch: Exception -> L46
        L33:
            r18 = r14.toUpperCase();     // Catch: Exception -> L46
            goto L34
        L24:
            r15 = false;
            goto L25
        L6:
            return new JSONArray();
        }

        @Override // x4.c0
        public final String e(Context r8, j0 r10) {
            if (r8.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) goto L8;
            boolean r11 = true;
        L9:
            if (r11 == false) goto L15;
        L18:
            int r12 = r.f13543a;
        L19:
            return null;
        L11:
            if (u0.f13567b.compareAndSet(false, true) == false) goto L15;
            return r10.H.f7907c.I.getDeviceId();
        L15:
            if (u0.f13567b.get() == false) goto L19;
            int r13 = r.f13543a;     // Catch: Exception -> L18
            return null;
        L8:
            r11 = false;
            goto L9
        }

        @Override // x4.c0
        public final String f(int r8, j0 r10) {
            return r10.H.f7907c.I.getImei(r8);
        }
    }

    static {
        f13566a = new a();
        f13567b = new AtomicBoolean(false);
        f13568c = new ConcurrentHashMap();
    }

    public static c0 a(String r8) {
        c0 r10 = f13568c.get(r8);
        if (r10 == null) goto L6;
        return r10;
    L6:
        return f13566a;
    }
}
