package com.bytedance.badger.collect.impl.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.bytedance.badger.collect.impl.constants.Constants;
import f06.b;
import f06.c;
import f06.d;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class NetworkTypeUtils {
    public NetworkTypeUtils() {
    }

    private static String com_bytedance_badger_collect_impl_utils_NetworkTypeUtils_android_telephony_TelephonyManager_getSimOperator(TelephonyManager r13) {
        c r8 = new c();
        Object[] r9 = new Object[0];
        b r10 = new b();
        d r12 = r8.b(102021, "android/telephony/TelephonyManager", "getSimOperator", r13, r9, "java.lang.String", r10);
        if (r12.a == false) goto L6;
        r8.a(102021, "android/telephony/TelephonyManager", "getSimOperator", r13, r9, null, r10, false);
        return (String) r12.b;
    L6:
        String r14 = r13.getSimOperator();
        r8.a(102021, "android/telephony/TelephonyManager", "getSimOperator", r13, r9, r14, r10, true);
        return r14;
    }

    public static String getCarrier(Context r12) {
        if (isSimCardReady(r12) == true) goto L7;
        return Constants.NetworkOperator.SIM_CARD_NOT_READY;
    L7:
        String r13 = getCarrierType(getMccMnc(r12));     // Catch: Exception -> L46
        int r1 = r13.hashCode();     // Catch: Exception -> L46
        if (r1 == (-1300183871)) goto L31;
        if (r1 == (-278955830)) goto L28;
        if (r1 == (-50643271)) goto L25;
        if (r1 == 0) goto L22;
        if (r1 == 1582678639) goto L19;
    L33:
        byte r14 = -1;
    L34:
        if (r14 == 0) goto L44;
        if (r14 == 1) goto L52;
        if (r14 == 2) goto L51;
        if (r14 == 3) goto L50;
        if (r14 == 4) goto L49;
        return "";
    L49:
        return Constants.NetworkOperator.OTHERS_OPERATOR;
    L50:
        return Constants.NetworkOperator.TELECOM_OPERATOR;
    L51:
        return Constants.NetworkOperator.UNICOM_OPERATOR;
    L52:
        return Constants.NetworkOperator.MOBILE_OPERATOR;
    L44:
        return Constants.NetworkOperator.UNKNOWN_OPERATOR;
    L19:
        if (r13.equals(Constants.NetworkOperator.TELECOM_OPERATOR) == false) goto L33;
        r14 = 3;
        goto L34
    L22:
        if (r13.equals("") == false) goto L33;
        r14 = 0;
        goto L34
    L25:
        if (r13.equals(Constants.NetworkOperator.UNICOM_OPERATOR) == false) goto L33;
        r14 = 2;
        goto L34
    L28:
        if (r13.equals(Constants.NetworkOperator.MOBILE_OPERATOR) == false) goto L33;
        r14 = 1;
        goto L34
    L31:
        if (r13.equals(Constants.NetworkOperator.OTHERS_OPERATOR) == false) goto L33;
        r14 = 4;
        goto L34
    L53:
        return "";
    }

    private static String getCarrierType(String r2) {
        r2.getClass();
        byte r1 = -1;
        switch(r2.hashCode()) {
            case 49679470: goto L46;
            case 49679471: goto L42;
            case 49679472: goto L38;
            case 49679473: goto L34;
            case 49679474: goto L30;
            case 49679475: goto L26;
            case 49679476: goto L22;
            case 49679477: goto L18;
            case 49679478: goto L14;
            case 49679479: goto L10;
            case 49679502: goto L6;
            default: goto L49;
        };
    L49:
        switch(r1) {
            case 0: goto L56;
            case 1: goto L54;
            case 2: goto L56;
            case 3: goto L52;
            case 4: goto L56;
            case 5: goto L52;
            case 6: goto L54;
            case 7: goto L56;
            case 8: goto L56;
            case 9: goto L54;
            case 10: goto L52;
            default: goto L50;
        };
    L50:
        return "";
    L52:
        return Constants.NetworkOperator.TELECOM_OPERATOR;
    L54:
        return Constants.NetworkOperator.UNICOM_OPERATOR;
    L56:
        return Constants.NetworkOperator.MOBILE_OPERATOR;
    L6:
        if (r2.equals("46011") == false) goto L49;
        r1 = 10;
        goto L49
    L10:
        if (r2.equals("46009") == false) goto L49;
        r1 = 9;
        goto L49
    L14:
        if (r2.equals("46008") == false) goto L49;
        r1 = 8;
        goto L49
    L18:
        if (r2.equals("46007") == false) goto L49;
        r1 = 7;
        goto L49
    L22:
        if (r2.equals("46006") == false) goto L49;
        r1 = 6;
        goto L49
    L26:
        if (r2.equals("46005") == false) goto L49;
        r1 = 5;
        goto L49
    L30:
        if (r2.equals("46004") == false) goto L49;
        r1 = 4;
        goto L49
    L34:
        if (r2.equals("46003") == false) goto L49;
        r1 = 3;
        goto L49
    L38:
        if (r2.equals("46002") == false) goto L49;
        r1 = 2;
        goto L49
    L42:
        if (r2.equals("46001") == false) goto L49;
        r1 = 1;
        goto L49
    L46:
        if (r2.equals("46000") == false) goto L49;
        r1 = 0;
        goto L49
    }

    public static String getMccMnc(Context r2) {
        if (r2 != null) goto L11;
        return "";
    L11:
        TelephonyManager r3 = (TelephonyManager) r2.getSystemService("phone");     // Catch: Throwable -> L10
        if (r3 != null) goto L8;
        return "";
    L8:
        return com_bytedance_badger_collect_impl_utils_NetworkTypeUtils_android_telephony_TelephonyManager_getSimOperator(r3);
    L10:
        return "";
    }

    public static String getNetworkStatus(Context r8) {
        if (r8 != null) goto L5;
        return Constants.NetworkOperator.NETWORK_TYPE_UNKNOWN;
    L5:
        ConnectivityManager r1 = (ConnectivityManager) r8.getApplicationContext().getSystemService("connectivity");
        if (r1 != null) goto L9;
        return Constants.NetworkOperator.NETWORK_TYPE_UNKNOWN;
    L9:
        if (Build.VERSION.SDK_INT < 23) goto L22;
        Network r0 = r1.getActiveNetwork();
        if (r0 == null) goto L22;
        NetworkCapabilities r2 = r1.getNetworkCapabilities(r0);
        if (r2 == null) goto L22;
        boolean r3 = r2.hasTransport(0);
        boolean r4 = r2.hasTransport(1);
        if (isDataMobileEnabled(r8, r1) == false) goto L18;
        if (r4 == false) goto L18;
        return Constants.NetworkOperator.NETWORK_TYPE_WIFI_AND_MOBILE;
    L18:
        if (r4 == false) goto L20;
        return Constants.NetworkOperator.NETWORK_TYPE_WIFI;
    L20:
        if (r3 == false) goto L22;
        return Constants.NetworkOperator.NETWORK_TYPE_MOBILE;
    L22:
        NetworkInfo r5 = r1.getActiveNetworkInfo();
        if (r5 != null) goto L25;
    L35:
        return Constants.NetworkOperator.NETWORK_TYPE_NO_NET;
    L25:
        if (r5.isAvailable() == false) goto L35;
        int r6 = r5.getType();
        if (r6 == 1) goto L30;
        if (r6 != 0) goto L35;
        return Constants.NetworkOperator.NETWORK_TYPE_MOBILE;
    L30:
        if (isDataMobileEnabled(r8, r1) == false) goto L32;
        return Constants.NetworkOperator.NETWORK_TYPE_WIFI_AND_MOBILE;
    L32:
        return Constants.NetworkOperator.NETWORK_TYPE_WIFI;
    }

    public static boolean isNetReady(Context r2) {
        NetworkInfo r3 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r3 == null) goto L12;
        if (r3.isAvailable() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    private static boolean isSimCardReady(Context r2) {
        if (r2 == null) goto L15;
        TelephonyManager r3 = (TelephonyManager) r2.getSystemService("phone");     // Catch: Exception -> L12
        if (r3 != null) goto L7;
        return false;
    L7:
        if (r3.getSimState() != 5) goto L16;
        return true;
    L16:
        return false;
    L17:
        return false;
    L15:
        return false;
    }

    private static boolean isDataMobileEnabled(Context r3, ConnectivityManager r4) {
    L10:
        e = move-exception;
        e.printStackTrace();
    L12:
        return false;
    L4:
        if (isSimCardReady(r3) == true) goto L6;
        return false;
    L6:
        Method r5 = r4.getClass().getDeclaredMethod("getMobileDataEnabled", new Class[0]);     // Catch: Exception -> L10
        if (r5 == null) goto L12;
        r5.setAccessible(true);     // Catch: Exception -> L10
        return ((Boolean) r5.invoke(r4, new Object[0])).booleanValue();
    }
}
