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
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ApiHelperForM {
    private ApiHelperForM() {
    }

    public static int getPendingIntentImmutableFlag() {
        return 67108864;
    }

    public static void setAlarmManagerExactAndAllowWhileIdle(AlarmManager r0, int r1, long r2, PendingIntent r4) {
    }

    public static long getDefaultActionModeHideDuration() {
        return ViewConfiguration.getDefaultActionModeHideDuration();
    }

    public static boolean isCleartextTrafficPermitted() {
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
    }

    public static boolean isProcess64Bit() {
        return Process.is64Bit();
    }

    public static Icon createIconWithBitmap(Bitmap r0) {
        return Icon.createWithBitmap(r0);
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

    public static void invalidateContentRectOnActionMode(ActionMode r0) {
        r0.invalidateContentRect();
    }

    public static boolean isCharging(BatteryManager r0) {
        return r0.isCharging();
    }

    public static boolean isDeviceIdleMode(PowerManager r0) {
        return r0.isDeviceIdleMode();
    }

    public static boolean isSystemUser(UserManager r0) {
        return r0.isSystemUser();
    }

    private static boolean com_ttnet_org_chromium_base_compat_ApiHelperForM_android_app_Activity_shouldShowRequestPermissionRationale(Activity r18, String r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        b r11 = new b("auto_cert_com_ttnet_org_chromium_base_compat_ApiHelperForM_android_app_Activity_shouldShowRequestPermissionRationale");
        a r2 = (a) ApiHookConfig.b.get(102609);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(102609, "android/app/Activity", "shouldShowRequestPermissionRationale", r18, r1, "boolean", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Boolean) r4.b).booleanValue();
    L21:
        return r18.shouldShowRequestPermissionRationale(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static Icon createIconWithResource(Context r0, int r1) {
        return Icon.createWithResource(r0, r1);
    }

    public static NetworkInfo getNetworkInfo(ConnectivityManager r0, Network r1) {
        return r0.getNetworkInfo(r1);
    }

    public static <T> T getSystemService(Context r0, Class<T> r1) {
        return (T) r0.getSystemService(r1);
    }

    public static void hideActionMode(ActionMode r0, long r1) {
        r0.hide(r1);
    }

    public static boolean isPermissionRevokedByPolicy(Activity r1, String r2) {
        return r1.getPackageManager().isPermissionRevokedByPolicy(r2, r1.getPackageName());
    }

    public static void onWindowFocusChangedOnActionMode(ActionMode r0, boolean r1) {
        r0.onWindowFocusChanged(r1);
    }

    public static Notification.Builder setSmallIcon(Notification.Builder r0, Icon r1) {
        return r0.setSmallIcon(r1);
    }

    public static boolean shouldShowRequestPermissionRationale(Activity r0, String r1) {
        return com_ttnet_org_chromium_base_compat_ApiHelperForM_android_app_Activity_shouldShowRequestPermissionRationale(r0, r1);
    }

    public static Notification.Action.Builder newNotificationActionBuilder(Icon r1, CharSequence r2, PendingIntent r3) {
        return new Notification.Action.Builder(r1, r2, r3);
    }

    public static void onPageCommitVisible(WebViewClient r0, WebView r1, String r2) {
        r0.onPageCommitVisible(r1, r2);
    }

    public static void reportNetworkConnectivity(ConnectivityManager r0, Network r1, boolean r2) {
        r0.reportNetworkConnectivity(r1, r2);
    }

    public static void requestActivityPermissions(Activity r0, String[] r1, int r2) {
        r0.requestPermissions(r1, r2);
    }
}
