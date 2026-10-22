package com.bytedance.bdlocation.scan.networklistener;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.bytedance.bdlocation.log.Logger;

/* JADX INFO: loaded from: classes.dex */
public class NetworkCallbackImpl extends ConnectivityManager.NetworkCallback {
    private Network lastNetWork;

    public NetworkCallbackImpl() {
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network r1) {
        super.onAvailable(r1);
        Logger.i("NetworkCallback:onAvailable: 网络已连接");
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network r3, NetworkCapabilities r4) {
        super.onCapabilitiesChanged(r3, r4);
        if (r3 == null) goto L20;
        if (r4 == null) goto L21;
        Logger.i(NetworkManager.TAG + ":NetworkCallback:onCapabilitiesChanged network：" + r3.toString());
        if (this.lastNetWork == null) goto L10;
        Logger.i(NetworkManager.TAG + ":NetworkCallback:onCapabilitiesChanged lastNetWork：" + this.lastNetWork.toString());
    L10:
        if (r3.equals(this.lastNetWork) == false) goto L18;
        Logger.i(NetworkManager.TAG + ":NetworkCallback:onCapabilitiesChanged: 相同network");
        return;
    L18:
        Logger.i(NetworkManager.TAG + ":NetworkCallback:resetPollUploadScheduleNetWorkChange");     // Catch: Exception -> L15
        NetworkManager.getInstance().notifyWifiChanged(r3, r4);     // Catch: Exception -> L15
        this.lastNetWork = r3;     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        Logger.e(NetworkManager.TAG + ":NetworkCallback:onCapabilitiesChanged error", e);
        return;
    L21:
        return;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network r1) {
        super.onLost(r1);
        Logger.i("NetworkCallback:onLost: 网络已断开");
    }
}
