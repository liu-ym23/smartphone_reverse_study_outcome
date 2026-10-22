package com.bytedance.bdlocation.scan.networklistener;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NetworkManager {
    public static String TAG = "NetworkManager";
    private volatile boolean isRegisterNetworkCallback;
    private volatile boolean mIsRegister;
    private List<WifiChangeListener> mListeners;
    private ConnectivityManager.NetworkCallback mNetworkCallback;
    private final Object mNetworkCallbackLock;
    private NetworkChangeReceiver mReceiver;

    public static class SingletonHolder {
        private static NetworkManager instance;

        static {
            instance = new NetworkManager(null);
        }

        private SingletonHolder() {
        }

        public static /* synthetic */ NetworkManager access$000() {
            return instance;
        }
    }

    private NetworkManager() {
        this.mNetworkCallbackLock = new Object();
        this.mListeners = new ArrayList();
        this.mReceiver = new NetworkChangeReceiver();
        this.mNetworkCallback = new AnonymousClass1(this);
    }

    public static NetworkManager getInstance() {
        return SingletonHolder.access$000();
    }

    public List<WifiChangeListener> getListener() {
        return this.mListeners;
    }

    public void notifyWifiChanged(Network r8, NetworkCapabilities r10) {
        List<WifiChangeListener> r11 = this.mListeners;     // Catch: Exception -> L11
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.size() <= 0) goto L19;
        Iterator<WifiChangeListener> r12 = this.mListeners.iterator();     // Catch: Exception -> L11
    L8:
        if (r12.hasNext() == false) goto L20;
        r12.next().notifyWifiChanged(r8, r10);     // Catch: Exception -> L11
        goto L8
    L20:
        return;
    L19:
        return;
    L11:
        e = move-exception;
        Logger.e("notifyWifiChanged error", e);
    }

    public void notifyWifiChangedTwo(NetworkInfo r8) {
        List<WifiChangeListener> r10 = this.mListeners;     // Catch: Exception -> L11
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.size() <= 0) goto L19;
        Iterator<WifiChangeListener> r11 = this.mListeners.iterator();     // Catch: Exception -> L11
    L8:
        if (r11.hasNext() == false) goto L20;
        r11.next().notifyWifiChangedTwo(r8);     // Catch: Exception -> L11
        goto L8
    L20:
        return;
    L19:
        return;
    L11:
        e = move-exception;
        Logger.e("notifyWifiChangedTwo error", e);
    }

    public void registerNetworkCallback(Context r8) {
        if (BDLocationConfig.enableStationaryScenePolicy() == true) goto L5;
        return;
    L5:
        Object r10 = this.mNetworkCallbackLock;
        monitor-enter(r10);
    L22:
        th = move-exception;
        throw th;
    L8:
        if (this.isRegisterNetworkCallback == false) goto L12;
        monitor-exit(r10);     // Catch: Throwable -> L22
        return;
    L12:
        if (this.mNetworkCallback != null) goto L15;
        monitor-exit(r10);     // Catch: Throwable -> L22
        return;
    L15:
        Logger.i("registerNetworkCallback");     // Catch: Throwable -> L22
        NetworkRequest r11 = new NetworkRequest.Builder().addTransportType(1).build();     // Catch: Exception -> L18 Throwable -> L22
        ((ConnectivityManager) r8.getSystemService("connectivity")).registerNetworkCallback(r11, this.mNetworkCallback);     // Catch: Exception -> L18 Throwable -> L22
        this.isRegisterNetworkCallback = true;     // Catch: Exception -> L18 Throwable -> L22
    L20:
        monitor-exit(r10);     // Catch: Throwable -> L22
        return;
    L18:
        e = move-exception;
        LocationMonitor.registerNetworkCallbackError("registerNetworkCallback", e);     // Catch: Throwable -> L22
        Logger.e("registerNetworkCallback error", e);     // Catch: Throwable -> L22
        goto L20
    }

    public void registerObserver(Context r8) {
        Logger.i("WifiCollect:register network mIsRegister is:" + this.mIsRegister);
        if (this.mIsRegister == false) goto L10;
        return;
    L10:
        IntentFilter r10 = new IntentFilter();     // Catch: Throwable -> L7
        r10.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Throwable -> L7
        this.mReceiver.doRegister(true);     // Catch: Throwable -> L7
        r8.registerReceiver(this.mReceiver, r10);     // Catch: Throwable -> L7
        this.mIsRegister = true;     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Logger.e("WifiCollect register network change error", th);
    }

    public void setListener(WifiChangeListener r8) {
        this.mListeners.add(r8);
    }

    public void unRegisterObserver(Context r8) {
        Logger.i("WifiCollect:unregister network mIsRegister is:" + this.mIsRegister);
        if (this.mIsRegister == true) goto L5;
        return;
    L5:
        if (r8 == null) goto L15;
        NetworkChangeReceiver r10 = this.mReceiver;     // Catch: Exception -> L10
        if (r10 == null) goto L16;
        r8.unregisterReceiver(r10);     // Catch: Exception -> L10
        this.mIsRegister = false;     // Catch: Exception -> L10
        return;
    L16:
        return;
    L10:
        e = move-exception;
        Logger.e("WifiCollect:unregister network change error", e);
        return;
    }

    public void unregisterNetworkCallback(Context r8) {
        if (BDLocationConfig.enableStationaryScenePolicy() == true) goto L5;
        return;
    L5:
        Object r10 = this.mNetworkCallbackLock;
        monitor-enter(r10);
    L22:
        th = move-exception;
        throw th;
    L8:
        if (this.isRegisterNetworkCallback == true) goto L12;
        monitor-exit(r10);     // Catch: Throwable -> L22
        return;
    L12:
        if (this.mNetworkCallback != null) goto L15;
        monitor-exit(r10);     // Catch: Throwable -> L22
        return;
    L15:
        Logger.i("unregisterNetworkCallback");     // Catch: Throwable -> L22
        ((ConnectivityManager) r8.getSystemService("connectivity")).unregisterNetworkCallback(this.mNetworkCallback);     // Catch: Exception -> L18 Throwable -> L22
        this.isRegisterNetworkCallback = false;     // Catch: Exception -> L18 Throwable -> L22
    L20:
        monitor-exit(r10);     // Catch: Throwable -> L22
        return;
    L18:
        e = move-exception;
        LocationMonitor.registerNetworkCallbackError("unregisterNetworkCallback", e);     // Catch: Throwable -> L22
        Logger.e("unregisterNetworkCallback error", e);     // Catch: Throwable -> L22
        goto L20
    }

    public /* synthetic */ NetworkManager(AnonymousClass1 r8) {
        this();
    }
}
