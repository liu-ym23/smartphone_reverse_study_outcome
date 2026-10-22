package com.bytedance.common.wschannel.channel;

import android.content.Context;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IWsChannelClient {
    void destroy();

    void init(Context r8, IWsChannelClient r10);

    boolean isConnected();

    void onAppStateChanged(int r8);

    void onConnection(JSONObject r8);

    void onMessage(byte[] r8);

    void onNetworkStateChanged(int r8);

    void onParameterChange(Map<String, Object> r8, List<String> r10);

    void openConnection(Map<String, Object> r8, List<String> r10);

    boolean sendMessage(byte[] r8);

    void stopConnection();
}
