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
import com.ttnet.org.chromium.base.ApiCompatibilityUtils;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class ApiHelperForS {
    private static final String TAG = "ApiHelperForS";

    private ApiHelperForS() {
    }

    public static Context createWindowContext(Context r2, Display r3, int r4, Bundle r5) {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).createWindowContext(r3, r4, r5), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    }

    public static float getConfidenceScore(ClipDescription r0, String r1) {
        return r0.getConfidenceScore(r1);
    }

    public static int getPendingIntentMutableFlag() {
        return 33554432;
    }

    public static TextClassification getTextClassification(TextSelection r0) {
        return r0.getTextClassification();
    }

    public static TextLinks getTextLinks(ClipData.Item r0) {
        return r0.getTextLinks();
    }

    public static boolean hasBluetoothConnectPermission() {
        if (ApiCompatibilityUtils.checkPermission((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "android.permission.BLUETOOTH_CONNECT", Process.myPid(), Process.myUid()) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isGetClassificationStatusIsComplete(ClipDescription r1) {
        if (r1.getClassificationStatus() != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isStyleText(ClipDescription r0) {
        return r0.isStyledText();
    }

    public static void setAutoEnterEnabled(PictureInPictureParams.Builder r0, boolean r1) {
        r0.setAutoEnterEnabled(r1);
    }

    public static TextSelection.Request.Builder setIncludeTextClassification(TextSelection.Request.Builder r0, boolean r1) {
        return r0.setIncludeTextClassification(r1);
    }

    public static void startForeground(Service r2, int r3, Notification r4, int r5) {
        ((Service) ZeusTransformUtils.wrapperContextForParams(r2, Service.class, "com.obric.memorydata.plugin")).startForeground(r3, r4, r5);     // Catch: ForegroundServiceStartNotAllowedException -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "Cannot run service as foreground: " + e + " for notification channel " + r4.getChannelId() + " notification id " + r3, new Object[0]);
    }
}
