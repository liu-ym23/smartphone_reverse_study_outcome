package com.obric.cae.smartNetwork.multipath;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import com.obric.cae.log.CaeLog;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class LinkLayerMonitor {
    private static final String TAG = "LinkLayerMonitor";
    private boolean mCellConnected;
    private boolean mCellValidated;
    private final ConnectivityManager mConnectivityManager;
    private Context mContext;
    private final Set<NetworkAvailableListener> mListenerSet;
    private Network mMobileNetwork;
    private ConnectivityManager.NetworkCallback mNetworkCallback;
    private NetworkRequest mNetworkRequest;
    private Network mWifiNetwork;
    private boolean mWlanConnected;
    private boolean mWlanValidated;

    public interface NetworkAvailableListener {
        void onCellAvailableChanged(boolean r8, boolean r10);

        void onWifiAvailableChanged(boolean r8, boolean r10);
    }

    public LinkLayerMonitor(Context r8) {
        this.mWifiNetwork = null;
        this.mMobileNetwork = null;
        this.mWlanValidated = false;
        this.mWlanConnected = false;
        this.mCellConnected = false;
        this.mCellValidated = false;
        this.mListenerSet = Collections.synchronizedSet(new HashSet());
        this.mNetworkRequest = new NetworkRequest.Builder().addCapability(12).build();
        this.mNetworkCallback = new AnonymousClass1(this);
        this.mContext = r8;
        this.mConnectivityManager = (ConnectivityManager) r8.getSystemService("connectivity");
    }

    public static /* synthetic */ void access$000(LinkLayerMonitor r8, Network r10, boolean r11) {
        r8.updateNetwork(r10, r11);
    }

    public static /* synthetic */ void access$100(LinkLayerMonitor r8, Network r10, NetworkCapabilities r11) {
        r8.updateValidated(r10, r11);
    }

    private void notifyAvailableChanged(int r8, boolean r10, boolean r11) {
        Set<NetworkAvailableListener> r12 = this.mListenerSet;
        monitor-enter(r12);
        Iterator<NetworkAvailableListener> r13 = this.mListenerSet.iterator();     // Catch: Throwable -> L14
    L6:
        if (r13.hasNext() == false) goto L12;
        NetworkAvailableListener r14 = r13.next();     // Catch: Throwable -> L14
        if (r8 == 1) goto L9;
        if (r8 != 0) goto L6;
        r14.onCellAvailableChanged(r10, r11);     // Catch: Throwable -> L14
        goto L6
    L9:
        r14.onWifiAvailableChanged(r10, r11);     // Catch: Throwable -> L14
        goto L6
    L12:
        monitor-exit(r12);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void updateNetwork(Network r8, boolean r10) {
        if (r10 == false) goto L14;
        NetworkInfo r11 = this.mConnectivityManager.getNetworkInfo(r8);
        if (r11 != null) goto L7;
        return;
    L7:
        int r12 = r11.getType();
        if (r12 == 0) goto L12;
        if (r12 != 1) goto L24;
        CaeLog.d(TAG, "add wifi network, netId: " + r8.toString());
        this.mWifiNetwork = r8;
        this.mWlanConnected = true;
        notifyAvailableChanged(1, true, this.mWlanValidated);
        return;
    L24:
        return;
    L12:
        CaeLog.d(TAG, "add mobile network, netId: " + r8.toString());
        this.mMobileNetwork = r8;
        this.mCellConnected = true;
        notifyAvailableChanged(0, true, this.mCellValidated);
        return;
    L14:
        if (r8.equals(this.mWifiNetwork) == false) goto L17;
        CaeLog.d(TAG, "remove wifi network, netId: " + r8.toString());
        this.mWifiNetwork = null;
        this.mWlanConnected = false;
        this.mWlanValidated = false;
        notifyAvailableChanged(1, false, false);
        return;
    L17:
        if (r8.equals(this.mMobileNetwork) == false) goto L23;
        CaeLog.d(TAG, "remove mobile network, netId: " + r8.toString());
        this.mMobileNetwork = null;
        this.mCellConnected = false;
        this.mCellValidated = false;
        notifyAvailableChanged(0, false, false);
        return;
    }

    private void updateValidated(Network r8, NetworkCapabilities r10) {
        if (r8 != null) goto L5;
    L9:
        if (r8 != null) goto L11;
        return;
    L11:
        if (r8.equals(this.mMobileNetwork) == false) goto L19;
        boolean r11 = r10.hasCapability(16);
        if (this.mCellValidated == r11) goto L20;
        CaeLog.d(TAG, "mobile network validated changed, netId: " + r8.toString() + ", validated: " + r11);
        this.mCellValidated = r11;
        int r12 = 0;
        boolean r13 = this.mCellConnected;
    L15:
        notifyAvailableChanged(r12, r13, r11);
        return;
    L20:
        return;
    L19:
        return;
    L5:
        if (r8.equals(this.mWifiNetwork) == false) goto L9;
        r11 = r10.hasCapability(16);
        if (this.mWlanValidated == r11) goto L17;
        CaeLog.d(TAG, "wifi network validated changed, netId: " + r8.toString() + ", validated: " + r11);
        this.mWlanValidated = r11;
        r12 = 1;
        r13 = this.mWlanConnected;
        goto L15
    }

    public boolean isCellAvailable() {
        if (this.mCellConnected == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mCellValidated == false) goto L7;
        return true;
    }

    public boolean isWifiAvailable() {
        if (this.mWlanConnected == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mWlanValidated == false) goto L7;
        return true;
    }

    public void registerListener(NetworkAvailableListener r8) {
        this.mListenerSet.add(r8);
    }

    public void start() {
        CaeLog.d(TAG, "start monitor link layer.");
        this.mConnectivityManager.registerNetworkCallback(this.mNetworkRequest, this.mNetworkCallback);
    }

    public void stop() {
        CaeLog.d(TAG, "stop monitor link layer.");
        this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
    }

    public void unregisterListener(NetworkAvailableListener r8) {
        this.mListenerSet.remove(r8);
    }
}
