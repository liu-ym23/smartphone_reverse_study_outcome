package com.bytedance.ai.bridge.method.net;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c extends ConnectivityManager.NetworkCallback {
    public c() {
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onUnavailable() {
        d.a();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network r10) {
        Intrinsics.checkNotNullParameter(r10, "network");
        d.a();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network r10) {
        Intrinsics.checkNotNullParameter(r10, "network");
        d.a();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network r10, NetworkCapabilities r11) {
        Intrinsics.checkNotNullParameter(r10, "network");
        Intrinsics.checkNotNullParameter(r11, "networkCapabilities");
        d.a();
    }
}
