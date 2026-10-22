package com.obric.cae.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.os.SystemProperties;
import android.util.Log;
import androidx.appcompat.app.g;
import com.obric.cae.log.ALogger;
import com.obric.cae.log.CommSenseLog;

/* JADX INFO: loaded from: classes2.dex */
public class ALogUtil {
    public static boolean DBG = false;
    private static final int DEBUGGABLE = 0;
    private static final String DEBUGGABLE_PROPERTY = "ro.debuggable";
    private static final String TAG = null;
    private static volatile ALogger mLogger;
    private static boolean sInitInProgress;
    private static final Object sInitLock = null;

    static {
        TAG = "Cae-ALogUtil";
        boolean r8 = true;
        int r10 = SystemProperties.getInt(DEBUGGABLE_PROPERTY, 1);
        DEBUGGABLE = r10;
        if (r10 == 1) goto L6;
        r8 = false;
    L6:
        DBG = r8;
        sInitLock = new Object();
        sInitInProgress = false;
    }

    public ALogUtil() {
    }

    public static /* synthetic */ void a(Context r8) {
        lambda$initAlogAsync$0(r8);
    }

    @SuppressLint({"LogTagMismatch"})
    public static void d(String r8, String r10) {
        if (mLogger == null) goto L6;
        mLogger.d(r8, r10);
        return;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void e(String r8, String r10) {
        if (mLogger == null) goto L6;
        mLogger.e(r8, r10);
        return;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void i(String r8, String r10) {
        if (mLogger == null) goto L6;
        mLogger.i(r8, r10);
        return;
    }

    public static void init(Context r8) {
        if (r8 != null) goto L5;
        Log.w(TAG, "init failed: context is null");
        return;
    L5:
        Context r10 = r8.getApplicationContext();
        mLogger = new ALogger();
        mLogger.init(r10);
        CommSenseLog.enableAlog();
    }

    public static void initAlog(Context r8) {
        initAlogAsync(r8);
    }

    public static void initAlogAsync(Context r8) {
        if (r8 != null) goto L5;
        Log.w(TAG, "initAlogAsync failed: context is null");
        return;
    L5:
        Context r10 = r8.getApplicationContext();
        if (r10 != null) goto L9;
        Log.w(TAG, "initAlogAsync failed: appContext is null");
        return;
    L9:
        Object r11 = sInitLock;
        monitor-enter(r11);
    L23:
        th = move-exception;
        throw th;
    L12:
        if (initSucceed() == false) goto L16;
        monitor-exit(r11);     // Catch: Throwable -> L23
        return;
    L16:
        if (sInitInProgress == false) goto L19;
        monitor-exit(r11);     // Catch: Throwable -> L23
        return;
    L19:
        sInitInProgress = true;     // Catch: Throwable -> L23
        monitor-exit(r11);     // Catch: Throwable -> L23
        new Thread(new g(r10, 3), "ALogInitThread").start();
    }

    public static boolean initSucceed() {
        if (mLogger != null) goto L5;
        return false;
    L5:
        return mLogger.initSucceed();
    }

    public static boolean isExternalStorageMounted() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    private static /* synthetic */ void lambda$initAlogAsync$0(Context r8) {
    L16:
        th = move-exception;
        monitor-enter(sInitLock);
        sInitInProgress = false;     // Catch: Throwable -> L22
        throw th;
    L22:
        th = move-exception;
        throw th;
    L4:
        if (isExternalStorageMounted() == true) goto L6;
    L8:
        Object r10 = sInitLock;
        monitor-enter(r10);
        sInitInProgress = false;     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    L6:
        if (initSucceed() == true) goto L8;
        Log.d(TAG, "initAlogAsync");     // Catch: Throwable -> L16
        init(r8);     // Catch: Throwable -> L16
        goto L8
    }

    public static void setDebug(boolean r8) {
        if (mLogger == null) goto L16;
        boolean r10 = true;
        if (r8 == false) goto L7;
    L10:
        DBG = r10;
        ALogger r11 = mLogger;
        if (r10 == false) goto L13;
        int r12 = 3;
    L14:
        r11.changeDebugLevel(r12);
        return;
    L13:
        r12 = 4;
        goto L14
    L7:
        if (DEBUGGABLE == 1) goto L10;
        r10 = false;
        goto L10
    }

    @SuppressLint({"LogTagMismatch"})
    public static void v(String r8, String r10) {
        if (mLogger == null) goto L6;
        mLogger.v(r8, r10);
        return;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void w(String r8, String r10) {
        if (mLogger == null) goto L6;
        mLogger.w(r8, r10);
        return;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void e(String r8, String r10, Throwable r11) {
        if (mLogger == null) goto L6;
        mLogger.e(r8, r10, r11);
        return;
    }
}
