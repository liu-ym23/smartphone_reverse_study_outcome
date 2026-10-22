package com.obric.cae.libs.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.obric.cae.libs.wifi.basicInfo.ChannelsEnvironment;
import f06.b;
import f06.c;
import f06.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class WifiUtils {
    public static final int WIFI_BAND_24_GHZ = 1;
    public static final int WIFI_BAND_5_GHZ = 2;
    public static final int WIFI_BAND_6_GHZ = 8;

    public WifiUtils() {
    }

    public static int convertChannelToFrequencyMhz(int r3, int r4) {
        if (r4 != 1) goto L14;
        if (r3 != 14) goto L8;
        return ChannelsEnvironment.BAND_24_GHZ_END_FREQ_MHZ;
    L8:
        if (r3 < 1) goto L12;
        if (r3 > 14) goto L12;
        return ((r3 - 1) * 5) + ChannelsEnvironment.BAND_24_GHZ_START_FREQ_MHZ;
    L12:
        return -1;
    L14:
        if (r4 != 2) goto L23;
        if (r3 >= 32) goto L18;
    L21:
        return -1;
    L18:
        if (r3 > 173) goto L21;
        return ((r3 - 32) * 5) + ChannelsEnvironment.BAND_5_GHZ_START_FREQ_MHZ;
    L23:
        if (r4 != 8) goto L29;
        if (r3 < 1) goto L29;
        if (r3 > 233) goto L29;
        return ((r3 - 1) * 5) + ChannelsEnvironment.BAND_6_GHZ_START_FREQ_MHZ;
    L29:
        return -1;
    }

    public static boolean is24GHz(int r1) {
        if (r1 >= 2412) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 2484) goto L7;
        return true;
    }

    public static boolean is5GHz(int r1) {
        if (r1 >= 5160) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 5865) goto L7;
        return true;
    }

    public static boolean is6GHz(int r1) {
        if (r1 >= 5945) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 7105) goto L7;
        return true;
    }

    private static List com_obric_cae_libs_utils_WifiUtils_android_net_wifi_WifiManager_getScanResults(WifiManager r13) {
        c r8 = new c();
        Object[] r9 = new Object[0];
        b r10 = new b();
        d r11 = r8.b(102300, "android/net/wifi/WifiManager", "getScanResults", r13, r9, "java.util.List", r10);
        if (r11.a == false) goto L6;
        r8.a(102300, "android/net/wifi/WifiManager", "getScanResults", r13, r9, null, r10, false);
        return (List) r11.b;
    L6:
        List<ScanResult> r12 = r13.getScanResults();
        r8.a(102300, "android/net/wifi/WifiManager", "getScanResults", r13, r9, r12, r10, true);
        return r12;
    }

    public static int convertFrequencyMhzToChannel(int r1) {
        if (r1 != 2484) goto L7;
        return 14;
    L7:
        if (is24GHz(r1) == false) goto L11;
        return ((r1 - 2412) / 5) + 1;
    L11:
        if (is5GHz(r1) == false) goto L15;
        return ((r1 - 5160) / 5) + 32;
    L15:
        if (is6GHz(r1) == true) goto L17;
        return -1;
    L17:
        return ((r1 - 5945) / 5) + 1;
    }

    public static boolean isWifiConnected(Context r5) {
        ConnectivityManager r0 = (ConnectivityManager) r5.getSystemService("connectivity");
        if (((WifiManager) r5.getSystemService("wifi")) == null) goto L31;
        if (r0 == null) goto L34;
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 23) goto L13;
        if (com_obric_cae_libs_utils_WifiUtils_android_content_Context_checkSelfPermission(r5, "android.permission.ACCESS_NETWORK_STATE") == 0) goto L13;
        LogUtil.e("WifiUtils", "isWifiConnected: ACCESS_NETWORK_STATE permission not granted");
        return false;
    L13:
        if (r1 < 23) goto L23;
        Network r2 = r0.getActiveNetwork();
        if (r2 != null) goto L17;
        return false;
    L17:
        NetworkCapabilities r3 = r0.getNetworkCapabilities(r2);
        if (r3 != null) goto L20;
        return false;
    L20:
        if (r3.hasTransport(1) == false) goto L30;
        return true;
    L30:
        return false;
    L23:
        NetworkInfo r4 = r0.getNetworkInfo(1);
        if (r4 != null) goto L26;
        return false;
    L26:
        if (r4.isConnected() == false) goto L33;
        return true;
    L33:
        return false;
    L34:
        return false;
    L31:
        return false;
    }

    public static String maskMacAddress(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return "";
    L6:
        String[] r1 = r4.split(":");
        if (r1.length == 6) goto L10;
        return r4;
    L10:
        return r1[0] + ":" + r1[1] + ":" + r1[2] + ":**:**:" + r1[5];
    }

    public static String removeDoubleQuotes(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return "";
    L6:
        int r0 = r4.length();
        if (r0 > 1) goto L9;
        return r4;
    L9:
        if (r4.charAt(0) != '\"') goto L15;
        int r1 = r0 - 1;
        if (r4.charAt(r1) == '\"') goto L13;
        return r4;
    L13:
        return r4.substring(1, r1);
    L15:
        return r4;
    }

    public static String ssidHide(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return "";
    L6:
        StringBuilder r0 = new StringBuilder(r3);
        int r4 = r3.length() / 3;
        int r1 = 0;
    L7:
        if (r1 >= r4) goto L10;
        r0.setCharAt(r1, '*');
        r1 = r1 + 1;
        goto L7
    L10:
        return r0.toString();
    }

    private static int com_obric_cae_libs_utils_WifiUtils_android_content_Context_checkSelfPermission(Context r18, String r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        b r11 = new b("auto_cert_com_obric_cae_libs_utils_WifiUtils_android_content_Context_checkSelfPermission");
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102608);
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
        d r4 = r7.preInvoke(102608, "android/content/Context", "checkSelfPermission", r18, r1, "int", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Integer) r4.b).intValue();
    L21:
        return r18.checkSelfPermission(r19);
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

    public static List<ScanResult> getWifiScanResults(Context r3, WifiManager r4) {
        if (r4 == null) goto L4;
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 33) goto L12;
        if (com_obric_cae_libs_utils_WifiUtils_android_content_Context_checkSelfPermission(r3, "android.permission.NEARBY_WIFI_DEVICES") == 0) goto L18;
        LogUtil.e("WifiUtils", "getWifiScanResults: NEARBY_WIFI_DEVICES permission not granted");
        return Collections.emptyList();
    L18:
        return com_obric_cae_libs_utils_WifiUtils_android_net_wifi_WifiManager_getScanResults(r4);
    L12:
        if (r0 < 23) goto L18;
        if (com_obric_cae_libs_utils_WifiUtils_android_content_Context_checkSelfPermission(r3, "android.permission.ACCESS_FINE_LOCATION") == 0) goto L18;
        LogUtil.e("WifiUtils", "getWifiScanResults: ACCESS_FINE_LOCATION permission not granted");
        return Collections.emptyList();
    L4:
        return Collections.emptyList();
    }
}
