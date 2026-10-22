package com.ttnet.org.chromium.base.compat;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.autofill.AutofillManager;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.ttnet.org.chromium.base.StrictModeContext;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ApiHelperForO {
    private ApiHelperForO() {
    }

    public static void addItem(ClipData r0, ContentResolver r1, ClipData.Item r2) {
    }

    public static boolean areAnimatorsEnabled() {
        return ValueAnimator.areAnimatorsEnabled();
    }

    public static void cancelAutofillSession(Activity r1) {
        AutofillManager r2 = (AutofillManager) r1.getSystemService(AutofillManager.class);
        if (r2 == null) goto L6;
        r2.cancel();
        return;
    }

    public static String getNotificationChannelId(Notification r0) {
        return r0.getChannelId();
    }

    public static String[] getSplitNames(ApplicationInfo r0) {
        return r0.splitNames;
    }

    public static long getTimestamp(ClipDescription r2) {
        return r2.getTimestamp();
    }

    public static boolean isInstantApp(PackageManager r0) {
        return r0.isInstantApp();
    }

    public static boolean isScreenWideColorGamut(Configuration r0) {
        return r0.isScreenWideColorGamut();
    }

    public static boolean isWideColorGamut(Display r0) {
        return r0.isWideColorGamut();
    }

    public static void notifyValueChangedForAutofill(View r2) {
        AutofillManager r0 = (AutofillManager) r2.getContext().getSystemService(AutofillManager.class);
        if (r0 == null) goto L6;
        r0.notifyValueChanged(r2);
        return;
    }

    public static Context createContextForSplit(Context r1, String r2) throws PackageManager.NameNotFoundException {
        StrictModeContext r0 = StrictModeContext.allowDiskReads();
        Context r3 = r1.createContextForSplit(r2);     // Catch: Throwable -> L7
        if (r0 == null) goto L6;
        r0.close();
    L6:
        return r3;
    L7:
        th = move-exception;
        if (r0 != null) goto L14;
    L13:
        throw th;
    L14:
        r0.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public static Notification.Builder setChannelId(Notification.Builder r0, String r1) {
        return r0.setChannelId(r1);
    }

    public static void setColorMode(Window r0, int r1) {
        r0.setColorMode(r1);
    }

    public static void setDefaultFocusHighlightEnabled(View r0, boolean r1) {
        r0.setDefaultFocusHighlightEnabled(r1);
    }

    public static Notification.Builder setTimeoutAfter(Notification.Builder r0, long r1) {
        return r0.setTimeoutAfter(r1);
    }

    public static void registerDefaultNetworkCallback(ConnectivityManager r0, ConnectivityManager.NetworkCallback r1, Handler r2) {
        r0.registerDefaultNetworkCallback(r1, r2);
    }

    public static void registerNetworkCallback(ConnectivityManager r0, NetworkRequest r1, ConnectivityManager.NetworkCallback r2, Handler r3) {
        r0.registerNetworkCallback(r1, r2, r3);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_ttnet_org_chromium_base_compat_ApiHelperForO_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r8, BroadcastReceiver r9, IntentFilter r10, String r11, Handler r12, int r13) {
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
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10, r11, r12, r13);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r10 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, r13, r11, r12, 5, r8);     // Catch: Exception -> L26
        int r1 = r0.result;     // Catch: Exception -> L26
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        return r8.registerReceiver(r9, r10, r11, r12, r13);
    L19:
        return r0.intent;
    L21:
        return new Intent();
    L23:
        return r8.registerReceiver(r9, r10, r11, r12, r13);
    L25:
        return r8.registerReceiver(r9, r10, r11, r12, r13);
    }

    public static Intent registerReceiver(Context r0, BroadcastReceiver r1, IntentFilter r2, String r3, Handler r4, int r5) {
        return INVOKEVIRTUAL_com_ttnet_org_chromium_base_compat_ApiHelperForO_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r0, r1, r2, r3, r4, r5);
    }
}
