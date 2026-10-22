package com.bytedance.crash.util;

import android.os.Build;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
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

    private static int getCpuCoreNumberFromCpuFiles(String r1) {
        File[] r2 = new File(r1).listFiles(new AnonymousClass1());     // Catch: Throwable -> L10
        if (r2 != null) goto L5;
        return -1;
    L5:
        if (r2.length <= 0) goto L13;
        return r2.length;
    L13:
        return -1;
    L14:
        return -1;
    }

    private static int getCpuCoreNumberFromFile(String r3) {
        BufferedReader r0 = null;
        BufferedReader r4 = new BufferedReader(new InputStreamReader(new FileInputStream(r3)));     // Catch: Throwable -> L17
        String r1 = r4.readLine();     // Catch: Throwable -> L10
        if (r1 == null) goto L9;
        int r2 = getCpuCoreNumberFromString(r1);     // Catch: Throwable -> L10
        r4.close();     // Catch: Throwable -> L15
    L8:
        return r2;
    L9:
        r4.close();     // Catch: Throwable -> L16
    L22:
        return -1;
    L10:
        r0 = r4;
    L11:
        if (r0 == null) goto L27;
        r0.close();     // Catch: Throwable -> L16
        goto L22
    L27:
        return -1;
    L28:
        return -1;
    }

    private static int getCpuCoreNumberFromString(String r1) {
        Matcher r2 = cpu_nums_pattern.matcher(r1);
        if (r2.matches() == true) goto L10;
    L7:
        return -1;
    L10:
        return Integer.parseInt(r2.group(1)) + 1;
    }

    public static int getCpuCoreNumbers() {
        int r0 = cpuCores;
        if (r0 <= 0) goto L5;
        return r0;
    L5:
        int r1 = getCpuCoreNumberFromFile("/sys/devices/system/cpu/possible");
        if (r1 > 0) goto L8;
        r1 = getCpuCoreNumberFromFile("/sys/devices/system/cpu/present");
    L8:
        if (r1 > 0) goto L10;
        r1 = getCpuCoreNumberFromCpuFiles("/sys/devices/system/cpu/");
    L10:
        if (r1 > 0) goto L12;
        r1 = Runtime.getRuntime().availableProcessors();
    L12:
        if (r1 > 0) goto L14;
        r1 = 1;
    L14:
        cpuCores = r1;
        return r1;
    }

    public static String getEmuiInfo() {
        return getSystemProperty("ro.build.version.emui");
    }

    private static String getSystemProperty(String r0) {
        return RomUtils.getSystemProperty(r0);
    }

    public static boolean isEmui(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        r1 = getEmuiInfo();
    L5:
        String r0 = r1.toLowerCase(Locale.getDefault());
        if (TextUtils.isEmpty(r1) == true) goto L14;
        if (r0.startsWith("emotionui") == false) goto L10;
        return true;
    L10:
        if (r0.startsWith("magicui") == false) goto L14;
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
        if (TextUtils.isEmpty(Build.BRAND) == true) goto L9;
        if (Build.BRAND.toLowerCase(Locale.getDefault()).startsWith("hua") == false) goto L9;
    L12:
        return true;
    L9:
        if (TextUtils.isEmpty(Build.MANUFACTURER) == true) goto L17;
        if (Build.MANUFACTURER.toLowerCase(Locale.getDefault()).startsWith("hua") == true) goto L12;
        return false;
    L17:
        return false;
    L19:
        return false;
    }

    public static boolean isMiui() {
        if (sIsInited == true) goto L10;
        if (ZeusTransformUtils.forName("miui.os.Build", "com.obric.memorydata.plugin") == null) goto L8;
        isMiui = true;     // Catch: Exception -> L11
    L8:
        sIsInited = true;
    L10:
        return isMiui;
    }
}
