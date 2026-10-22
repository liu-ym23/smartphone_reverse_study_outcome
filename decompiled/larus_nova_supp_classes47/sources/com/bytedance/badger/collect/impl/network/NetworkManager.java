package com.bytedance.badger.collect.impl.network;

import android.net.Network;
import com.bytedance.badger.collect.impl.constants.NetworkMethodEnum;
import com.bytedance.badger.collect.impl.model.TTResponse;
import com.bytedance.badger.collect.impl.monitor.MonitorManager;
import com.bytedance.badger.collect.impl.network.impl.NetworkServiceImpl;
import com.bytedance.badger.collect.impl.network.interfaces.INetWorkService;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class NetworkManager {
    private static volatile NetworkManager instance;
    private final INetWorkService netWorkService;

    public static NetworkManager getInstance() {
        if (instance != null) goto L15;
        monitor-enter(NetworkManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new NetworkManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(NetworkManager.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private NetworkManager() {
        this.netWorkService = new NetworkServiceImpl();
    }

    public TTResponse fetchMobilePseudoCodeSign(String r2, Map<String, String> r3, NetworkMethodEnum r4, Map<String, String> r5) throws Exception {
        return this.netWorkService.fetchMobilePseudoCodeSign(r2, r3, r4, r5);
    }

    public TTResponse fetchMobilePseudoCodeToken(Network r8, String r9, Map<String, String> r10, NetworkMethodEnum r12, Map<String, String> r13) throws Exception {
        MonitorManager.getInstance().getMobileGetTokenMonitor().setStartRequestTime();
        TTResponse r14 = this.netWorkService.fetchMobilePseudoCodeToken(r8, r9, r10, r12, r13);
        MonitorManager.getInstance().getMobileGetTokenMonitor().setFinishRequestTime();
        return r14;
    }
}
