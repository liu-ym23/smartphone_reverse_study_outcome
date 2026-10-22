package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.util.LocalConstants;

/* JADX INFO: loaded from: classes.dex */
class OldSpMigrater {
    OldSpMigrater() {
    }

    private static void migrateDidSp(InstallOptions r10, SharedPreferences r11) {
        SharedPreferences r12 = r10.getSp();
        String r13 = r12.getString("device_id", null);
        String r14 = r12.getString("bd_did", null);
        String r15 = r12.getString("install_id", null);
        String r16 = r12.getString(Api.KEY_SSID, null);
        SharedPreferences.Editor r17 = r11.edit();
        boolean r18 = true;
        if (TextUtils.isEmpty(r13) == true) goto L5;
        r17.putString("device_id", r13);
        boolean r19 = true;
    L7:
        if (TextUtils.isEmpty(r14) == true) goto L10;
        r17.putString("bd_did", r14);
        r19 = true;
    L10:
        if (TextUtils.isEmpty(r15) == true) goto L13;
        r17.putString("install_id", r15);
        r19 = true;
    L13:
        if (TextUtils.isEmpty(r16) == true) goto L15;
        r17.putString(Api.KEY_SSID, r16);
    L16:
        if (r18 == false) goto L19;
        r17.apply();
        return;
    L19:
        return;
    L15:
        r18 = r19;
        goto L16
    L5:
        r19 = false;
        goto L7
    }

    static void tryDoSDKMigrate(Context r10, Env r11, InstallOptions r12) {
        SharedPreferences r13 = LocalConstants.getCommonSp(r10, r12);
        SharedPreferences r14 = r11.getEnvIsolateSp(r12);
        if (r13.getBoolean("dr_install_migrate", false) == false) goto L5;
        return;
    L5:
        migrateDidSp(r12, r14);
        r13.edit().putBoolean("dr_install_migrate", true).apply();
    }
}
