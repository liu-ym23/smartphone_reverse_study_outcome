package com.obric.cae.smartNetwork.networkHandover;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import com.obric.cae.smartNetwork.networkHandoverRL.feedback.WifiCellSwitchMonitor;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkStateMonitor {
    private static final boolean DEBUG = false;
    private static final String TAG = "NetworkStateMonitor";
    private final ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private final Object mLock;
    private ConnectivityManager.NetworkCallback mNetworkCallback;
    private final NetworkL4QoEMonitor mNetworkL4QoEMonitor;
    private final NetworkPolicyCenter mNetworkPolicyCenter;
    private NetworkRequest mNetworkRequest;
    private final TrafficStatsMonitor mTrafficStatsMonitor;
    private final WifiCellSwitchMonitor mWifiCellSwitchMonitor;

    public NetworkStateMonitor(Context r8, NetworkPolicyCenter r10, NetworkL4QoEMonitor r11, TrafficStatsMonitor r12) {
        this.mNetworkRequest = new NetworkRequest.Builder().addCapability(12).build();
        this.mNetworkCallback = new AnonymousClass1(this);
        this.mContext = r8;
        this.mConnectivityManager = (ConnectivityManager) r8.getSystemService("connectivity");
        this.mNetworkPolicyCenter = r10;
        this.mNetworkL4QoEMonitor = r11;
        this.mTrafficStatsMonitor = r12;
        this.mWifiCellSwitchMonitor = WifiCellSwitchMonitor.getInstance(r8);
        this.mLock = new Object();
    }

    public static /* synthetic */ Object access$000(NetworkStateMonitor r8) {
        return r8.mLock;
    }

    public static /* synthetic */ Context access$100(NetworkStateMonitor r8) {
        return r8.mContext;
    }

    public static /* synthetic */ NetworkPolicyCenter access$200(NetworkStateMonitor r8) {
        return r8.mNetworkPolicyCenter;
    }

    public static /* synthetic */ NetworkL4QoEMonitor access$300(NetworkStateMonitor r8) {
        return r8.mNetworkL4QoEMonitor;
    }

    public static /* synthetic */ TrafficStatsMonitor access$400(NetworkStateMonitor r8) {
        return r8.mTrafficStatsMonitor;
    }

    public static /* synthetic */ WifiCellSwitchMonitor access$500(NetworkStateMonitor r8) {
        return r8.mWifiCellSwitchMonitor;
    }

    public void start() {
        this.mConnectivityManager.registerNetworkCallback(this.mNetworkRequest, this.mNetworkCallback);
    }

    public void stop() {
        this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
        this.mWifiCellSwitchMonitor.release();
    }
}
