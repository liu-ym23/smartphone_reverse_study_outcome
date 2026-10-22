package com.obric.cae.utils;

import android.text.TextUtils;
import android.util.Log;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;

/* JADX INFO: loaded from: classes2.dex */
public class CaeWifiUtil {
    public static final int BAND_24_GHZ_END_FREQ_MHZ = 2484;
    public static final int BAND_24_GHZ_START_FREQ_MHZ = 2412;
    public static final int BAND_5_GHZ_END_FREQ_MHZ = 5885;
    public static final int BAND_5_GHZ_START_FREQ_MHZ = 5160;
    public static final int BAND_6_GHZ_END_FREQ_MHZ = 7115;
    public static final int BAND_6_GHZ_OP_CLASS_136_CH_2_FREQ_MHZ = 5935;
    public static final int BAND_6_GHZ_PSC_START_MHZ = 5975;
    public static final int BAND_6_GHZ_START_FREQ_MHZ = 5955;
    private static final String TAG = "CaeWifiUtil";

    public CaeWifiUtil() {
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
        if (r8 > 5885) goto L7;
        return true;
    }

    public static boolean is6GHz(int r8) {
        if (r8 != 5935) goto L6;
        return true;
    L6:
        if (r8 >= 5955) goto L8;
    L10:
        return false;
    L8:
        if (r8 > 7115) goto L10;
        return true;
    }

    public static String maskMACAddress(String r8) {
        return CaeUtil.maskMacOrBssid(r8);
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
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return "";
    L5:
        String r10 = removeDoubleQuotes(r8);
        StringBuilder r11 = new StringBuilder(r10);     // Catch: Exception -> L11 StringIndexOutOfBoundsException -> L15 NullPointerException -> L17
        int r12 = r10.length() / 3;     // Catch: Exception -> L11 StringIndexOutOfBoundsException -> L15 NullPointerException -> L17
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L9;
        r11.setCharAt(r13, '*');     // Catch: Exception -> L11 StringIndexOutOfBoundsException -> L15 NullPointerException -> L17
        r13 = r13 + 1;     // Catch: Exception -> L11 StringIndexOutOfBoundsException -> L15 NullPointerException -> L17
        goto L7
    L9:
        return r11.toString();
    L17:
        e = e;
        StringBuilder r14 = new StringBuilder("Input string is null: e=");
    L13:
        r14.append(e);
        Log.e(TAG, r14.toString());
        return "";
    L15:
        e = e;
        r14 = new StringBuilder("String index out of bounds: e=");
    L11:
        e = e;
        r14 = new StringBuilder("fail: e=");
        goto L13
    }

    public static String toBand(int r8) {
        if (is24GHz(r8) == false) goto L7;
        return "24G";
    L7:
        if (is5GHz(r8) == false) goto L11;
        return "5G";
    L11:
        if (is6GHz(r8) == false) goto L14;
        return "6G";
    L14:
        return BdimCategoryConstants.VALUE_UNKNOWN;
    }

    public static String wifiStandardToGenerationString(int r8) {
        if (r8 == 1) goto L17;
        switch(r8) {
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L9;
            case 8: goto L7;
            default: goto L5;
        };
    L5:
        return "unknown";
    L7:
        return "wifi7";
    L9:
        return "wifiAD";
    L11:
        return "wifi6";
    L13:
        return "wifi5";
    L15:
        return "wifi4";
    L17:
        return "wifi3";
    }
}
