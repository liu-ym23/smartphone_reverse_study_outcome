package com.bytedance.crash;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.crash.dumper.AppVersion;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.FileSystemUtils;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class Global {
    public static final String HAS_CRASH = "hasCrash";
    private static ICrashMonitorService crashMonitorService = null;
    private static volatile boolean hasCrashBefore = false;
    private static String sAppVersionString = null;
    private static String sBusiness = "default";

    @SuppressLint({"StaticFieldLeak"})
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
        long r10 = SystemClock.elapsedRealtime();
        this.mInitElapsedRealtime = r10;
        if (Build.VERSION.SDK_INT < 24) goto L6;
        this.mAppStartTime -= r10 - Process.getStartElapsedRealtime();
        return;
    }

    @NonNull
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

    @Nullable
    public static Application getApplication() {
        return get().mApplication;
    }

    public static String getBusiness() {
        return sBusiness;
    }

    public static String getConfigDir() {
        File r10 = new File(getRootDirectory(), "configs");
        if (r10.exists() == true) goto L6;
        FileSystemUtils.createDirectory(r10);
    L6:
        return r10.getAbsolutePath();
    }

    @Nullable
    public static Context getContext() {
        return get().mContext;
    }

    public static ICrashMonitorService getCrashMonitorService() {
        return crashMonitorService;
    }

    public static long getInitElapsedRealtime() {
        return get().mInitElapsedRealtime;
    }

    @Nullable
    public static String getNativeAppVersion() {
        return sAppVersionString;
    }

    @Nullable
    public static File getRootDirectory() {
        return get().mRootDirectory;
    }

    @NonNull
    public static File getRootDirectory(@NonNull Context r10) {
        File r11 = getRootDirectory();
        if (r11 == null) goto L5;
        return r11;
    L5:
        return FileSystemUtils.createDirectory(r10.getFilesDir(), "npth");
    }

    public static boolean hasCrashBefore() {
        return hasCrashBefore;
    }

    public static void setAppLaunchMode(int r10) {
        get().appLaunchMode = r10;
    }

    public static void setAppStartTime(Long r10) {
        Global r11 = get();
        if (r10.longValue() >= get().mAppStartTime) goto L5;
        long r12 = r10.longValue();
    L6:
        r11.mAppStartTime = r12;
        return;
    L5:
        r12 = get().mAppStartTime;
        goto L6
    }

    public static void setAppVersion(long r10, long r11, long r12, String r13) {
        if (sAppVersionString != null) goto L8;
        String r14 = AppVersion.getJsonString(r10, r11, r12, r13);
        sAppVersionString = r14;
        if (r14 == null) goto L9;
        NativeBridge.setAppVersion(r14);
        return;
    L9:
        return;
    }

    public static void setApplication(Application r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (get().mApplication != null) goto L8;
        get().mApplication = r10;
        return;
    }

    private void setApplication(@NonNull Context r10) {
        if (this.mApplication == null) goto L5;
        return;
    L5:
        if ((r10 instanceof Application) == true) goto L8;
        r10 = r10.getApplicationContext();
    L8:
        this.mApplication = (Application) r10;
    }

    static void setBusiness(String r10) {
        sBusiness = r10;
    }

    public static void setContext(Context r10) {
        if (r10 == null) goto L6;
        get().setContextInner(r10);
        return;
    L6:
        throw new IllegalArgumentException("Context cannot be null");
    }

    private void setContextInner(@NonNull Context r10) {
        setApplication(r10);
        if (this.mContext != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mContext != null) goto L8;
        this.mContext = r10;     // Catch: Throwable -> L10
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
        this.mRootDirectory = FileSystemUtils.createDirectory(r10.getFilesDir(), "npth");     // Catch: Throwable -> L21
    L19:
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    }

    public static void setCrashMonitorService(ICrashMonitorService r10) {
        crashMonitorService = r10;
    }

    public static void setHasCrashBefore(boolean r10) {
        hasCrashBefore = r10;
    }
}
