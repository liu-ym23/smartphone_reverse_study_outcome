package com.bytedance.bdinstall.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class RomUtils {
    private static final CharSequence AMIGO = null;
    public static final String COLOROS = "coloros";
    public static final String EMUI = "emotionui";
    private static final String EUI = "eui";
    public static final String FLYME = "flyme";
    private static final String FOUTOUCH_OS_SOFTWARE_VERSION = "ro.vivo.product.version";
    private static final String FUNTOUCH_OS_VERSION = "ro.vivo.os.build.display.id";
    private static final String HARMONY_UI = "harmony";
    private static final String KEY_360OS = "ro.build.uiversion";
    private static final String MAGIC_UI = "magicui";
    public static final String MIUI = "miui";
    private static final String MODEL_LETV = "ro.letv.release.version";
    public static final String RUNTIME_MIUI = "ro.miui.ui.version.name";
    public static final String RUNTIME_OPPO = "ro.build.version.opporom";
    public static final String SEPARATOR = "_";
    private static final CharSequence SONY = null;
    private static final Singleton<Boolean> sIsHarmony = null;

    static {
        SONY = "sony";
        AMIGO = "amigo";
        sIsHarmony = new AnonymousClass1();
    }

    public RomUtils() {
    }

    public static String get360OSVersion() {
        return getSystemPropertyV2(KEY_360OS) + "_" + Build.DISPLAY;
    }

    public static String getAmigoVersion() {
        return Build.DISPLAY + "_" + getSystemPropertyV2("ro.gn.sv.version");
    }

    public static String getColorOsVersion() {
        if (isColorOS() == true) goto L5;
        return "";
    L5:
        return "coloros_" + getSystemPropertyV2("ro.build.version.opporom") + "_" + Build.DISPLAY;
    }

    public static String getEMUVersion() {
        String r10 = getEmuiInfo();
        if (r10 != null) goto L5;
        return "";
    L5:
        if (r10.toLowerCase().contains("emotionui") == true) goto L9;
        if (r10.toLowerCase().contains(MAGIC_UI) == true) goto L9;
        return "";
    L9:
        return r10 + "_" + Build.DISPLAY;
    }

    public static String getEUIVersion() {
        if (isEUI() == true) goto L5;
        return "";
    L5:
        return "eui_" + getSystemPropertyV2(MODEL_LETV) + "_" + Build.DISPLAY;
    }

    public static String getEmuiInfo() {
        return getSystemPropertyV2("ro.build.version.emui");
    }

    public static String getFlymeVersion() {
        String r10 = Build.DISPLAY;
        if (r10 != null) goto L5;
        return "";
    L5:
        if (r10.toLowerCase().contains("flyme") == false) goto L9;
        return r10;
    L9:
        return "";
    }

    public static String getFuntouchOSVersion() {
        return getSystemPropertyV2(FUNTOUCH_OS_VERSION) + "_" + getSystemPropertyV2(FOUTOUCH_OS_SOFTWARE_VERSION);
    }

    public static String getMIUIVersion() {
        if (isMiui() == true) goto L5;
        return "";
    L5:
        return "miui_" + getSystemPropertyV2("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    private static String getManufacturer() {
        String r10 = Build.MANUFACTURER;
        if (r10 != null) goto L6;
        return "";
    L6:
        return r10.trim();
    }

    public static String getProductName() {
        String r10 = getSystemProperty("persist.pxr.product.forcename", "");
        if (TextUtils.isEmpty(r10) == false) goto L6;
        r10 = getSystemProperty("pxr.vendorhw.product.name", "");
    L6:
        if (TextUtils.isEmpty(r10) == true) goto L8;
        return r10;
    L8:
        return Build.PRODUCT;
    }

    public static String getRomInfo() {
        if (isMiui() == false) goto L7;
        return getMIUIVersion();
    L7:
        if (isColorOS() == true) goto L9;
        String r10 = getEMUVersion();
        if (TextUtils.isEmpty(r10) == true) goto L14;
        return r10;
    L14:
        if (isVIVO() == false) goto L18;
        return getFuntouchOSVersion();
    L18:
        if (isFlyme() == false) goto L22;
        return getFlymeVersion();
    L22:
        if (isAmigo() == false) goto L26;
        return getAmigoVersion();
    L26:
        if (is360OS() == true) goto L28;
        String r11 = getEUIVersion();
        if (TextUtils.isEmpty(r11) == true) goto L33;
        return r11;
    L33:
        return Build.DISPLAY;
    L28:
        return get360OSVersion();
    L9:
        return getColorOsVersion();
    }

    public static String getSystemProperty(String r10, String r11) {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{r10, r11});
    L5:
        return r11;
    }

    private static String getSystemPropertyV2(String r10) {
        return (String) SystemPropertiesWithCache.get(r10);
    }

    public static boolean is360OS() {
        String r10 = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return false;
    L5:
        String r11 = r10.toLowerCase();
        if (r11.contains("360") == false) goto L8;
    L9:
        return true;
    L8:
        if (r11.contains("qiku") == true) goto L9;
        return false;
    }

    public static boolean isASUS() {
        return getManufacturer().toUpperCase().contains("ASUS");
    }

    public static boolean isAmigo() {
        String r10 = Build.DISPLAY;
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L7:
        return false;
    L5:
        if (r10.toLowerCase().contains(AMIGO) == false) goto L7;
        return true;
    }

    public static boolean isAndroidQOrHigher() {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 29) goto L5;
    L10:
        return true;
    L5:
        if (r10 == 28) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    public static boolean isAndroidROrHigher() {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 30) goto L5;
    L10:
        return true;
    L5:
        if (r10 == 29) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    public static boolean isBlackShark() {
        if ("BlackShark".equalsIgnoreCase(Build.MANUFACTURER) == false) goto L5;
    L8:
        return true;
    L5:
        if ("BlackShark".equalsIgnoreCase(Build.BRAND) == true) goto L8;
        return false;
    }

    public static boolean isColorOS() {
        if ("oppo".equalsIgnoreCase(Build.MANUFACTURER) == true) goto L10;
        String r10 = Build.BRAND;
        if ("oppo".equalsIgnoreCase(r10) == true) goto L10;
        if ("realme".equalsIgnoreCase(r10) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean isEUI() {
        return !TextUtils.isEmpty(getSystemPropertyV2(MODEL_LETV));
    }

    public static boolean isFlyme() {
        String r10 = Build.DISPLAY;
        if (TextUtils.isEmpty(r10) == true) goto L7;
        if (r10.contains("Flyme") == false) goto L7;
    L8:
        return true;
    L7:
        if ("flyme".equals(Build.USER) == true) goto L8;
        return false;
    }

    public static boolean isHarmonyUI() {
        return sIsHarmony.get(new Object[0]).booleanValue();
    }

    public static boolean isHonorDevice() {
        String r10 = Build.BRAND;
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L6:
        String r11 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r11) == false) goto L9;
    L11:
        return false;
    L9:
        if (r11.toLowerCase().startsWith("honor") == false) goto L11;
    L10:
        return true;
    L5:
        if (r10.toLowerCase().startsWith("honor") == true) goto L10;
        goto L6
    }

    public static boolean isHuawei() {
        return "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER);
    }

    private static boolean isHuaweiDevice() {
        String r10 = Build.BRAND;
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L6:
        String r11 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r11) == false) goto L9;
    L11:
        return false;
    L9:
        if (r11.toLowerCase().startsWith("huawei") == false) goto L11;
    L10:
        return true;
    L5:
        if (r10.toLowerCase().startsWith("huawei") == true) goto L10;
        goto L6
    }

    public static boolean isHwOrHonor(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        r10 = getEmuiInfo();
    L6:
        if (TextUtils.isEmpty(r10) == true) goto L13;
        if (r10.toLowerCase().contains("emotionui") == false) goto L10;
    L11:
        return true;
    L10:
        if (r10.toLowerCase().contains(MAGIC_UI) == true) goto L11;
    L13:
        if (isHuaweiDevice() == false) goto L15;
        return true;
    L15:
        if (isHonorDevice() == true) goto L20;
        return false;
    L20:
        return true;
    }

    public static boolean isLenovo() {
        String r10 = Build.FINGERPRINT;
        if (TextUtils.isEmpty(r10) == false) goto L5;
        String r11 = getSystemPropertyV2("ro.build.version.incremental");
        if (TextUtils.isEmpty(r11) == false) goto L9;
    L11:
        return false;
    L9:
        if (r11.contains("VIBEUI_V2") == false) goto L11;
        return true;
    L5:
        return r10.contains("VIBEUI_V2");
    }

    public static boolean isMeizu() {
        String r10 = Build.BRAND;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.toLowerCase(Locale.ENGLISH).contains("meizu");
    }

    public static boolean isMiui() {
        if (Class.forName("miui.os.Build").getName().length() <= 0) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    public static boolean isNubia() {
        return getManufacturer().toUpperCase().contains("NUBIA");
    }

    public static boolean isOnePlus() {
        if ("OnePlus".equalsIgnoreCase(Build.MANUFACTURER) == false) goto L5;
    L8:
        return true;
    L5:
        if ("OnePlus".equalsIgnoreCase(Build.BRAND) == true) goto L8;
        return false;
    }

    public static boolean isSamsung() {
        if ("samsung".equalsIgnoreCase(Build.BRAND) == false) goto L5;
    L8:
        return true;
    L5:
        if ("samsung".equalsIgnoreCase(Build.MANUFACTURER) == true) goto L8;
        return false;
    }

    public static boolean isSony() {
        String r10 = Build.BRAND + Build.MANUFACTURER;
        if (TextUtils.isEmpty(r10) == true) goto L5;
    L8:
        return true;
    L5:
        if (r10.toLowerCase().contains(SONY) == true) goto L8;
        return false;
    }

    public static boolean isTargetQOrHigher(Context r10) {
        if (r10.getApplicationInfo().targetSdkVersion < 29) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isTargetROrHigher(Context r10) {
        if (r10.getApplicationInfo().targetSdkVersion < 30) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isVIVO() {
        return !TextUtils.isEmpty(getSystemPropertyV2(FUNTOUCH_OS_VERSION));
    }

    public static boolean isXiaomi() {
        if (Build.MANUFACTURER.equalsIgnoreCase("XIAOMI") == true) goto L10;
        String r10 = Build.BRAND;
        if (r10.equalsIgnoreCase("XIAOMI") == true) goto L10;
        if (r10.equalsIgnoreCase("REDMI") == true) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean isZTE() {
        return getManufacturer().toUpperCase().contains("ZTE");
    }
}
