package com.bytedance.frameworks.baselib.network.http.cronet.websocket;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface IWsClient {
    boolean isConnected();

    void onParameterChange(Map<String, String> r10, Map<String, String> r11, List<String> r12, boolean r13, boolean r14);

    void openConnection(Map<String, String> r10, Map<String, String> r11, List<String> r12, boolean r13, boolean r14);

    boolean sendMessage(byte[] r10, int r11);

    void stopConnection();
}
