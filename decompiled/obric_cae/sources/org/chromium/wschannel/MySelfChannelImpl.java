package org.chromium.wschannel;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.chromium.CronetClient;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MySelfChannelImpl implements IWsChannelClient, WeakHandler.IHandler {
    private static final String CLIENT_KEY_MANAGER_CLASS = "com.bytedance.ttnet.clientkey.ClientKeyManager";
    private static final String TAG = "MySelfChannelImpl";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static String WSCHANNEL_ACTION_BACK;
    private static String WSCHANNEL_ACTION_FORE;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f9803a = 0;
    private static CronetEngine mCronetEngine;
    private static volatile int sChannelID;
    private static volatile AtomicInteger sFirstConnection;
    private static String sPackageName;
    private a mCallback;
    private Context mContext;
    private TTWebsocketConnection mWebsocketConnection;
    private IWsChannelClient mWsChannelClient;
    private boolean sharedConnection;

    public class a extends TTWebsocketConnection.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MySelfChannelImpl f9804a;

        public a(MySelfChannelImpl r8) {
            this.f9804a = r8;
        }

        @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
        public final void onConnectionError(TTWebsocketConnection r8, int r10, String r11, String r12) {
            MySelfChannelImpl r13 = this.f9804a;
            JSONObject r14 = new JSONObject();     // Catch: Throwable -> L5
            r14.put("type", 0);     // Catch: Throwable -> L5
            r14.put("state", MySelfChannelImpl.access$000(r13, r10));     // Catch: Throwable -> L5
            r14.put(WsConstants.KEY_CONNECTION_URL, r11);     // Catch: Throwable -> L5
            r14.put(WsConstants.KEY_CONNECTION_ERROR, r12);     // Catch: Throwable -> L5
            r13.onConnection(r14);     // Catch: Throwable -> L5
            return;
        }

        @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
        public final void onConnectionStateChanged(TTWebsocketConnection r8, int r10, String r11) {
            MySelfChannelImpl r12 = this.f9804a;
            JSONObject r13 = new JSONObject();     // Catch: Throwable -> L5
            r13.put("type", 1);     // Catch: Throwable -> L5
            r13.put("state", MySelfChannelImpl.access$000(r12, r10));     // Catch: Throwable -> L5
            r13.put(WsConstants.KEY_CONNECTION_URL, r11);     // Catch: Throwable -> L5
            r12.onConnection(r13);     // Catch: Throwable -> L5
            return;
        }

        @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
        public final void onMessageReceived(TTWebsocketConnection r8, ByteBuffer r10, int r11) {
            byte[] r12 = new byte[r10.capacity()];
            r10.get(r12);     // Catch: Throwable -> L5
            this.f9804a.onMessage(r12);     // Catch: Throwable -> L5
            return;
        }

        @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Callback
        public final void onTrafficChanged(TTWebsocketConnection r8, String r10, long r11, long r12, boolean r14) {
            if (kf.a.f9124a == null) goto L5;
        L14:
            kf.a.f9124a.a(r10, r11, r12, r14);     // Catch: Throwable -> L16
            return;
        L5:
            monitor-enter(kf.a.class);     // Catch: Throwable -> L16
        L11:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L7:
            if (kf.a.f9124a != null) goto L9;
            kf.a.f9124a = new kf.a();     // Catch: Throwable -> L11
        L9:
            monitor-exit(kf.a.class);     // Catch: Throwable -> L11
        }
    }

    static {
        sFirstConnection = new AtomicInteger(0);
        sChannelID = -1;
    }

    public MySelfChannelImpl() {
        this.mCallback = new a(this);
        this.sharedConnection = true;
    }

    public static /* synthetic */ int access$000(MySelfChannelImpl r8, int r10) {
        return r8.cronetToWsStateAdapter(r10);
    }

    private int cronetToWsStateAdapter(int r8) {
        if (r8 != (-1)) goto L5;
        return 0;
    L5:
        if (r8 == 0) goto L13;
        if (r8 != 1) goto L14;
        return 6;
    L14:
        return r8;
    L13:
        return 1;
    }

    private Map<String, String> getClientKeyHeaders() {
        ClientKeyManager r8 = ClientKeyManager.f4078g;     // Catch: Throwable -> L5
        return (Map) ClientKeyManager.class.getMethod("getClientKeyHeaders", new Class[0]).invoke(null, new Object[0]);
    L5:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static void loadCronetKernel() {
        String r8 = TTNetInit.DOMAIN_HTTPDNS_KEY;
        Object r10 = TTNetInit.class.newInstance();
        Reflect.on(r10).call("getInitCompletedLatch");
        Reflect.on(r10).call("preInitCronetKernel");
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void destroy() {
        TTWebsocketConnection r8 = this.mWebsocketConnection;
        if (r8 == null) goto L6;
        r8.stopConnection();
        this.mWebsocketConnection.destroyConnection();
        return;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r8) {
        Logger.d(TAG, "handleMsg data:" + r8.toString());
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void init(Context r8, IWsChannelClient r10) {
        Logger.d(TAG, "MySelfChannelImpl init");
        if (sFirstConnection.incrementAndGet() <= 1) goto L5;
        this.sharedConnection = false;
    L5:
        this.mContext = r8;
        sPackageName = r8.getPackageName();
        this.mWsChannelClient = r10;
        loadCronetKernel();     // Catch: Throwable -> L8
    L10:
        mCronetEngine = CronetClient.getCronetEngine();
        WSCHANNEL_ACTION_BACK = this.mContext.getPackageName() + ".wschannel.APP_BACKGROUND";
        WSCHANNEL_ACTION_FORE = this.mContext.getPackageName() + ".wschannel.APP_FOREGROUND";
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
        Logger.d(TAG, "TTNet init failed, cronet engine is null.");
        goto L10
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean isConnected() {
        TTWebsocketConnection r8 = this.mWebsocketConnection;
        if (r8 != null) goto L7;
        return false;
    L7:
        return r8.isConnected();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onAppStateChanged(int r8) {
        Intent r10 = new Intent();
        if (r8 != 1) goto L9;
        r10.setAction(WSCHANNEL_ACTION_FORE);
        if (TextUtils.isEmpty(sPackageName) == true) goto L7;
    L6:
        r10.setPackage(sPackageName);
    L7:
        this.mContext.sendBroadcast(r10);
        return;
    L9:
        if (r8 != 2) goto L14;
        r10.setAction(WSCHANNEL_ACTION_BACK);
        if (TextUtils.isEmpty(sPackageName) == true) goto L7;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onConnection(JSONObject r8) {
        if (this.mWsChannelClient == null) goto L12;
        r8.put(WsConstants.KEY_CHANNEL_TYPE, 1);     // Catch: JSONException -> L6
    L8:
        this.mWsChannelClient.onConnection(r8);
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(byte[] r8) {
        IWsChannelClient r10 = this.mWsChannelClient;
        if (r10 == null) goto L6;
        r10.onMessage(r8);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onNetworkStateChanged(int r8) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onParameterChange(Map<String, Object> r8, List<String> r10) {
        TTWebsocketConnection r11 = this.mWebsocketConnection;
        if (r11 == null) goto L5;
        r11.stopConnection();
        this.mWebsocketConnection.destroyConnection();
    L5:
        openConnection(r8, r10);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void openConnection(Map<String, Object> r11, List<String> r12) {
        if (r12 == null) goto L64;
        if (r12.size() <= 0) goto L64;
        Logger.d(TAG, "openConnection url:" + r12.get(0));
        if (r11 == null) goto L62;
        if (r11.isEmpty() == true) goto L62;
        Object r8 = r11.get(WsConstants.KEY_CHANNEL_ID);
        if (r8 != null) goto L13;
        int r10 = -1;
    L15:
        if (sChannelID != (-1)) goto L20;
        if (r10 <= 0) goto L20;
        if (sFirstConnection.get() != 1) goto L20;
        sChannelID = r10;
    L20:
        TTWebsocketConnection.Builder r13 = mCronetEngine.newWebsocketConnectionBuilder(this.mCallback, Executors.newSingleThreadExecutor());
        r13.setUrlList(r12);     // Catch: Throwable -> L58
        r13.setAppKey(String.valueOf(r11.get(WsConstants.KEY_APP_KEY)));     // Catch: Throwable -> L58
        r13.setFpid(((Integer) r11.get(WsConstants.KEY_FPID)).intValue());     // Catch: Throwable -> L58
        r13.setAppVersion(((Integer) r11.get("app_version")).intValue());     // Catch: Throwable -> L58
        r13.setAppId(((Integer) r11.get(WsConstants.KEY_APP_ID)).intValue());     // Catch: Throwable -> L58
        r13.setDeviceId(Long.parseLong((String) r11.get("device_id")));     // Catch: Throwable -> L58
        r13.setInstallId(Long.parseLong((String) r11.get(WsConstants.KEY_INSTALL_ID)));     // Catch: Throwable -> L58
        if (r10 > 0) goto L24;
    L26:
        r13.setSharedConnection(this.sharedConnection);     // Catch: Throwable -> L58
        if (r11.containsKey(WsConstants.KEY_SESSION_ID) == false) goto L29;
        r13.setSessionId((String) r11.get(WsConstants.KEY_SESSION_ID));     // Catch: Throwable -> L58
    L29:
        String r14 = (String) r11.get(WsConstants.KEY_EXTRA);     // Catch: Throwable -> L58
        HashMap r15 = new HashMap();     // Catch: Throwable -> L58
        if (TextUtils.isEmpty(r14) == true) goto L39;
        String[] r16 = r14.split("&");     // Catch: Throwable -> L58
        int r17 = r16.length;     // Catch: Throwable -> L58
        int r18 = 0;
    L32:
        if (r18 >= r17) goto L39;
        String r19 = r16[r18];     // Catch: Throwable -> L58
        if (TextUtils.isEmpty(r19) == true) goto L38;
        String[] r20 = r19.split("=");     // Catch: Throwable -> L58
        if (r20.length != 2) goto L38;
        r15.put(r20[0], r20[1]);     // Catch: Throwable -> L58
    L38:
        r18 = r18 + 1;     // Catch: Throwable -> L58
    L39:
        r13.setCustomizedParams(r15);     // Catch: Throwable -> L58
        HashMap r110 = new HashMap();     // Catch: Throwable -> L54
        Map<String, String> r21 = getClientKeyHeaders();     // Catch: Throwable -> L54
        Logger.d(TAG, "Client key: " + r21);     // Catch: Throwable -> L54
        if (r21 != null) goto L43;
    L45:
        Map r111 = (Map) r11.get("custom_headers");     // Catch: Throwable -> L54
        if (r111 == null) goto L51;
        if (r111.isEmpty() == true) goto L51;
        r110.putAll(r111);     // Catch: Throwable -> L54
    L51:
        if (r110.isEmpty() == true) goto L56;
        r13.setCustomizedHeaders(r110);     // Catch: Throwable -> L54
    L56:
        TTWebsocketConnection r112 = r13.build();
        this.mWebsocketConnection = r112;
        r112.startConnection();
        return;
    L43:
        if (r21.isEmpty() == true) goto L45;
        r110.putAll(r21);     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L58
        goto L56
    L24:
        if (r10 != sChannelID) goto L26;
        this.sharedConnection = true;     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        th.printStackTrace();
        throw new IllegalArgumentException("configMap contain err params !!!");
    L13:
        r10 = ((Integer) r8).intValue();
    L62:
        throw new IllegalArgumentException("configMap is empty !!!");
    L64:
        throw new IllegalArgumentException("urls size <= 0 !!!");
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(byte[] r8) {
        Logger.d(TAG, "sendMessage data:" + r8);
        if (this.mWebsocketConnection != null) goto L6;
        return false;
    L6:
        ByteBuffer r10 = ByteBuffer.allocateDirect(r8.length);
        r10.put(r8);
        this.mWebsocketConnection.asyncSendBinary(r10);
        return true;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void stopConnection() {
        TTWebsocketConnection r8 = this.mWebsocketConnection;
        if (r8 == null) goto L6;
        r8.stopConnection();
        this.mWebsocketConnection.destroyConnection();
        return;
    }
}
