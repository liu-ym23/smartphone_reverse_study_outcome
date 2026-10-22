package com.bytedance.frameworks.baselib.network.http.cronet.websocket;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface IWsClient {
    boolean isConnected();

    void onParameterChange(Map<String, String> r8, Map<String, String> r10, List<String> r11, boolean r12, boolean r13);

    void openConnection(Map<String, String> r8, Map<String, String> r10, List<String> r11, boolean r12, boolean r13);

    boolean sendMessage(byte[] r8, int r10);

    void stopConnection();
}
