package com.bytedance.crash.upload;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import com.bytedance.crash.Global;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
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

    public static void registerNetAvailableCallback(INetworkAvailableCallback r3) {
        INetworkAvailableCallback r4 = (INetworkAvailableCallback) ZeusTransformUtils.wrapperContextForParams(r3, INetworkAvailableCallback.class, "com.obric.memorydata.plugin");
        if (mCallbacks != null) goto L7;
        mCallbacks = new CopyOnWriteArrayList();     // Catch: Throwable -> L14
    L7:
        if (mCallbacks.isEmpty() == true) goto L9;
    L12:
        mCallbacks.add(r4);     // Catch: Throwable -> L14
        return;
    L9:
        if (mConnectivityManager != null) goto L11;
        mConnectivityManager = (ConnectivityManager) ZeusTransformUtils.preCheckCast((ConnectivityManager) ZeusTransformUtils.preCheckCast(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin"), ConnectivityManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
    L11:
        NetworkRequest r0 = new NetworkRequest.Builder().addCapability(12).build();     // Catch: Throwable -> L14
        mConnectivityManager.registerNetworkCallback(r0, mNetworkCallback);     // Catch: Throwable -> L14
    }
}
