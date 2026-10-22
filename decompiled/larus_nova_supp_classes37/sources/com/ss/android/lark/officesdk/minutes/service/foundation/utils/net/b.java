package com.ss.android.lark.officesdk.minutes.service.foundation.utils.net;

import android.net.ConnectivityManager;
import android.net.Network;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b extends ConnectivityManager.NetworkCallback {
    public b() {
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network r2) {
        Intrinsics.checkNotNullParameter(r2, "network");
        MmNetworkUtils.a(true, "system_callback_available");
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network r2) {
        Intrinsics.checkNotNullParameter(r2, "network");
        MmNetworkUtils.a(false, "system_callback_lost");
    }
}
