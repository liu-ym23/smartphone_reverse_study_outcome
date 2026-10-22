package com.bytedance.crash.config;

import com.bytedance.crash.IEncrypt;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.EncryptUtils;

/* JADX INFO: loaded from: classes.dex */
public class RuntimeConfig {
    private static final long ANR_CHECK_INTERVAL = 500;
    private static final long LAUNCH_CRASH_INTERVAL = 8000;
    private static boolean ensureEnable = false;
    private static boolean reportErrorEnable = false;
    private static long sAnrCheckInterval = 500;
    private static boolean sDebugMode = false;
    private static IEncrypt sEncryptImpl = null;
    private static long sLaunchCrashInterval = 8000;
    private static boolean sStopEnsure;
    private static boolean sStopUpload;

    static class DefaultEncrypt implements IEncrypt {
        DefaultEncrypt() {
        }

        @Override // com.bytedance.crash.IEncrypt
        public byte[] encrypt(byte[] r10) {
            return EncryptUtils.encrypt(r10);
        }
    }

    static {
        sEncryptImpl = new DefaultEncrypt();
        reportErrorEnable = true;
        ensureEnable = true;
    }

    public RuntimeConfig() {
    }

    public static long getAnrCheckInterval() {
        return sAnrCheckInterval;
    }

    public static IEncrypt getEncryptImpl() {
        return sEncryptImpl;
    }

    public static long getLaunchCrashInterval() {
        return sLaunchCrashInterval;
    }

    public static boolean isDebugMode() {
        return sDebugMode;
    }

    public static boolean isEncrypt() {
        return true;
    }

    public static boolean isEnsureEnable() {
        return ensureEnable;
    }

    public static boolean isLocalDebug() {
        if (isDebugMode() == true) goto L5;
    L7:
        return false;
    L5:
        if (isLocalTest() == false) goto L7;
        return true;
    }

    public static boolean isLocalTest() {
        AppMonitor r10 = MonitorManager.getAppMonitor();
        if (r10 != null) goto L5;
        return false;
    L5:
        String r11 = r10.getChannel();
        if (r11 != null) goto L8;
        return false;
    L8:
        if (r11.contains("test_crash") == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean isReportErrorEnable() {
        return reportErrorEnable;
    }

    public static boolean isStopEnsure() {
        return sStopEnsure;
    }

    public static boolean isStopUpload() {
        return sStopUpload;
    }

    public static void setAnrCheckInterval(long r10) {
        sAnrCheckInterval = r10;
    }

    public static void setDebugMode(boolean r10) {
        sDebugMode = r10;
    }

    public static void setEncryptImpl(IEncrypt r10) {
        if (r10 == null) goto L5;
        sEncryptImpl = r10;
        return;
    }

    public static void setEnsureEnable(boolean r10) {
        ensureEnable = r10;
    }

    public static void setLaunchCrashInterval(long r10) {
        sLaunchCrashInterval = r10;
    }

    public static void setReportErrorEnable(boolean r10) {
        reportErrorEnable = r10;
    }

    public static void stopEnsure() {
        sStopEnsure = true;
    }

    public static void stopUpload() {
        sStopUpload = true;
    }
}
