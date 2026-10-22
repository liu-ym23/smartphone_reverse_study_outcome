package com.bytedance.common.wschannel.channel;

import android.content.Context;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface IWsChannelClient {
    void destroy();

    void init(Context r5, IWsChannelClient r10);

    boolean isConnected();

    void onAppStateChanged(int r5);

    void onConnection(JSONObject r5);

    void onMessage(byte[] r5);

    void onNetworkStateChanged(int r5);

    void onParameterChange(Map<String, Object> r5, List<String> r10);

    void openConnection(Map<String, Object> r5, List<String> r10);

    boolean sendMessage(byte[] r5);

    void stopConnection();
}
