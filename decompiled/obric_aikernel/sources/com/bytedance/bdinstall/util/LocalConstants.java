package com.bytedance.bdinstall.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.AbsEnv;
import com.bytedance.bdinstall.BuildConfig;
import com.bytedance.bdinstall.InstallOptions;

/* JADX INFO: loaded from: classes.dex */
public class LocalConstants extends Constants {

    public static class Events {
        public static String DR_ACTIVATE_RESULT = "dr_active_result";
        public static String DR_REGISTER_PARAM = "dr_register_param";
        public static String DR_REGISTER_RESULT = "dr_register_result";
        public static String KEY_ACTIVATE = "activate";
        public static String KEY_PARAMS = "params";
        public static String KEY_REGISTER = "register";

        static {
        }

        public Events() {
        }
    }

    public LocalConstants() {
    }

    public static /* bridge */ /* synthetic */ SharedPreferences getCommonSp(Context r10, InstallOptions r11) {
        return Constants.getCommonSp(r10, r11);
    }

    public static /* bridge */ /* synthetic */ SharedPreferences getCommonSp(Context r10, String r11) {
        return Constants.getCommonSp(r10, r11);
    }

    public static /* bridge */ /* synthetic */ SharedPreferences getMainCommonSp(Context r10) {
        return Constants.getMainCommonSp(r10);
    }

    public static String getOldSpName() {
        return StringEncryptUtils.base64DecodeToString("Y29tLnNzLmFuZHJvaWQuZGV2aWNlcmVnaXN0ZXIudXRpbHMuQ2RpZA==");
    }

    public static int getVersionCode() {
        return BuildConfig.BDINSTALL_VERSION_CODE;
    }

    public static /* bridge */ /* synthetic */ String wrapEnvSuffix(String r10, AbsEnv r11) {
        return Constants.wrapEnvSuffix(r10, r11);
    }

    public static /* bridge */ /* synthetic */ String wrapServerIdSpName(AbsEnv r10) {
        return Constants.wrapServerIdSpName(r10);
    }

    public static /* bridge */ /* synthetic */ String wrapServerIdSpName(AbsEnv r10, String r11) {
        return Constants.wrapServerIdSpName(r10, r11);
    }
}
