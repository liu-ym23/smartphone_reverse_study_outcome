package com.bytedance.bdinstall.migrate;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.util.LocalConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class MigrateDetector {
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

    public MigrateDetector(Context r4, InstallOptions r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        this.sp = LocalConstants.getCommonSp(r6, r5);
        this.pm = r0.getPackageManager();
        this.component = new ComponentName(r6, MigrateDetectorActivity.class);
        boolean r7 = isMigrateInternal();
        this.migrate = r7;
        DrLog.d("MigrateDetector#constructor migrate=" + r7);
    }

    private int getComponentEnabledSetting() {
        return this.pm.getComponentEnabledSetting(this.component);
    }

    private static String getComponentState(int r1) {
        if (r1 != 0) goto L4;
        return "STATE_DEFAULT";
    L4:
        if (r1 != 1) goto L6;
        return "STATE_ENABLED";
    L6:
        if (r1 == 2) goto L9;
        return "UNKNOWN";
    L9:
        return "STATE_DISABLED";
    }

    public static String getOldDid(Context r2, InstallOptions r3) {
        return LocalConstants.getCommonSp((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3).getString("old_did", null);
    }

    private boolean isMigrateInternal() {
        int r0 = componentEnableStateCache;
        if (r0 == (-1)) goto L14;
    L7:
        int r4 = this.sp.getInt(KEY_COMPONENT_STATE, 0);
        DrLog.d("MigrateDetector#isMigrateInternal cs=" + getComponentState(r0) + " ss=" + getComponentState(r4));
        if (r0 == 0) goto L10;
    L13:
        return false;
    L10:
        if (r4 != 2) goto L13;
        return true;
    L14:
        r0 = getComponentEnabledSetting();     // Catch: Exception -> L6
        componentEnableStateCache = r0;     // Catch: Exception -> L6
    L6:
        return false;
    }

    public static boolean isThisDeviceMigrate(Context r2, InstallOptions r3) {
        return LocalConstants.getCommonSp((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3).getBoolean(Api.SP_KEY_IS_MIGRATE, false);
    }

    public static void saveOldDid(Context r2, InstallOptions r3, String r4, boolean r5) {
        SharedPreferences.Editor r6 = LocalConstants.getCommonSp((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3).edit();
        r6.putString("old_did", r4);
        if (r5 == false) goto L5;
        r6.putBoolean(Api.SP_KEY_IS_MIGRATE, true);
    L6:
        r6.apply();
        return;
    L5:
        r6.remove(Api.SP_KEY_IS_MIGRATE);
        goto L6
    }

    public void disableComponent() {
        DrLog.d("MigrateDetector#disableComponent");
        ZeusTransformUtils.setComponentEnabledSetting(this.pm, this.component, 2, 1);     // Catch: Exception -> L5
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
