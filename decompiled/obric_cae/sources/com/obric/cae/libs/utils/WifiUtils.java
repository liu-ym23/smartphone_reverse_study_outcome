package com.obric.cae.libs.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.obric.cae.libs.wifi.basicInfo.ChannelsEnvironment;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WifiUtils {
    public static final int WIFI_BAND_24_GHZ = 1;
    public static final int WIFI_BAND_5_GHZ = 2;
    public static final int WIFI_BAND_6_GHZ = 8;

    public WifiUtils() {
    }

    public static int convertChannelToFrequencyMhz(int r8, int r10) {
        if (r10 != 1) goto L14;
        if (r8 != 14) goto L8;
        return 2484;
    L8:
        if (r8 < 1) goto L12;
        if (r8 > 14) goto L12;
        return ((r8 - 1) * 5) + 2412;
    L12:
        return -1;
    L14:
        if (r10 != 2) goto L23;
        if (r8 >= 32) goto L18;
    L21:
        return -1;
    L18:
        if (r8 > 173) goto L21;
        return ((r8 - 32) * 5) + 5160;
    L23:
        if (r10 != 8) goto L29;
        if (r8 < 1) goto L29;
        if (r8 > 233) goto L29;
        return ((r8 - 1) * 5) + ChannelsEnvironment.BAND_6_GHZ_START_FREQ_MHZ;
    L29:
        return -1;
    }

    public static int convertFrequencyMhzToChannel(int r8) {
        if (r8 != 2484) goto L7;
        return 14;
    L7:
        if (is24GHz(r8) == false) goto L11;
        return ((r8 - 2412) / 5) + 1;
    L11:
        if (is5GHz(r8) == false) goto L15;
        return ((r8 - 5160) / 5) + 32;
    L15:
        if (is6GHz(r8) == true) goto L17;
        return -1;
    L17:
        return ((r8 - 5945) / 5) + 1;
    }

    public static List<ScanResult> getWifiScanResults(Context r8, WifiManager r10) {
        if (r10 != null) goto L6;
        return Collections.emptyList();
    L6:
        if (Build.VERSION.SDK_INT < 33) goto L13;
        if (r8.checkSelfPermission("android.permission.NEARBY_WIFI_DEVICES") == 0) goto L16;
        String r11 = "getWifiScanResults: NEARBY_WIFI_DEVICES permission not granted";
    L10:
        LogUtil.e("WifiUtils", r11);
        return Collections.emptyList();
    L16:
        return r10.getScanResults();
    L13:
        if (r8.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) goto L16;
        r11 = "getWifiScanResults: ACCESS_FINE_LOCATION permission not granted";
        goto L10
    }

    public static boolean is24GHz(int r8) {
        if (r8 >= 2412) goto L5;
    L7:
        return false;
    L5:
        if (r8 > 2484) goto L7;
        return true;
    }

    public static boolean is5GHz(int r8) {
        if (r8 >= 5160) goto L5;
    L7:
        return false;
    L5:
        if (r8 > 5865) goto L7;
        return true;
    }

    public static boolean is6GHz(int r8) {
        if (r8 >= 5945) goto L5;
    L7:
        return false;
    L5:
        if (r8 > 7105) goto L7;
        return true;
    }

    public static boolean isWifiConnected(Context r8) {
        ConnectivityManager r10 = (ConnectivityManager) r8.getSystemService("connectivity");
        if (((WifiManager) r8.getSystemService("wifi")) == null) goto L19;
        if (r10 != null) goto L7;
        return false;
    L7:
        if (r8.checkSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) goto L10;
        LogUtil.e("WifiUtils", "isWifiConnected: ACCESS_NETWORK_STATE permission not granted");
        return false;
    L10:
        Network r11 = r10.getActiveNetwork();
        if (r11 != null) goto L13;
        return false;
    L13:
        NetworkCapabilities r12 = r10.getNetworkCapabilities(r11);
        if (r12 != null) goto L16;
        return false;
    L16:
        if (r12.hasTransport(1) == true) goto L18;
        return false;
    L18:
        return true;
    L19:
        return false;
    }

    public static String maskMacAddress(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L6;
        return "";
    L6:
        String[] r10 = r8.split(BdimCategoryConstants.SEPARATOR_COLON);
        if (r10.length == 6) goto L10;
        return r8;
    L10:
        return r10[0] + BdimCategoryConstants.SEPARATOR_COLON + r10[1] + BdimCategoryConstants.SEPARATOR_COLON + r10[2] + ":**:**:" + r10[5];
    }

    public static String removeDoubleQuotes(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L6;
        return "";
    L6:
        int r10 = r8.length();
        if (r10 > 1) goto L9;
        return r8;
    L9:
        if (r8.charAt(0) != '\"') goto L15;
        int r11 = r10 - 1;
        if (r8.charAt(r11) == '\"') goto L13;
        return r8;
    L13:
        return r8.substring(1, r11);
    L15:
        return r8;
    }

    public static String ssidHide(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L6;
        return "";
    L6:
        StringBuilder r10 = new StringBuilder(r8);
        int r11 = r8.length() / 3;
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L10;
        r10.setCharAt(r12, '*');
        r12 = r12 + 1;
        goto L7
    L10:
        return r10.toString();
    }
}
