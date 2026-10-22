package androidx.work.impl.utils;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
@JvmName(name = "NetworkApi21")
public final class NetworkApi21 {
    @DoNotInline
    public static final NetworkCapabilities getNetworkCapabilitiesCompat(ConnectivityManager r10, Network r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getNetworkCapabilities(r11);
    }

    @DoNotInline
    public static final boolean hasCapabilityCompat(NetworkCapabilities r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.hasCapability(r11);
    }

    @DoNotInline
    public static final void unregisterNetworkCallbackCompat(ConnectivityManager r10, ConnectivityManager.NetworkCallback r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "networkCallback");
        r10.unregisterNetworkCallback(r11);
    }
}
