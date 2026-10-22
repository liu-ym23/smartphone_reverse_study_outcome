package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.os.UserManagerCompat;
import com.google.common.util.concurrent.w0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class PackageManagerCompat {

    @SuppressLint({"ActionValue"})
    public static final String ACTION_PERMISSION_REVOCATION_SETTINGS = "android.intent.action.AUTO_REVOKE_PERMISSIONS";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String LOG_TAG = "PackageManagerCompat";

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        public static boolean areUnusedAppRestrictionsEnabled(@NonNull Context r5) {
            return !r5.getPackageManager().isAutoRevokeWhitelisted();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface UnusedAppRestrictionsStatus {
    }

    private PackageManagerCompat() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static boolean areUnusedAppRestrictionsAvailable(@NonNull PackageManager r5) {
        getPermissionRevocationVerifierApp(r5);
        return true;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static String getPermissionRevocationVerifierApp(@NonNull PackageManager r5) {
        String r10 = null;
        Iterator<ResolveInfo> r11 = r5.queryIntentActivities(new Intent(ACTION_PERMISSION_REVOCATION_SETTINGS).setData(Uri.fromParts("package", "com.example", null)), 0).iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        String r12 = r11.next().activityInfo.packageName;
        if (r5.checkPermission("android.permission.PACKAGE_VERIFICATION_AGENT", r12) != 0) goto L4;
        if (r10 != null) goto L9;
        r10 = r12;
        goto L4
    L9:
        return r10;
    L11:
        return r10;
    }

    @NonNull
    public static w0 getUnusedAppRestrictionsStatus(@NonNull Context r5) {
        ResolvableFuture r10 = ResolvableFuture.create();
        if (UserManagerCompat.isUserUnlocked(r5) == true) goto L7;
        r10.set(0);
        Log.e(LOG_TAG, "User is in locked direct boot mode");
        return r10;
    L7:
        if (areUnusedAppRestrictionsAvailable(r5.getPackageManager()) == true) goto L10;
        r10.set(1);
        return r10;
    L10:
        int r11 = r5.getApplicationInfo().targetSdkVersion;
        if (r11 >= 30) goto L15;
        r10.set(0);
        Log.e(LOG_TAG, "Target SDK version below API 30");
        return r10;
    L15:
        if (Api30Impl.areUnusedAppRestrictionsEnabled(r5) == true) goto L17;
        r10.set(2);
    L22:
        return r10;
    L17:
        if (r11 < 31) goto L19;
        int r12 = 5;
    L20:
        r10.set(Integer.valueOf(r12));
        goto L22
    L19:
        r12 = 4;
        goto L20
    }
}
