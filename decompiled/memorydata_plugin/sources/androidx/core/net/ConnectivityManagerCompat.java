package androidx.core.net;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class ConnectivityManagerCompat {
    public static final int RESTRICT_BACKGROUND_STATUS_DISABLED = 1;
    public static final int RESTRICT_BACKGROUND_STATUS_ENABLED = 3;
    public static final int RESTRICT_BACKGROUND_STATUS_WHITELISTED = 2;

    static class Api16Impl {
        private Api16Impl() {
        }

        static boolean isActiveNetworkMetered(ConnectivityManager r0) {
            return r0.isActiveNetworkMetered();
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static int getRestrictBackgroundStatus(ConnectivityManager r0) {
            return r0.getRestrictBackgroundStatus();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RestrictBackgroundStatus {
    }

    private ConnectivityManagerCompat() {
    }

    public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager r2, Intent r3) {
        NetworkInfo r4 = (NetworkInfo) ZeusTransformUtils.preCheckCast(r3.getParcelableExtra("networkInfo"), NetworkInfo.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return null;
    L5:
        return r2.getNetworkInfo(r4.getType());
    }

    public static int getRestrictBackgroundStatus(ConnectivityManager r2) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return 3;
    L5:
        return Api24Impl.getRestrictBackgroundStatus(r2);
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager r2) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        NetworkInfo r3 = r2.getActiveNetworkInfo();
        if (r3 != null) goto L9;
        return true;
    L9:
        int r4 = r3.getType();
        if (r4 != 1) goto L12;
        return false;
    L12:
        if (r4 != 7) goto L14;
        return false;
    L14:
        if (r4 == 9) goto L19;
        return true;
    L19:
        return false;
    L5:
        return Api16Impl.isActiveNetworkMetered(r2);
    }
}
