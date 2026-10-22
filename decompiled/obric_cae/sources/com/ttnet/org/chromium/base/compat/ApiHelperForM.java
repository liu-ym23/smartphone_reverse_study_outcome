package com.ttnet.org.chromium.base.compat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Process;
import android.view.ActionMode;
import android.view.ViewConfiguration;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ttnet.org.chromium.base.annotations.DoNotInline;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(23)
@DoNotInline
public final class ApiHelperForM {
    private ApiHelperForM() {
    }

    public static int getActionModeType(ActionMode r8) {
        return r8.getType();
    }

    public static Network getActiveNetwork(ConnectivityManager r8) {
        return r8.getActiveNetwork();
    }

    public static Network getBoundNetworkForProcess(ConnectivityManager r8) {
        return r8.getBoundNetworkForProcess();
    }

    public static long getDefaultActionModeHideDuration() {
        return ViewConfiguration.getDefaultActionModeHideDuration();
    }

    public static long getNetworkHandle(Network r8) {
        return r8.getNetworkHandle();
    }

    public static NetworkInfo getNetworkInfo(ConnectivityManager r8, Network r10) {
        return r8.getNetworkInfo(r10);
    }

    public static void hideActionMode(ActionMode r8, long r10) {
        r8.hide(r10);
    }

    public static void invalidateContentRectOnActionMode(ActionMode r8) {
        r8.invalidateContentRect();
    }

    public static boolean isPermissionRevokedByPolicy(Activity r8, String r10) {
        return r8.getPackageManager().isPermissionRevokedByPolicy(r10, r8.getPackageName());
    }

    public static boolean isProcess64Bit() {
        return Process.is64Bit();
    }

    public static void onPageCommitVisible(WebViewClient r8, WebView r10, String r11) {
        r8.onPageCommitVisible(r10, r11);
    }

    public static void onWindowFocusChangedOnActionMode(ActionMode r8, boolean r10) {
        r8.onWindowFocusChanged(r10);
    }

    public static void requestActivityPermissions(Activity r8, String[] r10, int r11) {
        r8.requestPermissions(r10, r11);
    }

    public static boolean shouldShowRequestPermissionRationale(Activity r8, String r10) {
        return r8.shouldShowRequestPermissionRationale(r10);
    }
}
