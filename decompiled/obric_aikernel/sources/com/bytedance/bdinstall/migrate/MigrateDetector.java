package com.bytedance.bdinstall.migrate;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.util.LocalConstants;

/* JADX INFO: loaded from: classes.dex */
public final class MigrateDetector {

    @VisibleForTesting
    public static final String KEY_COMPONENT_STATE = "component_state";
    private static final int STATE_DEFAULT = 0;
    private static final int STATE_DISABLED = 2;
    private static final int STATE_ENABLED = 1;
    private static final int STATE_FLAG = 1;
    private static final int STATE_NOT_INITIALIZE = -1;
    private static int componentEnableStateCache = -1;
    private final ComponentName component;
    private final boolean migrate;
    private final PackageManager pm;
    private final SharedPreferences sp;

    static {
    }

    @WorkerThread
    public MigrateDetector(Context r10, InstallOptions r11) {
        Context r12 = r10.getApplicationContext();
        this.sp = LocalConstants.getCommonSp(r10, r11);
        this.pm = r12.getPackageManager();
        this.component = new ComponentName(r10, MigrateDetectorActivity.class);
        boolean r13 = isMigrateInternal();
        this.migrate = r13;
        DrLog.d("MigrateDetector#constructor migrate=" + r13);
    }

    private int getComponentEnabledSetting() {
        return this.pm.getComponentEnabledSetting(this.component);
    }

    private static String getComponentState(int r10) {
        if (r10 != 0) goto L4;
        return "STATE_DEFAULT";
    L4:
        if (r10 != 1) goto L6;
        return "STATE_ENABLED";
    L6:
        if (r10 == 2) goto L9;
        return "UNKNOWN";
    L9:
        return "STATE_DISABLED";
    }

    @Nullable
    public static String getOldDid(Context r10, InstallOptions r11) {
        return LocalConstants.getCommonSp(r10, r11).getString("old_did", null);
    }

    private boolean isMigrateInternal() {
        int r10 = componentEnableStateCache;
        if (r10 == (-1)) goto L14;
    L7:
        int r11 = this.sp.getInt(KEY_COMPONENT_STATE, 0);
        DrLog.d("MigrateDetector#isMigrateInternal cs=" + getComponentState(r10) + " ss=" + getComponentState(r11));
        if (r10 == 0) goto L10;
    L13:
        return false;
    L10:
        if (r11 != 2) goto L13;
        return true;
    L14:
        r10 = getComponentEnabledSetting();     // Catch: Exception -> L6
        componentEnableStateCache = r10;     // Catch: Exception -> L6
    L6:
        return false;
    }

    public static boolean isThisDeviceMigrate(Context r10, InstallOptions r11) {
        return LocalConstants.getCommonSp(r10, r11).getBoolean(Api.SP_KEY_IS_MIGRATE, false);
    }

    public static void saveOldDid(Context r10, InstallOptions r11, String r12, boolean r13) {
        SharedPreferences.Editor r14 = LocalConstants.getCommonSp(r10, r11).edit();
        r14.putString("old_did", r12);
        if (r13 == false) goto L5;
        r14.putBoolean(Api.SP_KEY_IS_MIGRATE, true);
    L6:
        r14.apply();
        return;
    L5:
        r14.remove(Api.SP_KEY_IS_MIGRATE);
        goto L6
    }

    public void disableComponent() {
        DrLog.d("MigrateDetector#disableComponent");
        this.pm.setComponentEnabledSetting(this.component, 2, 1);     // Catch: Exception -> L5
        this.sp.edit().putInt(KEY_COMPONENT_STATE, 2).apply();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        DrLog.e("MigrateDetector#disableComponent error", e);
    }

    public boolean isMigrate() {
        return this.migrate;
    }
}
