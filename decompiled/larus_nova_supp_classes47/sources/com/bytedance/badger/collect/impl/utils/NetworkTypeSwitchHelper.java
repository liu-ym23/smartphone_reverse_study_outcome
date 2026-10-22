package com.bytedance.badger.collect.impl.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.monitor.MonitorManager;
import com.bytedance.badger.collect.impl.network.interfaces.INetworkTypeSwitchCallback;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class NetworkTypeSwitchHelper {
    static Network mOriginalNetwork;

    public NetworkTypeSwitchHelper() {
    }

    public static /* synthetic */ void access$000(boolean r0, String r1) {
        onWifiMobileEvent(r0, r1);
    }

    private static void bindProcessToNetwork(ConnectivityManager r2, Network r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (Build.VERSION.SDK_INT < 23) goto L6;
        r2.bindProcessToNetwork(r3);
        return;
    L6:
        ConnectivityManager.setProcessDefaultNetwork(r3);
    }

    private static void onLock(CountDownLatch r5, long r6) {
        long r1 = System.currentTimeMillis();     // Catch: InterruptedException -> L8
        KLog.i(Constants.TAGS.NETWORK_SWITCH, ThreadMethodProxy.currentThread().getName() + " 开始阻塞，最大等待时间= " + r6);     // Catch: InterruptedException -> L8
        if (r5.await(r6, TimeUnit.SECONDS) == true) goto L6;
        KLog.e(Constants.TAGS.NETWORK_SWITCH, ThreadMethodProxy.currentThread().getName() + " 等待超时");     // Catch: InterruptedException -> L8
    L10:
        return;
    L6:
        KLog.i(Constants.TAGS.NETWORK_SWITCH, ThreadMethodProxy.currentThread().getName() + " 已经被唤醒，耗时=" + (System.currentTimeMillis() - r1) + " ms");     // Catch: InterruptedException -> L8
    L8:
        ThreadMethodProxy.currentThread().interrupt();
        KLog.e(Constants.TAGS.NETWORK_SWITCH, ThreadMethodProxy.currentThread().getName() + " latch等待被中断");
    }

    private static void onWifiMobileEvent(boolean r1, String r2) {
        MonitorManager.getInstance().getMobileWifiSwitchMonitor().setCellularToWifiResult(r1);
        MonitorManager.getInstance().getMobileWifiSwitchMonitor().setReleaseCellularTime();
        MonitorManager.getInstance().getMobileWifiSwitchMonitor().setErrorMsg(r2);
        MonitorManager.getInstance().getMobileWifiSwitchMonitor().report();
    }

    public static void wifiSwitchCellAndRequest(Context r3, final INetworkTypeSwitchCallback r4) {
        if (r3 == null) goto L14;
        if (r4 == null) goto L14;
        final ConnectivityManager r5 = (ConnectivityManager) r3.getSystemService("connectivity");
        if (r5 != null) goto L9;
        r4.onError(new RuntimeException("not support force switch"));
        return;
    L9:
        if (Build.VERSION.SDK_INT < 23) goto L11;
        mOriginalNetwork = r5.getBoundNetworkForProcess();
        KLog.i(Constants.TAGS.NETWORK_SWITCH, "原始网络状态 " + mOriginalNetwork);
    L11:
        KLog.i(Constants.TAGS.NETWORK_SWITCH, "------开始强切------");
        MonitorManager.getInstance().getMobileWifiSwitchMonitor().setStartTime();
        r5.requestNetwork(new NetworkRequest.Builder().addTransportType(0).addCapability(12).build(), new AnonymousClass1(r4, r5));
        return;
    L14:
        KLog.e(Constants.TAGS.NETWORK_SWITCH, "网络类型切换失败，context或callback为空");
    }
}
