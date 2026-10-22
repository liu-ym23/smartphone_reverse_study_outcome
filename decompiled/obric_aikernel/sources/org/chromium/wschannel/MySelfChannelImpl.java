package org.chromium.wschannel;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.ttnet.org.chromium.net.impl.UserAgent;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class MySelfChannelImpl implements IWsChannelClient, WeakHandler.IHandler {
    private static final String TAG = "MySelfChannelImpl";
    private static String WSCHANNEL_ACTION_BACK;
    private static String WSCHANNEL_ACTION_FORE;
    private static String sPackageName;
    private static volatile String sUserAgent;
    private Context mContext;
    private CronetFrontierConnection mFrontierConnection;
    private IWsChannelClient mWsChannelClient;

    public MySelfChannelImpl() {
    }

    public static String getDefaultUserAgent() {
        return sUserAgent;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void destroy() {
        CronetFrontierConnection r10 = this.mFrontierConnection;
        if (r10 == null) goto L6;
        r10.destroyConnection();
        return;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r10) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "handleMsg data:" + r10.toString());
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void init(Context r10, IWsChannelClient r11) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "MySelfChannelImpl init");
    L5:
        this.mContext = r10;
        sPackageName = r10.getPackageName();
        this.mWsChannelClient = r11;
        this.mFrontierConnection = new CronetFrontierConnection(this);
        if (TextUtils.isEmpty(sUserAgent) == true) goto L11;
    L8:
        WSCHANNEL_ACTION_BACK = this.mContext.getPackageName() + ".wschannel.APP_BACKGROUND";
        WSCHANNEL_ACTION_FORE = this.mContext.getPackageName() + ".wschannel.APP_FOREGROUND";
        return;
    L11:
        sUserAgent = UserAgent.from(r10);     // Catch: Throwable -> L10
        goto L8
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean isConnected() {
        CronetFrontierConnection r10 = this.mFrontierConnection;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.isConnected();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onAppStateChanged(int r10) {
        Intent r11 = new Intent();
        if (r10 != 1) goto L9;
        r11.setAction(WSCHANNEL_ACTION_FORE);
        if (TextUtils.isEmpty(sPackageName) == true) goto L7;
    L6:
        r11.setPackage(sPackageName);
    L7:
        this.mContext.sendBroadcast(r11);
        return;
    L9:
        if (r10 != 2) goto L14;
        r11.setAction(WSCHANNEL_ACTION_BACK);
        if (TextUtils.isEmpty(sPackageName) == true) goto L7;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onConnection(JSONObject r10) {
        if (this.mWsChannelClient == null) goto L12;
        r10.put(WsConstants.KEY_CHANNEL_TYPE, 1);     // Catch: JSONException -> L6
    L8:
        this.mWsChannelClient.onConnection(r10);
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(WsChannelMsg r10) {
        IWsChannelClient r11 = this.mWsChannelClient;
        if (r11 == null) goto L6;
        r11.onMessage(r10);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(byte[] r10) {
        IWsChannelClient r11 = this.mWsChannelClient;
        if (r11 == null) goto L6;
        r11.onMessage(r10);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onNetworkStateChanged(int r10) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onParameterChange(Map<String, Object> r10, List<String> r11) {
        CronetFrontierConnection r12 = this.mFrontierConnection;
        if (r12 == null) goto L5;
        r12.stopConnection();
    L5:
        openConnection(r10, r11);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onServiceConnectEvent(int r10, boolean r11, String r12) {
        IWsChannelClient r13 = this.mWsChannelClient;
        if (r13 == null) goto L6;
        r13.onServiceConnectEvent(r10, r11, r12);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void openConnection(Map<String, Object> r10, List<String> r11) {
        CronetFrontierConnection r12 = this.mFrontierConnection;
        if (r12 == null) goto L6;
        r12.startConnection(r10, r11);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolEnabled() {
        CronetFrontierConnection r10 = this.mFrontierConnection;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.privateProtocolEnabled();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolProxyEnabled() {
        CronetFrontierConnection r10 = this.mFrontierConnection;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.privateProtocolProxyEnabled();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void registerService(int r10) {
        CronetFrontierConnection r11 = this.mFrontierConnection;
        if (r11 == null) goto L6;
        r11.registerService(r10);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(WsChannelMsg r10) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "PP data:" + r10.toString());
    L5:
        CronetFrontierConnection r11 = this.mFrontierConnection;
        if (r11 != null) goto L10;
        return false;
    L10:
        return r11.sendMessageWithPrivateProtocol(r10);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(byte[] r10) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "WS sendMessage data:" + r10.toString());
    L5:
        CronetFrontierConnection r11 = this.mFrontierConnection;
        if (r11 != null) goto L10;
        return false;
    L10:
        if (r11.privateProtocolEnabled() == false) goto L16;
        if (this.mFrontierConnection.privateProtocolProxyEnabled() == false) goto L16;
        return this.mFrontierConnection.sendMessageWithPrivateProtocolProxy(r10);
    L16:
        return this.mFrontierConnection.sendMessageWithWebSocket(r10);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void stopConnection() {
        CronetFrontierConnection r10 = this.mFrontierConnection;
        if (r10 == null) goto L6;
        r10.stopConnection();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void unregisterService(int r10) {
        CronetFrontierConnection r11 = this.mFrontierConnection;
        if (r11 == null) goto L6;
        r11.unregisterService(r10);
        return;
    }
}
