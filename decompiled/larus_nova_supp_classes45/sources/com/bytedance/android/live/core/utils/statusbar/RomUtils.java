package com.bytedance.android.live.core.utils.statusbar;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.SystemPropertiesUtil;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class RomUtils extends puc.a {
    public static final int BUILD_VERSION_CODE_M = 23;
    private static final String HTC_MANUFACTURER = "htc";
    private static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    private static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    private static final String KEY_VERSION_OPPO = "ro.build.version.opporom";
    private static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    private static final String KEY_VERSION_VIVO = "ro.vivo.os.version";
    private static final String OPPO_MANUFACTURER = "oppo";
    public static final String ROM_EMUI = "EMUI";
    public static final String ROM_FLYME = "FLYME";
    public static final String ROM_MIUI = "MIUI";
    public static final String ROM_OPPO = "OPPO";
    public static final String ROM_QIKU = "QIKU";
    public static final String ROM_SAMSUNG = "SAMSUNG";
    public static final String ROM_SMARTISAN = "SMARTISAN";
    public static final String ROM_VIVO = "VIVO";
    public static final int SZ = 1024;
    private static final String TAG = "Rom";
    private static final String VIVO_MANUFACTURER = "vivo";
    private static String sName;
    private static String sVersion;

    public static String getName() {
        if (sName != null) goto L6;
        check("");
    L6:
        return sName;
    }

    public static boolean isVivo() {
        if (getRomManufacturer() == null) goto L9;
        if (getRomManufacturer().toLowerCase().equals(VIVO_MANUFACTURER) == false) goto L9;
        return true;
    L9:
        return check(ROM_VIVO);
    }

    public RomUtils() {
    }

    public static String getRomManufacturer() {
        return Build.MANUFACTURER;
    }

    public static boolean check(String r2) {
        String r0 = sName;
        if (r0 == null) goto L7;
        return r0.equals(r2);
    L7:
        if (TextUtils.isEmpty(getProp(KEY_VERSION_MIUI)) == true) goto L10;
        sVersion = getProp(KEY_VERSION_MIUI);
        sName = ROM_MIUI;
    L26:
        return sName.equals(r2);
    L10:
        if (TextUtils.isEmpty(getProp(KEY_VERSION_EMUI)) == true) goto L13;
        sVersion = getProp(KEY_VERSION_EMUI);
        sName = ROM_EMUI;
        goto L26
    L13:
        if (TextUtils.isEmpty(getProp(KEY_VERSION_OPPO)) == true) goto L16;
        sVersion = getProp(KEY_VERSION_OPPO);
        sName = ROM_OPPO;
        goto L26
    L16:
        if (TextUtils.isEmpty(getProp(KEY_VERSION_VIVO)) == true) goto L19;
        sVersion = getProp(KEY_VERSION_VIVO);
        sName = ROM_VIVO;
        goto L26
    L19:
        if (TextUtils.isEmpty(getProp(KEY_VERSION_SMARTISAN)) == true) goto L21;
        sVersion = getProp(KEY_VERSION_SMARTISAN);
        sName = ROM_SMARTISAN;
        goto L26
    L21:
        String r1 = Build.DISPLAY;
        sVersion = r1;
        if (r1.toUpperCase().contains(ROM_FLYME) == false) goto L24;
        sName = ROM_FLYME;
        goto L26
    L24:
        sVersion = "unknown";
        sName = Build.MANUFACTURER.toUpperCase();
        goto L26
    }

    public static String getProp(String r0) {
        return SystemPropertiesUtil.getProp(r0);
    }

    public static boolean isTablet(Context r1) {
        if ((r1.getResources().getConfiguration().screenLayout & 15) < 3) goto L5;
        return true;
    L5:
        return false;
    }
}
