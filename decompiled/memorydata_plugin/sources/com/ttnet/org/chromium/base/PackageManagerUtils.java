package com.ttnet.org.chromium.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.TransactionTooLargeException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class PackageManagerUtils {
    public static final Intent BROWSER_INTENT = null;
    private static final String TAG = "PackageManagerUtils";

    static {
        BROWSER_INTENT = new Intent().setAction("android.intent.action.VIEW").addCategory("android.intent.category.BROWSABLE").setData(Uri.fromParts("http", "", null));
    }

    public PackageManagerUtils() {
    }

    public static boolean canResolveActivity(Intent r1) {
        return canResolveActivity(r1, 0);
    }

    public static boolean canResolveActivity(Intent r0, int r1) {
        return !queryIntentActivities(r0, r1).isEmpty();
    }

    public static Intent getQueryInstalledHomeLaunchersIntent() {
        return new Intent("android.intent.action.MAIN").addCategory("android.intent.category.HOME");
    }

    private static void handleExpectedExceptionsOrRethrow(RuntimeException r2, Intent r3) {
        if (ZeusTransformUtils.instanceOf(r2, NullPointerException.class) == false) goto L5;
    L8:
        Log.e(TAG, "Could not resolve Activity for intent " + r3.toString(), new Object[]{r2});
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r2.getCause(), TransactionTooLargeException.class) == true) goto L8;
        throw r2;
    }

    public static List<ResolveInfo> queryAllLaunchersInfo() {
        return queryIntentActivities(getQueryInstalledHomeLaunchersIntent(), 131072);
    }

    public static List<ResolveInfo> queryAllWebBrowsersInfo() {
        return queryIntentActivities(BROWSER_INTENT, 983040);
    }

    public static List<ResolveInfo> queryIntentActivities(Intent r4, int r5) {
        StrictModeContext r1 = StrictModeContext.allowDiskReads();     // Catch: RuntimeException -> L15
        List<ResolveInfo> r6 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().queryIntentActivities(r4, r5);     // Catch: Throwable -> L8
        if (r1 == null) goto L7;
        r1.close();     // Catch: RuntimeException -> L15
    L7:
        return r6;
    L8:
        th = move-exception;
        if (r1 != null) goto L21;
    L14:
        throw th;     // Catch: RuntimeException -> L15
    L21:
        r1.close();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.addSuppressed(th);     // Catch: RuntimeException -> L15
    L15:
        e = move-exception;
        handleExpectedExceptionsOrRethrow(e, r4);
        return Collections.emptyList();
    }

    public static ResolveInfo resolveActivity(Intent r4, int r5) {
        StrictModeContext r1 = StrictModeContext.allowDiskWrites();     // Catch: RuntimeException -> L15
        ResolveInfo r6 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().resolveActivity(r4, r5);     // Catch: Throwable -> L8
        if (r1 == null) goto L7;
        r1.close();     // Catch: RuntimeException -> L15
    L7:
        return r6;
    L8:
        th = move-exception;
        if (r1 != null) goto L21;
    L14:
        throw th;     // Catch: RuntimeException -> L15
    L21:
        r1.close();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.addSuppressed(th);     // Catch: RuntimeException -> L15
    L15:
        e = move-exception;
        handleExpectedExceptionsOrRethrow(e, r4);
        return null;
    }

    public static ResolveInfo resolveDefaultWebBrowserActivity() {
        return resolveActivity(BROWSER_INTENT, 65536);
    }
}
