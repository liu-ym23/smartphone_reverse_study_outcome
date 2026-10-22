package com.ttnet.org.chromium.net;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class AndroidNetworkLibrary$1 extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ ConnectivityManager val$cm;

    public AndroidNetworkLibrary$1(ConnectivityManager r1) {
        this.val$cm = r1;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network r3) {
        NetworkCapabilities r4 = this.val$cm.getNetworkCapabilities(r3);
        if (r4 != null) goto L5;
    L9:
        AndroidNetworkLibraryJni.get().onCellularAlwaysUp(false, 8);
        return;
    L5:
        if (r4.hasTransport(0) == false) goto L9;
        if (r4.hasCapability(12) == false) goto L9;
        AndroidNetworkLibraryJni.get().onCellularAlwaysUp(true, -1);
    }
}
