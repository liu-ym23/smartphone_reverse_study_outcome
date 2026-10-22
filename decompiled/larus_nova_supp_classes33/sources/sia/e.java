package sia;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Object r6 = r5.getSystemService("connectivity");     // Catch: Exception -> L19
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Exception -> L19
        ConnectivityManager r7 = (ConnectivityManager) r6;     // Catch: Exception -> L19
        NetworkInfo r1 = r7.getActiveNetworkInfo();     // Catch: Exception -> L19
        if (Build.VERSION.SDK_INT < 23) goto L12;
        Network r2 = r7.getActiveNetwork();     // Catch: Exception -> L19
        if (r2 != null) goto L8;
        return false;
    L8:
        NetworkCapabilities r8 = r7.getNetworkCapabilities(r2);     // Catch: Exception -> L19
        if (r8 != null) goto L11;
        return false;
    L11:
        boolean r9 = r8.hasCapability(16);     // Catch: Exception -> L19
    L13:
        if (r1 == null) goto L22;
        if (r1.isConnected() == false) goto L23;
        if (r9 == false) goto L24;
        return true;
    L24:
        return false;
    L23:
        return false;
    L22:
        return false;
    L12:
        r9 = true;
    L25:
        return false;
    }
}
