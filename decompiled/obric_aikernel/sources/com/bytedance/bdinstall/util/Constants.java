package com.bytedance.bdinstall.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.AbsEnv;
import com.bytedance.bdinstall.InstallOptions;

/* JADX INFO: loaded from: classes.dex */
class Constants {
    public static final long ACTIVE_RETRY_TIME = 900000;
    public static final int DEFAULT_INSTANCE_CAPACITY = 4;
    public static final String NAME_NEW_USER_IMPL = "com.bytedance.bdinstall.nu.NUModeServiceImpl";
    public static final String SP_FILE_OPEN_UDID = "snssdk_openudid";
    public static final String SP_INSTALL = "ug_install_settings_pref";
    private static final Singleton<SharedPreferences> sInstallSpref = null;

    static {
        sInstallSpref = new AnonymousClass1();
    }

    Constants() {
    }

    public static SharedPreferences getCommonSp(Context r10, InstallOptions r11) {
        if (r11 == null) goto L9;
        if (r11.isMainInstance() == false) goto L7;
        return getMainCommonSp(r10);
    L7:
        return getCommonSp(r10, String.valueOf(r11.getAid()));
    L9:
        return getMainCommonSp(r10);
    }

    public static SharedPreferences getCommonSp(Context r10, String r11) {
        return r10.getSharedPreferences("ug_install_settings_pref_" + r11, 0);
    }

    public static SharedPreferences getMainCommonSp(Context r10) {
        return sInstallSpref.get(new Object[]{r10});
    }

    public static String wrapEnvSuffix(String r10, AbsEnv r11) {
        if (r11.isI18n() == false) goto L6;
        r10 = r10 + "_i18n";
    L6:
        if (r11.isBoe() == false) goto L9;
        r10 = r10 + "_boe";
    L9:
        if (r11.isChildMode() == true) goto L11;
        return r10;
    L11:
        return r10 + "_cm";
    }

    public static String wrapServerIdSpName(AbsEnv r10) {
        return wrapEnvSuffix(SP_INSTALL, r10);
    }

    public static String wrapServerIdSpName(AbsEnv r10, String r11) {
        return wrapEnvSuffix(SP_INSTALL, r10) + "_" + r11;
    }
}
