package com.ttnet.org.chromium.base.compat;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.BatteryManager;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.security.NetworkSecurityPolicy;
import android.view.ActionMode;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(23)
public final class ApiHelperForM {
    private ApiHelperForM() {
    }

    public static Icon createIconWithBitmap(Bitmap r10) {
        return Icon.createWithBitmap(r10);
    }

    public static Icon createIconWithResource(Context r10, int r11) {
        return Icon.createWithResource(r10, r11);
    }

    public static int getActionButton(MotionEvent r10) {
        return r10.getActionButton();
    }

    public static int getActionModeType(ActionMode r10) {
        return r10.getType();
    }

    public static Network getActiveNetwork(ConnectivityManager r10) {
        return r10.getActiveNetwork();
    }

    public static Network getBoundNetworkForProcess(ConnectivityManager r10) {
        return r10.getBoundNetworkForProcess();
    }

    public static long getDefaultActionModeHideDuration() {
        return ViewConfiguration.getDefaultActionModeHideDuration();
    }

    public static Display.Mode getDisplayMode(Display r10) {
        return r10.getMode();
    }

    public static Display.Mode[] getDisplaySupportedModes(Display r10) {
        return r10.getSupportedModes();
    }

    public static int getModePhysicalHeight(Display.Mode r10) {
        return r10.getPhysicalHeight();
    }

    public static int getModePhysicalWidth(Display.Mode r10) {
        return r10.getPhysicalWidth();
    }

    public static long getNetworkHandle(Network r10) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.getNetworkHandle();
    }

    public static NetworkInfo getNetworkInfo(ConnectivityManager r10, Network r11) {
        return r10.getNetworkInfo(r11);
    }

    public static int getPendingIntentImmutableFlag() {
        return 67108864;
    }

    public static <T> T getSystemService(Context r10, Class<T> r11) {
        return (T) r10.getSystemService(r11);
    }

    public static void hideActionMode(ActionMode r10, long r11) {
        r10.hide(r11);
    }

    public static void invalidateContentRectOnActionMode(ActionMode r10) {
        r10.invalidateContentRect();
    }

    public static boolean isCharging(BatteryManager r10) {
        return r10.isCharging();
    }

    public static boolean isCleartextTrafficPermitted() {
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
    }

    public static boolean isDeviceIdleMode(PowerManager r10) {
        return r10.isDeviceIdleMode();
    }

    public static boolean isPermissionRevokedByPolicy(Activity r10, String r11) {
        return r10.getPackageManager().isPermissionRevokedByPolicy(r11, r10.getPackageName());
    }

    public static boolean isProcess64Bit() {
        return Process.is64Bit();
    }

    public static boolean isSystemUser(UserManager r10) {
        return r10.isSystemUser();
    }

    public static Notification.Action.Builder newNotificationActionBuilder(Icon r10, CharSequence r11, PendingIntent r12) {
        return new Notification.Action.Builder(r10, r11, r12);
    }

    public static void onPageCommitVisible(WebViewClient r10, WebView r11, String r12) {
        r10.onPageCommitVisible(r11, r12);
    }

    public static void onWindowFocusChangedOnActionMode(ActionMode r10, boolean r11) {
        r10.onWindowFocusChanged(r11);
    }

    public static void reportNetworkConnectivity(ConnectivityManager r10, Network r11, boolean r12) {
        r10.reportNetworkConnectivity(r11, r12);
    }

    public static void requestActivityPermissions(Activity r10, String[] r11, int r12) {
        r10.requestPermissions(r11, r12);
    }

    public static void setAlarmManagerExactAndAllowWhileIdle(AlarmManager r10, int r11, long r12, PendingIntent r13) {
    }

    public static Notification.Builder setSmallIcon(Notification.Builder r10, Icon r11) {
        return r10.setSmallIcon(r11);
    }

    public static boolean shouldShowRequestPermissionRationale(Activity r10, String r11) {
        return r10.shouldShowRequestPermissionRationale(r11);
    }
}
