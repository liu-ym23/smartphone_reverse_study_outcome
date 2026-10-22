package com.obric.cae.libs.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.os.SystemProperties;
import com.obric.cae.libs.BuildConfig;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CaelibUtils {
    public CaelibUtils() {
    }

    public static String getAppNameByPID(Context r8, int r10) {
        Iterator<ActivityManager.RunningAppProcessInfo> r11 = ((ActivityManager) r8.getSystemService("activity")).getRunningAppProcesses().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        ActivityManager.RunningAppProcessInfo r12 = r11.next();
        if (r12.pid != r10) goto L4;
        return r12.processName;
    L9:
        return null;
    }

    public static String getAppNameByUID(Context r8, int r10) {
        Iterator<ActivityManager.RunningAppProcessInfo> r11 = ((ActivityManager) r8.getSystemService("activity")).getRunningAppProcesses().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        ActivityManager.RunningAppProcessInfo r12 = r11.next();
        if (r12.uid != r10) goto L4;
        return r12.processName;
    L9:
        return null;
    }

    public static String getCaelibVersion() {
        return BuildConfig.LIB_VERSION;
    }

    public static String getCallingPackageName(Context r8) {
        return r8.getOpPackageName();
    }

    public static int getWiFiAuthTypeFromScanResult(ScanResult r8) {
        if (r8 == null) goto L37;
        String r10 = r8.capabilities;
        if (r10 == null) goto L37;
        if (r10.contains("EAP") == false) goto L12;
        return 1;
    L12:
        if (r10.contains("PSK") == false) goto L15;
        return 2;
    L15:
        if (r10.contains("SAE") == false) goto L18;
        return 2;
    L18:
        if (r10.contains("WEP") == false) goto L21;
        return 2;
    L21:
        if (r10.contains("WAPI-PSK") == false) goto L24;
        return 2;
    L24:
        if (r10.contains("OWE") == false) goto L26;
    L36:
        return 3;
    L26:
        if (r10.contains("OSEN") == true) goto L36;
        if (r10.contains("WPA") == false) goto L31;
    L35:
        return 0;
    L31:
        if (r10.contains("WEP") == true) goto L35;
        if (r10.contains("EAP") == true) goto L35;
        return 3;
    L37:
        return 0;
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

    public static boolean isFileLargerThanMB(File r8, int r10) {
        if (r8 != null) goto L5;
        return false;
    L5:
        if (r8.exists() == true) goto L8;
        return false;
    L8:
        if ((r8.length() / 1048576.0d) <= r10) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean isMtkPlatform() {
        if ("mtk".equalsIgnoreCase(SystemProperties.get("ro.hardware.soc.manufacturer", "")) == false) goto L5;
    L16:
        return true;
    L5:
        if ("Mediatek".equalsIgnoreCase(SystemProperties.get("ro.soc.manufacturer", "")) == true) goto L16;
        if (SystemProperties.get("ro.boot.hardware", "").startsWith("mt") == true) goto L16;
        if (SystemProperties.get("ro.board.platform", "").startsWith("mt") == true) goto L16;
        if (SystemProperties.get("ro.hardware", "").startsWith("mt") == true) goto L16;
        if (SystemProperties.get("ro.soc.model", "").startsWith("MT") == true) goto L16;
        return false;
    }

    public static boolean isQcomPlatform() {
        if ("qcom".equalsIgnoreCase(SystemProperties.get("ro.boot.hardware", "")) == false) goto L5;
    L8:
        return true;
    L5:
        if ("qcom".equalsIgnoreCase(SystemProperties.get("ro.hardware", "")) == true) goto L8;
        return false;
    }

    public static boolean isXiaomiPlatform() {
        List r8 = Arrays.asList(new String[]{"Xiaomi", "Redmi", "Poco"});
        String[] r10 = {"ro.product.brand", "ro.product.odm.brand", "ro.product.manufacturer", "ro.product.system.manufacturer"};
        int r11 = 0;
    L4:
        if (r11 >= 4) goto L13;
        String r12 = SystemProperties.get(r10[r11], "");
        Iterator r13 = r8.iterator();
    L7:
        if (r13.hasNext() == false) goto L12;
        if (((String) r13.next()).equalsIgnoreCase(r12) == false) goto L7;
        return true;
    L12:
        r11 = r11 + 1;
        goto L4
    L13:
        return false;
    }
}
