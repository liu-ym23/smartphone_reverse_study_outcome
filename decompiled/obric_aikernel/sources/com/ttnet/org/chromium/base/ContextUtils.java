package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.preference.PreferenceManager;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForO;
import com.ttnet.org.chromium.build.BuildConfig;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
public class ContextUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int RECEIVER_EXPORTED = 2;
    public static final int RECEIVER_NOT_EXPORTED = 4;
    private static final String TAG = "ContextUtils";
    private static Context sApplicationContext;

    private static class Holder {
        private static SharedPreferences sSharedPreferences;

        static {
            sSharedPreferences = ContextUtils.access$000();
        }

        private Holder() {
        }

        static /* synthetic */ SharedPreferences access$100() {
            return sSharedPreferences;
        }

        static /* synthetic */ SharedPreferences access$102(SharedPreferences r10) {
            sSharedPreferences = r10;
            return r10;
        }
    }

    static {
    }

    public ContextUtils() {
    }

    static /* synthetic */ SharedPreferences access$000() {
        return fetchAppSharedPreferences();
    }

    @Nullable
    public static Activity activityFromContext(@Nullable Context r10) {
    L3:
        if ((r10 instanceof ContextWrapper) == false) goto L9;
        if ((r10 instanceof Activity) == true) goto L7;
        r10 = ((ContextWrapper) r10).getBaseContext();
        goto L3
    L7:
        return (Activity) r10;
    L9:
        return null;
    }

    @VisibleForTesting
    public static void clearApplicationContextForTests() {
        sApplicationContext = null;
        Holder.access$102(null);
    }

    private static SharedPreferences fetchAppSharedPreferences() {
        StrictModeContext r10 = StrictModeContext.allowDiskWrites();
        SharedPreferences r11 = PreferenceManager.getDefaultSharedPreferences(sApplicationContext);     // Catch: Throwable -> L7
        if (r10 == null) goto L6;
        r10.close();
    L6:
        return r11;
    L7:
        th = move-exception;
        if (r10 != null) goto L16;
    L13:
        throw th;
    L16:
        r10.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public static SharedPreferences getAppSharedPreferences() {
        return Holder.access$100();
    }

    public static AssetManager getApplicationAssets() {
        Context r10 = getApplicationContext();
    L4:
        if ((r10 instanceof ContextWrapper) == false) goto L7;
        r10 = ((ContextWrapper) r10).getBaseContext();
        goto L4
    L7:
        return r10.getAssets();
    }

    public static Context getApplicationContext() {
        return sApplicationContext;
    }

    public static String getProcessName() {
        return ApiCompatibilityUtils.getProcessName();
    }

    public static void initApplicationContext(Context r10) {
        initJavaSideApplicationContext(r10);
    }

    @VisibleForTesting
    public static void initApplicationContextForTests(Context r10) {
        initJavaSideApplicationContext(r10);
        Holder.access$102(fetchAppSharedPreferences());
    }

    private static void initJavaSideApplicationContext(Context r10) {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
    L7:
        sApplicationContext = r10;
        return;
    L5:
        if ((r10 instanceof Application) == false) goto L7;
        r10 = new ContextWrapper(r10);
        goto L7
    }

    public static boolean isIsolatedProcess() {
        return Process.isIsolated();
    }

    public static boolean isProcess64Bit() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        String[] r10 = Build.SUPPORTED_64_BIT_ABIS;
        if (r10.length > 0) goto L9;
        return false;
    L9:
        if (r10[0].equals(Build.CPU_ABI) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        return ApiHelperForM.isProcess64Bit();
    }

    public static boolean isSdkSandboxProcess() {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return false;
    L5:
        return Process.isSdkSandbox();
    }

    private static Intent registerBroadcastReceiver(Context r10, BroadcastReceiver r11, IntentFilter r12, String r13, Handler r14, int r15) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return ApiHelperForO.registerReceiver(r10, r11, r12, r13, r14, r15);
    L7:
        return r10.registerReceiver(r11, r12, r13, r14);
    }

    public static Intent registerExportedBroadcastReceiver(Context r10, BroadcastReceiver r11, IntentFilter r12, String r13) {
        return registerBroadcastReceiver(r10, r11, r12, r13, null, 2);
    }

    public static Intent registerNonExportedBroadcastReceiver(Context r10, BroadcastReceiver r11, IntentFilter r12) {
        return registerBroadcastReceiver(r10, r11, r12, null, null, 4);
    }

    public static Intent registerNonExportedBroadcastReceiver(Context r10, BroadcastReceiver r11, IntentFilter r12, Handler r13) {
        return registerBroadcastReceiver(r10, r11, r12, null, r13, 4);
    }
}
