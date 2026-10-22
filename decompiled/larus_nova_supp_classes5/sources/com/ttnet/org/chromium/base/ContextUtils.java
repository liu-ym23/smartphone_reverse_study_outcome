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
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForO;
import com.ttnet.org.chromium.build.BuildConfig;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@JNINamespace("base::android")
public class ContextUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int RECEIVER_EXPORTED = 2;
    public static final int RECEIVER_NOT_EXPORTED = 4;
    private static final String TAG = "ContextUtils";
    private static Context sApplicationContext;

    public ContextUtils() {
    }

    public static void clearApplicationContextForTests() {
        sApplicationContext = null;
        Holder.access$102(null);
    }

    public static boolean isProcess64Bit() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        String[] r0 = Build.SUPPORTED_64_BIT_ABIS;
        if (r0.length > 0) goto L9;
        return false;
    L9:
        if (r0[0].equals(Build.CPU_ABI) == false) goto L13;
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

    public static /* synthetic */ SharedPreferences access$000() {
        return fetchAppSharedPreferences();
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
    L4:
        if ((r0 instanceof ContextWrapper) == false) goto L7;
        r0 = ((ContextWrapper) r0).getBaseContext();
        goto L4
    L7:
        return r0.getAssets();
    }

    public static String getProcessName() {
        return ApiCompatibilityUtils.getProcessName();
    }

    public static boolean isIsolatedProcess() {
        return Process.isIsolated();
    }

    static {
    }

    public static Context getApplicationContext() {
        return sApplicationContext;
    }

    public static Activity activityFromContext(Context r1) {
    L3:
        if ((r1 instanceof ContextWrapper) == false) goto L9;
        if ((r1 instanceof Activity) == true) goto L7;
        r1 = ((ContextWrapper) r1).getBaseContext();
        goto L3
    L7:
        return (Activity) r1;
    L9:
        return null;
    }

    public static void initApplicationContext(Context r0) {
        initJavaSideApplicationContext(r0);
    }

    public static void initApplicationContextForTests(Context r0) {
        initJavaSideApplicationContext(r0);
        Holder.access$102(fetchAppSharedPreferences());
    }

    private static void initJavaSideApplicationContext(Context r1) {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
    L7:
        sApplicationContext = r1;
        return;
    L5:
        if ((r1 instanceof Application) == false) goto L7;
        r1 = new ContextWrapper(r1);
        goto L7
    }

    public static Intent registerNonExportedBroadcastReceiver(Context r6, BroadcastReceiver r7, IntentFilter r8) {
        return registerBroadcastReceiver(r6, r7, r8, null, null, 4);
    }

    public static Intent registerExportedBroadcastReceiver(Context r6, BroadcastReceiver r7, IntentFilter r8, String r9) {
        return registerBroadcastReceiver(r6, r7, r8, r9, null, 2);
    }

    public static Intent registerNonExportedBroadcastReceiver(Context r6, BroadcastReceiver r7, IntentFilter r8, Handler r9) {
        return registerBroadcastReceiver(r6, r7, r8, null, r9, 4);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_ttnet_org_chromium_base_ContextUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r8, BroadcastReceiver r9, IntentFilter r10, String r11, Handler r12) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L32;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L32:
    L26:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L30;
        throw e;
    L30:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10, r11, r12);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r10 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, r11, r12, 4, r8);     // Catch: Exception -> L26
        int r1 = r0.result;     // Catch: Exception -> L26
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        return r8.registerReceiver(r9, r10, r11, r12);
    L19:
        return r0.intent;
    L21:
        return new Intent();
    L23:
        return r8.registerReceiver(r9, r10, r11, r12);
    L25:
        return r8.registerReceiver(r9, r10, r11, r12);
    }

    private static Intent registerBroadcastReceiver(Context r2, BroadcastReceiver r3, IntentFilter r4, String r5, Handler r6, int r7) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return ApiHelperForO.registerReceiver(r2, r3, r4, r5, r6, r7);
    L7:
        return INVOKEVIRTUAL_com_ttnet_org_chromium_base_ContextUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r2, r3, r4, r5, r6);
    }
}
