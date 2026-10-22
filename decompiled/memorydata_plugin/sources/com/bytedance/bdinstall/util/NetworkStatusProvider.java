package com.bytedance.bdinstall.util;

import android.content.Context;
import android.content.IntentFilter;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.common.utility.NetworkUtils;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class NetworkStatusProvider {
    public static final String TAG = "NetworkStatusProvider ";
    private static volatile NetworkStatusProvider instance;
    private static volatile NetworkUtils.NetworkType networkType;
    private static volatile PluginBroadcastReceiver receiver;
    private static final AtomicInteger sInit = null;
    private Context mContext;

    static {
        networkType = NetworkUtils.NetworkType.MOBILE;
        sInit = new AtomicInteger(0);
    }

    private NetworkStatusProvider(Context r3) {
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        init();
    }

    static /* synthetic */ NetworkUtils.NetworkType access$000() {
        return networkType;
    }

    static /* synthetic */ NetworkUtils.NetworkType access$002(NetworkUtils.NetworkType r0) {
        networkType = r0;
        return r0;
    }

    static /* synthetic */ Context access$100(NetworkStatusProvider r0) {
        return r0.mContext;
    }

    public static NetworkStatusProvider getInstance(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (instance != null) goto L15;
        monitor-enter(NetworkStatusProvider.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new NetworkStatusProvider(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(NetworkStatusProvider.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public static void incrementReferenceCount() {
        sInit.incrementAndGet();
        DrLog.d("NetworkStatusProvider increment reference count");
    }

    private void init() {
        DrLog.d("NetworkStatusProvider init monitor...");
        networkType = NetworkUtils.e(this.mContext);
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        receiver = new AnonymousClass1(this);
        ZeusTransformUtils.registerReceiver(this.mContext, receiver, r0, "com.obric.memorydata.plugin");
    }

    public static NetworkStatusProvider instance() {
        return instance;
    }

    public NetworkUtils.NetworkType getNetworkType() {
        return networkType;
    }

    public synchronized void stop() {
        monitor-enter(this);
        AtomicInteger r0 = sInit;     // Catch: Throwable -> L15
        if (r0.get() != 1) goto L10;
        if (receiver == null) goto L10;
        ZeusTransformUtils.unregisterReceiver(this.mContext, receiver, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        receiver = null;     // Catch: Throwable -> L15
        r0.decrementAndGet();     // Catch: Throwable -> L15
        String r1 = "NetworkStatusProvider stop monitor";
    L8:
        DrLog.d(r1);     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L10:
        if (r0.get() <= 0) goto L13;
        r0.decrementAndGet();     // Catch: Throwable -> L15
        r1 = "NetworkStatusProvider decrement reference count";
    L15:
        th = move-exception;
        throw th;
    }
}
