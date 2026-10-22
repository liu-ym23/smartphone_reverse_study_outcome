package com.bytedance.crash.upload;

import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import com.bytedance.crash.Global;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class NetWorkManager {
    private static CopyOnWriteArrayList<INetworkAvailableCallback> mCallbacks;
    private static ConnectivityManager mConnectivityManager;
    private static ConnectivityManager.NetworkCallback mNetworkCallback;

    static {
        mNetworkCallback = new AnonymousClass1();
    }

    public NetWorkManager() {
    }

    static /* synthetic */ CopyOnWriteArrayList access$000() {
        return mCallbacks;
    }

    static /* synthetic */ ConnectivityManager access$100() {
        return mConnectivityManager;
    }

    public static void registerNetAvailableCallback(INetworkAvailableCallback r10) {
        if (mCallbacks != null) goto L6;
        mCallbacks = new CopyOnWriteArrayList();     // Catch: Throwable -> L13
    L6:
        if (mCallbacks.isEmpty() == true) goto L8;
    L11:
        mCallbacks.add(r10);     // Catch: Throwable -> L13
        return;
    L8:
        if (mConnectivityManager != null) goto L10;
        mConnectivityManager = (ConnectivityManager) Global.getApplication().getSystemService("connectivity");     // Catch: Throwable -> L13
    L10:
        NetworkRequest r11 = new NetworkRequest.Builder().addCapability(12).build();     // Catch: Throwable -> L13
        mConnectivityManager.registerNetworkCallback(r11, mNetworkCallback);     // Catch: Throwable -> L13
    }
}
