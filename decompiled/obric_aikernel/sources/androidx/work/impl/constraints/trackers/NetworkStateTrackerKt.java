package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.core.net.ConnectivityManagerCompat;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.NetworkApi21;
import androidx.work.impl.utils.NetworkApi23;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class NetworkStateTrackerKt {
    private static final String TAG = null;

    static {
        String r10 = Logger.tagWithPrefix("NetworkStateTracker");
        Intrinsics.checkNotNullExpressionValue(r10, "tagWithPrefix(\"NetworkStateTracker\")");
        TAG = r10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final ConstraintTracker<NetworkState> NetworkStateTracker(Context r10, TaskExecutor r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "taskExecutor");
        if (Build.VERSION.SDK_INT < 24) goto L6;
        return new NetworkStateTracker24(r10, r11);
    L6:
        return new NetworkStateTrackerPre24(r10, r11);
    }

    public static final /* synthetic */ String access$getTAG$p() {
        return TAG;
    }

    public static final NetworkState getActiveNetworkState(ConnectivityManager r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        NetworkInfo r11 = r10.getActiveNetworkInfo();
        boolean r12 = true;
        if (r11 != null) goto L5;
    L7:
        boolean r13 = false;
    L8:
        boolean r14 = isActiveNetworkValidated(r10);
        boolean r15 = ConnectivityManagerCompat.isActiveNetworkMetered(r10);
        if (r11 != null) goto L11;
    L13:
        r12 = false;
    L15:
        return new NetworkState(r13, r14, r15, r12);
    L11:
        if (r11.isRoaming() == true) goto L13;
    L5:
        if (r11.isConnected() == false) goto L7;
        r13 = true;
        goto L8
    }

    public static /* synthetic */ void getActiveNetworkState$annotations(ConnectivityManager r10) {
    }

    public static final boolean isActiveNetworkValidated(ConnectivityManager r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (Build.VERSION.SDK_INT < 23) goto L15;
        NetworkCapabilities r11 = NetworkApi21.getNetworkCapabilitiesCompat(r10, NetworkApi23.getActiveNetworkCompat(r10));     // Catch: SecurityException -> L9
        if (r11 == null) goto L14;
        return NetworkApi21.hasCapabilityCompat(r11, 16);
    L14:
        return false;
    L9:
        e = move-exception;
        Logger.get().error(TAG, "Unable to validate active network", e);
        return false;
    L15:
        return false;
    }
}
