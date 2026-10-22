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
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class ApiHelperForM {
    private ApiHelperForM() {
    }

    public static Icon createIconWithBitmap(Bitmap r0) {
        return Icon.createWithBitmap(r0);
    }

    public static Icon createIconWithResource(Context r2, int r3) {
        return Icon.createWithResource((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3);
    }

    public static int getActionButton(MotionEvent r0) {
        return r0.getActionButton();
    }

    public static int getActionModeType(ActionMode r0) {
        return r0.getType();
    }

    public static Network getActiveNetwork(ConnectivityManager r0) {
        return r0.getActiveNetwork();
    }

    public static Network getBoundNetworkForProcess(ConnectivityManager r0) {
        return r0.getBoundNetworkForProcess();
    }

    public static long getDefaultActionModeHideDuration() {
        return ViewConfiguration.getDefaultActionModeHideDuration();
    }

    public static Display.Mode getDisplayMode(Display r0) {
        return r0.getMode();
    }

    public static Display.Mode[] getDisplaySupportedModes(Display r0) {
        return r0.getSupportedModes();
    }

    public static int getModePhysicalHeight(Display.Mode r0) {
        return r0.getPhysicalHeight();
    }

    public static int getModePhysicalWidth(Display.Mode r0) {
        return r0.getPhysicalWidth();
    }

    public static long getNetworkHandle(Network r2) {
        if (r2 != null) goto L6;
        return 0;
    L6:
        return r2.getNetworkHandle();
    }

    public static NetworkInfo getNetworkInfo(ConnectivityManager r0, Network r1) {
        return r0.getNetworkInfo(r1);
    }

    public static int getPendingIntentImmutableFlag() {
        return AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
    }

    public static <T> T getSystemService(Context r2, Class<T> r3) {
        return (T) ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSystemService(r3);
    }

    public static void hideActionMode(ActionMode r0, long r1) {
        r0.hide(r1);
    }

    public static void invalidateContentRectOnActionMode(ActionMode r0) {
        r0.invalidateContentRect();
    }

    public static boolean isCharging(BatteryManager r0) {
        return r0.isCharging();
    }

    public static boolean isCleartextTrafficPermitted() {
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
    }

    public static boolean isDeviceIdleMode(PowerManager r0) {
        return r0.isDeviceIdleMode();
    }

    public static boolean isPermissionRevokedByPolicy(Activity r2, String r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        return r4.getPackageManager().isPermissionRevokedByPolicy(r3, r4.getPackageName());
    }

    public static boolean isProcess64Bit() {
        return Process.is64Bit();
    }

    public static boolean isSystemUser(UserManager r0) {
        return r0.isSystemUser();
    }

    public static Notification.Action.Builder newNotificationActionBuilder(Icon r2, CharSequence r3, PendingIntent r4) {
        return new Notification.Action.Builder(r2, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4);
    }

    public static void onPageCommitVisible(WebViewClient r0, WebView r1, String r2) {
        r0.onPageCommitVisible(r1, r2);
    }

    public static void onWindowFocusChangedOnActionMode(ActionMode r0, boolean r1) {
        r0.onWindowFocusChanged(r1);
    }

    public static void reportNetworkConnectivity(ConnectivityManager r0, Network r1, boolean r2) {
        r0.reportNetworkConnectivity(r1, r2);
    }

    public static void requestActivityPermissions(Activity r2, String[] r3, int r4) {
        ZeusTransformUtils.requestPermissions((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"), r3, r4, "com.obric.memorydata.plugin");
    }

    public static void setAlarmManagerExactAndAllowWhileIdle(AlarmManager r0, int r1, long r2, PendingIntent r4) {
    }

    public static Notification.Builder setSmallIcon(Notification.Builder r0, Icon r1) {
        return r0.setSmallIcon(r1);
    }

    public static boolean shouldShowRequestPermissionRationale(Activity r2, String r3) {
        return ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")).shouldShowRequestPermissionRationale(r3);
    }
}
