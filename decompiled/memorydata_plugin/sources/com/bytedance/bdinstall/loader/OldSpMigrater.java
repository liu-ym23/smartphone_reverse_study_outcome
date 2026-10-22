package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.util.LocalConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class OldSpMigrater {
    OldSpMigrater() {
    }

    private static void migrateDidSp(InstallOptions r9, SharedPreferences r10) {
        SharedPreferences r11 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r10, SharedPreferences.class, "com.obric.memorydata.plugin");
        SharedPreferences r12 = r9.getSp();
        String r2 = r12.getString("device_id", null);
        String r4 = r12.getString("bd_did", null);
        String r6 = r12.getString("install_id", null);
        String r13 = r12.getString(Api.KEY_SSID, null);
        SharedPreferences.Editor r14 = r11.edit();
        boolean r8 = true;
        if (TextUtils.isEmpty(r2) == true) goto L5;
        r14.putString("device_id", r2);
        boolean r0 = true;
    L7:
        if (TextUtils.isEmpty(r4) == true) goto L10;
        r14.putString("bd_did", r4);
        r0 = true;
    L10:
        if (TextUtils.isEmpty(r6) == true) goto L13;
        r14.putString("install_id", r6);
        r0 = true;
    L13:
        if (TextUtils.isEmpty(r13) == true) goto L15;
        r14.putString(Api.KEY_SSID, r13);
    L16:
        if (r8 == false) goto L19;
        r14.apply();
        return;
    L19:
        return;
    L15:
        r8 = r0;
        goto L16
    L5:
        r0 = false;
        goto L7
    }

    static void tryDoSDKMigrate(Context r2, Env r3, InstallOptions r4) {
        SharedPreferences r5 = LocalConstants.getCommonSp((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r4);
        SharedPreferences r6 = r3.getEnvIsolateSp(r4);
        if (r5.getBoolean("dr_install_migrate", false) == false) goto L5;
        return;
    L5:
        migrateDidSp(r4, r6);
        r5.edit().putBoolean("dr_install_migrate", true).apply();
    }
}
