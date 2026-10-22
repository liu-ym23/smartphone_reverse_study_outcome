package com.ttnet.org.chromium.net.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.VisibleForTesting;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.net.NetworkChangeNotifier;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
@JNINamespace("cronet")
public class CronetLibraryLoader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String LIBRARY_NAME = "sscronet";
    private static final String TAG = "CronetLibraryLoader";
    private static final HandlerThread sInitThread = null;
    public static long sInitThreadEndTime;
    private static volatile boolean sInitThreadInitDone;
    public static long sInitThreadStartTime;
    private static volatile boolean sLibraryLoaded;
    public static long sLoadCronetSoDuration;
    private static final Object sLoadLock = null;
    private static final ConditionVariable sWaitForLibLoad = null;

    static {
        sLoadLock = new Object();
        sInitThread = new HandlerThread("CronetInit");
        sLibraryLoaded = false;
        sWaitForLibLoad = new ConditionVariable();
    }

    public CronetLibraryLoader() {
    }

    public static void ensureInitialized(Context r8, CronetEngineBuilderImpl r10) {
        Object r11 = sLoadLock;
        monitor-enter(r11);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (sInitThreadInitDone == true) goto L11;
        ContextUtils.initApplicationContext(r8);     // Catch: Throwable -> L19
        HandlerThread r12 = sInitThread;     // Catch: Throwable -> L19
        if (r12.isAlive() == true) goto L9;
        r12.start();     // Catch: Throwable -> L19
    L9:
        postToInitThread(new AnonymousClass1());     // Catch: Throwable -> L19
    L11:
        if (sLibraryLoaded == true) goto L17;
        long r13 = SystemClock.uptimeMillis();     // Catch: Throwable -> L19
        loadCronetLibrary(r10);     // Catch: Throwable -> L19
        sLoadCronetSoDuration = SystemClock.uptimeMillis() - r13;     // Catch: Throwable -> L19
        String r14 = ImplVersion.getCronetVersion();     // Catch: Throwable -> L19
        if (r14.equals(nativeGetCronetVersion()) == false) goto L16;
        Log.i(TAG, "Cronet version: %s, arch: %s", new Object[]{r14, System.getProperty("os.arch")});     // Catch: Throwable -> L19
        sLibraryLoaded = true;     // Catch: Throwable -> L19
        sWaitForLibLoad.open();     // Catch: Throwable -> L19
        goto L17
    L16:
        throw new RuntimeException(String.format("Expected Cronet version number %s, actual version number %s.", new Object[]{r14, nativeGetCronetVersion()}));     // Catch: Throwable -> L19
    L17:
        monitor-exit(r11);     // Catch: Throwable -> L19
    }

    @CalledByNative
    private static void ensureInitializedFromNative() {
        Object r8 = sLoadLock;
        monitor-enter(r8);
        sLibraryLoaded = true;     // Catch: Throwable -> L9
        sWaitForLibLoad.open();     // Catch: Throwable -> L9
        monitor-exit(r8);     // Catch: Throwable -> L9
        ensureInitialized(ContextUtils.getApplicationContext(), null);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static void ensureInitializedOnInitThread() {
        if (sInitThreadInitDone == false) goto L5;
        return;
    L5:
        sInitThreadStartTime = System.currentTimeMillis();
        NetworkChangeNotifier.init();
        NetworkChangeNotifier.registerToReceiveNotificationsAlways();
        sWaitForLibLoad.block();
        nativeCronetInitOnInitThread();
        sInitThreadInitDone = true;
        sInitThreadEndTime = System.currentTimeMillis();
    }

    @CalledByNative
    private static String getDefaultUserAgent() {
        return UserAgent.from(ContextUtils.getApplicationContext());
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    private static void loadCronetLibrary(CronetEngineBuilderImpl r8) {
        String r10 = r8.getCronetSoPath();
        if (TextUtils.isEmpty(r10) == true) goto L11;
        File r11 = new File(r10);
        if (r11.exists() == false) goto L11;
        if (r11.isDirectory() == true) goto L11;
        Log.i(TAG, "cronet so load: %s", new Object[]{r10});
        System.load(r10);
        return;
    L11:
        if (r8.libraryLoader() == null) goto L13;
        r8.libraryLoader().loadLibrary(LIBRARY_NAME);
        return;
    L13:
        System.loadLibrary(LIBRARY_NAME);
    }

    private static native void nativeCronetInitOnInitThread();

    private static native String nativeGetCronetVersion();

    private static boolean onInitThread() {
        if (sInitThread.getLooper() != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public static void postToInitThread(Runnable r8) {
        if (onInitThread() == false) goto L5;
        r8.run();
        return;
    L5:
        new Handler(sInitThread.getLooper()).post(r8);
    }

    @CalledByNative
    private static void setNetworkThreadPriorityOnNetworkThread(int r8) {
        Process.setThreadPriority(r8);
    }
}
