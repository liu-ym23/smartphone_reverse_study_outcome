package com.ttnet.org.chromium.base;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.TransactionTooLargeException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PackageManagerUtils {
    public static final Intent BROWSER_INTENT = null;
    private static final String TAG = "PackageManagerUtils";

    static {
        BROWSER_INTENT = new Intent().setAction("android.intent.action.VIEW").addCategory("android.intent.category.BROWSABLE").setData(Uri.fromParts("http", "", null));
    }

    public PackageManagerUtils() {
    }

    public static boolean canResolveActivity(Intent r10) {
        return canResolveActivity(r10, 0);
    }

    public static boolean canResolveActivity(Intent r10, int r11) {
        return !queryIntentActivities(r10, r11).isEmpty();
    }

    public static Intent getQueryInstalledHomeLaunchersIntent() {
        return new Intent("android.intent.action.MAIN").addCategory("android.intent.category.HOME");
    }

    private static void handleExpectedExceptionsOrRethrow(RuntimeException r10, Intent r11) {
        if ((r10 instanceof NullPointerException) == false) goto L5;
    L8:
        Log.e(TAG, "Could not resolve Activity for intent " + r11.toString(), new Object[]{r10});
        return;
    L5:
        if ((r10.getCause() instanceof TransactionTooLargeException) == true) goto L8;
        throw r10;
    }

    public static List<ResolveInfo> queryAllLaunchersInfo() {
        return queryIntentActivities(getQueryInstalledHomeLaunchersIntent(), 131072);
    }

    public static List<ResolveInfo> queryAllWebBrowsersInfo() {
        return queryIntentActivities(BROWSER_INTENT, 983040);
    }

    public static List<ResolveInfo> queryIntentActivities(Intent r10, int r11) {
        StrictModeContext r12 = StrictModeContext.allowDiskReads();     // Catch: RuntimeException -> L14
        List<ResolveInfo> r13 = ContextUtils.getApplicationContext().getPackageManager().queryIntentActivities(r10, r11);     // Catch: Throwable -> L7
        if (r12 == null) goto L6;
        r12.close();     // Catch: RuntimeException -> L14
    L6:
        return r13;
    L7:
        th = move-exception;
        if (r12 != null) goto L20;
    L13:
        throw th;     // Catch: RuntimeException -> L14
    L20:
        r12.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: RuntimeException -> L14
    L14:
        e = move-exception;
        handleExpectedExceptionsOrRethrow(e, r10);
        return Collections.emptyList();
    }

    public static ResolveInfo resolveActivity(Intent r10, int r11) {
        StrictModeContext r12 = StrictModeContext.allowDiskWrites();     // Catch: RuntimeException -> L14
        ResolveInfo r13 = ContextUtils.getApplicationContext().getPackageManager().resolveActivity(r10, r11);     // Catch: Throwable -> L7
        if (r12 == null) goto L6;
        r12.close();     // Catch: RuntimeException -> L14
    L6:
        return r13;
    L7:
        th = move-exception;
        if (r12 != null) goto L20;
    L13:
        throw th;     // Catch: RuntimeException -> L14
    L20:
        r12.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: RuntimeException -> L14
    L14:
        e = move-exception;
        handleExpectedExceptionsOrRethrow(e, r10);
        return null;
    }

    public static ResolveInfo resolveDefaultWebBrowserActivity() {
        return resolveActivity(BROWSER_INTENT, 65536);
    }
}
