package com.ttnet.org.chromium.base.compat;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Notification;
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
import com.ttnet.org.chromium.base.StrictModeContext;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class ApiHelperForO {
    private ApiHelperForO() {
    }

    public static void addItem(ClipData r0, ContentResolver r1, ClipData.Item r2) {
    }

    public static boolean areAnimatorsEnabled() {
        return ValueAnimator.areAnimatorsEnabled();
    }

    public static void cancelAutofillSession(Activity r2) {
        AutofillManager r3 = (AutofillManager) ZeusTransformUtils.preCheckCast(((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")).getSystemService(AutofillManager.class), AutofillManager.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        r3.cancel();
        return;
    }

    public static Context createContextForSplit(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        StrictModeContext r0 = StrictModeContext.allowDiskReads();
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.createContextForSplit(r3), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        if (r0 == null) goto L6;
        r0.close();
    L6:
        return r5;
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

    public static void notifyValueChangedForAutofill(View r3) {
        AutofillManager r0 = (AutofillManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(AutofillManager.class), AutofillManager.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        r0.notifyValueChanged(r3);
        return;
    }

    public static void registerDefaultNetworkCallback(ConnectivityManager r0, ConnectivityManager.NetworkCallback r1, Handler r2) {
        r0.registerDefaultNetworkCallback(r1, r2);
    }

    public static void registerNetworkCallback(ConnectivityManager r0, NetworkRequest r1, ConnectivityManager.NetworkCallback r2, Handler r3) {
        r0.registerNetworkCallback(r1, r2, r3);
    }

    public static Intent registerReceiver(Context r7, PluginBroadcastReceiver r8, IntentFilter r9, String r10, Handler r11, int r12) {
        return ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, "com.obric.memorydata.plugin");
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
}
