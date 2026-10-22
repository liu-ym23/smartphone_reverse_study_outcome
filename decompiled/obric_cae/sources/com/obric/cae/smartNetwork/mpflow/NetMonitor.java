package com.obric.cae.smartNetwork.mpflow;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes2.dex */
public class NetMonitor {
    private static final String TAG = "NetMonitor";
    private String mCellularInterfaceName;
    private final ConnectivityManager mConnectivityManager;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private final MpflowInterface mMpflowInterface;
    private final ConnectivityManager.NetworkCallback mNetworkCallback;

    public NetMonitor(Context r8) {
        this.mConnectivityManager = (ConnectivityManager) r8.getSystemService("connectivity");
        this.mNetworkCallback = createNetworkCallback();
        this.mMpflowInterface = new MpflowInterface();
        HandlerThread r10 = new HandlerThread("NetMonitor");
        this.mHandlerThread = r10;
        r10.start();
        this.mHandler = new Handler(r10.getLooper());
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ String access$100(NetMonitor r8) {
        return r8.mCellularInterfaceName;
    }

    public static /* synthetic */ String access$102(NetMonitor r8, String r10) {
        r8.mCellularInterfaceName = r10;
        return r10;
    }

    public static /* synthetic */ ConnectivityManager access$200(NetMonitor r8) {
        return r8.mConnectivityManager;
    }

    public static /* synthetic */ MpflowInterface access$300(NetMonitor r8) {
        return r8.mMpflowInterface;
    }

    private ConnectivityManager.NetworkCallback createNetworkCallback() {
        return new AnonymousClass1(this);
    }

    public void start() {
        NetworkRequest r8 = new NetworkRequest.Builder().addTransportType(0).build();
        ConnectivityManager r10 = this.mConnectivityManager;
        if (r10 == null) goto L6;
        r10.registerNetworkCallback(r8, this.mNetworkCallback, this.mHandler);
        return;
    }

    public void stop() {
        ConnectivityManager r8 = this.mConnectivityManager;
        if (r8 == null) goto L5;
        r8.unregisterNetworkCallback(this.mNetworkCallback);
    L5:
        this.mHandlerThread.quitSafely();
    }
}
