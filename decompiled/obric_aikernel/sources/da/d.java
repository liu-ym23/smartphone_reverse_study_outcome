package da;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import java.util.Objects;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    static {
        new d();
    }

    private d() {
    }

    @JvmStatic
    public static final boolean a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Object r11 = r10.getSystemService("connectivity");
        Objects.requireNonNull(r11, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager r12 = (ConnectivityManager) r11;
        Network r13 = r12.getActiveNetwork();
        if (r13 == null) goto L15;
        Intrinsics.checkNotNullExpressionValue(r13, "connectivityManager.activeNetwork ?: return false");
        NetworkCapabilities r14 = r12.getNetworkCapabilities(r13);
        if (r14 == null) goto L16;
        Intrinsics.checkNotNullExpressionValue(r14, "connectivityManager.getN…          ?: return false");
        if (r14.hasTransport(1) == false) goto L10;
    L17:
        return true;
    L10:
        if (r14.hasTransport(0) == true) goto L17;
        if (r14.hasTransport(3) == true) goto L17;
        return false;
    L16:
        return false;
    L15:
        return false;
    }
}
