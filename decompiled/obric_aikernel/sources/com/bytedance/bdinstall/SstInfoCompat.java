package com.bytedance.bdinstall;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bytedance.bdinstall.loader.SstLoader;
import com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor;
import com.bytedance.bdinstall.util.InstallPmsUtils;
import com.bytedance.bdinstall.util.SystemPropertiesWithCache;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SstInfoCompat {
    private static final AtomicBoolean isCalled = null;
    private static volatile String sMeid;
    private static ISstInfoProvider sProvider;
    public static final ConcurrentHashMap<String, ISstInfoProvider> sProviderMap = null;

    /* JADX INFO: renamed from: com.bytedance.bdinstall.SstInfoCompat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    private static final class DefaultProvider implements ISstInfoProvider {
        private static final String DEFAULT_MAC_ADDRESS = "02:00:00:00:00:00";
        private TelephonyManager tm;

        private DefaultProvider() {
        }

        /* synthetic */ DefaultProvider(AnonymousClass1 r10) {
            this();
        }

        private static Class<?>[] getMethodParamTypes(String r10) {
            Class<?>[] r11 = null;
            Method[] r12 = TelephonyManager.class.getDeclaredMethods();     // Catch: Exception -> L12
            int r13 = r12.length;     // Catch: Exception -> L12
            int r14 = 0;
        L4:
            if (r14 >= r13) goto L14;
            Method r15 = r12[r14];     // Catch: Exception -> L12
            if (r10.equals(r15.getName()) == false) goto L11;
            r11 = r15.getParameterTypes();     // Catch: Exception -> L12
            if (r11.length < 1) goto L11;
            DrLog.d("length:" + r11.length);     // Catch: Exception -> L12
        L11:
            r14 = r14 + 1;
        L14:
            return r11;
        L12:
            e = move-exception;
            e.printStackTrace();
            DrLog.e(e.getMessage(), e);
            goto L14
        }

        private static String getNetworkInterfaceName() {
            String r10 = (String) SystemPropertiesWithCache.get("wifi.interface");     // Catch: Exception -> L8
            if (TextUtils.isEmpty(r10) == false) goto L7;
            return "wlan0";
        L7:
            return r10;
        L8:
            e = move-exception;
            e.printStackTrace();
            return "wlan0";
        }

        @Nullable
        private static Object getPhoneInfo(int r10, String r11, Context r12) {
            TelephonyManager r13 = (TelephonyManager) r12.getSystemService("phone");     // Catch: Exception -> L9
            if (Build.VERSION.SDK_INT < 21) goto L14;
            Method r14 = r13.getClass().getMethod(r11, getMethodParamTypes(r11));     // Catch: Exception -> L9
            if (r10 < 0) goto L15;
            return r14.invoke(r13, new Object[]{Integer.valueOf(r10)});
        L15:
            return null;
        L14:
            return null;
        L9:
            e = move-exception;
            e.printStackTrace();
            DrLog.e(e.getMessage(), e);
            return null;
        }

        private TelephonyManager getTelephonyManager(Context r10) {
            if (this.tm != null) goto L6;
            this.tm = (TelephonyManager) r10.getSystemService("phone");
        L6:
            return this.tm;
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String getDefaultImeiOrMeid(Context r10, InstallOptions r11) {
        L12:
            DrLog.v("no get_phone_state permission,getDeviceId return null");
            return null;
        L3:
            if (InstallPmsUtils.checkReadPhoneStatePermission(r10) == false) goto L9;
            if (SstInfoCompat.access$100().compareAndSet(false, true) == false) goto L9;
            return r11.getSensitiveInterceptor().getDeviceId();
        L9:
            if (SstInfoCompat.access$100().get() == false) goto L16;
            DrLog.d("getDefaultImeiOrMeid# get Meid from memory cache： " + SstInfoCompat.access$200());     // Catch: Exception -> L12
            return SstInfoCompat.access$200();
        L16:
            return null;
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public JSONArray getIPV6Address(Context r12) {
            JSONArray r13 = new JSONArray();
        L45:
            e = move-exception;
            e.printStackTrace();
        L47:
            return r13;
        L4:
            if (NetworkInterface.getNetworkInterfaces() == null) goto L6;
            Iterator r10 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();     // Catch: Exception -> L45
        L9:
            if (r10.hasNext() == false) goto L47;
            NetworkInterface r11 = (NetworkInterface) r10.next();     // Catch: Exception -> L45
            String r14 = r11.getName();     // Catch: Exception -> L45
            if ("dummy0".equals(r14) == true) goto L16;
            if ("wlan0".equals(r14) == false) goto L9;
        L16:
            Iterator r15 = Collections.list(r11.getInetAddresses()).iterator();     // Catch: Exception -> L45
        L18:
            if (r15.hasNext() == false) goto L9;
            String r16 = ((InetAddress) r15.next()).getHostAddress();     // Catch: Exception -> L45
            if (TextUtils.isEmpty(r16) == true) goto L18;
            if (r16.indexOf(58) >= 0) goto L24;
            boolean r17 = true;
        L25:
            if (r17 == true) goto L18;
            int r18 = r16.indexOf(37);     // Catch: Exception -> L45
            if ("dummy0".equals(r14) == true) goto L29;
            if ("wlan0".equals(r14) == true) goto L39;
            if ("fe80".equalsIgnoreCase(r16.split("::")[0]) == false) goto L18;
        L39:
            JSONObject r19 = new JSONObject();     // Catch: Exception -> L45
            r19.put(WsConstants.KEY_CONNECTION_TYPE, SstLoader.KEY_IPV6_TYPE_ANPI);     // Catch: Exception -> L45
            if (r18 < 0) goto L43;
            r16 = r16.substring(0, r18);     // Catch: Exception -> L45
        L43:
            r19.put(EventBody.KEY_VALUE, r16.toUpperCase());     // Catch: Exception -> L45
        L34:
            r13.put(r19);     // Catch: Exception -> L45
            goto L18
        L29:
            r19 = new JSONObject();     // Catch: Exception -> L45
            r19.put(WsConstants.KEY_CONNECTION_TYPE, SstLoader.KEY_IPV6_TYPE_TUN);     // Catch: Exception -> L45
            if (r18 < 0) goto L33;
            r16 = r16.substring(0, r18);     // Catch: Exception -> L45
        L33:
            r19.put(EventBody.KEY_VALUE, r16.toUpperCase());     // Catch: Exception -> L45
            goto L34
        L24:
            r17 = false;
            goto L25
        L6:
            return new JSONArray();
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        @RequiresApi(api = 26)
        public String getImei(Context r10, int r11, InstallOptions r12) {
            return r12.getSensitiveInterceptor().getImeiByIndex(r11);
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String getMac(Context r10, InstallOptions r11) {
            WifiInfo r12 = SstInfoCompat.access$300(r10, r11);
            DefaultSensitiveInterceptor r13 = r11.getSensitiveInterceptor();
            String r14 = r13.getMacAddress(r12);
            if (DEFAULT_MAC_ADDRESS.equals(r14) == false) goto L5;
        L29:
            Enumeration<NetworkInterface> r15 = r13.getNetworkInterfaces();     // Catch: Exception -> L26
            String r16 = getNetworkInterfaceName();     // Catch: Exception -> L26
        L8:
            if (r15.hasMoreElements() == false) goto L43;
            NetworkInterface r17 = r15.nextElement();     // Catch: Exception -> L26
            if (r17.getName().equals(r16) == false) goto L8;
            byte[] r18 = r13.getHardwareAddress(r17);     // Catch: Exception -> L26
            if (r18 == null) goto L8;
            if (r18.length == 0) goto L8;
            StringBuilder r19 = new StringBuilder();     // Catch: Exception -> L26
            int r20 = r18.length;     // Catch: Exception -> L26
            int r21 = 0;
        L19:
            if (r21 >= r20) goto L22;
            r19.append(String.format("%02X:", new Object[]{Byte.valueOf(r18[r21])}));     // Catch: Exception -> L26
            r21 = r21 + 1;     // Catch: Exception -> L26
            goto L19
        L22:
            if (r19.length() <= 0) goto L24;
            r19.deleteCharAt(r19.length() - 1);     // Catch: Exception -> L26
        L24:
            return r19.toString();
        L43:
            return r14;
        L26:
            e = move-exception;
            e.printStackTrace();
            return r14;
        L5:
            if (TextUtils.isEmpty(r14) == true) goto L29;
            return r14;
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        @RequiresApi(api = 26)
        public String getMeid(Context r10, int r11, InstallOptions r12) {
            return r12.getSensitiveInterceptor().getMeidByIndex(r11);
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String getSerial(Context r10, InstallOptions r11) {
            DefaultSensitiveInterceptor r12 = r11.getSensitiveInterceptor();
            if (Build.VERSION.SDK_INT >= 26) goto L5;
        L8:
            String r13 = null;
        L10:
            if (TextUtils.isEmpty(r13) == false) goto L12;
        L13:
            r13 = Build.SERIAL;
        L15:
            if (TextUtils.isEmpty(r13) == false) goto L17;
            return "";
        L17:
            if (TextUtils.equals(r13, "unknown") == true) goto L25;
            return r13;
        L25:
            return "";
        L12:
            if (TextUtils.equals(r13, "unknown") == false) goto L15;
        L5:
            if (r10.getApplicationInfo().targetSdkVersion < 26) goto L8;
            r13 = r12.getSerial();     // Catch: Throwable -> L22
            goto L10
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String[] getSimSerialNumbers(Context r10, InstallOptions r11) {
            DefaultSensitiveInterceptor r12 = r11.getSensitiveInterceptor();
        L20:
            th = move-exception;
            th.printStackTrace();
            return null;
        L4:
            int r13 = 0;
            if (Build.VERSION.SDK_INT < 22) goto L27;
            List<SubscriptionInfo> r14 = r12.getActiveSubscriptionInfoList();     // Catch: SecurityException -> L17 Throwable -> L20
            if (r14 == null) goto L16;
            if (r14.isEmpty() == true) goto L16;
            String[] r15 = new String[r14.size()];     // Catch: SecurityException -> L17 Throwable -> L20
        L13:
            if (r13 >= r14.size()) goto L28;
            r15[r13] = r12.getIccId(r14.get(r13));     // Catch: SecurityException -> L17 Throwable -> L20
            r13 = r13 + 1;     // Catch: SecurityException -> L17 Throwable -> L20
            goto L13
        L28:
            return r15;
        L16:
            return new String[0];
        L17:
            DrLog.d("getSSN , no permission, ignore");     // Catch: Throwable -> L20
            return null;
        L27:
            return new String[]{r12.getSimSerialNumber()};
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String reflectGetDeviceIdWithSlotIndex(Context r10, int r11) {
            String r12 = (String) getPhoneInfo(r11, "getDeviceId", r10);
            DrLog.d("getDeviceId  deviceId=" + r12);
            return r12;
        }
    }

    static {
        sProvider = new DefaultProvider(null);
        isCalled = new AtomicBoolean(false);
        sMeid = null;
        sProviderMap = new ConcurrentHashMap();
    }

    public SstInfoCompat() {
    }

    static /* synthetic */ AtomicBoolean access$100() {
        return isCalled;
    }

    static /* synthetic */ String access$200() {
        return sMeid;
    }

    static /* synthetic */ WifiInfo access$300(Context r10, InstallOptions r11) {
        return getWifiInfo(r10, r11);
    }

    public static ISstInfoProvider getProvider(String r10) {
        ISstInfoProvider r11 = sProviderMap.get(r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        return sProvider;
    }

    private static WifiInfo getWifiInfo(Context r10, InstallOptions r11) {
        if (r10 != null) goto L12;
        return null;
    L12:
        DefaultSensitiveInterceptor r12 = r11.getSensitiveInterceptor();     // Catch: Exception -> L9
        WifiInfo r13 = r12.getConnectionInfo();     // Catch: Exception -> L9
        String r14 = r12.getSSID(r13);     // Catch: Exception -> L9
        if (((ConnectivityManager) r10.getApplicationContext().getSystemService("connectivity")).getNetworkInfo(1).getState() != NetworkInfo.State.CONNECTED) goto L11;
        if (r14 == null) goto L11;
        return r13;
    L11:
        return null;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    static void setSstInfoProvider(String r10, ISstInfoProvider r11) {
        ConcurrentHashMap<String, ISstInfoProvider> r12 = sProviderMap;
        if (r12.containsKey(r10) == true) goto L6;
        r12.put(r10, r11);
        return;
    }
}
