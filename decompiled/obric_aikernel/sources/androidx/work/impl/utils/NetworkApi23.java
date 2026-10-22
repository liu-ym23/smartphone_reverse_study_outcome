package androidx.work.impl.utils;

import android.net.ConnectivityManager;
import android.net.Network;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
@JvmName(name = "NetworkApi23")
public final class NetworkApi23 {
    @DoNotInline
    public static final Network getActiveNetworkCompat(ConnectivityManager r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getActiveNetwork();
    }
}
