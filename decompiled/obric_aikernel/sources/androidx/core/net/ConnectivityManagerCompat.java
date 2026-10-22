package androidx.core.net;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class ConnectivityManagerCompat {
    public static final int RESTRICT_BACKGROUND_STATUS_DISABLED = 1;
    public static final int RESTRICT_BACKGROUND_STATUS_ENABLED = 3;
    public static final int RESTRICT_BACKGROUND_STATUS_WHITELISTED = 2;

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
        @DoNotInline
        static boolean isActiveNetworkMetered(ConnectivityManager r10) {
            return r10.isActiveNetworkMetered();
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static int getRestrictBackgroundStatus(ConnectivityManager r10) {
            return r10.getRestrictBackgroundStatus();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface RestrictBackgroundStatus {
    }

    private ConnectivityManagerCompat() {
    }

    @Nullable
    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    @SuppressLint({"ReferencesDeprecated"})
    public static NetworkInfo getNetworkInfoFromBroadcast(@NonNull ConnectivityManager r10, @NonNull Intent r11) {
        NetworkInfo r12 = (NetworkInfo) r11.getParcelableExtra("networkInfo");
        if (r12 != null) goto L5;
        return null;
    L5:
        return r10.getNetworkInfo(r12.getType());
    }

    public static int getRestrictBackgroundStatus(@NonNull ConnectivityManager r10) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return 3;
    L5:
        return Api24Impl.getRestrictBackgroundStatus(r10);
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static boolean isActiveNetworkMetered(@NonNull ConnectivityManager r10) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        NetworkInfo r11 = r10.getActiveNetworkInfo();
        if (r11 != null) goto L9;
        return true;
    L9:
        int r12 = r11.getType();
        if (r12 != 1) goto L12;
        return false;
    L12:
        if (r12 != 7) goto L14;
        return false;
    L14:
        if (r12 == 9) goto L19;
        return true;
    L19:
        return false;
    L5:
        return Api16Impl.isActiveNetworkMetered(r10);
    }
}
