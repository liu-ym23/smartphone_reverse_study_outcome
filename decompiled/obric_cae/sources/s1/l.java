package s1;

import android.net.ConnectivityManager;

/* JADX INFO: loaded from: classes.dex */
public final class l {
    public static final void a(ConnectivityManager r8, ConnectivityManager.NetworkCallback r10) {
        he.i.f(r8, "<this>");
        he.i.f(r10, "networkCallback");
        r8.registerDefaultNetworkCallback(r10);
    }
}
