package com.bytedance.common.wschannel.channel;

import android.content.Context;
import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.h;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements IWsChannelClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2081a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2082b;
    private final Handler c;
    private List<String> d;
    private boolean e;
    private IWsChannelClient f;
    private a g;

    static {
    }

    private b(int r4, a r5, Handler r6) {
        a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin");
        this.e = true;
        this.f2082b = r4;
        this.g = r7;
        this.c = r6;
        b();     // Catch: Throwable -> L9 ClassNotFoundException -> L11
        if (this.e == false) goto L7;
        String r8 = "use cronet to connect";
    L6:
        Logger.d("WsChannelClient", r8);     // Catch: Throwable -> L9 ClassNotFoundException -> L11
    L14:
        if (this.f != null) goto L19;
        Logger.d("WsChannelClient", "use okhttp to connect");
        this.f = new com.bytedance.common.wschannel.channel.a.a.a(r4, r6);
        return;
    L19:
        return;
    L7:
        r8 = "use PushManager to connect";
    L11:
        String r9 = "don't find plugin or plugin download failed";
    L12:
        Logger.d("WsChannelClient", r9);
    L9:
        th = move-exception;
        th.printStackTrace();
        r9 = "don't find plugin";
        goto L12
    }

    public static b a(int r2, a r3, Handler r4) {
        return new b(r2, (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin"), r4);
    }

    private Class<?> a(String r1) {
        return ZeusTransformUtils.forName(r1, "com.obric.memorydata.plugin");
    L4:
        return null;
    }

    private void a(JSONObject r3) {
        a r0 = this.g;
        if (r0 == null) goto L6;
        r0.a(this, this.f2082b, r3);
        return;
    }

    private void b() {
        if (this.f != null) goto L17;
        Class<?> r0 = null;
        if (h.a(f2081a) == true) goto L7;
        r0 = a(f2081a);
    L7:
        if (r0 != null) goto L9;
        r0 = a("org.chromium.wschannel.MySelfChannelImpl");
        this.e = true;
    L9:
        if (r0 != null) goto L11;
        r0 = a("com.b.c.ws.MySelfChannelImpl");
        this.e = false;
    L11:
        if (r0 == null) goto L16;
        Object r1 = r0.newInstance();
        if (ZeusTransformUtils.instanceOf(r1, IWsChannelClient.class) == false) goto L18;
        this.f = (IWsChannelClient) ZeusTransformUtils.preCheckCast(r1, IWsChannelClient.class, "com.obric.memorydata.plugin");
        return;
    L18:
        return;
    L16:
        throw new ClassNotFoundException("plugin class not found");
    }

    public boolean a() {
        return ZeusTransformUtils.instanceOf(this.f, com.bytedance.common.wschannel.channel.a.a.a.class);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void destroy() {
        monitor-enter(this);
        IWsChannelClient r0 = this.f;     // Catch: Throwable -> L19
        if (r0 == null) goto L17;
        r0.destroy();     // Catch: Throwable -> L19
        if (ZeusTransformUtils.instanceOf(this.f, com.bytedance.common.wschannel.channel.a.a.a.class) == true) goto L17;
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L19
        List<String> r2 = this.d;     // Catch: Throwable -> L19
        if (r2 != null) goto L10;
    L12:
        String r3 = "";
    L24:
        r1.put("type", 0);     // Catch: Exception -> L15 Throwable -> L19
        r1.put("state", 3);     // Catch: Exception -> L15 Throwable -> L19
        r1.put("url", r3);     // Catch: Exception -> L15 Throwable -> L19
        r1.put(WsConstants.KEY_CHANNEL_TYPE, 1);     // Catch: Exception -> L15 Throwable -> L19
        a(r1);     // Catch: Exception -> L15 Throwable -> L19
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L19
        goto L17
    L10:
        if (r2.size() < 1) goto L12;
        r3 = (String) ZeusTransformUtils.preCheckCast(this.d.get(0), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void init(Context r4, IWsChannelClient r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        IWsChannelClient r7 = (IWsChannelClient) ZeusTransformUtils.wrapperContextForParams(r5, IWsChannelClient.class, "com.obric.memorydata.plugin");
        IWsChannelClient r0 = this.f;
        if (r0 != null) goto L12;
        return;
    L12:
        r0.init(r6, r7);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        if (ZeusTransformUtils.instanceOf(this.f, com.bytedance.common.wschannel.channel.a.a.a.class) == true) goto L10;
        th.printStackTrace();
        Logger.d("WsChannelClient", "cronet socket init failed，use okhttp to connect");
        com.bytedance.common.wschannel.channel.a.a.a r1 = new com.bytedance.common.wschannel.channel.a.a.a(this.f2082b, this.c);
        this.f = r1;
        r1.init(r6, r7);
        return;
    L10:
        throw th;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean isConnected() {
        IWsChannelClient r0 = this.f;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isConnected();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onAppStateChanged(int r1) {
        IWsChannelClient r0 = this.f;
        if (r0 == null) goto L6;
        r0.onAppStateChanged(r1);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onConnection(JSONObject r1) {
        monitor-enter(this);
        a(r1);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(WsChannelMsg r2) {
        a r0 = this.g;
        if (r0 == null) goto L6;
        r0.a(this.f2082b, r2);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(byte[] r2) {
        a r0 = this.g;
        if (r0 == null) goto L6;
        r0.a(this.f2082b, r2);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onNetworkStateChanged(int r1) {
        IWsChannelClient r0 = this.f;
        if (r0 == null) goto L6;
        r0.onNetworkStateChanged(r1);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onParameterChange(Map<String, Object> r3, List<String> r4) {
        Map<String, Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        IWsChannelClient r0 = this.f;
        if (r0 == null) goto L5;
        r0.onParameterChange(r5, r6);
    L5:
        this.d = r6;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onServiceConnectEvent(int r3, boolean r4, String r5) {
        a r0 = this.g;
        if (r0 == null) goto L6;
        r0.a(new ServiceConnectEvent(this.f2082b, r3, r4, r5));
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void openConnection(Map<String, Object> r3, List<String> r4) {
        Map<String, Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        IWsChannelClient r0 = this.f;
        if (r0 == null) goto L5;
        r0.openConnection(r5, r6);
    L5:
        this.d = r6;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolEnabled() {
        IWsChannelClient r0 = this.f;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.privateProtocolEnabled();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolProxyEnabled() {
        IWsChannelClient r0 = this.f;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.privateProtocolProxyEnabled();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void registerService(int r1) {
        IWsChannelClient r0 = this.f;
        if (r0 == null) goto L6;
        r0.registerService(r1);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(WsChannelMsg r1) {
        IWsChannelClient r0 = this.f;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.sendMessage(r1);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(byte[] r1) {
        IWsChannelClient r0 = this.f;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.sendMessage(r1);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void stopConnection() {
        IWsChannelClient r0 = this.f;
        if (r0 == null) goto L6;
        r0.stopConnection();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void unregisterService(int r1) {
        IWsChannelClient r0 = this.f;
        if (r0 == null) goto L6;
        r0.unregisterService(r1);
        return;
    }
}
