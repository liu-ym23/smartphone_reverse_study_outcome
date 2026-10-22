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
    public void onAvailable(Network r8) {
        super.onAvailable(r8);
        Logger.i("NetworkCallback:onAvailable: 网络已连接");
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network r8, NetworkCapabilities r10) {
        super.onCapabilitiesChanged(r8, r10);
        if (r8 == null) goto L20;
        if (r10 == null) goto L21;
        Logger.i(NetworkManager.TAG + ":NetworkCallback:onCapabilitiesChanged network：" + r8.toString());
        if (this.lastNetWork == null) goto L10;
        Logger.i(NetworkManager.TAG + ":NetworkCallback:onCapabilitiesChanged lastNetWork：" + this.lastNetWork.toString());
    L10:
        if (r8.equals(this.lastNetWork) == false) goto L18;
        Logger.i(NetworkManager.TAG + ":NetworkCallback:onCapabilitiesChanged: 相同network");
        return;
    L18:
        Logger.i(NetworkManager.TAG + ":NetworkCallback:resetPollUploadScheduleNetWorkChange");     // Catch: Exception -> L15
        NetworkManager.getInstance().notifyWifiChanged(r8, r10);     // Catch: Exception -> L15
        this.lastNetWork = r8;     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        Logger.e(NetworkManager.TAG + ":NetworkCallback:onCapabilitiesChanged error", e);
        return;
    L21:
        return;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network r8) {
        super.onLost(r8);
        Logger.i("NetworkCallback:onLost: 网络已断开");
    }
}
