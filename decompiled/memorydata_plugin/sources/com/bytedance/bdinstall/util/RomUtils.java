package com.bytedance.bdinstall.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.honor.HonorKeys;
import com.tom_roush.pdfbox.pdmodel.a.d.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
        String r0 = getEmuiInfo();
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.toLowerCase().contains("emotionui") == true) goto L9;
        if (r0.toLowerCase().contains(MAGIC_UI) == true) goto L9;
        return "";
    L9:
        return r0 + "_" + Build.DISPLAY;
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
        String r0 = Build.DISPLAY;
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.toLowerCase().contains("flyme") == false) goto L9;
        return r0;
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
        if (Build.MANUFACTURER != null) goto L6;
        return "";
    L6:
        return Build.MANUFACTURER.trim();
    }

    public static String getProductName() {
        String r0 = getSystemProperty("persist.pxr.product.forcename", "");
        if (TextUtils.isEmpty(r0) == false) goto L6;
        r0 = getSystemProperty("pxr.vendorhw.product.name", "");
    L6:
        if (TextUtils.isEmpty(r0) == true) goto L8;
        return r0;
    L8:
        return Build.PRODUCT;
    }

    public static String getRomInfo() {
        if (isMiui() == false) goto L7;
        return getMIUIVersion();
    L7:
        if (isColorOS() == true) goto L9;
        String r0 = getEMUVersion();
        if (TextUtils.isEmpty(r0) == true) goto L14;
        return r0;
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
        String r1 = getEUIVersion();
        if (TextUtils.isEmpty(r1) == true) goto L33;
        return r1;
    L33:
        return Build.DISPLAY;
    L28:
        return get360OSVersion();
    L9:
        return getColorOsVersion();
    }

    public static String getSystemProperty(String r8, String r9) {
        return (String) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.memorydata.plugin").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{r8, r9}), String.class, "com.obric.memorydata.plugin");
    L5:
        return r9;
    }

    private static String getSystemPropertyV2(String r2) {
        return (String) ZeusTransformUtils.preCheckCast(SystemPropertiesWithCache.get(r2), String.class, "com.obric.memorydata.plugin");
    }

    public static boolean hasHWVersion() {
        Class r2 = ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.memorydata.plugin");     // Catch: Exception -> L7
        String r0 = (String) ZeusTransformUtils.preCheckCast(r2.getDeclaredMethod("get", new Class[]{String.class}).invoke(r2, new Object[]{"ro.build.version.emui"}), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L7
        if (TextUtils.isEmpty(r0) == true) goto L9;
        DrLog.d("honor# oldHonor device, version is" + r0);     // Catch: Exception -> L7
        return true;
    L9:
        return false;
    L7:
        e = move-exception;
        DrLog.e("Honor# " + e.getMessage(), e);
        goto L9
    }

    public static boolean is360OS() {
        String r0 = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return false;
    L5:
        String r1 = r0.toLowerCase();
        if (r1.contains(d.aj) == false) goto L8;
    L9:
        return true;
    L8:
        if (r1.contains("qiku") == true) goto L9;
        return false;
    }

    public static boolean isASUS() {
        return getManufacturer().toUpperCase().contains("ASUS");
    }

    public static boolean isAmigo() {
        if (TextUtils.isEmpty(Build.DISPLAY) == false) goto L5;
    L7:
        return false;
    L5:
        if (Build.DISPLAY.toLowerCase().contains(AMIGO) == false) goto L7;
        return true;
    }

    public static boolean isAndroidQOrHigher() {
        if (Build.VERSION.SDK_INT < 29) goto L5;
    L10:
        return true;
    L5:
        if (Build.VERSION.SDK_INT == 28) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    public static boolean isAndroidROrHigher() {
        if (Build.VERSION.SDK_INT < 30) goto L5;
    L10:
        return true;
    L5:
        if (Build.VERSION.SDK_INT == 29) goto L7;
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
        if ("oppo".equalsIgnoreCase(Build.MANUFACTURER) == false) goto L5;
    L10:
        return true;
    L5:
        if ("oppo".equalsIgnoreCase(Build.BRAND) == true) goto L10;
        if ("realme".equalsIgnoreCase(Build.BRAND) == true) goto L10;
        return false;
    }

    public static boolean isEUI() {
        return !TextUtils.isEmpty(getSystemPropertyV2(MODEL_LETV));
    }

    public static boolean isFlyme() {
        if (TextUtils.isEmpty(Build.DISPLAY) == true) goto L7;
        if (Build.DISPLAY.contains("Flyme") == false) goto L7;
    L8:
        return true;
    L7:
        if ("flyme".equals(Build.USER) == true) goto L8;
        return false;
    }

    public static boolean isHarmonyUI() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(sIsHarmony.get(new Object[0]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public static boolean isHonorDevice() {
        if (TextUtils.isEmpty(Build.BRAND) == true) goto L7;
        if (Build.BRAND.toLowerCase().startsWith("honor") == false) goto L7;
    L12:
        return true;
    L7:
        if (TextUtils.isEmpty(Build.MANUFACTURER) == true) goto L11;
        if (Build.MANUFACTURER.toLowerCase().startsWith("honor") == true) goto L12;
    L11:
        if (HonorKeys.NAME.equalsIgnoreCase(Build.MANUFACTURER) == true) goto L12;
        return false;
    }

    public static boolean isHuawei() {
        return "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER);
    }

    private static boolean isHuaweiDevice() {
        if (TextUtils.isEmpty(Build.BRAND) == true) goto L7;
        if (Build.BRAND.toLowerCase().startsWith("huawei") == false) goto L7;
    L10:
        return true;
    L7:
        if (TextUtils.isEmpty(Build.MANUFACTURER) == false) goto L9;
    L11:
        return false;
    L9:
        if (Build.MANUFACTURER.toLowerCase().startsWith("huawei") == false) goto L11;
        goto L10
    }

    public static boolean isHwOrHonor(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        r3 = getEmuiInfo();
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L13;
        if (r3.toLowerCase().contains("emotionui") == false) goto L10;
    L11:
        return true;
    L10:
        if (r3.toLowerCase().contains(MAGIC_UI) == true) goto L11;
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
        if ("lenovo".equalsIgnoreCase(Build.BRAND) == false) goto L5;
        return true;
    L5:
        if ("motorola".equalsIgnoreCase(Build.MANUFACTURER) == true) goto L19;
        String r0 = Build.FINGERPRINT;
        if (TextUtils.isEmpty(r0) == false) goto L10;
        String r1 = getSystemPropertyV2("ro.build.version.incremental");
        if (TextUtils.isEmpty(r1) == false) goto L14;
    L16:
        return false;
    L14:
        if (r1.contains("VIBEUI_V2") == false) goto L16;
        return true;
    L10:
        return r0.contains("VIBEUI_V2");
    L19:
        return true;
    }

    public static boolean isMeizu() {
        String r0 = Build.BRAND;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.toLowerCase(Locale.ENGLISH).contains("meizu");
    }

    public static boolean isMiui() {
        if (ZeusTransformUtils.forName("miui.os.Build", "com.obric.memorydata.plugin").getName().length() <= 0) goto L10;
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
        String r0 = Build.BRAND + Build.MANUFACTURER;
        if (TextUtils.isEmpty(r0) == true) goto L5;
    L8:
        return true;
    L5:
        if (r0.toLowerCase().contains(SONY) == true) goto L8;
        return false;
    }

    public static boolean isTargetQOrHigher(Context r2) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getApplicationInfo().targetSdkVersion < 29) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isTargetROrHigher(Context r2) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getApplicationInfo().targetSdkVersion < 30) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isVIVO() {
        return !TextUtils.isEmpty(getSystemPropertyV2(FUNTOUCH_OS_VERSION));
    }

    public static boolean isXiaomi() {
        if (Build.MANUFACTURER.equalsIgnoreCase("XIAOMI") == false) goto L5;
    L10:
        return true;
    L5:
        if (Build.BRAND.equalsIgnoreCase("XIAOMI") == true) goto L10;
        if (Build.BRAND.equalsIgnoreCase("REDMI") == true) goto L10;
        return false;
    }

    public static boolean isZTE() {
        return getManufacturer().toUpperCase().contains("ZTE");
    }
}
