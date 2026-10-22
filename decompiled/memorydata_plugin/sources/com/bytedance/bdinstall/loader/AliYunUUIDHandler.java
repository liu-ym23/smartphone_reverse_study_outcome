package com.bytedance.bdinstall.loader;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class AliYunUUIDHandler {
    private static volatile AliYunUUIDHandler sAliYunUUIDHandler;
    private String mCloudUUID;

    static {
    }

    private AliYunUUIDHandler() {
        if (isAliYunOs() == false) goto L8;
        String r0 = getCommonCloudUUID();
        this.mCloudUUID = r0;
        if (TextUtils.isEmpty(r0) == false) goto L9;
        this.mCloudUUID = getMeiZuCloudUUID();
        return;
    L9:
        return;
    }

    private static String getCommonCloudUUID() {
        return getSystemProperty("ro.aliyun.clouduuid", "false");
    }

    private static String getMeiZuCloudUUID() {
        return getSystemProperty("ro.sys.aliyun.clouduuid", "false");
    }

    private static String getSystemProperty(String r8, String r9) {
        return (String) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.memorydata.plugin").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{r8, r9}), String.class, "com.obric.memorydata.plugin");
    L5:
        return r9;
    }

    public static AliYunUUIDHandler inst() {
        if (sAliYunUUIDHandler != null) goto L15;
        monitor-enter(AliYunUUIDHandler.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sAliYunUUIDHandler != null) goto L9;
        sAliYunUUIDHandler = new AliYunUUIDHandler();     // Catch: Throwable -> L11
    L9:
        monitor-exit(AliYunUUIDHandler.class);     // Catch: Throwable -> L11
    L15:
        return sAliYunUUIDHandler;
    }

    private static boolean isAliYunOs() {
        if (System.getProperty("java.vm.name") != null) goto L6;
    L7:
        if (System.getProperty("ro.yunos.version") != null) goto L16;
        return false;
    L16:
        return true;
    L6:
        if (System.getProperty("java.vm.name").toLowerCase().contains("lemur") == false) goto L7;
        return true;
    L17:
        return false;
    }

    public String getCloudUUID() {
        return this.mCloudUUID;
    }
}
