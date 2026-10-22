package com.bytedance.crash.util;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class Device {
    private static int cpuCores = -1;
    private static final Pattern cpu_nums_pattern = null;
    static boolean isMiui = false;
    private static boolean sIsInited;

    static {
        cpu_nums_pattern = Pattern.compile("^0-([\\d]+)$");
    }

    private Device() {
    }

    private static int getCpuCoreNumberFromCpuFiles(String r10) {
        File[] r11 = new File(r10).listFiles(new AnonymousClass1());     // Catch: Throwable -> L10
        if (r11 != null) goto L5;
        return -1;
    L5:
        if (r11.length <= 0) goto L13;
        return r11.length;
    L13:
        return -1;
    L14:
        return -1;
    }

    private static int getCpuCoreNumberFromFile(String r10) {
        BufferedReader r11 = null;
        BufferedReader r12 = new BufferedReader(new InputStreamReader(new FileInputStream(r10)));     // Catch: Throwable -> L17
        String r13 = r12.readLine();     // Catch: Throwable -> L10
        if (r13 == null) goto L9;
        int r14 = getCpuCoreNumberFromString(r13);     // Catch: Throwable -> L10
        r12.close();     // Catch: Throwable -> L15
    L8:
        return r14;
    L9:
        r12.close();     // Catch: Throwable -> L16
    L22:
        return -1;
    L10:
        r11 = r12;
    L11:
        if (r11 == null) goto L27;
        r11.close();     // Catch: Throwable -> L16
        goto L22
    L27:
        return -1;
    L28:
        return -1;
    }

    private static int getCpuCoreNumberFromString(String r10) {
        Matcher r11 = cpu_nums_pattern.matcher(r10);
        if (r11.matches() == true) goto L10;
    L7:
        return -1;
    L10:
        return Integer.parseInt(r11.group(1)) + 1;
    }

    public static int getCpuCoreNumbers() {
        int r10 = cpuCores;
        if (r10 <= 0) goto L5;
        return r10;
    L5:
        int r11 = getCpuCoreNumberFromFile("/sys/devices/system/cpu/possible");
        if (r11 > 0) goto L8;
        r11 = getCpuCoreNumberFromFile("/sys/devices/system/cpu/present");
    L8:
        if (r11 > 0) goto L10;
        r11 = getCpuCoreNumberFromCpuFiles("/sys/devices/system/cpu/");
    L10:
        if (r11 > 0) goto L12;
        r11 = Runtime.getRuntime().availableProcessors();
    L12:
        if (r11 > 0) goto L14;
        r11 = 1;
    L14:
        cpuCores = r11;
        return r11;
    }

    public static String getEmuiInfo() {
        return getSystemProperty("ro.build.version.emui");
    }

    private static String getSystemProperty(String r10) {
        return RomUtils.getSystemProperty(r10);
    }

    public static boolean isEmui(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        r10 = getEmuiInfo();
    L5:
        String r11 = r10.toLowerCase(Locale.getDefault());
        if (TextUtils.isEmpty(r10) == true) goto L14;
        if (r11.startsWith("emotionui") == false) goto L10;
        return true;
    L10:
        if (r11.startsWith("magicui") == false) goto L14;
        return true;
    L14:
        return isHWDevice();
    }

    public static boolean isFlyme() {
        if (Build.DISPLAY.contains("Flyme") == false) goto L5;
    L8:
        return true;
    L5:
        if (Build.USER.equals("flyme") == true) goto L8;
        return false;
    }

    public static boolean isHWDevice() {
        String r10 = Build.BRAND;     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r10) == false) goto L7;
    L8:
        String r11 = Build.MANUFACTURER;     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r11) == true) goto L17;
        if (r11.toLowerCase(Locale.getDefault()).startsWith("hua") == false) goto L18;
    L12:
        return true;
    L18:
        return false;
    L17:
        return false;
    L7:
        if (r10.toLowerCase(Locale.getDefault()).startsWith("hua") == true) goto L12;
    L19:
        return false;
    }

    public static boolean isMiui() {
        if (sIsInited == true) goto L8;
        Class.forName("miui.os.Build");     // Catch: Exception -> L9
        isMiui = true;     // Catch: Exception -> L9
    L6:
        sIsInited = true;
    L8:
        return isMiui;
    }
}
