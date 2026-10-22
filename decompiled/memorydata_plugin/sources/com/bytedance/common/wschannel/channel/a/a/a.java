package com.bytedance.common.wschannel.channel.a.a;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.j;
import com.bytedance.common.wschannel.l;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements WeakHandler.IHandler, IWsChannelClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f2022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2023b;
    private Context c;
    private Handler d;
    private c e;
    private boolean f;
    private Map<String, Object> g;
    private List<String> h;
    private ContentObserver i;

    static {
    }

    public a(int r2, Handler r3) {
        this.g = new HashMap();
        this.f2023b = r2;
        this.d = r3;
        final Handler r4 = this.d;
        this.i = new AnonymousClass1(this, r4);
    }

    static /* synthetic */ Context a(a r0) {
        return r0.c;
    }

    private void a() {
        Context r0 = this.c;     // Catch: Throwable -> L6
        if (r0 == null) goto L11;
        ZeusProviderTransform.unregisterContentObserver(r0.getContentResolver(), this.i, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    private boolean a(Context r2) {
        return l.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).e();
    }

    static /* synthetic */ boolean a(a r2, Context r3) {
        return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ Map b(a r0) {
        return r0.g;
    }

    private void b(Context r11) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        long r1 = System.currentTimeMillis();
        Class r0 = ZeusTransformUtils.forName("com.bytedance.mobsec.metasec.ov.MSB", "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L5
    L6:
        if (r0 != null) goto L16;
        return;
    L16:
        r0.getMethod("a", new Class[]{Context.class, Integer.TYPE, Map.class}).invoke(r0, new Object[]{r10, 2, null});     // Catch: Throwable -> L10
    L12:
        f2022a = System.currentTimeMillis() - r1;
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    L5:
        Log.d("WsChannelSdk_ok", "MSSdk Class -com.bytedance.mobsec.metasec.ov.MSB- not found, init fail.");
        f2022a = -1;
        r0 = null;
        goto L6
    }

    static /* synthetic */ List c(a r0) {
        return r0.h;
    }

    private void c(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        ZeusProviderTransform.registerContentObserver(r6.getContentResolver(), WsChannelMultiProcessSharedProvider.a(r6, WsConstants.KEY_OK_IMPL_ENABLE, TypedValues.Custom.S_BOOLEAN), true, this.i, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void destroy() {
        Log.d("WsChannelSdk_ok", "destroy() , channelId = " + this.f2023b);
        this.e.d();
        a();
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r1) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void init(Context r5, IWsChannelClient r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        IWsChannelClient r8 = (IWsChannelClient) ZeusTransformUtils.wrapperContextForParams(r6, IWsChannelClient.class, "com.obric.memorydata.plugin");
        if (this.f == false) goto L5;
        return;
    L5:
        this.f = true;
        Log.d("WsChannelSdk_ok", "init() , channelId = " + this.f2023b);
        this.c = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        b(r7);
        c r0 = new c.a(r7).a(new com.bytedance.common.wschannel.channel.a.a.a.c(r7)).a(j.a(this.f2023b)).a();
        this.e = r0;
        r0.a(new e(this.c, this.e, r8));
        c(r7);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean isConnected() {
        return this.e.c();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onAppStateChanged(int r3) {
        if (a(this.c) == true) goto L5;
        return;
    L5:
        Log.d("WsChannelSdk_ok", "onAppStateChanged(), channelId = " + this.f2023b);
        c r2 = this.e;
        boolean r0 = true;
        if (r3 == 1) goto L9;
        r0 = false;
    L9:
        r2.a(r0);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onConnection(JSONObject r1) {
        Log.d("WsChannelSdk_ok", "onConnection()");
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(WsChannelMsg r1) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(byte[] r2) {
        Log.d("WsChannelSdk_ok", "onMessage(),channel = " + this.f2023b);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onNetworkStateChanged(int r3) {
        if (a(this.c) == true) goto L5;
        return;
    L5:
        Log.d("WsChannelSdk_ok", "onNetworkStateChanged(), channelId = " + this.f2023b);
        this.e.a(r3);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onParameterChange(Map<String, Object> r3, List<String> r4) {
        Map<String, Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L5;
        this.g.putAll(r5);
    L5:
        this.h = r6;
        if (a(this.c) == true) goto L8;
        return;
    L8:
        Log.d("WsChannelSdk_ok", "onParameterChange(),channelId = " + this.f2023b);
        this.e.b(r5, r6);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onServiceConnectEvent(int r1, boolean r2, String r3) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void openConnection(Map<String, Object> r3, List<String> r4) {
        Map<String, Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L5;
        this.g.putAll(r5);
    L5:
        this.h = r6;
        if (a(this.c) == true) goto L8;
        return;
    L8:
        this.e.a(r5, r6);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolEnabled() {
        return false;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolProxyEnabled() {
        return false;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void registerService(int r1) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(WsChannelMsg r1) {
        return false;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(byte[] r3) {
        if (a(this.c) == true) goto L6;
        return false;
    L6:
        Log.d("WsChannelSdk_ok", "sendMessage(),channelId = " + this.f2023b);
        return this.e.a(r3);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void stopConnection() {
        Log.d("WsChannelSdk_ok", "stopConnection(),channelId = " + this.f2023b);
        this.e.a();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void unregisterService(int r1) {
    }
}
