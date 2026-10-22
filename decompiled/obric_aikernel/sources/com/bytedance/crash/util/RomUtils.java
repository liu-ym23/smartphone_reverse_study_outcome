package com.bytedance.crash.util;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.crash.general.RomInfoHelper;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
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
    private static int sIsHmOs = -1;

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

    public static String getEMUVersion() {
        String r10 = Device.getEmuiInfo();
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
        if (Device.isMiui() == true) goto L5;
        return "";
    L5:
        return "miui_" + getSystemProperty("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    public static String getRomInfo() {
        if (Device.isMiui() == false) goto L7;
        return getMIUIVersion();
    L7:
        if (Device.isFlyme() == false) goto L11;
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
        if (TextUtils.isEmpty(r11) == true) goto L33;
        return r11;
    L33:
        return Build.DISPLAY;
    L28:
        return get360OSVersion();
    L13:
        return getColorOsVersion();
    }

    public static String getSystemProperty(String r10) {
        return RomInfoHelper.getSystemProperty(r10, "");
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

    public static boolean isFunTouchOS() {
        String r10 = getSystemProperty(FUNTOUCH_OS_VERSION);
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L7:
        return false;
    L5:
        if (r10.toLowerCase(Locale.getDefault()).contains(FUNTOUCHOS) == false) goto L7;
        return true;
    }

    public static boolean isHarmonyOs() {
        int r10 = sIsHmOs;
        if (r10 == (-1)) goto L14;
        if (r10 == 1) goto L6;
        return false;
    L6:
        return true;
    L14:
        Class.forName("ohos.utils.system.SystemCapability");     // Catch: Throwable -> L9
        sIsHmOs = 1;     // Catch: Throwable -> L9
    L11:
        if (sIsHmOs == 1) goto L13;
        return false;
    L13:
        return true;
    L9:
        sIsHmOs = 0;
        goto L11
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
