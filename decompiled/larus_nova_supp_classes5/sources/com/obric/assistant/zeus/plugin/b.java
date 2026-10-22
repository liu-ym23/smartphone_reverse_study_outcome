package com.obric.assistant.zeus.plugin;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b extends ConnectivityManager.NetworkCallback {
    public final /* synthetic */ ConnectivityManager a;

    public b(ConnectivityManager r1) {
        this.a = r1;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network r3) {
        Intrinsics.checkNotNullParameter(r3, "network");
        super.onAvailable(r3);
        NetworkCapabilities r4 = this.a.getNetworkCapabilities(r3);
        if (r4 == null) goto L7;
        boolean r0 = true;
        if (r4.hasTransport(1) != true) goto L7;
    L8:
        if (r0 == true) goto L10;
        return;
    L10:
        if (r4.hasCapability(11) == false) goto L14;
        FLogger.a.i("ZeusAutoFetchManager", "Connected to unmetered WiFi, triggering fetch for all plugins");
        c r5 = c.a;
        c.c("unmetered_wifi_available");
        return;
    L14:
        return;
    L7:
        r0 = false;
        goto L8
    }
}
