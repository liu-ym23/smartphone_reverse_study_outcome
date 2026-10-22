package com.bytedance.bdinstall.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.common.utility.NetworkUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class NetworkStatusProvider {
    public static final String TAG = "NetworkStatusProvider ";
    private static volatile NetworkStatusProvider instance;
    private static volatile NetworkUtils.NetworkType networkType;
    private static volatile BroadcastReceiver receiver;
    private static final AtomicInteger sInit = null;
    private Context mContext;

    static {
        networkType = NetworkUtils.NetworkType.MOBILE;
        sInit = new AtomicInteger(0);
    }

    private NetworkStatusProvider(Context r10) {
        this.mContext = r10;
        init();
    }

    static /* synthetic */ NetworkUtils.NetworkType access$000() {
        return networkType;
    }

    static /* synthetic */ NetworkUtils.NetworkType access$002(NetworkUtils.NetworkType r10) {
        networkType = r10;
        return r10;
    }

    static /* synthetic */ Context access$100(NetworkStatusProvider r10) {
        return r10.mContext;
    }

    public static NetworkStatusProvider getInstance(Context r10) {
        if (instance != null) goto L15;
        monitor-enter(NetworkStatusProvider.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new NetworkStatusProvider(r10);     // Catch: Throwable -> L11
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
        IntentFilter r10 = new IntentFilter();
        r10.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        receiver = new AnonymousClass1(this);
        this.mContext.registerReceiver(receiver, r10);
    }

    public static NetworkStatusProvider instance() {
        return instance;
    }

    public NetworkUtils.NetworkType getNetworkType() {
        return networkType;
    }

    public synchronized void stop() {
        monitor-enter(this);
        AtomicInteger r10 = sInit;     // Catch: Throwable -> L15
        if (r10.get() != 1) goto L10;
        if (receiver == null) goto L10;
        this.mContext.unregisterReceiver(receiver);     // Catch: Throwable -> L15
        receiver = null;     // Catch: Throwable -> L15
        r10.decrementAndGet();     // Catch: Throwable -> L15
        String r11 = "NetworkStatusProvider stop monitor";
    L8:
        DrLog.d(r11);     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L10:
        if (r10.get() <= 0) goto L13;
        r10.decrementAndGet();     // Catch: Throwable -> L15
        r11 = "NetworkStatusProvider decrement reference count";
    L15:
        th = move-exception;
        throw th;
    }
}
