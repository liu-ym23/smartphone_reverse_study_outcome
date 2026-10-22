package com.bytedance.bdlocation.scan.networklistener;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    private static class SingletonHolder {
        private static NetworkManager instance;

        static {
            instance = new NetworkManager(null);
        }

        private SingletonHolder() {
        }

        static /* synthetic */ NetworkManager access$000() {
            return instance;
        }
    }

    static {
    }

    private NetworkManager() {
        this.mNetworkCallbackLock = new Object();
        this.mListeners = new ArrayList();
        this.mReceiver = new NetworkChangeReceiver();
        if (Build.VERSION.SDK_INT < 21) goto L6;
        this.mNetworkCallback = new AnonymousClass1(this);
        return;
    }

    /* synthetic */ NetworkManager(AnonymousClass1 r1) {
        this();
    }

    public static NetworkManager getInstance() {
        return SingletonHolder.access$000();
    }

    public List<WifiChangeListener> getListener() {
        return this.mListeners;
    }

    public void notifyWifiChanged(Network r4, NetworkCapabilities r5) {
        List<WifiChangeListener> r0 = this.mListeners;     // Catch: Exception -> L13
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() <= 0) goto L24;
        Iterator<WifiChangeListener> r3 = this.mListeners.iterator();     // Catch: Exception -> L13
    L8:
        if (r3.hasNext() == false) goto L25;
        WifiChangeListener r1 = (WifiChangeListener) ZeusTransformUtils.preCheckCast(r3.next(), WifiChangeListener.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L13
        if (Build.VERSION.SDK_INT < 21) goto L8;
        r1.notifyWifiChanged(r4, r5);     // Catch: Exception -> L13
        goto L8
    L25:
        return;
    L24:
        return;
    L13:
        e = move-exception;
        Logger.e("notifyWifiChanged error", e);
    }

    public void notifyWifiChangedTwo(NetworkInfo r4) {
        List<WifiChangeListener> r0 = this.mListeners;     // Catch: Exception -> L11
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() <= 0) goto L19;
        Iterator<WifiChangeListener> r3 = this.mListeners.iterator();     // Catch: Exception -> L11
    L8:
        if (r3.hasNext() == false) goto L20;
        ((WifiChangeListener) ZeusTransformUtils.preCheckCast(r3.next(), WifiChangeListener.class, "com.obric.memorydata.plugin")).notifyWifiChangedTwo(r4);     // Catch: Exception -> L11
        goto L8
    L20:
        return;
    L19:
        return;
    L11:
        e = move-exception;
        Logger.e("notifyWifiChangedTwo error", e);
    }

    public void registerNetworkCallback(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        if (BDLocationConfig.enableStationaryScenePolicy() == true) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 21) goto L27;
        Object r0 = this.mNetworkCallbackLock;
        monitor-enter(r0);
    L24:
        th = move-exception;
        throw th;
    L10:
        if (this.isRegisterNetworkCallback == false) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L24
        return;
    L14:
        if (this.mNetworkCallback != null) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L24
        return;
    L17:
        Logger.i("registerNetworkCallback");     // Catch: Throwable -> L24
        NetworkRequest r1 = new NetworkRequest.Builder().addTransportType(1).build();     // Catch: Exception -> L20 Throwable -> L24
        ((ConnectivityManager) ZeusTransformUtils.preCheckCast(r7.getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin")).registerNetworkCallback(r1, this.mNetworkCallback);     // Catch: Exception -> L20 Throwable -> L24
        this.isRegisterNetworkCallback = true;     // Catch: Exception -> L20 Throwable -> L24
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L24
        return;
    L20:
        e = move-exception;
        LocationMonitor.registerNetworkCallbackError("registerNetworkCallback", e);     // Catch: Throwable -> L24
        Logger.e("registerNetworkCallback error", e);     // Catch: Throwable -> L24
        goto L22
    }

    public void registerObserver(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Logger.i("WifiCollect:register network mIsRegister is:" + this.mIsRegister);
        if (this.mIsRegister == false) goto L10;
        return;
    L10:
        IntentFilter r0 = new IntentFilter();     // Catch: Throwable -> L7
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Throwable -> L7
        this.mReceiver.doRegister(true);     // Catch: Throwable -> L7
        ZeusTransformUtils.registerReceiver(r6, this.mReceiver, r0, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        this.mIsRegister = true;     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Logger.e("WifiCollect register network change error", th);
    }

    public void setListener(WifiChangeListener r3) {
        WifiChangeListener r4 = (WifiChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, WifiChangeListener.class, "com.obric.memorydata.plugin");
        this.mListeners.add(r4);
    }

    public void unRegisterObserver(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Logger.i("WifiCollect:unregister network mIsRegister is:" + this.mIsRegister);
        if (this.mIsRegister == true) goto L5;
        return;
    L5:
        if (r5 == null) goto L15;
        NetworkChangeReceiver r0 = this.mReceiver;     // Catch: Exception -> L10
        if (r0 == null) goto L16;
        ZeusTransformUtils.unregisterReceiver(r5, r0, "com.obric.memorydata.plugin");     // Catch: Exception -> L10
        this.mIsRegister = false;     // Catch: Exception -> L10
        return;
    L16:
        return;
    L10:
        e = move-exception;
        Logger.e("WifiCollect:unregister network change error", e);
        return;
    }

    public void unregisterNetworkCallback(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (BDLocationConfig.enableStationaryScenePolicy() == true) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 21) goto L27;
        Object r0 = this.mNetworkCallbackLock;
        monitor-enter(r0);
    L24:
        th = move-exception;
        throw th;
    L10:
        if (this.isRegisterNetworkCallback == true) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L24
        return;
    L14:
        if (this.mNetworkCallback != null) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L24
        return;
    L17:
        Logger.i("unregisterNetworkCallback");     // Catch: Throwable -> L24
        ((ConnectivityManager) ZeusTransformUtils.preCheckCast(r5.getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin")).unregisterNetworkCallback(this.mNetworkCallback);     // Catch: Exception -> L20 Throwable -> L24
        this.isRegisterNetworkCallback = false;     // Catch: Exception -> L20 Throwable -> L24
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L24
        return;
    L20:
        e = move-exception;
        LocationMonitor.registerNetworkCallbackError("unregisterNetworkCallback", e);     // Catch: Throwable -> L24
        Logger.e("unregisterNetworkCallback error", e);     // Catch: Throwable -> L24
        goto L22
    }
}
