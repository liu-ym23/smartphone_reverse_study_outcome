package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.os.UserManagerCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class PackageManagerCompat {

    @SuppressLint({"ActionValue"})
    public static final String ACTION_PERMISSION_REVOCATION_SETTINGS = "android.intent.action.AUTO_REVOKE_PERMISSIONS";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String LOG_TAG = "PackageManagerCompat";

    @RequiresApi(30)
    private static class Api30Impl {
        private Api30Impl() {
        }

        static boolean areUnusedAppRestrictionsEnabled(@NonNull Context r10) {
            return !r10.getPackageManager().isAutoRevokeWhitelisted();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface UnusedAppRestrictionsStatus {
    }

    private PackageManagerCompat() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static boolean areUnusedAppRestrictionsAvailable(@NonNull PackageManager r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 30) goto L5;
        boolean r12 = true;
    L7:
        if (r11 < 23) goto L10;
        if (r11 >= 30) goto L10;
        boolean r13 = true;
    L12:
        if (getPermissionRevocationVerifierApp(r10) == null) goto L14;
        boolean r14 = true;
    L15:
        if (r12 == true) goto L21;
        if (r13 == false) goto L20;
        if (r14 == false) goto L20;
        return true;
    L20:
        return false;
    L21:
        return true;
    L14:
        r14 = false;
    L10:
        r13 = false;
        goto L12
    L5:
        r12 = false;
        goto L7
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static String getPermissionRevocationVerifierApp(@NonNull PackageManager r10) {
        String r11 = null;
        Iterator<ResolveInfo> r12 = r10.queryIntentActivities(new Intent(ACTION_PERMISSION_REVOCATION_SETTINGS).setData(Uri.fromParts("package", "com.example", null)), 0).iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        String r13 = r12.next().activityInfo.packageName;
        if (r10.checkPermission("android.permission.PACKAGE_VERIFICATION_AGENT", r13) != 0) goto L4;
        if (r11 != null) goto L9;
        r11 = r13;
        goto L4
    L9:
        return r11;
    L11:
        return r11;
    }

    @NonNull
    public static c6.a<Integer> getUnusedAppRestrictionsStatus(@NonNull Context r10) {
        ResolvableFuture<Integer> r11 = ResolvableFuture.create();
        if (UserManagerCompat.isUserUnlocked(r10) == true) goto L7;
        r11.set(0);
        Log.e(LOG_TAG, "User is in locked direct boot mode");
        return r11;
    L7:
        if (areUnusedAppRestrictionsAvailable(r10.getPackageManager()) == true) goto L10;
        r11.set(1);
        return r11;
    L10:
        int r12 = r10.getApplicationInfo().targetSdkVersion;
        if (r12 >= 30) goto L14;
        r11.set(0);
        Log.e(LOG_TAG, "Target SDK version below API 30");
        return r11;
    L14:
        int r13 = Build.VERSION.SDK_INT;
        int r14 = 4;
        if (r13 >= 31) goto L17;
        if (r13 == 30) goto L26;
        final UnusedAppRestrictionsBackportServiceConnection r15 = new UnusedAppRestrictionsBackportServiceConnection(r10);
        r11.addListener(new v(r15), Executors.newSingleThreadExecutor());
        r15.connectAndFetchResult(r11);
        return r11;
    L26:
        if (Api30Impl.areUnusedAppRestrictionsEnabled(r10) == true) goto L29;
        r14 = 2;
    L29:
        r11.set(Integer.valueOf(r14));
        return r11;
    L17:
        if (Api30Impl.areUnusedAppRestrictionsEnabled(r10) == false) goto L21;
        if (r12 < 31) goto L20;
        r14 = 5;
    L20:
        int r16 = Integer.valueOf(r14);
    L22:
        r11.set(r16);
        return r11;
    L21:
        r16 = 2;
        goto L22
    }
}
