package com.larus.dora.impl.ota.network;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import com.larus.dora.impl.ota.n;
import g49.d;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final Lazy a = null;
    public static final CopyOnWriteArraySet<c> b = null;
    public static final CoroutineScope c = null;
    public static final a d = null;

    public static final class a extends ConnectivityManager.NetworkCallback {
        public a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(Network r3) {
            Intrinsics.checkNotNullParameter(r3, "network");
            super.onAvailable(r3);
            NetworkCapabilities r4 = ((ConnectivityManager) b.a.getValue()).getNetworkCapabilities(r3);
            if (r4 != null) goto L6;
            d.d("DoraOTANetworkHelper", "Network capabilities is null");
            return;
        L6:
            if (r4.hasTransport(1) == false) goto L9;
            d.d("DoraOTANetworkHelper", "Switched to WiFi");
            return;
        L9:
            if (r4.hasTransport(0) == false) goto L14;
            d.d("DoraOTANetworkHelper", "Switched to Cellular (4G/3G etc.)");
            Iterator<c> r5 = b.b.iterator();
        L12:
            if (r5.hasNext() == false) goto L19;
            r5.next().a();
            goto L12
        L19:
            return;
        L14:
            d.d("DoraOTANetworkHelper", "Other network type");
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLost(Network r3) {
            Intrinsics.checkNotNullParameter(r3, "network");
            super.onLost(r3);
            d.d("DoraOTANetworkHelper", "Network lost: " + r3);
        }
    }

    static {
        Lazy r0 = LazyKt.lazy(new com.larus.dora.impl.ota.network.a());
        a = r0;
        b = new CopyOnWriteArraySet();
        c = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        a r1 = new a();
        d = r1;
        d.d("DoraOTANetworkHelper", "registerNetworkCallback");
        d.d("DoraOTANetworkHelper", "unregisterNetworkCallback");
        ((ConnectivityManager) r0.getValue()).unregisterNetworkCallback(r1);     // Catch: Exception -> L5
    L14:
        NetworkRequest r2 = new NetworkRequest.Builder().addTransportType(1).addTransportType(0).build();     // Catch: Exception -> L9
        ((ConnectivityManager) a.getValue()).registerNetworkCallback(r2, d);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        d.c("DoraOTANetworkHelper", "registerNetworkCallback ERROR", e);
        return;
    L5:
        e = move-exception;
        d.c("DoraOTANetworkHelper", "unregisterNetworkCallback ERROR", e);
        goto L14
    }

    public static Job a(n r7) {
        Intrinsics.checkNotNullParameter(r7, "callback");
        return BuildersKt.launch$default(c, null, null, new DoraOTANetworkHelper$postToCheckNetworkNotAvailable$1(r7, null), 3, null);
    }
}
