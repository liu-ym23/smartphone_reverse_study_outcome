package com.bytedance.crash;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Nullable;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.runtime.CommonParams;
import com.bytedance.crash.runtime.ConfigManager;
import com.bytedance.crash.runtime.SettingManager;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class NpthBus {
    public static final String UUID_SUFIX_3_1_3 = "G";
    private static AppDataCenter sCenter;
    private static final ConfigManager sConfigManager = null;
    private static Object sLockUUID;
    private static SettingManager sSettingManager;
    private static volatile String sUUID;

    static {
        sConfigManager = new ConfigManager();
        sCenter = new AppDataCenter();
        sUUID = null;
        sLockUUID = new Object();
    }

    public NpthBus() {
    }

    public static long getAppStartTime() {
        return Global.getAppStartTime();
    }

    public static long getAppStartUpTime() {
        return 0;
    }

    @Nullable
    public static Application getApplication() {
        return Global.getApplication();
    }

    @Nullable
    public static Context getApplicationContext() {
        return Global.getContext();
    }

    public static AppDataCenter getCallCenter() {
        return sCenter;
    }

    public static CommonParams getCommonParams() {
        return CommonParams.getInstance();
    }

    public static ConfigManager getConfigManager() {
        return sConfigManager;
    }

    public static String getNativeUUID() {
        if (sUUID != null) goto L15;
        Object r10 = sLockUUID;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sUUID != null) goto L9;
        sUUID = Long.toHexString(new Random().nextLong()) + '-' + getAppStartTime() + UUID_SUFIX_3_1_3;     // Catch: Throwable -> L11
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L11
    L15:
        return sUUID;
    }

    public static SettingManager getSettingManager() {
        if (sSettingManager != null) goto L13;
        monitor-enter(NpthBus.class);
        sSettingManager = new SettingManager();     // Catch: Throwable -> L9
        monitor-exit(NpthBus.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return sSettingManager;
    }

    public static boolean isLocalDebug() {
        return RuntimeConfig.isLocalDebug();
    }

    public static boolean isLocalTest() {
        return RuntimeConfig.isLocalTest();
    }

    public static void setApplication(Application r10) {
        Global.setApplication(r10);
    }
}
