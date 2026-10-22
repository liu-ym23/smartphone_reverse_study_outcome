package com.larus.dora.impl.core;

import android.net.ConnectivityManager;
import android.net.Network;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class w0 extends ConnectivityManager.NetworkCallback {
    public w0() {
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network r2) {
        Intrinsics.checkNotNullParameter(r2, "network");
        super.onAvailable(r2);
        g49.d.a("DoraSyncManager", "Network is connected");
        CoroutineScope r3 = DoraSyncManager.a;
        DoraSyncManager.c("4");
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network r2) {
        Intrinsics.checkNotNullParameter(r2, "network");
        super.onLost(r2);
        g49.d.a("DoraSyncManager", "Network is disconnected");
    }
}
