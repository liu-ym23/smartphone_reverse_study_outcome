package com.bytedance.apm6.util;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class RomUtils {
    private static final CharSequence AMIGO = null;
    public static final String COLOROS = "coloros";
    public static final String EMUI = "emotionui";
    private static final String EUI = "eui";
    public static final String FLYME = "flyme";
    private static final String FOUTOUCH_OS_SOFTWARE_VERSION = "ro.vivo.product.version";
    private static final CharSequence FUNTOUCHOS = null;
    private static final String FUNTOUCH_OS_VERSION = "ro.vivo.os.build.display.id";
    private static final String KEY_360OS = "ro.build.uiversion";
    public static final String MIUI = "miui";
    private static final String MODEL_LETV = "ro.letv.release.version";
    public static final String RUNTIME_MIUI = "ro.miui.ui.version.name";
    public static final String RUNTIME_OPPO = "ro.build.version.opporom";
    public static final String SEPARATOR = "_";
    private static final CharSequence SONY = null;
    private static String romInfo = null;
    public static boolean sIsInited = false;
    public static boolean sIsMiui = false;
    private static Method sSystemPropertiesGetMethod;

    static {
        SONY = "sony";
        AMIGO = "amigo";
        FUNTOUCHOS = "funtouch";
    }

    private RomUtils() {
    }

    public static String get360OSVersion() {
        return getSystemProperty(KEY_360OS) + "_" + Build.DISPLAY;
    }

    public static String getAmigoVersion() {
        return Build.DISPLAY + "_" + getSystemProperty("ro.gn.sv.version");
    }

    public static String getColorOsVersion() {
        if (isColorOS() == true) goto L5;
        return "";
    L5:
        return "coloros_" + getSystemProperty("ro.build.version.opporom") + "_" + Build.DISPLAY;
    }

    public static String getEMUI() {
        Method r10 = Build.class.getDeclaredMethod("getString", new Class[]{String.class});     // Catch: Throwable -> L6
        r10.setAccessible(true);     // Catch: Throwable -> L6
        Object r11 = r10.invoke(null, new Object[]{"ro.build.version.emui"});     // Catch: Throwable -> L6
        if ((r11 instanceof String) == false) goto L11;
        return (String) r11;
    L11:
        return null;
    L6:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public static String getEMUVersion() {
        String r10 = getEmuiInfo();
        if (r10 != null) goto L5;
        return "";
    L5:
        if (r10.toLowerCase(Locale.getDefault()).contains("emotionui") == true) goto L7;
        return "";
    L7:
        return r10 + "_" + Build.DISPLAY;
    }

    public static String getEUIVersion() {
        if (isEUI() == true) goto L5;
        return "";
    L5:
        return "eui_" + getSystemProperty(MODEL_LETV) + "_" + Build.DISPLAY;
    }

    public static String getEmuiInfo() {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return getSystemProperty("ro.build.version.emui");
    L7:
        return getEMUI();
    }

    public static String getFlymeVersion() {
        String r10 = Build.DISPLAY;
        if (r10 != null) goto L5;
        return "";
    L5:
        if (r10.toLowerCase(Locale.getDefault()).contains("flyme") == false) goto L9;
        return r10;
    L9:
        return "";
    }

    public static String getFuntouchOSVersion() {
        return getSystemProperty(FUNTOUCH_OS_VERSION) + "_" + getSystemProperty(FOUTOUCH_OS_SOFTWARE_VERSION);
    }

    public static String getMIUIVersion() {
        if (isMiui() == true) goto L5;
        return "";
    L5:
        return "miui_" + getSystemProperty("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    private static String getRom() {
        if (isMiui() == false) goto L7;
        return getMIUIVersion();
    L7:
        if (isFlyme() == false) goto L11;
        return getFlymeVersion();
    L11:
        if (isColorOS() == true) goto L13;
        String r10 = getEMUVersion();
        if (TextUtils.isEmpty(r10) == true) goto L18;
        return r10;
    L18:
        if (isFunTouchOS() == false) goto L22;
        return getFuntouchOSVersion();
    L22:
        if (isAmigo() == false) goto L26;
        return getAmigoVersion();
    L26:
        if (is360OS() == true) goto L28;
        String r11 = getEUIVersion();
        if (TextUtils.isEmpty(r11) == true) goto L32;
        return r11;
    L32:
        sIsInited = true;
        return Build.DISPLAY;
    L28:
        return get360OSVersion();
    L13:
        return getColorOsVersion();
    }

    public static String getRomInfo() {
        if (sIsInited == true) goto L5;
    L8:
        String r10 = getRom();
        romInfo = r10;
        return r10;
    L5:
        if (TextUtils.isEmpty(romInfo) == true) goto L8;
        return romInfo;
    }

    private static String getSystemProperty(String r10) {
        String r11 = getSystemPropertyByReflect(r10);
        if (TextUtils.isEmpty(r11) == true) goto L5;
        return r11;
    L5:
        String r12 = "";
        BufferedReader r13 = null;
        Process r14 = Runtime.getRuntime().exec("getprop " + r10);     // Catch: Throwable -> L13
        BufferedReader r15 = new BufferedReader(new InputStreamReader(r14.getInputStream()), 1024);     // Catch: Throwable -> L13
        r12 = r15.readLine();     // Catch: Throwable -> L10
        r14.destroy();     // Catch: Throwable -> L10
        IOUtils.closeQuietly(r15);
        return r12;
    L10:
        r13 = r15;
    L11:
        IOUtils.closeQuietly(r13);
        return r12;
    }

    private static String getSystemPropertyByReflect(String r10) {
    L7:
        e = move-exception;
        e.printStackTrace();
        return "";
    L3:
        if (sSystemPropertiesGetMethod != null) goto L5;
        sSystemPropertiesGetMethod = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});     // Catch: Exception -> L7
    L5:
        return (String) sSystemPropertiesGetMethod.invoke(null, new Object[]{r10});
    }

    public static boolean is360OS() {
        String r10 = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return false;
    L5:
        String r11 = r10.toLowerCase(Locale.getDefault());
        if (r11.contains("360") == false) goto L8;
    L9:
        return true;
    L8:
        if (r11.contains("qiku") == true) goto L9;
        return false;
    }

    public static boolean isAmigo() {
        String r10 = Build.DISPLAY;
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L7:
        return false;
    L5:
        if (r10.toLowerCase(Locale.getDefault()).contains(AMIGO) == false) goto L7;
        return true;
    }

    public static boolean isColorOS() {
        String r10 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return false;
    L5:
        return r10.toLowerCase(Locale.getDefault()).contains("oppo");
    }

    public static boolean isEUI() {
        return !TextUtils.isEmpty(getSystemProperty(MODEL_LETV));
    }

    public static boolean isEmui(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        r10 = getEmuiInfo();
    L6:
        if (TextUtils.isEmpty(r10) == true) goto L11;
        if (r10.toLowerCase().startsWith("emotionui") == false) goto L11;
        return true;
    L11:
        if (isHwDevice() == false) goto L13;
        return true;
    L13:
        return false;
    }

    public static boolean isFlyme() {
        if (Build.DISPLAY.contains("Flyme") == false) goto L5;
        return true;
    L5:
        if ("flyme".equals(Build.USER) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean isFunTouchOS() {
        String r10 = getSystemProperty(FUNTOUCH_OS_VERSION);
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L7:
        return false;
    L5:
        if (r10.toLowerCase(Locale.getDefault()).contains(FUNTOUCHOS) == false) goto L7;
        return true;
    }

    public static boolean isHwDevice() {
        String r10 = Build.BRAND;     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r10) == false) goto L7;
    L8:
        String r11 = Build.MANUFACTURER;     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r11) == true) goto L17;
        if (r11.toLowerCase().startsWith("hua") == false) goto L18;
    L12:
        return true;
    L18:
        return false;
    L17:
        return false;
    L7:
        if (r10.toLowerCase().startsWith("hua") == true) goto L12;
    L19:
        return false;
    }

    public static boolean isMiui() {
        Class.forName("miui.os.Build");     // Catch: Exception -> L4
        sIsMiui = true;     // Catch: Exception -> L4
        return true;
    L5:
        return sIsMiui;
    }

    public static boolean isSony() {
        String r10 = Build.BRAND + Build.MANUFACTURER;
        if (TextUtils.isEmpty(r10) == true) goto L5;
    L8:
        return true;
    L5:
        if (r10.toLowerCase(Locale.getDefault()).contains(SONY) == true) goto L8;
        return false;
    }
}
