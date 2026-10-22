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
import androidx.annotation.RequiresApi;
import com.ttnet.org.chromium.base.StrictModeContext;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(26)
public final class ApiHelperForO {
    private ApiHelperForO() {
    }

    public static void addItem(ClipData r10, ContentResolver r11, ClipData.Item r12) {
        r10.addItem(r11, r12);
    }

    public static boolean areAnimatorsEnabled() {
        return ValueAnimator.areAnimatorsEnabled();
    }

    public static void cancelAutofillSession(Activity r10) {
        AutofillManager r11 = (AutofillManager) r10.getSystemService(AutofillManager.class);
        if (r11 == null) goto L6;
        r11.cancel();
        return;
    }

    public static Context createContextForSplit(Context r10, String r11) {
        StrictModeContext r12 = StrictModeContext.allowDiskReads();
        Context r13 = r10.createContextForSplit(r11);     // Catch: Throwable -> L7
        if (r12 == null) goto L6;
        r12.close();
    L6:
        return r13;
    L7:
        th = move-exception;
        if (r12 != null) goto L14;
    L13:
        throw th;
    L14:
        r12.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public static String getNotificationChannelId(Notification r10) {
        return r10.getChannelId();
    }

    public static String[] getSplitNames(ApplicationInfo r10) {
        return r10.splitNames;
    }

    public static long getTimestamp(ClipDescription r10) {
        return r10.getTimestamp();
    }

    public static boolean isInstantApp(PackageManager r10) {
        return r10.isInstantApp();
    }

    public static boolean isScreenWideColorGamut(Configuration r10) {
        return r10.isScreenWideColorGamut();
    }

    public static boolean isWideColorGamut(Display r10) {
        return r10.isWideColorGamut();
    }

    public static void notifyValueChangedForAutofill(View r10) {
        AutofillManager r11 = (AutofillManager) r10.getContext().getSystemService(AutofillManager.class);
        if (r11 == null) goto L6;
        r11.notifyValueChanged(r10);
        return;
    }

    public static void registerDefaultNetworkCallback(ConnectivityManager r10, ConnectivityManager.NetworkCallback r11, Handler r12) {
        r10.registerDefaultNetworkCallback(r11, r12);
    }

    public static void registerNetworkCallback(ConnectivityManager r10, NetworkRequest r11, ConnectivityManager.NetworkCallback r12, Handler r13) {
        r10.registerNetworkCallback(r11, r12, r13);
    }

    public static Intent registerReceiver(Context r10, BroadcastReceiver r11, IntentFilter r12, String r13, Handler r14, int r15) {
        return r10.registerReceiver(r11, r12, r13, r14, r15);
    }

    public static Notification.Builder setChannelId(Notification.Builder r10, String r11) {
        return r10.setChannelId(r11);
    }

    public static void setColorMode(Window r10, int r11) {
        r10.setColorMode(r11);
    }

    public static void setDefaultFocusHighlightEnabled(View r10, boolean r11) {
        r10.setDefaultFocusHighlightEnabled(r11);
    }

    public static Notification.Builder setTimeoutAfter(Notification.Builder r10, long r11) {
        return r10.setTimeoutAfter(r11);
    }
}
