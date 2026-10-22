package com.ttnet.org.chromium.base.compat;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.PictureInPictureParams;
import android.app.Service;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.view.Display;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextLinks;
import android.view.textclassifier.TextSelection;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.ttnet.org.chromium.base.ApiCompatibilityUtils;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.Log;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(31)
public final class ApiHelperForS {
    private static final String TAG = "ApiHelperForS";

    private ApiHelperForS() {
    }

    public static Context createWindowContext(Context r10, Display r11, int r12, Bundle r13) {
        return r10.createWindowContext(r11, r12, r13);
    }

    public static float getConfidenceScore(ClipDescription r10, @NonNull String r11) {
        return r10.getConfidenceScore(r11);
    }

    public static int getPendingIntentMutableFlag() {
        return 33554432;
    }

    public static TextClassification getTextClassification(TextSelection r10) {
        return r10.getTextClassification();
    }

    public static TextLinks getTextLinks(ClipData.Item r10) {
        return r10.getTextLinks();
    }

    public static boolean hasBluetoothConnectPermission() {
        if (ApiCompatibilityUtils.checkPermission(ContextUtils.getApplicationContext(), "android.permission.BLUETOOTH_CONNECT", Process.myPid(), Process.myUid()) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isGetClassificationStatusIsComplete(ClipDescription r10) {
        if (r10.getClassificationStatus() != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isStyleText(ClipDescription r10) {
        return r10.isStyledText();
    }

    public static void setAutoEnterEnabled(PictureInPictureParams.Builder r10, boolean r11) {
        r10.setAutoEnterEnabled(r11);
    }

    public static TextSelection.Request.Builder setIncludeTextClassification(TextSelection.Request.Builder r10, boolean r11) {
        return r10.setIncludeTextClassification(r11);
    }

    public static void startForeground(Service r10, int r11, Notification r12, int r13) {
        r10.startForeground(r11, r12, r13);     // Catch: ForegroundServiceStartNotAllowedException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "Cannot run service as foreground: " + e + " for notification channel " + r12.getChannelId() + " notification id " + r11, new Object[0]);
    }
}
