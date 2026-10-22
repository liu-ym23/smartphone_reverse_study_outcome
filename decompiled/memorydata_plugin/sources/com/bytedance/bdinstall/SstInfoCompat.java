package com.bytedance.bdinstall;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor;
import com.bytedance.bdinstall.util.InstallPmsUtils;
import com.bytedance.bdinstall.util.SystemPropertiesWithCache;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    private static final class DefaultProvider implements ISstInfoProvider {
        private static final String DEFAULT_MAC_ADDRESS = "02:00:00:00:00:00";
        private TelephonyManager tm;

        private DefaultProvider() {
        }

        /* synthetic */ DefaultProvider(AnonymousClass1 r1) {
            this();
        }

        private static Class<?>[] getMethodParamTypes(String r6) {
            Class<?>[] r0 = null;
            Method[] r1 = TelephonyManager.class.getDeclaredMethods();     // Catch: Exception -> L12
            int r2 = r1.length;     // Catch: Exception -> L12
            int r3 = 0;
        L4:
            if (r3 >= r2) goto L14;
            Method r4 = r1[r3];     // Catch: Exception -> L12
            if (r6.equals(r4.getName()) == false) goto L11;
            r0 = r4.getParameterTypes();     // Catch: Exception -> L12
            if (r0.length < 1) goto L11;
            DrLog.d("length:" + r0.length);     // Catch: Exception -> L12
        L11:
            r3 = r3 + 1;
        L14:
            return r0;
        L12:
            e = move-exception;
            e.printStackTrace();
            DrLog.e(e.getMessage(), e);
            goto L14
        }

        private static String getNetworkInterfaceName() {
            String r1 = (String) ZeusTransformUtils.preCheckCast(SystemPropertiesWithCache.get("wifi.interface"), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L8
            if (TextUtils.isEmpty(r1) == false) goto L7;
            return "wlan0";
        L7:
            return r1;
        L8:
            e = move-exception;
            e.printStackTrace();
            return "wlan0";
        }

        private static Object getPhoneInfo(int r3, String r4, Context r5) {
            TelephonyManager r6 = (TelephonyManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin")).getSystemService(MemoryKeyInfoEntity.KEY_PHONE), TelephonyManager.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L9
            if (Build.VERSION.SDK_INT < 21) goto L14;
            Method r7 = r6.getClass().getMethod(r4, getMethodParamTypes(r4));     // Catch: Exception -> L9
            if (r3 < 0) goto L15;
            return r7.invoke(r6, new Object[]{Integer.valueOf(r3)});
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

        private TelephonyManager getTelephonyManager(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            if (this.tm != null) goto L6;
            this.tm = (TelephonyManager) ZeusTransformUtils.preCheckCast(r4.getSystemService(MemoryKeyInfoEntity.KEY_PHONE), TelephonyManager.class, "com.obric.memorydata.plugin");
        L6:
            return this.tm;
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String getDefaultImeiOrMeid(Context r2, InstallOptions r3) {
        L13:
            DrLog.v("no get_phone_state permission,getDeviceId return null");
            return null;
        L4:
            if (InstallPmsUtils.checkReadPhoneStatePermission((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")) == false) goto L10;
            if (SstInfoCompat.access$100().compareAndSet(false, true) == false) goto L10;
            return r3.getSensitiveInterceptor().getDeviceId();
        L10:
            if (SstInfoCompat.access$100().get() == false) goto L17;
            DrLog.d("getDefaultImeiOrMeid# get Meid from memory cache： " + SstInfoCompat.access$200());     // Catch: Exception -> L13
            return SstInfoCompat.access$200();
        L17:
            return null;
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public JSONArray getIPV6Address(Context r13) {
            Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
            JSONArray r15 = new JSONArray();
        L45:
            e = move-exception;
            e.printStackTrace();
        L47:
            return r15;
        L4:
            if (NetworkInterface.getNetworkInterfaces() == null) goto L6;
            Iterator r0 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();     // Catch: Exception -> L45
        L9:
            if (r0.hasNext() == false) goto L47;
            NetworkInterface r2 = (NetworkInterface) ZeusTransformUtils.preCheckCast(r0.next(), NetworkInterface.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L45
            String r3 = r2.getName();     // Catch: Exception -> L45
            if ("dummy0".equals(r3) == true) goto L16;
            if ("wlan0".equals(r3) == false) goto L9;
        L16:
            Iterator r4 = Collections.list(r2.getInetAddresses()).iterator();     // Catch: Exception -> L45
        L18:
            if (r4.hasNext() == false) goto L9;
            String r5 = ((InetAddress) ZeusTransformUtils.preCheckCast(r4.next(), InetAddress.class, "com.obric.memorydata.plugin")).getHostAddress();     // Catch: Exception -> L45
            if (TextUtils.isEmpty(r5) == true) goto L18;
            if (r5.indexOf(58) >= 0) goto L24;
            boolean r6 = true;
        L25:
            if (r6 == true) goto L18;
            int r7 = r5.indexOf(37);     // Catch: Exception -> L45
            if ("dummy0".equals(r3) == true) goto L29;
            if ("wlan0".equals(r3) == true) goto L39;
            if ("fe80".equalsIgnoreCase(r5.split("::")[0]) == false) goto L18;
        L39:
            JSONObject r8 = new JSONObject();     // Catch: Exception -> L45
            r8.put("type", "client_anpi");     // Catch: Exception -> L45
            if (r7 < 0) goto L43;
            r5 = r5.substring(0, r7);     // Catch: Exception -> L45
        L43:
            r8.put(EventBody.KEY_VALUE, r5.toUpperCase());     // Catch: Exception -> L45
        L34:
            r15.put(r8);     // Catch: Exception -> L45
            goto L18
        L29:
            r8 = new JSONObject();     // Catch: Exception -> L45
            r8.put("type", "client_tun");     // Catch: Exception -> L45
            if (r7 < 0) goto L33;
            r5 = r5.substring(0, r7);     // Catch: Exception -> L45
        L33:
            r8.put(EventBody.KEY_VALUE, r5.toUpperCase());     // Catch: Exception -> L45
            goto L34
        L24:
            r6 = false;
            goto L25
        L6:
            return new JSONArray();
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String getImei(Context r2, int r3, InstallOptions r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            return r4.getSensitiveInterceptor().getImeiByIndex(r3);
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String getMac(Context r7, InstallOptions r8) {
            WifiInfo r6 = SstInfoCompat.access$300((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin"), r8);
            DefaultSensitiveInterceptor r9 = r8.getSensitiveInterceptor();
            String r10 = r9.getMacAddress(r6);
            if (DEFAULT_MAC_ADDRESS.equals(r10) == false) goto L5;
        L29:
            Enumeration<NetworkInterface> r11 = r9.getNetworkInterfaces();     // Catch: Exception -> L26
            String r1 = getNetworkInterfaceName();     // Catch: Exception -> L26
        L8:
            if (r11.hasMoreElements() == false) goto L43;
            NetworkInterface r2 = (NetworkInterface) ZeusTransformUtils.preCheckCast(r11.nextElement(), NetworkInterface.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L26
            if (r2.getName().equals(r1) == false) goto L8;
            byte[] r3 = r9.getHardwareAddress(r2);     // Catch: Exception -> L26
            if (r3 == null) goto L8;
            if (r3.length == 0) goto L8;
            StringBuilder r12 = new StringBuilder();     // Catch: Exception -> L26
            int r13 = r3.length;     // Catch: Exception -> L26
            int r4 = 0;
        L19:
            if (r4 >= r13) goto L22;
            r12.append(String.format("%02X:", new Object[]{Byte.valueOf(r3[r4])}));     // Catch: Exception -> L26
            r4 = r4 + 1;     // Catch: Exception -> L26
            goto L19
        L22:
            if (r12.length() <= 0) goto L24;
            r12.deleteCharAt(r12.length() - 1);     // Catch: Exception -> L26
        L24:
            return r12.toString();
        L43:
            return r10;
        L26:
            e = move-exception;
            e.printStackTrace();
            return r10;
        L5:
            if (TextUtils.isEmpty(r10) == true) goto L29;
            return r10;
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String getMeid(Context r2, int r3, InstallOptions r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            return r4.getSensitiveInterceptor().getMeidByIndex(r3);
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String getSerial(Context r2, InstallOptions r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            DefaultSensitiveInterceptor r4 = r3.getSensitiveInterceptor();
            if (Build.VERSION.SDK_INT >= 26) goto L5;
        L8:
            String r5 = null;
        L10:
            if (TextUtils.isEmpty(r5) == false) goto L12;
        L13:
            r5 = Build.SERIAL;
        L15:
            if (TextUtils.isEmpty(r5) == false) goto L17;
            return "";
        L17:
            if (TextUtils.equals(r5, "unknown") == true) goto L25;
            return r5;
        L25:
            return "";
        L12:
            if (TextUtils.equals(r5, "unknown") == false) goto L15;
        L5:
            if (r1.getApplicationInfo().targetSdkVersion < 26) goto L8;
            r5 = r4.getSerial();     // Catch: Throwable -> L22
            goto L10
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String[] getSimSerialNumbers(Context r5, InstallOptions r6) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
            DefaultSensitiveInterceptor r7 = r6.getSensitiveInterceptor();
        L20:
            th = move-exception;
            th.printStackTrace();
            return null;
        L4:
            int r2 = 0;
            if (Build.VERSION.SDK_INT < 22) goto L27;
            List<SubscriptionInfo> r8 = r7.getActiveSubscriptionInfoList();     // Catch: SecurityException -> L17 Throwable -> L20
            if (r8 == null) goto L16;
            if (r8.isEmpty() == true) goto L16;
            String[] r9 = new String[r8.size()];     // Catch: SecurityException -> L17 Throwable -> L20
        L13:
            if (r2 >= r8.size()) goto L28;
            r9[r2] = r7.getIccId((SubscriptionInfo) ZeusTransformUtils.preCheckCast(r8.get(r2), SubscriptionInfo.class, "com.obric.memorydata.plugin"));     // Catch: SecurityException -> L17 Throwable -> L20
            r2 = r2 + 1;     // Catch: SecurityException -> L17 Throwable -> L20
            goto L13
        L28:
            return r9;
        L16:
            return new String[0];
        L17:
            DrLog.d("getSSN , no permission, ignore");     // Catch: Throwable -> L20
            return null;
        L27:
            return new String[]{r7.getSimSerialNumber()};
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String reflectGetDeviceIdWithSlotIndex(Context r2, int r3) {
            String r1 = (String) ZeusTransformUtils.preCheckCast(getPhoneInfo(r3, "getDeviceId", (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")), String.class, "com.obric.memorydata.plugin");
            DrLog.d("getDeviceId  deviceId=" + r1);
            return r1;
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

    static /* synthetic */ WifiInfo access$300(Context r2, InstallOptions r3) {
        return getWifiInfo((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3);
    }

    public static ISstInfoProvider getProvider(String r2) {
        ISstInfoProvider r3 = (ISstInfoProvider) ZeusTransformUtils.preCheckCast(sProviderMap.get(r2), ISstInfoProvider.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        return r3;
    L6:
        return sProvider;
    }

    private static WifiInfo getWifiInfo(Context r4, InstallOptions r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L12;
        return null;
    L12:
        DefaultSensitiveInterceptor r7 = r5.getSensitiveInterceptor();     // Catch: Exception -> L9
        WifiInfo r2 = r7.getConnectionInfo();     // Catch: Exception -> L9
        String r8 = r7.getSSID(r2);     // Catch: Exception -> L9
        if (((ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin")).getNetworkInfo(1).getState() != NetworkInfo.State.CONNECTED) goto L11;
        if (r8 == null) goto L11;
        return r2;
    L11:
        return null;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    static void setSstInfoProvider(String r2, ISstInfoProvider r3) {
        ISstInfoProvider r4 = (ISstInfoProvider) ZeusTransformUtils.wrapperContextForParams(r3, ISstInfoProvider.class, "com.obric.memorydata.plugin");
        ConcurrentHashMap<String, ISstInfoProvider> r0 = sProviderMap;
        if (r0.containsKey(r2) == true) goto L6;
        r0.put(r2, r4);
        return;
    }
}
