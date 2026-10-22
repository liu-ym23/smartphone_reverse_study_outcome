package com.ttnet.org.chromium.net.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.net.NetworkChangeNotifier;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("cronet")
@VisibleForTesting
public class CronetLibraryLoader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String LIBRARY_NAME = "sscronet";
    private static final String TAG = "CronetLibraryLoader";
    private static final HandlerThread sInitThread = null;
    private static volatile boolean sInitThreadInitDone;
    private static volatile boolean sLibraryLoaded;
    private static final Object sLoadLock = null;
    private static final ConditionVariable sWaitForLibLoad = null;

    interface Natives {
        void cronetInitOnInitThread();

        String getCronetVersion();
    }

    static {
        sLoadLock = new Object();
        sInitThread = new HandlerThread("CronetInit");
        sLibraryLoaded = false;
        sWaitForLibLoad = new ConditionVariable();
    }

    public CronetLibraryLoader() {
    }

    public static void ensureInitialized(Context r10, CronetEngineBuilderImpl r11) {
        Object r12 = sLoadLock;
        monitor-enter(r12);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (sInitThreadInitDone == true) goto L11;
        ContextUtils.initApplicationContext(r10);     // Catch: Throwable -> L29
        HandlerThread r13 = sInitThread;     // Catch: Throwable -> L29
        if (r13.isAlive() == true) goto L9;
        r13.start();     // Catch: Throwable -> L29
    L9:
        postToInitThread(new AnonymousClass1());     // Catch: Throwable -> L29
    L11:
        if (sLibraryLoaded == true) goto L27;
        TTCronetInitTimingInfo.sLoadCronetSoStart = System.nanoTime();     // Catch: Throwable -> L29
        loadCronetLibrary(r11);     // Catch: Throwable -> L29
        TTCronetInitTimingInfo.sLoadCronetSoEnd = System.nanoTime();     // Catch: Throwable -> L29
        String r14 = ImplVersion.getCronetVersion();     // Catch: Throwable -> L29
        if (r11 == null) goto L22;
        if (r11.optInit() == false) goto L22;
        if (r14.equals("107.0.5273.2") == false) goto L20;
    L24:
        sLibraryLoaded = true;     // Catch: Throwable -> L29
        sWaitForLibLoad.open();     // Catch: Throwable -> L29
        goto L27
    L20:
        throw new RuntimeException(String.format("Expected Cronet version number %s, actual version number %s.", new Object[]{r14, "107.0.5273.2"}));     // Catch: Throwable -> L29
    L22:
        if (r14.equals(CronetLibraryLoaderJni.get().getCronetVersion()) == false) goto L26;
        Log.i(TAG, "Cronet version: %s, arch: %s", new Object[]{r14, System.getProperty("os.arch")});     // Catch: Throwable -> L29
        goto L24
    L26:
        throw new RuntimeException(String.format("Expected Cronet version number %s, actual version number %s.", new Object[]{r14, CronetLibraryLoaderJni.get().getCronetVersion()}));     // Catch: Throwable -> L29
    L27:
        monitor-exit(r12);     // Catch: Throwable -> L29
    }

    @CalledByNative
    private static void ensureInitializedFromNative() {
        Object r10 = sLoadLock;
        monitor-enter(r10);
        sLibraryLoaded = true;     // Catch: Throwable -> L9
        sWaitForLibLoad.open();     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        ensureInitialized(ContextUtils.getApplicationContext(), null);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    static void ensureInitializedOnInitThread() {
        if (sInitThreadInitDone == false) goto L5;
        return;
    L5:
        TTCronetInitTimingInfo.sInitThreadStart = System.nanoTime();
        NetworkChangeNotifier.init();
        NetworkChangeNotifier.registerToReceiveNotificationsAlways();
        sWaitForLibLoad.block();
        CronetLibraryLoaderJni.get().cronetInitOnInitThread();
        sInitThreadInitDone = true;
        TTCronetInitTimingInfo.sInitThreadEnd = System.nanoTime();
    }

    @CalledByNative
    private static String getDefaultUserAgent() {
        return UserAgent.from(ContextUtils.getApplicationContext());
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    private static void loadCronetLibrary(CronetEngineBuilderImpl r10) {
        String r11 = r10.getCronetSoPath();
        if (TextUtils.isEmpty(r11) == true) goto L11;
        File r12 = new File(r11);
        if (r12.exists() == false) goto L11;
        if (r12.isDirectory() == true) goto L11;
        Log.i(TAG, "cronet so load: %s", new Object[]{r11});
        System.load(r11);
        return;
    L11:
        if (r10.libraryLoader() == null) goto L13;
        r10.libraryLoader().loadLibrary(LIBRARY_NAME);
        return;
    L13:
        System.loadLibrary(LIBRARY_NAME);
    }

    private static boolean onInitThread() {
        if (sInitThread.getLooper() != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public static void postToInitThread(Runnable r10) {
        if (onInitThread() == false) goto L5;
        r10.run();
        return;
    L5:
        new Handler(sInitThread.getLooper()).post(r10);
    }

    @CalledByNative
    private static void setNetworkThreadPriorityOnNetworkThread(int r10) {
        Process.setThreadPriority(r10);
    }
}
