package com.bytedance.common.wschannel.channel;

import android.content.Context;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IWsChannelClient {
    void destroy();

    void init(Context r10, IWsChannelClient r11);

    boolean isConnected();

    void onAppStateChanged(int r10);

    void onConnection(JSONObject r10);

    void onMessage(WsChannelMsg r10);

    void onMessage(byte[] r10);

    void onNetworkStateChanged(int r10);

    void onParameterChange(Map<String, Object> r10, List<String> r11);

    void onServiceConnectEvent(int r10, boolean r11, String r12);

    void openConnection(Map<String, Object> r10, List<String> r11);

    boolean privateProtocolEnabled();

    boolean privateProtocolProxyEnabled();

    void registerService(int r10);

    boolean sendMessage(WsChannelMsg r10);

    boolean sendMessage(byte[] r10);

    void stopConnection();

    void unregisterService(int r10);
}
