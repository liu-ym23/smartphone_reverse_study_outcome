package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.os.UserManagerCompat;
import com.google.common.util.concurrent.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class PackageManagerCompat {
    public static final String ACTION_PERMISSION_REVOCATION_SETTINGS = "android.intent.action.AUTO_REVOKE_PERMISSIONS";
    public static final String LOG_TAG = "PackageManagerCompat";

    private static class Api30Impl {
        private Api30Impl() {
        }

        static boolean areUnusedAppRestrictionsEnabled(Context r2) {
            return !((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getPackageManager().isAutoRevokeWhitelisted();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface UnusedAppRestrictionsStatus {
    }

    private PackageManagerCompat() {
    }

    public static boolean areUnusedAppRestrictionsAvailable(PackageManager r6) {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        boolean r0 = true;
    L7:
        if (Build.VERSION.SDK_INT >= 23) goto L9;
    L11:
        boolean r1 = false;
    L13:
        if (getPermissionRevocationVerifierApp(r6) == null) goto L15;
        boolean r7 = true;
    L16:
        if (r0 == true) goto L22;
        if (r1 == false) goto L21;
        if (r7 == false) goto L21;
        return true;
    L21:
        return false;
    L22:
        return true;
    L15:
        r7 = false;
        goto L16
    L9:
        if (Build.VERSION.SDK_INT >= 30) goto L11;
        r1 = true;
        goto L13
    L5:
        r0 = false;
        goto L7
    }

    public static String getPermissionRevocationVerifierApp(PackageManager r5) {
        String r3 = null;
        Iterator<ResolveInfo> r0 = r5.queryIntentActivities(new Intent(ACTION_PERMISSION_REVOCATION_SETTINGS).setData(Uri.fromParts("package", "com.example", null)), 0).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        String r1 = ((ResolveInfo) ZeusTransformUtils.preCheckCast(r0.next(), ResolveInfo.class, "com.obric.memorydata.plugin")).activityInfo.packageName;
        if (r5.checkPermission("android.permission.PACKAGE_VERIFICATION_AGENT", r1) != 0) goto L4;
        if (r3 != null) goto L9;
        r3 = r1;
        goto L4
    L9:
        return r3;
    L11:
        return r3;
    }

    public static l<Integer> getUnusedAppRestrictionsStatus(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        ResolvableFuture<Integer> r0 = ResolvableFuture.create();
        if (UserManagerCompat.isUserUnlocked(r8) == true) goto L7;
        r0.set(0);
        Log.e(LOG_TAG, "User is in locked direct boot mode");
        return r0;
    L7:
        if (areUnusedAppRestrictionsAvailable(r8.getPackageManager()) == true) goto L10;
        r0.set(1);
        return r0;
    L10:
        int r1 = r8.getApplicationInfo().targetSdkVersion;
        if (r1 >= 30) goto L14;
        r0.set(0);
        Log.e(LOG_TAG, "Target SDK version below API 30");
        return r0;
    L14:
        int r3 = 4;
        if (Build.VERSION.SDK_INT < 31) goto L25;
        if (Api30Impl.areUnusedAppRestrictionsEnabled(r8) == false) goto L21;
        if (r1 < 31) goto L20;
        r3 = 5;
    L20:
        int r9 = Integer.valueOf(r3);
    L22:
        r0.set(r9);
        return r0;
    L21:
        r9 = 2;
        goto L22
    L25:
        if (Build.VERSION.SDK_INT == 30) goto L27;
        final UnusedAppRestrictionsBackportServiceConnection r2 = new UnusedAppRestrictionsBackportServiceConnection(r8);
        Objects.requireNonNull(r2);
        r0.addListener(new $$Lambda$SJcDCtX_JtAI8Mo8DbauUqPURzc(r2), Executors.newSingleThreadExecutor());
        r2.connectAndFetchResult(r0);
        return r0;
    L27:
        if (Api30Impl.areUnusedAppRestrictionsEnabled(r8) == true) goto L30;
        r3 = 2;
    L30:
        r0.set(Integer.valueOf(r3));
        return r0;
    }
}
