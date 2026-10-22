package s1;

import android.net.ConnectivityManager;
import android.net.Network;

/* JADX INFO: loaded from: classes.dex */
public final class k {
    public static final Network a(ConnectivityManager r8) {
        he.i.f(r8, "<this>");
        return r8.getActiveNetwork();
    }
}
