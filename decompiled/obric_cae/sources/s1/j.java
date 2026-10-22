package s1;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* JADX INFO: loaded from: classes.dex */
public final class j {
    public static final NetworkCapabilities a(ConnectivityManager r8, Network r10) {
        he.i.f(r8, "<this>");
        return r8.getNetworkCapabilities(r10);
    }

    public static final boolean b(NetworkCapabilities r8, int r10) {
        he.i.f(r8, "<this>");
        return r8.hasCapability(r10);
    }

    public static final void c(ConnectivityManager r8, ConnectivityManager.NetworkCallback r10) {
        he.i.f(r8, "<this>");
        he.i.f(r10, "networkCallback");
        r8.unregisterNetworkCallback(r10);
    }
}
