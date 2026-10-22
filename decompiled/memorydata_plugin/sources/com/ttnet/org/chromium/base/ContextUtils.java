package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.app.Application;
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
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForO;
import com.ttnet.org.chromium.build.BuildConfig;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
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

        static /* synthetic */ SharedPreferences access$102(SharedPreferences r2) {
            SharedPreferences r3 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.class, "com.obric.memorydata.plugin");
            sSharedPreferences = r3;
            return r3;
        }
    }

    static {
    }

    public ContextUtils() {
    }

    static /* synthetic */ SharedPreferences access$000() {
        return fetchAppSharedPreferences();
    }

    public static Activity activityFromContext(Context r2) {
        Object r3 = ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
    L3:
        Context r4 = (Context) r3;
        if (ZeusTransformUtils.instanceOf(r4, ContextWrapper.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r4, Activity.class) == true) goto L8;
        r3 = ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r4, ContextWrapper.class, "com.obric.memorydata.plugin")).getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        goto L3
    L8:
        return (Activity) ZeusTransformUtils.preCheckCast(r4, Activity.class, "com.obric.memorydata.plugin");
    L10:
        return null;
    }

    public static void clearApplicationContextForTests() {
        sApplicationContext = null;
        Holder.access$102(null);
    }

    private static SharedPreferences fetchAppSharedPreferences() {
        StrictModeContext r0 = StrictModeContext.allowDiskWrites();
        SharedPreferences r1 = PreferenceManager.getDefaultSharedPreferences(sApplicationContext);     // Catch: Throwable -> L7
        if (r0 == null) goto L6;
        r0.close();
    L6:
        return r1;
    L7:
        th = move-exception;
        if (r0 != null) goto L16;
    L13:
        throw th;
    L16:
        r0.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public static SharedPreferences getAppSharedPreferences() {
        return Holder.access$100();
    }

    public static AssetManager getApplicationAssets() {
        Context r0 = getApplicationContext();
    L3:
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, ContextWrapper.class) == false) goto L7;
        r0 = ((ContextWrapper) ZeusTransformUtils.preCheckCast(r1, ContextWrapper.class, "com.obric.memorydata.plugin")).getBaseContext();
        goto L3
    L7:
        return r1.getAssets();
    }

    public static Context getApplicationContext() {
        return sApplicationContext;
    }

    public static String getProcessName() {
        return ApiCompatibilityUtils.getProcessName();
    }

    public static void initApplicationContext(Context r2) {
        initJavaSideApplicationContext((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    public static void initApplicationContextForTests(Context r2) {
        initJavaSideApplicationContext((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
        Holder.access$102(fetchAppSharedPreferences());
    }

    private static void initJavaSideApplicationContext(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
    L7:
        sApplicationContext = r3;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, Application.class) == false) goto L7;
        r3 = new ContextWrapper(r3);
        goto L7
    }

    public static boolean isIsolatedProcess() {
        return Process.isIsolated();
    }

    public static boolean isProcess64Bit() {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return ApiHelperForM.isProcess64Bit();
    L7:
        if (Build.SUPPORTED_64_BIT_ABIS.length > 0) goto L9;
        return false;
    L9:
        if (Build.SUPPORTED_64_BIT_ABIS[0].equals(Build.CPU_ABI) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public static boolean isSdkSandboxProcess() {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return false;
    L5:
        return Process.isSdkSandbox();
    }

    private static Intent registerBroadcastReceiver(Context r6, PluginBroadcastReceiver r7, IntentFilter r8, String r9, Handler r10, int r11) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return ApiHelperForO.registerReceiver(r0, r7, r8, r9, r10, r11);
    L7:
        return ZeusTransformUtils.registerReceiver(r0, r7, r8, r9, r10, "com.obric.memorydata.plugin");
    }

    public static Intent registerExportedBroadcastReceiver(Context r6, PluginBroadcastReceiver r7, IntentFilter r8, String r9) {
        return registerBroadcastReceiver((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin"), r7, r8, r9, null, 2);
    }

    public static Intent registerNonExportedBroadcastReceiver(Context r6, PluginBroadcastReceiver r7, IntentFilter r8) {
        return registerBroadcastReceiver((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin"), r7, r8, null, null, 4);
    }

    public static Intent registerNonExportedBroadcastReceiver(Context r6, PluginBroadcastReceiver r7, IntentFilter r8, Handler r9) {
        return registerBroadcastReceiver((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin"), r7, r8, null, r9, 4);
    }
}
