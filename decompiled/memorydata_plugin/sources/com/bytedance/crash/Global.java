package com.bytedance.crash;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.bytedance.crash.dumper.AppVersion;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.FileSystemUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class Global {
    public static final String HAS_CRASH = "hasCrash";
    private static ICrashMonitorService crashMonitorService = null;
    private static volatile boolean hasCrashBefore = false;
    private static String sAppVersionString = null;
    private static String sBusiness = "default";
    private static volatile Global sInstance;
    private int appLaunchMode;
    private long mAppStartTime;
    private final long mAppStartUpTime;
    private Application mApplication;
    private Context mContext;
    private long mInitElapsedRealtime;
    private File mRootDirectory;

    static {
    }

    private Global() {
        this.mAppStartTime = System.currentTimeMillis();
        this.mAppStartUpTime = SystemClock.uptimeMillis();
        this.mInitElapsedRealtime = SystemClock.elapsedRealtime();
        if (Build.VERSION.SDK_INT < 24) goto L6;
        this.mAppStartTime -= this.mInitElapsedRealtime - Process.getStartElapsedRealtime();
        return;
    }

    private static Global get() {
        if (sInstance != null) goto L15;
        monitor-enter(Global.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new Global();     // Catch: Throwable -> L11
    L9:
        monitor-exit(Global.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public static int getAppLaunchMode() {
        return get().appLaunchMode;
    }

    public static long getAppStartTime() {
        return get().mAppStartTime;
    }

    public static long getAppStartUpTime() {
        return get().mAppStartUpTime;
    }

    public static Application getApplication() {
        return get().mApplication;
    }

    public static String getBusiness() {
        return sBusiness;
    }

    public static String getConfigDir() {
        File r0 = new File(getRootDirectory(), "configs");
        if (r0.exists() == true) goto L6;
        FileSystemUtils.createDirectory(r0);
    L6:
        return r0.getAbsolutePath();
    }

    public static Context getContext() {
        return get().mContext;
    }

    public static ICrashMonitorService getCrashMonitorService() {
        return crashMonitorService;
    }

    public static long getInitElapsedRealtime() {
        return get().mInitElapsedRealtime;
    }

    public static String getNativeAppVersion() {
        return sAppVersionString;
    }

    public static File getRootDirectory() {
        return get().mRootDirectory;
    }

    public static File getRootDirectory(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        File r0 = getRootDirectory();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return FileSystemUtils.createDirectory(r3.getFilesDir(), "npth");
    }

    public static boolean hasCrashBefore() {
        return hasCrashBefore;
    }

    public static void setAppLaunchMode(int r1) {
        get().appLaunchMode = r1;
    }

    public static void setAppStartTime(Long r5) {
        Global r0 = get();
        if (r5.longValue() >= get().mAppStartTime) goto L5;
        long r1 = r5.longValue();
    L6:
        r0.mAppStartTime = r1;
        return;
    L5:
        r1 = get().mAppStartTime;
        goto L6
    }

    public static void setAppVersion(long r1, long r3, long r5, String r7) {
        if (sAppVersionString != null) goto L8;
        String r2 = AppVersion.getJsonString(r1, r3, r5, r7);
        sAppVersionString = r2;
        if (r2 == null) goto L9;
        NativeBridge.setAppVersion(r2);
        return;
    L9:
        return;
    }

    public static void setApplication(Application r2) {
        Application r3 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        if (get().mApplication != null) goto L9;
        get().mApplication = r3;
        return;
    }

    private void setApplication(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (this.mApplication == null) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, Application.class) == true) goto L8;
        r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L8:
        this.mApplication = (Application) ZeusTransformUtils.preCheckCast(r4, Application.class, "com.obric.memorydata.plugin");
    }

    static void setBusiness(String r0) {
        sBusiness = r0;
    }

    public static void setContext(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L7;
        get().setContextInner(r3);
        return;
    L7:
        throw new IllegalArgumentException("Context cannot be null");
    }

    private void setContextInner(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        setApplication(r4);
        if (this.mContext != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mContext != null) goto L8;
        this.mContext = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        if (this.mRootDirectory != null) goto L24;
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L17:
        if (this.mRootDirectory != null) goto L19;
        this.mRootDirectory = FileSystemUtils.createDirectory(r4.getFilesDir(), "npth");     // Catch: Throwable -> L21
    L19:
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    }

    public static void setCrashMonitorService(ICrashMonitorService r2) {
        crashMonitorService = (ICrashMonitorService) ZeusTransformUtils.wrapperContextForParams(r2, ICrashMonitorService.class, "com.obric.memorydata.plugin");
    }

    public static void setHasCrashBefore(boolean r0) {
        hasCrashBefore = r0;
    }
}
